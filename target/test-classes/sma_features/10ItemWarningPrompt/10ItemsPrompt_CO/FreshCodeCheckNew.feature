@New10Item_FreshCodeCheck @regression
Feature: Verify 10 Item Warning Prompt Message.

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "Fresh Code Check" on Home Page
    Then I click on "Pre-Opening Clearance Bay Checks" on Fresh Code Check Page
    And I search for "<minID1>"
    And I select "Wastage" from the dropdown
    And I enter the desired quantity "<quantity>"
    And I click on Log Product
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1     |quantity |  message                                                                                                |
      #####MIN######
      | 105683021  | 10      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      | 105683021  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
      | 102370651  | 99      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 99 units is correct.|
      ####PIN######
#      | 111119434  | 10      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      | 108614160  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      | 105548101  | 99      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 99 units is correct.|




  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "Fresh Code Check" on Home Page
    Then I click on "Pre-Opening Clearance Bay Checks" on Fresh Code Check Page
    And I search for "<minID1>"
    And I select "Wastage" from the dropdown
    And I enter the desired quantity "<quantity>"
    And I click on Log Product

    Examples:
      | minID1     | quantity  |
      | 103029869  | 9         |



  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 02    | 00   | pm       |


  @sma
   Scenario Outline: Displays 10 item Warning Prompt Message for Store Close, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "Fresh Code Check" on Home Page
    Then I click on "Store Close Clearance Bay Checks" on Fresh Code Check Page
    And I search for "<minID1>"
    And I select "Wastage" from the dropdown
    And I enter the desired quantity "<quantity>"
    And I click on Log Product
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity |  message                                                                                                |
      #####MIN######
      | 105236511  | 10      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      | 105683021  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
      | 102370651  | 99      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 99 units is correct.|
      ###PIN######
#      | 111119434  | 10      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
#      | 108614160  | 11      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 11 units is correct.|
#      | 105548101  | 99      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 99 units is correct.|



  @sma
  Scenario Outline: Displays No any Warning Prompt Message, when entered quantity is less than 10.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "Fresh Code Check" on Home Page
    Then I click on "Store Close Clearance Bay Checks" on Fresh Code Check Page
    And I search for "<minID1>"
    And I select "Wastage" from the dropdown
    And I enter the desired quantity "<quantity>"
    And I click on Log Product

    Examples:
      | minID1     | quantity  |
      | 103029869  | 9         |
#      | 102370651  | 1         |


  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message for Code Alerts, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "Fresh Code Check" on Home Page
    Then I click on "Code Alerts" on Fresh Code Check Page
    Then I select an "<minID1>" from the list
    And I select "Wastage" from the dropdown on code alert
    And I enter the desired quantity "<quantity>" on code alert
    And I click on Log Product
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1 |   quantity |  message                                                                                                |
      #####MIN######
      | 104989458  | 10      |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|

  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message for Daily Schedule, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "Fresh Code Check" on Home Page
    Then I click on "Daily Schedule" on Fresh Code Check Page
    Then I click on product on Fresh Code Check Page and click on daily checks
         |Mon 22nd August|
    Then I click on "<location>" on select check page
    Then I click on "<Daily_Checks>" on daily checks Page
    And I click on "<aisle>"
    And I click on Bought In Breads
    And I search for "<minID1>"
    And I select "Wastage" from the dropdown
    And I enter the desired quantity "<quantity>"
    And I click on Log Product
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | aisle        | minID1   |location  |   Daily_Checks |quantity |  message                                                                                           |
      #####MIN######
     | Aisle 0 | 104989458  | First Check|   Fixture     |10       |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|


  @sma
  Scenario Outline: Displays 10 item Warning Prompt Message for Daily Schedule, when entered quantity is 10 or more.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "Fresh Code Check" on Home Page
    Then I click on "Daily Schedule" on Fresh Code Check Page
    Then I click on product on Fresh Code Check Page and click on daily checks
      |Mon 22nd August|
    Then I click on "<location>" on select check page
    Then I click on "<Daily_Checks>" on daily checks Page
    And I search for "<minID1>"
    And I select "Wastage" from the dropdown
    And I enter the desired quantity "<quantity>"
    And I click on Log Product
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button

    Examples:
      | minID1     |location|Daily_Checks |quantity |  message                                                                                                |
      #####MIN######
      | 102370651  |First Check|Promotions  |10       |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|
      | 102370651  |First Check|Warehouse   |10       |You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|


