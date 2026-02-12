package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.UUID;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //this is for generating random email prefix number
    Random random = new Random();
    int number = random.nextInt(10000);
    String generatedEmail = number + "@gmail.com";

    String randomPassword = UUID.randomUUID().toString();

    private final static String URL = "https://automationexercise.com/login";

    private final By email = By.xpath("//input[@data-qa='login-email']\n");
    private final By password = By.xpath("//input[@data-qa='login-password']\n");
    private final By loginBtn = By.xpath("//button[@data-qa='login-button']\n");

    private final By loginFormHeading = By.xpath("//h2[text()='Login to your account']");

    @Step("Open URL")
    public LoginPage open(){
        driver.get(URL);
        return this;
    }

    @Step("Verify login form is visible")
    public boolean isLoginFormVisible() {
        return isVisible(driver.findElement(loginFormHeading));
    }

    @Step("Enter Login Email")
    public LoginPage enterEmail(String text){
        type(email, text);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String text){
        type(password, text);
        return this;
    }

    @Step("Click Login Button")
    public void clickLoginBtn(){
        click(loginBtn);
    }

    @Step("Generated Email for Incorrect Login Test")
    public LoginPage enterRandomEmail(){
        type(email, generatedEmail);
        return this;
    }

    @Step("Generate Random Password for incorrect Login Test")
    public LoginPage enterRandomPassword(){
        type(password, randomPassword);
        return this;
    }
}
