package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
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
        click((By) firstProduct);
    }

    public void searchProduct(String product) {
        type((By) searchBox, product);
        click((By) searchBtn);
    }

    public void addProductToCart() {
        click((By) addToCartBtn);
        click((By) viewCart);
    }
}
