@opticsProduct_adapter
Feature: SMA-53644-[Service] Product Adaptor Events to Focal Systems - Optic Strategic V1_TC-01

  @sma @ProdAdptrTask
  Scenario Outline: To verify Focal Adapter task runs at 6AM everyday
  Given The ECS Jobs for Cluster VPC are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"

    Examples:
      | TaskName                                    | ClusterName                               | LaunchType | LogGroupName                              | LogStreamNamePrefix      |
      | opticcounts-ecs-productadptr-task-sit-001:3 | ecs-euw1-n-supplychain-vpc001-general-001 | FARGATE    | clg-euw1-sit-supplychain-productadptr-001 | storewalkcountsprocessor |

  @sma @OOClusterVPC
  Scenario Outline: Get the output file created after the stock record adapter task run and validate it.
    Given I get output file for "<bucketName>" "<keyName>" "<filePath>" "<fileName>"
    Then I verify the "<Fields>" fields in the output file

    Examples:
      | bucketName                               | keyName                  | filePath                         | fileName                | Fields                                                                                                            |
      | xxwmm.supplychain.opticcounts.qwpjnhvhjb | product-adaptor/archive/ | C:/Users/Swati1500583/Downloads/ | product_full_getRunTime | productUpc,reportDate,itemNumber,departmentNumber,departmentDescription,itemDescription,caseUpc,casePack,imageUrl |

  @sma @PPFocalEndPt
  Scenario Outline: To verify the data inserted is updated in the focal system.
    Given the Focal UI where I validate the data got updated in the focal system

    Examples:
      | item      |
      | 107694381 |


