package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

@Epic("UI Test")
@Feature("Test Cases Page Test")
public class TestCasesPageTest extends BaseTest {

    @Test
    @Story("Test Case 7 - Verify Test Cases Page")
    public void testCasesPageTest() {
        driver.get("https://automationexercise.com");

        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage = new TestCasesPage(driver);

        homePage.openTestCases();

        Assert.assertTrue(testCasesPage.isPageVisible());
    }
}