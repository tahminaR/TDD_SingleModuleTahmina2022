package com.costco.testPages.costcoHomePageTest;

import com.amazon.Pages.HomePage2;
import com.costco.costcoPages.CostcoHomePage;
import configuration.common.WebTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
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
        waitFor(5);
//    verifyText(costcoHomePage.verifySearchText,"We found 20 results for \"bike\"","Product name does not match");
    }


}
