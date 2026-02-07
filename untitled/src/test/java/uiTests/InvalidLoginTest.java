package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("Negative UI Test")
@Feature("Invalid Login Test")
public class InvalidLoginTest extends BaseTest {
    @Test
    public void invalidLoginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open()
                .enterRandomEmail()
                .enterRandomPassword()
                .clickLoginBtn();
    }
}
