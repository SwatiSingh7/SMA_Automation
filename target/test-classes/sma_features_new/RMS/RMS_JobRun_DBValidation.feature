@MOCO_RMSIntegration @MOCOdemo
Feature: MOCO integration with RMS

  @sma @RMS_DeleteAllOrders
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC10, To verify response show all orders when Get Order details is hit sort by end date asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint1>" and "<APIKey>" and "<AuthKey>"

    Examples:
      | EndPoint                                                             | EndPoint1                                                                     |APIKey                           | AuthKey                                                                    | Filter1        | Filter2       | Param3                 | Request    | Response                                                       |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all |supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/deleteAllOrdId |GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=endDate | sortOrder=asc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_EndDateAsc.json |

  @sma @cRMS_DeleteAllOrders
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC10, To verify response show all orders when Get Order details is hit sort by end date asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint1>" and "<APIKey>" and "<AuthKey>"

    Examples:
      | EndPoint                                                             | EndPoint1                                                                     |APIKey                           | AuthKey                                                                    | Filter1        | Filter2       | Param3                 | Request    | Response                                                       |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all |supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/deleteAllOrdId |GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=endDate | sortOrder=asc | orderType=customerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_EndDateAsc.json |

  @sma @uuasuccessMgrCreateOrdr
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC17_To verify  Manager order is created successfully which complies to all validations criteria
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange1>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
#    Then I verify success "<message>" for ionic
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    Then I click on Back Button till we get to the "Shop Floor - Gap Scan" page on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Stock Management Applications" page
#    And I logout of the system
    Examples:
      | Barcode   |dateRange |dateRange1  |quantity  |message                            |OrderDetails|ItemDetails|
      | 113836365 |   8       |       16   |7        |Manager order created successfully |MIN:113836365,QTY,DEPT,Created by,Start Date,End Date|Heinz Beanz Jalfrezi 390g,MIN,EAN,Case Size|
#      | 106182332 |   8       |       16   |7        |Manager order created successfully |MIN:106182332,QTY,DEPT,Created by,Start Date,End Date|Ariel Original 10 Washes 650g,MIN,EAN,Case Size|

  @sma @ssVerfCreateManagerOrder
  Scenario Outline: SMA-56688_TC01_[SERVICE] MOCO | POST Order Endpoint_To verify 201 Reponse fro Create manager Order works successfully
    Given I hit the post endpoint to retrieve the "Create manager order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=104639896"
    Then I Verify the Response Code for the following "Create manager order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:Order created successfully |

  @sma @ssVerfCreateManagerOrder
  Scenario Outline: SMA-56688_TC01_[SERVICE] MOCO | POST Order Endpoint_To verify 201 Reponse fro Create manager Order works successfully
    Given I hit the post endpoint to retrieve the "Create manager order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=106182332"
    Then I Verify the Response Code for the following "Create manager order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:Order created successfully |

  @sma @abVerfCreateCustomerOrder
  Scenario Outline: SMA-56688_TC02_[SERVICE] MOCO | POST Order Endpoint_To verify  201 response for create customer Order works successfully
    Given I hit the post endpoint to retrieve the "Create Customer order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "Create Customer order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                               | APIKey                           | Param     | AuthKey                                                                    | Request                                                     | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateCustomerOrderReq.json | message:Order created successfully |