@stock_adjustment_MOCO @regression @store_walk
Feature: Verify StockAdjustment Rename Transfer Reason COdes Module

  @sma @StckOrdAdptrTask
  Scenario Outline: Stock Adjustments_Rename Transfer Reason codes_SMA app_TC01: To verify SMA Stock Adjustment global config has been changed for 489 & 490  label changes
    Given I hit the get endpoint to retrieve the "Gloabal config for Stockadjustment reason  url" for the following "<EndPoint>" and "<APIKey>" and "<Param>"
    Then I Verify the Response Code for the following "Gloabal config for Stockadjustment reason  url" is "498"
    And I verify the response fields "<Response>"
    And I get the field value for the field "reason"

    Examples:
      | EndPoint                                                                                | APIKey                           | Response                     |
      | /configuration/v1/domains/stock-service-v2/configurations/stock_adjustment_reason_codes | YTUzx1FDa5NpXCkrsh7qIouafl9Ng9F5 | reason:Transfer to PR sample |

  @sma @StckOrdAdptrTask
  Scenario Outline: Stock Adjustments_Rename Transfer Reason codes_SMA app_TC02:To verify SMA Config has been changed for 489 and 490 label changes
    Given I hit the get endpoint to retrieve the "Gloabal config for Stockadjustment reason  url" for the following "<EndPoint>" and "<APIKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is "498"
    And I verify the response fields "<Response>"
    And I get the field value for the field "reason"

    Examples:
      | EndPoint                                         | APIKey                           | Response                     |
      | /storage/v1/retail-static/config/SMA_Config.json | ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0 | reason:Transfer to PR sample |

  @sma
  Scenario Outline: Stock Adjustments_Rename Transfer Reason codes_SMA app_TC03:To verify the  New label changes displayed for Reason code 489
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>" on Home Page
    And I verify reason code "<adjustmentCode>" on stockAdjustment Page
    And I click on "<adjustmentCode>" on Home Page
    And I verify reason code "<ReasonCodes>" on stockAdjustment Page
    And I click on Adjustmentcode "<ReasonCodes>" on stockAdjustment Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on High button
#    And I enter quantity "<Quantity>" for fixture and warehouse
    And I choose the plan from popup if multiple records present
    And I click on Back Button
    Examples:
      | MenuOptions       | Barcode   | adjustmentCode           | ReasonCodes                  | Quantity |
      | Stock Adjustments | 108394582 | Transfer Stock To A Dept | Transfer to PR sample        | 3        |
      | Stock Adjustments | 108524922 | Transfer Stock To A Dept | Transfer back from PR sample | 9        |
      | Stock Adjustments | 108543859 | Transfer Stock To A Dept | Transfer back from PR sample | 9        |
      | Stock Adjustments | 108368632 | Store To Store Transfer  | sas                          | 9        |

  @sma
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC04, To verify the  New label changes displayed for Reason code 490
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>" on Home Page
    And I verify reason code "<adjustmentCode>" on stockAdjustment Page
    And I click on "<adjustmentCode>" on Home Page
    And I verify reason code "<ReasonCodes>" on stockAdjustment Page
    And I click on Adjustmentcode "<ReasonCodes>" on stockAdjustment Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
#    And I click on High button
#    And I enter quantity "<Quantity>" for fixture and warehouse
    Then I should get a Message saying "<message1>" and should be able to click the "confirm" Button
    Then I verify scuccess "<message>"
    And I click on Back Button
    Examples:
      | MenuOptions       | Barcode   | adjustmentCode           | ReasonCodes                  | Quantity | message1                                        | message                                |
      | Stock Adjustments | 108394582 | Transfer Stock To A Dept | Transfer to PR sample        | 3        | You have entered a quantity of 10 units or more | All items were submitted successfully. |
      | Stock Adjustments | 108524922 | Transfer Stock To A Dept | Transfer back from PR sample | 9        | You have entered a quantity of 10 units or more | All items were submitted successfully. |
      | Stock Adjustments | 108543859 | Transfer Stock To A Dept | Transfer back from PR sample | 11       | You have entered a quantity of 10 units or more | All items were submitted successfully. |
      | Stock Adjustments | 108394582 | Transfer Stock To A Dept | Transfer to PR sample        | 12       | You have entered a quantity of 10 units or more | All items were submitted successfully. |
      | Stock Adjustments | 108368632 | Store To Store Transfer  | sas                          | 9        | You have entered a quantity of 10 units or more | All items were submitted successfully. |

  @sma
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC07 To Verify stock record is refreshed on Stock information screen  when adjustment for reason code 489 is submitted after running stock adjustment producer lambda
    Given The ECS Jobs for Cluster VPC are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>" on Home Page
    And I verify reason code "<adjustmentCode>" on stockAdjustment Page
    And I click on "<adjustmentCode>" on Home Page
    And I verify reason code "<ReasonCodes>" on stockAdjustment Page
    And I click on Adjustmentcode "<ReasonCodes>" on stockAdjustment Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then verify Stock records should be  reduced as per the adjusted qty for reason code 489
    Examples:
      | TaskName                                   | ClusterName                               | LaunchType | LogGroupName                             | LogStreamNamePrefix      | MenuOptions       | Barcode   | adjustmentCode           | ReasonCodes           |
      | opticcounts-ecs-stkordadptr-task-sit-001:2 | ecs-euw1-n-supplychain-vpc001-general-001 | FARGATE    | clg-euw1-sit-opticcounts-stkordadptr-001 | storewalkcountsprocessor | Stock Adjustments | 108394582 | Transfer Stock To A Dept | Transfer to PR sample |

  @sma
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC08 To Verify stock record is refreshed on Stock information screen  when adjustment for reason code 490 is submitted after running stock adjustment producer lambda
    Given The ECS Jobs for Cluster VPC are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>" on Home Page
    And I verify reason code "<adjustmentCode>" on stockAdjustment Page
    And I click on "<adjustmentCode>" on Home Page
    And I verify reason code "<ReasonCodes>" on stockAdjustment Page
    And I click on Adjustmentcode "<ReasonCodes>" on stockAdjustment Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then verify Stock records should be  reduced as per the adjusted qty for reason code 489
    Examples:
      | TaskName                                   | ClusterName                               | LaunchType | LogGroupName                             | LogStreamNamePrefix      | MenuOptions       | Barcode   | adjustmentCode           | ReasonCodes           |
      | opticcounts-ecs-stkordadptr-task-sit-001:2 | ecs-euw1-n-supplychain-vpc001-general-001 | FARGATE    | clg-euw1-sit-opticcounts-stkordadptr-001 | storewalkcountsprocessor | Stock Adjustments | 108394582 | Transfer Stock To A Dept | Transfer to PR sample |
  @sma
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC11 To Verify Data is processed successfuly into SPO after posting  after changing the labels
  for 489
    Given I hit the post endpoint to retrieve the "SPO Endpoint" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param1>" and "<Param2>" and "<Param3>" and "<Param4>" and "<Param5>" and "<Param6>" and Request file "<Request>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                  | APIKey                           | AuthKey           | Param1               | Param2                 | Param3                       | Param4          | Param5        | Param6           | Request                                                   | Response       |
      | stock/v2/adjustments/jobs | 1rQlOAe1PAWaWLHlShKfhhUn8rODH8AK | (Userv1 & Userv2) | reasonCodes[in]=@all | groupbyReasonCode=true | groupbyTransactionType=false | from=2024-04-26 | to=2024-04-27 | location[in]=529 | test-data/json-files/service/MOCO/Request/PatchOrder.json | description:OK |

  @sma @VerfManagerOrderDataNotAvl
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC11 To Verify Data is processed successfuly into SPO after posting  after changing the labels
  for 489
    Given I hit the get endpoint to retrieve the "SPO Endpoint" for the following "<EndPoint>" and "<APIKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                             | APIKey                           | Param               | Response                    |
      | stock/v2/adjustments/jobs/925/status | 1rQlOAe1PAWaWLHlShKfhhUn8rODH8AK | jobType=stockonhand | errorCode:0,errorMessage:10 |

  @sma @VerfManagerOrderDataNotAvl
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC12 To verify SMA lite displays new labels on search item and product adjustment history screen for Code 489 and 490
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    Then I click on Stock record
    Then I verify  Stock records should display new label for reason code 489 & 490 "<Label1>" "<Label2>"
    Examples:
      | Barcode   | Label1                                                                                         | Label2                                                                                                    |
      | 108394582 | 489 - 'Transfer to Market Street Eat Fresh (TRIAL ONLY)' replaced  to 'Transfer to PR sample'. | 490 - /‘Return from Market Street Eat Fresh (TRIAL ONLY)/’ replaced  to /'Transfer back from PR sample/'. |

 @sma @VerfManagerOrderDataNotAvl
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC13 To verify Count schedular app is updated to add Stock adjustment restriction for 3 codes
   When I enter Username and Password for SMA Collegue user
   And I click on login button for SMA
   Then I click on "<MenuOptions>" on Home Page
   And I verify reason code "<adjustmentCode>" on stockAdjustment Page
   And I click on "<adjustmentCode>" on Home Page
   And I verify reason code "<ReasonCodes>" on stockAdjustment Page
   And I click on Adjustmentcode "<ReasonCodes>" on stockAdjustment Page
   And I click on barcode entry Button
   Then Enter "<Barcode>" number
   Then I add an item.
   Then I click on Export button

   Examples:
     | MenuOptions       | Barcode   | adjustmentCode           | ReasonCodes                  | Quantity |
     | Stock Adjustments | 108394582 | Transfer Stock To A Dept | Transfer to PR sample        | 3        |
     | Stock Adjustments | 108524922 | Transfer Stock To A Dept | Transfer back from PR sample | 9        |
     | Stock Adjustments | 108524922 | Transfer Stock To A Dept | Too Good To Go               | 9        |

  @sma
  Scenario Outline: SMA-56678_[INT] Stock Adjustments_Rename Transfer Reason codes_SMA app_TC14 To Veify warning popup is displayed for the item after scanning an item in ‘489 - 'Transfer to PR sample’ , TC15, TC16
  after stock adjustment rule is applied
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "<MenuOptions>" on Home Page
    And I verify reason code "<adjustmentCode>" on stockAdjustment Page
    And I click on "<adjustmentCode>" on Home Page
    And I verify reason code "<ReasonCodes>" on stockAdjustment Page
    And I click on Adjustmentcode "<ReasonCodes>" on stockAdjustment Page
    And I click on barcode entry Button
    Then Enter "<Barcode>" number
    And I click on COUNT button
    And I enter quantity "<Quantity>" for fixture and warehouse
    Then I should get a Message saying "<message1>" and should be able to click the "confirm" Button
    Then I verify scuccess "<message>"
    And I click on Back Button

    Examples:
      | MenuOptions       | Barcode   | adjustmentCode           | ReasonCodes                  | Quantity | message1                                        | message                                |
      | Stock Adjustments | 108394582 | Transfer Stock To A Dept | Transfer to PR sample        | 3        | You have entered a quantity of 10 units or more | All items were submitted successfully. |
      | Stock Adjustments | 108524922 | Transfer Stock To A Dept | Transfer back from PR sample | 9        | You have entered a quantity of 10 units or more | All items were submitted successfully. |
      | Stock Adjustments | 108524922 | Transfer Stock To A Dept | Too Good To Go               | 9        | You have entered a quantity of 10 units or more | All items were submitted successfully. |



