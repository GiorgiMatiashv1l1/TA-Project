package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private final static String HOME_URL = "https://automationexercise.com/";
    private final static String CONTACTS_URL = "https://automationexercise.com/contact_us";

    //link from nav bar to contacts page
    private final By contactBtn = By.xpath("//a[@href='/contact_us']");

    //contacts page itself
    private final By contactsPagetitle = By.xpath("//h2[@class='title text-center']");
    private final By name = By.xpath("//input[@data-qa='name']\n");
    private final By email = By.xpath("//input[@data-qa='email']\n");
    private final By subject = By.cssSelector(".form-control");
    private final By message = By.id("message");
    private final By uploadFile = By.xpath("//input[@type='file']");
    private final By submitBtn = By.name("submit");

    private final By successMsg = By.xpath("//div[@class='status alert alert-success']");



    //open home page first to test opening from navbar
    @Step("Open Home Page")
    public ContactUsPage open(){
        driver.get(HOME_URL);
        return this;
    }

    //open directly contact us page
    @Step("Open Contacts Page")
    public ContactUsPage openContactsPage(){
        driver.get(CONTACTS_URL);
        return this;
    }

    //open from navbar
    @Step("Open contact-us page from navbar")
    public ContactUsPage clickContactsNavLink(){
        click(contactBtn);
        return this;
    }

    @Step("Validate page")
    public String validateContactsPageTitle(){
        return getText(contactsPagetitle);
    }

    @Step("Enter Name")
    public ContactUsPage enterName(String text){
        type(name, text);
        return this;
    }

    @Step("Enter email")
    public ContactUsPage enterEmail(String text){
        type(email, text);
        return this;
    }

    @Step("Enter Subject")
    public ContactUsPage enterSubject(String text){
        type(subject, text);
        return this;
    }

    @Step("Enter Message")
    public ContactUsPage enterMessage(String text){
        type(message, text);
        return this;
    }

    @Step("Upload file")
    public ContactUsPage uploadFile(String absolutePath){
        uploadFile(uploadFile, absolutePath);
        return this;
    }

    @Step("Submit")
    public ContactUsPage submitForm(){
        click(submitBtn);
        return this;
    }

    @Step("Accept Alert")
    public ContactUsPage acceptAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    @Step("Validate Success Message")
    public String getSuccessMsg(){
        return getText(successMsg);
    }
}
