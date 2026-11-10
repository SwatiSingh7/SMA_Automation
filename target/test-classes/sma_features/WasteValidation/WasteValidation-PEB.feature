@waste_validation_PEB
Feature: Verify Waste Validation - PEB Module

  @timeChange @WV_Before1130_1030
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 10    | 30   | am       |


  @sma @WV_Before1130_Action_Waste
  Scenario Outline: Record Action Waste Before 11:30 AM
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Action Waste" on Stock Adjustment Page
    And I click on "Waste - Damaged" on Action Waste Page
    ## Scan Sellable KG MIN:
    And I search for "108539622"
    Then I should get a pop up title saying "Weighted Product"
    Then I should get a Message saying "<message1>" and should be able to click the "Yes" Button
    And I enter the price "1.06" and I click on confirm button
    Then I should get a pop up title saying "Confirm Price"
    Then I should get a Message saying "<message2>" and should be able to click the "CONTINUE" Button
    ## Scan Sellable KG PEB:
    And I search for "0215730045070"
    And I verify item selling price "45.07" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I click on Confirm button
    ## Scan Sellable EA:
    And I search for "0299000000000"
    And I enter the desired quantity "3" and confirm the same
    ## Scan Non-Sellable KG MIN:
    And I search for "104935695"
    Then I should get a pop up title saying "Weighted Product"
    Then I should get a Message saying "<message1>" and should be able to click the "Yes" Button
    And I verify item selling price "N/A" is auto-populated
    And I click on Confirm button
     ## Scan Non-Sellable KG PEB:
    And I search for "0201940056000"
    And I verify item selling price "N/A" is auto-populated
    And I click on Confirm button
     ## Scan Non-Sellable EA:
    And I search for "108684782"
    And I enter the desired quantity "8" and confirm the same
     ## Scan PIN of pack quantity 3:
    And I search for "105575628"
    And I enter the desired quantity "3" and confirm the same
    And click on the List View
    And I confirm the Submit List
    Then I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    Then I should get a Message saying "<message3>" and should be able to click the "Done" Button

    Examples:
      | message1                                                                                                   | message2                                                                                                        | message3                                                     |
      | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue? | Please confirm the price £1.06 you have entered is correct.\n\nCatch weight items can not be edited once added. | All items were submitted successfully. Tap on Done to leave. |


  @timeChange @WV_After1130
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 11    | 30   | am       |


  @sma @WV_After1130_PEBScenarios_CreateTrays
  Scenario: Verify PEB scenarios by creating the trays
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I create "5" trays


  @sma @WV_After1130_PEBScenarios_ScanSellableKG
  Scenario Outline: Verify PEB scenarios with Sellable KG MIN items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "1"
    And I search for "<minID>"
    Then I should get a pop up title saying "Weighted Product"
    Then I should get a Message saying "<message1>" and should be able to click the "Yes" Button
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Price Embedded Barcode" and message "<message2>"
    And I enter the price "<price>" and I click on confirm button
    Then I should get a pop up title saying "Confirm Price"
    Then I should get a Message saying "<message3>" and should be able to click the "CONTINUE" Button
    And click on the List View
    Then I verify Product description, Product MIN
    | <prodName> |
    | <prodQty> |
    | <minID> |
    And I verify the item is disabled

    Examples:
      | prodName                                 | prodQty | minID     | price | message1                                                                                                   | message2                                                                                                                                                                     | message3                                                                                                        |
      | PREPARED IN STORE WELSH LAMB SHANK £2.50 | 1       | 102797305 | 2.50  | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue? | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease input the original Item selling price of the product. | Please confirm the price £2.50 you have entered is correct.\n\nCatch weight items can not be edited once added. |
      | MORRISONS LOOSE BRUSSELS SPROUTS £1.06   | 1       | 108539622 | 1.06  | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue? | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease input the original Item selling price of the product. | Please confirm the price £1.06 you have entered is correct.\n\nCatch weight items can not be edited once added. |
    ##| BEEF TOMATOES KG £2.88                | 1      | 103989000| 2.88  | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?| You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease input the original Item selling price of the product.| Please confirm the price £2.88 you have entered is correct.\n\nCatch weight items can not be edited or removed once added.|

  @sma @WV_After1130_PEBScenarios_ScanSellableKG
  Scenario Outline: Verify PEB scenarios with Sellable KG EAN items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "1"
    And I search for "<EAN>"
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Price Embedded Barcode" and message "<message1>"
    And I verify item selling price "<autoPrice>" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I verify the "CONFIRM" button is "Disable"

    Examples:
      | EAN          | autoPrice  | message1                                                                                                                                                      |
      | 0201090000000| 0.00       | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease press confirm to validate this product.|
      ##| 0215730000000| 0.00       | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease press confirm to validate this product.|


  @sma @WV_After1130_PEBScenarios_ScanSellableKG
  Scenario Outline: Verify PEB scenarios with Sellable KG PEB items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "1"
    And I search for "<PEB>"
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Price Embedded Barcode" and message "<message1>"
    And I verify item selling price "<autoPrice>" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I click on Confirm button
    And click on the List View
    Then I verify Product description, Product MIN
      | <prodName> |
      | <prodQty> |
      | <minID> |
    And I verify the item is disabled

    Examples:
      | prodName                           | prodQty | minID     | PEB          | autoPrice| message1                                                                                                                                                      |
      ##| SCOTCH RIB EYE STEAK LOOSE £98.66  | 1       | 102796071 |0206170098660 | 98.66    | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease press confirm to validate this product.|
      | WELSH RIB OF BEEF/B.LESS LS £45.07 | 1       | 102796353 |0215730045070 | 45.07    | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease press confirm to validate this product.|


  @sma @WV_After1130_PEBScenarios_ScanSameSellableKG
  Scenario Outline: Verify PEB scenarios with Sellable KG items when same items are scanned
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "1"
    And I search for "<PEB>"
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Price Embedded Barcode" and message "<message1>"
    And I verify item selling price "<autoPrice>" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I click on Confirm button
    And click on the List View
    Then I verify Product description, Product MIN
      | <prodName> |
      | <prodQty> |
      | <minID> |
    And I verify the item is disabled

    Examples:
      | prodName                                 | prodQty | minID     | PEB           | autoPrice | message1                                                                                                                                                       |
      | PREPARED IN STORE WELSH LAMB SHANK £2.50 | 2       | 102797305 | 0291480002500 | 2.50      | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease press confirm to validate this product.|


  @sma @WV_After1130_PEBScenarios_ScanSameSellableKG
  Scenario Outline: Verify PEB scenarios with Sellable KG MIN items when same items are scanned with different prices
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "1"
    And I search for "<minID>"
    Then I should get a pop up title saying "Weighted Product"
    Then I should get a Message saying "<message1>" and should be able to click the "Yes" Button
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Price Embedded Barcode" and message "<message2>"
    And I enter the price "<price>" and I click on confirm button
    Then I should get a pop up title saying "Confirm Price"
    Then I should get a Message saying "<message3>" and should be able to click the "CONTINUE" Button
    And click on the List View
    Then I verify Product description, Product MIN
      | <prodName> |
      | <prodQty> |
      | <minID> |
    And I verify the item is disabled

    Examples:
      | prodName                               | prodQty | minID     | price | message1                                                                                                   | message2                                                                                                                                                                     | message3                                                                                                        |
      ##| SCOTCH RIB EYE STEAK LOOSE £98.66     | 2      | 102796071| 98.66 | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?| You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease input the original Item selling price of the product.| Please confirm the price £98.66 you have entered is correct.\n\nCatch weight items can not be edited or removed once added. |
      | MORRISONS LOOSE BRUSSELS SPROUTS £3.90 | 1       | 108539622 | 3.90  | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue? | You have scanned a product with price embedded barcode. Catch weight items should be validated individually.\n\nPlease input the original Item selling price of the product. | Please confirm the price £3.90 you have entered is correct.\n\nCatch weight items can not be edited once added. |


  @sma @WV_After1130_PEBScenarios_ScanSellableEA
  Scenario Outline: Verify PEB scenarios with Sellable EA items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "2"
    And I search for "<item>"
    And I verify fields displayed on screen for EA items
    And I enter the desired quantity "<quantity>" and confirm the same

    Examples:
      | item          | quantity |
      ##| 104786028     | 6        |
      ##| 0241170000000 | 4        |
      | 0299000000000 | 2        |
      ##| 102800691     | 1        |
      | 102800877     | 3        |


  @sma @WV_After1130_PEBScenarios_ScanSameSellableEA
  Scenario Outline: Verify PEB scenarios with Sellable EA items when same items are scanned
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "2"
    And I search for "<item>"
    And I verify "ADD TO COUNT" and "EDIT COUNT" buttons displayed on screen
    And I click on Edit Button
    And I enter the desired quantity "<quantity>" and confirm the same

    Examples:
      | item          | quantity |
      ##| 2324454000000 | 5        |
      ##| 102813088     | 3        |
      | 103043142     | 1        |
      ##| 0281560000450 | 2        |
      | 0208720000000 | 4        |


  @sma @WV_After1130_PEBScenarios_SellableEAViewList
  Scenario Outline: Verify PEB scenarios with Sellable EA items in View List
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "2"
    And click on the List View
    Then I verify Product description, Product MIN
      | PIG HEART     PREPACKED |
      | 4                       |
      | 102800877               |
##    Then I verify Product description, Product MIN
##      | THE REAL LANCASHIRE OX TRIPE |
##      | 2                            |
##      | 102800691                    |
    Then I verify Product description, Product MIN
      | 'M'FRESH YEAST 126G |
      | 1                   |
      | 103043142           |
##    Then I verify Product description, Product MIN
##      | TRAY BAKE & HOT DRINK (549 ONLY) |
##      | 3                                |
##      | 102813088                        |
##    Then I verify Product description, Product MIN
##      | M Bramley Apple & Mincemeat Crumble Tarts 2 x110g |
##      | 5                                                 |
##      | 104786028                                         |
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button

    Examples:
      | message1                                                                                                                                                             |
      | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone.|


  @sma @WV_After1130_PEBScenarios_ScanNonSellableKG
  Scenario Outline: Verify PEB scenarios with Non-Sellable KG MIN items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "3"
    And I search for "<minID>"
    Then I should get a pop up title saying "Weighted Product"
    Then I should get a Message saying "<message1>" and should be able to click the "Yes" Button
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Non-sellable Product" and message "<message2>"
    And I verify item selling price "N/A" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I click on Confirm button
    And click on the List View
    Then I verify Product description, Product MIN
      | <prodName> |
      | <prodQty> |
      | <minID> |
    And I verify the item is disabled

    Examples:
      | prodName                      | prodQty| minID    | message1                                                                                                  | message2                                                                                                                                                                              |
      | (B) HADDOCK LOIN              | 1      | 104935695| To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?| You have scanned a non-sellable product. You will not be able to enter a price as there is no item selling price associated with it.\n\nPlease press confirm to validate this product.|
      ##| (B) MORRISONS OR CONTI HAM 3KG| 1      | 107470221| To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?| You have scanned a non-sellable product. You will not be able to enter a price as there is no item selling price associated with it.\n\nPlease press confirm to validate this product.|


  @sma @WV_After1130_PEBScenarios_ScanNonSellableKG
  Scenario Outline: Verify PEB scenarios with Non-Sellable KG EAN/PEB items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "3"
    And I search for "<item>"
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Non-sellable Product" and message "<message1>"
    And I verify item selling price "N/A" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I click on Confirm button
    And click on the List View
    Then I verify Product description, Product MIN
      | <prodName> |
      | <prodQty> |
      | <minID> |
    And I verify the item is disabled

    Examples:
      | prodName                            | prodQty| minID    | item         | message1                                                                                                                                                                              |
      ##|MORRISONS SWEET & SMOKY HAM (EXPRESS)| 1      | 111189555| 0201950000000| You have scanned a non-sellable product. You will not be able to enter a price as there is no item selling price associated with it.\n\nPlease press confirm to validate this product.|
      |MORRISONS SWEET & SMOKY HAM (COUNTER)| 1      | 111189539| 0201940056000| You have scanned a non-sellable product. You will not be able to enter a price as there is no item selling price associated with it.\n\nPlease press confirm to validate this product.|


  @sma @WV_After1130_PEBScenarios_ScanSameNonSellableKG
  Scenario Outline: Verify PEB scenarios with Non-Sellable KG items when same items are scanned
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "3"
    And I search for "<minID>"
    Then I should get a pop up title saying "Weighted Product"
    Then I should get a Message saying "<message1>" and should be able to click the "Yes" Button
    And I verify fields displayed on screen for KG items
    And verify screen message with title "Non-sellable Product" and message "<message2>"
    And I verify item selling price "N/A" is auto-populated
    And I verify the auto-populated item selling price is disabled
    And I click on Confirm button
    And click on the List View
    Then I verify Product description, Product MIN
      | <prodName> |
      | <prodQty> |
      | <minID> |
    And I verify the item is disabled

    Examples:
      | prodName                            | prodQty| minID     | message1                                                                                                  | message2                                                                                                                                                                             |
      |MORRISONS SWEET & SMOKY HAM (COUNTER)| 1      | 111189539| To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?| You have scanned a non-sellable product. You will not be able to enter a price as there is no item selling price associated with it.\n\nPlease press confirm to validate this product.|
      ##|MORRISONS SWEET & SMOKY HAM (EXPRESS)| 1      | 111189555| To accurately adjust this product, you should scan the price embedded barcode, would you like to continue?| You have scanned a non-sellable product. You will not be able to enter a price as there is no item selling price associated with it.\n\nPlease press confirm to validate this product.|


  @sma @WV_After1130_PEBScenarios_ScanNonSellableEA
  Scenario Outline: Verify PEB scenarios with Non-Sellable EA items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "4"
    And I search for "<item>"
    And I verify fields displayed on screen for EA items
    And I enter the desired quantity "<quantity>" and confirm the same

    Examples:
      | item          | quantity |
      ##| 105717219     | 6        |
      | 108684782     | 3        |


  @sma @WV_After1130_PEBScenarios_ScanSameNonSellableEA
  Scenario Outline: Verify PEB scenarios with Non-Sellable EA items when scanned same items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "4"
    And I search for "<item>"
    And I verify "ADD TO COUNT" and "EDIT COUNT" buttons displayed on screen
    And I click on Add to Count Button
    And I enter the desired quantity "<quantity>" and confirm the same

    Examples:
      | item          | quantity |
      ##| 105717219     | 1        |
      | 108684782     | 5        |


  @sma @WV_After1130_PEBScenarios_NonSellableEAViewList
  Scenario Outline: Verify PEB scenarios with Non-Sellable EA items in View List
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "4"
    And click on the List View
    Then I verify Product description, Product MIN
      | (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
      | 8                                         |
      | 108684782                                 |
##    Then I verify Product description, Product MIN
##      | (B) M Raspberry White Chocolate Fresh Topped Cake NCO |
##      | 7                                                     |
##      | 105717219                                             |
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button

    Examples:
      | message1                                                                                                                                                             |
      | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone.|


  @sma @WV_After1130_PEBScenarios_ScanPIN
  Scenario Outline: Verify PEB scenarios with PIN items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "5"
    And I search for "<PIN>"
    And I verify fields displayed on screen for EA items
    And I enter the desired quantity "<quantity>" and confirm the same

    Examples:
      | PIN           | quantity |
      ##| 104196052     | 6        |
      ##| 102459867     | 3        |
      ##| 110047379     | 6        |
      ##| 105710033     | 3        |
      | 105575628     | 6        |
      ##| 109589146     | 3        |
      ##| 108684803     | 6        |


  @sma @WV_After1130_PEBScenarios_ScanSamePIN
  Scenario Outline: Verify PEB scenarios with same PIN items
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "5"
    And I search for "<PIN>"
    And I verify "ADD TO COUNT" and "EDIT COUNT" buttons displayed on screen
    And I click on Edit Button
    And I enter the desired quantity "<quantity>" and confirm the same

    Examples:
      | PIN                | quantity |
      ##| 05010228500669     | 2        |
      ##| 05060107332164     | 4        |
      ##| 05000144619606     | 8        |
      ##| 05000144183428     | 1        |
      | 05060133370413     | 3        |
      ##| 05000144559322     | 5        |
      ##| 05000144446677     | 7        |


  @sma @WV_After1130_PEBScenarios_PINViewList
  Scenario Outline: Verify PEB scenarios with PIN items in View List
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "5"
    And click on the List View
##    Then I verify PIN description, PIN MIN
##      | [6 x] (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
##      | 7                                               |
##      | 108684803                                       |
##    Then I verify PIN description, PIN MIN
##      | [3 x] MORRISONS EASTER CUPCAKE PLATTER 12S |
##      | 5                                          |
##      | 109589146                                  |
    Then I verify PIN description, PIN MIN
      | [3 x] AQUEOUS CREAM 500G |
      | 3                        |
      | 105575628                |
##    Then I verify PIN description, PIN MIN
##      | [48 x] Chocolate Iced Ring Doughnut |
##      | 1                                   |
##      | 105710033                           |
##    Then I verify PIN description, PIN MIN
##      | [5KG] MORRISONS SPROUTS 5KG (SKIPTON) |
##      | 8                                     |
##      | 110047379                             |
##    Then I verify PIN description, PIN MIN
##      | [6 x] Vegetable Bake 130g stage two |
##      | 4                                   |
##      | 102459867                           |
##    Then I verify PIN description, PIN MIN
##      | [12 x] McCain Micro Pizzetta Chse&Tom |
##      | 2                                     |
##      | 104196052                             |
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button

    Examples:
      | message1                                                                                                                                                             |
      | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone.|


  @sma @WV_After1130_PEBScenarios_Review
  Scenario Outline: Verify PEB scenarios on Review Screen
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    And I click on "Stock Adjustments" on Home Page
    And I click on "Waste Validation" on Stock Adjustment Page
    And I click on "Validation Checks" on Waste Validation Page
    And I select tray "1"
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button
    And I select tray "3"
    And click on the List View
    And I complete the tray
    Then I should get a Message saying "<message1>" and should be able to click the "Continue" Button
    And I click on Complete Check button
    And I click on Complete & Review button on Complete Check screen
    And I verify the date on Review page
    And I verify Review screen message
    And I verify the headers of review option
##  And I click on "All" tab and verify the following details
##    | [5KG] MORRISONS SPROUTS 5KG (SKIPTON) |
##    | FAIL                                  |
##    | 110047379                             |
##    | 0                                     |
##    | 8                                     |
##    | 8                                     |
##  And I click on "All" tab and verify the following details
##    | [6 x] (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
##    | FAIL                                            |
##    | 108684803                                       |
##    | 0                                               |
##    | 7                                               |
##    | 7                                               |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | M Bramley Apple & Mincemeat Crumble Tarts 2 x110g |
##    | FAIL                                              |
##    | 104786028                                         |
##    | 0                                                 |
##    | 5                                                 |
##    | 5                                                 |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | [3 x] MORRISONS EASTER CUPCAKE PLATTER 12S |
##    | FAIL                                       |
##    | 109589146                                  |
##    | 0                                          |
##    | 5                                          |
##    | 5                                          |
##  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | PIG HEART     PREPACKED |
    | FAIL                    |
    | 102800877               |
    | 0                       |
    | 4                       |
    | 4                       |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | [6 x] Vegetable Bake 130g stage two |
##    | FAIL                                |
##    | 102459867                           |
##    | 0                                   |
##    | 4                                   |
##    | 4                                   |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | TRAY BAKE & HOT DRINK (549 ONLY) |
##    | FAIL                             |
##    | 102813088                        |
##    | 0                                |
##    | 3                                |
##    | 3                                |
##  And I Scroll from 200 800 to 200 250
   And I click on "All" tab and verify the following details
     | PREPARED IN STORE WELSH LAMB SHANK £2.50 |
     | FAIL                                     |
     | 102797305                                |
     | 0                                        |
     | 2                                        |
     | 2                                        |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | SCOTCH RIB EYE STEAK LOOSE £98.66 |
##    | FAIL                              |
##    | 102796071                         |
##    | 0                                 |
##    | 2                                 |
##    | 2                                 |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | THE REAL LANCASHIRE OX TRIPE |
##    | FAIL                         |
##    | 102800691                    |
##    | 0                            |
##    | 2                            |
##    | 2                            |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | [12 x] McCain Micro Pizzetta Chse&Tom |
##    | FAIL                                  |
##    | 104196052                             |
##    | 0                                     |
##    | 2                                     |
##    | 2                                     |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | BEEF TOMATOES KG £2.88 |
##    | FAIL                   |
##    | 103989000              |
##    | 0                      |
##    | 1                      |
##    | 1                      |
##  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | MORRISONS LOOSE BRUSSELS SPROUTS £3.90 |
    | FAIL                                   |
    | 108539622                              |
    | 0                                      |
    | 1                                      |
    | 1                                      |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | (B) MORRISONS OR CONTI HAM 3KG |
##    | FAIL                           |
##    | 107470221                      |
##    | 0                              |
##    | 1                              |
##    | 1                              |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | MORRISONS SWEET & SMOKY HAM (EXPRESS) |
##    | FAIL                                  |
##    | 111189555                             |
##    | 0                                     |
##    | 1                                     |
##    | 1                                     |
  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | MORRISONS SWEET & SMOKY HAM (COUNTER) |
    | FAIL                                  |
    | 111189539                             |
    | 0                                     |
    | 1                                     |
    | 1                                     |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | MORRISONS SWEET & SMOKY HAM (EXPRESS) |
##    | FAIL                                   |
##    | 111189555                              |
##    | 0                                      |
##    | 1                                      |
##    | 1                                      |
##  And I Scroll from 200 800 to 200 250
##  And I click on "All" tab and verify the following details
##    | [48 x] Chocolate Iced Ring Doughnut |
##    | FAIL                                |
##    | 105710033                           |
##    | 0                                   |
##    | 1                                   |
##    | 1                                   |
  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | [3 x] AQUEOUS CREAM 500G |
    | PASS                     |
    | 105575628                |
    | 3                        |
    | 3                        |
    | 0                        |
    And I Scroll from 200 800 to 200 250
    And I click on "All" tab and verify the following details
      | (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
      | PASS                                      |
      | 108684782                                 |
      | 8                                         |
      | 8                                         |
      | 0                                         |
#  And I Scroll from 200 800 to 200 250
#  And I click on "All" tab and verify the following details
#    | (B) M Raspberry White Chocolate Fresh Topped Cake NCO |
#    | FAIL                                                  |
#    | 105717219                                             |
#    | 0                                                     |
#    | 7                                                     |
#    | 7                                                     |
  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | MORRISONS SWEET & SMOKY HAM (COUNTER) |
    | PASS                                  |
    | 111189539                             |
    | 1                                     |
    | 1                                     |
    | 0                                     |
  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | (B) HADDOCK LOIN |
    | PASS             |
    | 104935695        |
    | 1                |
    | 1                |
    | 0                |
  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | 'M'FRESH YEAST 126G |
    | PASS                |
    | 103043142           |
    | 3                   |
    | 1                   |
    | -2                  |
  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | WELSH RIB OF BEEF/B.LESS LS £45.07 |
    | PASS                               |
    | 102796353                          |
    | 1                                  |
    | 1                                  |
    | 0                                  |
  And I Scroll from 200 800 to 200 250
  And I click on "All" tab and verify the following details
    | MORRISONS LOOSE BRUSSELS SPROUTS £1.06 |
    | PASS                                   |
    | 108539622                              |
    | 1                                      |
    | 1                                      |
    | 0                                      |
  And I click on "Pass" tab and verify the following details
    | [3 x] AQUEOUS CREAM 500G |
    | PASS                     |
    | 105575628                |
    | 3                        |
    | 3                        |
    | 0                        |
##  And I click on "Pass" tab and verify the following details
##    | (B) M Raspberry White Chocolate Fresh Topped Cake NCO |
##    | PASS                                                  |
##    | 105717219                                             |
##    | 7                                                     |
##    | 7                                                     |
##    | 0                                                     |
    And I click on "Pass" tab and verify the following details
      | (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
      | PASS                                      |
      | 108684782                                 |
      | 8                                         |
      | 8                                         |
      | 0                                         |
  And I click on "Pass" tab and verify the following details
    | MORRISONS SWEET & SMOKY HAM (COUNTER) |
    | PASS                                  |
    | 111189539                             |
    | 1                                     |
    | 1                                     |
    | 0                                     |
  And I Scroll from 200 800 to 200 250
  And I click on "Pass" tab and verify the following details
    | (B) HADDOCK LOIN |
    | PASS             |
    | 104935695        |
    | 1                |
    | 1                |
    | 0                |
  And I Scroll from 200 800 to 200 250
  And I click on "Pass" tab and verify the following details
    | 'M'FRESH YEAST 126G |
    | PASS                |
    | 103043142           |
    | 3                   |
    | 1                   |
    | -2                  |
  And I Scroll from 200 800 to 200 250
  And I click on "Pass" tab and verify the following details
    | WELSH RIB OF BEEF/B.LESS LS £45.07 |
    | PASS                               |
    | 102796353                          |
    | 1                                  |
    | 1                                  |
    | 0                                  |
  And I Scroll from 200 800 to 200 250
  And I click on "Pass" tab and verify the following details
    | MORRISONS LOOSE BRUSSELS SPROUTS £1.06 |
    | PASS                                   |
    | 108539622                              |
    | 1                                      |
    | 1                                      |
    | 0                                      |
##  And I click on "Fail" tab and verify the following details
##    | [5KG] MORRISONS SPROUTS 5KG (SKIPTON) |
##    | FAIL                                  |
##    | 110047379                             |
##    | 0                                     |
##    | 8                                     |
##    | 8                                     |
##  And I click on "Fail" tab and verify the following details
##    | [6 x] (B) MORRISONS VALENTINES DAY CUPCAKES 2PK |
##    | FAIL                                            |
##    | 108684803                                       |
##    | 0                                               |
##    | 7                                               |
##    | 7                                               |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | M Bramley Apple & Mincemeat Crumble Tarts 2 x110g |
##    | FAIL                                              |
##    | 104786028                                         |
##    | 0                                                 |
##    | 5                                                 |
##    | 5                                                 |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | [3 x] MORRISONS EASTER CUPCAKE PLATTER 12S |
##    | FAIL                                       |
##    | 109589146                                  |
##    | 0                                          |
##    | 5                                          |
##    | 5                                          |
##  And I Scroll from 200 800 to 200 250
  And I click on "Fail" tab and verify the following details
    | PIG HEART     PREPACKED |
    | FAIL                    |
    | 102800877               |
    | 0                       |
    | 4                       |
    | 4                       |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | [6 x] Vegetable Bake 130g stage two |
##    | FAIL                                |
##    | 102459867                           |
##    | 0                                   |
##    | 4                                   |
##    | 4                                   |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | TRAY BAKE & HOT DRINK (549 ONLY) |
##    | FAIL                             |
##    | 102813088                        |
##    | 0                                |
##    | 3                                |
##    | 3                                |
##  And I Scroll from 200 800 to 200 250
  And I click on "Fail" tab and verify the following details
    | PREPARED IN STORE WELSH LAMB SHANK £2.50 |
    | FAIL                                     |
    | 102797305                                |
    | 0                                        |
    | 2                                        |
    | 2                                        |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | SCOTCH RIB EYE STEAK LOOSE £98.66 |
##    | FAIL                              |
##    | 102796071                         |
##    | 0                                 |
##    | 2                                 |
##    | 2                                 |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | THE REAL LANCASHIRE OX TRIPE |
##    | FAIL                         |
##    | 102800691                    |
##    | 0                            |
##    | 2                            |
##    | 2                            |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | [12 x] McCain Micro Pizzetta Chse&Tom |
##    | FAIL                                  |
##    | 104196052                             |
##    | 0                                     |
##    | 2                                     |
##    | 2                                     |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | BEEF TOMATOES KG £2.88 |
##    | FAIL                   |
##    | 103989000              |
##    | 0                      |
##    | 1                      |
##    | 1                      |
##  And I Scroll from 200 800 to 200 250
  And I click on "Fail" tab and verify the following details
    | MORRISONS LOOSE BRUSSELS SPROUTS £3.90 |
    | FAIL                                   |
    | 108539622                              |
    | 0                                      |
    | 1                                      |
    | 1                                      |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | (B) MORRISONS OR CONTI HAM 3KG |
##    | FAIL                           |
##    | 107470221                      |
##    | 0                              |
##    | 1                              |
##    | 1                              |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | MORRISONS SWEET & SMOKY HAM (EXPRESS) |
##    | FAIL                                  |
##    | 111189555                             |
##    | 0                                     |
##    | 1                                     |
##    | 1                                     |
  And I Scroll from 200 800 to 200 250
  And I click on "Fail" tab and verify the following details
    | MORRISONS SWEET & SMOKY HAM (COUNTER) |
    | FAIL                                  |
    | 111189539                             |
    | 0                                     |
    | 1                                     |
    | 1                                     |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | MORRISONS SWEET & SMOKY HAM (EXPRESS) |
##    | FAIL                                   |
##    | 111189555                              |
##    | 0                                      |
##    | 1                                      |
##    | 1                                      |
##  And I Scroll from 200 800 to 200 250
##  And I click on "Fail" tab and verify the following details
##    | [48 x] Chocolate Iced Ring Doughnut |
##    | FAIL                                |
##    | 105710033                           |
##    | 0                                   |
##    | 1                                   |
##    | 1                                   |

  Examples:
      | message1                                                                                                                                                             |
      | The item threshold has not been met for this waste tray.\n\nIf there are no more items left in the bag to validate you may continue.\n\nThis action cannot be undone.|




