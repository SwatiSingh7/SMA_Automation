@newCountOptimization

Feature: Verify Counts functionality for 'AM' window.

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      |    06 |   48 | am       |

  @sma @co
  Scenario Outline: Verify Manager user is able to login and create new AM schedule count in Scan mode for current date and complete all locations for the count.
    When I get login response for Count Optimization through API for "/json-files/service/countOptimization/uat_ManagerPostLogin.json"
    Given I get storewalks through Get storewalks service for current date
    Then I get list of Walkids for"<StoreID>"and Delete Count storewalkids for store id
    Then I create "<Mode>" "<Counts>" for "<StoreID>"for "/json-files/service/countOptimization/createCountAMScan.json"
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I verify all details on Homepage
    Then I click on "Stock Management Applications" and verify all the menus present on Stock Management Application Page
    Then I click on Scheduled Count Option
    Then I verify Count is visible on UI with same "<CountName>"
    Then I verify all location is visible
    Then I verify offshelf location is disabled
    Then I click on Warehouse locations
    Then I verify list of items present in Warehouse
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I click on View list of products in Warehouse
    Then I click on "Back" button
    Then I complete WareHouse location
    Then I click on Warehouse locations
    Then I verify Reopen Location is enabled  and click on Reopen Location
    Then I verify Reopen Count location alert is displayed and I click on it
    Then I complete WareHouse location

    Then I Click on Fixture location
    Then I verify list of items present in Fixture
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    Then I click on View list of products in Fixture
    Then I click on "Back" button

    Then I complete Fixture location
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
    Then I verify Add To Count ,Edit Count Button is enabled
    Then I click on Add to Count
    And I enter the quantity as "<quantity>" in Fixture
    And I Enter Product Min "104196036" and click on search

    Then I click on Edit Count
    Then I update quantity"40" and Confirm
    Then I click on "Back" button
#    And I confirm updated quantity is displayed
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
    Then I click on Edit Count
    And I click on delete button to delete the count
    And I verify Delete Count pop up is displayed
    Then I click on "Back" button

    Then I Click on Offshelf location

    Then I verify Offshelf location is enabled
    Then I click on Offshelf location
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Offshelf

    Then I click on View list of products in Offshelf
    Then I click on "Back" button
    Then I complete Offshelf location
    Then I click on Petrol location
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Petrol
    And I Enter Product Min "104479757" and click on search
#    Then I click on View list of products in Petrol
    Then I click on "Back" button
    Then I click on Petrol location

    Then I complete Petrol location
    Then I confirm to complete the count
    Then I verify count is not in TO DO tab
    Examples:
      | StoreID |Mode|CountName|Counts|quantity|
      |      2 |       Scan |AM Scan -Cross Scaning 2  6:45 TO 8:45|AM|90|

#
  @sma
  Scenario Outline: Verify Manager user is able to login and create new AM schedule count for current date and complete all locations for the count.
    When I get login response for Count Optimization through API for "/json-files/service/countOptimization/uat_ManagerPostLogin.json"
    Given I get storewalks through Get storewalks service for current date
    Then I get list of Walkids for"<StoreID>"and Delete Count storewalkids for store id
    Then I create "<Mode>" "<Counts>" for "<StoreID>"for "/json-files/service/countOptimization/createCount.json"
     When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I verify all details on Homepage
    Then I click on "Stock Management Applications" and verify all the menus present on Stock Management Application Page
    Then I click on Scheduled Count Option
    Then I verify Count is visible on UI with same "<CountName>"
    Then I verify all location is visible
    Then I verify offshelf location is disabled
    Then I click on Warehouse locations
    Then I verify list of items present in Warehouse
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I click on View list of products in Warehouse
   Then I click on "Back" button
   Then I complete WareHouse location
    Then I click on Warehouse locations
    Then I verify Reopen Location is enabled  and click on Reopen Location
    Then I verify Reopen Count location alert is displayed and I click on it
    Then I complete WareHouse location

    Then I Click on Fixture location
    Then I verify list of items present in Fixture
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    Then I click on View list of products in Fixture
    Then I click on "Back" button

   Then I complete Fixture location
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
   Then I verify Add To Count ,Edit Count Button is enabled
    Then I click on Add to Count
    And I enter the quantity as "<quantity>" in Fixture
    And I Enter Product Min "104196036" and click on search

    Then I click on Edit Count
    Then I update quantity"40" and Confirm
    Then I click on "Back" button
#    And I confirm updated quantity is displayed
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
    Then I click on Edit Count
    And I click on delete button to delete the count
    And I verify Delete Count pop up is displayed
    Then I click on "Back" button

    Then I Click on Offshelf location

    Then I verify Offshelf location is enabled
    Then I click on Offshelf location
     And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Offshelf

    Then I click on View list of products in Offshelf
    Then I click on "Back" button
    Then I complete Offshelf location
    Then I click on Petrol location
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Petrol
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in Petrol
    Then I click on View list of products in Petrol
    Then I click on "Back" button
    Then I complete Petrol location
   Then I verify count is not in TO DO tab
    Examples:
      | StoreID |Mode|CountName|Counts|quantity|
      |      2 |       List |AM List -Cross Scaning 2  6:45 TO 8:45|AM|10|


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      |    02 |   00 | pm       |
  @sma
  Scenario Outline: Verify Manager user is able to login and create new PM schedule count in Scan mode for current date and complete all locations for the count.
    When I get login response for Count Optimization through API for "/json-files/service/countOptimization/uat_ManagerPostLogin.json"
    Given I get storewalks through Get storewalks service for current date
    Then I get list of Walkids for"<StoreID>"and Delete Count storewalkids for store id
    Then I create "<Mode>" "<Counts>" for "<StoreID>"for "/json-files/service/countOptimization/createCountPMScan.json"
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I verify all details on Homepage
    Then I click on "Stock Management Applications" and verify all the menus present on Stock Management Application Page
    Then I click on Scheduled Count Option
    Then I verify Count is visible on UI with same "<CountName>"
    Then I verify all location is visible
    Then I verify offshelf location is disabled
    Then I click on Warehouse locations
    Then I verify list of items present in Warehouse
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I click on View list of products in Warehouse
    Then I click on "Back" button
    Then I complete WareHouse location
    Then I click on Warehouse locations
    Then I verify Reopen Location is enabled  and click on Reopen Location
    Then I verify Reopen Count location alert is displayed and I click on it
    Then I complete WareHouse location

    Then I Click on Fixture location
    Then I verify list of items present in Fixture
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    Then I click on View list of products in Fixture
    Then I click on "Back" button

    Then I complete Fixture location
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
    Then I verify Add To Count ,Edit Count Button is enabled
    Then I click on Add to Count
    And I enter the quantity as "<quantity>" in Fixture
    And I Enter Product Min "104196036" and click on search

    Then I click on Edit Count
    Then I update quantity"40" and Confirm
    Then I click on "Back" button
#    And I confirm updated quantity is displayed
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
    Then I click on Edit Count
    And I click on delete button to delete the count
    And I verify Delete Count pop up is displayed
    Then I click on "Back" button

    Then I Click on Offshelf location

    Then I verify Offshelf location is enabled
    Then I click on Offshelf location
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Offshelf

    Then I click on View list of products in Offshelf
    Then I click on "Back" button
    Then I complete Offshelf location
    Then I click on Petrol location
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Petrol
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in Petrol
    Then I click on View list of products in Petrol
    Then I click on "Back" button
    Then I complete Petrol location
    Then I confirm to complete the count

   Then I verify count is not in TO DO tab
    Examples:
      | StoreID |Mode|CountName|Counts|quantity|
      |      2 |       Scan |PM Scan -Count 2  2:00 TO 3:00|PM|90|



  @sma
  Scenario Outline: Verify Manager user is able to login and create new PM schedule count in List mode for current date and complete all locations for the count.Complete count should be moved to Review section.
    When I get login response for Count Optimization through API for "/json-files/service/countOptimization/uat_ManagerPostLogin.json"
    Given I get storewalks through Get storewalks service for current date
    Then I get list of Walkids for"<StoreID>"and Delete Count storewalkids for store id
    Then I create "<Mode>" "<Counts>" for "<StoreID>"for "/json-files/service/countOptimization/createPMCount.json"
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I verify all details on Homepage
    Then I click on "Stock Management Applications" and verify all the menus present on Stock Management Application Page
    Then I click on Scheduled Count Option
    Then I verify Count is visible on UI with same "<CountName>"
    Then I verify all location is visible
    Then I verify offshelf location is disabled
    Then I click on Warehouse locations
    Then I verify list of items present in Warehouse
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in WareHouse
    And I click on View list of products in Warehouse
    Then I click on "Back" button
    Then I complete WareHouse location
    Then I click on Warehouse locations
    Then I verify Reopen Location is enabled  and click on Reopen Location
    Then I verify Reopen Count location alert is displayed and I click on it
    Then I complete WareHouse location

#   Then I click on "Back" button
    Then I Click on Fixture location
    Then I verify list of items present in Fixture
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in Fixture
    Then I click on View list of products in Fixture
    Then I click on "Back" button

    Then I complete Fixture location
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
#    Then I verify Add To Count ,Edit Count Button is enabled
    Then I click on Add to Count
    And I enter the quantity as "<quantity>" in Fixture
#   Then I click on View list of products in Fixture
    And I Enter Product Min "104196036" and click on search

    Then I click on Edit Count
    Then I update quantity"490" and Confirm
       Then I click on "Back" button
##    And I confirm updated quantity is displayed
    Then I Click on Fixture location
    And I Enter Product Min "104196036" and click on search
    Then I click on Edit Count
    And I click on delete button to delete the count
    And I verify Delete Count pop up is displayed
    Then I click on "Back" button

    Then I Click on Offshelf location

    Then I verify Offshelf location is enabled
    Then I click on Offshelf location
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Offshelf

     Then I click on View list of products in Offshelf
    Then I click on "Back" button
    Then I Click on Offshelf location

    Then I complete Offshelf location
    Then I click on Petrol location
    And I Enter Product Min "104196036" and click on search
    And I enter the quantity as "<quantity>" in Petrol
    And I Enter Product Min "104479757" and click on search
    And I enter the quantity as "<quantity>" in Petrol
    Then I click on "Back" button
    Then I click on Petrol location

    Then I complete Petrol location
    Then I confirm to complete the count
    Then I verify count is not in TO DO tab
    Then I click on Review and verify count"<CountName>" is visible and status is "VIEW & EDIT"
    Then I verify all the locations are checked


    Examples:
      | StoreID |Mode|CountName|Counts|quantity|
      |      2 |       List |PM List Store 2 Dept 265 12:00 TO 03:00|PM|10|

 @sma
  Scenario Outline: User should also able to see incomplete counts in Review section once time is elapsed.
  When I get login response for Count Optimization through API for "/json-files/service/countOptimization/uat_ManagerPostLogin.json"
  Given I get storewalks through Get storewalks service for current date
   Then I get list of Walkids for"<StoreID>"and Delete Count storewalkids for store id
    Then I create "<Mode>" "<Counts>" for "<StoreID>"for "/json-files/service/countOptimization/createCount.json"
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I verify all details on Homepage

    Then I click on "Stock Management Applications" and verify all the menus present on Stock Management Application Page
    Then I click on Scheduled Count Option
    Then I verify count is not in TO DO tab
   Then I click on Review and verify count"<CountName>" is visible and status is "INCOMPLETE"
  Then I verify all the locations are unchecked


    Examples:
     | StoreID | Mode | CountName                        | Counts |
     |      2 |       List |AM List -Cross Scaning 2  6:45 TO 8:45|AM|
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
   Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
   Then I Change date
        Examples:
      | Hours | Mins | Meridiem |
      |    12|   00 | pm       |


  @sma
  Scenario Outline: Verify start time pop up should be displayed if user tries to perform action before count start time
    When I get login response for Count Optimization through API for "/json-files/service/countOptimization/uat_ManagerPostLogin.json"
    Given I get storewalks through Get storewalks service for current date
    Then I get list of Walkids for"2"and Delete Count storewalkids for store id
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I verify all details on Homepage
    Then I click on "Stock Management Applications" and verify all the menus present on Stock Management Application Page
    Then I create "<Mode>" "<Counts>" for "<StoreID>"for "/json-files/service/countOptimization/createCountPMScanAlert.json"

    Then I click on Scheduled Count Option
    Then I click on "Back" button
    Then I click on Scheduled Count Option

    Then I verify Count is visible on UI with same "<CountName>"
    Then I verify all location is visible
    Then I verify offshelf location is disabled
    Then I click on Warehouse locations
   Then  I confirm start time pop up "<alertText>" should be displayed

    Examples:
    | StoreID |Mode|CountName|Counts|alertText|
      |      2 |       Scan |PM Scan -Count 2  12:00 TO 12:30|PM|Counts cannot be started until the specified time.|


