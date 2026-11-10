@forget_password
Feature: Verify Forgot password functionality

  @sma
  Scenario Outline: Verify Forgot password link functionality
    Given I verify Forgot password link is displayed
    Then I click on Forgot password link
    And I verify Forgot password page

    Examples:
      | StoreID |
      | 78      |

  @sma
  Scenario Outline: Verify Change password button functionality
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on Navigation bar icon
    Given I verify Change password link is displayed
    Then I click on Change password link
    And I verify Change password page

    Examples:
      | StoreID |
      | 78      |
      
      