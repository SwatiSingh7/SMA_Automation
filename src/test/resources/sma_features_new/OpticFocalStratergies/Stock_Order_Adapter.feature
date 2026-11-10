@opticsStock_Order
Feature: SMA-53644[Service] Order Adaptor Events to Focal Systems

  @sma @Rmsorder
  Scenario Outline: To verify stock order are processed successfully for smsorder, rmsorder  files are processed
    Given I create input file for "<bucketName>" "<keyName>" "<filePath>" "<fileName>"

    Examples:
      | bucketName                         | keyName                        | filePath | fileName                            |
      | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/rmsorders/pending/ | Input    | nb_blueyonder_orders_getRunTime.dat |

  @sma @Rmsorder
  Scenario Outline: To verify POST Job status  for rmsorder to check whether file is generated to S3.
    Given I hit the post api for the following "<EndPoint>" and "<APIKey>" and "<Param>" based on Response code for data "<reqdata1>"

    Examples:
      | EndPoint            | APIKey                           | Param               | Response         | reqdata1                                |
      | /stockorder/v1/jobs | kWQ6gyrOGP0NA2fRAfvJTHVacfb9C95G | jobType=stockonhand | status:completed | file=getFromResponse,resource=rmsorders |

  @sma @relexnonmoorders
  Scenario Outline: To verify stock order are processed successfully for stockorder proposal and relexnonmoorders files are processed
    Given I create input file for "<bucketName>" "<keyName>" "<filePath>" "<fileName>"

    Examples:
      | bucketName                         | keyName                                 | filePath | fileName                           |
      | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/relexnonmoorders/processed/ | Input    | RelexDiffFile_getRunTime110339.csv |

  @sma @relexnonmoorders
  Scenario Outline: To verify POST Job status for relexnonmorder to check whether file is generated to S3.
    Given I hit the post api for the following "<EndPoint>" and "<APIKey>" and "<Param>" based on Response code for data "<reqdata1>"

    Examples:
      | EndPoint            | APIKey                           | Param               | Response         | reqdata1                                       |
      | /stockorder/v1/jobs | kWQ6gyrOGP0NA2fRAfvJTHVacfb9C95G | jobType=stockonhand | status:completed | file=getFromResponse,resource=relexnonmoorders |

  @sma @StckOrdAdptrTask
  Scenario Outline: To verify Focal Adapter task runs at 6AM everyday
    Given The ECS Jobs for Cluster VPC are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"

    Examples:
      | TaskName                                   | ClusterName                               | LaunchType | LogGroupName                             | LogStreamNamePrefix      |
      | opticcounts-ecs-stkordadptr-task-sit-001:2 | ecs-euw1-n-supplychain-vpc001-general-001 | FARGATE    | clg-euw1-sit-opticcounts-stkordadptr-001 | storewalkcountsprocessor |

  @sma @ClusterVPC @StckOrdAdptrTask
  Scenario Outline: To verify GET Job status to check whether file is generated to S3.
    Given I get the job status for the following "<EndPoint>" and "<APIKey>" and "<Param>"
    Then I Verify the Response Code for the following "<Item>" is 200
    And I verify the response fields "<Response>"
    And I get the field value for the field "jobId"
#    And I Verify the file is generated in  allocated S3 bucket


    Examples:
      | EndPoint                      | APIKey                           | Param               | Response         |
      | /stock/v2/jobs/<JobId>/status | 1rQlOAe1PAWaWLHlShKfhhUn8rODH8AK | jobType=stockonhand | status:completed |

  @sma @OOClusterVPC @StckOrdAdptrTask
  Scenario Outline: Get the output file created after the stock record adapter task run and validate it.
    Given I get output file for "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
    Then I validate the data in the input file gets inserted in the outfile generated

    Examples:
      | bucketName                         | keyName                       | filePath | fileName   |
      | xxwmm.retail.stockorder.eeeeeeeeee | stockorders/outbound/pending/ | Output   | getRunTime |

  @sma @OrderFocalEndPt
  Scenario: To verify the data inserted is updated in the focal system.
    Given the Focal UI where I validate the data inserted is updated into focal system for Stock Order Adapter

