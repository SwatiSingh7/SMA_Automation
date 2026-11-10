@61NewGlhPart1New_701
Feature: Scan GLH Mins with different count type and UOMs

  @sma @bb
  Scenario Outline: Create SOH for items
    Given I create SOH for the Items based on Response code "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
    Examples:
      | storeID |
      | 65      |

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma @VerfCompleteAreaCount
  Scenario Outline: Delete GLH Storewalk from Service
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service
    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Verify Get storewalks service response for current date
    Then Delete request is made to Delete GLH storewalk for store id "<storeID>"

    Examples:
      | storeID | capturetype   |
      | 8      | GapsHighsLows |

  @sma @rrt
  Scenario Outline: Verify and Scan Count_type 'Single' and 'Cases' having UOM 'EA' of MIN for all department which include 'Positive' SOH in AM GLH

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

#    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on Low button
#    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for "GapsHighsLows"

    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not
#    And I logout of the system
#	 
#	Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
#    When Request is made into Stock service
#    Then Service should return the details of the Stock service
#

    Examples:
      | StoreID | Barcode   | Category        | Department                     | Quantity | Typee         | captureType | captureStatus | sectionStatus | stockUOM | actionType | countType |
      | 8       | 104065909 | MarketStreet    | Bakery                         | 7        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 104065909 |
      | 8       | 111358136 | Alcohol         | Alcohol                        | 6        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 111358136 |
      | 8       | 107126295 | Grocery         | Grocery(Canned & Packet Goods) | 6        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 107126295 |
      | 8       | 108629804 | Home & Leisure  | Home & Leisure                 | 9        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 108629804 |
      | 8       | 110995598 | Health & Beauty | Health & Beauty                | 7        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 110995598 |
      | 8       | 102370168 | Bakery          | Bread & Cakes                  | 7        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 102370168 |
      | 8       | 105541065 | Fresh           | Dairy                          | 7        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 105541065 |
      | 8       | 100001497 | Frozen          | Frozen                         | 4        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 100001497 |
      | 8       | 104003441 | Tobacco         | Tobacco                        | 7        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 104003441 |
      | 8       | 104065909 | MarketStreet    | Bakery                         | 7        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 104065909 |
      | 8       | 110747754 | MarketStreet    | Oven Fresh/Baked               | 1        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 110747754 |
      | 8       | 108810996 | MarketStreet    | Oven Fresh/Baked               | 6        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 108810996 |
      | 8       | 109361221 | MarketStreet    | Cake Shop                      | 7        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 109361221 |



		#		|78	|	111069001|Fresh|Chilled|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
		#		|78	|	102370141|Breads & Cakes|Bought in Bakery|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
		#		|78	|  110276411|Grocery|Grocery(Canned & Packet Goods) |KG |Singles|
		#		 |      78 |105398043 | Fruit & Veg |Fruit & Veg    |

  @sma @Single&Cases
  Scenario Outline: Verify and Scan Count_type 'Single' and 'Cases' having UOM 'KG' of MIN for all department which include 'Positive' SOH in AM GLH
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

#    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on High button
#    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for "GapsHighsLows"

    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not

    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
#    And I logout of the system


    Examples:
      | StoreID | Barcode   | Category     | Department  | Quantity | Typee         | captureType | captureStatus | sectionStatus | stockUOM | actionType | countType |
      | 8       | 108394582 | Fruit & Veg  | Fruit & Veg | 3        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 108394582 |
      | 8       | 108524922 | Fruit & Veg  | Fruit & Veg | 9        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 108524922 |
      | 8       | 108543859 | Fruit & Veg  | Fruit & Veg | 9        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 108543859 |
      | 8       | 108368632 | Fruit & Veg  | Fruit & Veg | 9        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 108368632 |
      | 8       | 108335700 | Fruit & Veg  | Fruit & Veg | 9        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 108335700 |
      | 8       | 108335777 | Fruit & Veg  | Fruit & Veg | 9        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 108335777 |
      | 8       | 109202204 | Fruit & Veg  | Fruit & Veg | 9        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 109202204 |
      | 8       | 104058522 | MarketStreet | Deli        | 9        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 104058522 |

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

  @sma @runFro
  Scenario Outline: Verify and Scan Count_type 'Single' and 'Cases' having UOM 'PCS' of MIN for all department which include 'Positive' SOH in AM GLH
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

#    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
#    And I click on High button
#    And I enter quantity "<Quantity>" for fixture and warehouse
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for "GapsHighsLows"

    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not

    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
#    And I logout of the system


    Examples:
      | StoreID | Barcode   | Category       | Department       | Quantity | Typee         | captureType | captureStatus | sectionStatus | stockUOM | actionType | countType |
      | 8       | 108779061 | MarketStreet   | Cake Shop        | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 108779061 |
      | 8       | 107694381 | Fresh          | Chilled          | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 107694381 |
      | 8       | 103853612 | Fruit & Veg    | Fruit & Veg      | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 103853612 |
      | 8       | 102370011 | Breads & Cakes | Bought in Bakery | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 102370011 |
      | 8       | 102369685 | Breads & Cakes | Bought in Bakery | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 102369685 |
      | 8       | 102369685 | MarketStreet   | Deli             | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 102369685 |
      | 8       | 105198164 | MarketStreet   | Cake Shop        | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 105198164 |
      | 8       | 109361221 | MarketStreet   | Cake Shop        | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 109361221 |
      | 8       | 108361326 | Fruit & Veg    | Fruit & Veg      | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 108361326 |
      | 8       | 108414361 | Fruit & Veg    | Fruit & Veg      | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 108414361 |

###################################################################################################################################################
  @smaa @ToRunNow
  Scenario Outline: Verify and Scan Count_type 'Single' and 'Cases' having UOM 'EA' of MIN for all department which include 'Negative' SOH in AM GLH

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

#    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
#    And I click on Low button
#    And I Enter the Low quantity "<Quantity>"
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for "GapsHighsLows"

    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not
#    And I logout of the system


    Examples:
      | StoreID | Barcode   | Category       | Department       | Quantity | Typee         | captureType | captureStatus | sectionStatus | stockUOM | actionType | countType |
#		|78	|	101545721|Alcohol|Alcohol|10 |GapsHighsLows |	Low|Incomplete|Available|EA|Include|singles|
#		|78	|	107126295|Grocery|Grocery(Canned & Packet Goods)|10 |GapsHighsLows |Low|Incomplete|Available|EA|Include|singles|
#		|78|	108629804|Home & Leisure|Home & Leisure|10 |GapsHighsLows |Low|Incomplete|Available|EA|Include|singles|
#		|78	|	110995598|Health & Beauty|Health & Beauty|10 |GapsHighsLows |Low|Incomplete|Available|EA|Include|singles|
#		|78|102370168|Bakery|Bread & Cakes|10 |GapsHighsLows |Low|Incomplete|Available|EA|Include|singles|
#		|78|105541065|Fresh|Dairy|10 |GapsHighsLows |Low|Incomplete|Available|EA|Include|singles|
      | 8       | 100007066 | Frozen         | Frozen           | 1        | GapsHighsLows | Count       | Incomplete    | Available     | EA       | Include    | 100007066 |
#		|78|104003441|Tobacco|Tobacco|10|GapsHighsLows |Low|Incomplete|Available|EA|Include|singles|
#		|78|104065909|MarketStreet|Bakery|10|GapsHighsLows |Low|Incomplete|Available|EA|Include|cases|
#		|78|110747754|MarketStreet|Oven Fresh/Baked|3|GapsHighsLows |Low|Incomplete|Available|EA|Include|cases|
#		|78|108810996|MarketStreet|Oven Fresh/Baked|5|GapsHighsLows |Low|Incomplete|Available|EA|Include|cases|
#		|78|109361221|MarketStreet|Cake Shop|6|GapsHighsLows |Low|Incomplete|Available|EA|Include|cases|
      | 8       | 102370141 | Breads & Cakes | Bought in Bakery | 2        | GapsHighsLows | Count           | Incomplete    | Available     | EA       | Include    | 102370141 |


		#		|78	|	111069001|Fresh|Chilled|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
		#		|78	|	102370141|Breads & Cakes|Bought in Bakery|100 |GapsHighsLows |Low|Incomplete|Available|Give stock in single units|Complete|CountComplete|On shelf|EA|Include|singles|
		#		|78	|  110276411|Grocery|Grocery(Canned & Packet Goods) |KG |Singles|
		#		 |      78 |105398043 | Fruit & Veg |Fruit & Veg    |

  @smaa
  Scenario Outline: Verify and Scan Count_type 'Single' and 'Cases' having UOM 'KG' of MIN for all department which include 'Negative' SOH in AM GLH
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

#    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
#    And I click on High button
#    And I enter quantity "<Quantity>" for fixture and warehouse
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for "GapsHighsLows"

    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not

    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
#    And I logout of the system


    Examples:
      | StoreID | Barcode   | Category    | Department  | Quantity | Typee         | captureType | captureStatus | sectionStatus | stockUOM | actionType | countType |
      | 8       | 108394582 | Fruit & Veg | Fruit & Veg | 3        | GapsHighsLows | Count       | Incomplete    | Available     | KG       | Include    | 108394582 |
#		|78|	108524922	|Fruit & Veg |Fruit & Veg| 10 |GapsHighsLows |High|Incomplete|Available|KG|Include|singles|
#		|78|	108543859	|Fruit & Veg |Fruit & Veg| 10 |GapsHighsLows |High|Incomplete|Available|KG|Include|singles|
#		|78|	108368632	|Fruit & Veg |Fruit & Veg| 10 |GapsHighsLows |High|Incomplete|Available|KG|Include|cases|
#		|78|	108335700	|Fruit & Veg |Fruit & Veg| 10 |GapsHighsLows |High|Incomplete|Available|KG|Include|cases|
#		|78|	108335777	|Fruit & Veg |Fruit & Veg| 10 |GapsHighsLows |High|Incomplete|Available|KG|Include|cases|
#		|78|	109202204	|Fruit & Veg |Fruit & Veg| 10 |GapsHighsLows |High|Incomplete|Available|KG|Include|cases|
#		|78|	104058522	|MarketStreet |Deli	| 10 |GapsHighsLows |High|Incomplete|Available|KG|Include|singles|



  @smaa
  Scenario Outline: Verify and Scan Count_type 'Single' and 'Cases' having UOM 'PCS' of MIN for all department which include 'Negative' SOH in AM GLH
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

#    Then I click on AM Gaps Lows High
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
#    And I click on High button
#    And I enter quantity "<Quantity>" for fixture and warehouse
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on Back Button

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service


    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then Get Walkids from Getstorewalk service Store id "<StoreID>"
    And Get the walk id for "GapsHighsLows"

    Given Get request is made to Get walkItem service for store id "<StoreID>" and product id "<Barcode>"
    And Get Operation perform on service request
    Then Verify Get walkitem service response
    And I Verify Get walkitem UOM "<stockUOM>",Count Type "<countType>", SOH and Action Type "<actionType>"
    And I verify Get walkitem pack is present or not

    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
#    And I logout of the system


    Examples:
      | StoreID | Barcode   | Category     | Department | Quantity | Typee         | captureType | captureStatus | sectionStatus | stockUOM | actionType | countType |
      | 8       | 108779061 | MarketStreet | Cake Shop  | 3        | GapsHighsLows | Count       | Incomplete    | Available     | PCS      | Include    | 108779061 |
#		|78|107694381|Fresh|Chilled|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|singles|
#		|78|103853612|Fruit & Veg|Fruit & Veg|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|singles|
#		|78|102370011|Breads & Cakes|Bought in Bakery|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|singles|
#		|78|102369685|Breads & Cakes|Bought in Bakery|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|singles|
#		|78|102369685|MarketStreet|Deli|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|singles|
#		|78|105198164|MarketStreet|Cake Shop|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|cases|
#		|78|109361221|MarketStreet|Cake Shop|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|cases|
#		|78|108361326|Fruit & Veg|Fruit & Veg|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|singles|
#		|78|108414361|Fruit & Veg|Fruit & Veg|2|GapsHighsLows |High|Incomplete|Available|PCS|Include|singles|
#
  @sma @VerfCompleteAreaCount
  Scenario Outline: Verify Complete Area Count and Review Ready status at warehous


    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click on "Shop Floor - Gap Scan"
    Then I click on WareHouse
    Then I verify my min is present in the "<Department>" or not
#    Then I will enter the required quantity and click on confirm
    Then I click on Confirm Area Count
    Then I click on Confirm message after verifying it
    And I click on Back Button
    Then I click on Review
    Then I verify my min is present in the "<Department>"
    Then I select the "<Department>" and verify the status as ReviewReady

#    Given Request is made to SMA app login service for collegue user
#    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service

    Given Get request is made to Get storewalks service for current date
    And Get Operation perform on service request
    Then I verify Product id "<Barcode>" for Store id "<StoreID>" and Walk type "<Typee>" is present in Get storewalk service
    Then I verify Capture details in storewalk for Product id "<Barcode>" is Capture type "<captureType>" Capture status "<captureStatus>" and Capture quantity "<Quantity>"
    Then I verify Section status is "<sectionStatus>" in Get storewalk service
#    And I logout of the system

    Examples:
      | StoreID | Barcode   | Category        | Department                      | Quantity | Typee         | captureType | captureStatus | sectionStatus | stockUOM | actionType | countType | captureStatus | sectionStatus |
      | 8       | 111358136 | Alcohol         | Alcohol                         | 6        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
      | 8       | 107126295 | Grocery         | Grocery (Canned & Packet Goods) | 6        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
      | 8       | 108629804 | Home & Leisure  | Home & Leisure                  | 9        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
      | 8       | 108524922 | Fruit & Veg     | Fruit & Veg                     | 9        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
      | 8       | 110995598 | Health & Beauty | Health & Beauty                 | 7        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
      | 8       | 102370168 | Bakery          | Bread & Cakes                   | 7        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
      | 8       | 105541065 | Fresh           | Dairy                           | 7        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
      | 8       | 100001497 | Frozen          | Frozen                          | 4        | GapsHighsLows | Count       | Complete      | CountComplete | EA       | Include    | singles   | Complete      | CountComplete |
#      | 8       | 104003441 | Tobacco         | 10                             | GapsHighsLows | Low           | Incomplete  | Available     | EA            | Include  | singles    | Complete  | CountComplete | CountComplete |


