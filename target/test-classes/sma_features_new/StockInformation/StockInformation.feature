@stock_information701 @regression @store_walk
Feature: Verify StockInformation scenarios

  @TC_01_Verify_Screen_Elements_On_StockInformation @sma
  Scenario Outline: TC_01_Verify_Screen_Elements_On_StockInformation
  stock_information701
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I search for "<barcode>"
    Given Request is made to verify Product Id "<barcode>" is included in the service
    When Request is made into Price service
    Then Service should return the details of the service
    And verify that all the expected fields are present in Stock Information screen
    And verify that Price section is visible
    And verify that Stock section is visible
    And verify that LastCapture section is visible
    And verify that Space section is visible
    And verify that Deliveries section is visible
    And I logout of the system

    Examples:
      | barcode   |
      | 100688560 |
      | 107597505 |
     #| 109038707|
     #| 107597521|
     #|100402904|

  @sma
  Scenario Outline: TC_02_Verify Price & Promo screen
  --Pre-Requisite :: Price information must be available in price db

    Given Storeid"<StoreID>" and ProductId "<Barcode>" is included in the service
    When Request is made into Price service
    Then Service should return the details of the Price service
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Given Verify ProductId "<Barcode>" is included in the service
    And verify that Price section is visible
    And I click on Price section
    Then I verify the details on the price Page
    And I click on Back Button

    Examples:
      | Barcode   | StoreID |
      | 109345459 | 8      |
      | 100402904 | 8      |
      | 107819577 | 8      |
#     | 109038707 | 8      |
#     |100162509  |8       |

   @sma
  Scenario Outline: TC_03_Verify Price when NO PROMOTION present
  --Pre-Requisite :: No Promotion information must be available

    Given Storeid"<StoreID>" and ProductId "<Barcode>" is included in the service
    When Request is made into Price service
    Then Service should return the details of the Price service
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
     Then I click on "Stock Information" on Home Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Given Verify ProductId "<Barcode>" is included in the service
    And verify that Price section is visible
    And I click on Price section
    Then I verify the details on the price Page
    Then I verify that No Promotion details is present
    And I click on Back Button

    Examples:
      | Barcode   | StoreID |
      | 109345459 | 8      |
      | 100402904 | 8      |
#     | 107819577 |  8     |
#     | 109038707 | 8      |

  @sma
  Scenario Outline: TC_04_Verify Product Details on screen

    Given Request is made to verify Product Id "<Barcode>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service
    Given Verify ProductId "<Barcode>" is included in the service

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Given ProductId "<Barcode>" is included in the servce
    And verify that all the expected fields are present in Stock Information screen
    Then I verify product onscreen details with the service
    And I logout of the system

    Examples:
      | Barcode   | StoreID |
      | 103853612 | 8      |
      | 109345459 | 8      |
      | 100402904 | 8      |
#     | 100139085 | 8 |
#     | 109038707 | 8 |

  @sma @SItt
  Scenario Outline: TC_05_Verify Stock Information Space Screen
  --Pre-Requisite :: Space record must be present in the Db
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number

    Given Request is made to verify Product Id "<Barcode>" is included in the service
    When Request is made into Product service
    Then Service should return the details of the service

    And verify that Space section is visible
    And I click on Space section
    Then I verify the details on the space Page
    Then I verify the record from the list
    Then I verify the table values
    Examples:
      | Barcode   | StoreID |
      | 100688560 | 8      |
#      | 108682568 |       8 |Space record=0
      | 107957970 | 8      |
#   | 108755624 |       8 |Space record=0
  ########For UAT store 23:###########
# #      | 109543666 | 23      |
# #      | 109558067 | 23       |

  @sma @TC_06_VerfScen
  Scenario Outline: Generate Google Access Token. This is a Pre-requisite for all Counts modules
#    Given Request is made to SMA app login service for manager user
#    Then Service should return details for SMA app Login Service
    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I get the field value for the field "access_token"
    And Get the generated Access Tocken for SMA app Login Service

    Examples:
      | reqdata | Item   |
      | 8       | 432435 |

  @sma @TC_06_VerfScen
  Scenario Outline: TC_06_Verify Deliveries section

  ################## select * from orders where ship_to_location_id = 8 and item_id in ('104805170','109306652')
  ################## For each item, 2 entries should be present in db.
  ################## For receipted entry, Update final_order_date( current date - 2) , date_availability_expected(current date), date_delivery_expected( current date -1)
  ################## For ordered entry, Update final_order_date( current date - 2) , date_availability_expected(current date + 1), date_delivery_expected( current date)

#    Given Request is made to Markdown Login service
#    Then The service should return details for Login Service
#    Given request is made to capture access token and post endpoint for user v2 for "<reqdata>"
#    Then I Verify the Response Code for the following "<Item>" is 200
#    And I get the field value for the field "access_token"
    And Get the generated accessTocken
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the servce
    When Request is made into Delivery service
    Then Service should return the details of the Delivery service
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Given Request is made to verify Product Id "<Barcode>" is included in the service
    When Request is made into Price service
    Then Service should return the details of the service
    And I scroll Down
    And verify that Deliveries section is visible
    And Then I verify dates and qty
    And Then I verify the details with endpoints

    Examples:
      | Barcode   | StoreID |
      ##| 104805170 | 8      |
      | 109306652 | 8      |
      | 100002101 | 8      |

  @sma @TC_07_VerifyStockPage
  Scenario Outline: TC_07_Verify Stock Page when NO DATA PRESENT
  ############# DB name = Stock_V2
  ############# update with previous date
  ############# update stock_item set updated_on='2021-02-05 09:26:51.718+00' where item_id IN ('100404539','109961278','109437505','102066641') and location_id='78'
  When I connect to the "Test" database and fire a select query to get a single column as "taxid" with query as "Select * From xref limit 1"
# When I connect to "Stock V2" database and fire a update query as "update stock_item set updated_on='2021-02-05 09:26:51.718+00' where item_id IN ('100404539','109961278','109437505','102066641') and location_id='78'"
# And I check the results in another Step Def File
    Given ProductId "<Barcode>" and StoreID "<StoreID>" is included in the Stock Service
    When Request is made into Stock service
    Then Service should return the details of the Stock service
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And verify that Stock section is visible
    And I Verify that if No record present the status is displayed as UPDATING
    And I click on Stock record
    And I verify Stock info page is displayed as expected
    
    Examples:
      | Barcode   | StoreID |
      | 109961278 | 8      |
      | 109437505 | 8      |


##################### For below scenarios Upload data in S3 ######################################
################### For SIT env - AWS nonprod-Commercial account S3 bucket path: msit.xxwmm.retail.promotionv2.batch.eeeeeeeeee/promotionv2/rpm/pending
################### For UAT env - AWS nonprod-m-ordering account S3 bucket path: muat.xxwmm.retail.promotion.eeeeeeeeee/promotionv2/pending
#
#
#   #@sma
#  #Scenario Outline: Verify Price details when Simple promotion is present
#  #When I enter Username and Password for SMA Collegue user
#  #And I click on login button for SMA
#  #Then I click on "Stock Information" on Home Page
#  #And I click on barcode entry Button
#  #Then Enter "<Barcode>" number
#  #And verify that Price section is visible
#  #And I click on Price section
#  #Then I verify the details on the price Page
#  #Then I verify that Simple Promotion details is present
#  #And I click on Back Button
#  #Examples:
#   #| ProductID   |  StoreID |
#   #| 108908651 |       8 |
#
#  #@sma
#  #Scenario Outline: Verify Price details when Complex promotion is present
#  #When I enter Username and Password for SMA Collegue user
#  #And I click on login button for SMA
#  #Then I click on "Stock Information" on Home Page
#  #And I click on barcode entry Button
#  #Then Enter "<Barcode>" number
#  #And verify that Price section is visible
#  #And I click on Price section
#  #Then I verify the details on the price Page
#  #Then I verify that Complex Promotion details is present
#  #And I click on Back Button
#
#  #Examples:
#   #| Barcode   |  StoreID |
#   #| 110203685 |       8 |
#
#  #@sma
#  #Scenario Outline: Verify Price details when More points is present
#  #When I enter Username and Password for SMA Collegue user
#  #And I click on login button for SMA
#  #Then I click on "Stock Information" on Home Page
#  #And I click on barcode entry Button
#  #Then Enter "<Barcode>" number
#  #And verify that Price section is visible
#  #And I click on Price section
#  #Then I verify the details on the price Page
#  #Then I verify that More points details is present
#  #And I click on Back Button
#  #Examples:
#   #| Barcode   |  StoreID |
#   #| 105491441 |       8 |
