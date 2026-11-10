@g55Newglh_drill_down
Feature: GLH drill down PM Gaps

  @sma
  Scenario Outline: Verify COMPLETE status for WAREHOUSE Location
    #Given a Store ID "<StoreID>" and name "<Name>" and items "<Items>" and "<Mode>" is included in Count StoreWalk request- List
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and Items "<Items>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then verify Min details
    Then I will enter qty "<quantity>"
    Then verify that qty has been updated
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button

   #Added step for last capture
    And I click Stock Information in Hotkey
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I verify Capture Type as "<Capture Type>"
    And I verify Counted Quantity "<Counted>" same as onshelf
    And I logout of the system

    Examples:
      | StoreID | Name                          | Items     | Mode | Capture Type | Counted | quantity |
      | 8      | BackButtonOnPetrolandOffshelf | 103303063 | list | AM Count     | 6       | 5        |

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 03    | 30   | pm       |

  @sma @VerfGLHSummaryScreenDisp
  Scenario Outline: Verify that the GLH Summary screen will display all specified departments and sections which are mapped to Gaps walktype
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service
    Given Post request is made to Create storewalk service for store id "<storeID>" and type "<type1>"
    And Post Operation perform on service request
    Then Verify Create storewalk service response
    When Get request is made to GlhSummary api for Store id "<storeID>" and Walktype "<type1>"
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then I Verify all departments which are mapped to Gaps walktype on UI and Service matches


    Examples:
      | storeID | type1 |
      | 8      | Gaps  |


  @sma
  Scenario Outline: TS_16 Verify that the GLH Summary screen will display all departments in the specified static order
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
    And I verify "<Department>" is displayed

    Examples:
      | Department  |
      | Fruit & Veg |

  @sma
  Scenario Outline: TS_17 Verify that the GLH Summary screen will display all departments with right arrow indicator
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
    And I verify right arrow displayed for all department "<Department>"

    Examples:
      | Department  |
      | Fruit & Veg |

  @sma @TS_18
  Scenario Outline: TS_18 Verify that the drill down on each department shows all sections mapped to this department
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
    And I click "<Department>"
    And I verify sections "<Section1>", "<Section2>","<Section3>","<Section4>","<Section5>","<Section6>"


    Examples:
      | Department  | Section1 | Section2     | Section3 | Section4 | Section5 | Section6 |
      | Fruit & Veg | Fruit    | Horticulture | Nuts     | Prepared | Salads   | Veg      |

  @sma
  Scenario Outline:: TS_19 Verify user is able to scan and Gaps product as Gaps in PM Gaps and maintains the default behaviour.
	#i.e. Should give popup as "" N/A"" header with text as ""Please place an orange out of scope label until the product is back in the stock"" with Ok button.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And Verify the popup is displayed with the message
    And I click on OK

    Examples:
      | Department  | category | Barcode   |
      | Fruit & Veg | Fruit    | 103853612 |

  @sma @TS_20
  Scenario Outline: TS_20 Verify that the Scans,SF,IC counts are correctly displayed at department and section level in the Summary screen

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
    And I verify Scans,SF,IC displayed
    And I verify count "<Scans>","<SF>","<IC>" at department level
    And I verify count "<Scans>","<SF>","<IC>" at section level for department "<Department>"

    Examples:
      | Department  | category | Barcode   | Scans | SF | IC |
      | Fruit & Veg | Fruit    | 103853612 | 1     | 0  | 1  |

  @sma
  Scenario Outline: TS_21 Verify that the all counts at department level add up to the Total
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
    And I click "<Department>"
    And I verify count "<Scans>","<SF>","<IC>" at section level for department "<Department>"
#    And I verify Total Count "<Scans>","<SF>","<IC>"

    Examples:
      | Department  | category | Barcode   | Scans | SF | IC |
      | Fruit & Veg | Fruit    | 103853612 | 1     | 0  | 1  |


  @sma
  Scenario Outline: Data creation for Summary Screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
    And I click "<Department>"
    And I click on Back Button
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on OK
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on OK

    Examples:
      | Department  | Category | Strore id | Barcode   | Barcode1  |
      | Fruit & Veg | Fruit    | 8         | 106454481 | 102466936 |

#	|Fruit & Veg|	Nuts|	89|
#	|Fruit & Veg|	Prepared|89|103854826|
#	|Fruit & Veg|	Salads|	89|	103856160|
#	|Fruit & Veg|	Salads|	89|	104840012|
#	|Fruit & Veg|	Veg	|89	|105920250|


  @sma
  Scenario Outline: TS_22 Verify the sorting order in Summary Screen ,for GAPS it should be Low to High
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "PM Gaps"
    Then I click on Summary
    And I click "<Department>"
    And I verify Sorting order in Summary Screen as "<Section>", "<Scan>","<SF>","<IC>"
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
      | Department  | Section | Scan | SF | IC | storeID |
#   |Fruit & Veg|Nuts|1|0|1|
#     |Prepared|1|0|1| 
#     |Veg|1|0|1|
#     |Salads|2|0|2|
      | Fruit & Veg | Fruit   | 3    | 0  | 3  | 8       |
      
	
###########GLh Summary Service Scenarios#############

  @sma @SummariAPI
  Scenario Outline: To verify Get Storewalk Summary API Respones of Gaps, Lows and Highs at Department level for GLH, MS GLH


#	When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Stock Management Applications"
#    Then I click on "Gaps, Lows, Highs"
#    Then I click on Fixture Scan
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    And I click on GAP button
#    And I will capture the product name from view list
#    And I click on barcode entry Button
#    Then Enter "<Barcode1>" number
#    And I click on Low button
#    And I Enter the Low quantity "<Quantity>" and click on Confirm button
#    And I choose the plan from popup if multiple records present
#    And I will capture the product name from view list
#    And I click on barcode entry Button
#    Then Enter "<Barcode1>" number
#    And I click on High button
#    And I Enter High quantity "<Quantity>" and click on Confirm button
#    And I choose the plan from popup if multiple records present
#    And I will capture the product name from view list
#    And I click on Back Button

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
    And I verify service response is 200

    Examples:
      | storeID | type1         | type2                     |
      | 8      | GapsHighsLows | MarketStreetGapsHighsLows |


  @sma
  Scenario Outline: To verify Get Storewalk Summary API at Section level are displayed under respective Department for GLH, MS GLH

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    And I verify service response is 200

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |


  @sma
  Scenario Outline: To verify Get Storewalk Summary API to show section with same existing Positive stock record(+SR) attribute value for GLH, MS GLH

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    Then Get Glh Summary service response
    Then Verify Get Storewalk Summary API Positive stock(SR) value to be displayed under section level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |


  @sma
  Scenario Outline: To verify Get Storewalk Summary API to show section with same existing Stock found (SF) attribute value for GLH, MS GLH.

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API Stock Found(SF) value to be displayed under section level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |


  @sma
  Scenario Outline: To verify Get Storewalk Summary API to show section with same existing Incomplete Counts(IC) attribute value for GLH, MS GLH.
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API Incomplete Counts(IC) attribute value to be displayed under section level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline:To verify Get Storewalk Summary API to show department with existing Positive stock record(+SR) attribute value for GLH, MS GLH.
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API Positive stock(SR) value to be displayed under department level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: To verify Get Storewalk Summary API to show department with existing Stock found (SF) attribute value for GLH, MS GLH.
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API Stock Found(SF) value to be displayed under department level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: To verify Get Storewalk Summary API to show department with existing Incomplete Counts(IC) attribute value for GLH, MS GLH.

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API Incomplete Counts(IC) attribute value to be displayed under department level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: To verify GAPS attributes which are currently being displayed at department level needs to be displayed at section level for GLH, MS GLH.
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API GAPS attribute value to be displayed under department level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |


  @sma
  Scenario Outline: To verify LOWS attributes which are currently being displayed at department level needs to be displayed at section level for GLH, MS GLH.
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API LOWS attribute value to be displayed under department level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: To verify HIGHS attributes which are currently being displayed at department level needs to be displayed at section level for GLH, MS GLH.

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API HIghs attribute value to be displayed under department level

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: To verify that each level of hierarchy should be identifiable with department_id and department_name at department level for GLH, MS GLH.

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API response with department_id and department_name

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: To verify that each level of hierarchy should be identifiable with section_id and section_name similarly at section level for GLH, MS GLH.

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    Then Verify Get Storewalk Summary API response with section_id and section_name

    Examples:
      | storeID | CaptureType | Department | Section1                     | Section2                        | Barcode1  | Barcode2  | Count1 | Count2 |
      | 8      | Gaps        | Grocery    | Air Care, Matches & Cleaners | Biscuits, Crispbreads, Crackers | 106454481 | 102466936 | 0      | 1      |

  @sma
  Scenario Outline: To verify GET response for Storewalk Summary API when there is authorization problem

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH
    Then Get Operation perform on Glh Summary service request for error in authourization
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    And Verify service response code 401

    Examples:
      | storeID | CaptureType |
      | 8      | Gaps        |

  @sma
  Scenario Outline: To verify response for GET Storewalk Summary API when item does not exist

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get request is made to GlhSummary api for Store id "<storeID>" and Walktype GLH & Marketstreet GLH doesn't exist
    Then Get Operation perform on Glh Summary service request
    And Get Department list from Glh Summary service response for Store id "<storeID>"
    And Verify service response code 404

    Examples:
      | storeID | CaptureType |
      | 8      | Gaps        |
    	
   	
    