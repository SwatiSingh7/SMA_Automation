@twilight_manager @regression @store_walk
Feature: Verify Twilight manager functionality.

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples: 
      | Hours | Mins | Meridiem |
      |    07 |   00 | am       |

  @sma
  Scenario Outline: SMA_33289_MSGLH - Review --> Approval button is Disabled for Collegue user.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    And I click Counter & Fixture location
    And I search for "<MIN>"
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<MIN>" in list
    Then I click and enter "<Quantity>" for other location
    And I click Exit Other
    And I click on Back Button
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<MIN>" in list
    And I click and enter "<Quantity>" for backup location
    And I confirm count area
    And I click on Back Button
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I click on Back Button
    And I click Approval Tab
    And I see Approve label
    Then I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton>"

    Examples: 
      | storeID | MIN       | Department | Location | ApproveButton | Quantity | Type       |
      |      78 | 104695783 | Fresh Prep | Other    | Disabled      |      800 | Fresh Prep |

  @sma
  Scenario Outline: SMA_33289_MSGLH - Review --> For SMA Manager user Approval button is enabled and user can perform approve action.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    And I click Counter & Fixture location
    And I search for "<MIN>"
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<MIN>" in list
    Then I click and enter "<Quantity>" for other location
    And I click Exit Other
    And I click on Back Button
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<MIN>" in list
    And I click and enter "<Quantity>" for backup location
    And I confirm count area
    And I click on Back Button
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I click on Back Button
    And I click Approval Tab
    And I see Approve label
    Then I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton>"
    And I click on Approve button
    Then I verify Confirm alert is displayed
    And I click on "Yes" button

    Examples: 
      | storeID | MIN       | Department | Location | ApproveButton | Quantity | Type       |
      |      78 | 104695783 | Fresh Prep | Other    | Enabledd      |      800 | Fresh Prep |

  @sma
  Scenario Outline: SMA_33289_MSGLH - Review --> For SMA Twilight Manager user Approval button is enabled and user can perform approve action.
    When I enter Username and Password for Twilight Manager user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    And I click Counter & Fixture location
    And I search for "<MIN>"
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<MIN>" in list
    Then I click and enter "<Quantity>" for other location
    And I click Exit Other
    And I click on Back Button
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<MIN>" in list
    And I click and enter "<Quantity>" for backup location
    And I confirm count area
    And I click on Back Button
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I click on Back Button
    And I click Approval Tab
    And I see Approve label
    Then I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton>"
    And I click on Approve button
    Then I verify Confirm alert is displayed
    And I click on "Yes" button

    Examples: 
      | storeID | MIN       | Department | Location | ApproveButton | Quantity | Type       |
      |      78 | 104695783 | Fresh Prep | Other    | Enabled       |      800 | Fresh Prep |

  @sma
  Scenario Outline: SMA_33289_GLH -Verify Review --> Approval button is Disabled for Collegue user.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<StoreID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I search for "<Barcode>"
    And I verify the "<Barcode>" in Scan Item
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And Select plan from alert
    And I click on "Yes" button
    And I will capture the product name from view list
    Then I verify the if it is LOW
    And I click on Back Button
    Given a Store ID "<StoreID>" and type "<Type1>" is included in GLH  request
    Then I click on OffShelf
    And I completed section for all the department
    And I click on Back Button
    Then I click on Petrol
    And I completed section for all the department
    And I click on Back Button
    Given a Store ID "<StoreID>" and type "<Type2>" is included in GLH  request
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
    Then I verify the if Low is displayed in warehouse
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I verify Approval required alert is displayed with message as "<Message>"
    And I click on "Ok" button
    And I click on Back Button
    Then I click on Review
    Then I verify my min is present in the "<Type>"
    Then I select the "<Type>" and verify the status as ReviewReady
    And I click Approval Tab
    And I see Approve label
    Then I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton>"

    Examples: 
      | Barcode   | Type1                | Type2                | Type              | Type3                     | Quantity | location  | StoreID | Typee         | gaps | captureType | ApproveButton | Message                                                            |
      | 104897086 | Kiosk Counter Sweets | Petrol Chilled Fresh | Grocery (Impulse) | Chocolate & Confectionery |      600 | Warehouse |      78 | GapsHighsLows |    1 | Low         | Disabled      | There are products that require approval, please inform a Manager. |

  @sma
  Scenario Outline: SMA_33289_GLH - Verify Review --> Approval button is Enabled for SMA Manager user.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<StoreID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I search for "<Barcode>"
    And I verify the "<Barcode>" in Scan Item
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And Select plan from alert
    And I click on "Yes" button
    And I will capture the product name from view list
    Then I verify the if it is LOW
    And I click on Back Button
    Given a Store ID "<StoreID>" and type "<Type1>" is included in GLH  request
    Then I click on OffShelf
    And I completed section for all the department
    And I click on Back Button
    Then I click on Petrol
    And I completed section for all the department
    And I click on Back Button
    Given a Store ID "<StoreID>" and type "<Type2>" is included in GLH  request
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
    Then I verify the if Low is displayed in warehouse
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I verify Approval required alert is displayed with message as "<Message>"
    And I click on "Ok" button
    And I click on Back Button
    Then I click on Review
    Then I verify my min is present in the "<Type>"
    Then I select the "<Type>" and verify the status as ReviewReady
    And I click Approval Tab
    And I see Approve label
    Then I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton>"
    And I click on Approve button
    Then I verify Confirm alert is displayed
    And I click on "Yes" button

    Examples: 
      | Barcode   | Type1                | Type2                | Type              | Type3                     | Quantity | location  | StoreID | Typee         | gaps | captureType | ApproveButton | Message                                                            |
      | 104897086 | Kiosk Counter Sweets | Petrol Chilled Fresh | Grocery (Impulse) | Chocolate & Confectionery |      600 | Warehouse |      78 | GapsHighsLows |    1 | Low         | Enabled       | There are products that require approval, please inform a Manager. |

  @sma
  Scenario Outline: SMA_33289_GLH - Verify Review --> Approval button is Enabled for Twilight Manager.
    When I enter Username and Password for Twilight Manager user
    And I click on login button for SMA
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<StoreID>"
    Then I click on Gaps,Low,High
    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I search for "<Barcode>"
    And I verify the "<Barcode>" in Scan Item
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And Select plan from alert
    And I click on "Yes" button
    And I will capture the product name from view list
    Then I verify the if it is LOW
    And I click on Back Button
    Given a Store ID "<StoreID>" and type "<Type1>" is included in GLH  request
    Then I click on OffShelf
    And I completed section for all the department
    And I click on Back Button
    Then I click on Petrol
    And I completed section for all the department
    And I click on Back Button
    Given a Store ID "<StoreID>" and type "<Type2>" is included in GLH  request
    Then I click on WareHouse
    Then I verify my min is present in the "<Type>" or not
    Then I verify the if Low is displayed in warehouse
    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I verify Approval required alert is displayed with message as "<Message>"
    And I click on "Ok" button
    And I click on Back Button
    Then I click on Review
    Then I verify my min is present in the "<Type>"
    Then I select the "<Type>" and verify the status as ReviewReady
    And I click Approval Tab
    And I see Approve label
    Then I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton>"
    And I click on Approve button
    Then I verify Confirm alert is displayed
    And I click on "Yes" button

    Examples: 
      | Barcode   | Type1                | Type2                | Type              | Type3                     | Quantity | location  | StoreID | Typee         | gaps | captureType | ApproveButton | Message                                                            |
      | 104897086 | Kiosk Counter Sweets | Petrol Chilled Fresh | Grocery (Impulse) | Chocolate & Confectionery |      600 | Warehouse |      78 | GapsHighsLows |    1 | Low         | Enabled       | There are products that require approval, please inform a Manager. |

  @sma
  Scenario Outline: SMA_33289_Clean and Rotate --> Verify for Collegue user, Sign off Code Rotate button is Disabled.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on clean and rotate from menu
    Then I click on Weekly Schedules
    Then I scroll down to get the latest schdule
    Given Request is made to cleanandrotate Collegue Login services
    Then service should return details for Login Service clean and rotate
    And Get the generated accessTocken for CR
    Then getSchedule service is called for location id "<storeID>" and week "<selectWeek>"
    And user performs operation
    Then Service should return response of getSchedule service
    And I Select the schedule in a list "<week>"
    And I Complete code rotate for all the departments
    Then I Verify Sign off Code Rotate button is displayed
    And I verify Sign off code rotate button is Disabled

    Examples: 
      | storeID | week | departmentNumber | status1 | status2           | selectWeek |
      |      78 |    3 | First            | ToStart | Awaiting Sign-Off | NextWeek   |

  @sma
  Scenario Outline: SMA_33289_Clean and Rotate --> Verify for Manager user, Sign off Code Rotate button is Enabled.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on clean and rotate from menu
    Then I click on Weekly Schedules
    Then I scroll down to get the latest schdule
    Given Request is made to cleanandrotate Collegue Login services
    Then service should return details for Login Service clean and rotate
    And Get the generated accessTocken for CR
    Then getSchedule service is called for location id "<storeID>" and week "<selectWeek>"
    And user performs operation
    Then Service should return response of getSchedule service
    And I Select the schedule in a list "<week>"
    And I Complete code rotate for all the departments
    Then I Verify Sign off Code Rotate button is displayed
    And I verify Sign off code rotate button is Enabled

    Examples: 
      | storeID | week | departmentNumber | status1 | status2           | selectWeek |
      |      78 |    3 | First            | ToStart | Awaiting Sign-Off | NextWeek   |

  @sma
  Scenario Outline: SMA_33289_Clean and Rotate --> Verify for Twilight Manager user, Sign off Code Rotate button is Enabled.
    When I enter Username and Password for Twilight Manager user
    And I click on login button for SMA
    Then I click on clean and rotate from menu
    Then I click on Weekly Schedules
    Then I scroll down to get the latest schdule
    Given Request is made to cleanandrotate Collegue Login services
    Then service should return details for Login Service clean and rotate
    And Get the generated accessTocken for CR
    Then getSchedule service is called for location id "<storeID>" and week "<selectWeek>"
    And user performs operation
    Then Service should return response of getSchedule service
    And I Select the schedule in a list "<week>"
    And I Complete code rotate for all the departments
    Then I Verify Sign off Code Rotate button is displayed
    And I verify Sign off code rotate button is Enabled

    Examples: 
      | storeID | week | departmentNumber | status1 | status2           | selectWeek |
      |      78 |    3 | First            | ToStart | Awaiting Sign-Off | NextWeek   |

  @sma
  Scenario Outline: SMA_33289_Fresh code check -->Manager Summary & sign off--> Verify 'Access Restricted' alert is displayed for Collegue user. Twilight manager and Store Manager able to see Summary screen.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Summary & sign off screen is displayed
    Then I verify Sign off button is displayed and enabled
    And I logout of the system
    When I enter Username and Password for Twilight Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Summary & sign off screen is displayed
    Then I verify Sign off button is displayed and enabled
    And I logout of the system
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I verify Access Restricted alert is displayed with message as "<Message>"

    Examples: 
      | Menu             | Department_Menu            | Message                                                                           |
      | Fresh Code Check | Manager Summary & Sign Off | Access to this check is restricted. Please ask an appropriate manager to complete |

  @sma
  Scenario Outline: SMA_33289_Fresh code check -->Daily Schedule -Fresh Food manager check - Summary & sign off --> Verify 'Access Restricted' alert is displayed for Collegue user. Twilight manager and Store Manager able to see Summary screen.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    And I verify Summary & sign off screen is displayed
    And I logout of the system
    When I enter Username and Password for Twilight Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    Then I click on "<Location>"
    And I verify Summary & sign off screen is displayed
    And I logout of the system
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department_Menu>"
    And I click on Overdue date Schedule
    Then I click on "<SubMenu>"
    And I verify Access Restricted alert is displayed with message as "<Message>"

    Examples: 
      | Menu             | Department_Menu | SubMenu                  | Location           | Message                                                                           |
      | Fresh Code Check | Daily Schedule  | Fresh Food Manager Check | Summary & Sign Off | Access to this check is restricted. Please ask an appropriate manager to complete |

  ############################## Prompted count ############################################
  ########## Firstly Upload file in S3 Bucket
  #### nonprod-m-ordering S3 bucket path --> https://s3.console.aws.amazon.com/s3/buckets/msit.xxwmm.supplychain.freshcounts.eeeeeeeeee > promptedcountsexceptions > pending
  
  #####In Storewalk DB Update below query for getting current Stock record and large adjustment value
  #####Replace walk_id of your store below('')
  ######select * from walkitem where walk_id in('20220112830051592')
  ####update walkitem set qty_on_hand='100' where walk_id in('20220112830051592')
  #####update walkitem set stock_state='fresh' where walk_id in('20220112830051592')
  #####update walkitem set soh_value='100' where walk_id in('20220112830051592')
  @sma
  Scenario Outline: SMA_33289_Prompted count --> Summary - For Collegue user Approve button is disabled and For SMA Manager & Twilight manager user Approve button is enabled and able to perform Approval action.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location1>"
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I click on Back Button
    Then I click on "<Location2>"
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I click on Back Button
    And I click on Back Button
    And I verify "<Location3>" is displayed
    Then I click on "<Location3>"
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed
    Then I click on "<Department>"
    And I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton>"
    And I click on Back Button
    And I logout of the system
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Location3>"
    And I view and click on Button "<Button>"
    Then I click on "<Department>"
    And I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton1>"
    And I click on Approve button
    Then I verify Approve item alert is displayed
    And I click on "Continue" button
    And I click on Back Button
    And I logout of the system
    When I enter Username and Password for Twilight Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Location3>"
    And I view and click on Button "<Button>"
    Then I click on "<Department>"
    And I click on Product in Approval tab
    And I verify Approve button is "<ApproveButton1>"
    And I click on Approve button
    Then I verify Approve item alert is displayed
    And I click on "Continue" button

    Examples: 
      | Menu            | Department | Location1 | Location2 | Location3 | Button          | ApproveButton | ApproveButton1 | Quantity |
      | Prompted Counts | Fresh      | Fixture   | Warehouse | Summary   | Total Approvals | Disabled      | Enabled        |      900 |
