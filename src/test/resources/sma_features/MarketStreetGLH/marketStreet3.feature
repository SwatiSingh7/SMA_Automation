@3market_street @regression @store_walk
Feature:Verify Market Street Gaps, Lows and Highs Part-3

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 09    | 15   | am       |

  @sma
  Scenario: TS_190 To verify if GLH deadlines for First Warning Message 09:15 AM
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    Then I verify first warning message is displayed

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 11    | 30   | am       |

  @sma
  Scenario: TS_191 To verify if GLH deadlines for First Warning Message 09:15 AM
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    Then I verify second warning  message is displayed

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 12    | 00   | pm       |

  @sma
  Scenario: TS_192 To verify if GLH deadline for Second Slot end time 12:00 PM
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    Then I verify second slot end time message is displayed

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma
  Scenario Outline: TS_40 (End to End) To verify user is able to edit quantity in Review screen for Counter Location products which as marked as LOW
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
      | storeID | Barcode   | Quantity | Department | Count | Location |
	     # | 108533600 |400 |Butchery|20|Other|
      | 78      | 109349151 | 900      | Cake Shop  | 200   | Other    |

  @sma
  Scenario Outline: To verify if the SOH value is being displayed in the Approval tab of Review Section in decimal instead of integer
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
    And  I click Approval Tab
    And I verify SOH value is being display

    Examples:
      | Barcode   | Quantity | Department |
		#|102770778|200|Fresh Prep|
      | 105185558 | 200      | Fresh Prep |
		#|108533600|300|Butchery|
      | 102761020 | 400      | Butchery   |
      | 105526421 | 200      | Deli       |
		#|102391840|300|Butchery|

  @sma
  Scenario: To verify when the store colleague wishes to delete the scanned products at the counter location then product should not be deletable after  Section is completed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click View List
    And I verify popup msg for Section Completed

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

 	######################################################################Delete_Scenario_1###########################

  @sma
  Scenario Outline: sma23136 To verify store colleague is no allowed to delete scanned products from other location marked as GAP and not from the other and Backup location.
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
    And I click on GAP button
    And I click on barcode entry Button
    Then Enter "<Barcode1>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click on barcode entry Button
    Then Enter "<Barcode2>" number
    And I click on High button
    And I enter quantity "<Quantity>" for high
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Department>" or not
    And I verify Delete not allowed in Other
    And I click on Back Button

    Examples:
      | storeID | Barcode   | Barcode1  | Barcode2  | Quantity | Department |
      | 78      | 105780269 | 105185558 | 104695783 | 200      | Fresh Prep |

  @sma
  Scenario Outline: sma23136 To verify store colleague is no allowed to delete scanned products from other location marked as LOW and not from the other and Backup location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify Delete not allowed in Other
    And I click on Back Button

    Examples:
      | Departments |
      | Fresh Prep  |

  @sma
  Scenario Outline: sma23136 To verify store colleague is no allowed to delete scanned products from other location marked as HIGH and not from the other and Backup location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Other Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify Delete not allowed in Other
    And I click on Back Button

    Examples:
      | Departments |
      | Fresh Prep  |

  @sma
  Scenario Outline: sma23136 To verify store colleague is no allowed to delete scanned products from Backup location marked as GAP and not from the other and Backup location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify Delete not allowed in Backup

    Examples:
      | Departments |
      | Fresh Prep  |

  @sma
  Scenario Outline: sma23136 To verify store colleague is no allowed to delete scanned products from Backup location marked as LOW and not from the other and Backup location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify Delete not allowed in Backup

    Examples:
      | Departments |
      | Fresh Prep  |

  @sma
  Scenario Outline: sma23136 To verify store colleague is no allowed to delete scanned products from Backup location marked as HIGH and not from the other and Backup location.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify Delete not allowed in Backup

    Examples:
      | Departments |
      | Fresh Prep  |

  @sma
  Scenario Outline: TS_46 To verify user is able to delete scanned items marked as LOW in Counter location from App
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
    And I click View List
    Then I capture MIN for product in Counter
    And I Delete products from fixture
    And I click on Back Button
    And I click on Back Button
    And I verify department "<Department>" is deleted in Other location
    And I verify department "<Department>" is deleted in Backup location
    And I verify department "<Department>" is deleted in Review location
    And I click on Back Button
    And I logout of the system

    Examples:
      | Barcode   | Quantity | Department |
      | 105780269 | 10       | Fresh Prep |

  @sma
  Scenario Outline: TS_47 To verify user is able to delete scanned items marked as HIGH in Counter location from App
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on High button
    And I enter quantity "<Quantity>" for high
    And I click View List
    Then I capture MIN for product in Counter
    And I Delete products from fixture
    And I click on Back Button
    And I click on Back Button
    And I verify department "<Department>" is deleted in Other location
    And I verify department "<Department>" is deleted in Backup location
    And I verify department "<Department>" is deleted in Review location
    And I click on Back Button
    And I logout of the system

    Examples:
      | Barcode   | Quantity | Department |
      | 105780269 | 10       | Fresh Prep |

 	##########################################################################MS5#######################################

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

  @sma
  Scenario Outline: To verify that SOH value is calculated based on Stock On Hand UOM instead of the Standard UOM for items
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I verify Count Type as "<Count_type>"
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I click Stock Information in Hotkey
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I verify Stock UOM as "<UOM>"
    And I click on Back Button
    And I click on Back Button
    And I click on Back Button
    And I click Other Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify "<Barcode>" in list
    And I click product
    And I verify Count Type as "<Count_type>"
    And I click and enter "<Quantity>" for other location
    And I click Exit Other

    Examples:
      | Barcode   | Count_type            | Quantity | UOM     | Departments |
      #######| 108533600 | Count in Single Packs | 100      | Kg      | Butchery    |
      | 102761020 | Count in Single Packs | 100      | Kg      | Butchery    |
      | 105185558 | Count in Cases        | 100      | Singles | Fresh Prep  |
      | 102391840 | count in single kilos | 100      | Kg      | Fish Bar    |

  @sma
  Scenario Outline: Verify whether able to edit or add count(UOM: Cases, Singles) in Backup location for Mrkt St & Prepack products
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify "<Barcode>" in list
    And I click product
    And I verify Count Type as "<Count_type>"
    And I click and enter "<Quantity>" for backup location
    And I click on Back Button

    Examples:
      | Barcode   | Count_type            | Quantity | Departments |
      | 102761020 | Count in Single Packs | 100      | Butchery    |
      | 105185558 | Count in Cases        | 100      | Fresh Prep  |
      | 102391840 | count in single kilos | 100      | Fish Bar    |

  @sma
  Scenario Outline: To verify Count variance(sum_of_captures-SOH) attribute value in Backup location
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I click Backup Location
    Then I verify my min is present in the "<Departments>" or not
    And I verify Count Variance attribute

    Examples:
    | Departments |
    | Fish Bar    |
    | Butchery    |
    | Fresh Prep  |

  @sma
  Scenario Outline:TS_140 To verify that only one unique 'MarketStreetGapsHighsLows' is created in POST Store walk endpoint
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I see Please Select Location
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Given Request is made to Sma GLh Collegue Login services
    Then Service should return details for Sma Glh Login Service
    And Get the generated Access Tocken for login
    Given Request is made to post Create Storewalk services for store "<storeID>" and Type "<type>"
    And User performs operation for Storewalk Service
    Then Get Create Storewalk service response
    And I verify "<type>" is return in response

    Examples:
      | storeID | type                      | Barcode   |
      | 78      | MarketStreetGapsHighsLows | 104581911 |

  @sma
  Scenario Outline:TS_141 To verify walktype already created then API needs to return existing walk Id to application in store walk API
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I see Please Select Location
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Given Request is made to Sma GLh Collegue Login services
    Then Service should return details for Sma Glh Login Service
    And Get the generated Access Tocken for login
    Given Request is made to post Create Storewalk services for store "<storeID>" and Type "<type>"
    And User performs operation for Storewalk Service
    Then Get Create Storewalk service response
    And I verify walkid is return in response

    Examples:
      | storeID | type                      | Barcode   |
      | 78      | MarketStreetGapsHighsLows | 104695783 |

  @sma
  Scenario Outline:TS_142 To verify create store walk API has the check for the curfew store from config service and return the flag in response
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Market Street
    And I click Market Street Gaps,Highs,Lows
    And I see Please Select Location
    And I click Counter & Fixture location
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Given Request is made to Sma GLh Collegue Login services
    Then Service should return details for Sma Glh Login Service
    And Get the generated Access Tocken for login
    Given Request is made to post Create Storewalk services for store "<storeID>" and Type "<type>"
    And User performs operation for Storewalk Service
    Then Get Create Storewalk service response
    And I verify curfew store flag is return in response

    Examples:
      | storeID | type                      | Barcode   |
      | 78      | MarketStreetGapsHighsLows | 104695783 |

  @sma
  Scenario Outline:SMA_23108 To verify create walkitem api whether creates walkitem for walktype: MarketStreetGapsHighsLows for Prepack & Market street  product.
    Given Request is made to Sma GLh Collegue Login services
    Then Service should return details for Sma Glh Login Service
    And Get the generated Access Tocken for login
    Given Request is made to post Create Storewalk services for store "<storeID>" and Type "<type>"
    And User performs operation for Storewalk Service
    Then Get Create Storewalk service response
    Given Request is made to post Create Storewalk item services for store "<storeID>" and Products "<products>"
    And User performs operation for Storewalk Service
    Then Get Create Storewalk item service response
    And I verify "<type>" is return in response
    And I Verify API response is 201

    Examples:
      | storeID | type                      | products  |
      | 78      | MarketStreetGapsHighsLows | 104695783 |