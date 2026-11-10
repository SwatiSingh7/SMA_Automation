@sales_order
Feature: Sales Order functionality


  @sma
  Scenario Outline: Verify categories displayed on app UI matches with Services
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Get Sales Order Departments
    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Given Get forecast order service for store id "<storeId>" and get Total product count for all categories
    And I Verfiy Categories displayed on UI app and Services matched

    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: Verify total product count for categories on UI matches with Services
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Get Total Products count on UI
    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Given Get forecast order service for store id "<storeId>" and get Total product count for all categories
    And I Verfiy Product count on UI app and Services matched

    Examples:
      | storeId |
      | 78      |


  @sma
  Scenario Outline: Select dropdown as all Orders and Verify product name on UI matches with Services
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    And I Click on Dropdown list
    Then I Select the All Orders Dropdown
    And I Get Product details on UI

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    And Get category id for the "<deptName>" department
    Given I Get Forecast orders response from service for store id "<storeId>"

    And I Verify Product on UI and Service matches
    Examples:
      | storeId | deptName |
      | 78      | Fish     |

  @sma
  Scenario Outline: Select dropdown as Amendable Orders and Verify product name on UI matches with Services
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    And I Click on Dropdown list
    Then I Select a Amendable Orders Dropdown
    And I Get Product details on UI

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    And Get category id for the "<deptName>" department
    Given I Get Forecast orders response from service for store id "<storeId>"

    And I Verify Amend Product on UI and Service matches
    Examples:
      | storeId | deptName |
      | 78      | Fish     |

  @sma
  Scenario Outline: Select dropdown as Non Amendable Orders and Verify product name on UI matches with Services
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    And I Click on Dropdown list
    Then I Select a Non-Amendable Orders Dropdown
    And I Get Product details on UI

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    And Get category id for the "<deptName>" department
    Given I Get Forecast orders response from service for store id "<storeId>"

    And I Verify Non Amend Product on UI and Service matches
    Examples:
      | storeId | deptName |
      | 78      | Fish     |


  @sma
  Scenario Outline: I Verify Previous link response from api service

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    And Get category id for the "<deptName>" department
    Given I Get Forecast orders response from service for store id "<storeId>"

    And I Verify Previous link response from service
    Examples:
      | storeId | deptName |
      | 78      | Fish     |


  @sma
  Scenario Outline: I Verify Next link response from api service

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    And Get category id for the "<deptName>" department
    Given I Get Forecast orders response from service for store id "<storeId>"

    And I Verify Next link response from service
    Examples:
      | storeId | deptName |
      | 78      | Fish     |


  @sma
  Scenario Outline: I Verify Offset and Count attribute values in Services

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    And Get category id for the "<deptName>" department
    Given I Get Forecast orders response from service for store id "<storeId>"

    And I Verify Offset and Count attribute response from service
    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
 
########-----------------------------------------------------------------------------------------------------------------------

  @sma
  Scenario Outline: Select Amendable products and verify Week details on UI matches with Services
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select a Amendable Orders Dropdown
    Then I Verify Amendable Orders Product list is displayed
    Then I Select a Amendable order Product
    Then I Get product min value
    Then I Get Amendable product details and week details on UI

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    And Get category id for the "<deptName>" department
    Given Request is made to Get Order Item details services for item "<storeId>"
    And User performs operation on SO service
    Then Get Item details Response from services

    And I verify Amendable product week details displayed on UI matches with services

    Examples:
      | storeId | deptName |
      | 78      | Fish     |


  @sma
  Scenario Outline: Verify valid dates, maximum value increase and maximum value decrease displayed on UI matches with Services
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select a Amendable Orders Dropdown
    Then I Verify Amendable Orders Product list is displayed
    Then I Select a Amendable order Product
    Then I Get product min value
    Then I Get maximum increase and maximum decrease value

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Then I Get category id for selected category department
    Given Request is made to Get Order Item details services for item "<storeId>"
    Then Get Item details Response from services

    And I verify maximum increase and maximum decrease value displayed on UI matches with services

    Examples:
      | storeId |
      | 78      |
 
 
 
  #######################################-------------------------------------------------------------------------------------------------------------
 #####  SMA-18506
  @sma
  Scenario Outline: Verify that when new menu option added in SMA app home screen as  "Sales Order" and clicking on page then user should navigate to sales order landing screen which should be list of configured departments.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    Examples:
      | storeId |
      | 78      |

  @sma
  Scenario Outline: Verify that when all the configured departments are correctly displayed in the department list screen and clicking on any department then respective department page should get open with order list.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I click on departments and verify respective department page is displayed
    Examples:
      | storeId |
      | 78      |
  
  ####################################  SMA-19045 ###########################################################
 
 ## SMA-19045
  @sma
  Scenario Outline: Verify that when User clicks on back arrow then User is navigated to the department list screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I click on the Back Button
    And I Verify Departments under Sales order menu are displayed

    Examples:
      | storeId |
      | 78      |
  
   
   ########  SMA-19045
  @sma
  Scenario Outline: Verify that when the product is Amendable and the user clicks on product then the product information page is displayed.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    And I Click on Dropdown list
    Then I Select a Amendable Orders Dropdown
    And I Select a Amendable order Product
    Then I verify product information screen is displayed

    Examples:
      | storeId | deptName |
      | 78      | Fish     |
   
  
   
     ################# SMA-19045
  @sma
  Scenario Outline: Verify that when the product is Non Amendable then it should be non clickable
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select a Non-Amendable Orders Dropdown
    Then I Verify Non-Amendable Orders Product list is displayed
    And I verify Non-Amemdable order product is not clickable

    Examples:
      | storeId | deptName |
      | 78      | Fish     |

  @sma
  Scenario Outline: Verify Three dropdowns present n UI - All Orders, Amendable Orders and Non-amendable orders
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Verify dropdown values - All orders, Amendable Orders and Non-amendable Orders are present

    Examples:
      | storeId |
      | 78      |


  @sma
  Scenario Outline: Verify Amend text is displayed for Amendable products
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select a Amendable Orders Dropdown
    Then I Verify Amendable Orders Product list is displayed
    And I verify for Amendable products Amend text is displayed

    Examples:
      | storeId | deptName |
      | 78      | Fish     |

  @sma
  Scenario Outline: Verify that when the product is Amendable then it should be Order is clickable
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select a Amendable Orders Dropdown
    Then I Verify Amendable Orders Product list is displayed
    And I verify for Amendable products Amend text is displayed
    Then I Select a Amendable order Product
    And I verify Amemdable order product is clickable


    Examples:
      | storeId | deptName |
      | 78      | Fish     |
 
 

       ################# SMA-19045
  @sma
  Scenario Outline: Verify that when User selects All Orders filter then the Order list will display both Amendable and Non Amendable products
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select the All Orders Dropdown
    Then I verify the Order list is displayed with both Amendable and Non Amendable products

    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
         ################# SMA-19045
  @sma
  Scenario Outline: Verify that when User selects Amendable Orders filter then the Order list will display Amendable products
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select a Amendable Orders Dropdown
    Then I Verify Amendable Orders Product list is displayed

    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
  
         ################# SMA-19045
  @sma
  Scenario Outline: Verify that when User selects Non Amendable Orders filter then the Order list will display Non Amendable products
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    Then I Click on Dropdown list
    And I Select a Non-Amendable Orders Dropdown
    Then I Verify Non-Amendable Orders Product list is displayed

    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
 
      #################  SMA-19045
  @sma
  Scenario Outline: Verify that when The selected department has no products then The Order list will display empty lists
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed

    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Given Get forecast order service for store id "<storeId>" and get Total product count for all categories
    And I Select a Department with no products
    Then I verify Empty order lists is displayed

    Examples:
      | storeId |
      | 78      |
 
      ################# SMA-19045
  @sma
  Scenario Outline: Scroll till end of the page and verify page is loading completely
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I Scroll till end of the page and verify page is loading completely

    Examples:
      | storeId |
      | 78      |
  
   #################SMA-19045
  @sma
  Scenario Outline: Verify that when User selects All Orders filter then the Order list will display both Amendable and Non Amendable products
    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Given Get forecast order service for store id "<storeId>" and get Total product count for all categories
    Then I Get Amended orders from service

    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
  
    ################  SMA-19045
  @sma
  Scenario Outline: Verify that the order list will be sorted in ascending order of department id
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department "<deptName>" from department screen
    Then I Verify Product list is displayed
    And I get product description from product list on UI
    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Then Get category id for the "<deptName>" department
    Given I Get Forecast orders response from service for store id "<storeId>"
    And Verify that the order list is sorted in ascending order of department id

    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
  
   ################    SMA-19045
  @sma
  Scenario Outline: Verify Get category master details service response
    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services

    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
   ################  SMA-19045
  @sma
  Scenario Outline: Verify Order intervention service response
    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Given I Get Forecast orders response from service for store id "<storeId>"
    Examples:
      | storeId | deptName |
      | 78      | Fish     |
  
  
  
  
  
  ###################-------------------------- Search fucntioanlity-----------------------------------------------------------------------------------------------------
   
  
   
   
  ################   SMA-20297
  @sma
  Scenario Outline: Verify that when The Orderlist screen is displayed  then The Orderlist screen shows the Search icon at the top along with the product count and amendable orders filter.
    Given Request is made to SMA SO Collegue Login services
    Then Service should return details for Login Service for SMA app
    And I Get the generated accessTocken for sales order
    Given Request is made to get Category departments service is called for location id "<storeId>"
    And User performs operation on SO service
    Then Service should return response for Get Category departments services
    Given Get forecast order service for store id "<storeId>" and get Total product count for all categories


    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    And I verify product count is displayed
    Then I Click on Dropdown list
    And I Verify dropdown values - All orders, Amendable Orders and Non-amendable Orders are present

    Examples:
      | storeId |
      | 78      |
 
  ################# SMA-20297
  @sma
  Scenario Outline: Verify that when The User selects Search in the Orderlist screen then The product search screen is displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed

    Examples:
      | storeId |
      | 78      |
 
  #################SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by product number
  ########### and The product exists in the product service and The product is ranged to this Store in the Orderintervention db then The product(s) matching the search criteria is displayed in the search results
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product id "<productId>" in search box
    And I verify search result

    Examples:
      | storeId | productId |
      | 78      | 102391735 |
 
  ################# SMA-20297
  @sma
  Scenario Outline: Verify that when the User enters search criteria and Search by product number
  ########### and The product exists in the product service and The product is ranged to this Store in the Orderintervention db then The product(s) matching the search criteria is displayed in the search results
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product id "<productId>" in search box
    And I verify search result

    Examples:
      | storeId | productId |
      | 78      | 102391735 |
 
 
  ################# SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by product name 
  ###and The product exists in the product service and The product is ranged to this Store in the Orderintervention db then The product(s) matching the search criteria is displayed in the search results
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName    |
      | 78      | MONKFISH TAILS |
 
 ################# SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by long product name with special chars
  and The product exists in the product service and The product is ranged to this Store in the Orderintervention db  then The product(s) matching the search criteria is displayed in the search results
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      | MONKFISH    |
 
 ################# SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by partial product name with starting chars 
  #and The product exists in the product service and The product is ranged to this Store in the Orderintervention db  then The product(s) matching the search criteria is displayed in the search results
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      | MONK        |
 
 
 
 ############### SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by partial product number then The search results display 'No Product found'.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product id "<productId>" in search box
    And I verify No product found as search result

    Examples:
      | storeId | productId |
      | 78      | 1010      |
 
 ############### SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by partial product name with middle chars
  and The product exists in the product service and The product is ranged to this Store in the Orderintervention db  then The product(s) matching the search criteria is displayed in the search results .
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      | Monk        |
 
 ################# SMA-20297
  @sma
  Scenario Outline:  Verify that when The User enters search criteria and Search by product name and The product doesn't exist in the product service and The product is not ranged to this Store in the Orderintervention db  then The search results display 'No Product found'.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      |             |
 
  ################# SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by product name and The product exists in the product service and The product doesn't exist in the orderintervention db  then The search results display 'No Product found'.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      |             |
 
 ################ SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by product name and The product exists in the product service and The product is not ranged to this Store in the Orderintervention db  then The search results display 'No Product found'.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      |             |
 
 ############## SMA-20297
  @sma
  Scenario Outline: Verify that when The product search screen is displayed  then The user can go back to the Orderlist screen with previous screen position retained
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I click on back button
    And Then I Verify Product list is displayed

    Examples:
      | storeId |
      | 78      |
 
 ############## SMA-20297
  @sma
  Scenario Outline: Verify that when The product(s) matching the search criteria is displayed in the search results and The product is amendable  then The product is displayed as amendable with 7 days forecast
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter amendable product id "<productId>" in search box
    And I verify search result
    And I verify product is amendable
    And I verify product is displayed as amendable with 7 days forecast

    Examples:
      | storeId | productId |
      | 78      | 102391735 |
 
 ############## SMA-20297
  @sma
  Scenario Outline: Verify that when The product(s) matching the search criteria is displayed in the search results and The product is non amendable  then The product is displayed as non amendable with 7 days forecast ( This will be displayed irrespective of the amendable orders filter selection)
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter non amendable product name "<productName>" in search box
    And I verify search result
    And I verify product is non amendable
    And I verify product is displayed as non amendable with 7 days forecast

    Examples:
      | storeId | productName                  |
      | 78      | MORRISONS SWEET POPCORN 350G |
 
 ################ SMA-20297
  @sma
  Scenario Outline: Verify that when The product(s) matching the search criteria is displayed in the search results and The product is amendable and already amended  then The product is displayed as amendable with amended qty displayed in orange
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      |             |
 
 ################ SMA-20297
  @sma
  Scenario Outline:  Verify that when The product is displayed as amendable with 7 days forecast  then The amendable product in search results is selected and navigate to the amend screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName |
      | 78      |             |
 
 ############### SMA-20297
  @sma
  Scenario Outline:  Verify that when The product is displayed as non amendable with 7 days forecast  then The amendable product in search results can not be clicked
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName    |
      | 78      | MONKFISH TAILS |
 
 ############## SMA-20297
  @sma
  Scenario Outline:  Verify that when The product is displayed as non amendable with 7 days forecast  then The amendable product in search results can not be clicked
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter non amendable product name "<productName>" in search box
    And I verify search result
    And I verify product is non amendable
    And I verify product is displayed as non amendable with 7 days forecast
    Then I verify non amendble order is not clickable

    Examples:
      | storeId | productName                  |
      | 78      | MORRISONS SWEET POPCORN 350G |
 
 ############### SMA-20297
  @sma
  Scenario Outline: Verify that when The user amends the Order Qty  then The user navigates back to search results screen after order amendment
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName                  |
      | 78      | MORRISONS SWEET POPCORN 350G |
 
  ##############SMA-20297
  @sma
  Scenario Outline: Verify that the Search box highlights as "Search by product name or number" in background of search box
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    And I verify Search by product name or number text is displayed on search box

    Examples:
      | storeId |
      | 78      |
 
 ################ SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by product name and The product exists in the product service and The product is ranged to this Store but is not in selected department  in the Orderintervention db  then The search results display 'No Product found'.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName                  |
      | 78      | MORRISONS SWEET POPCORN 350G |
 
  ##############SMA-20297
  @sma
  Scenario Outline: Verify that when The Item search returns more than 20 Items the User is able to scroll all items
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter non amendable product name "<productName>" in search box
    And I verify search result
    Then I verify page is loading completely

    Examples:
      | storeId | productName                  |
      | 78      | MORRISONS SWEET POPCORN 350G |
 
 ################ SMA-20297
  @sma
  Scenario Outline: Verify that when The User enters search criteria and Search by barcode and The product exists in the product service and The product is ranged to this Store in the Orderintervention db  then 'No product found' is displayed in the search results
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I Click on Marketstreet menu
    And I Verify Sales Order menu is Displayed
    Then I Click on Sales Order menu
    Then I Verify Departments under Sales order menu are displayed
    And I Select a Department from department list
    Then I Verify Product list is displayed
    And I verify Search icon is displayed
    Then I click on Search icon
    And I verify product search screen is displayed
    Then I enter product name "<productName>" in search box
    And I verify search result

    Examples:
      | storeId | productName                  |
      | 78      | MORRISONS SWEET POPCORN 350G |


###########################################################################################################################################################
#################### Pending -  Need to test 

#
 #@sma
  #Scenario Outline: Click on product, select day and verify popup is displayed
 #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #
  #Examples:
  #| storeId |
 #|       78 |
 #
 #@sma
  #Scenario Outline: Verify Order amendable message
 #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #Then I Select amend order value from popup
  #And I Click on confirm button
  #And I Verify Order amendable message
  #
  #Examples:
  #| storeId |
 #|       78 |  
  #
 ########################################################################################################
 #
      # SMA-19045
  #@sma
  #Scenario Outline: Verify that when Order Day is in Today + 4, Today + 5, Today + 6, Today + 7 and Order Date matches the store_category_product.valid_date and Order Qty is not null then The product will be part of Amendable  list.
  ############## and The product details will display Amend label in green
 #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
  #Examples:
  #| storeId |
  #|      78 |
  #
     # SMA-19045
  #@sma
  #Scenario Outline: Verify that when Order Day is in Today + 4, Today + 5, Today + 6, Today + 7 and Order Date does not match the store_category_product.valid_date and Order Qty is not null then The product will be part of Non Amendable list and The product details will not display Amend label
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
  #Examples:
  #| storeId |
  #|      78 |
  #
    # SMA-19045
  #@sma
  #Scenario Outline: Verify that when Order Day is in Today + 4, Today + 5, Today + 6, Today + 7 and Order Date does match the store_category_product.valid_date and Order Qty is null then The product will be part of Non Amendable list and The product details will not display Amend label
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
  #Examples:
  #| storeId |
  #|      78 |
  #
  #
  #
 #
  #
  ##################   SMA-19045
    #########   Department with No products
  #@sma
  #Scenario Outline: Verify that when the selected department has no products then the Order list will display empty lists
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #Then I Select a Department "<department>" which has no products
  #And I verify empty order lists is displayed
  #
  #Examples:
  #| storeId |department|
  #|      78 |Butchery|
  #
    #
     ################# SMA-19045
  #@sma
  #Scenario Outline: Verify that when Order Day is Today+4 and Ordered Qty is null then the Order Qty will show as NA
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
  #Examples:
  #| storeId |
  #|      78 |
  #
     ################# SMA-19045
  #@sma
  #Scenario Outline: Verify that when Order Day is Today and Ordered Qty is null then The Order Qty will show as NA
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I verify Order day is today and Ordered quantity is null
  #Then I verify the order quantity as NA is displayed
  #
  #Examples:
  #| storeId |
  #|      78 |
  #
     ################ SMA-19045
  #@sma
  #Scenario Outline: Verify that when Order Day is Today+7 and requested Qty is 0 then The Order Qty will show as 0
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I verify Order day is today and Ordered quantity is null
  #Then I verify the order quantity as NA is displayed
  #
  #Examples:
  #| storeId |
  #|      78 |
  #
  #
  #
    ################ SMA-19050
  #@sma
  #Scenario Outline: Verify that when User clicks on amendable product in the order list screen then user can see the relevant product information screen
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #And I verify product information screen is displayed
  #
  #Examples:
  #| storeId |
  #|      78 |
#
  #
 ##################  SMA-19050
  #@sma
  #Scenario Outline: Verify Amendable day is Today + 4 / 5 /  6 / 7 is clickable
  ############## and displayed within the square box and displayed in green 
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I verify Amendable day Today + 4 is clickable
  #And I verify Amendable day Today + 5 is clickable
  #And I verify Amendable day Today + 6 is clickable
  #And I verify Amendable day Today + 7 is clickable
  #
  #Examples:
  #| storeId |
 #|       78 |
 #
 #
 ################## SMA-19050
  #@sma
  #Scenario Outline: Verify Amendable day is Today + 4 is clickable
  ############## and displayed within the square box and displayed in green 
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I verify Amendable day Today + 4 is clickable
  #
  #Examples:
  #| storeId |
 #|       78 |
  #
  #
  ################## SMA-19050
  #@sma
  #Scenario Outline: Verify Amendable day is Today + 5 is clickable
  ############## and displayed within the square box and displayed in green 
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I verify Amendable day Today + 5 is clickable
  #
  #Examples:
  #| storeId |
 #|       78 |
  #
  #
  ############## SMA-19050
  #@sma
  #Scenario Outline: Verify Amendable day is Today + 6 is clickable
  ############## and displayed within the square box and displayed in green 
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I verify Amendable day Today + 6 is clickable
  #
  #Examples:
  #| storeId |
 #|       78 |
  #
  #
  ################## SMA-19050
  #@sma
  #Scenario Outline: Verify Amendable day is Today + 7 is clickable
  ############## and displayed within the square box and displayed in green 
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
 #And I verify Amendable day Today + 7 is clickable
  #
  #Examples:
  #| storeId |
 #|       78 |
  #
  #
 ################  SMA-19050
  #@sma
  #Scenario Outline: Verify Amendable Day is Today + 4 ( valid_date is set) and Ordered Qty is null then Today + 4 will not be clickable
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
 ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that when User clicks on back arrow then User is navigated to the Order list screen
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #Then I Select a Amendable Orders Dropdown
  #And I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I click on the Back Button
  #And I Verify Amendable Orders Product list is displayed
   #
  #Examples:
  #| storeId |
 #|       78 |
 #
   ################SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day is Today-1 and Receipted Qty is not null then the Order Qty will show receipted Qty
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
  #
   ################  SMA-19050
  #@sma
  #Scenario Outline: Verify that when Ordered Qty is null then the Order Qty will show as NA (Check for Order Day as Today+7, Today,Today-1)
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################ SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day is Today+5 and Ordered Qty is not null and Requested Qty is not null then The Order Qty will show Requested Qty
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################ SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day is Today+4 and Ordered Qty is not null and Requested Qty is 0 then The Order Qty will show 0
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
  ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day is Today and Receipted Qty is not null then The Order Qty will show Receipted Qty
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
  #
  #
   ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day is Today and Receipted Qty is null and Requested Qty is not null then the Order Qty will show Requested Qty
     #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day is Today and Receipted Qty is null and Requested Qty is null and Ordered Qty is not null then The Order Qty will show Ordered Qty
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
  #
  #
  ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day is Today and Receipted Qty is 0 then The Order Qty will show Order/Requsted Qty
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
 ################  SMA-19050
  #@sma
  #Scenario Outline: Verify that when Order Day falls in Coming week and Ordered Qty is not null and Requested Qty is not null and Order Day is Today +3 then The Order Qty will show Requested Qty and Today + 3  will be non clickable
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
 #
   ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when User clicks on amendable day in the product information screen then the user can see the order increase/decrease tolerance limit popup
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
   #################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Click Cancel on the tolerance limit popup then the User will be navigated to the product information screen and The Order Qty will remain unchanged
     #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select the day from coming week list
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
  #And I click on cancel button on tolerance limit popup
  #Then I verify screen is naviggated to product information screen
  #And I verify the Order Qty will remain unchanged
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
 ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Click Confirm on the tolerance limit popup then the User will be navigated to the product information screen and the Order Qty will be updated to the requested Qty
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select the day from coming week list
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
   #And I select order quantity
  #And I click on confirm button on tolerance limit popup
  #Then I verify screen is naviggated to product information screen
   #And I verify the Order Qty is updated to the requested Qty 
  #Examples:
  #| storeId |
 #|       78 |
 #
  ###############SMA-19050
  #@sma
  #Scenario Outline: Verify that when User Amends Order Qty and navigates back to the order list screen then The Order Qty will be updated to the requested Qty
    #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select the day from coming week list
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
   #And I select order quantity
  #And I click on confirm button on tolerance limit popup
  #Then I verify screen is naviggated to product information screen
   #And I verify the Order Qty is updated to the requested Qty 
  #Examples:
  #| storeId |
 #|       78 |
 #
  ###############SMA-19050
  #@sma
  #Scenario Outline: Verify that when User Amends Order Qty and navigates back to the department list screen and navigates back to the order list screen then The Order Qty will be updated to the requested Qty
     #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select the day from coming week list
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
  #And I select order quantity
  #And I click on confirm button on tolerance limit popup
  #Then I verify screen is naviggated to product information screen
   #And I verify the Order Qty is updated to the requested Qty
   #Then I click on back button
   #And I verify screen is navigated to department list screen
   #Then I click on back button
   #Then I verify screen is naviggated to product information screen
   #And I verify the Order Qty is updated to the requested Qty 
   #
  #Examples:
  #| storeId |
 #|       78 |
  #
  ############### SMA-19050
  #@sma
  #Scenario Outline: Verify that when User doesn't change the default original qty in the tolerance limit popup then The Confirm button will remain disabled
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select the day from coming week list
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
  #And I verify confirm button is disabled
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
   ###############  SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 4 and Ordered Qty =10 then Today + 4 will show maximum Order Increase as 13 and minimum Order Decrease as 8 in response
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select the day from coming week list
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
   ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 7 and Ordered Qty =101 then Today + 7 will show maximum Order Increase as 126 and minimum Order Decrease as 76 in response
     #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
 #
  ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 5 and Ordered Qty =11 then Today + 5 will show maximum Order Increase as 14 and minimum Order Decrease as 8 in response
     #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 4 and Ordered Qty =5 then Today + 4 will show maximum Order Increase as 15 and minimum Order Decrease as 0 in response
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 4 and Ordered Qty =2 then Today + 4 will show maximum Order Increase as 12 and minimum Order Decrease as 0 in response
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################ SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 4 and Ordered Qty =0 then Today + 4 will show maximum Order Increase as 10 and minimum Order Decrease as 0 in response
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select the day from coming week list
  #And I verify order quantity for selected day is Zero
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
  #And I verify  maximum Order Increase is 10 on tolerance limit popup
    #And I verify  minimum Order Decrease is 0  on tolerance limit popup
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 4 and Ordered Qty =0 then Today + 4 will show maximum Order Increase as 10 and minimum Order Decrease as 0 in response
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
 #
  ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 4,5,6,7 and Ordered Qty between 0 and 100 then user can increase Order Qty for all values displayed in the popup
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ###################s SMA-19050
  #@sma
  #Scenario Outline: Verify that when Valid-Date set is Today + 4,5,6,7 and Ordered Qty between 0 and 100 then user can decrease Order Qty for all values displayed in the popup
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #
  #Examples:
  #| storeId |
 #|       78 |
 #
  ################### SMA-19050
  #@sma
  #Scenario Outline: Verify that when 2 users amend order qty for same item in same store at same time then the second user's update will fail.
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
   #
   #
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
   #
   #
    #
  #Examples:
  #| storeId |username2|password2|
 #|       78 |||
 #
 #
  ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that Manager users can amend the order qty
   #When I enter Username and Password for SMA Manager user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
   #
    #Examples:
  #| storeId |
 #|       78 |
 #
  ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that Colleague users can amend the order qty
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
   #
    #Examples:
  #| storeId |
 #|       78 |
 #
 #
 ################## SMA-19050
  #@sma
  #Scenario Outline: Verify that for amendable product the amendable days are correctly displayed when all 4 days Today+4, Today+5, Today+6, Today+7 are amendable
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I verify amendable days are correctly displayed when all 4 days Today+4, Today+5, Today+6, Today+7 are amendable
   #
    #Examples:
  #| storeId |
 #|       78 |
 #
 #
 #
################  SMA-19050
 #
# Order Amends
# Monday ( 16th Mar)
    ##################x requested | y originally ordered
  #@sma
  #Scenario Outline: Verify that when Order Qty is amended then it will display Order Amends message in the product information screen
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
    #And I Select the day from coming week list
  #And I verify tolerance limit popup is displayed
  #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
   #And I select order quantity
  #And I click on confirm button on tolerance limit popup
  #Then I verify screen is naviggated to product information screen
   #And I verify the Order Qty is updated to the requested Qty 
   #And I verify Order Amends message is displayed in the product information screen
   #
    #Examples:
  #| storeId |
 #|       78 |
 #
 ################  SMA-19050
  #
  # Order Amends
# Today ( 16th Mar)
   ################## x delivered | y  requested
  #@sma
  #Scenario Outline: Verify that when Order Qty is amended and subsequently gets delivered when Order Day is Today then it will display Order Amends message in the product information screen
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
   #
    #Examples:
  #| storeId |
 #|       78 |
 #
 #
  ##################SMA-19050
 #
  # Order Amends
# Today ( 16th Mar)
    ################## x requested | y originally ordered
  #@sma
  #Scenario Outline: Verify that when Order Qty is amended  and not yet delivered and Order Day is Today then it will display Order Amends message in the product information screen
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list 
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
   #Then I verify radiobutton values , cancel and confirm buttons are displayed on tolerance limit popup 
   #And I select order quantity
  #And I click on confirm button on tolerance limit popup
  #Then I verify screen is naviggated to product information screen
   #And I verify the Order Qty is updated to the requested Qty 
   #And I verify Order Amends message is displayed in the product information screen
   #
    #Examples:
  #| storeId |
 #|       78 |
 #
 #
 #
 ################## SMA-19050
 #@sma
  #Scenario Outline: Verify that when Order Day is in Today + 4, Today + 5, Today + 6, Today + 7 and Order Date does not match the store_category_product.valid_date and is not null then the product will be part of Amendable list but none of the dates will be amendable.
   #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
   #And I Select a amendable day
   #And I Verify popup is displayed
   #
    #Examples:
  #| storeId |
 #|       78 |
 #
 #
 #
 ################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Order Qty is available for next 7 days and The Order Day is Today + 4_5_6_7  then The Max Order Increase is displayed as next 7 days Order Qty average ( next 7 days based on Next_Average_Days config value)
#When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 #
################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Order Qty is not available for some of the next 7 days and The Order Day is any of Today + 4_5_6_7  then The Max Order Increase is displayed as next 7 days Order Qty average 
#When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 #
 #
################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The 7 day average qty changes on the next day and The Order Day is Today + 5  then The Max Order Increase is displayed as next 7 days Order Qty average
#When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Order Qty is available for next 7 days and The Order Day is any of Today + 4_5_6_7  then The Min Order Decrease is displayed as 0 
#When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Order Qty is 0 for the next 7 days and The Order Day is any of Today + 4_5_6_7  then The Max Order Increase is displayed as 10 ( Next_Average_Days_Default_Amount from config)
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Order Qty is not available for the next 7 days and The Order Day is any of Today + 4_5_6_7  then The Max Order Increase is displayed as 10 ( Next_Average_Days_Default_Amount from config)
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
  ################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Requested Qty is available and the The 7 day average qty changes on the next day and The Order Day is any of Today + 4_5_6_7  then The Max Order Increase remains same as when the Order was amended
 #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 #
  ################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Order Qty is available for next 7 days and The Order Day is Today + 4  then The Max Order Increase is displayed as next 10 days Order Qty average when Next_Average_Days is set to 10 in the config
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
  ################## Service - SMA-20589
 #@sma
  #Scenario Outline: Verify that when The User selects to amend the Order Qty and The Order Qty is 0 and The Order Qty is 0 for the next 7 days and The Order Day is any of Today + 4_5_6_7  then The Max Order Increase is displayed as 20 when Next_Average_Days_Default_Amount is set to 20 in the config
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 #
 #
 #
 #
  ################## SMA-20591
  ###########  Delivered Qty < Requested Qty
 #@sma
  #Scenario Outline: Verify that when the user views the Order Amends screen and The Order Day is Today and the Requested Qty is available and the Delivered Qty less than Requested Qty then the delivery message is displayed along with amended message for Today 
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #Then I Select amend order value from popup
  #And I Click on confirm button
  #And I Verify Order amendable message
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ##################  SMA-20591
  ###############   Delivered Qty > Requested Qty
 #@sma
  #Scenario Outline: Verify that when The user views the Order Amends screen and The Order Day is Today and The Requested Qty is available and The Delivered Qty greater than Requested Qty  then The delivery message is displayed along with amended message for Today 
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #Then I Select amend order value from popup
  #And I Click on confirm button
  #And I Verify Order amendable message
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ##############  SMA-20591
  ##########  Delivered Qty = Requested Qty
 #@sma
 #Scenario Outline:
 #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #Then I Select amend order value from popup
  #And I Click on confirm button
  #And I Verify Order amendable message
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ##################  SMA-20591
  ###############   Delivered Qty != Ordered Qty
 #@sma
  #Scenario Outline: Verify that when The user views the Order Amends screen and The Order Day is Today and The Order Qty is available and The Delivered Qty doesn't match Ordered Qty then no message displayed in the Order Amends as order is not amended
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #Then I Select amend order value from popup
  #And I Click on confirm button
  #And I Verify Order amendable message
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ##################  SMA-20591
  ########  The Order Qty is available and The Delivered Qty is not available
 #@sma
  #Scenario Outline: Verify that when The user views the Order Amends screen and The Order Day is Today and The Order Qty is available and The Delivered Qty is not available  then The amended message is not displayed for Today
  #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #Then I Select amend order value from popup
  #And I Click on confirm button
  #And I Verify Order amendable message
    #Examples:
  #| storeId |productName|
 #|       78 ||
 #
 ################## SMA-20591
 ############   The Requested Qty is available and The Delivered Qty is not available
 #@sma
  #Scenario Outline: Verify that when The user views the Order Amends screen and The Order Day is Today and The Requested Qty is available and The Delivered Qty is not available  then The amended message is displayed without additional delivery notification
 #When I enter Username and Password for SMA Collegue user
  #And I click on login button for SMA
  #Then I Click on Marketstreet menu
  #And I Verify Sales Order menu is Displayed
  #Then I Click on Sales Order menu
  #Then I Verify Departments under Sales order menu are displayed
  #And I Select a Department from department list
  #Then I Verify Product list is displayed
  #Then I Click on Dropdown list
  #And I Select a Amendable Orders Dropdown
  #Then I Verify Amendable Orders Product list is displayed
  #Then I Select a Amendable order Product
  #Then I verify a coming week day list is displayed
  #And I Select a amendable day
  #And I Verify popup is displayed
  #Then I Select amend order value from popup
  #And I Click on confirm button
  #And I Verify Order amendable message
  #
    #Examples:
  #| storeId |productName|
 #|       78 ||
 