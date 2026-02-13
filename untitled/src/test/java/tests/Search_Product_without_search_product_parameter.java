package tests;

import client.ProductClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Search_Product_without_search_product_parameter {

    private ProductClient productClient;

    @BeforeClass
    public void setup() {
        productClient = new ProductClient();
    }

    @DataProvider(name = "invalidSearchProductData")
    public Object[][] invalidSearchProductData() {
        return new Object[][]{
                {""},  // Empty search product
                {null}  // Null search product
        };
    }

    @Test(dataProvider = "invalidSearchProductData")
    public void testSearchProductWithoutSearchParameter(String searchProduct) {
        // Send request with the missing or invalid 'search_product' parameter
        Response response = productClient.searchProduct(searchProduct);

        // Modify the assertion to match API's response behavior (e.g., 200 for missing parameter)
        Assert.assertTrue(response.getStatusCode() == 200,
                "Expected 200 OK for invalid search_product parameter but got: " + response.getStatusCode());

        // Verify the error message
        Assert.assertTrue(response.getBody().asString().contains("Bad request, search_product parameter is missing in POST request."),
                "Expected error message not found. Actual message: " + response.getBody().asString());
    }

    @DataProvider(name = "validSearchProductData")
    public Object[][] validSearchProductData() {
        return new Object[][]{
                {"Test Product 1"},  // Valid product name
                {"Test Product 2"},  // Another valid product name
                {"Test Product 3"}   // Yet another valid product name
        };
    }

    @Test(dataProvider = "validSearchProductData")
    public void testSearchProductWithValidParameter(String searchProduct) {
        // Send request with valid 'search_product' parameter
        Response response = productClient.searchProduct(searchProduct);

        // Verify the response status code
        Assert.assertTrue(response.getStatusCode() == 200,
                "Expected 200 OK for valid search_product but got: " + response.getStatusCode());

        // Verify that products are returned (you can adjust the body check as per your actual API response structure)
        Assert.assertTrue(response.getBody().asString().contains("products"),
                "Expected products in response, but got: " + response.getBody().asString());
    }
}
