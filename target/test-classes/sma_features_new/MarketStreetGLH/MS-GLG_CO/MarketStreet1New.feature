@Newmarket_street1 @regression @store_walk
Feature: Verify Market Street Gaps, Lows and Highs Part-1

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma
  Scenario: SMA_20502 TS_92,93,97,98,100 To verify User see ‘Market Street - Gaps, Lows, Highs’ and ‘Sales Orders’ in sub menu for Store Collegue
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    #And I see Sales Orders
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I see Counter & Fixture location
    And I click Counter & Fixture location
    And I click on Back Button
    And I see Other location
    And I click Other Location
    And I click on Back Button
    And I see Backup location
    And I click Backup Location
    And I click on Back Button
    And I see Review location
    And I click Review Location
    And I click on Back Button


  @sma
  Scenario: SMA_20502 To verify screen for Market street with Sub menus for store manager
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    #And I see Sales Orders
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I see Counter & Fixture location
    And I click Counter & Fixture location
    And I click on Back Button
    And I see Other location
    And I click Other Location
    And I click on Back Button
    And I see Backup location
    And I click Backup Location
    And I click on Back Button
    And I see Review location
    And I click Review Location
    And I click on Back Button

  @sma
  Scenario Outline: SMA_23135 TS_25,26,27 To verify user is able to scan product in Counter Location with Barcode\QR code and mark as GAP,Low and High
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I see Please Select Location
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<EAN>" number
    And I click on GAP button
    And I click on barcode entry Button
    Then Enter "<EAN1>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on barcode entry Button
    Then Enter "<EAN2>" number
    And I click on High button
    And I enter quantity "<Quantity>" for high
    And I click on Back Button

    Examples:
      | storeID | EAN       | EAN1      | EAN2      | Quantity | Department |
      | 78     | 105780269 | 105185558 | 104695783 | 200      | Fresh Prep |


  @sma
  Scenario: sma23135	To verify store colleague is not allowed to scan a new market Street product at Other Location and mark as GAP
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Other Location
    Then I verify Scanning not allowed
    And I click on Back Button

  @sma
  Scenario Outline: TS_01,101 To verify when GLH market Street product is scan in Counter Location as GAP and item details shown in Other, Backup screens
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<departments>" or not
    And I click on Back Button
    And I click on Back Button

    Examples:
      | Barcode   | departments |
      | 105780269 | Fresh Prep  |

  @sma
  Scenario: sma23135 To verify store colleague is not allowed to scan a new market Street product at Other Location and mark as LOW
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Other Location
    Then I verify Scanning not allowed
    And I click on Back Button

  @sma
  Scenario Outline: To verify when user mark GLH market street and prepack product as GAP the orange out of stock label is no more visibile
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I verify no orange out of stock popup is visible
    Examples:
      | Barcode   | departments |
      | 105780269 | Fresh Prep  |


  @sma
  Scenario Outline: TS_03 To verify when GLH market Street product is scan in Counter Location as LOW and item details shown in Other, Backup screens
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
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
    And I click on Back Button
    And I click on Back Button
    And I click Stock Information in Hotkey
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I verify Capture Type as "<Capture Type>"
    And I verify Counted Quantity "<Counted>" same as onshelf

    Examples:
      | Barcode   | Quantity | Department | Capture Type | Counted |
      | 110006577 | 400      | Bakery     | Low          | 1200    |

  @sma
  Scenario Outline: TS_13 To verify that when the store colleague wishes to edit the scanned products in product list, then product which is Gap is not editable
  and product which is High or Low is editable

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I click on Back Button
    And I click Counter & Fixture location
    And I click View List
    And I verfiy Gap marked product is not editable
    And I verfiy Low, High marked product are editable
    And I click on Back Button

    Examples:
      | Barcode   |
      | 105780269 |

  @sma
  Scenario Outline: SMA_22269 To verify when  the user scans an item on stock information then last capture of that product to be displayed as ‘Gap’, ‘Low’ or ‘High’.

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click Stock Information in Hotkey
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I verify Capture Type as "<Capture Type>"
    And I verify Counted Quantity "<Counted>" same as onshelf

    Examples:
      | Barcode   | departments | Capture Type | Counted |
      | 105780269 | Fresh Prep  | Gap          | 0       |
      | 104695783 | Fresh Prep  | High         | 400     |
      | 110006577 | Bakery      | Low          | 1200    |

  @sma
  Scenario Outline: SMA_22269 To verify user is able to view upto last 3 days capture details for scan item

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click Stock Information in Hotkey
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I verify last capture within 3 days

    Examples:
      | Barcode   | departments | Capture Type |
      | 105780269 | Fresh Prep  | Gap          |


  @sma
  Scenario Outline: TS_15,16 To verify if user scan non GLH Market Street product in Counter Location with MIN correct warning message is displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I see Please Select Location
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I see warning message for non GLH Marketstreet product
    When I click Proceed
    And I click on GAP button

    Examples:
      | MIN       |
      | 105695953 |


  @sma
  Scenario Outline: TS_19 To verify user is able to scan product in counter Location with PIN number and mark as GAP
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I see Please Select Location
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<PIN>" number
    And I capture MIN for product
    And I click on GAP button
    Then I see product in View List
    And I click View List

    Examples:
      | PIN       |
      | 109129705 |


  @sma
  Scenario Outline: TS_02 To verify when GLH market Street product is scan in Counter Location as HIGH and item details shown in Other, Backup screens
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on High button
    And I enter quantity "<Quantity>" for high
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
    And I click and enter "<Quantity>" for backup location
    And I click on Back Button

    Examples:
      | Barcode   | Quantity | Department         |
      | 105348927 | 50       | Oven Fresh / Baked |


  @sma
  Scenario Outline: TS_124 To verify PrePack Product scanned in Counter location than it should not display warning message
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<PrepackProduct>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click View List
    Then I capture MIN for product in Counter
    And I click on Back Button

    Examples:
      | PrepackProduct | Quantity |
      | 105713584      | 10       |

  @sma
  Scenario Outline: TS_125 To verify prepack product scanned in Counter location displays count
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click View List
    And I verify "<Barcode>" in list
    And I click product

    Examples:
      | PrepackProduct | Quantity | Barcode   |
      | 109913452      | 100      | 105713584 |

  @sma
  Scenario Outline:TS_20 To verify user is able to scan product in counter Location with PIN number and mark as HIGH
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<PIN>" number
    And I click on High button
    And I enter quantity "<Quantity>" for high
    And I click View List
    Then I capture MIN for product in Counter

    Examples:
      | PIN       | Quantity |
      | 109129705 | 20       |

  @sma
  Scenario Outline:TS_21 To verify user is able to scan product in counter Location with PIN number and mark as LOW
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I see Please Select Location
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<PIN>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    Then I see product in View List
    And I click View List
    Then I capture MIN for product in Counter
    And I click Exit Counter
    And I click on Back Button

    Examples:
      | PIN       | Quantity |
      | 109129705 | 100      |


  @sma
  Scenario: To verify Departments to be sorted in alphabetical orderin Other and Backup Location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Other Location
    And I verify alphabetic order sorting for list
    And I click on Back Button
    And I click Backup Location
    And I verify alphabetic order sorting for list

  @sma
  Scenario Outline: As a Store Colleague/manager they should be able to view department-section list for all location Other, Backup & Review
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Other Location
    And I verify "<Departments>" department is Displayed
    And I verify "<Section>" section is Displayed
    And I click on Back Button
    And I click Backup Location
    And I verify "<Departments>" department is Displayed
    And I verify "<Section>" section is Displayed
    And I click on Back Button
    And I click Review Location
    And I verify "<Departments>" department is Displayed
    And I verify "<Section>" section is Displayed
    And I click on Back Button

    Examples:
      | Section            | Departments        |
      | Fish Bar           | Fish Bar           |
      | Oven Fresh / Baked | Oven Fresh / Baked |
 			#|Butchery|Butchery|

  @sma
  Scenario Outline: To verify List of department at Other screen is displayed when user clicks on the department
#than respective section of the department to be displayed <cascading view>
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Other Location
    And I verify "<Departments>" department is Displayed
    And I verify "<Section>" section is Displayed
    And I click on Back Button

    Examples:
      | Section            | Departments        |
      | Fish Barr          | Fish Bar           |
      | Oven Fresh / Baked | Oven Fresh / Baked |
 			#|Butchery|Butchery|
  @sma
  Scenario Outline:To verify List of Section at backup screen is displayed when user clicks on the department
	#name than respective section of the department to be displayed <cascading view>
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Backup Location
    And I verify "<Departments>" department is Displayed
    And I verify "<Section>" section is Displayed
    And I click on Back Button

    Examples:
      | Section            | Departments        |
      | Fish Bar           | Fish Bar           |
      | Oven Fresh / Baked | Oven Fresh / Baked |
 			#|Butchery|Butchery|

  @sma
  Scenario Outline: To verify List of Section at Review screen is displayed when user clicks on the department
 #name than respective section of the department to be displayed <cascading view>
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Review Location
    And I verify "<Departments>" department is Displayed
    And I verify "<Section>" section is Displayed
    And I click on Back Button

    Examples:
      | Section            | Departments        |
      | Fish Bar           | Fish Bar           |
      | Oven Fresh / Baked | Oven Fresh / Baked |
 			#|Butchery|Butchery|
#  @sma
#  Scenario Outline:To verify when user mark GLH market street and prepack product as GAP Than Delist/Derange label should not be displayed
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Stock Management Applications"
#    Then I click on "Market Street - Gaps, Lows, Highs"
#    And I click Counter & Fixture location
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    And I click on GAP button
#    And I verify no Delist/Derange label is displayed
#    Examples:
#      | Barcode   | departments |
#      | 105780269 | Fresh Prep  |
#
#  @sma
#  Scenario Outline:To verify when user mark GLH market street and prepack product as GAP Than Delist/Derange with effective Date label should not be displayed
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Stock Management Applications"
#    Then I click on "Market Street - Gaps, Lows, Highs"
#    And I click Counter & Fixture location
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    And I click on GAP button
#    And I verify no Delist/Derange with effective Date label is displayed
#    Examples:
#      | Barcode   | departments |
#      | 105780269 | Fresh Prep  |
#
#  @sma
#  Scenario Outline:To verify when user mark GLH market street and prepack product as GAP Than Delist/Derange label with Delivery date (Future date) should not be displayed
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Stock Management Applications"
#    Then I click on "Market Street - Gaps, Lows, Highs"
#    And I click Counter & Fixture location
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    And I click on GAP button
#    And I verify no Delist/Derange label with Delivery date is displayed
#    Examples:
#      | Barcode   | departments |
#      | 105780269 | Fresh Prep  |
#
  @sma
  Scenario Outline:To verify when user mark GLH market street and prepack product as GAP Than Delist/Derange label with Delivery date as "NA" (Less Than System date) should not be displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Market Street - Gaps, Lows, Highs"
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I verify no Delist Derange label with Delivery date as "NA" (Less Than System date) is displayed
    Examples:
      | Barcode   | departments |
      | 105780269 | Fresh Prep  |
#
#  @sma
#  Scenario Outline:To verify when user mark GLH market street and prepack product as GAP Than Delist/Derange label with Delivery date as "NA" should not be displayed
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Stock Management Applications"
#    Then I click on "Market Street - Gaps, Lows, Highs"
#    And I click Counter & Fixture location
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    And I click on GAP button
#    And I verify no Delist/Derange label with Delivery date as "NA" is displayed
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    Given Get request is made to Get storewalks service for current date
#    And Get Operation perform on service request
#    Then Verify Get storewalks service response for current date
#    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
#
#    Examples:
#      | Barcode   | departments | storeID | type                      |
#      | 105780269 | Fresh Prep  | 78      | MarketStreetGapsHighsLows |
#
#
