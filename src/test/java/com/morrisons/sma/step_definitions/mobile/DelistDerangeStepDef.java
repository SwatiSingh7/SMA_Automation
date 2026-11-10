package com.morrisons.sma.step_definitions.mobile;


import com.morrisons.sma.page_objects.mobile.DLDRPO;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.Locale;

public class DelistDerangeStepDef {

    private final Logger log = Logger.getLogger(DelistDerangeStepDef.class);
    DLDRPO dldrPO = new DLDRPO();

    @And("I should get a Message {string} and should be able to click the {string} Button")
    public void verifyMessageNClickOnOk(String message, String button) throws Throwable {
        switch (button.toUpperCase(Locale.ROOT)) {
            case "OK":
                dldrPO.verifyMessageNClickOnOk(message);
                break;
            case "YES":
                //popUpPONew.verifyMessageNClickOnDone(message);
                break;
            default:
                log.error("No Such Button : " + button);
                Assert.fail("No Such Button : " + button);

        }
    }

    @And("I verify Blue tag Icon and Text is displayed")
    public void verifyBlueTagSignAndText() throws Throwable {
        dldrPO.verifyBlueTagSignAndText();
    }
}