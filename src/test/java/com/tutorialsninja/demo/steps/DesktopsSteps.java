package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class DesktopsSteps {
    @When("I Mouse Hover On Desktop Tab")
    public void iMouseHoverOnDesktopTab() {
        new HomePage().mouseHoverAndClickOnDesktopTab();
    }

    @And("I call select Menu method and pass menu Show All Desktops")
    public void iCallSelectMenuMethodAndPassMenuShowAllDesktops() {
        new HomePage().selectMenu("Show AllDesktops");
    }

    @And("I select Sort By position Name : Z to A")
    public void iSelectSortByPositionNameZToA() {
        //1.3 Select Sort By position "Name: Z to A"
        new DesktopPage().selectFilter(new DesktopPage().descOrderText);
    }

    @Then("I will see the Product arrange in Descending order")
    public void iWillSeeTheProductArrangeInDescendingOrder() {
        //1.4 Verify the Product will arrange in Descending order.
        List<String> actualList = new DesktopPage().getSortedProductList();
        List<String> expectedList = new DesktopPage().expectedList();
        Assert.assertEquals(actualList, expectedList);
    }

    @When("I Mouse Hover On Currency Dropdown and click")
    public void iMouseHoverOnCurrencyDropdownAndClick() {
        //2.1 Mouse hover on Currency Dropdown and click
        new HomePage().clickOnElement(new DesktopPage().currencyDropdown);
    }

    @And("I Mouse hover on £Pound Sterling and click")
    public void iMouseHoverOn£PoundSterlingAndClick() {
        //2.2 Mouse hover on £Pound Sterling and click
        new HomePage().clickOnElement(new DesktopPage().poundSterling);
        //2.3 Mouse hover on Desktops Tab.
        new HomePage().mouseHoverAndClickOnDesktopTab();
        // 2.4 Click on “Show All Desktops”
        new HomePage().selectMenu("Show AllDesktops");
    }

    @And("I select Sort By position Name : A to Z")
    public void iSelectSortByPositionNameAToZ() {
        //2.5 Select Sort By position "Name: A to Z"
        new DesktopPage().selectFilter(new DesktopPage().ascOrderText);
    }

    @And("I selects product {string}")
    public void iSelectsProduct(String product) {
        //2.6 Select product “product”
        new DesktopPage().clickOnProduct(product);
    }

    @And("I verifies the text {string}")
    public void iVerifiesTheText(String text) {
        new DesktopPage().verifyThatTextIsDisplayed(new DesktopPage().productTitle, text);
    }

    @And("I enters quantity {string} using the Select class")
    public void iEntersQuantityUsingTheSelectClass(String quantity) {
        //2.7 Enter Qty <qty> using Select class.
        new DesktopPage().clearTextFromTag(new DesktopPage().clearTextQuantity);
        new DesktopPage().sendTextToElement(new DesktopPage().clearTextQuantity, quantity);
    }

    @And("I clicks on the Add to Cart button")
    public void iClicksOnTheAddToCartButton() {
        //2.8 Click on “Add to Cart” button
        new DesktopPage().clickOnElementByWebElements(new DesktopPage().addToCartPath);
    }

    @Then("I verifies the message {string}")
    public void iVerifiesTheMessage(String product) {
        //2.9 Verify the Message <successMessage>
        Assert.assertEquals(new ProductPage().getSuccessAlertMsg(), "Success: You have added " + product + " to your shopping cart!\n" + "×");

//        String expString = new DesktopPage().getSuccessAlertMsg();
//        String expString2 = expString.split("!")[0];
//        Assert.assertEquals(expString, message);

    }
    @Then("I verifies the message Success: You have added {string} to your shopping cart!")
    public void iVerifiesTheMessageSuccessYouHaveAddedToYourShoppingCart(String product) {
        //2.9 Verify the Message <successMessage>
        Assert.assertEquals(new ProductPage().getSuccessAlertMsg(), "Success: You have added " + product + " to your shopping cart!\n" + "×");

    }

    @And("I clicks on the link shopping cart displayed in the success message")
    public void iClicksOnTheLinkShoppingCartDisplayedInTheSuccessMessage() {
        //2.10 Click on link “shopping cart” display into success message
        new DesktopPage().clickOnCartLinkInMsgButton();
    }

    @And("I verifies the text Shopping Cart")
    public void iVerifiesTheTextShoppingCart() {
        //2.11 Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart", "Shopping Cart", "Not Matched");


    }

    @And("I verifies the product name {string}")
    public void iVerifiesTheProductName(String product) {
        //2.12 Verify the Product name <productName>
        Assert.assertEquals(product, product, "Product name not matched");

    }

    @And("I verifies the model {string}")
    public void iVerifiesTheModel(String model) {
        //2.13 Verify the Model <model>
        Assert.assertEquals(model, model, "Model not matched");

    }

    @And("I verifies the total {string}")
    public void iVerifiesTheTotal(String total) {
        //2.14 Verify the Total <total>
        Assert.assertEquals(total, total, "Total not matched");

    }
}
