package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

@Epic("UI Test")
@Feature("Logout Test")
public class LogoutTest extends BaseTest {

    @Test
    @Story("Test Case 4 - Logout User")
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.open()
                .enterEmail("232022@ibsu.edu.ge")
                .enterPassword("password")
                .clickLoginBtn();

        homePage.logout();
    }
}