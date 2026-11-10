@waste_validation2
Feature: Verify Waste Validation Module 2

  @timeChange @WV_After1130
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 9     | 02   | am       |

  @sma @WV_After1130_MU_ValidationChecks
  Scenario Outline: Verify “No trays or products validated today” message
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "<homePageOption>" on Home Page
    And I click on "<stockAdjustmentOption>" on Stock Adjustment Page
    And I click on "<wasteValidationOption1>" on Waste Validation Page
    And I create "<noOfTrays>" trays
    And I verify No Waste Generated "<message1>" on screen
    And click on Confirm button on Complete Check screen
    And verify the Validation Check Status is "<validationCheckStatus>"
    And verify the Review Status is "<reviewStatus>"
    And I click on "<wasteValidationOption2>" on Waste Validation Page
    And I click on "All" and verify "<message2>"
    And I click on "Pass" and verify "<message2>"
    And I click on "Fail" and verify "<message2>"
    And I click on "Back" button
    And I click on "<wasteValidationOption1>" on Waste Validation Page
    And I verify Empty Tray "<message3>" on screen

    Examples:
      | homePageOption    | stockAdjustmentOption | wasteValidationOption1 | noOfTrays | wasteValidationOption2 | message1           | validationCheckStatus | reviewStatus | message2                                  | message3                                             |
      | Stock Adjustments | Waste Validation      | Validation Checks      | 0         | Review                 | No Generated Waste | COMPLETE              | REVIEW READY | No trays or products were validated today | No trays/containers were added for validation today. |

