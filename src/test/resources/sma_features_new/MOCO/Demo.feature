@MOCO_PatchOrdEndPt @MOCOdemo
Feature: Demo Scenarios for MOCO API

  @sma @DeleteAllOrders
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC10, To verify response show all orders when Get Order details is hit sort by end date asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint1>" and "<APIKey>" and "<AuthKey>"

    Examples:
      | EndPoint                                                             | EndPoint1                                                                     |APIKey                           | AuthKey                                                                    | Filter1        | Filter2       | Param3                 | Request    | Response                                                       |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all |supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/deleteAllOrdId |GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=endDate | sortOrder=asc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_EndDateAsc.json |

  @sma @VerfManagerOrderSch
  Scenario Outline: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint_TC01_To verify  manager order schedules can be retreived from Schedule DB on store basis
    Given I hit the get endpoint to retrieve the "manager order schedule for a store" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                           | APIKey                           | AuthKey                                                                    | Param                  | Response                                                                                                                                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/schedules | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | storeId:8~schedule:[\"MONDAY\",\"TUESDAY\",\"WEDNESDAY\",\"THURSDAY\",\"FRIDAY\",\"SATURDAY\",\"SUNDAY\"]~activeOrders:3~maxOrdersLimit:200 |


  @sma @GetValidateItemNotExist
  Scenario Outline: SMA-56686_TC03_[SERVICE] MOCO | GET validate item Endpoint o verify 404 -Data not found is received when post item ewhich does not exist or invalid
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=109756864"
    Then I Verify the Response Code for the following "validate item" is "404"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                             |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | description:No such element~httpResponseCode:404  |

  @sma @GetValidateItemValidBarcodePostReq
  Scenario Outline: SMA-56686_TC07_[SERVICE] MOCO | GET validate item Endpoint To verify 200 success is given when valid Barcode is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=113836365"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                               |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | json-files/service/MOCO/Response/ValidateItemResp.json |

  @sma @lPatchOrdrEndPtOrderData
  Scenario Outline: SMA-56692_[SERVICE] MOCO | PATCH Orders Endpoint To Verify Patch endpt updates the order data from the system
    Given I hit the patch endpoint to retrieve the "PATCH Orders Endpoint" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and Request file "<Request>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Request                                         | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/1295 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/PatchOrder.json | message:Record updated Succesfully |

@sma @getOrder
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC03, To verify 200 - Order details received
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "get Orders for an items" is "200"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                           | APIKey                           | AuthKey                                                                    | Param                  | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/3114 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | orderId:3114 |

  @sma @ddelVerfMOCODeleteOrdr
  Scenario Outline: SMA-56694_SERVICE_MOCO_DELETE Order Endpoint_TC01_To Verify delete order endpt deletes the order data from the system
    Given I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>"
    Then I Verify the Response Code for the following "<Item>" is "204"
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Request    | Response |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/3114 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | "//gfdgdf" | null |

  @sma @stsVerfCreateManagerOrder
  Scenario Outline: SMA-56688_TC01_[SERVICE] MOCO | POST Order Endpoint_To verify 201 Reponse fro Create manager Order works successfully
    Given I hit the post endpoint to retrieve the "Create manager order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "<ItemDedails>"
    Then I Verify the Response Code for the following "Create manager order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                           |ItemDedails                                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:Order created successfully |itemNumber=113836365,inStoreDate=runtimedate+180|

 @sma @wwCreateManagerOrder
  Scenario Outline: SMA-56688_TC01_[SERVICE] MOCO | POST Order Endpoint_To verify 201 Reponse fro Create manager Order works successfully
    Given I hit the post endpoint to retrieve the "Create manager order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "Create manager order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:Order created successfullyyyy |

  @sma @GetValidateItemIncorrctURL @wwCreateManagerOrder
  Scenario Outline: SMA-56686_TC02_[SERVICE] MOCO | GET validate item Endpoint To verify  400 - Bad request is received when post Order details is hit incorrect url details
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "validate item" is "401"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7hj | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:0,errorMessage:10 |
