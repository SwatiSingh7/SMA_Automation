@CO_ToggleON_count_curfew_store @regression @store_walk
Feature: Verify Counts functionality for 'AM' ans 'PM' window for Curfew store (Store no. - 16).

  ############################################ AM Count ############################################################################
  
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
      |      16 | Counts      |

 
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
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Get count storewalk service response is same as post count storewalk body
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    And Verify store id "<StoreID>" is Curfew store
    Given Get request is made to Get walkItem service for count name "<Name>", store id "<StoreID>" and product id "<Item>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    Given Request is made to verify Product Id "<Item>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    Given Verify ProductId "<Item>" is included in the service
    Given ProductId "<Item>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service

    Examples: 
      | StoreID | Name                      | Window | Mode | CountedType | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | StorewalkStatus |
      |      16 | AM_SCAN_Count_CurfewStore | AM     | scan | singles     | 101545309 |         223 | Include    | Available | unknown      | Counts   | Available       |
      |      16 | AM_LIST_Count_CurfewStore | AM     | list | singles     | 100001592 | null        | Include    | Available | active      | Counts   | Available       |   

 @sma
  Scenario Outline: AM Count - Verify UI of Counts displayed as expected or not
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
   Then I click on the main menu "Stock Management Applications"
   Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    And I click on Back Button
    Then I click on Fixtures Sections
    And I click on Back Button
    Then I click on Uncounted Sections
    And I click on Back Button
    Then I click on OffShelf Sections
    And I click on Back Button
    Then I click on Petrol Sections
    And I click on Back Button
    And I click on Back Button
    Then I click on ReviewCount
    And I click on Back Button
    Then I click on Counts Summary
    Then I verify the fields in Counts Summary
    And I click on Back Button
    

    Examples: 
      | StoreID |
      |      16 |


  @sma
  Scenario Outline: Verify end to end AM COUNT functionality for Curfew store - Create Count, Complete all the locations, Review capture of Counts and verify Summary.
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
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Scheduled Counts"
    Then I click on Counts Sections
    Then I click on WareHouse Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on barcode entry Button
    Then Enter "<Item>" number
    Then I will enter qty "<quantity>"
    Then I will confirm Counts
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    Then I click on Fixtures Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I click on barcode entry Button
    Then Enter "<Item>" number
    Then I will enter qty "<quantity>"
    Then I will confirm Counts
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    Then I click on OffShelf Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And Select product, enter quantity "<quantity>" and click on confirm button
    Then I complete OffShelf
    Then I click on Confirm button on Confirm counts alert
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    Then I click on Petrol Sections
    Then I verify that the posted counts are displayed in Warehouse and select the count
    And I complete Petrol
    And Verify "<Alert>" alert is displayed
    Then I click on Confirm button on Confirm counts alert
    Then Verify count status for "<Name>" has changed to Complete
    And I click on Back Button
    And I click on Back Button
    Then I click on ReviewCount
    Then I verify that the posted counts are displayed in Warehouse and select the count
    Then I select the product from Count
    And I select the Capture count location
    Then I will enter qty "<quantity>"
    And I select the product from Count
    And I Confirm the Review
    And I click on Back Button
    And I click on Back Button
    Then I click on Counts Summary
    Then I verify the fields in Counts Summary
    Then I verify if checkbox are checked
    
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    And Get Operation perform on service request
    Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    And Verify Get count storewalk service response is same as post count storewalk body
    And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    Then Verify for "<location1>" Count location status "<locationStatus>" is present in Get storewalk service response
    Then Verify for "<location2>" Count location status "<locationStatus>" is present in Get storewalk service response
    Then Verify for "<location3>" Count location status "<locationStatus>" is present in Get storewalk service response
    Then Verify for "<location4>" Count location status "<locationStatus>" is present in Get storewalk service response
    And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    #And Verify store id "<StoreID>" is Curfew store

    Given Get request is made to Get walkItem service for count name "<Name>", store id "<StoreID>" and product id "<Item>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    Given Request is made to verify Product Id "<Item>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    Given Verify ProductId "<Item>" is included in the service
    Given ProductId "<Item>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    Examples: 
      | StoreID | Name                      | Window | Mode | CountedType | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | StorewalkStatus | quantity | location1 | location2 | location3 | location4 | locationStatus |
      |      16 | AM_SCAN_Count_CurfewStore | AM     | scan | singles     | 101545309 |         223 | Review     | Available | active      | Counts   | ReviewComplete  |        4 | On_Shelf  | Off_Shelf | WareHouse | Petrol    | CountComplete  |
      |      16 | AM_LIST_Count_CurfewStore | AM     | list | singles     | 100001592 | null        | Review     | Available | active      | Counts   | ReviewComplete  |        4 | On_Shelf  | Off_Shelf | WareHouse | Petrol    | CountComplete  |
#
  ############################################## PM COUNT ##################################################################
  #
  #@timeChange
  #Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    #Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    #Then I Change time
    #Then I Change date
#
    #Examples: 
      #| Hours | Mins | Meridiem |
      #|    03 |   30 | pm       |
#
  ## UAT
  ## |   01   |   48    |    pm    |
  #
#
#
  #@sma
  #Scenario Outline: Create Count storewalk by making call with Post storewalk service for "<Window>" window and "<Mode>" mode.
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given The Post request is made to create Count storewalk for window "<Window>"
    #Given Post count storewalk Item list data is "<Item>"
    #Given Post count storewalk Department list data is "<Departments>"
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    #When The Post request is made to create Count storewalk api for Store id "<StoreID>"
    #Then Post operation performed on post strorewalk api to create Count storewalk
    #Then The service should return detailsCount StoreWalk Service
    #Then I verify the json response with Count StoreWalk
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Get count storewalk service response is same as post count storewalk body
    #And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    #And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    #And Verify store id "<StoreID>" is Curfew store
    #Given Get request is made to Get walkItem service for count name "<Name>", store id "<StoreID>" and product id "<Item>"
    #And Get Operation perform on service request
    #Then Verify Get walkitem service response
    #Given Request is made to verify Product Id "<Item>" is included in the service
    #When Request is made into Product service
    #Then Service should return the details of the service
    #Given Verify ProductId "<Item>" is included in the service
    #Given ProductId "<Item>" and StoreID "<StoreID>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
#
    #Examples: 
       #| StoreID | Name                      | Window | Mode | CountedType | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | StorewalkStatus |
      #|      16 | PM_SCAN_Count_CurfewStore | PM     | scan | singles     | 101545309 |         223 | Include    | Available | unknown      | Counts   | Available       |
      #|      16 | PM_LIST_Count_CurfewStore | PM     | list | singles     | 100001592 | null        | Include    | Available | unknown      | Counts   | Available       |   
 #
  #@sma
  #Scenario Outline: PM Count - Verify UI of Counts displayed as expected or not
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on the main menu "Stock Management Applications"
    #   Then I click on "Scheduled Counts"
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
#
    #Examples: 
      #| StoreID |
      #|      16 |
#
  #@sma
  #Scenario Outline: Verify end to end PM COUNT functionality for Curfew store - Create Count, Complete all the locations, Review capture of Counts and verify Summary.
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get the generated Access Tocken for SMA app Login Service
    #Given The Post request is made to create Count storewalk for window "<Window>"
    #Given Post count storewalk Item list data is "<Item>"
    #Given Post count storewalk Department list data is "<Departments>"
    #Given The Post Storewalk body to create Count storewalk api for Store id "<StoreID>",name "<Name>" and mode "<Mode>"
    #When The Post request is made to create Count storewalk api for Store id "<StoreID>"
    #Then Post operation performed on post strorewalk api to create Count storewalk
    #Then The service should return detailsCount StoreWalk Service
    #Then I verify the json response with Count StoreWalk
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on the main menu "Stock Management Applications"
    #   Then I click on "Scheduled Counts"
    #Then I click on Counts Sections
    #Then I click on WareHouse Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I click on barcode entry Button
    #Then Enter "<Item>" number
    #Then I will enter qty "<quantity>"
    #Then I will confirm Counts
    #Then Verify count status for "<Name>" has changed to Complete
    #And I click on Back Button
    #Then I click on Fixtures Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I click on barcode entry Button
    #Then Enter "<Item>" number
    #Then I will enter qty "<quantity>"
    #Then I will confirm Counts
    #Then Verify count status for "<Name>" has changed to Complete
    #And I click on Back Button
    #Then I click on OffShelf Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And Select product, enter quantity "<quantity>" and click on confirm button
    #Then I complete OffShelf
    #Then I click on Confirm button on Confirm counts alert
    #Then Verify count status for "<Name>" has changed to Complete
    #And I click on Back Button
    #Then I click on Petrol Sections
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #And I complete Petrol
    #And Verify "<Alert>" alert is displayed
    #Then I click on Confirm button on Confirm counts alert
    #Then Verify count status for "<Name>" has changed to Complete
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on ReviewCount
    #Then I verify that the posted counts are displayed in Warehouse and select the count
    #Then I select the product from Count
    #And I select the Capture count location
    #Then I will enter qty "<quantity>"
    #And I select the product from Count
    #And I Confirm the Review
    #And I click on Back Button
    #And I click on Back Button
    #Then I click on Counts Summary
    #Then I verify the fields in Counts Summary
    #Then I verify if checkbox are checked
    #
    #Given Get request is made to Get storewalks service for current date
    #And Get Operation perform on service request
    #And Get Walkid for Store id "<StoreID>" and walk type "<WalkType>"
    #When Get request is made to Get Count storewalk response for count name "<Name>" and store id "<StoreID>"
    #And Get Operation perform on service request
    #Then Verify Get count storewalk for count name "<Name>" and store id "<StoreID>"
    #And Verify Get count storewalk service response is same as post count storewalk body
    #And Verify Storewalk status as "<StorewalkStatus>" is present in Get storewalk service response
    #Then Verify for "<location1>" Count location status "<locationStatus>" is present in Get storewalk service response
    #Then Verify for "<location2>" Count location status "<locationStatus>" is present in Get storewalk service response
    #Then Verify for "<location3>" Count location status "<locationStatus>" is present in Get storewalk service response
    #Then Verify for "<location4>" Count location status "<locationStatus>" is present in Get storewalk service response
    #And Verify for Product id "<Item>" Count type "<CountedType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Action type "<ActionType>" is present in Get storewalk service response
    #Then Verify for Product id "<Item>" Range Status "<RangeStatus>" is present in Get storewalk service response
    #And Verify store id "<StoreID>" is Curfew store
#
    #Given Get request is made to Get walkItem service for count name "<Name>", store id "<StoreID>" and product id "<Item>"
    #And Get Operation perform on service request
    #Then Verify Get walkitem service response
    #Given Request is made to verify Product Id "<Item>" is included in the service
    #When Request is made into Product service
    #Then Service should return the details of the service
    #Given Verify ProductId "<Item>" is included in the service
    #Given ProductId "<Item>" and StoreID "<StoreID>" is included in the Stock Service
    #When Request is made into Stock service
    #Then Service should return the details of the Stock service
    #Examples: 
      #| StoreID | Name                      | Window | Mode | CountedType | UOM | DepartmentName  | Item      | Departments | ActionType | Status    | RangeStatus | WalkType | StorewalkStatus | quantity | location1 | location2 | location3 | location4 | locationStatus |
      #|      16 | PM_SCAN_Count_CurfewStore | PM     | scan | singles     | EA  | Fresh           | 101545309 |         223 | Review     | Available | active      | Counts   | ReviewComplete  |        4 | On_Shelf  | Off_Shelf | WareHouse | Petrol    | CountComplete  |
      #|      16 | PM_LIST_Count_CurfewStore | PM     | list | singles     | EA  | Health & Beauty | 100001592 | null        | Review     | Available | active      | Counts   | ReviewComplete  |        4 | On_Shelf  | Off_Shelf | WareHouse | Petrol    | CountComplete  |
