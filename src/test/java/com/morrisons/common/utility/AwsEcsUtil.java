//package com.morrisons.common.utility;
//
//import com.amazonaws.ClientConfiguration;
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.ecs.AmazonECS;
//import com.amazonaws.services.ecs.AmazonECSClientBuilder;
//import com.amazonaws.services.ecs.model.DescribeTasksRequest;
//import com.amazonaws.services.ecs.model.DescribeTasksResult;
//import com.amazonaws.services.ecs.model.RunTaskRequest;
//import com.amazonaws.services.ecs.model.RunTaskResult;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import software.amazon.awssdk.services.ecs.model.AwsVpcConfiguration;
//import software.amazon.awssdk.services.ecs.model.NetworkConfiguration;
//
//public class AwsEcsUtil {
//
//    public static AmazonECS amazonECS;
//    public static final Logger log = LoggerFactory.getLogger(AwsEcsUtil.class);
//
//    public static AmazonECS getEcsClient(){
//        return AmazonECSClientBuilder.standard()
//                .withClientConfiguration(getAwsClientConfiguration())
//                .withRegion("eu-west-1")
//                .withCredentials(new DefaultAWSCredentialsProviderChain())
//                .build();
//    }
//
//    public static void RunECSEc2Task(String cluster, String taskdef) throws InterruptedException {
//        amazonECS = getClient();
//        RunTaskRequest runTaskRequest = new RunTaskRequest()
//                .withCluster(cluster)
//                .withTaskDefinition(taskdef)
//                .withLaunchType("EC2");
//        RunTaskResult runTaskResult = amazonECS.runTask(runTaskRequest);
//        String taskArn = runTaskResult.getTasks().get(0).getTaskArn();
//        String taskStatus = runTaskResult.getTasks().get(0).getLastStatus();
//        DescribeTasksRequest request = new DescribeTasksRequest().withTasks(taskArn).withCluster(cluster);
//        System.out.println("Task ID - "+ taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() +" Task Staus - "+taskStatus);
//        while (!taskStatus.equals("STOPPED")){
//            log.info("Waiting for task to be completed");
//            Thread.sleep(10000);
//            DescribeTasksResult response = amazonECS.describeTasks(request);
//            taskStatus = response.getTasks().get(0).getLastStatus();
//        }
//
//    }
//
//    public static void RunECSFargateTask(String cluster, String taskdef, String subnet, String group) throws InterruptedException {
//        amazonECS = getClient();
//        NetworkConfiguration networkConfiguration = new NetworkConfiguration().withAwsvpcConfiguration(new AwsVpcConfiguration()
//                .withSubnets(subnet)
//                .withSecurityGroups(group));
//        RunTaskRequest runTaskRequest = new RunTaskRequest()
//                .withCluster(cluster)
//                .withNetworkConfiguration(networkConfiguration)
//                .withTaskDefinition(taskdef)
//                .withLaunchType("FARGATE");
//        RunTaskResult runTaskResult = amazonECS.runTask(runTaskRequest);
//        String taskArn = runTaskResult.getTasks().get(0).getTaskArn();
//        String taskStatus = runTaskResult.getTasks().get(0).getLastStatus();
//        DescribeTasksRequest request = new DescribeTasksRequest().withTasks(taskArn).withCluster(cluster);
//        System.out.println("Task ID - "+ taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() +" Task Staus - "+taskStatus);
//        while (!taskStatus.equals("STOPPED")){
//            log.info("Waiting for task to be completed");
//            Thread.sleep(20000);
//            DescribeTasksResult response = amazonECS.describeTasks(request);
//            taskStatus = response.getTasks().get(0).getLastStatus();
//        }
//        System.out.println("Task ID - "+ taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() +" Task Staus - "+taskStatus);
//
//    }
//
//    public static void getEcsStatus(String taskArn){
//        amazonECS = getClient();
//    }
//
//
//    public static AmazonECS getClient() {
//        if (amazonECS == null) {
//            amazonECS = getEcsClient();
//        }
//        return amazonECS;
//    }
//
//	public static ClientConfiguration getAwsClientConfiguration() {
//        ClientConfiguration clientConfiguration = null;
//        if(Boolean.TRUE.toString().equals(config.get("PROXYENABLD"))){ // set as environment variable - True or false
//            clientConfiguration = new ClientConfiguration()
//                    .withReaper(true)
//                    .withTcpKeepAlive(true)
//                    .withConnectionMaxIdleMillis(10000)
//                    .withMaxConnections(5000)
//                    .withMaxErrorRetry(5)
//                    .withConnectionTimeout(10000);
//            clientConfiguration.setProxyHost(config.get("HOST").toString()); // proxy host
//            clientConfiguration.setProxyPort((Integer) config.get("PORT")); // proxy port
//            clientConfiguration.setProxyUsername(config.get("USERNAME").toString()); //proxy username
//            clientConfiguration.setProxyPassword(config.get("PASSWORD").toString()); //proxy password
//        }
//        return clientConfiguration;
//    }
//
//    public static void main(String []args) throws InterruptedException {
//
//    }
//}
