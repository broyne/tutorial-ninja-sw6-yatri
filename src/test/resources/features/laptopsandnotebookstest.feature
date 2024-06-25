Feature: Laptops and notebooks test Feature
  As a user I can navigate to Laptops and notebooks menu tab options on homepage

  Background: I am on homepage

  @author_Yatri @sanity @smoke @regression
  Scenario: Verify Products Price Display High To Low Successfully
    When I Mouse hover on Laptops & Notebooks Tab and click
    And I select menu "Show AllLaptops & Notebooks"
    And I select product sort by "Price (High > Low)"
    Then I will see the Product arrange in High to Low order

  @author_Yatri @smoke @regression
  Scenario: User should place order successfully
    When I mouse hover and click on currency dropdown
    And I mouse hover and click on  £ Pound Sterling
    And I mouse hover and click on laptop and notebook tab
    And I select menu "Show AllLaptops & Notebooks"
    And I select product sort by "Price (High > Low)"
    And I select product "HP LP3065" from laptop and notebook page
    And I should navigate to "HP LP3065" product
    And I click on add to cart button
    When I should see the message Success: You have added "HP LP3065" to your shopping cart!
    And I click on shopping cart link into message
    And I should see the shopping text message
    And I should see the product name "HP LP3065"
    And I change quantity "2" for product
    And I click on update quantity
    And I should see cart modified message
    And I should see the total "£149.45"
    And I click on checkout button
    And I should navigate to checkout page
    And I should see new customer text
    And I click on guest checkout button
    And I click on continue button of guest checkout page
    And I filled all mandatory field of checkout page
    And I click on continue after fill all detail on checkout page
    And I add comments to text area about product order
    And I click on continue of checkout
    And I click checkbox of terms and condition
    Then I should see warning message regarding Payment method