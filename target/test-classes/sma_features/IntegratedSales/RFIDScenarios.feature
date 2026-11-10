@rfid
Feature: Verify RFID scenarios functionality

  #@timeChange
  #Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    #Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    #Then I Change time
    #Then I Change date
#
    #Examples: 
      #| Hours | Mins | Meridiem |
      #|    06 |   48 | am       |
#
  ################################# Post Stock movement api validations ##############################################################################
  #@sma
  #Scenario Outline: RFID_1_To verify API response is 400 Bad Request when asnId attribute is empty in Stock movement service post request body.
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #Given AsnId attribute is Empty in Stock movement Api post request body
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service is returning 400 Bad Request response
    #And Get post stock movement response
    #Then Verify by passing Empty asn id in Post Stock movement api response message returned is "<responseMessage>"
#
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage    |
      #|               101 |                   952 | 103149414 | 103222052 |  20210706 |            4 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | asnId is Mandatory |
#
  #@sma
  #Scenario Outline: RFID_2_To verify API response is 400 Bad Request when TrailerId attribute is empty in Stock movement service post request body.
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #Given TrailerId attribute is Empty in Stock movement Api post request body
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service is returning 400 Bad Request response
    #And Get post stock movement response
    #Then Verify by passing Empty Trailer id in Post Stock movement api response message returned is "<responseMessage>"
#
    #Examples: 
      #| ReceiptlocationId | ReceiptlocationId | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage        |
      #|               101 |               952 | 103149414 | 103222052 |  20210706 |            4 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | trailerId is Mandatory |
#
  #@sma
  #Scenario Outline: RFID_3_To verify API response is 400 Bad Request when ItemId,PackId,lotNumber,ReceiptedQuantity and ReceiptedQuantityType attribute is empty in Stock movement service post request body.
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #Given ItemId, PackId, lotNumber, ReceiptedQuantity and ReceiptedQuantityType attributes detail are Empty in Stock movement Api post request body
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service is returning 400 Bad Request response
    #And Get post stock movement response
    #Then Verify by passing Empty Item id in Post Stock movement api response message returned is "<responseMessage1>"
    #Then Verify by passing Empty Pack id in Post Stock movement api response message returned is "<responseMessage2>"
    #Then Verify by passing Empty lot Number in Post Stock movement api response message returned is "<responseMessage3>"
    #Then Verify by passing Empty Receipted quantity in Post Stock movement api response message returned is "<responseMessage4>"
    #Then Verify by passing Empty Receipted quantity type in Post Stock movement api response message returned is "<responseMessage5>"
#
    #Examples: 
      #| ReceiptlocationId | ReceiptlocationId | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage1    | responseMessage2    | responseMessage3       | responseMessage4               | responseMessage5                   |
      #|               101 |               952 | 103149414 | 103222052 |  20210706 |            4 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | itemId is Mandatory | packId is Mandatory | lotNumber is Mandatory | receiptedQuantity is Mandatory | receiptedQuantityType is Mandatory |
#
  #@sma
  #Scenario Outline: RFID_4_To verify API response is 400 Bad Request when OrderId, OrderType and OrderDate attribute is empty in Stock movement service post request body.
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #Given OrderId, OrderType and OrderedDate attributes detail are Empty in Stock movement Api post request body
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service is returning 400 Bad Request response
    #And Get post stock movement response
    #Then Verify by passing Empty Order id in Post Stock movement api response message returned is "<responseMessage1>"
    #Then Verify by passing Empty Order type in Post Stock movement api response message returned is "<responseMessage2>"
    #Then Verify by passing Empty Order date in Post Stock movement api response message returned is "<responseMessage3>"
#
    #Examples: 
      #| ReceiptlocationId | ReceiptlocationId | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage1     | responseMessage2       | responseMessage3         |
      #|               101 |               952 | 103149414 | 103222052 |  20210706 |            4 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | orderId is Mandatory | orderType is Mandatory | orderedDate is Mandatory |
#
  #@sma
  #Scenario Outline: RFID_5_To verify API response is 400 Bad Request when ContainerId attribute is empty in Stock movement service post request body.
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #Given ContainerId is Empty in Stock movement Api post request body
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service is returning 400 Bad Request response
    #And Get post stock movement response
    #Then Verify by passing Empty Container id in Post Stock movement api response message returned is "<responseMessage>"
#
    #Examples: 
      #| ReceiptlocationId | ReceiptlocationId | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage          |
      #|               101 |               952 | 103149414 | 103222052 |  20210706 |            4 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | containerId is Mandatory |
#
  #@sma
  #Scenario Outline: RFID_6_To verify API response is 400 Bad Request when ReceiptDate, ReceiptLocationId and ShippedFromLocationId attribute is empty in Stock movement service post request body.
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #Given ReceiptDate, ReceiptLocationId and ShippedFromLocationId attributes detail are Empty in Stock movement Api post request body
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service is returning 400 Bad Request response
    #And Get post stock movement response
    #Then Verify by passing Empty Receipt date in Post Stock movement api response message returned is "<responseMessage1>"
    #Then Verify by passing Empty Receipt location in Post Stock movement api response message returned is "<responseMessage2>"
    #Then Verify by passing Empty Shipped location in Post Stock movement api response message returned is "<responseMessage3>"
#
    #Examples: 
      #| ReceiptlocationId | ReceiptlocationId | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage1         | responseMessage2               | responseMessage3                   |
      #|               101 |               952 | 103149414 | 103222052 |  20210706 |            4 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | receiptDate is Mandatory | receiptLocationId is Mandatory | shippedFromLocationId is Mandatory |

  ################### Store pick + Receipt
  #### expected  = 90
  #@sma
  #Scenario Outline: RFID_7__To verify that Real time stock is displayed across Stock information page of SMA app, When store picks and Receipt happened on the same product for respective store.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ###### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    ####create store pick - Post transfer service
    #Given Stock transfer data is "<ReceiptlocationId>","<ReceiptlocationId>","<internal>","<isBatch>","<containerId>","<ItemNo>" and "<ReceiptedQty>"
    #When Request is made to Stock transfer api
    #Then Post operation perform on Stock transfer api
    #
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | lotNumber | ReceiptedQty |ReceiptedQty1| ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage | internal | isBatch | containerId |
      #|               101 |               952 |        100 | 106789530 | 109930391 |  20210706 |            5 | 10|CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         | false    | true    |           3 |
#
  ################ Sales record + Receipt
  #@sma
  #Scenario Outline: RFID_8_To verify that Real time stock is displayed across Stock information page of SMA app, When Sale happened on the same product for respective store.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    #### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    ##### Create a sales record - BasketV2 api
    #Given Bakset V2 data is "<ItemNo>","<ReceiptedQty>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    #When Request is made to Bakset V2 api for store id "<ReceiptlocationId>"
    #Then Post operation perform on Basket V2 api
    #And Verify Post Bakset V2 service response
   #
    #Examples: 
    #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | lotNumber | ReceiptedQty |ReceiptedQty1| ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | deptId | desc                             | deptName        | isRefund |
      #|               101 |               952 |        100 | 104317512 | 104317547 |  20210706 |            5 |20| CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR |     34 | N/F Pears 1kg + 20% Free |005 Canned Fruit | false    |
    #
        ############### Create fund + Receipt
  #@sma
  #Scenario Outline: RFID_9_To verify that Real time stock is displayed across Stock information page of SMA app, When Refund happened on the same product for respective store.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    #### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #  Create fund record - BasketV2 api
    #Given Bakset V2 data is "<ItemNo>","<refundQuantity>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    #When Request is made to Bakset V2 api for store id "<ReceiptlocationId>"
    #Then Post operation perform on Basket V2 api
    #And Verify Post Bakset V2 service response
    #
    #
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | lotNumber | ReceiptedQty |ReceiptedQty1| ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | refundQuantity | deptId | desc                    | deptName        | isRefund |
      #|               101 |               952 |        100 | 100099562 | 100184345 |  20210706 |            5 |10| CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR |             -10 |     34 | 'M'PEACH SLICES IN JUICE 410G | 005 Canned Fruit | true     |

  ##################  Stock adjustment (Waste - Damaged)  + Receipt
  #@sma
  #Scenario Outline: RFID_10_To verify that Real time stock is displayed across Stock information page of SMA app, When wastage happened on the same product for respective store.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ########## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on "<MenuOptions>"
    #Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    #Then I verify reason code "<reasoncode>" on stockAdjustment Page
    #And I click on the reason code "<reasoncode>"
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And I enter "<ReceiptedQty>" for adjustment
    #Then I click on confirm button
    #And I click on listView
    #Then I click on Submit Button
    #And I confirm Submit List
    #Then I verify scuccess "<Message>"
  
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. | 100099896 | 100906969 |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
  ##################  Stock adjustment (Transfer to Bakery)  + Receipt
  #@sma
  #Scenario Outline: RFID_11_To verify that Real time stock is displayed across Stock information page of SMA app, When inter departmental transfers(Outgoing stocks) happened on the same product for respective store.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ########## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on "<MenuOptions>"
    #Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    #Then I verify reason code "<reasoncode>" on stockAdjustment Page
    #And I click on the reason code "<reasoncode>"
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And I enter "<ReceiptedQty>" for adjustment
    #Then I click on confirm button
    #And I click on listView
    #Then I click on Submit Button
    #And I confirm Submit List
    #Then I verify scuccess "<Message>"
   
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | MenuOptions       | adjustmentCode           | reasoncode         | Message                                                      | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | 107319732 | 107319759 | Stock Adjustments | Transfer Stock To A Dept | Transfer to Bakery | All items were submitted successfully. Tap on Done to leave. |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
  ##################  Stock adjustment (Return from Bakery)  + Receipt
  #@sma
  #Scenario Outline: RFID_12_To verify that Real time stock is displayed across Stock information page of SMA app, When inter departmental transfers(Incoming stocks) happened on the same product for respective store.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ########## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on "<MenuOptions>"
    #Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    #Then I verify reason code "<reasoncode>" on stockAdjustment Page
    #And I click on the reason code "<reasoncode>"
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And I enter "<ReceiptedQty>" for adjustment
    #Then I click on confirm button
    #And I click on listView
    #Then I click on Submit Button
    #And I confirm Submit List
    #Then I verify scuccess "<Message>"
  
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | MenuOptions       | adjustmentCode            | reasoncode         | Message                                                      | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | 106458597 | 106458600 | Stock Adjustments | Transfer Back From A Dept | Return from Bakery | All items were submitted successfully. Tap on Done to leave. |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |

  #@sma
  #Scenario Outline: Delete GLH Storewalk from Service
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #Then Verify Get storewalks service response for current date
    #Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
#
    #Examples: 
      #| storeID | capturetype   |
      #|     101 | GapsHighsLows |
#
  ######### AM GLH + Receipt
  #@sma
  #Scenario Outline: RFID_13_To verify that- Stock record across stock information page is getting recalculated once AM GLH counting is done after that Receipt is generated. Once count event producer runs stock record should get calculated with the counted quantity.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ######## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #Then I click on Gaps,Low,High
    #Then I click on AM Gaps Lows High
    #Then I click on Fixture Scan
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And I click on Low button
    #And I Enter the Low quantity "<ReceiptedQty>"
    #And I choose the plan from popup if multiple records present
    #Then I verify the if it is LOW
    #And I click on Back Button
    #Then I click on WareHouse
    #Then I verify my min is present in the "<Type>" or not
    #Then I verify the if Low is displayed in warehouse
    #Then I will enter the required quantity and click on confirm
    #Then I click on Confirm Area Count
    #Then I click on Confirm message after verifying it
    #And I click on Back Button
    #And I click on Back Button
    #And I click on Back Button
#
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | Type              | ItemNo    | PackId    | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | Grocery (Cereals, Tea, Coffee, Baking & Desserts) | 107145517 | 107145525 | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. |       8082 | false    | true    |           3 |     35 | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
#@sma
  #Scenario Outline: Delete GLH Storewalk from Service
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #Then Verify Get storewalks service response for current date
    #Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
#
    #Examples: 
      #| storeID | capturetype   |
      #|     101 | MarketStreetGapsHighsLows |
#
  ######### MS GLH + Receipt
  #@sma
  #Scenario Outline: RFID_14_To verify that- Stock record across stock information page is getting recalculated once MS GLH counting is done after that receipt is generated. Once count event producer runs stock record should get calculated with the counted quantity.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ######## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #Then I click on Market Street
    #And I click Market Street Gaps,Highs,Lows
    #And I click Counter & Fixture location
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And I click on Low button
    #And I enter "<ReceiptedQty>"
    #Then I click on the Confirm Button
    #And I click on Back Button
    #And I click Other Location
    #Then I verify my min is present in the "<Department>" or not
    #And I verify "<ItemNo>" in list
    #And I click and enter "<ReceiptedQty>" for other location
    #And I click Exit Other
    #And I click on Back Button
    #And I click Backup Location
    #Then I verify my min is present in the "<Department>" or not
    #And I verify "<ItemNo>" in list
    #And I click and enter "<ReceiptedQty>"  for backup location for low
    #And I confirm count area
    #And I click on Back Button
  #
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | Department | ItemNo    | PackId    | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | Butchery  | 108533600 | 108533626 | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. |       8082 | false    | true    |           3 |     35 | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
  ############################## AMGLH + Store pick + Sale order + Receipt
  #@sma
  #Scenario Outline: RFID_15_To verify that- Stock record across stock information page is getting recalculated once AM GLH counting is done after that Store pick and Sales happened. Once count event producer runs stock record should get calculated with the counted quantity.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ########### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #Then I click on Gaps,Low,High
    #Then I click on AM Gaps Lows High
    #Then I click on Fixture Scan
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And I click on Low button
    #And I Enter the Low quantity "<ReceiptedQty>"
    #And I choose the plan from popup if multiple records present
    #Then I verify the if it is LOW
    #And I click on Back Button
    #Then I click on WareHouse
    #Then I verify my min is present in the "<Type>" or not
    #Then I verify the if Low is displayed in warehouse
    #Then I will enter the required quantity and click on confirm
    #Then I click on Confirm Area Count
    #Then I click on Confirm message after verifying it
    #And I click on Back Button
    #And I click on Back Button
    #And I click on Back Button
    ###########create store pick - Post transfer service
    #Given Stock transfer data is "<ReceiptlocationId>","<toLocation>","<internal>","<isBatch>","<containerId>","<ItemNo>" and "<ReceiptedQty>"
    #When Request is made to Stock transfer api
    #Then Post operation perform on Stock transfer api
    ########### create a sales record
    #Given Bakset V2 data is "<ItemNo>","<ReceiptedQty>","<deptId>","<desc>","<deptName>" and "<isRefund>"
    #When Request is made to Bakset V2 api for store id "<ReceiptlocationId>"
    #Then Post operation perform on Basket V2 api
    #And Verify Post Bakset V2 service response
    ############## Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
#
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | Type              | ItemNo    | PackId    | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | Grocery (Impulse) | 106458562 | 106458571 |       8082 | false    | true    |           3 |     35 | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
  #@sma
  #Scenario Outline: Verify Delete Count Storewalk service
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #Then Verify Get storewalks service response for current date
    #Then Delete request is made to Delete Count storewalk for store id "<storeID>"
#
    #Examples: 
      #| storeID | capturetype |
      #|     101 | Counts      |
#
  #@sma
  #Scenario Outline: Create Count storewalk by making call with services
    #Given Request is made to Markdown Login service
    #Then The service should return details for Login Service
    #And Get the generated accessTocken
    #Given a Store ID "<StoreID>" and name "<Name>" and items "<Items>" and "<Mode>" is included in Count StoreWalk request- List
    #When the request is made to the specified Count StoreWalk service for Store "<StoreID>"
    #Then The service should return detailsCount StoreWalk Service
    #Then I verify the json response with Count StoreWalk
#
    #Examples: 
      #| StoreID | Name                             | Items     | Mode |
       #|     101 | RFID AM Count scan Item1 | 107778031 | list |
        #
#
  ######################## AM Count + Receipt
  #@sma
  #Scenario Outline: RFID_16_To verify that - Stock record across stock information page is getting recalculated once AM Counts counting is done and receipt is generted, once count event producer runs.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #And verify that Stock section is visible
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ####### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #Then I verify that the posted counts are displayed in Warehouse
    #Then verify Min details
    #Then I will enter qty "<ReceiptedQty>"
    #Then verify that qty has been updated
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #Then I click on Fixtures Sections
    #Then I verify that the posted counts are displayed in Warehouse
    #Then verify Min details
    #Then I will enter qty "<ReceiptedQty>"
    #Then I will choose the plan from popup and enter qty
    #Then verify that qty has been updated
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #Then I click on OffShelf Sections
    #Then I select the required record
    #Then I select the Product
    #Then I will enter qty "<ReceiptedQty>"
    #Then I complete OffShelf
    #And I click on Back Button
    #Then I click on Petrol Sections
    #Then I select the required record
    #Then I select the Product
    #Then I will enter qty "<ReceiptedQty>"
    #Then I complete OffShelf
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on ReviewCount
    #Then I verify that the posted counts are displayed in Warehouse
    #Then I verify the details of the Min selected
    #Then I Confirm the Review
    #Then I verify the details of the Min selected
    #Then I Confirm the Review
    #And I click on Back Button
 #
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | Name                             | ItemNo    | PackId    | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | RFID AM Count scan Item | 107778031 | 111664521 | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. |       8082 | false    | true    |           3 |     217 | EL RASTRO SPECIALLY SELECTED 75CL | 098 Wines | false    |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
#
#
#
  #@timeChange
  #Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    #Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    #Then I Change time
    #Then I Change date
#
    #Examples: 
      #| Hours | Mins | Meridiem |
      #|    03 |   30 | pm       |
      #
       #@sma
  #Scenario Outline: Verify Delete Count Storewalk service
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #Then Verify Get storewalks service response for current date
    #Then Delete request is made to Delete Count storewalk for store id "<storeID>"
#
    #Examples: 
      #| storeID | capturetype |
      #|     101 | Counts      |
#
############################################################## Change data
  #@sma
  #Scenario Outline: Verify post Count PM services
    #Given Request is made to Markdown Login service
    #Then The service should return details for Login Service
    #And Get the generated accessTocken
    #Given a Store ID "<StoreID>" and name "<Name>" and itemOne "<Items>" and itemTwo "<Items2>" and department "<Department>" and "<Mode>" is included in Count StoreWalk request
    #When the request is made to the specified Count StoreWalk service for Store "<StoreID>"
    #Then The service should return detailsCount StoreWalk Service
    #Then I verify the json response with Count StoreWalk
    #Then I wait for Database update
#
    #Examples: 
      #| StoreID | Name                             | Items     | Items2    | Department | Mode |
      #|     101 | RFID PM Count scan Item | 109154185 | 109134635 |         12 | scan |
#
  ################### PM Count + Receipt
  #@sma
  #Scenario Outline: RFID_17_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations and receipt is generated, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify initial Stock value is "<stockValue>"
    ###### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #Then I verify that the posted counts are displayed in Warehouse
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I will enter qty "<ReceiptedQty>"
    #Then I click on ViewList
    #And I verify product in product list
    #Then I will confirm Complete count
    #And I click on Back Button
    #Then I click on Fixtures Sections
    #Then I verify that the posted counts are displayed in Warehouse
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I will enter qty "<ReceiptedQty>"
    #Then I select type from the Popup
    #Then I click on ViewList
    #And I verify product in product list
    #Then I will confirm Complete count
    #And I click on Back Button
    #Then I click on OffShelf Sections
    #Then I select the required record
    #Then I select the Product
    #Then I will enter qty "<ReceiptedQty>"
    #Then I complete OffShelf
    #And I click on Back Button
    #Then I click on Petrol Sections
    #Then I select the required record
    #Then I select the Product
    #Then I will enter qty "<ReceiptedQty>"
    #Then I complete OffShelf
    #And I click on Back Button
#
    #Examples: 
    #| ReceiptlocationId | ShippedFromLocationId | stockValue | Name                             | ItemNo    | PackId    | ItemNo1   | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | RFID PM Count scan Item | 109154185 | 109154222| 109134635 |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
    
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | Name                             | ItemNo    | PackId    | ItemNo1   | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | RFID PM Count scan Item | 107053541 | 109680011| 109077116 |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
      #################################################After job############################################################
  #
  
   #@sma
  #Scenario Outline: TC_7_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ######### Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
###### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | lotNumber | ReceiptedQty |ReceiptedQty1| ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage | internal | isBatch | containerId |
      #|               101 |               952 |        105 | 106789530 | 109930391 |  20210706 |            5 | 10|CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         | false    | true    |           3 |

      
  #@sma
  #Scenario Outline: RFID_8_To verify that Real time stock is displayed across Stock information page of SMA app, When Sale happened on the same product for respective store.
 #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ####### Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
#### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | lotNumber | ReceiptedQty |ReceiptedQty1| ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | deptId | desc                             | deptName        | isRefund |
      #|               101 |               952 |        160 | 104317512 | 104317547 |  20210706 |            10 |20| CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR |     34 | N/F Pears 1kg + 20% Free |005 Canned Fruit | false    |
    #
  #
    #@sma
  #Scenario Outline: RFID_9_To verify that Real time stock is displayed across Stock information page of SMA app, When Refund happened on the same product for respective store.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ####### Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
#### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
#
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | lotNumber | ReceiptedQty |ReceiptedQty1| ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | refundQuantity | deptId | desc                    | deptName        | isRefund |
      #|               101 |               952 |        220 | 100099562 | 100184345 |  20210706 |            10 |10| CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR |             -10 |     34 | 'M'PEACH SLICES IN JUICE 410G | 005 Canned Fruit | true     |

  
    #@sma
  #Scenario Outline: TC_10_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########## Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
####### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
#
    #Examples: 
     #| ReceiptlocationId | ShippedFromLocationId | stockValue | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | ItemNo    | PackId    | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        215 | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. | 100099896 | 100906969 |  20210706 |            10 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
  #
    #@sma
  #Scenario Outline: TC_11_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
     #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########## Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
####### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
#
    #Examples: 
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | MenuOptions       | adjustmentCode           | reasoncode         | Message                                                      | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        215 | 107319732 | 107319759 | Stock Adjustments | Transfer Stock To A Dept | Transfer to Bakery | All items were submitted successfully. Tap on Done to leave. |  20210706 |            10 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
  #
    #@sma
  #Scenario Outline: TC_12_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########### Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
######## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
#
    #Examples: 
       #| ReceiptlocationId | ShippedFromLocationId | stockValue | ItemNo    | PackId    | MenuOptions       | adjustmentCode            | reasoncode         | Message                                                      | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        225 | 106458597 | 106458600 | Stock Adjustments | Transfer Back From A Dept | Return from Bakery | All items were submitted successfully. Tap on Done to leave. |  20210706 |            10 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |

  
    #@sma
  #Scenario Outline: RFID_13_To verify that- Stock record across stock information page is getting recalculated once AM GLH counting is done after that Receipt is generated. Once count event producer runs stock record should get calculated with the counted quantity.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########### Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
######## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
    #Examples: 
     #| ReceiptlocationId | ShippedFromLocationId | stockValue | Type              | ItemNo    | PackId    | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | Deli | 107145517 | 107145525 | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. |       8082 | false    | true    |           3 |     35 | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
  #
    #@sma
  #Scenario Outline: RFID_14_To verify that- Stock record across stock information page is getting recalculated once MS GLH counting is done after that receipt is generated. Once count event producer runs stock record should get calculated with the counted quantity.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########## Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
####### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
    #Examples: 
       #| ReceiptlocationId | ShippedFromLocationId | stockValue | Department | ItemNo    | PackId    | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        180 | Butchery  | 108533600 | 108533626  | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. |       8082 | false    | true    |           3 |     35 | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |  20210706 |            10 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
    #@sma
  #Scenario Outline: TC_15_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
   #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########### Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
######## Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
    #Examples: 
   #| ReceiptlocationId | ShippedFromLocationId | stockValue | Type              | ItemNo    | PackId    | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 | Grocery (Impulse) | 106458562 | 106458571 |       8082 | false    | true    |           3 |     35 | M CONDENSED MILK FULL CREAM 397G | 004 Canned Milk | false    |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
#
  #
    #@sma
  #Scenario Outline: RFID_16_To verify that - Stock record across stock information page is getting recalculated once AM Counts counting is done and receipt is generted, once count event producer runs.
   #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########## Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
####### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
    #Examples: 
     #| ReceiptlocationId | ShippedFromLocationId | stockValue | Name                             | ItemNo    | PackId    | MenuOptions       | adjustmentCode | reasoncode      | Message                                                      | toLocation | internal | isBatch | containerId | deptId | desc                             | deptName        | isRefund | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        15 | RFID AM Count scan Item | 107778031 | 111664521 | Stock Adjustments | Wastage        | Waste - Damaged | All items were submitted successfully. Tap on Done to leave. |       8082 | false    | true    |           3 |     217 | EL RASTRO SPECIALLY SELECTED 75CL | 098 Wines | false    |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
      #
  #
    #@sma
  #Scenario Outline: RFID_17_Verify post Count PM services, To verify that When user is performing PM List mode Count for a product and completing the count for all the locations and receipt is generated, Then the stock record is getting override by the PM Count capture quantity for the same product across UI stock information page.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
   #
    ########## Receipt - Post Stock movement service
    #Given Stock movement data is ReceiptlocationId "<ReceiptlocationId>",ShippedFromLocationId "<ShippedFromLocationId>",ItemNo "<ItemNo>",PackId "<PackId>",lotNumber "<lotNumber>",ReceiptedQty "<ReceiptedQty>",ReceiptedQtyType "<ReceiptedQtyType>",OrderId "<OrderId>",OrderType "<OrderType>",StockOrderID "<StockOrderID>",ContainerID "<ContainerID>",TrailerId "<TrailerId>"
    #When Post request is made to Stock movement Api
    #And Post operation perform on Stock movement Api
    #Then Verify Post Stock movement service response
    #
     #Then I click on stock information
    #And I click on barcode entry Button
    #Then Enter "<ItemNo>" number
    #Then I get Stock value
    #And I verify updated Stock value is "<stockValue>"
    #
#
####### Stock info service
    #Given ProductId "<ItemNo>" and StoreID "<ReceiptlocationId>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #And I verify Stock value on UI and Stock info service is matched
#
    #Examples: 
    #
    #| ReceiptlocationId | ShippedFromLocationId | stockValue | Name                             | ItemNo    | PackId    | ItemNo1   | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        260 |RFID PM Count scan Item | 109154185 | 109154222| 109134635  |  20210706 |            10 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
    
      #| ReceiptlocationId | ShippedFromLocationId | stockValue | Name                             | ItemNo    | PackId    | ItemNo1   | lotNumber | ReceiptedQty | ReceiptedQtyType | OrderId | OrderType | StockOrderID                         | ContainerID | TrailerId   | responseMessage |
      #|               101 |                   952 |        100 |RFID PM Count scan Item | 107053541 | 109680011|109077116 |  20210706 |            5 | CS               | 2931328 | stock     | bcade831-827f-47d8-ba40-6fb3ce5d5aac | C19042102   | 148 OUTDOOR | CREATED         |
