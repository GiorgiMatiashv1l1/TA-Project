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

    @FindBy(css = "a[href='/logout']")
    WebElement logoutBtn;

    @FindBy(css = "a[href='/products']")
    WebElement productsLink;

    @FindBy(css = "a[href='/test_cases']")
    WebElement testCasesLink;

    public void logout() {
        logoutBtn.click();
    }

    public void openProducts() {
        productsLink.click();
    }

    public void openTestCases() {
        testCasesLink.click();
    }
}