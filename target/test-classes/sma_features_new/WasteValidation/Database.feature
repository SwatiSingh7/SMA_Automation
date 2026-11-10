Feature: Verify Database connection

  @database
  Scenario: Database Connection
#    When I connect to the "Test" database and fire a select query to get a single column as "taxid" with query as "Select * From xref limit 1"
#    And I check the results in another Step Def File
#    When I connect to the "Waste Validation" database and fire a select query to get a single row with query as "Select * From tray_items limit 1", for the following columns
#      | tray_id       |
#      | tray_items_id |
#      | item_id       |
#    And I check the results in another Step Def File
    When I connect to the "Stock V2" database and fire a select query to get multiple rows with query as "Select * From stock_item limit 1", for the following columns
      | stock_item_id |
      | location_id   |
      | item_id       |
    And I check the results in another Step Def File
#    When I connect to "Stock V2" database and fire a delete query as ""
#    When I connect to Remote Database