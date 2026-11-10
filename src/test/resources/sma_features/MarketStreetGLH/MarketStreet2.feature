@2market_street @regression @store_walk
Feature: Verify Market Street Gaps, Lows and Highs Part-2

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma
  Scenario Outline:sma2313701 To verify Store Colleague/manager should be able to mark all uncounted items as Confirm all Zero at Other Location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    Then I see product in View List
    And I click Confirm all Zero
    And I verify zero marked products

    Examples:
      | storeID | Barcode   | Quantity | Department         |
	     #|78 | 104695783 |200|Fresh Prep|
      | 78      | 105348901 | 200      | Oven Fresh / Baked |

  @sma
  Scenario Outline: sma2313702 To verify Store Colleague/manager should be able to mark all uncounted items as Confirm all Zero at Backup Location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<departments>" or not
    Then I see product in View List
    And I click Confirm all Zero
    And I verify zero marked products

    Examples:
      | departments        |
		#|Fresh Prep|
		#|Butchery|
      | Oven Fresh / Baked |

  @sma
  Scenario Outline:sma2313703  To verify that if all the list of items are counted then Confirm all zero button should disappear at Other Location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    Then I verify my min is present in the "<departments>" or not
    Then I verify Confirm all zero dissappers

    Examples:
      | departments        |
		#|Fresh Prep|
		#|Butchery|
      | Oven Fresh / Baked |

  @sma
  Scenario Outline: sma2313704 To verify that if all the list of items are counted then Confirm all zero button should disappear at Backup Location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<departments>" or not
    Then I verify Confirm all zero dissappers

    Examples:
      | departments        |
      | Oven Fresh / Baked |
		#|Fresh Prep|
		#|Butchery|
  @sma
  Scenario Outline: sma2313705 To verify list of items When at least one item is uncounted then Confirm all zero button to appear at Other Location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I verify Confirm all Zero Button present
    And I click Exit Other

    Examples:
      | Barcode   | Quantity | Department         |
	      #| 104695783 |7|Fresh Prep|
	      #|105150110|70|Fresh Prep|
      | 105348927 | 200      | Oven Fresh / Baked |

  @sma
  Scenario Outline:sma2313706 To verify list of items When at least one item is uncounted then Confirm all zero button to appear at Backup Location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I click Confirm all Zero
    And I click on Back Button
    And I click on Back Button
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I verify Confirm all Zero Button present

    Examples:
      | Barcode   | Department         |
	      #| 104695783 |Fresh Prep|
      | 105348927 | Oven Fresh / Baked |

  @sma
  Scenario Outline: sma2313707 To verify list of items screen displayed all items to appear in Alphabetical order and Actioned items to go bottom at Other location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    And I verify alphabetic order sorting for list
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list

    Examples:
      | Barcode   | Department         |
	     # | 104695783 |Fresh Prep|
      | 105348927 | Oven Fresh / Baked |

  @sma
  Scenario Outline: sma2313708 To verify list of items screen displayed all items to appear in Alphabetical order and Actioned items to go bottom at Back up location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    And I verify alphabetic order sorting for list
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list

    Examples:
      | Barcode   | Department         |
	     # | 104695783 |7|Fresh Prep|
      | 105348927 | Oven Fresh / Baked |

  @sma
  Scenario Outline: sma2313709 To verify Actioned items at Other location counts are not impacted or changed after confirm all zeros.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verfiy "<Barcode>" count is not changed
    And I click on Back Button

    Examples:
      | Barcode   | Department         |
	     # | 104695783 | Fresh Prep|
      | 105348927 | Oven Fresh / Baked |

  @sma
  Scenario Outline:sma2313710To verify Actioned items at Back up locatioN counts are not impacted or changed after confirm all zeros.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I click Confirm all Zero
    And I verfiy "<Barcode>" count is not changed
    And I click on Back Button

    Examples:
      | Barcode   | Department         |
	#      | 104695783 |Fresh Prep|
      | 105348927 | Oven Fresh / Baked |

#######################################################################################################RUN_4#########################################################################################

  @sma
  Scenario Outline: TS_51 To verify department header status gets updated in Other location whenever user captures the products beloging to the same department in Other location.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Other Location
    And I verify department header status as "<Status>"

    Examples:
      | storeID | Barcode   | Status | Quantity |
      | 78      | 109194831 | 0 of 1 | 100      |

  @sma
  Scenario Outline: TS_52 To verify department header status gets updated in Other location whenever user captures the products beloging to the same department in Other location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    Then I verify my min is present in the "<Departments>" or not
    Then I see product in View List
    And I click Confirm all Zero
    And I click on Back Button
    And I verify department header status as "<Status>"

    Examples:
      | Departments | Status |
      | Fish Bar    | 1 of 1 |

  @sma
  Scenario Outline: TS_53 To verify Section header status gets updated in Other location whenever user captures the products beloging to the same department in Other location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    And I verify department header status as "<Status>"
    And I verify "<Departments>" department is Displayed
    And I verify section header status as "<sectionStatus>"

    Examples:
      | Departments | Status | sectionStatus |
      | Fish Bar    | 1 of 1 | 1 of 1        |

  @sma
  Scenario Outline:TS_57,58 To verify Section header status gets updated in backup location whenever user captures the products beloging to the same department in Backup location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<Departments>" or not
    Then I see product in View List
    And I click Confirm all Zero
    And I confirm count area
    And I verify department header status as "<Status>"
    And I verify section header status as "<sectionStatus>"

    Examples:
      | Departments | Status    | sectionStatus |
      | Fish Bar    | Completed | COMPLETED     |

  @sma
  Scenario Outline:TS_55 To verify if user scans multiple products in Counter and Fixture location than when the user navigate to Backup Location than user should be able to view department list with Section header status as - Other Pending
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on Back Button
    And I click Backup Location
    And I verify "<Departments>" department is Displayed
    And I verify section header status as "<sectionStatus>"

    Examples:
      | Barcode   | Quantity | Departments | sectionStatus |
      | 105526421 | 100      | Deli        | OTHER PENDING |

  @sma
  Scenario Outline: TS_56 To verify department header status gets updated in backup location whenever user captures the products beloging to the same department in Backup location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    Then I verify my min is present in the "<Departments>" or not
    Then I see product in View List
    And I click Confirm all Zero
    And I click on Back Button
    And I verify department header status as "<Status>"
    And I click on Back Button
    And I click Backup Location
    And I verify department header status as "<Status1>"

    Examples:
      | Departments | Status | Status1 |
      | Deli        | 1 of 1 | 0 of 1  |

 	#SMA-20508
  @sma
  Scenario Outline: TS_41 To verify user is able to edit quantity in Review screen for Counter Location products which as marked as HIGH
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on High button
    And I capture MIN for product
    And I enter quantity "<Quantity>" for high
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I click and enter "<Quantity>" for other location
    And I click Exit Other
    And I click on Back Button
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I click and enter "<Quantity>" for backup location
    And I confirm count area
    And I click on Back Button
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I capture MIN for product
    And I click product
    And I update "<Count>" for "<Location>" location
    And I click on Back Button
    And I click on Back Button

    Examples:
      | Barcode   | Quantity | Count | Department | Location |
      | 104695783 | 500      | 300   | Fresh Prep | Other    |
	    ####### |105810211 |   500 |    700 |Oven Fresh / Baked|Other|
	      #########	 |109349151|200|400|Bakery|Other|

  @sma
  Scenario Outline: sma20508 TS_118 To Verify user is able to drill down at department level and drill up at item level
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Review Location
    Then I verify my min is present in the "<Type>"
    Then I select the "<Type>" and verify the status as ReviewReady

    Examples:
      | Type       |
      | Fresh Prep |
       	 ########|Butchery|

  @sma
  Scenario Outline: sma20508 TS_119 To Verify when an item is viewed on Review screen it displays MIN,product description,adjustment value,stock record,counted,adjustment
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I capture MIN for product
    And I see MIN, Product description, Adjustment value, Stock record, Counted, Adjustment

    Examples:
      | Department |
      | Fresh Prep |

  @sma
  Scenario Outline: sma20508 To Verify the Manager user can Approve the items present in the list in Approval tab in Review section
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Review Location
    Then I verify my min is present in the "<Type>"
    And I click Approval Tab
    And I see Approve label

    Examples:
      | Type       |
      | Fresh Prep |

##use Non-Integrated Store and update SOH=0
  @sma
  Scenario Outline: TS_39 To verify user is able to edit quantity in Review screen for Counter Location products which as marked as GAP
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I click and enter "<Quantity>" for other location
    And I click Exit Other
    And I click on Back Button
    And I click Backup Location
    Then I verify my min is present in the "<Department>" or not
    And I verify "<Barcode>" in list
    And I click and enter "<Quantity>"  for backup location for low
    And I confirm count area
    And I click on Back Button
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I capture MIN for product
    And I click product
    And I update "<Count>" for "<Location>" location
    And I click on Back Button
    And I click on Back Button

    Examples:
      | Barcode   | Count | Quantity | Department         | Location |
	      #| 107625810 |    12 |        4 |Bakery|Other|
      |109349151   |200    |400       |Cake Shop           |Other     |
      ##| 105810211 | 500   | 700      | Oven Fresh / Baked | Other    |

  @sma
  Scenario Outline: TS_116,117 To Verify the Manager user can review and approve items present in Review section
    When  I enter Username and Password for SMA Manager user
    And  I click on login button for SMA
    Then  I click on Market Street
    And  I click Market Street Gaps,Highs,Lows
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I capture MIN for product
    And I click product
    And I update "<Count>" for "<Location>" location
    And I click on Back Button
		#for approval
    And  I click Approval Tab
    And I see Approve label
    And I click Approve button
    And I see product is APPROVED
    And I click on Back Button

    Examples:
      | Department | Count | Location |
      | Fresh Prep | 20    | Other    |

  @sma
  Scenario: To verify GLH market street Approval screen is displaying GLH market street products whose adjustment price is more than 200pounds
    When  I enter Username and Password for SMA Collegue user
    And  I click on login button for SMA
    Then  I click on Market Street
    And  I click Market Street Gaps,Highs,Lows
    And I click Review Location
    And  I click Approval Tab
    And I verify adjustment value more than 200pound

  @sma
  Scenario Outline:  sma20508 To verify Colleague user able to see Approve button disabled for items pending for approval
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Review Location
    Then I verify my min is present in the "<Type>"
    And I click Approval Tab
    And I see Approve label
    And I verify Approve button is disabled

    Examples:
      | Type       |
      | Fresh Prep |

  @sma
  Scenario Outline: To Verify the Manager user can review the items present in the list in Review section
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Review Location
    Then I verify my min is present in the "<Department>" or not
    And I Verify count for the scanned items which are ready to review
    And I click on Back Button
    And I click Approval Tab
    And I Verify count for the scanned items in Approval Tab

    Examples:
      | Department |
      | Fresh Prep |

  @sma
  Scenario: To verify below attributes displayed in Approval screen when user click on item to Approve
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Review Location
    And I click Approval Tab
    And I see MIN, Product description, Adjustment value, Stock record, Counted, Adjustment


  @sma
  Scenario Outline: Verify Delete Marketstreet Storewalk service
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete MarketStreet storewalk for store id "<storeID>"

    Examples:
      | storeID |
      | 78      |
