@weekly_manager_signoff
Feature: Waste Validation - Weekly Manager SignOff

  @sma
  Scenario: Weekly Manager SignOff before SignOff
  --Prerequisite: Waste Action and Validation Check should be performed earlier for the previous week
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I verify Weekly Manager Sign Off status "AWAITING SIGN OFF"
    And I click on "Weekly Manager Sign Off" on Waste Validation Page
    And I verify date range and Weekly Manager Sign Off status "AWAITING SIGN OFF"
    And I verify unrecorded waste as Weekly Manager
    And I verify Weekly Wastage Validation Completion is displayed
    And I verify Weekly Weekly Department Completion is displayed
    And I verify list of days with the status "COMPLETE"
    And I verify list of days with status "INCOMPLETE"
    And I click on any day system should redirect to "CHECKS" tab
    And I click on "Back" button
    And I verify "SIGN OFF" button is displayed
    And I click on Weekly Wastage Validation Completion view
    And I view two tabs "CHECKS" and "DEPARTMENTS"
    And I click Departments tab
    And I click on "Back" button
    And I click on Weekly Department Completion view
    And I click Checks tab
    And I verify item check details for a day if all trays are completed with "COMPLETE" status
    And I verify item check details for a day if no trays are completed with "INCOMPLETE" status
    And I click Departments tab
    And I verify Department,Pass,Fail,Waste column
    And I verify Department Waste column is in descending order
    And I click on "Back" button
    And I click on "SIGN OFF" button
    And I verify Store manager weekly sign off at top
    And I verify date of previous week at top
    And I verify Please confirm that you have completed the following before signing off is displayed
    And I verify four check boxes
    And I verify Reviewed the weekly activity is displayed
    And I verify Reviewed all in store waste areas and confirm all waste in areas conforms to policy is displayed
    And I verify Spoken to departments with high unrecorded waste is displayed
    And I verify Actions next steps documented is displayed
    And I verify Able to view text field to write comments if any is displayed
    And I able to check all boxes and click sign off









