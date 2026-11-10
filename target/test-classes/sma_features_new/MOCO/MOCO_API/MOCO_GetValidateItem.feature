@MOCO_GetValidateItem
Feature: SMA-56686 GET validate item Endpoint

  @sma @GetValidateItemIncorrctURL
  Scenario Outline: SMA-56686_TC02_[SERVICE] MOCO | GET validate item Endpoint To verify  400 - Bad request is received when post Order details is hit incorrect url details
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "validate item" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7hj | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:0,errorMessage:10 |

  @sma @GetValidateItemNotExist
  Scenario Outline: SMA-56686_TC03_[SERVICE] MOCO | GET validate item Endpoint o verify 404 -Data not found is received when post item ewhich does not exist or invalid
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=109756864"
    Then I Verify the Response Code for the following "validate item" is "404"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                             |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | description:No such element~httpResponseCode:404  |

  @sma @GetValidateItemServiceDown
  Scenario Outline: SMA-56686_TC04_[SERVICE] MOCO | GET validate item Endpoint To verify 500 -Internal server error is received when post Order details is hit when Manageroreder services or DB is down
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "validate item" is "500"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:0,errorMessage:10 |

  @sma @GetValidateItemPINSendPostReq
  Scenario Outline: SMA-56686_TC05_[SERVICE] MOCO | GET validate item Endpoint To verify 400 error is given when PIN is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=111608060"
    Then I Verify the Response Code for the following "validate item" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                                | Response                                                                        |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:400.189.5~errorMessage:PACK scanning not supported~httpResponseCode:400 |

  @sma @GetValidateItemValidBarcodePostReq
  Scenario Outline: SMA-56686_TC07_[SERVICE] MOCO | GET validate item Endpoint To verify 200 success is given when valid Barcode is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=113836365"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                               |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | json-files/service/MOCO/Response/ValidateItemResp.json |

  @sma @GetValidateItemRestrictDeptPostReq
  Scenario Outline: SMA-56686_TC08_[SERVICE] MOCO | GET validate item Endpoint To verify 400 error is given when Item with restricted Dept is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=110202041"
    Then I Verify the Response Code for the following "validate item" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                                                        |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:400.189.1~errorMessage:Department is restricted.~httpResponseCode:400 |

  @sma @GetValidateItemRestrictPostReq
  Scenario Outline: SMA-56686_TC10_[SERVICE] MOCO | GET validate item Endpoint To verify 400 error is given when Item with restricted Item is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=106248240"
    Then I Verify the Response Code for the following "validate item" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                                                        |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:400.189.1~errorMessage:Department is restricted.~httpResponseCode:400 |

  @sma @GetValidateItemDelistedPostReq
  Scenario Outline: SMA-56686_TC11_[SERVICE] MOCO | GET validate item Endpoint To verify 400 error is given when Item with delisted Item is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=100105230"
    Then I Verify the Response Code for the following "validate item" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:400.189.2~errorMessage:delist/derange/discontinued item~httpResponseCode:400 |

  @sma @GetValidateItemDerangedPostReq
  Scenario Outline: SMA-56686_TC12_[SERVICE] MOCO | GET validate item Endpoint To verify 400 error is given when Item with deranged Item is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=100109960"
    Then I Verify the Response Code for the following "manager order data" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:400.189.2~errorMessage:delist/derange/discontinued item~httpResponseCode:400 |

  @sma @GetValidateItemDiscontdPostReq
  Scenario Outline: SMA-56686_TC13_[SERVICE] MOCO | GET validate item Endpoint To verify 400 error is given when Item with Discontinued Item is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=100105230"
    Then I Verify the Response Code for the following "manager order data" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:400.189.2~errorMessage:delist/derange/discontinued item~httpResponseCode:400 |

  @sma @GetValidateValidMINPostReq
  Scenario Outline: SMA-56686_TC15_[SERVICE] MOCO | GET validate item Endpoint To verify 200 success is given when valid MIN is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=106182332"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response file "<Response>" for item "itemNumber=106248240"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                               |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | json-files/service/MOCO/Response/ValidateItemResp.json |

  @sma @GetValidateValidInactiveMINReq
  Scenario Outline: SMA-56686_TC16_[SERVICE] MOCO | GET validate item Endpoint To verify 400 error is given when inactive Item is sent in the Manager Order Post Request Dry Run
    Given I hit the post endpoint to retrieve the "validate item" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=109756864"
    Then I Verify the Response Code for the following "manager order data" is "400"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                    |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | errorCode:400.189.2~errorMessage:delist/derange/discontinued item~httpResponseCode:400 |

  @sma @sGetValidateValidInactiveMINReq
  Scenario Outline: SMA-56686_TC17_[SERVICE] MOCO | GET validate item Endpoint Verify Manager Order Post Request Dry Run response shows correct details
    Given I hit the post endpoint to retrieve the "deletes order data" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>"
    Then I Verify the Response Code for the following "manager order data" is "200"
    And I verify the response file "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | AuthKey                                                                    | Param      | Request                                              | Response                                               |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | dryRun=yes | json-files/service/MOCO/Request/ValidateItemReq.json | json-files/service/MOCO/Response/ValidateItemResp.json |