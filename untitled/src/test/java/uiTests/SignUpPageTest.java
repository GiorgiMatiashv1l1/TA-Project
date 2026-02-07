package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.SignUpPage;

@Epic("UI Test")
@Feature("Sign up Page Test")
public class SignUpPageTest extends BaseTest {

    @Test
    @Story("Test Signing up")
    public void signUpTest(){
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open().checkTitle1();
        signUpPage.enterName("Giorgi")
                        .enterEmail("232012@ibsu.edu.ge")
                        .clickSignupBtn();


        signUpPage.checkTitle2();
        signUpPage.checkGenderMale()
                .enterSignupName("Giorgi")
                .enterPassword("password")
                .selectDay("27")
                .selectMonth("November")
                .selectYear("2004")
                .checkFirstCheckbox()
                .checkSecondCheckbox()
                .enterFirstname("Giorgi")
                .enterLastname("Matiashvili")
                .enterCompany("Google")
                .enterAddress1("Tbilisi")
                .enterAddress2("Telavi")
                .selectCountry("United States")
                .enterState("New York")
                .enterCity("New York")
                .enterZipcode("0144")
                .enterMobileNumber("551500934")
                .clickButton();
        signUpPage.getSuccessMessage();

    }
}
