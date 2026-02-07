package uiTests;


import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("UI Test")
@Feature("Login Test")
public class LoginPageTest extends BaseTest {

    @Test
    @Story("Test Loging in")
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open()
                .enterEmail("232022@ibsu.edu.ge")
                .enterPassword("password")
                .clickLoginBtn();
    }
}
