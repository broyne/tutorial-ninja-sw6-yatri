package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ShoppingCartPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartHeading;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNames;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    public WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[@class='text-left'][2]")
    WebElement modelName;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]")
    WebElement totalPrice;

    public String getShoppingCartHeading() {
        return getTextFromElement(shoppingCartHeading);
    }
    public String getProductName() {
        return getTextFromElement(productName);
    }

    public String getModelName() {
        return getTextFromElement(modelName);
    }

    public String getTotalPrice() {
        WebElement toRightOf = driver.findElement(RelativeLocator.with(By.xpath("//td[@class='text-right']")).toRightOf(By.xpath("//strong[normalize-space()='Total:']")));
        return getTextFromElement(toRightOf);
    }

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String getProductsName() {
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        log.info("Get delivery date" + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        return getTextFromElement(model);
    }

    public String getTotal() {
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        clearText(qtyField);
        sendTextToElement(qtyField, qty);

    }

    public void clickOnQtyUpdateButton() {
        clickOnElement(qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() {
       return getTextFromElement(successModifiedMessage);
    }
}
