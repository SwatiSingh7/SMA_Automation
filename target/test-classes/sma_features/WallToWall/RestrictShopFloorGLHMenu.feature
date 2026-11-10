@W2WRestrictshopfloorGLHMenu @regression
Feature: Wall to Wall - SMA Changes- Restrict Shop floor GLH menu

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 06    | 00   | am       |


@sma
  Scenario Outline: TC_01 To check Colleague user should get restriction popup for AM GLH functionality when Wall to Wall count scheduled Day 1
  When  I enter Username and Password for SMA Collegue user
  And  I click on login button for SMA
  Then  I click on Gaps,Low,High
  Then  I click on AM Gaps Lows High
  And I verify "<Message>" message is displayed
    And I click on OK

  Examples:
    | Message               |
    |  Functionality Locked |

  @sma
  Scenario Outline: TC_02 To check Colleague user should get restriction popup for AM GLH functionality when Wall to Wall count scheduled Day 2
    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Gaps,Low,High
    Then  I click on AM Gaps Lows High
    And I verify "<Message>" message is displayed
    And I click on OK

    Examples:
      | Message               |
      |  Functionality Locked |
  @sma
  Scenario Outline: TC_03 To check Colleague user should get restriction popup for AM GLH functionality when Wall to Wall count scheduled Day 3
    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Gaps,Low,High
    Then  I click on AM Gaps Lows High
    And I verify "<Message>" message is displayed
    And I click on OK

    Examples:
      | Message               |
      |  Functionality Locked |


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 35   | am       |

  @sma
  Scenario Outline: TC_04 To check Colleague user should get restriction popup for AM GLH functionality when Wall to Wall count scheduled Day 1
    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Gaps,Low,High
    Then  I click on AM Gaps Lows High
    And I verify "<Message>" message is displayed
    And I click on OK

    Examples:
      | Message               |
      |  Functionality Locked |

  @timeChange @TC_06
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 12    | 30   | pm       |


#     Should get submission closed on day 1 store 1 at 12:30 pm as per scenario
  @sma
  Scenario Outline: TC_05 To check Colleague user should get error "Submission Closed" for AM GLH functionality when Wall to Wall count scheduled (For Store 1 and Day 1st Time 12:30PM)
    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Gaps,Low,High
    Then  I click on AM Gaps Lows High
    And I verify "<Message>" message is displayed
    And I click on OK

    Examples:
      | Message               |
      |  Submissions Closed |

# Day 4 should be configured
  @sma @TC_06
  Scenario Outline: TC_06 To check Colleague user should able to proceed AM GLH functionality in store 4 on day 4 @12:30 AM when wall to wall count restriction revoked.

    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Gaps,Low,High
    Then  I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button

    Examples:
      |    MIN            |
      |  111021841        |

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 00   | am       |

    # Day 4 should be configured
  @sma
  Scenario Outline: TC_07 To check Colleague user should able to proceed AM GLH functionality in store 4 on day 4 @09:00 AM when wall to wall count restriction revoked.

    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Gaps,Low,High
    Then  I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button

    Examples:
      |    MIN            |
      |  111021841        |


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 12    | 30   | am       |

#    need to configure where api is failed
  @sma @TC_08
  Scenario Outline: TC_08 To check Colleague user should able to proceed AM GLH functionality in store 5 on day 3 @12:30 AM when wall to wall count scheduled status is failed and restiction revoked.

    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Gaps,Low,High
    Then  I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on Back Button

    Examples:
      |    MIN            |
      |  111021841        |



