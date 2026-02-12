package pages;

import io.qameta.allure.Step;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReviewPage extends BasePage{

    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    private final String URL = "https://automationexercise.com/";

    private final By productsNavLink = By.xpath("//a[@href='/products']");
    private final By pageTitle = By.xpath("//h2[@class='title text-center']");
    private final By viewProductBtn = By.xpath("//a[@href='/product_details/1']");

    //for scroll
    private final By footer = By.id("footer");

    private final By name = By.id("name");
    private final By email = By.id("email");
    private final By review = By.id("review");
    private final By submitBtn = By.id("button-review");
    private final By successMsg = By.xpath("//span[text()='Thank you for your review.']\n");


    @Step("Open Website")
    public ProductReviewPage open(){
        driver.get(URL);
        return this;
    }

    @Step("Click products Nav Link to open page")
    public ProductReviewPage openReviewPage(){
        click(productsNavLink);
        return this;
    }

    @Step("Verify that page is open")
    public ProductReviewPage verifyPage(){
        getText(pageTitle);
        return this;
    }

    @Step("Click view product button")
    public ProductReviewPage clickViewProductBtn(){
        ScrollToElement(viewProductBtn);
        click(viewProductBtn);
        return this;
    }

    @Step("Enter name")
    public ProductReviewPage enterName(String text){
        ScrollToElement(footer);
        type(name, text);
        return this;
    }

    @Step("Enter email")
    public ProductReviewPage enterEmail(String text){
        type(email, text);
        return this;
    }

    @Step("Write Review")
    public ProductReviewPage enterReview(String text){
        type(review, text);
        return this;
    }

    @Step("Click submit")
    public ProductReviewPage submit(){
        click(submitBtn);
        return this;
    }

    @Step("Verify submit")
    public ProductReviewPage verifySubmit(){
        getText(successMsg);
        return this;
    }
}
