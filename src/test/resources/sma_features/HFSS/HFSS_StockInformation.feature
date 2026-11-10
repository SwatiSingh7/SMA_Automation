@HFSS_stock_information
Feature: Verify Flag for High Fat Sugar and Salt

  @sma
  Scenario Outline: verify HFSS flag on Stock Information

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I search for "<minID1>"
    And verify HFSS flag is visible
    And Click on HFSS flag view button
    And verify the message on HFSS
    And I click on Back Button
      Examples:
      | minID1   |
#      ###  MIN
#      | 100001667 |
#      #### PIN
#      | 112635967 |
#      ### EAN
#      |5010251501190|
#      ### PEB
#      |0279740045000|
#      ### QR
#      |112700378|
#      ## UAT ENV MIN/PIN
      |100162488|
      |112374322|


  @sma
  Scenario Outline: verify HFSS flag on Price and Promo

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I search for "<minID1>"
    And verify that Price section is visible
    And I click on Price section
    And verify HFSS flag is visible
    And Click on HFSS flag view button
    And verify the message on HFSS
    And I click on Back Button
    And I click on Back Button

    Examples:
      | minID1  |
#      ###  MIN
#      | 100001667 |
#      #### PIN
#      | 112635967 |
#      ### EAN
#      |5010251501190|
#      ### PEB
#      |0279740045000|
#      ### QR
#      |112700378|
  ### UAT ENV MIN/PIN
      |100162488|
      |112374322|

  @sma
  Scenario Outline: verify HFSS flag on Stock Section

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I search for "<minID1>"
    And verify that Stock section is visible
    And I click on Stock record
    And verify HFSS flag is visible
    And Click on HFSS flag view button
    And verify the message on HFSS
    And I click on Back Button
    And I click on Back Button

    Examples:
      | minID1  |
#      ###  MIN
#      | 100001667 |
#      #### PIN
#      | 112635967 |
#      ### EAN
#      |5010251501190|
#      ### PEB
#      |0279740045000|
#      ### QR
#      |112700378|
  ### UAT ENV MIN/PIN
      |100162488|
      |112374322|

  @sma
  Scenario Outline: verify HFSS flag on Space Section

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I search for "<minID1>"
    And I scroll Down
    And verify that Space section is visible
    And I click on Space section
    And verify HFSS flag is visible
    And Click on HFSS flag view button
    And verify the message on HFSS
    And I click on Back Button
    And I click on Back Button

    Examples:
      | minID1  |
      ###  MIN
#      | 100001667 |
#      #### PIN
#      | 112635967 |
#      ### EAN
#      |5010251501190|
#      ### PEB
#      |0279740045000|
#      ### QR
#      |112700378|
  ### UAT ENV MIN/PIN
      |100162488|
      |112374322|

