package com.morrisons.sma.runners.mobile;

import com.morrisons.common.testng.CustomAbstractTestNGCucumberTestsWithTag;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features   =  {"classpath:sma_features_new"},
        glue       =  {"com/morrisons/sma/step_definitions/mobile",
                        "com/morrisons/sma/step_definitions/database",
                        "com/morrisons/common/action",
                        "com/morrisons/sma/step_definitions/service",
                        "com/morrisons/sma/step_definitions/Web"},
        dryRun     =   false,
        monochrome =   true,
        plugin     =   {"pretty", "json:target/customgenericrunnerwithtag.json",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Runner extends CustomAbstractTestNGCucumberTestsWithTag {

}
