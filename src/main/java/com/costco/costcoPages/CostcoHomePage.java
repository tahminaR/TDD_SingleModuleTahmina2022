package com.costco.costcoPages;

import configuration.common.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static com.costco.costoPageElements.CostcoHomePageElements.*;
import static configuration.common.GlobalReUsableMethods.*;

public class CostcoHomePage extends WebTestBase {

    @FindBy(xpath = enterProductNameInSearchBoxFieldWebElement)
    public WebElement enterProductNameInSearchBoxField;
    @FindBy(xpath = clickOnSearchButtonWebElement)
    public WebElement clickOnSearchButton;
//    @FindBy(xpath = verifySearchTextWebElement)
//    public WebElement verifySearchText;


    public void checkSearchBoxWithValidProducts(String productName) throws InterruptedException {
            // searchBox.sendKeys("");
            enterValueOnElement(enterProductNameInSearchBoxField,productName);
            waitFor(3);
            clickOnElement(clickOnSearchButton);
            waitFor(5);
    }

}
