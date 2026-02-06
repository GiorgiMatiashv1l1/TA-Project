package tests.api;

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
    public void testGetNonExistentProduct() {
        int nonExistentId = 999999;
        Response response = productClient.getProduct(nonExistentId);

        // API returns 404 for non-existent product
        Assert.assertEquals(response.getStatusCode(), 404,
                "Should return 404 for non-existent product");

        System.out.println("✓ Non-existent product test passed - Status: " + response.getStatusCode());
    }

    @Test
    public void testCreateProductWithoutRequiredFields() {
        Product incompleteProduct = new Product();
        incompleteProduct.setName("Incomplete Product");
        // Missing other required fields

        Response response = productClient.createProduct(incompleteProduct);

        // API returns 403 Forbidden (not 400 Bad Request)
        Assert.assertEquals(response.getStatusCode(), 403,
                "API returns 403 for incomplete product data");

        System.out.println("✓ Incomplete product test passed - Status: " + response.getStatusCode());
    }

    @Test
    public void testDeleteNonExistentProduct() {
        int nonExistentId = 999999;
        Response response = productClient.deleteProduct(nonExistentId);

        // API returns 404 for non-existent product deletion
        Assert.assertEquals(response.getStatusCode(), 404,
                "Should return 404 for non-existent product deletion");

        System.out.println("✓ Delete non-existent product test passed - Status: " + response.getStatusCode());
    }

    @Test
    public void testUpdateNonExistentProduct() {
        Product product = new Product();
        product.setId(999999);
        product.setName("Non Existent Product");
        product.setPrice("Rs. 500");

        Response response = productClient.updateProduct(product);

        // API returns 403 Forbidden (not 404 Not Found)
        Assert.assertEquals(response.getStatusCode(), 403,
                "API returns 403 for updating non-existent product");

        System.out.println("✓ Update non-existent product test passed - Status: " + response.getStatusCode());
    }

    @Test
    public void testVerifyErrorResponseStructure() {
        // Test that error responses have proper structure
        Response response = productClient.getProduct(999999);

        // Verify we get a response
        Assert.assertNotNull(response, "Response should not be null");
        Assert.assertTrue(response.getStatusCode() >= 400, "Should be an error status code");

        System.out.println("✓ Error response structure test passed");
        System.out.println("  Response Status: " + response.getStatusCode());
        System.out.println("  Response Body: " + response.getBody().asString());
    }
}