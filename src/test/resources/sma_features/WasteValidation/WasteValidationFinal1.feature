@waste_validation1
Feature: Verify Waste Validation Module
  Background: To digitize the waste check validation process through SMA by providing a waste bag check per day.
  Giving a provision to the manager for scanning any item from the bag and automatically informing whether pass
  or fail based on whether wastage had performed yesterday in any process. Allow data to be captured on completion
  and communicate through email and through centrally at GCP. Automatically waste the items which were found as not wasted
  and record under new waste code of “unrecorded waste”.
  Need flexibility to increase or decrease number for checks per bag (up and down) through auto flex logic
  depending on store performance and also have ability to change universal or store level Base value,
  Cut off value which can be amended by change request process if no admin panel.
  Need an ability to capture the quantities (stated count by manager performing) of quantity in back up for backhaul
  prior to start and number on this check in order to keep Logistics informed of quantity collection by store
  and ensure 100% basket checks using data and reporting to identify misses.
  The following automation scripts will cover the functional scenarios for the above solution.
  Pre-requisites : We need three stores for performing waste validation regression and hence we have three diffrent feature files for Waste Validation.
  We need to run the following queries before running the regression scenarios :
  For deleting recorded waste :
  delete from stock_adjustment where location_id='4' and date(created_on)='2022-03-11';
  For deleting waste validation records :
  delete from tray_items where tray_items_date = '2022-03-11' and tray_id ilike '%-4-%';
  delete from trays where tray_date = '2022-03-11' and store_id='4';
  delete from backhaul where backhaul_date= '2022-03-11' and store_id='4' ;
  delete from wastevalidation where waste_validation_date = '2022-03-11' and store_id='4';
  Only if the above scripts are run the automation scripts would gurantee a proper result.

  @timeChange @WV_Before1130_1030
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 10    | 30   | am       |

  @sma @WV_FCC_Before1130
  Scenario Outline: Record Action Waste Before 11:30 AM (FCC)
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
##    Then I click on the main menu "Code Checking"
##    Then I click on "Fresh Code Check"
    And I click on "<fccOption>" on Fresh Code Check Page
    And I search for "<minID>"
    And I select "<action>" from the dropdown
    And I select the date <dateRange>
    And I enter the desired quantity "<quantity>" and Log product
    And I select the "<wastageReason>" and confirm
    And click on the List View
    And I confirm Clearance Bay Check and continue
    Examples:
      | homePageOption   | fccOption                        | minID     | quantity | action  | dateRange | wastageReason       |
      | Fresh Code Check | Pre-Opening Clearance Bay Checks | 105236511 | 8        | Wastage | 1         | Waste - Out of Date |

  @sma @WV_Before1130_Action_Waste
  Scenario Outline: Record Action Waste Before 11:30 AM
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I click on "<actionWaste>" on Action Waste Page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    And I search for "<minID2>"
    And I enter the desired quantity "<quantity2>" and confirm the same
    And I search for "<minID3>"
    And I enter the desired quantity "<quantity3>" and confirm the same
    And click on the List View
    And I confirm the Submit List
    Then I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    Then I verify scuccess "<message>"
    Then I click on 'doneButton' on page 'PopUpPO_New'
#    Then I should get a Message saying "<message>" and should be able to click the "Done" Button
    Examples:
      | homePageOption    | stockAdjustmentOption | actionWaste           | minID1    | quantity1 | minID2    | quantity2 | minID3    | quantity3 | message                                                      |
      | Stock Adjustments | Action Waste          | Charity - Damaged     | 100402904 | 9         | 108684782 | 9         | 103090580 | 9         | All items were submitted successfully. Tap on Done to leave. |
      | Stock Adjustments | Action Waste          | Waste - Out of Date   | 105201870 | 9         | 102377108 | 9         | 100155368 | 9         | All items were submitted successfully. Tap on Done to leave. |
      | Stock Adjustments | Action Waste          | Charity - Out of Date | 110307652 | 9         | 111508376 | 9         | 108304663 | 5         | All items were submitted successfully. Tap on Done to leave. |
      | Stock Adjustments | Action Waste          | Waste - Reverse       | 111449994 | 9         | 111508317 | 9         | 108803358 | 5         | All items were submitted successfully. Tap on Done to leave. |
      | Stock Adjustments | Action Waste          | Waste - Damaged       | 105709930 | 5         | 102800789 | 5         | 107091248 | 9         | All items were submitted successfully. Tap on Done to leave. |

  @sma @WV_Before1130_WV_Check
  Scenario Outline: Verify that Waste Validation cannot be performed before 11:30 AM
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I click on "<wasteValidationOption>" on Waste Validation Page
    Then I should get a title saying "Validation Checks Submissions Closed" and a message saying "<message>"
    Examples:
      | homePageOption    | stockAdjustmentOption | wasteValidationOption | message                                                                                                                  |
      | Stock Adjustments | Waste Validation      | Validation Checks     | The submission window for waste validation is not open. \n\nPlease return and complete this task between 11:30 and 13:30. |

  @timeChange @WV_After1130
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 11    | 40   | am       |

  @sma @WV_After1130_CU
  Scenario Outline: Waste Validation Check E2E for Collegue user
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    Then "Action Waste" should get displayed on Stock Adjustment Page
    Then "<stockAdjustmentOption>" should not get displayed on Stock Adjustment Page
    Examples:
      | homePageOption    | stockAdjustmentOption |
      | Stock Adjustments | Waste Validation      |

  @sma @WV_After1130_MU
  Scenario Outline: Waste Validation Check E2E for Manager user with negative scenario for tray creation
  --Prerequisite: Weekly Manager sign off will show status "Awaiting sign off / Signed off" only if waste validation is performed last week, else it will be disabled.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    Then "Action Waste" should get displayed on Stock Adjustment Page
    Then "<stockAdjustmentOption>" should get displayed on Stock Adjustment Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I verify "Review" is "Disable" and the next page option is "All"
    And I verify "Validation Checks" is "Enable" and the next page option is "Trays & Charity Containers for waste validation today"
    And I verify "Backhaul" is "Disable" and the next page option is "Trays for Backhaul"
    And I verify "Weekly Manager Sign Off" is "Enable" and the next page option is "Total Unrecorded Value"
##    And I verify "Weekly Manager Sign Off" is "Disable" and the next page option is "Total Unrecorded Value"
    And I verify Weekly Manager Sign Off status "AWAITING SIGN OFF"
##    And I verify Weekly Manager Sign Off status "SIGNED OFF"
    And I click on "<wasteValidationOption>" on Waste Validation Page
    Then I should get the header saying "Trays & Charity Containers for waste validation today" and description saying "<message3>"
    And I create "100" trays
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button
    And I create "4" trays
    And I click on "Back" button
    And verify the Validation Check Status is "IN PROGRESS"
    And I click on "<wasteValidationOption>" on Waste Validation Page
    And I add a new tray by clicking on Add Button
    Then I should get a Message saying "Are you sure you want to add a new tray/ container?" and should be able to click the "Continue" Button
    And I verify that following trays are created
      | Tray/ Container 1 |
      | Tray/ Container 2 |
      | Tray/ Container 3 |
      | Tray/ Container 4 |
      | Tray/ Container 5 |
    And I select tray "1"
    And I search for "105709930"
    And I enter the desired quantity "5" and confirm the same
    And I search for "102800789"
    And I enter the desired quantity "9" and confirm the same
    And I search for "107091248"
    And I enter the desired quantity "2" and confirm the same
    And I search for "102760916"
    And I enter the desired quantity "5" and confirm the same
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message2>" and should be able to click the "Continue" Button
    Examples:
      | homePageOption    | stockAdjustmentOption | wasteValidationOption | message1                                                                                                       | message2                                                                                                                                                              | message3                                                                                                                                                                                                         |
      | Stock Adjustments | Waste Validation      | Validation Checks     | Please check the number of trays/containers you have entered.\n\nThe maximum number of trays/containers is 99. | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone. | Please state how many trays and charity containers you have for waste validation today.\n\nToo Good to Go bags created today should also be checked.\n\nPlease include 1 tray to check all \nToo Good to Go Bags.|

  @sma @WV_After1130_MU_ValidationChecks
  Scenario Outline: Validation Check Scenario covering the entire flow and recording all types of waste in different trays
  --Prerequisite: Set autoflex_count = 6 for the store before execution
  --Prerequisite: Large Qty pop-up occurs from 11 since largeQty is set 10 in config file. If largeQty is not set in config file, then Large Qty pop-up occurs from 10.
  --Prerequisite: Weekly Manager sign off will show status "Awaiting sign off / Signed off" only if waste validation is performed last week, else it will be disabled.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "2"
##   Verify Add to count by scanning same MIN again
    And I search for "111449994"
    And I enter the desired quantity "3" and confirm the same
    And I search for "111449994"
    And I verify "ADD TO COUNT" and "EDIT COUNT" buttons displayed on screen
    And I click on Add to Count Button
    And I enter the desired quantity "3" and confirm the same
    Then I verify the new count is added with existing count
      | 6 |
##   Verify Edit count by scanning same MIN again
    And I search for "111508317"
    And I enter the desired quantity "5" and confirm the same
    And I search for "111508317"
    And I click on Edit Button
    And I enter the desired quantity "8" and confirm the same
    Then I verify the new count is replaced with existing count
      | 8 |
##  Verify wastage from waste recorded from FCC
    And I search for "105236511"
    And I enter the desired quantity "5" and confirm the same
    And click on the List View
    And I verify "COMPLETE TRAY" button displayed on screen
    And I complete the tray
##   Verify Threshold not met pop-up
    Then I should get a pop up title saying "Item Threshold Not Met"
    Then I should get a Message saying "<message1>" and should be able to click the "Cancel" Button
    Then I verify Product description, Product MIN
      | Hovis Granary 400g |
      | 5                  |
      | 105236511          |
    Then I verify Product description, Product MIN
      | MALTESERS EASTER HUNT MIX 297.8G |
      | 8                                |
      | 111508317                        |
    Then I verify Product description, Product MIN
      | GUYLIAN SEASHELLS EGG 285G |
      | 6                          |
      | 111449994                  |
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button
    Then verify status of tray "COMPLETE"
    And I select tray "3"
##  Verify Threshold is met
    And I search for "100402904"
    And I enter the desired quantity "7" and confirm the same
    And I search for "108684782"
    And I enter the desired quantity "5" and confirm the same
    And I search for "103090580"
    And I enter the desired quantity "8" and confirm the same
    And I search for "105201870"
    And I enter the desired quantity "6" and confirm the same
    And I search for "102377108"
    And I enter the desired quantity "2" and confirm the same
    And I search for "100155368"
    And I enter the desired quantity "9" and confirm the same
## Verify Review & Edit button and products scanned
    And I verify "REVIEW & EDIT" button is displayed on screen
    And I verify "COMPLETE TRAY" button displayed on screen
    And verify screen with title "<title>" and message "<message3>" and I click on "REVIEW & EDIT" button
    Then I verify Product description, Product MIN
      | MARS MALTEASTER BUNNY 29G |
      | 9                         |
      | 100155368                 |
    Then I verify Product description, Product MIN
      | MR KIPLING LEMON FANCIES 8PK |
      | 2                            |
      | 102377108                    |
    Then I verify Product description, Product MIN
      | MIN:M GRATED MATURE WHITE CHEDDAR 250G     |
      | 6                                      |
      | 105201870                              |
    Then I verify Product description, Product MIN
      | OCEAN SPRAY CRANBERRY JUICE 1L |
      | 8                              |
      | 103090580                      |
    Then I verify Product description, Product MIN
      | (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
      | 5                                         |
      | 108684782                                 |
    Then I verify Product description, Product MIN
      | SCHWARTZ R/CHICKEN GRAVY  200G |
      | 7                              |
      | 100402904                      |
    And I complete the tray
    And I select tray "4"
##  Verify Add to count button with click of an item
    And I search for "110307652"
    And I enter the desired quantity "6" and confirm the same
    And click on the List View
    And I click on "<itemScanned1>" from list
    And I verify "ADD TO COUNT" and "EDIT COUNT" buttons displayed on screen
    And I click on Add to Count Button
    And I enter the desired quantity "2" and confirm the same
    Then I verify the new count is added with existing count
      | 8 |
    And I click on "Back" button
##  Verify Edit count button with click of an item
    And I search for "111508376"
    And I enter the desired quantity "3" and confirm the same
    And click on the List View
    And I click on "<itemScanned2>" from list
    And I click on Edit Button
    And I enter the desired quantity "4" and confirm the same
    Then I verify the new count is replaced with existing count
      | 4 |
    And I click on "Back" button
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button
    And I select tray "5"
##  Verify Large Quantity pop-up
    And I search for "108803358"
    And I enter the desired quantity "45" and confirm the same
    Then I should get a pop up title saying "Large Quantity Entered"
    Then I should get a Message saying "<message4>" and should be able to click the "Continue" Button
##   Verify with Markdown barcode
    And I search for "108304663"
    And I enter the desired quantity "8" and confirm the same
    And click on the List View
    And I verify "COMPLETE TRAY" button displayed on screen
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button
##   Verify status of Complete Tray button on adding a tray
    And I verify "COMPLETE CHECK" button is "Enable"
    And I add a new tray by clicking on Add Button
    Then I should get a Message saying "Are you sure you want to add a new tray/ container?" and should be able to click the "Continue" Button
    And I verify "COMPLETE CHECK" button is "Disable"
    And I select tray "6"
##  Verify 0 items are scanned
    And I complete the tray
    Then I should get a Message saying "<message2>" and should be able to click the "Continue" Button
##   Complete the Check
    And I click on Complete Check button
    And I click on Cancel button on Complete Check screen
    And I verify that following trays are created
      | Tray/ Container 1 |
      | Tray/ Container 2 |
      | Tray/ Container 3 |
      | Tray/ Container 4 |
      | Tray/ Container 5 |
      | Tray/ Container 6 |
    And I verify "COMPLETE CHECK" button is "Enable"
    And I verify Add New Tray button is displayed and "Enable"
    And I click on Complete Check button
    And I verify Complete Check "<message5>" on screen
    And I click on Complete & Review button on Complete Check screen
    And I click on "Back" button
    And I click on "Validation Checks" on Waste Validation Page
    And I verify Add New Tray button is displayed and "Disable"
    And I verify "COMPLETE CHECK" button is "Disable"
    And I click on "Back" button
    And verify the Validation Check Status is "COMPLETE"
    And I verify "Review" is "Enable" and the next page option is "All"
    And verify the Review Status is "REVIEW READY"
    And I verify "Backhaul" is "Enable" and the next page option is "Trays for Backhaul"
    And I verify "Weekly Manager Sign Off" is "Enable" and the next page option is "Total Unrecorded Value"
##    And I verify "Weekly Manager Sign Off" is "Disable" and the next page option is "Total Unrecorded Value"
    And I verify Weekly Manager Sign Off status "AWAITING SIGN OFF"
##    And I verify Weekly Manager Sign Off status "SIGNED OFF"

    Examples:
      | title                                          | itemScanned1                                | itemScanned2                                    | message1                                                                                                                                                              | message2                                                                                                                                                 | message3                                                                                                                                            | message4                                                                                             | message5                   |
      | You have completed waste validation for Tray 3 | CADBURY DAIRY MILK WITH OREO EASTER EGG 31G | MILKYBAR WHITE CHOCOLATE LARGE EASTER BUNNY 88G | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone. | You have not captured any items within this tray/ container.\n\nAre you sure you wish to complete this tray/ container?\n\nThis action cannot be undone. | To review the checks done for this waste tray please select the button below.\n\nTo complete the validation of this tray please press Complete Tray | You have entered a large quantity of this item.\n\nIf the quantity is correct please press continue. | Complete Validation Checks |

  @sma @WV_After1130_Review
  Scenario Outline: Verify the review screen for the recorded waste and waste validation performed in the above scenarios
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    #Verifying status of Reivew
    And I Verify the status of review option
    And I click on "<wasteValidationOption>" on Waste Validation Page
    #Verifying date on review page
    And I verify the date on Review page
    #Verifying Review message
    And I verify Review screen message
    #Verifying headers tab of Review page
    And I verify the headers of review option
    # Verify the All tab data
    And I click on "All" tab and verify the following details
      | (B) BEEF BEST BRAISING STEAK |
      | FAIL                           |
      | 102760916                      |
      | 0                              |
      | 5                              |
      | 5                              |
    And I click on "All" tab and verify the following details
      | 'M'SLICED LAMB LIVER |
      | FAIL                 |
      | 102800789            |
      | 5                    |
      | 9                    |
      | 4                    |
    And I click on "All" tab and verify the following details
      | MORRISONS WHOLE SWEDE |
      | FAIL                  |
      | 108304663             |
      | 5                     |
      | 8                     |
      | 3                     |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | MILKYBAR WHITE CHOCOLATE LARGE EASTER BUNNY 88G |
      | PASS                                            |
      | 111508376                                       |
      | 9                                               |
      | 4                                               |
      | -5                                              |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | CADBURY DAIRY MILK WITH OREO EASTER EGG 31G |
      | PASS                                        |
      | 110307652                                   |
      | 9                                           |
      | 8                                           |
      | -1                                          |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | MARS MALTEASTER BUNNY 29G |
      | PASS                      |
      | 100155368                 |
      | 9                         |
      | 9                         |
      | 0                         |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | MR KIPLING LEMON FANCIES 8PK |
      | PASS                         |
      | 102377108                    |
      | 9                            |
      | 2                            |
      | -7                           |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | MIN:M GRATED MATURE WHITE CHEDDAR 250G     |
      | PASS                                   |
      | 105201870                              |
      | 9                                      |
      | 6                                      |
      | -3                                     |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | OCEAN SPRAY CRANBERRY JUICE 1L |
      | PASS                           |
      | 103090580                      |
      | 9                              |
      | 8                              |
      | -1                             |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
      | PASS                                      |
      | 108684782                                 |
      | 9                                         |
      | 5                                         |
      | -4                                        |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | SCHWARTZ R/CHICKEN GRAVY  200G |
      | PASS                           |
      | 100402904                      |
      | 9                              |
      | 7                              |
      | -2                             |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | Hovis Granary 400g |
      | PASS               |
      | 105236511          |
      | 8                  |
      | 5                  |
      | -3                 |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | MORRISONS RASPBERRY TRIFLE 600G |
      | PASS                            |
      | 107091248                       |
      | 9                               |
      | 2                               |
      | -7                              |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | M Kitchen Raspberry Mini Trilfes 6x33g |
      | PASS                                   |
      | 105709930                              |
      | 5                                      |
      | 5                                      |
      | 0                                      |
    #Verify the Pass tab data
    And I click on "Pass" tab and verify the following details
      | MILKYBAR WHITE CHOCOLATE LARGE EASTER BUNNY 88G |
      | PASS                                            |
      | 111508376                                       |
      | 9                                               |
      | 4                                               |
      | -5                                              |
    And I click on "Pass" tab and verify the following details
      | CADBURY DAIRY MILK WITH OREO EASTER EGG 31G |
      | PASS                                        |
      | 110307652                                   |
      | 9                                           |
      | 8                                           |
      | -1                                          |
    And I click on "Pass" tab and verify the following details
      | MARS MALTEASTER BUNNY 29G |
      | PASS                      |
      | 100155368                 |
      | 9                         |
      | 9                         |
      | 0                         |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | MR KIPLING LEMON FANCIES 8PK |
      | PASS                         |
      | 102377108                    |
      | 9                            |
      | 2                            |
      | -7                           |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | MIN:M GRATED MATURE WHITE CHEDDAR 250G     |
      | PASS                                   |
      | 105201870                              |
      | 9                                      |
      | 6                                      |
      | -3                                     |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | OCEAN SPRAY CRANBERRY JUICE 1L |
      | PASS                           |
      | 103090580                      |
      | 9                              |
      | 8                              |
      | -1                             |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
      | PASS                                      |
      | 108684782                                 |
      | 9                                         |
      | 5                                         |
      | -4                                        |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | SCHWARTZ R/CHICKEN GRAVY  200G |
      | PASS                           |
      | 100402904                      |
      | 9                              |
      | 7                              |
      | -2                             |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | Hovis Granary 400g |
      | PASS               |
      | 105236511          |
      | 8                  |
      | 5                  |
      | -3                 |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | MORRISONS RASPBERRY TRIFLE 600G |
      | PASS                            |
      | 107091248                       |
      | 9                               |
      | 2                               |
      | -7                              |
    And I Scroll from 200 800 to 200 250
    And I click on "Pass" tab and verify the following details
      | M Kitchen Raspberry Mini Trilfes 6x33g |
      | PASS                                   |
      | 105709930                              |
      | 5                                      |
      | 5                                      |
      | 0                                      |
    #Verify the Fail tab data
    And I click on "Fail" tab and verify the following details
      | (B) BEEF BEST BRAISING STEAK |
      | FAIL                         |
      | 102760916                    |
      | 0                            |
      | 5                            |
      | 5                            |
    And I click on "Fail" tab and verify the following details
      | 'M'SLICED LAMB LIVER |
      | FAIL                 |
      | 102800789            |
      | 5                    |
      | 9                    |
      | 4                    |
    And I click on "Fail" tab and verify the following details
      | MORRISONS WHOLE SWEDE |
      | FAIL                  |
      | 108304663             |
      | 5                     |
      | 8                     |
      | 3                     |
#    Verifying Waste Reverse Min in All tab
    And I click on tab "All"
    And I verify the waste reversal min "<WRMinID>"
    Examples:
      | homePageOption    | stockAdjustmentOption | wasteValidationOption | WRMinID   |
      | Stock Adjustments | Waste Validation      | Review                | 111449994 |

  @sma @E2E_Waste_Check_Backhaul
  Scenario Outline: SMA-33937 Verify Backhaul end to end functionality
    #Prerequisite: wasteaction and validationcheck should be performed earlier
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Backhaul" on Waste Validation Page
    And I verify backhaul header and tray count description "<message1>"
    And I enter tray quantity "999" and confirm the same
    And I verify backhaul header and Pallet count description "<message2>"
    And I enter pallet quantity "99" and confirm the same
    And I verfiy backhaul overview Screen and description "<message3>"
    And I verify trayquantity "999" and pallet quantity "99"
    And I verify user able to edit count "880" tray for backhaul and pallet for backhaul quantity "88"
    And I click confirm backhaul overview
    And I verify backhaul status "COMPLETE"
    And I click on "Backhaul" on Waste Validation Page
    And I verify user not able edit quantity in backhaul overview screen

    Examples:
      | message1                                                                                                                                                | message2                                                                                                                                                           | message3                                                                         |
      | Please enter the number of trays that are currently waiting to be returned as part of the backhaul process.\n\nIncluding what you have validated today. | Please enter the number of pallets that are currently waiting to be returned as part of the backhaul process.\n\nIncluding any added as part of the process today. | Please check the quantities you have entered are correct and then press confirm. |

  @timeChange @WV_After1
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 1     | 00   | pm       |

  @sma @WV_After1_WV_Check
  Scenario Outline: Verify Deadline Reminder pop-up at 1:00 PM
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    Then I should get a pop up title saying "Deadline Reminder"
    Then I should get a Message saying "<message>" and should be able to click the "OK" Button
    Examples:
      | homePageOption    | stockAdjustmentOption | message                                        |
      | Stock Adjustments | Waste Validation      | The deadline for Waste Validation is 01:30 PM. |

  @timeChange @WV_After130
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 1     | 30   | pm       |

  @sma @WV_After130_WV_Check
  Scenario Outline: Verify that Waste Validation cannot be performed after 1:30 PM
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I click on "<wasteValidationOption>" on Waste Validation Page
    Then I should get a title saying "Validation Checks Submissions Closed" and a message saying "<message>"
    Examples:
      | homePageOption    | stockAdjustmentOption | wasteValidationOption | message                                                                                                                                                                                                                                                 |
      | Stock Adjustments | Waste Validation      | Validation Checks     | The submission window is now closed. \n\nPlease place appropriate trays with the backhaul ready for collection.\n\nDo NOT include these trays in tomorrow's validation check.\n\nAppropriate products will be automatically wasted as unrecorded items. |
#
