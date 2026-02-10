package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Epic("UI TEST")
@Feature("Contact Form Test")
public class ContactUsTest extends BaseTest {
    @Test
    public void contactUsTest() throws URISyntaxException {
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        Path path = Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource("test-data.json")
                ).toURI()
        );

        String filePath = path.toString();



        contactUsPage.open()
                .clickContactsNavLink()
                .validateContactsPageTitle();

        contactUsPage.enterName("Giorgi")
                .enterEmail("23202245@ibsu.edu.ge")
                .enterSubject("Test")
                .enterMessage("Test")
                .uploadFile(filePath)
                .submitForm()
                .acceptAlert()
                .getSuccessMsg();


    }
}
