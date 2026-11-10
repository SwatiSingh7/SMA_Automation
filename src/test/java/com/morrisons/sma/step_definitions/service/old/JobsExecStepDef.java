package com.morrisons.sma.step_definitions.service.old;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ecs.AmazonECS;
import com.amazonaws.services.ecs.AmazonECSClientBuilder;
import com.morrisons.sma.page_objects.mobile.old.AWS_S3Upload;
import org.apache.http.HttpResponse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ecs.EcsClient;
import software.amazon.awssdk.services.ecs.model.UpdateServiceRequest;
import software.amazon.awssdk.services.ecs.model.UpdateServiceResponse;

import java.io.IOException;

public class JobsExecStepDef {
    @Given("The ECS Jobs are triggered with Task {string}, containerOverrides {string},ClusterName {string}, LaunchType {string}, LogGroupName {string}, LogStreamNamePrefix {string}")
    public void theECSJobsAreTriggered(String TaskName, String containerOverrides, String ClusterName, String LaunchType, String logGroupName, String LogStreamNamePrefix) throws InterruptedException {
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.AWS_RunECSTask(TaskName, containerOverrides, ClusterName, LaunchType, logGroupName, LogStreamNamePrefix);
    }

    @Given("The ECS Jobs for Cluster VPC are triggered with Task {string}, containerOverrides {string},ClusterName {string}, LaunchType {string}, LogGroupName {string}, LogStreamNamePrefix {string}")
    public void theECSJobsForClusterVPCAreTriggeredWithTaskContainerOverridesClusterNameLaunchTypeLogGroupNameLogStreamNamePrefix(String TaskName, String containerOverrides, String ClusterName, String LaunchType, String logGroupName, String LogStreamNamePrefix) throws InterruptedException, IOException {
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.AWS_RunECSTask_ClusterVPC(TaskName, containerOverrides, ClusterName, LaunchType, logGroupName, LogStreamNamePrefix);
    }

    @Given("I update the service {string} making it down and up with ClusterName {string}")
    public void iUpdateTheServiceMakingItDownAndUp(String serviceArn1, String clusterName) throws InterruptedException {
        String clusterName1 = "nonprod-ECS-ECSCluster-W68V9ZHCS399";
        String serviceArn = "stockV2Adjustment_srv_sit";
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

        Thread.sleep(5000);

        UpdateServiceRequest serviceRequest1 = UpdateServiceRequest.builder()
                .cluster(clusterName1)
                .service(serviceArn)
                .desiredCount(1)
                .build();
        UpdateServiceResponse response = ecsClient.updateService(serviceRequest1);
    }

    @Given("The ECS Jobs are triggered with Task {string}, containerOverrides {string},ClusterName {string}, LaunchType {string}, LogGroupName {string}, LogStreamNamePrefix {string} with subnets {string} with securityGrp {string}")
    public void theECSJobsAreTriggeredWithTaskContainerOverridesClusterNameLaunchTypeLogGroupNameLogStreamNamePrefixWithSubnetsWithSecurityGrp(String TaskName, String containerOverrides, String ClusterName, String LaunchType, String logGroupName, String LogStreamNamePrefix, String subnets, String securityGrp) throws IOException, InterruptedException {
        AWS_S3Upload oAWSObj = new AWS_S3Upload();
        oAWSObj.AWS_RunECSTask_ClusterVPC(TaskName, containerOverrides, ClusterName, LaunchType, logGroupName, LogStreamNamePrefix, subnets, securityGrp);
    }
}