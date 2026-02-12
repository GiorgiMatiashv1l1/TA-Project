package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

@Epic("UI Test")
@Feature("Add To Cart Test")
public class AddToCartTest extends BaseTest {

    @Test
    @Story("Test Case 12 - Add Products In Cart")
    public void addToCartTest() {
        driver.get("https://automationexercise.com");

        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.openProducts();

        Assert.assertTrue(productsPage.areProductsVisible());

        productsPage.addProductToCart();

        Assert.assertTrue(cartPage.isProductInCart());
    }
}