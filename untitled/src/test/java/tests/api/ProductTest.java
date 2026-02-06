package tests.api;

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

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        // Deserialize response
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        // Verify response code
        Assert.assertEquals(productsResponse.getResponseCode(), 200, "Response code should be 200");

        // Verify products list is not empty
        Assert.assertNotNull(productsResponse.getProducts(), "Products list should not be null");
        Assert.assertTrue(productsResponse.getProducts().size() > 0, "Products list should not be empty");

        // Print product count
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
    public void testGetSpecificProduct() {
        // First get all products to get a valid product ID
        Response allProductsResponse = productClient.getAllProducts();
        ProductsResponse productsResponse = allProductsResponse.as(ProductsResponse.class);
        int productId = productsResponse.getProducts().get(0).getId();

        // Get specific product
        Response response = productClient.getProduct(productId);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        System.out.println("Successfully retrieved product with ID: " + productId);
    }

    @Test(priority = 4)
    public void testCreateProduct() {
        // Create UserType
        UserType userType = new UserType("Men");

        // Create Category
        Category category = new Category(userType, "Tshirts");

        // Create Product
        Product newProduct = new Product();
        newProduct.setName("Test Product");
        newProduct.setPrice("Rs. 999");
        newProduct.setBrand("TestBrand");
        newProduct.setCategory(category);

        // Send request
        Response response = productClient.createProduct(newProduct);

        // Verify status code (201 for created or 200 for success)
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 201,
                "Status code should be 200 or 201");

        System.out.println("Product created successfully");
    }

    @Test(priority = 5)
    public void testUpdateProduct() {
        // Create UserType
        UserType userType = new UserType("Women");

        // Create Category
        Category category = new Category(userType, "Dress");

        // Create Product to update
        Product productToUpdate = new Product();
        productToUpdate.setId(1);
        productToUpdate.setName("Updated Product Name");
        productToUpdate.setPrice("Rs. 1500");
        productToUpdate.setBrand("UpdatedBrand");
        productToUpdate.setCategory(category);

        // Send request
        Response response = productClient.updateProduct(productToUpdate);

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        System.out.println("Product updated successfully");
    }

    @Test(priority = 6)
    public void testDeleteProduct() {
        int productIdToDelete = 1;

        Response response = productClient.deleteProduct(productIdToDelete);

        // Verify status code (200 or 204 for successful deletion)
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204,
                "Status code should be 200 or 204");

        System.out.println("Product deleted successfully");
    }

    @Test(priority = 7)
    public void testFilterProductsByCategory() {
        Response response = productClient.getAllProducts();
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        // Filter products by category
        long tshirtCount = productsResponse.getProducts().stream()
                .filter(product -> "Tshirts".equals(product.getCategory().getCategory()))
                .count();

        System.out.println("Number of T-shirts: " + tshirtCount);
        Assert.assertTrue(tshirtCount > 0, "Should have at least one T-shirt");
    }

    @Test(priority = 8)
    public void testFilterProductsByUserType() {
        Response response = productClient.getAllProducts();
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        // Filter products by user type
        long menProductsCount = productsResponse.getProducts().stream()
                .filter(product -> "Men".equals(product.getCategory().getUsertype().getUsertype()))
                .count();

        System.out.println("Number of Men's products: " + menProductsCount);
        Assert.assertTrue(menProductsCount > 0, "Should have at least one Men's product");
    }

    @Test(priority = 9)
    public void testFilterProductsByBrand() {
        Response response = productClient.getAllProducts();
        ProductsResponse productsResponse = response.as(ProductsResponse.class);

        String brandToFilter = "Polo";

        // Filter products by brand
        long brandProductCount = productsResponse.getProducts().stream()
                .filter(product -> brandToFilter.equals(product.getBrand()))
                .count();

        System.out.println("Number of " + brandToFilter + " products: " + brandProductCount);
    }

    @Test(priority = 10)
    public void testVerifyResponseTime() {
        Response response = productClient.getAllProducts();

        long responseTime = response.getTime();
        System.out.println("Response time: " + responseTime + "ms");

        // Assert response time is less than 3 seconds
        Assert.assertTrue(responseTime < 3000, "Response time should be less than 3000ms");
    }
}