@C&R_service
Feature: Get a specific product

  @sma
  Scenario Outline: Get Product Details
    Given I get the product details for the following item "<Item>"
    #Then I delete the item "<Item>"
    Then I verify the Response Code for the item "<Item>"
    Then I create new "<Item>" based on Response code and "packId"
    Given I get the product price for following item "<Item>"
    Then I get the Stock Order details for the following "<Item>"
    And I verify the Response Code for the item "<Item>"
    Then I create Stock Order for the "<Item>" based on Response code for data "<reqdata>"
    Given I get the Space details for the following "<Item>"
    And I verify the Response Code for the item "<Item>"
    Then I create Space for the "<Item>" based on Response code for data "<reqdata1>"
    Then I create SOH for the Items based on Response code "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
     #Then I update price for following "<Item>"

    Examples:
      | Item      | reqdata                                                                                                                                                                                                       | reqdata1             | bucketName                         | keyName                                 | filePath | fileName                           |
      | 109866342 | itemId=109866342,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 113358455 | itemId=113358455,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 111181684 | itemId=111181684,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 107665601 | itemId=107665601,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102883094 | itemId=102883094,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 111181684 | itemId=111181684,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |






#  //======================================


#  //==========================================
#  |109826068 |
#  |111673013 |
# | 111682489|
#  |111982529 |
#  |111982596 |
# | 111627033|
# | 100001707|
#  |100001708 |
# | 108114456|
#  |110455743 |
#  |111405131 |
# | 102369837|
#  |102370176 |
# | 102370264|
# | 110993453|
# | 110993576|
#  |105802245 |
#  |102369685 |
# | 102371401|
# | 104789966|
# | 104806623|
# | 107254668|
# | 109289178|
#  |110082019 |
# | 109876962|
# | 111400592|
# | 111400752|
#  |108309579 |
#  |108309608 |
# | 108309704|
# | 111693647|
# | 111876865|
# | 111876890|
#  |111876929 |
#  |111876953 |
# | 105801867|
# | 101525851|
# | 101534811|
#  |101536955 |
#



