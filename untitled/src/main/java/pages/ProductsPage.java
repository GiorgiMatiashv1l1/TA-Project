package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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


    private final By pageTitle = By.xpath("//h2[@class='title text-center']");

    private final By productCards = By.className("single-products");

    private final By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");

    private final By viewCartLink = By.xpath("//u[text()='View Cart']");

    public boolean areProductsVisible() {
        return isVisible(productsList);
    }

    public boolean isAllProductsPageVisible() {
        return driver.getCurrentUrl().contains("/products");
    }

      public boolean isSearchedProductsTitleVisible() {
        String title = getText(pageTitle);
        return title.contains("SEARCHED PRODUCTS");
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


    private void hoverAndAddToCart(int index) {
        List<WebElement> cards = driver.findElements(productCards);
        WebElement card = cards.get(index);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", card);
        new Actions(driver).moveToElement(card).perform();
        card.findElement(By.cssSelector(".add-to-cart")).click();
    }

    public void hoverAndAddFirstProductToCart() {
        hoverAndAddToCart(0);
    }

    public void hoverAndAddSecondProductToCart() {
        hoverAndAddToCart(1);
    }

    public void clickContinueShopping() {
        click(continueShoppingBtn);
    }

    public void clickViewCart() {
        click(viewCartLink);
    }
}
