@glh_burst
Feature: GlhBurst functionality

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma
  Scenario Outline: Delete GLH Storewalk from Service
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype   |
      | 78      | GapsHighsLows |

  @sma
  Scenario Outline: Scan products in fixture and marked as HIGH, GAP and LOW.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I will capture the product name from view list
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on barcode entry Button
    Then Enter "<Barcode2>" number
    And I click on High button
    And I Enter High quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on Back Button

    Examples:
      | Barcode   | Barcode1  | Barcode2  | Quantity |
      | 107514491 | 109154185 | 100162509 | 2        |

  @sma
  Scenario Outline: SMA-20454_To verify Get storewalk API response is correct when sent without attributes.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    Then I verify storewalk response

    Examples:
      | storeID | type          |
      | 78      | GapsHighsLows |

  @sma
  Scenario Outline: SMA-20454_To verify Get storewalk API response is correct when sent with attributes.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get storewalk service for store id "<storeID>" and attributes
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    Then I verify storewalk response

    Examples:
      | storeID | type          |
      | 78      | GapsHighsLows |

  @sma
  Scenario Outline: SMA-20454_To verify as per below mentioned values in new attribute Capturetype['High'] are excluded from the Get Storewalk API response.Capturetype[ne]=['High']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get storewalk service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And I verify Capturetype attribute is excluded from the Get Storewalk API response

    Examples:
      | storeID | type          | captureType |
      | 78      | GapsHighsLows | High        |

  @sma
  Scenario Outline: SMA-20454_To verify as per below mentioned values in new attribute Capturetype['Low'] are excluded from the Get Storewalk API response.Capturetype[ne]=['Low']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get storewalk service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    Then I verify storewalk response
    And I verify Capturetype attribute is excluded from the Get Storewalk API response

    Examples:
      | storeID | type          | captureType |
      | 78      | GapsHighsLows | Low         |

  @sma
  Scenario Outline: SMA-20454_To verify as per below mentioned values in new attribute Capturetype['Gap'] are excluded from the Get Storewalk API response.Capturetype[ne]=['Gap']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get storewalk service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    Then I verify storewalk response
    And I verify Capturetype attribute is excluded from the Get Storewalk API response

    Examples:
      | storeID | type          | captureType |
      | 78      | GapsHighsLows | Gap         |

  @sma
  Scenario Outline: SMA-20454_To verify as per below mentioned values in new attribute Capturetype['High','Low'] are excluded from the Get Storewalk API response.Capturetype[ne]=['High','Low']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get storewalk service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    Then I verify storewalk response
    And I verify Capturetype attribute is excluded from the Get Storewalk API response

    Examples:
      | storeID | type          | captureType |
      | 78      | GapsHighsLows | High','Low  |

  @sma
  Scenario Outline: SMA-20454_To verify as per below mentioned values in new attribute Capturetype['High','Low','Gap'] are excluded from the Get Storewalk API response.Capturetype[ne]=['High','Low','Gap']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to Get storewalk service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    Then I verify storewalk response
    And I verify Capturetype attribute is excluded from the Get Storewalk API response

    Examples:
      | storeID | type          | captureType      |
      | 78      | GapsHighsLows | High','Low','Gap |

  @sma
  Scenario Outline: SMA-20455_To verify Get Section API response is correct after the code change.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And Get request is made to Get section service for store id "<storeID>"
    Then Get Operation perform on service request
    And Verify Get section service response

    Examples:
      | storeID | type          | productId |
      | 78      | GapsHighsLows | 100001478 |

  @sma
  Scenario Outline: SMA-20455_To verify as per below mentioned values in new attribute Capturetype['High'] are excluded from the Get Section API  response.Capturetype[ne]=['High']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And Get request is made to Get section service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    And Verify Get section service response with captures
    Then I verify Capturetype attribute is excluded from the Get Section API response
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | type          | captureType | productId | locationn | valuee | sectionID |
      | 78      | GapsHighsLows | High        | 100001478 | On_Shelf  | 100    | 0         |

  @sma
  Scenario Outline: SMA-20455_To verify as per below mentioned values in new attribute Capturetype['Low'] are excluded from the Get Section API  response.Capturetype[ne]=['Low']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And Get request is made to Get section service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    And Verify Get section service response with captures
    Then I verify Capturetype attribute is excluded from the Get Section API response
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | type          | captureType | productId | locationn | valuee | sectionID |
      | 78      | GapsHighsLows | Low         | 100001478 | On_Shelf  | 100    | 0         |

  @sma
  Scenario Outline: SMA-20455_To verify as per below mentioned values in new attribute Capturetype['Gap'] are excluded from the Get Section API  response.Capturetype[ne]=['Gap']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And Get request is made to Get section service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    And Verify Get section service response with captures
    Then I verify Capturetype attribute is excluded from the Get Section API response
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | type          | captureType | productId | locationn | valuee | sectionID |
      | 78      | GapsHighsLows | Gap         | 100001478 | On_Shelf  | 100    | 0         |

  @sma
  Scenario Outline: SMA-20455_To verify as per below mentioned values in new attribute Capturetype['High','Low'] are excluded from the Get Section API  response.Capturetype[ne]=['High','Low']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType1>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType2>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And Get request is made to Get section service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    And Verify Get section service response with captures
    Then I verify Capturetype attribute is excluded from the Get Section API response
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | type          | captureType | productId | locationn | valuee | sectionID | captureType1 | captureType2 |
      | 78      | GapsHighsLows | High','Low  | 100001478 | On_Shelf  | 100    | 0         | High         | Low          |

  @sma
  Scenario Outline: SMA-20455_To verify as per below mentioned values in new attribute Capturetype['High','Low','Gap'] are excluded from the Get Section API  response.Capturetype[ne]=['High','Low','Gap']
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType1>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType2>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType3>"
    And Post Operation perform on service request
    Then Verify Create capture service response
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And Get request is made to Get section service for store id "<storeID>" and capture type "<captureType>"
    Then Get Operation perform on service request
    And Verify Get section service response with captures
    Then I verify Capturetype attribute is excluded from the Get Section API response
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | type          | captureType      | productId | locationn | valuee | sectionID | captureType1 | captureType2 | captureType3 |
      | 78      | GapsHighsLows | High','Low','Gap | 100001478 | On_Shelf  | 100    | 0         | High         | Low          | Gap          |

  @sma
  Scenario Outline: Delete GLH Storewalk from Service
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype   |
      | 78      | GapsHighsLows |
      
      
      #####################-------------------------------------- UI  scenario-----------------------------------------------------------

  @sma
  Scenario Outline: SMA-20474_Verify if all the mins from any section are marked as high in the fixture location then respective section should be displayed in the Warehouse department screen but with empty list and Complete section button will be displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on High button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on ViewList to verify that two entries are present for MIN "<Barcode>"
    And I click on Back Button
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on High button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I Click on Section "<Type>"
    Then I Click on group section and Verify Empty product list and Complete section button is displayed
    And I click on Back Button
    Then I click on Fixture Scan
    Then I Click on View list in fixture location
    And I Delete products from fixture
    And I logout of the system

    Examples:
      | storeID | Barcode   | Barcode1  | Type              | Quantity |
      | 78      | 100162509 | 110440154 | Grocery (Impulse) | 2        |

  #########################|78| 110440154 | Grocery (Impulse)|1|
  #########################|  109154185 | Grocery (Impulse) |1|
  #########################|  100130110 | Grocery (Impulse) |1|
  @sma
  Scenario Outline: SMA-20474_Verify when all the GAP marked products for a single section are deleted from fixture location then respective section is not displayed in Warehouse department screen when there are no HIGH captures.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is GAP
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is GAP
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I click on Back Button
    Then I click on Fixture Scan
    Then I Click on View list in fixture location
    And I Delete products from fixture
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is not displayed in Warehouse screen
    And I logout of the system

    Examples:
      | storeID | Barcode   | Barcode1  | Type              | Quantity |
      | 78      | 100162509 | 110440154 | Grocery (Impulse) | 2        |

  @sma
  Scenario Outline: SMA-20474_Verify when all the LOW marked products for a single section are deleted from fixture location then respective section is not displayed in Warehouse department screen when there are no HIGH captures.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is LOW
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is LOW
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I click on Back Button
    Then I click on Fixture Scan
    Then I Click on View list in fixture location
    And I Delete products from fixture
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is not displayed in Warehouse screen
    And I logout of the system

    Examples:
      | storeID | Barcode   | Barcode1  | Type              | Quantity |
      | 78      | 109154185 | 110440154 | Grocery (Impulse) | 2        |

  @sma
  Scenario Outline: SMA-20474_Verify when all the GAP marked products for a single section are deleted from fixture location then respective section is displayed in Warehouse department screen with section Count as "0 of 0" when there are HIGH captures present.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on High button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    Then I verify the if it is HIGH
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on GAP button
    And I will capture the product name from view list
    Then I verify the if it is GAP
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I click on Back Button
    Then I click on Fixture Scan
    Then I Click on View list in fixture location
    And I Delete Gap and Low products from fixture
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I Click on Section "<Type>"
    And I Verify Section count as 0 of 0
    And I logout of the system

    Examples:
      | storeID | Barcode   | Barcode1  | Type              | Quantity |
      | 78      | 100162509 | 110440154 | Grocery (Impulse) | 2        |

  @sma
  Scenario Outline: SMA-20475_Scan a product in fixture as GAP, Go to Warehouse and check if product is present in the list and label is GAP. For same product user again scan in fixture location and Marks as HIGH, Go to Warehouse and check if product is not present in the list.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is GAP
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I Click on Section "<Type>"
    Then I Click on Group section in warehouse
    And I verify Product is present in list
    Then I verify Product capture type as GAP in warehouse
    And I click on Back Button
    And I click on Back Button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on High button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    Then I verify the if it is HIGH
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I Click on Section "<Type>"
    Then I Click on Group section in warehouse
    And I Verify Empty product list is displayed
    And I logout of the system

    Examples:
      | storeID | Barcode   | Type              | Quantity |
      | 78      | 102391591 | Fish Bar          | 2        |
      | 78      | 100162509 | Grocery (Impulse) | 2        |

  @sma
  Scenario Outline: SMA-20475_Scan multiple products in fixture location, Mark products as HIGH, GAP LOW. Navigate to warehouse select the respective sections and navigate to item screen.(Only GAP and LOW products should be present in the list)
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on High button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    Then I verify the if it is HIGH
    And I click on barcode entry Button
    Then Enter "<Barcode2>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is GAP
    And I click on barcode entry Button
    Then Enter "<Barcode3>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is LOW
    And I click on Back Button
    Then I click on WareHouse
    Then I verify Section "<Type>" is displayed in Warehouse screen
    And I Click on Section "<Type>"
    Then I Click on Group section in warehouse
    And I verify Product is present in list
    And I click on Back Button
    Then I verify Section "<Type1>" is displayed in Warehouse screen
    And I Click on Section "<Type1>"
    Then I Click on Group section in warehouse
    And I verify Product is present in list
    Then I verify Product capture type as GAP and LOW in warehouse
    And I logout of the system

    Examples:
      | storeID | Barcode1  | Barcode2  | Barcode3  | Type              | Type1    | Quantity |
      | 78      | 107572771 | 102391591 | 110440154 | Grocery (Impulse) | Fish Bar | 2        |

  ####################  Data required
  @sma
  Scenario Outline: SMA-20475_Verify products which were marked as HIGH in fixture location and adjustment value is too high are present in REVIEW screen for manager approval.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I capture StockRecord Value
    And I click on High button
    And I Enter High quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on Back Button
    Then I click on Review
    Then I Click on on Review Approval tab
    Then I Verify product is present for Manager approval
    And I logout of the system

    Examples:
      | storeID | Barcode   | Type    | subcategory | Quantity |
      | 78      | 107423572 | Alcohol | Wines       | 4        |
