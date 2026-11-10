@FCC_service
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
#    Then I create SOH for the Items based on Response code "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
     #Then I update price for following "<Item>"

    Examples:
      | Item      | reqdata                                                                                                                                                                                                       | reqdata1             | bucketName                         | keyName                                 | filePath | fileName                           |
      | 102369685 | itemId=102369685,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 107091248 | itemId=107091248,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 106794945 | itemId=106794945,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 107089869 | itemId=107089869,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 103113622 | itemId=103113622,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 110760924 | itemId=110760924,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 100100842 | itemId=100100842,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108511241 | itemId=108511241,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 106909888 | itemId=106909888,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 105521988 | itemId=105521988,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 102376463 | itemId=102376463,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 107365923 | itemId=107365923,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108338062 | itemId=108338062,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 108111052 | itemId=108111052,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |
      | 105236511 | itemId=105236511,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |

  Scenario Outline: Create SOH for items
    Then I create Space for the "<Item>" based on Response code for data "<reqdata1>"
    Then I create SOH for the Items based on Response code "<bucketName>" "<keyName>" "<filePath>" "<fileName>"

    Examples:
      | Item      | reqdata                                                                                                                                                                                                       | reqdata1             | bucketName                         | keyName                                 | filePath | fileName                           |
      | 107514491 | itemId=107514491,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation | file=getFromResponse | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |









#  //===100001478===================================


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



#  107365923	itemId=107365923,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108338062	itemId=108338062,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108347903	itemId=108347903,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108111052	itemId=108111052,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  107514491	itemId=107514491,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  100162509	itemId=100162509,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  101533092	itemId=101533092,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  110440154	itemId=110440154,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  109154185	itemId=109154185,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  107742952	itemId=107742952,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  104897086	itemId=104897086,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  107572771	itemId=107572771,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  100407422	itemId=100407422,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  100001478	itemId=100001478,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  102391639	itemId=102391639,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  110213664	itemId=110213664,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  111032347	itemId=111032347,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  109471640	itemId=109471640,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  110781645	itemId=110781645,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  111358734	itemId=111358734,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  111037383	itemId=111037383,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  111094732	itemId=111094732,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  109669533	itemId=109669533,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  11081645	itemId=11081645 ,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  106174631	itemId=106174631,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  111358136	itemId=111358136,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  107126295	itemId=107126295,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108629804	itemId=108629804,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  110995598	itemId=110995598,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  102370168	itemId=102370168,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  105541065	itemId=105541065,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  100001497	itemId=100001497,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  104003441	itemId=104003441,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  104065909	itemId=104065909,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  110747754	itemId=110747754,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108810996	itemId=108810996,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  109361221	itemId=109361221,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108394582	itemId=108394582,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108524922	itemId=108524922,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108543859	itemId=108543859,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108368632	itemId=108368632,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108335700	itemId=108335700,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108335777	itemId=108335777,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  109202204	itemId=109202204,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  104058522	itemId=104058522,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108779061	itemId=108779061,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  107694381	itemId=107694381,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  103853612	itemId=103853612,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  102370011	itemId=102370011,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  105198164	itemId=105198164,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108361326	itemId=108361326,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  108414361	itemId=108414361,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  100007066	itemId=100007066,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  102370141	itemId=102370141,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  105398043	itemId=105398043,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  102466936	itemId=102466936,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  103856160	itemId=103856160,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  104840012	itemId=104840012,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  105920250	itemId=105920250,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  112085150	itemId=112085150,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  100001478	itemId=100001478,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  105398043	itemId=105398043,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#  100001478	itemId=100001478,packId=getFromResponse,asnId=getUnique7Digit,trailerId=getUnique8Digit,orderedDate=getCurrentDate,receiptDate=getCurrentDate,receiptLocationId=GetLocation,shippedFromLocationId=GetLocation	file=getFromResponse	xxwmm.retail.stockorder.eeeeeeeeee	stockorders/relexnonmoorders/processed/	Input	RelexDiffFile_getRunTime110339.csv
#



