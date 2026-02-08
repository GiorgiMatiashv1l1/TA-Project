package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage {

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    WebElement title;

    public boolean isPageVisible() {
        return isVisible(title);
    }
}
