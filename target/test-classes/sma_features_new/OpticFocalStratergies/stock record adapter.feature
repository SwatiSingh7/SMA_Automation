@stockrecord_adapter
Feature: SMA-53644[Service] Order Adaptor Events to Focal Systems

  @sma @SOHCreate
  Scenario Outline: Get SOH Details
    Given I create SOH for the Items based on Response code "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
     #Then I update price for following "<Item>"

    Examples:
      | bucketName                         | keyName                                 | filePath | fileName                               |
      | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | ExceptionItemStock_YYYYMMDD_052020.dat |

#    @sma @stockV2Gapstores
#  Scenario Outline: Get SOH Details
#    Given I create input file for "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
#
#    Examples:
#      | bucketName                               | keyName             | filePath                         | fileName              |
#      | xxwmm.supplychain.opticcounts.qwpjnhvhjb | optic-store-config/ | C:/Users/Swati1500583/Downloads/ | stockV2Gapstores.json |

  @sma @KTClusterVPC
  Scenario Outline: To verify Stock record Adapter task runs at 6AM everyday for full extract
    Given The ECS Jobs for Cluster VPC are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"

    Examples:
      | TaskName                              | ClusterName                               | LaunchType | LogGroupName                          | LogStreamNamePrefix      |
      | opticcounts-ecs-sohadptr-task-sit-001 | ecs-euw1-n-supplychain-vpc001-general-001 | FARGATE    | clg-euw1-sit-supplychain-sohadptr-001 | storewalkcountsprocessor |

  @sma @DDClusterVPC
  Scenario Outline: Get the output file created after the stock record adapter task run and validate it.
    Given I get output file for "<bucketName>" "<keyName>" "<filePath>" "<fileName>"

    Examples:
      | bucketName                      | keyName             | filePath                         | fileName                                  |
      | xxwmm.stockv2.reader.eeeeeeeeee | supplierPO/stockv2/ | C:/Users/Swati1500583/Downloads/ | StockRecord_318_24063_20230929_071655.csv |

  @sma @ClusterVPC
  Scenario Outline: To verify GET Job status to check whether file is generated to S3.
    Given I get the job status for the following "<EndPoint>" and "<APIKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"
    And I get the field value for the field "jobId"
#    And I Verify the file is generated in  allocated S3 bucket


    Examples:
      | EndPoint                      | APIKey                           | Param               | Response         |
      | /stock/v2/jobs/<JobId>/status | 1rQlOAe1PAWaWLHlShKfhhUn8rODH8AK | jobType=stockonhand | status:completed |

  @sma @FocalEndPt
  Scenario Outline: To verify the data inserted is updated in the focal system.
    Given the Focal UI where I validate the data "<item>" inserted is updated into focal system

    Examples:
      | item      |
      | 107694381 |
#      | 108394582 |
#      | 108368632 |
#      | 108543859 |
##      | 108335777 |
##      | 109202204 |
##      | 104058522 |
##      | 108779061 |
##      | 107694381 |
##      | 103853612 |
##      | 109361221 |
##

  @sma @CreateGapFocal
  Scenario: To create gap for the items inserted under adapters.
    Given the Focal UI where I create gaps for the items inserted under adapters