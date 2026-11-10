@AWS_ECS_Task
Feature: AWS ECS task execution scenarios

  @sma
  Scenario Outline: Executing the AWS ECS task with different parameters
    Given The ECS Jobs are triggered with Task "<TaskName>", containerOverrides "<containerOverrides>",ClusterName "<ClusterName>", LaunchType "<LaunchType>", LogGroupName "<LogGroupName>", LogStreamNamePrefix "<LogStreamNamePrefix>"

    Examples:
      | TaskName | containerOverrides | ClusterName | LaunchType | LogGroupName | LogStreamNamePrefix |
#   | storewalkcountsprocessor_task_sit | /app/upload/application_sit.json,GapsHighsLows,GLH,09:45:00,12:00:00,             | nonprod-ECS-ECSCluster-W68V9ZHCS399 | EC2        | clg-euw1-sit-logistics-supplychain-storewalk-counts-processor-001 | storewalkcountsprocessor |
  | storewalkcountsprocessor_task_sit | /app/upload/application_sit.json,Counts,AM,00:00:00,12:00:00,09:45:00,12:00:00,2, | nonprod-ECS-ECSCluster-W68V9ZHCS399 | EC2        | clg-euw1-sit-logistics-supplychain-storewalk-counts-processor-001 | storewalkcountsprocessor |
  | storewalkcountsprocessor_task_sit | /app/upload/application_sit.json,MarketStreetGapsHighsLows,GLH,00:00:00,09:45:00, | nonprod-ECS-ECSCluster-W68V9ZHCS399 | EC2        | clg-euw1-sit-logistics-supplychain-storewalk-counts-processor-001 | storewalkcountsprocessor |




