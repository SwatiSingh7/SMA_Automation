@WebApplDemo
Feature: Performing action waste from stock adjustment

  @sma @nn
  Scenario: We add one product in the cart and go to the basket
    Given I launch the Browser and navigate to the application
    And I click on Groceries Fresh Food
    And I click on Fresh Fruit - Bananas
    And I select an item Tesco Organic Fair Trade Bananas 5 Pack
    #Then I verify that the item got added to the cart
