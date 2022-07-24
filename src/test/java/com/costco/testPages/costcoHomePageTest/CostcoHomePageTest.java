package com.costco.testPages.costcoHomePageTest;

import com.amazon.Pages.HomePage2;
import com.costco.costcoPages.CostcoHomePage;
import configuration.common.WebTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static configuration.common.GlobalReUsableMethods.verifyText;

public class CostcoHomePageTest extends WebTestBase {


    CostcoHomePage costcoHomePage;

    @BeforeMethod
    public void getInit() {
        costcoHomePage = PageFactory.initElements(driver, CostcoHomePage.class);
    }

    @Test
    public void verifyCostcoSearchBox() throws InterruptedException {
        costcoHomePage.checkSearchBoxWithValidProducts("Bike");
        waitFor(10);
//        verifyText(costcoHomePage.verifyBikeText, "Bike", "text not match");
//        waitFor(3);
    }
@Test @Ignore
    public void verifyPhotoWebElement() throws InterruptedException {
    costcoHomePage.checkPhotoWebElementOnCostcoHomePage();
//    waitFor(10);


}
}
