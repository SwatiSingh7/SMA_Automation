@test_count
Feature: Verify Counts functionality for 'AM' window.

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples: 
      | Hours | Mins | Meridiem |
      |    06 |   48 | am       |

  @sma
  Scenario Outline: Verify Delete Count Storewalk service - Delete existing Counts.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete Count storewalk for store id "<StoreID>"

    Examples: 
      | StoreID | capturetype |
      |      78 | Counts      |



  @sma
  Scenario Outline: Create Count storewalk by making call with Post storewalk service for "<Window>" window ,"<Mode>" mode, "<CountedType>" counted type and Product SOH is "<SOH>", UOM is "<UOM>", Pack is "<Pack>" and department name is "<DepartmentName>"
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given The Post request is made to create Count storewalk for window "<Window>"
    Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Departments>"
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>", type "<Type>" and count type "<CountedType>"
    When The Post request is made to create Count storewalk api for Store id "<StoreID>"
    Then Post operation performed on post strorewalk api to create Count storewalk
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk
    ### Get storewalk service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Get count storewalk service response is same as post count storewalk body
    And Verify Storewalk status as "<Status>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
    ## Get walkitem service
    Given Get request is made to Get walkItem service for count name "<Name>", store id "<StoreID>" and product id "<Item>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    ## Product service
    Given Request is made to verify Product Id "<Item>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    Given Verify ProductId "<Item>" is included in the service
    ######### Stock info service
    Given ProductId "<Item>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
        #### Space service
    Given Request is made to Get Space service for Store id "<StoreID>" and Product "<Item>"
    When User performs Get operation for Space service
    Then Get Space service response
      #### Stock order service
     Given ProductId "<Item>" and StoreID "<StoreID>" is included in the servce
  When Request is made into Delivery service
  Then Service should return the details of the Delivery service
    

   Examples: 
   | StoreID | Name            | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName   | Item                | Departments | ActionType | Status    | RangeStatus | WalkType |Type|
   |      78 | AM_SCAN_INGREDIENT_N_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           100376785 |          111,216,1  | Include    | Available | active      | Counts   |ScanWithoutIngredient|
      |      78 | AM_SCAN_INGREDIENT_Y_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           105445532,105361451,105361187,105361419,105361507 |          286,81,6  | Include    | Available | active      | Counts   |ScanWithIngredient|
     |      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS  | AM     | list | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           104284271,104284280,104305765,104571588,104284132 |         null | Include    | Available | active      | Counts   |ListAllCheckboxes|
     |      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS  | AM     | list | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |            103295542,103845284,103864274,109315022 |      null | Include    | Available | active      | Counts   |ListIgnoreRange|
   ####|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS  | AM     | list | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |            102369685,102370011,102370053,102370168,102370256 |        null | Include    | Available | active      | Counts   |ListIgnoreRange|
#
  #
   #@sma
  #Scenario Outline: Verify UI of Counts displayed as expected or not
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #And I click on Back Button
    #Then I click on Fixtures Sections
    #And I click on Back Button
    #Then I click on Uncounted Sections
    #And I click on Back Button
    #Then I click on OffShelf Sections
    #And I click on Back Button
    #Then I click on Petrol Sections
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on ReviewCount
    #And I click on Back Button
    #Then I click on Counts Summary
    #Then I verify the fields in Counts Summary
    #And I click on Back Button
    #And I logout of the system
#
    #Examples: 
      #| StoreID |
      #|      78 |
#
   #@sma
  #Scenario Outline: Navigate to Warehouse location and Verify count data is getting generated.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Storewalk status as "<Status>" is present in Get storewalk service response
    #Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response
#
   #Examples: 
   #| StoreID | Name            | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName   | Item                | Departments | ActionType | Status    | RangeStatus | WalkType |Type|
   #|      78 | AM_SCAN_INGREDIENT_N_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           100376785 |          111,216,1  | Include    | Available | active      | Counts   |ScanWithoutIngredient|
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           105361187,105361419,105361451,105361507,105445532 |          286,81,6  | Include    | Available | active      | Counts   |ScanWithIngredient|
     #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           104284132,104284271,104284280,104305765,104571588 |         null | Include    | Available | active      | Counts   |ListAllCheckboxes|
     #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |            103295542,103845284,103864274,109315022 |      null | Include    | Available | active      | Counts   |ListIgnoreRange|
   #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |            102369685,102370011,102370053,102370168,102370256 |        null | Include    | Available | active      | Counts   |ListIgnoreRange|
   #
     #
  #@sma
  #Scenario Outline: Verify COMPLETE status for WAREHOUSE Location
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #Then verify Min details
    #Then I will enter qty "<quantity>"
    #Then verify that qty has been updated
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #Then Verify status for "<Name>" has changed to Complete
    #And I logout of the system
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    #Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response
    #And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    #And Verify store id "<StoreID>" is not Curfew store
#
    #Examples: 
   #| StoreID | Name            | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName   | Item                | Departments | ActionType | Status    | RangeStatus | WalkType |Type|
   #|      78 | AM_SCAN_INGREDIENT_N_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           100376785 |          111,216,1  | Include    | Available | active      | Counts   |ScanWithoutIngredient|
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           105361187,105361419,105361451,105361507,105445532 |          286,81,6  | Include    | Available | active      | Counts   |ScanWithIngredient|
     #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |           104284132,104284271,104284280,104305765,104571588 |         null | Include    | Available | active      | Counts   |ListAllCheckboxes|
     #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |            103295542,103845284,103864274,109315022 |      null | Include    | Available | active      | Counts   |ListIgnoreRange|
   #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS  | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |            102369685,102370011,102370053,102370168,102370256 |        null | Include    | Available | active      | Counts   |ListIgnoreRange|
#
 #
  #@sma
  #Scenario Outline: WAREHOUSE Location - Click on Completed count and verify REOPEN Counts alert.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I verify "<AlertName>" alert is displayed
    #And I verify Reopen counts alert message "<AlertMessage>" is displayed
    #And I verify Reopen counts alert with Yes and No options are displayed
    #Then I Click on No option on Reopen counts alert
    #And I logout of the system
#
    #Examples: 
      #| StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
       #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
        #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
         #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
          #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
   #
  #@sma
  #Scenario Outline: WAREHOUSE Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I verify ADD to Count and EDIT Count buttons are displayed
    #And I click on Back Button
    #Then I will confirm Counts
    #And I logout of the system
#
    #Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 | scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  | scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 | scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 | scan | singles      | Fresh          |
  #
  #@sma
  #Scenario Outline: WAREHOUSE Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I will Add the quantity "<quantity1>"
    #And I select the product "<Item>"
    #Then I will Edit the quantity "<quantity1>"
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #And I logout of the system
#
#
    #Examples: 
     #| StoreID | Name           | Item      | Mode | quantity | quantity1 | DepartmentName |CountedType |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | 8 |         8 | Fresh          |singles|
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS |  105361187,105361419,105361451,105361507,105445532 | scan | 8 |         8 | Fresh          |singles|
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588 | scan | 8 |         8 | Fresh          |singles|
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 | scan | 8 |         8 | Fresh          |singles|
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS | 102369685,102370011,102370053,102370168,102370256 | scan | 8 |         8 | Fresh          |singles|
   #
  #@sma
  #Scenario Outline: Navigate to Fixture location and Verify count data getting generated.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Fixtures Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Storewalk status as "<Status>" is present in Get storewalk service response
    #Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response
#
#
    #Examples: 
    #
      #| StoreID | Name            | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName   | Item | WalkType | location | Status    |
       #|78 | AM_SCAN_INGREDIENT_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 100376785 |Counts   | On_Shelf | Available |
     #|78 | AM_SCAN_INGREDIENT_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 105361187,105361419,105361451,105361507,105445532  |Counts   | On_Shelf | Available |
     #|78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  104284132,104284271,104284280,104305765,104571588 |Counts   | On_Shelf | Available |
     #|78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  103295542,103845284,103864274,109315022  |Counts   | On_Shelf | Available |
     #|78 | AM_LIST_IGNORE_SOH_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  102369685,102370011,102370053,102370168,102370256 |Counts   | On_Shelf | Available |
    #
    #
  #@sma
  #Scenario Outline: Verify COMPLETE status for FIXTURE Location
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Fixtures Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #Then verify Min details
    #Then I will enter qty "<quantity>"
    #Then I will choose the plan from popup and enter qty
    #Then verify that qty has been updated
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #And I logout of the system
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    #Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response
    #And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    #And Verify store id "<StoreID>" is not Curfew store
#
  #Examples: 
  #
   #| StoreID | Name            | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName   | Item | WalkType | location | Status    |quantity|StorewalkStatus | Status        | ActionType | RangeStatus |
       #|78 | AM_SCAN_INGREDIENT_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 100376785 |Counts   | On_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_SCAN_INGREDIENT_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 105361187,105361419,105361451,105361507,105445532  |Counts   | On_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  104284132,104284271,104284280,104305765,104571588 |Counts   | On_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  103295542,103845284,103864274,109315022  |Counts   | On_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_IGNORE_SOH_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  102369685,102370011,102370053,102370168,102370256 |Counts   | On_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
    #
  #
  #@sma
  #Scenario Outline: FIXTURE Location - Click on Completed count and verify REOPEN Counts alert.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Fixtures Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I verify "<AlertName>" alert is displayed
    #And I verify Reopen counts alert message "<AlertMessage>" is displayed
    #And I verify Reopen counts alert with Yes and No options are displayed
    #Then I Click on No option on Reopen counts alert
    #And I logout of the system
#
      #Examples: 
      #| StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
       #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
        #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
         #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
          #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
   #
  #@sma
  #Scenario Outline: FIXTURE Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Fixtures Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I verify ADD to Count and EDIT Count buttons are displayed
    #And I click on Back Button
    #Then I will confirm Counts
    #And I logout of the system
#
  #Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | singles |      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 | scan | singles |      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  | scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 | scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 | scan | singles      | Fresh          |
#
  #@sma
  #Scenario Outline: FIXTURE Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Fixtures Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I will Add the quantity "<quantity1>"
    #And I select the product "<Item>"
    #Then I will Edit the quantity "<quantity1>"
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #And I logout of the system
#
  #Examples: 
      #| StoreID | Name           | Item      | Mode | quantity | quantity1 |  CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan |     7 |         8 |  singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |   scan |     7 |         8 |singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan |     7 |         8 | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |scan |      7 |         8 |  singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 | scan |      7 |         8 | singles      | Fresh          |
  #
#
  #@sma
  #Scenario Outline: Verify COMPLETE status for OFFSHELF Location
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on OffShelf Sections
    #Then I select the required record
    #Then I select the Product
    #Then I will enter qty "<quantity>"
    #Then I complete OffShelf
    #And I click on Back Button
    #And I logout of the system
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    #Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response
    #And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    #And Verify store id "<StoreID>" is not Curfew store
#
#Examples: 
  #
   #| StoreID | Name            | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName   | Item | WalkType | location | Status    |quantity|StorewalkStatus | Status        | ActionType | RangeStatus |
       #|78 | AM_SCAN_INGREDIENT_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 100376785 |Counts   | Off_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_SCAN_INGREDIENT_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 105361187,105361419,105361451,105361507,105445532  |Counts   | Off_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  104284132,104284271,104284280,104305765,104571588 |Counts   | Off_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  103295542,103845284,103864274,109315022  |Counts   | Off_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_IGNORE_SOH_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  102369685,102370011,102370053,102370168,102370256 |Counts   | Off_Shelf | Available |6|Available       | CountComplete | Complete   | active      |
    #
  #@sma
  #Scenario Outline: OFFSHELF Location - Click on Completed count and verify REOPEN Counts alert.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on OffShelf Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I verify "<AlertName>" alert is displayed
    #And I verify Reopen counts alert message "<AlertMessage>" is displayed
    #And I verify Reopen counts alert with Yes and No options are displayed
    #Then I Click on No option on Reopen counts alert
    #And I logout of the system
#
     #Examples: 
      #| StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
       #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
        #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
         #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
          #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
   #
  #@sma
  #Scenario Outline: OFFSHELF Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on OffShelf Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I verify ADD to Count and EDIT Count buttons are displayed
    #And I click on Back Button
    #Then I will confirm Counts
    #And I logout of the system
#
#
    #Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |   scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |   scan | singles      | Fresh          |
  #
#
  #@sma
  #Scenario Outline: OFFSHELF Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on OffShelf Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I will Add the quantity "<quantity1>"
    #And I select the product "<Item>"
    #Then I will Edit the quantity "<quantity1>"
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #And I logout of the system
#
   #Examples: 
      #| StoreID | Name           | Item      |quantity | quantity1 | Mode |   CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 |      7 |         8 |scan |  singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |     7 |         8 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |     7 |         8 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |     7 |         8 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |     7 |         8 |  scan | singles      | Fresh          |
  #
#
  #@sma
  #Scenario Outline: Verify COMPLETE status for PETROL Location
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Petrol Sections
    #Then I select the required record
    #Then I select the Product
    #Then I will enter qty "<quantity>"
    #Then I complete OffShelf
    #And I click on Back Button
    #And I logout of the system
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response
    #And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    #And Verify store id "<StoreID>" is not Curfew store
#
    #Examples: 
  #
   #| StoreID | Name            | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName   | Item | WalkType | location | Status    |quantity|StorewalkStatus | Status        | ActionType | RangeStatus |
       #|78 | AM_SCAN_INGREDIENT_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 100376785 |Counts   | Petrol | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_SCAN_INGREDIENT_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            | 105361187,105361419,105361451,105361507,105445532  |Counts   | Petrol | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  104284132,104284271,104284280,104305765,104571588 |Counts   | Petrol | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  103295542,103845284,103864274,109315022  |Counts   | Petrol | Available |6|Available       | CountComplete | Complete   | active      |
     #|78 | AM_LIST_IGNORE_SOH_Y_COUNTS | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh            |  102369685,102370011,102370053,102370168,102370256 |Counts   | Petrol | Available |6|Available       | CountComplete | Complete   | active      |
   #
    #
  #@sma
  #Scenario Outline: PETROL Location - Click on Completed count and verify REOPEN Counts alert.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Petrol Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I verify "<AlertName>" alert is displayed
    #And I verify Reopen counts alert message "<AlertMessage>" is displayed
    #And I verify Reopen counts alert with Yes and No options are displayed
    #Then I Click on No option on Reopen counts alert
    #And I logout of the system
#
     #Examples: 
      #| StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
       #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
        #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
         #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
          #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
   #
  #@sma
  #Scenario Outline: PETROL Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Petrol Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I verify ADD to Count and EDIT Count buttons are displayed
    #And I click on Back Button
    #Then I will confirm Counts
    #And I logout of the system
#
      #
    #Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan |  singles |       | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |   scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |   scan | singles      | Fresh          |
  #
#
  #@sma
  #Scenario Outline: PETROL Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Petrol Sections
    #And I Select the completed Count
    #Then I Click on Yes button on Reopen alert
    #And I select the product "<Item>"
    #Then I will Add the quantity "<quantity1>"
    #And I select the product "<Item>"
    #Then I will Edit the quantity "<quantity1>"
    #Then I will confirm Counts
    #Then Verify status for "<Name>" has changed to Complete
    #And I click on Back Button
    #And I logout of the system
#
    #Examples: 
      #| StoreID | Name           | Item      | Mode | quantity | quantity1 |  CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan |     7 |         8 |  singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan |     7 |         8 | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan |     7 |         8 |singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |  scan |     7 |         8 |singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |  scan |     7 |         8 |  singles      | Fresh          |
  #
  #@sma
  #Scenario Outline: After completing all the count sections, Verify storewalk status as 'CountComplete' in Storewalk service.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on ReviewCount
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I click on Back Button
    #And I logout of the system
    #Given Request is made to SMA app login service for collegue user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
#
#Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |   scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |   scan | singles      | Fresh          |
  #
  #@sma
  #Scenario Outline: Verify Count is edited in Review section
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on ReviewCount
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #Then I select the product from Count
    #And I select the Capture count location
    #Then I will enter qty "<quantity>"
    #And I verify count quantity "<quantity>" is updated in Review section
    #And I Confirm the Review
    #And I click on Back Button
    #And I logout of the system
#
   #Examples: 
      #| StoreID | Name           | Mode      | Item | quantity | quantity1 |  CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS |  scan |  103087399 |   7 |         8 |  singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS |  scan |  105361187,105361419,105361451,105361507,105445532 |     7 |         8 |  singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS | scan |    104284132,104284271,104284280,104305765,104571588  |     7 |         8 | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS | scan |    103295542,103845284,103864274,109315022 |     7 |         8 | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS | scan |    102369685,102370011,102370053,102370168,102370256 |     7 |         8 | singles      | Fresh          |
  #
#
  #@sma
  #Scenario Outline: Confirm the capture count in Review section. Then, verify Review section status on UI as 'Completed' and Storewalk status as 'ReviewComplete' in the Storewalk service.
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on ReviewCount
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #Then I select the product and click on confirm button
    #And I click on Back Button
    #And I logout of the system
    #Given Request is made to SMA app login service for collegue user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
#
    #Examples: 
      #| StoreID | Name           | Item      | Mode | quantity | quantity1 |  CountedType | DepartmentName |WalkType | StorewalkStatus |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan |     7 |         8 |  singles      | Fresh          |Counts   | ReviewComplete  |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan |     7 |         8 | singles      | Fresh          |Counts   | ReviewComplete  |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan |     7 |         8| singles      | Fresh          |Counts   | ReviewComplete  |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |  scan |     7 |         8  | singles      | Fresh          |Counts   | ReviewComplete  |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 | scan |      7 |         8 | singles      | Fresh          |Counts   | ReviewComplete  |
    #|
#
  #@sma
  #Scenario Outline: Verify that After REVIEW we cannot select the review completed product from - WAREHOUSE
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #Then I verify that the posted counts are displayed
    #Then The field should be disabled
    #And I logout of the system
#
    #Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |   scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |   scan | singles      | Fresh          |
  #
#
  #@sma
  #Scenario Outline: Verify that After REVIEW we cannot select the review completed product from - FIXTURE
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Sections
    #Then I click on Fixtures Sections
    #Then I verify that the posted counts are displayed
    #Then The field should be disabled
    #And I logout of the system
#
   #Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |   scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |   scan | singles      | Fresh          |
  #
#
  #@sma
  #Scenario Outline: Verify Counts SUMMARY after completing all the sections on UI
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    #Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Counts
    #Then I click on Counts Summary
    #Then I verify the fields in Counts Summary
    #Then I verify if checkbox are checked
    #And I logout of the system
#
    #Examples: 
      #| StoreID | Name           | Item      | Mode | CountedType | DepartmentName |
      #|      78 | AM_SCAN_INGREDIENT_N_COUNTS | 103087399 | scan | singles      | Fresh          |
      #|      78 | AM_SCAN_INGREDIENT_Y_COUNTS | 105361187,105361419,105361451,105361507,105445532 |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_ALL_CHECKBOX_N_COUNTS |  104284132,104284271,104284280,104305765,104571588  |  scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_RANGE_Y_COUNTS |  103295542,103845284,103864274,109315022 |   scan | singles      | Fresh          |
      #|      78 | AM_LIST_IGNORE_SOH_Y_COUNTS |  102369685,102370011,102370053,102370168,102370256 |   scan | singles      | Fresh          |
  

  
   ##################### COUNT - end to end flow ###########################################################################
 
  @sma
  Scenario Outline: Verify end to end functionality for COUNT - Create Count, Complete all the locations, Review capture of Counts and verify Summary.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given The Post request is made to create Count storewalk for window "<Window>"
    Given Post count storewalk for department "<DepartmentName>" with Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Departments>"
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>", mode "<Mode>" and count type "<CountedType>"
    When The Post request is made to create Count storewalk api for Store id "<StoreID>"
    Then Post operation performed on post strorewalk api to create Count storewalk
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk
    ### Get storewalk service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Get count storewalk service response is same as post count storewalk body
    And Verify Storewalk status as "<Status>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
    ## Get walkitem service
    Given Get request is made to Get walkItem service for count name "<Name>", store id "<StoreID>" and product id "<Item>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    ## Product service
    Given Request is made to verify Product Id "<Item>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    Given Verify ProductId "<Item>" is included in the service
    ##### Stock info service
    Given ProductId "<Item>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service

     Examples: 
      | StoreID | Name                | Window | Mode | CountedType | UOM | SOH      | OrderReceipt | Price | Range | Pack          | DepartmentName     | Item                 | Departments | ActionType | Status    | RangeStatus | WalkType |location  | StorewalkStatus | quantity|
      #### EA
      |      78 | AM_SCAN_EA_Item_1   | AM     | scan | singles     | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh              |            103087399 |         359 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_2   | AM     | scan | cases       | EA  | Positive | Yes          | Yes   | Yes   | No pack       | Bakery             |            108441561 |         275 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_EA_Item_1   | AM     | list | singles     | EA  | Positive | Yes          | Yes   | Yes   | Single pack   | Health & Beauty    |  100001592 | null    | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     #not working### |      78 | AM_LIST_EA_Item_2   | AM     | list | cases       | EA  | Positive | Yes          | Yes   | Yes   | Multiple pack | Deli               |            111113500 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_3   | AM     | scan | singles     | EA  | Positive | No           | No    | No    | Multiple pack | Alcohol            |            101545309 |         223 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_4   | AM     | scan | cases       | EA  | Positive | No           | No    | No    | No pack       | Fresh Prep         |            104950043 |         292 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #not working|      78 | AM_LIST_EA_Item_3   | AM     | list | singles     | EA  | Positive | No           | No    | No    | Single pack   | Oven Fresh / Baked |  104317387,104183542 | null   | Include    | Available | active      | Counts   |WareHouse | Available       |4|
       #not working|      78 | AM_LIST_EA_Item_4   | AM     | list | cases       | EA  | Positive | No           | No    | No    | Multiple pack | Fresh Prep         |            107945127 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_5   | AM     | scan | singles     | EA  | Negative | Yes          | Yes   | Yes   | Multiple pack | Fish Bar           |            105140288 |         261 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_6   | AM     | scan | cases       | EA  | Negative | Yes          | Yes   | Yes   | No pack       | Bakery             |            110010154 |         275 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
     #not working |      78 | AM_LIST_EA_Item_5   | AM     | list | singles     | EA  | Negative | Yes          | Yes   | Yes   | Single pack   | Grocery            |  100407861,109771933 |     null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
       #not working dept|      78 | AM_LIST_EA_Item_6   | AM     | list | cases       | EA  | Negative | Yes          | Yes   | Yes   | Multiple pack | Oven Fresh / Baked |  104307023,109933120 |     null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_7   | AM     | scan | singles     | EA  | Negative | No           | No    | No    | Multiple pack | Grocery            |            107537844 |         126 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_8   | AM     | scan | cases       | EA  | Negative | No           | No    | No    | No pack       | Bakery             |            110114957 |         273 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_EA_Item_7   | AM     | list | singles     | EA  | Negative | No           | No    | No    | Single pack   | Fresh              |  109670788,109671123 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
       #not working|      78 | AM_LIST_EA_Item_8   | AM     | list | cases       | EA  | Negative | No           | No    | No    | Single pack   | Cafe               |  107020749,102767894 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_9   | AM     | scan | singles     | EA  | Zero     | Yes          | Yes   | Yes   | Multiple pack | Fresh Prep         |            103273538 |         290 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
     |      78 | AM_SCAN_EA_Item_10  | AM     | scan | cases       | EA  | Zero     | Yes          | Yes   | Yes   | Single pack   | Fresh Prep         |            102786340 |         287 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_EA_Item_9   | AM     | list | singles     | EA  | Zero     | Yes          | Yes   | Yes   | Single pack   | Home & Leisure     |  109060082,109166872 |     null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     #not working |      78 | AM_LIST_EA_Item_10  | AM     | list | cases       | EA  | Zero     | Yes          | Yes   | Yes   | Multiple pack | Fish Bar           |            104907467 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_EA_Item_11  | AM     | scan | singles     | EA  | Zero     | No           | No    | No    | Multiple pack | Alochol            |            101531257 |         217 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     |      78 | AM_SCAN_EA_Item_12  | AM     | scan | cases       | EA  | Zero     | No           | No    | No    | No pack       | Deli               |            106048521 |         405 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #not working |      78 | AM_LIST_EA_Item_11  | AM     | list | singles     | EA  | Zero     | No           | No    | No    | Single pack   | Fruit & Veg        |  109702399,109701716 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #not working|      78 | AM_LIST_EA_Item_12  | AM     | list | cases       | EA  | Zero     | No           | No    | No    | Multiple pack | Bakery             |  108147371,108946703 |     null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #### KG
      |      78 | AM_SCAN_KG_Item_1   | AM     | scan | singles     | KG  | Positive | Yes          | Yes   | Yes   | Multiple pack | Butchery           |            102761290 |         297 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
       #not working|      78 | AM_SCAN_KG_Item_2   | AM     | scan | cases       | KG  | Positive | Yes          | Yes   | Yes   | No pack       | Fish Bar           |            102391031 |         261 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #not working dept |      78 | AM_LIST_KG_Item_1   | AM     | list | singles     | KG  | Positive | Yes          | Yes   | Yes   | Single pack   | Deli               | 104665171,103126642 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
     #not working dept |      78 | AM_LIST_KG_Item_2   | AM     | list | cases       | KG  | Positive | Yes          | Yes   | Yes   | Multiple pack | Fruit & Veg        |  109035979,109035864 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_KG_Item_3   | AM     | scan | cases     | KG  | Positive | No           | No    | No    | Multiple pack | Fruit & Veg        |            108534792 |         542 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
       # not working|      78 | AM_SCAN_KG_Item_4   | AM     | scan | cases       | KG  | Positive | No           | No    | No    | Single pack   | Fish Bar           |            107734469 |         261 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
       # not working dept|      78 | AM_LIST_KG_Item_3   | AM     | list | singles     | KG  | Positive | No           | No    | No    | Single pack   | Fruit & Veg        |  108540543,108337158 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_KG_Item_4   | AM     | list | cases       | KG  | Positive | No           | No    | No    | Multiple pack | Fruit & Veg        |  108335777,108335531 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
       #not working|      78 | AM_SCAN_KG_Item_5   | AM     | scan | singles     | KG  | Negative | Yes          | Yes   | Yes   | Multiple pack | Fish Bar           |            102390679 |         261 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
     # not working |      78 | AM_SCAN_KG_Item_6   | AM     | scan | cases       | KG  | Negative | Yes          | Yes   | Yes   | Single pack   | Fish Bar           |            102391081 |         261 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
        #not working dept|      78 | AM_LIST_KG_Item_5   | AM     | list | singles     | KG  | Negative | Yes          | Yes   | Yes   | Single pack   | Grocery            |  110278927,110276411 |          null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #|      78 | AM_LIST_KG_Item_6   | AM     | list | cases       | KG  | Negative | Yes          | Yes   | Yes   | Multiple pack | pending            | pending              | null     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_KG_Item_7   | AM     | scan | singles     | KG  | Negative | No           | No    | No    | Multiple pack | Deli               |            105591345 |         406 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
    #  |      78 | AM_SCAN_KG_Item_8   | AM     | scan | cases       | KG  | Negative | No           | No    | No    | No pack       | pending            | pending              | pending     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      # not working dept|      78 | AM_LIST_KG_Item_7   | AM     | list | singles     | KG  | Negative | No           | No    | No    | Single pack   | Fruit & Veg        |  108425529,108368608 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
    #  |      78 | AM_LIST_KG_Item_8   | AM     | list | cases       | KG  | Negative | No           | No    | No    | Multiple pack | pending            | pending              | null     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      # not working|      78 | AM_SCAN_KG_Item_9   | AM     | scan | singles     | KG  | Zero     | Yes          | Yes   | Yes   | Multiple pack | Fruit & Veg        |            108335620 |         542 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
     # not working|      78 | AM_SCAN_KG_Item_10  | AM     | scan | cases       | KG  | Zero     | Yes          | Yes   | Yes   | No pack       | Butchery           |            106869513 |         297 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #  not working dept|      78 | AM_LIST_KG_Item_9   | AM     | list | singles     | KG  | Zero     | Yes          | Yes   | Yes   | Single pack   | Fish Bar           |  110245463,102391090 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_KG_Item_10  | AM     | list | cases       | KG  | Zero     | Yes          | Yes   | Yes   | Multiple pack | Fruit & Veg        |  108598382,108453538 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_KG_Item_11  | AM     | scan | singles     | KG  | Zero     | No           | No    | No    | Multiple pack | Deli               |            105776497 |         386 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_KG_Item_12  | AM     | scan | cases       | KG  | Zero     | No           | No    | No    | No pack       | Fruit & Veg        |            104840012 |         548 | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #not working dept |      78 | AM_LIST_KG_Item_11  | AM     | list | singles     | KG  | Zero     | No           | No    | No    | Single pack   | Butchery           |  110218908,110459349 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      #  not working|      78 | AM_LIST_KG_Item_12  | AM     | list | cases       | KG  | Zero     | No           | No    | No    | Multiple pack | Fruit & Veg        |  108543787,108424913 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      #### PCS
      |      78 | AM_SCAN_PCS_Item_1  | AM     | scan | singles     | PCS | Positive | Yes          | Yes   | Yes   | Multiple pack | Fresh              |            103147620 |         381 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
    #  |      78 | AM_SCAN_PCS_Item_2  | AM     | scan | cases       | PCS | Positive | Yes          | Yes   | Yes   | No pack       | pending            | pending              | pending     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
        #not working dept|      78 | AM_LIST_PCS_Item_1  | AM     | list | singles     | PCS | Positive | Yes          | Yes   | Yes   | Single pack   | Deli               |  106798541,106285471 |         null | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_PCS_Item_2  | AM     | list | singles       | PCS | Positive | Yes          | Yes   | Yes   | Multiple pack | Oven Fresh / Baked |            105348994 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_PCS_Item_3  | AM     | scan | singles     | PCS | Positive | No           | No    | No    | Multiple pack | Bread & cakes      |            102372201 |         271 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
    #  |      78 | AM_SCAN_PCS_Item_4  | AM     | scan | cases       | PCS | Positive | No           | No    | No    | No pack       | pending            | pending              | pending     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_PCS_Item_3  | AM     | list | singles     | PCS | Positive | No           | No    | No    | Single pack   | Fish Bar           |  108313236,108311775 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     # |      78 | AM_LIST_PCS_Item_4  | AM     | list | cases       | PCS | Positive | No           | No    | No    | Multiple pack | pending            | pending              | null     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_PCS_Item_5  | AM     | scan | singles     | PCS | Negative | Yes          | Yes   | Yes   | Multiple pack | Fruit & Veg        |            103853612 |         543 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      #|      78 | AM_SCAN_PCS_Item_6  | AM     | scan | cases       | PCS | Negative | Yes          | Yes   | Yes   | No pack       | pending            | pending              | pending     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_PCS_Item_5  | AM     | list | singles     | PCS | Negative | Yes          | Yes   | Yes   | Single pack   | Bread & cakes      |  105734123,109678966 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     # |      78 | AM_LIST_PCS_Item_6  | AM     | list | cases       | PCS | Negative | Yes          | Yes   | Yes   | Multiple pack | pending            | pending              | null     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_PCS_Item_7  | AM     | scan | singles     | PCS | Negative | No           | No    | No    | Multiple pack | Fresh              |            103143451 |         359 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
    #  |      78 | AM_SCAN_PCS_Item_8  | AM     | scan | cases       | PCS | Negative | No           | No    | No    | No pack       | pending            | pending              | pending     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_PCS_Item_7  | AM     | list | singles     | PCS | Negative | No           | No    | No    | Single pack   | Fish Bar           |  102390337,105901930 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     # |      78 | AM_LIST_PCS_Item_8  | AM     | list | cases       | PCS | Negative | No           | No    | No    | Multiple pack | pending            | pending              | null     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_SCAN_PCS_Item_9  | AM     | scan | singles     | PCS | Zero     | Yes          | Yes   | Yes   | Multiple pack | Fresh              |            107305912 |         284 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     # |      78 | AM_SCAN_PCS_Item_10 | AM     | scan | cases       | PCS | Zero     | Yes          | Yes   | Yes   | No pack       | pending            | pending              | pending     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
      |      78 | AM_LIST_PCS_Item_9  | AM     | list | singles     | PCS | Zero     | Yes          | Yes   | Yes   | Single pack   | Fresh              |  103153229,108175355 |     null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     # |      78 | AM_LIST_PCS_Item_10 | AM     | list | cases       | PCS | Zero     | Yes          | Yes   | Yes   | Multiple pack | pending            | pending              | null     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
       #not working|      78 | AM_SCAN_PCS_Item_11 | AM     | scan | singles     | PCS | Zero     | No           | No    | No    | Multiple pack | Fruit & Veg        |            105822385 |         346 | Include    | Available | active      | Counts   |WareHouse | Available       |4|
      #|      78 | AM_SCAN_PCS_Item_12 | AM     | scan | cases       | PCS | Zero     | No           | No    | No    | No pack       | pending            | pending              | pending     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
       #not working|     78 | AM_LIST_PCS_Item_11 | AM     | list | singles     | PCS | Zero     | No           | No    | No    | Single pack   | Cake Shop          |  111023627,105523300 |         null | Include    | Available | active      | Counts   |WareHouse | Available       |4|
     # |      78 | AM_LIST_PCS_Item_12 | AM     | list | cases       | PCS | Zero     | No           | No    | No    | Multiple pack | pending            | pending              | null     | Include    | Available | unknown      | Counts   |WareHouse | Available       |4|
     
     
 