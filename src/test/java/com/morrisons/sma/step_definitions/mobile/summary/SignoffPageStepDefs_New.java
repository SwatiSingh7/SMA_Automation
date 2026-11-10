package com.morrisons.sma.step_definitions.mobile.summary;

import com.morrisons.sma.page_objects.mobile.summary.SignOffScreenPO_New;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;

public class SignoffPageStepDefs_New {

    private final Logger log = Logger.getLogger(SignoffPageStepDefs_New.class);
    SignOffScreenPO_New SignOffScreenPONew= new  SignOffScreenPO_New();

    @And("I verify Store manager weekly sign off at top")
    public void iVerifyStoreManagerWeeklySignOffAtTop() {
        SignOffScreenPONew.verifytoreManagerWeeklySignOffAtTop();
    }

    @And("I verify date of previous week at top")
    public void iVerifyDateOfPreviousWeekAtTop() {
        SignOffScreenPONew.verifyDateOfPreviousWeekAtTop();
    }

    @And("I verify four check boxes")
    public void iVerifyFourCheckBoxes() {
        SignOffScreenPONew.VerifyFourCheckBoxes();
    }

    @And("I verify Reviewed the weekly activity is displayed")
    public void iVerifyReviewedTheWeeklyActivityIsDisplayed() {
        SignOffScreenPONew.VerifyReviewedTheWeeklyActivityI();
    }

    @And("I verify Reviewed all in store waste areas and confirm all waste in areas conforms to policy is displayed")
    public void iVerifyReviewedAllInStoreWasteAreasAndConfirmAllWasteInAreasConformsToPolicyIsDisplayed() {
        SignOffScreenPONew.verifyyReviewedAllInStoreWasteAreas();
    }

    @And("I verify Spoken to departments with high unrecorded waste is displayed")
    public void iVerifySpokenToDepartmentsWithHighUnrecordedWasteIsDisplayed() {
        SignOffScreenPONew.VerifySpokenToDepartmentsWithHighUnrecordedWaste();
    }

    @And("I verify Actions next steps documented is displayed")
    public void iVerifyActionsNextStepsDocumentedIsDisplayed() {
        SignOffScreenPONew.VerifyActionsNextStepsDocumented();
    }

    @And("I verify Able to view text field to write comments if any is displayed")
    public void iVerifyAbleToViewTextFieldToWriteCommentsIfAnyIsDisplayed() {
        SignOffScreenPONew.VerifyAbleToViewTextFieldToWriteComments();
    }

    @And("I verify Please confirm that you have completed the following before signing off is displayed")
    public void iVerifyPleaseConfirmThatYouHaveCompletedTheFollowingBeforeSigningOffIsDisplayed() {
        SignOffScreenPONew.verifyPleaseConfirmThatYouHaveCompleted();
    }

    @And("I able to check all boxes and click sign off")
    public void iAbleToCheckAllBoxesAndClickSignOff() {
        SignOffScreenPONew.clickcheckbox();
        SignOffScreenPONew.clicksignoffbutton();

    }
}
