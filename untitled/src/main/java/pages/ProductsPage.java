package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "features_items")
    WebElement productsList;

    @FindBy(css = "a[href^='/product_details']")
    WebElement firstProduct;

    @FindBy(id = "search_product")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement searchBtn;

    @FindBy(css = "a.add-to-cart")
    WebElement addToCartBtn;

    @FindBy(css = "a[href='/view_cart']")
    WebElement viewCart;

    public boolean areProductsVisible() {
        return isVisible(productsList);
    }

    public void openFirstProduct() {
        firstProduct.click();
    }

    public void searchProduct(String product) {
        searchBox.clear();
        searchBox.sendKeys(product);
        searchBtn.click();
    }

    public void addProductToCart() {
        addToCartBtn.click();
        viewCart.click();
    }
}
