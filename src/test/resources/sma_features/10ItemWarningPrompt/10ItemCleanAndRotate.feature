@10Item_cleanAndRotate
Feature: Verify Clean and Rotate functionality for 10 Item Warning Prompt

  @sma
  Scenario Outline: Log product with Action -> Wastage and Display 10 Item warning Prompt
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Weekly Schedules" on Clean and Rotate Page
    And I Select Weekly schedule
      |Week 22nd August 2022|
    And I Select "<Department>"
    And I search for "<minID1>"
    Then I select "<action>" Action on Action log page
    And I Select Current Date in Calendar
    And I enter the quantity as "<quantity>" in Quantity textbox
    Then I click on Log Product button on Action log page
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button
    And I Verify Wastage reason Alert Title and Message
    Then I select "<wastageOption1>" Action on Wastage Reason alert and click on Confirm

    Examples:
      | action  | quantity |Department |minID1|message                                                                                                  |wastageOption1  |
      | Wastage | 10       |Crisps and Snacks|105590393|You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|Waste - Damaged |
      | Wastage | 10       |Crisps and Snacks|109101606|You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|Waste - Out of Date |
      | Wastage | 10     |Canned Fruit| 107665601|You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|Charity - Out of Date |
      | Wastage | 10     |Canned Fruit| 102883094|You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|Charity - Damaged |




  @sma
  Scenario Outline: Verify Ambient and Code alert and display 10 item warning prompt
    When I enter Username and Password for SMA Manager user
    And I click on login button for SMA
    Then I click on "Clean and Rotate" on Home Page
    Then I click on "Ambient & Frozen Code Alerts" on Clean and Rotate Page
    And I click on Alert dropdown
    Then I select "All Alerts" from the Alert dropdown
    Then I select product on Ambient and Frozen code page
    Then I select "<action>" Action on Code Alert
    And I enter the desired quantity "<quantity>" for product
    Then I Click on Add next action button on Ambient frozen page
    Then I should get a Message saying "<message>" and should be able to click the "CONFIRM" Button
    And I verify reason code and Title on Wastage popup
    Then I select the desired reason code "<wastageOption1>" for product

    Examples:
      |action| quantity | message                                                                                                  |wastageOption1|
      |Wastage| 10       | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|Waste - Out of Date|
      |Wastage| 10       | You have entered a quantity of 10 units or more.\n\nPlease confirm that the value of 10 units is correct.|Charity - Out of Date|
