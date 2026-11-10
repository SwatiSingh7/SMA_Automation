@admin_panel @web @fcc
Feature: FCC Admin Panel Webpage for Store, Change log and Check Schedule tabs

  @web
  Scenario: Login webpage
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
######################################### Store Group ################################
  @web
  Scenario: UAT_32Verify User able to 'View' Store Group list
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on the Stores Tab
    Then User should be able to enter Store page with list of Store Groups

  @web
  Scenario: UAT_33 Verify User able to 'Create' new Store group
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on 'New Group' button
    Then New Store Groups with storelist is created successfully

  @web
  Scenario: UAT_34 Verify User able to 'Edit' the desired store group from the store group list by adding stores
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on edit icon of the desired store group
    Then Verify 'Store group updated successfully'

  @web
  Scenario: UAT_35 Verify User able to 'Delete' the desired store group from the store group list
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on delete icon of the desired store group.
    And Verify "Are you sure you want to delete this store group?"
    Then User deletes the Store Group successfully


  @web
  Scenario: UAT_37Verify User can 'Disable' all the StoreGroup with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store group
    Then Store Group are successfully disables
    And Verify "Are you sure you want to disable this Store/Store Group?"
    When Click on Save below popup will appear for disable
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"

  @web
  Scenario: UAT_36Verify User can 'Enable' all the StoreGroup with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store group
    Then User enables all the Store Group successfully
    And Verify "Are you sure you want to enable this Store/Store Group?"
    When Click on Save below popup will appear
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"

#TC-35fcc4

  Scenario Outline: UAT_41Verify User can 'Disable' selected single StoresGroup with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store "<StoreGroup>"
    And Verify "Are you sure you want to disable this Store/Store Group?"
    Then User Disable the selected Stores successfully
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"

    Examples:
      | StoreGroup   |
      | A Test Group |


  Scenario Outline: UAT_42Verify User can 'Enable' selected single StoresGroup with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store "<StoreGroup>"
    And Verify "Are you sure you want to disable this Store/Store Group?"
    Then User enables selected Stores successfully.
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"

    Examples:
      | StoreGroup   |
      | A Test group |

  @web
  Scenario: UAT_38Verify User able to view Store list
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on the Store list Tab
    Then User should be able to view list of Stores

  @web
  Scenario: UAT_40Verify User can 'Disable' all the Stores with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store
    And Verify "Are you sure you want to disable this Store/Store Group?"
    Then User disables all the Stores successfully.
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"

  @web
  Scenario: UAT_39Verify User can 'Enable' all the Stores with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store
    And Verify "Are you sure you want to enable this Store/Store Group?"
    Then User enables all the Stores successfully
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"
#fcc4-41

  @web
  Scenario Outline: UAT_41Verify User can 'Disable' selected single Stores with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store "<StoreID>"
    And Verify "Are you sure you want to disable this Store/Store Group?"
    Then User Disable the selected Stores successfully
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"

    Examples:
      | StoreID |
      | 79      |

  @webb
  Scenario Outline: UAT_42Verify User can 'Enable' selected single Stores with toggle switch
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on toggle of store "<StoreID>"
    And Verify "Are you sure you want to disable this Store/Store Group?"
    Then User enables selected Stores successfully.
    And Verify "Are you sure you want to save changes? "
    And Verify "Changes will be effective from tomorrow."
    And Verify "These changes will be effective for 24 hours"

    Examples:
      | StoreID |
      | 79      |

  @web
  Scenario: UAT_43Verify User to 'Export' Stores and Store Groups
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When User click on export
    And Verify "Export will provide you with the list of stores and store groups"
    Then User should be able to export list of stores and store groups from ‘Stores’ for the current day

  @web
  Scenario Outline: UAT_44Verify User is able to 'View' check schedule
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When Clicks on Check Schedule
    And select Store/Storegroup "<Store>"
    And I navigate to Department "<Department>"
    And I view Daily Check/Afternoon Check/FM Check
    Then Able to View and Edit "<Department>" department/class/subclass check schedule dates

    Examples:
      | Store        | Department            |
      | 78 - London2 | 001 Canned Vegetables |

  @web
  Scenario Outline: UAT_44Verify User is able to 'Edit' check schedule
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When Clicks on Check Schedule
    And select Store/Storegroup "<Store>"
    And I navigate to Department "<Department>"
    And I view Daily Check/Afternoon Check/FM Check
    Then Able to View and Edit "<Department>" department/class/subclass check schedule dates

    Examples:
      | Store        | Department            |
      | 78 - London2 | 001 Canned Vegetables |

  @web
  Scenario Outline: UAT_45Verify User is able to 'Search' department/class/subclass on Check schedule screen
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When Clicks on Check Schedule
    And select Store/Storegroup "<Store>"
    And I search Department "<Department>" in Search box
    And I view Daily Check/Afternoon Check/FM Check
    Then Able to Search and Edit department/class/subclass check schedule dates

    Examples:
      | Store        | Department       |
      | 78 - London2 | Bought In Breads |

  @web
  Scenario Outline: Verify User is able to view logs of activity for respective date
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When Clicks on Change Log
    Then Able to View the logs of activities for respective time
    And Enter the From date and To date in the date range
    And View the respective logs
    Then click Export to excel

    Examples:
      | Activity |
      | Manager  |


  @web
  Scenario Outline: Verify User is able to view logs of activity for respective activity name
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When Clicks on Change Log
    Then Able to View the logs of activities for respective time
    And Enter Activity Name "<Activity>" in Search field
    And View the respective logs
    Then click Export to excel

    Examples:
      | Activity |
      | Manager  |

  @web
  Scenario Outline: Verify User is able to view logs of all activities
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    When Clicks on Change Log
    And View the respective logs
    Then click Export to excel

    Examples:
      | Activity |
      | Manager  |


