package com.morrisons.sma.page_objects.mobile.old;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ecs.AmazonECS;
import com.amazonaws.services.ecs.AmazonECSClientBuilder;
import com.amazonaws.services.ecs.model.*;
import com.amazonaws.services.logs.AWSLogs;
import com.amazonaws.services.logs.AWSLogsClient;
import com.amazonaws.services.logs.AWSLogsClientBuilder;
import com.amazonaws.services.logs.model.*;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.sma.step_definitions.service.Product.API_ServiceStepDef;
import org.testng.Assert;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import static com.morrisons.common.utility.ApplicationContext.applicationConfig;
import static com.morrisons.common.utility.WebServicesRetry.log;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ecs.EcsClient;
import software.amazon.awssdk.services.ecs.model.EcsException;
import software.amazon.awssdk.services.ecs.model.UpdateServiceRequest;
import software.amazon.awssdk.services.ecs.model.UpdateServiceResponse;


public class AWS_S3Upload {

    private static ArrayList arrOutputFieldData = new ArrayList();
    static LinkedHashMap<String,LinkedHashMap> arrInputData = new LinkedHashMap<String,LinkedHashMap>();
    public ArrayList getFieldData(){
        return this.arrOutputFieldData;
    }
    public LinkedHashMap getProductData(){
        return this.arrInputData;
    }
    int RunCtr = 0;
        public void S3Uploader(String sCurrentDate1) {
            String env = applicationConfig.getWebElementEnviroment().getEnv();
            if(env.equalsIgnoreCase("com.morrisons.instore.uat")){
                env = "uat";
            }
            else if (env.equalsIgnoreCase("com.morrisons.instore.sit")){
                env = "sit";
            }
            String bucketName = "m" + env + ".xxwmm.retail.space.eeeeeeeeee";
            LocalDateTime currentDate1 = LocalDateTime.now();
            String keyName = "spaceservice/space/processed/" + sCurrentDate1;
            String filePath = System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sCurrentDate1;

            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "eu-west-1"))
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();
           // s3Client = new AmazonS3Client(DefaultAWSCredentialsProviderChain.getInstance());
//            String access_key_id = "ASIAQJSHSDLWTGJ2VVOM";
//            String secret_key_id = "MIfNz20860LdompqHhntPD+rUGsyk/Jmh/szuCJS";
//            String session_token = "IQoJb3JpZ2luX2VjEKf//////////wEaCWV1LXdlc3QtMSJHMEUCIQDTLkzUD93VosF1j8PUFP13FmQBKuCLwSSMSBgdGNeuvwIgM6Ia9oFTEL6kCifmOMzqo/96XbB3/cKm7b4e0x8HoxEqowMIkP//////////ARADGgwwMjA1NTExNzg5ODkiDM3q/Vi2RTiqqqtS9Sr3Au31pN09225SW1uGLW3yHQQty8II75NTevdrBpgYsn45Qwql/AZVaAzFc1fjoN56PJJcvusxW+C0iPoEXsMTbqFZilZC9xO9HTWwqhtJrPWQXyeoEVzBqmAHrdvN7myYKTrwMbb2CUaBmuogOCOHvbm5Z9aJ1o4BRZyNPp/Zx8PAh0mSLLbspYm7/5rvihFUt8EoBRheyeYpPZFmK11XfhKNXvwYR0O5//OylHpYOy/ks9wNoe1TV97SPuQTclorq3Zep+kxh/cQPsXmKnx9XM6XfrMfHXaCxahM3wsDdL12zVio8XHJhYl4kS3dBOdtq/7FLc+UzJFSz7m3hragaICnHass1J3bDFlqYMwEtevU+HKSBvfwxNTsXrwjlJUv6xWX9j59gm5Yki6IQLoqmALDbIqTnnMS8lrjqPgJpClamOrJJu8sl3XLNyp2qjI8Lb6rdGwCea96xKuMHSce7MCWWXCxWm5CNfa88+LRo/zWSrUuYtJTNzCzudChBjqmAROW+seeotbO91Z+kayVSi3k7MvpXs7M1U4jYqWBlnBX5CzffU8pm+jAArI4VsLl60OptTuF8zRGVaIXsjOlBw+1VY4C1JrMOtEms0Asrzp36bM2l04mvIwd0NZPix9ZoG/4NoqxzLRsjhDGTC8MdKfhLLVJvmO++s9nGkS32hr+oAp5XmZjXPwe6FDqpRXN1RCrpFH9xDC/I4R2U0XDPt3apRHQDa0=";
//            BasicSessionCredentials awsCreds = new BasicSessionCredentials("access_key_id", "secret_key_id", "session_token");
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "us-east-1"))
//                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                    .build();
            try {
                File file = new File(filePath);
                PutObjectRequest request = new PutObjectRequest(bucketName, keyName, file);
                s3Client.putObject(request);
                System.out.println("File uploaded successfully to S3 bucket.");
            } catch (AmazonServiceException e) {
                e.printStackTrace();
            } catch (SdkClientException e) {
                e.printStackTrace();
            }
        }
        //=======================================================
        public void S3UploaderNP(String bucketName, String keyName, String filePath,String sCurrentDate1) {
            String env = applicationConfig.getWebElementEnviroment().getEnv();
            if(env.equalsIgnoreCase("com.morrisons.instore.uat")){
                env = "uat";
            }
            else if (env.equalsIgnoreCase("com.morrisons.instore.sit")){
                env = "sit";
            }
            bucketName = "m" + env + "." + bucketName;  //xxwmm.supplychain.freshcounts.eeeeeeeeee";
            LocalDateTime currentDate1 = LocalDateTime.now();
            keyName = keyName + sCurrentDate1;
            filePath = System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sCurrentDate1;

            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "eu-west-1"))
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();
            // s3Client = new AmazonS3Client(DefaultAWSCredentialsProviderChain.getInstance());
//            String access_key_id = "ASIAQJSHSDLWTGJ2VVOM";
//            String secret_key_id = "MIfNz20860LdompqHhntPD+rUGsyk/Jmh/szuCJS";
//            String session_token = "IQoJb3JpZ2luX2VjEKf//////////wEaCWV1LXdlc3QtMSJHMEUCIQDTLkzUD93VosF1j8PUFP13FmQBKuCLwSSMSBgdGNeuvwIgM6Ia9oFTEL6kCifmOMzqo/96XbB3/cKm7b4e0x8HoxEqowMIkP//////////ARADGgwwMjA1NTExNzg5ODkiDM3q/Vi2RTiqqqtS9Sr3Au31pN09225SW1uGLW3yHQQty8II75NTevdrBpgYsn45Qwql/AZVaAzFc1fjoN56PJJcvusxW+C0iPoEXsMTbqFZilZC9xO9HTWwqhtJrPWQXyeoEVzBqmAHrdvN7myYKTrwMbb2CUaBmuogOCOHvbm5Z9aJ1o4BRZyNPp/Zx8PAh0mSLLbspYm7/5rvihFUt8EoBRheyeYpPZFmK11XfhKNXvwYR0O5//OylHpYOy/ks9wNoe1TV97SPuQTclorq3Zep+kxh/cQPsXmKnx9XM6XfrMfHXaCxahM3wsDdL12zVio8XHJhYl4kS3dBOdtq/7FLc+UzJFSz7m3hragaICnHass1J3bDFlqYMwEtevU+HKSBvfwxNTsXrwjlJUv6xWX9j59gm5Yki6IQLoqmALDbIqTnnMS8lrjqPgJpClamOrJJu8sl3XLNyp2qjI8Lb6rdGwCea96xKuMHSce7MCWWXCxWm5CNfa88+LRo/zWSrUuYtJTNzCzudChBjqmAROW+seeotbO91Z+kayVSi3k7MvpXs7M1U4jYqWBlnBX5CzffU8pm+jAArI4VsLl60OptTuF8zRGVaIXsjOlBw+1VY4C1JrMOtEms0Asrzp36bM2l04mvIwd0NZPix9ZoG/4NoqxzLRsjhDGTC8MdKfhLLVJvmO++s9nGkS32hr+oAp5XmZjXPwe6FDqpRXN1RCrpFH9xDC/I4R2U0XDPt3apRHQDa0=";
//            BasicSessionCredentials awsCreds = new BasicSessionCredentials("access_key_id", "secret_key_id", "session_token");
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "us-east-1"))
//                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                    .build();
            try {
                File file = new File(filePath);
                PutObjectRequest request = new PutObjectRequest(bucketName, keyName, file);
                s3Client.putObject(request);
                System.out.println("File uploaded successfully to S3 bucket.");
            } catch (AmazonServiceException e) {
                e.printStackTrace();
            } catch (SdkClientException e) {
                e.printStackTrace();
            }
        }
    //==========================================================

    public void S3UploaderForSOH(String sCurrentDate1) {
        String env = applicationConfig.getWebElementEnviroment().getEnv();
        if(env.equalsIgnoreCase("com.morrisons.instore.uat")){
            env = "uat";
        }
        else if (env.equalsIgnoreCase("com.morrisons.instore.sit")){
            env = "sit";
        }
        String bucketName = "m" + env + ".xxwmm.stockv2.reader.eeeeeeeeee";
        LocalDateTime currentDate1 = LocalDateTime.now();
        String keyName = "Stockv2reader/Stockv2ReaderSOH/freshstocks/pending/" + sCurrentDate1;
        String filePath = System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sCurrentDate1;

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "eu-west-1"))
                .withCredentials(new ProfileCredentialsProvider())
                .build();
        // s3Client = new AmazonS3Client(DefaultAWSCredentialsProviderChain.getInstance());
//            String access_key_id = "ASIAQJSHSDLWTGJ2VVOM";
//            String secret_key_id = "MIfNz20860LdompqHhntPD+rUGsyk/Jmh/szuCJS";
//            String session_token = "IQoJb3JpZ2luX2VjEKf//////////wEaCWV1LXdlc3QtMSJHMEUCIQDTLkzUD93VosF1j8PUFP13FmQBKuCLwSSMSBgdGNeuvwIgM6Ia9oFTEL6kCifmOMzqo/96XbB3/cKm7b4e0x8HoxEqowMIkP//////////ARADGgwwMjA1NTExNzg5ODkiDM3q/Vi2RTiqqqtS9Sr3Au31pN09225SW1uGLW3yHQQty8II75NTevdrBpgYsn45Qwql/AZVaAzFc1fjoN56PJJcvusxW+C0iPoEXsMTbqFZilZC9xO9HTWwqhtJrPWQXyeoEVzBqmAHrdvN7myYKTrwMbb2CUaBmuogOCOHvbm5Z9aJ1o4BRZyNPp/Zx8PAh0mSLLbspYm7/5rvihFUt8EoBRheyeYpPZFmK11XfhKNXvwYR0O5//OylHpYOy/ks9wNoe1TV97SPuQTclorq3Zep+kxh/cQPsXmKnx9XM6XfrMfHXaCxahM3wsDdL12zVio8XHJhYl4kS3dBOdtq/7FLc+UzJFSz7m3hragaICnHass1J3bDFlqYMwEtevU+HKSBvfwxNTsXrwjlJUv6xWX9j59gm5Yki6IQLoqmALDbIqTnnMS8lrjqPgJpClamOrJJu8sl3XLNyp2qjI8Lb6rdGwCea96xKuMHSce7MCWWXCxWm5CNfa88+LRo/zWSrUuYtJTNzCzudChBjqmAROW+seeotbO91Z+kayVSi3k7MvpXs7M1U4jYqWBlnBX5CzffU8pm+jAArI4VsLl60OptTuF8zRGVaIXsjOlBw+1VY4C1JrMOtEms0Asrzp36bM2l04mvIwd0NZPix9ZoG/4NoqxzLRsjhDGTC8MdKfhLLVJvmO++s9nGkS32hr+oAp5XmZjXPwe6FDqpRXN1RCrpFH9xDC/I4R2U0XDPt3apRHQDa0=";
//            BasicSessionCredentials awsCreds = new BasicSessionCredentials("access_key_id", "secret_key_id", "session_token");
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "us-east-1"))
//                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                    .build();
        try {
            File file = new File(filePath);
            PutObjectRequest request = new PutObjectRequest(bucketName, keyName, file);
            s3Client.putObject(request);
            System.out.println("File uploaded successfully to S3 bucket.");
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

        public void AWS_RunECSTask(String TaskName, String containerOverridesVal, String clusterName, String launchType, String logGroupName, String logStreamNamePrefix) throws InterruptedException {
            //====================================================
            AmazonECS client = AmazonECSClientBuilder.standard()
                    .withRegion("eu-west-1")
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();
//.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("sqs.eu-west-1.amazonaws.com", "eu-west-1"))

            //CreateServiceRequest request = new CreateServiceRequest().withServiceName("ecs-simple-service").withTaskDefinition("hello_world").withDesiredCount(10);
            //CreateServiceResult response = client.createService(request);//AmazonECS client = AmazonECSClientBuilder.standard().build();
//            CreateServiceRequest request = new CreateServiceRequest()
//                    .withServiceName("ecs-simple-service-elb")
//                    .withTaskDefinition("storewalkcountsprocessor_task_sit")
//                    .withCluster("nonprod-ECS-ECSCluster-W68V9ZHCS399")
//                    .withLoadBalancers(
//                            new LoadBalancer().withLoadBalancerName("EC2Contai-EcsElast-15DCDAURT3ZO2").withContainerName("simple-app").withContainerPort(80))
//                    .withDesiredCount(10).withRole("ecsServiceRole");
//            CreateServiceResult response = client.createService(request);
//            CreateClusterRequest cluster = new CreateClusterRequest().withClusterName("nonprod-ECS-ECSCluster-W68V9ZHCS399");
//            CreateClusterResult cluster1 = client.createCluster(cluster);

            TaskOverride overrides = new TaskOverride();
            ContainerOverride containerOverrides = new ContainerOverride();
            containerOverrides.setName(TaskName);
            LocalDate currentDate = LocalDate.now();
            LocalDate currentDateFuture = LocalDate.now().plusDays(7);
            //===========================================
            String[] arrCntner = containerOverridesVal.split(" ");
            if(arrCntner.length > 1){
                containerOverrides.withName("fresh-schedule-loader-task-sit").setCommand(Collections.singleton(arrCntner[0] + " " + currentDate + " " + currentDateFuture + " " + ApplicationContext.STORE_ID));
            }
            else{
                containerOverrides.setCommand(Collections.singleton(containerOverridesVal + currentDate + ",null,null,null,null,null"));
            }
            //==========================================
            overrides.withContainerOverrides(containerOverrides);
            //RunTaskRequest request2 = new RunTaskRequest().withCluster(String.valueOf(cluster)).withTaskDefinition("storewalkcountsprocessor_task_sit");
            RunTaskRequest runTaskRequest = new RunTaskRequest()
                    .withCluster(clusterName)
                    .withTaskDefinition(TaskName)
                    .withOverrides(overrides)
                    .withLaunchType(launchType);
                    //.withLaunchType("FARGATE");
            RunTaskResult response2 = client.runTask(runTaskRequest);
            //====================================================
            String taskArn = response2.getTasks().get(0).getTaskArn();
            String taskStatus = response2.getTasks().get(0).getLastStatus();
            DescribeTasksRequest request = new DescribeTasksRequest().withTasks(taskArn).withCluster(clusterName);
            System.out.println("Task ID - "+ taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() +" Task Staus - "+taskStatus);
            while (!taskStatus.equals("STOPPED")){
                log.info("Waiting for task to be completed");
                Thread.sleep(20000);
                DescribeTasksResult response = client.describeTasks(request);
                taskStatus = response.getTasks().get(0).getLastStatus();
            }
            System.out.println("Task ID - "+ taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() +" Task Staus - "+taskStatus);
            AWSLogsClient logs = new AWSLogsClient().withRegion(Regions.EU_WEST_1);

            DescribeLogStreamsRequest req = new DescribeLogStreamsRequest(logGroupName)
                    .withLogStreamNamePrefix(logStreamNamePrefix);

            DescribeLogStreamsResult res = logs.describeLogStreams(req);

            if(res != null && res.getLogStreams() != null && !res.getLogStreams().isEmpty())
            {
                System.out.println("Log Stream exists, do work here " + res.toString());
            }
            //====================
            ClientConfiguration clientConfig = new ClientConfiguration();

            AWSLogsClientBuilder builder = AWSLogsClientBuilder.standard();
            AWSLogs logsClient = builder.withCredentials( new AWSStaticCredentialsProvider( new ProfileCredentialsProvider().getCredentials() ) )
                    .withRegion( Regions.EU_WEST_1 )
                    .withClientConfiguration( clientConfig ).build();

            DescribeLogStreamsRequest describeLogStreamsRequest = new DescribeLogStreamsRequest().withLogGroupName(logGroupName );
            DescribeLogStreamsResult describeLogStreamsResult = logsClient.describeLogStreams( describeLogStreamsRequest );

            // building a put request log
            for ( LogStream logStream : describeLogStreamsResult.getLogStreams() )
            {
                GetLogEventsRequest getLogEventsRequest = new GetLogEventsRequest()
                        .withLogGroupName( logGroupName )
                        .withLogStreamName( logStream.getLogStreamName() );

                GetLogEventsResult result = logsClient.getLogEvents( getLogEventsRequest );

                result.getEvents().forEach( outputLogEvent -> {
                    System.out.println( outputLogEvent.getMessage() );
                } );

            }

            //===========================

        }

        //==============================================
        public void AWS_RunECSTask_ClusterVPC(String TaskName, String containerOverridesVal, String clusterName, String launchType, String logGroupName, String logStreamNamePrefix) throws InterruptedException, IOException {
            //====================================================
            AmazonECS client = AmazonECSClientBuilder.standard()
                    .withRegion("eu-west-1")
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();
//.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("sqs.eu-west-1.amazonaws.com", "eu-west-1"))

            //CreateServiceRequest request = new CreateServiceRequest().withServiceName("ecs-simple-service").withTaskDefinition("hello_world").withDesiredCount(10);
            //CreateServiceResult response = client.createService(request);//AmazonECS client = AmazonECSClientBuilder.standard().build();
//            CreateServiceRequest request = new CreateServiceRequest()
//                    .withServiceName("ecs-simple-service-elb")
//                    .withTaskDefinition("storewalkcountsprocessor_task_sit")
//                    .withCluster("nonprod-ECS-ECSCluster-W68V9ZHCS399")
//                    .withLoadBalancers(
//                            new LoadBalancer().withLoadBalancerName("EC2Contai-EcsElast-15DCDAURT3ZO2").withContainerName("simple-app").withContainerPort(80))
//                    .withDesiredCount(10).withRole("ecsServiceRole");
//            CreateServiceResult response = client.createService(request);
//            CreateClusterRequest cluster = new CreateClusterRequest().withClusterName("nonprod-ECS-ECSCluster-W68V9ZHCS399");
//            CreateClusterResult cluster1 = client.createCluster(cluster);
            Timestamp sStart = new Timestamp(System.currentTimeMillis());
            String subnets[] ={"subnet-0075af7ea30926420","subnet-0269a4e0320a15f04","subnet-03eb6eb99457e1589"};
            List<String> subnetList = Arrays.asList(subnets);
            String securityGrp[] ={"sg-078193ad801aaabcf"};
            List<String> securityGrpList = Arrays.asList(securityGrp);
            AwsVpcConfiguration awsvpcConfiguration = new AwsVpcConfiguration();
            awsvpcConfiguration.setSubnets(subnetList);
            awsvpcConfiguration.setSecurityGroups(securityGrpList);
            NetworkConfiguration networkConfiguration = new NetworkConfiguration();
            networkConfiguration.setAwsvpcConfiguration(awsvpcConfiguration);
            //RunTaskRequest request2 = new RunTaskRequest().withCluster(String.valueOf(cluster)).withTaskDefinition("storewalkcountsprocessor_task_sit");
            RunTaskRequest runTaskRequest = new RunTaskRequest()
                    .withCluster(clusterName)
                    .withTaskDefinition(TaskName)
                    .withLaunchType(launchType)
                    .withNetworkConfiguration(networkConfiguration);;
            //.withLaunchType("FARGATE");
            RunTaskResult response2 = client.runTask(runTaskRequest);
            //====================================================
            String taskArn = response2.getTasks().get(0).getTaskArn();
            String taskStatus = response2.getTasks().get(0).getLastStatus();
            DescribeTasksRequest request = new DescribeTasksRequest().withTasks(taskArn).withCluster(clusterName);
            System.out.println("Task ID - "+ taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() +" Task Staus - "+taskStatus);
            while (!taskStatus.equals("STOPPED")){
                log.info("Waiting for task to be completed");
                Thread.sleep(20000);
                DescribeTasksResult response = client.describeTasks(request);
                taskStatus = response.getTasks().get(0).getLastStatus();
            }
            Timestamp sEnd = new Timestamp(System.currentTimeMillis());
            String sToken;
            boolean sLogSts = false;
            for(int iTry = 0;iTry<3;iTry++ ) {
                AtomicBoolean bTaskSts = new AtomicBoolean(false);
             try{
                 sToken = taskArn.substring(taskArn.lastIndexOf('/') + 1).trim();
                System.out.println("Task ID - " + taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() + " Task Staus - " + taskStatus);
                AWSLogsClient logs = new AWSLogsClient().withRegion(Regions.EU_WEST_1);

                DescribeLogStreamsRequest req = new DescribeLogStreamsRequest(logGroupName)
                        .withLogStreamNamePrefix(logStreamNamePrefix);

                DescribeLogStreamsResult res = logs.describeLogStreams(req);

                if (res != null && res.getLogStreams() != null && !res.getLogStreams().isEmpty()) {
                    System.out.println("Log Stream exists, do work here " + res.toString());
                }
//            //====================
                ClientConfiguration clientConfig = new ClientConfiguration();

                AWSLogsClientBuilder builder = AWSLogsClientBuilder.standard();
                AWSLogs logsClient = builder.withCredentials(new AWSStaticCredentialsProvider(new ProfileCredentialsProvider().getCredentials()))
                        .withRegion(Regions.EU_WEST_1)
                        .withClientConfiguration(clientConfig).build();

                DescribeLogStreamsRequest describeLogStreamsRequest = new DescribeLogStreamsRequest().withLogGroupName(logGroupName)
                        .withOrderBy(com.amazonaws.services.logs.model.OrderBy.LastEventTime)
                        .withDescending(true);
                DescribeLogStreamsResult describeLogStreamsResult = logsClient.describeLogStreams(describeLogStreamsRequest);
                List<LogStream> logStream1 = describeLogStreamsResult.getLogStreams();
                int temp;
                String sLogStreamName = null;
                for(int iStrm = 0;iStrm<logStream1.size();iStrm++){
                    if(logStream1.get(iStrm).getLogStreamName().contains(sToken)){
                        sLogStreamName = logStream1.get(iStrm).getLogStreamName();
                        sLogSts = true;
                        break;
                    }
                }
                if(iTry >=3 && sLogSts==false){
                    Assert.assertTrue(sLogSts,"Log file didn't get generated for Task id" + sToken);
                }
                GetLogEventsRequest getLogEventsRequest = new GetLogEventsRequest()
                        .withLogGroupName(logGroupName)
                        .withLogStreamName(sLogStreamName);
                GetLogEventsResult result = logsClient.getLogEvents(getLogEventsRequest);
                System.out.println(result.getEvents().size());
                result.getEvents().forEach(outputLogEvent -> {
                    try {
                        System.out.println(outputLogEvent.getMessage());
                        String sMsg = outputLogEvent.getMessage();
                        System.out.println("Job Id..... " + sMsg);
                        String[] arrMsg = sMsg.split(",");
                        for (int j = 0; j < arrMsg.length; j++) {
                            if (arrMsg[j].contains("jobId") && sMsg.contains("_" + ApplicationContext.STORE_ID + "_")) {
                                String[] arrField = arrMsg[j].split("=");
                                String sFieldData = arrField[1];
                                API_ServiceStepDef.sRespData.put("jobId", sFieldData);
                            }
                            if (arrMsg[j].contains("file")) {
                                String[] arrField = arrMsg[j].split("=");
                                String sFileName = arrField[1];
                                if (sFileName.contains(".csv") && sFileName.contains("_" + ApplicationContext.STORE_ID + "_")) {
                                    bTaskSts.set(true);
                                    API_ServiceStepDef.sRespData.put("file", sFileName.trim());
                                    System.out.println("Job id and output file captured : " + API_ServiceStepDef.sRespData.get("jobId") + " " + API_ServiceStepDef.sRespData.get("file"));
                                    break;
                                }
                            }
                                if (arrMsg[j].contains("product_full")) {
                                    String sFileName1 = arrMsg[j];
                                    int start = sFileName1.indexOf("product_full_");
                                    int end = sFileName1.indexOf(".csv");
                                    sFileName1 = sFileName1.substring(start,end+4);
                                        bTaskSts.set(true);
                                        API_ServiceStepDef.sRespData.put("file", sFileName1.trim());
                                        System.out.println("Job id and output file captured : " + API_ServiceStepDef.sRespData.get("jobId") + " " + API_ServiceStepDef.sRespData.get("file"));
                                        break;
                                }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Continue");
                });
            }
              catch(Exception ee){
               System.out.println("Exception is " + ee);
              }
             if(bTaskSts.get() == true){
                 break;
             }
            }
            Thread.sleep(20000);
        }
    //==================================================
        public void getS3Uploader(String sCurrentDate1) {
            String env = applicationConfig.getWebElementEnviroment().getEnv();
            if(env.equalsIgnoreCase("com.morrisons.instore.uat")){
                env = "uat";
            }
            else if (env.equalsIgnoreCase("com.morrisons.instore.sit")){
                env = "sit";
            }
            String bucketName = "m" + env + ".xxwmm.stockv2.reader.eeeeeeeeee";
            LocalDateTime currentDate1 = LocalDateTime.now();
            String keyName = "Stockv2reader/Stockv2ReaderSOH/freshstocks/pending/" + sCurrentDate1;
            String filePath = System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sCurrentDate1;

            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "eu-west-1"))
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();
            // s3Client = new AmazonS3Client(DefaultAWSCredentialsProviderChain.getInstance());
//            String access_key_id = "ASIAQJSHSDLWTGJ2VVOM";
//            String secret_key_id = "MIfNz20860LdompqHhntPD+rUGsyk/Jmh/szuCJS";
//            String session_token = "IQoJb3JpZ2luX2VjEKf//////////wEaCWV1LXdlc3QtMSJHMEUCIQDTLkzUD93VosF1j8PUFP13FmQBKuCLwSSMSBgdGNeuvwIgM6Ia9oFTEL6kCifmOMzqo/96XbB3/cKm7b4e0x8HoxEqowMIkP//////////ARADGgwwMjA1NTExNzg5ODkiDM3q/Vi2RTiqqqtS9Sr3Au31pN09225SW1uGLW3yHQQty8II75NTevdrBpgYsn45Qwql/AZVaAzFc1fjoN56PJJcvusxW+C0iPoEXsMTbqFZilZC9xO9HTWwqhtJrPWQXyeoEVzBqmAHrdvN7myYKTrwMbb2CUaBmuogOCOHvbm5Z9aJ1o4BRZyNPp/Zx8PAh0mSLLbspYm7/5rvihFUt8EoBRheyeYpPZFmK11XfhKNXvwYR0O5//OylHpYOy/ks9wNoe1TV97SPuQTclorq3Zep+kxh/cQPsXmKnx9XM6XfrMfHXaCxahM3wsDdL12zVio8XHJhYl4kS3dBOdtq/7FLc+UzJFSz7m3hragaICnHass1J3bDFlqYMwEtevU+HKSBvfwxNTsXrwjlJUv6xWX9j59gm5Yki6IQLoqmALDbIqTnnMS8lrjqPgJpClamOrJJu8sl3XLNyp2qjI8Lb6rdGwCea96xKuMHSce7MCWWXCxWm5CNfa88+LRo/zWSrUuYtJTNzCzudChBjqmAROW+seeotbO91Z+kayVSi3k7MvpXs7M1U4jYqWBlnBX5CzffU8pm+jAArI4VsLl60OptTuF8zRGVaIXsjOlBw+1VY4C1JrMOtEms0Asrzp36bM2l04mvIwd0NZPix9ZoG/4NoqxzLRsjhDGTC8MdKfhLLVJvmO++s9nGkS32hr+oAp5XmZjXPwe6FDqpRXN1RCrpFH9xDC/I4R2U0XDPt3apRHQDa0=";
//            BasicSessionCredentials awsCreds = new BasicSessionCredentials("access_key_id", "secret_key_id", "session_token");
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "us-east-1"))
//                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                    .build();
            try {
                File file = new File(filePath);
                GetObjectRequest request = new GetObjectRequest(bucketName, keyName, String.valueOf(file));
                S3Object oFile = s3Client.getObject(request);
                System.out.println("File uploaded successfully to S3 bucket.");
            } catch (AmazonServiceException e) {
                e.printStackTrace();
            } catch (SdkClientException e) {
                e.printStackTrace();
            }
        }

    public void S3getOutPutFile(String bucketName, String keyName, String filePath, String sFileName) throws InterruptedException, IOException {
            String env = applicationConfig.getWebElementEnviroment().getEnv();
        if (env.equalsIgnoreCase("com.morrisons.instore.uat")) {
            env = "uat";
        } else if (env.equalsIgnoreCase("com.morrisons.instore.sit")) {
            env = "sit";
        }
        bucketName = "m" + env + "." + bucketName;
        LocalDateTime currentDate1 = LocalDateTime.now();
        keyName = keyName + sFileName;
        AmazonS3 s3Client;
        //filePath = filePath + sFileName;
        System.out.println("Job id and output file captured from log file under CloudWatch: " + API_ServiceStepDef.sRespData.get("jobId") + " " + API_ServiceStepDef.sRespData.get("file"));
        //===============================================
//        final AmazonIdentityManagement iam =
//                AmazonIdentityManagementClientBuilder.defaultClient();
//
//        CreateAccessKeyRequest request = new CreateAccessKeyRequest()
//                .withUserName(user);
//
//        CreateAccessKeyResult response = iam.createAccessKey(request);
        //=================================================
        File file = new File("C://Users//Swati1500583//.aws//Credentials.txt");

        if(!keyName.contains("product-adaptor")) {
            s3Client = getTempToken(file);
        }
        else{
           s3Client = AmazonS3ClientBuilder.standard()
                   .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "eu-west-1"))
                   .withCredentials(new ProfileCredentialsProvider())
                   .build();
       }

        // s3Client = new AmazonS3Client(DefaultAWSCredentialsProviderChain.getInstance());
//            String access_key_id = "ASIAQJSHSDLWTGJ2VVOM";
//            String secret_key_id = "MIfNz20860LdompqHhntPD+rUGsyk/Jmh/szuCJS";
//            String session_token = "IQoJb3JpZ2luX2VjEKf//////////wEaCWV1LXdlc3QtMSJHMEUCIQDTLkzUD93VosF1j8PUFP13FmQBKuCLwSSMSBgdGNeuvwIgM6Ia9oFTEL6kCifmOMzqo/96XbB3/cKm7b4e0x8HoxEqowMIkP//////////ARADGgwwMjA1NTExNzg5ODkiDM3q/Vi2RTiqqqtS9Sr3Au31pN09225SW1uGLW3yHQQty8II75NTevdrBpgYsn45Qwql/AZVaAzFc1fjoN56PJJcvusxW+C0iPoEXsMTbqFZilZC9xO9HTWwqhtJrPWQXyeoEVzBqmAHrdvN7myYKTrwMbb2CUaBmuogOCOHvbm5Z9aJ1o4BRZyNPp/Zx8PAh0mSLLbspYm7/5rvihFUt8EoBRheyeYpPZFmK11XfhKNXvwYR0O5//OylHpYOy/ks9wNoe1TV97SPuQTclorq3Zep+kxh/cQPsXmKnx9XM6XfrMfHXaCxahM3wsDdL12zVio8XHJhYl4kS3dBOdtq/7FLc+UzJFSz7m3hragaICnHass1J3bDFlqYMwEtevU+HKSBvfwxNTsXrwjlJUv6xWX9j59gm5Yki6IQLoqmALDbIqTnnMS8lrjqPgJpClamOrJJu8sl3XLNyp2qjI8Lb6rdGwCea96xKuMHSce7MCWWXCxWm5CNfa88+LRo/zWSrUuYtJTNzCzudChBjqmAROW+seeotbO91Z+kayVSi3k7MvpXs7M1U4jYqWBlnBX5CzffU8pm+jAArI4VsLl60OptTuF8zRGVaIXsjOlBw+1VY4C1JrMOtEms0Asrzp36bM2l04mvIwd0NZPix9ZoG/4NoqxzLRsjhDGTC8MdKfhLLVJvmO++s9nGkS32hr+oAp5XmZjXPwe6FDqpRXN1RCrpFH9xDC/I4R2U0XDPt3apRHQDa0=";
//            BasicSessionCredentials awsCreds = new BasicSessionCredentials("access_key_id", "secret_key_id", "session_token");
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "us-east-1"))
//                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                    .build();
        try {
            // File file = new File(filePath);
            GetObjectRequest request = new GetObjectRequest(bucketName, keyName);
            System.out.println(request.getKey());
            char[] destArray = new char[20];
            request.getKey().getChars(0, 10, destArray, 1);
            System.out.println(destArray);
            String key_name = request.getKey();
            S3Object o = s3Client.getObject(request);
            S3ObjectInputStream s3is = o.getObjectContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(o.getObjectContent()));
            String line = reader.readLine();
            System.out.println(line + "   ");
// this will store characters of first row in array
            String row[] = line.split(",");
            int length = row.length;
            for (int i = 0; i < length; i++) {
                System.out.print(row[i] + "   ");
                arrOutputFieldData.add(row[i]);
            }
//            BufferedInputStream buffer7 = new BufferedInputStream(s3is);
            //===================
            int iCtr = 0;
            while ((line = reader.readLine()) != null) {
                try{
                   LinkedHashMap<String,String> ChildarrInputData = new LinkedHashMap<String,String>();
                System.out.println(reader.readLine() + "   ");
                // storing characters of corresponding line in an array
                String value[] = line.split(",");
                for (int i = 0; i < length; i++) {
                    System.out.print(value[i] + "   ");
                    ChildarrInputData.put( iCtr+ "|" + row[i],value[i]);
                }
                arrInputData.put(ChildarrInputData.get(iCtr+ "|itemNumber"),ChildarrInputData);
                System.out.println();
//            int i = buffer7.read();
//
//            while (i != -1) {
//                System.out.print((char) i);
//                // log.info(String.valueOf((char) i));
//                // Reads next byte from the file
//                i = buffer7.read();
//            }
            }
            catch(ArrayIndexOutOfBoundsException ae){

            }
                if(iCtr>10){
                    break;
                }
                iCtr++;
            }
        }catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(arrInputData.size()==0 && RunCtr < 4){
            S3getOutPutFile(bucketName, keyName, filePath, sFileName);
        }
        RunCtr++;
    }

    private AmazonS3 getTempToken(File file) throws IOException {
        BufferedReader rr = new BufferedReader(new FileReader(file));
        String st = rr.readLine(), access_key_id, secret_key_id, session_token;
        st = rr.readLine();
        String[] arrSt = st.split("=");
        access_key_id = arrSt[1];
        st = rr.readLine();
        arrSt = st.split("=");
        secret_key_id = arrSt[1];
        st = rr.readLine();
        arrSt = st.split("=");
        session_token = arrSt[1];
        BasicSessionCredentials awsCreds = new BasicSessionCredentials(access_key_id, secret_key_id, session_token);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "eu-west-1"))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
        return s3Client;
    }

    //====================================================
    public void S3uploadInputFile(String bucketName, String keyName, String filePath, String sFileName) {
        String env = applicationConfig.getWebElementEnviroment().getEnv();
        if(env.equalsIgnoreCase("com.morrisons.instore.uat")){
            env = "uat";
        }
        else if (env.equalsIgnoreCase("com.morrisons.instore.sit")){
            env = "sit";
        }
        bucketName = "m" + env + "." + bucketName;
        LocalDateTime currentDate1 = LocalDateTime.now();
        keyName = keyName + sFileName;
        filePath = System.getProperty("user.dir") + "//src//test//resources//TestData//Output//" + sFileName;

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "eu-west-1"))
                .withCredentials(new ProfileCredentialsProvider())
                .build();
        // s3Client = new AmazonS3Client(DefaultAWSCredentialsProviderChain.getInstance());
//            String access_key_id = "ASIAQJSHSDLWTGJ2VVOM";
//            String secret_key_id = "MIfNz20860LdompqHhntPD+rUGsyk/Jmh/szuCJS";
//            String session_token = "IQoJb3JpZ2luX2VjEKf//////////wEaCWV1LXdlc3QtMSJHMEUCIQDTLkzUD93VosF1j8PUFP13FmQBKuCLwSSMSBgdGNeuvwIgM6Ia9oFTEL6kCifmOMzqo/96XbB3/cKm7b4e0x8HoxEqowMIkP//////////ARADGgwwMjA1NTExNzg5ODkiDM3q/Vi2RTiqqqtS9Sr3Au31pN09225SW1uGLW3yHQQty8II75NTevdrBpgYsn45Qwql/AZVaAzFc1fjoN56PJJcvusxW+C0iPoEXsMTbqFZilZC9xO9HTWwqhtJrPWQXyeoEVzBqmAHrdvN7myYKTrwMbb2CUaBmuogOCOHvbm5Z9aJ1o4BRZyNPp/Zx8PAh0mSLLbspYm7/5rvihFUt8EoBRheyeYpPZFmK11XfhKNXvwYR0O5//OylHpYOy/ks9wNoe1TV97SPuQTclorq3Zep+kxh/cQPsXmKnx9XM6XfrMfHXaCxahM3wsDdL12zVio8XHJhYl4kS3dBOdtq/7FLc+UzJFSz7m3hragaICnHass1J3bDFlqYMwEtevU+HKSBvfwxNTsXrwjlJUv6xWX9j59gm5Yki6IQLoqmALDbIqTnnMS8lrjqPgJpClamOrJJu8sl3XLNyp2qjI8Lb6rdGwCea96xKuMHSce7MCWWXCxWm5CNfa88+LRo/zWSrUuYtJTNzCzudChBjqmAROW+seeotbO91Z+kayVSi3k7MvpXs7M1U4jYqWBlnBX5CzffU8pm+jAArI4VsLl60OptTuF8zRGVaIXsjOlBw+1VY4C1JrMOtEms0Asrzp36bM2l04mvIwd0NZPix9ZoG/4NoqxzLRsjhDGTC8MdKfhLLVJvmO++s9nGkS32hr+oAp5XmZjXPwe6FDqpRXN1RCrpFH9xDC/I4R2U0XDPt3apRHQDa0=";
//            BasicSessionCredentials awsCreds = new BasicSessionCredentials("access_key_id", "secret_key_id", "session_token");
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("s3.amazonaws.com", "us-east-1"))
//                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                    .build();
        try {
            File file = new File(filePath);
            PutObjectRequest request = new PutObjectRequest(bucketName, keyName, file);
            s3Client.putObject(request);
            System.out.println("File uploaded successfully to S3 bucket.");
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

    //==========================================
    public void AWS_UpdateECSTask(String TaskName, String containerOverridesVal, String clusterName, String launchType, String logGroupName, String logStreamNamePrefix) throws InterruptedException {
        //====================================================
        String clusterName1 = "nonprod-ECS-ECSCluster-W68V9ZHCS399";
        String serviceArn = "stock-order-service-sit";
        AmazonECS client = AmazonECSClientBuilder.standard()
                .withRegion("eu-west-1")
                .withCredentials(new ProfileCredentialsProvider())
                .build();
        EcsClient ecsClient = EcsClient.builder()
                .region(Region.of("eu-west-1"))
                .build();

        UpdateServiceRequest serviceRequest = UpdateServiceRequest.builder()
                .cluster(clusterName1)
                .service(serviceArn)
                .desiredCount(0)
                .build();
        UpdateServiceResponse response2 = ecsClient.updateService(serviceRequest);

//        response2.getValueForField("status");
        //====================================================


        //===========================

    }

    public void AWS_RunECSTask_ClusterVPC(String TaskName, String containerOverridesVal, String clusterName, String launchType, String logGroupName, String logStreamNamePrefix, String subnets1, String securityGrp1) throws InterruptedException {
        {
            //====================================================
            AmazonECS client = AmazonECSClientBuilder.standard()
                    .withRegion("eu-west-1")
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();
//.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("sqs.eu-west-1.amazonaws.com", "eu-west-1"))

            //CreateServiceRequest request = new CreateServiceRequest().withServiceName("ecs-simple-service").withTaskDefinition("hello_world").withDesiredCount(10);
            //CreateServiceResult response = client.createService(request);//AmazonECS client = AmazonECSClientBuilder.standard().build();
//            CreateServiceRequest request = new CreateServiceRequest()
//                    .withServiceName("ecs-simple-service-elb")
//                    .withTaskDefinition("storewalkcountsprocessor_task_sit")
//                    .withCluster("nonprod-ECS-ECSCluster-W68V9ZHCS399")
//                    .withLoadBalancers(
//                            new LoadBalancer().withLoadBalancerName("EC2Contai-EcsElast-15DCDAURT3ZO2").withContainerName("simple-app").withContainerPort(80))
//                    .withDesiredCount(10).withRole("ecsServiceRole");
//            CreateServiceResult response = client.createService(request);
//            CreateClusterRequest cluster = new CreateClusterRequest().withClusterName("nonprod-ECS-ECSCluster-W68V9ZHCS399");
//            CreateClusterResult cluster1 = client.createCluster(cluster);
            Timestamp sStart = new Timestamp(System.currentTimeMillis());
            String subnets[] ={subnets1};
            List<String> subnetList = Arrays.asList(subnets);
            String securityGrp[] ={"" + securityGrp1 + ""};
            List<String> securityGrpList = Arrays.asList(securityGrp);
            AwsVpcConfiguration awsvpcConfiguration = new AwsVpcConfiguration();
            awsvpcConfiguration.setSubnets(subnetList);
            awsvpcConfiguration.setSecurityGroups(securityGrpList);
            NetworkConfiguration networkConfiguration = new NetworkConfiguration();
            networkConfiguration.setAwsvpcConfiguration(awsvpcConfiguration);
            TaskOverride overrides = new TaskOverride();
            ContainerOverride containerOverrides = new ContainerOverride();
            containerOverrides.setName(TaskName);
            String[] arrCntner = containerOverridesVal.split(" ");
            LocalDate currentDate = LocalDate.now();
            LocalDate currentDateFuture = LocalDate.now().plusDays(7);
//            if(arrCntner.length > 1){
//                containerOverrides.withName("fresh-schedule-loader-task-sit").setCommand(Collections.singleton(arrCntner[0] + " " + currentDate + " " + currentDateFuture + " " + ApplicationContext.STORE_ID));
//            }
//            else{
//                containerOverrides.setCommand(Collections.singleton(containerOverridesVal + currentDate + ",null,null,null,null,null"));
//            }
            overrides.withContainerOverrides(containerOverrides);
            //RunTaskRequest request2 = new RunTaskRequest().withCluster(String.valueOf(cluster)).withTaskDefinition("storewalkcountsprocessor_task_sit");
            RunTaskRequest runTaskRequest = new RunTaskRequest()
                    .withCluster(clusterName)
                    .withTaskDefinition(TaskName)
                    .withOverrides(overrides)
                    .withLaunchType(launchType)
                    .withNetworkConfiguration(networkConfiguration);;
            //.withLaunchType("FARGATE");
            RunTaskResult response2 = client.runTask(runTaskRequest);
            //====================================================
            String taskArn = response2.getTasks().get(0).getTaskArn();
            String taskStatus = response2.getTasks().get(0).getLastStatus();
            DescribeTasksRequest request = new DescribeTasksRequest().withTasks(taskArn).withCluster(clusterName);
            System.out.println("Task ID - "+ taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() +" Task Staus - "+taskStatus);
            while (!taskStatus.equals("STOPPED")){
                log.info("Waiting for task to be completed");
                Thread.sleep(20000);
                DescribeTasksResult response = client.describeTasks(request);
                taskStatus = response.getTasks().get(0).getLastStatus();
            }
            Timestamp sEnd = new Timestamp(System.currentTimeMillis());
            String sToken;
            boolean sLogSts = false;
            for(int iTry = 0;iTry<3;iTry++ ) {
                AtomicBoolean bTaskSts = new AtomicBoolean(false);
                try{
                    sToken = taskArn.substring(taskArn.lastIndexOf('/') + 1).trim();
                    System.out.println("Task ID - " + taskArn.substring(taskArn.lastIndexOf('/') + 1).trim() + " Task Staus - " + taskStatus);
                    AWSLogsClient logs = new AWSLogsClient().withRegion(Regions.EU_WEST_1);

                    DescribeLogStreamsRequest req = new DescribeLogStreamsRequest(logGroupName)
                            .withLogStreamNamePrefix(logStreamNamePrefix);

                    DescribeLogStreamsResult res = logs.describeLogStreams(req);

                    if (res != null && res.getLogStreams() != null && !res.getLogStreams().isEmpty()) {
                        System.out.println("Log Stream exists, do work here " + res.toString());
                    }
//            //====================
                    ClientConfiguration clientConfig = new ClientConfiguration();

                    AWSLogsClientBuilder builder = AWSLogsClientBuilder.standard();
                    AWSLogs logsClient = builder.withCredentials(new AWSStaticCredentialsProvider(new ProfileCredentialsProvider().getCredentials()))
                            .withRegion(Regions.EU_WEST_1)
                            .withClientConfiguration(clientConfig).build();

                    DescribeLogStreamsRequest describeLogStreamsRequest = new DescribeLogStreamsRequest().withLogGroupName(logGroupName)
                            .withOrderBy(com.amazonaws.services.logs.model.OrderBy.LastEventTime)
                            .withDescending(true);
                    DescribeLogStreamsResult describeLogStreamsResult = logsClient.describeLogStreams(describeLogStreamsRequest);
                    List<LogStream> logStream1 = describeLogStreamsResult.getLogStreams();
                    int temp;
                    String sLogStreamName = null;
                    for(int iStrm = 0;iStrm<logStream1.size();iStrm++){
                        if(logStream1.get(iStrm).getLogStreamName().contains(sToken)){
                            sLogStreamName = logStream1.get(iStrm).getLogStreamName();
                            sLogSts = true;
                            break;
                        }
                    }
                    if(iTry >=3 && sLogSts==false){
                        Assert.assertTrue(sLogSts,"Log file didn't get generated for Task id" + sToken);
                    }
                    GetLogEventsRequest getLogEventsRequest = new GetLogEventsRequest()
                            .withLogGroupName(logGroupName)
                            .withLogStreamName(sLogStreamName);
                    GetLogEventsResult result = logsClient.getLogEvents(getLogEventsRequest);
                    System.out.println(result.getEvents().size());
                    result.getEvents().forEach(outputLogEvent -> {
                        try {
                            System.out.println(outputLogEvent.getMessage());
                            String sMsg = outputLogEvent.getMessage();
                            System.out.println("Job Id..... " + sMsg);
                            String[] arrMsg = sMsg.split(",");
                            for (int j = 0; j < arrMsg.length; j++) {
                                if (arrMsg[j].contains("jobId") && sMsg.contains("_" + ApplicationContext.STORE_ID + "_")) {
                                    String[] arrField = arrMsg[j].split("=");
                                    String sFieldData = arrField[1];
                                    API_ServiceStepDef.sRespData.put("jobId", sFieldData);
                                }
                                if (arrMsg[j].contains("file")) {
                                    String[] arrField = arrMsg[j].split("=");
                                    String sFileName = arrField[1];
                                    if (sFileName.contains(".csv") && sFileName.contains("_" + ApplicationContext.STORE_ID + "_")) {
                                        bTaskSts.set(true);
                                        API_ServiceStepDef.sRespData.put("file", sFileName.trim());
                                        System.out.println("Job id and output file captured : " + API_ServiceStepDef.sRespData.get("jobId") + " " + API_ServiceStepDef.sRespData.get("file"));
                                        break;
                                    }
                                }
                                if (arrMsg[j].contains("product_full")) {
                                    String sFileName1 = arrMsg[j];
                                    int start = sFileName1.indexOf("product_full_");
                                    int end = sFileName1.indexOf(".csv");
                                    sFileName1 = sFileName1.substring(start,end+4);
                                    bTaskSts.set(true);
                                    API_ServiceStepDef.sRespData.put("file", sFileName1.trim());
                                    System.out.println("Job id and output file captured : " + API_ServiceStepDef.sRespData.get("jobId") + " " + API_ServiceStepDef.sRespData.get("file"));
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Continue");
                    });
                }
                catch(Exception ee){
                    System.out.println("Exception is " + ee);
                }
                if(bTaskSts.get() == true){
                    break;
                }
            }
            Thread.sleep(20000);
        }
    }

    //================================================

}
