package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenuTabs;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLinks;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    public String currency;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    public WebElement currencyTab;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
    List<WebElement> selectMultipleElementFromDropdown;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllComponents']")
    WebElement showAllComponents;


    public void selectMenu(String menu) {
        // Reports and Log
        log.info("Select " + menu +" from " + topMenuTabs.toString());
        List<WebElement> topMenuList = topMenuTabs;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuTabs;
        }
    }

    public void mouseHoverAndClickOnDesktopTab() {
        mouseHoverToElementAndClick(desktopTab);
        log.info("Mouse hover on desktops Tab and click " + desktopTab.toString());

    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        log.info("Mouse hover on laptops and Notebooks Tab and click " + laptopsAndNotebooksLink.toString());
    }

    public void mouseHoverOnComponentLinkAndClick() {
        mouseHoverToElementAndClick(componentsLinks);
        log.info("Mouse hover on component Tab and click " + componentsLinks.toString());

    }

    public void selectMyAccountOptions(String option) {
        log.info("Selected option is " + option.toString());
        List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(myAccountOptions);
        }
    }

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
        // Reports and Log
        log.info("Click on My Account Tab and click " + myAccountTab.toString());

    }

    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                System.out.println(e.getText());
                //e.click();
                driver.findElement(By.name("GBP")).click();
                clickOnElement(By.name("GBP"));
                return;
            }
        }
        // Reports and Log
        log.info("Selected currency is " + currency.toString());
    }

    public void clickOnMyAccountLink() {
        Reporter.log("Clicking on My Account Link " + myAccountTab.toString());
        clickOnElement(myAccountTab);
        log.info("Clicking on My Account Link " + myAccountTab.toString());
    }


}
