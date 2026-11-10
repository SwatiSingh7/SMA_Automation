@waste_validation_ADF
Feature: Verify Waste Validation - ADF Module

#  @timeChange @WV_After1130
#  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
#    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
#    Then I Change time
#
#    Examples:
#      | Hours | Mins | Meridiem |
#      | 11    | 40   | am       |

  @sma @WV_After1130_MU
  Scenario Outline: Waste Validation Check simple E2E scenario
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    Then I should get the header saying "Trays & Charity Containers for waste validation today" and description saying "<message2>"
    And I create "1" trays
    And I add a new tray by clicking on Add Button
    Then I should get a Message saying "Are you sure you want to add a new tray/ container?" and should be able to click the "Continue" Button
    And I select tray "1"
    And I search for "105709930"
    And I enter the desired quantity "5" and confirm the same
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message>" and should be able to click the "Continue" Button
    And I select tray "2"
    And I search for "110307652"
    And I enter the desired quantity "3" and confirm the same
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message>" and should be able to click the "Continue" Button
    And I click on Complete Check button
    And I click on Complete & Review button on Complete Check screen
    And I verify the date on Review page
    And I click on "All" tab and verify the following details
      | M Kitchen Raspberry Mini Trilfes 6x33g |
      | FAIL                                   |
      | 105709930                              |
      | 0                                      |
      | 5                                      |
      | 5                                      |
    And I click on "All" tab and verify the following details
      | CADBURY DAIRY MILK WITH OREO EASTER EGG 31G |
      | FAIL                                        |
      | 110307652                                   |
      | 0                                           |
      | 3                                           |
      | 3                                           |

    Examples:
      | message                                                                                                                                                               | message2                                                                                                                                                                                                          |  |
      | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone. | Please state how many trays and charity containers you have for waste validation today.\n\nToo Good to Go bags created today should also be checked.\n\nPlease include 1 tray to check all \nToo Good to Go Bags. |  |