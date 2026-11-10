@New_pm_count_ToggleON @regression @store_walk
Feature: Verify Counts functionality for 'PM' window.

 @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples: 
      | Hours | Mins | Meridiem |
      |    03 |   30 | pm       |

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
      |     78 | Counts      |

########### SCAN MODE ----> Add DEPARTMENT list in POST count body
########### LIST MODE ----> Add ITEM list in POST count body

######################################--------------SCAN MODE------------------------######################################################  

  @sma
  Scenario Outline: Create Count storewalk by making call with Post storewalk service for "<Window>" window and "<Mode>" mode.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given The Post request is made to create Count storewalk for window "<Window>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Departments>"
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When The Post request is made to create Count storewalk api for Store id "<StoreID>"
    Then Post operation performed on post strorewalk api to create Count storewalk
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk
    Examples: 
      | StoreID | Name               | Window | Mode | Item | Departments | ActionType | Status    | RangeStatus | WalkType | location  | StorewalkStatus |
|      78 | PM_SCAN_ITEM_COUNT | PM     | scan | 103087399 | 359,223,261,126,290,287,217,406,542,386,548,381 | Include    | Available | active      | Counts   | WareHouse | Available       |
 
  @sma
  Scenario Outline: Navigate to Warehouse location and Verify count data is getting generated and displayed on UI. 
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on Back Button

    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"

    Examples: 
      | StoreID | Name               | Window | Mode | Item      | ActionType | Status    | RangeStatus | WalkType | location  |
      |    78 | PM_SCAN_ITEM_COUNT | PM     | scan | 103087399 | Include    | Available | active      | Counts   | WareHouse |

@sma
  Scenario Outline: Warehouse Location - Scan an Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
  Then I click on the main menu "Stock Management Applications"
  Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on barcode entry Button
    Then Enter "<Item>" number
    Then Enter quantity as "<quantity>" and click on Confirm button
    And I click on Back Button
   
    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
      |    78 | PM_SCAN_ITEM_COUNT | PM     | scan | singles     |  Single pack   | Fresh           | 103087399 |         359 | Include    | Available | active      | Counts   |        5 |
      
 
     @sma
  Scenario Outline: WAREHOUSE Location - Confirm counts and Verify COMPLETE status for WAREHOUSE Location.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
       Then I click on the main menu "Stock Management Applications"
       Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
   Then I will confirm Counts
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
 Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
   |     78 | PM_SCAN_ITEM_COUNT  | PM     | scan |103087399| singles     | Complete    |WareHouse|CountComplete| Available | unknown      | Counts   |Available|
   
    
    @sma
  Scenario Outline: WAREHOUSE Location - Reopen Completed count and verify REOPEN Counts alert.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
      Then I click on the main menu "Stock Management Applications"
      Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    

    Examples: 
      | StoreID | Name           | Mode |AlertName             | AlertMessage                                         |Item|
      |     78 | PM_SCAN_ITEM_COUNT | scan | Confirm Reopen Counts | Are you sure you want to reopen this count location? |101545309|
      
@sma
  Scenario Outline: WAREHOUSE Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
  Then I click on the main menu "Stock Management Applications"
  Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I verify ADD to Count and EDIT Count buttons are displayed
    And I click on Back Button
    Then I will confirm Counts
    

    Examples: 
      | StoreID | Name           |  Mode | 
      |    78 | PM_SCAN_ITEM_COUNT | scan | 
        
      @sma
  Scenario Outline: WAREHOUSE Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
        Then I click on the main menu "Stock Management Applications"
        Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
    And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Add the quantity "<quantity>"
And I click on product from product list
And I click on Back Button
And I verify "<Action1>" quantity is updated
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Edit the quantity "<quantity>"
    And I verify "<Action2>" quantity is updated
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button
    
   Examples: 
     | StoreID | Name           |  Mode | quantity |Action1|Action2|
      |     78 | PM_SCAN_ITEM_COUNT |scan | 8 |Add|Edit|
      
       
  @sma
  Scenario Outline: Navigate to Fixture location and Verify count data is getting generated and displayed on UI. 
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
        And I click on Back Button
    
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
     Examples: 
       | StoreID | Name            | Window | Mode | Item | WalkType | location | Status    |
       |78 | PM_SCAN_ITEM_COUNT | PM     | scan | 101545309 |Counts   | On_Shelf | Available |
     
   
  @sma
  Scenario Outline: Fixture Location - Scan an Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on barcode entry Button
    Then Enter "<Item>" number
    Then Enter quantity as "<quantity>" and click on Confirm button
    And I click on Back Button
   
    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
       |     78 | PM_SCAN_ITEM_COUNT | PM     | scan | singles     |  Single pack   | Fresh           | 103087399 |         359 | Include    | Available | active      | Counts   |        5 |
         
       @sma
  Scenario Outline: FIXTURE Location - Confirm counts and Verify COMPLETE status for FIXTURE Location.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
         Then I click on the main menu "Stock Management Applications"
         Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
     Then I verify that the posted counts are displayed in Warehouse and select the count
   Then I will confirm Counts
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store

  Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
   |     78 | PM_SCAN_ITEM_COUNT  | PM     | scan |103087399| singles     | Complete    |On_Shelf|CountComplete| Available | unknown      | Counts   |Available|
  
      @sma
  Scenario Outline: FIXTURE Location - Reopen Completed count and verify REOPEN Counts alert.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
        Then I click on the main menu "Stock Management Applications"
        Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    

      Examples: 
      | StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
      |  78 | PM_SCAN_ITEM_COUNT | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
        
     @sma
  Scenario Outline: FIXTURE Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
       Then I click on the main menu "Stock Management Applications"
       Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I verify ADD to Count and EDIT Count buttons are displayed
    And I click on Back Button
    Then I will confirm Counts
    

  Examples: 
      | StoreID | Name           |  Mode | 
      |    78 | PM_SCAN_ITEM_COUNT | scan | 
      
       @sma
  Scenario Outline: FIXTURE Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
     When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
         Then I click on the main menu "Stock Management Applications"
         Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Add the quantity "<quantity>"
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Edit the quantity "<quantity>"
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button
    

  Examples: 
      | StoreID | Name           | Mode | quantity |  
      |     78 | PM_SCAN_ITEM_COUNT | scan |           8 | 
    
   @sma
  Scenario Outline: OFFSHELF Location - Select Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
     Then I click on the main menu "Stock Management Applications"
     Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And Select product, enter quantity "<quantity>" and click on confirm button
   And I click on Back Button
   
    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
      |     78 | PM_SCAN_ITEM_COUNT | PM     | scan | singles     |  Single pack   | Fresh           | 103087399 |         261 | Include    | Available | active      | Counts   |        5 |
    
   
  @sma
  Scenario Outline: OFFSHELF Location - Confirm counts and Verify COMPLETE status for OFFSHELF Location. 
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
      When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I complete OffShelf
    And I click on Confirm button on Confirm counts alert
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
 Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
   |     78 | PM_SCAN_ITEM_COUNT  | PM     | scan |103087399| singles     | Complete    |Off_Shelf|CountComplete| Available | unknown      | Counts   |CountComplete|

  @sma
  Scenario Outline: OFFSHELF Location - Click on Completed count and verify REOPEN Counts alert.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    

     Examples: 
      | StoreID | Name           | Mode | AlertName             | AlertMessage                                         |
      |    78 | PM_SCAN_ITEM_COUNT | scan |  Confirm Reopen Counts | Are you sure you want to reopen this count location? |
  

 @sma
  Scenario Outline: PETROL Location - Select Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
   Then I click on the main menu "Stock Management Applications"
   Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
     And Select product, enter quantity "<quantity>" and click on confirm button
   And I click on Back Button
   
    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
      |    78 | PM_SCAN_ITEM_COUNT | PM     | scan | singles     |  Single pack   | Fresh           |  103087399 |         261 | Include    | Available | active      | Counts   |        5 |
  
  @sma
  Scenario Outline: PETROL Location - Confirm counts and Verify COMPLETE status for PETROL Location. 
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
      When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I complete Petrol
    And I click on Confirm button on Confirm counts alert
     Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
   |    78 | PM_SCAN_ITEM_COUNT  | PM     | scan |103087399| singles     | Complete    |Petrol|CountComplete| Available | unknown      | Counts   |Available|
    
  @sma
  Scenario Outline: PETROL Location - Click on Completed count and verify REOPEN Counts alert.
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
       When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    
    Examples: 
      | StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
      |   78 | PM_SCAN_ITEM_COUNT | scan | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
     
 
  @sma
  Scenario Outline: Complete all the count locations on UI and Verify storewalk status as 'CountComplete' in Storewalk service.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
       When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on Back Button
    
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response

Examples: 
      | StoreID | Name           | Item      | Mode |StorewalkStatus|WalkType|
      |    78 | PM_SCAN_ITEM_COUNT | 103087399 | scan |CountComplete|Counts|
  
  @sma
  Scenario Outline: Verify Count is edited in Review section
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
     When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I select the product from Count
    And I select the Capture count location
    Then I will enter qty "<quantity>"
    And I verify count quantity "<quantity>" is updated in Review section
    And I Confirm the Review
    And I click on Back Button
    

   Examples: 
      | StoreID | Name           | Mode      | Item | quantity|  
      |    78 | PM_SCAN_ITEM_COUNT |  scan |  103087399 |       8 | 

  @sma
  Scenario Outline: Confirm the capture count in Review section. Then, verify Review section status on UI as 'Completed' and Storewalk status as 'ReviewComplete' in the Storewalk service.
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
      When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I select the product and click on confirm button
    And I click on Back Button
    
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"

    Examples: 
      | StoreID | Name           | Item      | Mode | quantity |WalkType | 
      |    78 | PM_SCAN_ITEM_COUNT | 103087399 | scan |   8 | Counts   | 

   
  @sma
  Scenario Outline: Verify that After REVIEW we cannot select the review completed product from WAREHOUSE location.
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
      When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed
    Then The field should be disabled
    

    Examples: 
      | StoreID | Name           | Item      | Mode | 
      |     78| PM_SCAN_ITEM_COUNT | 103087399 | scan | 
   
  @sma
  Scenario Outline: Verify that After REVIEW we cannot select the review completed product from FIXTURE location.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed
    Then The field should be disabled
    

   Examples: 
      | StoreID | Name           | Item      | Mode |
      |    78 | PM_SCAN_ITEM_COUNT | 103087399 | scan | 
     
  @sma
  Scenario Outline: Verify Counts SUMMARY after completing all the locations on UI
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
       When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Summary
    Then I verify the fields in Counts Summary
    Then I verify if checkbox are checked
    

    Examples: 
      | StoreID | Name           | Item      | Mode | CountedType | 
      |    78 | PM_SCAN_ITEM_COUNT | 103087399 | scan | singles      | 
      
      @sma
  Scenario Outline: SUMMARY - Verify in Summary section DAY spinner dropdown is displayed. 
  When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
        Then I click on the main menu "Stock Management Applications"
        Then I click on "Scheduled Counts"
    Then I click on Counts Summary
    Then I verify the fields in Counts Summary
    Then I verify Day spinner option is displayed
    And I click on Day spinner
    Then I verify Day spinner with three optins are displayed - Today, Yesterday and date Day before yesterday
    And I click on Back Button
    

    Examples: 
      | StoreID | 
      |     78| 
      
###########################################--------------LIST MODE------------------------######################################################      

 @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples: 
      | Hours | Mins | Meridiem |
      |    03 |   30 | pm       |
      
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
      |     78 | Counts      |

@sma
  Scenario Outline: Create Count storewalk by making call with Post storewalk service for "<Window>" window and "<Mode>" mode.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given The Post request is made to create Count storewalk for window "<Window>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Departments>"
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When The Post request is made to create Count storewalk api for Store id "<StoreID>"
    Then Post operation performed on post strorewalk api to create Count storewalk
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk

    Examples: 
      | StoreID | Name               | Window | Mode | Item | Departments | ActionType | Status    | RangeStatus | WalkType | location  | StorewalkStatus |
   |     78| PM_LIST_ITEM_COUNT | PM     | list |102390337|null | Include    | Available | active      | Counts   | WareHouse | Available       |

 @sma
  Scenario Outline: Navigate to Warehouse location and Verify count data is getting generated and displayed on UI. 
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
   Then I click on the main menu "Stock Management Applications"
   Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on Back Button
    
    
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<Status>" is present in Get storewalk service response
    Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response

    Examples: 
      | StoreID | Name               | Window | Mode | Item      | ActionType | Status    | RangeStatus | WalkType | location  |
      |     78 | PM_LIST_ITEM_COUNT | PM     | list | 102390337 | Include    | Available | active      | Counts   | WareHouse |

  @sma
  Scenario Outline: Warehouse Location - Select an Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on product "<Item>" in the list
     Then I will enter qty "<quantity>"
     And I click on Back Button

    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
       |    78| PM_LIST_ITEM_COUNT | PM     | list | singles     |  Single pack   | Fish Bar           | 102390337 |         261 | Include    | Available | active      | Counts   |        5 |
     
      @sma
  Scenario Outline: Navigate to Fixture location and Verify count data is getting generated and displayed on UI. 
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
        Then I click on the main menu "Stock Management Applications"
        Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
        And I click on Back Button
    
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<Status>" is present in Get storewalk service response
    Then Verify for "<location>" Count location status "<Status>" is present in Get storewalk service response
    Examples: 
       | StoreID | Name            | Window | Mode | Item | WalkType | location | Status    |
     |78 | PM_LIST_ITEM_COUNT | PM     | list | 102390337  |Counts   | On_Shelf | Available |

  @sma
  Scenario Outline: Fixture Location - Select an Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on product "<Item>" in the list
    Then I will enter qty "<quantity>" and click on Confirm button

    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
     |    78 | PM_LIST_ITEM_COUNT | PM     | list | singles     |  Single pack   | Fish Bar           | 102390337 |         261 | Include    | Available | active      | Counts   |        5 |
     
    @sma
  Scenario Outline: WAREHOUSE Location - Confirm counts and Verify COMPLETE status for WAREHOUSE Location.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
      Then I click on the main menu "Stock Management Applications"
      Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
   Then I will confirm Counts
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
 Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
      |   78 | PM_LIST_ITEM_COUNT  | PM     | list |102390337| singles     |Complete    |WareHouse|CountComplete| Available | unknown      | Counts   |Available|
   
    
    @sma
  Scenario Outline: WAREHOUSE Location - Reopen Completed count and verify REOPEN Counts alert.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
      Then I click on the main menu "Stock Management Applications"
      Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    

    Examples: 
      | StoreID | Name           | Mode |AlertName             | AlertMessage                                         |Item|
       |  78 | PM_LIST_ITEM_COUNT | list |Confirm Reopen Counts | Are you sure you want to reopen this count location? |102390337|
    
@sma
  Scenario Outline: WAREHOUSE Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
  Then I click on the main menu "Stock Management Applications"
  Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I verify ADD to Count and EDIT Count buttons are displayed
    And I click on Back Button
    Then I will confirm Counts
    

    Examples: 
      | StoreID | Name           |  Mode | 
       |    78 | PM_LIST_ITEM_COUNT | list | 
      
      @sma
  Scenario Outline: WAREHOUSE Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
        Then I click on the main menu "Stock Management Applications"
        Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
    And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Add the quantity "<quantity>"
And I click on product from product list
And I click on Back Button
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Edit the quantity "<quantity>"
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button
    
   Examples: 
     | StoreID | Name           |  Mode | quantity |
       |   78 | PM_LIST_ITEM_COUNT | list | 8 |
  
 
       @sma
  Scenario Outline: FIXTURE Location - Confirm counts and Verify COMPLETE status for FIXTURE Location.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
         Then I click on the main menu "Stock Management Applications"
         Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
     Then I verify that the posted counts are displayed in Warehouse and select the count
   Then I will confirm Counts
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store

  Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
   |  78 | PM_LIST_ITEM_COUNT  | PM     | list |102390337| singles     |Complete    |On_Shelf|CountComplete| Available | active      | Counts   |CountComplete|

      @sma
  Scenario Outline: FIXTURE Location - Reopen Completed count and verify REOPEN Counts alert.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
        Then I click on the main menu "Stock Management Applications"
        Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    

      Examples: 
      | StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
       |   78 | PM_LIST_ITEM_COUNT | list | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |
       
     @sma
  Scenario Outline: FIXTURE Location - Reopen the completed Count, select the product and verify 'ADD TO COUNT' and 'EDIT COUNT' buttons are displayed.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
       Then I click on the main menu "Stock Management Applications"
       Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I verify ADD to Count and EDIT Count buttons are displayed
    And I click on Back Button
    Then I will confirm Counts
    

  Examples: 
      | StoreID | Name           |  Mode | 
      |    78 | PM_LIST_ITEM_COUNT |list | 
     
       @sma
  Scenario Outline: FIXTURE Location - Verify 'EDIT COUNT' and 'Add to Count' functionality.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
     When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
         Then I click on the main menu "Stock Management Applications"
         Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    And I Select the completed Count
    Then I Click on Yes button on Reopen alert
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Add the quantity "<quantity>"
     And I get product quantity displayed on UI
    And I click on product from product list
    Then I will Edit the quantity "<quantity>"
    Then I will confirm Counts
    Then Verify status for "<Name>" has changed to Complete
    And I click on Back Button
    

  Examples: 
      | StoreID | Name           | Mode | quantity |  
      |   78 | PM_LIST_ITEM_COUNT |   list |            8 |


   @sma
  Scenario Outline: OFFSHELF Location - Select Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
     Then I click on the main menu "Stock Management Applications"
     Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And Select product, enter quantity "<quantity>" and click on confirm button
   
    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
      |    78 | PM_LIST_ITEM_COUNT | PM     | list | singles     |  Single pack   | Fresh           | 102390337 |         359 | Include    | Available | active      | Counts   |        5 |
   
   
  @sma
  Scenario Outline: OFFSHELF Location - Confirm counts and Verify COMPLETE status for OFFSHELF Location. 
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
      When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I complete OffShelf
    And I click on Confirm button on Confirm counts alert
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
 Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
   |     78| PM_LIST_ITEM_COUNT  | PM     | list |102390337| singles     | Complete    |Off_Shelf|CountComplete| Available | active      | Counts   |CountComplete|

  @sma
  Scenario Outline: OFFSHELF Location - Click on Completed count and verify REOPEN Counts alert.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    

     Examples: 
      | StoreID | Name           | Mode | AlertName             | AlertMessage                                         |
       |    78| PM_LIST_ITEM_COUNT | list | Confirm Reopen Counts | Are you sure you want to reopen this count location? |

  
 
 @sma
  Scenario Outline: PETROL Location - Select Items in generated Count for "<Mode>" mode, Enter quantity and confirm.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
   Then I click on the main menu "Stock Management Applications"
   Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And Select product, enter quantity "<quantity>" and click on confirm button
   
    Examples: 
      | StoreID | Name               | Window | Mode | CountedType |Pack          | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | quantity |
      |    78 | PM_LIST_ITEM_COUNT | PM     | list | singles     |  Single pack   | Fresh           | 102390337 |         359 | Include    | Available | active      | Counts   |        5 |
   
 
  @sma
  Scenario Outline: PETROL Location - Confirm counts and Verify COMPLETE status for PETROL Location. 
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
      When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I complete Petrol
    And I click on Confirm button on Confirm counts alert
     Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    Then Verify for "<location>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is not Curfew store
Examples: 
   | StoreID | Name            | Window | Mode | Item|CountedType |ActionType |location|locationStatus| Status    | RangeStatus | WalkType |StorewalkStatus|
   |   78 | PM_LIST_ITEM_COUNT  | PM     | list |102390337| singles     | Complete    |Petrol|CountComplete| Available | unknown      | Counts   |Available|
    
  @sma
  Scenario Outline: PETROL Location - Click on Completed count and verify REOPEN Counts alert.
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
       When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I verify "<AlertName>" alert is displayed
    And I verify Reopen counts alert message "<AlertMessage>" is displayed
    And I verify Reopen counts alert with Yes and No options are displayed
    Then I Click on No option on Reopen counts alert
    
    Examples: 
      | StoreID | Name           | Mode | CountedType | DepartmentName | AlertName             | AlertMessage                                         |
        |   78 | PM_LIST_ITEM_COUNT | list | singles     | Fresh          | Confirm Reopen Counts | Are you sure you want to reopen this count location? |

 
  @sma
  Scenario Outline: Complete all the count locations on UI and Verify storewalk status as 'CountComplete' in Storewalk service.
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
       When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on Back Button
    
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response

Examples: 
      | StoreID | Name           | Item      | Mode |StorewalkStatus|WalkType|
      |   78| PM_LIST_ITEM_COUNT | 102390337 |  list | CountComplete|Counts|

  @sma
  Scenario Outline: Verify Count is edited in Review section
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
     When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I select the product from Count
    And I select the Capture count location
    Then I will enter qty "<quantity>"
    And I verify count quantity "<quantity>" is updated in Review section
    And I Confirm the Review
    And I click on Back Button
    

   Examples: 
      | StoreID | Name           | Mode      | Item | quantity|  
      |   78 | PM_LIST_ITEM_COUNT |  list |  102390337 |        8 |  
 
 
  @sma
  Scenario Outline: Verify that After REVIEW we cannot select the review completed product from WAREHOUSE location.
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
      When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed
    Then The field should be disabled
    

    Examples: 
      | StoreID | Name           | Item      | Mode | 
      |    78 | PM_LIST_ITEM_COUNT | 102390337 |  list | 
 

  @sma
  Scenario Outline: Verify that After REVIEW we cannot select the review completed product from FIXTURE location.
     Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed
    Then The field should be disabled
    

   Examples: 
      | StoreID | Name           | Item      | Mode |
      |    78 | PM_LIST_ITEM_COUNT | 102390337 |  list | 


  @sma
  Scenario Outline: Verify Counts SUMMARY after completing all the locations on UI
   Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
       When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Summary
    Then I verify the fields in Counts Summary
    Then I verify if checkbox are checked
    

    Examples: 
      | StoreID | Name           | Item      | Mode | CountedType | 
      |    78| PM_LIST_ITEM_COUNT | 102390337 |  list | singles      | 
      
##########################################################------------TIME CHANGE SCENARIOS-------------#############################################
   @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples: 
      | Hours | Mins | Meridiem |
      |    01 |   00 | pm       |

  @sma
  Scenario Outline: Verify Delete Count Storewalk service
  Given Request is made to SMA app login service for collegue user
  Then Service should return details for SMA app Login Service
  And Get the generated Access Tocken for SMA app Login Service
  Given Get request is made to Get storewalks service for current date
  And Get Operation perform on service request
  Then Verify Get storewalks service response for current date
  Then Delete request is made to Delete Count storewalk for store id "<storeID>"
  
  Examples:
  | storeID | capturetype |
  |    78| Counts      |
  
  @sma
  Scenario Outline: Create Count storewalk by making call with Post storewalk service for "<Window>" window and "<Mode>" mode.
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given The Post request is made to create Count storewalk for window "<Window>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Departments>"
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    When The Post request is made to create Count storewalk api for Store id "<StoreID>"
    Then Post operation performed on post strorewalk api to create Count storewalk
    Then The service should return detailsCount StoreWalk Service
    Then I verify the json response with Count StoreWalk

    Examples: 
      | StoreID | Name                  | Window | Mode | Item                | Departments | ActionType | Status    | RangeStatus | WalkType | location  | StorewalkStatus |
      |    78| PM_SCAN_ITEM_COUNT_01 | PM     | scan | null |          344 | Include    | Available | active      | Counts   | WareHouse | Available       |

  @sma
  Scenario Outline: Verify PM Counts cannot be performed BEFORE the specified time - FIXTURE Sections
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Department>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I click on the product and I should get the Start time message

    Examples: 
      | StoreID | Name                  | Item      | Department | Mode |
      |      78| PM_SCAN_ITEM_COUNT_01 | 108837697 |   344 | scan |

  @sma
  Scenario Outline: Verify PM Counts cannot be performed BEFORE the specified time - PETROL Sections
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Department>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I click on the product and I should get the Start time message

    Examples: 
      | StoreID | Name                  | Item      | Department | Mode |
      |     78| PM_SCAN_ITEM_COUNT_01 | 108837697 |      344 | scan |

  @sma
  Scenario Outline: Verify PM Counts cannot be performed BEFORE the specified time - OFFSHELF Sections
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Department>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I click on the product and I should get the Start time message

    Examples: 
      | StoreID | Name                  | Item      | Department | Mode |
      |     78| PM_SCAN_ITEM_COUNT_01 | 108837697 |       344 | scan |

   @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples: 
      | Hours | Mins | Meridiem |
      |    11 |   48 | pm       |

  @sma
  Scenario Outline: Verify PM Counts cannot be performed AFTER the specified time - WAREHOUSE Sections
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Department>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I click on the product and I should get the End time message

    Examples: 
      | StoreID | Name                  | Item      | Department | Mode |
      |     78| PM_SCAN_ITEM_COUNT_01 | 108837697 |       344 | scan |

  @sma
  Scenario Outline: Verify PM Counts cannot be performed AFTER the specified time - FIXTURES Sections
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Department>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Fixtures Sections
    Then I click on the product and I should get the End time message

    Examples: 
      | StoreID | Name                  | Item      | Department | Mode |
      |     78| PM_SCAN_ITEM_COUNT_01 | 108837697 |       344| scan |

  @sma
  Scenario Outline: Verify PM Counts cannot be performed AFTER the specified time - PETROL Sections
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Department>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on Petrol Sections
    Then I click on the product and I should get the End time message

    Examples: 
      | StoreID | Name                  | Item      | Department | Mode |
      |     78| PM_SCAN_ITEM_COUNT_01 | 108837697 |         344 | scan |

  @sma
  Scenario Outline: Verify PM Counts cannot be performed AFTER the specified time - OFFSHELF Sections
    Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    Given Post count storewalk Item list data is "<Item>"
    Given Post count storewalk Department list data is "<Department>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on OffShelf Sections
    Then I click on the product and I should get the End time message

    Examples: 
      | StoreID | Name                  | Item      | Department | Mode |
      |    78| PM_SCAN_ITEM_COUNT_01 | 108837697 |       344 | scan |
      