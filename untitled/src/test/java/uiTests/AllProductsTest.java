package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

@Epic("UI Test")
@Feature("All Products Test")
public class AllProductsTest extends BaseTest {

    @Test
    @Story("Test Case 8 - Verify All Products And Product Detail Page")
    public void allProductsTest() {
        driver.get("https://automationexercise.com");

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        homePage.openProducts();

        Assert.assertTrue(productsPage.areProductsVisible());

        productsPage.openFirstProduct();
    }
}