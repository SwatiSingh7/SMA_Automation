package com.morrisons.sma.step_definitions.mobile.old;

import com.morrisons.sma.page_objects.mobile.promptedCount.PromptedCountMenu_New;
import io.cucumber.java.en.And;
import org.apache.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.morrisons.common.action.Hook;
import io.cucumber.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import com.morrisons.sma.page_objects.mobile.old.PromptedCountPO;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class PromptedCountStepDef {

    private static AndroidDriver driveR;

    PromptedCountPO promptedCountPO = new PromptedCountPO();
    ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse Response;
    public static io.restassured.response.Response restResponse;

    public static String actionLabel = null;

    private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

    PromptedCountMenu_New promptedCountMenu = new PromptedCountMenu_New();

    public PromptedCountStepDef() {
        this.driveR = (AndroidDriver) Hook.getDriver();
    }


    @Then("I verify {string} Action label is displayed")
    public void verifyActionDisplay(String action) throws Throwable {
        promptedCountPO.verifyActionDisplay(action);
    }

    @Then("I click on {string} Action label")
    public void clickOnActionCheckbox(String action) throws Throwable {
        promptedCountPO.clickOnActionCheckbox(action);
        actionLabel = action;
    }

    @Then("I verify item details on the prompted screen")
    public void verifyDetailsOnThePromptedScreen() throws Throwable {
        promptedCountPO.verifyDetailsOnFixtureScreen();
    }

    @Then("I verify details on Warehouse screen")
    public void verifyDetailsOnWarehouseScreen() throws Throwable {
        promptedCountPO.verifyDetailsOnWarehouseScreen();
    }

    @Then("I verify one prompted item is displayed")
    public void verifyOnePromptedItemDisplay() throws Throwable {
        promptedCountPO.verifyOnePromptedItemDisplay();
    }

    @Then("I enter qty {string} and click on Confirm button")
    public void enterQtyAndConfirm(String quantity) throws Throwable {
        promptedCountPO.enterQtyAndConfirm(quantity);
    }

    @Then("I enter qty {string} and click on Confirm button for all the products")
    public void enterQtyAndConfirmAllProducts(String quantity) throws Throwable {
        promptedCountPO.enterQtyAndConfirmAllProducts(quantity);
    }

    @Then("I verify Summary screen UI")
    public void verifySummaryPage() throws Throwable {
        promptedCountPO.verifySummaryPage();
    }

    @Then("I verify product is displayed in {string} list")
    public void verifyProductList(String action) throws Throwable {
        promptedCountPO.verifyProductList(action);
    }

    @Then("I verify details on Merchandising screen")
    public void verifyDetailsOnMerchandising() throws Throwable {
        promptedCountPO.verifyDetailsOnMerchandising();
    }

    @Then("I verify Product is displayed in Product list on Merchandising screen")
    public void verifyProductsOnMerchandising() throws Throwable {
        promptedCountPO.verifyProductsOnMerchandising();
    }

    @Then("I verify Prompted Items are displayed one at a time with proper sorting based on sequence id/storewalk order")
    public void promptedItemSortingSequence() throws Throwable {
        promptedCountPO.promptedItemSortingSequence();
    }

    @Then("I verify Request Label screen UI")
    public void requestLabelScreen() throws Throwable {
        promptedCountPO.requestLabelScreen();
    }

    @Then("I verify {string}, {string} and {string} labels are displayed")
    public void verifyLablesArePresent(String label1, String label2, String label3) throws Throwable {
        promptedCountPO.verifyLablesArePresent(label1, label2, label3);
    }

    @Then("I verify Item list count is displayed")
    public void verifyItemListCount() throws Throwable {
        promptedCountPO.verifyItemListCount();
    }


    @Then("I verify History screen is displayed with list of completed products with total count")
    public void verifyHistoryScreen() throws Throwable {
        promptedCountPO.verifyHistoryScreen();
    }

    @Then("I verify Edit button is displayed")
    public void verifyEditButton() throws Throwable {
        promptedCountPO.verifyEditButton();
    }

    @Then("I click on Edit button")
    public void clickOnEditButton() throws Throwable {
        promptedCountPO.clickOnEditButton();
    }


    @Then("I add action and edit stock count as {string}")
    public void addActionAndEditStockCount(String count) throws Throwable {
        promptedCountPO.enterQtyAndConfirm(count);
    }

    @Then("I edit stock count with {string}")
    public void editStockCount(String qty) throws Throwable {
        promptedCountPO.enterQtyAndConfirm(qty);
    }

    @Then("I verify History icon is displayed")
    public void verifyHistoryIcon() throws Throwable {
        promptedCountPO.verifyHistoryIcon();
    }

    @Then("I click on History icon")
    public void clickOnHistoryIcon() throws Throwable {
        promptedCountPO.clickOnHistoryIcon();
    }

    @Then("I verify Merchandising action tile is displayed on Action & Next steps page")
    public void verifyMerchandisingAction() throws Throwable {
        promptedCountPO.verifyMerchandisingAction();
    }

    @Then("I Scroll down on Prompted Count menu page")
    public void iScrollDownonPromptedCountPage() throws Throwable {
        promptedCountMenu.scrollDown();
    }

    @Then("I click on {string} on Prompted Count Page")
    public void iClickonPromptedCountPage(String option) throws Throwable {
        promptedCountMenu.clickOnPromptedCountOption(option);
    }


    @Then("I verify Print & Place Labels action tile is displayed on Action & Next steps page")
    public void verifyPrintAndPlaceLabelsAction() throws Throwable {
        promptedCountPO.verifyPrintAndPlaceLabelsAction();
    }

    @Then("I verify Merchandising action with count Zero when no action is captured")
    public void merchandisingActionWithZeroCount() throws Throwable {
        promptedCountPO.merchandisingActionWithZeroCount();
    }

    @Then("I verify Print and Place Labels with count Zero when no action is captured")
    public void printAndPlaceLabelsWithZeroCount() throws Throwable {
        promptedCountPO.printAndPlaceLabelsWithZeroCount();
    }

    @Then("I click on Merchandising on Action & Next steps page")
    public void clickOnMerchandising() throws Throwable {
        promptedCountPO.clickOnMerchandising();
    }

    @Then("I click on Print & Place Labels on Action & Next steps page")
    public void clickOnPrintAndPlaceLabels() throws Throwable {
        promptedCountPO.clickOnPrintAndPlaceLabels();
    }

    @Then("I verify Print & Place Labels screen is displayed")
    public void printAndPlaceLabelScreenDisplay() throws Throwable {
        promptedCountPO.printAndPlaceLabelScreenDisplay();
    }

    @Then("I verify details on Print & Place Labels screen")
    public void detailsOnPrintAndPlaceLabel() throws Throwable {
        promptedCountPO.detailsOnPrintAndPlaceLabel();
    }

    @Then("I verify Place labels screen with Product details are displayed")
    public void detailsOnPlaceLabel() throws Throwable {
        promptedCountPO.detailsOnPlaceLabel();
    }

    @Then("I click on Place labels button")
    public void clickOnPlaceLabels() throws Throwable {
        promptedCountPO.clickOnPlaceLabels();
    }

    @Then("I verify {string} alert title is displayed")
    public void deadlineReminderName(String alertName) throws Throwable {
        promptedCountPO.deadlineReminderName(alertName);
    }

    @Then("I verify {string} alert message  is displayed")
    public void deadlineReminderMessage(String alertMessage) throws Throwable {
        promptedCountPO.deadlineReminderMessage(alertMessage);
    }

    @Then("I verify {string} message title is displayed")
    public void messageTitle(String alertName) throws Throwable {
        promptedCountPO.messageTitle(alertName);
    }

    @Then("I verify {string} message text is displayed")
    public void messageText(String alertMessage) throws Throwable {
        promptedCountPO.messageText(alertMessage);
    }

    @Then("I verify Action & Next steps screen is displayed")
    public void actionAndNextScreenDisplay() throws Throwable {
        promptedCountPO.actionAndNextScreenDisplay();
    }

    @Then("I select Label size")
    public void selectLabel() throws Throwable {
        promptedCountPO.selectLabel();
    }

    @Then("I select {string} Label size")
    public void selectLabel(String size) throws Throwable {
        promptedCountPO.verifyLabel(size);
    }

    @Then("I click on Continue Button on Request label page")
    public void clickOnContinueButton() throws Throwable {
        promptedCountPO.clickOnContinueButton();
    }

    @Then("I verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String message) throws Throwable {
        promptedCountPO.verifyMessageIsDisplayed(message);
    }

    @Then("I Select product on {string} History screen")
    public void selectProductOnHistoryScreen(String quantity) throws Throwable {
        promptedCountPO.selectProductOnHistoryScreen(quantity);
    }

    @Then("I verify REVIEW & EDIT button is displayed")
    public void verifyReviewAndEditButton() throws Throwable {
        promptedCountPO.verifyReviewAndEditButton();
    }

    @Then("I click on REVIEW & EDIT button")
    public void clickOnReviewAndEdit() throws Throwable {
        promptedCountPO.clickOnReviewAndEdit();
    }

/////////////////////////////Shrutika///////////////////////////////////////////////////////////////

    @Then("I Verify Prompte is displayed at {string}")
    public void i_Verify_Prompted_is_displayed_at(String location) throws Throwable {
        promptedCountPO.verifyPromptDisplayed(location);
    }

    @Then("I Verify Prompt {string} is displayed at {string}")
    public void i_Verify_Prompt_is_displayed_at(String message, String location) throws Throwable {
        promptedCountPO.verifymessage(message, location);
    }

    @Then("I view and click on Button {string}")
    public void i_view_and_click_on_Button(String button) throws Throwable {
        promptedCountPO.iclickButton(button);
    }


    @Then("I verify Prompt Screen all details")
    public void promptScreendetails() {
        promptedCountPO.promptedScreen();
    }


    @Then("I complete all prompted items")
    public void i_complete_all_prompted_items() throws Throwable {
        promptedCountPO.CompleteAllprompteditems();
    }

    @Then("I verify edit is allowed by updating Stock {string} at {string}")
    public void i_verify_edit_is_allowed_by_updating_Stock_at(String qty, String location) throws Throwable {
        promptedCountPO.verifyEditAllowedinReviewEdit(qty, location);
    }

    @Then("I verify unflagged items allowed to update count or action")
    public void i_verify_unflagged_items_allowed_to_update_count_or_action() throws Throwable {
        promptedCountPO.unflageditemedit();
    }


    @Then("I verify users cannot remove an action previously added")
    public void i_verify_users_cannot_remove_an_action_previously_added() throws Throwable {
        promptedCountPO.verifyusercannotremoveaction();
    }


    @Then("I mark product as flag")
    public void i_mark_product_as_flag() throws Throwable {
        promptedCountPO.doMultipleFlag();
    }

    @Then("I Verify prompted item navigated to {string}")
    public void i_Verify_prompted_item_navigated_to(String location) throws Throwable {
        promptedCountPO.verifyPreviouslocation(location);
    }

    @Then("I select item from history list to edit")
    public void i_select_item_from_history_list_to_edit() throws Throwable {
        promptedCountPO.selectitem();
    }

    @Then("I select action checkboxes")
    public void i_select_action_checkboxes() throws Throwable {
        promptedCountPO.selectactioncheckbox();
    }


    @Then("I click on icon {string}")
    public void i_click_on_icon_showlisthistory(String icon) throws Throwable {
        promptedCountPO.clickOnHistoryIcon();
    }

    @Then("I see {string}")
    public void i_see(String header) throws Throwable {
        promptedCountPO.verifyheaderText(header);
    }

    @Then("I verify {string} count Updated same as {string}")
    public void i_verify_count_Updated_same_as(String header, String qtyUpdated) throws Throwable {
        promptedCountPO.verifyEditedCount(header, qtyUpdated);
    }

    @Then("I verify Department list of outstanding count is displayed")
    public void i_verify_Department_list_of_outstanding_count_is_displayed() throws Throwable {
        promptedCountPO.departmentlistforApproval();
    }

    @Then("I verify item which need manager approvals")
    public void i_verify_item_which_need_manager_approvals() throws Throwable {
        promptedCountPO.itemlistforapproval();
    }

    @Then("I select and Approve prompted item from list")
    public void i_select_and_Approve_prompted_item_from_list() throws Throwable {
        promptedCountPO.approveitemlist();
    }

    @Then("I edit count of any {string} before approval")
    public void i_edit_count_of_any_before_approval(String location) throws Throwable {
        promptedCountPO.edititembeforeapproval(location);
    }

    @Then("I verify approved items displayed")
    public void i_verify_approved_items_displayed() throws Throwable {
        promptedCountPO.approveitemdisplayed();

    }

    @Then("I verify item details display in View Mode")
    public void i_verify_item_details_display_in_View_Mode() throws Throwable {
        promptedCountPO.verifyiteminviewmode();
    }

    @Then("I select Summary Card for {string}")
    public void i_select_Summary_Card_for(String Department) throws Throwable {
        promptedCountPO.selectSummaryCard(Department);
    }

    @Then("I verify all the list of products with Total count at the top of the screen")
    public void i_verify_all_the_list_of_products_with_Total_count_at_the_top_of_the_screen() throws Throwable {
        promptedCountPO.verifytotalcount();
    }

    @Then("I verify product list item description, MIN, Stock count, Adjustment value")
    public void i_verify_product_list_item_description_MIN_Stock_count_Adjustment_value() throws Throwable {
        promptedCountPO.verifyProductlistdescription();
    }

    @Then("I verify Adjustment value calculation agaist current stock and updated count")
    public void i_verify_Adjustment_value_calculation_agaist_current_stock_and_updated_count() throws Throwable {
        promptedCountPO.verifyadjustmentcount();
    }

    @Then("I verify updated Adjustment back on main screen after count is updated at department level")
    public void i_verify_updated_Adjustment_back_on_main_screen_after_count_is_updated_at_department_level() throws Throwable {
        promptedCountPO.verifyAdjustmentvalueondeartmentlevel();
    }


    @And("I mark single product as flag")
    public void iMarkSingleProductAsFlag() {
        promptedCountPO.doFlag();
    }


    @Then("I unflag the item with qty {string} without any action")
    public void iUnflagTheItem(String editQty) throws Throwable {
        promptedCountPO.unflagWithoutAction(editQty);
    }

    @Then("I verify the edited quantity {string} on history screen")
    public void iVerifyTheEditedQuantiyOnHistoryScreen(String editQty) throws Throwable {
        promptedCountPO.editedQtyVerification(editQty);
    }

    @And("I re-flag the item with one action")
    public void iReFlagTheItemWithOneAction() throws Throwable {
        promptedCountPO.reflagWithMarchandisingAction();
    }

    @And("I click on Back Button in Prompted Counts screen")
    public void iClickOnBackButtonInPromptedCountsScreen() throws InterruptedException {
        promptedCountPO.clickBackButton();
    }

    @And("I verify flagged item from {string} to {string} location")
    public void iVerifyFlaggedItemFromToLocation(String flaggedLocation, String verificationLocation) throws Throwable {
        promptedCountPO.verifyFlaggedItemStatusInOtherLocation(flaggedLocation, verificationLocation);
    }

    @Then("I unflag the item with qty {string} with one action")
    public void iUnflagTheItemWithQtyWithOneAction(String editQty) throws Throwable {
        promptedCountPO.unflagWithOneAction(editQty);
    }

    @And("I verify the added aciton after unflag with qty {string} on history action")
    public void iVerifyTheAddedAcitonAfterUnflagWithQtyOnHistoryAction(String editQty) throws Throwable {
        promptedCountPO.verifyActionOnUnFlaggedItem(editQty);
    }

    @And("I mark single product as flag with one action")
    public void iMarkSingleProductAsFlagWithOneAction() {
        promptedCountPO.doFlagwith1Action();
    }


    @And("I mark product as flag with all actions")
    public void iMarkProductAsFlagWithAllActions() {
        promptedCountPO.doFlagwithAllaction();
    }

    @And("I verify the added {string} aciton on history screen while flag")
    public void iVerifyTheAddedAcitonOnHistoryScreenWhileFlag(String actions) throws Throwable {
        promptedCountPO.verifyActionOnFlaggedItem(actions);
    }

    @And("I verify un-flagged item status with count in {string} location")
    public void iVerifyUnFlaggedItemStatusWithCountInLocation(String location) throws Throwable {
        promptedCountPO.verifyUnFlaggedItemStatusInOtherLocation(location);
    }


    @Then("I click on Confirm button for all products")
    public void iClickOnConfirmButtonInPromptedCounts() {
        promptedCountPO.confirmBtnForAllproductOnPlaceLabel();
    }

    @Then("I verify {string} with {string} status")
    public void iVerifyWithStatus(String deptName, String status) {
        promptedCountPO.verifyDepartmentWithStatus(deptName, status);
    }

    @Then("I click on {string} option")
    public void iClickOnOption(String arg0) throws Throwable {
        promptedCountPO.menuOption(arg0);
    }

    @And("I verify option {string} with {string} status")
    public void iVerifyOptionWithStatus(String subMenu, String status) {
        promptedCountPO.verifySubMenuWithStatus(subMenu, status);
    }


    @And("I verify the action {string} status as {string} on edit screen")
    public void iVerifyTheActionStatusAsOnEditScreen(String actionName, String status) {
        promptedCountPO.actionStatusOnEditScreen(actionName, status);
    }

    @And("I select flag item from history")
    public void iSelectFlagItemFromHistory() throws Throwable {
        promptedCountPO.selectFlagItemFromHistory();
    }

    @And("I verify {string} action status with {string} on Action & Next Steps")
    public void iVerifyActionStatusWithOnActionNextSTeps(String action, String status) {
        promptedCountPO.actionStatusOnActionAndNextSteps(action, status);
    }

    @And("I edit {string} to existing prompted item")
    public void iEditToExistingPromptedItem(String qty) throws Throwable {
        promptedCountPO.EditToExistingPromptedItem(qty);
    }

    @And("Verify the updated quantity")
    public void verifyTheUpdatedQuantity() {
        promptedCountPO.verifyUpdatedQuantity();
    }





}
