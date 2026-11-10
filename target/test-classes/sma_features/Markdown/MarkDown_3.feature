@markdown
Feature: MarkDown 3

  @sma
  Scenario Outline: To verify if the Manager user is able to scan non-marked down barcode and proceed to first markdown
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request


    Examples:
      | storeId | Department    | category | barcode   | quantity |
      #|78|Fresh Foods|022 Speciality Cheeses|106145443|2|
      | 78      | Market Street | Fish     | 102410781 | 2        |


  @sma
  Scenario Outline: TS_To verify if the store user is restricted while scanning an BY inscope item which is marked down

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request


    Examples:
      | storeId | Department  | category                      | barcode   | quantity | quantity1 |
      #|78|Fresh Foods|022 Speciality Cheeses|106145443|2|2|
      | 78      | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 | 2        | 2         |

  @sma
  Scenario Outline: To verify if the manager user is restricted while scanning an BY inscope item which is marked down


    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request


    Examples:
      | storeId | Department  | category                      | barcode   | quantity |
      | 78      | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 106194202 | 2        |


  @sma
  Scenario Outline: To verify if the store colleague is able to perform markdown on ambient item for multiple time from the scan screen

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request


    Examples:
      | storeId | Department | barcode   | quantity |
      | 78      | Ambient    | 103138934 | 1        |
      | 78      | Ambient    | 103138934 | 1        |


  @sm
  Scenario Outline: To verify if the in progress items once finally cleared are removed from markdown list

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    Then I select the dropdown for discount and select the percentage
    Then I select yes option
    And I click on Add to Print Queue
    Then I verify Popup is displayed for final clearence
    Then I verify And navigate to Print List By clicking on Print list icon
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request


    Examples:
      | storeId | Department    | category      | barcode   | quantity |
      | 78      | Fruit and Veg | Fruit and Veg | 108304794 | 1        |


  @sm
  Scenario Outline: Validate Manager is allowed to perform further markdown on already marked down items - Scan Markdowns
    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeid>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter Markdown barcode number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request



    Examples:
      | storeid | Department    | category | barcode   | quantity |
      | 78      | Market Street | Bakery   | 110249931 | 1        |


  @sma
  Scenario Outline: Validate user is allowed to do another markdown on markdown ambient items

    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request



    Examples:
      | storeId | Department | barcode   | quantity | percent |
      | 78      | Ambient    | 105659291 | 2        | 70      |
      
      
#     
# @sma
# Scenario Outline: 02 To verify that GET markdown details API response for the respective product should display the list of percentages till the 'Markdown_Max_percentage_limit' or 'Markdown_lower_price_limit' whichever is greater.
#
# 	When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<productId>" number
#    Given Request is made to SMA app login service for manager user
#    Then Service should return details for SMA app Login Service
#    And Get generated access token
#    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
#    And Get Operation perform on Markdown service request
#    Then Get markdown percentage from GetMarkdownDetails service 
#    And I verify GET markdown details API response till "<Markdown_Max_percentage_limit>" or "<markdown_lower_price_limit>" whichever greater
#    
#     Examples: 
#      | storeId | Department  | category| productId |	markdown_lower_price_limit|	Markdown_Max_percentage_limit|
#    	|78	|Fresh Food	|026 Soup, Pasta, Garlic Bread|109345459|3|60|
#		#|78	|Fruit and Veg||	108384771|4|43|
#		#|78	|Market Street|	|107973427|6|67|
#      
#      
# @sma
# Scenario Outline: 03 Verify percentage drop down across Item price details page in UI for the respective product 
# 
# 	When I enter Username and Password for SMA Manager user
#	And I click on login button for sma
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number    
#    And I enter markdown "<quantity>" for the product
#    Then I click on Get Price
#    Then I get percentage list form UI
#    And I verify percentage dropdown "<Markdown_Max_percentage_limit>" or "<markdown_lower_price_limit>" whichever greater
#
#
#Examples: 
#      | storeId | Department  | category| Barcode |		markdown_lower_price_limit|		Markdown_Max_percentage_limit|	quantity|
#    	|78	|Fresh Food	|026 Soup, Pasta, Garlic Bread|109345459|3|60%|1|
# 
# @sma
#  Scenario Outline: 04 To verify that GET markdown details API response for depatment level the respective product should display the list of percentages till the 'Markdown_Max_percentage_limit' or 'Markdown_lower_price_limit' whichever is greater.
# 
# 	When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<productId>" number
#    Given Request is made to SMA app login service for manager user
#    Then Service should return details for SMA app Login Service
#    And Get generated access token
#    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
#    And Get Operation perform on Markdown service request
#    Then Get markdown percentage from GetMarkdownDetails service 
#    And I verify GET markdown details API response till "<Markdown_Max_percentage_limit>" or "<markdown_lower_price_limit>" whichever greater
#    
#     Examples: 
#      | storeId | Department  | category| productId |	markdown_lower_price_limit|	Markdown_Max_percentage_limit|
#    	|78	|Fruit and Veg|Fruit and Veg|108304794|4|43|
#    	
#  @sma
# Scenario Outline: 05 Verify percentage drop down across Item price details page in UI for depatment level the respective product 
# 
# 	When I enter Username and Password for SMA Manager user
#	And I click on login button for sma
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number    
#    And I enter markdown "<quantity>" for the product
#    Then I click on Get Price
#    Then I get percentage list form UI
#    And I verify percentage dropdown "<Markdown_Max_percentage_limit>" or "<markdown_lower_price_limit>" whichever greater
#     Examples: 
#      | storeId | Department  | category| Barcode |	markdown_lower_price_limit|	Markdown_Max_percentage_limit|quantity|
#   	|78	|Fruit and Veg|Fruit and Veg|108304794|4|43%|1|
#    	
#   
# @sma
#  Scenario Outline: 06 To verify that GET markdown details API response when Markdown_lower_price_limit and Markdown_Max_percentage_limit is not set across Markdown_rule_master table 
#    	
#    		When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<productId>" number
#    Given Request is made to SMA app login service for manager user
#    Then Service should return details for SMA app Login Service
#    And Get generated access token
#    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
#    And Get Operation perform on Markdown service request
#    Then Get markdown percentage from GetMarkdownDetails service 
#    And I verify GET markdown details API response till "<Markdown_Max_percentage_limit>" or "<markdown_lower_price_limit>" whichever greater
#    
#     Examples: 
#      | storeId | Department  | category| productId |	markdown_lower_price_limit|	Markdown_Max_percentage_limit|
#    	|78	|	Market Street|		Fish|			102410781|			5|							90|
#    	
# @sma
#  Scenario Outline: 07 Verify percentage drop down across Item price details page in UI when no limit is set for the respective product 
#  When I enter Username and Password for SMA Manager user
#	And I click on login button for sma
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number    
#    And I enter markdown "<quantity>" for the product
#    Then I click on Get Price
#    Then I get percentage list form UI
#    And I verify percentage dropdown "<Markdown_Max_percentage_limit>" or "<markdown_lower_price_limit>" whichever greater
#     Examples: 
#      | storeId | Department  | category| Barcode |	markdown_lower_price_limit|	Markdown_Max_percentage_limit|quantity|
#          	|78	|Market Street		|Fish|	102410781	|5						|			90%|1|
#      
#   	@sma
#   	Scenario Outline: 08 Verify that department level entry is present but Class_id and Sub_class_id are NULL across Markdown_rule_master table with respect to store 
#    	
#    When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<productId>" number
#    Given Request is made to SMA app login service for manager user
#    Then Service should return details for SMA app Login Service
#    And Get generated access token
#    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
#    And Get Operation perform on Markdown service request
#    Then Get markdown percentage from GetMarkdownDetails service 
#    #And I verify GET markdown details API response is 404
#    
#     Examples: 
#      | storeId | Department  | category| productId |	markdown_lower_price_limit|	Markdown_Max_percentage_limit|
#    	|78	|	Market Street|		Fish|			102410781|			Null|				NUll|
#    	
    	