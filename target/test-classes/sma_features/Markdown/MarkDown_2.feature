@markdown
Feature: Markdown 2


  @sma
  Scenario Outline: To verify if the Manager user is able to scan non-marked down barcode
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<barcode>" number
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
      #|Fruit and Veg|Fruit and Veg|108384771|2|
      | 78      | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 106194202 | 2        |


  @sma
  Scenario Outline:SMA-13580 To verify if the Store user is able to see option to scan item on markdown list
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I verify Scanning option not present in markdown list

    Examples:
      | storeId | Department    | category | barcode   | quantity |
      | 78      | Market Street | Fish     | 107973427 | 2        |
    	      #|Fruit and Veg|Fruit and Veg|108384771|2|


  @sma
  Scenario: To verify if the Manager user is able to Scan Marked Down barcode while device is offline
    Given device is in offline mode
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I user not able to login

  @sma
  Scenario: To verify if the Manager user is able to Scan Non-Marked Down barcode while device offline
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I user not able to login
    And I enable wifi n data for login

  @sma
  Scenario Outline: To verify if the user is shown error message when scans invalid markdown barcode from markdown list
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify error message displayed

    Examples:
      | Barcode   | Department    | category |
      | 111111111 | Market Street | Fish     |
	
     
   ################################RUN2###############################################

  @sma
  Scenario Outline: To verify if the L4 user is able to see the new price, the calculated value selected in the discount percentage dropdown, the original price and the L4 user is able to amend the discount from 0-95% regardless of it is a first or final markdown
 	#User - BY In Scope Item - printer added

    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I see original price
    And I see new price
    And I select percentage "<percent>" and see calculated value


    Examples:
      | Department    | category      | Barcode   | quantity | percent |
     #|Fruit and Veg|Fruit and Veg  |103853612|1|70|
      | Fruit and Veg | Fruit and Veg | 108304794 | 2        | 70      |


  @smaa
  Scenario Outline: To verify if the L4 user is able to see the new price, the calculated value selected in the discount percentage dropdown, the original price and the L4 user is able to amend the discount from 0-95% regardless of it is a first or final markdown
 	#User - BY In Scope Item - printer not added
    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I see original price
    And I see new price
    And I select percentage "<percent>" and see calculated value


    Examples:
      | Department    | category      | Barcode   | quantity | percent |
      | Fruit and Veg | Fruit and Veg | 103853612 | 1        | 70      |


  @sma
  Scenario Outline: To verify if the L4 user is able to see the new price, the calculated value selected in the discount percentage dropdown, the original price and the L4 user is able to amend the discount from 0-95% regardless of it is a first or final markdown
 	# BY Out of Scope Item - printer added
    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity>" for the product
    And I see original price
    And I see new price
    And I select percentage "<percent>" and see calculated value

    Examples:
      | Department | Barcode   | quantity | percent |
      | Ambient    | 105659291 | 1        | 40      |
     
#    @smaa
#    Scenario Outline: To verify if the L4 user is able to see the new price, the fixed value selected in the discount percentage dropdown, the original price and the L4 user is able to amend the discount from 0-95% regardless of it is a first or final markdown
#   # BY Out of Scope Item - printer not added
# 	When I enter Username and Password for SMA Manager user
#	And I click on login button for sma
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number    
#    And I enter markdown "<quantity>" for the product
#    And I see original price
#    And I see new price
#    And I select percentage "<percent>" and see calculated value
#
#   Examples:
#     |Department   |Barcode|quantity|percent|
#     |Ambient|103138934|10|70|

  @sma
  Scenario Outline:To verify if the L3 user only enters quantity to print labels or add to print list while scanning BY In Scope item
      #BY In Scope Item - printer added
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity>" for the product

    Examples:
      | Department | Barcode   | quantity |
      | Ambient    | 105659291 | 10       |


  @sma
  Scenario Outline: To verify if the L3 user only enters quantity to print labels or add to print list while scanning BY In Scope item
      #BY In Scope Item - printer not added
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    And I verify Add to Print Queue button is Displayed
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
      | 78      | Ambient    | 105659291 | 1        |


  @sma
  Scenario Outline: To verify if the L3 user is able to see the new price, the fixed value selected in the discount percentage dropdown, the original price and the L3 user is able to amend the percentage in 5% increments in the following bandings
 	# BY Out of Scope Item - printer not added
    When I enter Username and Password for SMA Collegue user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I see original price
    And I see new price
    And I select percentage "<percent>" and see calculated value
    And I enter markdown "<quantity>" for the product
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
      | 78      | Ambient    | 105659291 | 1        | 20      |

  @smaa
  Scenario Outline: To verify if the L3 user is able to see the new price, the fixed value selected in the discount percentage dropdown, the original price and the L3 user is able to amend the percentage in 5% increments in the following bandings
 	# BY Out of Scope Item - printer added
    When I enter Username and Password for SMA Collegue user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I see original price
    And I see new price
    And I select percentage "<percent>" and see calculated value
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
      | 78      | Ambient    | 105659291 | 1        | 20      |
     
  ##############Run 3##########
     
#    @sma 
#   	Scenario Outline: Validate manager able to do markdown for item and able to Override optimized price
#   	When I enter Username and Password for SMA Manager user
#	    And I click on login button for sma
#	    Then I click on Markdowns
#	    Then I click on Scan Markdowns
#	    Then I click on No Printer Available
#	    And I click on the "<Department>" available
#	    Then I select one of the "<category>"
#	    And I click on barcode entry Button
#	    Then Enter "<barcode>" number
#	    And I enter markdown "<quantity>" for the product
#	    Then I click on Get Price
#	    And I select percentage "<percent>" and see calculated value
#	    And I click on Add to Print Queue as an employee
#	    
#	    
#	  Examples:
#      |Department   |category|barcode|quantity|percent|
#      #|Market Street|Bakery  |110249931|1|70|
#      #|Fruit and Veg|Fruit and Veg|108384771|2|70|
#            	  |Market Street|Fish  |102410781|2|70| 
#      
#      
#@sma	    
#Scenario Outline: Validate manager is allowed to edit optimised price which are sent by BlueYonder
#		When I enter Username and Password for SMA Manager user
#	    And I click on login button for sma
#	    Then I click on Markdowns
#	    Then I click on Scan Markdowns
#	    Then I click on No Printer Available
#	    And I click on the "<Department>" available
#	    Then I select one of the "<category>"
#	    And I click on barcode entry Button
#	    Then Enter "<barcode>" number
#	    And I enter markdown "<quantity>" for the product
#	    Then I click on Get Price
#	    And I select percentage "<percent>" and see calculated value
#	    And I click on Add to Print Queue as an employee
#	    
#	    
#	  Examples:
#      |Department   |category|barcode|quantity|percent|
#      #|Fruit and Veg|Fruit and Veg|108384771|2|70|
#		      |Fresh Foods |026 Soup, Pasta, Garlic Bread| 109345459|2|70|
#		
#@sma      
#Scenario Outline: Validate user is allowed to edit optimised price which are not scope for BlueYonder
#	When I enter Username and Password for SMA Manager user
#	And I click on login button for sma
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number    
#    And I enter markdown "<quantity>" for the product
#    And I see original price
#    And I see new price
#    And I select percentage "<percent>" and see calculated value
#     
#     Examples:
#     |Department   |Barcode|quantity|percent|
#     |Ambient|105659291|2|40|
#
#@sma
#Scenario Outline: Validate user is allowed to give quantity in whole value
#		When I enter Username and Password for SMA Manager user
#	    And I click on login button for sma
#	    Then I click on Markdowns
#	    Then I click on Scan Markdowns
#	    Then I click on No Printer Available
#	    And I click on the "<Department>" available
#	    Then I select one of the "<category>"
#	    And I click on barcode entry Button
#	    Then Enter "<barcode>" number
#	    And I enter markdown "<quantity>" for the product
#	    
#	   Examples:
#      |Department   |category|barcode|quantity|
#      |Fruit and Veg|Fruit and Veg|108304794|2|
#
#
#@sma     
#Scenario Outline:To verify if the user can add item to print list while performing first markdown for which discount % is 90
##new requirement
#	When I enter Username and Password for SMA Manager user
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
#    And I see original price
#    And I see new price
#    And I select percentage "<percent>" and see calculated value
#	And I click on Add to Print Queue as an employee
#	
#    
#     Examples:
#     |Department   |category|Barcode|quantity|percent|
#      |Fruit and Veg|Fruit and Veg|108361457|2|90|
# 
#@sma
#Scenario Outline: To verify that error message has displayed when Maximum Markdown Reached
# 
# 	Given Request is made to SMA app login service for manager user
#    Then Service should return details for SMA app Login Service
#    And Get the generated Access Tocken for SMA app Login Service
#    And Get generated access token
#    Given Get request is made to GetMarkdown Details service for store id "<storeid>" and product id "<Barcode>"
#    And Get Operation perform on Markdown service request
#    Then Get markdown details service response after scanning the product
#    When I enter Username and Password for SMA Manager user
#	And I click on login button for sma
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter Markdown barcode number
#    And I verfiy error message for Maximum Markdown
#    
#    Examples:
#    |storeid|Barcode|Department|category|
#    |78|108361457|Fruit and Veg|Fruit and Veg|
#     
#@smaa
#Scenario Outline: To Verify that manager is able to enter quantity to markdown and press 'Get Price' using add printer
##printer
#	When I enter Username and Password for SMA Manager user
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
#    
#     Examples: 
#     |Department   |category|Barcode|quantity|percent|
#     |Fruit and Veg|Fruit and Veg  |108649987|1|95|
#     
#@sma    
#Scenario Outline: To Verify that manager is able to enter quantity to markdown and press 'Get Price' With outprinter
#	When I enter Username and Password for SMA Manager user
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
#    
#     Examples:
#     |Department   |category|Barcode|quantity|percent|
#     |Fruit and Veg|Fruit and Veg  |103853612|1|95|
#     
#
#@sma   
#Scenario Outline: To verify that manager is able to view the markdown price of restricted item on choosing continue option while restricted product scan message displayed
##scan restricted productid
#		When I enter Username and Password for SMA Manager user
#	    And I click on login button for sma
#	    Then I click on Markdowns
#	    Then I click on Scan Markdowns
#	    Then I click on No Printer Available
#	    And I click on the "<Department>" available
#	    And I click on barcode entry Button
#	    Then Enter "<Barcode>" number
#	    And I see Warning message
#	  	And I click continue
#	  	And I see new price
#	    
#	    
#	  Examples:
#     |Department   |Barcode|
#     |Ambient|101552605|
#
#
#@sma
#Scenario Outline: To verify that manager is able to view the markdown price of restricted item on choosing continue option while restricted product scan message displayed and no printer has selected
#
#		When I enter Username and Password for SMA Manager user
#	    And I click on login button for sma
#	    Then I click on Markdowns
#	    Then I click on Scan Markdowns
#	    Then I click on No Printer Available
#	    And I click on the "<Department>" available
#	    And I click on barcode entry Button
#	    Then Enter "<Barcode>" number
#	  	And I see Warning message
#	  	And I click continue
#	  	And I see new price
#	  		    
#	 Examples:
#     |Department   |Barcode|
#     |Ambient|101552605|
#
#
#@sma
#Scenario Outline: To verify that manager is able to print the restricted item
#		When I enter Username and Password for SMA Manager user
#	    And I click on login button for sma
#	    Then I click on Markdowns
#	    Then I click on Scan Markdowns
#	    Then I click on No Printer Available
#	    And I click on the "<Department>" available
#	    And I click on barcode entry Button
#	    Then Enter "<Barcode>" number
#	  	And I see Warning message
#	  	And I click continue
#	  	And I see new price
#	  	And I enter markdown "<quantity>" for the product
#	  	And I click on Add to Print Queue as an employee
#	  	
#	  		    
#	 Examples:
#     |Department   |Barcode|quantity|
#      |Ambient|101552605|
################################################# Start from here######
 
# 
# @sma
# Scenario Outline: To verify if the user markdowns missed out items as part of first markdown same price is used from the markdown event
#					#Markdown For Missed Item-BY In Scope_L3 User_Added to print list First Time
#					
#	When I enter Username and Password for SMA Collegue user
#     And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<barcode>" number
#    And I enter markdown "<quantity>" for the product
#        And I capture markdown price
#        And I logout of the system 
#    When I enter Username and Password for SMA Collegue user
#     And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<barcode>" number
#    And I verify markdown price is same
#   
#    
#     Examples:
#      |storeId|Department   |category|barcode|quantity|
#      |89|Fresh Foods|022 Speciality Cheeses|106145443|2|
# 
# @sma
# Scenario Outline: To verify if the user markdowns missed out items as part of first markdown same price is used from the markdown event
#					
#	When I enter Username and Password for SMA Manager user
#     And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<barcode>" number
#    And I enter markdown "<quantity>" for the product
#    And I capture markdown price
#        And I logout of the system 
#    When I enter Username and Password for SMA Manager user
#     And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#    And I click on barcode entry Button
#    Then Enter "<barcode>" number
#    And I verify markdown price is same
#    
#     Examples:
#      |Department   |category|barcode|quantity|
#      |Fresh Foods|022 Speciality Cheeses|106145443|2|
#      
#     @sma 
#     Scenario Outline: To verify that L3 user is able to view all detail information of the product on Markdown Items Summary screen when no printer is present
#       
#     When I enter Username and Password for SMA Collegue user
#     And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    And I click on barcode entry Button
#    Then Enter "<Barcode>" number    
#    And I enter markdown "<quantity>" for the product
#    And I click on Add to Print Queue as an employee
#    And I click on Print list icon
#    And I click on product
#    And I verify Product Name, MIN, EAN, Original Price, New Price
#     
#     Examples:
#     |Department|Barcode|quantity|
#  	|Ambient|104883012|1|
#  
#  @sma    	
#  Scenario: To verify that percentage details text is not displayed on Markdown Items Summary screen when L3 user is scanning BY product scan
#     When I enter Username and Password for SMA Collegue user
#     And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on Print list icon
#    And I click on product
#    And I verify percentage details text is not displayed
#      
#             		
#@smaa
#Scenario Outline: To verify if the user is able to scan clearance marked down barcode from the Print List
#	When I enter Username and Password for SMA Collegue user
#    And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    Then I select one of the "<category>"
#	And I verify and navigate to Print List By clicking on Print list icon
#  	 And I click on barcode entry Button
#    Then Enter "<barcode>" number
#    
#	 Examples:
#      |Department   |category|barcode|quantity|
#      |Market Street|Fish  |107973427|21| 
#
# 