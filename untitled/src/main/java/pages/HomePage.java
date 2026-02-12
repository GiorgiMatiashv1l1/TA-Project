package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String URL = "https://automationexercise.com";

    @FindBy(css = "a[href='/logout']")
    WebElement logoutBtn;

    @FindBy(css = "a[href='/products']")
    WebElement productsLink;

    @FindBy(css = "a[href='/test_cases']")
    WebElement testCasesLink;

    @FindBy(css = "a[href='/login']")
    WebElement loginSignupLink;

    @FindBy(id = "slider-carousel")
    WebElement slider;

    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
    WebElement loggedInAsText;

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public boolean isHomePageVisible() {
        return isVisible(slider);
    }

    public void clickLoginSignup() {
        loginSignupLink.click();
    }

    public void logout() {
        logoutBtn.click();
    }

    public boolean isLoggedInAsVisible() {
        return isVisible(loggedInAsText);
    }

    public void openProducts() {
        productsLink.click();
    }

    public void openTestCases() {
        testCasesLink.click();
    }
}