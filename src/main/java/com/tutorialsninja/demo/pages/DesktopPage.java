package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());

    public String descOrderText = "Name (Z - A)";
    public String ascOrderText = "Name (A - Z)";

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByOptions;

    @CacheLookup
    @FindBy(xpath = "//div[@class='caption']//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div[1]/div[2]/h1")
    public WebElement productTitle;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    public WebElement selectOptionHP;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    public WebElement clearTextQuantity;

    @CacheLookup
    @FindBy(id = "button-cart")
    public WebElement addToCartPath;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='HP LP3065']")
    public WebElement HPLPText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement HPLPSuccessText;

    @CacheLookup
    @FindBy(linkText = "shoppingCart")
    public WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//body/div/div/div/h1[1]")
    public WebElement shoppingCartMessage;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    public WebElement actualHPText;

    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    public WebElement productMessage;

    @CacheLookup
    @FindBy(xpath = "(//td[contains(text(),'£74.73')])[4]")
    public WebElement totPrice;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    public WebElement currencyDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    public WebElement poundSterling;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successAlertMsg;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement cartLinkInMsg;


    public String getDesktopsText() {
        // Report and Logs
        log.info("Getting desktop text " + desktopsText.toString());
        return getTextFromElement(desktopsText);
    }

    public void sortByProducts(String orderByText){
        System.out.println(orderByText);
        log.info("Select text from visible text in " + orderByText + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, orderByText);
    }

    public List<String> verifyProductOrder(){
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement productName : getListOfElements(productsList)) {
            actualProductNames.add(productName.getText());
        }
        log.info("Product list before sorting " + actualProductNames.toString());
        return actualProductNames;
    }

    public List<String> reverseProductOrder(List<String> actualProductNames){
        List<String> expectedProducts = new ArrayList<>(actualProductNames);
        expectedProducts.sort(Collections.reverseOrder());
        actualProductNames.sort(Collections.reverseOrder());
        // Report and Log
        log.info("Product list after sorting " + expectedProducts.toString());
        return expectedProducts;
    }

    public void clickOnElementByWebElements(WebElement element){
        clickOnElement(element);
        log.info("Clicked on element " + element.toString());
    }

    //Get text method
    public String getVerificationText(WebElement element) {
        log.info("Get text from the particular element " + element.toString());
        return getTextFromElement(element);
    }

    public void clearTextFromTag(WebElement element){
        clearText(element);
        // Reports and Log
        log.info("Clear text from element " + element.toString());
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        clickOnElement(shoppingCartLink);
        // Reports and Log
        log.info("Clicked on shopping cart link from message" + shoppingCartLink.toString());
    }

    public void clickOnProduct(String product) {
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equalsIgnoreCase(product)) {
                e.click();
                break;
            }
        }
        log.info("Clicked on product " + product.toString());

    }

    public String getSuccessAlertMsg() {
        log.info("Get success alert message  " + successAlertMsg.toString());
        return getTextFromElement(successAlertMsg);

    }

    public void clickOnCartLinkInMsgButton() {
        clickOnElement(cartLinkInMsg);
        log.info("Click on cart link from success message  " + cartLinkInMsg.toString());
    }

    public void selectFilter(String text) {
        selectByVisibleTextFromDropDown(sortBy, text);
        log.info("Select option product sorted by " + text + "from sort by options " + sortByOptions.toString());
    }

    public ArrayList expectedList() {

        List<WebElement> products = productsList;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        log.info("Expected Product List  " + productsList.toString());
        return originalProductsName;
    }

    public ArrayList getSortedProductList() {

        Collections.reverse(expectedList());
        List<WebElement> products = productsList;

        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        log.info("After sorting product list  " + productsList.toString());
        return afterSortByZToAProductsName;
    }
}
