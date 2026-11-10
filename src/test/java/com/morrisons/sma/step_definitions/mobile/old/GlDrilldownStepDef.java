package com.morrisons.sma.step_definitions.mobile.old;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import org.apache.http.HttpResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.GlhDrillDownPO;
import com.morrisons.sma.page_objects.service.GlhSummaryService;

public class GlDrilldownStepDef {


	GlhSummaryService glhSummary_Service = new GlhSummaryService();
	GlhDrillDownPO glhDrillDown_PageObject = new GlhDrillDownPO();

	private AndroidDriver driveR;
	public static String iscomplete;
	public static String windows;

	public static String accessToken = null;
	public static HttpResponse Response;

	public static List<String> gapsTabDeptList = new ArrayList<String>();
	public static List<String> lowsTabDeptList = new ArrayList<String>();
	public static List<String> highsTabDeptList = new ArrayList<String>();

	@When("Get Operation perform on Glh Summary service request")
	public void getServicePerformOperation() throws Throwable {
		Response = glhSummary_Service.getServicePerformOperation();
		System.out.println(Response);
	}
	
	///////////////  Service step defination

	/////// Generating Url for both GLH and MS GLH walktype
	@When("Get request is made to GlhSummary api for Store id {string} and Walktype GLH & Marketstreet GLH")
	public void getGlhSummaryServiceUrlForGLH(String storeid) throws Throwable {
		glhSummary_Service.getGlhSummaryForGLH_MSGlh(storeid);
	}

	/////// Generating Url for GLH/ MS_Glh/ Gaps walktype
	@When("Get request is made to GlhSummary api for Store id {string} and Walktype {string}")
	public void getGlhSummaryServiceUrlForGaps(String storeid,String walkType) throws Throwable {
		glhSummary_Service.getGlhSummaryServiceUrl(storeid,walkType);
	}

	///// Get GLH API summary service response
	@Then("Get Glh Summary service response")
	public void getGlhSummaryResponse() throws Throwable {
		glhSummary_Service.getGlhSummaryResponse();
	}

	/////Get Department list from GLH summary api 
	@Then("Get Department list from Glh Summary service response for Store id {string}")
	public void getGlhSummaryResponse(String storeid) throws Throwable {
		glhSummary_Service.getDepartmentListFromApi(storeid);
	}

	
	
	///// UI scenario step defination

	@Then("I verify Gaps, Count tabs are displayed on summary page")
	public void verifyGapsCountTab() throws Throwable {
		glhDrillDown_PageObject.verifyGapsCountTab();
	}

	@Then("I verify department list is displayed on summary page")
	public void verifyDepartmentList() throws Throwable {
		glhDrillDown_PageObject.verifyDepartmentList();
	}
	//
	@Then("I verify Gaps tab, SR, SF and IC columns are displayed on summary page Header")
	public void verifyGapsSummaryHeaderColumns() throws Throwable {
		glhDrillDown_PageObject.verifyGapsSummaryHeaderColumns();
	}

	@Then("I verify Total count for Gaps , SR, SF and IC columns are displayed on summary page Footer")
	public void verifyGapsSummaryFooter() throws Throwable {
		glhDrillDown_PageObject.verifyGapsSummaryFooter();
	}

	@Then("I verify Count tab, Count and IC columns are displayed on summary page Header")
	public void verifyCountSummaryHeaderColumns() throws Throwable {
		glhDrillDown_PageObject.verifyCountSummaryHeaderColumns();
	}

	@Then("I verify Total count for Count, and IC columns are displayed on summary page Footer")
	public void verifyCountSummaryFooter() throws Throwable {
		glhDrillDown_PageObject.verifyCountSummaryFooter();
	}

	@Then("I verify Counts tab and IC columns are displayed on summary page Header")
	public void verifyHighsSummaryHeaderColumns() throws Throwable {
		glhDrillDown_PageObject.verifyHighsSummaryHeaderColumns();
	}

	@Then("I verify Total count for Highs and IC columns are displayed on summary page Footer")
	public void verifyHighsSummaryFooter() throws Throwable {
		glhDrillDown_PageObject.verifyHighsSummaryFooter();
	}

	@Given("Capture type is {string} and count {string}")
	public void setCaptureType(String captureType,String count) throws Throwable {
		glhDrillDown_PageObject.setCaptureTypeAndCount(captureType, count);
	}

	@Then("I get Department list for Gaps tab on summary page")
	public void getGapsDepartmentList() throws Throwable {
		gapsTabDeptList = glhDrillDown_PageObject.getDepartmentList();
	}

	@Then("I get Department list for Count tab on summary page")
	public void getLowsDepartmentList() throws Throwable {
		lowsTabDeptList = glhDrillDown_PageObject.getDepartmentList();
	}

	@Then("I get Department list for Highs tab on summary page")
	public void getHighsDepartmentList() throws Throwable {
		highsTabDeptList = glhDrillDown_PageObject.getDepartmentList();
	}

	@Then("I get Section list for {string} Dept and Count for sections {string} and {string} department on summary page")
	public void getSectionList(String dept, String section1, String section2) throws Throwable {
		glhDrillDown_PageObject.getSectionList_7(dept,section1,section2);
	}

	@Then("I get Sections {string} and {string} index before scanning the products")
	public void getSectionIndexBefore(String section1,String section2) throws Throwable {
		glhDrillDown_PageObject.getSectionIndexBefore(section1,section2);
	}
	@Then("I get Sections {string} and {string} index after scanning the products")
	public void getSectionIndexAfter(String section1,String section2) throws Throwable {
		glhDrillDown_PageObject.getSectionIndexAfter(section1,section2);
	}

	@Then("I verify after scanning product Sections {string} and {string} are moved to bottom of list")
	public void verifySectionMovedToBottom(String section1, String section2) throws Throwable {
		glhDrillDown_PageObject.verifySectionMovedToBottom(section1,section2);
	}

	@Then("I verify after scanning product Sections {string} and {string} are at the same position in the list")
	public void verifySectionAtSamePosition(String section1, String section2) throws Throwable {
		glhDrillDown_PageObject.verifySectionAtSamePosition(section1,section2);
	}

	//	@Then("I verify Count on summary page Dept {string} and sections {string} and {string} is Gaps {string}, SF {string} and IC {string}")
	//	public void verifyCountOnSummary(String dept, String section1, String section2,int count) throws Throwable {
	//		glhDrillDown_PageObject.verifyCountOnSummary(dept,section1,section2,count);
	//	}


	@Then("I verify Count on summary page for Dept {string} and sections {string} and {string}")
	public void verifyHighsCount(String dept, String section1, String section2) throws Throwable {
		glhDrillDown_PageObject.verifySectionCount(dept,section1,section2);
	}

	@Then("I verify all departments are displayed in the specified static order in all 3 tabs for Gaps,High and Low")
	public void verifyDeptStaticOrder() throws Throwable {
		glhDrillDown_PageObject.verifyDeptStaticOrder(gapsTabDeptList,lowsTabDeptList,highsTabDeptList);
	}

	@Then("I get Sections for corresponding Department list on summary page")
	public void getDepartmentAndSectionsOnUI() throws Throwable {
		glhDrillDown_PageObject.getDepartmentAndSectionsOnUI(gapsTabDeptList);
	}


	/////UI and API verification
	@Then("I Verify all departments which are mapped to GapsHighsLows walktype along with Market Street department on UI and Service matches")
	public void verifyDeptOnUIAndService() throws Throwable {
		glhDrillDown_PageObject.verifyDeptOnUIAndService();
	}

	@Then("I Verify all department sections which are mapped to Market Street department on UI and Service matches")
	public void verifyMSSectionsOnUIAndAPI() throws Throwable {
		glhDrillDown_PageObject.verifyMSSectionsOnUIAndAPI();
	}


	@Then("I click on Gaps tab on summary page")
	public void clickOnGapsTab() throws Throwable {
		glhDrillDown_PageObject.clickOnGapsTab();
	}

	@Then("I click on Lows tab on summary page")
	public void clickOnLowsTab() throws Throwable {
		glhDrillDown_PageObject.clickOnLowsTab();
	}

	@Then("I click on Highs tab on summary page")
	public void clickOnHighsTab() throws Throwable {
		glhDrillDown_PageObject.clickOnHighsTab();
	}

	@Then("I verify all departments with right arrow indicator is displayed on summary page")
	public void verifyRightArrowIndicator() throws Throwable {
		glhDrillDown_PageObject.verifyRightArrowIndicator();
	}


	@Then("I get Gaps count on summary page")
	public void getGapsCount(String sectionName) throws Throwable {
		glhDrillDown_PageObject.getGapsCount(sectionName);
	}

	@Then("I get Lows count on summary page")
	public void getLowsCount(String sectionName) throws Throwable {
		glhDrillDown_PageObject.getLowsCount(sectionName);
	}

	@Then("I get Highs count on summary page")
	public void getHighsCount(String sectionName) throws Throwable {
		glhDrillDown_PageObject.getHighsCount(sectionName);
	}

	@Then("I get +SF count on summary page")
	public void getSFCount(String sectionName) throws Throwable {
		glhDrillDown_PageObject.getSFCount(sectionName);
	}

	@Then("I get SR count on summary page")
	public void getSRCount(String sectionName) throws Throwable {
		glhDrillDown_PageObject.getSRCount(sectionName);
	}

	@Then("I get IC count on summary page")
	public void getICCount(String sectionName) throws Throwable {
		glhDrillDown_PageObject.getICCount(sectionName);
	}

	@Then("I get Total {string} count on summary page")
	public void getTotalCaptureCount(String captureType) throws Throwable {
		if(captureType.equals("Gaps")){
			glhDrillDown_PageObject.getTotalGapsCount();
		}
		if(captureType.equals("Lows")){
			glhDrillDown_PageObject.getTotalLowCount();
		}
		if(captureType.equals("Highs")){
			glhDrillDown_PageObject.getTotalHighCount();
		}
	}

	@Then("I get Total +SF count on summary page")
	public void getTotalSFCount(String captureType) throws Throwable {
		if(captureType.equals("Gaps")){
			glhDrillDown_PageObject.getTotalGap_SFCount();
		}
		if(captureType.equals("Lows")){
			glhDrillDown_PageObject.getTotalLow_SFCount();
		}
	}

	@Then("I get Total SR count on summary page")
	public void getTotalSRCount(String captureType) throws Throwable {
		if(captureType.equals("Gaps")){
			glhDrillDown_PageObject.getTotalGap_SRCount();
		}
	}

	@Then("I get Total IC count on summary page")
	public void getTotalICCount(String captureType) throws Throwable {
		if(captureType.equals("Gaps")){
			glhDrillDown_PageObject.getTotalGap_ICCount();
		}
		if(captureType.equals("Lows")){
			glhDrillDown_PageObject.getTotalLow_ICCount();
		}
		if(captureType.equals("Highs")){
			glhDrillDown_PageObject.getTotalHigh_ICCount();
		}
	}



	//////All department sections count is zero
	@Then("I verify all {string} Department sections count is Zero")
	public void getSectionCountAndOrder(String dept) throws Throwable {
		glhDrillDown_PageObject.getSectionsForSpecificDept(dept);
	}

	@Then("I verify department sections which have 0 counts are sorted in alphabetical order")
	public void sectionsInAlphabeticalOrder() throws Throwable {
		glhDrillDown_PageObject.sectionsInAlphabeticalOrder();
	}

	@Then("I get all {string} Department sections")
	public void getSpecificDeptSection(String dept) throws Throwable {
		glhDrillDown_PageObject.getSectionsForSpecificDept(dept);
	}
	
	
	@Then("I get all {string} Department sections in list")
	public void getMarketstreetGlhDepts(String dept) throws Throwable {
		glhDrillDown_PageObject.getMarketstreetGlhDepts(dept);
	}
	
	
	@Then("I verify that the all counts at section level add up to the department level for {string} Department")
	public void verifySectionCountAtDept(String deptName) throws Throwable {
		glhDrillDown_PageObject.verifySectionCountAtDept(deptName);
	}
	

	@Then("I Get department count for {string} and {string} departments")
	public void getDepartmentCount(String dept1,String dept2) throws Throwable {
		glhDrillDown_PageObject.getDepartmentCount(dept1,dept2);
	}
	
	@Then("I verify that the all counts at department level add up to the Totals for {string}")
	public void verifyDeptCountAtTotal(String captureType) throws Throwable {
		glhDrillDown_PageObject.verifyDeptCountAtTotal(captureType);
	}

	@Then("I Selct {string} department")
	public void selectDepartment(String dept) throws Throwable {
		glhDrillDown_PageObject.selectDepartment(dept);
	}
}
