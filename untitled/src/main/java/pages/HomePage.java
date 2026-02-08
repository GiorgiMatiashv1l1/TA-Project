package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/logout']")
    WebElement logoutBtn;

    @FindBy(css = "a[href='/products']")
    WebElement productsLink;

    @FindBy(css = "a[href='/test_cases']")
    WebElement testCasesLink;

    public void logout() {
        click((By) logoutBtn);
    }

    public void openProducts() {
        click((By) productsLink);
    }

    public void openTestCases() {
        click((By) testCasesLink);
    }
}
