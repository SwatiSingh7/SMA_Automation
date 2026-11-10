@NewfccDailySchedule @regression
Feature: Verify Daily Schedule-Daily Checks in Fresh code check

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | pm       |

  @sma
  Scenario Outline: UAT_27Verify Overdue schedule date User should be able to view in  Daily Schedule module with status as 'Overdue'
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify status as "<Status>"

    Examples:
      | Menu             | Department_Menu | Status  |
      | Fresh Code Check | Daily Schedule  | OVERDUE |

  @sma
  Scenario Outline:UAT_28Verify On current day User should be able to view list of 9 scheduled days
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify list of nine schedule days

    Examples:
      | Menu             | Department_Menu | Status  |
      | Fresh Code Check | Daily Schedule  | OVERDUE |

  @sma
  Scenario Outline:UAT_29Verify On current day User should be able to view Below list of checks
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I select current day date
    And I verify "<Submenu1>" is displayed
    And I verify "<Submenu2>" is displayed
    And I verify "<Submenu3>" is displayed

    Examples:
      | Menu             | Department_Menu | Submenu1     | Submenu2         | Submenu3                 |
#      | Fresh Code Check | Daily Schedule  | First Check | Second Check | Fresh Food Manager Check |
      | Fresh Code Check | Daily Schedule  | Daily Checks | Second Check | Fresh Food Manager Check |

  @sma
  Scenario Outline:UAT_30Verify On current day User view list of menu for 'Daily Checks'
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I select current day date
    And I verify status as "<Status>"
    Then I click on "<SubMenu>"
    And I verify "<list1>" is displayed
    And I verify "<list2>" is displayed
    And I verify "<list3>" is displayed
    And I verify "<list4>" is displayed

    Examples:
      | Menu             | Department_Menu | SubMenu      | Status      | list1           | list2   | list3      | list4     |
#      | Fresh Code Check | Daily Schedule  | First Check | NOT CHECKED | Critical Checks | Fixture | Promotions | Warehouse |
      | Fresh Code Check | Daily Schedule  | Daily Checks | NOT CHECKED | Critical Checks | Fixture | Promotions | Warehouse |
#
##  @sma
##  Scenario Outline: UAT_02_Verify for Daily check seperation between Short Life departments and Long Life departments are displayed
##    When I enter Username and Password for SMA Collegue user
##    And I click on login button for SMA
##    Then I click on the main menu "Code Checking"
##    Then I click on "<Menu>"
##    Then I click on "<Department_Menu>"
##    And I click on Cuurent date Schedule
##    Then I click on "<SubMenu>"
##    And I verify Critical Check,Fixture,Promotion and Warehouse are displayed
##    Then I click on "<Location>"
##    And I verify Aisle list is displayed
##    Then I click on "<Aisle>"
##    And I verify seperation between Short Life departments and Long Life departments are displayed
##
##    Examples:
##      | Menu             | Department_Menu | SubMenu      |  Location | Aisle    |
##      | Fresh Code Check | Daily Schedule  | First Check  |  Fixture   | Aisle 33 |
#
##  Scenario Outline: UAT_31Verify in Daily Check  'Rotate to front' action is restricted for 'Short life department'
##    When I enter Username and Password for SMA Collegue user
##    And I click on login button for SMA
##    Then I click on the main menu "Code Checking"
##    Then I click on "<Menu>"
##    Then I click on "<Department_Menu>"
##    And I select current day date
##    Then I click on "<SubMenu>"
##    Then I click on "<Location>"
##    Then I click on "<Aisle>"
##    Then I select "<Productgroup>"
##    And I click on barcode entry Button
##    Then Enter "<MIN>" number
##    And I click on action spinner
##    Then Verify "<Action>" action is not displayed
##
##    Examples:
##      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action          | Quantity | dateRangeMax |
##      | Fresh Code Check | Daily Schedule  | First Check | NOT CHECKED | Fixture  | Aisle 33 | Bought In Bread 800g | 102369685 | Rotate To Front | 2        | 1            |
#
  @sma
  Scenario Outline: UAT_33Verify when user scan item in 'Fixture' location from any scheduled department/class/Subclass and perform 'Markdown' action and select expiry date as future date.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I select current day date
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    Then I click on "<Aisle>"
    Then I select "<Productgroup>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And I click on Calendar
    Then I select next <dateRange> th date
#    Then I select next "<dateRangeMax>" th date
    Then I click on Done Button
    And I capture product details
    And I click Log Product
#    Then I click on No Printer Available
#    Then I click on Add to Print Queuee
#    And I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action   | Quantity | dateRange    |
      | Fresh Code Check | Daily Schedule  | Daily Checks  | NOT CHECKED | Fixture  | Aisle 0 | Bought In Bread 800g | 102369685 | Markdown | 2        | 1            |
#      | Fresh Code Check | Daily Schedule  |  First Check | NOT CHECKED | Fixture  | Aisle 0 | White Bought In Bread 400g | 102369685 | Markdown | 2        | 1            |
#
#  @sma
#  Scenario Outline: UAT_04Verify and Scan 'Shortlife Department' for 'Fixture' location perform 'Wastage' action and select expiry date as 'Past expiry date'.
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
###    Then I select next <dateRange> th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
##    Then Verify Select Reason Code as Waste Out of date
#    And I select "<WastageReason>" and Confirm
##    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action  | Quantity | dateRange | WastageReason     |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | White Bought in Bread 400g | 102369685 | Wastage | 2        | -2        | Waste - Out of Date |
#
#  @sma
#  Scenario Outline: UAT_05Verify and Scan 'Short life Department' for 'Fixture' location perform 'Wastage' action and select expiry date as 'Fututre expiry date'.
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
##    Then I select next "<dateRange>" th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
#    Then Verify Select Reason Code template
##    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
#    And I select "<WastageReason>" and Confirm
##    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action  | Quantity | dateRange | WastageReason |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | White Bought in Bread 400g | 102370256 | Wastage | 2        | 1         | Charity - Damaged |
#
#  @sma
#  Scenario Outline: UAT_06Verify and Select 'Short life Department' for 'Fixture' and Scan 'long life Department' product and perform 'Rotate to Front' action
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
##    Then I select next "<dateRangeMax>" th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
##    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle   | Productgroup          | MIN       | Action          | Quantity | dateRange  |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | White Bought in Bread 400g  | 105828787 | Rotate To Front | 2        |1           |

#   Failing becasue of data issue
#  @sma
#  Scenario Outline: UAT_09Verify and Scan 'Long life Department' for 'Fixture' location perform 'Wastage' action and select expiry date as 'Past expiry date'.
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
#    Then I click on Done Button
##    And I capture product details
#    And I click Log Product
##    Then Verify Select Reason Code as Waste Out of date
#    And I select "<WastageReason>" and Confirm
#    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup        | MIN       | Action  | Quantity | dateRange | WastageReason     |
# #|Fresh Code Check|Daily Schedule|	Daily Checks|Not Checked|Fixture|Aisle 22|Bought In Breads	|		102369685|		Wastage|		2|			-2|Waste Out of Date|
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | 060 Chilled Desserts | 102376455 | Wastage | 2        | -2        | Waste - Out of Date |
#
  @sma
  Scenario Outline: UAT_10Verify and Scan 'Long life Department' for 'Fixture' location perform 'Wastage' action and select expiry date as 'Fututre expiry date'.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I select current day date
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    Then I click on "<Aisle>"
    Then I select "<Productgroup>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And I click on Calendar
    Then I select next <dateRange> th date
    Then I click on Done Button
    And I capture product details
    And I click Log Product
#    Then Verify Select Reason Code template
#    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
    And I select "<WastageReason>" and Confirm
#    And I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup        | MIN       | Action  | Quantity | dateRange | WastageReason |
 #|Fresh Code Check|Daily Schedule|	Daily Checks|Not Checked|Fixture|Aisle 22|Bought In Breads	|		102370256|		Wastage|		2|			2|Waste Out of Date|
      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | White Bought in Bread 400g  | 102376463 | Wastage | 2        | 2         | Charity - Out of Date |
###
###
#  @sma
#  Scenario Outline: UAT_13Verify and Select 'Long life Department' for 'Fixture' and Scan 'Short life Department' product and perform 'Wastage' action
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
##    Then Verify Select Reason Code template
##    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
#    And I select "<WastageReason>" and Confirm
##    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup        | MIN       | Action  | Quantity | dateRange | WastageReason |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | White Bought in Bread 400g | 102370264 | Wastage | 2        | 2         | Charity - Out of Date |
##

#  Markdown is done functinally
#  @sma
#  Scenario Outline: UAT_36Verify when User should be able to delete the products actioned as Markdown  deleted item will get disappear from the list of scanned items
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
#    Then I click on No Printer Available
#    Then I click on Add to Print Queuee
#    Then I click on Back button
#    And I verify my product displayed in view list
#    And I Delete products
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action   | Quantity | dateRange |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | 060 Chilled Desserts | 102369685 | Markdown | 2        | 2            |
#
#
#  @sma
#  Scenario Outline: UAT_37Verify department/class/subclass status as 'Completed' with Counts of Markdown, Wastage, RTF and Rotation Rating(as Average/Good/Poor).
#  Also displays Completed by XXXX, Date and time
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on Button "<Button>"
#    And I select rating and confirm
#    And I verify status as "<Status>"
#    And I verify Counts and Rating
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location | Aisle    | Productgroup     | Button              | Status    |
#      | Fresh Code Check | Daily Schedule  | First Check  | Fixture  | Aisle 0 | 060 Chilled Desserts | COMPLETE CODE CHECK | COMPLETED |
#status not available as required
# @sma
# Scenario Outline: UAT_38 Verify Fixture Location status as 'In Progress'  When User completes all the Aisles under Fixture location
# When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#          And I verify status as "<Status>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#          And I verify status as "<Status>"
#
# Examples:
# | Menu | 			Department_Menu |	SubMenu|Location|Aisle|		Productgroup|				Button|				Status	|
# |Fresh Code Check|Daily Schedule|	First Check|Fixture|Aisle 0 |Bought In Breads		|COMPLETE CODE CHECK|In Progress|
##
#  @sma
#  Scenario Outline: UAT_39Verfiy User able to 'Reopen Code Rotate Group'when status of Department is completed in 'Fixture'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I reopen department "<Productgroup>"
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | Status     |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | 060 Chilled Desserts | In Progress |
#

#  Min not valid
#  @sma
#  Scenario Outline: UAT_40 verify after reopening respective department, user can performs delete operation on scanned items in 'Fixture'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#	Then I select next <dateRange> th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
#    And I verify my product displayed in view list
#    And I Delete products
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action          | Quantity | dateRange    |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | 060 Chilled Desserts | 102370264 | Rotate To Front | 2        | 1            |
##


#  date range issue
#  @sma
#  Scenario Outline: UAT_41 Verify Popup msg for invalid Schedule check
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I select next <dateRange> th date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click Log Product
#    And I verify Pop Message for invalide Schedule
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action          | Quantity | dateRange | WastageReason     |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 33 | Bought In Breads | 102370264 | Rotate To Front | 2        | -5         | Waste Out of Date |

#  not an ambient product
#  @sma
#  Scenario Outline: UAT_42 verify when 'Ambient product' is scanned , prompt will appear and user remain on same department screen
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I Confirm prompt for Ambient product
#    And I verify department screnn remain same
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | Bought In Bread 800g | 105101123 |

# ########################################################################-Critical Checks-########################################################################


#  Markdown will be done by functional
#  @sma
#  Scenario Outline: UAT_43 verify when 'non-Ranged' product scanned in fixture and redirected to 'Critical Check'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on barcode entry Button
#    Then Enter "<MIN>" number
#    And I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And I click on Calendar
#    Then I select next <dateRange> th date
#    Then I click on Done Button
#    And I capture product details
#    And I click Log Product
#    Then I click on No Printer Available
##Then I click on Add to Print Queuee
#    #Then I click on Back button
#    #And I verify redirect to Critical check
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Status      | Location | Aisle    | Productgroup     | MIN       | Action   | Quantity | dateRange    |
#      | Fresh Code Check | Daily Schedule  | First Check  | NOT CHECKED | Fixture  | Aisle 0 | Bought In Bread 800g | 103092761 | Markdown | 2        | 1            |
#
#  @sma
#  Scenario Outline:UAT_44 Verify when user performs delete operation on products actioned as (Markdown/Rotate to front) in 'Critical Check'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    And I Delete products in critical check
#    Then I click on Back button
#    And I verify Critical checks status "<Status1>"
#
#    Examples:
#      | storeId | Menu             | Department_Menu | SubMenu      | Location        | Status | Status1 | MIN       |
#      | 78      | Fresh Code Check | Daily Schedule  | First Check  | Critical Checks | 1 OF 1 | 0 OF 0  | 110729185 |
#
#
#  @sma
#  Scenario Outline:UAT_45 Verify user performs 'Complete Code Check' in 'Critical Check' and display status as 'Completed'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    And I verify Critical checks status "<Status>"
#    Then I click on "<Location>"
#    And I click on Button "<Button>"
#    And I verify Critical checks status "<Status1>"
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location        | Status | Button              | Status1   |
#      | Fresh Code Check | Daily Schedule  | First Check  | Critical Checks | 0 OF 0 | COMPLETE CODE CHECK | COMPLETED |
##
#
#  @sma
#  Scenario Outline:UAT_46 Verify when status is completed, user performs 'Reopen Code Rotate Group' in 'Critical Check'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    And I verify Critical checks status "<Status>"
#    Then I reopen department "<Location>"
#    Then I click on Back button
#    And I verify Critical checks status "<Status1>"
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location        | Status    | Status1 |
#      | Fresh Code Check | Daily Schedule  | First Check  | Critical Checks | COMPLETED | 0 OF 0  |
##
##@sma
##Scenario: UAT_47 Verify Overdue status date disapper, After successful completion all the checks(Daily Checks, Afternoon Checks, FCC manager)
##
##Given: User navigates to Daily Schedule
##When: On current day, user should be able to view list of Overdue scheduled days(Today-3 to Today-7)
##Then: will be able to perform actions (Wastage\Markdown\Rotate to Front) and complete the respective day.
##If the respective overdue day is completed than that particular day will get disappear from the list"
#
######################################################################################-PROMOTIONS-#####################################################
#
#
#  @sma
#  Scenario Outline: UAT_48 Verify 'Promotion' screen when 'Markdown' action is performed for scanned product
#    When  I enter Username and Password for SMA Collegue user
#    And  I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then  I click on "<Menu>"
#    Then  I click on "<Department_Menu>"
#    And  I select current day date
#    Then  I click on "<SubMenu>"
#    Then  I click on "<Location>"
#    Then I verify Next scan date is displayed
#    And  I click on barcode entry Button
#    Then  Enter "<MIN>" number
#    And  I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And  I click on Calendar
#    Then  I select next <dateRange> th date
#    Then  I click on Done Button
#    And  I capture product details
#    And I click Log Product
#    Then  I click on No Printer Available
#    Then  I click on Add to Print Queuee
#    And  I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location   | MIN       | Action   | Quantity | dateRange    |
#      | Fresh Code Check | Daily Schedule  | First Check  | Promotions | 107076451 | Markdown | 2        | 1            |
#
#  @sma
#  Scenario Outline: UAT_49 Verify 'Promotion' screen when 'Wastage' action is performed for scanned product for future expiry date
#    When  I enter Username and Password for SMA Collegue user
#    And  I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then  I click on "<Menu>"
#    Then  I click on "<Department_Menu>"
#    And  I select current day date
#    Then  I click on "<SubMenu>"
#    Then  I click on "<Location>"
#    And  I click on barcode entry Button
#    Then  Enter "<MIN>" number
#    And  I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And  I click on Calendar
#    Then  I select next <dateRange> th date
#    Then  I click on Done Button
#    And  I capture product details
#    And I click Log Product
##    Then Verify Select Reason Code template
##    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
#    And I select "<WastageReason>" and Confirm
#    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location   | MIN       | Action  | Quantity | dateRange    | WastageReason     |
#      | Fresh Code Check | Daily Schedule  | First Check  | Promotions | 107076451 | Wastage | 2        | 4            | Waste - Out of Date |
#
#  @sma
#  Scenario Outline: UAT_50 Verify 'Promotion' screen when 'Wastage' action is performed for scanned product for past expiry date
#    When  I enter Username and Password for SMA Collegue user
#    And  I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then  I click on "<Menu>"
#    Then  I click on "<Department_Menu>"
#    And  I select current day date
#    Then  I click on "<SubMenu>"
#    Then  I click on "<Location>"
#    And  I click on barcode entry Button
#    Then  Enter "<MIN>" number
#    And  I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And  I click on Calendar
#    Then  I select next <dateRange> th date
#    Then  I click on Done Button
#    And  I capture product details
#    And I click Log Product
##    Then Verify Select Reason Code template
##    Then Verify Select Reason Code as Waste Out of date
#    And I select "<WastageReason>" and Confirm
#    And I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location   | MIN       | Action  | Quantity | dateRange    | WastageReason     |
#      | Fresh Code Check | Daily Schedule  | First Check  | Promotions | 107076451 | Wastage | 2        | -1           | Waste - Out of Date |
#
#  @sma
#  Scenario Outline: UAT_51 Verify 'Promotion' screen when user 'Delete' product actioned as Markdow from view list
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    And I verify my product displayed in view list
#    And I Delete products
#
#		#	Given Request is made to SMA app login service for manager user
#		#  Then Service should return details for SMA app Login Service
#		#  And Get generated access token
#		#  Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<MIN>"
#		#  And Get Operation perform on Markdown service request
#		#  Then Get markdown details service response after scanning the product
#		#  Given Patch request is made to delete print list service for store id "<storeId>"
#		#  Then Patch Operation perform on Markdown service request
#		#
#
#    Examples:
#      | storeId | Menu             | Department_Menu | SubMenu      | Location   | MIN       |
#      | 8      | Fresh Code Check | Daily Schedule  | First Check   | Promotions | 107076451 |

#  @sma
#  Scenario Outline: UAT_14 Verify user give Rotation Rating for 'Promotion' screen when user click 'Complete Promotions'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I verify Next scan date is displayed
#    And I click on Button "<Button>"
##    And I select rating and confirm
##    And I verify Counts and Rating
#    And I verify promotion status "<Status>"
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location   | Button              | Status    |
#      | Fresh Code Check | Daily Schedule  | First Check  | Promotions | COMPLETE PROMOTIONS | COMPLETED |
###
#  @sma
#  Scenario Outline: UAT_53 Verify when status is completed, user performs 'Reopen Code Rotate Group' in 'Promotion'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    And I verify promotion status "<Status>"
#    Then I click on "<Location>"
#    And I click on Button "<Button>"
#    And I click Continue
#    Then I click on Back button
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location   | Status    | Status1     | Button             |
#      | Fresh Code Check | Daily Schedule  | First Check  | Promotions | COMPLETED | In Progress | RE-OPEN PROMOTIONS |

###################################################################################################-WAREHOUSE-#################################################
#
#
#  @sma
#  Scenario Outline: UAT_54 Verify 'Warehouse' screen when 'Markdown' action is performed for scanned product
#    When  I enter Username and Password for SMA Collegue user
#    And  I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then  I click on "<Menu>"
#    Then  I click on "<Department_Menu>"
#    And  I select current day date
#    Then  I click on "<SubMenu>"
#    Then  I click on "<Location>"
#    And  I click on barcode entry Button
#    Then I verify Next scan date is displayed
#    Then  Enter "<MIN>" number
#    And  I click on spinner to select one of the action "<Action>"
#    And I enter markdown "<Quantity>" for the product
#    And  I click on Calendar
#    Then  I select next <dateRange> th date
#    Then  I click on Done Button
#    And  I capture product details
#    And I click Log Product
#    Then  I click on No Printer Available
#    Then  I click on Add to Print Queuee
#    And  I verify my product displayed in view list
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location  | MIN       | Action   | Quantity | dateRange        |
#      | Fresh Code Check | Daily Schedule  | First Check  | Warehouse | 105521988 | Markdown | 2        | 1            |
#
#
  @sma
  Scenario Outline: UAT_55 Verify 'Warehouse' screen when 'Wastage' action is performed for scanned product for future expiry date
    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then  I click on "<Menu>"
    Then  I click on "<Department_Menu>"
    And  I select current day date
    Then  I click on "<SubMenu>"
    Then  I click on "<Location>"
    And  I click on barcode entry Button
    Then  Enter "<MIN>" number
    And  I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And  I click on Calendar
    Then  I select next <dateRange> th date
    Then  I click on Done Button
    And  I capture product details
    And I click Log Product
#    Then Verify Select Reason Code template
#    Then Verify Select Reason Code as Waste Damaged Fruit & Veg Quality or Condition, Waste Out of date ,Waste Charity
    And I select "<WastageReason>" and Confirm
    And I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu | SubMenu      | Location  | MIN       | Action  | Quantity | dateRange    | WastageReason     |
      | Fresh Code Check | Daily Schedule  | First Check  | Warehouse | 102796353 | Wastage | 2        | 1            | Waste - Out of Date |
##
##
  @sma
  Scenario Outline: UAT_56 Verify 'Warehouse' screen when 'Wastage' action is performed for scanned product for past expiry date
    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then I click on the main menu "Code Checking"
    Then  I click on "<Menu>"
    Then  I click on "<Department_Menu>"
    And  I select current day date
    Then  I click on "<SubMenu>"
    Then  I click on "<Location>"
    And  I click on barcode entry Button
    Then  Enter "<MIN>" number
    And  I click on spinner to select one of the action "<Action>"
    And I enter markdown "<Quantity>" for the product
    And  I click on Calendar
    Then  I select next <dateRange> th date
    Then  I click on Done Button
    And  I capture product details
    And I click Log Product
#    Then Verify Select Reason Code template
#   Then Verify Select Reason Code as Waste Out of date
    And I select "<WastageReason>" and Confirm
    And I verify my product displayed in view list

    Examples:
      | Menu             | Department_Menu | SubMenu      | Location  | MIN       | Action  | Quantity | dateRange    | WastageReason     |
      | Fresh Code Check | Daily Schedule  | First Check  | Warehouse | 102796353 | Wastage | 2        | -2           | Waste - Out of Date |
#
#
#  @sma
#  Scenario Outline: UAT_57 Verify 'Warehouse' screen when user 'Delete' product actioned as Markdow from view list
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    And I verify my product displayed in view list
#    And I Delete products
#    Given Request is made to SMA app login service for manager user
#    Then Service should return details for SMA app Login Service
#    And Get generated access token
#    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<MIN>"
#    And Get Operation perform on Markdown service request
#    Then Get markdown details service response after scanning the product
#    Given Patch request is made to delete print list service for store id "<storeId>"
#    Then Patch Operation perform on Markdown service request
#
#    Examples:
#      | storeId | Menu             | Department_Menu | SubMenu      | Location  | MIN       |
#      | 78      | Fresh Code Check | Daily Schedule  | First Check  | Warehouse | 110488705 |
#
#  @sma
#  Scenario Outline: UAT_15 Verify user give Rotation Rating for 'Warehouse' screen when user click 'Complete Promotions'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    Then I verify Next scan date is displayed
#    And I click on Button "<Button>"
#    And I select rating and confirm
#    And I verify Counts and Rating
#    And I verify warehouse status "<Status>"
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location  | Button             | Status    |
#      | Fresh Code Check | Daily Schedule  | First Check  | Warehouse | COMPLETE WAREHOUSE | COMPLETED |
#



#  Status issue
#  @sma
#  Scenario Outline: UAT_59 Verify when status is completed, user performs 'Reopen Code Rotate Group' in 'Warehouse'
#    When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    And I verify warehouse status "<Status>"
#    Then I click on "<Location>"
#    And I click on Button "<Button>"
#    And I click Continue
#    Then I click on Back button
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location  | Status    | Status1     | Button            |
#      | Fresh Code Check | Daily Schedule  | First Check | Warehouse | In Progress | In Progress | RE-OPEN WAREHOUSE |
#
#
#  @sma
#  Scenario Outline: Complete all Daily checks current day schedule for Critical check,Fixture,Promotion and Warehouse
#    When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    Then I click on the main menu "Code Checking"
#    Then I click on "<Menu>"
#    Then I click on "<Department_Menu>"
#    And I select current day date
#    Then I click on "<SubMenu>"
#    Then I click on "<Location>"
#    And I click on Button "<Button>"
#    Then I click on "<Location1>"
#    Then I click on "<Aisle>"
#    Then I select "<Productgroup>"
#    And I click on Button "<Button1>"
#    And I select rating and confirm
#    Then I click on Back button
#    Then I click on Back button
#    Then I click on "<Location2>"
#    And I click on Button "<Button2>"
#    And I click Continue
#    Then I click on "<Location3>"
#    And I click on Button "<Button3>"
#    And I click Continue
#    And I verify warehouse status "<Status>"
#    And I verify promotion status "<Status>"
#    And I verify Critical checks status "<Status>"
#
#    Examples:
#      | Menu             | Department_Menu | SubMenu      | Location        | Button              | Location1 | Location2  | Location3 | Aisle    | Productgroup     | Button1             | Button2             | Button3            | Status    |
#      | Fresh Code Check | Daily Schedule  | First Check | Critical Checks | COMPLETE CODE CHECK | Fixture   | Promotions | Warehouse | Aisle 0 | Bought In Bread 800g | COMPLETE CODE CHECK | COMPLETE PROMOTIONS | COMPLETE WAREHOUSE | Completed |

		