@fccSummarySignOff @regression
Feature: Verify Fresh Food Manager Check - Summary in Fresh code check

  ######################################## FCC phase 2 scenarios (UAT 54 - UAT 82 --> Excluding Code alert scenarios )####################################################################################################3
  ######################################## Fresh Food Manager Check --> Summary & Sign Off #########################################################
  @sma
  Scenario Outline: UAT_54 Verify After clicking on 'Fresh code check completion', screen will be redirected to Check Completion Summary tab and following fields should be displayed.1)Previous Date Check with Status 2)Filtering symbol 3)List of Checks with check box
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    When I click on Fresh check code completion
    And I verify three tabs Checks, Categories and Escalations are displayed
    And I verify lists of Checks with checkbox are displayed
    Then I click on Check completion filter symbol
    And I verify All checks, completed checks and Incomplete checks options are displayed

    Examples: 
      | StoreID | Menu             | Department_Menu | SubMenu                  | listMenu           |
      |      73 | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off |

  @sma
  Scenario Outline: UAT_56 Verify when user will be able to filter respective checks from the check summary screen
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    When I click on Fresh check code completion
    And I verify three tabs Checks, Categories and Escalations are displayed
    And I verify lists of Checks with checkbox are displayed
    Then I click on Check completion filter symbol
    And I verify All checks, completed checks and Incomplete checks options are displayed
    Then I click on All checks option from Check completion filter
    And I verify screen should display all the list of checks completed or Incomplete
    Then I click on Check completion filter symbol
    Then I click on Completed checks option from Check completion filter
    And I verify screen should display only the list of checks which are completed
    Then I click on Check completion filter symbol
    Then I click on Incomplete checks option from Check completion filter
    And I verify screen should display only the list of checks which are Incomplete

    Examples: 
      | StoreID | Menu             | Department_Menu | SubMenu                  | listMenu           |
      |      73 | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off |

  @sma
  Scenario Outline: UAT_57 Daily Check_Verify when user clicks on 'Out of Code - First Check (Waste)'.Then, should navigated to First check sub menu under Categories tab and details.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Out of Code-First Check Waste with top three departments according to wastage qty which belongs to first check along with there qty and wastage amount are displayed
    Then I click on Out of Code-First Check Waste on summary screen
    And I verify Daily check, Afternoon Check, FM Check and Code Alerts
    And I verify Category completion with list of departments with quantity and price are displayed
    Then I click on Category completion sorting symbol
    And I verify two sorting orders Lowest to Highest Price and Highest to Lowest Price are displayed
    Then I click on Category completion sorting symbol to close the filter
    And I verify in the list of departments the sorting order should be, by default Critical Checks would be first, Promotions would be second and Warehouse would be third

    Examples: 
      | StoreID | Menu             | Department_Menu | SubMenu                  | listMenu           |
      |      73 | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off |

  @sma
  Scenario Outline: UAT_58 Daily Check_I click on Afternoon check tab on Category completion table Check_Verify when user clicks on Critical checks/Promotions/Warehouse. Then, will be able to view list of all the products scanned under respective location, irrespective of the action performed and total count of products present in the list.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    Then I click on Out of Code-First Check Waste on summary screen
    Then I click on Daily check tab on Category completion table
    Then I click on "<Location1>"
    And I verify Product list is displayed
    Then I click on back button
    Then I click on "<Location2>"
    And I verify Product list is displayed
    Then I click on back button
    Then I click on "<Location3>"
    And I verify Product list is displayed
    Then I click on back button

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | listMenu           | Location1       | Location2  | Location3 |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off | Critical Checks | Promotions | Warehouse |

  @sma
  Scenario Outline: UAT_59 Daily Check_Verify when user clicks on any department name. Then, will be able to view list of aisles under the respective department with rotation rating details if department is completed.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    Then I click on Out of Code-First Check Waste on summary screen
    Then I click on Daily check tab on Category completion table
    Then I click on any department
    And I verify list of aisles under respective department with rotation rating details are displayed

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | listMenu           |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off |

  @sma
  Scenario Outline: UAT_60 Afternoon Check_Verify when user clicks on Critical checks/Promotions/Warehouse. Then, will be able to view list of all the products scanned under respective location, irrespective of the action performed and total count of products present in the list.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    Then I click on Out of Code-First Check Waste on summary screen
    Then I click on Afternoon check tab on Category completion table
    Then I click on "<Location1>"
    And I verify Product list is displayed
    Then I click on back button
    Then I click on "<Location2>"
    And I verify Product list is displayed
    Then I click on back button
    Then I click on "<Location3>"
    And I verify Product list is displayed
    Then I click on back button

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | listMenu           | Location1       | Location2  | Location3 |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off | Critical Checks | Promotions | Warehouse |

  @sma
  Scenario Outline: UAT_61 Afternoon Check_Verify user clicks on any department name. Then, will be able to view list of aisles under the respective department with rotation rating details if department is completed.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    Then I click on Out of Code-First Check Waste on summary screen
    Then I click on Afternoon check tab on Category completion table
    Then I click on any department
    And I verify list of aisles under respective department with rotation rating details are displayed

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | listMenu           |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off |

  @sma
  Scenario Outline: UAT_62 Fresh Food Manager Check_Verify when user clicks on Critical checks/Promotions/Warehouse. Then, will be able to view list of all the products scanned under respective location, irrespective of the action performed and total count of products present in the list.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    Then I click on Out of Code-First Check Waste on summary screen
    Then I click on FM check tab on Category completion table
    Then I click on "<Location1>"
    And I verify Product list is displayed
    Then I click on back button
    Then I click on "<Location2>"
    And I verify Product list is displayed
    Then I click on back button
    Then I click on "<Location3>"
    And I verify Product list is displayed
    Then I click on back button

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | listMenu           | Location1       | Location2  | Location3 |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off | Critical Checks | Promotions | Warehouse |

  @sma
  Scenario Outline: UAT_63 Fresh Food Manager Check_Verify when user clicks on any department name. Then, will be able to view list of aisles under the respective department with rotation rating details if department is completed.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    Then I click on Out of Code-First Check Waste on summary screen
    Then I click on FM check tab on Category completion table
    Then I click on any department
    And I verify list of aisles under respective department with rotation rating details are displayed

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | listMenu           |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off |

  @sma
  Scenario Outline: UAT_68 Verify when user navigates to Fresh Food manager Check Summary screen.Then, at the bottom of the summary screen, below 'Out of Code - First Check (Waste)' label, user will be able to view top 3 First Check departments which has maximum quantity actioned as Wastage with wastage quantity and wasted price
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<listMenu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    And I verify below Out of Code - Daily Checks Waste label, department list is displayed
    And I verify top 3 First Check departments which has maximum quantity actioned as Wastage with wastage quantity and wasted price are displayed
    Then I click on any department on list
    And I verify Category completion with list of departments with quantity and price are displayed

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | listMenu           |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off |

  @sma
  Scenario Outline: UAT_69 Verify on clicking the Sign-off button, Sign-off Confirmation page.Then, summary screen for Fresh Food Manager daily sign off should display the below header and content before confirming the sign off.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    Then I verify Sign off button is displayed
    And I click on Sign off button
    Then I verify content on Sign off page

    Examples: 
      | StoreID | Menu             | Department_Menu | SubMenu                  | listMenu           | Status     |
      |      73 | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off | Signed-Off |

  ########### Sign off the previous day
  @sma
  Scenario Outline: UAT_70 Verify When user clicks on Summary. Then, should view previous date in header with status as 'Signed-Off', if fresh food manager signs off the previous date check
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify previous day header status as "<Status1>"
    Then I verify Sign off button is displayed
    And I click on Sign off button
    Then I verify content on Sign off page
    And I select all checkboxes on Sign off page
    And I click on Sign off button
    And I verify previous day header status as "<Status2>"

    Examples: 
      | StoreID | Menu             | Department_Menu | SubMenu                  | listMenu           | Status1     | Status2    |
      |      73 | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off | In Progress | Signed Off |

  #
  #
  #Pending
  #@sma
  #Scenario Outline: UAT_71 Verify when Fresh manager summary has been signed-off. Then, Fresh/Store Manager user should not be allowed to add/edit/delete any completed escalations.
  #When I enter Username and Password for SMA Manager user
  #And I click on login button for SMA
  #Then I click on "<Menu>"
  #Then I verify "<Menu>" is displayed
  #When I verify "<Menu>" is displayed with status as 'Awaiting Sign-Off'
  #Then I click on "<Department_Menu>"
  #And I verify Sign off button is displayed
  #Then I click on Sign off button
  #And I verify content on Sign off page
  #And I select all checkboxes on Sign off page
  #Then I click on Sign off button
  #And I verify Week status is Sign off
  #Then I click on Escalations Section on summary page
  #Then I click on View for one escalation from list
  #And I verify user is not allowed to add or edit completed escalations
  #
  #Examples:
  #| Menu             | Department_Menu            |
  #| Fresh Code Check | Manager Summary & Sign Off |
  #
  ##########################################  Manager Summary & Sign Off  ################################################################################################
  #
  @sma
  Scenario Outline: To create escalation - Complete the department location with Poor rating.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I click on Day Schedule
    Then I click on "<SubMenu1>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    And I get "<listMenu>" status
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I complte the department with Poor rating
    And I click on back button
    And I click on back button
    Then I click on "<SubMenu2>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    And I get "<listMenu>" status
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I complte the department with Poor rating

    Examples: 
      | StoreID | productMin | Menu             | Department_Menu | SubMenu1     | SubMenu2         | listMenu | Status    |
      |      73 |  100179351 | Fresh Code Check | Daily Schedule  | Daily Checks | Afternoon Checks | Fixture  | Completed |

  @sma
  Scenario Outline: UAT_72_Verify user should be able to view Manager Summary & Sign Off sub-menu with 'Awaiting Sign-Off' status.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I verify "<Department_Menu>" is displayed
    When I verify "<Department_Menu>" is displayed with status as 'Awaiting Sign-Off'

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_73_Verify on Manager Summary & Sign Off screen user clicks on Summary and verify summary page header, Escalations with status as 'View' and message, Fresh code check completion, Out of Code-First Check (Waste) and top three departments according to wastage qty details are displayed
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify summary page header should display previous week date range along with status as 'Awaiting Sign-Off'
    And I verify Escalations with status as 'View' and message are displayed
    And I verify Fresh code chech completion with 7 day titles are displayed
    Then I scroll down to get the latest schdule
    And I verify Out of Code-First Check Waste with top three departments according to wastage qty which belongs to first check along with there qty and wastage amount are displayed

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_74_Verify on Manager Summary & Sign Off screen user clicks on Summary page header should display previous week date range along with status as 'Awaiting Sign-Off'.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I verify "<Department_Menu>" is displayed
    Then I click on "<Department_Menu>"
    And I verify summary page header should display previous week date range along with status as 'Awaiting Sign-Off'

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_75_Verify on Manager Summary & Sign Off screen user clicks on Summary. Then, summary Page should display the Total Wastage Amount in £ Pound symbol including all the checks i.e First Check,Second and Fresh manager check.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Total Wastage Amount in £ Pound symbol is displayed

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_76_Verify on Manager Summary & Sign Off screen user verify on Escalations tab list with escalations with View/Incomplete status are displayed.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Escalations with status as 'View' and message are displayed
    Then I click on Escalation View button
    And I verify Escalations page is displayed
    And I verify Date schedules are displayed
    And I verify Escalations list with details is displayed

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_77_Verify on Manager Summary & Sign Off screen user select one of the escalations that are in "Incomplete" Status then verify Next step screen. Perform actions and complete the escalation.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Escalations with status as 'View' and message are displayed
    Then I click on Escalation View button
    And I verify Escalations page is displayed
    And I verify Date schedules are displayed
    Then I select day from the Day schedule list
    And I verify Escalations list with details is displayed
    Then I select one escalations with Incomplete status
    And I verify Next steps screen is displayed
    Then I scroll down on the page
    And I added comment
    When I click on Save button
    Then I verify user is redirected to escalations list screen
    And I verify respective escalation is at the top with latest edited details

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_78_Verify on Manager Summary & Sign Off screen user should ADD comments in Escalations.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Escalations with status as 'View' and message are displayed
    Then I click on Escalation View button
    And I verify Escalations page is displayed
    And I verify Date schedules are displayed
    Then I select day from the Day schedule list
    And I verify Escalations list with details is displayed
    Then I select one escalations with Incomplete status
    And I verify Next steps screen is displayed
    Then I scroll down on the page
    And I added comment
    When I click on Save button
    Then I verify user is redirected to escalations list screen
    And I verify respective escalation is at the top with latest edited details

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_79_Verify on Manager Summary & Sign Off screen user should EDIT comments in Escalations.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Escalations with status as 'View' and message are displayed
    Then I click on Escalation View button
    And I verify Escalations page is displayed
    And I verify Date schedules are displayed
    Then I select day from the Day schedule list
    And I verify Escalations list with details is displayed
    Then I select one escalations with Incomplete status
    And I verify Next steps screen is displayed
    Then I scroll down on the page
    And I edited the comment
    Then I scroll down on the page
    When I click on Save button
    Then I verify user is redirected to escalations list screen
    And I verify respective escalation is at the top with latest edited details

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_80_Verify on Manager Summary & Sign Off screen user should EDIT comments in Escalations for Previous week
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I verify Summary screen is displayed
    When I click on Fresh check code completion
    And I verify three tabs Checks, Categories and Escalations are displayed
    Then I click on Escalations tab
    And I verify Date schedules are displayed
    And I verify Escalations list with details is displayed
    Then I click on day schdule for Previous week
    And I verify Escalations list with details is displayed
    Then I click on View for one escalation from list
    And I verify Next steps screen is displayed
    Then I scroll down
    And I edited comment
    Then I scroll down
    When I click on Save button
    Then I verify user is redirected to escalations list screen
    And I verify respective escalation is at the top with latest edited details

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_81 Manager Summary & Sign Off screen_Verify when user should be able to view Day wise tabs with label and after clicking on each day tabs, it will navigate to the Category Completion Summary screen of First Check.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I verify Summary screen is displayed
    And I verify Day tiles with Day, Date and Wastage values are present
    Then I click on Day tile
    And I verify screen navigate to the Category Completion Summary screen of First Check

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |

  @sma
  Scenario Outline: UAT_82 Manager Summary & Sign Off screen_Verify when clicks on 'Out of Code - First Check (Waste)'. Then, will be navigated to First check sub menu under Categories tab and verify the screen.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I verify Summary screen is displayed
    And I verify Out of Code-First Check Waste on summary screen is displayed
    Then I click on Out of Code-First Check Waste on summary screen
    And I verify Daily check, Afternoon Check, FM Check and Code Alerts
    And I verify Category completion with list of departments with quantity and price are displayed
    Then I click on Category completion sorting symbol
    And I verify two sorting orders Lowest to Highest Price and Highest to Lowest Price are displayed
    Then I click on Category completion sorting symbol to close the filter
    Then I select day from the Day schedule list
    And I verify in the list of departments the sorting order should be, by default Critical Checks would be first, Promotions would be second and Warehouse would be third

    Examples: 
      | Menu             | Department_Menu            |
      | Fresh Code Check | Manager Summary & Sign Off |
