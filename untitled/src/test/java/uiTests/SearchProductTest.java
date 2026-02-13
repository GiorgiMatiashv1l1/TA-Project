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
@Feature("Search Product Test")
public class SearchProductTest extends BaseTest {

    @Test
    @Story("Test Case 9 - Search Product")
    public void searchProductTest() {
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        homePage.open();
        Assert.assertTrue(homePage.isHomePageVisible());

        homePage.openProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible());

        productsPage.searchProduct("Dress");

        Assert.assertTrue(productsPage.isSearchedProductsTitleVisible());

        Assert.assertTrue(productsPage.areProductsVisible());
    }
}