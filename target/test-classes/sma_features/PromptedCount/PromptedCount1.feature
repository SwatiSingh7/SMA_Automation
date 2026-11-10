@prompted_count @regression @store_walk
Feature: Verify Prompted Counts functionality

 ############firstly Upload file before 6AM BST in S3 Bucket
 ######In Storewalk DB Update below query for getting current Stock record and large adjustment value
 #######Replace walk_id of your store below('')
 ########select * from walkitem where walk_id in('20220112830051592')
 ######update walkitem set qty_on_hand='100' where walk_id in('20220112830051592')
 #######update walkitem set stock_state='fresh' where walk_id in('20220112830051592')
 #######update walkitem set soh_value='100' where walk_id in('20220112830051592')


  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 7     | 48   | am       |

  #######################################################SMA-31447#######################################################
  @sma
  Scenario Outline: SMA-31447TC_02 Verify user able to voew all locations and departments
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Department>" is displayed
    And I verify "<Department1>" is displayed
    And I verify "<Department2>" is displayed
    And I verify "<Department3>" is displayed
    Then I click on "<Department>"
    And I verify "<Location>" is displayed
    And I verify "<Location1>" is displayed
    And I verify "<Location2>" is displayed
    And I verify "<Location3>" is displayed

    Examples:
      | Menu            | Department       | Department1 | Department2   | Department3 | Location | Location1 | Location2 | Location3 |
      | Prompted Counts | Ambient & Frozen | Fresh       | Market Street | Services    | Fixture  | Off Shelf | Petrol    | Warehouse |

  @sma
  Scenario Outline: SMA-31447TC_01,06,11,16Verify user able to view Prompt at Location of Department
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I Verify Prompte is displayed at "<Location>"

    Examples:
      | Menu            | Department       | Location |
      | Prompted Counts | Ambient & Frozen | Fixture  |
      | Prompted Counts | Fresh            | Fixture  |
      | Prompted Counts | Market Street    | Fixture  |
      | Prompted Counts | Services         | Fixture  |

  @sma
  Scenario Outline: SMA-31447TC_02,07,12,17Verify user able to view at Location of Department  'location not completed' message and 'continue' button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I view and click on Button "<Button>"
    And I Verify prompted item navigated to "<Previouslocation>"

    Examples:
      | Menu            | Department       | Location  | Message                                  | Button              | Previouslocation |
      | Prompted Counts | Ambient & Frozen | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |
  ###  | Prompted Counts | Fresh            | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE |Fixture|
  #### | Prompted Counts | Market Street    | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture|
  #### | Prompted Counts | Services         | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture|
  @sma
  Scenario Outline: SMA-31447TC_03,08,13,18  Verify user able to view at Location of Department  'location not completed' message and 'continue' button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I view and click on Button "<Button>"
    And I Verify prompted item navigated to "<Previouslocation>"

    Examples:
      | Menu            | Department | Location | Message                                  | Button              | Previouslocation |
      ### | Prompted Counts | Ambient & Frozen | Petrol   | Fixture location has not been completed. | CONTINUE TO FIXTURE|Fixture|
      ##| Prompted Counts | Fresh            | Petrol   | Fixture location has not been completed. | CONTINUE TO FIXTURE |Fixture|
      ##| Prompted Counts | Market Street    | Petrol   |Fixture location has not been completed. |CONTINUE TO FIXTURE |Fixture|
      | Prompted Counts | Services   | Petrol   | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |

  @sma
  Scenario Outline: SMA-31447TC_04,09,14,19Verify user able to view at Location of Department  'location not completed' message and 'continue' button
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I view and click on Button "<Button>"
    And I Verify prompted item navigated to "<Previouslocation>"

    Examples:
      | Menu            | Department       | Location  | Message                                  | Button              | Previouslocation |
      | Prompted Counts | Ambient & Frozen | Warehouse | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Prompted Counts | Fresh            | Warehouse | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Prompted Counts | Market Street    | Warehouse | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Prompted Counts | Services         | Warehouse | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |

    ######################################################################US31448###################################
   #When No item is actioned in Prompted Count
  @sma
  Scenario Outline: TC_US31448 Department_Location Verify user should able to view blank history when No item is actioned in Prompted Count
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I Verify Prompte is displayed at "<Location>"
    Then I click on icon "<Icon>"
    And I see "<Header>"
    And I Verify Prompt "<Message>" is displayed at "<Location>"

    Examples:
      | Menu            | Department       | Location | Icon      | Header          | Message            |
      | Prompted Counts | Ambient & Frozen | Fixture  | Show List | Fixture History | No Items Available |
      | Prompted Counts | Fresh            | Fixture  | Show List | Fixture History | No Items Available |
      | Prompted Counts | Market Street    | Fixture  | Show List | Fixture History | No Items Available |
      | Prompted Counts | Services         | Fixture  | Show List | Fixture History | No Items Available |

  @sma
  Scenario Outline: TC_US31448 Department_Location Verify user should able to view blank history when no item is actioned in Prompted Count
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I Verify Prompt "<Message1>" is displayed at "<Location>"
    And I see "<Button1>"
    Then I click on icon "<Icon>"
    And I see "<Header>"
    And I Verify Prompt "<Message>" is displayed at "<Location>"

    Examples:
      | Menu            | Department       | Location  | Icon      | Header            | Message            | Message1                                 | Button1             |
      | Prompted Counts | Ambient & Frozen | Off Shelf | Show List | Off Shelf History | No Items Available | Fixture location has not been completed. | CONTINUE TO FIXTURE |
      | Prompted Counts | Ambient & Frozen | Warehouse | Show List | Warehouse History | No Items Available | Fixture location has not been completed. | CONTINUE TO FIXTURE |
  ######| Prompted Counts | Ambient & Frozen | Petrol		 | Show List | Petrol History | No Items Available | Fixture location has not been completed.				|CONTINUE TO FIXTURE |
  ###### | Prompted Counts | Fresh | Off Shelf | Show List | Off Shelf History | No Items Available |Fixture location has not been completed.      | CONTINUE TO FIXTURE|
      | Prompted Counts | Fresh            | Warehouse | Show List | Warehouse History | No Items Available | Fixture location has not been completed. | CONTINUE TO FIXTURE |
      | Prompted Counts | Market Street    | Warehouse | Show List | Warehouse History | No Items Available | Fixture location has not been completed. | CONTINUE TO FIXTURE |
      | Prompted Counts | Services         | Petrol    | Show List | Petrol History    | No Items Available | Fixture location has not been completed. | CONTINUE TO FIXTURE |
      | Prompted Counts | Services         | Warehouse | Show List | Warehouse History | No Items Available | Fixture location has not been completed. | CONTINUE TO FIXTURE |
 ################################################################################RUN2#############################################
  @sma
  Scenario Outline: TC_US31448 Verify user is allowed to edit from history on completion few items at Location of Department
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I enter "<StockQuantity>"
    Then I click on the Confirm Button
    Then I click on icon "<Icon>"
    And I see "<Header>"
    And I select item from history list to edit
    And I click on Edit button
    And I enter "<updatedStockQuantity>"
    Then I click on the Confirm Button
    And I verify "<Header>" count Updated same as "<updatedStockQuantity>"

    Examples:
      | Menu            | Department | Location | Icon      | Header          | updatedStockQuantity | StockQuantity |
      | Prompted Counts | Fresh      | Fixture  | Show List | Fixture History | 200                  | 10            |
 ## | Prompted Counts | Ambient & Frozen | Off Shelf | Show List | Off Shelf History |                  200 |            10 |
  #######| Prompted Counts | Ambient & Frozen | Petrol    | Show List | Petrol History    |                  200 |            10 |
  ##| Prompted Counts | Ambient & Frozen | Warehouse | Show List | Warehouse History |                  500 |            10 |

  @sma
  Scenario Outline: SMA-31447TC_21,22,23,24Verify user able to complete all prompts at Location for Department
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify Prompt Screen all details
    And I enter "<StockQuantity>"
    And I mark product as flag
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I click on Back Button
    And I verify status as "<Status>"

    Examples:
      | Menu            | Department       | Location | StockQuantity | Message                                                | Status   |
      | Prompted Counts | Ambient & Frozen | Fixture  | 100           | You have completed Fixture checks for Ambient & Frozen | COMPLETE |
      ######| Prompted Counts | Ambient & Frozen | Off Shelf |        100 | You have completed Off Shelf checks for Ambient & Frozen | COMPLETE |
     #####| Prompted Counts | Ambient & Frozen | Petrol    |        100 | You have completed Petrol checks for Ambient & Frozen | COMPLETE |
      ####| Prompted Counts | Ambient & Frozen | Warehouse |            100 | You have completed Warehouse checks for Ambient & Frozen | COMPLETE |

  @sma
  Scenario Outline: SMA-31447TC_25,26,27,28 Verify user able to complete all prompts at Location for Department
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify Prompt Screen all details
    And I enter "<StockQuantity>"
    Then I click on the Confirm Button
    And I complete all prompted items
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I click on Back Button
    And I verify status as "<Status>"

    Examples:
      | Menu            | Department | Location  | StockQuantity | Message                                       | Status   |
      | Prompted Counts | Fresh      | Fixture   | 999           | You have completed Fixture checks for Fresh   | COMPLETE |
     ###| Prompted Counts | Fresh      | Off Shelf |            500 | You have completed Off Shelf checks for Fresh | COMPLETE |
     ###| Prompted Counts | Fresh  | Petrol    |            500| You have completed Petrol checks for Fresh | COMPLETE |
      | Prompted Counts | Fresh      | Warehouse | 999           | You have completed Warehouse checks for Fresh | COMPLETE |

  @sma
  Scenario Outline: SMA-31447TC_29,30,31,32 Verify user able to complete all prompts at Location for Department
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I verify Prompt Screen all details
    And I enter "<StockQuantity>"
    Then I click on the Confirm Button
    And I enter "<StockQuantity>"
    Then I click on the Confirm Button
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I click on Back Button
    And I verify status as "<Status>"

    Examples:
      | Menu            | Department    | Location  | StockQuantity | Message                                               | Status   |
      | Prompted Counts | Market Street | Fixture   | 999           | You have completed Fixture checks for Market Street   | COMPLETE |
      ###| Prompted Counts | Market Street | Off Shelf |           999 | You have completed Off Shelf checks for Market Street | COMPLETE|
      ###| Prompted Counts | Market Street | Petrol    |           999 | You have completed Petrol checks for Market Street | COMPLETE |
      | Prompted Counts | Market Street | Warehouse | 999           | You have completed Warehouse checks for Market Street | COMPLETE |

  @sma
  Scenario Outline: SMA-31447TC_33,34,35,36 Verify user able to flag all prompts at Location for Department
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    And I mark product as flag
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I click on Back Button
    And I verify status as "<Status>"

    Examples:
      | Menu            | Department | Location | StockQuantity | Message                                        | Status   |
      | Prompted Counts | Services   | Fixture  | 500           | You have completed Fixture checks for Services | COMPLETE |
      #####| Prompted Counts | Services   | Off Shelf |            500 | You have completed Off Shelf checks for Services | COMPLETE |
     #### | Prompted Counts | Services   | Petrol    |            500 | You have completed Petrol checks for Services| COMPLETE |
     ####| Prompted Counts | Services   | Warehouse |            500| You have completed Warehouse checks for Services | COMPLETE |

  ########################################################SMA-31446#######################################################
  @sma
  Scenario Outline: SMA31446 TC_02 Department_Location Verify user is allow to edit any prompted item by updating stock counts or adding action
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    Then I click on "<Action>"
    And I verify edit is allowed by updating Stock "<StockQuantity>" at "<Location>"

    Examples:
      | Menu            | Department    | Location | Action        | StockQuantity |
      ########| Prompted Counts | Ambient & Frozen | Fixture   | REVIEW & EDIT |           520 |
      | Prompted Counts | Fresh         | Fixture  | REVIEW & EDIT | 920           |
      | Prompted Counts | Market Street | Fixture  | REVIEW & EDIT | 920           |
     ######## | Prompted Counts | Services         | Fixture   | REVIEW & EDIT |           520 |
      ###| Prompted Counts | Ambient & Frozen | Off Shelf | REVIEW & EDIT |           520 |
      ###| Prompted Counts | Fresh            | Off Shelf | REVIEW & EDIT |           920 |
      ###| Prompted Counts | Market Street    | Off Shelf | REVIEW & EDIT |           920 |
      ###| Prompted Counts | Services         | Off Shelf | REVIEW & EDIT |           520 |
      ###| Prompted Counts | Ambient & Frozen | Petrol    | REVIEW & EDIT |           520 |
      ###| Prompted Counts | Fresh            | Petrol    | REVIEW & EDIT |           920 |
      ###| Prompted Counts | Market Street    | Petrol    | REVIEW & EDIT |           920 |
     #####| Prompted Counts | Services         | Petrol    | REVIEW & EDIT |           520 |

  @sma
  Scenario Outline: SMA31446 TC_03 Department_Location Verify user unflagged items should be allowed to update count or action from REVIEW & EDIT screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    Then I click on "<Action>"
    And I verify unflagged items allowed to update count or action

    Examples:
      | Menu            | Department    | Location | Action        | StockQuantity |
      ####| Prompted Counts | Ambient & Frozen | Fixture   | REVIEW & EDIT |       520 |
      | Prompted Counts | Fresh         | Fixture  | REVIEW & EDIT | 920           |
      | Prompted Counts | Market Street | Fixture  | REVIEW & EDIT | 920           |
     ###| Prompted Counts | Services         | Fixture   | REVIEW & EDIT |           520 |
    ###| Prompted Counts | Ambient & Frozen | Off Shelf | REVIEW & EDIT |           520 |
    ###| Prompted Counts | Services         | Petrol    | REVIEW & EDIT |           520 |


  @sma
  Scenario Outline: SMA31446 TC_04 Department_Location Verify user Flagged items are allowed add action with reflagging in REVIEW & EDIT screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    Then I click on "<Department>"
    Then I click on "<Location>"
    Then I click on "<Action>"
    And I verify flagged items are allowed  to add action with reflagging

    Examples:
      | Menu            | Department | Location  | Action        | StockQuantity |
      | Prompted Counts | Services   | Fixture   | REVIEW & EDIT | 520           |
      | Prompted Counts | Services   | Warehouse | REVIEW & EDIT | 520           |


  #@sma
  #Scenario Outline:SMA31446 TC_05"<Department>"_"<Location>"Verify users cannot remove an action previously added to an item whilst in edit state
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I click on "<Menu>"
  #Then I click on "<Department>"
  #Then I click on "<Location>"
  #Then I click on "<Action>"
  #And I verify users cannot remove an action previously added
  #
  #Examples:
  #| Menu            | Department       | Location  | Action        | StockQuantity |
  #| Prompted Counts | Market Street    | Fixture   | REVIEW & EDIT |            20 |
  #| Prompted Counts | Fresh   | Fixture   | REVIEW & EDIT |            20 |



  #################################################UserStory- SMA-31440#######################################################
  @sma
  Scenario Outline: SMA31440TC_01 Location Verify user Able to view Summary tab throughout the day irrespective of time
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed

    Examples:
      | Menu            | Department       | Location |
      | Prompted Counts | Ambient & Frozen | Summary  |

  @sma
  Scenario Outline: SMA31440TC_02 Location Verify user Able to view "Total Approvals" tab with total count of approvals
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I verify "<Tab>" is displayed

    Examples:
      | Menu            | Department       | Location | Tab             |
      | Prompted Counts | Ambient & Frozen | Summary  | Total Approvals |

  @sma
  Scenario Outline: SMA31440TC_03 Location Verify user Able to view department list with its outstanding count i.e., 1 of 2 (Amber colour), 2 of 2 (Green Colour)
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify Location is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed

    Examples:
      | Menu            | Department       | Location | Button          |
      | Prompted Counts | Ambient & Frozen | Summary  | Total Approvals |

  @sma
  Scenario Outline: SMA31440TC_04 Location Verify user Able to view total items list count at the top which needs manager approval
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed

    Examples:
      | Menu            | Department       | Location | Button          |
      | Prompted Counts | Ambient & Frozen | Summary  | Total Approvals |

  @sma
  Scenario Outline: SMA31440TC_05 Location Verify user Able to view list of prompted items which requires manager approval i.e. Adjustment value>=200 pounds
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed
    Then I click on "<Department>"
    And I verify item which need manager approvals

    Examples:
      | Menu            | Department    | Location | Button          |
      | Prompted Counts | Market Street | Summary  | Total Approvals |

  @sma
  Scenario Outline: SMA31440TC_06 Location Verify user Able to approve prompted item from the list
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed
    Then I click on "<Department>"
    And I verify item which need manager approvals
    And I select and Approve prompted item from list

    Examples:
      | Menu            | Department | Location | Button          |
      | Prompted Counts | Fresh      | Summary  | Total Approvals |

  @sma
  Scenario Outline: SMA31440TC_07 Location Verify user Allow to edit count at any location before approval
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed
    Then I click on "<Department>"
    And I verify item which need manager approvals
    And I edit count of any "<location>" before approval

    Examples:
      | Menu            | Department    | Location | Button          | location |
      | Prompted Counts | Market Street | Summary  | Total Approvals | Fixture  |

  @sma
  Scenario Outline: SMA31440TC_09 Location Verify user Able to view the approved items at the bottom after approval
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed
    Then I click on "<Department>"
    And I verify approved items displayed

    Examples:
      | Menu            | Department | Location | Button          | location |
      | Prompted Counts | Fresh      | Summary  | Total Approvals | Fixture  |

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 48   | am       |

  @sma
  Scenario Outline: SMA31440TC_11 Location Verify After 9.45AM item details display in View Mode
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed
    Then I click on "<Department>"
    And I verify item details display in View Mode

    Examples:
      | Menu            | Department | Location | Button          |
      | Prompted Counts | Fresh      | Summary  | Total Approvals |


      #############################SMA31437,35###########################################################################

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 48   | am       |

  @sma
  Scenario Outline: SMA31437TC_01Verify Summary Card details for Department_Location department level review
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<Menu>"
    And I verify "<Location>" is displayed
    Then I click on "<Location>"
    And I verify Summary screen UI
    Then I select Summary Card for "<Department>"
    And I verify all the list of products with Total count at the top of the screen
    And I verify product list item description, MIN, Stock count, Adjustment value
    And I verify Adjustment value calculation agaist current stock and updated count
    And I verify updated Adjustment back on main screen after count is updated at department level

    Examples:
      | Menu            | Department | Location |
      | Prompted Counts | Fresh      | Summary  |

