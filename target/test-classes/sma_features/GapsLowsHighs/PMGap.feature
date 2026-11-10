@pm_glh @regression @store_walk
Feature: Verify PM Gap Scenarios

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 03    | 30   | pm       |
      ## UAT
      ###|    01 |   30 | pm       |

  @sma
  Scenario Outline: Verify Screen elements on PM GAP Screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    And I click on PMGaps
    Then I click on Fixture Scan
    And I click on Back Button
    Then I click on OffShelf
    And I click on Back Button
    Then I click on Petrol
    And I click on Back Button
    Then I click on WareHouse
    And I click on Back Button
    Then I click on Summary
    And I click on Back Button
    And I logout of the system

    Examples:
      | storeID |
      | 89      |

  @sma @ll
  Scenario Outline: Verify user is abel to scan a product in onshelf location and it is marked as GAP by default
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    And I click on PMGaps
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Product is marked as GAP
    And I click on Back Button
    And I click on Back Button
    Then I click on Summary
    Then I verify text "<Department>" is under IC is "<incomplete>" in summary
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<storeID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Section status is "<sectionStatus>" in Get storewalk service

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | Department  | category | Barcode   | incomplete | Typee | sectionStatus |
      | 89      | Fruit & Veg | Fruit    | 103853612 | 1          | Gaps  | Available     |
      | 89      | Fruit & Veg | Nuts     | 105398043 | 1          | Gaps  | Available     |
       ########|      89 | Fruit & Veg | Fruit    | 107147660 |          1 |Gaps|Available|

  @sma
  Scenario Outline: Verify scanned barcode is availabel in Warehouse Location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    And I click on PMGaps
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Product is marked as GAP
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I verify Product marked as gap in Warehouse
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | Department  | category | Barcode   | quantity |
      | 89      | Fruit & Veg | Fruit    | 103853612 | 21       |

  @sma
  Scenario Outline: To verify Last capture section in Stock information displaying correct information when the last capture has been taken in PM GLH and scanned as GAP.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    And I click on PMGaps
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Product is marked as GAP
    Then I click on hotKey
    And I select StockInformation from the Hotkey Menu
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify Last Capture Type is "<captureType>"
    And I verify Date and User details for Last capture
    And I verify Counted column and counted quantity "<countedQty>" for last capture are present
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | Department  | category | Barcode   | quantity | Type | captureType | countedQty |
      | 89      | Fruit & Veg | Fruit    | 103853612 | 21       | Gaps | PM Gap      | 0          |
      | 89      | Fruit & Veg | Nuts     | 105398043 | 8        | Gaps | PM Gap      | 0          |
      #####|      89 | Fruit & Veg | Fruit    | 105142718 |        8 | Gaps |PM Gap|0|

  @sma
  Scenario Outline: Verify user is able to mark product as gap, end to end
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    And I click on PMGaps
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I choose the plan from popup if multiple records present
    And I click on OK
    And I verify Product is marked as GAP
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    Then I verify product is displayed as gap in Warehouse
    And I click on product in warehouse "<Barcode>"
    Then I verify Popup is displayed for confirm stock found
    And I click on Confirm option
    Then I verify Stock Found is Displayed
    And I click on product in warehouse "<Barcode>"
    And I click on Confirm option
    Then I verify product is displayed as gap in Warehouse
    Then I click on confirm count area button
    And I click on confirm count popup
    And I verify Section completed status is displayed

    And I click on Back Button
    Then I click on Summary
    And I verify "<Department>" is displayed under summary
    Then I verify text is under Low is "<low>" in summary

    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | Department  | category | Barcode   | low | Type |
      | 89      | Fruit & Veg | Nuts     | 105398043 | 1   | Gaps |

  @sma
  Scenario Outline: Verify Stock Found End to End Scenario
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Gaps,Low,High
    And I click on PMGaps
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I choose the plan from popup if multiple records present
    And I click on OK
    And I verify Product is marked as GAP
    And I click on Back Button
    And I click on Back Button
    Then I click on WareHouse
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    Then I verify product is displayed as gap in Warehouse
    And I click on product in warehouse "<Barcode>"
    Then I verify Popup is displayed for confirm stock found
    And I click on Confirm option
    Then I verify Stock Found is Displayed
    Then I click on confirm count area button
    And I click on confirm count popup
    And I click on Back Button
    Then I click on Summary
    And I verify "<Department>" is displayed under summary
    And I click on the "<Department>" available
    Then I verify text "<Department>" is under stockfound is "<stockfound>" in summary

    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | Department  | category | Barcode   | stockfound | Type |
      | 89      | Fruit & Veg | Nuts     | 105398043 | 1          | Gaps |

#  @sma
#  Scenario Outline: Verify Offshelf section
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on Gaps,Low,High
#    And I click on PMGaps
#    Then I click on Fixture Scan
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    And I choose the plan from popup if multiple records present
#    And I click on OK
#    And I verify Product is marked as GAP
#    And I click on Back Button
#    And I click on Back Button
#    Then I click on OffShelf
#    And I click on the "<Department>" available
#    Then I verify "<Barcode>" from the list
#
#    Examples:
#      | storeID | Department                                 | category | Barcode   | Type |
#      | 89      | Sharing Crisps & Snacks Grocery Nuts (997) | Fruit    | 105398043 | Gaps |
#
#  @sma
#  Scenario Outline: Verify Petrol Section
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on Gaps,Low,High
#    And I click on PMGaps
#    Then I click on Fixture Scan
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number
#    And I choose the plan from popup if multiple records present
#    And I click on OK
#    And I click on Back Button
#    Then I click on Petrol
#    And I click on the "<Department>" available
#    Then I verify "<Barcode>" from the list
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    Given Get request is made to Get storewalks service for current date
#    And Get Operation perform on service request
#    Then Verify Get storewalks service response for current date
#    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"
#
#    Examples:
#      | storeID | Department                 | category | Barcode   | Type |
#      | 89      | Petrol Chilled Fresh (860) | Fruit    | 112085150 | Gaps |
