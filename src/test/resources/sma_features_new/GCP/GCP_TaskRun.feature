@GCP_Run
Feature: GCP Integration with MOCO

  @sma @GCPgetOrders
  Scenario Outline: SMA-56690_SERVICE_MOCO_GET_TC05, To verify 404 error is received when Get Order details is hit when Item is not found.
    Given I hit the get endpoint to retrieve the "get Orders for an items" for the following "<EndPoint>" and "<APIKey>" and "<AuthKey>" and "<Param1>" and "<Param2>" and "<Param3>" and "<Param4>" and "<Param5>" and "<Param6>" and Request file "<Request>"
    Then I Verify the Response Code for the following "get Orders for an items" is "200"
    And I verify the response fields "<Response>"

    Examples:
      | EndPoint                                                             | APIKey                           | AuthKey                                                                    | Param1                 |Param2          | Param3     |Param4     |Param5             | Param6             |Response                     |Request|
      | supplychain-managercustomerorders/v1/stores/orders/@all              | GA6GFexsLxfPzIukf1erDTT67z9vskG7 | Basic R0E2R0ZleHNMeGZQekl1a2YxZXJEVFQ2N3o5dnNrRzc6QUJ6WlVMNTRGenRsWTlCZQ== | orderType=managerorder |  status= gcp   |limit = 1000| offset=0  |since=runtimedate-1| until=runtimedate  | errorCode:0,errorMessage:10 |json-files/service/MOCO/Request/CreateManagerOrderReq.json|
#  https://sit-api.morrisons.com/supplychain-managercustomerorders/v1/stores/@all/orders/@all?since=2024-08-26T21:45:01&until=2024-08-27T21:45:00&limit=1000&offset=0&orderType=customerorder&status=gcp&apikey=GA6GFexsLxfPzIukf1erDTT67z9vskG7&

  @sma @StckOrdAdptrTask
  Scenario Outline: To verify Focal Adapter task runs at 6AM everyday
    Given The ECS Jobs for Cluster VPC are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"

    Examples:
      | TaskName                                                      | ClusterName                               | LaunchType | LogGroupName                             | LogStreamNamePrefix      |
      | manager-customer-order-ecs-moco-to-gcp-processor-task-sit-002 | ecs-euw1-n-supplychain-vpc001-general-001 | FARGATE    | clg-euw1-sit-opticcounts-stkordadptr-001 | storewalkcountsprocessor |

  @sma
  Scenario Outline: Executing the AWS ECS task with different parameters
    Given The ECS Jobs are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>" with subnets "<subnets>" with securityGrp "<sg-078193ad801aaabcf>"

    Examples:
      | TaskName                                                      | containerOverrides | ClusterName                         | LaunchType | LogGroupName | LogStreamNamePrefix                                                               |                  subnets                                                       |
      | manager-customer-order-ecs-moco-to-gcp-processor-task-sit-002:1 | 22:00:01 22:00:00 1| nonprod-ECS-ECSCluster-W68V9ZHCS399 | FARGATE        | clg-euw1-sit-logistics-supplychain-storewalk-counts-processor-001 | storewalkcountsprocessor |"subnet-0075af7ea30926420","subnet-0269a4e0320a15f04","subnet-03eb6eb99457e1589"|