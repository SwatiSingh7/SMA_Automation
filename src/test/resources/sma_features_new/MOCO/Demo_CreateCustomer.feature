@CO_Demo
#SMA-56764_[INT] [INT] Manager order | Review orders |
Feature: Automation Demo

@sma @wdemCustmrMinMaxStartDate
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
| Barcode   | dateRange1 |dateRange2|dateRange3|
|           | 3          |28        |29        |

  @sma @demExistAllOrdersVerf
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

  @sma @demCustomerSortOrdrverf
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

  @sma @demNonLiveOrdEdit
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
      | Barcode   |quantity |dateRange |dateRange1|OrderDetails|
      | 106182332 |    7     |  8      |16       |MIN:106182332,QTY:1,DEPT,Created by,Instore Date:runtimedate|

  @sma @demCustmrValidatePIN_Items @InvalidItemDemo
  Scenario Outline: SMA-56772_INT_Create New Manager order_SMA_Scanning_TC04_To verify Store Manager is not allowed to create Manager orders for PIN items or Outer Case Barcodes
    Given I enter Username and Password for SMA Manager user
    When I click on login button for SMA
    And I click on 'stockMngmtText' on page 'HomePagePO_New'
    And I scroll down to "Manager Orders"
    And I click "sObjectName" "Manager Orders" on page "ManagerOrderPage"
    And I click "sTabName" "CREATE" on page "ManagerOrderPage"
#    And I click on 'CreateTab' on page 'ManagerOrderPage'
    And I click on 'BarCodeBtn' on page 'MOCO.ManagerOrderPage'
#    Then I check one step
    Then I Enter "<Barcode>" in the "BarCodeEdit" on page 'ManagerOrderPage' and search
    Then I verify the error message "errorMsg" "errorMsg1" "<message>" is displayed on page "ManagerOrderPage"
    Then I click "oButton" "OK" on page "ManagerOrderPage"

    Examples:
      | Barcode   | message                                                                                    |
      | 111608060 | Invalid Input\nYou cannot create an order using outer case barcode. Please use either:\nProduct Barcode\nShelf Edge Label\nMIN |