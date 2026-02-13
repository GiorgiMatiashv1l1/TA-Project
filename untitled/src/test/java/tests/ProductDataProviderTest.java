package tests;

import client.ProductClient;
import io.restassured.response.Response;
import model.ProductsResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductDataProviderTest {

    private ProductClient productClient;

    @BeforeClass
    public void setup() {
        productClient = new ProductClient();
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTerms() {
        return new Object[][]{
                {"top"},
                {"dress"},
                {"tshirt"},
                {"jeans"}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"invalid1@test.com", "wrongpass1"},
                {"invalid2@test.com", "wrongpass2"},
                {"notanemail",        "anypassword"}
        };
    }

    @Test(dataProvider = "searchTerms", priority = 1)
    public void testSearchProductWithMultipleTerms(String searchTerm) {
        Response response = productClient.searchProduct(searchTerm);

        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200 for search term: " + searchTerm);

        ProductsResponse productsResponse = response.as(ProductsResponse.class);
        Assert.assertEquals(productsResponse.getResponseCode(), 200,
                "API response code should be 200 for search term: " + searchTerm);

        System.out.println("Search '" + searchTerm + "' returned "
                + productsResponse.getProducts().size() + " results");
    }

    @Test(dataProvider = "invalidCredentials", priority = 2)
    public void testVerifyLoginWithInvalidCredentials(String email, String password) {
        Response response = productClient.verifyLoginWithInvalidDetails(email, password);

        Assert.assertEquals(response.getStatusCode(), 200,
                "HTTP status should be 200 for email: " + email);

        String body = response.getBody().asString();
        Assert.assertTrue(body.contains("404") || body.contains("User not found")
                        || body.contains("400"),
                "Should return error for invalid credentials: " + email);

        System.out.println("✓ Invalid login '" + email + "' correctly rejected");
    }
}
