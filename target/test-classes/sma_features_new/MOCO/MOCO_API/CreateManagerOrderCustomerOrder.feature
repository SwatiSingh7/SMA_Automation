@MOCO_POST
#Create manager Order Endpoint
Feature: SMA-56688_SERVICE_ MOCO_POST Create manager Order Endpoint

  @sma @VerfCreateManagerOrder
  Scenario Outline: SMA-56688_TC01_[SERVICE] MOCO | POST Order Endpoint_To verify 201 Reponse fro Create manager Order works successfully
    Given I hit the post endpoint to retrieve the "Create manager order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "Create manager order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:Order created successfully |

  @sma @VerfCreateCustomerOrder
  Scenario Outline: SMA-56688_TC02_[SERVICE] MOCO | POST Order Endpoint_To verify  201 response for create customer Order works successfully
    Given I hit the post endpoint to retrieve the "Create Customer order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "Create Customer order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                               | APIKey                           | Param     | AuthKey                                                                    | Request                                                     | Response                           |
      | supplychain-managercustomerorders/v1/stores/529/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateCustomerOrderReq.json | message:Order created successfully |

  @sma
  Scenario Outline: SMA-56688_TC03_[SERVICE] MOCO | POST Order Endpoint_To verify 400 response is generated if header fields are invalid or missing in post Create Endpoint
    Given I hit the post endpoint to retrieve the "Create Customer order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "Create Customer order" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | errorCode:0,errorMessage:10 |

  @sma @VerfCrtCustrOrderDateOverlap
  Scenario Outline: SMA-56688_TC04_[SERVICE] MOCO | POST Order Endpoint_To verify 409 response is generated if start date and end date of orders overlaps with the existing order date
    Given I hit the post endpoint to retrieve the "Create Customer order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "Create Customer order" is "409"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                               | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                                               |
      | supplychain-managercustomerorders/v1/stores/529/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:order already present for the given date range |

  @sma @VerfCrtCustrOrderServiceNotAvl
  Scenario Outline: SMA-56688_TC04_[SERVICE] MOCO | POST Order Endpoint_To verify 500 & 503 response is generated if order serice is temporarily unavailable
    Given I hit the post endpoint to retrieve the "create Customer order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "Create Customer order" is "500"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | errorCode:0,errorMessage:10 |