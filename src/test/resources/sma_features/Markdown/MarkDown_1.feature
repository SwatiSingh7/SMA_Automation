@markdown
Feature: Markdown Scenario

  BY blueyonder

  @sma
  Scenario Outline: TS_117 To verify that L3 user is able to create Record Out Of Code option and submit that when scanning BY product and not performing markdown

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
    Then I click on Get Price
    And I verify Add to Print Queue button is Displayed
    Then I click on Record Out Of Code
    And I scroll Down to out of code
    Then I verify Expiry Date and Expiry Quantity is Displayed
    And I select Expiry Date for record Out of code
    And I Enter Expiry Quantity "<quantity1>" for record Out of code
    Then I Verify Add To Print Queue and Record Out of code Button is enabled
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department    | category | barcode   | quantity | quantity1 |
      | 78      | Market Street | Bakery   | 104736151 | 1        | 2         |


  @sma
  Scenario Outline:TS_118 To verify that L3 user is able to create Record Out Of Code option and submit that when scanning Non BY product and not performing markdown

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I verify Add to Print Queue button is Displayed
    Then I click on Record Out Of Code
    And I scroll Down to out of code
    Then I verify Expiry Date and Expiry Quantity is Displayed
    And I select Expiry Date for record Out of code
    And I Enter Expiry Quantity "<quantity1>" for record Out of code
    Then I Verify Add To Print Queue and Record Out of code Button is enabled
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department | barcode   | quantity | quantity1 |
      | 78      | Ambient    | 103138934 | 1        | 2         |

  @smaa
  Scenario Outline: TS_119 To verify that L3 user is able to create Record Out Of Code and perform markdown and submit that when scanning BY product when printer is selected
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
    Then I click on Get Price
    And I verify Add to Print Queue button is Displayed
    Then I click on Record Out Of Code
    And I scroll Down to out of code
    Then I verify Expiry Date and Expiry Quantity is Displayed
    And I select Expiry Date for record Out of code
    And I Enter Expiry Quantity "<quantity1>" for record Out of code
    Then I Verify Add To Print Queue and Record Out of code Button is enabled
    And I click on Add To Print Queue and Record Out of code Button
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department    | category      | barcode   | quantity | quantity1 |
      | 78      | Fruit and Veg | Fruit and Veg | 108649987 | 2        | 2         |

  @sma
  Scenario Outline: TS_120 To verify that L3 user is able to create Record Out Of Code and perform markdown and submit that when scanning BY product when no printer is selected
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
    Then I click on Get Price
    And I verify Add to Print Queue button is Displayed
    Then I click on Record Out Of Code
    And I scroll Down to out of code
    Then I verify Expiry Date and Expiry Quantity is Displayed
    And I select Expiry Date for record Out of code
    And I Enter Expiry Quantity "<quantity1>" for record Out of code
    Then I Verify Add To Print Queue and Record Out of code Button is enabled
    And I click on Add To Print Queue and Record Out of code Button
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department    | category | barcode   | quantity | quantity1 |
      | 78      | Market Street | Bakery   | 110249931 | 2        | 1         |

  @sma
  Scenario Outline: TS_121 To verify that L3 user is able to create multiple Record Out Of Code and perform markdown and submit that when scanning BY product when no printer is selected
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
    And I verify Add to Print Queue button is Displayed
    Then I click on Record Out Of Code
    And I scroll Down to out of code
    Then I verify Expiry Date and Expiry Quantity is Displayed
    And I select Expiry Date for record Out of code
    And I Enter Expiry Quantity "<quantity1>" for record Out of code
    Then I click on Record Out Of Code
    And I scroll Down to out of code
    Then I verify Expiry Date and Expiry Quantity is Displayed
    And I select Expiry Date for record Out of code
    And I Enter Expiry Quantity "<quantity1>" for record Out of code
    Then I Verify Add To Print Queue and Record Out of code Button is enabled
    And I click on Add To Print Queue and Record Out of code Button
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department    | category | barcode   | quantity | quantity1 |
      | 78      | Market Street | Fish     | 102410781 | 1        | 1         |
	  #|Market Street|Fish  |107973427|2|
#	  
#@sma
#Scenario Outline:TS_122 To verify if the store Manager/User is scanning an ambient item Markdown Barcode, there is no change in functionality due to new change
#
# When I enter Username and Password for SMA Collegue user
#     And I click on login button for SMA
#    Then I click on Markdowns
#    Then I click on Scan Markdowns
#    Then I click on No Printer Available
#    And I click on the "<Department>" available
#    And I click on barcode entry Button
#    Then Enter "<Markdown_barcode>" number
#    And I see item Summary
#        
#    Examples:
#    |Department|Markdown_barcode|
#    |Ambient|92501025155455400263700016|
#

  @sma
  Scenario Outline:TS_123 To verify that when price embedded bar code are scanned service should ignore the event present in database for L3 user

    When I enter Username and Password for SMA Collegue user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity1>" for the product
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<MIN>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request


    Examples:
      | storeId | Department    | category | MIN       | quantity | Barcode       | quantity1 |
      | 78      | Market Street | Bakery   | 110114990 | 1        | 0272300030000 | 2         |

  @smaa
  Scenario Outline:TS_124 To verify that when price embedded bar code are scanned service should ignore the event present in database for L4 user


    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity1>" for the product
    And I click on Add to Print Queue as an employee


    Examples:
      | Department    | category | MIN       | quantity | Barcode       | quantity1 |
      | Market Street | Bakery   | 110114990 | 1        | 0272300030000 | 2         |


  @sma
  Scenario Outline: To verify that service should persist one entry i.e. unique MIN when a product (ITEM) with multiple barcode is markdown
# To verify that service should persist one entry i.e. unique MIN when a product (EAN8) with multiple barcode is markdown
# To verify that service should persist one entry i.e. unique MIN when a product (UPC-A) with multiple barcode is markdown

    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I see change category option
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify user redirected to Edit Item Screen
    And I verify user allowed to do save changes
	    
#	  	Given Request is made to SMA app login service for manager user
#	    Then Service should return details for SMA app Login Service
#	    And Get the generated Access Tocken for SMA app Login Service
#	    And Get generated access token
#	    Given Get request is made to GetMarkdown Details service for store id "<storeid>" and product id "<MIN>"
#	    And Get Operation perform on Markdown service request
#	    Then Get markdown details service response after scanning the product
#		And I verify service persist one entry for MIN

    Examples:
      | Department | category | MIN       | quantity | storeid | Barcode       | Type  |
      | Ambient    | Ambient  | 109894829 | 1        | 78      | 3574661435916 | EAN13 |

  @sma
  Scenario Outline: To verify that service should persist one entry i.e. unique MIN when a product (EAN13) with multiple barcode is markdown

    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I see change category option
    And I click continue
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify user redirected to Edit Item Screen
    And I verify user allowed to do save changes

    Examples:
      | Department | category | MIN       | quantity | storeid | Barcode       | Type  |
      | Ambient    | Ambient  | 105118144 | 4        | 78      | 5010251495529 | EAN13 |
		
		#-->restricted
  @sma
  Scenario Outline: To verify that service should persist one entry i.e. unique MIN when a product (VPLU) with multiple barcode is markdown

    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<MIN>" number
    And I see change category option
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I verify user redirected to Edit Item Screen
    And I verify user allowed to do save changes
	    
#	  	Given Request is made to SMA app login service for manager user
#	    Then Service should return details for SMA app Login Service
#	    And Get the generated Access Tocken for SMA app Login Service
#	    And Get generated access token
#	    Given Get request is made to GetMarkdown Details service for store id "<storeid>" and product id "<ITEM>"
#	    And Get Operation perform on Markdown service request
#	    Then Get markdown details service response after scanning the product
#		And I verify service persist one entry for MIN

    Examples:
      | Department    | category | MIN       | quantity | storeid | Barcode | Type |
      | Market Street | Fish     | 109594463 | 2        | 78      | 4037    | PLU  |
      | Market Street | Pizza    | 102793283 | 2        | 78      | 3266    | VPLU |

  @sma
  Scenario Outline: Validate manager is allowed to do final markdown from Markdown list

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
    And I click on Add to Print Queue as an employee



    Examples:
      | Department    | category      | Barcode   | quantity | percent |
      | Fruit and Veg | Fruit and Veg | 108361457 | 1        | 90      |

  @sma
  Scenario Outline: Validate user is allowed to do final clearance
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
    And I click on Add to Print Queue as an employee



    Examples:
      | Department    | category      | Barcode   | quantity | percent |
      | Fruit and Veg | Fruit and Veg | 108304794 | 1        | 90      |

  @sma
  Scenario Outline: Validate user gets optimised price on promo price for item which are in scope for BlueYonder
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


    Examples:
      | Department    | category      | Barcode   | quantity | percent |
      | Fruit and Veg | Fruit and Veg | 108384771 | 1        | 90      |

  @sma
  Scenario Outline: Validate user is allowed to capture Record out of code for Fresh items
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
    And I verify Add to Print Queue button is Displayed
    Then I click on Record Out Of Code
    And I scroll Down to out of code
    Then I verify Expiry Date and Expiry Quantity is Displayed
    And I select Expiry Date for record Out of code
    And I Enter Expiry Quantity "<quantity1>" for record Out of code
    Then I Verify Add To Print Queue and Record Out of code Button is enabled

    Examples:
      | Department    | category | barcode   | quantity | quantity1 |
      | Market Street | Fish     | 107973232 | 10       | 2         |

  @sma
  Scenario Outline: Validate user is allowed to give quantity in whole value for weight items
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

    Examples:
      | Department    | category | barcode   | quantity | quantity1 |
      | Market Street | Fish     | 107973232 | 10       | 2         |

  @sma
  Scenario Outline: Validate user gets proper warning message if markdowns quantity is higher than 19

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
    And I see Large markdown quantity warning message

    Examples:
      | Department    | category | barcode   | quantity |
      | Market Street | Fish     | 107973232 | 22       |


  @sma
  Scenario Outline: Validate manager is allowed to do markdown on restricted item L4

    When I enter Username and Password for SMA Manager user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I see Warning message
    And I click continue
    And I see new price
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee


    Examples:
      | Department | Barcode   | quantity |
      | Ambient    | 101552605 | 1        |

  Scenario Outline: Validate user is allowed to do another markdown on markdown ambient items

    When I enter Username and Password for SMA Collegue user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee

    Examples:
      | Department | Barcode   | quantity | percent |
      | Ambient    | 103138934 | 2        | 70      |

  @sma
  Scenario Outline: Validate store Collegue is not allowed to do markdown on restricted item
    When I enter Username and Password for SMA Collegue user
    And I click on login button for sma
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I see Warning message
    And I click continue
    And I see new price
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee

    Examples:
      | Department | Barcode   | quantity |
      | Ambient    | 101552605 | 1        |

  @sma
  Scenario: Validate user gets number of category completed in Department selection screen

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I verify number of category completed in Department screen is displayed


  @sma
  Scenario Outline: To verify if the Price over ride data is being sent while creating markdown and manager overrides optimised price
#Perform markdown with manger user and override the optimised price and Validate below attributes values in GET markdown details API:

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I see new price
    And I select percentage "<percent>" and see calculated value
    And I click on Add to Print Queue as an employee

    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    #Get markdown details service response before scanning the product
    And I verify Optimised price parameters


    Examples:
      | Department    | category      | Barcode   | quantity | percent | storeId | productId |
      | Fruit and Veg | Fruit and Veg | 103853612 | 1        | 70      | 78      | 103853612 |

  @sma
  Scenario Outline: To verify if the Price over ride data is being sent while creating markdown and Manager Selects Optimised Price
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I see new price
    And I click on Add to Print Queue as an employee
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    #Get markdown details service response before scanning the product
    And I verify Optimised price parameters


    Examples:
      | Department | category | Barcode | quantity | percent | storeId | productId |
#     |Fruit and Veg|Fruit and Veg  |103853612|1|70|78|103853612|
