package com.amazon.Pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.amazon.PageElements.AmazonHomePageElements.*;
import static configuration.common.GlobalReUsableMethods.*;
import static configuration.utilities.DataDriven.*;
import static configuration.utilities.DataDriven.getItemsListFromExcel;


public class AmazonHomePage extends WebTestBase {

//        public AmazonHomePage(){
//            PageFactory.initElements(driver,this);
//        }
//===============================================================
// @FindBy
@FindBy(xpath = clickOnSignInWebElement)
public WebElement clickOnSignIn;
    @FindBy(xpath = enterEmailAddressOnTextFieldWebElement)
    public WebElement enterEmailAddressOnTextField;
    @FindBy(xpath = clickOnContinueButtonWebElement)
    public WebElement clickOnContinueButton;
    @FindBy(xpath = enterInvalidPassWordOnPasswordTextFieldWebElement)
    public WebElement enterInvalidPassWordOnPasswordTextField;
    @FindBy(xpath = clickOnSignInButtonWebElement)
    public WebElement clickOnSignInButton;
    @FindBy(xpath = verifyErrorMassagePageDisplayWebElement)
    public WebElement verifyErrorMassagePageDisplay;
    //==================================================================
    @FindBy(xpath = clickHamBurgerMenuWebElement)
    public WebElement clickHamBurgerMenu;
    @FindBy(xpath = clickOnBestSellersWebElement)
    public WebElement clickOnBestSellers;
    @FindBy(xpath = clickOnAmazonDeviceAndAccessoriesLinkWebElement)
    public WebElement clickOnAmazonDeviceAndAccessoriesLink;
    @FindBy(xpath = verifyBestSellersPageTextWebElement)
    public WebElement verifyBestSellersPageText;
    //===================================================================
    @FindBy(xpath = clickOnCustomerServiceLinkWebElement)
    public WebElement clickOnCustomerServiceLink;
    @FindBy(xpath = clickOnPrimeLinkWebElement)
    public WebElement clickOnPrimeLink;
    @FindBy(xpath = enterValidEmailAddressOrPhoneNumberInUsernameFieldWebElement)
    public WebElement enterValidEmailAddressOrPhoneNumberInUsernameField;
    @FindBy(xpath = enterInValidPasswordInPasswordFieldWebElement)
    public WebElement enterInValidPasswordInPasswordField;
    //    @FindBy(xpath = clickOnSignInButtonWebElement)
//    public WebElement clickOnSignInButton;
//    @FindBy(xpath = verifyErrorMassagePageDisplayWebElement)
//    public WebElement verifyErrorMassagePageDisplay;
    //======================================================================
    @FindBy(xpath = searchBoxWebElement)
    public WebElement searchBox;
    @FindBy(xpath = searchButtonWebElement)
    public WebElement searchButton;
    @FindBy(xpath = verifySearchedProductWebElement)
    public WebElement verifySearchedProduct;
    //=============================================================================

        @FindBy(xpath = purellAdvancedHandSanitizerWebElement)
        public WebElement purellAdvancedHandSanitizer;
        @FindBy(xpath = oneTimePurchaseWebElement)
        public WebElement oneTimePurchase;
        @FindBy(xpath = selectQtyWebElement)
        public WebElement selectQty;
        @FindBy(xpath = setQtyWebElement)
        public WebElement setQty;
        @FindBy(xpath = addToShoppingCartWebElement)
        public WebElement addToShoppingCart;
        @FindBy(xpath = proceedToRetailCheckoutWebElement)
        public WebElement proceedToRetailCheckout;


    /**
     * verify SignIn functionality with inValid credential
     */
    public void checkSignInWebElementFunctionality() {
        clickOnSignIn.click();
        enterEmailAddressOnTextField.sendKeys("akthamina@yahoo.com");
        clickOnContinueButton.click();
        enterInvalidPassWordOnPasswordTextField.sendKeys("Test43221");
        clickOnSignInButton.click();
        String expectedKeyWord = "There was a problem";
        String actualSearchKeyword = verifyErrorMassagePageDisplay.getText();
        System.out.println("Actual Text: " + actualSearchKeyword);
        Assert.assertEquals(actualSearchKeyword, expectedKeyWord, "page not found");

    }

//    public void checkEmailAddressTextFieldWebElement() {
//        enterEmailAddressOnTextField.sendKeys("akthamina@yahoo.com");
//    }
//    public void checkContinueButtonWebElement() {
//        clickOnContinueButton.click();
//    }
//    public void checkPasswordFieldWebElement() {
//        enterPassWordOnPasswordTextField.sendKeys("Test43221");
//    }
//    public void checkSignInButtonWebElement() {
//        clickOnSignInButton.click();
//    }
//    public void verifyErrorMassageDisplayed() {
//        String expectedKeyWord = "There was a problem";
//        String actualSearchKeyword = verifyErrorMassagePageDisplay.getText();
//        System.out.println("Actual Text: " + actualSearchKeyword);
//        Assert.assertEquals(actualSearchKeyword, expectedKeyWord, "page not found");
//    }




    /**
     * verify Best Sellers Link functionality
     */


    public void checkBestSellersWebElementFunctionality() throws InterruptedException {
        clickHamBurgerMenu.click();
        clickOnBestSellers.click();
        clickOnAmazonDeviceAndAccessoriesLink.click();
        Thread.sleep(5000);

        String expectedKeyWord = "Amazon Best Sellers";
        String actualSearchKeyword = verifyBestSellersPageText.getText();
        System.out.println("Actual Text: " + actualSearchKeyword);
        Assert.assertEquals(actualSearchKeyword, expectedKeyWord, "page not found");
        Thread.sleep(6000);
    }




    /**
     *
     */

    public void clickOnCustomerServiceLink() throws InterruptedException {
        clickOnCustomerServiceLink.click();
        clickOnPrimeLink.click();
        enterValidEmailAddressOrPhoneNumberInUsernameField.sendKeys("tamtammeena@gmail.com");
        enterValidEmailAddressOrPhoneNumberInUsernameField.click();
        enterInValidPasswordInPasswordField.sendKeys("testpassword");
        clickOnSignInButton.click();
        String expectedKeyWord = "There was a problem";
        String actualSearchKeyword = verifyErrorMassagePageDisplay.getText();
        System.out.println("Actual Text: " + actualSearchKeyword);
        Assert.assertEquals(actualSearchKeyword, expectedKeyWord, "page not found");
        Thread.sleep(6000);
    }

    //**********     using Array Data Driven Approach **********************************
    public static List<String> getExpectedProducts() {
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("Hand sanitizer");
        itemsList.add("iphone 11 pro max");
        itemsList.add("t-shirt");
//        itemsList.add("Mens shirt");
//        itemsList.add("Shoes");
//        itemsList.add("Camera");
//        itemsList.add("Bike");
//        itemsList.add("Tv");
        return itemsList;
    }

    // Data Driven Approach : Direct data
    public void searchProductUsingValidProductName1() throws InterruptedException {
        for (String st : getExpectedProducts()) {
            searchBox.clear();
            searchBox.sendKeys(st);
            searchButton.click();
            String expectedProductName = "\"" + st + "\"";
            String actualProductName = driver.findElement(By.xpath(verifySearchedProductWebElement)).getText();
            Assert.assertEquals(actualProductName, expectedProductName, "Product name doest match");
            waitFor(5);
        }
    }

    // Data driven approach from Excel
    // ***********  after size() -1 is needed to end execution. **********
    public void searchProductUsingValidProductName2() throws Exception {
        for (int i = 0; i < getItemsListFromExcel().size() - 1; i++) {
            searchBox.clear();
            searchBox.sendKeys(getItemsListFromExcel().get(i + 1));
            searchButton.click();
            String expectedProductName = "\"" + getItemsListFromExcel().get(i + 1) + "\"";
            String actualProductName = driver.findElement(By.xpath(verifySearchedProductWebElement)).getText();
            Assert.assertEquals(actualProductName, expectedProductName, "Product name doest match");
            waitFor(5);
        }
    }

    // Data driven approach from Database
    public void searchProductUsingValidProductName3() throws Exception {
        for (String st : getItemsListFromDB()) {
            searchBox.clear();
            searchBox.sendKeys(st);
            searchButton.click();
            String expectedProductName = "\"" + st + "\"";
            String actualProductName = driver.findElement(By.xpath(verifySearchedProductWebElement)).getText();
            Assert.assertEquals(actualProductName, expectedProductName, "Product name doest match");
        }
    }



    //***********Excel file
    public static List<String> getItemsListFromExcel() throws Exception, IOException, SQLException, ClassNotFoundException {
        //String path = "DataTest/SampleTestData.xlsx";
        String path = "DataTest/AutomationAmazonTest.xlsx";
        String[] myStringArray = excelReader.fileReader2(path, 0);
        for (int i = 1; i < myStringArray.length; i++)
            System.out.println(myStringArray[i] + " ");
        ArrayList<String> list = new ArrayList<String>();

        // Using add() method to add elements in array_list
        //System.out.println();
        for (int i = 0; i < myStringArray.length; i++) {
            list.add(myStringArray[i]);
            //System.out.print(list.get(i+1) + " ");
        }
        return list;
    }

    // *********** reading data from Excel file, after size() -1 is needed to end execution.
    public void checkAllProductInSearchBar() throws Exception {
        for (int i = 0; i < getItemsListFromExcel().size() - 1; i++) {
            searchBox.clear();
            searchBox.sendKeys(getItemsListFromExcel().get(i + 1));
            searchButton.click();
            String expectedKeyWord = "\"" + getItemsListFromExcel().get(i + 1) + "\"";
            String actualSearchKeyword = verifySearchedProduct.getText();
            System.out.println("Actual Text: " + actualSearchKeyword + " Verified");
            Assert.assertEquals(actualSearchKeyword, expectedKeyWord, "page not found");
        }
    }

    // Search Product
    public void searchValidProduct(String productName){
        //  searchBox.sendKeys("");
        enterValueOnElement(searchBox,productName);
        clickOnElement(searchButton);
    }
    public void selectPurellAdvancedHandSanitizer() throws InterruptedException {
        scrollDownToElement(purellAdvancedHandSanitizer);
        clickOnElement(purellAdvancedHandSanitizer);
        waitFor(5);
        clickOnElement(oneTimePurchase);
        clickOnElement(selectQty);
        clickOnElement(setQty);
        clickOnElement(addToShoppingCart);
        clickOnElement(proceedToRetailCheckout);
        waitFor(10);

    }

}
