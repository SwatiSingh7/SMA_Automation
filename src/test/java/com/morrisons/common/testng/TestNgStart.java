package com.morrisons.common.testng;

import com.google.inject.Inject;
import com.morrisons.common.utility.ApplicationConfig;
import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestNgStart {

    private final Logger log = Logger.getLogger(TestNgStart.class);

    @Inject
    private ApplicationConfig applicationConfig;

    @Inject
    private TestNG tng;

    public void testNgXmlSuite() {
        try {
            List<XmlSuite> suites = new ArrayList<>();

            List<XmlClass> promotionClass = new ArrayList<>();
            List<XmlClass> productClass = new ArrayList<>();
            List<XmlClass> priceClass = new ArrayList<>();
            List<XmlClass> CountsClass = new ArrayList<>();

            List<XmlClass> classes6 = new ArrayList<>();

            List<Class> listenerClasses = new ArrayList<Class>();

            String projectPath = System.getProperty("user.dir");
            XmlSuite suite = new XmlSuite();
            suite.setName("SMA Mobile Automation");

            XmlTest CountsTest = new XmlTest(suite);
            CountsTest.setName("Regression Pack for Counts");

            log.info("Checker  " + applicationConfig.getActionConfiguration().isMarketStreet);

            if (applicationConfig.getActionConfiguration().isMarketStreet == Boolean.TRUE) {

                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.MarketStreetRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isAM_Counts);

            if (applicationConfig.getActionConfiguration().isAM_Counts == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.AMCountRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isPM_Count);

            if (applicationConfig.getActionConfiguration().isPM_Count == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.PMCountRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isStockAdjustment);

            if (applicationConfig.getActionConfiguration().isStockAdjustment == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.StockAdjustmentRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isStockInformation);

            if (applicationConfig.getActionConfiguration().isStockInformation == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.StockInformationRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isAM_GLH);

            if (applicationConfig.getActionConfiguration().isAM_GLH == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.AMGLHRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isPM_Gap);

            if (applicationConfig.getActionConfiguration().isPM_Gap == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.PMGapRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  "
                    + applicationConfig.getActionConfiguration().getCleanAndRotate_Action().isCnR_Functionality);

            if (applicationConfig.getActionConfiguration()
                    .getCleanAndRotate_Action().isCnR_Functionality == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.CnRFunctionalityRunner");
                CountsClass.add(setCountsClass);
            }

            log.info(
                    "Checker  " + applicationConfig.getActionConfiguration().getCleanAndRotate_Action().isCnR_2_3);

            if (applicationConfig.getActionConfiguration().getCleanAndRotate_Action().isCnR_2_3 == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.CnR_2_3_Runner");
                CountsClass.add(setCountsClass);
            }

            log.info("Checker  "
                    + applicationConfig.getActionConfiguration().getCleanAndRotate_Action().isCnR_CrispScenario);

            if (applicationConfig.getActionConfiguration()
                    .getCleanAndRotate_Action().isCnR_CrispScenario == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.CnRCrispRunner");
                CountsClass.add(setCountsClass);
            }

            log.info("Checker  "
                    + applicationConfig.getActionConfiguration().getCleanAndRotate_Action().isCnR_SignOffScenario);

            if (applicationConfig.getActionConfiguration()
                    .getCleanAndRotate_Action().isCnR_SignOffScenario == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.CnRSignOffRunner");
                CountsClass.add(setCountsClass);
            }

            log.info("Checker  "
                    + applicationConfig.getActionConfiguration().getCleanAndRotate_Action().isCnR_WeeklyAlert);

            if (applicationConfig.getActionConfiguration()
                    .getCleanAndRotate_Action().isCnR_WeeklyAlert == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.CnRWeeklyAlertRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isMarkdown);

            if (applicationConfig.getActionConfiguration().isMarkdown == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.MarkdownRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isGLHBurst);

            if (applicationConfig.getActionConfiguration().isGLHBurst == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.GlhBurstRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isPriceIntegrity);

            if (applicationConfig.getActionConfiguration().isPriceIntegrity == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.PriceIntegrityRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isNegativePromt);

            if (applicationConfig.getActionConfiguration().isNegativePromt == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.GlhNegativePromptRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isSalesOrder);

            if (applicationConfig.getActionConfiguration().isSalesOrder == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.SalesOrderRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isGlhDrillDown);

            if (applicationConfig.getActionConfiguration().isGlhDrillDown == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.GlhDrilldownRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isIntegratedSales);

            if (applicationConfig.getActionConfiguration().isIntegratedSales == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.IntegratedSalesRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isforgotPassword);

            if (applicationConfig.getActionConfiguration().isforgotPassword == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.ForgotPasswordRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isEasyStore);

            if (applicationConfig.getActionConfiguration().isEasyStore == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.EasyStoreRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isFreshCodeCheck);

            if (applicationConfig.getActionConfiguration().isFreshCodeCheck == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.FCCRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isRFID);

            if (applicationConfig.getActionConfiguration().isRFID == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.RFIDRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isStockAdjustment);

            if (applicationConfig.getActionConfiguration().isStockAdjustment == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.StockAdjustmentRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isWasteValidation);

            if (applicationConfig.getActionConfiguration().isWasteValidation == Boolean.TRUE) {
                log.info("Calling Waste Validation Runner");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.runners.mobile.WasteValidationRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isPromptedCount);

            if (applicationConfig.getActionConfiguration().isPromptedCount == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.PromptedCountRunner");
                CountsClass.add(setCountsClass);

            }

            log.info("Checker  " + applicationConfig.getActionConfiguration().isDLDR);

            if (applicationConfig.getActionConfiguration().isDLDR == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.runners.mobile.DLDRRunner");
                CountsClass.add(setCountsClass);

            }
            
            log.info("Checker  " + applicationConfig.getActionConfiguration().isTwilightManager);

            if (applicationConfig.getActionConfiguration().isTwilightManager == Boolean.TRUE) {
                log.info("Inside loop");
                XmlClass setCountsClass = new XmlClass("com.morrisons.sma.smaRunner.TwilightManagerRunner");
                CountsClass.add(setCountsClass);

            }


            listenerClasses.add(ListenerTest.class);

            CountsTest.setXmlClasses(CountsClass);

            suite.setParallel("parallel test execution");
            suites.add(suite);
            log.info(suites);

            tng.setXmlSuites(suites);
            // tng.setListenerClasses(listenerClasses);

            log.info("Prject path in testNG: " + projectPath);

            tng.setOutputDirectory(projectPath + "/Output");
            tng.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
