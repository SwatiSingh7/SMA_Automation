package com.morrisons.sma.page_objects.mobile.old;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CharMatcher;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WrapsDriver;
import org.apache.http.HttpResponse;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CnR_DepartmentVO;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CnR_Schedules;
import com.morrisons.sma.pojo.service.CleanNRotateServicePOJO.CnR_SchedulesVo;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;

public class CleanAndRotatePO {
	ObjectMapper objectMapper = new ObjectMapper();
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	public static String DatefromApp;
	public static HttpResponse Response;
	public static io.restassured.response.Response restResponse;
	public static CnR_SchedulesVo cnRScedulesJsonResp;
	public static CnR_DepartmentVO cnRDepartmentJsonResp;
	private static By pickers = MobileBy.xpath("//android.widget.EditText[@text='13']");

	// public static String discountedPrice;
	// public static String firstMDPriceEmployee = "£0.10";
	//
	// public String firstMarkDownBarcode;
	// public static String BCode;
	// public static String newPrice;
	// public static String qtyApp;
	// public static String oldPrice;
	//
	// Markdown markDownBarcode = new Markdown();

	String cleanAndRotate = "Clean and Rotate";
	String weeklyschedules = "Weekly Schedules";
	String DatePicker = "edt_ExpiryDate";

	public static int productCount = 0;
	public static int logProductCount = 0;
	public static int day;
	public static String selectedWeek = null;
	public static String scanDateCode = null;
	public static String weeklyScheduleName = null;
	public static String firstWeekScheduleStatus = null;
	public static int beforeScannedItemQuantity = 0;
	public static int afterScannedItemQuantity = 0;

	public static Date scanDate;
	public static Date maximumDateOnCalendar;

	private static AndroidDriver driveR;

	public static int itemQuantity;

	public static String weekNameUI = null;
	public static String weekStatusUI = null;

	public static String weeklyScheduleStatus = null;
	public static String weekStatus = null;
	public static String weekName = null;
	public static String departmentNameUI = null;
	public static String departmentNextCheckUI = null;
	public static String departmentStatusUI = null;

	public static String departmentTitleUI = null;
	public static String departmentUpdatedByNameUI = null;
	public static String departmentUpdatedOnUI = null;

	public static String departmentUpdatedByNameServices = null;
	public static String departmentUpdatedOnServices = null;

	// private AndroidDriver<WebElement> driveRList;
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	public static String value;

	public static String deptNameUI = null;
	public static String itemNumberUI = null;
	public static String actionNameUI = null;
	public static String actionPerformedUI = null;
	public static String expiryDateUI = null;
	public static String quantityUI = null;
	public static String isDeletedUI = null;
	public static String itemDescriptionUI = null;

	public static int itemQuantityPrintList;
	public static int latestItemQuantityPrintList;
	public static int initialCount = 0;
	public static String quantityText = null;

	public static String crispDept = applicationConfig.getCleanAndRotateTestData().getCrispDepartment();
	public static String crispItem[] = applicationConfig.getCleanAndRotateTestData().getCrispItems();
	public static String nonCrispDept = applicationConfig.getCleanAndRotateTestData().getnonCrispDepartment();
	public static String nonCrispItem[] = applicationConfig.getCleanAndRotateTestData().getNonCrispItems();

	public static List<String> allMins = new ArrayList<String>();

	public static CleanAndRotatePO cnRpageObjects;
	//
	// public static String crispDeptSelected = null;
	// public static String crispItemEnter = null;

	public void getDays(int dayCount) {
		day = dayCount;
	}

	public CleanAndRotatePO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
		// DatefromApp = "2019-10-21";
	}

	public void clickcleanAndRotate() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + cleanAndRotate + "']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + cleanAndRotate + "']")).click();

	}

	public void clickWeeklySchedules() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + weeklyschedules + "']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + weeklyschedules + "']")).click();

	}

	// ******************
	public void clickDatePicker() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/edt_ExpiryDate']"))
				.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/edt_ExpiryDate']")).click();
	}

	public void clickDoneDatePicker() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@text='Done' or @text='OK']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@text='Done' or @text='OK']")).click();

	}

	public void buttonLogProduct() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/btn_AddExpiringProduct']"))
				.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/btn_AddExpiringProduct']"))
				.click();

		try {
			driveR.findElement(By.xpath("//android.widget.Button[@text ='CONTINUE']")).click();
		} catch (Exception e) {
		}

	}

	public void clearanceMarkdownMessage() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='This item needs Clearance Markdown']"))
				.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.TextView[@text='This item needs Clearance Markdown']")).click();

	}

	public void clickSpinner() throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/spinner_Actions']"))
				.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/spinner_Actions']")).click();

	}

	public void selectOneOption(String action) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@index='0']")).click();

		driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/spinner_Actions']")).click();

		Thread.sleep(5000);
		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + action + "']")).isDisplayed();
		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + action + "']")).click();

	}

	public void selectActionOption(String action) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/action_spinner']")).click();

		Thread.sleep(1000);

		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + action + "']")).isDisplayed();

		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + action + "']")).click();

		Thread.sleep(2000);

	}

	public void changeDate(String date, String month, String year, String datee, String monthh, String yearr)
			throws Throwable {

		// System.out.println("date" + date);
		// System.out.println("datee" + datee);

		// driveR.findElement(By.xpath("//android.widget.EditText[@text='" +
		// datee + "']")).isDisplayed();

		WebElement dateElement = driveR.findElement(By.xpath("//android.widget.EditText[@text='" + datee + "']"));

		dateElement.clear();

		Thread.sleep(6000);
		// List<WebElement> pick =
		// driveR.findElements(By.className("android.widget.EditText"));
		// pick.get(0).sendKeys("\"" + date + "\"");
		// pick.get(0).sendKeys("\"" + date + "\"");
		dateElement.sendKeys("\"" + date + "\"");
		// dateElement.sendKeys(date);

		Thread.sleep(10000);

		WebElement monthElement = driveR.findElement(By.xpath("//android.widget.EditText[@text='" + monthh + "']"));
		monthElement.clear();
		Thread.sleep(6000);
		monthElement.sendKeys("\"" + month + "\"");
		Thread.sleep(6000);
		WebElement yearElement = driveR.findElement(By.xpath("//android.widget.EditText[@text='" + yearr + "']"));
		yearElement.click();
		// monthElement.sendKeys(month);
		/*
		 * // driveR.findElement(By.xpath("//android.widget.EditText[@text='" +
		 * monthh + "']")).clear(); // Thread.sleep(3000); // List<WebElement>
		 * minthhh =
		 * driveR.findElements(By.className("android.widget.EditText")); //
		 * minthhh.get(0).sendKeys("\"" + month + "\""); // Thread.sleep(10000);
		 */

		// String dat = date;
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='" +
		// datee + "']")).click();
		/*
		 * if(driveR.findElementByClassName("android.widget.EditText").getText()
		 * . equalsIgnoreCase(""));{ driveR.pressKeyCode(1); }
		 */
		// String dateeeeee =
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='"+datee+"']")).getText();
		// System.out.println("asjdjkadjnajkdnajkndkjandkandkjadnkjanjka"+dateeeeee);
		// System.out.println("old date" +datee );
		// System.out.println("new date" +date );

		// JavascriptExecutor js = (JavascriptExecutor)driveR;
		// //getElementById('email').value='krishna@gmail.com'
		// js.executeScript("document.getElementByXpath(//android.widget.EditText[@text='\"
		// + datee + \"']").value='16'");"

		// WebElement element =
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='" +
		// datee + "']"));
		// element.clear();
		// Thread.sleep(3000);

		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driveR;
		 * jse.executeScript("arguments[0].value='16';", element);
		 */
		/*
		 * WebElement slider =
		 * driveR.findElement(By.xpath("//android.widget.EditText[@text='" +
		 * datee + "']")); slider.sendKeys("16"); driveR.pressKeyCode(16);
		 */
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='" +
		// datee + "']")).sendKeys(date);

		// a.sendKeys(driveR.findElement(By.xpath("//android.widget.EditText[@text='"+datee+"']")),
		// date);
		// Actions a = new Actions(driveR);
		// a.sendKeys(driveR.findElement(By.xpath("//android.widget.EditText[@text='"+datee+"']")),
		// date);
		// a.sendKeys(date).perform();
		// String inputField;
		// inputField =
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='datee']"));
		// driveR.executeScript("arguments[0].setAttribute('date', '" + date
		// +"')" );
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='datee']"));

		// Boolean ExpectedConditions =
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='"+datee+"']")).isDisplayed();
		// List<AndroidElement> profile = driveR.findElements(
		// MobileBy.xpath("//android.widget.EditTex[@text='"+datee+"'']"));
		//
		// for (AndroidElement a : profile) {
		//
		// String dd = a.getText();
		// dd.replaceAll(datee, date);
		// driveR.findElement(By.xpath("//android.widget.EditText[@text='"+datee+"']")).sendKeys(dd);
		//
		// }

		// WebElement
		// we=driveR.findElement(By.xpath("//android.widget.EditText[@text='" +
		// datee + "']"));
		// we.click();
		// JavascriptExecutor js = (JavascriptExecutor)driveR;
		// js.executeScript("arguments[0].value='15';", we);

	}

	public void datesInList() throws Throwable {
		Thread.sleep(5000);
		driveR.hideKeyboard();
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String abc = a.getText().replace("Week ", "").replace("th ", "-").replace("st ", "-").replace("nd ", "-")
					.replace("rd ", "-").replace("January ", "1-").replace("February ", "2-").replace("March ", "3-")
					.replace("April ", "4-").replace("May ", "5-").replace("June ", "6-").replace("July ", "7-")
					.replace("August ", "8-").replace("September ", "9-").replace("October ", "10-")
					.replace("November ", "11-").replace("December ", "12-");

			System.out.println("Date is " + abc);
			DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
			DateFormat sourceFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			// String navvdee = sourceFormat1.format(date);

			Date date = sourceFormat.parse(abc);
			String DatefromApp = sourceFormat1.format(date);
			System.out.println("Formatted date is APP---: " + DatefromApp);
		}

	}

	public void dateFromListService() throws Throwable {
		int responseCode = Response.getStatusLine().getStatusCode();
		String errorMessage = Response.getStatusLine().getReasonPhrase();
		int responseCodeE = 200;
		System.out.println("Error Message is - " + errorMessage);

		assertEquals(responseCode, responseCodeE, " Schedule details does not exist. Response code");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		cnRScedulesJsonResp = objectMapper.readValue(Response.getEntity().getContent(), CnR_SchedulesVo.class);
		String ProductJSONresult1 = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(cnRScedulesJsonResp);
		System.out.println("Markdown Login Response:\n" + ProductJSONresult1);

		// String cnRResult =
		// objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cnRJsonResp);
		System.out.println("cnR Response:\n" + cnRScedulesJsonResp);
		List<CnR_Schedules> allScheduledWeeks = cnRScedulesJsonResp.getSchedules();
		for (CnR_Schedules datefromService : allScheduledWeeks) {
			// b.getWeekNumber();
			// System.out.println("Date -------" + b.getStartDate().replace("-",
			// " "));
			// System.out.println("Date -------" + b.getStartDate().replace("-",
			// " "));
			System.out.println("Date -------" + datefromService.getStartDate());

			assertEquals(DatefromApp, datefromService, "date does not match");
			// assertEquals(, Matchers.contains(allScheduledWeeks));

		}

		// driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"
		// + env + ":id/department_title']")).isDisplayed();
		// WebElement
		// list1=driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"
		// + env + ":id/department_title']"));
		// System.out.println("list of dates------"+list1);

	}

	public void enterItemQuantity(String qty) throws Throwable {

		quantityText = qty;

		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_quantity']"))
				.isDisplayed();
		driveR.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_quantity']"))
				.sendKeys(qty);
	}

	public void verifyReasonCode() throws Throwable {
		WebElement xpathReasonCode = driveR.findElement(
				By.xpath("//android.widget.TextView[@text='Select Reason Code' or @text='Wastage Reason']"));
		xpathReasonCode.isDisplayed();
	}

	public void selectReasonCode(String action) throws Throwable {
		Thread.sleep(3000);
		WebElement xpathReasonCode = driveR
				.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + action + "']"));
		xpathReasonCode.isDisplayed();
		xpathReasonCode.click();
	}

	public void clickOnConfirmButton() throws Throwable {
		WebElement xpathConfirmButton = driveR
				.findElement(By.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']"));
		xpathConfirmButton.isDisplayed();
		xpathConfirmButton.click();
	}

	public void clickOnCompleteCodeRotate() throws Throwable {
		Thread.sleep(3000);
		WebElement completeCodeRotateGrpBtn = driveR
				.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']"));
		completeCodeRotateGrpBtn.isDisplayed();
		completeCodeRotateGrpBtn.click();
	}

	public void verifyCompleteCodeRotateDisplayed() throws Throwable {
		Thread.sleep(3000);
		WebElement completeCodeRotateGrpBtn = driveR.findElement(By.xpath(
				"//android.widget.Button[@text='COMPLETE CODE ROTATE GROUP' or @text='Complete Code Rotate Group']"));
		completeCodeRotateGrpBtn.isDisplayed();
	}

	public void verifyWeekelyScheduleStatus(String arg2, int arg3) throws Throwable {
		List<AndroidElement> totalWeekList = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		System.out.println("total week : " + totalWeekList.size());
		int selectWeek = totalWeekList.size() - arg3;
		System.out.println("selectWeek week : " + selectWeek);
		Thread.sleep(3000);

		WebElement xpathDepartmentStatus = driveR.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='"
				+ selectWeek + "']/android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		weekNameUI = xpathDepartmentStatus.getText();
		System.out.println(weekNameUI);

		try {
			WebElement xpathDepartmentTitle = driveR
					.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='" + selectWeek
							+ "']/android.widget.TextView[@resource-id='" + env + ":id/department_status']"));

			weekStatusUI = xpathDepartmentTitle.getText();
			System.out.println(weekStatusUI);
		} catch (NoSuchElementException e) {

			weekStatusUI = "ToStart";
			System.out.println(weekStatusUI);
		}

		assertEquals(weekStatusUI, arg2, "Week Status is mismatched");
	}

	public void verifyDepartmentStatus(String deptNumber, String arg2) throws Throwable {
		// Below map is declared to get value at Runtime
		HashMap<String, Integer> departmentNumber = new HashMap<String, Integer>();
		departmentNumber.put("First", 0);
		departmentNumber.put("Second", 1);
		departmentNumber.put("Third", 2);
		departmentNumber.put("Four", 3);
		departmentNumber.put("Five", 4);

		int arg3 = departmentNumber.get(deptNumber);
		try {
			Thread.sleep(3000);
			WebElement xpathDepartmentTitle = driveR.findElement(By.xpath("//android.widget.RelativeLayout[@index='"
					+ arg3 + "']/android.widget.TextView[@resource-id='" + env + ":id/department_status']"));

			departmentStatusUI = xpathDepartmentTitle.getText();
			System.out.println(departmentStatusUI);
		} catch (NoSuchElementException e) {

			departmentStatusUI = "ToStart";
			System.out.println(departmentStatusUI);
		}
		assertEquals(departmentStatusUI, arg2, "Department Status is mismatched");
	}

	public void verifyDepartmentBanner(String arg1) throws InterruptedException {
		try {
			Thread.sleep(3000);
			WebElement xpathDepartmentTitle = driveR.findElement(By.xpath("//android.widget.TextView[@text='"
					+ departmentNameUI + "']/following-sibling::android.widget.TextView[@resource-id='" + env
					+ ":id/department_status']"));

			departmentStatusUI = xpathDepartmentTitle.getText();
			System.out.println(departmentStatusUI);
		} catch (NoSuchElementException e) {

			departmentStatusUI = "ToStart";
			System.out.println(departmentStatusUI);
		}
		assertEquals(departmentStatusUI, arg1, "Department Status is mismatched");
	}
	


	public void getDepartmentName(String deptNumber) throws Throwable {
		// Below map is declared to get value at Runtime
		HashMap<String, Integer> departmentNumber = new HashMap<String, Integer>();
		departmentNumber.put("First", 0);
		departmentNumber.put("Second", 1);
		departmentNumber.put("Third", 2);
		departmentNumber.put("Four", 3);
		departmentNumber.put("Five", 4);

		int arg3 = departmentNumber.get(deptNumber);

		System.out.println("Department number  : " + arg3);

		Thread.sleep(5000);

		WebElement xpathDepartmentStatus = driveR.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='"
				+ arg3 + "']/android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		departmentNameUI = xpathDepartmentStatus.getText();
		System.out.println(departmentNameUI);
	}
	
	

	public void iGetCrispDepartmentName() {
		departmentNameUI = crispDept;
		System.out.println("departmentNameUI : " + departmentNameUI);
	}

	public void iGetNonCrispDepartmentName() {
		departmentNameUI = nonCrispDept;
		System.out.println("departmentNameUI : " + departmentNameUI);
	}

	public void verifyReopenCodeRotateGroup() throws Throwable {
		WebElement reopenCodeRotateGroup = driveR
				.findElement(By.xpath("//android.widget.Button[@text='RE-OPEN CODE ROTATE GROUP']"));
		reopenCodeRotateGroup.isDisplayed();
	}

	public void clickOnReopenCodeRotateGroup() throws Throwable {
		WebElement reopenCodeRotateGroup = driveR
				.findElement(By.xpath("//android.widget.Button[@text='RE-OPEN CODE ROTATE GROUP']"));
		reopenCodeRotateGroup.isDisplayed();
		reopenCodeRotateGroup.click();
	}

	public void verifyReopenDepartmentAlert(String arg1) throws Throwable {
		WebElement reopenDepartmentAlert = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		reopenDepartmentAlert.isDisplayed();

		String alertTitle = reopenDepartmentAlert.getText().trim();
		assertEquals(alertTitle, arg1, "Reopen department alert title is mismatched");

		WebElement reopenDepartmentAlertText = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		reopenDepartmentAlertText.isDisplayed();

		String alertText = reopenDepartmentAlertText.getText().trim();
		assertEquals(alertText, "Are you sure you want to open the completed check for this department?",
				"Reopen department alert text is mismatched");
		Thread.sleep(3000);

		String expectedValue = null;
		String yesButtonText = driveR
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if (CharMatcher.javaUpperCase().matchesAllOf(yesButtonText)) {
			expectedValue = "YES";
		} else {
			expectedValue = "Yes";
		}
		assertEquals(yesButtonText, expectedValue, "Yes button text is mismatched");
		Thread.sleep(3000);

		String expectedValue1 = null;
		String noButtonText = driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"))
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("Captured name = " + yesButtonText);

		if (CharMatcher.javaUpperCase().matchesAllOf(yesButtonText)) {
			expectedValue1 = "NO";
		} else {
			expectedValue1 = "No";
		}
		assertEquals(noButtonText, expectedValue1, "No button text is mismatched");
		Thread.sleep(3000);
	}

	public void clickOnNoReopenDepartment() throws Throwable {
		WebElement xpathNoButton = driveR
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']"));
		xpathNoButton.isDisplayed();
		xpathNoButton.click();
	}

	public void clickOnYesReopenDepartment() throws Throwable {
		Thread.sleep(3000);
		WebElement xpathYesButton = driveR
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		xpathYesButton.isDisplayed();
		xpathYesButton.click();
	}

	// public int getProductCountOnViewList() throws Throwable
	// {
	// int productCount;
	// WebElement xpathProductCount =
	// driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" +
	// env + ":id/singleItemTitle']"));
	// xpathProductCount.isDisplayed();
	// return productCount =
	// Integer.parseInt(xpathProductCount.getText().replaceAll("\\D+", ""));
	// }

	public int getProductCountOnViewList() throws Throwable {
		try {

			Boolean viewList = driveR
					.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/singleItemTitle']"))
					.isDisplayed();

			if (viewList = true) {

				WebElement xpathProductCount = driveR.findElement(
						By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/singleItemTitle']"));
				xpathProductCount.isDisplayed();
				productCount = Integer.parseInt(xpathProductCount.getText().replaceAll("\\D+", ""));
			}
		} catch (Exception e) {
			productCount = 0;
		}
		System.out.println("Product count on View list : " + productCount);

		return productCount;
	}

	public void verifyIncreaseCountOnViewList() throws Throwable {
		WebElement xpathProductCount = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/singleItemTitle']"));
		xpathProductCount.isDisplayed();
		int actualProduct = Integer.parseInt(xpathProductCount.getText().replaceAll("\\D+", ""));

		System.out.println("Product increased count on View list : " + (productCount + 1));
		assertEquals(actualProduct, productCount + 1, "Product count is mismatched");
	}

	public void verifyDecreaseCountOnViewList() throws Throwable {
		WebElement xpathProductCount = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/singleItemTitle']"));
		xpathProductCount.isDisplayed();
		int actualProduct = Integer.parseInt(xpathProductCount.getText().replaceAll("\\D+", ""));
		System.out.println("Product decrease count on View list : " + (productCount - 1));
		assertEquals(actualProduct, productCount - 1, "Product count is mismatched");
	}

	public int getProductCountOnProductDetail() throws Throwable {
		try {

			Boolean isProductCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env
					+ ":id/list_header_count' or @resource-id='" + env + ":id/txt_action']")).isDisplayed();

			if (isProductCount = true) {

				WebElement xpathProductCount = driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='"
						+ env + ":id/list_header_count' or @resource-id='" + env + ":id/txt_action']"));
				xpathProductCount.isDisplayed();
				logProductCount = Integer.parseInt(xpathProductCount.getText().replaceAll("\\D+", ""));
			}
		} catch (Exception e) {
			logProductCount = 0;
		}
		System.out.println("Product count on product Log list : " + logProductCount);
		return logProductCount;
	}

	public void verifyIncreaseCountOnProductDetails() throws Throwable {
		WebElement xpathProductCount = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_header_count']"));
		xpathProductCount.isDisplayed();
		int actualProduct = Integer.parseInt(xpathProductCount.getText().replaceAll("\\D+", ""));
		System.out.println("Product increased count on product Log list : " + (logProductCount + 1));
		assertEquals(actualProduct, logProductCount + 1, "Product count is mismatched on Log Product details");
	}

	public void verifyDecreaseCountOnProductDetails() throws Throwable {
		WebElement xpathProductCount = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_header_count']"));
		xpathProductCount.isDisplayed();
		int actualProduct = Integer.parseInt(xpathProductCount.getText().replaceAll("\\D+", ""));
		System.out.println("Product decreased count on product Log list : " + (logProductCount - 1));
		assertEquals(actualProduct, logProductCount - 1, "Product count is mismatched on Log Product details");
	}

	public void rightSwipe() throws Throwable {
		Thread.sleep(3000);

		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 269)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(32, 269)).release().perform();
		Thread.sleep(3000);
	}

	public void productIsNotAbleToDelete() throws Throwable {

		WebElement disableDeleteButton = driveR.findElement(
				By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/delete_button_disabled']"));

		disableDeleteButton.isDisplayed();

		String isDeleteButtonClickable = disableDeleteButton.getAttribute("clickable");

		assertEquals(isDeleteButtonClickable, "false", "Delete button is visible. Product is deleted");
	}

	public void completeCodeRotateDepartment() throws Throwable {
		int index;
		Thread.sleep(3000);
		List<AndroidElement> totalDepartmentList = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (index = 0; index < totalDepartmentList.size(); index++) {
			Thread.sleep(3000);

			WebElement xpathDepartmentStatus = driveR
					.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='" + index
							+ "']/android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

			String productName = xpathDepartmentStatus.getText();
			System.out.println(productName);

			String productStatus = null;
			try {
				WebElement xpathDepartmentTitle = driveR
						.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='" + index
								+ "']/android.widget.TextView[@resource-id='" + env + ":id/department_status']"));

				productStatus = xpathDepartmentTitle.getText();
				System.out.println(productStatus);
			} catch (NoSuchElementException e) {

				productStatus = "Not Started";
				System.out.println(productStatus);
			}

			if (productStatus.equals("Not Started") || productStatus.equals("In Progress")) {
				xpathDepartmentStatus.click();

				if (productStatus.equals("In Progress")) {

					if (isViewListPresent()) {
						driveR.findElement(
								By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/singleItemIcon']"))
								.click();
						System.out.println("Click on view list");
					}
				}

				clickOnCompleteCodeRotate();
			}

			// Below map is declared to get value at Runtime
			HashMap<Integer, String> departmentNumber = new HashMap<Integer, String>();
			departmentNumber.put(0, "First");
			departmentNumber.put(1, "Second");
			departmentNumber.put(2, "Third");
			departmentNumber.put(3, "Four");
			departmentNumber.put(4, "Five");

			String arg3 = departmentNumber.get(index);

			verifyDepartmentStatus(arg3, "Completed");
		}
	}

	public boolean isViewListPresent() throws Throwable {
		boolean isViewList = false;
		try {
			WebElement xpathViewList = driveR
					.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/singleItemIcon']"));
			isViewList = xpathViewList.isDisplayed();
		} catch (NoSuchElementException e) {
		}
		return isViewList;
	}

	public void verifySignOffCodeRotateButton() throws Throwable {

		WebElement xpathSignOffCodeRotate = driveR
				.findElement(By.xpath("//android.widget.Button[@text='SIGN-OFF CODE ROTATE']"));
		xpathSignOffCodeRotate.isDisplayed();
	}

	public void verifySignOffCodeRotateIsEnabled() throws Throwable {

		WebElement xpathSignOffCodeRotate = driveR
				.findElement(By.xpath("//android.widget.Button[@text='SIGN-OFF CODE ROTATE']"));
		xpathSignOffCodeRotate.isDisplayed();

		String isEnabled = xpathSignOffCodeRotate.getAttribute("enabled");
		assertEquals(isEnabled, "true", "Sign off code rotate button is not enabled");
	}

	public void verifySignOffCodeRotateIsDisabled() throws Throwable {

		WebElement xpathSignOffCodeRotate = driveR
				.findElement(By.xpath("//android.widget.Button[@text='SIGN-OFF CODE ROTATE']"));
		xpathSignOffCodeRotate.isDisplayed();

		String isDisabled = xpathSignOffCodeRotate.getAttribute("enabled");
		assertEquals(isDisabled, "false", "Sign off code rotate button is not disabled");
	}

	public void clickOnSignOffCodeRotateButton() throws Throwable {

		WebElement xpathSignOffCodeRotate = driveR
				.findElement(By.xpath("//android.widget.Button[@text='SIGN-OFF CODE ROTATE']"));
		xpathSignOffCodeRotate.isDisplayed();

		xpathSignOffCodeRotate.click();
	}

	public void verifyConfirmSignOffAlert() throws Throwable {

		WebElement xpathSignOffAlert = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		xpathSignOffAlert.isDisplayed();

		String confirmSignOffAlert = xpathSignOffAlert.getText();

		assertEquals(confirmSignOffAlert, "Confirm Sign-Off", "Confirm sign off alert text is mismatched");

		WebElement xpathSignOffAlertText = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		xpathSignOffAlertText.isDisplayed();

		String signOffAlertText = xpathSignOffAlertText.getText();

		assertEquals(signOffAlertText,
				"Please confirm all scheduled checks have been completed and products listed with an expiry date of this week have been sold or wasted."
						+ "Once confirmed this week's check will be archived and cannot be amended.",
				"Confirm Sign-Off alert text is mismatched");

		WebElement xpathCancelButton = driveR.findElement(By.xpath("//android.widget.Button[@text='CANCEL']"));
		xpathCancelButton.isDisplayed();

		WebElement xpathConfirmButton = driveR.findElement(By.xpath("//android.widget.Button[@text='CONFIRM']"));
		xpathConfirmButton.isDisplayed();

	}

	public void clickOnCancelSignOffButton() throws Throwable {

		WebElement xpathCancelButton = driveR
				.findElement(By.xpath("//android.widget.Button[@text='CANCEL' or @text='Cancel']"));
		xpathCancelButton.isDisplayed();

		xpathCancelButton.click();

	}

	public void verifySignOffRotateButtonIsDisplayed() throws Throwable {
		Thread.sleep(3000);
		WebElement xpathSignOffCodeRotateButton = driveR
				.findElement(By.xpath("//android.widget.Button[@resource-id='" + env + ":id/inner_button']"));
		xpathSignOffCodeRotateButton.isDisplayed();

		String signOffCodeRotateButtonText = xpathSignOffCodeRotateButton.getText();

		assertEquals(signOffCodeRotateButtonText, "SIGN-OFF CODE ROTATE",
				"SIGN-OFF CODE ROTATE button is not displayed");
	}

	public void clickOnConfirmSignOffButton() throws Throwable {

		WebElement xpathConfirmButton = driveR
				.findElement(By.xpath("//android.widget.Button[@text='CONFIRM' or @text='Confirm']"));
		xpathConfirmButton.isDisplayed();

		xpathConfirmButton.click();
	}

	public void verifySignOffCodeRotateIsNotClickable() throws Throwable {

		WebElement xpathSignOffCodeRotate = driveR
				.findElement(By.xpath("//android.widget.Button[@text='SIGN-OFF CODE ROTATE']"));
		xpathSignOffCodeRotate.isDisplayed();

		String isClickable = xpathSignOffCodeRotate.getAttribute("clickable");
		assertEquals(isClickable, "false", "Sign off code rotate button is Clickable");
	}

	public void getWeekScheduleText() throws Throwable {
		List<AndroidElement> profile = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement a : profile) {

			String abc = a.getText();
			System.err.println("List is as follows  " + abc);

		}
		String firstElementInlist = profile.get(profile.size() - 4).getText();
		System.out.println("First Element in List:------------" + firstElementInlist);
		selectedWeek = profile.get(profile.size() - 4).getText();
	}

	public void verifyWeekIsNotDisplayed() throws Throwable {

		List<String> weekScheduleList = new ArrayList<String>();

		List<AndroidElement> xpathWeekSchedules = driveR.findElements(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		for (AndroidElement xpathWeekSchedule : xpathWeekSchedules) {

			weekScheduleList.add(xpathWeekSchedule.getText());
		}

		boolean weekDisplayed = weekScheduleList.contains(selectedWeek); // Verifying
																			// week
																			// is
																			// present
																			// in
																			// week
																			// scedules
																			// or
																			// not

		assertEquals(weekDisplayed, false,
				"After clicking on Sign-Off Code Rotate button, Week is displayed in Week Schedules");
	}

	public void clickOnMainMenu() throws Throwable {
		WebElement xpathMainMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']"));
		xpathMainMenu.isDisplayed();
		xpathMainMenu.click();
	}

	public void verifyMainMenuBox() throws Throwable {
		String mainMenuBoxTitle = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/title']")).getText();

		assertEquals(mainMenuBoxTitle, "Main Menu", "Main menu box is not displayed");

	}

	public void verifySelectAProductGroup() throws Throwable {
		String selectAProductGroupText = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/txt_action']")).getText();

		assertEquals(selectAProductGroupText, "Select a product group", "Select a product group is not displayed");
	}

	// Adding given days in current date and selecting the date
	public void selectDate(int addDays) throws Throwable {

		boolean otherDevice = true;

		try {
			WebElement xpathDateField = driveR
					.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));
			xpathDateField.isDisplayed();
		} catch (NoSuchElementException e) {
			otherDevice = false; // For CT 60 device, flag value will be false
		}

		LocalDateTime today = LocalDateTime.now(); // Storing current date
		LocalDateTime nextDay = today.plusDays(addDays);// Adding days in
														// current date

		int date = nextDay.getDayOfMonth();
		System.out.println(date);// Getting Date
		Month month = nextDay.getMonth();
		System.out.println(month); // Getting Month
		int year = nextDay.getYear();
		System.out.println(year); // Getting Year

		// To set the Calendar format - If date is less than or equal to 9, then
		// adding '0' before the date.
		String date1 = null;

		if (date <= 9) {
			date1 = "0" + String.valueOf(date);
		} else {
			date1 = String.valueOf(date);
		}

		if (otherDevice) // For CT 50 device Calendar
		{
			System.out.println("CT 50 device");

			List<WebElement> lowerDatePicker = driveR.findElements(By.xpath("//android.widget.Button[@index='2']"));
			List<WebElement> upperDatePicker = driveR.findElements(By.xpath("//android.widget.Button[@index='0']"));

			try {
				while (upperDatePicker.get(2).isDisplayed()) {
					List<WebElement> calendarList = driveR.findElements(
							By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));
					int selectedYear = Integer.parseInt(calendarList.get(2).getText());

					if (year != selectedYear) {
						upperDatePicker.get(2).click();
					} else
						break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			String expMonth = month.toString().substring(0, 3);
			String expMonth1 = expMonth.charAt(0) + expMonth.substring(1, expMonth.length()).toLowerCase(); // Creating
																											// Month
																											// in
																											// format.
																											// eg.
																											// Feb

			while (lowerDatePicker.get(1).isDisplayed()) {

				List<WebElement> mmm = driveR.findElements(
						By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));

				if (!expMonth1.equals(mmm.get(1).getText())) {
					lowerDatePicker.get(1).click();
				} else
					break;
			}

			while (lowerDatePicker.get(0).isDisplayed()) {
				List<WebElement> ddd = driveR.findElements(
						By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));

				if (!date1.equals(ddd.get(0).getText())) {
					lowerDatePicker.get(0).click();
				} else
					break;
			}
		} else // For CT 60 device Calendar
		{
			System.out.println("CT 60 device");

			String m = month.toString(); // month is FEBRUARY
			String mnth = m.charAt(0) + m.substring(1, m.length()).toLowerCase(); // Creating
																					// Month
																					// in
																					// format.
																					// eg.
																					// February

			String selectDate = date1 + " " + mnth + " " + year; // Creating
																	// date in
																	// format .
																	// eg. 01
																	// February
																	// 2020
			System.out.println("Select date : " + selectDate);

			// If date is not available in current month, clicking on Next
			// button

			for (int arrow = 0; arrow < 2; arrow++) {
				try {
					Thread.sleep(2000);
					driveR.findElement(By.xpath("//android.view.View[@content-desc='" + selectDate + "']"))
							.isDisplayed();
					break;
				} catch (NoSuchElementException e) {
					WebElement xpathNextArrow = driveR
							.findElement(By.xpath("//android.widget.ImageButton[@resource-id='android:id/next']"));

					xpathNextArrow.click();
				}
			}
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//android.view.View[@content-desc='" + selectDate + "']")).click(); // Selecting
																												// date
		}
	}

	public void verifyClearanePopupMessage(String expectedMessage) throws Throwable {

		WebElement xpathClearanceMessage = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		xpathClearanceMessage.isDisplayed();

		String actualMessage = xpathClearanceMessage.getText();

		assertEquals(actualMessage, expectedMessage, "Message is mismatched");
	}

	public void firstMarkdownPopupNotDisplayed() throws Throwable {
		boolean isAlertPresent = false;
		try {
			WebElement xpathClearanceMessage = driveR
					.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
			xpathClearanceMessage.isDisplayed();
		} catch (Exception e) {
			Thread.sleep(3000);
			isAlertPresent = true;
		}

		assertEquals(isAlertPresent, true, "Alert is displayed");
	}

	public void iClickOnOkButton() throws Throwable {
		WebElement xpathOkButton = driveR.findElement(By.xpath("//android.widget.Button[@text='OK' or @text='Ok']"));
		xpathOkButton.isDisplayed();
		xpathOkButton.click();
	}

	public void swipeLeft() throws InterruptedException {
		Thread.sleep(3000);

		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(884, 863)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(0, 468)).release().perform();
		Thread.sleep(3000);
	}

	public void alertSwipeLeftProductNonDeletable() throws InterruptedException {
		Thread.sleep(3000);

		TouchAction ts = new TouchAction(driveR);

		if (ts.press(PointOption.point(884, 863)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(0, 468)).release().perform() != null) {
			System.out.println("Alerts are non deletable");
		} else {
			System.out.println("Alerts are deletable");
		}
		Thread.sleep(3000);
	}

	public void verifyDeleteIconIsEnabled() throws InterruptedException {
		Thread.sleep(3000);
		WebElement xpathDeleteIcon = driveR
				.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/delete_button']"));

		String isEnabled = xpathDeleteIcon.getAttribute("enabled");

		assertEquals(isEnabled, "true", "Delete icon is not Enabled");
	}

	public void verifyDeleteIconIsDisabled() throws InterruptedException {

		WebElement xpathDeleteIcon = driveR.findElement(
				By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/delete_button_disabled']"));

		String isClickable = xpathDeleteIcon.getAttribute("clickable");

		assertEquals(isClickable, "false", "Delete icon is not Disabled");

	}

	public void deleteTheProduct() throws InterruptedException {

		WebElement xpathDeleteIcon = driveR
				.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/delete_button']"));

		xpathDeleteIcon.isDisplayed();
		xpathDeleteIcon.click();
	}

	public void getScanDateCode() throws InterruptedException, ParseException {

		WebElement xpathScanDateCode = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));

		xpathScanDateCode.isDisplayed();

		String scanDateCode = xpathScanDateCode.getText().split(" ")[3];

		scanDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanDateCode);
	}

	public void getMaximumDateEntryInTheCalendar() throws InterruptedException, ParseException {

		boolean otherDevice = true;

		try {
			WebElement xpathDateField = driveR
					.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));
			xpathDateField.isDisplayed();
		} catch (NoSuchElementException e) {
			otherDevice = false; // For CT 60 device, flag value will be false
		}

		if (otherDevice)// For CT 50 device calendar
		{
			List<WebElement> lowerDatePicker = driveR.findElements(By.xpath("//android.widget.Button[@index='2']"));
			List<WebElement> upperDatePicker = driveR.findElements(By.xpath("//android.widget.Button[@index='0']"));

			List<WebElement> calendarList = driveR
					.findElements(By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input']"));

			try {
				while (lowerDatePicker.get(2).isDisplayed()) {
					lowerDatePicker.get(2).click();
				}
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				while (lowerDatePicker.get(1).isDisplayed()) {
					lowerDatePicker.get(1).click();
				}
			} catch (Exception e) {
				e.getMessage();
			}

			String maxdate = calendarList.get(0).getText();
			System.out.println(maxdate);

			maximumDateOnCalendar = new SimpleDateFormat("dd/MM/yyyy").parse(maxdate);
		}
		// For CT 60 device calendar
		else {
			WebElement xpathNextArrow = driveR
					.findElement(By.xpath("//android.widget.ImageButton[@resource-id='android:id/next']"));

			xpathNextArrow.isDisplayed();

			try {
				while (xpathNextArrow.isDisplayed()) {

					Thread.sleep(3000);
					xpathNextArrow.click();
				}
			} catch (Exception e) {
				Thread.sleep(3000);
			}
			List<AndroidElement> dateList = driveR.findElements(MobileBy.xpath("//android.view.View[@text]"));
			System.out.println("Total date : " + dateList.size());

			List<String> allDate = new ArrayList<String>();
			String dateText = null;

			for (int i = 1; i <= dateList.size() - 1; i++) {
				WebElement xpathDate = driveR.findElement(By.xpath("//android.view.View[@text=" + i + "]"));
				String isEnabled = xpathDate.getAttribute("enabled");

				if (isEnabled.equals("true")) {
					dateText = xpathDate.getAttribute("contentDescription");
					allDate.add(dateText);
				}
			}

			String maxdate = allDate.get(allDate.size() - 1).replace(" ", "");
			System.out.println(maxdate);

			String maximumDate = maxdate.replace("January", "/01/").replace("February", "/02/").replace("March", "/03/")
					.replace("April", "/04/").replace("May", "/05/").replace("June", "/06/").replace("July", "/07/")
					.replace("August", "/08/").replace("September", "/09/").replace("October", "/10/")
					.replace("November", "/11/").replace("December", "/12/");

			System.out.println(maximumDate);

			maximumDateOnCalendar = new SimpleDateFormat("dd/MM/yyyy").parse(maximumDate);
		}
	}

	public void compareScanDateWithMaxDateInCalendar() throws InterruptedException {

		assertEquals(maximumDateOnCalendar, scanDate, "Date is Mismatched");
	}

	// Verifying Weekly schedule sub menu is displayed
	public void verifyWeeklySchedulesSubmenu() throws InterruptedException {
		WebElement xpathWeeklySchedule = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Weekly Schedules']"));
		xpathWeeklySchedule.isDisplayed();
	}

	// Getting Weekly schedule sub menu status
	public void getWeeklyScheduleSubmenuStatus() throws InterruptedException {
		try {
			WebElement xpathWeeklySchedule = driveR.findElement(
					MobileBy.xpath("//android.widget.RelativeLayout[@index='3']/android.widget.TextView[@resource-id='"
							+ env + ":id/department_status']"));

			weeklyScheduleStatus = xpathWeeklySchedule.getText();
			System.out.println(weeklyScheduleStatus);
		} catch (NoSuchElementException e) {

			weeklyScheduleStatus = "Not Started";
			System.out.println(weeklyScheduleStatus);
		}
	}

	// Verifying Weekly schedule list is displayed
	public void verifyWeeklySchedulesList() throws InterruptedException {
		Thread.sleep(3000);
		WebElement xpathWeeklySchedule = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='Weekly Schedules']"));
		xpathWeeklySchedule.isDisplayed();

		WebElement xpathWeeklyScheduleList = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));
		xpathWeeklyScheduleList.isDisplayed();
	}

	// Getting First Week schedule status
	public void getFirstWeekScheduleStatus() throws InterruptedException {
		try {
			WebElement xpathFirstWeekSchedule = driveR.findElement(
					By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@resource-id='" + env
							+ ":id/department_status']"));

			firstWeekScheduleStatus = xpathFirstWeekSchedule.getText();
			System.out.println(firstWeekScheduleStatus);
		} catch (NoSuchElementException e) {

			firstWeekScheduleStatus = "Not Started";
			System.out.println(firstWeekScheduleStatus);
		}
	}

	public void verifyStatusIsSame() throws InterruptedException {

		assertEquals(firstWeekScheduleStatus, weeklyScheduleStatus,
				"Weekly schedule submenu status is not same as First week status inside week schedule");
	}

	public void verifyDepartmentCompletionStatus() throws InterruptedException {

		WebElement xpathDepartmentCompletionStatus = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/description']"));

		xpathDepartmentCompletionStatus.isDisplayed();
	}

	public void getDepartmentCompletionStatusUI(String departmentNumner) throws InterruptedException {

		// Below map is declared to get value at Runtime
		HashMap<String, Integer> departmentNumber = new HashMap<String, Integer>();
		departmentNumber.put("First", 0);
		departmentNumber.put("Second", 1);
		departmentNumber.put("Third", 2);
		departmentNumber.put("Four", 3);
		departmentNumber.put("Five", 4);

		int index = departmentNumber.get(departmentNumner);

		Thread.sleep(3000);

		WebElement xpathDepartmentTitle = driveR.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@index='"
				+ index + "']/android.widget.TextView[@resource-id='" + env + ":id/department_title']"));

		departmentTitleUI = xpathDepartmentTitle.getText();
		System.out.println(departmentTitleUI);

		WebElement xpathDepartmentCompletionStatus = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/description']"));

		String status = xpathDepartmentCompletionStatus.getText();
		departmentUpdatedByNameUI = status.substring(status.indexOf("by") + 2, status.indexOf("on")).trim();

		departmentUpdatedOnUI = status.substring(status.indexOf("on") + 1).split(" ")[1].replaceAll("([a-z])", "");
	}

	public void getDeptStatus() throws InterruptedException {
		String departmentNameUI = cnRpageObjects.departmentNameUI;
		String departmentStatusUI = cnRpageObjects.departmentStatusUI;

		Thread.sleep(3000);

		departmentTitleUI = departmentNameUI;
		System.out.println(departmentTitleUI);

		WebElement xpathDepartmentCompletionStatus = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/description']"));

		String status = xpathDepartmentCompletionStatus.getText();
		departmentUpdatedByNameUI = status.substring(status.indexOf("by") + 2, status.indexOf("on")).trim();

		departmentUpdatedOnUI = status.substring(status.indexOf("on") + 1).split(" ")[1].replaceAll("([a-z])", "");
	}

	public void getQuantityForFirstItem() throws InterruptedException {
		WebElement xpathScannedItemCount = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_quantity_value']"));

		beforeScannedItemQuantity = Integer.parseInt(xpathScannedItemCount.getText().replaceAll("[^0-9]", ""));
	}

	public void verifyMergeQuantity() throws InterruptedException {

		WebElement xpathScannedItemCount = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_quantity_value']"));

		int mergeScannedItemQuantity = Integer.parseInt(xpathScannedItemCount.getText().replaceAll("[^0-9]", ""));

		int expectedMergeItemQuantity = beforeScannedItemQuantity + itemQuantity;

		assertEquals(mergeScannedItemQuantity, expectedMergeItemQuantity, "Scanned item quantity is not merged");

		System.out.println(expectedMergeItemQuantity);
	}

	public void verifyUnMergeQuantity() throws InterruptedException {

		WebElement xpathScannedItemCount = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_quantity_value']"));

		int mergeScannedItemQuantity = Integer.parseInt(xpathScannedItemCount.getText().replaceAll("[^0-9]", ""));

		int expectedMergeItemQuantity = Integer.parseInt(quantityText);

		assertEquals(mergeScannedItemQuantity, expectedMergeItemQuantity, "Scanned item quantity is merged");
	}

	public void getDetails(int qty) throws InterruptedException {
		itemQuantity = qty;
		System.out.println("qty = " + itemQuantity);
	}

	public void verifyCurrentlyUnavailbleAlert() throws InterruptedException {

		WebElement currentlyUnavailableAlert = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));

		String alertTitle = currentlyUnavailableAlert.getText();

		assertEquals(alertTitle, "Currently unavailable", "Alert title is mismatched");

		WebElement currentlyUnavailableMessage = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='android:id/message']"));

		String alertMessage = currentlyUnavailableMessage.getText();

		assertEquals(alertMessage, "Products cannot be captured until one week before the start date.",
				"Alert message is mismatched");

		WebElement xpathOkButton = driveR
				.findElement(MobileBy.xpath("//android.widget.Button[@text='Ok' or @text='OK']"));

		xpathOkButton.isDisplayed();
	}

	public void clickOnOkButtonOnAlert() throws InterruptedException {
		WebElement xpathOkButton = driveR
				.findElement(MobileBy.xpath("//android.widget.Button[@text='Ok' or @text='OK']"));

		xpathOkButton.isDisplayed();
		xpathOkButton.click();
		Thread.sleep(3000);
	}

	public void getItemDetailsUI() throws InterruptedException {

		WebElement xpathItemDescription = driveR.findElement(MobileBy
				.xpath("//android.widget.TextView[@resource-id='" + env + ":id/updated_list_item_description']"));

		itemDescriptionUI = xpathItemDescription.getText();

		WebElement xpathItemNumber = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_min']"));

		itemNumberUI = xpathItemNumber.getText();

		WebElement itemQuantity = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_quantity_value']"));

		actionPerformedUI = itemQuantity.getText();

		WebElement itemExpiryDate = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/list_item_expiry_date']"));

		expiryDateUI = itemExpiryDate.getText();

		WebElement departmentName = driveR.findElement(MobileBy.xpath("//android.widget.TextView[@index='1']"));

		deptNameUI = departmentName.getText();

	}

	public void verifyProductNotFountPopup() throws InterruptedException {
		Thread.sleep(3000);
		WebElement xpathPopupTitle = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));

		xpathPopupTitle.isDisplayed();

		String popupTitle = xpathPopupTitle.getText();

		assertEquals(popupTitle, "Product not found", "Popup Title is mismatched");

		WebElement xpathPopupText = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));

		xpathPopupText.isDisplayed();

		String popupText = xpathPopupText.getText();

		assertEquals(popupText, "Make sure you are scanning a valid product barcode and try again",
				"Popup text is mismatched");
	}

	public void verifyContactTechSupportPopup() throws InterruptedException {
		WebElement xpathPopup = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='android:id/message']"));

		xpathPopup.isDisplayed();

		String popupText = xpathPopup.getText();

		assertEquals(popupText, "You may be able to go back and try again, or contact Technology for assistance",
				"Popup text is mismatched");
	}

	public String VerifyItemDetailsInSummary() throws InterruptedException {
		boolean summaryPage = true;
		String pageName = null;

		try {
			WebElement xpathSummaryPage = driveR
					.findElement(MobileBy.xpath("//android.widget.TextView[@text='Item Summary']"));
			pageName = xpathSummaryPage.getText();
		} catch (NoSuchElementException e) {
			summaryPage = false;
			WebElement xpathEditSummaryPage = driveR
					.findElement(MobileBy.xpath("//android.widget.TextView[@text='Edit Item']"));
			pageName = xpathEditSummaryPage.getText();
		}

		if (summaryPage) {
			WebElement xpathProductTitle = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_title']"));
			xpathProductTitle.isDisplayed();

			WebElement xpathMinValue = driveR
					.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			xpathMinValue.isDisplayed();

			WebElement xpathOriginalPriceLabel = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/original_price_label']"));
			xpathOriginalPriceLabel.isDisplayed();

			WebElement xpathOriginalPrice = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/original_price']"));
			xpathOriginalPrice.isDisplayed();

			WebElement xpathDiscountLabel = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/discount_label']"));
			xpathDiscountLabel.isDisplayed();

			WebElement xpathDiscountDropdown = driveR.findElement(MobileBy
					.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/markdown_percentage_spinner']"));
			xpathDiscountDropdown.isDisplayed();

			WebElement xpathNewPriceLabel = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/new_price_label']"));
			xpathNewPriceLabel.isDisplayed();

			WebElement xpathNewPriceEdit = driveR.findElement(
					MobileBy.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_price_editable']"));
			xpathNewPriceEdit.isDisplayed();

			WebElement xpathMarkdownQuantityLabel = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_quantity_label']"));
			xpathMarkdownQuantityLabel.isDisplayed();

			WebElement xpathMarkdownQuantity = driveR.findElement(
					MobileBy.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_quantity']"));
			xpathMarkdownQuantity.isDisplayed();
		}

		else {
			WebElement xpathProductTitle = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_title']"));
			xpathProductTitle.isDisplayed();

			WebElement xpathMinValue = driveR
					.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/value']"));
			xpathMinValue.isDisplayed();

			WebElement xpathOriginalPriceLabel = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/original_price_label']"));
			xpathOriginalPriceLabel.isDisplayed();

			WebElement xpathOriginalPrice = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/original_price']"));
			xpathOriginalPrice.isDisplayed();

			WebElement xpathNewPriceLabel = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/new_price_title']"));
			xpathNewPriceLabel.isDisplayed();

			WebElement xpathNewPrice = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_price_fixed']"));
			xpathNewPrice.isDisplayed();

			WebElement xpathMarkdownQuantityLabel = driveR.findElement(
					MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_quantity_label']"));
			xpathMarkdownQuantityLabel.isDisplayed();

			WebElement xpathMarkdownQuantity = driveR.findElement(
					MobileBy.xpath("//android.widget.EditText[@resource-id='" + env + ":id/markdown_quantity']"));
			xpathMarkdownQuantity.isDisplayed();
		}
		return pageName;
	}

	public void clickOnBackButton(String screenName) throws InterruptedException {

		WebElement xpathBackButton = driveR.findElement(By.className("android.widget.ImageButton"));
		xpathBackButton.isDisplayed();

		if (screenName.equals("Edit Item")) {
			Thread.sleep(3000);
			xpathBackButton.click();
		}
	}

	public void getItemCountOnPrintList(String screenName) throws InterruptedException {

		if (screenName.equals("Edit Item")) {
			WebElement xpathItemQuantity = driveR.findElement(MobileBy
					.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']"));
			xpathItemQuantity.isDisplayed();

			initialCount = Integer.parseInt(xpathItemQuantity.getText());
		}
	}

	public void SelectDiscountPercentage() throws InterruptedException {

		WebElement xpathDiscountDropdown = driveR.findElement(
				MobileBy.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/markdown_percentage_spinner']"));

		xpathDiscountDropdown.isDisplayed();

		xpathDiscountDropdown.click();

		WebElement xpathSelectDiscount = driveR
				.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@index='1']"));

		xpathSelectDiscount.isDisplayed();
		xpathSelectDiscount.click();
	}

	public void VerifyItemDetailsOnPrintList() throws InterruptedException {

		WebElement xpathListHeaderCount = driveR.findElement(MobileBy
				.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_list_expanded_header_count']"));
		xpathListHeaderCount.isDisplayed();

		WebElement xpathItemDescriptin = driveR.findElement(MobileBy
				.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_description']"));
		xpathItemDescriptin.isDisplayed();

		WebElement xpathItemQuantity = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']"));
		xpathItemQuantity.isDisplayed();

		WebElement xpathItemMin = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_min']"));
		xpathItemMin.isDisplayed();
	}

	public void GetCountOnPrintList() throws InterruptedException {

		WebElement xpathItemQuantity = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']"));
		xpathItemQuantity.isDisplayed();

		itemQuantityPrintList = Integer.parseInt(xpathItemQuantity.getText());
	}

	public void VerifyItemQuantityIsMerged() throws InterruptedException {

		WebElement xpathItemQuantity = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']"));
		xpathItemQuantity.isDisplayed();

		latestItemQuantityPrintList = Integer.parseInt(xpathItemQuantity.getText());
		int addedQuantity = Integer.parseInt(quantityText);

		int expectedCount = initialCount + addedQuantity;

		assertEquals(latestItemQuantityPrintList, expectedCount, "Item quantity on Print List page is not Merged");
	}

	public void VerifyItemQuantityIsUnMerged() throws InterruptedException {

		WebElement xpathItemQuantity = driveR.findElement(
				MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdown_list_item_quantity']"));
		xpathItemQuantity.isDisplayed();

		latestItemQuantityPrintList = Integer.parseInt(xpathItemQuantity.getText());

		int addedQuantity = Integer.parseInt(quantityText);

		assertEquals(latestItemQuantityPrintList, addedQuantity, "Item quantity on Print List page is not UnMerged");
	}

	public void verifyLargeMarkdwonQuantity() throws InterruptedException {

		Thread.sleep(3000);
		WebElement xpathLargeMarkdwonQuantityTitle = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='" + env + ":id/alertTitle']"));
		xpathLargeMarkdwonQuantityTitle.isDisplayed();

		WebElement xpathLargeQuantityAlertText = driveR
				.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		xpathLargeQuantityAlertText.isDisplayed();

		WebElement xpathCancelButton = driveR
				.findElement(MobileBy.xpath("//android.widget.Button[@text='Cancel' or @text='CANCEL']"));
		xpathCancelButton.isDisplayed();

		WebElement xpathConfirmButton = driveR
				.findElement(MobileBy.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']"));
		xpathConfirmButton.isDisplayed();
	}

	public void clickOnAlertCancelButton() throws InterruptedException {

		WebElement xpathCancelButton = driveR
				.findElement(MobileBy.xpath("//android.widget.Button[@text='Cancel' or @text='CANCEL']"));
		xpathCancelButton.isDisplayed();
		xpathCancelButton.click();
		Thread.sleep(3000);
	}

	public void clickOnAlertConfirmButton() throws InterruptedException {

		WebElement xpathConfirmButton = driveR
				.findElement(MobileBy.xpath("//android.widget.Button[@text='Confirm' or @text='CONFIRM']"));
		xpathConfirmButton.isDisplayed();
		xpathConfirmButton.click();
		Thread.sleep(3000);
	}

	public void enterPrinterBarcode(String barcode) throws Throwable {

		Thread.sleep(3000);
		driveR.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/action_barcode_entry']"))
				.sendKeys(barcode);

		new TouchAction((AppiumDriver) driveR).press(PointOption.point(715, 1278)).release().perform();
	}

	public void clickOnPrintButton() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathPrintButton = driveR
				.findElement(By.xpath("//android.widget.Button[@text ='PRINT' or @text ='Print']"));

		xpathPrintButton.isDisplayed();
		xpathPrintButton.click();
	}

	//////////////// C&R 2,3

	public void clickOnMarkdownMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathMarkdownMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/markdowns']"));

		xpathMarkdownMenu.isDisplayed();
		xpathMarkdownMenu.click();
	}

	public void clickOnStockAdjustmentMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathStockAdjustmentMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stock_adjustment']"));

		xpathStockAdjustmentMenu.isDisplayed();
		xpathStockAdjustmentMenu.click();
	}

	public void clickOnCountMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathCountMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/count']"));

		xpathCountMenu.isDisplayed();
		xpathCountMenu.click();
	}

	public void clickOnGLHMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathGlhMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/store_walk']"));

		xpathGlhMenu.isDisplayed();
		xpathGlhMenu.click();
	}

	public void iClickOnSalesOrderMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathSalesOrderMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='Sales Orders']"));

		xpathSalesOrderMenu.isDisplayed();
		xpathSalesOrderMenu.click();
	}

	public void clickOnShelfEdgeLabelToStack() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathShelfEdgeLabelToStock = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/sel_printing']"));

		xpathShelfEdgeLabelToStock.isDisplayed();
		xpathShelfEdgeLabelToStock.click();
	}

	public void iClickOnYellowScreens() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathYellowScreens = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/legacy_app']"));

		xpathYellowScreens.isDisplayed();
		xpathYellowScreens.click();
	}

	public void clickOnStockInformationMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathStockInformation = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/stock_information']"));

		xpathStockInformation.isDisplayed();
		xpathStockInformation.click();
	}

	public void clickOnGLHScreenMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathGLHScreenMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/store_walk']"));

		xpathGLHScreenMenu.isDisplayed();
		xpathGLHScreenMenu.click();
	}

	public void clickOnCleanAndRotateMenu() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathCleanAndRotateMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/clean_rotate']"));

		xpathCleanAndRotateMenu.isDisplayed();
		xpathCleanAndRotateMenu.click();
	}

	public void clickOnHotkeys() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathHotkeys = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/context_menu']"));

		xpathHotkeys.isDisplayed();
		xpathHotkeys.click();
	}

	public void verifyMarkdownOptionNotAvailable() throws Throwable {
		boolean isMarkdownDisplayed = true;
		try {
			WebElement xpathMarkdownOption = driveR
					.findElement(By.xpath("//android.widget.TextView[@text ='Markdowns' or @text ='MARKDOWNS']"));

			xpathMarkdownOption.isDisplayed();
		} catch (Exception e) {
			isMarkdownDisplayed = false;
		}

		assertEquals(isMarkdownDisplayed, false, "Markdown option is available in hotekeys");

	}

	public void verifyStockAdjustmentOptionAvailable() throws Throwable {

		WebElement xpathStockAdjustmentMenu = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Stock Adjustments' or @text ='STOCK ADJUSTMENTS']"));

		xpathStockAdjustmentMenu.isDisplayed();

	}

	public void clickOnStockAdjustmentFromHotkeys() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathStockAdjustmentMenu = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Stock Adjustments' or @text ='STOCK ADJUSTMENTS']"));

		xpathStockAdjustmentMenu.isDisplayed();
		xpathStockAdjustmentMenu.click();
	}

	public void verifyStockAdjustmentPageDisplayed() throws Throwable {

		WebElement xpathStockAdjustmentMenu = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Stock Adjustments' or @text ='STOCK ADJUSTMENTS']"));

		xpathStockAdjustmentMenu.isDisplayed();

	}

	public void iVerifyStockInformationOptionAvailable() throws Throwable {

		WebElement xpathStockAdjustmentMenu = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Stock Information' or @text ='STOCK INFORMATION']"));

		xpathStockAdjustmentMenu.isDisplayed();

	}

	public void iClickOnStockInformationFromHotkeys() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathStockAdjustmentMenu = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Stock Information' or @text ='STOCK INFORMATION']"));

		xpathStockAdjustmentMenu.isDisplayed();
		xpathStockAdjustmentMenu.click();
	}

	public void verifyStockInformationPageDisplayed() throws Throwable {

		WebElement xpathStockInformationMenu = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Stock Information' or @text ='STOCK INFORMATION']"));

		xpathStockInformationMenu.isDisplayed();

	}

	public void clickOnBackButton() throws Throwable {

		Thread.sleep(4000);
		WebElement xpathBackButton = driveR.findElement(By.className("android.widget.ImageButton"));
		xpathBackButton.isDisplayed();

		xpathBackButton.click();
		Thread.sleep(3000);
	}

	public void verifyStockAdjustmentOptionNotAvailable() throws Throwable {
		boolean isStockAdjustments = true;
		try {
			WebElement xpathStockAdjustmentMenu = driveR.findElement(
					By.xpath("//android.widget.TextView[@text ='Stock Adjustments' or @text ='STOCK ADJUSTMENTS']"));

			isStockAdjustments = xpathStockAdjustmentMenu.isDisplayed();
		} catch (Exception e) {
			isStockAdjustments = false;
		}

		assertEquals(isStockAdjustments, false, "Stock adjustment option is available in hotekeys");

	}

	public void verifyShelfEdgeLabelToStackOption() throws Throwable {

		WebElement xpathShelfEdgeLabelToStock = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Shelf Edge Label to Stack' or @text ='SHELF EDGE LABEL TO STACK']"));

		xpathShelfEdgeLabelToStock.isDisplayed();
	}

	public void clickShelfEdgeLabelToStackOption() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathShelfEdgeLabelToStock = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Shelf Edge Label to Stack' or @text ='SHELF EDGE LABEL TO STACK']"));

		xpathShelfEdgeLabelToStock.isDisplayed();
		xpathShelfEdgeLabelToStock.click();
	}

	public void verifyShelfEdgeLabelToStackPage() throws Throwable {
		WebElement xpathShelfEdgeLabelToStock = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Select EPISYS Print Queue' or @text ='SELECT EPISYS PRINT QUEUE']"));

		xpathShelfEdgeLabelToStock.isDisplayed();

	}

	public void verifyMarkdownOptionAvailable() throws Throwable {

		WebElement xpathMarkdownOption = driveR
				.findElement(By.xpath("//android.widget.TextView[@text ='Markdowns' or @text ='MARKDOWNS']"));

		xpathMarkdownOption.isDisplayed();

	}

	public void clickScanMarkdownSubmenus() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathScanMarkdownSubmenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/view_scan_markdown']"));

		xpathScanMarkdownSubmenu.isDisplayed();
		xpathScanMarkdownSubmenu.click();
	}

	public void clickMardownsList() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathMarkdownList = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/view_markdown_list']"));

		xpathMarkdownList.isDisplayed();
		xpathMarkdownList.click();
	}

	public void iClickOnMarkdownOption() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathMarkdownOption = driveR
				.findElement(By.xpath("//android.widget.TextView[@text ='Markdowns' or @text ='MARKDOWNS']"));

		xpathMarkdownOption.isDisplayed();
		xpathMarkdownOption.click();
	}

	public void iVerifyMarkdownMainPage() throws Throwable {
		Thread.sleep(3000);
		WebElement xpathMarkdownMainPage = driveR
				.findElement(By.xpath("//android.widget.TextView[@text ='Markdowns' or @text ='MARKDOWNS']"));

		xpathMarkdownMainPage.isDisplayed();
		xpathMarkdownMainPage.click();
	}

	public void iClickOnWastageSubmenus() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathWastageSubmenus = driveR
				.findElement(By.xpath("//android.widget.TextView[@text ='Wastage' or @text ='WASTAGE']"));

		xpathWastageSubmenus.isDisplayed();
		xpathWastageSubmenus.click();
	}

	public void iClickOnTransferStockToADept() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathTransferStockToADept = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Transfer Stock To A Dept' or @text ='TRANSFER STOCK TO A DEPT']"));

		xpathTransferStockToADept.isDisplayed();
		xpathTransferStockToADept.click();
	}

	public void iClickOnTransferBAckFromADept() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathTransferBAckFromADept = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Transfer Back From A Dept' or @text ='TRANSFER BACK FROM A DEPT']"));

		xpathTransferBAckFromADept.isDisplayed();
		xpathTransferBAckFromADept.click();
	}

	public void iClickOnOtherAdjustments() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathOtherAdjustments = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Other Adjustments' or @text ='OTHER ADJUSTMENTS']"));

		xpathOtherAdjustments.isDisplayed();
		xpathOtherAdjustments.click();
	}

	public void iClickOnStoreToStoreTransfer() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathStoreToStoreTransfer = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Store To Store Transfer' or @text ='STORE TO STORE TRANSFER']"));

		xpathStoreToStoreTransfer.isDisplayed();
		xpathStoreToStoreTransfer.click();
	}

	public void verifyCleararnceBayAndAlert() throws Throwable {
		WebElement xpathClearanceBayAndAlert = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Ambient & Frozen Code Alerts' or @text ='Ambient & Frozen Code Alerts']"));

		xpathClearanceBayAndAlert.isDisplayed();

	}

	public void clickCleararnceBayAndAlert() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathClearanceBayAndAlert = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Ambient & Frozen Code Alerts' or @text ='Ambient & Frozen Code Alerts']"));

		xpathClearanceBayAndAlert.isDisplayed();
		xpathClearanceBayAndAlert.click();
	}

	public void verifyWeeklyScheduleDepartment() throws Throwable {

		WebElement xpathWeeklyScheduleDepartment = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Weekly Schedules' or @text ='WEEKLY SCHEDULE']"));

		xpathWeeklyScheduleDepartment.isDisplayed();
	}

	public void clickWeeklyScheduleDepartment() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathWeeklyScheduleDepartment = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Weekly Schedules' or @text ='WEEKLY SCHEDULE']"));

		xpathWeeklyScheduleDepartment.isDisplayed();
		xpathWeeklyScheduleDepartment.click();
	}

	public void verifyActionLogProduct() throws Throwable {

		WebElement xpathActionLogProduct = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Date Code Alerts' or @text ='DATE CODE ALERTS']"));

		xpathActionLogProduct.isDisplayed();

	}

	public void clickOnActionLogProduct() throws Throwable {

		Thread.sleep(3000);
		WebElement xpathActionLogProduct = driveR.findElement(
				By.xpath("//android.widget.TextView[@text ='Date Code Alerts' or @text ='DATE CODE ALERTS']"));

		xpathActionLogProduct.isDisplayed();
		xpathActionLogProduct.click();
	}

	public void clickOnCrossIcon() throws Throwable {
		Thread.sleep(3000);
		WebElement xpathBackButton = driveR.findElement(By.className("android.widget.ImageButton"));
		xpathBackButton.isDisplayed();
		xpathBackButton.click();
		System.out.println("Click on cross icon");
	}

	public void verifyDeptBanner(String status) throws Throwable {

		Thread.sleep(3000);
		WebElement xpathDeptBanner = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_status']"));
		String deptStatus = xpathDeptBanner.getText();

		assertEquals(deptStatus, status, "Department banner is not as expected");
	}

	//////////////// CnR 1,7,8/////////////////

	public void verifyAmbientAndFrozenSubmenu() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathAmbientAndFrozenSubmenu = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Ambient & Frozen Code Alerts' or @text ='AMBIENT & FROZEN CODE ALERTS']"));

		xpathAmbientAndFrozenSubmenu.isDisplayed();
	}

	public void clickAmbientAndFrozenSubmenu() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathAmbientAndFrozenSubmenu = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Ambient & Frozen Code Alerts' or @text ='AMBIENT & FROZEN CODE ALERTS']"));

		xpathAmbientAndFrozenSubmenu.click();
	}

	public void iSelectTheProduct() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathProduct = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_name']"));

		xpathProduct.isDisplayed();
		xpathProduct.click();
	}

	public void selectMin(String min) throws Throwable {

		Thread.sleep(2000);

		WebElement xpathProduct = driveR
				.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + min + "')]"));
		xpathProduct.isDisplayed();
		xpathProduct.click();

		Thread.sleep(2000);
	}

	public void iEnterTheQuantity() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathQuantity = driveR
				.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/edt_remain_qty']"));

		xpathQuantity.isDisplayed();

		Thread.sleep(3000);
		xpathQuantity.sendKeys("4");

		Thread.sleep(3000);

		driveR.hideKeyboard();
	}

	public void enterQuantity(String qty) throws Throwable {

		Thread.sleep(2000);
		WebElement xpathQuantity = driveR
				.findElement(By.xpath("//android.widget.EditText[@resource-id='" + env + ":id/edt_remain_qty']"));

		xpathQuantity.isDisplayed();

		Thread.sleep(3000);
		xpathQuantity.sendKeys(qty);

		Thread.sleep(3000);

		// driveR.hideKeyboard();
	}

	public void clickOnAddNextActionbutton() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathAddNextActionbutton = driveR
				.findElement(By.xpath("//android.widget.Button[@text ='Add Next Action' or @text ='ADD NEXT ACTION']"));

		xpathAddNextActionbutton.isDisplayed();
		xpathAddNextActionbutton.click();
		Thread.sleep(2000);
	}

	public void verifyWastagePopupMessage() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathWastagePopupHeader = driveR.findElement(By.xpath("//android.widget.TextView[@index='0']"));
		xpathWastagePopupHeader.isDisplayed();
		Thread.sleep(2000);
		String wastageHeader = xpathWastagePopupHeader.getText();

		assertEquals(wastageHeader, "Wastage Reason", "Wastage popup header is mismatched");

		WebElement xpathWastagePopupMessage = driveR.findElement(By.xpath("//android.widget.TextView[@index='1']"));
		xpathWastagePopupMessage.isDisplayed();
		Thread.sleep(2000);
		String wastageMessage = xpathWastagePopupMessage.getText();

		assertEquals(wastageMessage,
				"Wastage is removed from stock on hand, once confirmed it will not be editable from the list.",
				"Wastage popup message is not display as expected");

	}

	public void verifyWastageReasonCode() throws Throwable {
		Thread.sleep(2000);
		WebElement xpathWastageFirstReason = driveR
				.findElement(By.xpath("//android.widget.CheckedTextView[@text='Waste Out of Date']"));
		xpathWastageFirstReason.isDisplayed();
	}

	public void verifyConfirmAndCancelButtons() throws Throwable {
		Thread.sleep(2000);
		WebElement xpathConfirmButton = driveR
				.findElement(By.xpath("//android.widget.Button[@text ='CONFIRM' or @text ='Confirm']"));
		xpathConfirmButton.isDisplayed();

		Thread.sleep(2000);
		WebElement xpathCancelButton = driveR
				.findElement(By.xpath("//android.widget.Button[@text ='CANCEL' or @text ='Cancel']"));
		xpathCancelButton.isDisplayed();
	}

	public void verifyAlertsValuesInDropdown() throws Throwable {

		Thread.sleep(2000);

		WebElement xpathAllValues = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id ='android:id/text1' and @index='0']"));
		xpathAllValues.isDisplayed();
		String allValuesText = xpathAllValues.getText();
		assertEquals(allValuesText, "All Alerts", "Alert option is mismatched");

		WebElement xpathFirstAlert = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id ='android:id/text1' and @index='1']"));
		xpathFirstAlert.isDisplayed();
		String firstAlertText = xpathFirstAlert.getText();
		assertEquals(firstAlertText, "1st Alerts", "Alert option is mismatched");

		WebElement xpathClearanceAlert = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id ='android:id/text1' and @index='2']"));
		xpathClearanceAlert.isDisplayed();
		String clearanceAlertText = xpathClearanceAlert.getText();
		assertEquals(clearanceAlertText, "Clearance Alerts", "Alert option is mismatched");

	}

	public void clickOnFrozenClearance() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathFrozenClearanceBayCheck = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Frozen Clearance Bay Check' or @text ='FROZEN CLEARANCE BAY CHECK']"));
		xpathFrozenClearanceBayCheck.isDisplayed();

		xpathFrozenClearanceBayCheck.click();
	}

	public void verifyFrozenClearanceBayText() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathFrozenClearanceBayText = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Frozen Clearance Bay Check' or @text ='FROZEN CLEARANCE BAY CHECK']"));
		xpathFrozenClearanceBayText.isDisplayed();

	}

	public void verifyConfirmClearanceBayCheckButton() throws Throwable {

		Thread.sleep(2000);
		WebElement confirmClearanceBayCheckButton = driveR.findElement(By.xpath(
				"//android.widget.Button[@text ='Confirm Clearance Bay Check' or @text ='CONFIRM CLEARANCE BAY CHECK']"));
		confirmClearanceBayCheckButton.isDisplayed();

	}

	public void clickOnAmbientClearance() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathAmbientClearanceBayCheck = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Ambient Clearance Bay Check' or @text ='AMBIENT CLEARANCE BAY CHECK']"));
		xpathAmbientClearanceBayCheck.isDisplayed();

		xpathAmbientClearanceBayCheck.click();
	}

	public void verifyAmbientClearanceBayText() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathAmbientClearanceBayText = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text ='Ambient Clearance Bay Check' or @text ='AMBIENT CLEARANCE BAY CHECK']"));
		xpathAmbientClearanceBayText.isDisplayed();

	}

	public void clickOnAlertDropdown() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathAlertDropdown = driveR
				.findElement(By.xpath("//android.widget.Spinner[@resource-id='" + env + ":id/markdown_spinner']"));
		xpathAlertDropdown.isDisplayed();

		xpathAlertDropdown.click();
	}

	public void clickOnAllAlertDropdown() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathAllAlertDropdownDropdown = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id ='android:id/text1' and @index='0']"));
		xpathAllAlertDropdownDropdown.isDisplayed();

		xpathAllAlertDropdownDropdown.click();
		Thread.sleep(2000);
	}

	public void clickOnFirstAlertDropdown() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathFirstAlertDropdown = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @index='1']"));
		xpathFirstAlertDropdown.isDisplayed();

		xpathFirstAlertDropdown.click();
	}

	public void clickOnClearanceAlertDropdown() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathClearanceDropdown = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @index='2']"));
		xpathClearanceDropdown.isDisplayed();

		xpathClearanceDropdown.click();
	}

	public void verifyClearanceAlertSorting() throws Throwable {

		Thread.sleep(2000);

		List<Date> dateList = new ArrayList<Date>();

		Thread.sleep(5000);
		List<WebElement> allProducts = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_expiry']"));

		for (WebElement product : allProducts) {
			String str = product.getText().split(": ")[1];
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(str);

			dateList.add(date1);
		}

		for (int i = 0; i <= dateList.size() - 1; i++) {
			try {
				if (dateList.get(i).before(dateList.get(i + 1)) || dateList.get(i).equals(dateList.get(i + 1))) {
					System.out.println(dateList.get(i));
					System.out.println(dateList.get(i + 1));
					System.out.println("Date1 is before Date2");
				}
			} catch (IndexOutOfBoundsException e) {
				Thread.sleep(3000);
			}
		}
	}

	public void verifyFirstAlertSorting() throws Throwable {

		Thread.sleep(2000);

		// Xpath for date
		List<WebElement> xpathAllAlertsDate = driveR.findElements(
				By.xpath("//android.widget.TextView[@text ='Clearance Alerts' or @text ='CLEARANCE ALERTS']"));

		List<Date> allDates = new ArrayList<Date>();

		for (WebElement date : xpathAllAlertsDate) {

			Date alertDate = new SimpleDateFormat("dd/MM/yyyy").parse(date.getText());

			allDates.add(alertDate);
		}

		for (int i = 0; i <= allDates.size() - 1; i++) {

			Date date1 = allDates.get(i);
			Date date2 = allDates.get(i + 1);

			boolean isVerify;

			if (date1.compareTo(date2) == 0) {
				isVerify = true;
			} else {
				isVerify = false;
			}

			assertEquals(isVerify, true, "First alert is not on the top list");
		}

	}

	public void verifyDepartmentInforNotDisplayed() throws Throwable {

		Thread.sleep(2000);

		boolean isVerify;
		// Xpath - department

		try {
			WebElement xpathDepartment = driveR
					.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_name']"));
			xpathDepartment.isDisplayed();
			isVerify = false;

		} catch (Exception e) {
			isVerify = true;
		}

		assertEquals(isVerify, true, "Department information is displayed");
	}

	public void clickOnMainMenuFromHotkeys() throws Throwable {
		WebElement xpathMainMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='Main Menu' or @text='MAIN MENU']"));
		xpathMainMenu.isDisplayed();

		xpathMainMenu.click();
	}

	public void reopenTheDept() throws Throwable {
		List<WebElement> xpathAllDepts = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_title']"));
		List<String> deptNames = new ArrayList<String>();
		for (WebElement dept : xpathAllDepts) {
			deptNames.add(dept.getText());
			Thread.sleep(3000);
		}

		for (String name : deptNames) {
			driveR.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();

			try {
				WebElement reopenCodeRotateGroup = driveR
						.findElement(By.xpath("//android.widget.Button[@text='RE-OPEN CODE ROTATE GROUP']"));
				reopenCodeRotateGroup.click();
				Thread.sleep(3000);
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

			} catch (Exception e) {
				Thread.sleep(3000);
			}

			Thread.sleep(3000);
			WebElement xpathBackButton = driveR.findElement(By.className("android.widget.ImageButton"));
			xpathBackButton.isDisplayed();
			xpathBackButton.click();
			System.out.println("Click on back button");
		}
	}

	public void reopenTheDepartment(String deptName) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.TextView[@text='" + deptName + "']")).click();

		try {
			WebElement reopenCodeRotateGroup = driveR
					.findElement(By.xpath("//android.widget.Button[@text='RE-OPEN CODE ROTATE GROUP']"));
			Thread.sleep(3000);
			reopenCodeRotateGroup.click();

			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		} catch (Exception e) {
		}
		Thread.sleep(3000);
	}

	public void verifyStatusAsNotStarted() throws Throwable {
		WebElement xpathMainMenu = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='Main Menu' or @text='MAIN MENU']"));
		xpathMainMenu.isDisplayed();

		xpathMainMenu.click();
	}

	public void verifyReasonCode1() throws Throwable {
		WebElement xpathWasteOutOfDate = driveR.findElement(By.xpath(
				"//android.widget.CheckedTextView[@text='Waste Out of Date']"));
		xpathWasteOutOfDate.isDisplayed();
	}

	public void verifyReasonCode2() throws Throwable {
		WebElement xpathWasteOutOfDate = driveR.findElement(By.xpath(
				"//android.widget.CheckedTextView[@text='Waste Out of Date']"));
		xpathWasteOutOfDate.isDisplayed();
		
		WebElement xpathWasteDamaged = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@text='Waste Damaged/Fruit & Veg Quality or Condition']"));
		xpathWasteDamaged.isDisplayed();

		WebElement xpathCharityDamaged = driveR.findElement(
				By.xpath("//android.widget.CheckedTextView[@text='Waste Charity']"));
		xpathCharityDamaged.isDisplayed();
	}

	public void verifyMainMenuScreen() throws Throwable {
		boolean mainMenu = driveR
				.findElement(By
						.xpath("//android.widget.TextView[@text='Select one of the options below' or @text='SELECT ONE OF THE OPTIONS BELOW']"))
				.isDisplayed();

		assertEquals(mainMenu, true, "Main menu screen is not displayed");
	}

	public void navigateToRequestLabel() throws Throwable {
		boolean requestLabelScreen = driveR
				.findElement(By.xpath("//android.widget.TextView[@text='Request label' or @text='REQUEST LABEL']"))
				.isDisplayed();

		assertEquals(requestLabelScreen, true, "Request label screen is not displayed");

	}

	public void clickOnShelfEdge() throws Throwable {

		WebElement xpathShelfEdgeMenu = driveR.findElement(By.xpath(
				"//android.widget.TextView[@text='Shelf Edge Label to Stack' or @text='SHELF EDGE LABEL TO STACK']"));
		xpathShelfEdgeMenu.isDisplayed();
		xpathShelfEdgeMenu.click();
	}

	public void verifyEdgeshelfIsRemoved() throws Throwable {
		boolean isMenuRemoved = true;

		try {
			isMenuRemoved = driveR
					.findElement(By
							.xpath("//android.widget.TextView[contains(@text='Target Replenishment' or @text='TARGET REPLENISHMENT')]"))
					.isDisplayed();
			assertEquals(isMenuRemoved, false, "Target Replenishment screen is displayed");
		} catch (Exception e) {
			assertEquals(isMenuRemoved, true, "Target Replenishment screen is not displayed");
		}

		try {
			isMenuRemoved = driveR
					.findElement(By
							.xpath("//android.widget.TextView[contains(@text='Shelf Edge Label to Stack' or @text='SHELF EDGE LABEL TO STACK')]"))
					.isDisplayed();
			assertEquals(isMenuRemoved, false, "Shelf Edge Label to Stack screen is displayed");
		} catch (Exception e) {
			assertEquals(isMenuRemoved, true, "Shelf Edge Label to Stack screen is not displayed");
		}
	}

	public void verifyAlertIsCreated(String productMin) throws Throwable {

		int i = 0;
		boolean isProductPresent = false;

		while (i < 2) {
			List<WebElement> xpathAllMins = driveR
					.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_min']"));
			System.out.println("DepartmentsList size : " + xpathAllMins.size());
			try {
				for (WebElement xpathMin : xpathAllMins) {
					String minText = xpathMin.getText();

					if (allMins.contains(minText)) {
						System.out.println("Product Min : " + minText);
						allMins.add(minText);
					}
				}
				i++;

				Thread.sleep(2000);
				TouchAction ts = new TouchAction(driveR);
				ts.press(PointOption.point(350, 1515)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(300, 390)).release().perform();
			}

			catch (Exception e) {
			}
		}

		if (allMins.contains(productMin)) {
			isProductPresent = true;
		}

		assertEquals(isProductPresent, true, "Alert is not created");
	}

	public void deleteAlert() throws InterruptedException {
		TouchAction ts = new TouchAction(driveR);
		ts.press(PointOption.point(520, 237)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(32, 269)).release().perform();
		Thread.sleep(3000);

		try {
			driveR.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + env + ":id/delete_button']"));
		} catch (Exception e) {
			System.out.println("Alert is not deleted");
		}
	}

	public void clickOnLogProductButton() throws Throwable {

		Thread.sleep(2000);
		WebElement xpathNextActionbutton = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/nextActionButton']"));

		xpathNextActionbutton.isDisplayed();
		xpathNextActionbutton.click();
		Thread.sleep(2000);
	}

	public void itemExistsOrNot(String min) throws Throwable {

		Thread.sleep(2000);
		List<WebElement> xpathAllMins = driveR
				.findElements(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/product_min']"));
		System.out.println("DepartmentsList size : " + xpathAllMins.size());

		for (WebElement item : xpathAllMins) {
			String listedProduct = item.getText();
			if (listedProduct.contains(min)) {
				System.out.println("Item present");
			} else {
				System.out.println("Item deleted");
			}

		}

		Thread.sleep(2000);
	}

	public void verifyCodeAlertDepartmentBanner(String deptStatus) throws Throwable {

		Thread.sleep(2000);
		WebElement xpathDeptStatus = driveR
				.findElement(By.xpath("//android.widget.TextView[@resource-id='" + env + ":id/department_status' and @index='1']"));
		
String deptStatusName = xpathDeptStatus.getText();
System.out.println("text: "+deptStatusName);
if(deptStatusName.contains(deptStatus)){
	System.out.println("Code Alert is in completed state");
}else{
	System.out.println("Code Alert is not yet completed");
}

		
		Thread.sleep(2000);
	}	
	
	public void verifyActionOnSpinner(String action) throws Throwable {

		driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + action + "']")).isDisplayed();
	}
	
	public void verifyActionNotDisplayed(String action) throws Throwable {
boolean isActionNotPresent = true;
		try{
			isActionNotPresent = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + action + "']")).isDisplayed();
		}
		catch(Exception e){
			isActionNotPresent = false;
		}
		assertEquals(isActionNotPresent, false, action + " is Present on Spinner");
	}

	public void verifyDefaultAction(String wastageCode) throws Throwable {
		WebElement xpathReasonCode = driveR.findElement(By.xpath("//android.widget.TextView[@text='"+wastageCode+"']"));
		xpathReasonCode.isDisplayed();
	}
	
	public void verifyWastageReasonCode(String wastageCode) throws Throwable {
		WebElement xpathReasonCode = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+wastageCode+"']"));
		xpathReasonCode.isDisplayed();
	}
	
	public void wastageReasonCodeNotDisplay(String wastageCode) throws Throwable {
		boolean isDisplayed = true;
		try{
		WebElement xpathReasonCode = driveR.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+wastageCode+"']"));
		isDisplayed = xpathReasonCode.isDisplayed();
		}
		catch(Exception e){
			isDisplayed = false;
		}
		assertEquals(isDisplayed, false,"Rotate to front is displayed");
	}
	
}
