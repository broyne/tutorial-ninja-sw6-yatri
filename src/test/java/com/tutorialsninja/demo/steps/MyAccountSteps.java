package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LoginPage;
import com.tutorialsninja.demo.pages.LogoutPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyAccountSteps {
    @When("I click on my account link")
    public void iClickOnMyAccountLink() {
        new HomePage().clickOnMyAccountLink();
    }

    @And("I call the method selectMyAccountOptions method and pass the parameter {string}")
    public void iCallTheMethodSelectMyAccountOptionsMethodAndPassTheParameter(String tabName) {
        new HomePage().selectMyAccountOptions(tabName);
    }

    @Then("I should see text register account")
    public void iShouldSeeTextRegisterAccount() {
        Assert.assertEquals(new RegisterPage().getRegisterText(), "Register Account");
    }

    @Then("I should see text returning customer")
    public void iShouldSeeTextReturningCustomer() {
        Assert.assertEquals(new LoginPage().getReturningCustomerTextFromLoginPage(), "Returning Customer");

    }

    @And("I enter First Name {string}")
    public void iEnterFirstName(String firstName) {
        new RegisterPage().enterFirstName(firstName);
    }

    @And("I enter Last Name {string}")
    public void iEnterLastName(String lastName) {
        new RegisterPage().enterLastName(lastName);
    }

    @And("I enter Email {string}")
    public void iEnterEmail(String email) {
        new RegisterPage().enterEmail(email);
    }

    @And("I enter Telephone {string}")
    public void iEnterTelephone(String telephoneNumber) {
        new RegisterPage().enterTelephone(telephoneNumber);
    }

    @And("I enter Password {string}")
    public void iEnterPassword(String password) {
        new RegisterPage().enterPassword(password);
    }

    @And("I enter Confirm Password {string}")
    public void iEnterConfirmPassword(String confirmPassword) {
        new RegisterPage().enterConfirmPassword(confirmPassword);
    }

    @And("I select Subscribe Yes radio button")
    public void iSelectSubscribeYesRadioButton() {
        new RegisterPage().clickOnSubscribeRadioButton("yes");
    }

    @And("I click on Privacy Policy check box")
    public void iClickOnPrivacyPolicyCheckBox() {
        new RegisterPage().clickOnPrivacyPolicyCheckBox();
    }

    @And("I click on Continue button for registration")
    public void iClickOnContinueButtonForRegistration() {
        new RegisterPage().clickOnContinueButton();
    }

    @And("I should see the message Your Account Has Been Created!")
    public void iShouldSeeTheMessageYourAccountHasBeenCreated() {
        Assert.assertEquals(new RegisterPage().getAccountCreatedMessage(), "Your Account Has Been Created!");
    }

    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        new RegisterPage().clickOnContinue();
    }


    @And("I should see the text Account Logout")
    public void iShouldSeeTheTextAccountLogout() {
        Assert.assertEquals(new LogoutPage().getAccountLogoutText(), "Account Logout");
    }

    @And("I enter Email {string} on login page")
    public void iEnterEmailOnLoginPage(String email) {
        new LoginPage().enterEmail(email);
    }

    @And("I enter password {string} on login page")
    public void iEnterPasswordOnLoginPage(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @And("I should see My Account text")
    public void iShouldSeeMyAccountText() {
        Assert.assertEquals(new LoginPage().getMyAccountText(),"My Account");
    }
}
