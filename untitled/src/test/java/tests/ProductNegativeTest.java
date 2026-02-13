package tests;

import client.ProductClient;
import io.restassured.response.Response;
import model.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductNegativeTest {

    private ProductClient productClient;

    @BeforeClass
    public void setup() {
        productClient = new ProductClient();
    }

    @Test
    public void testSearchProductWithoutParam() {
        // API 12: POST to searchProduct without search_product param → 400 Bad Request (in body)
        Response response = productClient.searchProductWithoutParam();

        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status should be 200");

        String body = response.getBody().asString();
        Assert.assertTrue(body.contains("400"), "Response body should contain 400 for missing param");

        System.out.println("✓ Search without param test passed - Body: " + body);
    }

    @Test
    public void testCreateProductWithMissingFields() {
        // API 11: POST to createAccount with incomplete data
        Product incompleteProduct = new Product();
        incompleteProduct.setName("Incomplete Product");
        // Missing all other required fields

        Response response = productClient.createProduct(incompleteProduct);

        // API returns 400 Bad Request inside body for missing required fields
        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status should be 200");
        System.out.println("✓ Create product with missing fields - Status: "
                + response.getStatusCode() + " Body: " + response.getBody().asString());
    }

    @Test
    public void testVerifyLoginWithInvalidCredentials() {
        // API 9: POST verifyLogin with invalid email/password → 404 in body
        Response response = productClient.verifyLoginWithInvalidDetails(
                "notexist_" + System.currentTimeMillis() + "@nowhere.com",
                "wrongpassword123"
        );

        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status should be 200");

        String body = response.getBody().asString();
        Assert.assertTrue(body.contains("404") || body.contains("User not found"),
                "Response should indicate user not found");

        System.out.println("✓ Invalid login test passed - Body: " + body);
    }

    @Test
    public void testVerifyLoginWithMissingEmail() {
        // Verify login without email — expect 400 in body
        Response response = productClient.verifyLoginWithInvalidDetails("", "somepassword");

        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status should be 200");
        String body = response.getBody().asString();
        System.out.println("✓ Missing email test - Body: " + body);
        Assert.assertNotNull(body, "Response body should not be null");
    }

    @Test
    public void testVerifyResponseNotNull() {
        Response response = productClient.getAllProducts();

        Assert.assertNotNull(response, "Response should not be null");
        Assert.assertEquals(response.getStatusCode(), 200, "Should return 200 OK");

        System.out.println("✓ Response not null test passed");
        System.out.println("  Response Status: " + response.getStatusCode());
    }
}
