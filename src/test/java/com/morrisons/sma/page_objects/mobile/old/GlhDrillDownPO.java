package com.morrisons.sma.page_objects.mobile.old;

import static com.morrisons.common.helper.MobileHelper.ScrolltoElementWithText;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.morrisons.common.helper.MobileHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.sma.page_objects.service.GlhSummaryService;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class GlhDrillDownPO {


	private static AndroidDriver driveR;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	static int iRepeat, iRepeat1;
	public static int gapsCount = 0;
	public static int lowsCount = 0;
	public static int highsCount = 0;
	public static int categoryName = 0;
	public static int sFCount = 0;
	public static int sRCount = 0;
	public static int iCCount = 0;

	public static int gapsTotalCount = 0;
	public static int gaps_SFCount = 0;
	public static int gaps_SRCount = 0;
	public static int gaps_ICCount = 0;

	public static int highsTotalCount = 0;
	public static int highs_ICCount = 0;

	public static int lowsTotalCount = 0;
	public static int lows_SFCount = 0;
	public static int lows_ICCount = 0;

	public static List<String> departmentNameList = new ArrayList<String>();
	public static Map<String,List<String>> deptSectionList = new HashMap<String,List<String>>();

	GlhSummaryService glhSummary_Service = new GlhSummaryService();

	public static List<String> specificDeptSectionList = new ArrayList<String>();

	public static int section1IndexBefore = 0;
	public static int section2IndexBefore = 0;
	public static int section1IndexAfter = 0;
	public static int section2IndexAfter = 0;

	public static int section1Count = 0;
	public static int section2Count = 0;

	public static int dept1Count = 0;
	public static int dept2Count = 0;

	public static String captureType = null;
	public static String count = null;

	public GlhDrillDownPO()
	{
		this.driveR = (AndroidDriver) Hook.getDriver();

	}

	
	////Verifying Gaps, Highs andLows tabs are present on Glh summary page
	public void verifyGapsCountTab() throws Throwable {

		WebElement xpathGapsTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='GAPS' or @text='Gaps']"));
		boolean isGapTabPresent = xpathGapsTab.isDisplayed();
		assertEquals(isGapTabPresent, true, "Gap tab is not present on Glh Summary page");

		WebElement xpathLowsTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='COUNT' or @text='Count']"));
		boolean isLowTabPresent = xpathLowsTab.isDisplayed();
		assertEquals(isLowTabPresent, true, "Low tab is not present on Glh Summary page");

	}

	/////Gaps tab
	//// Verifying Gaps tab Summary page header columns text => Department, Gaps, +SR, SF and IC.
	public void verifyGapsSummaryHeaderColumns() throws Throwable {

		WebElement xpathDepartmentColumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/department_text']"));
		String departmentHeader = xpathDepartmentColumn.getText();
		assertEquals(departmentHeader, "Department", "Department column name is mismatched");

		WebElement xpathGaps = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_first']"));
		String gapsText = xpathGaps.getText();
		assertEquals(gapsText, "Gaps", "Gaps tab column name is mismatched");

		WebElement xpathSRcolumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_second']"));
		String SRText = xpathSRcolumn.getText();
		assertEquals(SRText, "+SR", "SR column name is mismatched");

		WebElement xpathSFcolumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_third']"));
		String SFText = xpathSFcolumn.getText();
		assertEquals(SFText, "SF", "SF column name is mismatched");

		WebElement xpathICcolumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_fourth']"));
		String ICText = xpathICcolumn.getText();
		assertEquals(ICText, "IC", "IC column name is mismatched");
	}

	public void verifyGapsSummaryFooter() throws Throwable {

		WebElement xpathTotalColumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/total_text']"));
		boolean totalColumn = xpathTotalColumn.isDisplayed();
		String totalText = xpathTotalColumn.getText();
		assertEquals(totalColumn, true, "Total column is not present on summary page");
		assertEquals(totalText, "Total", "Total column name is mismatched");

		WebElement xpathTotalGapsCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_first_value']"));
		boolean gapTotalCount = xpathTotalGapsCount.isDisplayed();
		assertEquals(gapTotalCount, true, "Gaps total is not present on summary page");

		WebElement xpathTotalSFCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_second_value']"));
		boolean sFTotalCount = xpathTotalColumn.isDisplayed();
		assertEquals(sFTotalCount, true, "SF total is not present on summary page");

		WebElement xpathTotalSRCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_third_value']"));
		boolean sRTotalcount = xpathTotalColumn.isDisplayed();
		assertEquals(sRTotalcount, true, "SR total is not present on summary page");

		WebElement xpathTotalICCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_fourth_value']"));
		boolean iCTotalCount = xpathTotalColumn.isDisplayed();
		assertEquals(iCTotalCount, true, "IC total is not present on summary page");
	}

	////// Lows tab
	////Verifying Lows tab Summary page header columns text => Department, Lows, SF and IC.
	public void verifyCountSummaryHeaderColumns() throws Throwable {

		WebElement xpathDepartmentColumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/department_text']"));
		String departmentHeader = xpathDepartmentColumn.getText();
		assertEquals(departmentHeader, "Department", "Department column name is mismatched");

		WebElement xpathLows = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_third']"));
		String CountText = xpathLows.getText();
		assertEquals(CountText, "Count", "Counts tab column name is mismatched");

//		WebElement xpathSFcolumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_third']"));
//		String SFText = xpathSFcolumn.getText();
//		assertEquals(SFText, "SF", "SF column name is mismatched");

		WebElement xpathICcolumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_fourth']"));
		String ICText = xpathICcolumn.getText();
		assertEquals(ICText, "IC", "IC column name is mismatched");
	}

	public void verifyCountSummaryFooter() throws Throwable {

		WebElement xpathTotalColumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/total_text']"));
		boolean totalColumn = xpathTotalColumn.isDisplayed();
		String totalText = xpathTotalColumn.getText();
		assertEquals(totalColumn, true, "Total column is not present on summary page");
		assertEquals(totalText, "Total", "Total column name is mismatched");

//		WebElement xpathLowsCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_second_value']"));
//		boolean lowsTotalCount = xpathLowsCount.isDisplayed();
//		assertEquals(lowsTotalCount, true, "Lows total is not present on summary page");

		WebElement xpathTotalSFCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_third_value']"));
		boolean sFTotalCount = xpathTotalColumn.isDisplayed();
		assertEquals(sFTotalCount, true, "SF total is not present on summary page");

		WebElement xpathTotalICCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_fourth_value']"));
		boolean iCTotalCount = xpathTotalColumn.isDisplayed();
		assertEquals(iCTotalCount, true, "IC total is not present on summary page");
	}

	////// Highs tab
	////Verifying Highs tab Summary page header columns text => Department, Highs and IC.
	public void verifyHighsSummaryHeaderColumns() throws Throwable {

		WebElement xpathDepartmentColumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/department_text']"));
		String departmentHeader = xpathDepartmentColumn.getText();
		assertEquals(departmentHeader, "Department", "Department column name is mismatched");

		WebElement xpathHighs = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_third']"));
		String highsText = xpathHighs.getText();
		assertEquals(highsText, "Count", "Count tab column name is mismatched");

		WebElement xpathICcolumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/text_fourth']"));
		String ICText = xpathICcolumn.getText();
		assertEquals(ICText, "IC", "IC column name is mismatched");
	}

	public void verifyHighsSummaryFooter() throws Throwable {

		WebElement xpathTotalColumn = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/total_text']"));
		boolean totalColumn = xpathTotalColumn.isDisplayed();
		String totalText = xpathTotalColumn.getText();
		assertEquals(totalColumn, true, "Total column is not present on summary page");
		assertEquals(totalText, "Total", "Total column name is mismatched");

		WebElement xpathHighTotalCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_third_value']"));
		boolean highsTotalCount = xpathHighTotalCount.isDisplayed();
		assertEquals(highsTotalCount, true, "Highs total is not present on summary page");

		WebElement xpathTotalICCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_fourth_value']"));
		boolean iCTotalCount = xpathTotalColumn.isDisplayed();
		assertEquals(iCTotalCount, true, "IC total is not present on summary page");
	}

	////Clicking on Gaps tab on GLh summary page
	public void clickOnGapsTab()throws Throwable {
		WebElement xpathGapsTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='GAPS' or @text='Gaps']"));
		xpathGapsTab.click();
		Thread.sleep(2000);
	}

	////Clicking on Lows tab on GLh summary page
	public void clickOnLowsTab()throws Throwable {
		WebElement xpathLowsTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='LOWS' or @text='Lows']"));
		xpathLowsTab.click();
		Thread.sleep(2000);
	}

	////Clicking on Highs tab on GLh summary page
	public void clickOnHighsTab()throws Throwable {
		WebElement xpathHighsTab = driveR.findElement(By.xpath("//android.widget.TextView[@text='HIGHS' or @text='Highs']"));
		xpathHighsTab.click();
		Thread.sleep(2000);
	}


	///Verifying Department list on summary page
	public void verifyDepartmentList() throws Throwable {
		List<WebElement> xpathDepartmentsList = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/department_text']"));
		boolean dept = xpathDepartmentsList.size()>1;

		assertEquals(dept, true,"Departments are not present");
	}

	////Get Department names from UI
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

	//Verifying department order with services for all 3 tabs - Gaps, Highs and Lows
	public void verifyDeptStaticOrder(List<String> gapsDeptList,List<String> lowsDeptList,List<String> highsDeptList) throws Throwable {
		verifyDeptList(gapsDeptList);
		verifyDeptList(lowsDeptList);
		verifyDeptList(highsDeptList);
	}

	public void verifyDeptList(List<String> deptList) throws Throwable {
		boolean isEqual = false;
		List<String> deptListService = glhSummary_Service.glhMSglhDepartments;

		System.out.println("Department list Service : " + deptListService);
		System.out.println("Department list UI : " + deptList);

		for(int i=0;i<=deptList.size()-1;i++){
		if(deptList.contains(departmentNameList.get(i))){
			isEqual = true;
		}
		assertEquals(isEqual, true,"Department list on UI and service mismatches");
		}
	}

	//// Verifying Departments On UI and Service matches
	public void verifyDeptOnUIAndService() throws Throwable {
		boolean isEqual = false;
		List<String> deptListService = glhSummary_Service.glhMSglhDepartments;

		System.out.println("Department list Service : " + deptListService);
		System.out.println("Department list UI : " + departmentNameList);

		for(int i=0;i<=departmentNameList.size()-1;i++){
		if(deptListService.contains(departmentNameList.get(i))){
			isEqual = true;
		}
		assertEquals(isEqual, true,"Department list on UI and service mismatches");
		}
	}

	public void setCaptureTypeAndCount(String captureTypee,String countt){
		captureType = captureTypee;
		count = countt;
	}

	public void getSectionList(String deptName,String section1, String section2) throws Throwable {

		WebElement xpathRightArrowIndicator = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+deptName+"']//preceding-sibling::android.widget.ImageView[@resource-id='"+env+":id/expand_icon']"));

		if(xpathRightArrowIndicator.isDisplayed()) {

			xpathRightArrowIndicator.click();
			Thread.sleep(2000);
			int i = 0;

			while(i<5)
			{
				List<WebElement> xpathDeptSectionsList = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='"+env+":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='"+env+":id/department_text']"));

				try{
					for(WebElement xpathDeptSections : xpathDeptSectionsList){
						String sectionName = xpathDeptSections.getText();
						Thread.sleep(3000);

						if(!sectionName.equals("Department") && !specificDeptSectionList.contains(sectionName)){
							System.out.println("Section department name : " + sectionName);

							specificDeptSectionList.add(sectionName);
							getCountOnSummary(sectionName,section1,section2,captureType,count);
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
		}
	}
	//=================================================
	public void getSectionList_7(String deptName,String section1, String section2) throws Throwable {
		try {
			String[] arrDeptSec = new String[]{section1,section2};
			WebElement xpathRightArrowIndicator = driveR.findElement(By.xpath("//android.widget.TextView[@text='" + deptName + "']//preceding-sibling::android.widget.ImageView[@resource-id='" + env + ":id/expand_icon']"));

			if (xpathRightArrowIndicator.isDisplayed()) {

				xpathRightArrowIndicator.click();
				Thread.sleep(2000);
				int ctr = 0, iDeptCtr = 0;
				List<WebElement> xpathDeptSectionsList = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='" + env + ":id/department_text']"));
				while (ctr < arrDeptSec.length) {

//					try {
						List<WebElement> listDept = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='" + env + ":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='" + env + ":id/department_text']"));
//						WebElement oDept = null;
//						//=========================================================
//						String ic = null, scan = null, sf = null;
//						boolean sFound = false;
//						List<WebElement> listDept = driveR.findElements(By.xpath("//android.widget.LinearLayout"));
//						for (int j = 0; j < listDept.size(); j++) {
//							System.out.println(listDept.get(j).findElements(By.xpath("//android.widget.TextView")).get(0).getText());
//							if (listDept.get(j).findElements(By.xpath("//android.widget.TextView")).get(0).getText().contains(deptName)) {
//								sFound = true;
//								oDept = listDept.get(j);
//								iDeptCtr = j;
//								break;
//							}
//						}
						   //.findElements(By.xpath("//android.widget.TextView"));
						//=========================================
						boolean obool = true;
//						Sect: while(obool == true) {
					try {
						int b = 0, sectCtr = 0;
						listDept = driveR.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='" + env + ":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='" + env + ":id/department_text']"));
						int iSectNameLen = listDept.size();
						ScrolltoElementWithText(driveR,arrDeptSec[ctr]);
						if(iSectNameLen ==0 ){
							MobileHelper.scroll(driveR, 500, 1515, 1000, 1000);
							listDept = driveR.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='" + env + ":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='" + env + ":id/department_text']"));
						}
						String sSectName = listDept.get(b).getText();
						Sect:
						while (!sSectName.equalsIgnoreCase(arrDeptSec[ctr])) {
							Thread.sleep(2000);
							listDept = driveR.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='" + env + ":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='" + env + ":id/department_text']"));
							int d = 0;
							for (int c = 0; c < listDept.size(); c++) {
								try {
									System.out.println("listDept.size() " + listDept.size());
									sSectName = listDept.get(c).getText();
									if (sSectName.equalsIgnoreCase(arrDeptSec[ctr])) {
										sectCtr = c;
										break Sect;
									}
								} catch (Exception ew) {
System.out.println(ew);
								}
								d = c;
							}
							MobileHelper.scroll(driveR, 500, 1515, 1000, 1000);
							b = d;
							sSectName = listDept.get(b).getText();
							String sSectName1 = listDept.get(b).getText();
						}

//							WebElement oSectionName = driveR.findElement(By.xpath("//android.widget.TextView[@text = '" + arrDeptSec[ctr] + "']"));
						try {

							String sectionName = listDept.get(sectCtr).getText();
							;
							if (sectionName.equalsIgnoreCase(arrDeptSec[ctr])) {
								System.out.println("Section department name : " + sectionName);

								specificDeptSectionList.add(sectionName);
								getCountOnSummary(sectionName, section1, section2, captureType, count);
							}

						} catch (StaleElementReferenceException w) {
							if (iRepeat < 3) {
								iRepeat++;
								driveR.navigate().refresh();
								getSectionList_7(deptName, section1, section2);
							}
						} catch (Exception e) {
						}
//							}
						ctr++;
					}
				 catch (Exception ew) {
System.out.println(ew);
				}
					//==========================================================
				}
			}
		}
		catch(NoSuchElementException ne){
			if (iRepeat1 < 3) {
				iRepeat1++;
				MobileHelper.scroll(driveR, 500, 1515, 1000, 1000);
				getSectionList_7(deptName, section1, section2);
			}
		}
		catch (StaleElementReferenceException w) {
			if (iRepeat1 < 3) {
				iRepeat1++;
				driveR.navigate().refresh();
				getSectionList_7(deptName, section1, section2);
			}
		} catch (Exception e) {
			if (iRepeat1 < 3) {
				iRepeat1++;
			MobileHelper.scroll(driveR, 500, 1515, 1000, 1000);
			getSectionList_7(deptName, section1, section2);
			}
		}
	}

	//===================================================

	public void getDepartmentCount(String deptName1,String deptName2) throws Throwable {

		if(captureType.equals("Gaps")){
			System.out.println("Department name : " + deptName1);
			dept1Count = getGapsCount(deptName1);
			System.out.println("Department name : " + deptName2);
			dept2Count = getGapsCount(deptName2);
		}
		if(captureType.equals("Count")){
			System.out.println("Department name : " + deptName1);
			dept1Count = getHighsCount(deptName1);
			System.out.println("Department name : " + deptName2);
			dept2Count = getHighsCount(deptName2);
		}
		if(captureType.equals("Lows")){

			System.out.println("Department name : " + deptName1);
			dept1Count = getLowsCount(deptName1);
			System.out.println("Department name : " + deptName2);
			dept2Count = getLowsCount(deptName2);

		}
		if(captureType.equals("Highs")){

			System.out.println("Department name : " + deptName1);
			dept1Count = getHighsCount(deptName1);
			System.out.println("Department name : " + deptName2);
			dept2Count = getHighsCount(deptName2);

		}
	}

	///// verify that the all counts at department level add up to the Totals
	public void verifyDeptCountAtTotal(String captureType) throws Throwable{
		int totalCountUI = 0;
		int deptCount = dept1Count + dept2Count;
		System.out.println("Department count on UI : " + deptCount);

		if(captureType.equals("Gaps")){
			totalCountUI = getTotalGapsCount();}
		if(captureType.equals("Lows")){
			totalCountUI = getTotalLowCount();}
		if(captureType.equals("Highs")){
			totalCountUI = getTotalHighCount();}

		assertEquals(deptCount, totalCountUI, "Total count is mismatched");

	}

	public void getSectionIndexBefore(String section1, String section2) throws Throwable {
		section1IndexBefore = specificDeptSectionList.indexOf(section1);
		section2IndexBefore = specificDeptSectionList.indexOf(section2);

	}

	public void getSectionIndexAfter(String section1, String section2) throws Throwable {
		section1IndexAfter = specificDeptSectionList.indexOf(section1);
		section2IndexAfter = specificDeptSectionList.indexOf(section2);

	}

	public void verifySectionMovedToBottom(String section1, String section2) throws Throwable {
		boolean indexMoved = false;
		
		if(section1IndexBefore<section1IndexAfter){
			indexMoved = true;
			assertEquals(indexMoved, true,"Section are not moved to bottom list");
		}
		
		if(section2IndexBefore<section2IndexAfter){
			indexMoved = true;
			assertEquals(indexMoved, true,"Section are not moved to bottom list");
		}
	}

	public void verifySectionAtSamePosition(String section1, String section2) throws Throwable {
		boolean indexMoved = false;
		
		if(section1IndexBefore==section1IndexAfter){
			indexMoved = true;
			assertEquals(indexMoved, true,"Section are not at the same position in the list");
		}
		
		if(section2IndexBefore==section2IndexAfter){
			indexMoved = true;
			assertEquals(indexMoved, true,"Section are not at the same position in the list");
		}
	}

	public void verifySectionCount(String dept,String section1, String section2) throws Throwable {

		System.out.println("Department "+dept+" Section department name : " + section1);

		assertEquals(section1Count, count,captureType+" count is mismatched");

		System.out.println("Department "+dept+" Section department name : " + section2);

		assertEquals(section2Count, count,captureType+" count is mismatched");
	}


	////Get Department and corresponding section names from UI
	public void getDepartmentAndSectionsOnUI(List<String> departmentNameList) throws Throwable {
		//List<String> departmentNameList = new ArrayList<String>();
		List<String> departmentSectionsNameList = new ArrayList<String>();

		int deptNo = 0;
		System.out.println("deptNo : " + deptNo);
		for(String deptName : departmentNameList){

			String index = String.valueOf(deptNo);

			System.out.println("Department name : " + deptName);

			WebElement xpathDept = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+departmentNameList.get(deptNo)+"']"));

			if(xpathDept.isDisplayed()){

				WebElement xpathRightArrowIndicator = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+departmentNameList.get(deptNo)+"']//preceding-sibling::android.widget.ImageView[@resource-id='"+env+":id/expand_icon']"));

				if(xpathRightArrowIndicator.isDisplayed()) {

					xpathRightArrowIndicator.click();
					Thread.sleep(2000);
					int i = 0;

					sectionLoop : while(i<5)
					{
						List<WebElement> xpathDeptSectionsList = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='"+env+":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='"+env+":id/department_text']"));

						System.out.println("Departments Sections List size : " + departmentNameList.size());


						try{
							for(WebElement xpathDeptSections : xpathDeptSectionsList){
								String sectionName = xpathDeptSections.getText();
								Thread.sleep(5000);

								if(!sectionName.equals("Department") && !departmentSectionsNameList.contains(sectionName)){
									System.out.println("Section department name : " + sectionName);

									departmentSectionsNameList.add(sectionName);
								}
							}
							i++;

							try{
								if(driveR.findElement(By.xpath("//android.widget.TextView[@text='"+departmentNameList.get(deptNo+1)+"']")).isDisplayed()){
									break sectionLoop;
								}
							}catch(Exception e){}

							Thread.sleep(2000);
							TouchAction ts = new TouchAction(driveR);
							ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
							.moveTo(PointOption.point(300, 390)).release().perform();

						}

						catch(Exception e){}
					}

					System.out.println("Map values : " + deptSectionList);

					deptNo ++;
					driveR.findElement(By.className("android.widget.ImageButton")).click();
					Thread.sleep(3000);
					driveR.findElement(By.xpath("//android.widget.TextView[@text='Summary' or @text='SUMMARY']")).click();
					Thread.sleep(3000);
				}
			}	
		}
	}



	//// Verifying all departments with right arrow indicator
	public void verifyRightArrowIndicator() throws Throwable {

		int i = 1;
		while(i<3)
		{
			List<WebElement> xpathRightArrowIndicator = driveR.findElements(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/department_text']//preceding::android.widget.ImageView[@resource-id='"+env+":id/expand_icon']"));

			try{
				for(WebElement xpathRightArrow : xpathRightArrowIndicator){
					boolean isPresent = xpathRightArrow.isDisplayed();
					System.out.println("Right Arrow indicator : " + isPresent);
					assertEquals(isPresent, true,"Right arrow indicator is not present");
				}
				i++;

				Thread.sleep(2000);
				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(300, 390)).release().perform();
			}

			catch(Exception e){}
		}
	}	


	public void getCountOnSummary(String currentSection,String section1,String section2,String captureType,String count) throws Throwable{
		if(captureType.equals("Gaps")){
			if(currentSection.equals(section1)){
				System.out.println("Section department name : " + section1);

				section1Count = getGapsCount(section1);
				assertEquals(String.valueOf(section1Count), count,"Gaps count is mismatched");

			}
			if(currentSection.equals(section2)){
				System.out.println("Section department name : " + section2);

				section2Count = getGapsCount(section2);
				assertEquals(String.valueOf(section2Count), count,"Gaps count is mismatched");

			}
		}
		if(captureType.equals("Lows")){
			if(currentSection.equals(section1)){
				System.out.println("Section department name : " + section1);

				section1Count = getLowsCount(section1);
				assertEquals(String.valueOf(section1Count), count,"Lows count is mismatched");

			}
			if(currentSection.equals(section2)){
				System.out.println("Section department name : " + section2);

				section2Count = getLowsCount(section2);
				assertEquals(String.valueOf(section2Count), count,"Lows count is mismatched");

			}
		}
		if(captureType.equals("Counts")){
			if(currentSection.equals(section1)){
				System.out.println("Section department name : " + section1);

				section1Count = getHighsCount(section1);
				assertEquals(String.valueOf(section1Count), count,"Highs count is mismatched");

			}
			if(currentSection.equals(section2)){
				System.out.println("Section department name : " + section2);

				section2Count = getHighsCount(section2);
				assertEquals(String.valueOf(section2Count), count,"Highs count is mismatched");

			}
		}
	}

	public int getGapsCount(String sectionName) throws Throwable {

		WebElement xpathGapCount = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+sectionName+"']//following::android.widget.TextView[@resource-id='"+env+":id/text_gaps']"));

		gapsCount = Integer.parseInt(xpathGapCount.getText());
		System.out.println("Gaps count is : " + gapsCount);
		return gapsCount;
	}

	public int getCountsCount(String sectionName) throws Throwable {

		WebElement xpathGapCount = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+sectionName+"']//following::android.widget.TextView[@resource-id='"+env+":id/text_highs']"));

		gapsCount = Integer.parseInt(xpathGapCount.getText());
		System.out.println("Count count is : " + gapsCount);
		return gapsCount;
	}

	public int getLowsCount(String sectionName) throws Throwable {
		WebElement xpathLowCount = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+sectionName+"']//following::android.widget.TextView[@resource-id='"+env+":id/text_lows']"));
		lowsCount = Integer.parseInt(xpathLowCount.getText());

		System.out.println("Lows count is : " + lowsCount);
		return lowsCount;
	}

	public int getHighsCount(String sectionName) throws Throwable {
		WebElement xpathHighCount = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+sectionName+"']//following::android.widget.TextView[@resource-id='"+env+":id/text_highs']"));
		highsCount = Integer.parseInt(xpathHighCount.getText());

		System.out.println("Highs count is : " + highsCount);
		return highsCount;
	}

	public int getSFCount(String sectionName) throws Throwable {
		WebElement xpathSFCount = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+sectionName+"']//following::android.widget.TextView[@resource-id='"+env+":id/text_positive_stock']"));
		sFCount = Integer.parseInt(xpathSFCount.getText());

		System.out.println("SF count is : " + sFCount);
		return sFCount;
	}

	public int getSRCount(String sectionName) throws Throwable {
		WebElement xpathSRCount = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+sectionName+"']//following::android.widget.TextView[@resource-id='"+env+":id/text_stock']"));
		sRCount = Integer.parseInt(xpathSRCount.getText());

		System.out.println("SR count is : " + sRCount);
		return sRCount;
	}

	public int getICCount(String sectionName) throws Throwable {
		WebElement xpathICCount = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+sectionName+"']//following::android.widget.TextView[@resource-id='"+env+":id/text_incomplete']"));
		iCCount = Integer.parseInt(xpathICCount.getText());

		System.out.println("IC count is : " + iCCount);
		return iCCount;
	}


	///////////////////////  Get total count for Gaps, +SR,SF and IC - Footer location

	public int getTotalGapsCount() throws Throwable {
		WebElement xpathTotalCaptureCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_first_value']"));
		gapsTotalCount = Integer.parseInt(xpathTotalCaptureCount.getText());

		System.out.println("Total Gaps count is : " + gapsTotalCount);
		return gapsTotalCount;
	}

	public int getTotalGap_SFCount() throws Throwable {
		WebElement xpathTotalSFCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_second_value']"));
		gaps_SFCount = Integer.parseInt(xpathTotalSFCount.getText());

		System.out.println("Total Gaps SF count is : " + gaps_SFCount);
		return gaps_SFCount;
	}

	public int getTotalGap_SRCount() throws Throwable {
		WebElement xpathTotalSRCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_third_value']"));
		gaps_SRCount = Integer.parseInt(xpathTotalSRCount.getText());

		System.out.println("Total Gaps SR count is : " + gaps_SRCount);
		return gaps_SRCount;
	}

	public int getTotalGap_ICCount() throws Throwable {
		WebElement xpathTotalICCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_fourth_value']"));
		gaps_ICCount = Integer.parseInt(xpathTotalICCount.getText());

		System.out.println("Total Gaps IC count is : " + gaps_ICCount);
		return gaps_ICCount;
	}

	///////////////////////  Get total count for Lows,SF and IC - Footer location

	public int getTotalLowCount() throws Throwable {
		WebElement xpathTotalCaptureCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_second_value']"));
		lowsTotalCount = Integer.parseInt(xpathTotalCaptureCount.getText());

		System.out.println("Total Lows count is : " + lowsTotalCount);
		return lowsTotalCount;
	}

	public int getTotalLow_SFCount() throws Throwable {
		WebElement xpathTotalSFCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_third_value']"));
		lows_SFCount = Integer.parseInt(xpathTotalSFCount.getText());

		System.out.println("Total Lows SF count is : " + lows_SFCount);
		return lows_SFCount;
	}

	public int getTotalLow_ICCount() throws Throwable {
		WebElement xpathTotalICCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_fourth_value']"));
		lows_ICCount = Integer.parseInt(xpathTotalICCount.getText());

		System.out.println("Total Lows IC count is : " + lows_ICCount);
		return lows_ICCount;
	}

	///////////////////////  Get total count for Highs and IC - Footer location

	public int getTotalHighCount() throws Throwable {
		WebElement xpathTotalCaptureCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_third_value']"));
		highsTotalCount = Integer.parseInt(xpathTotalCaptureCount.getText());

		System.out.println("Total Highs count is : " + highsTotalCount);
		return highsTotalCount;
	}

	public int getTotalHigh_ICCount() throws Throwable {
		WebElement xpathTotalICCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"+env+":id/footer_fourth_value']"));
		highs_ICCount = Integer.parseInt(xpathTotalICCount.getText());

		System.out.println("Total Highs IC count is : " + highs_ICCount);
		return highs_ICCount;
	}

	public void getMarketstreetGlhDepts(String deptName) throws Throwable{
		int j = 0;
		while(j<=1){
			Thread.sleep(2000);
			TouchAction ts = new TouchAction(driveR);
			ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(300, 390)).release().perform();
			j++;
		}

		WebElement xpathRightArrowIndicator = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+deptName+"']//preceding-sibling::android.widget.ImageView[@resource-id='"+env+":id/expand_icon']"));

		if(xpathRightArrowIndicator.isDisplayed()) {

			xpathRightArrowIndicator.click();
int k = 0;
			while(k<=1){
				Thread.sleep(2000);
				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(300, 390)).release().perform();
				k++;
			}

			List<WebElement> xpathDeptSectionsList = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='"+env+":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='"+env+":id/department_text']"));

			try{
				for(WebElement xpathDeptSections : xpathDeptSectionsList){
					String sectionName = xpathDeptSections.getText();
					Thread.sleep(5000);

					System.out.println("Section department name : " + sectionName);
					specificDeptSectionList.add(sectionName);
					getCounts(sectionName);

				}
			}
			catch(Exception e){}
		}
	}

	////////////Without scanning any product
	////////// All department sections count is Zero

	public void getSectionsForSpecificDept(String deptName) throws Throwable {


		Thread.sleep(3000);
		WebElement xpathRightArrowIndicator = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+deptName+"']//preceding-sibling::android.widget.ImageView[@resource-id='"+env+":id/expand_icon']"));

		if(xpathRightArrowIndicator.isDisplayed()) {

			xpathRightArrowIndicator.click();

			Thread.sleep(2000);
			int i = 0;

			sectionLoop : while(i<5)
			{
				List<WebElement> xpathDeptSectionsList = driveR.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='"+env+":id/summary_sublist_recycler_view']//android.widget.TextView[@resource-id='"+env+":id/department_text']"));

				try{
					for(WebElement xpathDeptSections : xpathDeptSectionsList){
						String sectionName = xpathDeptSections.getText();
						Thread.sleep(5000);

						if(!sectionName.equals("Department") && !specificDeptSectionList.contains(sectionName)){
							System.out.println("Section department name : " + sectionName);

							specificDeptSectionList.add(sectionName);
						getCounts(sectionName);}

					}
					i++;
					Thread.sleep(2000);
					TouchAction ts = new TouchAction(driveR);
					ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(300, 390)).release().perform();
				}
				catch(Exception e){}
			}
		}
	}



	public void sectionsInAlphabeticalOrder() throws Throwable{
		List<String> originalList = specificDeptSectionList;
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());     

		boolean isEqual = sortedList.equals(originalList);
		assertEquals(isEqual, true, "Department section is not in an Alphabetical order");
	}

	public int getCounts(String sectionName) throws Throwable{
		if(captureType.equals("Gaps")){
			System.out.println("Section department name : " + sectionName);
			sectionName = sectionName.replaceAll("\\s", "");
			section1Count = getGapsCount(sectionName);

			assertEquals(String.valueOf(section1Count), count,"Gaps count is mismatched");
		}
		if(captureType.equals("Lows")){

			System.out.println("Section department name : " + sectionName);

			section1Count = getLowsCount(sectionName);
			assertEquals(section1Count, count,"Lows count is mismatched");
		}
		if(captureType.equals("Highs")){

			System.out.println("Section department name : " + sectionName);

			section1Count = getHighsCount(sectionName);
			assertEquals(section1Count, count,"Highs count is mismatched");
		}
		return section1Count;
	}



	////Verifying MS GLH sections On UI and service matches
	public void verifyMSSectionsOnUIAndAPI() throws Throwable{
		boolean isEqual = false;
		List<String> deptListService = glhSummary_Service.marketSteetSectionsList;

		System.out.println("Department Section list Service : " + deptListService);
		System.out.println("Department Section list UI : " + specificDeptSectionList);

		if(specificDeptSectionList.equals(deptListService)){
			isEqual = true;
			assertEquals(isEqual, true,"Department Section list on UI and service mismatches");
		}
	}

	//// verify that the all counts at section level add up to the department level
	public void verifySectionCountAtDept(String dept) throws Throwable{
		int totalSectionCount = section1Count + section2Count;

		int totalDeptCountUI = 0;

		System.out.println("Department UI : " + dept);

		if(captureType.equals("Gaps")){
			totalDeptCountUI = getGapsCount(dept);}
		if(captureType.equals("Lows")){
			totalDeptCountUI = getLowsCount(dept);}
		if(captureType.equals("Highs")){
			totalDeptCountUI = getHighsCount(dept);}

		assertEquals(totalSectionCount, totalDeptCountUI, "Total " +captureType+ " count is mismatched");

	}

	public void selectDepartment(String deptName){
		WebElement xpathRightArrowIndicator = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+deptName+"']//preceding-sibling::android.widget.ImageView[@resource-id='"+env+":id/expand_icon']"));
		xpathRightArrowIndicator.click();
	}

}
