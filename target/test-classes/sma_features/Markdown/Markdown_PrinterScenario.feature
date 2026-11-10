@markdown
Feature: Markdown Printer scenarios

   ########################### Printer is required ################################
    ############# isPrinted = true 
    ######### Markdown barcode required
  @sma
  Scenario Outline: SMA-12798_To Verify that a L4 user is able to edit New price as discount drop down is enabled when scanning Morrisons markdown product
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I verify discount dropdown is enabled
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I verify Manager selected optimized percentage "<percentage>" is displayed
    And I click on Add to Print Queue
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed
    And I click on Yes button on Clearance alert
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request
    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |

  @sma
  Scenario Outline: SMA-16744_To Verify new final clearance pop up is not displayed when manager scan a markdown barcode in "firstmarkdownwindow".
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Then I click on Back button
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I click on Add to Print Queue as an employee
    Then I verify Clearance alert is not displayed
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request
    Examples:
      | storeId | Department    | category | productId | quantity |
      | 3       | Market Street | Fish     | 102410781 | 5        |
   ###################   |      78 | Fresh Foods | 022 Speciality Cheeses | 106145443 | 4|

  @sma
  Scenario Outline: SMA-16740_To Verify default price is displayed when a manager user is scanning a product which is already cleared by manager user in same first markdown window.
      #########  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I get calculate price on UI for Manager user
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    And I click on Back button
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Last Markdown price on UI
    Then Verify default markdown price is displayed when a manager user is scanning a product
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request
    Examples:
      | storeId | Department    | category | productId | quantity |
      | 3       | Market Street | Fish     | 102410781 | 5        |
     ##### |78 | Fresh Foods | 022 Speciality Cheeses | 106145443 |  5 |


  @sma
  Scenario Outline: SMA-16738_To Verify default price is displayed when a colleague user is scanning a product which is already cleared by manager user in same "firstmarkdownwindow".
   #########  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I get calculate price on UI for Manager user
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    And I logout of the system
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Last Markdown price on UI
    Then Verify default markdown price is displayed when a manager user is scanning a product
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |


  @sma
  Scenario Outline: SMA-16726(Service)_To Verify default price is displayed when a colleague user is scanning a product which is already cleared by manager user in same first markdown window.
   ########  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I get Original price on UI
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I get calculate price on UI for Manager user
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    And I logout of the system

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Last Markdown price on UI
    Then Verify default markdown price is displayed when a manager user is scanning a product

    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify First markdown attribute is present and in HH:MM:SS format
    Then I verify current price on Ui and services is matched
    And I verify Markdown percentage
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |


  @sma
  Scenario Outline: SMA_-16379_To Verify default price is displayed when a manager user is scanning a product which is already cleared by manager user in same first markdown window.
    ############ isPrinted =true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product is present in print list
    And I logout of the system

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Last Markdown price on UI
    Then Verify last markdown price is displayed when a manager user is scanning a product

    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-16728(Service)_To Verify default price is displayed when a manager user is scanning a product which is already cleared by manager user in same first markdown window.
      #########  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Original price on UI
    Then I click on Get Price
    And I get calculate price on UI for Manager user
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    And I click on Back button
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Last Markdown price on UI
    Then Verify default markdown price is displayed when a manager user is scanning a product
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify First markdown attribute is present and in HH:MM:SS format
    Then I verify current price on Ui and services is matched
    And I verify Markdown percentage
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request
    Examples:
      | storeId | Department    | category | productId | quantity |
      | 3       | Market Street | Fish     | 102410781 | 5        |
     ##### |78 | Fresh Foods | 022 Speciality Cheeses | 106145443 |  5 | 
      
  
  #### pending
  @sma
  Scenario Outline: SMA_-16379_To Verify last markdown price is displayed when a colleague user is scanning a product for which first markdown is done by manager user in same first markdown window.
    ############ isPrinted =true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product is present in print list
    And I logout of the system

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Last Markdown price on UI
    Then Verify last markdown price is displayed when a manager user is scanning a product

    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

 #### pending
  @sma
  Scenario Outline: SMA_-16379_To Verify default price is displayed when a colleague user is scanning a product which is already cleared by manager user in same first markdown window.
    ############ isPrinted =true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product is present in print list
    And I logout of the system

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I get Last Markdown price on UI
    Then Verify last markdown price is displayed when a manager user is scanning a product

    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |


  @sma
  Scenario Outline: SMA-12871_(Printer connected_No change in Qty)To verify that user is able to create a final clearance for items that are already present in Markdown List without changing the quantity.
     ##################  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    ######## Get mardownbarcode from api
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I verify second markdown is performed.

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |

  @sma
  Scenario Outline: SMA-12871_(Printer connected_Qty greater than originally markdown qty)To verify that user is able to create a final clearance for items that are already present in Markdown List after editing the quantity to more than that was originally markdown
    ##################  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    ######## Get mardownbarcode from api
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I verify second markdown is performed.

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 85%        |

  @sma
  Scenario Outline: SMA-12871_(Printer connected_Qty less than originally markdown qty)To verify that user is able to create a final clearance for items that are already present in Markdown List after editing the quantity to less than that was originally markdown
     ##################  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    ######## Get mardownbarcode from api
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I verify second markdown is performed.

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 65%        |

  @sma
  Scenario Outline: SMA-12871_To verify that L3 user is not able to create a final clearance for items that are already present in Markdown List.
     ##################  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    ######## Get mardownbarcode from api
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I verify second markdown is performed.

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 65%        |


  @sma
  Scenario Outline: SMA-14862-To verify that user is able to scan missing BY scope item on different Markdown Window ( L4 followed by L3)
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that user is able to scan Missing BY scope item by L4 user when there is no 1st Markdown but clearance happened for the same BY scope item in the markdown window.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |

  @sma
  Scenario Outline: SMA-14862_To verify that user is able to scan Missing BY scope item by L3 when there is no 1st Markdown but clearance happened for the same BY scope item in the markdown window.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that user is able to perform markdown and make clearance then scan missing BY scope items(L3 followed by L4) on same day
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that user is able to perform markdown and make clearance then scan missing BY scope items(L4 followed by L3) on same day
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify if the L3 user scans MIN for which first markdown was done by L4 user with price over ride, the over ridden price is being fetched
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |

  @sma
  Scenario Outline: SMA-14862_To verify that L3 user is able to get fresh Markdown during MIN Scan whenever the 1st Markdown is done with highest percentage (clearance) by L4 user

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that L4 user is able to get fresh Markdown during MIN scan whenever the 1st Markdown is done with highest percentage (clearance) by L4 user

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that L4 user is able to perform clearance based on first markdown barcode within same window
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that user is able to scan missing BY out of scope item on different Markdown Window ( L3 followed by L4)
  As post service for printing barcode is not availabel, update the is_printed for store and min = y at runtime 103853612
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |

  @sma
  Scenario Outline: SMA-14862_To verify that user is able to scan missing BY out of scope item on different Markdown Window ( L4 followed by L3)
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that user is able to scan Missing BY out of scope item by L4 user when there is no 1st Markdown but clearance happened for the same BY out of scope item in the markdown window.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that user is able to scan Missing BY out of scope item by L3 when there is no 1st Markdown but clearance happened for the same BY out of scope item in the markdown window.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |

  @sma
  Scenario Outline: SMA-14862_To verify that user is able to perform markdown and make clearance then scan missing BY out of scope items(L3 followed by L4) on same day
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |

  @sma
  Scenario Outline: SMA-14862_To verify that user is able to perform markdown and make clearance then scan missing BY out of scope items(L4 followed by L3) on same day
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify if the L3 user scans MIN for which first markdown was done by L4 user with price over ride, the over ridden price is being fetched
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |

  @sma
  Scenario Outline: SMA-14862_To verify that L3 user is able to get fresh Markdown during MIN Scan whenever the 1st Markdown is done with highest percentage (clearance) by L4 user
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that L4 user is able to get fresh Markdown during MIN scan whenever the 1st Markdown is done with highest percentage (clearance) by L4 user

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |


  @sma
  Scenario Outline: SMA-14862_To verify that L4 user is able to perform clearance based on first markdown barcode within same window
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    	##And I click on barcode entry Button
    	##Then Enter "XXQPJ172200016" number
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    	##Then I click on Get Price
    	##And I click on Add to Print Queue
    And I click on Add to Print Queue as an employee
    Then I verify and navigate to Print List By clicking on Print list icon
    And I click on scanned "<barcode>"
    And I store the new price into a variable from first markdown
    Given Request is made to Markdown Login service
    Then The service should return details for Login Service
    And Get the generated accessTocken
    Given  a Store ID "<StoreID>" and Product ID "<Barcode>" is included in Markdown Service request
    When the request is made to the specified get Markdown service
    Then The service should return details for Get Markdown Service
     	##And I store the new price into a variable to verify with second markdown
    	##And I click on Discount and select percentage
    	##And I click on Print
    	##Then I make a service call to get a mardown barcode
    	##And I make a service call to print the barcode
    	##And I store the barcode to perform second markdown
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button
    When I enter "98765430" and "852258" for sma
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter first markdown barcode number from the variable
    	##Then I click on Get Price
    And I enter markdown "<quantity>" for the product
    And I store the new price into a variable to verify with second markdown
    And I click on Add to Print Queue
	    ##And I enter markdown "<quantity>" for the product
	    ##And I click on Add to Print Queue as an employee
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | Department    | category      | barcode   | quantity | percentage | Barcode   | StoreID |
      | Fruit and Veg | Fruit and Veg | 105100016 | 1        | 5%         | 105100016 | 79      |
      
  ############################################## Markdown list ##################################################################33

  @sma
  Scenario Outline: SMA-12871_(Printer not connected_No change in Qty)To verify that user is able to create a final clearance for items that are already present in Markdown List without changing the quantity.
   #################  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    ####### Get mardownbarcode from api
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I verify second markdown is performed.

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |

  @sma
  Scenario Outline: SMA-12871_(Printer not connected_Qty greater than originally markdown qty)To verify that user is able to create a final clearance for items that are already present in Markdown List after editing the quantity to more than that was originally markdown
     #################  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    ####### Get mardownbarcode from api
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I verify second markdown is performed.

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 85%        |

  @sma
  Scenario Outline: SMA-12871_(Printer not connected_Qty less than originally markdown qty)To verify that user is able to create a final clearance for items that are already present in Markdown List after editing the quantity to less than that was originally markdown
     #################  isPrinted = true
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    ####### Get mardownbarcode from api
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I verify second markdown is performed.

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 65%        |

  @sma
  Scenario Outline: L3 User should not get a prompt while doing Missing item scan after clearance

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    ############## isPrinted = true
    And I Click on Print button
    And I click on barcode entry Button
    Then Enter Printer barcode "<printerBarcode>" number
    ##########
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Item summary screen is displayed
    And I verify Markdown prompt is not displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | printerBarcode     |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 95%        | printerBarcodeData |


  @sma
  Scenario Outline: L4 User should get markdown prompt while doing Missing item scan after clearance.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    ############## isPrinted = true
    And I Click on Print button
    And I click on barcode entry Button
    Then Enter Printer barcode "<printerBarcode>" number
    ##########
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Item summary screen is displayed
    And I verify Markdown prompt is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | printerBarcode     |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 95%        | printerBarcodeData |


  @sma
  Scenario Outline: L4 User should get markdown prompt while doing Missing item scan after clearance. If User choose 'New Markdown' , price from BY will be fetched to perform fresh markdown

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    ############## isPrinted = true
    And I Click on Print button
    And I click on barcode entry Button
    Then Enter Printer barcode "<printerBarcode>" number
    ##########
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Item summary screen is displayed
    And I verify Markdown prompt is displayed
    Then I click on New Markdown button
    And I verify Item summary page is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | printerBarcode     |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 95%        | printerBarcodeData |

  @sma
  Scenario Outline: L4 User should get markdown prompt while doing Missing item scan after clearance. If User choose 'New Markdown' , price from BY will be fetched to perform fresh markdown

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    ############## isPrinted = true
    And I Click on Print button
    And I click on barcode entry Button
    Then Enter Printer barcode "<printerBarcode>" number
    ##########
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Item summary screen is displayed
    And I verify Markdown prompt is displayed
    Then I click on New Markdown button
    And I verify Item summary page is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | printerBarcode     |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 95%        | printerBarcodeData |

  @sma
  Scenario Outline: L4 User should get markdown prompt while doing Missing item scan after clearance.  If User choose 'Clearance' , previous clearance price will be considered during missing item scan..

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    ############## isPrinted = true
    And I Click on Print button
    And I click on barcode entry Button
    Then Enter Printer barcode "<printerBarcode>" number
    ##########
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Item summary screen is displayed
    And I verify Markdown prompt is displayed
    Then I click on Final Clearance button
    And I verify Edit item page is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | printerBarcode     |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 95%        | printerBarcodeData |


  @sma
  Scenario Outline: L3 User should not able to perform Final Clearance.

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    ############# isPrinted = true
    And I Click on Print button
    And I click on barcode entry Button
    Then Enter Printer barcode "<printerBarcode>" number
    #########
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Item summary screen is displayed
    And I verify Markdown prompt is displayed
    Then I click on Final Clearance button
    And I verify Edit item page is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | printerBarcode     |
      | 78      | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 95%        | printerBarcodeData |
       
       