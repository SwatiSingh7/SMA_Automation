@10Item_ActionWasteWastage @regression
Feature: Verify 10 Item Warning Prompt Message.


  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Damaged" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
       | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
       ####### PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Damaged" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Out of Date" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
       ######## PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Out of Date" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Charity - Damaged" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
        ######## PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Charity - Damaged" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Charity - Out of Date" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
       ######## PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Charity - Out of Date" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Withdrawal" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
       ######## PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Withdrawal" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Reverse" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
        ######## PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Waste - Reverse" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |


  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Free Fruits for Kids" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
      ######## PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Free Fruits for Kids" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |


  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Too Good To Go" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity1 |  message                                                                                                |
      #####MIN######
      | 107618329  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      |103032523  | 100     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 100 units is correct.|
#      |103029762  | 999     |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 999 units is correct.|
       ######## PIN ############
      |111119434  |    5    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      |108614160  |    12   |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 24 units is correct.|
#      |105548101  |    1    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
#      |107161082  |    2    |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 12 units is correct.|
      ######### EAN and QR ##########
      |5000241004466|10     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 106174797   |11     | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|

  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Too Good To Go" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      | minID1     | quantity1 |
      | 103029869  | 9         |
#      | 105173039  | 1         |

