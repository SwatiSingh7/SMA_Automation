@integrated_sales
Feature: Integrated Sales

  #READ ME before execution
  #Upload sms/rms file in aws for current stock record update,
  #Execute scenario 01 to 10 respectivly
  #Then run aws tasks for GLH/MS/Counts
  #Now execute last scenario to verify override counts.
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples: 
      | Hours | Mins | Meridiem |
      |    07 |   00 | am       |

  @sma
  Scenario Outline: 01To verify that product's stock UOM = EA and countType = Single, stock record across Stock information and AM GLH/ MS GLH item details screen should be displayed same as the real time stock record.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock record UI with Real time stock quantity
    And I click on Back Button
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify GLH stock record value same as Real time stock quantity

    Examples: 
      | StoreID | Barcode   | stock UOM | countType |
      |      78 | 104727298 | EA        | Single    |

  @sma
  Scenario Outline: 02Verify that product's stock UOM = EA and countType = Cases, stock record across Stock information and AM GLH/ MS GLH item details screen should be a calculated qty as below formula: Real Time stock Qty / PackQty
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    Given Request is made to verify Product Id "<Barcode>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    And I calculate Stock quantity
    And I verify Stock record UI displayed as calculated value
    And I click on Back Button
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify GLH Stock record value same as calculated value

    Examples: 
      | StoreID | Barcode   | stock UOM | countType |
      |      78 | 104065909 | EA        | Cases     |

  @sma
  Scenario Outline: 03Verify that product's stock UOM = PCS and countType = Single,stock record across Stock information and AM GLH/ MS GLH item details screen should be displayed same as the real time stock record.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock record UI with Real time stock quantity
    And I click on Back Button
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify GLH stock record value same as Real time stock quantity

    Examples: 
      | StoreID | Barcode   | stock UOM | countType |
      |      78 | 102370141 | PCS       | Singles   |

  @sma
  Scenario Outline: 04Verify that product's stock UOM = PCS and countType = Cases,stock record across Stock information and AM GLH/ MS GLH item details screen should be a calculated qty as below formula:Real Time stock Qty / PackQty
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    Given Request is made to verify Product Id "<Barcode>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    And I calculate Stock quantity
    And I verify Stock record UI displayed as calculated value for PCS
    And I click on Back Button
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify GLH Stock record value same as calculated value

    Examples: 
      | StoreID | Barcode   | stock UOM | countType |
      |      78 | 107945127 | PCS       | Cases     |

  @sma
  Scenario Outline: 05Verify that product's stock UOM = KG and countType = Singles,stock record across Stock information and AM GLH/ MS GLH item details screen should be a calculated qty as below formula: Real Time stock Qty * (PackQty / PackWeight)
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    Given Request is made to verify Product Id "<Barcode>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    And I calculate Stock quantity for kg
    And I verify Stock record UI displayed as calculated value for kg
    And I click on Back Button
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify GLH Stock record value same as calculated value for kg

    Examples: 
      | StoreID | Barcode   | stock UOM | countType |
      |      78 | 110276411 | KG        | Singles   |

  @sma
  Scenario Outline: 06Verify that product's stock UOM = KG and countType = Cases, stock record across Stock information and AM GLH/MS GLH item details screen should be a calculated qty as below formula:Real Time stock Qty / PackWeight
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I calculate Stock quantity for kgcases
    And I verify Stock record UI displayed as calculated value KGcases
    And I click on Back Button
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify GLH Stock record value same as calculated value KGcases

    Examples: 
      | StoreID | Barcode   | stock UOM | countType |
      |      78 | 108335312 | KG        | Cases     |

  @sma
  Scenario Outline: 07Verify that stock record is getting override by the GLH capture quantity for the same product across UI stock information page When AM GLH is performed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    And I click on Back Button
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock record UI with Real time stock quantity
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
    Then I verify the if Low is displayed in warehouse
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button

    Examples: 
      | StoreID | Barcode   | Quantity | Type     | Quantity1 |
      |      78 | 108777727 |        1 | Fish Bar |         1 |

  @sma
  Scenario Outline: 08Verify that stock record is getting override by the MS GLH capture quantity for the same product across UI stock information page When MS GLH is performed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    And I click on Back Button
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    Given Request is made to verify Product Id "<Barcode>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    And I calculate Stock quantity
    And I click on Back Button
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I click and enter "<Quantity>" for other location
    And I click Exit Other
    And I click on Back Button
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I click and enter "<Quantity>"  for backup location for low
    And I confirm count area
    And I click on Back Button

    Examples: 
      | StoreID | Barcode   | Quantity | Department | Quantity1 |
      |      78 | 106790207 |        1 | Cake Shop  |         1 |

  ###################################################################################################
  @sma
  Scenario Outline: Verify Delete Count Storewalk service
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete Count storewalk for store id "<storeID>"

    Examples: 
      | storeID | capturetype |
      |      78 | Counts      |

  @sma
  Scenario Outline: Create Count storewalk by making call with services
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given a Store ID "<StoreID>" and name "<Name>" and items "<Items>" and "<Mode>" is included in Count StoreWalk request- List
    When the request is made to the specified Count StoreWalk service for Store "<StoreID>"
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk

    Examples: 
      | StoreID | Name                             | Items     | Mode |
      |      78 | AM Count scan Item Uncounted 001 | 100001497 | list |

  #supplychain-stockv2-reader-stockcount-stream-producer-task-sit
  @sma
  Scenario Outline: 09Verify that stock record is getting override by the AM scan mode Count capture quantity for the same product across UI stock
    information page When AM Count is performed.

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    And I click on Back Button
    And I click on Back Button
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    ##### AM count steps
    Then I click on Counts
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse
    Then verify Min details
    Then I will enter qty "<quantity>"
    Then verify that qty has been updated
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse
    Then verify Min details
    Then I will enter qty "<quantity>"
    Then I will choose the plan from popup and enter qty
    Then verify that qty has been updated
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button
    And I click on Back Button
    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse
    Then I verify the details of the Min selected
    Then I Confirm the Review
    Then I verify the details of the Min selected
    Then I Confirm the Review
    And I click on Back Button

    Examples: 
      | StoreID | Name                             | Barcode   | Mode | quantity | Quantity1 |
      |      78 | AM Count scan Item Uncounted 001 | 100001497 | list |        1 |         1 |

  @sm
  Scenario Outline: 10To verify that AM GLH or MS GLH captured quantity is overriding the opening stock record for a product for which Store pick is happened before the counting.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on stock information
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I Capture Stock record UI
    And I click on Back Button
    And I click on Back Button
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    And I verify Stock record UI with Real time stock quantity
    Given Stock transfer data is "<transferDate>","<fromLocation>","<toLocation>","<internal>","<isBatch>","<containerId>","<productId>" and "<qtyTransferre>"
    When Request is made to Stock transfer api
    Then Post operation perform on Stock transfer api
    And I click on Back Button
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
    Then I verify the if Low is displayed in warehouse
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button

    Examples: 
      | StoreID | Barcode   | transferDate         | fromLocation | toLocation | internal | isBatch | containerId | productId | qtyTransferre | Quantity | Type   | Quantity1 |
      |      78 | 105551491 | 2021-04-21T07:30:37Z |           78 |       8082 | false    | true    |           3 | 105551491 |            10 |       10 | Frozen |        20 |
