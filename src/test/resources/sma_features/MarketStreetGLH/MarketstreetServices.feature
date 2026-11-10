@market_street @regression @store_walk
Feature: Verify Market Street Gaps, Lows and Highs Services Part-4

  ############################# User stories - 106, 107 & 109 ##########################################################
  @sma
  Scenario Outline: SMA-23106_To verify create walkitem api whether creates walkitem for walktype: MarketStreetGapsHighsLows for market street product.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<products>"
    And Post Operation perform on service request
    And Verify Create walkitem service response is 201/200
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105526421 |

  @sma
  Scenario Outline: SMA-23106_To verify create walkitem api whether creates walkitem for walktype: MarketStreetGapsHighsLows for Prepack product.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<products>"
    And Post Operation perform on service request
    And Verify Create walkitem service response is 201/200
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 |

  @sma
  Scenario Outline: SMA-23106_To verify whether Restricted_locations attribute has been removed from create walkitem api
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location>"
    And Post Operation perform on service request
    Given Get request is made to Get walkItem service for store id "<storeID>" and product id "<products>"
    Then Get Operation perform on service request
    And Verify Get walkitem service response
    And I verify locations attribute is not present in create walkitem service response
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 | Counter  |

  @sma
  Scenario Outline: SMA-23106_To verify create walkitem api whether creates walkitem for walktype: MarketStreetGapsHighsLows for same market street /Prepack product.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<products>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 |

  @sma
  Scenario Outline: SMA-23106_To verify Create walkitem endpoint using incorrect access token
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get Incorrect access token
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 401
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | productId |
      | 78      | MarketStreetGapsHighsLows | 105492718 |

  @sma
  Scenario Outline: SMA-23106_To verify Create walkitem endpoint using empty access token
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get Incorrect access token
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 401
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | productId |
      | 78      | MarketStreetGapsHighsLows | 105492718 |

  @sma
  Scenario Outline: SMA-23106_To verify Create walkitem endpoint by passing empty store id
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get Incorrect access token
    Given Post request is made to Create walkitem service for store id "<storeID1>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 400,404
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | storeID1 | type                      | productId |
      | 78      |          | MarketStreetGapsHighsLows | 105492718 |

  @sma
  Scenario Outline: SMA-23106_To verify Create walkitem endpoint by passing empty storewalk
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get Incorrect access token
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<productId>" and empty storewalk
    And Post Operation perform on service request
    And Verify service response code is 400,404
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | productId |
      | 78      | MarketStreetGapsHighsLows | 105492718 |

  @sma
  Scenario Outline: SMA-23106_To verify create walkitem response code with blank request payload
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 500
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | productId |
      | 78      | MarketStreetGapsHighsLows |           |

  @sma
  Scenario Outline: SMA-23106_To verify create walkitem response code with incorect request payload
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 500
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | productId |
      | 78      | MarketStreetGapsHighsLows | xxxxx     |

  @sma
  Scenario Outline: SMA-23106_To verify create walkitem response code with incorrect header
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request with Incorrect header
    And Verify service response code is 400,404
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | productId |
      | 78      | MarketStreetGapsHighsLows | 105492718 |

  @sma
  Scenario Outline: SMA-23107_To verify captures as zero (Qty=0.00) value for all (single and multiple)the items which captures does not exist or unattended item.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Verify Captures as zero value for the items
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location | value | sectionId | captureType |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 | Counter  | 0     | 0         | Low         |

  @sma
  Scenario Outline: SMA-23107_To verify Capture value and status as 'Incomplete' At Counter location
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Verify Capture value and status as 'Incomplete' At Counter location
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location | value | sectionId | captureType |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 | Counter  | 0     | 0         | Low         |

  @sma
  Scenario Outline: SMA-23107_To verify Capture value and status as 'Incomplete' At Other location
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Verify Capture value and status as 'Incomplete' At Other location
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location | value | sectionId | captureType |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 | Other    | 0     | 0         | Low         |

  @sma
  Scenario Outline: SMA-23107_To verify Capture value and status as 'Incomplete' At Backup location
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location1>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Verify Capture value and status as 'Incomplete' At Backup location
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location | location1 | value | sectionId | captureType |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 | Other    | Backup    | 0     | 0         | Low         |

  @sma
  Scenario Outline: SMA-23107_Verify Capture Audit information is persisted inline with capture
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Verify Capture Audit information is persisted inline with capture
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location | value | sectionId | captureType |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 | Counter  | 0     | 0         | Low         |

  @sma
  Scenario Outline: SMA-23109_To verify Get all captures api response if no captures at mentioned store location. It should give response code 400 with No response body
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get all capture service for store id "<storeID>"
    Then Get Operation perform on service request
    And Verify service response code is 404

    Examples:
      | storeID | type                      |
      | 78      | MarketStreetGapsHighsLows |


  @sma
  Scenario Outline: SMA-23109_To verify Get all captures api whether give response of all captures at mentioned store location
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location1>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location1>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location2>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get all capture service for store id "<storeID>"
    Then Verify Create walkitem service response is 201/200
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location1 | location2 | value | sectionId | captureType |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 104695783 | Counter   | Other     | 0     | 0         | High        |

  @sma
  Scenario Outline: SMA-23109_To verify Get all captures api whether give response of all captures including Gaps, Highs & lows at mentioned store location
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<product1>"
    And Post Operation perform on service request
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<product2>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<product1>", location "<location1>", value "<value>", section id "<sectionId>" and capture type "<captureType1>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<product2>", location "<location2>", value "<value>", section id "<sectionId>" and capture type "<captureType1>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<product1>", location "<location1>", value "<value>", section id "<sectionId>" and capture type "<captureType2>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<product2>", location "<location2>", value "<value>", section id "<sectionId>" and capture type "<captureType2>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<product1>", location "<location1>", value "<value>", section id "<sectionId>" and capture type "<captureType3>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<product2>", location "<location2>", value "<value>", section id "<sectionId>" and capture type "<captureType3>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get all capture service for store id "<storeID>"
    Then Verify service response code is 200/201
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | product1  | product2  | location1 | location2 | value | sectionId | captureType1 | captureType2 | captureType3 |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 104695783 | 105348927 | Counter   | Other     | 0     | 0         | High         | Low          | Gap          |

  @sma
  Scenario Outline: SMA-23109_To verify Get all captures api whether give response of all captures including G/L/H for any item with multiple captures at mentioned store location
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<products>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location1>", value "<value>", section id "<sectionId>" and capture type "<captureType1>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location1>", value "<value>", section id "<sectionId>" and capture type "<captureType2>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get all capture service for store id "<storeID>"
    Then Verify service response code is 200/201
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location1 | location2 | value | sectionId | captureType1 | captureType2 |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 104695783 | Counter   | Backup    | 0     | 0         | High         | Low          |


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 45   | am       |

  @sma
  Scenario Outline: SMA-23107_To verify Confirm zero captures for unattended items
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>", type "<type>" and response type "<responsetype>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" ,product id "<products>" and location "<location>"
    And Post Operation perform on service request
    Then Verify service response code is 200/201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<products>", location "<location>", value "<value>", section id "<sectionId>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    Then I verify Product captured through Api is displayed on UI in Counter & Fixture location
    And I click on Back Button
    And I click Other Location
    Then I verify Category is displayed at Other location
    And I click on Back Button
    And I click Backup Location
    Then I verify Category is displayed at Backup location
    And I click on Back Button
    And I click Review Location
    Then I verify Category is displayed at Review location
    And I click on Back Button
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID | type                      | responsetype | products  | location | value | sectionId | captureType |
      | 78      | MarketStreetGapsHighsLows | Tiny         | 105492718 | Counter  | 100   | 0         | Low         |
