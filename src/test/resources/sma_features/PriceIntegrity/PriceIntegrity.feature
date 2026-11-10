@price_integrity
Feature: To verify Price integrity module

  @sma
  Scenario: TC-1_To verify navigating to mobile app screen is working properly
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User should be able to see the relevant sub-menus under Daily Workload
    And User checks the sub-menu items under Business Critical menu
    Then User should be able to see the relevant sub-menus under Business Critical
    When User navigates to Price Increases sub-menu
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Business Critical
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Daily Workload
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Exceptions sub-menu under Price Integrity option
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Request Label sub-menu under Price Integrity option
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification sub-menu under Price Integrity option
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    When User presses on back button
    Then User should be able to see the relevant sub-menus under Price Integrity
    Then User Close the application

  @sma
  Scenario: TC-2_To verify task list under Business critical group is getting displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User should be able to see the relevant sub-menus under Daily Workload
    And User checks the sub-menu items under Business Critical menu
    Then User should be able to see the relevant sub-menus under Business Critical
    Then User Close the application


  ############DailyWorkload_OverdueTask
  @sma
  Scenario: TC-3_To verify that different tasks are displayed under overdue tab in PIApp.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User should be able to see the relevant sub-menus under Daily Workload
    And User checks the sub-menu items under Overdue menu
    Then User should be able to see the relevant sub-menus under Overdue
    Then User Close the application

  @sma
  Scenario: TC-4_Daily Workload - To verify daily workload screen gets closed after pressing back button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User presses on back button
    Then User presses on back button
    And User verify daily workload screen get closed

  @sma
  Scenario: TC-5_Daily Workload - To verify overdue screen gets closed after pressing back button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User should be able to see the relevant sub-menus under Daily Workload
    And User checks the sub-menu items under Overdue menu
    Then User presses on back button
    Then User presses on back button
    Then User presses on back button
    And User verify daily workload screen get closed

  @sma
  Scenario: TC-6_Daily Workload - To verify Business critical screen gets closed after pressing back button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User should be able to see the relevant sub-menus under Daily Workload
    And User checks the sub-menu items under Business Critical menu
    Then User presses on back button
    Then User presses on back button
    Then User presses on back button
    And User verify daily workload screen get closed

  @sma
  Scenario: TC-7_Daily Workload - To verify scanning screen gets closed after pressing back button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User should be able to see the relevant sub-menus under Daily Workload
    And User checks the sub-menu items under Business Critical menu
    Then User presses on back button
    Then User presses on back button
    Then User presses on back button
    And User verify daily workload screen get closed

  @sma
  Scenario: TC-8_Daily Workload - To check swipe right an item for Ending offers task in daily workload
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    And User checks the sub-menu items under Daily Workload menu
    Then User should be able to see the relevant sub-menus under Daily Workload
    And User checks the sub-menu items under Business Critical menu
    And User checks item details under Ending Offers task
    When User performs swipe left on item in task list
    And Verify item is moved from task and missing Label exception is raised for same

  ##### Review
  @sma
  Scenario: TC-11_Review - To verify that user is able to view items under My Work tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on an item under My Work tab
    Then User should be able to see the details of item and close button

  @sma
  Scenario: TC-12_Review - To verify that user is able to view items under My Store tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    And User clicks on My Store tab
    Then User should be able to see items without any error
    And User clicks on an item under My Store tab
    Then User should be able to see the details of item and close button

  @sma
  Scenario: TC-13_Review - To verify that user is able to close screen with the close button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on an item under My Work tab
    Then User should be able to see the details of item and close button
    When User clicks on close button on details page
    Then User should be able to see item under My Work tab

  @sma
  Scenario: TC-14_Review - To verify that user is able to close review screen with back button press
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    Then User presses on back button
    And User should be able to see the relevant sub-menus under Price Integrity

  @sma
  Scenario: TC-15_Review - To verify that user is able to close review screen with the up-navigation button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    Then User clicks on up-navigation button
    And User should be able to see the relevant sub-menus under Price Integrity

  @sma
  Scenario: TC-16_Review - To verify user is able to apply filters on My work and My Store tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    And User verify My Work tab is displayed
    And User navigate to My Work tab
    Then User verify Filter icon is displayed
    And User click on Filter icon
    And User verify filters popup is displayed
    Then User select filter option
    And verify selected filter items are displayed in item list
    And User verify My Store tab is displayed
    And User navigate to My Store tab
    Then User verify Filter icon is displayed
    And User click on Filter icon
    And User verify filters popup is displayed
    Then User select filter option
    And verify selected filter items are displayed in item list

  ######## Verification History
  @sma
  Scenario: TC-17_Verification History - To verify that user is able to view items under My Work tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on an item under My Work tab
    Then User should be able to see the details of item and close button

  @sma
  Scenario: TC-18_Verification History - To verify that user is able to view items under My Store tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    And User clicks on My Store tab
    Then User should be able to see items without any error
    And User clicks on an item under My Store tab
    Then User should be able to see the details of item and close button

  @sma
  Scenario: TC-19_Verification History - To verify that user is able to close screen with the close button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on an item under My Work tab
    Then User should be able to see the details of item and close button
    When User clicks on close button on details page
    Then User should be able to see item under My Work tab

  @sma
  Scenario: TC-20_Verification History - To verify user is able to apply filters on My work and My Store tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    And User clicks on My Store tab
    Then User should be able to see items without any error
    And User clicks on filter and selects "Only Exceptions" filter
    Then User should be able to see items as per "Only Exceptions" filter condition
    And User clicks on filter and selects "Only Correct" filter
    Then User should be able to see items as per "Only Correct" filter condition
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on filter and selects "Only Exceptions" filter
    Then User should be able to see items as per "Only Exceptions" filter condition
    And User clicks on filter and selects "Only Correct" filter
    Then User should be able to see items as per "Only Correct" filter condition

  @sma
  Scenario: TC-21_Verification History - To verify that user is able to close verification history screen with back button press
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    Then User presses on back button
    And User should be able to see the relevant sub-menus under Price Integrity

  @sma
  Scenario: TC-22_Verification History - To verify that user is able to close review screen with the up-navigation button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    Then User clicks on up-navigation button
    And User should be able to see the relevant sub-menus under Price Integrity

  @sma
  Scenario: TC-23_Verification - To verify that user is able to close verification screen with back button press
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification sub-menu under Price Integrity option
    Then User presses on back button
    And User should be able to see the relevant sub-menus under Price Integrity

  @sma
  Scenario: TC-24_Verification - To verify that user is able to close review screen with the up-navigation button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification sub-menu under Price Integrity option
    Then User clicks on up-navigation button
    And User should be able to see the relevant sub-menus under Price Integrity

  @MPI-4616
  @sma
  Scenario: TC-25_Verify user can review Verifications results
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Verification History sub-menu under Price Integrity option
    And User clicks on My Store tab
    Then User should be able to see items without any error
    And User clicks on filter and selects "Only Exceptions" filter
    Then User should be able to see items as per "Only Exceptions" filter condition
    And User clicks on filter and selects "Only Correct" filter
    Then User should be able to see items as per "Only Correct" filter condition
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on filter and selects "Only Exceptions" filter
    Then User should be able to see items as per "Only Exceptions" filter condition
    And User clicks on filter and selects "Only Correct" filter
    Then User should be able to see items as per "Only Correct" filter condition

#
  ####@RequestLabel_PrintingLabel
  ###@MPI-4460
  #@sma
  #Scenario Outline: TC-28_Verify user can request label
    #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #Then I click on "Price Integrity" on Home Page
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #When User navigates to Request Label sub-menu under Price Integrity option
    #Then User should be able to see Scan Product page
    #And User selects Price Integrity Labelling System radio button option
    #And User searches for a item "<Item Name>" from toolbar
    #Then User should be able to see the item "<Item Name>" in search results
    #And User clicks on the item displayed in search result
    #Then User should be able to see the item description with label addition option and continue button
    #When User selects the label type and quantity then clicks on continue button
    #And User selects a stack
    #Then User should be able to see Scan Product page
     #
    #Examples:
      #| Item Name       |
      #| Gold Wrap & Tag |
#
  @sma
  Scenario: TC-29_Request Label - To verify Request Label screen gets closed with back button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Request Label sub-menu under Price Integrity option
    Then User presses on back button
    And User should be able to see the relevant sub-menus under Price Integrity
    And User Close the application

  @sma
  Scenario: TC-30_Request Label - To verify that user is able to close review screen with the up-navigation button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Request Label sub-menu under Price Integrity option
    Then User clicks on up-navigation button
    And User should be able to see the relevant sub-menus under Price Integrity
    And User Close the application


  ## Exceptions
  @sma
  Scenario: TC-32_Exceptions - To verify that user is able to view items under My Work tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Exceptions sub-menu under Price Integrity option
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on an item under My Work tab
    Then User should be able to see the details of item and close button

  @sma
  Scenario: TC-33_Exceptions - To verify that user is able to view items under My Store tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Exceptions sub-menu under Price Integrity option
    And User clicks on My Store tab
    Then User should be able to see items without any error
    And User clicks on an item under My Store tab
    Then User should be able to see the details of item and close button

  @sma
  Scenario: TC-34_Exceptions - To verify that user is able to close screen with the close button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Exceptions sub-menu under Price Integrity option
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on an item under My Work tab
    Then User should be able to see the details of item and close button
    When User clicks on close button on details page
    Then User should be able to see item under My Work tab

  @sma
  Scenario: TC-35_Exceptions - To verify user is able to apply filters on My work and My Store tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Exceptions sub-menu under Price Integrity option
    And User clicks on My Store tab
    Then User should be able to see items without any error
    And User clicks on filter and selects "Missing Label" filter
    Then User should be able to see items as per "Missing Label" filter condition
    And User clicks on My Work tab
    Then User should be able to see items without any error
    And User clicks on filter and selects "Missing Label" filter
    Then User should be able to see items as per "Missing Label" filter condition

  @sma
  Scenario: TC-36_Exceptions - To verify that user is able to close review screen with back button press
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Review sub-menu under Price Integrity option
    Then User presses on back button
    Then User should be able to see the relevant sub-menus under Price Integrity

  @sma
  Scenario: TC-37_Exceptions - To verify that user is able to close review screen with the up-navigation button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    Then User should be able to see the relevant sub-menus under Price Integrity
    When User navigates to Exceptions sub-menu under Price Integrity option
    Then User clicks on up-navigation button
    And User should be able to see the relevant sub-menus under Price Integrity

  @sma
  Scenario: TC-38_Exceptions - To verify user is able to apply filters on My work and My Store tab
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Price Integrity" on Home Page
    When User navigates to Exceptions sub-menu under Price Integrity option
    And User verify My Work tab is displayed
    And User navigate to My Work tab
    Then User verify Filter icon is displayed
    And User click on Filter icon
    And User verify filters popup is displayed
    Then User select filter option
    And verify selected filter items are displayed in item list
    And User verify My Store tab is displayed
    And User navigate to My Store tab
    Then User verify Filter icon is displayed
    And User click on Filter icon
    And User verify filters popup is displayed
    Then User select filter option
    And verify selected filter items are displayed in item list



#############SwipeLeft_EndingOffer
  #@sma
  #Scenario: TC-9_To check swipe left an item for Ending offers task in daily workload
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Ending Offers task
    #When User performs swipe left on item in task list
    #And Verify item is moved to bottom and undo option is displayed
    #And User presses on back button
    #And User checks item details under Ending Offers task
    #When User performs swipe left on item in task list
    #When User clicks on undo
    #Then Task should be moved back to its original position
#
  #############SwipeLeft_StartingOffer
  #@sma
  #Scenario: TC-10_To check swipe left an item for Starting offers task in daily workload
       #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Starting Offers task
    #When User performs swipe left on item in task list
    #And Verify item is moved to bottom and undo option is displayed
    #And User presses on back button
    #And User checks item details under Starting Offers task
    #When User performs swipe left on item in task list
    #When User clicks on undo
    #Then Task should be moved back to its original position
#
#
######################################### Barcode Scanning is required for below scenarios########################################################################
#
#
  #####@MPI-6250
  #@sma
  #Scenario: TC-26_Daily Workload - Request Label for Country of Origin
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #When User navigates to sub-menu under Price Integrity option
    #Then User should be able to see Scan Product page
    #And User selects EPISYS RES radio button option
    #And User searches for a item "<Item Name>" from toolbar
    #Then User should be able to see the item "<Item Name>" in search results
    #And User clicks on the item displayed in search result
    #Then User should be able to see the item description with label addition option and continue button
    #When User selects the label type and quantity then clicks on continue button
    #And User selects a stack
    #Then User should be able to see Scan Product page
#
    #Examples:
      #| Item Name       |
      #| Gold Wrap & Tag |
 #@sma
  #Scenario: TC-27_To verify that user is able to request adhoc label for an item with Request Label
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #When User navigates to Request Label sub-menu under Price Integrity option
    #Then User should be able to see Scan Product page
    #And User selects EPISYS RES radio button option
    #And User searches for a item "<Item Name>" from toolbar
    #Then User should be able to see the item "<Item Name>" in search results
    #And User clicks on the item displayed in search result
    #Then User should be able to see the item description with label addition option and continue button
    #When User selects the label type and quantity then clicks on continue button
    #Then User should be able to see Scan Product page
#
    #Examples:
      #| Item Name         |
      #| Breaded Mushrooms |
#
 ##### @Verification_ScanWrongBarcode
  #@sma
  #Scenario: TC-31_To check price verification fails on scanning Incorrect barcode
       #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #When User navigates to Verification sub-menu under Price Integrity option
    #And User scans an item with wrong barcode "<Barcode>"
    #Then User should be able to see an alert popup with product not found message
#
    #Examples:
      #| Barcode |
      #| 1111111 |
      #
 ##### @MPI-6535
  #@sma
  #Scenario: TC-39_Swipe task to the bottom of the list and raise exception
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #Then User should be able to see the relevant sub-menus under Business Critical
    #And User checks Overdue label is displayed next to the sub-menu items on the top
    #And User navigates to Price Increases sub-menu
    #And User scans an item "<MIN>"
    #And User selects an exception "<Exception>" in Workload
    #Then User clicks on complete check button
    #And User enters the description "Exception raised"
    #And User clicks on complete check button
    #And User presses on back button
    #And User verifies that the overdue task count has increased or decreased
#
    #Examples:
      #| MIN       | Exception       |
      #| 102467955 | Incorrect Price |
#
  #@sma
  #Scenario: TC-40_Swipe task to the bottom of the list and raise exception
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Starting Offers task
    #When User performs swipe left on item in task list
    #And Verify item is moved to bottom and undo option is displayed
    #And User presses on back button
    #And User checks item details under Ending Offers task
    #When User performs swipe left on item in task list
    #When User clicks on undo
    #Then Task should be moved back to its original position
    #And User presses on back button
    #And User checks item details under Ending Offers task
    #When User performs swipe right on item in task list
    #And Verify item is moved from task and missing Label exception is raised for same
#
 ##### @MobileApp2 @Smoke
  #@sma
  #Scenario: TC-41_To verify scanning of a barcode is working fine
     #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #When User navigates to Verification sub-menu under Price Integrity option
    #And User scans an item "<Barcode>"
    #And User enters price "300" in pences
    #And User clicks on verify button
    #When User clicks on submit button
#
    #Examples:
      #| Barcode   |
      #| 100453023 |
#
  #####@MPI-5400
  #@sma
  #Scenario: TC-42_Verify different GTIN types are supported properly
    #Pre requisite: There are products in some store of GTINS of following types EAN13, VPLUBC, VPLU, UPC-A, UCC14
#
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Starting Offers task
    #And User scans an item "<Barcode>"
#
    #Examples:
      #| Barcode              |
      #| input EAN13 barcode  |
      #| input VPLUBC barcode |
      #| input VPLU barcode   |
      #| input UPC-A barcode  |
      #| input UCC14 barcode  |
#
  #@sma
  #Scenario: TC-43_Verify different GTIN types are supported properly
    #Pre requisite: There are products in some store of GTINS of following types EAN13, VPLUBC, VPLU, UPC-A, UCC14
#
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Starting Offers task
    #And User scans an item "<Barcode>"
#
    #Examples:
      #| Barcode       |
      #| 5017690853828 |
      #| 0208160000000 |
#
  #@sma
  #Scenario: TC-44_If price increase task is Overdue, then products with overdue status should displayed in task list.
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #And User Click on the sub-menu items under Overdue menu
    #And User select the product category
    #Then User should be able to navigate to Price increase menu from Overdue menu
    #Then User verify for Products with Overdue status are displayed
#
  #@sma
  #Scenario: TC-45_If price decrease task is Overdue, then products with overdue status should displayed in task list
    #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #And User Click on the sub-menu items under Overdue menu
    #And User select the product category
    #Then User should be able to navigate to Price decrease menu from Overdue menu
    #Then User verify for Products with Overdue status are displayed
#
  #@sma
  #Scenario: TC-46_If Starting offers task is Overdue, then products with overdue status should displayed in task list
       #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #And User Click on the sub-menu items under Overdue menu
    #And User select the product category
    #Then User should be able to navigate to Starting offers menu from Overdue menu
    #Then User verify for Products with Overdue status are displayed
#
  #@sma
  #Scenario: TC-47_If Ending offers task is Overdue, then products with overdue status should displayed in task list
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #And User Click on the sub-menu items under Overdue menu
    #And User select the product category
    #Then User should be able to navigate to Ending offers menu from Overdue menu
    #Then User verify for Products with Overdue status are displayed
#
 ##### @MPI-4617
  #@sma
  #Scenario: TC-48_Verify user can review Workloads results
    #Pre-requisite: Scan of 2 products should be done via Workload 1 Successful and 1 Exception
#
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #When User navigates to Review sub-menu under Price Integrity option
    #And User clicks on My Store tab
    #Then User should be able to see items without any error
    #And User clicks on filter and selects "Missing Label" filter
    #Then User should be able to see items as per "Missing Label" filter condition
    #And User clicks on filter and selects "None" filter
    #Then User should be able to see items as per "None" filter condition
    #And User clicks on My Work tab
    #Then User should be able to see items without any error
    #And User clicks on filter and selects "Gap" filter
    #Then User should be able to see items as per "Gap" filter condition
    #And User clicks on filter and selects "None" filter
    #Then User should be able to see items as per "None" filter condition
#
#@sma
  #Scenario: TC-49_Daily workload - To verify Buisness critical - Price increase task is created and displayed
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #When User navigates to Price Increases sub-menu
    #Then User should be able to see task is present in the task list
#
#@sma
  #Scenario: TC-50_Daily workload - To verify Buisness critical - Price decrease task is created and displayed
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #When User navigates to Price decreases sub-menu
    #Then User should be able to see task is present in the task list
#
#@sma
  #Scenario: TC-51_Daily workload - To verify Price increase task is created and displayed
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #When User navigates to Price Increases sub-menu
    #Then User should be able to see task is present in the task list
#
#@sma
  #Scenario: TC-52_Daily workload - To verify Price decrease task is created and displayed
     #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #When User navigates to Price decreases sub-menu
    #Then User should be able to see task is present in the task list
#
#@sma
  #Scenario: TC-53_Daily workload - To verify Buisness critical - Starting offer task is created and displayed
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Starting Offers task
    #Then User should be able to see task is present in the task list
#
#@sma
  #Scenario: TC-54_Daily workload - To verify Buisness critical - Ending offer task is created and displayed
       #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Ending Offers task
    #Then User should be able to see task is present in the task list
#
#@sma
  #Scenario: TC-55_Daily workload - To verify Starting offer task is created and displayed
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks item details under Starting Offers task
    #Then User should be able to see task is present in the task list
#
#@sma
  #Scenario: TC-56_Daily workload - To verify  Ending offer task is created and displayed
       #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks item details under Ending Offers task
    #Then User should be able to see task is present in the task list
#
  #####@MPI-4769
  #@sma
  #Scenario: TC-57_Verify user can match new exception with already existing one
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #When User navigates to Verification sub-menu under Price Integrity option
    #And User scans an item "<MIN>"
    #And User enters price "100" in pences
    #And User clicks on verify button
    #And User expands the report exception panel
    #And User selects an exception "Other" in Verification
    #And User accepts the alert
    #And User selects an exception "Flash Marked" in Verification
    #And User selects an exception "Incorrect Unit Price" in Verification
    #When User clicks on submit button
    #And User enters the description "Exception raised"
    #And User clicks on raise button
    #And User enters the description "Exception raised"
    #And User clicks on raise button
    #And User enters the description "Exception raised"
    #And User clicks on raise button
    #And User clicks on save button
    #And User selects a label system
    #Then Select multiple label size
    #And User clicks on continue button
#
    #Examples:
      #| Barcode   |
      #| 100453023 |
#
 ##### @Verification_ScreenCheckWithCorrectBarcode
  #@sma
  #Scenario: TC-58_Price verification screen
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #When User navigates to Verification sub-menu under Price Integrity option
    #And User scans an item "<Barcode>"
    #And User enters price "300" in pences
    #And User expands the report exception panel
    #And User selects an exception "Flash Marked" in Verification
    #And User presses on back button
    #And User clicks on verify button
    #When User clicks on submit button
    #And User enters the description "Exception raised"
    #And User clicks on save button
    #Then User should be able to see item under review
    #When User opens the item under review
    #Then User can see right exception name "Flash Marked" and status
    #And User click on close button
    #Then User should be able to see item under review
#
    #Examples:
      #| Barcode   |
      #| 100453023 |
#
  #####@MPI-4618
  #@sma
  #Scenario: TC-59_Verify user can review Workloads Exceptions
    #Pre-requisite: At least few Workloads scans (1 successful and 2 with different Exceptions) have been done for some store
#
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #When User navigates to Exceptions sub-menu under Price Integrity option
    #And User clicks on My Store tab
    #Then User should be able to see items without any error
    #And User clicks on filter and selects "Missing Label" filter
    #Then User should be able to see items as per "Missing Label" filter condition
    #And User clicks on My Work tab
    #Then User should be able to see items without any error
    #And User clicks on filter and selects "Gap" filter
    #Then User should be able to see items as per "Gap" filter condition
    #And User clicks on filter and selects "All" filter
    #Then User should be able to see items as per "Gap" filter condition
    #Then User should be able to see items as per "Flash Marked" filter condition
    #Then User should be able to see items as per "Incorrect Price" filter condition
    #Then User should be able to see items as per "Incorrect Description" filter condition
    #Then User should be able to see items as per "Incorrect Unit Price" filter condition
#
 ##### @DailyWorkload_OverdueTask
  #@sma
  #Scenario: TC-60_To verify that different tasks are displayed under overdue tab in PIApp.
    #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Overdue menu
    #Then User should be able to see the relevant sub-menus under Overdue
#
 ##### @SwipeRight_EndingOffer
  #@sma
  #Scenario: TC-61_To check swipe right an item for Ending offers task in daily workload
      #	When I enter Username and Password for SMA Collegue user
#	    And I click on login button for SMA
    #When User checks the sub-menu items under Price Integrity menu
    #Then User should be able to see the relevant sub-menus under Price Integrity
    #And User checks the sub-menu items under Daily Workload menu
    #Then User should be able to see the relevant sub-menus under Daily Workload
    #And User checks the sub-menu items under Business Critical menu
    #And User checks item details under Ending Offers task
    #When User performs swipe right on item in task list
    #And Verify item is moved from task and missing Label exception is raised for same
