@g60Newglh_drill_down
Feature: Verify Glh Drilldown scenario functionality

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma @nonmarketstreetdept
  Scenario Outline: Delete GLH Storewalk from Service
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID |
      | 8      |

  @sma
  Scenario Outline: Delete MS GLH Storewalk from Service
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID |
      | 8      |

  @sma
  Scenario Outline: Get department list from GLH Summari API response
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype "<type>"
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"

    Examples:
      | storeID | type                      |
      | 8      | MarketStreetGapsHighsLows |

  @sma @VerfSectionsNonMarket
  Scenario Outline: Verify that sections for non market street departments which have 0 counts are sorted in alphabetical order
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on Gaps tab on summary page
    And I verify department list is displayed on summary page
    Given Capture type is "<CaptureType>" and count "<Count>"
    Then I verify all "<Department>" Department sections count is Zero
    And I verify department sections which have 0 counts are sorted in alphabetical order
    And I logout of the system

    Examples:
      | storeID | CaptureType | Department | Count |
      | 8      | Gaps        | Grocery    | 0     |


  @sma @ms
  Scenario Outline: Verify that sections for market street department will display specified list of market street departments which are mapped to MarketStrreetGapsHighsLows walktype
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    And I verify department list is displayed on summary page
    And I verify Gaps tab, SR, SF and IC columns are displayed on summary page Header
    Given Capture type is "<CaptureType>" and count "<Count>"
    Then I get all "<dept>" Department sections in list
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype "<type>"
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then I Verify all department sections which are mapped to Market Street department on UI and Service matches
    And I logout of the system
    Examples:
      | storeID | dept          | type                      | CaptureType | Count |
      | 8      | Market Street | MarketStreetGapsHighsLows | Gaps        | 0     |

  @sma
  Scenario Outline: Verify that sections for market street department will be displayed as per specified static sort order
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    And I verify department list is displayed on summary page
    And I verify Gaps tab, SR, SF and IC columns are displayed on summary page Header
    Given Capture type is "<CaptureType>" and count "<Count>"
    Then I get all "<dept>" Department sections in list
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype "<type>"
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then I Verify all department sections which are mapped to Market Street department on UI and Service matches
    And I logout of the system

    Examples:
      | storeID | dept          | type                      | CaptureType | Count |
      | 8      | Market Street | MarketStreetGapsHighsLows | Gaps        | 0     |

  @sma
  Scenario Outline: Verify that the GLH Summary screen will display all specified departments which are mapped to GapsHighsLows walktype along with Market Street department.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on Back Button
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    And I verify department list is displayed on summary page
    And I verify Gaps tab, SR, SF and IC columns are displayed on summary page Header
    Then I get Department list for Gaps tab on summary page
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type1>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type2>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then I Verify all departments which are mapped to GapsHighsLows walktype along with Market Street department on UI and Service matches
    And I logout of the system

    Examples:
      | storeID | type1         | type2                     |
      | 8      | GapsHighsLows | MarketStreetGapsHighsLows |

  @sma
  Scenario Outline: Verify that the GLH Summary screen will display all departments in the specified static order in all 3 tabs for Gaps,High and Low.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on Back Button
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on Gaps tab on summary page
    And I verify department list is displayed on summary page
    Then I get Department list for Gaps tab on summary page
    And I click on COUNT tab in summary screen
#    Then I click on Lows tab on summary page
    And I verify department list is displayed on summary page
    Then I get Department list for Count tab on summary page
#    Then I click on Highs tab on summary page
#    And I verify department list is displayed on summary page
#    Then I get Department list for Highs tab on summary page
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type1>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type2>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    And I verify all departments are displayed in the specified static order in all 3 tabs for Gaps,High and Low
    And I logout of the system

    Examples:
      | storeID | type1         | type2                     |
      | 8      | GapsHighsLows | MarketStreetGapsHighsLows |

  @sma
  Scenario Outline: Verify that the GLH Summary screen will display all departments with right arrow indicator in all 3 tabs
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on Gaps tab on summary page
    And I verify all departments with right arrow indicator is displayed on summary page
    And I click on COUNT tab in summary screen
#    Then I click on Lows tab on summary page
    And I verify all departments with right arrow indicator is displayed on summary page
#    Then I click on Highs tab on summary page
#    And I verify all departments with right arrow indicator is displayed on summary page
    And I logout of the system

    Examples:
      | storeID |
      | 8      |

  @sma @nonmarketstreetdept
  Scenario Outline: Verify that sections for non market street departments are sorted based on counts low to high for Gaps.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on Gaps tab on summary page
    And I verify department list is displayed on summary page
    Given Capture type is "<CaptureType>" and count "<Count1>"
    Then I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I get Sections "<Section1>" and "<Section2>" index before scanning the products
    And I click on Back Button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on GAP button
    And I will capture the product name from view list
    And I click on barcode entry Button
    Then Enter "<Barcode2>" number
    And I click on GAP button
    And I will capture the product name from view list
    And I click on Back Button
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on Gaps tab on summary page
    And I verify department list is displayed on summary page
    Given Capture type is "<CaptureType>" and count "<Count2>"
    Then I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I get Sections "<Section1>" and "<Section2>" index after scanning the products
    Then I verify after scanning product Sections "<Section1>" and "<Section2>" are moved to bottom of list
    And I verify Count on summary page for Dept "<Department>" and sections "<Section1>" and "<Section2>"
    And I logout of the system

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8       | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: Verify that sections for non market street departments are sorted based on counts low to high for Lows.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    And I click on COUNT tab in summary screen
#    Then I click on Lows tab on summary page
    And I verify department list is displayed on summary page
    Given Capture type is "<CaptureType>" and count "<Count1>"
    Then I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I get Sections "<Section1>" and "<Section2>" index before scanning the products
    And I click on Back Button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
#    And I click on Low button
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I Enter the Low quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on barcode entry Button
    Then Enter "<Barcode2>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I Enter the Low quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on Back Button
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
#    Then I click on Lows tab on summary page
    And I click on COUNT tab in summary screen
    And I verify department list is displayed on summary page
    Given Capture type is "<CaptureType>" and count "<Count2>"
    Then I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I get Sections "<Section1>" and "<Section2>" index after scanning the products
    Then I verify after scanning product Sections "<Section1>" and "<Section2>" are moved to bottom of list
    And I verify Count on summary page for Dept "<Department>" and sections "<Section1>" and "<Section2>"
    And I logout of the system

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Quantity | Count1 | Count2 |
      | 8      | Lows        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 4        | 0      | 1      |

  @sma @MarketStreetGLH
  Scenario Outline: Verify that sections for non market street departments are sorted based on counts high to low for Highs.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    And I click on COUNT tab in summary screen
#    Then I click on Highs tab on summary page
    And I verify department list is displayed on summary page
    Given Capture type is "<CaptureType>" and count "<Count1>"
    Then I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I get Sections "<Section1>" and "<Section2>" index before scanning the products
    And I click on Back Button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    Then I click on High button
#    And I Enter High quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on barcode entry Button
    Then Enter "<Barcode2>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    Then I click on High button
#    And I Enter High quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on Back Button
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    And I click on COUNT tab in summary screen
#    Then I click on Highs tab on summary page
    And I verify department list is displayed on summary page
    Given Capture type is "<CaptureType>" and count "<Count2>"
    Then I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I get Sections "<Section1>" and "<Section2>" index after scanning the products
    Then I verify after scanning product Sections "<Section1>" and "<Section2>" are at the same position in the list
    And I verify Count on summary page for Dept "<Department>" and sections "<Section1>" and "<Section2>"
    And I logout of the system

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Quantity | Count1 | Count2 |
      | 8       | Counts       | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 4        | 0      | 1      |

  @sma @Verifydrilldown
  Scenario Outline: Verify that the drill down department will appear in green with down arrow indicator
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on Gaps tab on summary page
    And I Selct "<Department>" department
    And I verify all departments with right arrow indicator is displayed on summary page
    And I click on COUNT tab in summary screen
#    Then I click on Lows tab on summary page
    And I Selct "<Department>" department
    And I verify all departments with right arrow indicator is displayed on summary page
#    And I click on COUNT tab in summary screen
##    Then I click on Highs tab on summary page
#    And I Selct "<Department>" department
#    And I verify all departments with right arrow indicator is displayed on summary page
    And I logout of the system

    Examples:
      | storeID | Department |
      | 8      | Grocery    |

  @sma @VerfCountSectLvl
  Scenario Outline: Verify that the all counts at section level add up to the department level for all departments (for non marketstreet dept) in all 3 tabs
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on Back Button
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Given Capture type is "<CaptureType1>" and count "<Count>"
    Then I click on Gaps tab on summary page
    And I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I verify that the all counts at section level add up to the department level for "<Department>" Department
    Given Capture type is "<CaptureType3>" and count "<Count>"
    And I click on COUNT tab in summary screen
#    Then I click on Lows tab on summary page
    And I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I verify that the all counts at section level add up to the department level for "<Department>" Department
    And I logout of the system
#    Given Capture type is "<CaptureType3>" and count "<Count>"
#    And I click on COUNT tab in summary screen
##    Then I click on Highs tab on summary page
#    And I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
#    And I verify that the all counts at section level add up to the department level for "<Department>" Department
#    And I logout of the system

    Examples:
      | storeId | Department | Section1                     | Section2                        | CaptureType1 | CaptureType2 | CaptureType3 | Count |
      | 8       | Grocery    | Biscuits, Crispbreads, Crackers | Air Care, Matches & Cleaners | Gaps         | Lows         | Counts       | 1     |

  @sma
  Scenario Outline: Scan products in fixture and marked as HIGH, GAP and LOW for GLH dept.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on Low button
#    And I Enter the Low quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on High button
#    And I Enter High quantity "<Quantity>" and click on Confirm button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    And I click on Back Button
    And I logout of the system

    Examples:
      | storeId | Department | Section1 | Barcode   | Barcode1  | Quantity |
      | 8      | Fresh      | Cheese   | 100688560 | 103268851 | 2        |

  @sma @VerifyAllcountsatDept
  Scenario Outline: Verify that the all counts at department level add up to the Totals (For Non Market Street dept)in all 3 tabs
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Fixture Scan
    And I click on Back Button
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Given Capture type is "<captureType1>" and count "<Count>"
    Then I click on Gaps tab on summary page
    And I Get department count for "<Department1>" and "<Department2>" departments
    And I verify that the all counts at department level add up to the Totals for "<captureType1>"
#    Given Capture type is "<captureType2>" and count "<Count>"
#    Given Capture type is "<captureType2>" and count "<Count>"
#    Then I click on COUNT tab in summary screen
#    And I Get department count for "<Department1>" and "<Department2>" departments
#    And I verify that the all counts at department level add up to the Totals for "<captureType2>"
    Given Capture type is "<captureType2>" and count "<Count>"
    Then I click on COUNT tab in summary screen
#    Then I click on Highs tab on summary page
    And I Get department count for "<Department1>" and "<Department2>" departments
    And I verify that the all counts at department level add up to the Totals for "<captureType2>"
    And I logout of the system

    Examples:
      | storeId | Department1 | Department2 | captureType1 | captureType2 | Count |
      | 8       | Grocery     | Fresh       | Gaps         | Count        |       |
   
   ##################   Market Street
  @sma @scanProductsGLHDept
  Scenario Outline: Scan products in fixture and marked as HIGH, GAP and LOW for Marketstreet GLH dept.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gap Scan"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on GAP button
    And I click View List
    Then I capture MIN for product in Counter
    And I click on Back Button
    And I click on barcode entry Button
    Then Enter "<Barcode2>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on Low button
#    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click View List
    Then I capture MIN for product in Counter
    And I click on Back Button
    And I click on barcode entry Button
    Then Enter "<Barcode3>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on High button
#    And I enter quantity "<Quantity>" for high
    And I click View List
    Then I capture MIN for product in Counter
    And I logout of the system

    Examples:
      | storeID | Department    | Section1 | Section2   | Barcode1  | Barcode2  | Barcode3  | Quantity |
      | 8      | Market Street | Bakery   | Fresh Prep | 104229467 | 104738042 | 105780269 | 4        |

  @sma @Scrollaa
  Scenario Outline: Verify that the all counts at section level add up to the department level for all departments (Market Street) in all 3 tabs
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Given Capture type is "<CaptureType1>" and count "<Count>"
    Then I click on Gaps tab on summary page
    And I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I verify that the all counts at section level add up to the department level for "<Department>" Department
    Given Capture type is "<CaptureType2>" and count "<Count>"
    Then I click on COUNT tab in summary screen
    And I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
    And I verify that the all counts at section level add up to the department level for "<Department>" Department
#    Given Capture type is "<CaptureType3>" and count "<Count>"
##    Then I click on Highs tab on summary page
#    Then I click on COUNT tab in summary screen
#    And I get Section list for "<Department>" Dept and Count for sections "<Section1>" and "<Section2>" department on summary page
#    And I verify that the all counts at section level add up to the department level for "<Department>" Department
    And I logout of the system

    Examples:
      | storeID | Department    | Section1 | Section2   | CaptureType1 | CaptureType2 | CaptureType3 | Count |
      | 8       | Market Street | Bakery   | Fresh Prep | Gaps         | Counts       | Highs        | 1     |

  @sma @VerfGapScreen
  Scenario Outline: Verify that the Gaps,+SR,SF,IC counts are correctly displayed at department and section level in the Gaps screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on Gaps tab on summary page
    And I verify department list is displayed on summary page
    Then I verify Gaps tab, SR, SF and IC columns are displayed on summary page Header
    And I verify Total count for Gaps , SR, SF and IC columns are displayed on summary page Footer
    And I logout of the system

    Examples:
      | storeID |
      | 8      |

  @sma @VerfCountScreen
  Scenario Outline: Verify that the Lows,SF,IC counts are correctly displayed at department and section level in the Count screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on COUNT tab in summary screen
#    Then I click on Lows tab on summary page
    And I verify department list is displayed on summary page
    Then I verify Count tab, Count and IC columns are displayed on summary page Header
    And I verify Total count for Count, and IC columns are displayed on summary page Footer
    And I logout of the system

    Examples:
      | storeID |
      | 8      |

  @sma
  Scenario Outline: Verify that the High,IC counts are correctly displayed at department and section level in the High screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on Summary
    And I verify Gaps, Count tabs are displayed on summary page
    Then I click on COUNT tab in summary screen
#    Then I click on Highs tab on summary page
    And I verify department list is displayed on summary page
    Then I verify Counts tab and IC columns are displayed on summary page Header
    And I verify Total count for Highs and IC columns are displayed on summary page Footer
    And I logout of the system

    Examples:
      | storeID |
      | 8      |
      
      
   