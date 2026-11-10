@MOCO_Delete
Feature: SMA-56694_SERVICE_MOCO_DELETE Order Endpoint

  @sma @VerfMOCODeleteOrdr
  Scenario Outline: SMA-56694_SERVICE_MOCO_DELETE Order Endpoint_TC01_To Verify delete order endpt deletes the order data from the system
    Given I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>"
    Then I Verify the Response Code for the following "<Item>" is "204"
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Request    | Response |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/1295 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | "//gfdgdf" | null |

  @sma @VerfMOCODeleteOrdr
  Scenario Outline: SMA-56694_SERVICE_MOCO_DELETE Order Endpoint_TC02_To Verify error 400 should be displayed  if delete end pt url is entered incorrectly
    Given I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>"
    Then I Verify the Response Code for the following "deletes order data" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                            | APIKey                           | AuthKey                                                                    | Request    | Response |
      | managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | "//gfdgdf" | //jjhuhu |

  @sma @VerfMOCODeleteOrdr
  Scenario Outline: SMA-56694_SERVICE_MOCO_DELETE Order Endpoint_TC03_To Verify error 404  should be displayed  if delete end pt is hit for  order ID which is already been permanently delete or not existed
    Given I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>"
    Then I Verify the Response Code for the following "deletes order data" is "404"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Request    | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/1294 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | "//gfdgdf" | errorCode:0,errorMessage:10 |

  @sma @VerfMOCODeleteOrdrDBDown
  Scenario Outline: SMA-56694_SERVICE_MOCO_DELETE Order Endpoint_TC04_To Verify error 500  should be displayed  if delete end pt is hit for order ID when manager order service is down or DB is down
    Given I hit the get endpoint to retrieve the "get order data" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>"
    Then I Verify the Response Code for the following "deletes order data" is "500"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                            | APIKey                           | AuthKey                                                                    | Request    | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/137 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | "//gfdgdf" | errorCode:0,errorMessage:10 |