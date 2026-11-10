@MOCO_CreateCustomerOrderScn
#Create New Manager order SMA_Scanning Endpoint
Feature: SMA-56772_INT_Create New Customerorder_SMA_Scanning

  @sma @MOCOCustmr_DeleteAllOrders
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC10, To verify response show all orders when Get Order details is hit sort by end date asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint1>" and "<APIKey>" and "<AuthKey>"

    Examples:
      | EndPoint                                                             | EndPoint1                                                                     |APIKey                           | AuthKey                                                                    | Filter1        | Filter2       | Param3                 | Request    | Response                                                       |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all |supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/deleteAllOrdId |GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=endDate | sortOrder=asc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_EndDateAsc.json |

  @sma @CustmrMOCOVerfMgrLnk
  Scenario: SMA-56772_INT_Create New Customerorder_SMA_Scanning_TC01_To verify customer order link is  display Stock management application for Store Colleague and Store Manager
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    Then I Verify "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I Verify "sObjectName" "Customer Orders" on page "ManagerOrderPage"

#  @sma @wwMOCOVerfMgrLnk
#  Scenario: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC01_To verify manager order link in  display Stock management application for Store Colleague and Store Manager
#    When I enter Username and Password for SMA Manager user
#    And I click on login button for SMA
#    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
##    Then I Verify "sObjectName" "Manager Orders" on page 'ManagerOrderPage'
#    And I Verify following 'sObjectName' on page 'ManagerOrderPage'
#      |Manager Orders||Customer Orders|


  @sma @CustmrVerfCustmrCreateOrdr
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC02_To verify only Store Manager has ability to create customer  orders
    Given I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    Then I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I Verify "sObjectName" "Scan or manually enter a product" on page "ManagerOrderPage"
    And I Verify "ScanImage" on page "ManagerOrderPage"

    Examples:
      | Barcode   | Heading1       | Heading2        |
      | 108394582 | Manager Orders | Customer Orders |

  @sma @CustmrVerfCollgCannotCreateMgrOrdr
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC03_To verify Store Customer is not allowed to create Customer orders for PIN items or Outer Case Barcodes
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    Then I verify the error message "errorMsg1" "errorMsg2" "<message>" is displayed on page "ManagerOrderPage"

    Examples:
      | message                                                                                                    |
      | Create Manager Order Is Unavailable\nYou are using a colleague sign on, so can only view the Manager Orders|

  @sma @CustmrValidatePIN_Items @InvalidItemDemo
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC04_To verify Store Manager is not allowed to create Customer orders for Invalid item  for eg :Inactive product
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
#    And I click on 'CreateTab' on page 'ManagerOrderPage'
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                    |
      | 111608060 | Invalid Input\nYou cannot create an order using outer case barcode. Please use either:\nProduct Barcode\nShelf Edge Label\nMIN |

  @sma @CustmrVerfInvalidItem @@InvalidItemDemo
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC05_To verify Store Manager is not allowed to create customer orders for Invalid item  for eg : Delist  product
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
#    And I click on 'CreateTab' on page 'ManagerOrderPage'
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                                  |
      | 110202041 | Product Blocked\nYou are not able to place a Customer Order against this product, because it is either:\nRestricted\nDelisted\nInactive |

  @sma @CustmrVerfInvalidItemDelisted
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC06_To verify Store Manager is not allowed to create Customer orders for Invalid item  for eg :Derange item
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                                                                   |
      | 110202041 | Product Blocked\nYou are not able to place a Customer Order against this product, because it is either:\nRestricted\nDelisted\nInactive|

  @sma @CustmrVerfDerangedItem
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC07_To verify Store Manager is not allowed to create Customer orders for Restricted item
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                                                                     |
      | 108524922 | Product Blocked\nYou are not able to place a Customer Order against this product, because it is either:\nRestricted\nDelisted\nInactive |

  @sma @CustmrVerfRestrictedItem
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC08_To verify Store Manager is not allowed to create Manager orders for Restricted item
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                                                                    |
      | 108524922 | Product Blocked\nYou are not able to place a Customer Order against this product, because it is either:\nRestricted\nDelisted\nInactive |

  @sma @CustmrVerfValidItem
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC08_To verify Store Manager is  allowed to create customer orders for valid item  for eg : Active , ranged and listed items
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Instore Date" on page "ManagerOrderPage"
#    And I verify Product Details on "CreateOrder" page

    Examples:
      | Barcode   | ItemDetails                                                                    |
      | 106182332 | Ariel Original 10 Washes 650g,MIN,EAN,Case Size,Instore Date |

  @sma @Scanning_TC09
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC09_To verify Store Manager is allowed to create Manager orders for valid item only for scheduled dates
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Instore Date" on page "ManagerOrderPage"

    Examples:
      | Barcode   | ItemDetails                                                                                                                                     |
      | 105148790 | Diet Tonic & Lemon 1l,MIN:105148790,EAN,Case Size,Instore Date|

  @sma @CustmrVerfNonSchldItem
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC11_To verify Store Manager is not allowed to create Manager orders for valid item for Non schedule dates
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                                         |
      | 108524922 | Customer Order is Unavailable\nYou can view the existing orders but are not able to place new orders this time |

  @sma @CustmrMinMaxStartDate
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC10_To verify Minimum Start date and Maximum start validation on create order screen
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    Then I verify the "rangeObj" date range <dateRange1> for "Instore Date" from current date + 1 on page 'MOCO.ManagerOrderPage'
    Then I verify the "rangeObj" date range <dateRange2> for "Instore Date" from current date + 0 on page 'MOCO.ManagerOrderPage'
    Then I verify the "rangeObj" date range <dateRange3> for "Instore Date" from current date + 0 is not within limit on page 'MOCO.ManagerOrderPage'
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Examples:
      | Barcode   |dateRange1 |dateRange2|dateRange3|
      | 106858881 | 3          |28        |29        |

  @sma @CustmrMinMaxEndDate
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC13_To verify Minimum End date (GAP)  and Maximum End date (GAP)  validation on create order screen
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    And I click on "InstoreDateBtn" on page "MOCO.ManagerOrderPage"
    Then I verify the "rangeObj" date range 3 for "Instore Date" from current date + 0 on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    And I click "Datebtn" "Instore Date" on page "MOCO.ManagerOrderPage"
    Then I verify the "rangeObj" date range 28 for "Instore Date" from current date + <dateRange> on page 'MOCO.ManagerOrderPage'
    Then I verify the "rangeObj" date range 29 for "Instore Date" from current date + <dateRange> is not within limit on page 'MOCO.ManagerOrderPage'
    And I click "oButton" "DONE" on page "ManagerOrderPage"

    Examples:
      | Barcode   | dateRange |
      | 106858881 |      10    |

  @sma @Custmrverf7DaysGap
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC14_To verify there should be 7 days Gap between startdate and end  validation on create order screen
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Instore Date" on page "ManagerOrderPage"
    And I click on "InstoreDateBtn" on page "MOCO.ManagerOrderPage"
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"


    Examples:
      | Barcode   | dateRange |dateRange1 |ItemDetails                                                                  |
      | 106858881 | 8         |     9    |Ariel Original 10 Washes 650g,MIN,EAN,Case Size,Instore Date|

  @sma
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC11_To verify  Maximum quantity reached validation for Create order screen
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Instore Date" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"
#    Then I should get a Message saying "<message1>" and should be able to click the "OK" Button
#    Then I verify scuccess "<message>"

    Examples:
      | Barcode   |dateRange |dateRange1  |quantity|ItemDetails                                                                    | message                                                                                | Quantity |
      | 108524922 | 8       |       16    |51      |Ariel Original 10 Washes 650g,MIN,EAN,Case Size,Instore Date|Maximum Quantity Exceeded\nThe current maximum quanity for this product is 50 units | 503      |

  @sma @CustmrHFSSPrd
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC12_To verify HFSS Flag with View details is NOT required for customer orders product information screen.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "High Fat Sugar Salt" on page "ManagerOrderPage"
#    And I click on Back Button
#    Then I verify product information screen is displayed

    Examples:
      | Barcode   |ItemDetails                                                                    |                               message                                                                                                                                     |
      | 112635941 |Ariel Original 10 Washes 650g,MIN:112635941,EAN,Case Size,Instore Date |Product Blocked \n You are not able to place a Manager order against this product, because it is either:\n Restricted\n Delisted\n Inactive |

  @sma @CustmrsuccessMgrCreateOrdr
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC13_To verify  Manager order is created successfully which complies to all validations criteria
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
#    Then I verify scuccess "<message>"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    Examples:
      | Barcode   |dateRange |dateRange1  |quantity|message                                                                                                                                     |OrderDetails|ItemDetails|
      | 113836365 |   8       |       16   |7        |Product Blocked\nYou are not able to place a Manager order against this product, because it is either:\n Restricted\n Delisted\n Inactive |MIN:113836365,QTY,DEPT,Created by,Instore Date|Heinz Beanz Jalfrezi 390g,MIN,EAN,Case Size|
      | 106182332 |   8       |       16   |7        |Product Blocked\nYou are not able to place a Manager order against this product, because it is either:\n Restricted\n Delisted\n Inactive |MIN:106182332,QTY,DEPT,Created by,Instore Date|Ariel Original 10 Washes 650g,MIN,EAN,Case Size|

  @sma
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC14_To verify maximum order validation is displayed on create order screen when active order  excceeds max order quantity
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    And I Verify "oButton" "Cancel" on page "ManagerOrderPage"
    And I Verify "oButton" "Review Order(s)" on page "ManagerOrderPage"
    And I click "oButton" "Review Order(s)" on page "ManagerOrderPage"
    And I click on 'ReviewOrder' on page 'ManagerOrderPage'
    Then I verify "Manager orders history" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"
    Examples:
      | Barcode   |dateRange |dateRange1  |quantity|OrderDetails|ItemDetails |message                                   |
      | 108524922 | 8       |       16   |7        |MIN,QTY,DEPT,Created by,Instore Date|Ariel Original 10 Washes 650g,MIN:112635941,EAN,Case Size,Instore Date|Customer Order is currently Unavailable\nYou can view the existing order but are not able to place new orders at this time.|

  @sma @CustmrDuplicateMgrOrdOvpl
  Scenario Outline: SMA-56772_INT_Create New Customer order_SMA_Scanning_TC15_To verify Duplicate Customer order for an item can not be created for the same  instore dates for wihich  order already exist
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Instore Date" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
    Then I verify the error message "errorMsg" "errorMsg1" "<message1>" is displayed on page "ManagerOrderPage"
    And I Verify "oButton" "Cancel" on page "ManagerOrderPage"
    And I Verify "oButton" "Review Order(s)" on page "ManagerOrderPage"
    And I click "oButton" "Review Order(s)" on page "ManagerOrderPage"
    And I Verify "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    Then I verify "Manager orders history" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    And I click on 'BackBtn' on page 'MOCO.ManagerOrderPage'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Instore Date" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
    Then I verify the error message "errorMsg" "errorMsg1" "<message1>" is displayed on page "ManagerOrderPage"
    And I Verify "oButton" "Cancel" on page "ManagerOrderPage"
    And I Verify "oButton" "Review Order(s)" on page "ManagerOrderPage"
    And I click "oButton" "Cancel" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "Manager Orders" not found on page "ManagerOrderPage"

    Examples:
      | Barcode   |dateRange |dateRange1  |quantity |message1                                                                                                  |OrderDetails                               |ItemDetails                                |
      | 113836365 | 8        |       16   |7        |Existing Order(s)\nA live order for this product already exists within the date range you have selected.|MIN,QTY,DEPT,Created by,Instore Date|Heinz Beanz Jalfrezi 390g,MIN,EAN,Case Size|