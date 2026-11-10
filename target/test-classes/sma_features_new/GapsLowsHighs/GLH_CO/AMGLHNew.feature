@NewAm_glh1_701 @regression @store_walk
Feature: Verify AM GLH Functionality

  ##################select * from space where min IN ('100002101','100162509') and store_number = 78;
  ##############TC_04_16133_To ---- space should be availabel in multipal location 100162509
########################| 109154185 | Grocery (Impulse)    |
##################| 107514491 | Household & Pet Food |
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma @bb
  Scenario Outline: Create SOH for items
    Given I create SOH for the Items based on Response code "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
    Examples:
      | storeID |
      | 65      |

  @sma @eerr
  Scenario: TC-01_Verify UI of Gaps, Count is displayed as expected or not
#    Given I create SOH for the "<Item>" based on Response code
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    #Then I click on 'ScheduledCounts' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on Back Button
    Then I click on OffShelf
    And I click on Back Button
    Then I click on Petrol
    And I click on Back Button
    Then I click on WareHouse
    And I click on Back Button
    Then I click on Review
    And I click on Back Button
    Then I click on Summary
    And I click on Back Button

  @sma
  Scenario Outline: Delete GLH Storewalk from Service and create the access token
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I get the field value for the field "access_token"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype   | reqdata                    |
      | 8       | GapsHighsLows | grant_type=getFromResponse |

  @sma
  Scenario Outline: TC_02_16131_Scan product as Gap in fixture scan and verify records are present in warehouse. Delete product from fixture and verify records are not present in warehouse.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    Then I verify the if it is GAP
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>"
    And I click on Back Button

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Section status is "<sectionStatus>" in Get storewalk service
    Then I click on Fixture Scan
    Then I click on ViewList of GapsLowHigh
    And I Delete products from fixture
#    And I click on Back Button
#    And I click on Back Button
    And I click on Back Button till we get to the "Warehouse" page
    Then I click on WareHouse
    Then I verify that record is deleted from WareHouse

    Examples:
      | storeID | Barcode   | Type                 | Quantity | Typee         | sectionStatus |
      | 8      | 107514491 | Household & Pet Food | 2        | GapsHighsLows | Available     |

  @sma @High
  Scenario Outline: TC_03_16131_Scan product as Count in fixture scan and verify records are present in warehouse. Delete product from fixture and verify records are not present in warehouse.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on dynamic "sLocatorName" "COUNT" on page 'GapsLowsHighsPO'
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    #Then I verify the if it is HIGH
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>"

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
#    Then I Verify the Response Code for the following "<Item>" is 200
#    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service
    And I click on Back Button
    Then I click on Fixture Scan
    Then I click on ViewList of GapsLowHigh
    And I Delete products from fixture
    And I click on Back Button
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    Then I verify that record is deleted from WareHouse

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         | captureType | captureStatus | sectionStatus |
      | 8       | 100162509 | Grocery (Impulse) | 2        | GapsHighsLows | Count       | Incomplete    | Available     |

  @sma @Low
  Scenario Outline: TC_04_16131_Scan product as Count in fixture scan and verify records are present in warehouse. Delete product from fixture and verify records are not present in warehouse.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on COUNT button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
#    Then I verify the if it is LOW
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>"

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
#    Then I Verify the Response Code for the following "<Item>" is 200
#    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service
    And I click on Back Button
    Then I click on Fixture Scan
    Then I click on ViewList of GapsLowHigh
    And I Delete products from fixture
    And I click on Back Button till we get to the "Warehouse" page
#    And I click on Back Button
    Then I click on WareHouse
    Then I verify that record is deleted from WareHouse

    Examples:
      | storeID | Barcode   | Type    | Quantity | Typee         | captureType | captureStatus | sectionStatus |
      | 8       | 101533092 | Alcohol | 2        | GapsHighsLows | Count           | Incomplete    | Available     |

  ####Update stockv2 ..stock_item
  ##update stock_item set updated_on='2019-12-16 09:11:25.412+00' where location_id='78' and item_id='107514491';
#  @sma @Low1
#  Scenario Outline: TC_05_16132_Scan a product as LOW. Update variance count in warehouse. Verify variance count is updated.
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    Given Get request is made to Get storewalks service for current date
#    And Get Operation perform on service request
#    Then Verify Get storewalks service response for current date
#    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
#    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
#    Then I click on "Shop Floor - Gap Scan"
#    Then I click on Fixture Scan
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    Then I capture StockRecord Value
#    And I click on dynamic "COUNT" "sLocatorName" on page 'GapsLowsHighsPO'
#    And I Enter the Low quantity "<Quantity>"
#    And I choose the plan from popup if multiple records present
#    And I will capture the product name from view list
#    Then I verify the product MIN value "<Barcode>" from view list
##    Then I verify the if it is LOW
#    And I click on Back Button
#    Then I click on WareHouse
#    Then I verify my min is present in the "<Type>" or not
##    Then I verify the if Low is displayed in warehouse
##    Then I Verify that Barcode matches with the input "<Barcode>" barcode
#    And I get the variance count previous value
#    Then I verify the Item Description
#    Then I enter Qty in Warehouse "<Quantity1>"
#    And I verify the variance count after adding quantity "<Quantity1>" value
#    And I click on Back Button
#
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    Given Get request is made to Get storewalks service for current date
#    And Get Operation perform on service request
#    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<walkType>" is present in Get storewalk service
#    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType1>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
#    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType2>" Capture status "<captureStatus>" and Capture quantity "<Quantity1>"
#    Then I verify Section status is "<sectionStatus>" in Get storewalk service
#    And I click on Back Button
#    Then I click on Fixture Scan
#    Then I click on ViewList of GapsLowHigh
#    And I Delete products from fixture
#
#    Examples:
#      | storeID | Barcode   | Type                 | Quantity | walkType      | Quantity1 | captureType1 | captureStatus | captureType2 | sectionStatus |
#      | 8       | 107514491 | Household & Pet Food | 2        | GapsHighsLows | 3         | Count        | Incomplete    | Actual       | Available     |

  @sma @High1
  Scenario Outline: TC_06_16133_Verify if product is marked as COUNT, then in view list two entries should be present.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
#    Then I verify the if it is HIGH
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    And I click on ViewList to verify that two entries are present for MIN "<Barcode>"
    And I Delete products from fixture

    Examples:
      | storeID | Barcode   | Type                 | Quantity | Quantity1 | Typee         |
      | 8      | 107514491 | Household & Pet Food | 2        | 4         | GapsHighsLows |

  ########|8| 110440154 | Grocery (Impulse)|2|4|GapsHighsLows|
  @sma @gap
  Scenario Outline: TC_07_Verify that GAP is properly generated in Fixture Scan and view list GAP status, Product name and Product min value should displayed.To verify Last capture section displaying correct information when the last capture has been taken in AM GLH and scanned as GAP.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>"
    And I click on Back Button
    Then I click on hotKey
    And I select StockInformation from the Hotkey Menu
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Last Capture Type is "<captureType>"
    And I verify Date and User details for Last capture
    And I verify Counted column and counted quantity "<countedQty>" for last capture are present
    And I click on Back Button
    And I click on Back Button

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee     | captureType | countedQty |
      | 8       | 110440154 | Grocery (Impulse) | 2        | GapsCount | AM Gap      | 0          |

  @sma @LowTry
  Scenario Outline: TC_08_Verify that COUNT is properly generated in Fixture Scan and view list LOW status, Product name and Product min value should displayed.To verify Last capture section displaying correct information when the last capture has been taken in Low and scanned as LOW.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on dynamic "sLocatorName" "COUNT" on page 'GapsLowsHighsPO'
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
#    Then I verify the if it is LOW
    And I verfify "<Barcode>" item is present
    And I click on Back Button
    Then I click on hotKey
    And I select StockInformation from the Hotkey Menu
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Last Capture Type is "<captureType>"
    And I verify Date and User details for Last capture
    And I verify Counted column and counted quantity "<verifyQuantity>" for last capture are present
    And I click on Back Button
    And I click on Back Button

    Examples:
      | storeID | Barcode   | Quantity | captureType | verifyQuantity |
      | 8       | 109154185 | 2        | Count       | 4              |
      | 8       | 100162509 | 4        | Count       | 8              |
      | 8       | 107742952 | 4        | Count       | 8              |

  @sma @High2
  Scenario Outline: TC_09_Verify that High is properly generated in Fixture Scan and view list HIGH status, Product name and Product min value should displayed. To verify Last capture section displaying correct information when the last capture has been taken in High and scanned as HIGH.
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on dynamic "sLocatorName" "COUNT" on page 'GapsLowsHighsPO'
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
#    Then I verify the if it is HIGH
    And I click on Back Button
    Then I click on hotKey
    And I select StockInformation from the Hotkey Menu
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Last Capture Type is "<captureType>"
    And I verify Date and User details for Last capture
    And I verify Counted column and counted quantity "<verifyQuantity>" for last capture are present
    And I click on Back Button
    And I click on Back Button

    Examples:
      | storeID | Barcode   | Quantity | verifyQuantity | captureType |
      | 8       | 103853612 | 3        | 6              | Count       |
      | 8       | 110440154 | 5        | 10              | Count           |

  @sma
  Scenario Outline: First scan in GLH as LOW then as HIGH/GAP , captured should override with latest Capture details in Stock information screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on dynamic "sLocatorName" "COUNT" on page 'GapsLowsHighsPO'
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
#    Then I verify the if it is LOW
    And I verfify "<Barcode>" item is present
    And I click on Back Button
    Then I click on hotKey
    And I select StockInformation from the Hotkey Menu
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Last Capture Type is "<captureType>"
    And I verify Date and User details for Last capture
    And I verify Counted column and counted quantity "<verifyQuantity>" for last capture are present
    And I click on Back Button
    And I click on Back Button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I click on Back Button
    Then I click on hotKey
    And I select StockInformation from the Hotkey Menu
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Last Capture Type is "<captureType1>"
    And I verify Date and User details for Last capture
    And I verify Counted column and counted quantity "<verifyQuantity1>" for last capture are present
    And I click on Back Button

    Examples:
      | storeID | Barcode   | Quantity | verifyQuantity | captureType | captureType1 | countedQty | verifyQuantity1 |
      | 8       | 109154185 | 2        | 4              | Count       | AM Gap       | 2          | 4               |

  @sma
  Scenario Outline: TC_10_Verify End to End, User is abel to review the product which is available in multiple locations.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify the "<Barcode>" in Scan Item
    And I click on dynamic "sLocatorName" "COUNT" on page 'GapsLowsHighsPO'
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
#    Then I verify the if it is LOW
    And I click on Back Button
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus1>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus1>" in Get storewalk service

    Given a Store ID "<StoreID>" and type "<Type1>" is included in GLH  request
    Then I click on OffShelf
    And I completed offshelf section for all the department
    And I click on Back Button
    Then I click on Petrol
    And I completed petrol section for all the department
    And I click on Back Button
    Given a Store ID "<StoreID>" and type "<Type2>" is included in GLH  request
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>"
    And I click on Back Button
    Then I click on Review
    Then I select the "<Type>" and verify the status as Pending
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
#    Then I verify the if Count is displayed in warehouse
#    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button
    Then I click on Review
    Then I verify my min is present in the "<Type>"
    Then I select the "<Type>" and verify the status as ReviewReady
    And I click on "<subcategory>" under the department
    And I click on the "<Barcode>" to update the count
    Then I select "<location>" to update
    And I update the "<Quantity>"
    Then I click on the Confirm Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus2>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus2>" in Get storewalk service

    Examples:
      | Barcode   | Type1                | Type2                | Type              | Quantity | subcategory               | location  | storeID | Typee         | gaps | captureType | captureStatus1 | captureStatus2 | sectionStatus1 | sectionStatus2 |
      | 104897086 | Kiosk Counter Sweets | Petrol Chilled Fresh | Grocery (Impulse) | 15       | Chocolate & Confectionery | Warehouse | 8       | GapsHighsLows | 1    | Count           | Incomplete     | Complete       | Available      | CountComplete  |

  ##################################  |8 | 100162509 | Grocery (Impulse) |2|
  @sma @TC_11_VerifyEndToEnd
  Scenario Outline: TC_11_Verify End to End, Verify Summary screen
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on dynamic "sLocatorName" "COUNT" on page 'GapsLowsHighsPO'
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is COUNT

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus1>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus1>" in Get storewalk service

    And I click on Back Button
    Then I click on OffShelf
    And Verify that the same record is present in Offshelf
    And enter Qty in offshelf
    And I click on Back Button
    Then I click on Petrol
    And Verify that the same record is present in Offshelf
    And enter Qty in offshelf
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>"
    And I click on Back Button
    Then I click on Review
    Then I select the "<Type>" and verify the status as Pending
    And I click on Back Button

    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
#    Then I verify the if Count is displayed in warehouse
#    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button
    Then I click on Review
    Then I verify my min is present in the "<Type>"
    Then I select the "<Type>" and verify the status as ReviewReady

    And I click on "<subcategory>" under the department
    And I click on the "<Barcode>" to update the count
    Then I select "<location>" to update
    And I update the "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus2>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus2>" in Get storewalk service
    And I click on Back Button
    Then I click on Summary
    And I click on COUNT tab in summary screen
    Then I verify text "Total" is under COUNT is "<lows>" in summary
#    Then I verify text is under Low is "<lows>" in summary

    Examples:
      | Barcode   | Type              | Quantity | subcategory               | location  | storeID | lows | Typee         | captureType | captureStatus1 | captureStatus2 | sectionStatus1 | sectionStatus2 |
      | 109154185 | Grocery (Impulse) | 14       | Water, Squash, Carbonates | Warehouse | 8       | 1    | GapsHighsLows | Count       | Incomplete     | Complete       | Available      | CountComplete  |

  @sma @TC_12_Verify_Order_QTY
  Scenario Outline: TC_12_Verify Order QTY and Delivery Qty are in sync with Stock Information
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I store Order Quantity and Delivered Quantity
    Then I click on hotKey
    And I select StockInformation from the Hotkey Menu
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I verify Order Quantity and Delivered Quantity from GLH and SI are same
    And I click on Back Button
    And I click on Back Button

    Examples:
      | Barcode   | storeID |
      | 107572771 | 8      |
      | 107514491 | 8      |
      | 101533092 | 8      |

  @sma @TC_13_Verify_Exempted_Item
  Scenario Outline: TC_13_Verify Exempted Item in GLH
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I verify "<message>" message box is displayed

    Examples:
      | Barcode   | message       |
      | 100407422 | Exempted Item |

  @timeChange @AfterTimeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 03    | 00   | pm       |

  @sma @AfterTimeChange
  Scenario Outline: After time message
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on location "<location>"
    Then I verify Error message is displayed

    Examples:
      | location     | StoreID | Typee         |
      | Fixture Scan | 8      | GapsHighsLows |
      | Off Shelf    | 8      | GapsHighsLows |
      | Petrol       | 8      | GapsHighsLows |
      | Warehouse    | 8      | GapsHighsLows |
