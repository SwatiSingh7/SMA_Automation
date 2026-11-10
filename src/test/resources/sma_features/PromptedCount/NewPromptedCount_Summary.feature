@prompted_count_summary
Feature: Verify Prompted Count functionality for Summary screen.

  @sma
  Scenario: Verify Prompted Counts Summary screen
    When I enter Username and Password for SMA Collegue user
    And I click on login button for SMA
    Then I click on "Prompted Counts"
    Then I click on "Summary"
#    And verify Total Approvals is Disabled
    And I verify flagged items are "2"
    And I verify Actions Completed are "0 / 26"
    Then I verify  Flagged & Actions Completed sections
    And verify "Ambient & Frozen" department and its details
    And click on "Ambient & Frozen" and verify its details
    And I click on "Back" button
    And verify "Fresh" department and its details
    And click on "Fresh" and verify its details
    And I click on "Back" button
    And verify "Market Street" department and its details
    And click on "Market Street" and verify its details
    And I click on "Back" button
    And I scroll down to "Services"
    And verify "Services" department and its details
    And click on "Services" and verify its details
    And I click on "Back" button