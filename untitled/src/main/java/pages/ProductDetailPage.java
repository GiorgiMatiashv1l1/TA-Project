package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private final By productName     = By.xpath("//div[@class='product-information']/h2");
    private final By productCategory = By.xpath("//div[@class='product-information']/p[contains(text(),'Category:')]");
    private final By productPrice    = By.xpath("//div[@class='product-information']/span/span");
    private final By availability    = By.xpath("//div[@class='product-information']/p/b[text()='Availability:']/parent::p");
    private final By condition       = By.xpath("//div[@class='product-information']/p/b[text()='Condition:']/parent::p");
    private final By brand           = By.xpath("//div[@class='product-information']/p/b[text()='Brand:']/parent::p");

    public boolean isProductDetailPageVisible() {
        return driver.getCurrentUrl().contains("/product_details/");
    }

    public boolean areAllProductDetailsVisible() {
        return isVisible(driver.findElement(productName))
            && isVisible(driver.findElement(productCategory))
            && isVisible(driver.findElement(productPrice))
            && isVisible(driver.findElement(availability))
            && isVisible(driver.findElement(condition))
            && isVisible(driver.findElement(brand));
    }
}