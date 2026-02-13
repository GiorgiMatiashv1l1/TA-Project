package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        return wait.until(ExpectedConditions.urlContains("/products"));
    }

      public boolean isSearchedProductsTitleVisible() {
          wait.until(ExpectedConditions.textToBe(pageTitle, "SEARCHED PRODUCTS"));
          return true;
      }

    public void openFirstProduct() {
        jsClick(By.cssSelector("a[href^='/product_details']"));
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

        List<WebElement> addBtns = card.findElements(By.cssSelector(".add-to-cart"));
        WebElement addBtn = addBtns.get(addBtns.size() - 1);

        js.executeScript("arguments[0].click();", addBtn);
    }

    public void hoverAndAddFirstProductToCart() {
        hoverAndAddToCart(0);
    }

    public void hoverAndAddSecondProductToCart() {
        hoverAndAddToCart(1);
    }

    public void clickContinueShopping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingBtn));
        click(continueShoppingBtn);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(continueShoppingBtn));
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));
        click(viewCartLink);
    }
}
