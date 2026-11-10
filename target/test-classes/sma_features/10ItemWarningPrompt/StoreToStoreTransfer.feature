@10Item_StoreToStoreTransfer @regression
Feature: Verify 10 Item Warning Prompt Message.

  @sma
  Scenario Outline: Not Displays any Warning Prompt Message, when quantity is entered at Store.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Store To Store Transfer" on Stock Adjustment Page
    And I Select store"<Store>" to transfer
    Then I select store on Store To Store Transfer page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same

    Examples:
      |Store| minID1     | quantity1 |
      |8    | 103029869  | 9         |
      |8    | 105173039  | 10        |
      |8    | 100746432  | 999        |

  @sma
  Scenario Outline: Not Displays Warning Prompt Message, when quantity entered at Store edited through View List.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Store To Store Transfer" on Stock Adjustment Page
    And I Select store"<Store>" to transfer
    Then I select store on Store To Store Transfer page
    And I search for "<minID1>"
    And I enter the desired quantity "<quantity1>" and confirm the same
    And I click on View list
    Then I select the product from list
    And I enter the desired quantity "<quantity2>" and click on Done Button

    Examples:
      |Store| minID1     | quantity1 |quantity2|
      |8    | 103029869  | 9         |11       |
      |8    | 105173039  | 10        |99       |
      |8    | 100746432  | 999       |1        |
