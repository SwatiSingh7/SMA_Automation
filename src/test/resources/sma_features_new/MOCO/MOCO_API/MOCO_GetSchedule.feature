@MOCO_GET @ScheduleEndpoint
Feature: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint

  @sma @VerfManagerOrderSch
  Scenario Outline: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint_TC01_To verify  manager order schedules can be retreived from Schedule DB on store basis
    Given I hit the get endpoint to retrieve the "manager order schedule for a store" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                           | APIKey                           | AuthKey                                                                    | Param                  | Response                                                                                                                                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/schedules | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder | storeId:8~schedule:[\"MONDAY\",\"TUESDAY\",\"WEDNESDAY\",\"THURSDAY\",\"FRIDAY\",\"SATURDAY\",\"SUNDAY\"]~activeOrders:3~maxOrdersLimit:200 |

  @sma @VerfManagerOrderForDiffSch
  Scenario Outline: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint_ TC02_To verify  manager order schedules can be retreived from Schedule DB for store which has different schedule than default schedule
    Given I hit the get endpoint to retrieve the "manager order schedule for a store" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                | APIKey                           | Param                  | AuthKey                                                                    | Response                                                                        |
      | supplychain-managercustomerorders/v1/stores/2/schedules | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | orderType=managerorder | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | schedule:[\"MONDAY\",\"WEDNESDAY\",\"FRIDAY\"]~activeOrders:0~maxOrdersLimit:10 |

  @sma @VerfManagerOrderInvalidURL
  Scenario Outline: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint_ TC03_To verify  manager order schedules throws 400 bad request due to incvalid url request
    Given I hit the get endpoint to retrieve the "manager order schedule for a store" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "manager order schedule for a store" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                            | APIKey                           | Param                  | AuthKey                                                                    | Response                    |
      | msupplychain-managercustomerorders/v1/stores/{getStoreId}/schedules | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | orderType=managerorder | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | errorCode:0,errorMessage:10 |

  @sma @VerfManagerOrderDataNotAvl
  Scenario Outline: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint_ TC04_To verify  manager order schedules throws 404 Data not found error  due to data not available in Schedule table for a particular store
    Given I hit the get endpoint to retrieve the "manager order schedule for a store" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "manager order schedule for a store" is "404"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                  | APIKey                           | Param                  | AuthKey                                                                    | Response                                                                                      |
      | supplychain-managercustomerorders/v1/stores/475/schedules | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | orderType=managerorder | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | errorMessage:No manager-order configuration found for given store,errorCode:0,errorMessage:10 |

  @sma @VerfManagerOrderInternalServErr
  Scenario Outline: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint_ TC05_To verify  manager order schedules throws 500 internal server error due to unable to connect to DB
    Given I hit the get endpoint to retrieve the "manager order schedule for a store" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "manager order schedule for a store" is "500"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                           | APIKey                           | Param                  | AuthKey                                                                    | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/schedules | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | orderType=managerorder | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | errorCode:0,errorMessage:10 |

  @sma @VerfCustomerOrderCustomerOrderSch
  Scenario Outline: SMA-56684_SERVICE_ MOCO_GET Schedule Endpoint_TC06_To verify  Customer order schedules can be retreived from Schedule DB on store basis
    Given I hit the get endpoint to retrieve the "manager order schedule for a store" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                           | APIKey                           | Param                   | AuthKey                                                                    | Response                                               |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/schedules | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | orderType=customerorder | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | storeId:8,schedule:[],activeOrders:7,maxOrdersLimit:25 |