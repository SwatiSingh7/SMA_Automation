@integrated_sales
Feature: Integrated Sales scenarios (Scenarios --> UAT_01 to UAT_06 & UAT_17 to UAT_20)

######### Use Store number --> 101
######### To update SOH value = Upload file(File name - BlueYonder_Produce_Stocks_20210423_033104.TXT) in msit.xxwmm.stockv2.reader.eeeeeeeeee/Stockv2ReaderSOH folder

##########################################################################################################################################################
######################################## Before JOB Run ##################################################################################################

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 06    | 48   | am       |

  @sma
  Scenario Outline: Before job run -> UAT_01_To verify that Real time stock is displayed across Stock information page of SMA app, When wastage happened on the same product for respective store.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    And I click on Back Button
    And I click on Back Button
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    And I click on listView
    Then I click on Submit Button
    And I confirm Submit List
    Then I verify scuccess "<Message>"

    Examples:
      | StoreID | MenuOptions       | adjustmentCode | Barcode   | quantity | stockValue | reasoncode      | Message                                                      |
      | 101     | Stock Adjustments | Wastage        | 110864555 | 5        | 100        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. |

  @sma
  Scenario Outline: Before job run -> UAT_02_To verify that Real time stock is displayed across Stock information page of SMA app, When inter departmental transfers(Outgoing stocks) happened on the same product for respective store.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"   
     ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    And I click on Back Button
    And I click on Back Button
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    And I click on listView
    Then I click on Submit Button
    And I confirm Submit List
    Then I verify scuccess "<Message>"

    Examples:
      | StoreID | MenuOptions       | adjustmentCode           | Barcode   | quantity | stockValue | reasoncode         | Message                                                      |
      | 101     | Stock Adjustments | Transfer Stock To A Dept | 110904060 | 5        | 100        | Transfer to Bakery | All items were submitted successfully. Tap on Done to leave. |

  @sma
  Scenario Outline: Before job run -> UAT_03_To verify that Real time stock is displayed across Stock information page of SMA app, When store picks happened on the same product for respective store.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
     ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched
    
     #########create store pick - Post transfer service
    Given Stock transfer data is "<StoreID>","<toLocation>","<internal>","<isBatch>","<containerId>","<Barcode>" and "<quantity>"
    When Request is made to Stock transfer api
    Then Post operation perform on Stock transfer api

    Examples:
      | StoreID | Barcode   | quantity | stockValue | toLocation | internal | isBatch | containerId |
      | 101     | 100404563 | 5        | 100        | 8082       | false    | true    | 3           |

  @sma
  Scenario Outline: Before job run -> UAT_04_To verify that Real time stock is displayed across Stock information page of SMA app, When Sale happened on the same product for respective store.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched
     ############ Create a sales record - BasketV2 api
    Given Bakset V2 data is "<Barcode>","<quantity>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    When Request is made to Bakset V2 api for store id "<StoreID>"
    Then Post operation perform on Basket V2 api
    And Verify Post Bakset V2 service response

    Examples:
      | StoreID | Barcode   | quantity | stockValue | deptId | desc                             | deptName        | isRefund |
      | 101     | 105650042 | 5        | 100        | 35     | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |

  @sma
  Scenario Outline: Before job run -> UAT_05_To verify that Real time stock is displayed across Stock information page of SMA app, When inter departmental transfers(Incoming stocks) happened on the same product for respective store.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched
    And I click on Back Button
    And I click on Back Button
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    And I click on listView
    Then I click on Submit Button
    And I confirm Submit List
    Then I verify scuccess "<Message>"

    Examples:
      | StoreID | MenuOptions       | adjustmentCode            | Barcode   | quantity | stockValue | reasoncode         | Message                                                      |
      | 101     | Stock Adjustments | Transfer Back From A Dept | 100099298 | 5        | 100        | Return from Bakery | All items were submitted successfully. Tap on Done to leave. |

  @sma
  Scenario Outline: Before job run -> UAT_06_To verify that Real time stock is displayed across Stock information page of SMA app, When Refund happened on the same product for respective store.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
 
     ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    ########  Create fund record - BasketV2 api
    Given Bakset V2 data is "<Barcode>","<quantity>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    When Request is made to Bakset V2 api for store id "<StoreID>"
    Then Post operation perform on Basket V2 api
    And Verify Post Bakset V2 service response
    Examples:
      | StoreID | Barcode   | quantity | stockValue | deptId | desc                    | deptName        | isRefund |
      | 101     | 100099271 | -5       | 100        | 35     | 'M'EVAPORATED MILK 340G | 004 Canned Milk | true     |


  @sma
  Scenario Outline: Delete GLH Storewalk from Service
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype   |
      | 101     | GapsHighsLows |

  @sma
  Scenario Outline: Before job run -> UAT_17_To verify that- Stock record across stock information page is getting recalculated once AM GLH counting is done after that Wastage adjustment, Store pick and Sales happened. Once count event producer runs stock record should get calculated with the counted quantity.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
     ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched
    And I click on Back Button
    And I click on Back Button
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I Enter the Low quantity "<quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
    Then I verify the if Low is displayed in warehouse
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button
    And I click on Back Button
    And I click on Back Button

    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    And I click on listView
    Then I click on Submit Button
    And I confirm Submit List
    Then I verify scuccess "<Message>"
    
     ###########create store pick - Post transfer service
    Given Stock transfer data is "<StoreID>","<toLocation>","<internal>","<isBatch>","<containerId>","<Barcode>" and "<quantity>"
    When Request is made to Stock transfer api
    Then Post operation perform on Stock transfer api
	
	   ########### create a sales record
    Given Bakset V2 data is "<Barcode>","<quantity>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    When Request is made to Bakset V2 api for store id "<StoreID>"
    Then Post operation perform on Basket V2 api
    And Verify Post Bakset V2 service response

    Examples:
      | StoreID | Barcode   | quantity | stockValue | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund |
      | 101     | 107533181 | 5        | 100        | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. | 8082       | false    | true    | 3           | 35     | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |


  @sma
  Scenario Outline: Verify Delete Count Storewalk service
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete Count storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype |
      | 101     | Counts      |

  @sma
  Scenario Outline: Create Count storewalk by making call with services
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given a Store ID "<StoreID>" and name "<Name>" and items "<Items>" and "<Mode>" is included in Count StoreWalk request- List
    When the request is made to the specified Count StoreWalk service for Store "<StoreID>"
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk
    Examples:
      | StoreID | Name                             | Items     | Mode |
      | 101     | AM Count scan Item Uncounted 002 | 100099159 | list |

  @sma
  Scenario Outline: Before job run -> UAT_18_To verify that - Stock record across stock information page is getting recalculated once AM Counts counting is done, once count event producer.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
     ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched
    And I click on Back Button
    And I click on Back Button

    Then I click on Counts
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse
    Then verify Min details
    Then  I will enter qty "<quantity>"
    Then verify that qty has been updated
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button

    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse
    Then verify Min details
    Then I will enter qty "<quantity>"
    Then I will choose the plan from popup and enter qty
    Then verify that qty has been updated
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button

    Then I click on OffShelf Sections
    Then I select the required record
    Then I select the Product
    Then I will enter qty "<quantity>"
    Then I complete OffShelf
    And I click on Back Button

    Then I click on Petrol Sections
    Then I select the required record
    Then I select the Product
    Then I will enter qty "<quantity>"
    Then I complete OffShelf
    And I click on Back Button
    And I click on Back Button

    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse
    Then I verify the details of the Min selected
    Then I Confirm the Review
    Then I verify the details of the Min selected
    Then I Confirm the Review
    And I click on Back Button

    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    And I click on listView
    Then I click on Submit Button
    And I confirm Submit List
    Then I verify scuccess "<Message>"
    
     ###########create store pick - Post transfer service
    Given Stock transfer data is "<StoreID>","<toLocation>","<internal>","<isBatch>","<containerId>","<Barcode>" and "<quantity>"
    When Request is made to Stock transfer api
    Then Post operation perform on Stock transfer api
	
	   ########### create a sales record
    Given Bakset V2 data is "<Barcode>","<quantity>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    When Request is made to Bakset V2 api for store id "<StoreID>"
    Then Post operation perform on Basket V2 api
    And Verify Post Bakset V2 service response

    Examples:
      | StoreID | Name                             | Barcode   | Mode | quantity | stockValue | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund |
      | 101     | AM Count scan Item Uncounted 002 | 100099159 | list | 5        | 100        | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. | 8082       | false    | true    | 3           | 35     | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |

  @sma
  Scenario Outline: Before job run -> UAT_19_To verify that- Stock record across stock information page is getting recalculated once AM GLH counting is done after that Store pick and Sales happened. Once count event producer runs stock record should get calculated with the counted quantity.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
     ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched
    And I click on Back Button
    And I click on Back Button
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I Enter the Low quantity "<quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
    Then I verify the if Low is displayed in warehouse
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button
    And I click on Back Button
    And I click on Back Button

     ###########create store pick - Post transfer service
    Given Stock transfer data is "<StoreID>","<toLocation>","<internal>","<isBatch>","<containerId>","<Barcode>" and "<quantity>"
    When Request is made to Stock transfer api
    Then Post operation perform on Stock transfer api
	
	   ########### create a sales record
    Given Bakset V2 data is "<Barcode>","<quantity>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    When Request is made to Bakset V2 api for store id "<StoreID>"
    Then Post operation perform on Basket V2 api
    And Verify Post Bakset V2 service response

    Examples:
      | StoreID | Barcode   | quantity | stockValue | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund |
      | 101     | 101533092 | 5        | 100        | 8082       | false    | true    | 3           | 35     | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED

    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 03    | 30   | pm       |

  @sma
  Scenario Outline: Verify post Count PM services
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given a Store ID "<StoreID>" and name "<Name>" and itemOne "<Items>" and itemTwo "<Items2>" and department "<Department>" and "<Mode>" is included in Count StoreWalk request
    When the request is made to the specified Count StoreWalk service for Store "<StoreID>"
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk
    Then I wait for Database update

    Examples:
      | StoreID | Name                             | Items     | Items2    | Department | Mode |
      | 101     | PM Count scan Item Uncounted 001 | 109154185 | 109134635 | 12         | scan |


  @sma
  Scenario Outline: Before job run -> UAT_20_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify initial Stock value is "<stockValue>"
     ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched
    And I click on Back Button
    And I click on Back Button

    Then I click on Counts
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I will enter qty "<quantity>"
    Then I click on ViewList
    And I verify product in product list
    Then I will confirm Complete count
    And I click on Back Button

    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I will enter qty "<quantity>"
    Then I select type from the Popup
    Then I click on ViewList
    And I verify product in product list
    Then I will confirm Complete count
    And I click on Back Button
    Then I click on OffShelf Sections
    Then I select the required record
    Then I select the Product
    Then I will enter qty "<quantity>"
    Then I complete OffShelf
    And I click on Back Button
    Then I click on Petrol Sections
    Then I select the required record
    Then I select the Product
    Then I will enter qty "<quantity>"
    Then I complete OffShelf
    And I click on Back Button

    Examples:
      | StoreID | Name                             | Barcode   | Barcode1  | Department | Mode | quantity | stockValue |
      | 101     | PM Count scan Item Uncounted 001 | 109154185 | 109134635 | 12         | scan | 5        | 100        |
      
      ############## Pending
       #@sma
  #Scenario Outline: SMA-27151_The GLH screen will show current stock and detail break up fields for store pick/transfer/adjustment/closing stock will be hidden.
     #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Gaps,Low,High
    #Then I click on AM Gaps Lows High
    #Then I click on Fixture Scan
    #And I click on barcode entry Button
    #Then Enter "<Barcode>" number
    #And I click on Low button
   #Then I verify current stock field is displayed and detail break up fields are hidden
    #
    #Examples: 
      #| storeID | Barcode   | Type                 | Quantity | Typee         |
      #|      78 | 107514491 | Household & Pet Food |        2 | GapsHighsLows |
      
      
      
      
#####################################################################################################################################################      
######################################## After JOB Run ###############################################################################################

  @sma
  Scenario Outline: After job run -> Before job run -> UAT_01_To verify that Real time stock is displayed across Stock information page of SMA app, When wastage happened on the same product for respective store.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 110864555 | 95         |

  @sma
  Scenario Outline: After job run -> UAT_02_To verify that Real time stock is displayed across Stock information page of SMA app, When inter departmental transfers(Outgoing stocks) happened on the same product for respective store.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 110904060 | 95         |

  @sma
  Scenario Outline: After job run -> UAT_03_To verify that Real time stock is displayed across Stock information page of SMA app, When store picks happened on the same product for respective store.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 100404563 | 95         |

  @sma
  Scenario Outline: After job run -> UAT_04_To verify that Real time stock is displayed across Stock information page of SMA app, When Sale happened on the same product for respective store.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 105650042 | 95         |

  @sma
  Scenario Outline: After job run -> UAT_05_To verify that Real time stock is displayed across Stock information page of SMA app, When inter departmental transfers(Incoming stocks) happened on the same product for respective store.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 100099298 | 105        |

  @sma
  Scenario Outline: After job run -> UAT_06_To verify that Real time stock is displayed across Stock information page of SMA app, When Refund happened on the same product for respective store.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 100099271 | 105        |

  @sma
  Scenario Outline: After job run -> UAT_17_To verify that- Stock record across stock information page is getting recalculated once AM GLH counting is done after that Wastage adjustment, Store pick and Sales happened. Once count event producer runs stock record should get calculated with the counted quantity.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 107533181 | 85         |

  @sma
  Scenario Outline: After job run -> UAT_18_To verify that - Stock record across stock information page is getting recalculated once AM Counts counting is done, once count event producer.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 100099159 | 85         |

  @sma
  Scenario Outline: After job run -> UAT_19_To verify that- Stock record across stock information page is getting recalculated once AM GLH counting is done after that Store pick and Sales happened. Once count event producer runs stock record should get calculated with the counted quantity.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 101533092 | 90         |

  @sma
  Scenario Outline: After job run -> UAT_20_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I get Stock value
    And I verify updated Stock value is "<stockValue>"
    ########### Stock info service
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock value on UI and Stock info service is matched

    Examples:
      | StoreID | Barcode   | stockValue |
      | 101     | 109154185 | 95         |

