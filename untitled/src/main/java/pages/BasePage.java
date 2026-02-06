package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js =(JavascriptExecutor) driver;
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected void selectByVisibleText(By locator, String text){
        Select select = new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(By locator, String value){
        Select select = new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ));
        select.selectByValue(value);
    }

    protected void selectByIndex(By locator, int index){
        Select select = new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ));
        select.selectByIndex(index);
    }

    protected void ScrollToElement(By locator) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }
}
