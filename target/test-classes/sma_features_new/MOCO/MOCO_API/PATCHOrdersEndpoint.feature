@MOCO_PatchOrdEndPt
Feature: SMA-56692_[SERVICE] MOCO | PATCH Orders Endpoint

  @sma @PatchOrdrEndPtOrderData
  Scenario Outline: SMA-56692_[SERVICE] MOCO | PATCH Orders Endpoint To Verify Patch endpt updates the order data from the system
    Given I hit the patch endpoint to retrieve the "PATCH Orders Endpoint" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and Request file "<Request>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Request                                         | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/1295 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/PatchOrder.json | message:Record updated Succesfully |

  @sma @PatchOrdrEndPtOrderData
  Scenario Outline: SMA-56692_[SERVICE] MOCO | PATCH Orders Endpoint To verify  400 - Bad request is received when Get Order details is hit incorrect url details
    Given I hit the patch endpoint to retrieve the "PATCH Orders Endpoint" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and Request file "<Request>"
    Then I Verify the Response Code for the following "PATCH Orders Endpoint" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                            | APIKey                           | AuthKey                                                                    | Request                                                     | Response                                                                  |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/625 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/PatchOrderIncorrectUrl.json | test-data/json-files/service/MOCO.Response/ResPatchOrderIncorrectUrl.json |

  @sma @PatchOrdrEndPtOrderIdUpdated
  Scenario Outline: SMA-56692_[SERVICE] MOCO | PATCH Orders Endpoint To Verify error 409  should be displayed  if Patch end pt is hit for order ID which is already been Updated
    Given I hit the patch endpoint to retrieve the "PATCH Orders Endpoint" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and Request file "<Request>"
    Then I Verify the Response Code for the following "PATCH Orders Endpoint" is "409"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                            | APIKey                           | AuthKey                                                                    | Request                                                     | Response                                                |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/625 | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/PatchOrderIncorrectUrl.json | message: order already present for the given date range |

  @sma @PatchOrdrEndPtOrderDBDown
  Scenario Outline: SMA-56692_[SERVICE] MOCO | PATCH Orders Endpoint To Verify error 500  should be displayed  if Patch end pt is hit for order ID when manager order service is down or DB is down
    Given I hit the patch endpoint to retrieve the "PATCH Orders Endpoint" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and Request file "<Request>"
    Then I Verify the Response Code for the following "PATCH Orders Endpoint" is "500"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                         | APIKey                           | AuthKey           | Request                                                               | Response                                                |
      | managercustomerorders/v1/stores/{getStoreId}/orders/{getOrderid} | 1rQlOAe1PAWaWLHlShKfhhUn8rODH8AK | (Userv1 & Userv2) | test-data/json-files/service/MOCO/Request/PatchOrderIncorrectUrl.json | message: order already present for the given date range |