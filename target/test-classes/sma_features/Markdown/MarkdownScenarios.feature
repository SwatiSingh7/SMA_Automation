@markdown
Feature: Verify Markdown functionality

  @sma
  Scenario Outline: Validate all departments for manager
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I validate number of "<department>" available
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | department                                      |
      | Fresh Foods,Fruit and Veg,Market Street,Ambient |
      | Fresh Foods,Fruit and Veg,Market Street,Ambient |

  @sma
  Scenario Outline: Validate all departments for store User
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I validate number of "<department>" available
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | department                                      |
      | Fresh Foods,Fruit and Veg,Market Street,Ambient |

  @sma
  Scenario Outline: Validate all catagory under all department for store manager
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I validate number of "<department>" available
    And I click on the "<Department>" available
    Then I validate all "<Category>" under all departments
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | department    | Department    | Category                                                                                                                                                                       |
      | Fresh Foods   | Fresh Foods   | 012 Regional Ranges,016 Processed & Soft Cheese,World Foods,022 Speciality Cheeses,040 Fresh Milk & Daily Dairy,050 Ready Meals,051 Bought in Cakes,052 Grated & Sliced Cheese |
      | Fresh Foods   | Fresh Foods   | 012 Regional Ranges,016 Processed & Soft Cheese,World Foods,022 Speciality Cheeses,040 Fresh Milk & Daily Dairy,050 Ready Meals,051 Bought in Cakes,052 Grated & Sliced Cheese |
      | Fruit and Veg | Fruit and Veg | Fruit and Veg                                                                                                                                                                  |
      | Market Street | Market Street | Bakery,Butchery,Deli,Fish,Food to Go,Cake Shop,Pizza,Oven Fresh                                                                                                                |

  @sma
  Scenario Outline: Validate all catagory under all department for store employee
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I validate number of "<department>" available
    And I click on the "<Department>" available
    Then I validate all "<Category>" under all departments
    Then I click on Back to home screen from HotKey Feature
    And I click on Logout Button

    Examples:
      | department    | Department    | Category                                                                                                                                                                       |
      | Fresh Foods   | Fresh Foods   | 012 Regional Ranges,016 Processed & Soft Cheese,World Foods,022 Speciality Cheeses,040 Fresh Milk & Daily Dairy,050 Ready Meals,051 Bought in Cakes,052 Grated & Sliced Cheese |
      | Fresh Foods   | Fresh Foods   | 012 Regional Ranges,016 Processed & Soft Cheese,World Foods,022 Speciality Cheeses,040 Fresh Milk & Daily Dairy,050 Ready Meals,051 Bought in Cakes,052 Grated & Sliced Cheese |
      | Fruit and Veg | Fruit and Veg | Fruit and Veg                                                                                                                                                                  |
      | Market Street | Market Street | Bakery,Butchery,Deli,Fish,Food to Go,Cake Shop,Pizza,Oven Fresh                                                                                                                |

  @sma
  Scenario Outline: Valid print error message for store manager
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I verify printer not found error message is displayed

    Examples:
      | barcode  |
      | xxxxxxx1 |

  @sma
  Scenario Outline: Valid print error message for store employee
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    And I click on barcode entry Button
    Then Enter "<barcode>" number
    And I verify printer not found error message is displayed

    Examples:
      | barcode  |
      | xxxxxxx1 |

  @sma
  Scenario Outline: Verify Manager is able to add product to print list
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
    And I click on Add to Print Queue as an employee
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
      | storeId | Department    | category | productId | quantity |
      | 3       | Market Street | Bakery   | 104736151 | 5        |

  @sma
  Scenario Outline: Employee Does complete Markdown, add product to print list
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
    And I click on Add to Print Queue as an employee
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department    | category | productId | quantity |
      | 3       | Market Street | Bakery   | 110249931 | 5        |

  @sma
  Scenario Outline: SMA-17899_To Verify firstmarkdownwindow attributes is showing updated value in Get Markdown Details API response.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get firstmarkdownwindow attributes value from GetMarkdownDetails service
    And Verify firstmarkdownwindow attributes is showing updated value as "<firstmarkdownwindow>"

    Examples:
      | storeId | productId | firstmarkdownwindow |
      | 3       | 109345459 | 18:59:59            |

  @sma
  Scenario Outline: SMA-16724_To Verify New field "first markdown window start timestamp" in HH:MM:SS format is added in "Get Markdown Details" API response.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get the generated Access Tocken for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get firstmarkdownwindow attributes value from GetMarkdownDetails service
    And Verify firstmarkdownwindow attributes is showing updated value as "<firstmarkdownwindow>"
    And I verify First markdown attribute is present and in HH:MM:SS format

    Examples:
      | storeId | productId | firstmarkdownwindow |
      | 3       | 109345459 | 18:59:59            |

  @sma
  Scenario Outline: SMA-12421_To verify Markdown percentage and Price on UI and services matchees.
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
    Then I Get Markdown percentage and Price on UI
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown percentage from GetMarkdownDetails service
    And I verify Markdown percentage on UI and services matches

    Examples:
      | storeId | Department  | category                      | productId | quantity |
      | 3       | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 | 5        |

  @sma
  Scenario Outline: SMA-14862_To verify if L3 user scans MIN, first markdown price should be fetched within the window(Markdown Price_BY InScope)
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    Then I verify first markdown price is displayed

    Examples:
      | storeId | Department  | category                      | productId |
      | 3       | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 |

  @sma
  Scenario Outline: SMA-14862_To verify if L3 user scans MIN, first markdown price should be fetched within the window(Markdown Price_BY OutScope)
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    Then I verify first markdown price is displayed

    Examples:
      | storeId | Department    | category | productId |
      | 3       | Market Street | Fish     | 102410781 |

  @sma
  Scenario Outline: SMA-18154_For collegue user, Scan a product and delete from print list and verify product is deleted.
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
    And I click on Add to Print Queue as an employee
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Then I left swipe the product and click on delete icon
    And I verify product "<productId>" is Deleted from Print list

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-18154_For Manager user Scan a product and delete from print list and verify product is deleted.
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
    And I click on Add to Print Queue as an employee
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Then I left swipe the product and click on delete icon
    And I verify product "<productId>" is Deleted from Print list

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |


  @sma
  Scenario Outline: SMA-12798_To verify that Manager user is able to scan product by using EAN barcode
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<eanBarcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue as an employee
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
      | storeId | Department  | category               | eanBarcode    | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 5010251592839 | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-12798_To verify that Colleugue user is able to scan product by using EAN barcode.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<eanBarcode>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request
    Examples:
      | storeId | Department  | category               | eanBarcode    | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 5010251592839 | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-13276_To verify that 'Product not found' message is displayed on scanning an invalid item.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Product not found message is displayed

    Examples:
      | storeId | Department  | category               | productId |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 100000000 |
  
  ############################# Print list scenarios #################################################################
  @sma
  Scenario Outline: SMA-13477_To verify that Manager user is able to scan product from the print list to search for the product in the list
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue as an employee
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
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-13477_To verify that Colleuge user is able to scan product from the print list to search for the product in the list
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |


  @sma
  Scenario Outline: SMA-13276_To verify that Collegue user is able to scan product by using EAN from the print list to search for the product in the list
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<eanBarcode>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | eanBarcode    | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 5010251592839 | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-13276_To verify that Manager user is able to scan product by using EAN from the print list to search for the product in the list
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<eanBarcode>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue as an employee
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
      | storeId | Department  | category               | eanBarcode    | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 5010251592839 | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-13276_To verify that user is able to scan product from the print list and edit quantity.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
    Then I verify product "<productId>" is present in print list
    And I Select product from print list
    And I enter markdown "<quantity1>" for the product
    And I click on Add to Print Queue as an employee
    Then I verify product "<productId>" is present in print list
    And I verify edited quantity "<quantity1>" is displayed
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | quantity1 |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 9         |

  @sma
  Scenario Outline: SMA-13276_To verify that user is able to create a new markdown by scanning an BY not-in-scope item from the print list.
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    And I click on Add to Print Queue as an employee
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
      | storeId | Department    | category | productId | quantity |
      | 3       | Market Street | Fish     | 102410781 | 5        |

  @sma
  Scenario Outline: SMA-13276_To verify that 'Product not found' message is displayed on scanning an invalid item in Print list.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I verify Product not found message is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 100000000 | 5        |

  ######################### Before First Markdown Window ####################################
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 11    | 00   | am       |

  @sma
  Scenario Outline: SMA-12957_(Return Markdown price in Pence_EA) To verify that service is displaying price in pence though Blueyonder sends in pounds.
    Given Request is made to SMA app login service for collegue user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>" before scanning a products
    And Get Operation perform on Markdown service request
    Then Get markdown details service response before scanning the product
    Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Blueyonder service request
    Then Get Blueyonder Details service response
    And Verify price unit in service

    Examples:
      | storeId | Department    | category      | productId |
      | 3       | Fruit and Veg | Fruit and Veg | 103853612 |


  @sma
  Scenario Outline: SMA-16742_Scans AMBIANT Products in "firstmarkdownwindow" and verify product is present in Print list
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department | productId | quantity | isComplete |
      | 3       | Ambient    | 103138934 | 4        | N          |

  @sma
  Scenario Outline: SMA-16741_To Verify last markdown price is displayed when a manager user is scanning a product for which first markdown is done by manager user in same first markdown window.
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
    Then I get calculated price on Item summary screen
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    And I click on Back button
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I get New price on UI
    Then Verify last markdown price is displayed when a manager user is scanning a product
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-16739_To Verify last markdown price is displayed when a colleague user is scanning a product for which first markdown is done by manager user in same first markdown window.
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
    And I get calculated price on Item summary screen
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
    And I get New price on UI
    Then Verify last markdown price is displayed when a manager user is scanning a product
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-16737_To Verify final clearance markdown popup is not displayed when a manager user is scanning but not overriding default price of a FRESH product in "firstmarkdownwindow".
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
    Then I verify Clearance alert is not displayed
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-16727(Service)_To Verify last markdown price is displayed when a colleague user is scanning a product for which first markdown is done by manager user in same first markdown window.
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
    And I get calculated price on Item summary screen
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
    And I get New price on UI
    Then Verify last markdown price is displayed when a manager user is scanning a product
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify First markdown attribute is present and in HH:MM:SS format
    Then I verify current price on Ui and services is matched
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        |

  @sma
  Scenario Outline: SMA-16735_To Verify final clearance markdown popup is not displayed when a manager user is scanning and overriding default price of a FRESH product before "firstmarkdownwindow".
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
    And I verify Clearance alert is not displayed
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        | N          |

  @sma
  Scenario Outline: SMA_-16379_To Verify final clearance markdown popup is not displayed when a colleague user is scanning a FRESH product in "firstmarkdownwindow".
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
    And I click on Add to Print Queue as an employee
    Then I verify Clearance alert is not displayed
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | N          |
      
      
       ##############################################  First markdown Time Interval ####################################################################

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | pm       |

  @sma
  Scenario Outline: SMA-16742_To Verify There is no changed in when user scans AMBIANT Products in "firstmarkdownwindow".
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    And I verify Clearance alert is not displayed
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department | productId | quantity | percentage | isComplete |
      | 3       | Ambient    | 103138934 | 4        | 75%        | N          |

  @sma
  Scenario Outline: SMA-16745_To Verify manager user is able to perform final clearance markdown by overriding price to maximum percentage (90%) when scanning out of "firstmarkdownwindow".
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
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 90%        | Y          |

  @sma
  Scenario Outline: SMA-18150_To Verify manger user is able perform clearance markdown by overriding calculated price in firstmarkdown window by selecting yes in the Clearance markdown popup.
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
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        | Y          |

  @sma
  Scenario Outline: SMA-16733_To Verify manager user is able to perform first markdown by clicking on "No" in final clearance markdown popup in "firstmarkdownwindow".
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
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed
    And I click on No button on Clearance alert
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        | N          |

  @sma
  Scenario Outline: SMA_-16379_To Verify manager user is able to perform clearance markdown by clicking on "Yes" in final clearance markdown popup in "firstmarkdownwindow".
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
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 60%        | Y          |

  @sma
  Scenario Outline: SMA-16731_To Verify Pop up content is as per requirement.
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
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |

  @sma
  Scenario Outline: SMA-16730_To verify final clearance markdown popup is displayed to Manager user, once user is scanning and overriding default price of a FRESH product in "firstmarkdownwindow".
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
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 70%        |

  @sma
  Scenario Outline: SMA-16729(Service)_To Verify last markdown price is displayed when a manager user is scanning a product for which first markdown is done by manager user in same first markdown window.
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
    And I get calculated price on Item summary screen
    And I click on Add to Print Queue
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    And I click on Back button
    Then I select one of the "<category>"
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I get New price on UI
    Then Verify last markdown price is displayed when a manager user is scanning a product
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify First markdown attribute is present and in HH:MM:SS format
    Then I verify current price on Ui and services is matched
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |

  @sma
  Scenario Outline: SMA-16745_To Verify when manager is scanning a FRESH product in "firstmarkdownwindow" and overriding calculate price to 90% then final clearance pop up should not be displayed and it should be considered as final clearance markdown.
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
    Then I verify Clearance alert is not displayed
    And I click on Print list icon
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category                      | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 | 5        | 90%        | Y          |


  @sma
  Scenario Outline: SMA-13477_To verify that Manager user is able to scan product from the print list and overriding calculate price to 90% then final clearance pop up should not be displayed and it should be considered as final clearance markdown.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 90%        | Y          |

  @sma
  Scenario Outline: SMA-13477_To verify that Manager user is able to scan product from the print list and overriding calculate price upto 75% then final clearance pop up should be displayed.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        |

  @sma
  Scenario Outline: SMA-13477_To verify that Manager user is able to scan product from the print list and overriding calculate price upto 75% and Select 'Yes' option and it should be considered as final clearance markdown.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed
    And I click on Yes button on Clearance alert
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        | Y          |

  @sma
  Scenario Outline: SMA-13477_To verify that Manager user is able to scan product from the print list and overriding calculate price upto 75% and Select 'Yes' option and it should be considered as regular markdown.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    Then I select one of the "<category>"
    And I click on Print list icon
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I click on Get Price
    And I click on Discount percenatge dropdown on Item summary screen
    Then I select "<percentage>" value from discount dropdown
    And I click on Add to Print Queue
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed
    And I click on No button on Clearance alert
    Then I verify product "<productId>" is present in print list
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify isComplete attribute value as "<isComplete>" in GetMarkdownDetails service
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category               | productId | quantity | percentage | isComplete |
      | 3       | Fresh Foods | 022 Speciality Cheeses | 106145443 | 5        | 75%        | N          |

  @sma
  Scenario Outline: SMA-13059_To verify if the Manager is able to choose 'Optimized' percentage to return to the markdown service recommended price
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
    Then I capture selected Markdown percentage value "<percentage>" and corresponding Price on UI
    And I click on Add to Print Queue
    Then I verify Clearance alert is displayed
    Then I verify Yes and No buttons is displayed
    And I click on Yes button on Clearance alert
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    And I verify Markdown percentage on UI and services matches
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category                      | productId | quantity | percentage |
      | 3       | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 | 5        | 75%        |

  @sma
  Scenario Outline: SMA-12798_To Verify that a L3 user is not able to edit New price when scanning Non-BY optimised product
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Markdowns
    Then I click on Scan Markdowns
    Then I click on No Printer Available
    And I click on the "<Department>" available
    And I click on barcode entry Button
    Then Enter "<productId>" number
    And I enter markdown "<quantity>" for the product
    Then I verify discount dropdown is disabled

    Examples:
      | storeId | Department | productId | quantity |
      | 3       | Ambient    | 103138934 | 5        |
      
       ############################################## After first markdownwindow ##########################################################3

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 12    | 00   | am       |

  @sma
  Scenario Outline: SMA-16736_To Verify final clearance markdown popup is not displayed when a manager user is scanning and overriding default price of a product after "firstmarkdownwindow".
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
    Then I verify Clearance alert is not displayed
    Given Request is made to SMA app login service for manager user
    Then Service should return details for SMA app Login Service
    And Get generated access token
    Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    And Get Operation perform on Markdown service request
    Then Get markdown details service response after scanning the product
    Given Patch request is made to delete print list service for store id "<storeId>"
    Then Patch Operation perform on Markdown service request

    Examples:
      | storeId | Department  | category                      | productId | quantity | percentage |
      | 3       | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 | 5        | 65%        |
      
      
      ########################################## Bluyonder data required for below scenarios ####################################################################
      #
      #
       #@sma
  #Scenario Outline: SMA-13276_To verify that user is able to create a new markdown by scanning an BY scope item from the print list.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on Print list icon
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #And I click on Add to Print Queue as an employee
    #Then I verify product "<productId>" is present in print list
    #Given Request is made to SMA app login service for collegue user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department  | category                      | productId | quantity |
      #|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 |        5 |
      #
       #@sma
  #Scenario Outline: SMA-13271_(L4 USER_ Blue Yonder price) To Verify that the price response from Blue Yonder the screen is displayed calculated
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<barcode>" number
    #And I enter markdown "<quantity>" for the product
    #Then I click on Get Price
    #And I verify calculated price is displayed
    #Then I get calculated price on Item summary screen
    #Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Blueyonder service request
    #Then Get Blueyonder Details service response
    #And I verify calculated price on UI matched with bluyonder response
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department    | category | barcode   | quantity |
#			|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 |5 |
#			
#			@sma
  #Scenario Outline: SMA-13271_(NEG_L3 User_NoCalculated) To Verify that calculated term is not showing in discount dropdown when user scans blueyonder item for L3 user
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<barcode>" number
    #And I enter markdown "<quantity>" for the product
    #Then I click on Get Price
    #And I verify calculated price is not displayed
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<barcode>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department    | category | barcode   | quantity |
      #|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 |5 |
      #
       #@sma
  #Scenario Outline: SMA-18154_To verify the calculate price displayed in UI is matching with Blueyonder service response when Colleague user is scanning a product Before 4pm.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #And I click on Add to Print Queue as an employee
    #And I click on Print list icon
    #Then I verify product "<productId>" is present in print list
    #Then I click on Back button
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #Then I get New price on UI
    #Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Blueyonder service request
    #Then Get Blueyonder Details service response
    #Then Verify calculate price displayed in UI is matching with Blueyonder service response
    #Given Request is made to SMA app login service for collegue user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department  | category                      | productId | quantity |
      #|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 |        5 |
      #
      #@sma
  #Scenario Outline: SMA-18148_To verify the calculate price displayed in UI is matching with Blueyonder service response when manager user is scanning a product Before 4pm.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #Then I click on Get Price
    #Then I get calculated price on Item summary screen
    #Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Blueyonder service request
    #Then Get Blueyonder Details service response
    #Then Verify for manager user calculate price displayed in UI is matching with Blueyonder service response
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department    | category | productId | quantity |
#			|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 |5 |
#			
#			@sma
  #Scenario Outline: SMA-17899_To Verify when user is performing markdown for a fresh product after cut off time then blueyonder is sending calculated price.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #And I click on Add to Print Queue as an employee
    #And I click on Print list icon
    #Then I verify product "<productId>" is present in print list
    #Then I click on Back button
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #Then I get New price on UI
    #Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Blueyonder service request
    #Then Get Blueyonder Details service response
    #Then Verify calculate price displayed in UI is matching with Blueyonder service response
    #Given Request is made to SMA app login service for collegue user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department  | category                      | productId | quantity | percentage |
      #|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 |        5 | 75%        |
      #
      #@sma
  #Scenario Outline: SMA-12421_To verify that User is able to see optimised price for scanned product(Service)
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #And I click on Add to Print Queue as an employee
    #And I click on Print list icon
    #Then I verify product "<productId>" is present in print list
    #Given Request is made to SMA app login service for collegue user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Then Verify optimized percentage and price from GetMarkdownDetails service
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department  | category               | productId | quantity | 
     #|      3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 |        5 |
     #
     #
     #@sma
  #Scenario Outline: SMA-12630_To Verify that L4 User is able to update the item price details when product is in scope of blueyonder
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #Then I click on Get Price
    #And I click on Discount percenatge dropdown on Item summary screen
    #Then I select "<percentage>" value from discount dropdown
    #And I click on Add to Print Queue
     #Then I verify Clearance alert is displayed
    #Then I verify Yes and No buttons is displayed
    #And I click on Yes button on Clearance alert
    #And I click on Print list icon
    #Then I verify product "<productId>" is present in print list
      #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
 #Then Patch Operation perform on Markdown service request
    #Examples: 
       #| storeId | Department  | category   | productId | quantity | percentage |
      #|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 109345459 |        5 | 75%        |
     #
      #@sma
  #Scenario Outline: SMA-12798_To Verify that a L3 user is not able to edit New price as discount drop down is disabled when scanning By In Scope Item
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #Then I verify discount dropdown is disabled
#
    #Examples: 
      #| storeId | Department  | category               | productId | quantity | 
      #|      3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 |        5 |
      #
      #@sma
  #Scenario Outline: SMA-12798_To Verify that a L4 user is able to edit New price as discount drop down is enabled when scanning BY optimised product
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #Then I click on Get Price
    #And I verify discount dropdown is enabled
    #And I click on Discount percenatge dropdown on Item summary screen
    #Then I select "<percentage>" value from discount dropdown
    #And I verify Manager selected optimized percentage "<percentage>" is displayed
     #And I click on Add to Print Queue
     #Then I verify Clearance alert is displayed
    #Then I verify Yes and No buttons is displayed
    #And I click on Yes button on Clearance alert
    #And I click on Print list icon
    #Then I verify product "<productId>" is present in print list
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
#Then Patch Operation perform on Markdown service request
    #Examples: 
      #| storeId | Department  | category               | productId | quantity | percentage |
      #|      3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 |        5 | 75%|
      #
      #
       ############################################### Bluyonder data required #############################################################################
       ############################################### In first markdown window #############################################################################
       #
       #@sma
  #Scenario Outline: SMA-18154_To verify the calculate price displayed in UI is matching with Blueyonder service response when Colleague user is scanning a product In first markdown window.
    #When I enter Username and Password for SMA Collegue user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #And I click on Add to Print Queue as an employee
    #And I click on Print list icon
    #Then I verify product "<productId>" is present in print list
    #Then I click on Back button
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #Then I get New price on UI
    #Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Blueyonder service request
    #Then Get Blueyonder Details service response
    #Then Verify calculate price displayed in UI is matching with Blueyonder service response
    #Given Request is made to SMA app login service for collegue user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department    | category | productId | quantity |
 #			|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 | 5 |
  #
  #@sma
  #Scenario Outline: SMA-18149_To verify the calculate price displayed in UI is matching with Blueyonder service response when manager user is scanning a product In first markdown window.
    #When I enter Username and Password for SMA Manager user
    #And I click on login button for SMA
    #Then I click on Markdowns
    #Then I click on Scan Markdowns
    #Then I click on No Printer Available
    #And I click on the "<Department>" available
    #Then I select one of the "<category>"
    #And I click on barcode entry Button
    #Then Enter "<productId>" number
    #And I enter markdown "<quantity>" for the product
    #Then I click on Get Price
    #Then I get calculated price on Item summary screen
    #Given Get request is made to Blueyonder Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Blueyonder service request
    #Then Get Blueyonder Details service response
    #Then Verify for manager user calculate price displayed in UI is matching with Blueyonder service response
    #Given Request is made to SMA app login service for manager user
    #Then Service should return details for SMA app Login Service
    #And Get generated access token
    #Given Get request is made to GetMarkdown Details service for store id "<storeId>" and product id "<productId>"
    #And Get Operation perform on Markdown service request
    #Then Get markdown details service response after scanning the product
    #Given Patch request is made to delete print list service for store id "<storeId>"
    #Then Patch Operation perform on Markdown service request
#
    #Examples: 
      #| storeId | Department  | category | productId | quantity |
      #|       3 | Fresh Foods | 026 Soup, Pasta, Garlic Bread | 104843176 | 5 |