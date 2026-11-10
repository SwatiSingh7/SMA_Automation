@Neweasy_store @regression
Feature: Easy store Orange n Green Label

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Then I Change date

    Examples:
      | Hours | Mins | Meridiem |
      | 07    | 00   | am       |

##################################### Marketstreet GLH products ############################################################################

  @sma
  Scenario Outline: Verify that when store collegue scan MarketStreet product  in GLH with Diffrent SOH then Green propmpt should displayed

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed

    Examples:
      | storeID | Barcode   | SOH      | Type                      | Status |
      | 78      | 108158416 | Positive | MarketStreetGapsHighsLows | Stale  |
      #####|      78 | 108244841 | Negative  | MarketStreetGapsHighsLows | Stale|
      | 78      | 108752298 | Zero     | MarketStreetGapsHighsLows | Stale  |
      | 78      | 109589138 | Positive | MarketStreetGapsHighsLows | Fresh  |
      | 78      | 109630399 | Negative | MarketStreetGapsHighsLows | Fresh  |


  @sma
  Scenario Outline: Verify Default behaviour when store collegue scan MarketStreet product in GLH and Mark as LOW and enter quantity
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I enter "<Quantity>"
    Then I click on the Confirm Button
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list

    Examples:
      | storeID | Barcode   | Quantity | SOH | Type                      |
      | 78      | 110006577 | 100      | 0   | MarketStreetGapsHighsLows |



  ################################################ GLH Products ################################################################

  @sma
  Scenario Outline: Verify that when store collegue scan glh product with Positive(+) with status as stale SOH then Green propmpt should displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      | 78      | 100427116 | Grocery (Impulse) | 2        | GapsHighsLows |

  @sma
  Scenario Outline: Verify that when store collegue scan glh product with Negative(-) SOH with status as stale then Green propmpt should displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      | 78      | 110918509 | Grocery (Impulse) | 2        | GapsHighsLows |

  @sma
  Scenario Outline: Verify that when store collegue scan glh product with Zero(0) SOH with status as stale then Green propmpt should displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      | 78      | 106431845 | Grocery (Impulse) | 2        | GapsHighsLows |

  @sma
  Scenario Outline: Verify that when store collegue scan glh product with Positive(+) SOH with status as Fresh then Green propmpt should displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      | 78      | 106938654 | Grocery (Impulse) | 2        | GapsHighsLows |

  @sma
  Scenario Outline: Verify that when store collegue scan glh product with Negative(-) SOH with status as Fresh then Green propmpt should displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And I choose the plan from popup if multiple records present
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      | 78      | 100699074 | Grocery (Impulse) | 2        | GapsHighsLows |


  @sma
  Scenario Outline: Verify that user should be able to scans another product and "Fixture Scan" header should be appear in default format i.e. Green, when user did not clicked on 'OK' button on Green label,
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Green label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      | 78      | 110852482 | Grocery (Impulse) | 2        | GapsHighsLows |


 ################################################# ORANGE LABEL Scenarios ##################################################################################
 ############################### Update in Stock_V2 DB for Non-Integrated Store orange label #update stock_item set updated_on=now() where location_id = '89';

  @sma1
  Scenario Outline: Verify that when store collegue scan MarketStreet product in GLH with Zero(0) SOH then Orange propmpt should displayed

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Orange label prompt is displayed

    Examples:
      | storeID | Barcode   | SOH | Type                      |
      | 78      | 110006577 | 0   | MarketStreetGapsHighsLows |


  @sma
  Scenario Outline: Verify that when store collegue scan glh product with Zero(0) SOH with status as Fresh then Orange propmpt should displayed
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Orange label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
    #######  |      78 | 105621786 | Grocery (Impulse) |        2 | GapsHighsLows |
      | 89      | 100425840 | Grocery (Impulse) | 2        | GapsHighsLows |


  @sma
  Scenario Outline: Verify that user should be able to scans another product and "Fixture Scan" header should be appear in Orange, when user did not clicked on 'OK' button on Orange label
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Orange label prompt is displayed
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on GAP button
    And Verify the popup is displayed with the message
    And I click on OK
    And I will capture the product name from view list
    Then I verify the product MIN value "<Barcode>" from view list
    Then I verify the if it is GAP
    And I verify Orange label prompt is displayed

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      #######|      78 | 100719186 | Grocery (Impulse) |        2 | GapsHighsLows |
      | 89      | 104557305 | Grocery (Impulse) | 2        | GapsHighsLows |


  @sma
  Scenario Outline: Verify that when a Store colleague again scans the GLH product,previously mark as LOW with status as fresh.It should work as default behaviour and should be enter quantity and mark the product as LOW.

    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on the main menu "Stock Management Applications"
    Then I click on "Gaps, Lows, Highs"
    Then I click on Fixture Scan
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on Low button
    And I Enter the Low quantity "<Quantity>"
    And I choose the plan from popup if multiple records present
    Then I verify the if it is LOW

    Examples:
      | storeID | Barcode   | Type              | Quantity | Typee         |
      | 78      | 100719186 | Grocery (Impulse) | 2        | GapsHighsLows |

