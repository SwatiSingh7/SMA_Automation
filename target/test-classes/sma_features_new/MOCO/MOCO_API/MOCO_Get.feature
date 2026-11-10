@MOCO_POST
#get  Manager or Customer  orders
Feature: SMA-56690_SERVICE_MOCO_GET

  @sma @VerfManagerOrderIncorrectDetls
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC01 To verify Manager or Customer  orders details are retreived after hitting Get Orders endpts for an Item
    Given I hit the post endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param1>" and "<Param2>" and Request file "<Request>"
    Then I Verify the Response Code for the following "get Orders for an items" is "200"
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param1                 | Param2    | Request                                                    | Response                                            |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | dryRun=no | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:Order created successfully |

  @sma @VerfManagerOrder
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC02, To verify  404 - Bad request is received when Get Order details is hit incorrect url details
    Given I hit the post endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param1>" and "<Param2>" and Request file "<Request>"
    Then I Verify the Response Code for the following "get Orders for an items" is "400"
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                              | APIKey                           | AuthKey                                                                    | Param1                 | Param2    | Request                                                    | Response                                            |
      | msupplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | dryRun=no | json-files/service/MOCO/Request/CreateManagerOrderReq.json | json-files/service/MOCO/Response/getOrdersResp.json |

  @sma @ddVerfManagerOrder
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC01, To verify Manager or Customer  orders details are retreived after hitting Get Orders endpts for an Item
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Filter1    | Filter2       | Param3                 | Request | Response                                            |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=qty | sortOrder=asc | orderType=managerorder | gfdgdf  | json-files/service/MOCO/Response/getOrdersResp.json |

  @sma @VerfManagerOrderOrderIdNotExist
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC03, To verify 404 -Data not found is received when Get Order details is hit for order ID which does not exist or not created
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "get Orders for an items" is "200"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                           | APIKey                           | AuthKey                                                                    | Param                  | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/3114 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | orderId:3114 |

  @sma @getOrderItemNotFound
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC05, To verify 404 error is received when Get Order details is hit when Item is not found.
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and "<itemNumber>"
    Then I Verify the Response Code for the following "get Orders for an items" is "404"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Param                  | itemNumber | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | 107706880  | errorCode:0,errorMessage:10 |

  @sma @getOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC06, To verify response  is received when Get Order details is hit when when image url is null
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "get Orders for an items" is "404"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Param                  | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | errorCode:0,errorMessage:10 |

  @sma @getOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC07, To verify response  is received when Get Order details is hit for an Orderid
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<Param>" and "<AuthKey>"
    Then I Verify the Response Code for the following "get Orders for an items" is "200"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Param                  | Response |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | //dscds  |

  @sma @getOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC08, To verify response show all orders when Get Order details is hit sort by start date asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Filter1          | Filter2       | Param3                 | Request    | Response                                                         |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=startDate | sortOrder=asc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_StartDateAsc.json |

  @sma @getOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC09, To verify response show all orders when Get Order details is hit sort by start date desc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Filter1          | Filter2        | Param3                 | Request    | Response                                                          |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=startDate | sortOrder=desc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_StartDateDesc.json |

  @sma @wweegetOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC10, To verify response show all orders when Get Order details is hit sort by end date asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Filter1        | Filter2       | Param3                 | Request    | Response                                                       |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=endDate | sortOrder=asc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_EndDateAsc.json |

  @sma @qqgetOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC11, To verify response show all orders when Get Order details is hit sort by end date desc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Filter1          | Filter2        | Param3                 | Request    | Response                                                        |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=startDate | sortOrder=desc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_EndDateDesc.json |

  @sma @oogetOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC12, To verify response show all orders when Get Order details is hit sort by qty asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Filter1    | Filter2       | Param3                 | Request | Response                                            |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=qty | sortOrder=asc | orderType=managerorder | gfdgdf  | json-files/service/MOCO/Response/getOrdersResp.json |

  @sma @getOrderImageURLNull
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC13, To verify response show all orders when Get Order details is hit  when no sort order specified, will sort by start date
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

  Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Filter1          | Filter2        | Param3                 | Request    | Response                                            |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=startDate | sortOrder=desc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp.json |