package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cart_info")
    WebElement cartInfo;


    private final By cartRows = By.xpath("//table[@id='cart_info_table']/tbody/tr");
    private final By cartPrices = By.xpath("//td[@class='cart_price']/p");
    private final By cartQuantities = By.xpath("//td[@class='cart_quantity']/button");
    private final By cartTotals = By.xpath("//td[@class='cart_total']/p");

    public boolean isProductInCart() {
        return isVisible(cartInfo);
    }

    public boolean areBothProductsInCart() {
        List<WebElement> rows = driver.findElements(cartRows);
        return rows.size() >= 2;
    }

    public boolean arePricesQuantitiesAndTotalsVisible() {
        List<WebElement> prices     = driver.findElements(cartPrices);
        List<WebElement> quantities = driver.findElements(cartQuantities);
        List<WebElement> totals     = driver.findElements(cartTotals);
        return !prices.isEmpty() && !quantities.isEmpty() && !totals.isEmpty();
    }
}
