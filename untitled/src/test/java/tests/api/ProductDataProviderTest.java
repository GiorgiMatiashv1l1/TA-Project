package tests.api;

import client.ProductClient;
import io.restassured.response.Response;
import model.Category;
import model.Product;
import model.UserType;
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

    @DataProvider(name = "productData")
    public Object[][] productData() {
        return new Object[][]{
                {"Test Product 1", "Rs. 500", "Brand1", "Men", "Tshirts"},
                {"Test Product 2", "Rs. 1000", "Brand2", "Women", "Dress"},
                {"Test Product 3", "Rs. 750", "Brand3", "Kids", "Tops & Shirts"}
        };
    }

    @Test(dataProvider = "productData")
    public void testCreateMultipleProducts(String name, String price, String brand,
                                           String userTypeValue, String categoryValue) {
        // Create UserType
        UserType userType = new UserType(userTypeValue);

        // Create Category
        Category category = new Category(userType, categoryValue);

        // Create Product
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setBrand(brand);
        product.setCategory(category);

        // Send request
        Response response = productClient.createProduct(product);

        // Verify
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 201,
                "Product creation failed for: " + name);

        System.out.println("Created product: " + name);
    }

    @DataProvider(name = "invalidProductIds")
    public Object[][] invalidProductIds() {
        return new Object[][]{
                {-1},
                {0},
                {99999}
        };
    }

    @Test(dataProvider = "invalidProductIds")
    public void testGetProductWithInvalidId(int productId) {
        Response response = productClient.getProduct(productId);

        // Expecting 404 or 400 for invalid IDs
        Assert.assertTrue(response.getStatusCode() == 404 || response.getStatusCode() == 400,
                "Should return error for invalid product ID: " + productId);
    }
}