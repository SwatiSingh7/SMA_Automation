@Newglh_negative_prompt
Feature: GLH Negative prompt scenarios

  #Prerequisite :
  #1)Create data in .dat file
  #2)Upload data in non-prod m ordering S3 bucket - S3: msit.xxwmm.supplychain.freshcounts.eeeeeeeeee/promptednegatives/pending/
 #3) dat file name should suffix with Previous day date.
  
  ########## ---------------------------------NAS to S3 bucket file upload----------------------------------------------------
  #@PriceDay-0File
  #Scenario: To check processing of one-off file for Price Service
  #	Given I fetch file from folder
  #When Extract is moved to NAS Pending folder for Negative prompt
  #And Extract is moved to NAS Pending folder for Negative prompt
  #And user uploads "One-Off NAS to S3" file to process records of Price Service
  #And executed "S3 to RDS One Off" job for Price Service to insert data into database
  #And count should get increased in Event table for price Service database
  
########---- Before uploading file in S3 bucket, delete all existing 'GapsHighsLows' walkids from GetStorewalks api  -------------------------------------------------------------------------------------------

  @sma
  Scenario Outline: Delete GLH Storewalk from Service
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype   |
      | 78      | GapsHighsLows |


  ####----------------------------------- Time change-----------------------------------------------------------
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  #######----------------------------------- API Scenarios-----------------------------------------------------------
  @sma
  Scenario Outline: SMA-22779_To verify API response is 201 Created in Create Walkitem API when multiple product id is passed in request body asynchronously.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and multiple product ids "<productId1>","<productId2>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response is 201

    Examples:
      | storeID | type          | productId1 | productId2 |
      | 78      | GapsHighsLows | 100001478  | 102391639  |

  @sma
  Scenario Outline: SMA-22779_To verify multiple walkitems are created successfully in walkitem table through Create Walkitem API when 10 product is are passed at the given time for one walk_id.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Multiple product Create walkitem service for store id "<storeID>" and 10 product ids "<productId1>","<productId2>","<productId3>","<productId4>","<productId5>","<productId6>","<productId7>","<productId8>","<productId9>","<productId10>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response is 201

    Examples:
      | storeID | type          | productId1 | productId2 | productId3 | productId4 | productId5 | productId6 | productId7 | productId8 | productId9 | productId10 |
      | 78      | GapsHighsLows | 100001478  | 102391639  | 110213664  | 111032347  | 109471640  | 110781645  | 111358734  | 111037383  | 111094732  | 109669533   |

  @sma
  Scenario Outline: SMA-22779_To verify Create walkitem API through exceeded limit exception when we pass more than 10 product ids in the request body.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Multiple product Create walkitem service for store id "<storeID>" and more than product ids "<productId1>","<productId2>","<productId3>","<productId4>","<productId5>","<productId6>","<productId7>","<productId8>","<productId9>","<productId10>","<productId11>"
    And Post Operation perform on service request
    Then Verify Error message in Create walkitem service response

    Examples:
      | storeID | type          | productId1 | productId2 | productId3 | productId4 | productId5 | productId6 | productId7 | productId8 | productId9 | productId10 | productId11 |
      | 78      | GapsHighsLows | 100001478  | 102391639  | 110213664  | 111032347  | 109471640  | 110781645  | 111358734  | 111037383  | 111094732  | 109669533   | 106174631   |

  @sma
  Scenario Outline: SMA-22779_To verify using create capture API, captures are getting created for all the walkitems created through Multiple Product endpoint of Create walkitem API.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Multiple product Create walkitem service for store id "<storeID>" and 10 product ids "<productId1>","<productId2>","<productId3>","<productId4>","<productId5>","<productId6>","<productId7>","<productId8>","<productId9>","<productId10>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response is 201
    Given Post request is made to Create capture service for store id "<storeID>", product id "<productId1>", location "<locationn>", value "<valuee>", sectionId "<sectionID>" and capture type "<captureType>"
    And Post Operation perform on service request
    Then Verify Create capture service response

    Examples:
      | storeID | type          | productId1 | productId2 | productId3 | productId4 | productId5 | productId6 | productId7 | productId8 | productId9 | productId10 | locationn | valuee | sectionID | captureType |
      | 78      | GapsHighsLows | 100001478  | 102391639  | 110213664  | 111032347  | 109471640  | 110781645  | 111358734  | 111037383  | 111094732  | 109669533   | On_Shelf  | 100    | 0         | High        |

  @sma
  Scenario Outline: SMA-22779_To verify section is created when multiple walkitems are created using Create Walkitem API by passing multiple product id in request body.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and multiple product ids "<productId1>","<productId2>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response is 201
    And Get request is made to Get storewalk service for store id "<storeID>"
    Then Get Operation perform on service request
    Then Verify Get storewalk service response
    And Get request is made to Get section service for store id "<storeID>"
    Then Get Operation perform on service request
    And Verify Get section service response

    Examples:
      | storeID | type          | productId1 | productId2 |
      | 78      | GapsHighsLows | 100001478  | 102391639  |

  @sma
  Scenario Outline: SMA-22779_To verify whether it allows to create walkitem for different store locations if same products are already processed for other store location
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID1>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Multiple product Create walkitem service for store id "<storeID1>" and 10 product ids "<productId1>","<productId2>","<productId3>","<productId4>","<productId5>","<productId6>","<productId7>","<productId8>","<productId9>","<productId10>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response is 201
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID2>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Multiple product Create walkitem service for store id "<storeID2>" and 10 product ids "<productId1>","<productId2>","<productId3>","<productId4>","<productId5>","<productId6>","<productId7>","<productId8>","<productId9>","<productId10>"
    And Post Operation perform on service request
    Then Verify Create walkitem service response is 201

    Examples:
      | storeID1 | storeID2 | type          | productId1 | productId2 | productId3 | productId4 | productId5 | productId6 | productId7 | productId8 | productId9 | productId10 |
      | 78       | 77       | GapsHighsLows | 100001478  | 102391639  | 110213664  | 111032347  | 109471640  | 110781645  | 111358734  | 111037383  | 111094732  | 109669533   |

  @sma
  Scenario Outline: SMA-22779_To verify create walkitem response code:400,401 with incorrect header
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request with Incorrect header
    And Verify service response code is 400,401

    Examples:
      | storeID | type          | productId |
      | 78      | GapsHighsLows | 100001478 |

  @sma
  Scenario Outline: SMA-22779_To verify create walkitem response code:400,401 with incorrect access token
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get Incorrect access token
    Given Post request is made to Create walkitem service for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 400,401

    Examples:
      | storeID | type          | productId |
      | 78      | GapsHighsLows | 100001478 |

  @sma
  Scenario Outline: SMA-22779_To verify create walkitem response code:401 with blank store id
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get Incorrect access token
    Given Post request is made to Create walkitem service for store id "<storeID1>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 401

    Examples:
      | storeID | storeID1 | type          | productId |
      | 78      | 77       | GapsHighsLows | 100001478 |

  @sma
  Scenario Outline: SMA-22779_To verify create walkitem response code:400 with blank request payload
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service without payload for store id "<storeID>"
    And Post Operation perform on service request
    And Verify service response code is 400

    Examples:
      | storeID | type          |
      | 78      | GapsHighsLows |

  @sma
  Scenario Outline: SMA-22779_To verify create walkitem response code:400,401 with incorect request payload
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk for negative prompt for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create walkitem service with invalid payload for store id "<storeID>" and product id "<productId>"
    And Post Operation perform on service request
    And Verify service response code is 400

    Examples:
      | storeID | type          | productId |
      | 78      | GapsHighsLows | 100001478 |

  ###########----------------------------------- UI Scenarios------------------------------------------------------------
  @sma
  Scenario Outline: SMA-22771_To verify the list of "Prompted Negative Products" are visible on offshelf location in AM GLH across store mobile app without any captures.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I verify products list is not displayed in fixture location
    Then I click on Back button
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location

    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: SMA-22771_To verify For GLH create Items with reason as ‘NegativeStock’ to appear the records in offshelf in GLH.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date for store id "<storeId>"
    Given Get request is made to Get storewalk service for Negative prompt product and store id "<storeId>"
    And Get Operation perform on service request
    Then Verify Get storewalks service response for Negative prompt and store id "<storeId>"
    And I verify GLH create Items with reason as ‘NegativeStock’ in GetStorewalks service response

    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: SMA-22771_To verify if "Prompted Negative Products" are not captured by store colleague, then status across warehouse location for respective department > section is Offshelf pending.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I click on Back button
    Then I click on WareHouse
    And I verify department section status is Offshelf pending
    And I click on Back Button

    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: SMA-22771_To verify once negative walkitems are created and displayed at offshelf location then the respective departments are also visible followed by section across Warehouse location.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I get Category name from Offshelf location
    Then I click on Back button
    Then I click on Petrol
    And I verify products are displayed in Petrol location
    Then I get Category name from Petrol location
    Then I click on Back button
    Then I click on WareHouse
    And I verify products are displayed in Warehouse location

    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: SMA-22771_To verify Groups and section displayed at Warehouse location on UI matches with Get storewalk Service response.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I click on Back button
    Then I click on WareHouse
    And I verify products are displayed in Warehouse location
    Then I get Department name from Warehouse location
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date for store id "<storeId>"
    Given Get request is made to Get storewalk service for store id "<storeId>"
    And Get Operation perform on service request
    Then Verify Get storewalks service response for store id "<storeId>"
    And I verify Warehouse Group dept and section on UI and service matches

    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: SMA-22771_To verify user is able to capture "Prompted Negative Products" as GAP in on-shelf location then respective product is getting removed from Off shelf location.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I get Category name and Min values from Offshelf location
    Then I click on Back button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then I Enter barcode number in fixture scan
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is GAP
    Then I click on Back button
    Then I click on OffShelf
    And I verify Scan product in fixture is removed from offshelf location

    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: SMA-22771_To verify user is able to capture "Prompted Negative Products" as LOW in on-shelf location then respective product is getting removed from Off shelf location.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I get Category name and Min values from Offshelf location
    Then I click on Back button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then I Enter barcode number in fixture scan
    And I click on Low button
    And I Enter the Low quantity "<quantity>"
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is LOW
    Then I click on Back button
    Then I click on OffShelf
    And I verify Scan product in fixture is removed from offshelf location

    Examples:
      | storeId | quantity |
      | 78      | 4        |

  @sma
  Scenario Outline: SMA-22771_To verify user is able to capture "Prompted Negative Products" as HIGH in on-shelf location then respective product is getting removed from Off shelf location.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I get Category name and Min values from Offshelf location
    Then I click on Back button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then I Enter barcode number in fixture scan
    And I click on High button
    And I enter quantity "<quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is HIGH
    Then I click on Back button
    Then I click on OffShelf
    And I verify Scan product in fixture is removed from offshelf location

    Examples:
      | storeId | quantity |
      | 78      | 4        |

  @sma
  Scenario Outline: SMA-22771_To verify when user scans "Prompted Negative Products" in fixture location as HIGH then respective products are excluded from the Warehouse location but empty item list should be displayed.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
#    Then I click on AM Gaps Lows High
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I get Category name and Min values from Offshelf location
    Then I click on Back button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then I Enter barcode number in fixture scan
    And I click on High button
    And I enter quantity "<quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the if it is HIGH
    Then I click on Back button
    Then I click on OffShelf
    And I verify Scan product in fixture is removed from offshelf location
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date for store id "<storeId>"
    Given Get request is made to Get storewalk service for store id "<storeId>"
    And Get Operation perform on service request
    Then Verify Get storewalks service response for store id "<storeId>"
    And I Get Group name and product id from GetStorewalk Service
    Then I click on Back button
    Then I click on WareHouse
    Then I Select the Group section in warehouse
    Then I Verify Empty product list is displayed

    Examples:
      | storeId | quantity |
      | 78      | 4        |

  @sma
  Scenario Outline: SMA-22771_To verify user is able to set '0' quantity for prompted negative counts at Off-Shelf location.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I select section in offshelf location
    And I enter quantity as "<quantity>" in offshelf location
    Then I verify "<quantity>" quantity set for prompted negative counts at offshelf location

    Examples:
      | storeId | quantity |
      | 78      | 0        |

  @sma
  Scenario Outline: SMA-22771_To verify user should not be able to delete negative "Prompted Negative Products" from Offshelf Location.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    Then I select section in offshelf location
    And I left swipe the product description
    And I verify product is not able to delete from Offshelf Location

    Examples:
      | storeId |
      | 78      |
#
  @sma
  Scenario Outline: SMA-22771_To verify user is able to complete warehouse location for the "Prompted Negative Products".
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on OffShelf
    And I verify Prompted Negative products are displayed in Offshelf location
    And I Complete the section
    Then I verify status as Completed
    And I click on Back Button
    Then I click on Petrol
    And I verify Prompted Negative products are displayed in Offshelf location
    And I Complete the section
    And I verify status as Completed
    And I click on Back Button
    Then I click on WareHouse
    And I Complete the warehouse section
    And I verify status as Completed
    And I click on Back Button

    Examples:
      | storeId |
      | 78      |
