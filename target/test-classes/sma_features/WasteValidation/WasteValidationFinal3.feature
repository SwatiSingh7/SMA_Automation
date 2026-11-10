@waste_validation3
Feature: Verify Waste Validation Module 3

#   @timeChange @WV_Before1130
#  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
#    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
#    Then I Change time
#    Examples:
#      | Hours | Mins | Meridiem |
#      | 11    | 05   | am       |
#
#
#  @sma @WV_Before1130_Action_Waste
#  Scenario Outline: Record Action Waste Before 11:30 AM
#    When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    And I click on "<homePageOption>" on Home Page
#    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
#    And I click on "<actionWaste>" on Action Waste Page
#    And I search for "<minID1>"
#    And I enter the desired quantity "<quantity1>" and confirm the same
#    And click on the List View
#    And I confirm the Submit List
#    Then I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
#    Then I should get a Message saying "All items were submitted successfully. Tap on Done to leave." and should be able to click the "Done" Button
#
#    Examples:
#      | homePageOption    | stockAdjustmentOption | actionWaste       | minID1    | quantity1 |
#      | Stock Adjustments | Action Waste          | Waste - Reverse   | 103029762 | 30        |
#      | Stock Adjustments | Action Waste          | Charity - Damaged | 103029762 | 40        |
#      | Stock Adjustments | Action Waste          | Waste - Damaged   | 108684782 | 50        |
#      | Stock Adjustments | Action Waste          | Waste - Reverse   | 108684782 | 20       |
#      | Stock Adjustments | Action Waste          | Waste - Out of Date | 109514064 | 25      |
#      | Stock Adjustments | Action Waste          | Waste - Reverse   | 109514064 | 40        |
#
  @timeChange @WV_After1130
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 11    | 40   | am       |

  @sma @WV_After1130_ValidationCheckNew
  Scenario Outline: Waste Validation Check E2E for Manager user with different type of products
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    Then "Action Waste" should get displayed on Stock Adjustment Page
    Then "<stockAdjustmentOption>" should get displayed on Stock Adjustment Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I click on "<wasteValidationOption>" on Waste Validation Page
    And I create "4" trays
    # Verify Validation check screen message
    And I verify validation check screen message
    And I select tray "1"
    And I search for "108064858"
    And I enter the desired quantity "15" and confirm the same
    Then I should get a Message saying "<message2>" and should be able to click the "CONTINUE" Button
    #Scan PIN instead of MIN
    And I search for "102459867"
    #Verify the Case scanned header for pin
    And verify the case scanned header
    #Verifying multiplication of quantity
    And I enter the quantity "5" and enter package size "6"
### Below commented section is refactored in another feature file of PEB (Below commented lines will fail due to functionality change):
#    Scan KG Products
#    And I search for "106905756"
#    #Verify KG Product scan message
#    Then I should get a Message saying "<message1>" and should be able to click the "NO" Button
#    #Verify enter qty and confirm of KG product
#    And I search for "106905756"
#    Then I should get a Message saying "<message1>" and should be able to click the "YES" Button
#    And I enter the desired quantity "9" and confirm the same
    #Verify View list option functionality after click no on popup
    And I search for "102800789"
    And I enter the desired quantity "9" and confirm the same
    #Verify the VewList option in the page
    And click on the List View
    And I click on "Back" button
    And I click on "Back" button
    # Verify status of tray
    And verify status of tray "IN PROGRESS"
    #And I click on "Back" button
    And I select tray "2"
  ### Below commented section is refactored in another feature file of PEB (Below commented lines will fail due to functionality change):
#    Scan BAR Code instead of MIN
#    And I search for "0206320099000"
#    Then I should get a Message saying "<message1>" and should be able to click the "YES" Button
#    #Verifying min against barcode
#    And I verify the min "102796311" against entered BarCode
#    And I enter the desired quantity "2" and confirm the same
    #Enter Markdown BAR Code instead of MIN
    And I search for "92023678000000200128200013"
    And I verify the min "109706998" against entered BarCode
    And I enter the desired quantity "2" and confirm the same

    And I click on "Back" button
    And I select tray "3"
    And I search for "103029762"
    And I enter the desired quantity "15" and confirm the same
    Then I should get a Message saying "<message2>" and should be able to click the "CONTINUE" Button

    And I search for "108684782"
    And I enter the desired quantity "11" and confirm the same
    Then I should get a Message saying "<message2>" and should be able to click the "CONTINUE" Button

    And I search for "109514064"
    And I enter the desired quantity "9" and confirm the same

    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message3>" and should be able to click the "Continue" Button

    And I select tray "1"
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message3>" and should be able to click the "Continue" Button

    And I select tray "2"
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message3>" and should be able to click the "Continue" Button

    And I click on Complete Check button
    And I click on Complete & Review button on Complete Check screen
    # Pass scenarios

#    And I click on "Pass" tab and verify the following details
#      | (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
#      | PASS                           |
#      | 108684782                      |
#      | 30                             |
#      | 10                             |
#      | -20                            |
#
#    # Fail sceanrio
#    And I click on tab "All"
#    And I verify the waste reversal min "109514064"
#
#    And I Scroll from 200 800 to 200 250
#    And I Scroll from 200 800 to 200 250
#    And I click on "All" tab and verify the following details
#      | FLORA ORIGINAL SPREAD     500G |
#      | FAIL                           |
#      | 103029762                      |
#      | 10                             |
#      | 15                             |
#      | 5                              |

    Examples:
      | homePageOption    | stockAdjustmentOption | wasteValidationOption | message1                                                                                                   | message2                                                                                             | message3                                                                                                                                                              |
      | Stock Adjustments | Waste Validation      | Validation Checks     | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue? | You have entered a large quantity of this item.\n\nIf the quantity is correct please press continue. | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone. |

######################################Waste Validation - PEB enhancement (SMA-45149, SMA-45572)#########################################################################
#
  @sma @WV_ValidationCheckNewEnhancement
  Scenario Outline: Waste Validation Check for PEB enhancement scenarios : SMA-46745
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Action Waste" on Stock Adjustment Page
    And I click on "Charity - Damaged" on Action Waste Page
    ##Scanning Sellable KG MIN/EAN with price 0 (SMA-45149)
    And I search for "108539622"
    Then I should get a pop up title saying "Weighted Product"
    Then I should get a Message saying "To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?" and should be able to click the "Yes" Button
    And I enter the price "0" and I click on confirm button
    And I verify the "CONFIRM" button is "Disable"
    And I enter the price "0.00" and I click on confirm button
    And I verify the "CONFIRM" button is "Disable"
    And I click on "Back" button
    And I search for "0201090000000"
    And verify screen message with title "Price Embedded Barcode" and message "<message>"
    And I verify item selling price "0.00" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I verify the "CONFIRM" button is "Disable"
    And I click on "Back" button
    And I click on "Back" button
    And I click on "Back" button
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "4"
    ##Scanning same EA barcode item in Waste Validation without confirming (SMA-45572)
    And I search for "0299000000000"
    And I enter the quantity as "3"
    And I click on "Back" button
    And I search for "0299000000000"
    And I enter the desired quantity "4" and confirm the same

    Examples:
    |message                                                                                                                                                       |
    |You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease press confirm to validate this product.|


