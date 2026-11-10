package com.morrisons.sma.step_definitions.service.cleanAndRotate;

import com.google.inject.Inject;
import com.morrisons.common.helper.CommonHelperMethods;
import com.morrisons.common.utility.ApplicationContext;
import com.morrisons.common.utility.WebServicesUtilities;
import com.morrisons.sma.page_objects.service.StorewalkServicePage;
import com.morrisons.sma.page_objects.service.cleanAndRotate.DepartmentService;
import com.morrisons.sma.pojo.service.cleanAndRotate.getDepartments.DepartmentResponse;
import com.morrisons.sma.step_definitions.mobile.cleanAndRotate.GetDeptAndMin;
import com.morrisons.sma.step_definitions.service.Login.LoginStepDef;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class DepartmentServiceStepDef {
    public static final String DEPARTMENT_SERVICE_BASE_URL = "https://sit-api.morrisons.com/cleanrotate/v1";
    private final Logger log = Logger.getLogger(DepartmentServiceStepDef.class);
    private final ApplicationContext applicationContext;
    public static String departmentCheckId;
    public static int departmentId;
    public static String departmentName, nextCheck, status;

    @Inject
    public DepartmentServiceStepDef(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Given("I get the department details through API")
    public void iGetTheDepartmentDetails() throws Throwable {
        log.info("Getting Response for " + DEPARTMENT_SERVICE_BASE_URL + "/locations/" + ApplicationContext.STORE_ID + "/departments/");
        String weekNumber = CommonHelperMethods.getWeekoftheyear();
        String yearNumber = CommonHelperMethods.getYear();
        log.info("Week Number------------" + weekNumber);
        log.info("Year Number-------------" + yearNumber);
//        String accessToken = LoginStepDef.accessToken;
        StorewalkServicePage oStrWalkser = new StorewalkServicePage();
        String accessToken = oStrWalkser.getGeneratedAccessTokenAppLogin();
        log.info("Access Token received in GetDepartment service-------------" + accessToken);

        String jsonResponseString = WebServicesUtilities.retryGETRequestWithHeader(DEPARTMENT_SERVICE_BASE_URL, "/locations/" + ApplicationContext.STORE_ID + "/departments", "apikey", "ZwQGsEN0f65kORZ8EVQlJWA2bGNbHls0", "week", weekNumber, "year", yearNumber, "Authorization", "Bearer " + accessToken);
        log.info("GetDepartment service Json response" + jsonResponseString);


        List<DepartmentResponse> departmentList = new DepartmentService().getDepartmentResponse(jsonResponseString);
        log.info("No. Of Departments : " + departmentList.size());

        for (int deptIndex = 0; deptIndex <= departmentList.size() - 1; deptIndex++) {
            log.info("No. Of Departments name : " + departmentList.get(deptIndex).getDepartmentName());
            if (departmentList.get(deptIndex).getDepartmentName().equalsIgnoreCase(GetDeptAndMin.departmentNameUI)) {

                departmentId = departmentList.get(deptIndex).getDepartmentId();
                log.info("Department ID : " + departmentId);

                departmentCheckId = String.valueOf(departmentList.get(deptIndex).getDepartmentCheckId());
                log.info("Department CheckId : " + departmentCheckId);

                departmentName = departmentList.get(deptIndex).getDepartmentName();
                log.info("Department Name : " + departmentName);

                nextCheck = departmentList.get(deptIndex).getNextCheck();
                log.info("Next Check : " + nextCheck);

                status = departmentList.get(deptIndex).getStatus();
                log.info("Department Status : " + status);
            }
        }
    }
}

