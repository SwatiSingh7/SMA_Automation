@WVproduct_service
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
      | 105709930 | itemId=105709930,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 110307652 | itemId=110307652,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108539622 | itemId=108539622,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 104935695 | itemId=104935695,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108684782 | itemId=108684782,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 110202041 | itemId=110202041,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102797305 | itemId=102797305,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102796353 | itemId=102796353,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102800877 | itemId=102800877,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 103043142 | itemId=103043142,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 111189539 | itemId=111189539,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 105236511 | itemId=105236511,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 100402904 | itemId=100402904,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 105201870 | itemId=105201870,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102377108 | itemId=102377108,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 111508376 | itemId=111508376,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102800789 | itemId=102800789,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 103090580 | itemId=103090580,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 100155368 | itemId=100155368,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108304663 | itemId=108304663,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 107091248 | itemId=107091248,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 111449994 | itemId=111449994,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 111508317 | itemId=111508317,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108803358 | itemId=108803358,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102760916 | itemId=102760916,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108064858 | itemId=108064858,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102459867 | itemId=102459867,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 109706998 | itemId=109706998,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 103029762 | itemId=103029762,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 109514064 | itemId=109514064,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |

  @sma @BarCodeCreation
  Scenario Outline: Get Product Details
    Given I get the product details for the following item "<Item>"
    #Then I delete the item "<Item>"
    Then I verify the Response Code for the item "<Item>"
    Then I create new "<Item>" based on Response code and "packId,itemNumber" for the given barcode

    Examples:
      | Item          | reqdata                                                                                                                                                                                                           | reqdata1             | bucketName                         | keyName                                 | filePath | fileName                           |
      | 0299000000000 | itemId=0299000000000,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |



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



