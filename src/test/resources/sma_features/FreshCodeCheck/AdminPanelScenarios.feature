@admin_panel @web @fcc
Feature: Admin Panel - Verify Admin, Schedule summary and Manager sign off functionality.

  @web
  Scenario Outline: UAT_01_(Admin Panel-Admin) Verify Admin tab functionality.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Admin menu is displayed
    Then I click on Admin menu on Admin Panel
    And I verify Admin page is displayed
    Then I verify enter user details textfiled are displayed
    Then I enter username "<Username>"
    And I click on Next button
    Then I verify Select Access checkboxes are displayed
    And I scroll down to the page
    And I verify Grant Access button is displayed
    Then I click on Grant Access button
    And I verify Confirmation alert "<alertName>" is displayed
    Then I verify Grant access alert message as "<alertMessage>" is displayed

    Examples: 
      | StoreId | Username                               | alertName    | alertMessage                                                                    |
      |      78 | mjoiner.5.both@test.morrisonsplc.co.uk | Grant Access | You are about to grant access for this user. Are you sure you want to continue? |

  @web
  Scenario Outline: UAT_46_(Admin Panel_Schedule Summary) Verify department list for selected store for current week and next week is displayed.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Current week and next week tabs are displayed
    Then I click on Current week tab
    And I scroll down to the page
    And I verify department list for selected store for current week is displayed
    Then I click on Next week tab
    And I verify department list for selected store for next week is displayed

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_47_(Admin Panel_Schedule Summary) Verify department level schedule for Daily check, Afternoon Check and FM Check for current week.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Current week and next week tabs are displayed
    Then I click on Current week tab
    And I verify department list for selected store for current week is displayed
    Then I verify department level schedule for Daily check, Afternoon Check and FM Check
    And I verify schedule are in DDMMYYYY format

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_48_(Admin Panel_Schedule Summary) Verify class level schedule under selected department for Daily check, Afternoon Check and FM Check for current week.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Current week and next week tabs are displayed
    Then I click on Current week tab
    And I verify department list for selected store for current week is displayed
    Then I verify department level schedule for Daily check, Afternoon Check and FM Check
    And I verify schedule are in DDMMYYYY format
    Then I click on Department
    And I verify class level schedule under selected department for Daily check, Afternoon Check and FM Check
    And I verify schedule are in DDMMYYYY format

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_49_(Admin Panel_Schedule Summary) Verify subclass level schedule under selected department->class for Daily check, Afternoon Check and FM Check for current week.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Current week and next week tabs are displayed
    Then I click on Current week tab
    And I verify department list for selected store for current week is displayed
    Then I verify department level schedule for Daily check, Afternoon Check and FM Check
    And I verify schedule are in DDMMYYYY format
    Then I click on Department
    And I verify class level schedule under selected department for Daily check, Afternoon Check and FM Check
    And I verify schedule are in DDMMYYYY format
    And I scroll down to the page
    Then I click on Class under selected department
    And I verify subclass level schedule under selected department class for Daily check, Afternoon Check and FM Check
    And I verify schedule are in DDMMYYYY format

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_50_(Admin Panel_Schedule Summary) Verify User able to search Department data.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I Get Department name for selected store
    Then I verify Search icon is displayed on Schedule summary screen
    And I click on Search icon on Schedule summary screen
    Then I verify Search Dept class subclass & MI Textfield is displayed
    And I Enter and search Department name
    Then I verify Department Name is displayed on Search result page

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_51_1_(Admin Panel_Schedule Summary) Verify User is able to see Class level data on Search department level data.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I Get Department name for selected store
    Then I verify Search icon is displayed on Schedule summary screen
    And I click on Search icon on Schedule summary screen
    Then I verify Search Dept class subclass & MI Textfield is displayed
    And I Enter and search Department name
    Then I verify Department Name is displayed on Search result page
    Then I click on Searched Department
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_51_2_(Admin Panel_Schedule Summary) Verify User is able to see Subclass level data on Search department level data.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I Get Department name for selected store
    Then I verify Search icon is displayed on Schedule summary screen
    And I click on Search icon on Schedule summary screen
    Then I verify Search Dept class subclass & MI Textfield is displayed
    And I Enter and search Department name
    Then I verify Department Name is displayed on Search result page
    Then I click on Searched Department
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format
    And I scroll down to the page
    Then I click on Searched Department class
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_53_(Admin Panel_Schedule Summary) Verify User able to view departmentname and Classname at the top with class schedule details and Subclass details are dispalyed below with schedule details for all checks.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I Get Department name for selected store
    Then I verify Search icon is displayed on Schedule summary screen
    And I click on Search icon on Schedule summary screen
    Then I verify Search Dept class subclass & MI Textfield is displayed
    And I Enter and search Department name
    Then I verify Department Name is displayed on Search result page
    Then I click on Searched Department
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format
    And I scroll down to the page
    Then I click on Searched Department class
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format
    And I scroll down to the page
    Then I click on Searched Department subclass
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_54_(Admin Panel_Schedule Summary) Verify after clicking on Back to search, User navigates to search page to enter Department or Class or subclass name.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I Get Department name for selected store
    Then I verify Search icon is displayed on Schedule summary screen
    And I click on Search icon on Schedule summary screen
    Then I verify Search Dept class subclass & MI Textfield is displayed
    And I Enter and search Department name
    Then I verify Department Name is displayed on Search result page
    Then I click on Back to search
    Then I verify Search Dept class subclass & MI Textfield is displayed

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_55_(Admin Panel_Schedule Summary) Verify User able to search Sub Class data .
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I Get Department name for selected store
    Then I verify Department Name is displayed on Search result page
    Then I click on Department
    And I Get Class name for selected store
    Then I verify Search icon is displayed on Schedule summary screen
    And I click on Search icon on Schedule summary screen
    Then I verify Search Dept class subclass & MI Textfield is displayed
    And I Enter and search Class name
    Then I verify Class Name is displayed on Search result page
    Then I click on Searched Class Name
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format
    And I scroll down to the page
    Then I click on Searched Class subclass
    And I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_56_(Admin Panel_Schedule Summary) Verify Export Schedule Summary functionality.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Export schdule link is displayed
    Then I click on Export schdule link
    And I verify Export Schedule Information alert with message as "<alertMessage>"
    And I verify Cancel and Export button on Export Schedule Information alert
    Then I click On Export button

    #And I verify csv file is downloaded
    Examples: 
      | StoreId | StoreName     | alertMessage                                                                          |
      |      78 | 73 - Tamworth | Export will provide you with the schedule data for the selected store or store group. |

  @web
  Scenario Outline: UAT_57_1_(Admin Panel_ Manager signOff) Verify user able to view current days of selected store.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_57_2_(Admin Panel_ Manager signOff) Verify user able to view current days of selected group.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select group dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreGroup>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed

    Examples: 
      | StoreId | StoreGroup  |
      |      78 | Test502 - 2 |

  @web
  Scenario Outline: UAT_58_1_(Admin Panel_ Manager signOff) Verify user able to append or delete stores from the selection.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed
    And I verify Append and Delete icons are displayed
    Then I click on Append icon
    Then I verify alert "<alertName>" is displayed
    Then I click on Select store dropdown on Alert
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName1>" checkbox
    And I click on Save Button on Alert
    Then I verify days details are displayed for selected Stores "<verifyStore>"
    Then I click on Delete icon to remove store
    And I verify details are removed for deleted store "<verifyStore>"

    Examples: 
      | StoreId | StoreName     | StoreName1   | verifyStore | alertName                          |
      |      78 | 73 - Tamworth | 78 - London2 | London2     | Please select store or storegroups |

  @web
  Scenario Outline: UAT_58_2_(Admin Panel_ Manager signOff) Verify user able to append or delete group from the selection.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed
    And I verify Append and Delete icons are displayed
    Then I click on Append icon
    Then I verify alert "<alertName>" is displayed
    Then I click on Select group dropdown
    And I verify Store list with checkboxes are displayed
    Then I select group "<StoreGroup>" checkbox
    And I click on Save Button on Alert
    Then I verify days details are displayed for selected Groups "<verifyGroup>"
    Then I click on Delete icon to remove group
    And I verify details are removed for deleted group "<verifyGroup>"

    Examples: 
      | StoreId | StoreName     | StoreGroup  | verifyGroup | alertName                          |
      |      78 | 73 - Tamworth | Test502 - 2 | Test502     | Please select store or storegroups |

  @web
  Scenario Outline: UAT_59_1_(Admin Panel_ Manager signOff) Verify user able to select desired new sign off days for the chosen stores.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed
    And I scroll down to the page
    And I click on sign off days
    And I verify selected checkboxes are displayed

    Examples: 
      | StoreId | StoreName     |
      |      78 | 73 - Tamworth |

  @web
  Scenario Outline: UAT_59_2_(Admin Panel_ Manager signOff) Verify user able to select desired new sign off days for the chosen Store groups.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select group dropdown
    And I verify Store list with checkboxes are displayed
    Then I select group "<StoreGroup>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed

    Examples: 
      | StoreId | StoreGroup  |
      |      78 | Test502 - 2 |

  @web
  Scenario Outline: UAT_60_1_(Admin Panel_ Manager signOff) Verify user able to select desired new sign off days for the chosen Store stores.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed
    And I click on sign off days
    And I verify selected checkboxes are displayed
    And I scroll down to the page
    Then I verify Save and Discard buttons are displayed
    Then I click on Save Button
    And I verify alert "<alertName>" is displayed
    And I verify alert message as "<alertMessage1>" is displayed
    And I verify alert msg as "<alertMessage2>" is displayed

    Examples: 
      | StoreId | StoreName     | alertName | alertMessage1                                                                              | alertMessage2                                       |
      |      78 | 73 - Tamworth | CONFIRM   | Are you sure you want to save changes? Saving changes will overwrite existing information. | Changes will be effective from the following Monday |

  @web
  Scenario Outline: UAT_60_2_(Admin Panel_ Manager signOff) Verify user able to select desired new sign off days for the chosen Store groups.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select group dropdown
    And I verify Store list with checkboxes are displayed
    Then I select group "<StoreGroup>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed
    And I click on sign off days
    And I verify selected checkboxes are displayed
    And I scroll down to the page
    Then I verify Save and Discard buttons are displayed
    Then I click on Save Button
    And I verify alert "<alertName>" is displayed
    And I verify alert message as "<alertMessage1>" is displayed
    And I verify alert msg as "<alertMessage2>" is displayed

    Examples: 
      | StoreId | StoreGroup  | alertName | alertMessage1                                                                              | alertMessage2                                       |
      |      78 | Test502 - 2 | CONFIRM   | Are you sure you want to save changes? Saving changes will overwrite existing information. | Changes will be effective from the following Monday |

  @web
  Scenario Outline: UAT_61_1_(Admin Panel_ Manager signOff) Verify user able to discard new sign off days for the chosen stores.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed
    And I click on sign off days
    And I verify selected checkboxes are displayed
    And I scroll down to the page
    Then I verify Save and Discard buttons are displayed
    Then I click on Discard Button
    And I verify alert "<alertName>" is displayed
    And I verify alert message as "<alertMessage>" is displayed

    Examples: 
      | StoreId | StoreName     | alertName       | alertMessage                                                |
      |      78 | 73 - Tamworth | Discard changes | Are you sure you want to discard the changes you have made? |

  @web
  Scenario Outline: UAT_61_2_(Admin Panel_ Manager signOff) Verify user able to discard new sign off days for the chosen Store groups.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select group dropdown
    And I verify Store list with checkboxes are displayed
    Then I select group "<StoreGroup>" checkbox
    And I click on Next button
    Then I verify Manager Sign Off page details
    Then I verify Days with checkboxes are displayed
    And I click on sign off days
    And I verify selected checkboxes are displayed
    And I scroll down to the page
    Then I verify Save and Discard buttons are displayed
    Then I click on Discard Button
    And I verify alert "<alertName>" is displayed
    And I verify alert message as "<alertMessage>" is displayed

    Examples: 
      | StoreId | StoreGroup  | alertName       | alertMessage                                                |
      |      78 | Test502 - 2 | Discard changes | Are you sure you want to discard the changes you have made? |
      
      
      
      @web
  Scenario Outline: UAT_46_(Admin Panel_Schedule Summary) Verify Store list is in Ascending order in list.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I fetch all Store name and id
    And I verify Store list is in Ascending order
    Examples: 
      | StoreId | 
      |      78 | 
      
      
      @web
  Scenario Outline: UAT_46_(Admin Panel_Manager signOff) Verify Store list is in Ascending order in list.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Manager Sign Off menu is displayed
    Then I click on Manager Sign Off on Admin Panel
    And I verify Manager Sign Off page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I fetch all Store name and id
    And I verify Store list is in Ascending order
    Examples: 
      | StoreId | 
      |      78 | 
      
      
      @web
  Scenario Outline: UAT_50_(Admin Panel_Schedule Summary) Verify Search Functionality is flexible.
    Given I Navigate to webpage URL
    When I Enter Username and Password for SMA user
    Then I Verify Fcc Admin webpage logged Successfully
    And I verify Schedule Summary menu is displayed
    Then I click on Schedule Summary on Admin Panel
    And I verify Schedule Summary page is displayed
    Then I verify select store, select store group and Next button are displayed
    Then I click on Select store dropdown
    And I verify Store list with checkboxes are displayed
    Then I select store "<StoreName>" checkbox
    And I click on Next button
    Then I verify Search icon is displayed on Schedule summary screen
    And I click on Search icon on Schedule summary screen
    Then I verify Search Dept class subclass & MI Textfield is displayed
    And I Enter "<searchKeyword>" and Search
    Then I verify Department Name "<DepartmentName>" is displayed on Search result page

    Examples: 
      | StoreId | StoreName     |searchKeyword|DepartmentName|
      |      78 | 73 - Tamworth |001 Canned Vegetables|001 Canned Vegetables|
       |      78 | 73 - Tamworth |001 Canned|001 Canned Vegetables|
        |      78 | 73 - Tamworth |Canned|001 Canned Vegetables|
         |      78 | 73 - Tamworth |001|001 Canned Vegetables|
         
   
