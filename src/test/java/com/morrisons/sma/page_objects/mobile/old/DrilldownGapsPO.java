package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;
import com.morrisons.sma.page_objects.service.GlhSummaryService;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import org.openqa.selenium.interactions.Actions;

public class DrilldownGapsPO {
	
	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static List<String> departmentNameList = new ArrayList<String>();
	GlhSummaryService glhSummary_Service = new GlhSummaryService();


	public DrilldownGapsPO()
	{
	this.driveR = (AndroidDriver) Hook.getDriver();
	
	}

	public void verifySortingorder() {
		ArrayList<String> obtainedList = new ArrayList<>(); 
		List<WebElement> elementList= driveR.findElements(By.xpath(("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.LinearLayout[@index='0']")));
		for(WebElement we:elementList){
		   obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();   
		for(String s:obtainedList){
		sortedList.add(s);
		}
		Collections.sort(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}

	public void verifyCountTotal(String scan, String sf, String ic) {
		
		
		boolean isTotalPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='Total' or @text='total']")).isDisplayed();
		assertEquals(isTotalPresent, true, "Total is not present on Glh Summary page");
				
		String isScanCountPresent = driveR.findElement(By.id(""+env+":id/footer_second_value")).getText();
		assertEquals(isScanCountPresent, scan, "Total Scan count is not present on Glh Summary page");

		String isSfCountPresent = driveR.findElement(By.id(""+env+":id/footer_third_value")).getText();
				assertEquals(isScanCountPresent, sf, "Total SF count is not present on Glh Summary page");
		
		String isICpresent = driveR.findElement(By.id(""+env+":id/footer_fourth_value")).getText();
		assertEquals(isICpresent, ic, "Total IC count is not present on Glh Summary page");


		
	}

	public void verifyCountSectionlevel(String scan, String sf, String ic) {
		String isScanCountPresent = driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'text_lows')")).getText();
		assertEquals(isScanCountPresent, scan, "Scan count is not present at section level");

		String isSfCountPresent = driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'text_stock')")).getText();
		assertEquals(isSfCountPresent, sf, "SF count is not present at section level");

		String isICpresent = driveR.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'text_incomplete')")).getText();
		assertEquals(isICpresent, ic, "IC count is not present at section level");


	}

	public void verifySummarySectionlevel(String categoryName,String sScan, String sSF, String incomplete) throws Throwable {
		String ic = null, scan = null, sf = null;
		List<WebElement> oDept = driveR.findElements(By.xpath("//android.widget.LinearLayout"));
		//=========================================
		for(int i=0;i<oDept.size();i++) {
			try {
				List<WebElement> oLevel = oDept.get(i).findElements(By.xpath("//android.widget.TextView"));
				//for (int j = 0; j < oLevel.size(); j++) {
					if (oLevel.get(0).getText().equalsIgnoreCase(categoryName)) {
						ic = oLevel.get(3).getText();
						scan = oLevel.get(1).getText();
						sf = oLevel.get(2).getText();
						break;
					}
				//}
			}
			catch(Exception e){
			}
		}
		//==============================================
		//String ic =driveR.findElement(By.xpath("//parent::android.widget.TextView[@text='"+categoryName+"']/following-sibling::android.widget.TextView[@resource-id='" + env + ":id/text_incomplete']")).getText();
		//String ic =driveR.findElement(By.xpath("//android.widget.TextView[@text='"+categoryName+"']|/android.widget.TextView[@index='2']")).getText();


		System.out.println("IC Count:---" + ic);

		System.out.println("capture type--" + scan);
		String eXpected = incomplete;
		System.out.println("Actuall IC --" + sf);
		assertEquals(ic, eXpected);
		String expectedScan = sScan;
		assertEquals(scan, expectedScan);
		String expectedSF = sSF;
		assertEquals(sf, expectedSF);

	}

	public void verifyCountDepartmentlevel(String scan, String sf, String ic) {
//	driveR.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.Button[contains(@resource-id,'digit5') and @index='1']")).getText();
//print text herer
	}

	public void verifyheader() {
		boolean isScanPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='Scans' or @text='scans']")).isDisplayed();
		assertEquals(isScanPresent, true, "Scan is not present in header");

		boolean isSFPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='SF' or @text='sf']")).isDisplayed();
		assertEquals(isSFPresent, true, "SF is not present in header");

		boolean isICPresent = driveR.findElement(By.xpath("//android.widget.TextView[@text='IC' or @text='ic']")).isDisplayed();
		assertEquals(isICPresent, true, "IC is not present in header");

	}

	public void verifySection(String section1, String section2, String section3, String section4, String section5,String section6) {
		int ctr = 0;
	try {
		boolean Section1 = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + section1 + "']")).isDisplayed();
		assertEquals(Section1, true, "Section is not present");

		boolean Section2 = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + section2 + "']")).isDisplayed();
		assertEquals(Section2, true, "Section is not present");

		boolean Section3 = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + section3 + "']")).isDisplayed();
		assertEquals(Section3, true, "Section is not present");

		boolean Section4 = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + section4 + "']")).isDisplayed();
		assertEquals(Section4, true, "Section is not present");

		boolean Section5 = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + section5 + "']")).isDisplayed();
		assertEquals(Section5, true, "Section is not present");

		boolean Section6 = driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + section6 + "']")).isDisplayed();
		assertEquals(Section6, true, "Section is not present");
	}
	catch(NoSuchElementException ne){
		String uiSelector = "new UiSelector().textMatches(\"" + section6
				+ "\")";

		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
				+ uiSelector + ");";

		driveR.findElementByAndroidUIAutomator(command);
			verifySection(section1, section2, section3, section4, section5, section6);

	}

	}

	public void clickDepartment(String department) {
	   // driveR.findElement(By.id(""+env+":id/summary_list_row_layout")).click();
		 driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + department + "']")).click();
	}

	public void verifyArrow() {
	boolean isArrowPresent = driveR.findElement(By.id(""+env+":id/expand_icon")).isDisplayed();
	assertEquals(isArrowPresent, true, "Arrow is not present on Department");

	}

	public void verifyDisplay(String department) {
		boolean isDepartment = ElementRetry.waitForElementVisible(driveR, driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + department + "']")));
		//boolean isDepartment = ElementRetry.checkElementExist(driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + department + "']")));
		//boolean isDepartment =	driveR.findElement(By.xpath("//android.widget.TextView[@text= '" + department + "']")).isDisplayed();
		assertEquals(isDepartment, true, department + "Department is not present...");


	}

	
	public void verifyAlertDisplay(String alertName) {
		driveR.findElement(By.xpath("//*[@text= '" + alertName + "']")).isDisplayed();
	
	}	
	


	public List<String> getDepartmentList() throws Throwable {

		int i = 1;
		while(i<5)
		{
			List<WebElement> xpathDepartmentsList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/department_text']"));
			System.out.println("DepartmentsList size : " + departmentNameList.size());
			try{
				for(WebElement xpathDept : xpathDepartmentsList){
					String deptName = xpathDept.getText();

					if(!deptName.equals("Department") && !departmentNameList.contains(deptName)){
						System.out.println("Department name : " + deptName);
						departmentNameList.add(deptName);
					}
				}
				i++;

				Thread.sleep(2000);
				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(300, 390)).release().perform();
			}

			catch(Exception e){}
		}
		return departmentNameList;
	}
////Verifying Departments On UI and Service matches
	public void verifyDeptOnUIAndService() throws Throwable {

		boolean isEqual = false;
		List<String> deptListService = glhSummary_Service.glhMSglhDepartments;

		System.out.println("Department list Service : " + deptListService);
		System.out.println("Department list UI : " + departmentNameList  );
		Collections.sort(departmentNameList);
		Collections.sort(deptListService);
		if(departmentNameList.equals(deptListService)){
			isEqual = true;
		}
		assertEquals(isEqual, true,"Department list on UI and service mismatches");
	
	}

	public void verifySummaryScreenOrder(String section, String scan, String sF, String iC) {
		//String sectionName = driveR.findElement(By.xpath("//android.widget.LinearLayout[@index = '5']"));
		//String sectionName = driveR.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'department_text')]")).getText();
				

		//assertEquals(sectionName,section,"mismatch");
	}
	
	
	
	}


	
	


