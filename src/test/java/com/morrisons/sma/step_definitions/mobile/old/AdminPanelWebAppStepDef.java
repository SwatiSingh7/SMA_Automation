package com.morrisons.sma.step_definitions.mobile.old;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.morrisons.sma.page_objects.mobile.old.AdminPanelWebAppPO;

public class AdminPanelWebAppStepDef {

	AdminPanelWebAppPO adminPanelWebAppPO = new AdminPanelWebAppPO();

	@Given("I Navigate to webpage URL")
	public void i_Navigate_to_webpage_URL() throws Throwable {
		adminPanelWebAppPO.enterURl();
	    }
	
	@When("I Enter Username and Password for SMA user")
	public void i_Enter_Username_and_Password_for_SMA_user() throws Throwable {
		adminPanelWebAppPO.enterWebpageLoginCredentials();
	
	}
	
	@Then("I Verify Fcc Admin webpage logged Successfully")
	public void i_Verify_Fcc_Admin_webpage_logged_Successfully() throws Throwable {
		adminPanelWebAppPO.verifywebpage();
		
	}

	@And("I verify Admin menu is displayed")
	public void verifyAdminMenu() throws Throwable {
		adminPanelWebAppPO.verifyAdminMenu();
	}

	@Then("I click on Admin menu on Admin Panel")
	public void clickOnAdminMenu() throws Throwable {
		adminPanelWebAppPO.clickOnAdminMenu();
	}

	@And("I verify Admin page is displayed")
	public void verifyAdminPageDisplayed() throws Throwable {
		adminPanelWebAppPO.verifyAdminPageDisplayed();
	}

	@And("I verify enter user details textfiled are displayed")
	public void enterUserDetail() throws Throwable {
		adminPanelWebAppPO.enterUserDetail();
	}

	@Then("I enter username {string}")
	public void enterUsername(String username) throws Throwable {
		adminPanelWebAppPO.enterUsername(username);
	}

	@Then("I click on Next button")
	public void clickOnNextButton() throws Throwable {
		adminPanelWebAppPO.clickOnNextButton();
	}

	@And("I verify Select Access checkboxes are displayed")
	public void verifyAccesCheckboxes() throws Throwable {
		adminPanelWebAppPO.verifyAccesCheckboxes();
	}

	@Then("I scroll down to the page")
	public void scrollDownToPage() throws Throwable {
		adminPanelWebAppPO.scrollDownToPage();
	}

	@And("I verify Grant Access button is displayed")
	public void verifyGrantAccessButton() throws Throwable {
		adminPanelWebAppPO.verifyGrantAccessButton();
	}

	@Then("I click on Grant Access button")
	public void clickOnGrantAccessBtn() throws Throwable {
		adminPanelWebAppPO.clickOnGrantAccessBtn();
	}

	@And("I verify Confirmation alert {string} is displayed")
	public void verifyConfirmationPopup(String alertName) throws Throwable {
	    adminPanelWebAppPO.verifyConfirmationPopup(alertName);
	}
	
	@And("I verify Grant access alert message as {string} is displayed")
	public void verifyGrantAccessAlert(String alertMessage) throws Throwable {
	    adminPanelWebAppPO.verifyGrantAccessAlert(alertMessage);
	}

	@And("I verify Schedule Summary menu is displayed")
	public void verifyScheduleSummary() throws Throwable {
		adminPanelWebAppPO.verifyScheduleSummary();
	}

	@Then("I click on Schedule Summary on Admin Panel")
	public void clickOnScheduleSummary() throws Throwable {
		adminPanelWebAppPO.clickOnScheduleSummary();
	}

	@And("I verify Schedule Summary page is displayed")
	public void verifyScheduleSummaryPage() throws Throwable {
		adminPanelWebAppPO.verifyScheduleSummaryPage();
	}

	@And("I verify select store, select store group and Next button are displayed")
	public void verifyCheckSchedulePage() throws Throwable {
		adminPanelWebAppPO.verifyCheckSchedulePage();
	}

	@Then("I click on Select store dropdown")
	public void clickOnSelectStoreDropdown() throws Throwable {
		adminPanelWebAppPO.clickOnSelectStoreDropdown();
	}
	
	@Then("I click on Select store dropdown on Alert")
	public void selectDropdownOnAlert() throws Throwable {
		adminPanelWebAppPO.selectDropdownOnAlert();
	}

	@And("I verify Store list with checkboxes are displayed")
	public void verifyStoreListCheckbox() throws Throwable {
		adminPanelWebAppPO.verifyStoreListCheckbox();
	}

	@Then("I select store {string} checkbox")
	public void selectStoreCheckbox(String storeName) throws Throwable {
		adminPanelWebAppPO.selectStoreCheckbox(storeName);
	}
	
	@Then("I select group {string} checkbox")
	public void selectGroupCheckbox(String groupName) throws Throwable {
		adminPanelWebAppPO.selectGroupCheckbox(groupName);
	}

	@And("I verify Current week and next week tabs are displayed")
	public void verifyCurrentAndNextWeek() throws Throwable {
		adminPanelWebAppPO.verifyCurrentAndNextWeek();
	}

	@Then("I click on Current week tab")
	public void clickOnCurrentWeekTab() throws Throwable {
		adminPanelWebAppPO.clickOnCurrentWeekTab();
	}

	@And("I verify department list for selected store for current week is displayed")
	public void verifyDeptListForCurrentWeek() throws Throwable {
		adminPanelWebAppPO.verifyDeptListForWeek();
	}

	@Then("I click on Next week tab")
	public void clickOnNextWeekTab() throws Throwable {
		adminPanelWebAppPO.clickOnNextWeekTab();
	}

	@And("I verify department list for selected store for next week is displayed")
	public void verifyDeptListForNextWeek() throws Throwable {
		adminPanelWebAppPO.verifyDeptListForWeek();
	}

	@And("I verify department level schedule for Daily check, Afternoon Check and FM Check")
	public void verifyDeptLevelSchedule() throws Throwable {
		adminPanelWebAppPO.verifyDeptLevelSchedule();
	}

	@And("I verify schedule are in DDMMYYYY format")
	public void verifyScheduleDateFormat() throws Throwable {
		adminPanelWebAppPO.verifyScheduleDateFormat();
	}

	@Then("I click on Department")
	public void clickOnDept() throws Throwable {
		adminPanelWebAppPO.clickOnDept();
	}
	
	@Then("I click on Searched Department")
	public void clickOnSearchDept() throws Throwable {
		adminPanelWebAppPO.clickOnSearchDept();
	}
	
	@Then("I click on Searched Department class")
	public void clickOnSearchDeptClass() throws Throwable {
		adminPanelWebAppPO.clickOnSearchDeptClass();
	}
	
	@Then("I click on Searched Department subclass")
	public void clickOnSearchDeptSubClass() throws Throwable {
		adminPanelWebAppPO.clickOnSearchDeptSubClass();
	}

	@And("I verify class level schedule under selected department for Daily check, Afternoon Check and FM Check")
	public void verifyClassLevelSchedule() throws Throwable {
		adminPanelWebAppPO.verifyDeptLevelSchedule();
	}

	@Then("I click on Class under selected department")
	public void clickOnClassUnderDept() throws Throwable {
		adminPanelWebAppPO.clickOnClassUnderDept();
	}

	@And("I verify subclass level schedule under selected department class for Daily check, Afternoon Check and FM Check")
	public void verifySubclassLevel() throws Throwable {
		adminPanelWebAppPO.verifyDeptLevelSchedule();
	}
	
	@And("I verify Daily check, Afternoon Check and FM Check are displayed with DDMMYYYY date format")
	public void verifyChecks() throws Throwable {
		adminPanelWebAppPO.verifyChecks();
	}

	@Then("I Get Department name for selected store")
	public void getDeptName() throws Throwable {
		adminPanelWebAppPO.getDeptName();
	}

	@And("I verify Search icon is displayed on Schedule summary screen")
	public void verifySearchIconDisplayed() throws Throwable {
		adminPanelWebAppPO.verifySearchIconDisplayed();
	}

	@Then("I click on Search icon on Schedule summary screen")
	public void clickOnSearchIcon() throws Throwable {
		adminPanelWebAppPO.clickOnSearchIcon();
	}

	@And("I verify Search Dept class subclass & MI Textfield is displayed")
	public void verifySearchDept() throws Throwable {
		adminPanelWebAppPO.verifySearchDept();
	}

	@Then("I Enter and search Department name")
	public void enterAndSearchDept() throws Throwable {
		adminPanelWebAppPO.enterAndSearchDept();
	}
	
	@Then("I Enter {string} and Search")
	public void enterAndSearchDept(String deptName) throws Throwable {
		adminPanelWebAppPO.enterAndSearchDept(deptName);
	}
	
	@And("I verify Department Name {string} is displayed on Search result page")
	public void verifyDeptOnSearchResult(String deptName) throws Throwable {
		adminPanelWebAppPO.verifyDeptOnSearchResult(deptName);
	}

	@And("I verify Department Name is displayed on Search result page")
	public void verifyDeptOnSearchResult() throws Throwable {
		adminPanelWebAppPO.verifyDeptOnSearchResult();
	}
	
	@And("I verify Class Name is displayed on Search result page")
	public void verifyClassOnSearchResult() throws Throwable {
		adminPanelWebAppPO.verifyClassOnSearchResult();
	}
	
	@And("I click on Searched Class Name")
	public void clickOnClassDept() throws Throwable {
		adminPanelWebAppPO.clickOnClassDept();
	}
	
	@Then("I click on Searched Class subclass")
	public void clickOnSubClass() throws Throwable {
		adminPanelWebAppPO.clickOnSubClass();
	}

	@And("I verify Back option is displayed")
	public void verifyBackOption() throws Throwable {
		adminPanelWebAppPO.verifyBackOption();
	}

	@Then("I click on Back to search")
	public void clickOnBackToSearch() throws Throwable {
		adminPanelWebAppPO.clickOnBackToSearch();
	}

	@And("I verify page navigates to search page to enter Department or Class or subclass name")
	public void verifyPageNavigatesToSearch() throws Throwable {
		adminPanelWebAppPO.verifyPageNavigatesToSearch();
	}

	@Then("I Get Class name for selected store")
	public void getClassNameForSelectedStore() throws Throwable {
		adminPanelWebAppPO.getClassNameForSelectedStore();
	}

	@Then("I Enter and search Class name")
	public void enterAndSearchClassName() throws Throwable {
		adminPanelWebAppPO.enterAndSearchClassName();
	}

	@And("I verify Export schdule link is displayed")
	public void verifyExportScheduleLink() throws Throwable {
		adminPanelWebAppPO.verifyExportScheduleLink();
	}

	@Then("I click on Export schdule link")
	public void clickOnExportScheduleLink() throws Throwable {
		adminPanelWebAppPO.clickOnExportScheduleLink();
	}

	@And("I verify Export Schedule Information alert with message as {string}")
	public void verifyExportScheduleAlert(String message) throws Throwable {
		adminPanelWebAppPO.verifyExportScheduleAlert(message);
	}

	@And("I verify Cancel and Export button on Export Schedule Information alert")
	public void verifyCancelAndExportBtn() throws Throwable {
		adminPanelWebAppPO.verifyCancelAndExportBtn();
	}

	@Then("I click On Export button")
	public void clickOnExportBtn() throws Throwable {
		adminPanelWebAppPO.clickOnExportBtn();
	}

//	@And("I verify csv file is downloaded")
//	public void verifyCSVFile() throws Throwable {
//		adminPanelWebAppPO.verifyCSVFile();
//	}

	@And("I verify Manager Sign Off menu is displayed")
	public void verifyManagerSignOffMenu() throws Throwable {
		adminPanelWebAppPO.verifyManagerSignOffMenu();
	}

	@Then("I click on Manager Sign Off on Admin Panel")
	public void clickOnManagerSignOff() throws Throwable {
		adminPanelWebAppPO.clickOnManagerSignOff();
	}

	@And("I verify Manager Sign Off page is displayed")
	public void verifyManagerSignOffPage() throws Throwable {
		adminPanelWebAppPO.verifyManagerSignOffPage();
	}

	@And("I verify Manager Sign Off page details")
	public void verifyManagerSignOffDetails() throws Throwable {
		adminPanelWebAppPO.verifyManagerSignOffDetails();
	}

	@And("I verify Days with checkboxes are displayed")
	public void verifyDaysWithCheckboxes() throws Throwable {
		adminPanelWebAppPO.verifyDaysWithCheckboxes();
	}

	@Then("I click on Select group dropdown")
	public void clickOnSelectGroupDropdown() throws Throwable {
		adminPanelWebAppPO.clickOnSelectGroupDropdown();
	}

	@And("I verify Append and Delete icons are displayed")
	public void verifyAppendAndDeleteIcon() throws Throwable {
		adminPanelWebAppPO.verifyAppendAndDeleteIcon();
	} 
	


	@Then("I click on Append icon")
	public void clickOnAppendIcon() throws Throwable {
		adminPanelWebAppPO.clickOnAppendIcon();
	}

//
	@And("I verify Cancel and Save buttons are displayed")
	public void verifyCancelAndSaveBtn() throws Throwable {
		adminPanelWebAppPO.verifyCancelAndSaveBtn();
	}

	@Then("I click on Delete icon to remove store")
	public void clickOnDeleteIcon() throws Throwable {
		adminPanelWebAppPO.clickOnDeleteIcon();
	}
	
	@And("I verify days details are displayed for selected Stores {string}")
	public void storeDisplayed(String name) throws Throwable {
		adminPanelWebAppPO.groupDayDisplayed(name);
	}
//
	@And("I verify details are removed for deleted store {string}")
	public void verifyDetailsAreRemoved(String storeName) throws Throwable {
		adminPanelWebAppPO.verifyGroupsAreRemoved(storeName);
	}


	@And("I verify days details are displayed for selected Groups {string}")
	public void daysDetailsAreDisplayed(String name) throws Throwable {
		adminPanelWebAppPO.groupDayDisplayed(name);
	}

	@Then("I click on Delete icon to remove group")
	public void removeGroup() throws Throwable {
		adminPanelWebAppPO.clickOnDeleteIcon();
	}

	@And("I verify details are removed for deleted group {string}")
	public void verifyGroupsAreRemoved(String name) throws Throwable {
		adminPanelWebAppPO.verifyGroupsAreRemoved(name);
	}
//
	@Then("I click on sign off days")
	public void clickOnSignOffDays() throws Throwable {
		adminPanelWebAppPO.clickOnSignOffDays();
	}

	@And("I verify selected checkboxes are displayed")
	public void verifySelectedCheckboxes() throws Throwable {
		adminPanelWebAppPO.verifyDaysWithCheckboxes();
	}
	
	@And("I verify Save and Discard buttons are displayed")
	public void verifySaveDiscardBtn() throws Throwable {
		adminPanelWebAppPO.verifySaveDiscardBtn();
	}
	
	@And("I click on Discard Button")
	public void clickOnDiscardBtn() throws Throwable {
		adminPanelWebAppPO.clickOnDiscardBtn();
	}
	
	@And("I click on Save Button")
	public void clickOnSaveBtn() throws Throwable {
		adminPanelWebAppPO.clickOnSaveBtn();
	}
	
	@And("I click on Save Button on Alert")
	public void clickOnSaveBtnOnAlert() throws Throwable {
		adminPanelWebAppPO.clickOnSaveBtnOnAlert();
	}
	
	@And("I verify alert {string} is displayed")
	public void verifyAlertDisplay(String alertName) throws Throwable {
		adminPanelWebAppPO.verifyAlertDisplay(alertName);
	}
	
	@And("I verify alert message as {string} is displayed")
	public void verifyAlertMessage(String alertMessage) throws Throwable {
		adminPanelWebAppPO.verifyAlertMessage(alertMessage);
	}
	
	@And("I verify alert msg as {string} is displayed")
	public void verifyAlertMsg(String alertMessage) throws Throwable {
		adminPanelWebAppPO.verifyAlertMsg(alertMessage);
	}
	
	@And("I fetch all Store name and id")
	public void getAllStoreInList() throws Throwable {
		adminPanelWebAppPO.getAllStoreInList();
	}
	
	@And("I verify Store list is in Ascending order")
	public void verifyAscendingOrder() throws Throwable {
		adminPanelWebAppPO.verifyAscendingOrder();
	}
	
	//Shrutika

	@When("User click on the Stores Tab")
	public void user_click_on_the_Stores_Tab() throws Throwable {
		adminPanelWebAppPO.viewStoreGrouplist();      
	}

	@Then("User should be able to enter Store page with list of Store Groups")
	public void user_should_be_able_to_enter_Store_page_with_list_of_Store_Groups() throws Throwable {
		adminPanelWebAppPO.VerifyStorepagelistofstoregroup();      
	}

	@When("User click on 'New Group' button")
	public void user_click_on_New_Group_button() throws Throwable {
		adminPanelWebAppPO.ClickNewGroup();
	}

	@Then("New Store Groups with storelist is created successfully")
	public void new_Store_Groups_with_storelist_is_created_successfully() throws Throwable {
		adminPanelWebAppPO.CreateNewgroup();
	}

	@When("User click on edit icon of the desired store group")
	public void user_click_on_edit_icon_of_the_desired_store_group() throws Throwable {
		adminPanelWebAppPO.ClickEditiconOfnewStoreGroup();
	}

	@Then("Verify 'Store group updated successfully'")
	public void store_group_updated_successfully() throws Throwable {
		adminPanelWebAppPO.verifySuccessmessage();
	}


	@When("User click on delete icon of the desired store group\\.")
	public void user_click_on_delete_icon_of_the_desired_store_group() throws Throwable {
		adminPanelWebAppPO.clickDeleticonofnewStoreGroup();
	}

	@Then("User deletes the Store Group successfully")
	public void user_deletes_the_Store_Group_successfully() throws Throwable {
		adminPanelWebAppPO.deletestoregroup();
	}

	@Then("Verify {string}")
	public void verify(String Alertmsg) throws Throwable {
		   adminPanelWebAppPO.verifypopupmsg(Alertmsg);
	}

	@Then("User enables all the Store Group successfully")
	public void user_enables_all_the_Store_Group_successfully() throws Throwable {
		adminPanelWebAppPO.enableAllStoregroup();
	}

	@When("Click on Save below popup will appear")
	public void click_on_Save_below_popup_will_appear() throws Throwable {
		adminPanelWebAppPO.clickEnableNSave();
	}
	@When("Click on Save below popup will appear for disable")
	public void click_on_Save_below_popup_will_appear_for_disable() throws Throwable {
		adminPanelWebAppPO.clickDisableNSave();
	}

	@When("User click on toggle of store group")
	public void user_click_on_toggle_of_store_group() throws Throwable {
		adminPanelWebAppPO.clicktogglestoregroup();
	}

	@Then("Store Group are successfully disables")
	public void store_Group_are_successfully_disables() throws Throwable {
		adminPanelWebAppPO.disableAllStoregroup();
	}

	@When("User click on the Store list Tab")
	public void user_click_on_the_Store_list_Tab() throws Throwable {
		adminPanelWebAppPO.clickStorelistTab();
	}

	@Then("User should be able to view list of Stores")
	public void user_should_be_able_to_view_list_of_Stores() throws Throwable {
		adminPanelWebAppPO.listofStores();
	}

	@When("User click on toggle of store")
	public void user_click_on_toggle_of_store() throws Throwable {
		adminPanelWebAppPO.clickStoretoggle();  
	}

	@Then("User enables all the Stores successfully")
	public void user_enables_all_the_Stores_successfully() throws Throwable {
		adminPanelWebAppPO.enableStorelist();
	}


	@Then("User disables all the Stores successfully\\.")
	public void user_disables_all_the_Stores_successfully() throws Throwable {
		adminPanelWebAppPO.disableStorelist();
	}


	@When("User click on toggle of store {string}")
	public void user_click_on_toggle_of_store(String storeID) throws Throwable {
		adminPanelWebAppPO.clickSelectedStore(storeID);
	}

	@Then("User Disable the selected Stores successfully")
	public void user_Disable_the_selected_Stores_successfully() throws Throwable {
		adminPanelWebAppPO.clickDisableNSave();
	}


	@Then("User enables selected Stores successfully\\.")
	public void user_enables_selected_Stores_successfully() throws Throwable {
		adminPanelWebAppPO.clickEnableNSave();

	}

	@When("User click on export")
	public void user_click_on_export() throws Throwable {
		adminPanelWebAppPO.clickExport();
	}

	@Then("User should be able to export list of stores and store groups from ‘Stores’ for the current day")
	public void user_should_be_able_to_export_list_of_stores_and_store_groups_from_Stores_for_the_current_day() throws Throwable {
		adminPanelWebAppPO.clickexportlist();
	}

	@When("Clicks on Check Schedule")
	public void clicks_on_Check_Schedule() throws Throwable {
		adminPanelWebAppPO.clickCheckSchedules();
	}


	//###########################################

	@When("select Store/Storegroup {string}")
	public void select_Store_Storegroup(String StoreId) throws Throwable {
		adminPanelWebAppPO.selectstoreinCheckSchedule(StoreId);
	}

	@When("I navigate to Department {string}")
	public void i_navigate_to_Department(String Department) throws Throwable {
		adminPanelWebAppPO.selectDepartment(Department);
	}

	@When("I view Daily Check/Afternoon Check/FM Check")
	public void i_view_Daily_Check_Afternoon_Check_FM_Check() throws Throwable {
		adminPanelWebAppPO.ViewDailyAfternoonFMCheck();
	}

	@Then("Able to View and Edit {string} department/class/subclass check schedule dates")
	public void able_to_View_and_Edit_department_class_subclass_check_schedule_dates(String department) throws Throwable {
		adminPanelWebAppPO.editDepartmentCheckDate(department);

	}

	@When("I search Department {string} in Search box")
	public void i_search_Department_in_Search_box(String Department) throws Throwable {
		adminPanelWebAppPO.searchDepartment(Department);
	}

	@Then("Able to Search and Edit department/class/subclass check schedule dates")
	public void able_to_Search_and_Edit_department_class_subclass_check_schedule_dates() throws Throwable {
		adminPanelWebAppPO.editdepartmentdatesinSearchpg();
	}

	@When("Clicks on Change Log")
	public void clicks_on_Change_Log() throws Throwable {
		adminPanelWebAppPO.clickChangelog();
	}

	@Then("Able to View the logs of activities for respective time")
	public void able_to_View_the_logs_of_activities_for_respective_time() throws Throwable {
		adminPanelWebAppPO.viewLogs();
	}

	@Then("Enter Activity Name {string} in Search field")
	public void enter_Activity_Name_in_Search_field(String Text) throws Throwable {
		adminPanelWebAppPO.enterActivityNameinSearchbox(Text);
	}

	@Then("Enter the From date and To date in the date range")
	public void enter_the_From_date_and_To_date_in_the_date_range() throws Throwable {
		adminPanelWebAppPO.selectdaterange();
	}

	@Then("View the respective logs")
	public void view_the_respective_logs() throws Throwable {
		adminPanelWebAppPO.viewLogs();

	}

	@Then("click Export to excel")
	public void click_Export_to_excel() throws Throwable {
		adminPanelWebAppPO.clickExport();
	}
}
