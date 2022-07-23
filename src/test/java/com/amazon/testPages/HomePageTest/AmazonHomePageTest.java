package com.amazon.testPages.HomePageTest;

import com.amazon.Pages.AmazonHomePage;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.HomePage2;
import configuration.common.WebTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static configuration.common.GlobalReUsableMethods.*;
public class AmazonHomePageTest extends WebTestBase {

    AmazonHomePage amazonHomePage;

    @BeforeMethod
    public void getInit() {
        amazonHomePage = PageFactory.initElements(driver, AmazonHomePage.class);
    }


    @Test(enabled = false)
    public void verifySignInFunctionality() {
        // Action method
        amazonHomePage.checkSignInWebElementFunctionality();
//        amazonHomePage.checkEmailAddressTextFieldWebElement();
//        amazonHomePage.checkContinueButtonWebElement();
    }

    @Test(enabled = false)
    public void verifyHamBurgerMenuWebElementFunctionality() throws InterruptedException {
        amazonHomePage.checkBestSellersWebElementFunctionality();
    }

    @Test(enabled = false)
    public void AmazonHomePageCustomerServicelinkFunctionalityChecking() throws InterruptedException {
        amazonHomePage.clickOnCustomerServiceLink();
    }

    @Test
    @Ignore
    public void verifySearchProductUsingValidProductNameFromDirectArray() throws InterruptedException {
        // // Data Driven Approach : Direct data
        amazonHomePage.searchProductUsingValidProductName1();
    }

    @Test
    @Ignore
    public void verifySearchProductUsingValidProductNameFromExcel() throws Exception {
        // Data driven approach from Excel
        amazonHomePage.searchProductUsingValidProductName2();
    }

    @Test
    @Ignore
    public void verifySearchProductUsingValidProductNameFromDataProvider() throws Exception {
        // Data driven approach from Database
        amazonHomePage.searchProductUsingValidProductName3();
    }

    @Test @Ignore

    public void TestAllProductFromExcel() throws Exception {
        amazonHomePage.checkAllProductInSearchBar();
    }

    @Test @Ignore
    public void verifySearchValidProduct() {
        amazonHomePage.searchValidProduct("Hand Sanitizer");
        verifyText(amazonHomePage.verifySearchedProduct, "\"Hand Sanitizer\"", "Product name does not match");
    }


    @Test
    public void verifyPurellAdvancedHandSanitizer() throws InterruptedException {
        // AmazonHomePage homePageNew=new AmazonHomePage();
        amazonHomePage.searchValidProduct("Hand Sanitizer");
        verifyText(amazonHomePage.verifySearchedProduct, "\"Hand Sanitizer\"", "Product name does not match");
        amazonHomePage.selectPurellAdvancedHandSanitizer();

    }
}