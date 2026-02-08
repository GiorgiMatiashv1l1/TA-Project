package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_info")
    WebElement cartInfo;

    public boolean isProductInCart() {
        return isVisible(cartInfo);
    }
}
