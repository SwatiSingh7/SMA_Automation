package com.morrisons.sma.step_definitions.mobile.countOptimization;

import com.morrisons.sma.page_objects.mobile.cleanAndRotate.EnterMin;
import com.morrisons.sma.page_objects.mobile.countOptimization.*;
import com.morrisons.sma.page_objects.mobile.mins.EnterMINPO_New;
import com.morrisons.sma.page_objects.service.countOptimisation.StorewalkService;
import com.morrisons.sma.step_definitions.mobile.cleanAndRotate.GetDeptAndMin;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class CountOptimizationHomePageStepDefs {
    private final Logger log = Logger.getLogger(CountOptimizationHomePageStepDefs.class);

    CountOptimizationHomePage countOptimizationHomePage = new CountOptimizationHomePage();
    StockManagement stockManagement = new StockManagement();
    ScheduledCount scheduledCount = new ScheduledCount();
    StorewalkService storewalkService = new StorewalkService();
    WareHousePage wareHousePage = new WareHousePage();
    FixturePage fixturePage = new FixturePage();
    OffShelf offShelfPage = new OffShelf();
    EnterMINPO_New enterMINPO_New = new EnterMINPO_New();
    EnterMin enterMin = new EnterMin();
    PetrolPage petrolPage = new PetrolPage();
    ReviewPage reviewPage=new ReviewPage();

    @Then("I verify all the details present on Homepage and {string} is displayed")
    public void verifyCountOptimisationHomepage() throws Throwable {
        countOptimizationHomePage.verifyCountOptimizationHomePage();
    }

    @Then("I click on {string} on Count Optimisation HomePage")
    public void clickOnStockManagement(String option) throws Throwable {
        countOptimizationHomePage.clickOnCOHomePageOption(option);
    }

    @Then("I verify all the details present on StockManagement page")
    public void verifyStockManagement(String option) throws Throwable {
        stockManagement.verifyStockManagement();
    }

    @Then("I click on Scheduled Count Option")
    public void clickOnScheduledCount() throws Throwable {
        Thread.sleep(5000);

        stockManagement.clickOnScheduledCount();
    }

    @Then("I verify Count is visible on UI with same {string}")
    public void verifyCountDescription(String countName) throws Throwable {
//        countname = createCountService.getCreateCountResponse();
        log.info("countname" + storewalkService.createCountResponseinRetur);
        scheduledCount.verifyScheduleCountHeader(countName);

    }

    @Then("I verify all location is visible")
    public void verifyLocation() throws Throwable {
        scheduledCount.verifyCountLocationVisible();

    }

    @Then("I verify offshelf location is disabled")
    public void verifyOffshelfLocation() throws Throwable {
        scheduledCount.verifyLocationDisabled();

    }

    @Then("I click on Warehouse locations")
    public void clickOnWarehouseLocation() throws Throwable {
        scheduledCount.clickOnWarehouse();

    }
    @Then("I confirm start time pop up {string} should be displayed")
    public void verifyAlert(String alertText) throws Throwable{
        scheduledCount.verifyAlert(alertText);
    }
    @Then("I confirm end time pop up {string} should be displayed")
    public void verifyEndTimeAlert(String alertText) throws Throwable{
        scheduledCount.verifyCountElapsedAlert(alertText);
    }


    @Then("I verify Reopen Location is enabled  and click on Reopen Location")
    public void verifyReopenLocation() throws Throwable {
        wareHousePage.verifyReopenLocation();

    }
    @Then("I verify MIN ,PIN ,Case details are displayed")
    public void verifyItemDetailsDisplayed() throws Throwable {
        wareHousePage.verifyItemDetails();

    }


    @Then("I verify Reopen Count location alert is displayed and I click on it")

    public void verifyReopenCount() throws Throwable{
        wareHousePage.verifyReopenLocationAlert();
    }



    @Then("I verify list of items present in Warehouse")
    public void verifyListofItemsinWareHouse() throws Throwable {
        wareHousePage.iGetProductMins();

    }

    @Then("I enter the quantity as {string} in Offshelf")
    public void enterItemsQtyinOffshelf(String productMin) throws Throwable {
        log.info("productMin-in stepdef----------------------------------" + productMin);
        offShelfPage.iEnterProductQtyOffshelf(productMin);

    }

    @Then("I enter the quantity as {string} in Petrol")
    public void enterItemsQtyinPetrol(String productMin) throws Throwable {
        log.info("productMin-in stepdef----------------------------------" + productMin);
        petrolPage.iEnterProductQtyPetrol(productMin);

    }

    @Then("I verify petrol plan is available")
    public void verifyPetrolPlan(){
        petrolPage.verifyPetrolPlan();

    }


    @Then("I enter the quantity as {string} in WareHouse")
    public void enterItemsQuantity(String qty) throws Throwable {
        log.info("productMin-in stepdef----------------------------------" + qty);
        wareHousePage.iEnterProductQty(qty);

    }


    @Then("I click on View list of products in Warehouse")
    public void clickOnViewList() throws Throwable {
        wareHousePage.clickOnViewList();

    }

    @Then("I click on View list of products in Petrol")
    public void clickOnPetrolList() throws Throwable {
        petrolPage.clickOnViewList();

    }


    @Then("I click on View list of products in Fixture")
    public void clickOnViewListinFixure() throws Throwable {
        fixturePage.iClickOnViewList();

    }

    @Then("I click on View list of products in Offshelf")
    public void clickOnViewListinOffshelf() throws Throwable {
        offShelfPage.iClickOnViewList();

    }


    @Then("I complete WareHouse location")
    public void completeLocation() throws Throwable {
        wareHousePage.completeWareHouse();
    }

    @Then("I complete Fixture location")
    public void completeFixtureLocation() throws Throwable {
        Thread.sleep(3000);
        fixturePage.completeFixture();

    }

    @Then("I complete Offshelf location")
    public void completeOffshelfLocation() throws Throwable {
        offShelfPage.completeOffshelf();
    }

    @Then("I complete Petrol location")
    public void completePetrolLocation() throws Throwable {
        petrolPage.completePetrol();
    }
    @Then("I confirm to complete the count")
    public void confirmLocation() throws Throwable {
        petrolPage.completeLocations();
    }
    @Then("I Click on Fixture location")
    public void clickOnFixtureLocation() throws Throwable {
        scheduledCount.clickOnFixture();

    }
    @Then("I Click on Offshelf location")
    public void clickOnOffshelfLocation() throws Throwable {
        scheduledCount.clickOnOffshelf();

    }

    @Then("I verify {string} is not present in the list")
    public void itemNotDisplayed(String barCode) {

        fixturePage.VerifyItemNotDisplayed(barCode);

    }

    @Then("I verify user is redirected to {string}")
        public void verifyUserRedirected(String countName){
            fixturePage.verifyCountName(countName);


    }



    @Then("I verify list of items present in Fixture")
    public void verifyListofItemsinFixture() throws Throwable {
        fixturePage.iGetProductMinsinFixture();

    }

    @Then("I verify MIN ,Aisle,Bay,Shelf,Position details are displayed")

    public void verifyItemDetailsinFixture() throws Throwable {
        fixturePage.iGetProductDetailsinFixture();

    }

    @Then("I enter the quantity as {string} in Fixture")
    public void enterItemsQuantityinFixture(String qty) throws Throwable {
        log.info("productMin-in stepdef----------------------------------" + qty);
        fixturePage.iEnterProductQtyinFixture(qty);

    }

    @Then("I verify Add To Count ,Edit Count Button is enabled")
    public void verifyUpdateCount() throws Throwable {
        fixturePage.verifyUpdateCountisible();
    }

    @Then("I click on Add to Count")
    public void clickAddCount() throws Throwable {
        Thread.sleep(5000);
        fixturePage.clickOnAddCount();
    }

    @Then("I click on Edit Count")
    public void clickEditCount() throws Throwable {
        fixturePage.editCount();
    }

    @Then("I update quantity{string} and Confirm")
    public void updateQuantity(String qty) throws Throwable {
        fixturePage.updateQuantity(qty);
    }

    @Then("I verify Offshelf location is enabled")
    public void verifyOffshelf() throws Throwable {
        scheduledCount.verifyLocationEnabled();
    }

    @Then("I click on delete button to delete the count")
    public void deleteCount() throws Throwable {
        fixturePage.deleteCapture();
    }

    @Then("I verify Delete Count pop up is displayed")
        public void verifyDeleteAlertDisplayed() {
            fixturePage.deleteAlertDisplayed();

    }

    @Then("I click on Offshelf location")
    public void clickOnOffshelf() throws Throwable {
        scheduledCount.clickOnOffshelf();
    }

    @Then("I click on Petrol location")
    public void clickOnPetrol() throws Throwable {
        scheduledCount.clickOnPetrol();
    }


    @Then("I verify list of items present in Offshelf")
    public void verifyOffshelfProducts() throws Throwable {
        offShelfPage.iGetProductMinOffshelf();
    }
    @Then("I verify list of items present in Petrol")
    public void verifyPetrolProducts() throws Throwable {
        petrolPage.iGetProductMininPetrol();
    }

    @Then("I enter the quantity as {string} in OffShelf")
    public void enterItemQuantity(String qty) throws Throwable {
        log.info("productMin-in stepdef----------------------------------" + qty);
        offShelfPage.iEnterProductMinOffshelf(qty);

    }

    @Then("I Enter Product Min {string} and click on search")
    public void enterItem(String itemID) throws Throwable {
        enterMINPO_New.clickOnBarCodeIcon();
        String enterProductMin = itemID;
        log.info("Entering Product min : " + enterProductMin);
        enterMin.enterProductMin(enterProductMin);

    }

    @Then("I verify count is not in TO DO tab")
    public void verifyCountNotDisplayed() throws InterruptedException {
        scheduledCount.countNotDisplayed();
    }

    @Then("I Click on the the Count")
    public void clickOnCount() throws InterruptedException {
        scheduledCount.clickOnView();
    }
    @Then("I verify all the item details are present for complete count in Review section")
    public void verifyItemsinCount() throws InterruptedException {
        scheduledCount.verifyProductDetailsDisplayed();
    }
    @Then("I click on the product")
    public void clickonItem() throws InterruptedException {
        scheduledCount.clickItem();
    }
    @Then("I click on approvals to approve the item")
    public void clickOnApprovals() throws InterruptedException{
            scheduledCount.clickonApproval();

    }

    @Then("I Click on approvals and verify approve button is disabled")
    public void clickOnApprovalsDisabled(){
        scheduledCount.clickonApprovalforColuser();
    }

    @Then("I verify approval confirm alert box displayed and confirm it")
    public void confirmAlertDisplayed(){
        scheduledCount.alertDisplayed();
    }
    @Then("I verify item is displayed in Approval section")
    public void itemApprovalPending(){
        reviewPage.approvalPending();
    }
    @Then("I click on product in Approval section")

        public void itemClick(){
        reviewPage.itemClick();

        }
    @Then("I edit the capture in Warehouse location")

    public void editCaptureInWareHouse(){
        reviewPage.editCapture();
    }

    @Then("I verify approval count is Zero")
    public void verifyNoApprovalpending() throws InterruptedException {
        reviewPage.approvalNotPending();
    }


    @Then("I Click on approvals and verify no item is present")
    public void verifyUpdatedApprovals() throws InterruptedException {
        scheduledCount.clickonApproval();
        reviewPage.approvalNotPending();
    }


    @Then("I click on Review and verify count{string} is visible and status is {string}")
    public void verifyCountStatus(String countName,String status){

       scheduledCount.verifyCountStatus(countName,status);

    }
    @Then("I verify all the locations are unchecked")
    public void verifyStoresUnchecked(){

        scheduledCount.verifyUncheckedStatus();
    }
    @Then("I verify all the locations are checked")
    public void verifyStoreCheckedStatus(){
        scheduledCount.verifyCheckedStatus();

    }
    @Then("I Click on approvals and verify button is disabled in Approval section")
    public void ClickandVerifyApprovalButtonDisabled(){
        scheduledCount.clickonApproval();

        scheduledCount.clickonApprovalforColuser();

    }

}
