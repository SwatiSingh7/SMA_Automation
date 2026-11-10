@NewfccAlert
Feature: Fresh Code Check Alerts
  
  #fcc phase 1
  @sma @CompleteSchedule
  Scenario Outline: FCC_Alerts_UAT_TC121_Complete the schedule for all the departments for a particular date
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Previous Date"
#    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    Then I complete the schedule for all the departments 'sDeptList' on page 'FCC_PO'.


    Examples:
      | StoreID | Menu             | Department_Menu | SubMenu     | Status      | Location |
      | 8       | Fresh Code Check | Daily Schedule  | First Check | Not Checked | Fixture  |

  @sma @VerfAlertmessage
  Scenario Outline: FCC_Alerts_UAT_TC121_Verify that product count and message displayed when alerts are generated and items are displayed in the list
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are generated and items in the list

    Examples:
      | Menu             | Department_Menu |
      | Fresh Code Check | Code Alerts     |

  @sma @UserSwipeLeft
  Scenario Outline: FCC_Alerts_UAT_TC127_Verify when user swipe left on any selected product, present on the alert screen, the product should be non deletable from the list
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are generated and items in the list
    Then the product should be non deletable from the list

    Examples:
      | Menu             | Department_Menu | item      |
      | Fresh Code Check | Code Alerts     | 108347903 |

  @sma @VerfPerfWasteg
  Scenario Outline: FCC_Alerts_UAT_TC123_Verify on performing Wastage action on item (having expiry date as current date + 1) present on the alert screen,
  the item gets deleted and product count gets decreased

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are generated and items in the list
    Then I select an "<item>" from the list
    Then I select "<Action>" from the action drop down
    Then I enter the "<Quantity>" in the quantity field
    Then I click on Log Product button
    Then I Verify Select Reason Code template
    Then I select the "<Wastage Code>" from the reason code drop down
    And I click on Confirm button
    Then Verify the "<item>" gets deleted  from the list and count gets decreased

    Examples:
      | Menu             | Department_Menu | Action  | Quantity | Wastage Code        | item      |
      | Fresh Code Check | Code Alerts     | Wastage | 3        | Waste - Out of Date | 107365923 |

  @sma @VerfPerfNoFurtherActn
  Scenario Outline: FCC_Alerts_UAT_TC124_Verify on performing No Further Action - Stock sold on item (having expiry date as current date + 1) present on the alert screen,
  the item gets deleted and product count gets decreased

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are generated and items in the list
    Then I select an "<item>" from the list
    Then I select "<Action>" from the action drop down
    Then I click on Log Product button
    Then Verify the "<item>" gets deleted  from the list and count gets decreased

    Examples:
      | Menu             | Department_Menu | Action                         | item      |
      | Fresh Code Check | Code Alerts     | No further action – Stock sold | 107365923 |

  @sma @verfWastagePerfAlert
  Scenario Outline: FCC_Alerts_UAT_TC125_Verify on performing Wastage action on expired alert (having expiry date as current date - 1) present on the alert screen,
  the item gets deleted and product count gets decreased

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are generated and items in the list
    Then I select an "<item>" from the list
    Then I select "<Action>" from the action drop down
    Then I enter the "<Quantity>" in the quantity field
    Then I click on Log Product button
    Then I Verify Select Reason Code template
    Then I select the "<Wastage Code>" from the reason code drop down
    And I click on Confirm button
    Then Verify the "<item>" gets deleted  from the list and count gets decreased

    Examples:
      | Menu             | Department_Menu | Action  | Quantity | Wastage Code        | item      |
      | Fresh Code Check | Code Alerts     | Wastage | 3        | Waste - Out of Date | 108338062 |

  @sma
  Scenario Outline: FCC_Alerts_UAT_TC126_Verify on performing No Further Action - Stock sold on expired alert (having expiry date as current date - 1) present on the alert screen,
  the item gets deleted and product count gets decreased

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are generated and items in the list
    Then I select an "<item>" from the list
    Then I select "<Action>" from the action drop down
    Then I click on Log Product button
    Then Verify the "<item>" gets deleted  from the list and count gets decreased

    Examples:
      | Menu             | Department_Menu | Action                         | item      |
      | Fresh Code Check | Code Alerts     | No further action – Stock sold | 108111052 |

  @sma
  Scenario Outline: FCC_Alerts_UAT_TC120_Verify that product count and message displayed when alerts are not generated and no items are displayed in the list
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are not generated and no items are displayed in the list

    Examples:
      | Menu             | Department_Menu |
      | Fresh Code Check | Code Alerts     |

  @sma
  Scenario Outline: FCC_Alerts_UAT_TC128_Verify when user perform action on all products present on Alert screen, the alert sub menu status should get completed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I navigate to Alert screen and verify product count and message when alerts are generated and items in the list
    And I click on back button
    And I Verify the department menu banner as "<status>"

    Examples:
      | Menu             | Department_Menu | status    |
      | Fresh Code Check | Code Alerts     | Completed |
