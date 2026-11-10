package com.morrisons.sma.step_definitions.mobile;

import com.morrisons.sma.page_objects.mobile.old.MarkDownPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LogoutStepDef {

    MarkDownPO markDownPage = new MarkDownPO();

    @And("I logout of the system")
    public void i_logout_of_the_system() throws Throwable {
        markDownPage.selectHotKey();
    }


}

