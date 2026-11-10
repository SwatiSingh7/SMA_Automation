@NewfccFreshFoodManager @regression
Feature: Verify Daily Schedule-Fresh Food Manager in Fresh code check

####################### Data #############################################

############ Manager Checks -
############ Ranged     -> Aisle 0 - 064 Bacon - 103113622
############ Non Ranged -> Aisle 0 - 064 Bacon - 110760924
############ Short dept  -> Aisle 0 - 050 Ready Meals - 102753361
############ Long dept  -> Aisle 0 - 064 Bacon - 103113622

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | pm       |
      
  
  ####################################  Manager Check Scenarios (UAT_90 to UAT_104) ########################################################################################

  @sma @SubMenuStatus
  Scenario Outline: SMA-25033_UAT_90_When User navigates to Fresh Food Manager in defined time window (After 7:00 pm) then Sub-Menu Status will get displayed as 'Not Checked' and should be able to view list - Critical Check,Fixture,Promotion and Warehouse

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed

    Examples:
      | StoreID | Menu             | Department_Menu | SubMenu                  |
      | 8      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check |

  ################################# Fixture ########################################################################################
  
  #################################################### Fixture --> Short Department ##################################################################################

  @sma
  Scenario Outline: FCC_Phase4_ UAT_03_For Fresh Food Manager Check Short life departments - In Fixture location "Markdown & Wastage" actions are displayed and "Rotate to Front" action is not displayed.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    Then I verify Next scan date is displayed
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    Then Verify "<action2>" as default action is displayed
    And I click on action spinner
    Then Verify "<action1>" action is displayed
    Then Verify "<action2>" action is displayed
    Then Verify "<action3>" action is not displayed

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department      | action1 | action2  | action3         |
      | 8      | 102800789  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 050 Ready Meals | Wastage | Markdown | Rotate To Front |

  @sma
  Scenario Outline: FCC_Phase4_ UAT_04_For Fresh Food Manager Check Short life departments - Fixture location , select "Past expiry date" and verify only 1 Wastage reason code as "Waste Out of Date" is displayed.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    Then I verify Next scan date is displayed
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<pastDateRange>" th date
    Then I click on Done Button
    And I click Log Product
    Then Verify Select Reason Code template
    Then Verify Wastage reason code "<wastageCode1>" is displayed

    Examples:
      | StoreID | productMin | pastDateRange | quantity | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department      | action  | wastageCode1      |
      | 8      | 102800789  | -2            | 5        | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 050 Ready Meals | Wastage | Waste Out of Date |

  @sma
  Scenario Outline: FCC_Phase4_ UAT_05_For Fresh Food Manager Check Short life departments - Fixture location , select "Future expiry date" and verify only 3 Wastage reason code as "Waste Out of Date" ,"Waste Charity" and "Waste Damaged/Fruit & Veg Quality or Condition" are displayed.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    Then I verify Next scan date is displayed
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<futureDateRange>" th date
    Then I click on Done Button
    And I click Log Product
    Then Verify Select Reason Code template
    Then Verify Wastage reason code "<wastageCode1>" is displayed
    Then Verify Wastage reason code "<wastageCode2>" is displayed
    Then Verify Wastage reason code "<wastageCode3>" is displayed

    Examples:
      | StoreID | productMin | futureDateRange | quantity | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department      | action  | wastageCode1                                   | wastageCode2      | wastageCode3  |
      | 8      | 102800789  | 2               | 5        | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 050 Ready Meals | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | Waste Out of Date | Waste Charity |
  
  
  #################################################### Fixture --> Long Department ##################################################################################

  @sma
  Scenario Outline: FCC_Phase4_ UAT_8_For Fresh Food Manager Check Long life departments - In Fixture location "Markdown & Wastage" actions are displayed and "Rotate to Front" action is not displayed.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    Then I verify Next scan date is displayed
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    Then Verify "<action2>" as default action is displayed
    And I click on action spinner
    Then Verify "<action1>" action is displayed
    Then Verify "<action2>" action is displayed
    Then Verify "<action3>" action is not displayed

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action1 | action2  | action3         |
      | 8      | 108511241  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Markdown | Rotate To Front |


  @sma
  Scenario Outline: FCC_Phase4_ UAT_09_For Fresh Food Manager Check Long life departments - Fixture location , select "Past expiry date" and verify only 1 Wastage reason code as "Waste Out of Date" is displayed.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    Then I verify Next scan date is displayed
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<pastDateRange>" th date
    Then I click on Done Button
    And I click Log Product
    Then Verify Select Reason Code template
    Then Verify Wastage reason code "<wastageCode1>" is displayed

    Examples:
      | StoreID | productMin | pastDateRange | quantity | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | wastageCode1      |
      | 8      | 108511241  | -2            | 5        | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Out of Date |

  @sma
  Scenario Outline: FCC_Phase4_ UAT_10_For Fresh Food Manager Check Long life departments - Fixture location , select "Future expiry date" and verify only 3 Wastage reason code as "Waste Out of Date" ,"Waste Charity" and "Waste Damaged/Fruit & Veg Quality or Condition" are displayed.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    Then I verify Next scan date is displayed
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<futureDateRange>" th date
    Then I click on Done Button
    And I click Log Product
    Then Verify Select Reason Code template
    Then Verify Wastage reason code "<wastageCode1>" is displayed
    Then Verify Wastage reason code "<wastageCode2>" is displayed
    Then Verify Wastage reason code "<wastageCode3>" is displayed

    Examples:
      | StoreID | productMin | futureDateRange | quantity | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | wastageCode1                                   | wastageCode2      | wastageCode3  |
      | 8      | 108511241  | 2               | 5        | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | Waste Out of Date | Waste Charity |

  @sma
  Scenario Outline: SMA-25033_UAT_93_When User navigates to Fresh Food Manager and scanned item at fixture location from any Scheduled department/class/Subclass then Next scan date is displayed on item scan screen and after scanning a product user is able to perform action as Markdown

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    Then I click on date picker and select expiry date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on No Printer Available
    Then I click on Get Price
    Then I click on Add to Print Queuee
    And I click on back button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    And I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Enabled
    Then I Delete the product

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action   | quantity | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Markdown | 3        | Markdowns    |

  @sma
  Scenario Outline: SMA-25033_UAT_94_When User navigates to Fresh Food Manager for Action as Wastage and user scan and select action=Wastage and expiry date as back dated(current date -1) then user should be able to select below wastage reason codes ->  Waste Out of Date

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Out of Date | 2        | -1        | Wasted       |

  @sma
  Scenario Outline: SMA-25033_UAT_94_When User navigates to Fresh Food Manager for Action as Wastage and user scan and select action=Wastage and expiry date as back dated(current date -2) then user should be able to select below wastage reason codes ->  Waste Out of date.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Out of Date | 2        | -2        | Wasted       |

  @sma
  Scenario Outline: SMA-25033_UAT_95_1_When User navigates to Fresh Food Manager for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes -> Waste Damaged/Fruit & Veg Quality or Condition.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then Verify Select Reason Code template
    And I verify Three wastage code options are dispayed
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25033_UAT_95_2_When User navigates to Fresh Food Manager for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes -> Waste Charity.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then Verify Select Reason Code template
    And I verify Three wastage code options are dispayed
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | option        | quantity | dateRange | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Charity | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25033_UAT_95_3_When User navigates to Fresh Food Manager for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes -> Waste Out of Date

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then Verify Select Reason Code template
    And I verify Three wastage code options are dispayed
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Out of Date | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25033_UAT_95_4_When User navigates to Fresh Food Manager for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes -> Waste Charity.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then Verify Select Reason Code template
    And I verify Three wastage code options are dispayed
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | option        | quantity | dateRange | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Charity | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25033_UAT_97_When User navigates to fixture location under Fresh Food Manager and user wants to delete product from the view list of scheduled department then User should be able to delete the products actioned as Markdown and the deleted item will get disappear from the list of scanned items.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    Then I click on date picker and select expiry date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on No Printer Available
    And I click on Get Price
    Then I click on Add to Print Queuee
    And I click on back button
    And I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Enabled
    Then I Delete the product

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action   | quantity | dateRange | verifyAction |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Markdown | 2        | 3         | Markdown     |

  @sma
  Scenario Outline: SMA-25033_UAT_99_When User navigates to Fixture screen under Fresh Food Manager and status of Department is completed. Then user should be able to click on "Reopen Code Rotate Group" then prompt will appear.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then Verify Select Reason Code template
    And I verify Three wastage code options are dispayed
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button

    Then I click on View list of expiring products
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    Then I click on confirm button

    And I verify "<Department>" status is "<Status>"
    Then I click on "<Department>"
    And I verify Reopen Complete Code Check button is displayed
    Then I click on Reopen Complete Code Check button
    And I click on Yes option on Reopen Complete Code Check alert

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action  | option        | quantity | dateRange | verifyAction | Status    | ratingOption |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Wastage | Waste Charity | 2        | 1         | Wasted       | Completed | Poor         |

  @sma
  Scenario Outline: SMA-25033_UAT_100_When User navigates to Fixture screen under Fresh Food Manager, after reopening respective department and performs delete operation on scanned items actioned as Markdown by swiping left on the product. Then, items must disappear from the list of Scanned items.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    Then I click on date picker and select expiry date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on No Printer Available
    And I click on Get Price
    Then I click on Add to Print Queuee
    And I click on back button
    And I click on View list of expiring products
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"

    Then I click on confirm button
    Then I verify "<Department>" status is "<Status>"
    Then I click on "<Department>"
    And I verify Reopen Complete Code Check button is displayed
    Then I click on Reopen Complete Code Check button
    And I click on Yes option on Reopen Complete Code Check alert
    And I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Enabled
    Then I Delete the product

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action   | quantity | dateRange | verifyAction | Status    | ratingOption |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Markdown | 2        | 3         | Markdown     | Completed | Poor         |

  ############################################### Select invalid date
  @sma
  Scenario Outline: SMA-25033_UAT_101_When User navigates to Fixture screen under Fresh Food Manager and selected expiry date is 'Invalid' in Schedule.Then prompt will appear with Message and 'OK' button.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I verify "<alertMessage>" is displayed

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | action   | quantity | dateRange | alertMessage                                                                |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Markdown | 2        | 8         | Please enter a valid date for this product, Inline with the Scheduled Check |

  ############################################################# Enter Ambient product
  @sma
  Scenario Outline: SMA-25033_UAT_102_When User navigates to Fixture location under Fresh Food Manager and user scans a Ambient product in one of the Schedule department.Then, prompt will appear with Continue Button ,user clicks on 'Continue' button then should remain on the same department screen.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    Then I verify after scanning Ambient product "<alertMessage>" message is displayed

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | quantity | dateRange | action   | alertMessage                                                     |
      | 8      | 100100842  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | 2        | 1         | Markdown | This product is not part of Fresh Foods.Please action separately |

################################################ Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25033_UAT_103_1_When User navigates to Fresh Food Manager and scan non-Ranged product in fixture location from any Scheduled department/class/Subclass. and select action as 'Markdown' and verify product on Critical checks screen.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    And I verify page is navigated to location page
    Then I enter location details and click on continue
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | listMenu1       | Aisle   | Department | quantity | dateRange | action   | verifyAction | alertMessage                                                                                                |
      | 8      | 110760924  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Critical Checks | Aisle 0 | 064 Bacon  | 2        | 1         | Markdown | Markdowns    | This product is not ranged to your store. Please enter the products locations and continue with your check. |

  
##################### Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25033_UAT_103_3_When User navigates to Fresh Food Manager and scan non-Ranged product in fixture location from any Scheduled department/class/Subclass. click on continue button and enter location details and log the product.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    And I verify page is navigated to location page
    Then I enter location details and click on continue
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | listMenu1       | Aisle   | Department | quantity | dateRange | action   | verifyAction | alertMessage                                                                                                |
      | 8      | 110760924  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Critical Checks | Aisle 0 | 064 Bacon  | 2        | 1         | Markdown | Markdowns    | This product is not ranged to your store. Please enter the products locations and continue with your check. |

##################### Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25033_UAT_103_4_When User navigates to Fresh Food Manager and scan non-Ranged product in fixture location from any Scheduled department/class/Subclass. Complete the Critical check menu.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    And I verify page is navigated to location page
    Then I enter location details and click on continue
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I click on back button
    Then I click on "<SubMenu>"
    Then I click on "<listMenu1>"
    And I click on Reopen Complete Code Check button
    And I click on Yes option on Reopen Complete Code Check alert

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | listMenu1       | Aisle   | Department | quantity | dateRange | action   | verifyAction | alertMessage                                                                                                |
      | 8      | 110760924  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Critical Checks | Aisle 0 | 064 Bacon  | 2        | 1         | Markdown | Markdowns    | This product is not ranged to your store. Please enter the products locations and continue with your check. |

##################### Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25033_UAT_104_When User navigates to critical check screen under Fresh Food Manager and user performs delete operation on products actioned as Markdown. Then, the respective product must disappear from the list of critical check items and product count in critical check sub-menu should get updated.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    Then I click on "<Department>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    And I verify page is navigated to location page
    Then I enter location details and click on continue
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    And I Swipe left
    And I Delete the product

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | listMenu1       | Aisle   | Department | quantity | dateRange | action   | verifyAction | alertMessage                                                                                                |
      | 8      | 110760924  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Critical Checks | Aisle 0 | 064 Bacon  | 2        | 1         | Markdown | Markdowns    | This product is not ranged to your store. Please enter the products locations and continue with your check. |

  @sma
  Scenario Outline: SMA-25033_UAT_98_When User navigates to Fixture screen under Fresh Food Manager and User completes all the Aisles under Fixture location then The app will display Fixture Location status as 'completed'.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    And I get "<listMenu>" status
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I complte all the Aisles
    And I click on back button
    Then I verify "<listMenu>" status is "<Status>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu                  | listMenu | Aisle   | Department | Status    |
      | 8      | 103113622  | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Fixture  | Aisle 0 | 064 Bacon  | Completed |
  
 ###########################################Critical Check###########################################################################################


  @sma
  Scenario Outline: UAT_105 Verify completed status in 'Critical Check' screen when Fresh Food Manager 'Complete Code Check'

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    And I click on Button "<Button>"
    And I verify Critical checks status "<Status>"

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location        | Button              | Status    |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Critical Checks | COMPLETE CODE CHECK | Completed |

  @sma
  Scenario Outline:UAT_106 Verify when status is completed, user performs 'Reopen Code Rotate Group' in 'Critical Check'

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    And I verify Critical checks status "<Status>"
    Then I reopen department "<Location>"
    Then I click on Back button
    And I verify Critical checks status "<Status1>"
    Then I click on "<Location>"
    And I click on Button "<Button>"

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location        | Status    | Status1 | Button              |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Critical Checks | Completed | 0 OF 0  | COMPLETE CODE CHECK |
 
##########################

  @sma
  Scenario Outline: UAT_108  Verify 'Promotion' screen when 'Markdown' action is performed for scanned product

    When  I enter Username and Password for SMA Manager user
    And  I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then  I click on "<Menu>"
    Then  I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And  I select current day date
    Then  I click on "<SubMenu>"
    Then  I click on "<Location>"
    Then I verify Next scan date is displayed
    And  I click on barcode entry Button
    Then  Enter "<MIN>" number
    And  I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And  I click on Calendar
    Then  I select next "<dateRangeMax>" th date
    Then  I click on Done Button
    And  I capture product details
    And I click Log Product
    Then  I click on No Printer Available
    Then I click on Get Price
    Then  I click on Add to Print Queuee
    And I verify my product displayed in view list
    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location   | MIN       | Action   | Quantity | dateRangeMax |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Promotions | 107089869 | Markdown | 2        | 1            |
 
 #######################
 #@sma
 ###########Scenario Outline: UAT_109 Verify 'Promotion' screen when 'Wastage' action is performed for scanned product for future expiry date
 #		When  I enter Username and Password for SMA Manager user 
#		And  I click on login button for SMA
#       Then I click on the main menu "Code Checking"
#		Then  I click on "<Menu>" 
#		Then  I click on "<Department_Menu>" 
#		And  I select current day date 
#		Then  I click on "<SubMenu>" 
#		Then  I click on "<Location>" 
#		And  I click on barcode entry Button 
#		Then  Enter "<MIN>" number 
#		And  I click on spinner to select one of the action "<Action>" 
#	  	And I enter markdown "<Quantity>" for the product
#		And  I click on Calendar 
#		Then  I select next "<dateRangeMax>" th date 
#		Then  I click on Done Button 
#		And  I capture product details 
#		And I click Log Product
#	    Then Verify Select Reason Code template
#	    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
#	 	And I select "<WastageReason>" and Confirm
#	   	And I verify my product displayed in view list
       #
 #Examples:   
 #| Menu | 			Department_Menu |	SubMenu|Location|			MIN	|		Action|		Quantity|			dateRangeMax|WastageReason|
 #|Fresh Code Check|Daily Schedule|	Fresh Food Manager Check|Promotions|		107089869|		Wastage|		2|			4|Waste Out of Date|
 #
 ###################################
 #@sma
 ###########Scenario Outline: UAT_110 Verify 'Promotion' screen when 'Wastage' action is performed for scanned product for past expiry date
#	When  I enter Username and Password for SMA Manager user 
#	And  I click on login button for SMA
#   Then I click on the main menu "Code Checking"
#	Then  I click on "<Menu>" 
#	Then  I click on "<Department_Menu>" 
#	And  I select current day date 
#	Then  I click on "<SubMenu>" 
#	Then  I click on "<Location>" 
#	And  I click on barcode entry Button 
#	Then  Enter "<MIN>" number 
#	And  I click on spinner to select one of the action "<Action>" 
#	And I enter markdown "<Quantity>" for the product
#	And  I click on Calendar 
#	Then  I select next "<dateRangeMax>" th date 
#	Then  I click on Done Button 
#	And  I capture product details 
#	And I click Log Product
#	Then Verify Select Reason Code template 
#	Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity	 	
#	And I select "<WastageReason>" and Confirm 
#	And I verify my product displayed in view list 
#	     
 #Examples:   
 #| Menu | 			Department_Menu |	SubMenu|Location|			MIN	|		Action|		Quantity|			dateRangeMax|WastageReason|
 #|Fresh Code Check|Daily Schedule|	Fresh Food Manager Check|Promotions|		107089869  |		Wastage|		2|			-2|Waste Out of Date|
 #
  @sma
  Scenario Outline:UAT_111 Verify 'Promotion' screen when user 'Delete' product actioned as Markdow from view list

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    And I verify my product displayed in view list
    And I Delete products
###########     Given Request is made to SMA app login service for manager user
###########  Then Service should return details for SMA app Login Service
###########  And Get generated access token
###########  Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<MIN>"
###########  And Get Operation perform on Markdown service request
###########  Then Get markdown details service response after scanning the product
###########  Given Patch request is made to delete print list service for store id "<storeId>"
###########  Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Menu             | Department_Menu | SubMenu                  | Location   | MIN       |
      | 78      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Promotions | 106794945 |

  @sma
  Scenario Outline: UAT_16 Verify user give Rotation Rating for 'Warehouse' screen when user click 'Complete Promotions'

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    Then I verify Next scan date is displayed
    And I click on Button "<Button>"
    And I select rating and confirm
    And I verify Counts and Rating
    And I verify promotion status "<Status>"

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location   | Button              | Status    |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Promotions | COMPLETE PROMOTIONS | Completed |


  @sma
  Scenario Outline:UAT_113 Verify when status is completed, user performs 'Reopen Code Rotate Group' in 'Promotion'

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    And I verify promotion status "<Status>"
    Then I click on "<Location>"
    And I click on Button "<Button>"
    And I click Continue
    And I click on Button "<Button1>"

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location   | Status    | Status1     | Button             | Button1             |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Promotions | Completed | In Progress | RE-OPEN PROMOTIONS | COMPLETE PROMOTIONS |
		
 
##########################################WAREHOUSE###############################################


  @sma
  Scenario Outline: UAT_114 Verify 'Warehouse' screen when 'Markdown' action is performed for scanned product

    When  I enter Username and Password for SMA Manager user
    And  I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then  I click on "<Menu>"
    Then  I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And  I select current day date
    Then  I click on "<SubMenu>"
    Then  I click on "<Location>"
    Then I verify Next scan date is displayed
    And  I click on barcode entry Button
    Then  Enter "<MIN>" number
    And  I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And  I click on Calendar
    Then  I select next "<dateRangeMax>" th date
    Then  I click on Done Button
    And  I capture product details
    And I click Log Product
    Then  I click on No Printer Available
    Then I click on Get Price
    Then  I click on Add to Print Queuee
    And  I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location  | MIN       | Action   | Quantity | dateRangeMax |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Warehouse | 107091248 | Markdown | 2        | 1            |


  @sma
  Scenario Outline: UAT_115 Verify 'Warehouse' screen when 'Wastage' action is performed for scanned product for future expiry date

    When  I enter Username and Password for SMA Manager user
    And  I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then  I click on "<Menu>"
    Then  I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And  I select current day date
    Then  I click on "<SubMenu>"
    Then  I click on "<Location>"
    And  I click on barcode entry Button
    Then  Enter "<MIN>" number
    And  I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And  I click on Calendar
    Then  I select next "<dateRangeMax>" th date
    Then  I click on Done Button
    And  I capture product details
    And I click Log Product
    Then Verify Select Reason Code template
    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
    And I select "<WastageReason>" and Confirm
    And I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location  | MIN       | Action  | Quantity | dateRangeMax | WastageReason     |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Warehouse | 107091248 | Wastage | 2        | 4            | Waste Out of Date |


  @sma
  Scenario Outline: UAT_116 Verify 'Warehouse' screen when 'Wastage' action is performed for scanned product for past expiry date

    When  I enter Username and Password for SMA Manager user
    And  I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then  I click on "<Menu>"
    Then  I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And  I select current day date
    Then  I click on "<SubMenu>"
    Then  I click on "<Location>"
    And  I click on barcode entry Button
    Then  Enter "<MIN>" number
    And  I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And  I click on Calendar
    Then  I select next "<dateRangeMax>" th date
    Then  I click on Done Button
    And  I capture product details
    And I click Log Product
    Then Verify Select Reason Code template
    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
    And I select "<WastageReason>" and Confirm
    And I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location  | MIN       | Action  | Quantity | dateRangeMax | WastageReason     |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Warehouse | 107091248 | Wastage | 2        | -2           | Waste Out of Date |


  @sma
  Scenario Outline:UAT_117 Verify 'Warehouse' screen when user 'Delete' product actioned as Markdow from view list

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    And I verify my product displayed in view list
    And I Delete products

    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<MIN>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Menu             | Department_Menu | SubMenu                  | Location  | MIN       |
      | 8       | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Warehouse | 107091248 |

  @sma
  Scenario Outline: UAT_17 Verify user give Rotation Rating for 'Warehouse' screen when user click 'Complete Promotions'

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    Then I verify Next scan date is displayed
    And I click on Button "<Button>"
    And I select rating and confirm
    And I verify Counts and Rating
    And I verify warehouse status "<Status>"

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location  | Button             | Status    |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Warehouse | COMPLETE WAREHOUSE | Completed |


  @sma
  Scenario Outline:UAT_119 Verify when status is completed, user performs 'Reopen Code Rotate Group' in 'Warehouse'

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    Then I Scroll down on Daily schedule page
    And I Select Daily schedule for "Current Date"
#    And I select current day date
    Then I click on "<SubMenu>"
    And I verify warehouse status "<Status>"
    Then I click on "<Location>"
    And I click on Button "<Button>"
    And I click Continue
    And I click on Button "<Button1>"

    Examples:
      | Menu             | Department_Menu | SubMenu                  | Location  | Status    | Status1     | Button            | Button1            |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Warehouse | Completed | In Progress | RE-OPEN WAREHOUSE | COMPLETE WAREHOUSE |
