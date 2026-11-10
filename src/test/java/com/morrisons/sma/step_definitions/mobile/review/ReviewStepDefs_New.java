package com.morrisons.sma.step_definitions.mobile.review;

import com.morrisons.common.helper.DateHelper;
import com.morrisons.sma.page_objects.mobile.wastevalidation.ReviewPO_New;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

import java.util.List;

public class ReviewStepDefs_New {

    private final Logger log = Logger.getLogger(ReviewStepDefs_New.class);
    ReviewPO_New reviewPONew = new ReviewPO_New();

    @And("I click on {string} tab and verify the following details")
    public void iClickOnTabAndVerifyTheFollowingDetails(String tab, List<String> detailsList) throws Throwable {
        reviewPONew.clickOnTabAndverifyIfDisplayed(tab,
                detailsList.get(0),
                detailsList.get(1),
                detailsList.get(2),
                detailsList.get(3),
                detailsList.get(4),
                detailsList.get(5));
    }

    @And("I verify the headers of review option")
    public void iVerifyTheHeaderOfReview() throws Throwable {
        reviewPONew.verifyTab("All");
        reviewPONew.verifyTab("Pass");
        reviewPONew.verifyTab("Fail");
        /*boolean result = true;
        result = checkElementExist(reviewPONew.allTab);
        if (result) {
            log.info("Review header 'ALL' is verified");
        } else {
            Assert.fail("Review header 'ALL' verification failed.");
        }
        reviewPONew.veirfyReviewEnabled();
        result = checkElementExist(reviewPONew.passTab);
        if (result) {
            log.info("Review header 'PASS' is verified");
        } else {
            Assert.fail("Review header 'PASS' verification failed.");
        }
        result = checkElementExist(reviewPONew.failTab);
        if (result) {
            log.info("Review header 'FAIL' is verified");
        } else {
            Assert.fail("Review header 'FAIL' verification failed.");
        }*/
    }

    @And("I click on tab {string}")
    public void iClickOnTab(String tab) throws Throwable {
        reviewPONew.clickOnTab(tab);
    }

    @And("I verify Review screen message")
    public void iVerifyReviewScreenMessage() {
        reviewPONew.verifyMessageOfReviewScreen();
    }

    @And("I verify the date on Review page")
    public void iVerifyDateOnReview() throws Throwable {
        String expected = DateHelper.getCurrentDateAsHeader();
        reviewPONew.veirfyHeaderDate(expected);
        /*String actual = reviewPONew.reviewHeaderDate.getText();
        boolean result = true;
        org.testng.Assert.assertEquals(actual, expected, "Failed to verify Review date. ");*/
    }

    @And("I verify the waste reversal min {string}")
    public void iVerifyTheWasateReversalMinItShouldBeNotDisplay(String min) {
        reviewPONew.verifyWaseteReverseMIN(min);
    }


    @And("I click on {string} and verify {string}")
    public void iClickOnAndVerifyMessage(String tab, String message) throws Throwable {
        reviewPONew.clickTabVerifyReviewScreenMessage(tab, message);
    }

}
