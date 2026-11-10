@internalAudit


Feature: Verify Internal Audit API functionality and last and next delivery status in AM GLH ,Prompted Counts ,Market Street and Stock Information module.

  Background:
  The following automation scripts will cover the functional scenarios for the Internal Audit functionality.
  Pre-requisites : We need One store for performing Internal Audit regression.

  We need to run the following queries before running the regression scenarios :
  Updating the existing data for Last and Current /Next order status  :

  For last order status:

  update orders
  set final_order_date = current_date - interval '3 DAY',date_availability_expected = current_date - interval '1 DAY',
  date_delivery_expected= current_date - interval '1 DAY'
  where quantity_ordered=10 and ship_to_location_id='78' and item_id in ('107313541','107350668','107350705','109363340','109040727',
  '107329973','112232957','110058756','111175111','112232869','103234301','103111256',
  '111719106','111181684','102392738','102391989','102391591','102391831','109363278','102391866','101545561','102391735','110053373','109415162','107322835');

  For Current and Next order status:
  set final_order_date = current_date - interval '2 DAY',date_availability_expected = current_date,
  date_delivery_expected= current_date
  where quantity_ordered=20 and ship_to_location_id='78' and item_id in ('107313541','107350668','107350705','109363340','109040727',
  '107329973','112232957','110058756','111175111','112232869','103234301','103111256',
  '111719106','111181684','102392738','102391989','107322835','102391591','109363278','102391831','102391866','101545561','102391735','110053373','109415162');

  Only if the above scripts are run the automation scripts would guarantee a proper result.

  @timeChange
  Scenario Outline: TO CHANGE THE DEVICE TIMINGS AS REQUIRED
    Given I send the time "<Hours>" and mins "<Mins>" and meridiem "<Meridiem>" and current date in list
    Then I Change time
    Examples:
      | Hours | Mins | Meridiem |
      | 6     | 45   | am       |

  @sma
  Scenario Outline: I verify item order status for 0ne or multiple item and verify order status in Stock Information,MarketStreet and GLH modules.
    When I get the item order status response through API for following <itemCount>"<Item>"
    Then I create expected result from "<jsonFile>"
    Then I compare expected response with actual response

    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Stock Information" on Home Page
    And I search for items "<Item>" and verify that Delivery status is same on UI and Service

    Then I click on "Market Street" on Home Page
    Then I Scroll down on Market Street page
    Then I click on "Gaps, Lows, Highs" on Market Street Page
    Then I click on "Counter & Fixture" on Market Street GLH page
    And I search for items "<scanItem>" and verify that Last Delivery status is same on service and Market Street UI

    Then I click on "Gaps, Lows, Highs" on Home Page
    Then I Scroll down on Gaps, Lows, Highs page
    Then I click on "AM Gaps Lows Highs" on AMGLH Page
    Then I click on "Fixture Scan" on AMGLH menu page
    And I search for items "<scanItem>" and verify that Last Delivery status is same on service and AM GLH UI

    Examples:
      | Item                                                                                                                                                                                                    | jsonFile                                                        | itemCount | scanItem            |
      | 112232957                                                                                                                                                                                               | /json-files/service/internalAudit/expectedResultSingleItem.json | 1         | 112232957           |
#   | 107313541,107350668,10735070,110053373,109040727,107329973,112232957,110058756,111175111,112232869,103234301,103111256,111719106,111181684,102392738,102391989,102391591,102391831,102391866,102391735| /json-files/service/internalAudit/expectedResultSingleItem.json | 20        |112232957,103234301|
      | 107313541,107350668,109040727,107329973,112232957,110058756,111175111,112232869,103234301,103111256,111719106,111181684,102392738,102391989,102391591,102391831,102391866,102391735,109363340,107322835 | /json-files/service/internalAudit/expectedResult.json           | 20        | 112232957,102391831 |


  @sma
  Scenario Outline: I verify item order status for multiple items and verify counts in Prompted count module.
    When I get the item order status response through API for following <ItemCount>"<Item>"
    Then I create expected result from "<jsonFile>"
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA

    Then I click on "Prompted Counts" on Home Page
    Then I Scroll down on Prompted Count menu page
    Then I click on "Ambient & Frozen" on Prompted Count Page
    Then I click on "Fixture" on Ambient Frozen Page
    And I verify Last Delivery Date and Next Delivery Date are same on service and UI for Product Min "109363340"
    Then I click on "Market Street" on Prompted Count Page
    Then I click on "Fixture" to get Product details
    And I verify Last Delivery Date and Next Delivery Date are same on service and UI for Market Street Product Min "109040727"
    Then I click on "Fresh" on Prompted Count Page
    Then I click on "Fixture" to get Fresh Product details
    And I verify Last Delivery Date and Next Delivery Date are same on service and UI for Fresh Product Min "107329973"
    Then I click on "Services" on Prompted Count Page
    Then I click on "Fixture" to get Service Product details
    And I verify Last Delivery Date and Next Delivery Date are same on service and UI for Service Product Min "101545561"

    Examples:
      | Item                                              | jsonFile                                                        | ItemCount |
      | 109363340,109040727,107329973,109415162,101545561 | /json-files/service/internalAudit/expectedResultSingleItem.json | 5         |

  @sma
  Scenario Outline: I verify item order status for more than 20 items
    When I get the item order status response through API for following <itemCount>"<Item>"
    Then I compare expected response from "<jsonFile>"with actual response for more than 20 items
    Examples:
      | Item                                                                                                                                                                                                              | jsonFile                                             | itemCount |
      | 108932811,107313541,107331011,107314982,107314860,109040727,107350705,107350668,107329973,111181684,111556335,110053373,111175111,103111256,111719106,107313402,107320776,112232869,112232957,110058756,103304411 | /json-files/service/internalAudit/errorResponse.json | 21        |


