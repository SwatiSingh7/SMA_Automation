@NewfccAfternoonCheck @regression
Feature: Verify Fresh code check scenarios functionality - Afternoon Checks(UAT_60 to UAT_89).


####################### Data #############################################

############ Afternoon Checks -
############ Ranged     -> Aisle 0 - 065 Dairy - 103034836
############ Non Ranged -> Aisle 0 - 065 Dairy - 110226609
############ Short dept  -> Aisle 0 - 060 Chilled Desserts - 106909888
############ Long dept  -> Aisle 0 - 065 Dairy - 103034836
  @sma
  Scenario Outline: Executing the AWS ECS task with different parameters
    Given The ECS Jobs are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"

    Examples:
      | TaskName                                           | containerOverrides                                                | ClusterName                         | LaunchType | LogGroupName                                                                | LogStreamNamePrefix      |
      | logistics-supplychain-freshscheduleloader-task-sit | /app/cleanrotate/service/bin/runApp,sit 2023-07-13 2023-07-18 475 | nonprod-ECS-ECSCluster-W68V9ZHCS399 | EC2        | clg-euw1-sit-logistics-supplychain-cleanrotate-freshscheduleloader-task-001 | storewalkcountsprocessor |

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | pm       |

  @sma @VerfAfternoonChkSubMenu
  Scenario Outline: SMA-25001_UAT_60_When User navigates to Afternoon Checks then Sub-Menu Status will get displayed as 'Not Checked' and should be able to view list - Critical Check,Fixture,Promotion and Warehouse
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I get "<SubMenu>" status
    And I verify "<SubMenu>" status "<Status>" is displayed on UI
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed

    Examples:
      | StoreID | Menu             | Department_Menu | SubMenu          | Status      |
      | 8      | Fresh Code Check | Daily Schedule  | Afternoon Checks | Not Checked |

  
  #################################################### Fixture ##################################################################################

  @sma
  Scenario Outline: FCC_Phase4_ UAT_02_Verify for Afternoon check seperation between Short Life departments and Long Life departments are displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I click on "<Aisle>"
    And I verify corresponding departments are displayed
    And I verify seperation between Short Life departments and Long Life departments are displayed

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 |

  
  #################################################### Fixture --> Short Department ##################################################################################

  @sma
  Scenario Outline: FCC_Phase4_ UAT_03_For Afternoon check Short life departments - In Fixture location "Markdown & Wastage" actions are displayed and "Rotate to Front" action is not displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I click on action spinner
    Then Verify "<action1>" action is displayed
    Then Verify "<action2>" action is displayed
    Then Verify "<action3>" action is not displayed

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department           | action1 | action2  | action3         |
      | 8      | 102800789  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 060 Chilled Desserts | Wastage | Markdown | Rotate To Front |

  @sma
  Scenario Outline: FCC_Phase4_ UAT_04_For Afternoon check Short life departments - Fixture location , select "Past expiry date" and verify only 1 Wastage reason code as "Waste Out of Date" is displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | pastDateRange | quantity | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department           | action  | wastageCode1      |
      | 8      | 102800789  | -2            | 5        | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 060 Chilled Desserts | Wastage | Waste Out of Date |

  @sma
  Scenario Outline: FCC_Phase4_ UAT_05_For Afternoon check Short life departments - Fixture location , select "Future expiry date" and verify only 3 Wastage reason code as "Waste Out of Date" ,"Waste Charity" and "Waste Damaged/Fruit & Veg Quality or Condition" are displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | futureDateRange | quantity | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department           | action  | wastageCode1                                   | wastageCode2      | wastageCode3  |
      | 8      | 102800789  | 2               | 5        | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 060 Chilled Desserts | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | Waste Out of Date | Waste Charity |
  
  
  #################################################### Fixture --> Long Department ##################################################################################

  @sma
  Scenario Outline: FCC_Phase4_ UAT_8_For Afternoon check Long life departments - In Fixture location "Markdown & Wastage" actions are displayed and "Rotate to Front" action is not displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action1 | action2  | action3         |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Markdown | Rotate To Front |


  @sma
  Scenario Outline: FCC_Phase4_ UAT_09_For Afternoon check Long life departments - Fixture location , select "Past expiry date" and verify only 1 Wastage reason code as "Waste Out of Date" is displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | pastDateRange | quantity | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | wastageCode1      |
      | 8      | 103034836  | -2            | 5        | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date |

  @sma
  Scenario Outline: FCC_Phase4_ UAT_10_For Afternoon check Long life departments - Fixture location , select "Future expiry date" and verify only 3 Wastage reason code as "Waste Out of Date" ,"Waste Charity" and "Waste Damaged/Fruit & Veg Quality or Condition" are displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | futureDateRange | quantity | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | wastageCode1                                   | wastageCode2      | wastageCode3  |
      | 8      | 103034836  | 2               | 5        | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | Waste Out of Date | Waste Charity |


  @sma
  Scenario Outline: SMA-25001_UAT_63_When User navigates to Afternoon Checks and scanned item at fixture location from any Scheduled department/class/Subclass then Next scan date is displayed on item scan screen and after scanning a product user is able to perform action as Markdown
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action   | quantity | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Markdown | 3        | Markdowns    |

  @sma
  Scenario Outline: SMA-25001_UAT_64_1_When User navigates to Afternoon Checks for Action as Wastage and user scan and select action=Wastage and expiry date as back dated(current date -1) then user should be able to select below wastage reason codes ->  Waste Out of date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I verify only One wastage code options are dispayed
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date | 2        | -1        | Wasted       |

  @sma
  Scenario Outline: SMA-25001_UAT_64_2_When User navigates to Afternoon Checks for Action as Wastage and user scan and select action=Wastage and expiry date as back dated(current date -2) then user should be able to select below wastage reason codes -> Waste Damaged/Fruit & Veg Quality or Condition.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I verify only One wastage code options are dispayed
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date | 2        | -2        | Wasted       |

  @sma
  Scenario Outline: SMA-25001_UAT_65_1_When User navigates to Afternoon Checks for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes -> Waste Charity.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option        | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Charity | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25001_UAT_65_2_When User navigates to Afternoon Checks for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes ->Waste Damaged/Fruit & Veg Quality or Condition.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25001_UAT_65_3_When User navigates to Afternoon Checks for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes -> Waste Out of date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25001_UAT_65_4_When User navigates to Afternoon Checks for Action as Wastage and user scan and select action=Wastage and expiry date as current\future dated(current date +1) then user should be able to select below wastage reason codes -> Waste Damaged/Fruit & Veg Quality or Condition.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25001_UAT_66_2_When User navigates to fixture location under Afternoon Checks and user wants to delete product from the view list of scheduled department then User should be able to delete the products actioned as Markdown and the deleted item will get disappear from the list of scanned items.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    Then I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Enabled
    Then I Delete the product

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action   | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Markdown | 2        | 3         | Markdowns    |

  @sma
  Scenario Outline: SMA-25001_UAT_66_3_When User navigates to fixture location under Afternoon Checks and scan the product and marked action as Wastage. And verify Products which are actioned as Wastage cannot be deleted.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    Then Verify Select Reason Code template
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    Then I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Disabled
    Then Verify product is not able to delete

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-25001_UAT_67_1_When User navigates to department/class/subclass of Afternoon Checks and User clicks on "Complete Code Check" button then the app will display department/class/subclass status as 'Completed' with Counts of Markdown, Wastage and Rotation Rating(as Average/Good/Poor). Also displays Completed by XXXX, Date and time.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    Then I click on View list of expiring products
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    And I verify Department is Completed for product "<Department>"
    Then I click on "<Department>"
    And I verify Reopen Complete Code Check button is displayed
    Then I click on Reopen Complete Code Check button
    And I verify on Reopen Complete Code Check alert
    Then I click on Yes option on Reopen Complete Code Check alert

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action   | quantity | dateRange | verifyAction | ratingOption |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Markdown | 2        | 2         | Markdowns    | Good         |

  @sma
  Scenario Outline: SMA-25001_UAT_67_2_When User navigates to department/class/subclass of Afternoon Checks and User clicks on "Complete Code Check" button then the app will display department/class/subclass status as 'Completed' with Counts of Markdown, Wastage and Rotation Rating(as Average/Good/Poor). Also displays Completed by XXXX, Date and time.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    Then I click on View list of expiring products
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    And I verify Department is Completed for product "<Department>"
    Then I click on "<Department>"
    And I verify Reopen Complete Code Check button is displayed
    Then I click on Reopen Complete Code Check button
    And I verify on Reopen Complete Code Check alert
    Then I click on Yes option on Reopen Complete Code Check alert

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction | ratingOption |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 2         | Wasted       | Good         |

  @sma
  Scenario Outline: SMA-25001_UAT_67_3_When User navigates to department/class/subclass of Afternoon Checks and User clicks on "Complete Code Check" button then the app will display department/class/subclass status as 'Completed' with Counts of Markdown, Wastage and Rotation Rating(as Average/Good/Poor). Also displays Completed by XXXX, Date and time.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    Then I click on View list of expiring products
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    And I verify Department is Completed for product "<Department>"
    Then I click on "<Department>"
    And I verify Reopen Complete Code Check button is displayed
    Then I click on Reopen Complete Code Check button
    And I verify on Reopen Complete Code Check alert
    Then I click on Yes option on Reopen Complete Code Check alert

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action   | quantity | dateRange | verifyAction | ratingOption |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Markdown | 2        | 2         | Markdowns    | Good         |


  @sma
  Scenario Outline: SMA-25001_UAT_70_When User navigates to Fixture screen under Afternoon Checks, after reopening respective department and performs delete operation on scanned items actioned as Markdown by swiping left on the product. Then, items must disappear from the list of Scanned items.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    And I Verify Scanned itemm "<productMin>" is visible on view list
    And I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    Then I click on View list of expiring products
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    And I verify Department is Completed for product "<Department>"
    Then I click on "<Department>"
    And I verify Reopen Complete Code Check button is displayed
    Then I click on Reopen Complete Code Check button
    And I verify on Reopen Complete Code Check alert
    Then I click on Yes option on Reopen Complete Code Check alert
    Then I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Disabled
    Then Verify product is not able to delete

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action   | quantity | dateRange | verifyAction | ratingOption |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Markdown | 2        | 3         | Markdowns    | Good         |

  ################### Enter Invalid date
  @sma
  Scenario Outline: SMA-25001_UAT_71_When User navigates to Fixture screen under Afternoon Checks and selected expiry date is 'Invalid' in Schedule.Then prompt will appear with Message and 'OK' button.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | action   | quantity | dateRange | alertMessage                                                                |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | Markdown | 2        | 4         | Please enter a valid date for this product, Inline with the Scheduled Check |

  ################### Enter Ambient Product
  @sma
  Scenario Outline: SMA-25001_UAT_72_When User navigates to Fixture location under Afternoon Checks and user scans a Ambient product in one of the Schedule department.Then, prompt will appear with Continue Button ,user clicks on 'Continue' button then should remain on the same department screen.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Aisle   | Department | quantity | dateRange | action   | alertMessage                                                     |
      | 8      | 100101124  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Aisle 0 | 065 Dairy  | 2        | 1         | Markdown | This product is not part of Fresh Foods.Please action separately |

  #################### Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25034_UAT_73_When User navigates to Afternoon Checks and scan non-Ranged product in fixture location from any Scheduled department/class/Subclass. Log product with action as Rotate to front, click on continue button and enter location details and log the product.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | listMenu1       | Aisle   | Department | quantity | dateRange | action   | verifyAction | alertMessage                                                                                                |
      | 8      | 110226609  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Critical Checks | Aisle 0 | 065 Dairy  | 2        | 1         | Markdown | Markdowns    | This product is not ranged to your store. Please enter the products locations and continue with your check. |

  ################################################# Critical check ################################################################################
  #################### Enter Non-Ranged product

  @sma
  Scenario Outline: SMA-25034_UAT_74_2_When User navigates to critical check screen under Afternoon Checks and user performs delete operation on products actioned as (Markdown). Then,the respective product must disappear from the list of critical check items and product count in critical check sub-menu should get updated.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    Then I click on date picker and select expiry date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on No Printer Available
    And I click on Get Price
    Then I click on Add to Print Queuee
    And I click on Back button
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    And I Swipe left
    And I Delete the product

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | listMenu1       | Aisle   | Department | quantity | dateRange | action   | verifyAction |
      | 8      | 108683051  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Critical Checks | Aisle 0 | 065 Dairy  | 2        | 1         | Markdown | Markdowns    |

#################### Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25034_UAT_75_When User navigates to Critical check screen under Afternoon Checks and user clicks on "Complete Code Check" button. Then, Critical check section will display status as 'completed'.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    Then I click on date picker and select expiry date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on No Printer Available
    And I click on Get Price
    Then I click on Add to Print Queuee
    And I click on Back button
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify "<listMenu1>" status is "<Status>"
    Then I click on "<listMenu1>"
    And I click on Reopen Complete Code Check button
    And I click on Yes option on Reopen Complete Code Check alert

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | listMenu1       | Aisle   | Department | dateRange | action   | quantity | Status    |
      | 8      | 108683051  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Critical Checks | Aisle 0 | 065 Dairy  | 1         | Markdown | 2        | Completed |

#################### Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25034_UAT_76_1_When User navigates to Critical Check screen under Afternoon Checks and status of Critical Check is completed. Then, user should be able to reopen critical check section when clicked on "Reopen Code Rotate Group" button, popup will get displayed.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    Then I click on date picker and select expiry date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on No Printer Available
    And I click on Get Price
    Then I click on Add to Print Queuee
    And I click on Back button
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify "<listMenu1>" status is "<Status>"
    Then I click on "<listMenu1>"
    And I click on Reopen Complete Code Check button
    And I click on Yes option on Reopen Complete Code Check alert

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | listMenu1       | Aisle   | Department | dateRange | action   | quantity | Status    |
      | 8      | 108683051  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Critical Checks | Aisle 0 | 065 Dairy  | 1         | Markdown | 2        | Completed |

#################### Enter Non-Ranged product
  @sma
  Scenario Outline: SMA-25034_UAT_76_2_When User navigates to Critical Check screen under Afternoon Checks and Complete the Critical check and verify status as 'Completed'
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
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
    Then I click on date picker and select expiry date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then I click on No Printer Available
    And I click on Get Price
    Then I click on Add to Print Queuee
    And I click on Back button
    And I click on Back button
    And I click on Back button
    And I click on Back button
    Then I click on "<listMenu1>"
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    And I verify Complete Code Check button is displayed
    Then I click on Complete Code Check button
    And I verify "<listMenu1>" status is "<Status>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | listMenu1       | Aisle   | Department | dateRange | action   | quantity | Status    |
      | 8      | 108683051  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Critical Checks | Aisle 0 | 065 Dairy  | 1         | Markdown | 2        | Completed |

  @sma
  Scenario Outline: SMA-25001_UAT_77_When User navigates to Fixture screen under Afternoon Checks and User completes all the Aisles under Fixture location then The app will display Fixture Location status as 'completed'.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    And I get "<listMenu>" status
    Then I click on "<listMenu>"
    And I verify Aisle list is displayed
    Then I complte all the Aisles
    And I click on back button
    Then I verify "<listMenu>" status is "<Status>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu | Status    |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Fixture  | Completed |

  ######################################### Promotions ########################################################################################
  @sma
  Scenario Outline: SMA-27045_UAT_78_When User navigates to promotions screen under Afternoon Checks and Promotions is schedule for the selected date. Then, User should be able to scan any fresh product to perform action as markdown.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action   | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Markdown | 2        | 3         | Markdowns    |

  @sma
  Scenario Outline: SMA-27045_UAT_79_1_When user navigates Promotions under Afternoon Checks and User has scanned fresh product in promotion screen and perform action as Wastage and expiry date as future-dated. Then, Able to select reason code as Charity- Out of date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 2         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_79_2_When user navigates Promotions under Afternoon Checks and User has scanned fresh product in promotion screen and perform action as Wastage and expiry date as future-dated. Then, Able to select reason code as Waste Charity.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option        | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Charity | 2        | 2         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_79_3_When user navigates Promotions under Afternoon Checks and User has scanned fresh product in promotion screen and perform action as Wastage and expiry date as future-dated. Then, Able to select reason code as Waste Out of date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date | 2        | 2         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_79_4_When user navigates Promotions under Afternoon Checks and User has scanned fresh product in promotion screen and perform action as Wastage and expiry date as future-dated. Then, Able to select  reason codes as Waste Damaged/Fruit & Veg Quality or Condition
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 2         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_80_1_When User navigates to Promotions screen under Afternoon Checks and User has scanned Fresh product in promotion screen and perform action as Wastage and expiry date as back-dated. Then, next scan date is displayed on item scan screen,and able to select reason codes - Waste Out of Date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date | 2        | -1        | Wasted       |


  @sma
  Scenario Outline: SMA-27045_UAT_81_1_When User navigates to Promotions screen under Afternoon Checks and User wants to delete product from the viewt list of product. Then,User should be able to delete the products actioned as Markdown and then the deleted item must disappear from the list of scanned items.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action   | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Markdown | 2        | 3         | Markdowns    |

  @sma
  Scenario Outline: SMA-27045_UAT_81_2_When User navigates to Promotions screen under Afternoon Checks and User scan products and perform action as Wastage. Then verify Products which are actioned as Wastage cannot be deleted.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    And I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Disabled
    Then Verify product is not able to delete

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |


  @sma
  Scenario Outline: SMA-27045_UAT_83_When User navigates to Promotions screen under Afternoon Checks screen and Status is Completed. Then, user should able to Reopen the Promotion by clicking on "Yes" option on Reopen alert.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    And I click on View list of expiring products
    And I verify Complete promotion button is displayed
    Then I click on Complete promotions button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    Then I verify "<listMenu>" status is "<Status>"
    Then I click on "<listMenu>"
    And I click on Reopen promotions button
    Then I verify on Reopen Promotions alert
    And I click on Yes option on Reopen Complete Code Check alert
    And I click on back button
    Then I verify "<listMenu>" status is "<Status1>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction | Status    | Status1     | ratingOption |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       | Completed | In Progress | Good         |

  @sma
  Scenario Outline: SMA-27045_UAT_83_1_When User navigates to Promotions screen under Afternoon Checks screen and Status is Completed. Then , user should click on "No" option on Reopen alert and remains on same screen.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    And I click on View list of expiring products
    And I verify Complete promotion button is displayed
    Then I click on Complete promotions button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    Then I verify "<listMenu>" status is "<Status>"
    Then I click on "<listMenu>"
    And I click on Reopen promotions button
    Then I verify on Reopen Promotions alert
    And I click on No option on Reopen Complete Code Check alert
    And I click on back button
    Then I verify "<listMenu>" status is "<Status>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu   | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction | Status    |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Promotions | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       | Completed |

  ############################################# Warehouse ##########################################################################################
  @sma
  Scenario Outline: SMA-27045_UAT_84_When User navigates to Warehouse screen under Afternoon Checks and Warehouse is schedule for the selected date and User should be able to scan any fresh product to perform action as markdown.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action   | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Markdown | 2        | 3         | Markdowns    |

  @sma
  Scenario Outline: SMA-27045_UAT_85_1_When User navigates Warehouse under Afternoon Checks and User has scanned fresh product in Warehouse screen and perform action as Wastage and expiry date as future-dated. Then, Able to select any one of the Waste Charity.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option        | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Charity | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_85_2_When User navigates Warehouse under Afternoon Checks and User has scanned fresh product in Warehouse screen and perform action as Wastage and expiry date as future-dated. Then, Able to select any one of the Waste Damaged/Fruit & Veg Quality or Condition.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_85_3_When User navigates Warehouse under Afternoon Checks and User has scanned fresh product in Warehouse screen and perform action as Wastage and expiry date as future-dated. Then, Able to select Waste Out of date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_85_4_When User navigates Warehouse under Afternoon Checks and User has scanned fresh product in Warehouse screen and perform action as Wastage and expiry date as future-dated. Then, Able to select any one of the Waste Damaged/Fruit & Veg Quality or Condition.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_86_1_When User navigates to Warehouse screen under Afternoon Checks and User has scanned Fresh product in Warehouse screen and perform action as Wastage and expiry date as back-dated. Then, Next scan date is displayed on item scan screen,and able to select reason codes - Waste Out of Date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
    And I click on barcode entry Button
    And I enter Product Min "<productMin>"
    And I click on spinner to select one of the action "<action>"
    And I enter markdown "<quantity>" for the product
    And I click on Calendar
    Then I select next "<dateRange>" th date
    Then I click on Done Button
    And I click on plus Log product button on Product detail page
    Then Verify Select Reason Code template
    Then I click on alert to select one of the option "<option>"
    And I click on Confirm button
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option            | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Out of Date | 2        | -1        | Wasted       |


  @sma
  Scenario Outline: SMA-27045_UAT_87_When User navigates to Warehouse screen under Afternoon Checks and User wants to delete product from the view list of product. Then,User should be able to delete the products actioned as Markdown and then the deleted item must disappear from the list of scanned items.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    Then I Verify Scanned itemm "<productMin>" is visible on view list
    Then I Verify for Scanned itemm "<productMin>" action performed as "<verifyAction>" is visible on view list
    And I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Enabled
    Then I Delete the product

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action   | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Markdown | 2        | 3         | Markdowns    |

  @sma
  Scenario Outline: SMA-27045_UAT_87_When User navigates to Warehouse screen under Afternoon Checks and User scan the product and perform action as Wastage. Then verify Products which are actioned as Wastage cannot be deleted.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    And I click on View list of expiring products
    And I Swipe left
    Then I verify Delete icon is Disabled
    Then Verify product is not able to delete

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 1         | Wasted       |

  @sma
  Scenario Outline: SMA-27045_UAT_89_1_When User navigates to Warehouse screen under Afternoon Checks screen and Status is Completed. Then, user should able to Reopen the Promotion by clicking on "Yes" option on Reopen alert.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    And I click on View list of expiring products
    And I verify Complete warehouse button is displayed
    Then I click on Complete warehouse button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    Then I verify "<listMenu>" status is "<Status>"
    Then I click on "<listMenu>"
    And I click on Reopen warehouse button
    Then I verify on Reopen Warehouse alert
    And I click on Yes option on Reopen Complete Code Check alert
    And I click on back button
    Then I verify "<listMenu>" status is "<Status1>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction | Status    | Status1     |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 2         | Wasted       | Completed | In Progress |

  @sma
  Scenario Outline: SMA-27045_UAT_89_2_When User navigates to Warehouse screen under Afternoon Checks screen and Status is Completed. Then , user should click on "No" option on Reopen alert and remains on same screen.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I click on "<listMenu>"
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
    And I click on View list of expiring products
    And I verify Complete warehouse button is displayed
    Then I click on Complete warehouse button
    And I verify Rotation ratings page is displayed
    Then I select rating option as "<ratingOption>"
    Then I verify "<listMenu>" status is "<Status>"
    Then I click on "<listMenu>"
    And I click on Reopen warehouse button
    Then I verify on Reopen Warehouse alert
    And I click on No option on Reopen Complete Code Check alert
    And I click on back button
    Then I verify "<listMenu>" status is "<Status>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu  | Aisle   | Department | action  | option                                         | quantity | dateRange | verifyAction | Status    |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Warehouse | Aisle 0 | 065 Dairy  | Wastage | Waste Damaged/Fruit & Veg Quality or Condition | 2        | 2         | Wasted       | Completed |

  #######################################################################################################################################
  @sma
  Scenario Outline: Verify 'Afternoon Checks' status as 'Completed' after Completing Critical Check,Fixture,Promotion and Warehouse location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Cuurent date Schedule
    Then I click on "<SubMenu>"
    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
    Then I verify "<listMenu1>" status is "<Status>"
    Then I verify "<listMenu2>" status is "<Status>"
    Then I verify "<listMenu3>" status is "<Status>"
    Then I verify "<listMenu4>" status is "<Status>"
    And I click on Back button
    Then I verify "<SubMenu>" status is "<Status>"

    Examples:
      | StoreID | productMin | Menu             | Department_Menu | SubMenu          | listMenu1       | listMenu2 | listMenu3  | listMenu4 | Status    |
      | 8      | 103034836  | Fresh Code Check | Daily Schedule  | Afternoon Checks | Critical Checks | Fixture   | Promotions | Warehouse | Completed |
