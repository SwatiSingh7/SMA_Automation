Feature: GLH extended scenarios

  @timeChang
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |


  @sma
  Scenario Outline: Delete GLH Storewalk from Service
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype   |
      | 78      | GapsHighsLows |

  @sma
  Scenario Outline: Verify and Scan Case and Single type of MIN for all department which include different count types in AM GLH

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

#    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I verify Count Type as "<CountType>"
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service


    Then I click on WareHouse
    Then I verify my min is present in the "<Department>" or not
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button
    Then I click on Review
    Then I verify my min is present in the "<Department>"
    Then I select the "<Department>" and verify the status as ReviewReady

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus2>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus2>" in Get storewalk service


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for GapsHighsLows
    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not

    Examples:
      | StoreID | Barcode   | Category     | Department | Quantity | Typee         | captureType | captureStatus | sectionStatus | CountType      | captureStatus2 | sectionStatus2 | location | stockUOM | actionType | countTypee |
      | 78      | 104065909 | MarketStreet | Bakery     | 200      | GapsHighsLows | Low         | Incomplete    | Available     | Count in Cases | Complete       | CountComplete  | On shelf | EA       | Include    | cases      |
#		|78	|	111358136|Alcohol|Alcohol|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
#		|78	|	110995598|Health & Beauty|Health & Beauty|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
#		|78	|	111069001|Fresh|Chilled|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
#		|78	|	102370141|Breads & Cakes|Bought in Bakery|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
#		|78	|  110276411|Grocery|Grocery(Canned & Packet Goods) |KG |Singles|
#		 |      78 |105398043 | Fruit & Veg |Fruit & Veg    | 
 ##|78	|  105792809|Grocery|     200 | GapsHighsLows |Low|Incomplete|Available|Count in Cases|Complete|CountComplete|On shelf|EA|Include|cases|



  @sma
  Scenario Outline: Verify and Scan Case and Single type of MIN for all department which include different count types in PM Gaps

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "PM Gaps"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I choose the plan from popup if multiple records present
    And I click on OK
    And I verify Product is marked as GAP
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    Then I verify product is displayed as gap in Warehouse
#    Then I click on confirm count area button
#    And I click on confirm count popup
#    And I verify Section completed status is displayed


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for GapsHighsLows
    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not
	
    
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    Given Get request is made to Get storewalks service for current date
#    And Get Operation perform on service request
#    Then Verify Get storewalks service response for current date
#    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | Department  | category | Barcode   | low | Typee | stockUOM | actionType | countType |
      | 78      | Fruit & Veg | Nuts     | 105398043 | 1   | Gaps  | EA       | Include    | cases     |
      | 78      | Fruit & Veg | Fruit    | 103853612 | 1   | Gaps  | PCS      | Include    | single    |
      | 78      | Fruit & Veg | Prepared | 103854826 | 1   | Gaps  | PCS      | Include    | single    |
      | 78      | Fruit & Veg | Salads   | 102796353 | 1   | Gaps  | PCS      | Include    | single    |
      | 78      | Fruit & Veg | Salads   | 104840012 | 1   | Gaps  | PCS      | Include    | single    |
      | 78      | Fruit & Veg | Veg      | 105920250 | 1   | Gaps  | PCS      | Include    | single    |
	