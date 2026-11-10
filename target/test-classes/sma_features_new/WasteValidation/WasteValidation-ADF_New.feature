@waste_validation_ADF_701
Feature: Verify Waste Validation - ADF Module

  @timeChange @WV_After1130
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time

    Examples:
      | Hours | Mins | Meridiem |
      | 9     | 02   | am       |

  @sma @StckOrdUpdateTask
  Scenario Outline: To update StockV2 service making it down and up
    Given I update the service "<serviceArn>" making it down and up with ClusterName "<ClusterName>"

    Examples:
      | serviceArn                                             | ClusterName                         |
      | stockV2Adjustment_srv_sit-ecs-stkordadptr-task-sit-001 | nonprod-ECS-ECSCluster-W68V9ZHCS399 |

  @sma @WV_After1130_MU
  Scenario Outline: Waste Validation Check simple E2E scenario
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on 'optStockAdjustments' on page 'HomePagePO_New'
    Then I click on 'optWasteValidation' on page 'StockAdjustmentPO_New'
    Then I click on 'ValidationChecksStatus' on page 'WasteValidationPO_New'
    Then I should get the header saying "Trays & Charity Containers for waste validation today" and description saying "<message2>"
    And I create "1" trays
    And I add a new tray by clicking on Add Button
    Then I should get a Message saying "Are you sure you want to add a new tray/ container?" and should be able to click the "Continue" Button
    #Then I click on dynamic "1" "sLocatorName" on page 'WasteValidationPO_New'
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