@10Item_DelistedWasteCharity @regression
Feature: Verify 10 Item Warning Prompt Message.

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "Delisted Waste" on Other adjustment Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 109092308  | 10      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 112177169  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
      | 109092308  | 99      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 99 units is correct.|
      |112177169 | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
      |109092308  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "Delisted Waste" on Other adjustment Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 109092308  | 9         |
      | 112177169  | 1         |

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "Delisted Charity" on Other adjustment Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
       #####MIN######
      | 109092308  | 10      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 112177169  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
      | 109092308  | 99      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 99 units is correct.|
      |112177169 | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
      |109092308  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|


  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "Delisted Charity" on Other adjustment Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 109092308  | 9         |
      | 112177169  | 1         |
