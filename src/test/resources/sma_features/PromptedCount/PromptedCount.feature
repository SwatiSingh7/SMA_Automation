@prompted_count @regression @store_walk
Feature: Verify Prompted Count functionality.(User story - SMA-28254, SMA-28253, SMA-28252, SMA-31421, SMA-31414, SMA-31425, SMA-31422)

########## Before starting execution , upload file in the S3 bucket.
########### File name with previous day date
###########  https://s3.console.aws.amazon.com/s3/buckets/msit.xxwmm.supplychain.freshcounts.eeeeeeeeee > promptedcountsexceptions > pending
###########################  Prompted counts will be performed from 6 AM - 9.45 AM.
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 06    | 01   | am       |


  @sma
  Scenario Outline: SMA-31414_Department_Location_Verify user is able to see one prompted item at a time.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify one prompted item is displayed

    Examples:
      | StoreID | Menu            | Department       | Location |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  |
      | 78      | Prompted Counts | Fresh            | Fixture  |
      | 78      | Prompted Counts | Market Street    | Fixture  |
      | 78      | Prompted Counts | Services         | Fixture  |
 
  
  ########################################## In below scenario, User story SMA-31427 scenarios are covered.
  @sma
  Scenario Outline: SMA-31430_Department_Verify Prompted item as Completed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Submenu>"
    Then I verify Action & Next steps screen is displayed
    And I verify Merchandising action tile is displayed on Action & Next steps page
    And I verify Print & Place Labels action tile is displayed on Action & Next steps page
    And I verify Merchandising action with count Zero when no action is captured
    And I verify Print and Place Labels with count Zero when no action is captured

    Examples:
      | StoreID | Menu            | Department       | Submenu              |
      | 78      | Prompted Counts | Ambient & Frozen | Actions & Next Steps |
      | 78      | Prompted Counts | Fresh            | Actions & Next Steps |
      | 78      | Prompted Counts | Market Street    | Actions & Next Steps |
      | 78      | Prompted Counts | Services         | Actions & Next Steps |
  
  ########################################### FIXTURE --> LOCATION ##################################################################################


  @sma
  Scenario Outline: SMA-31421_Department_Location_Verify labels preference should be displayed as Default, A4P White POS and Medium White POS.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Action>" Action label is displayed
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    And I verify Request Label screen UI
    And I verify "<Label1>", "<Label2>" and "<Label3>" labels are displayed

    Examples:
      | StoreID | Menu            | Department       | Location | Action                           | Quantity | Label1                    | Label2                      | Label3           |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  | Print and Place Shelf Edge Label | 5        | Default                   | A4P White POS               | Medium White POS |
      | 78      | Prompted Counts | Fresh            | Fixture  | Print and Place Shelf Edge Label | 5        | Medium White Label Bakery | Medium White No Price Label | A4P Bakery POS   |
      | 78      | Prompted Counts | Market Street    | Fixture  | Print and Place Shelf Edge Label | 5        | Default                   | A4P White POS               | Medium White POS |
      | 78      | Prompted Counts | Services         | Fixture  | Print and Place Shelf Edge Label | 5        | Default                   | A4P White POS               | Medium White POS |


  @sma
  Scenario Outline: SMA-31422_Department_Location_After clicking on History icon, verify History screen is displayed with list of completed products with total count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify History icon is displayed
    Then I click on History icon
    And I verify History screen is displayed with list of completed products with total count

    Examples:
      | StoreID | Menu            | Department       | Location |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  |
      | 78      | Prompted Counts | Fresh            | Fixture  |
      | 78      | Prompted Counts | Market Street    | Fixture  |
      | 78      | Prompted Counts | Services         | Fixture  |

  @sma
  Scenario Outline: SMA-31422_Department_Location_Select product on History screen and verify should be able to add action and edit stock count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    Then I verify History icon is displayed
    And I click on History icon
    Then I verify History screen is displayed with list of completed products with total count
    And I Select product on "<Location>" History screen
    Then I verify Edit button is displayed
    Then I click on Edit button
    And I edit stock count as "<Quantity1>"

    Examples:
      | StoreID | Menu            | Department       | Location | Quantity | Quantity1 | Action                   | Message                                                   | Option1       | Option2               |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  | 5        | 6         | Check Merchandising Plan | You have completed "<Location>" checks for "<Department>" | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Fresh            | Fixture  | 5        | 6         | Check Merchandising Plan | You have completed "<Location>" checks for "<Department>" | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Market Street    | Fixture  | 5        | 6         | Check Merchandising Plan | You have completed "<Location>" checks for "<Department>" | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Services         | Fixture  | 5        | 6         | Check Merchandising Plan | You have completed "<Location>" checks for "<Department>" | REVIEW & EDIT | CONTINUE TO WAREHOUSE |



  ############################################## In below scenario, User story SMA-31427 scenarios are covered.
  @sma
  Scenario Outline: SMA-31414_Department_Location_Verify user is able to view and select 2 actions "Check Merchandising Plan" and "Print & Place Shelf Edge Label" and should automatically add item in 'Actions & Next steps' under appropriate actions.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify details on Fixture screen
    And I verify "<Action>" Action label is displayed
    And I verify "<Action1>" Action label is displayed
    Then I click on "<Action>" Action label
    Then I click on "<Action1>" Action label
    And I enter qty "<Quantity>" and click on Confirm button

    Then I select Label size
    And I click on Continue Button on Request label page

    And I click on Back Button
    Then I click on "<Submenu>"
    And I click on Merchandising on Action & Next steps page
    Then I verify details on Merchandising screen
    And I click on Back Button
    Then I click on Print & Place Labels on Action & Next steps page
    And I verify Print & Place Labels screen is displayed
    Then I verify details on Print & Place Labels screen

    Examples:
      | StoreID | Menu            | Department       | Location | Quantity | Submenu              | Action                           | Action1                  | selectAction         | selectAction1 |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Fresh            | Fixture  | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Market Street    | Fixture  | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Services         | Fixture  | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |

  @sma
  Scenario Outline: SMA-31414_Department_Location_Select department then select product and verify user is able to select 1 actions out of "Check Merchandising Plan" and "Print & Place Shelf Edge Label".
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Action>" Action label is displayed
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button

    Examples:
      | StoreID | Menu            | Department       | Location | Quantity | Action                           |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  | 5        | Print and Place Shelf Edge Label |
      | 78      | Prompted Counts | Fresh            | Fixture  | 5        | Print and Place Shelf Edge Label |
      | 78      | Prompted Counts | Market Street    | Fixture  | 5        | Check Merchandising Plan         |
      | 78      | Prompted Counts | Services         | Fixture  | 5        | Check Merchandising Plan         |


################ In below scenarios US SMA-31431, SMA-31432 and SMA-31433 are covered.
  @sma
  Scenario Outline: SMA-31429_Department_Location_Verify Actions & Next Steps - Print & place label - Place Label functionality.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Action>" Action label is displayed
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    Then I verify Request Label screen UI
    And I click on Continue Button on Request label page
    And I click on Back Button
    Then I click on "<Submenu>"
    Then I verify Action & Next steps screen is displayed
    And I verify Print & Place Labels action tile is displayed on Action & Next steps page
    And I click on Print & Place Labels on Action & Next steps page
    Then I verify Print & Place Labels screen is displayed
    And I verify details on Print & Place Labels screen
    Then I click on Place labels button
    Then I verify Place labels screen with Product details are displayed

    Examples:
      | StoreID | Menu            | Department       | Location | Submenu              | Quantity | Action                           | LabelSize                 |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Default                   |
      | 78      | Prompted Counts | Fresh            | Fixture  | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Medium White Label Bakery |
      | 78      | Prompted Counts | Market Street    | Fixture  | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Medium White POS          |
      | 78      | Prompted Counts | Services         | Fixture  | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Default                   |


  @sma
  Scenario Outline: SMA-31422_Department_Location_Complete the Location and Message is displayed after completion of location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify Item list count is displayed
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I verify "<Message>" message is displayed

    Examples:
      | StoreID | Menu            | Department       | Location | Quantity | Message                                                |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  | 5        | You have completed Fixture checks for Ambient & Frozen |
      | 78      | Prompted Counts | Fresh            | Fixture  | 5        | You have completed Fixture checks for Fresh            |
      | 78      | Prompted Counts | Market Street    | Fixture  | 5        | You have completed Fixture checks for Market Street    |
      | 78      | Prompted Counts | Services         | Fixture  | 5        | You have completed Fixture checks for Services         |

  @sma
  Scenario Outline: SMA-31422_Department_Location_After clicking on "REVIEW & EDIT", verify History screen is displayed with list of completed products with total count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count

    Examples:
      | StoreID | Menu            | Department       | Location | Message                                                |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture  | You have completed Fixture checks for Ambient & Frozen |
      | 78      | Prompted Counts | Fresh            | Fixture  | You have completed Fixture checks for Fresh            |
      | 78      | Prompted Counts | Market Street    | Fixture  | You have completed Fixture checks for Market Street    |
      | 78      | Prompted Counts | Services         | Fixture  | You have completed Fixture checks for Services         |

  ########################################### OFFSHELF / PETROL --> LOCATION ##################################################################################
  
  ###############  Scenarios --> 18 to 46
  @sma
  Scenario Outline: SMA-31421_Department_Location_Verify labels preference should be displayed as Default, A4P White POS and Medium White POS.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Action>" Action label is displayed
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    And I verify Request Label screen UI
    And I verify "<Label1>", "<Label2>" and "<Label3>" labels are displayed

    Examples:
      | StoreID | Menu            | Department       | Location  | Action                           | Quantity |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | Print and Place Shelf Edge Label | 5        |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | Print and Place Shelf Edge Label | 5        |
      | 78      | Prompted Counts | Fresh            | Off Shelf | Print and Place Shelf Edge Label | 5        |
      | 78      | Prompted Counts | Fresh            | Petrol    | Print and Place Shelf Edge Label | 5        |
      | 78      | Prompted Counts | Market Street    | Off Shelf | Print and Place Shelf Edge Label | 5        |
      | 78      | Prompted Counts | Market Street    | Petrol    | Print and Place Shelf Edge Label | 5        |
      | 78      | Prompted Counts | Services         | Off Shelf | Print and Place Shelf Edge Label | 5        |
      | 78      | Prompted Counts | Services         | Petrol    | Print and Place Shelf Edge Label | 5        |

  @sma
  Scenario Outline: SMA-31422_Department_Location_Complete the Location and Message is displayed after completion of location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify Item list count is displayed
    Then I enter qty "<Quantity>" and click on Confirm button
    And I verify "<Message>" message is displayed

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Message                                                  |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | 5        | You have completed Off Shelf checks for Ambient & Frozen |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | 5        | You have completed Petrol checks for Ambient & Frozen    |
      | 78      | Prompted Counts | Fresh            | Off Shelf | 5        | You have completed Off Shelf checks for Fresh            |
      | 78      | Prompted Counts | Fresh            | Petrol    | 5        | You have completed Petrol checks for Fresh               |
      | 78      | Prompted Counts | Market Street    | Off Shelf | 5        | You have completed Off Shelf checks for Market Street    |
      | 78      | Prompted Counts | Market Street    | Petrol    | 5        | You have completed Petrol checks for Market Street       |
      | 78      | Prompted Counts | Services         | Off Shelf | 5        | You have completed Off Shelf checks for Services         |
      | 78      | Prompted Counts | Services         | Petrol    | 5        | You have completed Petrol checks for Services            |

  @sma
  Scenario Outline: SMA-31422_Department_Location_After clicking on "REVIEW & EDIT", verify History screen is displayed with list of completed products with total count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Message                                                  | Option1       | Option2               |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | 5        | You have completed Off Shelf checks for Ambient & Frozen | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | 5        | You have completed Petrol checks for Ambient & Frozen    | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Fresh            | Off Shelf | 5        | You have completed Off Shelf checks for Fresh            | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Fresh            | Petrol    | 5        | You have completed Petrol checks for Fresh               | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Market Street    | Off Shelf | 5        | You have completed Off Shelf checks for Market Street    | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Market Street    | Petrol    | 5        | You have completed Petrol checks for Market Street       | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Services         | Off Shelf | 5        | You have completed Off Shelf checks for Services         | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Services         | Petrol    | 5        | You have completed Petrol checks for Services            | REVIEW & EDIT | CONTINUE TO WAREHOUSE |

  @sma
  Scenario Outline: SMA-31422_Department_Location_Select product on History screen and verify should be able to add action and edit stock count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count
    Then I Select product on "<Location>" History screen
    Then I verify Edit button is displayed
    Then I click on Edit button
    And I add action and edit stock count as "<Quantity1>"

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Quantity1 | Message                                                  | Option1       | Option2               |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | 5        | 6         | You have completed Off Shelf checks for Ambient & Frozen | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | 5        | 6         | You have completed Petrol checks for Ambient & Frozen    | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Fresh            | Off Shelf | 5        | 6         | You have completed Off Shelf checks for Fresh            | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Fresh            | Petrol    | 5        | 6         | You have completed Petrol checks for Fresh               | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Market Street    | Off Shelf | 5        | 6         | You have completed Off Shelf checks for Market Street    | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Market Street    | Petrol    | 5        | 6         | You have completed Petrol checks for Market Street       | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Services         | Off Shelf | 5        | 6         | You have completed Off Shelf checks for Services         | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Services         | Petrol    | 5        | 6         | You have completed Petrol checks for Services            | REVIEW & EDIT | CONTINUE TO WAREHOUSE |

  @sma
  Scenario Outline: SMA-31422_Department_Location_After clicking on History icon, verify History screen is displayed with list of completed products with total count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify History icon is displayed
    Then I click on History icon
    And I verify History screen is displayed with list of completed products with total count

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Message                                                  |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | 5        | You have completed Off Shelf checks for Ambient & Frozen |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | 5        | You have completed Petrol checks for Ambient & Frozen    |
      | 78      | Prompted Counts | Fresh            | Off Shelf | 5        | You have completed Off Shelf checks for Fresh            |
      | 78      | Prompted Counts | Fresh            | Petrol    | 5        | You have completed Petrol checks for Fresh               |
      | 78      | Prompted Counts | Market Street    | Off Shelf | 5        | You have completed Off Shelf checks for Market Street    |
      | 78      | Prompted Counts | Market Street    | Petrol    | 5        | You have completed Petrol checks for Market Street       |
      | 78      | Prompted Counts | Services         | Off Shelf | 5        | You have completed Off Shelf checks for Services         |
      | 78      | Prompted Counts | Services         | Petrol    | 5        | You have completed Petrol checks for Services            |

  @sma
  Scenario Outline: SMA-31414_Department_Location_Verify user is able to see one prompted item at a time.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify one prompted item is displayed

    Examples:
      | StoreID | Menu            | Department       | Location  |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    |
      | 78      | Prompted Counts | Fresh            | Off Shelf |
      | 78      | Prompted Counts | Fresh            | Petrol    |
      | 78      | Prompted Counts | Market Street    | Off Shelf |
      | 78      | Prompted Counts | Market Street    | Petrol    |
      | 78      | Prompted Counts | Services         | Off Shelf |
      | 78      | Prompted Counts | Services         | Petrol    |

  @sma
  Scenario Outline: SMA-31414_Department_Location_Verify user is able to view and select 2 actions "Check Merchandising Plan" and "Print & Place Shelf Edge Label" and should automatically add item in 'Actions & Next steps' under appropriate actions.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Action>" Action label is displayed
    And I verify "<Action1>" Action label is displayed
    Then I click on "<Action>" Action label
    Then I click on "<Action1>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    And I click on Back Button

    Then I click on "<Submenu>"
    Then I click on Merchandising on Action & Next steps page
    Then I verify Summary screen UI
    And I verify product is displayed in "<selectAction>" list
    Then I click on Print & Place Labels on Action & Next steps page
    Then I verify Summary screen UI
    And I verify product is displayed in "<selectAction1>" list
    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Submenu              | Action                           | Action1                  | selectAction         | selectAction1 |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Fresh            | Off Shelf | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Fresh            | Petrol    | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Market Street    | Off Shelf | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Market Street    | Petrol    | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Services         | Off Shelf | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |
      | 78      | Prompted Counts | Services         | Petrol    | 5        | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Print & Place Labels | Merchandising |

  @sma
  Scenario Outline: SMA-31414_Department_Location_Select department then select product and verify user is able to select 1 actions out of "Check Merchandising Plan" and "Print & Place Shelf Edge Label".
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Action>" Action label is displayed
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Action                           |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | 5        | Print and Place Shelf Edge Label |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | 5        | Check Merchandising Plan         |
      | 78      | Prompted Counts | Fresh            | Off Shelf | 5        | Print and Place Shelf Edge Label |
      | 78      | Prompted Counts | Fresh            | Petrol    | 5        | Check Merchandising Plan         |
      | 78      | Prompted Counts | Market Street    | Off Shelf | 5        | Check Merchandising Plan         |
      | 78      | Prompted Counts | Market Street    | Petrol    | 5        | Print and Place Shelf Edge Label |
      | 78      | Prompted Counts | Services         | Off Shelf | 5        | Check Merchandising Plan         |
      | 78      | Prompted Counts | Services         | Petrol    | 5        | Print and Place Shelf Edge Label |

  @sma
  Scenario Outline: SMA-31429_Department_Location_Verify Actions & Next Steps - Print & place label - Place Label functionality.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Menu>"
    Then I click on "<Location>"
    And I verify "<Action>" is displayed
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    Then I verify Request Label screen UI
    And I select "<LabelSize>" Label size
    Then I click on Continue Button on Request label page
    And I click on Back Button
    Then I click on "<Submenu>"
    Then I verify Action & Next steps screen is displayed
    And I click on Print & Place Labels
    Then I verify Print & Place Labels screen is displayed
    And I click on Place labels button
    Then I verify Place labels screen
    Then I click on Confirm button
    And I verify Print & place label is displayed with status as Completed

    Examples:
      | StoreID | Menu            | Department       | Location  | Submenu              | Quantity | Action                           | LabelSize        |
      | 78      | Prompted Counts | Ambient & Frozen | Off Shelf | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | A4P White POS    |
      | 78      | Prompted Counts | Ambient & Frozen | Petrol    | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Medium White POS |
      | 78      | Prompted Counts | Fresh            | Off Shelf | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Medium White POS |
      | 78      | Prompted Counts | Fresh            | Petrol    | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Default          |
      | 78      | Prompted Counts | Market Street    | Off Shelf | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Default          |
      | 78      | Prompted Counts | Market Street    | Petrol    | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | A4P White POS    |
      | 78      | Prompted Counts | Services         | Off Shelf | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | A4P White POS    |
      | 78      | Prompted Counts | Services         | Petrol    | Actions & Next Steps | 5        | Print and Place Shelf Edge Label | Medium White POS |

  ############################################ WAREHOUSE --> LOCATION ##################################################################################

  @sma
  Scenario Outline: SMA-31414_Department_Location_Verify user is able to see one prompted item at a time.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify one prompted item is displayed

    Examples:
      | StoreID | Menu            | Department       | Location  |
      | 78      | Prompted Counts | Ambient & Frozen | Warehouse |
      | 78      | Prompted Counts | Fresh            | Warehouse |
      | 78      | Prompted Counts | Market Street    | Warehouse |
      | 78      | Prompted Counts | Services         | Warehouse |


  @sma
  Scenario Outline: SMA-31422_Department_Location_Complete the Location and Message is displayed after completion of location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify Item list count is displayed
    Then I verify details on Warehouse screen
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I verify "<Message>" message is displayed

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Message                                                  |
      | 78      | Prompted Counts | Ambient & Frozen | Warehouse | 5        | You have completed Warehouse checks for Ambient & Frozen |
      | 78      | Prompted Counts | Fresh            | Warehouse | 5        | You have completed Warehouse checks for Fresh            |
      | 78      | Prompted Counts | Market Street    | Warehouse | 5        | You have completed Warehouse checks for Market Street    |
      | 78      | Prompted Counts | Services         | Warehouse | 5        | You have completed Warehouse checks for Services         |

  @sma
  Scenario Outline: SMA-31422_Department_Location_After clicking on "REVIEW & EDIT", verify History screen is displayed with list of completed products with total count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Message                                                  | Option1       | Option2               |
      | 78      | Prompted Counts | Ambient & Frozen | Warehouse | 5        | You have completed Warehouse checks for Ambient & Frozen | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Fresh            | Warehouse | 5        | You have completed Warehouse checks for Fresh            | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Market Street    | Warehouse | 5        | You have completed Warehouse checks for Market Street    | REVIEW & EDIT | CONTINUE TO WAREHOUSE |
      | 78      | Prompted Counts | Services         | Warehouse | 5        | You have completed Warehouse checks for Services         | REVIEW & EDIT | CONTINUE TO WAREHOUSE |

  @sma
  Scenario Outline: SMA-31422_Department_Location_Select product on History screen and verify should be able to add action and edit stock count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count
    Then I Select product on "<Location>" History screen
    Then I verify Edit button is displayed
    Then I click on Edit button
    And I add action and edit stock count as "<Quantity1>"

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Quantity1 | Message                                                  |
      | 78      | Prompted Counts | Ambient & Frozen | Warehouse | 5        | 6         | You have completed Warehouse checks for Ambient & Frozen |
      | 78      | Prompted Counts | Fresh            | Warehouse | 5        | 6         | You have completed Warehouse checks for Fresh            |
      | 78      | Prompted Counts | Market Street    | Warehouse | 5        | 6         | You have completed Warehouse checks for Market Street    |
      | 78      | Prompted Counts | Services         | Warehouse | 5        | 6         | You have completed Warehouse checks for Services         |

  @sma
  Scenario Outline: SMA-31422_Department_Location_After clicking on History icon, verify History screen is displayed with list of completed products with total count.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify History icon is displayed
    Then I click on History icon
    And I verify History screen is displayed with list of completed products with total count

    Examples:
      | StoreID | Menu            | Department       | Location  | Quantity | Message                                                  |
      | 78      | Prompted Counts | Ambient & Frozen | Warehouse | 5        | You have completed Warehouse checks for Ambient & Frozen |
      | 78      | Prompted Counts | Fresh            | Warehouse | 5        | You have completed Warehouse checks for Fresh            |
      | 78      | Prompted Counts | Market Street    | Warehouse | 5        | You have completed Warehouse checks for Market Street    |
      | 78      | Prompted Counts | Services         | Warehouse | 5        | You have completed Warehouse checks for Services         |


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 16   | am       |

  @sma
  Scenario Outline: SMA-30760_Verify that user able to view Deadline Reminder prompt before half an hour in prompted counts
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<alertName>" alert title is displayed
    And I verify "<alertMessage>" alert message  is displayed

    Examples:
      | StoreID | Menu            | Department       | Location             | alertName         | alertMessage                                                      |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Ambient & Frozen | Off Shelf           | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Ambient & Frozen | Petrol              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Ambient & Frozen | Warehouse            | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Ambient & Frozen | Actions & Next Steps | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Fresh            | Fixture              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Fresh            | Off Shelf           | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Fresh            | Petrol              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Fresh            | Warehouse            | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Fresh            | Actions & Next Steps | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Market Street    | Fixture              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Market Street    | Off Shelf           | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Market Street    | Petrol              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Market Street    | Warehouse            | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Market Street    | Actions & Next Steps | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Services         | Fixture              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Services         | Off Shelf           | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      #####################|      78 | Prompted Counts | Services         | Petrol              | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Services         | Warehouse            | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |
      | 78      | Prompted Counts | Services         | Actions & Next Steps | Deadline Reminder | Submissions must be completed prior to the 09:45 AM daily cutoff. |


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 46   | am       |

  @sma
  Scenario Outline: SMA-30760_Verify that Post 9.45 AM when user try to click on any department or action, it should display message as 'Prompted counts submissions closed'.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify "<messageTitle>" message title is displayed
    And I verify "<messageText>" message text is displayed

    Examples:
      | StoreID | Menu            | Department       | Location             | messageTitle                       | messageText                                                                                                                                             |
      | 78      | Prompted Counts | Ambient & Frozen | Fixture              | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      ####################|      78 | Prompted Counts | Ambient & Frozen | Off Shelf           | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
     ###################|      78 | Prompted Counts | Ambient & Frozen | Petrol              |Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
      | 78      | Prompted Counts | Ambient & Frozen | Warehouse            | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      | 78      | Prompted Counts | Ambient & Frozen | Actions & Next Steps | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      | 78      | Prompted Counts | Fresh            | Fixture              | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
    ###################|      78 | Prompted Counts | Fresh            |Off Shelf            | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
    ###################|      78 | Prompted Counts | Fresh            | Petrol              | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
      | 78      | Prompted Counts | Fresh            | Warehouse            | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      | 78      | Prompted Counts | Fresh            | Actions & Next Steps | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      | 78      | Prompted Counts | Market Street    | Fixture              | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
     ###################|      78 | Prompted Counts | Market Street    | Off Shelf           |Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
      ####################|      78 | Prompted Counts | Market Street    | Petrol              |Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
      | 78      | Prompted Counts | Market Street    | Warehouse            | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      | 78      | Prompted Counts | Market Street    | Actions & Next Steps | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      | 78      | Prompted Counts | Services         | Fixture              | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
     ###################|      78 | Prompted Counts | Services         | Off Shelf 					|Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
      ###################|      78 | Prompted Counts | Services         | Petrol              |Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off.|
      | 78      | Prompted Counts | Services         | Warehouse            | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      | 78      | Prompted Counts | Services         | Actions & Next Steps | Prompted counts submissions closed | You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off. |
      #

  @sma
  Scenario Outline: SMA-30760_Verify Only Summary should be available for view throughout the day.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Location>"
    And I verify Summary screen UI

    Examples:
      | StoreID | Menu            | Location |
      | 78      | Prompted Counts | Summary  |
