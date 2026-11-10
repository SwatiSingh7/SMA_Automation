@StockAdjustmentDemo
Feature: Performing action waste from stock adjustment

  @sma @WV_Before1130_Action_Waste @check
  Scenario Outline: Record Action Waste Before 11:30 AM
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I search for "<minID1>"
    And I click on dynamic "<actionWaste1>" "sLocatorName" on page 'CountsPO'
#    And I click on "<actionWaste>" on Action Waste Page
    And I enter the desired quantity "<quantity1>" and confirm the same
    And I search for "<minID2>"
    And I click on dynamic "<actionWaste2>" "sLocatorName" on page 'CountsPO'
#    And I click on "<actionWaste>" on Action Waste Page
    And I enter the desired quantity "<quantity2>" and confirm the same
    And I search for "<minID3>"
    And I click on dynamic "<actionWaste3>" "sLocatorName" on page 'CountsPO'

    And I enter the desired quantity "<quantity3>" and confirm the same
    And click on the List View
    And I confirm the Submit List
    Then I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    Then I verify scuccess "<message>"
    And I get the product details for following item "<minID1>"
    #Then I delete the item "<Item>"
    Then I verify the Response Code for the item "<minID1>"
    Then I report the response status for the item "<minID1>"
    And I get the product details for following item "<minID2>"
    Then I verify the Response Code for the item "<minID2>"
    Then I report the response status for the item "<minID2>"
    And I get the product details for following item "<minID3>"
    Then I verify the Response Code for the item "<minID3>"
    Then I report the response status for the item "<minID3>"
    Examples:
      | homePageOption    | stockAdjustmentOption | actionWaste1          | minID1    | quantity1 | actionWaste2          | minID2    | quantity2 | actionWaste3          | minID3    | quantity3 | message                                |
      | Stock Adjustments | Action Waste          | Charity - Damaged     | 111890501 | 9         | Waste - Out of Date     | 112537945 | 9         | Waste - Damaged     | 103090580 | 9         | All items were submitted successfully. |
#      | Stock Adjustments | Action Waste          | Waste - Out of Date   | 105201870 | 9         | Waste - Out of Date   | 102377108 | 9         | Waste - Out of Date   | 100155368 | 9         | All items were submitted successfully. |
#      | Stock Adjustments | Action Waste          | Charity - Out of Date | 110307652 | 9         | Charity - Out of Date | 111508376 | 9         | Charity - Out of Date | 108304663 | 5         | All items were submitted successfully. |
#      | Stock Adjustments | Action Waste          | Waste - Reverse       | 111449994 | 9         | Waste - Reverse       | 111508317 | 9         | Waste - Reverse       | 108803358 | 5         | All items were submitted successfully. |
#      | Stock Adjustments | Action Waste          | Waste - Damaged       | 105709930 | 5         | Waste - Damaged       | 102800789 | 5         | Waste - Damaged       | 107091248 | 9         | All items were submitted successfully. |

  @sma @WV_Before1130_Action_WasteWithQuantity>10 @MoreThan10Qtycheck
  Scenario Outline: Record Action Waste Before 11:30 AM
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I search for "<minID1>"
    And I click on dynamic "<actionWaste1>" "sLocatorName" on page 'CountsPO'
#    And I click on "<actionWaste>" on Action Waste Page
    And I enter the desired quantity "<quantity1>" and confirm the same
    And click on the List View
    And I confirm the Submit List
    Then I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    Then I verify scuccess "<message>"
    #Then I should get a Message saying "<message>" and should be able to click the "CANCEL" Button
    Examples:
      | homePageOption    | stockAdjustmentOption | actionWaste1      | minID1    | quantity1 | actionWaste2        | message                                                                                       |
      | Stock Adjustments | Action Waste          | Charity - Damaged | 111890501 | 11        | Waste - Out of Date | You have entered a quantity of 10 units or more.\n\nPlease confirm that 11 units are correct. |