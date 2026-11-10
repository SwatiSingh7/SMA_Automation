@dldr @regression
Feature: Verify Delist and Derange functionality.

  #######  Data depdendency on TCS
  ###### Service name = GetRange
  ##### Non-Ranged products = Product is not in Range.
  #### Ranged/Active products = Product is in Range.
  
  ##### Verify Get range api response
  ##### Perform adjustment on an delisted/Deranged item, when adjustment date lies between wastage from and to date with wastage status =Y.
  ##### Not able to perform the adjustment when Non-Ranged or Active item is scanned under "Delisted Waste"/"Delisted Charity" when wastage from and to date with wastage status =Y is in past (scanning is done After the wastage dates)
  ##### Not be able to perform the adjustment when Non-Ranged or Active item is scanned under "Delisted Waste"/"Delisted Charity" when wastage from and to date with wastage status =Y is in Future (scanning is done Before the wastage dates)
  ##### Not be able to perform the adjustment when Non-Ranged or Active item is scanned under "Delisted Waste"/"Delisted Charity" when wastage from and to date with wastage status = N with NO wastage dates.
  ##### Not be able to perform the adjustment when Non-Ranged or Active item is scanned under "Delisted Waste"/"Delisted Charity" when wastage from and to date with wastage status = N with ANY wastage dates.
  ##### Not be able to perform the adjustment when Non-Ranged or Active item is scanned under "Delisted Waste"/"Delisted Charity" when wastage from and to date with wastage status =Y is in past and should receive two sequential prompt message, when item is KG.
  ##### Not be able to perform the adjustment when Non-Ranged or Active item is scanned under "Delisted Waste"/"Delisted Charity" when wastage from and to date with wastage status =Y is in Future and should receive two sequential prompt message, when item is KG.
  ##### To verify when Pin is scanned - blue tag with sign and description should display.
  #
  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time

    Examples: 
      | Hours | Mins | Meridiem |
      |    06 |   48 | am       |

  @sma
  Scenario Outline: Perform adjustment on Non-ranged delisted/deranged item, when adjustment date lies between wastage from and to date with wastage status =Y.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I verify Reason codes are displayed on Other adjustment Page
    And I click on "Back" button
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "<ReasonCode1>" on Other adjustment Page
    And I search for "<DelistedItem>"
    Then I enter the desired quantity "<Quantity>" and confirm the same
    And click on the List View
    Then I confirm the Submit List
    And I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    And I should get a Message saying "<Message>" and should be able to click the "DONE" Button
    And I click on "Back" button
    And I click on "Back" button
    Then I click on "Stock Information" on Home Page
    And I search for "<DelistedItem>"
    Then I verify Range status "<RangeStatus>" is displayed
    Then I Click on "Stock" option on Stock information screen
    And I verify Stock status "<ReasonCode1>" and Adjustment quantity "<StockQuantity>" on Product adjustment history screen
    And I click on "Back" button
    And I click on "Back" button
    And I click on "Back" button
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "<ReasonCode2>" on Other adjustment Page
    And I search for "<DelistedItem>"
    Then I enter the desired quantity "<Quantity>" and confirm the same
    And click on the List View
    Then I confirm the Submit List
    And I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    And I should get a Message saying "<Message>" and should be able to click the "DONE" Button
    And I click on "Back" button
    And I click on "Back" button
    Then I click on "Stock Information" on Home Page
    And I search for "<DelistedItem>"
    Then I Click on "Stock" option on Stock information screen
    And I verify Stock status "<ReasonCode2>" and Adjustment quantity "<StockQuantity>" on Product adjustment history screen

    Examples: 
      | StoreID | ReasonCode1    | ReasonCode2      | DelistedItem | Quantity | ClearanceStatus1 | Message                                                      | WastageStatus | RangeStatus | StockQuantity |
      |     101 | Delisted Waste | Delisted Charity |    109823086 |       10 | delist           | All items were submitted successfully. Tap on Done to leave. | Y             | Delisted    | 10 Single(s)  |
      |       8 | Delisted Waste | Delisted Charity |    110003026 |       10 | derange          | All items were submitted successfully. Tap on Done to leave. | Y             | Deranged    | 10 Single(s)  |

  @sma
  Scenario Outline: Perform adjustment on Ranged/Active delisted/deranged item, when adjustment date lies between wastage from and to date with wastage status =Y.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    When Post request to Login service for "Collegue" user
    And Verify Response code for Login Service
    Then Get JSON response for Login service
    And Post request to Range service for Store id "<StoreID>" and Product id "<DelistedItem>"
    Then Verify Response code for Range Service
    Then Get JSON response for Range service
    And Verify Clearance status is "<ClearanceStatus1>" in GetRange service
    And Verify Wastage status is "<WastageStatus>" in GetRange service
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I verify Reason codes are displayed on Other adjustment Page
    And I click on "Back" button
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "<ReasonCode1>" on Other adjustment Page
    And I search for "<DelistedItem>"
    Then I enter the desired quantity "<Quantity>" and confirm the same
    And click on the List View
    Then I confirm the Submit List
    And I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    And I should get a Message saying "<Message>" and should be able to click the "DONE" Button
    And I click on "Back" button
    And I click on "Back" button
    Then I click on "Stock Information" on Home Page
    And I search for "<DelistedItem>"
    Then I verify Range status "<RangeStatus>" is displayed
    Then I Click on "Stock" option on Stock information screen
    And I verify Stock status "<ReasonCode1>" and Adjustment quantity "<StockQuantity>" on Product adjustment history screen
    And I click on "Back" button
    And I click on "Back" button
    And I click on "Back" button
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "<ReasonCode2>" on Other adjustment Page
    And I search for "<DelistedItem>"
    Then I enter the desired quantity "<Quantity>" and confirm the same
    And click on the List View
    Then I confirm the Submit List
    And I should get a Message saying "Are you sure you want to submit the list?" and should be able to click the "SUBMIT" Button
    And I should get a Message saying "<Message>" and should be able to click the "DONE" Button
    And I click on "Back" button
    And I click on "Back" button
    Then I click on "Stock Information" on Home Page
    And I search for "<DelistedItem>"
    Then I Click on "Stock" option on Stock information screen
    And I verify Stock status "<ReasonCode2>" and Adjustment quantity "<StockQuantity>" on Product adjustment history screen

    Examples: 
      | StoreID | ReasonCode1    | ReasonCode2      | DelistedItem | Quantity | ClearanceStatus1 | Message                                                      | WastageStatus | RangeStatus | StockQuantity |
      |     151 | Delisted Waste | Delisted Charity |    110376674 |       10 | delist           | All items were submitted successfully. Tap on Done to leave. | Y             | Delisted    | 10 Single(s)  |
      |     112 | Delisted Waste | Delisted Charity |    112201481 |       10 | derange          | All items were submitted successfully. Tap on Done to leave. | Y             | Deranged    | 10 Single(s)  |

  @sma
  Scenario Outline: To Verify user should be not be able to perform the adjustment when Non-Ranged delisted/deranged item is scanned under "Delisted Charity/Delisted Waste" when wastage from and to date are in Past or Future dates.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "<ReasonCode1>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName>" alert is displayed
    Then I should get a Message "<DelistedCharityMessage>" and should be able to click the "OK" Button
    And I click on "Back" button
    Then I click on "<ReasonCode2>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName>" alert is displayed

    Examples: 
      | StoreID | DateRange | WastageStatus | ReasonCode1      | ReasonCode2    | ProductMin | PopupName                      |
      |     491 | Past      | Y             | Delisted Charity | Delisted Waste |  105841383 | Product not valid at this time |
      |     479 | Future    | Y             | Delisted Charity | Delisted Waste |  112069272 | Product not valid at this time |
      |     105 | NA        | N             | Delisted Charity | Delisted Waste |  112006167 | Product Not Valid              |

  @sma
  Scenario Outline: To Verify user should be not be able to perform the adjustment when Ranged delisted/deranged item is scanned under "Delisted Charity/Delisted Waste" when wastage from and to date are in Past or Future dates.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    ######Get Range API
    When Post request to Login service for "Collegue" user
    And Verify Response code for Login Service
    Then Get JSON response for Login service
    And Post request to Range service for Store id "<StoreID>" and Product id "<ProductMin>"
    Then Verify Response code for Range Service
    Then Get JSON response for Range service
    Then I click on "<ReasonCode1>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName>" alert is displayed
    Then I should get a Message "<DelistedCharityMessage>" and should be able to click the "OK" Button
    And I click on "Back" button
    Then I click on "<ReasonCode2>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName>" alert is displayed
    Then I should get a Message "<DelistedWasteMessage>" and should be able to click the "OK" Button

    Examples: 
      | StoreID | DateRange | WastageStatus | ReasonCode1      | ReasonCode2    | ProductMin | PopupName                      | DelistedCharityMessage                                                                                                                                                                                                                | DelistedWasteMessage                                                                                                                                                                                                                |
      |     200 | Past      | Y             | Delisted Charity | Delisted Waste |  101563291 | Product not valid at this time | This product can no longer be wasted using a delisted charity reason code. \n\nThis product was due for wastage between wastageFrom and wastageTo.\n\nPlease action this product using the normal 'Damaged' or 'Charity' waste codes. | This product can no longer be wasted using a delisted waste reason code. \n\nThis product was due for wastage between wastageFrom and wastageTo.\n\nPlease action this product using the normal 'Damaged' or 'Charity' waste codes. |
      |       2 | Future    | Y             | Delisted Charity | Delisted Waste |  100442068 | Product not valid at this time | Please action this product under a delisted charity reason code between wastageFrom and wastageTo.                                                                                                                                    | Please action this product under a delisted waste reason code between wastageFrom and wastageTo.                                                                                                                                    |
      |       8 | NA        | NULL          | Delisted Charity | Delisted Waste |  108052911 | Product Not Valid              | This is not a valid product to be actioned through the deranged and delisted process.\n\nPlease scan another item.                                                                                                                    | This is not a valid product to be actioned through the deranged and delisted process.\n\nPlease scan another item.                                                                                                                  |
      |     151 | NULL      | NULL          | Delisted Charity | Delisted Waste |  111124516 | Product Not Valid              | This is not a valid product to be actioned through the deranged and delisted process.\n\nPlease scan another item.                                                                                                                    | This is not a valid product to be actioned through the deranged and delisted process.\n\nPlease scan another item.                                                                                                                  |
      |      11 | N         | NA            | Delisted Charity | Delisted Waste |  100407473 | Product Not Valid              | This is not a valid product to be actioned through the deranged and delisted process.\n\nPlease scan another item.                                                                                                                    | This is not a valid product to be actioned through the deranged and delisted process.\n\nPlease scan another item.                                                                                                                  |

  @sma
  Scenario Outline: Verify two sequential prompt message displayed when "KG" item is scanned under "Delisted Waste"/"Delisted Waste" and wastage dates are in Past or Future and wastage status =Y. On "Weighted Product" popup ,If click on "Yes" then should display dldr prompt and If click on "No" then should not display dldr prompt.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    #####Get Range API
    When Post request to Login service for "Collegue" user
    And Verify Response code for Login Service
    Then Get JSON response for Login service
    And Post request to Range service for Store id "<StoreID>" and Product id "<ProductMin>"
    Then Verify Response code for Range Service
    Then Get JSON response for Range service
    Then I click on "<ReasonCode1>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName1>" alert is displayed
    Then I should get a Message saying "<PopupMessage>" and should be able to click the "YES" Button
    Then Verify "<PopupName2>" alert is displayed
    Then I should get a Message "<popupMessageCharity>" and should be able to click the "OK" Button
    And I click on "Back" button
    Then I click on "<ReasonCode1>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName1>" alert is displayed
    Then I should get a Message saying "<PopupMessage>" and should be able to click the "NO" Button
    Then Verify "<PopupName2>" alert is not displayed
    And I click on "Back" button
    Then I click on "<ReasonCode2>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName1>" alert is displayed
    Then I should get a Message saying "<PopupMessage>" and should be able to click the "YES" Button
    Then Verify "<PopupName2>" alert is displayed
    Then I should get a Message "<popupMessageWaste>" and should be able to click the "OK" Button
    And I click on "Back" button
    Then I click on "<ReasonCode2>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then Verify "<PopupName1>" alert is displayed
    Then I should get a Message saying "<PopupMessage>" and should be able to click the "No" Button
    Then Verify "<PopupName2>" alert is not displayed

    Examples: 
      | StoreID | DateRange | WastageStatus | ProductMin | ReasonCode1      | ReasonCode2    | Quantity | StockStatus      | PopupName1       | PopupName2                     | PopupMessage                                                                                               | popupMessageCharity                                                                                                                                                                                                                   | popupMessageWaste                                                                                                                                                                                                                   |
      |     101 | Future    | Y             |  111216980 | Delisted Charity | Delisted Waste |       10 | Delisted Waste   | Weighted Product | Product not valid at this time | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue? | Please action this product under a delisted charity reason code between wastageFrom and wastageTo.                                                                                                                                    | Please action this product under a delisted waste reason code between wastageFrom and wastageTo.                                                                                                                                    |
      |     101 | Past      | Y             |  111214933 | Delisted Charity | Delisted Waste |       10 | Delisted Charity | Weighted Product | Product not valid at this time | To accurately adjust this product, you should scan the price embedded barcode, would you like to continue? | This product can no longer be wasted using a delisted charity reason code. \n\nThis product was due for wastage between wastageFrom and wastageTo.\n\nPlease action this product using the normal 'Damaged' or 'Charity' waste codes. | This product can no longer be wasted using a delisted waste reason code. \n\nThis product was due for wastage between wastageFrom and wastageTo.\n\nPlease action this product using the normal 'Damaged' or 'Charity' waste codes. |

  @sma
  Scenario Outline: Verify when Pin is scanned - blue tag with sign and description should display.
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Adjustments" on Home Page
    Then I click on "Other Adjustments" on Stock Adjustment Page
    Then I click on "<ReasonCode1>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then I verify Blue tag Icon and Text is displayed
    And I click on "Back" button
    And I click on "Back" button
    Then I click on "<ReasonCode2>" on Other adjustment Page
    And I search for "<ProductMin>"
    Then I verify Blue tag Icon and Text is displayed

    Examples: 
      | StoreID | ProductMin | ReasonCode1      | ReasonCode2    |
      |     101 |  110003034 | Delisted Charity | Delisted Waste |
