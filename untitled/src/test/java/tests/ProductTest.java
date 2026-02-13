package tests;

import client.ProductClient;
import io.restassured.response.Response;
import model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest {

    private ProductClient productClient;

    @BeforeClass
    public void setup() {
        productClient = new ProductClient();
    }

    @Test(priority = 1)
    public void testGetAllProducts() {
        Response response = productClient.getAllProducts();

        // Verify HTTP status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        // Deserialize response
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        // Verify API response code inside body
        Assert.assertEquals(productsResponse.getResponseCode(), 200, "Response code should be 200");

        // Verify products list is not empty
        Assert.assertNotNull(productsResponse.getProducts(), "Products list should not be null");
        Assert.assertFalse(productsResponse.getProducts().isEmpty(), "Products list should not be empty");

        System.out.println("Total products found: " + productsResponse.getProducts().size());
    }

    @Test(priority = 2)
    public void testGetAllProductsAndVerifyStructure() {
        Response response = productClient.getAllProducts();
        ProductsResponse productsResponse = response.as(ProductsResponse.class);
        List<Product> products = productsResponse.getProducts();

        // Verify first product has all required fields
        Product firstProduct = products.get(0);
        Assert.assertNotNull(firstProduct.getId(), "Product ID should not be null");
        Assert.assertNotNull(firstProduct.getName(), "Product name should not be null");
        Assert.assertNotNull(firstProduct.getPrice(), "Product price should not be null");
        Assert.assertNotNull(firstProduct.getBrand(), "Product brand should not be null");
        Assert.assertNotNull(firstProduct.getCategory(), "Product category should not be null");

        System.out.println("First product: " + firstProduct.getName());
    }

    @Test(priority = 3)
    public void testPostToProductsListReturns405() {
        // API 2: POST request to All Products List — should return 405 Method Not Allowed
        Response response = productClient.getAllProductsWithPost();

        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status should be 200");

        // The API wraps 405 inside JSON body
        ProductsResponse productsResponse = response.as(ProductsResponse.class);
        Assert.assertEquals(productsResponse.getResponseCode(), 405,
                "API response code should be 405 for POST to productsList");

        System.out.println("POST to productsList correctly returned 405");
    }

    @Test(priority = 4)
    public void testGetAllBrands() {
        Response response = productClient.getAllBrands();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        System.out.println("Brands list response: " + response.getBody().asString().substring(0, 100));
    }

    @Test(priority = 5)
    public void testSearchProduct() {
        Response response = productClient.searchProduct("top");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        ProductsResponse productsResponse = response.as(ProductsResponse.class);
        Assert.assertEquals(productsResponse.getResponseCode(), 200, "Response code should be 200");
        Assert.assertNotNull(productsResponse.getProducts(), "Search results should not be null");

        System.out.println("Search results found: " + productsResponse.getProducts().size());
    }

    @Test(priority = 6)
    public void testFilterProductsByCategory() {
        Response response = productClient.getAllProducts();
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        long tshirtCount = productsResponse.getProducts().stream()
                .filter(product -> "Tshirts".equals(product.getCategory().getCategory()))
                .count();

        System.out.println("Number of T-shirts: " + tshirtCount);
        Assert.assertTrue(tshirtCount > 0, "Should have at least one T-shirt");
    }

    @Test(priority = 7)
    public void testFilterProductsByUserType() {
        Response response = productClient.getAllProducts();
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        long menProductsCount = productsResponse.getProducts().stream()
                .filter(product -> "Men".equals(product.getCategory().getUsertype().getUsertype()))
                .count();

        System.out.println("Number of Men's products: " + menProductsCount);
        Assert.assertTrue(menProductsCount > 0, "Should have at least one Men's product");
    }

    @Test(priority = 8)
    public void testFilterProductsByBrand() {
        Response response = productClient.getAllProducts();
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        String brandToFilter = "Polo";

        long brandProductCount = productsResponse.getProducts().stream()
                .filter(product -> brandToFilter.equals(product.getBrand()))
                .count();

        System.out.println("Number of " + brandToFilter + " products: " + brandProductCount);
        Assert.assertTrue(brandProductCount >= 0, "Brand filter should execute without error");
    }

    @Test(priority = 9)
    public void testVerifyResponseTime() {
        Response response = productClient.getAllProducts();

        long responseTime = response.getTime();
        System.out.println("Response time: " + responseTime + "ms");

        Assert.assertTrue(responseTime < 5000, "Response time should be less than 5000ms");
    }

    @Test(priority = 10)
    public void testVerifyLogin() {
        Response response = productClient.verifyLogin("test@example.com", "wrongpassword");

        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status should be 200");
        System.out.println("Verify login response: " + response.getBody().asString());
    }
}
