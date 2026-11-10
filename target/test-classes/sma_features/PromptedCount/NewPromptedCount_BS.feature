@111Newprompted_count @regression @store_walk
Feature: Verify Prompted Count functionality.

########## Before starting execution , upload file in the S3 bucket.
########### File name with previous day date
###########  https://s3.console.aws.amazon.com/s3/buckets/msit.xxwmm.supplychain.freshcounts.eeeeeeeeee > promptedcountsexceptions > pending
###########################  Prompted counts will be performed from 6 AM - 9.45 AM.

  @timeChange @Part1
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 06    | 01   | am       |



  @sma @Part1
  Scenario Outline: SC_01 To verify available Departments and all locations with default status
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I verify "<Department>" with "<DeptStatus>" status
    Then I click on "<Department>" option
    And I verify option "<Location1>" with "0" status
    And I verify option "<Location2>" with "0" status
    And I verify option "<Location3>" with "0" status
    And I verify option "<Location4>" with "0" status
    And I verify option "<Submenu>" with "Default" status

    Examples:
      | Department       | Location1 | Location2 | Location3 | Location4 | Submenu              | DeptStatus |
      | Ambient & Frozen | Fixture   | Off Shelf | Petrol    | Warehouse | Actions & Next Steps | Default    |
      | Fresh            | Fixture   | Off Shelf | Petrol    | Warehouse | Actions & Next Steps | Default    |
      | Market Street    | Fixture   | Off Shelf | Petrol    | Warehouse | Actions & Next Steps | Default    |
      | Services         | Fixture   | Off Shelf | Petrol    | Warehouse | Actions & Next Steps | Default    |


  @sma @Part1
  Scenario Outline: SC_02 To verify one prompt item and 'location not completed' message, for OffShelf location with 'CONTINUE TO FIXTURE' button navigation.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I view and click on Button "<Button>"
    And I Verify prompted item navigated to "<Previouslocation>"
    Then I verify one prompted item is displayed

    Examples:
      | Department       | Location  | Message                                  | Button              | Previouslocation |
      | Ambient & Frozen | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Fresh            | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Market Street    | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Services         | Off Shelf | Fixture location has not been completed. | CONTINUE TO FIXTURE | Fixture          |

  @sma @Part1
  Scenario Outline: SC_03  To verify 'location not completed' message with 'CONTINUE TO FIXTURE' button navigation for Petrol location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I view and click on Button "<Button>"
    And I Verify prompted item navigated to "<Previouslocation>"

    Examples:
      | Department       | Location | Message                                                  | Button              | Previouslocation |
      | Ambient & Frozen | Petrol   | Fixture and Off Shelf locations have not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Fresh            | Petrol   | Fixture and Off Shelf locations have not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Market Street    | Petrol   | Fixture and Off Shelf locations have not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Services         | Petrol   | Fixture and Off Shelf locations have not been completed. | CONTINUE TO FIXTURE | Fixture          |

  @sma @Part1
  Scenario Outline: SC_04 To Verify 'location not completed' message with 'CONTINUE TO FIXTURE' button navigation for Warehouse location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I Verify Prompt "<Message>" is displayed at "<Location>"
    And I view and click on Button "<Button>"
    And I Verify prompted item navigated to "<Previouslocation>"

    Examples:
      | Department       | Location  | Message                                                  | Button              | Previouslocation |
      | Ambient & Frozen | Warehouse | Fixture location has not been completed.                 | CONTINUE TO FIXTURE | Fixture          |
      | Fresh            | Warehouse | Fixture location has not been completed.                 | CONTINUE TO FIXTURE | Fixture          |
      | Market Street    | Warehouse | Fixture and Off Shelf locations have not been completed. | CONTINUE TO FIXTURE | Fixture          |
      | Services         | Warehouse | Fixture and Off Shelf locations have not been completed. | CONTINUE TO FIXTURE | Fixture          |

  @sma @Part1
  Scenario Outline: SC_05 To verify history screen with 'No Item Available' msg for, Fixture,  Offshelf, Petrol and Warehouse for all deparments.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    Then I click on icon "Show List"
    And I see "<Header>"
    Then I Verify Prompt "No Items Available" is displayed at "<Location>"

    Examples:
      | Department       | Location  | Header            |
      | Ambient & Frozen | Fixture   | Fixture History   |
      | Ambient & Frozen | Off Shelf | Off Shelf History |
      | Ambient & Frozen | Petrol    | Petrol History    |
      | Ambient & Frozen | Warehouse | Warehouse History |
      | Fresh            | Fixture   | Fixture History   |
      | Fresh            | Off Shelf | Off Shelf History |
      | Fresh            | Petrol    | Petrol History    |
      | Fresh            | Warehouse | Warehouse History |
      | Market Street    | Fixture   | Fixture History   |
      | Market Street    | Off Shelf | Off Shelf History |
      | Market Street    | Petrol    | Petrol History    |
      | Market Street    | Warehouse | Warehouse History |
      | Services         | Fixture   | Fixture History   |
      | Services         | Off Shelf | Off Shelf History |
      | Services         | Petrol    | Petrol History    |
      | Services         | Warehouse | Warehouse History |


  @sma @Part1
  Scenario Outline: SC_06 To verify Action & Next Steps screen for all departments with its default status
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Submenu>" option
    And I verify "Merchandising" action status with "0" on Action & Next Steps
    And I verify "Print & Place Labels" action status with "0" on Action & Next Steps
    Then I verify Action & Next steps screen is displayed
    And I verify Merchandising action tile is displayed on Action & Next steps page
    And I verify Print & Place Labels action tile is displayed on Action & Next steps page
    And I verify Print and Place Labels with count Zero when no action is captured

    Examples:
      | Department       | Submenu              |
      | Ambient & Frozen | Actions & Next Steps |
      | Fresh            | Actions & Next Steps |
      | Market Street    | Actions & Next Steps |
      | Services         | Actions & Next Steps |


  @timeChange @Part1
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
#    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 16   | am       |

  @sma @Part1
  Scenario Outline: SC_07 To Verify Deadline Reminder prompt before half an hour at 09:16 AM for all Departments and their location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify "Deadline Reminder" alert title is displayed
    And I verify "Submissions must be completed prior to the 09:45 AM daily cutoff." alert message  is displayed

    Examples:
      | Department       | Location             |
      | Ambient & Frozen | Fixture              |
      | Ambient & Frozen | Off Shelf            |
      | Ambient & Frozen | Petrol               |
      | Ambient & Frozen | Warehouse            |
      | Ambient & Frozen | Actions & Next Steps |
      | Fresh            | Fixture              |
      | Fresh            | Off Shelf            |
      | Fresh            | Petrol               |
      | Fresh            | Warehouse            |
      | Fresh            | Actions & Next Steps |
      | Market Street    | Fixture              |
      | Market Street    | Off Shelf            |
      | Market Street    | Petrol               |
      | Market Street    | Warehouse            |
      | Market Street    | Actions & Next Steps |
      | Services         | Fixture              |
      | Services         | Off Shelf            |
      | Services         | Petrol               |
      | Services         | Warehouse            |
      | Services         | Actions & Next Steps |


  @timeChange @Part1
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 46   | am       |

  @sma @Part1
  Scenario Outline: SC_08 to verify deadline timer prompt message 'Prompted counts submissions closed' for all Departments and their location after 9:45 AM
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify "Prompted counts submissions closed" message title is displayed
    And I verify "You are unable to complete prompted counts submissions for the remainder of the day. Submissions must be completed prior to the 09:45 am daily cut off." message text is displayed

    Examples:
      | Department       | Location             |
      | Ambient & Frozen | Fixture              |
      | Ambient & Frozen | Off Shelf            |
      | Ambient & Frozen | Petrol               |
      | Ambient & Frozen | Warehouse            |
      | Ambient & Frozen | Actions & Next Steps |
      | Fresh            | Fixture              |
      | Fresh            | Off Shelf            |
      | Fresh            | Petrol               |
      | Fresh            | Warehouse            |
      | Fresh            | Actions & Next Steps |
      | Market Street    | Fixture              |
      | Market Street    | Off Shelf            |
      | Market Street    | Petrol               |
      | Market Street    | Warehouse            |
      | Market Street    | Actions & Next Steps |
      | Services         | Fixture              |
      | Services         | Off Shelf            |
      | Services         | Petrol               |
      | Services         | Warehouse            |
      | Services         | Actions & Next Steps |

 ######## FIXTURE --> LOCATION ######

  @timeChange @Part2
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
#    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 06    | 01   | am       |

  @sma @Part2
  Scenario Outline: SC_09 To verify prompted count with single item without action, Department 'In Progress' status, location count update, Edit prompted count functionality, and history screen, for Fixture.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    Then I verify one prompted item is displayed
    And I enter qty "<Quantity>" and click on Confirm button
    And I click on Back Button in Prompted Counts screen
    And I verify option "<Location>" with "1" status
    And I click on Back Button in Prompted Counts screen
    Then I verify "<Department>" with "IN PROGRESS" status
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I click on History icon
    Then I verify History screen is displayed with list of completed products with total count
    And I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I edit stock count with "<EditQty>"
    Then I verify the edited quantity "<EditQty>" on history screen

    Examples:
      | Department       | Location | Quantity | EditQty |
      | Ambient & Frozen | Fixture  | 11       | 110     |
      | Fresh            | Fixture  | 11       | 110     |
      | Market Street    | Fixture  | 11       | 110     |
      | Services         | Fixture  | 11       | 110     |

  @sma @Part2
  Scenario Outline: SC_10 To verify prompted count with single item and one action, Edit count and action disable functionality on Edit screen, Merchandising status on Action & Next Steps and history screen verfication for Fixture.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    Then I click on "<Action>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    Then I click on History icon
    Then I verify History screen is displayed with list of completed products with total count
    And I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I verify the action "<Action>" status as "Disable" on edit screen
    And I edit stock count with "<EditQty>"
    Then I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I click on Back Button in Prompted Counts screen
    Then I click on "Actions & Next Steps" option
    And I verify "Merchandising" action status with "1" on Action & Next Steps


    Examples:
      | Department       | Location | Quantity | EditQty | Action                   |
      | Ambient & Frozen | Fixture  | 12       | 120     | Check Merchandising Plan |
      | Fresh            | Fixture  | 12       | 120     | Check Merchandising Plan |
      | Market Street    | Fixture  | 12       | 120     | Check Merchandising Plan |
      | Services         | Fixture  | 12       | 120     | Check Merchandising Plan |


  @sma @Part2
  Scenario Outline: SC_11 To verify prompted count with single item and 'Print and Place label' and 'Marchandising' actions, Print labels verification, Actions & Next step screen verification for Fixture.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify item details on the prompted screen
    And I verify "<Action>" Action label is displayed
    And I verify "<Action1>" Action label is displayed
    Then I click on "<Action>" Action label
    Then I click on "<Action1>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    And I verify Request Label screen UI
    And I verify "<Label1>", "<Label2>" and "<Label3>" labels are displayed
    Then I select Label size
    And I click on Continue Button on Request label page
    Then I click on History icon
    And I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I verify the action "<Action>" status as "Disable" on edit screen
    And I verify the action "<Action1>" status as "Disable" on edit screen
    And I edit stock count with "<EditQty>"
    Then I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I click on Back Button in Prompted Counts screen
    Then I click on "<Submenu>" option
    And I verify "Merchandising" action status with "2" on Action & Next Steps
    And I verify "Print & Place Labels" action status with "1" on Action & Next Steps
    And I click on Merchandising on Action & Next steps page
    Then I verify details on Merchandising screen
    And I click on Back Button in Prompted Counts screen
    Then I click on Print & Place Labels on Action & Next steps page
    And I verify Print & Place Labels screen is displayed
    Then I verify details on Print & Place Labels screen
    Then I click on Place labels button
    Then I verify Place labels screen with Product details are displayed

    Examples:
      | Department       | Location | Quantity | Submenu              | Action                           | Action1                  | Label1                         | Label2                      | Label3             | EditQty |
      | Ambient & Frozen | Fixture  | 13       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Default                        | A4P White POS               | Medium White POS   | 130     |
      | Fresh            | Fixture  | 13       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Medium White Label Bakery      | Medium White No Price Label | A4P Bakery POS     | 130     |
      | Market Street    | Fixture  | 13       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Medium Counter Deli Cheese POS | Medium White No Price Label | A4P Counter POS    | 130     |
      | Services         | Fixture  | 13       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Small Cigarettes Label         | Medium White No Price Label | Medium White Label | 130     |


  @sma @Part2
  Scenario Outline: SC_12 To verify flag with single item without action, Re-flag,  Un-flag functionality, flagged item verification on other locations, edit flagged items in other location for Fixture

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I mark single product as flag
    And I verify flagged item from "<Location>" to "Off Shelf" location
    And I verify flagged item from "<Location>" to "Petrol" location
    And I verify flagged item from "<Location>" to "Warehouse" location
    Then I click on Back Button in Prompted Counts screen
    Then I click on "<Location>" option
    Then I click on History icon
    And I re-flag the item with one action
    And I verify the added "One" aciton on history screen while flag
    Then I click on Back Button in Prompted Counts screen
    Then I unflag the item with qty "<EditQty>" without any action
    And I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I verify un-flagged item status with count in "Off Shelf" location
    And I verify un-flagged item status with count in "Petrol" location
    And I verify un-flagged item status with count in "Warehouse" location

    Examples:
      | Department       | Location | EditQty |
      | Ambient & Frozen | Fixture  | 200     |
      | Fresh            | Fixture  | 200     |
      | Market Street    | Fixture  | 200     |
      | Services         | Fixture  | 200     |


  @sma @Part2
  Scenario Outline: SC_13 To verify flag with single item and one action, Un-flag functionality, flagged item verification on other locations, edit flagged items in other location for Fixture
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I enter "<Quantity>"
    And I mark single product as flag with one action
    Then I click on History icon
    And I select flag item from history
    Then I click on Edit button
    And I verify the action "Check Merchandising Plan" status as "Disable" on edit screen
    And I click on Back Button in Prompted Counts screen
    And I click on Back Button in Prompted Counts screen
    And I verify flagged item from "<Location>" to "Off Shelf" location
    And I verify flagged item from "<Location>" to "Petrol" location
    And I verify flagged item from "<Location>" to "Warehouse" location
    Then I click on Back Button in Prompted Counts screen
    Then I click on "<Location>" option
    Then I click on History icon
    Then I unflag the item with qty "<EditQty>" without any action
    And I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I verify un-flagged item status with count in "Off Shelf" location
    And I verify un-flagged item status with count in "Petrol" location
    And I verify un-flagged item status with count in "Warehouse" location

    Examples:
      | Department       | Location | Quantity | EditQty |
      | Ambient & Frozen | Fixture  | 14       | 140     |
      | Fresh            | Fixture  | 14       | 140     |
      | Market Street    | Fixture  | 14       | 140     |
      | Services         | Fixture  | 14       | 140     |

  @sma @Part2
  Scenario Outline: SC_14 To verify flag with single item and all action, Un-flag functionality, flagged item verification on other locations,  edit flagged items in other location for Fixture
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I enter "<StockQuantity>"
    And I mark product as flag with all actions
    Then I click on History icon
    And I verify the added "All" aciton on history screen while flag
    Then I click on Edit button
    And I verify the action "Check Merchandising Plan" status as "Disable" on edit screen
    And I verify the action "Print and Place Shelf Edge Label" status as "Disable" on edit screen
    And I click on Back Button in Prompted Counts screen
    And I click on Back Button in Prompted Counts screen
    And I verify flagged item from "<Location>" to "Off Shelf" location
    And I verify flagged item from "<Location>" to "Petrol" location
    And I verify flagged item from "<Location>" to "Warehouse" location
    And I click on Back Button in Prompted Counts screen
    Then I click on "<Location>" option
    Then I click on History icon
    Then I unflag the item with qty "<EditQty>" without any action
    And I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I verify un-flagged item status with count in "Off Shelf" location
    And I verify un-flagged item status with count in "Petrol" location
    And I verify un-flagged item status with count in "Warehouse" location

    Examples:
      | Department       | Location | StockQuantity | EditQty |
      | Ambient & Frozen | Fixture  | 15            | 150     |
      | Fresh            | Fixture  | 15            | 150     |
      | Market Street    | Fixture  | 15            | 150     |
      | Services         | Fixture  | 15            | 150     |

  @sma @Part2
  Scenario Outline: SC_15 To verify complete all pending prompted items functionality, completion message verification, Review & Edit screen verification for Fixture location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify Item list count is displayed
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count
    And I click on Back Button in Prompted Counts screen
    And I click on Back Button in Prompted Counts screen
    And I verify option "<Location>" with "COMPLETE" status
    And I click on Back Button in Prompted Counts screen
    Then I verify "<Department>" with "IN PROGRESS" status

### Need to add total completed product count and flag counts.
    Examples:

      | Department       | Location | Quantity | Message                                                |
      | Ambient & Frozen | Fixture  | 16       | You have completed Fixture checks for Ambient & Frozen |
      | Market Street    | Fixture  | 16       | You have completed Fixture checks for Market Street    |
      | Fresh            | Fixture  | 16       | You have completed Fixture checks for Fresh            |
      | Services         | Fixture  | 16       | You have completed Fixture checks for Services         |

  @sma @Part2
  Scenario Outline: SC_16 To verify promoted item edit functionality after complete Fixture location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify History icon is displayed
    Then I click on History icon
    Then I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I add action and edit stock count as "<EditQty>"

    Examples:
      | Department       | Location | EditQty | Quantity |
      | Ambient & Frozen | Fixture  | 230     | 16       |
      | Fresh            | Fixture  | 230     | 16       |
      | Market Street    | Fixture  | 230     | 16       |
      | Services         | Fixture  | 230     | 16       |


##  ########################################### OFFSHELF --> LOCATION ##################################################################################
#
  @sma @Part3
  Scenario Outline: SC_17 To verify prompted count with single item without action, Edit prompted count and history screen verification for OffShelf
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I enter qty "<Quantity>" and click on Confirm button
    And I click on History icon
    Then I verify History screen is displayed with list of completed products with total count
    And I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I edit stock count with "<EditQty>"
    Then I verify the edited quantity "<EditQty>" on history screen

    Examples:
      | Department       | Location  | Quantity | EditQty |
      | Ambient & Frozen | Off Shelf | 17       | 170     |
      | Fresh            | Off Shelf | 17       | 170     |
      | Market Street    | Off Shelf | 17       | 170     |
      | Services         | Off Shelf | 17       | 170     |


  @sma @Part3
  Scenario Outline: SC_18 To verify prompted count with single item and 'Print and Place label' and 'Merchandising' actions, Print labels verification, Actions & Next step screen verification for OffShelf.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify "<Action>" Action label is displayed
    And I verify "<Action1>" Action label is displayed
    Then I click on "<Action>" Action label
    Then I click on "<Action1>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    And I verify Request Label screen UI
    And I verify "<Label1>", "<Label2>" and "<Label3>" labels are displayed
    Then I select Label size
    And I click on Continue Button on Request label page
    And I click on Back Button in Prompted Counts screen
    Then I click on "<Submenu>"
    And I click on Merchandising on Action & Next steps page
    Then I verify details on Merchandising screen
    And I click on Back Button in Prompted Counts screen
    Then I click on Print & Place Labels on Action & Next steps page
    And I verify Print & Place Labels screen is displayed
    Then I verify details on Print & Place Labels screen
    Then I click on Place labels button
    Then I verify Place labels screen with Product details are displayed

    Examples:
      | Department       | Location  | Quantity | Submenu              | Action                           | Action1                  | Label1                         | Label2                      | Label3           |
      | Ambient & Frozen | Off Shelf | 23       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Default                        | A4P White POS               | Medium White POS |
      | Fresh            | Off Shelf | 23       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Medium White Label Bakery      | Medium White No Price Label | A4P Bakery POS   |
      | Market Street    | Off Shelf | 23       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Medium Counter Deli Cheese POS | Medium White No Price Label | A4P Counter POS  |
#   ####   | Services         | Off Shelf | 23       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Small Cigarettes Label         | Medium White No Price Label | Medium White Label |


  @sma @Part3
  Scenario Outline: SC_19 To verify flag with single item without action and qty, Re-flag, Un-flag functionality, flagged item verification on other locations, edit flagged items in other location for OffShelf.

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I mark single product as flag
    And I verify flagged item from "<Location>" to "Petrol" location
    And I verify flagged item from "<Location>" to "Warehouse" location
    Then I click on Back Button in Prompted Counts screen
    Then I click on "<Location>" option
    Then I click on History icon
    And I re-flag the item with one action
    And I verify the added "One" aciton on history screen while flag
    Then I click on Back Button in Prompted Counts screen
    Then I unflag the item with qty "<EditQty>" without any action
    And I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I verify un-flagged item status with count in "Petrol" location
    And I verify un-flagged item status with count in "Warehouse" location

    Examples:
      | Department       | Location  | EditQty |
      | Ambient & Frozen | Off Shelf | 200     |
      | Fresh            | Off Shelf | 200     |
      | Market Street    | Off Shelf | 200     |
      | Services         | Off Shelf | 200     |


  @sma @Part3
  Scenario Outline: SC_20 To verify flag with single item and one action, Un-flag functionality, flagged item verification on other locations, edit flagged items in other location for OffShelf
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I enter "<Quantity>"
    And I mark single product as flag with one action
    And I verify flagged item from "<Location>" to "Petrol" location
    And I verify flagged item from "<Location>" to "Warehouse" location
    Then I click on Back Button in Prompted Counts screen
    Then I click on "<Location>" option
    Then I click on History icon
    Then I unflag the item with qty "<EditQty>" without any action
    And I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I verify un-flagged item status with count in "Petrol" location
    And I verify un-flagged item status with count in "Warehouse" location

    Examples:
      | Department       | Location  | Quantity | EditQty |
      | Ambient & Frozen | Off Shelf | 24       | 240     |
      | Fresh            | Off Shelf | 24       | 240     |
# ####     | Market Street| Off Shelf | 24       | 240     |
      | Services         | Off Shelf | 24       | 240     |


  @sma @Part3
  Scenario Outline: SC_21 To verify complete all pending prompted items functionality, completion message verification, Review & Edit screen verification for OffShelf.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify Item list count is displayed
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I verify "<Message>" message is displayed
    And I click on Back Button in Prompted Counts screen
    And I verify option "<Location>" with "COMPLETE" status
    And I click on Back Button in Prompted Counts screen
    Then I verify "<Department>" with "IN PROGRESS" status
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count


    Examples:
      | Department       | Location  | Quantity | Message                                                  |
      | Ambient & Frozen | Off Shelf | 25       | You have completed Off Shelf checks for Ambient & Frozen |
      | Fresh            | Off Shelf | 25       | You have completed Off Shelf checks for Fresh            |
      | Market Street    | Off Shelf | 25       | You have completed Off Shelf checks for Market Street    |
      | Services         | Off Shelf | 25       | You have completed Off Shelf checks for Services         |

  @sma @Part3
  Scenario Outline: SC_22 To verify promoted item edit functionality after complete OffShelf location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify History icon is displayed
    Then I click on History icon
    Then I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I add action and edit stock count as "<EditQty>"

    Examples:
      | Department       | Location  | EditQty | Quantity |
      | Ambient & Frozen | Off Shelf | 26      | 200      |
      | Fresh            | Off Shelf | 26      | 200      |
      | Market Street    | Off Shelf | 26      | 200      |
      | Services         | Off Shelf | 26      | 200      |


# #   ########################################### PETROL --> LOCATION ##################################################################################
#
  @sma @Part3
  Scenario Outline: SC_23 To verify prompted count with single item and 'Print and Place label' and 'Marchandising' actions, Print labels verification, Actions & Next step screen verification for Petrol.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify "<Action>" Action label is displayed
    And I verify "<Action1>" Action label is displayed
    Then I click on "<Action>" Action label
    Then I click on "<Action1>" Action label
    And I enter qty "<Quantity>" and click on Confirm button
    And I verify Request Label screen UI
    And I verify "<Label1>", "<Label2>" and "<Label3>" labels are displayed
    Then I select Label size
    And I click on Continue Button on Request label page
    And I click on Back Button in Prompted Counts screen
    Then I click on "<Submenu>" option
    And I click on Merchandising on Action & Next steps page
    Then I verify details on Merchandising screen
    And I click on Back Button in Prompted Counts screen
    Then I click on Print & Place Labels on Action & Next steps page
    And I verify Print & Place Labels screen is displayed
    Then I verify details on Print & Place Labels screen
    Then I click on Place labels button
    Then I verify Place labels screen with Product details are displayed

    Examples:
      | Department | Location | Quantity | Submenu              | Action                           | Action1                  | Label1                    | Label2                      | Label3         |
#   ###  | Ambient & Frozen | Petrol   | 31       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Default                        | A4P White POS               | Medium White POS   |
      | Fresh      | Petrol   | 31       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Medium White Label Bakery | Medium White No Price Label | A4P Bakery POS |
#  ###  | Market Street | Petrol   | 31       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Medium Counter Deli Cheese POS | Medium White No Price Label | A4P Counter POS    |
#  ###  | Services   | Petrol   | 31       | Actions & Next Steps | Print and Place Shelf Edge Label | Check Merchandising Plan | Small Cigarettes Label    | Medium White No Price Label | Medium White Label |


  @sma @Part3
  Scenario Outline: SC_24 To verify prompted count with single item without action, Edit prompted count and history for Petrol.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I enter qty "<Quantity>" and click on Confirm button
    And I click on History icon
    Then I verify History screen is displayed with list of completed products with total count
    And I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I edit stock count with "<EditQty>"
    Then I verify the edited quantity "<EditQty>" on history screen

    Examples:
      | Department       | Location | Quantity | EditQty |
      | Ambient & Frozen | Petrol   | 30       | 320     |
      | Fresh            | Petrol   | 30       | 320     |
      | Market Street    | Petrol   | 30       | 320     |
# ###     | Services         | Petrol   | 30       | 320     |


  @sma @Part3
  Scenario Outline: SC_25 To verify flag with single item without action, Re-flag,  Un-flag functionality, flagged item verification on other locations, edit flagged items in other location for Petrol.

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I mark single product as flag
    And I verify flagged item from "<Location>" to "Warehouse" location
    Then I click on Back Button in Prompted Counts screen
    Then I click on "<Location>" option
    Then I click on History icon
    And I re-flag the item with one action
    And I verify the added "One" aciton on history screen while flag
    Then I click on Back Button in Prompted Counts screen
    Then I unflag the item with qty "<EditQty>" without any action
    And I verify the edited quantity "<EditQty>" on history screen
    And I click on Back Button in Prompted Counts screen
    And I verify un-flagged item status with count in "Warehouse" location

    Examples:
      | Department       | Location | EditQty |
      | Ambient & Frozen | Petrol   | 160     |
      | Fresh            | Petrol   | 160     |
      | Market Street    | Petrol   | 160     |
      | Services         | Petrol   | 160     |

  @sma @Part3
  Scenario Outline: SC_26 To verify complete all pending prompted items functionality, completion message verification, Review & Edit screen verification for Petrol location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify Item list count is displayed
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I verify History screen is displayed with list of completed products with total count

    Examples:
      | Department       | Location | Quantity | Message                                               |
      | Ambient & Frozen | Petrol   | 6        | You have completed Petrol checks for Ambient & Frozen |
      | Fresh            | Petrol   | 6        | You have completed Petrol checks for Fresh            |
      | Market Street    | Petrol   | 6        | You have completed Petrol checks for Market Street    |
      | Services         | Petrol   | 6        | You have completed Petrol checks for Services         |

  @sma @Part3
  Scenario Outline: SC_27 To verify promoted item edit functionality after complete Petrol location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify History icon is displayed
    Then I click on History icon
    Then I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I add action and edit stock count as "<EditQty>"

    Examples:
      | Department       | Location | EditQty | Quantity |
      | Ambient & Frozen | Petrol   | 60      | 6        |
      | Fresh            | Petrol   | 60      | 6        |
      | Market Street    | Petrol   | 60      | 6        |
      | Services         | Petrol   | 60      | 6        |

####   ########################################### WAREHOUSE --> LOCATION ##################################################################################
###
  @sma @Part3
  Scenario Outline: SC_28 To verify prompted count with single item, Edit prompted count and history screen verification for Warehouse.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I enter qty "<Quantity>" and click on Confirm button
    And I click on History icon
    Then I verify History screen is displayed with list of completed products with total count
    And I Select product on "<Quantity>" History screen
    Then I click on Edit button
    And I edit stock count with "<EditQty>"
    Then I verify the edited quantity "<EditQty>" on history screen

    Examples:
      | Department       | Location  | Quantity | EditQty |
      | Ambient & Frozen | Warehouse | 40       | 80      |
      | Fresh            | Warehouse | 40       | 80      |
      | Market Street    | Warehouse | 40       | 80      |
      | Services         | Warehouse | 40       | 80      |


  @sma @Part3
  Scenario Outline: SC_29 To verify complete all pending prompted items functionality, completion message verification, Review & Edit screen verification for Warehouse.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify Item list count is displayed
    Then I verify details on Warehouse screen
    Then I enter qty "<Quantity>" and click on Confirm button for all the products
    And I verify "<Message>" message is displayed
    And I verify REVIEW & EDIT button is displayed
    Then I click on REVIEW & EDIT button
    And I click on Back Button in Prompted Counts screen
    And I click on Back Button in Prompted Counts screen
    And I verify option "<Location>" with "COMPLETE" status
    And I click on Back Button in Prompted Counts screen
    Then I verify "<Department>" with "ACTION" status

    Examples:
      | Department       | Location  | Quantity | Message                                                  |
      | Ambient & Frozen | Warehouse | 70       | You have completed Warehouse checks for Ambient & Frozen |
      | Fresh            | Warehouse | 70       | You have completed Warehouse checks for Fresh            |
      | Market Street    | Warehouse | 70       | You have completed Warehouse checks for Market Street    |
      | Services         | Warehouse | 70       | You have completed Warehouse checks for Services         |

#
  @sma @Part3
  Scenario Outline: SC_30 To verify promoted item edit functionality after complete Warehouse location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Location>" option
    And I verify History icon is displayed
    Then I click on History icon
    Then I Select product on "<Quantity>" History screen
    Then I verify Edit button is displayed
    Then I click on Edit button
    And I add action and edit stock count as "<EditQty>"

    Examples:
      | Department       | Location  | EditQty | Quantity |
      | Ambient & Frozen | Warehouse | 7       | 70       |
      | Fresh            | Warehouse | 7       | 70       |
      | Market Street    | Warehouse | 7       | 70       |
      | Services         | Warehouse | 7       | 70       |

############# Action & Next Steps #####################################################

  @sma @Part3
  Scenario Outline: SC_31 To verify complete pending actions functionality on Action & Next Step for all departments.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Department>" option
    Then I click on "<Submenu>" option
    And I click on Merchandising on Action & Next steps page
    Then I click on the Confirm Button
    Then I click on Print & Place Labels on Action & Next steps page
    And I verify Print & Place Labels screen is displayed
    Then I click on Place labels button
    Then I click on Confirm button for all products
    And I verify "Merchandising" action status with "Complete" on Action & Next Steps
    And I verify "Print & Place Labels" action status with "Complete" on Action & Next Steps

    Examples:
      | Department       | Submenu              |
      | Ambient & Frozen | Actions & Next Steps |
      | Fresh            | Actions & Next Steps |
      | Market Street    | Actions & Next Steps |
      | Services         | Actions & Next Steps |


##    ########################### SUMMARY #######################################################################################
#
  @sma @Part3
  Scenario Outline: SC_32 To verify Summary screen, Total approval screen with pending items list for approvals for all departments.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    And I click on "Prompted Counts" option
    And I click on "<Location>" option
    And I verify Summary screen UI


    Examples:
      | Location |
      | Summary  |

  @sma @Part3
  Scenario Outline: SC_33 To verify Summary screen edit count functinality , Total approval screen with pending items list for approvals for all departments.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Location>" option
    And I click on "<Department>" option
    And I edit "<Quantity>" to existing prompted item
    And I click on Back Button in Prompted Counts screen
    And Verify the updated quantity
    And I click on Back Button in Prompted Counts screen

    Examples:
      | Location | Department       | Quantity |
      | Summary  | Ambient & Frozen | 5        |

  @sma @Part3
  Scenario Outline: SC_34 To verify Summary screen, Total approval screen with pending items list for approvals for all departments.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Location>" option
    And I verify Summary screen UI
    And I view and click on Button "<Button>"
    And I verify Department list of outstanding count is displayed

    Examples:
      | Location | Button          |
      | Summary  | Total Approvals |

  @sma @Part3
  Scenario Outline: SC_35 To verify edit count functionality before manager approval on Summary-Total approvals screen.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Location>" option
    And I view and click on Button "<Button>"
    Then I click on "<Department>"
    And I verify item which need manager approvals
    And I edit count of any "<Department>" before approval

    Examples:
      | Department       | Location | Button          |
      | Ambient & Frozen | Summary  | Total Approvals |

  @sma @Part3
  Scenario Outline: SC_36 To verify Item Approve functionality for pending items on Summary-Total approvals screen.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Location>" option
    And I view and click on Button "<Button>"
    Then I click on "<Department>"
    And I verify item which need manager approvals
    And I select and Approve prompted item from list

    Examples:
      | Department | Location | Button          |
      | Fresh   | Summary  | Total Approvals |


  @sma @Part3
  Scenario Outline: SC_37 To verify Approve items functionality Summary-Total approvals screen.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Location>" option
    And I view and click on Button "<Button>"
    Then I click on "<Department>"
    And I verify approved items displayed

    Examples:
      | Department | Location | Button          |
      | Fresh      | Summary  | Total Approvals |

  @timeChange @Part3
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 48   | am       |

  @sma @Part3
  Scenario Outline: SC_38 To verify Summary-Total approvals screen after deadline time 09:45 AM.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Location>" option
    And I view and click on Button "<Button>"
    Then I click on "<Department>"
    And I verify item details display in View Mode

    Examples:
      | Department    | Location | Button          |
      | Market Street | Summary  | Total Approvals |


  @timeChange @Part3
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 48   | am       |

  @sma @Part3
  Scenario Outline: SC_39 Verify Summary Card details for Department_Location department level review
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts" option
    Then I click on "<Location>" option
    Then I select Summary Card for "<Department>"
    And I verify all the list of products with Total count at the top of the screen

    Examples:
      | Department | Location |
      | Fresh      | Summary  |



###################################################### Total- 174