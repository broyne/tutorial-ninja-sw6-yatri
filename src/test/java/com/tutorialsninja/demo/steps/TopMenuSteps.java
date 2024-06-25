package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TopMenuSteps {
    @When("I Mouse Hover and click on On Desktop Tab")
    public void iMouseHoverAndClickOnOnDesktopTab() {
        new HomePage().mouseHoverAndClickOnDesktopTab();
    }

    @And("I can call select Menu method and pass menu Show All Desktops")
    public void iCanCallSelectMenuMethodAndPassMenuShowAllDesktops() {
        new HomePage().selectMenu("Show AllDesktops");
    }

    @Then("I should navigate Successfully on Desktops Page")
    public void iShouldNavigateSuccessfullyOnDesktopsPage() {
        String expectedDesktop = "Desktops";
        String actualDesktop = new DesktopPage().getDesktopsText();
        Assert.assertEquals(actualDesktop,expectedDesktop);
    }

    @When("I Mouse Hover and click On Laptops & Notebooks Tab")
    public void iMouseHoverAndClickOnLaptopsNotebooksTab() {
        new HomePage().mouseHoverOnLaptopsAndNotebooksLinkAndClick();
    }

    @And("I can call select Menu method and pass menu Show All Laptops & Notebooks")
    public void iCanCallSelectMenuMethodAndPassMenuShowAllLaptopsNotebooks() {
        new HomePage().selectMenu("Show AllLaptops & Notebooks");
    }

    @Then("I should navigate Successfully on Laptops & Notebooks Page")
    public void iShouldNavigateSuccessfullyOnLaptopsNotebooksPage() {
        String expectedLaptopsNotebooks = "Laptops & Notebooks";
        String actualLaptopsNotebooks = new LaptopsAndNotebooksPage().getLaptopsAndNotebooksText();
        Assert.assertEquals(actualLaptopsNotebooks,expectedLaptopsNotebooks);
    }

    @When("I Mouse Hover and click On Components Tab")
    public void iMouseHoverAndClickOnComponentsTab() {
        new HomePage().mouseHoverOnComponentLinkAndClick();
    }

    @And("I can call select Menu method and pass menu Show All Components")
    public void iCanCallSelectMenuMethodAndPassMenuShowAllComponents() {
        new HomePage().selectMenu("Show AllComponents");
    }

    @Then("I should navigate Successfully on Components Page")
    public void iShouldNavigateSuccessfullyOnComponentsPage() {
        String expectedCom = "Components";
        String actualCom = new ComponentsPage().getComponentsText();
        Assert.assertEquals(actualCom,expectedCom);
    }
}
