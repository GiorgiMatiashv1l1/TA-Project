package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String URL = "https://automationexercise.com/login";

    //on login
    private final By sectionTitle = By.xpath("//h2[text()='New User Signup!']\n");
    private final By name = By.xpath("//input[@data-qa='signup-name']\n");
    private final By email = By.xpath("//input[@data-qa='signup-email']\n");
    private final By submitBtn = By.xpath("//button[@data-qa='signup-button']\n");

    @Step("Open page")
    public LoginPage open(){
        driver.get(URL);
        return this;
    }

    @Step("Check title")
    public void checkTitle1(){
        getText(sectionTitle);
    }

    @Step("Enter name")
    public LoginPage enterName(String text){
        type(name, text);
        return this;
    }

    @Step("Enter email")
    public LoginPage enterEmail(String text){
        type(email, text);
        return this;
    }

    @Step("Click button")
    public void clickButton(){
        click(submitBtn);
    }

}
