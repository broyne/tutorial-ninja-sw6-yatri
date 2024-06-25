Feature: Top Menu Feature
  As a user I can check top menu tab options on homepage

  Background: I am on homepage

  @author_Yatri @sanity @smoke @regression
  Scenario: User Should Navigate To Desktops Page Successfully
    When I Mouse Hover and click on On Desktop Tab
    And I can call select Menu method and pass menu Show All Desktops
    Then I should navigate Successfully on Desktops Page

  @author_Yatri @smoke @regression
  Scenario: User Should Navigate To Laptops And Notebooks Page Successfully
    When I Mouse Hover and click On Laptops & Notebooks Tab
    And I can call select Menu method and pass menu Show All Laptops & Notebooks
    Then I should navigate Successfully on Laptops & Notebooks Page

  @author_Yatri @regression
  Scenario: User Should Navigate To Components Page Successfully
    When I Mouse Hover and click On Components Tab
    And I can call select Menu method and pass menu Show All Components
    Then I should navigate Successfully on Components Page