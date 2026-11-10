@UI_MOCOdemo
Feature: Demo Scenarios for MOCO UI

  @sma @uuasuccessMgrCreateOrdr
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC17_To verify  Manager order is created successfully which complies to all validations criteria
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange1>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
#    Then I verify success "<message>" for ionic
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    Then I click on Back Button till we get to the "Shop Floor - Gap Scan" page on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Stock Management Applications" page
#    And I logout of the system
    Examples:
      | Barcode   |dateRange |dateRange1  |quantity  |message                            |OrderDetails|ItemDetails|
      | 113836365 |   8       |       16   |7        |Manager order created successfully |MIN:113836365,QTY,DEPT,Created by,Start Date,End Date|Heinz Beanz Jalfrezi 390g,MIN,EAN,Case Size|
      | 106182332 |   8       |       16   |7        |Manager order created successfully |MIN:106182332,QTY,DEPT,Created by,Start Date,End Date|Ariel Original 10 Washes 650g,MIN,EAN,Case Size|

  @sma @ssVerfCreateManagerOrder
  Scenario Outline: SMA-56688_TC01_[SERVICE] MOCO | POST Order Endpoint_To verify 201 Reponse fro Create manager Order works successfully
    Given I hit the post endpoint to retrieve the "Create manager order" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param>" and Request file "<Request>" for item "itemNumber=104639896"
    Then I Verify the Response Code for the following "Create manager order" is "201"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                        | APIKey                           | Param     | AuthKey                                                                    | Request                                                    | Response                           |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | dryRun=no | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | json-files/service/MOCO/Request/CreateManagerOrderReq.json | message:Order created successfully |

  @sma @SortByDiffOptions
  Scenario Outline: SMA-56764_[INT] [INT] Manager order | Review orders | SMA_TC08 To verify that Manager reviews created manager order when Review screen to provide sorting by different options
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
#    And I click "ListItem" "End Date" on page "ManagerOrderPage"
##    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
##    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "Orders" is sorted by "End Date" in "desc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
    And I click "ListItem" "Start Date" on page "ManagerOrderPage"
    Then I verify "Orders" is sorted by "Start Date" in "asc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
    And I click "ListItem" "Quantity" on page "ManagerOrderPage"
    Then I verify "Orders" is sorted by "QTY" in "desc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
    And I click "ListItem" "User" on page "ManagerOrderPage"
    Then I verify "Orders" is sorted by "Created by" in "asc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
    And I click "ListItem" "End Date" on page "ManagerOrderPage"
    Then I verify "Orders" is sorted by "End Date" in "asc" order on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Shop Floor - Gap Scan" page on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Stock Management Applications" page
#      Then Verify Start date - By Default - In Ascending order (Earliest at the top)
#      Then I verify End date - In Descending order (Latest at the top)
#      Then I verify User - In Alphabetical order
#      Then I verify Quantity - In Descending order (Highest at the top)
#      Then I verify Department - In Alphabetical order
#    And I logout of the system
    Examples:
      | Barcode   | message                                   |
      | 108524922 | Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @amendsuccessMgrCreateOrdr
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC17_To verify  Manager order is created successfully which complies to all validations criteria
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    #    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click "Orders" "MIN: 106182332" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity1>", "QuantityEdt" and click on "sLocatorName" "UPDATE ORDER" button on "MOCO.ManagerOrderPage" page
    And I click "oButton" "Confirm" on page "ManagerOrderPage"
#    Then I verify success "<message>" for ionic
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    Then I click on Back Button till we get to the "Shop Floor - Gap Scan" page on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Stock Management Applications" page
#    And I logout of the system
    Examples:
      | Barcode   |dateRange |dateRange1  |quantity |quantity1  |message                           |OrderDetails                                         |ItemDetails|
      | 106182332 |   8       |       16   |10      |1          |Manager order updated successfully|MIN:106182332,QTY:1,DEPT,Created by,Start Date,End Date|Ariel Original 10 Washes 650g,MIN,EAN,Case Size|

  @sma @qqVerfInvalidItem @@InvalidItemDemo
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC05_To verify Store Manager is not allowed to create Manager orders for Invalid item  for eg :Inactive product
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click on 'CreateTab' on page 'ManagerOrderPage'
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"
#    Then I click on Back Button till we get to the "Shop Floor - Gap Scan" page on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Stock Management Applications" page
#    And I logout of the system

    Examples:
      | Barcode   | message                                                                                                  |
      | 110202041 | Product Blocked\nYou are not able to place a Manager Order against this product, because it is either:\nRestricted\nDelisted\nInactive\n |

  @sma @VerfInvalidItemDelisted
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC06_To verify Store Manager is not allowed to create Manager orders for Invalid item  for eg : Delist  product
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"
#    Then I click on Back Button till we get to the "Shop Floor - Gap Scan" page on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Stock Management Applications" page
#    And I logout of the system

    Examples:
      | Barcode   | message                                                                                                                                   |
      | 110202041 | Product Blocked\nYou are not able to place a Manager Order against this product, because it is either:\nRestricted\nDelisted\nInactive\n|

  @sma @VerfValidItem
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC09_To verify Store Manager is allowed to create Manager orders for valid item  for eg : Active , ranged and listed items
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    Then I click on Back Button till we get to the "Shop Floor - Gap Scan" page on page 'ManagerOrderPage'
#    Then I click on Back Button till we get to the "Stock Management Applications" page
#    And I verify Product Details on "CreateOrder" page
#    And I logout of the system

    Examples:
      | Barcode   | ItemDetails                                                                    |
      | 106182332 | Ariel Original 10 Washes 650g,MIN,EAN,Case Size,Start Date,End Date |

  @sma @ValidatePIN_Items @InvalidItemDemo
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC04_To verify Store Manager is not allowed to create Manager orders for PIN items or Outer Case Barcodes
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click on 'CreateTab' on page 'ManagerOrderPage'
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                    |
      | 111608060 | Invalid Input\nYou cannot create an order using outer case barcode. Please use either:\nProduct Barcode\nShelf Edge Label\nMIN\n |

#  @sma @DeleteItems
#  Scenario: SMA-56764_[INT] [INT] Manager order | Review orders | SMA_TC08 To verify that Manager reviews created manager order when Review screen to provide sorting by different options
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I Delete products "oProductDtls" "productName" from the list on page "ManagerOrderPage"
