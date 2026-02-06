package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    private final static String URL = "https://automationexercise.com/login";

    private final By sectionTitle1 = By.xpath("//h2[text()='New User Signup!']\n");
    private final By name = By.xpath("//input[@data-qa='signup-name']\n");
    private final By email = By.xpath("//input[@data-qa='signup-email']\n");
    private final By signupBtn = By.xpath("//button[@data-qa='signup-button']\n");

    //Account info
    private final By sectionTitle2 = By.cssSelector(".title");
    private final By genderTitleMale = By.id("uniform-id_gender1");
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By password = By.id("password");
    private final By day = By.id("days");
    private final By month = By.id("months");
    private final By year = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By secondCheckbox = By.id("optin");

    //Address info
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address1 = By.id("address1");
    private final By address2 = By.id("address2");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");

    private final By createAccountBtn = By.cssSelector(".btn-default");

    @Step("Open page")
    public SignUpPage open(){
        driver.get(URL);
        return this;
    }

    @Step("Check title")
    public void checkTitle1(){
        getText(sectionTitle1);
    }

    @Step("Enter name")
    public SignUpPage enterName(String text){
        type(name, text);
        return this;
    }

    @Step("Enter email")
    public SignUpPage enterEmail(String text){
        type(email, text);
        return this;
    }

    @Step("Click submit button")
    public void clickSignupBtn(){
        click(signupBtn);
    }


    //Account info
    @Step("Check title 2")
    public void checkTitle2(){
        getText(sectionTitle2);
    }

    @Step("Check Gender Male")
    public SignUpPage checkGenderMale(){
        click(genderTitleMale);
        return this;
    }

    @Step("Enter name")
    public SignUpPage enterSignupName(String text){
        type(nameInput, text);
        return this;
    }

    @Step("Enter Email")
    public SignUpPage enterSignupEmail(String text){
        type(emailInput, text);
        return this;
    }

    @Step("Enter Password")
    public SignUpPage enterPassword(String text){
        ScrollToElement(secondCheckbox);
        type(password, text);
        return this;
    }

    @Step("Select day")
    public SignUpPage selectDay(String value){
        selectByValue(day,value);
        return this;
    }

    @Step("Select month")
    public SignUpPage selectMonth(String text){
        selectByVisibleText(month, text);
        return this;
    }

    @Step("Select year")
    public SignUpPage selectYear(String value){
        selectByValue(year, value);
        return this;
    }

    @Step("Check first checkbox")
    public SignUpPage checkFirstCheckbox(){
        click(newsletterCheckbox);
        return this;
    }

    @Step("Check second checkbox")
    public SignUpPage checkSecondCheckbox(){
        click(secondCheckbox);
        return this;
    }


    // Address info
    @Step("Enter firstname")
    public SignUpPage enterFirstname(String text){
        ScrollToElement(state);
        type(firstName, text);
        return this;
    }

    @Step("Enter Lastname")
    public SignUpPage enterLastname(String text){
        type(lastName, text);
        return this;
    }

    @Step("Enter company")
    public SignUpPage enterCompany(String text){
        type(company, text);
        return this;
    }

    @Step("Enter Address 1")
    public SignUpPage enterAddress1(String text){
        type(address1, text);
        return this;
    }

    @Step("Enter Address 2")
    public SignUpPage enterAddress2(String text){
        type(address2, text);
        return this;
    }

    @Step("Select Country")
    public SignUpPage selectCountry(String value){
        selectByValue(country, value);
        return this;
    }

    @Step("Enter State")
    public SignUpPage enterState(String text){
        type(state, text);
        return this;
    }

    @Step("Enter City")
    public SignUpPage enterCity(String text){
        ScrollToElement(createAccountBtn);
        type(city, text);
        return this;
    }

    @Step("Enter Zip Code")
    public SignUpPage enterZipcode(String text){
        type(zipcode, text);
        return this;
    }

    @Step("Enter Mobile Number")
    public SignUpPage enterMobileNumber(String text){
        type(mobileNumber, text);
        return this;
    }

    @Step("Click create-account button ")
    public void clickButton(){
        click(createAccountBtn);
    }
}
