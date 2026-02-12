package uiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.ProductReviewPage;

@Epic("UI Test")
@Feature("Product Review Test")
public class ProductReviewTest extends BaseTest {
    @Test
    @Story("Test writing review on product")
    public void productReviewTest(){
        ProductReviewPage productReviewPage = new ProductReviewPage(driver);

        productReviewPage.open().openReviewPage()
                .verifyPage()
                .clickViewProductBtn()
                .enterName("giorgi")
                .enterEmail("giorgi@ibsu.ge")
                .enterReview("magari produqtia")
                .submit()
                .verifySubmit();
    }
}
