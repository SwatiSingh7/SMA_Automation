Feature: Verify Database connection

  @CNRdatabase @ee
  Scenario: Database Connection
    When I connect to the "cleanAndRotate" database and fire a select query to get multiple rows with query as "Create dynamic query", for the following columns
      | stock_item_id |
      | location_id   |
      | item_id       |
    And I check the results in another Step Def File
    When I connect to "Stock V2" database and fire a delete query as "Create dynamic query"
  And I delete the data from "cleanAndRotate" database and create fresh data

#    When I connect to Remote Database