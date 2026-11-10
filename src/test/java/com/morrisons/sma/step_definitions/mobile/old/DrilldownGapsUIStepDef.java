package com.morrisons.sma.step_definitions.mobile.old;

import com.morrisons.sma.page_objects.mobile.old.DrilldownGapsPO;
import com.morrisons.sma.page_objects.service.GlhSummaryService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;


public class DrilldownGapsUIStepDef {
	
	DrilldownGapsPO drilldown = new DrilldownGapsPO();
	GlhSummaryService glhSummary_Service = new GlhSummaryService();

	public static List<String> deptlist = new ArrayList<String>();


@Then("I verify {string} is displayed")
public void i_verify_is_displayed(String department) throws Throwable {
	drilldown.verifyDisplay(department);
}

@Then("I verify right arrow displayed for all department {string}")
public void i_verify_right_arrow_displayed_for_all_department(String arg1) throws Throwable {
    drilldown.verifyArrow();
}

@Then("I click {string}")
public void i_click(String department) throws Throwable {
   drilldown.clickDepartment(department);
}

@Then("I verify sections {string}, {string},{string},{string},{string},{string}")
public void i_verify_sections(String Section1, String Section2, String Section3, String Section4, String Section5, String Section6) throws Throwable {
    drilldown.verifySection(Section1,Section2,Section3,Section4,Section5,Section6);
}

@Then("I verify Scans,SF,IC displayed")
public void i_verify_Scans_SF_IC_displayed() throws Throwable {
   drilldown.verifyheader();
}

@Then("I verify count {string},{string},{string} at department level")
public void i_verify_count_at_department_level(String scan, String sf, String ic) throws Throwable {
    drilldown.verifyCountDepartmentlevel(scan,sf,ic);
}

@Then("I verify count {string},{string},{string} at section level for department {string}")
public void i_verify_count_at_section_levelfordepartment(String scan, String sf, String ic, String sDept) throws Throwable {
    drilldown.verifySummarySectionlevel(sDept,scan,sf,ic);
}

@Then("I verify Total Count {string},{string},{string}")
public void i_verify_Total_Count(String scan, String sf, String ic) throws Throwable {
    drilldown.verifyCountTotal(scan,sf,ic);
}


@Then("I verify Sorting order in Summary Screen as")
public void i_verify_Sorting_order_in_Summary_Screen_as()		{
    drilldown.verifySortingorder();
}


@Then("I Verify all departments which are mapped to Gaps walktype on UI and Service matches")
public void i_Verify_all_departments_which_are_mapped_to_Gaps_walktype_on_UI_and_Service_matches() throws Throwable {
    deptlist = drilldown.getDepartmentList();
    drilldown.verifyDeptOnUIAndService();
}


@Then("I verify Sorting order in Summary Screen as {string}, {string},{string},{string}")
public void i_verify_Sorting_order_in_Summary_Screen_as(String Section, String Scan, String SF, String IC) throws Throwable {
	drilldown.verifySummaryScreenOrder(Section,Scan,SF,IC);
}


///////////////////////////////////Service Steps////////////////////////
@Then("Verify Get Storewalk Summary API Positive stock\\(+SR) value to be displayed under section level")
public void verifyGetStorewalkSummaryAPIPositiveStockSRValueToBeDisplayedUnderSectionLevel() throws Throwable {
	glhSummary_Service.verifyPositivestockundersection();
}

@Then("Verify Get Storewalk Summary API Stock Found\\(SF) value to be displayed under section level")
public void verify_Get_Storewalk_Summary_API_Stock_Found_SF_value_to_be_displayed_under_section_level() throws Throwable {
	glhSummary_Service.verifyStockfoundunderSection();

}

@Then("Verify Get Storewalk Summary API Incomplete Counts\\(IC) attribute value to be displayed under section level")
public void verify_Get_Storewalk_Summary_API_Incomplete_Counts_IC_attribute_value_to_be_displayed_under_section_level() throws Throwable {
	glhSummary_Service.verifyIncompleteCountunderSection();
}

@Then("Verify Get Storewalk Summary API Positive stock\\(+SR) value to be displayed under department level")
public void verify_Get_Storewalk_Summary_API_Positive_stock_SR_value_to_be_displayed_under_department_level() throws Throwable {
    glhSummary_Service.verifyPositivestockunderDepartment();
}

@Then("Verify Get Storewalk Summary API Stock Found\\(SF) value to be displayed under department level")
public void verify_Get_Storewalk_Summary_API_Stock_Found_SF_value_to_be_displayed_under_department_level() throws Throwable {
	glhSummary_Service.verifyStockfoundunderDepartment();
}

@Then("Verify Get Storewalk Summary API Incomplete Counts\\(IC) attribute value to be displayed under department level")
public void verify_Get_Storewalk_Summary_API_Incomplete_Counts_IC_attribute_value_to_be_displayed_under_department_level() throws Throwable {
	glhSummary_Service.verifyIncompleteCountunder();
}

@Then("I verify service response is {int}")
public void i_verify_service_response_is(int arg1) throws Throwable {
	glhSummary_Service.getglhSummaryResponseIs200();
}

@Then("Verify Get Storewalk Summary API GAPS attribute value to be displayed under department level")
public void verify_Get_Storewalk_Summary_API_GAPS_attribute_value_to_be_displayed_under_department_level() throws Throwable {
    glhSummary_Service.verifyGapsattribute();
}

@Then("Verify Get Storewalk Summary API LOWS attribute value to be displayed under department level")
public void verify_Get_Storewalk_Summary_API_LOWS_attribute_value_to_be_displayed_under_department_level() throws Throwable {
    glhSummary_Service.verifyLowsattribute();

}

@Then("Verify Get Storewalk Summary API HIghs attribute value to be displayed under department level")
public void verify_Get_Storewalk_Summary_API_HIghs_attribute_value_to_be_displayed_under_department_level() throws Throwable {
    glhSummary_Service.verifyHighsattribute();

}


@Then("Verify Get Storewalk Summary API response with department_id and department_name")
public void verify_Get_Storewalk_Summary_API_response_with_department_id_and_department_name() throws Throwable {
	glhSummary_Service.verifyDepartmentidnName();
}

@Then("Verify Get Storewalk Summary API response with section_id and section_name")
public void verify_Get_Storewalk_Summary_API_response_with_section_id_and_section_name() throws Throwable {
	glhSummary_Service.verifySectionidnName();

}

@Then("Get Operation perform on Glh Summary service request for error in authourization")
public void get_Operation_perform_on_Glh_Summary_service_request_for_error_in_authourization() throws Throwable {
	glhSummary_Service.getServicePerformOperationError();
}

@Then("Get request is made to GlhSummary api for Store id {string} and Walktype GLH & Marketstreet GLH doesn't exist")
public void get_request_is_made_to_GlhSummary_api_for_Store_id_and_Walktype_GLH_Marketstreet_GLH_doesn_t_exist(String storeID) throws Throwable {
	glhSummary_Service.getGlhSummaryForGLH_MSGlhincorrect(storeID);
}


@When("Verify service response code 401")
public void verifyAPIResponse401() throws Throwable {
	glhSummary_Service.verifyAPIResponse400Or401();
}

@When("Verify service response code 404")
public void verifyAPIResponse404() throws Throwable {
	glhSummary_Service.verifyAPIResponse404();
}
}
