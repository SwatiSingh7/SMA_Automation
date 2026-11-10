@CleanAndRotate
Feature: Verify Clean and Rotate functionality

  Background:
  The following automation scripts will cover the functional scenarios for the Clean and Rotate functionality.
  Pre-requisites : We need One store for performing Clean and rotate regression.

  We need to run the following queries before running the regression scenarios :
  Database name : Clean and rotate
  Firstly do the required modification in below queries and then execute.

  For deleting existing data :
  select * from department_config where category = 'Ambient' and week_check  = 13;
  select * from department_check where dept_config_id = '3057942';
  select * from department_product_check where dept_check_id = '112514';

  Insert query to create New data :
  INSERT INTO public.department_config
  (dept_id, dept_name, store_dept_name, week_check, year_check, date_check, next_check, is_enabled, category, shelf_life, store_id, signoff_status, signoff_updated_by_id, signoff_updated_by_name, signoff_updated_on, is_critical, is_range, aisle, daily_code_check_type_id, hierarchy_key, is_promotion, is_warehouse)
  VALUES
  (22, 'Crisps and Snacks', 'Crisps and Snacks', 9, 2022, '2022-02-28', '2022-05-09', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (34,'Canned Fruit','Canned Fruit', 9, 2022, '2022-02-28', '2022-05-09', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (22, 'Crisps and Snacks', 'Crisps and Snacks', 10, 2022, '2022-03-07', '2022-05-16', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (34, 'Canned Fruit', 'Canned Fruit', 10, 2022, '2022-03-07', '2022-05-16', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (34, 'Canned Fruit', 'Canned Fruit', 11, 2022, '2022-03-14', '2022-05-23', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (22, 'Crisps and Snacks', 'Crisps and Snacks', 12, 2022, '2022-03-21', '2022-05-30', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
  (22, 'Crisps and Snacks', 'Crisps and Snacks', 13, 2022, '2022-03-28', '2022-06-06', true, 'Ambient', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

  Only if the above scripts are run the automation scripts would guarantee a proper result.

  @sma @StckOrdUpdateTask
  Scenario Outline: To update StockV2 service making it down and up
    Given I update the service "<serviceArn>" making it down and up with ClusterName "<ClusterName>"

    Examples:
      | serviceArn                                             | ClusterName                         |
      | stockV2Adjustment_srv_sit-ecs-stkordadptr-task-sit-001 | nonprod-ECS-ECSCluster-W68V9ZHCS399 |

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 6     | 45   | am       |

  @sma @tuu
  Scenario Outline: Log product with Action -> Wastage
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I Get Department Name for "Non-Crisp" type dept
    And I Get "First" Product Min for "Non-Crisp" department
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
    And I Get Weekly Schedules Submenus status
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    And I Get First Weekly schedule status
    Then I Verify Weekly schedule Submenu status is same as First Weekly Schedule status inside week schedule
    Then I Scroll down on Weekly schedule page
    And I Verify for "Current Week" schedule status is ""

#    When I get login response through API for "/json-files/service/login/managerPostLogin.json"

    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service
    When I get the schedule details through API
    And I verify Weekly Schedule status is same on UI and GetSchedule Service

    And I Select Weekly schedule for "Current Week"
    Then I get the department details through API
    Then I Verify Department page
    Then I Verify Department status is "ToStart"
    And I verify Department status is same on UI and API
    And I Select Department
####################### Without Scanning any product, Perform Complete Code Rotate and Reopen.
    And I Click on Complete Code Rotate Group button
    Then I Verify Department status is "Completed"
    Then I Verify Department Completion Message
    And I Select Department
    Then I Click on Reopen code rotate group button
    And Verify "Reopen Department" alert is displayed
    Then I should get a Message saying "Are you sure you want to open the completed check for this department?" and should be able to click the "YES" Button

    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    Then I should get a Message saying "<message1>" and should be able to click the "Cancel" Button
#    Then I verify Quantity check message is displayed
#    And I click on cancel on Alert
    And I enter the quantity as "90" in Quantity textbox
    Then I click on Log Product button on Action log page
#    Then I verify Quantity check message is displayed
#    And I click on cancel on Alert
    Then I should get a Message saying "<message2>" and should be able to click the "Cancel" Button
    And I enter the quantity as "20" in Quantity textbox
    Then I click on Log Product button on Action log page
    Then I should get a Message saying "<message3>" and should be able to click the "Confirm" Button
#    Then I verify Quantity check message is displayed
#    Then I confirm the alert
    And I Verify Wastage reason Alert Title and Message
    Then I select "<wastageOption1>" Action on Wastage Reason alert and click on Confirm
    Then I Verify product is logged with "<verifyAction>" action
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    Then I should get a Message saying "<message1>" and should be able to click the "Cancel" Button
#    Then I verify Quantity check message is displayed
#    And I click on cancel on Alert
    And I enter the quantity as "90" in Quantity textbox
    Then I click on Log Product button on Action log page
    Then I should get a Message saying "<message2>" and should be able to click the "Cancel" Button
#    Then I verify Quantity check message is displayed
#    And I click on cancel on Alert
    And I enter the quantity as "20" in Quantity textbox
    Then I click on Log Product button on Action log page
#    Then I verify Quantity check message is displayed
#    Then I confirm the alert
    Then I should get a Message saying "<message3>" and should be able to click the "Confirm" Button
    And I Verify Wastage reason Alert Title and Message
    Then I select "<wastageOption2>" Action on Wastage Reason alert and click on Confirm
    Then I Verify product is logged with "<verifyAction>" action

    Then I get action and quantity on UI
    When I get the item details through API
    And I verify Action and quantity on UI and service is same

    And I Get "Second" Product Min for "Non-Crisp" department
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
#   Then I verify Quantity check message is displayed
#    And I click on cancel on Alert
    Then I should get a Message saying "<message1>" and should be able to click the "Cancel" Button

    And I enter the quantity as "90" in Quantity textbox
    Then I click on Log Product button on Action log page
#    Then I verify Quantity check message is displayed
    And I click on cancel on Alert
#    Then I should get a Message saying "<message2>" and should be able to click the "Cancel" Button
    And I enter the quantity as "20" in Quantity textbox
    Then I click on Log Product button on Action log page
#    Then I verify Quantity check message is displayed
    Then I confirm the alert
#    Then I should get a Message saying "<message3>" and should be able to click the "Confirm" Button
    And I Verify Wastage reason Alert Title and Message
    Then I select "<wastageOption3>" Action on Wastage Reason alert and click on Confirm
    Then I Verify product is logged with "<verifyAction>" action

    Then I get action and quantity on UI
    When I get the item details through API
    And I verify Action and quantity on UI and service is same

    And I click on View list
    And I Verify the latest scanned Product Min is visible at the top
    Then I Swipe left on View list screen
    And I Verify Delete button is "Disabled"
    Then I click on "Back" button

    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus 2 date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    Then I should get a Message saying "<message1>" and should be able to click the "Cancel" Button
    And I enter the quantity as "90" in Quantity textbox
    Then I click on Log Product button on Action log page
#    Then I should get a Message saying "<message2>" and should be able to click the "Cancel" Button
#    Then I verify Quantity check message is displayed
    And I click on cancel on Alert
    And I enter the quantity as "20" in Quantity textbox
    Then I click on Log Product button on Action log page
#    Then I verify Quantity check message is displayed
    Then I confirm the alert
#    Then I should get a Message saying "You have entered a quantity of 10 units or more.\n\nPlease confirm that 20 units are correct." and should be able to click the "Confirm" Button
    And I Verify Wastage reason Alert Title and Message
    Then I select "<wastageOption4>" Action on Wastage Reason alert and click on Confirm
    Then I Verify product is logged with "<verifyAction>" action

    Then I get action and quantity on UI
    When I get the item details through API
    And I verify Action and quantity on UI and service is same

    And I click on View list
    And I Click on Complete Code Rotate Group button
    Then I Verify Department status is "Completed"
    And I Select Department
    Then I Click on Reopen code rotate group button
    And Verify "Reopen Department" alert is displayed
    Then I should get a Message saying "Are you sure you want to open the completed check for this department?" and should be able to click the "YES" Button
    Examples:
      | action  | quantity | wastageOption1  | wastageOption2      | wastageOption3    | wastageOption4        | verifyAction | message1                                                                                      | message2                                                                                            | message3                                                                                      |
      | Wastage | 10       | Waste - Damaged | Waste - Out of Date | Charity - Damaged | Charity - Out of Date | Wasted       | You have entered a quantity of 10 units or more.\n\nPlease confirm that 10 units are correct. | You have entered a quantity of 90 unit(s) to the value of £54.00\n\nPlease confirm this is correct. | You have entered a quantity of 10 units or more.\n\nPlease confirm that 20 units are correct. |

  @sma @RotateToFront
  Scenario Outline: Log product with Action - Rotate to front.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I Get Department Name for "Non-Crisp" type dept
    And I Get "First" Product Min for "Non-Crisp" department
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "Current Week"
    Then I Verify Department page
    And I Select Department
    Then I Verify Department details page
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    Then I Verify product is logged with "<verifyAction>" action
    Then I get action and quantity on UI

#    Then I get login response through API for "/json-files/service/login/managerPostLogin.json"
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service

    Then I get the department details through API
    When I get the item details through API
    And I verify Action and quantity on UI and service is same

    Then I click on "Back" button
    Then I Verify Department status is "In Progress"
    Then I verify Department status is same on UI and API

    Examples:
      | action          | quantity | verifyAction | dateRange |
      | Rotate To Front | 10       | Rotated      | 29        |


  @sma @VerfCrispMardwn&ClearanceAlert
  Scenario Outline:  For Crisp Department, verify Markdown and Clearance alert functionality.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I Get Department Name for "Crisp" type dept
    And I Get "First" Product Min for "Crisp" department
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "Overdue Week"
    And I Select Department
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange1> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert pop-up is not displayed
    Then I Verify product is logged with "<verifyAction>" action

    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange2> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert pop-up is not displayed
    Then I Verify product is logged with "<verifyAction>" action

    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange3> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<expectedMessage>" is displayed
    Then I click on "Back" button
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange4> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<expectedMessage>" is displayed

    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on "Back" button

    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "<selectWeek>"
    And I Select Department
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange1> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert pop-up is not displayed
    Then I Verify product is logged with "<verifyAction>" action
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange2> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert pop-up is not displayed
    Then I Verify product is logged with "<verifyAction>" action
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange3> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<expectedMessage>" is displayed
    Then I click on "Back" button

    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange4> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<expectedMessage>" is displayed
    Then I click on "Back" button
    Examples:
      | action          | quantity | verifyAction | dateRange1 | dateRange2 | dateRange3 | dateRange4 | selectWeek   | expectedMessage                                                                                         |
      | Rotate To Front | 10       | Rotated      | 14         | 21         | 2          | 12         | Current Week | This product is due to expire, Please complete a clearance markdown. And move product to clearance bay. |

  @sma @NonCrispMandCAlert
  Scenario Outline:  For Non-Crisp Department, verify Markdown and Clearance alert functionality.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I Get Department Name for "Non-Crisp" type dept
    And I Get "First" Product Min for "Non-Crisp" department
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "Overdue Week"
    And I Select Department
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange1> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert popup with "<markdownAlertMessage>" is displayed
    Then I click on "Back" button
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange2> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert popup with "<markdownAlertMessage>" is displayed
    Then I click on "Back" button
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange3> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<clearenceAlertMessage>" is displayed
    Then I click on "Back" button
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange4> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<clearenceAlertMessage>" is displayed
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on "Back" button
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "Current Week"
    And I Select Department
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange1> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert popup with "<markdownAlertMessage>" is displayed
    Then I click on "Back" button
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange2> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify 1st Markdown alert popup with "<markdownAlertMessage>" is displayed
    Then I click on "Back" button
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange3> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<clearenceAlertMessage>" is displayed
    Then I click on "Back" button
    And I Enter Product Min and click on search
    Then I select "<action>" Action on Action log page
    And I Select Current Date plus <dateRange4> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I verify Clearance Markdown alert popup with "<clearenceAlertMessage>" is displayed
    Then I click on "Back" button
    Examples:
      | action          | quantity | dateRange1 | dateRange2 | dateRange3 | dateRange4 | markdownAlertMessage                                   | clearenceAlertMessage                                                                                   |
      | Rotate To Front | 10       | 14         | 21         | 2          | 12         | This product expires soon, Please complete a markdown. | This product is due to expire, Please complete a clearance markdown. And move product to clearance bay. |

  @sma @VerfInstrMsg
  Scenario:  Verify Instruction Messages on Ambient Clearance Bay Page and Frozen Clearance Bay Check Page
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I Get Department Name for "Non-Crisp" type dept
    And I Get "First" Product Min for "Non-Crisp" department
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
    Then I click on "Ambient Clearance Bay Check" on Clean and Rotate Page
    Then I verify Instruction Message on Ambient Clearance Bay Check page
    And I click on Confirm Clearance Bay Check button on Ambient Clearance Bay Check page
    Then I click on "Frozen Clearance Bay Check" on Clean and Rotate Page
    Then I verify Instruction Message on Frozen Clearance Bay Check Page
    And I click on Confirm Clearance Bay Check button on Frozen Clearance Bay Check Page


  @sma @NavigateToAnyPageFromHK
  Scenario: Verify User is able to navigate to any page from any Hotkeys menu on top right
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on 'ScheduledCounts' on page 'HomePagePO_New'
#    Then I click on "Counts" on Home Page
    And I click on hotkeys option
    Then I verify option "Stock Adjustments" is available in hotkeys
    Then I click on option "Stock Adjustments" from hotkeys
    And I verify Stock Adjustment page  is displayed
    Then I click on "Action Waste" on Stock Adjustment Page
    Then I click on "Back" button
    Then I click on "Transfer Stock To A Dept" on Stock Adjustment Page
    Then I click on "Back" button
    Then I click on "Transfer Back From A Dept" on Stock Adjustment Page
    Then I click on "Back" button
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "Back" button
    Then I click on "Store To Store Transfer" on Stock Adjustment Page
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on 'hotKeyOption' on page 'BaseClass'
    And I click on hotkeys option
    Then I verify option "Stock Information" is available in hotkeys
    Then I click on option "Stock Information" from hotkeys
    And I verify Stock Information page is displayed
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    #Then I click on 'ScheduledCounts' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Then I click on "Gaps, Lows, Highs" on Home Page
    And I click on hotkeys option
    Then I click on option "Markdowns" from hotkeys
    And I verify Markdowns page is displayed
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on "Back" button
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on "Fresh Code Check" on Home Page
    And I click on hotkeys option
    Then I click on option "Main Menu" from hotkeys
    Then I click on "Stock Information" on Home Page
    And I click on hotkeys option
#    And I verify "Stock Information" is not available in hotkeys
    Then I click on option "Main Menu" from hotkeys
    Then I click on "Stock Adjustments" on Home Page
    And I click on hotkeys option
#    And I verify "Stock Adjustments" is not available in hotkeys
    Then I click on option "Main Menu" from hotkeys

  @sma @VerfNextFutureWeek
  Scenario Outline: Verify alerts for Next-To-Future week and Next-to-Next-Future week
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I Get Department Name for "Crisp" type dept
    And I Get "First" Product Min for "Crisp" department
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "NextToFutureWeek"
    And I Select Department
    And I verify Currently unavailable alert with "<expectedMessage>" is displayed
    Then I click on "Back" button
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "NextToNextFutureWeek"
    And I Select Department
    And I verify Currently unavailable alert with "<expectedMessage>" is displayed
    Examples:
      | expectedMessage                                                   |
      | Products cannot be captured until one week before the start date. |

  @sma @VerfWastageActPastExp
  Scenario Outline:  Verify for Wastage action and past expiry_date,Wastage alert pop-up should be displayed with 2 options "Waste - Out of Date " and "Charity - Out of Date"
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I Get Department Name for "Non-Crisp" type dept
    And I Get "First" Product Min for "Non-Crisp" department
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "Current Week"
    And I Select Department
    And I Enter Product Min and click on search
    Then I select "Wastage" Action on Action log page
    And I Select Current Date plus <dateRange1> date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    And I Verify Wastage reason Alert Title and Message
    Then I verify "Waste - Out of Date" Action on Wastage Reason alert
    Then I verify "Charity - Out of Date" Action on Wastage Reason alert

    Examples:
      | quantity | dateRange1 |
      | 9       | -1         |
  @sma @VerfAwaitingSignOff
  Scenario: Verify status "Awaiting Signoff" is displayed after completion of Code Rotate Group for all the departments.Also verify Collegue user can not sign-off but Manager user can sign-off.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Weekly Schedules" on Clean and Rotate Page

    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "Current Week"
    And I complete code rotate for the departments

    Then I Verify Sign off Code Rotate button is getting displayed
    And I verify Sign off code rotate button is not enabled
    Then I click on "Back" button
    Then I Scroll down on Weekly schedule page
    Then I Verify for "Current Week" schedule status is "Awaiting Sign-Off"
    Then I logout of the system
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    Then I Scroll down on Weekly schedule page
    And I Select Weekly schedule for "Current Week"
    Then I Verify Sign off Code Rotate button is getting displayed
    And I verify Sign off code rotate button is enabled
    Then I Click on Sign-Off Code Rotate button
    Then I verify Confirm Sign off Alert is displayed
    Then I click on Cancel button on Confirm Sign off Alert
    Then I click on "Back" button
    Then I Scroll down on Weekly schedule page
    Then I Verify for "Current Week" schedule status is "Awaiting Sign-Off"

    And I Select Weekly schedule for "Current Week"
    Then I click on Sign-Off Code Rotate button on week page
    Then I click on Confirm button on Confirm Sign off Alert
#    Then I click on "Back" button
    Then I Scroll down on Weekly schedule page
    And I Verify Current Week is not displayed in Weekly schedule

  @sma @VerfAmbCodeAlert
  Scenario: Verify Ambient and Code alert functionality
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on dynamic "sLocatorName" "Code Checking" on page 'BaseClass'
    Then I click on dynamic "sLocatorName" "Ambient Clean & Rotate" on page 'BaseClass'
#    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Ambient & Frozen Code Alerts" on Clean and Rotate Page
    And I click on Alert dropdown
    Then I select "Clearance Alerts" from the Alert dropdown
    And I verify on Product Min list
    And I click on Alert dropdown

    Then I select "1st Alerts" from the Alert dropdown
    And I verify on Product Min list
    And I click on Alert dropdown
    Then I select "All Alerts" from the Alert dropdown
    And I verify on Product Min list
    Then I select product on Ambient and Frozen code page
    And I verify Product Details on Date Code alert page
    And I enter the desired quantity "10" for product
    Then I Click on Add next action button on Ambient frozen page
    Then I verify Quantity check message is displayed
    And I click on cancel on Alert
    And I enter the desired quantity "90" for product
    Then I Click on Add next action button on Ambient frozen page
    Then I verify Quantity check message is displayed
    And I click on cancel on Alert
    And I enter the desired quantity "9" for product
    Then I Click on Add next action button on Ambient frozen page
    And I verify reason code and Title on Wastage popup
    Then I select the desired reason code "Waste - Out of Date" for product

    Then I select product on Ambient and Frozen code page
    And I enter the desired quantity "10" for product
    Then I Click on Add next action button on Ambient frozen page
    Then I verify Quantity check message is displayed
    And I click on cancel on Alert
    And I enter the desired quantity "9" for product
    Then I Click on Add next action button on Ambient frozen page
    And I verify reason code and Title on Wastage popup
    Then I select the desired reason code "Charity - Out of Date" for product

    Then I select product on Ambient and Frozen code page
    Then I click on Action Spinner and select "No further action – Stock sold" Action
    And I verify Quantity input box is disabled
    Then I Click on Add next action button on Ambient frozen page



########################################### Markdown service should be UP #############################################################################

#  @sma
#  Scenario Outline: Log product with Action -> Markdown
#    When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    And I Get Department Name for "Non-Crisp" type dept
#    And I Get "First" Product Min for "Non-Crisp" department
#    Then I click on "Clean and Rotate" on Home Page
#    Then I click on "Weekly Schedules" on Clean and Rotate Page
#    Then I Scroll down on Weekly schedule page
#    And I Select Weekly schedule for "Current Week"
#    And I Select Department
#    And I Enter Product Min and click on search
#    Then I select "<action>" Action on Action log page
#    And I Select Current Date in Calendar
#    And I enter the quantity as "<quantity>" in Quantity textbox
#    Then I click on Log Product button on Action log page
#    And I Click on No Printer Available
#    And I verify Product details on Summary page
#    Then I Click on Add to Print Queue button
#
#    And I Get "First" Product Min for "Non-Crisp" department
#    And I Enter Product Min and click on search
#    Then I select "<action>" Action on Action log page
#    And I Select Current Date in Calendar
#    And I enter the quantity as "<quantity>" in Quantity textbox
#    Then I click on Log Product button on Action log page
#    And I Click on No Printer Available
#    And I verify Product details on Summary page
#    Then I Click on Add to Print Queue button
#
#    And I click on View list
#    And I Verify the latest scanned Product Min is visible at the top
#    Then I Swipe left on View list screen
#    And I Verify Delete button is "Enabled"
#    Then I Click On Delete button
#
#    Examples:
#      | action   | quantity |
#      | Markdown | 10       |
#
#
#  ############################################ Printer should be connected #############################################################
#  @sma
#  Scenario Outline: Log product with Action -> Markdown and verify Printer fuctionality.
#    When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    And I Get Department Name for "Non-Crisp" type dept
#    And I Get "First" Product Min for "Non-Crisp" department
#    Then I click on "Clean and Rotate" on Home Page
#    Then I click on "Weekly Schedules" on Clean and Rotate Page
#    Then I Scroll down on Weekly schedule page
#    And I Select Weekly schedule for "Current Week"
#    And I Select Department
#    And I Enter Product Min and click on search
#    Then I select "<action>" Action on Action log page
#    And I Select Current Date in Calendar
#    And I enter the quantity as "<quantity>" in Quantity textbox
#    Then I click on Log Product button on Action log page
#    Then I Enter Printer Barcode number "<printerBarcode>"
#    And I click On ADD To Queue button
#    Then I Click on Print button on Product details page
#    And I verify Product details on Print List page
#
#    Examples:
#      | action   | quantity | printerBarcode |
#      | Markdown | 10       | XXQPH184360260 |

