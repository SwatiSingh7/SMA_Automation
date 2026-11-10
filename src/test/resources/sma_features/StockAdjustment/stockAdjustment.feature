@stock_adjustment @regression @store_walk
Feature: Verify StockAdjustment Module

  @sma
  Scenario Outline: Validate all Adjustment Codes on Stock Adjustment Page
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I verify reason code "<adjustmentCode>" on stockAdjustment Page
    Examples:
      | MenuOptions       | adjustmentCode            |
      | Stock Adjustments | Wastage                   |
      | Stock Adjustments | Transfer Stock To A Dept  |
      | Stock Adjustments | Transfer Back From A Dept |
      | Stock Adjustments | Other Adjustments         |
      | Stock Adjustments | Store To Store Transfer   |


  @sma
  Scenario Outline: Validate all Reason code in Adjustment codes - Transfer Stock To A Dept
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page

    Examples:
      | MenuOptions       | adjustmentCode           | reasoncode            |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Bakery    |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Cake Shop |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Deli                  |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Fish                  |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Fresh To Go           |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Meat                  |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Oven Baked            |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Pie Shop              |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Cafe                  |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Staff Room            |
      | Stock Adjustments | Transfer Stock To A Dept | Transfer to Pharmacy (TRIAL ONLY) |

  @sma
  Scenario Outline: Validate all Reason code in Adjustment codes - Transfer Back From A Dept
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page

    Examples:
      | MenuOptions       | adjustmentCode            | reasoncode                        |
      | Stock Adjustments | Transfer Back From A Dept | Return from Bakery                |
      | Stock Adjustments | Transfer Back From A Dept | Return from Cake Shop             |
      | Stock Adjustments | Transfer Back From A Dept | Return from Deli                  |
      | Stock Adjustments | Transfer Back From A Dept | Return from Fish                  |
      | Stock Adjustments | Transfer Back From A Dept | Return from Fresh To Go           |
      | Stock Adjustments | Transfer Back From A Dept | Return from Meat                  |
      | Stock Adjustments | Transfer Back From A Dept | Return from Oven Baked            |
      | Stock Adjustments | Transfer Back From A Dept | Return from Pie Shop              |
      | Stock Adjustments | Transfer Back From A Dept | Return from Cafe                  |
      | Stock Adjustments | Transfer Back From A Dept | Return from Staff Room            |
      | Stock Adjustments | Transfer Back From A Dept | Return from Pharmacy (TRIAL ONLY) |

  @sma
  Scenario Outline: Validate all Reason code in Adjustment codes - Other Adjustments
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page

    Examples:
      | MenuOptions       | adjustmentCode    | reasoncode                    |
      #######| Stock Adjustments | Other Adjustments | Charity Donation|
      ########| Stock Adjustments | Other Adjustments | Donation - Reverse|
      | Stock Adjustments | Other Adjustments | In Store Use                  |
      | Stock Adjustments | Other Adjustments | In Store Use – Reverse        |
      | Stock Adjustments | Other Adjustments | Record Insurance Loss         |
      | Stock Adjustments | Other Adjustments | Insurance Loss Reverse        |
      | Stock Adjustments | Other Adjustments | Fridge Breakdown              |
      | Stock Adjustments | Other Adjustments | Breakdown Reverse             |
      | Stock Adjustments | Other Adjustments | Non M Forecourt Transfer      |
      | Stock Adjustments | Other Adjustments | Non M Forecourt Reversal      |
      | Stock Adjustments | Other Adjustments | In-Store Tasting (TRIAL ONLY) |

  @sma
  Scenario Outline: Store To Store Transfer - Invalid Store ID, message should popup
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    And I Select store"<storeIDs>" to transfer
    Then I verify the error message"<message>" is displayed

    Examples:
      | MenuOptions       | storeIDs | message                                                            | adjustmentCode          |
      | Stock Adjustments |     9999 | The store number entered does not match a store. Please try again. | Store To Store Transfer |
      | Stock Adjustments |     3333 | The store number entered does not match a store. Please try again. | Store To Store Transfer |

  @sma
  Scenario Outline: select valid store and store number should be available for transfer
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    And I Select store"<storeIDs>" to transfer
    Then I verify the store "<storeIDs>" is availabel for transfer

    Examples:
      | MenuOptions       | storeIDs | adjustmentCode          |
      | Stock Adjustments |        2 | Store To Store Transfer |
      | Stock Adjustments |       89 | Store To Store Transfer |

#  @sma
#  Scenario Outline: verify sucessfull store to store transfer - SA
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on "<MenuOptions>"
#    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
#    And I Select store"<storeIDs>" to transfer
#    Then I verify the store "<storeIDs>" is availabel for transfer
#    And I click on the given "<storeIDs>" storeid
#    And I search for "<Barcode1>"
#    And I enter "<quantity>" for adjustment
#    Then I click on confirm button
#    And I search for "<Barcode2>"
#    And I enter "<quantity>" for adjustment
#    Then I click on confirm button
#    And I click on listView
#    Then I click on Submit Button
#    And I confirm Submit List
#    Then I verify scuccess "<Message>"
#    Then I click on done on the messagebox
#    And I click on Back Button
#    And I click on Back Button
#    Then I click on Stock Information
#    And I search for "<Barcode1>"
#    And I click on stock
#    Then I verify under Today reason code "<adjustmentCode>" and "<quantity>"
#
#    Examples:
#      | MenuOptions       | storeIDs | adjustmentCode          | Barcode1  | Barcode2  | quantity | Message                                                      |
#      | Stock Adjustments |        2 | Store To Store Transfer | 100688560 | 100404555 |        4 | All items were submitted successfully. Tap on Done to leave. |
#      | Stock Adjustments |        1 | Store To Store Transfer | 100688560 | 100404555 |        4 | All items were submitted successfully. Tap on Done to leave. |

  @sma
  Scenario Outline: stockAdjustment for reasoncode other then store to store transfer
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I search for "<Barcode>"
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    And I click on listView
    Then I click on Submit Button
    And I confirm Submit List
    Then I verify scuccess "<Message>"

    Examples:
      | MenuOptions       | adjustmentCode            | Barcode   | quantity | reasoncode         | Message                                                      |
      | Stock Adjustments | Transfer Back From A Dept | 100402904 |        2 | Return from Bakery | All items were submitted successfully. Tap on Done to leave. |
      | Stock Adjustments | Transfer Back From A Dept | 100402904 |        2 | Return from Bakery | All items were submitted successfully. Tap on Done to leave. |
      #| Stock Adjustments | Other Adjustments         | 100402980 |        3 | Withdrawal - Hold  | All items were submitted successfully. Tap on Done to leave. |
      | Stock Adjustments | Transfer Stock To A Dept  | 100404555 |        4 | Transfer to Bakery | All items were submitted successfully. Tap on Done to leave. |
      | Stock Adjustments | Wastage                   | 100404563 |        5 | Waste - Damaged      | All items were submitted successfully. Tap on Done to leave. |

  @sma
  Scenario Outline: verify on click of cross button 24 hours message is displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I search for "<Barcode>"
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    Then I click on cross Button
    And I verify Stock Adjustment Message"<message>"

    Examples:
      | MenuOptions       | adjustmentCode            | Barcode   | quantity | reasoncode         | message                                                                                                        |
      | Stock Adjustments | Transfer Back From A Dept | 100402904 |        2 | Return from Bakery | Your Stock Adjustment list will be saved on this device for 24 hours. After 24 hours the list will be deleted. |

  @sma
  Scenario Outline: verify on click of cross button 24 hours message is displayed, resume option
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I search for "<Barcode>"
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    Then I click on cross Button
    And I verify Stock Adjustment Message"<message>"
    Then I click on "<MenuOptions>"
    Then I verify resume new option is displayed with "<messagee>" to continue
    Examples:
      | MenuOptions       | adjustmentCode            | Barcode   | quantity | reasoncode         | message                                                                                                        | messagee                                                                                                          |
      | Stock Adjustments | Transfer Back From A Dept | 100402904 |        2 | Return from Bakery | Your Stock Adjustment list will be saved on this device for 24 hours. After 24 hours the list will be deleted. | You have a saved Stock Adjustment list on this device. Choose Resume to continue or New to start a new adjustment |

  @sma
  Scenario Outline: verify on click of resume user is redirected to same product list which he has scanned
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I search for "<Barcode>"
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    Then I click on cross Button
    And I verify Stock Adjustment Message"<message>"
    Then I click on "<MenuOptions>"
    Then I verify resume new option is displayed with "<messagee>" to continue
    Then I click on option Resume
    And I click on listView
    Then I verify the product "<Barcode>"

    Examples:
      | MenuOptions       | adjustmentCode            | Barcode   | quantity | reasoncode         | message                                                                                                        | messagee                                                                                                          | optionresumenew |
      | Stock Adjustments | Transfer Back From A Dept | 100402904 |        2 | Return from Bakery | Your Stock Adjustment list will be saved on this device for 24 hours. After 24 hours the list will be deleted. | You have a saved Stock Adjustment list on this device. Choose Resume to continue or New to start a new adjustment | Resume          |

  @sma
  Scenario Outline: verify on click of new user is redirected to Stock Adjustment home screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I search for "<Barcode>"
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    Then I click on cross Button
    And I verify Stock Adjustment Message"<message>"
    Then I click on "<MenuOptions>"
    Then I verify resume new option is displayed with "<messagee>" to continue
    Then I click on option New
    And I verify user is redirected to Stock Adjustment home screen

    Examples:
      | MenuOptions       | adjustmentCode            | Barcode   | quantity | reasoncode         | message                                                                                                        | messagee                                                                                                          | optionresumenew |
      | Stock Adjustments | Transfer Back From A Dept | 100402904 |        2 | Return from Bakery | Your Stock Adjustment list will be saved on this device for 24 hours. After 24 hours the list will be deleted. | You have a saved Stock Adjustment list on this device. Choose Resume to continue or New to start a new adjustment | New             |

  @sma
  Scenario Outline: verify on click of hot key to main menu from capture screen redirects user to home screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I search for "<Barcode>"
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    Then I click on Back to home screen from HotKey Feature
    And I verify, I am on Home Screen

    Examples:
      | MenuOptions       | adjustmentCode            | Barcode   | quantity | reasoncode         | message                                                                                                        | messagee                                                                                                          | optionresumenew |
      | Stock Adjustments | Transfer Back From A Dept | 100402904 |        2 | Return from Bakery | Your Stock Adjustment list will be saved on this device for 24 hours. After 24 hours the list will be deleted. | You have a saved Stock Adjustment list on this device. Choose Resume to continue or New to start a new adjustment | New             |

  @sma @testzzz
  Scenario Outline: Adjustment Should reflect in SI
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>"
    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
    Then I verify reason code "<reasoncode>" on stockAdjustment Page
    And I click on the reason code "<reasoncode>"
    And I search for "<Barcode>"
    And I enter "<quantity>" for adjustment
    Then I click on confirm button
    And I click on listView
    Then I click on Submit Button
    And I confirm Submit List
    Then I verify scuccess "<message>"
    Then I click on done on the messagebox
    And I click on Back Button
    And I click on Back Button
    Then I click on Stock Information
    And I search for "<Barcode>"
    And I click on stock
    Then I verify under Today reason code "<reasoncode>" and "<quantity>"

    Examples:
      | MenuOptions       | adjustmentCode            | Barcode   | quantity | reasoncode         | message                                                      | optionresumenew |
      | Stock Adjustments | Transfer Back From A Dept | 104176342 |        2 | Return from Bakery | All items were submitted successfully. Tap on Done to leave. | New             |
#
###########################################Donot run below Scenarios
##       @sma
##  Scenario Outline: Production Defect SMA-32452
##    When I enter Username and Password for SMA Collegue user
##    And I click on login button for SMA
##    Then I click on "<MenuOptions>"
##    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
##    #Then I verify reason code "<reasoncode>" on stockAdjustment Page
##    #And I click on the reason code "<reasoncode>"
##        And I search for "<Barcode>"
##    And I click on the reason code "<wastageReasonCode>"
##    And I enter "<quantity>" for adjustment
##    Then I click on confirm button
##    Then I click on cross Button
##    And I verify Stock Adjustment Message"<message>"
##    Then I click on "<MenuOptions>"
##    Then I verify resume new option is displayed with "<messagee>" to continue
##    Then I click on option Resume
##    And I click on listView
##    Then I verify the product "<Barcode>"
##    Given a request is made to Stock Adjustment get service for "<storeId>" and product "<itemId>"
##    When the request is made to the specified Stock Adjustment service
##    Then the service should return details for specified stock Adjustment service
##
##
##    ##92501025140130800075500105
##    Examples:
##      | storeId | itemId    | MenuOptions       | adjustmentCode | Barcode                    | quantity | wastageReasonCode | message                                                                                                        | messagee                                                                                                          | optionresumenew |
##      |      78 | 102883094 | Stock Adjustments | Wastage        | 92501025140130800075500105 |        2 | Waste Out of Date | Your Stock Adjustment list will be saved on this device for 24 hours. After 24 hours the list will be deleted. | You have a saved Stock Adjustment list on this device. Choose Resume to continue or New to start a new adjustment | Resume          |
##
##
##    #######-- Wastage Code
##    @sma
##  	Scenario Outline: Validate all Reason code in Adjustment codes - Wastage
##    When I enter Username and Password for SMA Collegue user
##    And I click on login button for SMA
##    Then I click on "<MenuOptions>"
##    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
##  	And I click on barcode entry Button
##    Then Enter "<Barcode>" number
##    Then I verify reason code "<reasoncode>" on stockAdjustment Page
##
##    Examples:
##      | MenuOptions       | adjustmentCode | reasoncode          |			Barcode			|
##      | Stock Adjustments | Wastage        | Waste Damaged/Fruit & Veg Quality or Condition|103304411|
##      | Stock Adjustments | Wastage        | Waste Out of Date   |103304411|
##      | Stock Adjustments | Wastage        | Waste Charity		|103304411|
##      | Stock Adjustments | Wastage        | Waste Reversal    |103304411|
##      | Stock Adjustments | Wastage        | Too Good To Go     |103304411|
##
##       @sma
##      Scenario Outline: Verify Scanning functionality,when user click on the wastage and scanning is done with "<MIN Type>",quantity and wastage reason codes are displayed
##
##	    When I enter Username and Password for SMA Collegue user
##	    And I click on login button for SMA
##	    Then I click on "<MenuOptions>"
##	    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
##	        And I search for "<Barcode>"
##	    And I enter "<quantity>" for adjustment
##		Then I verify reason code "<reasoncode>" on stockAdjustment Page
##	    And I click on the reason code "<reasoncode>"
##		Then I click on confirm button
##
##	    Examples:
##	      | MenuOptions       | adjustmentCode | reasoncode          							|MIN Type	|Barcode	|quantity	|
##	      | Stock Adjustments | Wastage        | Waste Damaged/Fruit & Veg Quality or Condition |MIN|105201870|10|
##	      | Stock Adjustments | Wastage        | Waste Out of Date   							|Barcode/EAN|103066117|11|
##	      | Stock Adjustments | Wastage        | Waste Charity									|QR Code|	107274976|12|
##	      | Stock Adjustments | Wastage        | Waste Reversal		   							|Price Embedded|2323363000000|13|
##	      | Stock Adjustments | Wastage        | Too Good To Go     							|Markdown Barcode|92501025140130800075500105|14|
##	      | Stock Adjustments | Wastage        | Too Good To Go     							|PIN|109129705|15|
##
##	    @sma
##	    Scenario Outline: Verify 'Weighted Product' pop up message is displayed when price embedded or KG products are scanned using Min
##
##  		When I enter Username and Password for SMA Collegue user
##	    And I click on login button for SMA
##	    Then I click on "<MenuOptions>"
##	    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
##	        And I search for "<Barcode>"
##	    And I verify Message "<message>"
##
##	    Examples:
##	      | MenuOptions       | adjustmentCode | reasoncode          |MIN Type	|Barcode	|quantity	|message	|
##	      | Stock Adjustments | Wastage        | Waste Charity       |VPLU/VPLUBC|108728861	|10|To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?|
##
##        @sma
##	    Scenario Outline: Verify KG display on the wastage screen in the application in between quantity and confirm button when KG products are scanned Price embedded barcode
##
##  		When I enter Username and Password for SMA Collegue user
##	    And I click on login button for SMA
##	    Then I click on "<MenuOptions>"
##	    Then I click on Adjustmentcode "<adjustmentCode>" on stockAdjustment Page
##	        And I search for "<Barcode>"
##		Then I click Yes button
##		And I verify KG is Displayed
##
##	    Examples:
##	      | MenuOptions       | adjustmentCode | reasoncode          |MIN Type	|Barcode	|quantity	|
##	      | Stock Adjustments | Wastage        | Waste Charity       |VPLU/VPLUBC|108728861	|10|