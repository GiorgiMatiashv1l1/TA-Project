package uiTests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("UI Test")
public class LoginTest extends BaseTest {
    @Test
    @Story("filling fields")
    @Description("filling name and email")
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open().checkTitle1();
        loginPage.enterName("Giorgi")
                 .enterEmail("23202245@ibsu.edu.ge")
                 .clickButton();
    }
}
