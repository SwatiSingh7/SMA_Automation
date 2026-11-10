@CustmrReview_MOCO_UI
#SMA-56764_[INT] [INT] Manager order | Review orders |
Feature: SMA-56764_[INT] [INT] Manager order | Review orders |

  @sma @MOCOCustmr_DeleteAllOrders
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC10, To verify response show all orders when Get Order details is hit sort by end date asc
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param3>" with filetr "<Filter1>" and "<Filter2>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I hit the get endpoint to retrieve the "deletes order data" for the following "<EndPoint1>" and "<APIKey>" and "<AuthKey>"

    Examples:
      | EndPoint                                                             | EndPoint1                                                                     |APIKey                           | AuthKey                                                                    | Filter1        | Filter2       | Param3                 | Request    | Response                                                       |
      | supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/@all |supplychain-managercustomerorders/v1/stores/{getStoreId}/orders/deleteAllOrdId |GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | sortBy=endDate | sortOrder=asc | orderType=managerorder | "//gfdgdf" | json-files/service/MOCO/Response/getOrdersResp_EndDateAsc.json |

  @sma @VerfCreatedLiveOrd
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC01 To verify that when Store Colleague and Store Manager want to review created live Customer orders then customer orders history is available to view and manage as per store need.
    Given I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
#    Then I verify Manager orders history is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    Then I verify "Manager orders history" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    Then Verify Store Colleague and Sotre Manager review created live manager orders then Manager orders history is available to view and manage as per store need.
    Examples:
      | Barcode   |OrderDetails                                      |
      | 106182332 | MIN,QTY,DEPT,Created by,Start Date,End Date          |

  @sma @ReviewOrderValidItem
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC02 To verify customer creates an order using valid item
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    And I Verify "sObjectName" "Instore Date" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
    Then I should get a Message saying "<message1>" and should be able to click the "OK" Button
    Examples:
      | Barcode   |dateRange |dateRange1  |quantity |message1                                                                                                                      |OrderDetails|
      | 108524922 |8        |       16    |7        |Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time. |MIN,QTY,DEPT,Created by,Start Date,End Date|

  @sma @VerfMgrOrdRev
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC03 To verify that customer reviews created customer order when created customer order is available in the review to view details. Available for store manager or store colleague (view only).
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders history" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    Examples:
      | Barcode   | OrderDetails                               |                                                     message                                                                |
      | 108524922 |MIN,QTY,DEPT,Created by,Start Date,End Date |Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @verfLiveOrdrs
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC04 To verify that customer reviews created customer order when Total orders with number of live orders to be listed on review screen.

    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders history" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    Examples:
      | Barcode   | OrderDetails                                                                         |message                                   |
      | 106858881 |  MIN,QTY,DEPT,Created by,Start Date,End Date                                         |Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC05 To verify that customer reviews created customer order when It should display details like product description, product image, MIN, Qty, Created by, Start Date, End Date, Department name.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders history" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    Examples:
      | Barcode   | OrderDetails                                                                         |message                                   |
      | 108524922 |      MIN,QTY,DEPT,Created by,Start Date,End Date                                     |Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @StartDateValid
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC06 To verify that customer reviews created customer order when Live orders should be sorted by default with Start date in ascending order (Earliest at the top).
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Orders" is sorted by "Instore Date" in "asc" order on page 'ManagerOrderPage'

    Examples:
      | Barcode   | message                                   |
      | 108524922 | Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @MgrSortOrdrverf
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC07 To verify that customer reviews created customer order when same start date for multiple items then next sorting is by product description in alphabetical order.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Orders" is sorted by "Instore Date" with second sorting by "oProductDtls" "productName" in "asc" order on page 'ManagerOrderPage'
    Examples:
      | Barcode   | message                                   |
      | 108524922 | Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @SortByDiffOptions
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC08 To verify that customer reviews created customer order when Review screen to provide sorting by different options
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
#    And I click "ListItem" "End Date" on page "ManagerOrderPage"
##    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
##    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "Orders" is sorted by "End Date" in "desc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
    And I click "ListItem" "Instore Date" on page "ManagerOrderPage"
    Then I verify "Orders" is sorted by "Start Date" in "asc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
    And I click "ListItem" "Quantity" on page "ManagerOrderPage"
    Then I verify "Orders" is sorted by "QTY" in "desc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
    And I click "ListItem" "User" on page "ManagerOrderPage"
    Then I verify "Orders" is sorted by "Created by" in "asc" order on page 'ManagerOrderPage'
    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
#    And I click "ListItem" "End Date" on page "ManagerOrderPage"
#    Then I verify "Orders" is sorted by "End Date" in "asc" order on page 'ManagerOrderPage'
#      Then Verify Start date - By Default - In Ascending order (Earliest at the top)
#      Then I verify End date - In Descending order (Latest at the top)
#      Then I verify User - In Alphabetical order
#      Then I verify Quantity - In Descending order (Highest at the top)
#      Then I verify Department - In Alphabetical order
    Examples:
      | Barcode   | message                                   |
      | 108524922 | Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

#  @sma @demoVerf
#  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC09 To verify that customer order should get wiped off post End date is lapsed or deleted before end date.
#    Given I enter Username and Password for SMA Collegue user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Customer Orders"
#    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I Delete products "oProductDtls" "productName" from the list on page "ManagerOrderPage"
#    Then I verify "Manager orders" not is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    Examples:
#      | Barcode   |OrderDetails |
#      | 108524922 |MIN:113836365|

  @sma @demoVerf
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC09 To verify that customer order should get wiped off post End date is lapsed or deleted before end date.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    Examples:
      | Barcode   | message                                                                                    |                                              OrderDetails                        |
      | 113836365 | Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|MIN:113836365,QTY,DEPT,Created by,Instore Date|

  @sma @SearchByMIN
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC10 To verify that customer reviews created customer order when Search by MIN is available in Review screen.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders" not is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
    Examples:
      | Barcode   | OrderDetails |
      | 108524922 | MIN:113836365|

  @sma @VerfOrdsLiveAndExist
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC11 To verify that customer reviews created customer order when Searched item from Review screen, should club all live orders for searched item under Existing Order label and rest of the orders with All Other Orders label.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I Verify "sObjectName" "Existing Order(s)" on page "ManagerOrderPage"
    And I Verify "sObjectName" "All Other Orders" on page "ManagerOrderPage"
    Then I verify "OrderList" is present on page "ManagerOrderPage"
    Examples:
      | Barcode   | message                                   |
      | 106182332 | Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @ExistAllOrdersVerf
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC12 To verify that customer reviews created customer order when For any existing order prompt , when clicked on review orders button should navigate to review screen with Existing order sorted together and then all other orders.
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
    Then I verify review order sorted with existing order sorted together and then all other orders

    Examples:
      | Barcode   | dateRange |dateRange1  |quantity |message1                                                                                           |OrderDetails                               |ItemDetails                                |
      | 106182332 | 8        |       16   |7        |Existing Order(s)\nAn order for this product already exists for the same in-store date you have selected.|MIN,QTY,DEPT,Created by,Start Date,End Date|Heinz Beanz Jalfrezi 390g,MIN,EAN,Case Size|

  @sma @VerfReviewRestrctDay
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC13 To verify that customer reviews created customer order when Review screen should be available to view for manager & colleague during restricted day of manager orders.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"

    Examples:
      | Barcode   |         OrderDetails      |
      | 113836365 |MIN:113836365,QTY,DEPT,Created by,Instore Date |

  @sma @NoOrderAvlVerf
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC14 To verify that customer reviews created customer order when If no order available to view on review screen to show “No Orders Found”,
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg1" "errorMsg2" "<message>" is displayed on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                   |
      | 108524922 | No Search Results Found\nNo orders matched your search|

  @sma @NonLiveOrdEdit
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC15 To verify  newly created customer order can be edited for start date , end date and qty when order in not live
#    Then I check one step
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    #    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click "Orders" "MIN: 106182332" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I capture the "Instore Date"
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "sLocatorName" "UPDATE ORDER" button on "MOCO.ManagerOrderPage" page
    And I click "oButton" "Confirm" on page "ManagerOrderPage"
#    Then I verify success "<message>" for ionic
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"

    Examples:
      | Barcode   |quantity |dateRange |dateRange1|OrderDetails|message                                   |
      | 106182332 |    1     |  8      |16       |MIN:106182332,QTY:1,DEPT,Created by,Instore Date:runtimedate|Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @MgrOrdeditByEndDate
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC16 To verify newly created customer order can be not edited for start date but edited for end date and qty when order in live
#    Then I check one step
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click "Orders" "MIN: <Barcode>" on page "ManagerOrderPage"
#    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click on 'InstoreDateBtn' on page 'MOCO.ManagerOrderPage'
    And I select a date of date range <dateRange>
    And I capture the "Instore Date"
    And I click "oButton" "DONE" on page "ManagerOrderPage"
    Then I verify "Instore Date" has not been edited as date selected
#    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"

    Examples:
      | Barcode   | dateRange |dateRange1  |OrderDetails|message                                   |
      | 113836365 | 8       |       16     |MIN:113836365,QTY:7,DEPT,Created by,Start Date:runtimedate,End Date:runtimedate|Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @Order_TC17
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC17 To verify  newly created customer order can be Searched item by MIN is available in Review screen.
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    #    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    Then I verify success "<message>" for ionic
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"

    Examples:
      | Barcode   |OrderDetails                                          |                   message                                   |
      | 106182332 |MIN:106182332,QTY,DEPT,Created by,Instore Date |Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|

  @sma @Order_TC18
  Scenario Outline: SMA-54535_[INT] Customer order | Review orders | SMA_TC18 To verify  newly created customer order can be Searched item from Review screen, should club all live orders for searched item under Existing Order label and rest of the orders with All Other Orders label
    Given I enter Username and Password for SMA Collegue user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Customer Orders"
    And I click "sObjectName" "Customer Orders" on page "ManagerOrderPage"
    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
    Then I verify review order sorted with existing order sorted together and then all other orders

    Examples:
      | Barcode   | ItemDetails                                   |
      | 106182332 | MIN:106182332,QTY,DEPT,Created by,Instore Date|

#  @sma @Order_TC19 @ItemNotFound
#  Scenario Outline: SMA-56764-SMA-56904_INT_[DEV-UI]  Manager order | Review orders | SMA | Search Order_TC19 To verify If order NOT found for Item searched by MIN/Barcode/QR Code then message stating No search result matched should be shown with Create Order button to navigate
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify the error message "errorMsg1" "errorMsg2" "<message>" is displayed on page "ManagerOrderPage"
#
#    Examples:
#      | Barcode   | message                 |
#      | 108527922 | Product Not Found\nThe product you entered could not be found. Please try searching again.\n|
#
#  @sma
#  Scenario Outline: SMA-56764-SMA-56904_INT_[DEV-UI]  Manager order | Review orders | SMA | Search Order_TC20 To verify if order NOT found for item searched by PIN/Outer case barcode then a validation message for Invalid Input prompt should be showin
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
##    And I click on 'CreateTab' on page 'ManagerOrderPage'
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
##    Then I check one step
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
#    Then I click "oButton" "OK" on page "ManagerOrderPage"
##    Then I verify If order NOT found for item searched by PIN/Outer case barcode then a validation message for Invalid Input prompt should be showin
#    Examples:
#      | Barcode   | message             |
#      | 108524922 | Invalid Input\nYou cannot create an order using outer case barcode. Please use either:\nProduct Barcode\nShelf Edge Label\nMIN\n|
#
#  @sma
#  Scenario Outline: SMA-56764-SMA-56904_INT_[DEV-UI]  Manager order | Review orders | SMA | Search Order_TC21 To verify If order NOT found for Item searched by MIN/Barcode/QR Code AND item is delisted/deranged/restricted/inactive then message stating No search result matched should be shown with Create Order button to navigate.
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
##    And I click on 'CreateTab' on page 'ManagerOrderPage'
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
##    Then I check one step
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify the error message "errorMsg1" "errorMsg2" "<message>" is displayed on page "ManagerOrderPage"
#    Then I click "oButton" "OK" on page "ManagerOrderPage"
##    Then I verify If order NOT found for Item searched by MIN/Barcode/QR Code AND item is delisted/deranged/restricted/inactive then message stating No search result matched should be shown with Create Order button to navigate.
#    Examples:
#      | Barcode   | message                 |
#      | 108524922 | Product Not Found\nThe product you entered could not be found. Please try searching again.\n|
#
#  @sma @HowToDo?
#  Scenario Outline: SMA-56764-SMA-56904_INT_[DEV-UI]  Manager order | Review orders | SMA | Search Order_TC22 To verify If order has been created as per rule set e.g.Start date is after 28 days.Meanwhile item got delisted/Inactive/Dept restricted/ Item got restricted or any config change. And user search this item then it should be shown under label of “Existing orders”
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
##    And I click on 'CreateTab' on page 'ManagerOrderPage'
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
##    Then I check one step
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
#    Then I click "oButton" "OK" on page "ManagerOrderPage"
#    Examples:
#      | Barcode   | message        |
#      | 108524922 | Existing orders|
#
#  @sma @NoOrderFoundRevScr
#  Scenario Outline: SMA-56764-SMA-56904_INT_[DEV-UI]  Manager order | Review orders | SMA | Search Order_TC23 To verify If no order available to view on review screen then it should show “No Orders Found” as mentioned
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
##    And I click on 'CreateTab' on page 'ManagerOrderPage'
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
##    Then I check one step
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
##    Then I click "oButton" "OK" on page "ManagerOrderPage"
#
#    Examples:
#      | Barcode   | message        |
#      | 108524922 | No Orders Found|
#
#  @sma @StartDateEditNonLv
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders | Amend Orders | SMA | Search Order_TC24 To verify user is allowed to edit start date for Non Live Orders as per configuration around start date.
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click "Orders" "MIN: <Barcode>" on page "ManagerOrderPage"
##    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
##    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
##    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange>
#    And I capture the "Start Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange1>
#    And I capture the "End Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    Then I verify "Start Date" has been edited as date selected
#
#    Examples:
#      | Barcode   | dateRange |dateRange1   |message        |
#      | 106182332 |    8       |    16      |No Orders Found|
#
#  @sma
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders  | Amend Orders |SMA | Search Order_TC25 To verify when user is clicked on update order after amend, prompt is shown while updating order
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    #    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
##    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
##    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click "Orders" "MIN: 106182332" on page "ManagerOrderPage"
#    Then I Enter the quantity as "<quantity1>", "QuantityEdt" and click on "sLocatorName" "UPDATE ORDER" button on "MOCO.ManagerOrderPage" page
#    And I click "oButton" "Confirm" on page "ManagerOrderPage"
#    Then I verify success "<message>" for ionic
#    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    #    Then I click on Back Button till we get to the "Stock Management Applications" page
##    And I logout of the system
#    Examples:
#      | Barcode   | message                           |OrderDetails                                           |ItemDetails                                      |
#      | 106182332 | Manager order updated successfully|MIN:106182332,QTY:1,DEPT,Created by,Start Date,End Date|Ariel Original 10 Washes 650g,MIN,EAN,Case Size|
#
#  @sma @startdateVerf
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders  | Amend Orders | SMA | Search Order_TC26 To verify user is not allowed to edit start date for live orders where start date is past or equal to current date
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click "Orders" "MIN: <Barcode>" on page "ManagerOrderPage"
##    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
##    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
##    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange>
#    And I capture the "Start Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange1>
#    And I capture the "End Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    Then I verify "Start Date" has not been edited as date selected
#    Examples:
#      | Barcode   | dateRange |dateRange1|message        |
#      | 113836365 |   8        |    16      |No Orders Found|
#
#  @sma @enddateVerf
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders | Amend Orders | SMA | Search Order_TC27 To verify user is allowed to edit only end date for live orders and it is greater then current date and it is working as per min end date , max end date configuration
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click "Orders" "MIN: <Barcode>" on page "ManagerOrderPage"
##    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
##    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
##    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange>
#    And I capture the "Start Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange1>
#    And I capture the "End Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    Then I verify "End Date" has been edited as date selected
#    Examples:
#      | Barcode   | dateRange |dateRange1|message        |
#      | 113836365 |    8       |  16        |No Orders Found|
#
#  @sma
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders | Amend Orders | SMA | Search Order_TC28 To verify user is allowed to change quantity in amend for all live and non live orders and prompt is shown while updating orders
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    #    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
##    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
##    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click "Orders" "MIN: <Barcode>" on page "ManagerOrderPage"
#    Then I Enter the quantity as "<quantity1>", "QuantityEdt" and click on "sLocatorName" "UPDATE ORDER" button on "MOCO.ManagerOrderPage" page
#    And I click "oButton" "Confirm" on page "ManagerOrderPage"
##    Then I verify success "<message>" for ionic
#    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    Examples:
#      | Barcode   | message        |quantity1  |message                           |OrderDetails                                         |ItemDetails|
#      | 106182332 | No Orders Found|1          |Manager order updated successfully|MIN:106182332,QTY:1,DEPT,Created by,Start Date,End Date|Ariel Original 10 Washes 650g,MIN,EAN,Case Size|
#
#  @sma
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders | Amend Orders | SMA | Search Order_TC29 To verify when user edit order and its overlapping with existing order start date or end date and existing order popup validation is shown while updating orders
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange>
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange1>
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
#    Then I verify the error message "errorMsg" "errorMsg1" "<message1>" is displayed on page "ManagerOrderPage"
#    And I Verify "oButton" "Cancel" on page "ManagerOrderPage"
#    And I Verify "oButton" "Review Order(s)" on page "ManagerOrderPage"
#    And I click "oButton" "Review Order(s)" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    Then I verify "Manager orders history" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    And I click on 'BackBtn' on page 'MOCO.ManagerOrderPage'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
#    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
#    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
#    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
#    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange>
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange1>
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    Then I Enter the quantity as "<quantity>", "QuantityEdt" and click on "CREATE_ORDER" button on "MOCO.ManagerOrderPage" page
#    Then I verify the error message "errorMsg" "errorMsg1" "<message1>" is displayed on page "ManagerOrderPage"
#    And I Verify "oButton" "Cancel" on page "ManagerOrderPage"
#    And I Verify "oButton" "Review Order(s)" on page "ManagerOrderPage"
#    And I click "oButton" "Cancel" on page "ManagerOrderPage"
#    Examples:
#      | Barcode   | message       |dateRange |dateRange1  |quantity |message1                                                                                           |OrderDetails                               |ItemDetails                                |
#      | 108524922 | existing order|8        |       16   |7        |Existing Order(s)\nA live order for this product already exists within the date range you have selected.\n|MIN,QTY,DEPT,Created by,Start Date,End Date|Heinz Beanz Jalfrezi 390g,MIN,EAN,Case Size|
#
#  @sma
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders | Amend Orders | SMA | Search Order_TC30 To verify when user edit order for live and non live orders and clicks on confirm option of prompt message shown while updating orders
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
#    And I click "Orders" "MIN: <Barcode>" on page "ManagerOrderPage"
##    Then I verify "valid item details" is available to view for "Orders" for "<ItemDetails>" on "ManagerOrderPage"
##    And I Verify "sObjectName" "Start Date" on page "ManagerOrderPage"
##    And I Verify "sObjectName" "End Date" on page "ManagerOrderPage"
#    And I click on 'startDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange>
#    And I capture the "Start Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    And I click on 'EndDateBtn' on page 'MOCO.ManagerOrderPage'
#    And I select a date of date range <dateRange1>
#    And I capture the "End Date"
#    And I click "oButton" "DONE" on page "ManagerOrderPage"
#    Then I Enter the quantity as "<quantity1>", "QuantityEdt" and click on "sLocatorName" "UPDATE ORDER" button on "MOCO.ManagerOrderPage" page
#    And I click "oButton" "Confirm" on page "ManagerOrderPage"
#    Then I verify success "<message>" for ionic
#    Then I verify "Manager orders" is available to view for "Orders" for "<OrderDetails>" on "ManagerOrderPage"
#    Examples:
#      | Barcode   | message      |dateRange |dateRange1 |quantity1  |message                           |OrderDetails                                         |ItemDetails|
#      | 106182332 | existing order|8        |   16      |1          |Manager order updated successfully|MIN:106182332,QTY:1,DEPT,Created by,Start Date:runtimedate,End Date:runtimedate|Ariel Original 10 Washes 650g,MIN,EAN,Case Size|
#
#  @sma
#  Scenario Outline: SMA-56764-SMA-56904_SMA-57079_INT_[DEV-UI]  Manager order | Review orders | Amend Orders | SMA | Search Order_TC31 To verify after amend when updated details are shown in review orders page, sorting is as per default sorting or selected sorting parameter.
#    Given I enter Username and Password for SMA Manager user
#    When I click on login button for SMA
#    And I click on 'stockMngmtText' on page 'HomePagePO_New'
#    And I scroll down to "Manager Orders"
#    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
#    And I click "sTabName" "REVIEW" on page "ManagerOrderPage"
##    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
##    And I click "ListItem" "End Date" on page "ManagerOrderPage"
###    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
###    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
##    Then I verify "Orders" is sorted by "End Date" in "desc" order on page 'ManagerOrderPage'
#    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
#    And I click "ListItem" "Start Date" on page "ManagerOrderPage"
#    Then I verify "Orders" is sorted by "Start Date" in "asc" order on page 'ManagerOrderPage'
#    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
#    And I click "ListItem" "Quantity" on page "ManagerOrderPage"
#    Then I verify "Orders" is sorted by "QTY" in "desc" order on page 'ManagerOrderPage'
#    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
#    And I click "ListItem" "User" on page "ManagerOrderPage"
#    Then I verify "Orders" is sorted by "Created by" in "asc" order on page 'ManagerOrderPage'
#    And I click on 'SortByDropDwn' on page 'MOCO.ManagerOrderPage'
#    And I click "ListItem" "End Date" on page "ManagerOrderPage"
#    Then I verify "Orders" is sorted by "End Date" in "asc" order on page 'ManagerOrderPage'
##      Then Verify Start date - By Default - In Ascending order (Earliest at the top)
##      Then I verify End date - In Descending order (Latest at the top)
##      Then I verify User - In Alphabetical order
##      Then I verify Quantity - In Descending order (Highest at the top)
##      Then I verify Department - In Alphabetical order
#    Examples:
#      | Barcode   | message                                   |
#      | 108524922 | Manager Order is currently Unavailable \n You can view the existing order but are not able to place new orders at this time.|
