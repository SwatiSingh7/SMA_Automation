package com.morrisons.sma.page_objects.mobile.old;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.morrisons.common.action.Hook;
import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class AdminPanelWebAppPO {


	private static WebDriver driveR;

	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();

	String url = applicationConfig.getFccadminCredentials().getUrl();
	String username = applicationConfig.getFccadminCredentials().getUsername();
	String password = applicationConfig.getFccadminCredentials().getPassword();

	static String deptName = null;
	static String className = null;
	static String classDeptName = null;

	List<Integer> storeIds = new ArrayList<Integer>();	

	public AdminPanelWebAppPO() {
		this.driveR = Hook.getDriver();
	}

	public void enterURl() {
		driveR.get(url);
		driveR.manage().deleteAllCookies();
	}
	public void enterWebpageLoginCredentials() throws Throwable {
		String parentWindow = driveR.getWindowHandle();
		driveR.findElement(By.cssSelector("#root > main > form > div > button > span.MuiButton-label")).isDisplayed();
		driveR.findElement(By.cssSelector("#root > main > form > div > button > span.MuiButton-label")).click();

		Set<String> windows = driveR.getWindowHandles();
		System.out.println("windows:" + windows);
		Iterator<String> I1 = windows.iterator();
		while (I1.hasNext()) {
			String childwindow = I1.next();
			driveR.switchTo().window(childwindow);
			if (!parentWindow.equals(childwindow)) {
				driveR.switchTo().window(childwindow);
				System.out.println(driveR.switchTo().window(childwindow).getTitle());
				driveR.manage().window().maximize();
				driveR.findElement(By.id("identifierId")).isDisplayed();
				driveR.findElement(By.id("identifierId")).sendKeys(username);

				driveR.findElement(By.cssSelector("#identifierNext > div > button > span")).isDisplayed();
				driveR.findElement(By.cssSelector("#identifierNext > div > button > span")).click();

				driveR.findElement(By.name("password")).isDisplayed();
				driveR.findElement(By.name("password")).sendKeys(password);

				driveR.findElement(By.cssSelector("#passwordNext > div > button > span")).isDisplayed();
				driveR.findElement(By.cssSelector("#passwordNext > div > button > span")).click();
				Thread.sleep(20000);
				driveR.switchTo().window(parentWindow);

			}

		}
	}

	public void verifywebpage()
	{		
		driveR.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		boolean cURL= driveR.getCurrentUrl().contains("checkschedule");
		System.out.println("url::: "+cURL);
		Assert.assertEquals(true, cURL, "Incorrect webpage URL");
		driveR.findElement(By.xpath("//*[contains(text(),'Fresh Code Check')]")).isDisplayed();
	}

	public void verifyAdminMenu() throws InterruptedException {
		driveR.findElement(By.xpath("//span[contains(text(),'Admin')]")).isDisplayed();
	}

	public void clickOnAdminMenu() throws InterruptedException {
		driveR.findElement(By.xpath("//span[contains(text(),'Admin')]")).click();
	}

	public void verifyAdminPageDisplayed() throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'Admin')]")).isDisplayed();
	}

	public void enterUserDetail() throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'Admin')]")).isDisplayed();
		driveR.findElement(By.xpath("//*[contains(text(),'Please enter an email address and select a role to continue.')]")).isDisplayed();
		driveR.findElement(By.xpath("//*[contains(text(),'User Details')]")).isDisplayed();
		driveR.findElement(By.xpath("//input[@name = 'email']")).isDisplayed();
		driveR.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),' Next ')]")).isDisplayed();
	}

	public void enterUsername(String username) throws InterruptedException {
		driveR.findElement(By.xpath("//input[@name = 'email']")).isDisplayed();
		driveR.findElement(By.xpath("//input[@name = 'email']")).sendKeys(username);
	}

	public void clickOnNextButton() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='NEXT' or text()='Next' or text()=' Next ']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='NEXT' or text()='Next' or text()=' Next ']")).click();
	}

	public void verifyAccesCheckboxes() throws InterruptedException {

		List<WebElement> xpathAccessCheckboxes = driveR.findElements(By.xpath("//div[starts-with(@id,'transfer-list-all-item')]/span"));

		for(WebElement accessCheckbox : xpathAccessCheckboxes){
			accessCheckbox.isDisplayed();
			String name = accessCheckbox.getText();
			System.out.println("Checkbox name : " + name);
		}
	}

	public void scrollDownToPage() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driveR).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void verifyGrantAccessButton() throws InterruptedException {

		driveR.findElement(By.xpath("//*[contains(text(),'Grant Access')]")).isDisplayed();
	}

	public void clickOnGrantAccessBtn() throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'Grant Access')]")).click();
	}

	public void verifyConfirmationPopup(String alertName) throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'"+alertName+"')]")).isDisplayed();
	}

	public void verifyGrantAccessAlert(String alertMessage) throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'"+alertMessage+"')]")).isDisplayed();
		driveR.findElement(By.xpath("//*[contains(text(),'SAVE')]")).isDisplayed();
		driveR.findElement(By.xpath("//*[contains(text(),'Cancel')]")).isDisplayed();
	}

	public void verifyScheduleSummary() throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'Schedule Summary')]")).isDisplayed();
	}

	public void clickOnScheduleSummary() throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'Schedule Summary')]")).click();
	}

	public void verifyScheduleSummaryPage() throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(text(),'Schedule Summary')]")).isDisplayed();
	}

	public void verifyCheckSchedulePage() throws InterruptedException {
		driveR.switchTo().defaultContent();

		driveR.findElement(By.xpath("//*[text()='Select Store']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Select Store Group']")).isDisplayed();

		driveR.findElement(By.xpath("//div[1]/div/div[2]//button[@class='MuiButtonBase-root']")).isDisplayed();
		driveR.findElement(By.xpath("//div[2]/div/div/div[2]//button[@class='MuiButtonBase-root']")).isDisplayed();
	}

	public void clickOnSelectStoreDropdown() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Select Store']")).isDisplayed();
		driveR.findElement(By.xpath("//div[1]/div/div[2]//button[@class='MuiButtonBase-root']")).isDisplayed();
		driveR.findElement(By.xpath("//div[1]/div/div[2]//button[@class='MuiButtonBase-root']")).click();
	}

	public void selectDropdownOnAlert() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Select Store']")).isDisplayed();
		driveR.findElement(By.xpath("//button[@class='MuiButtonBase-root'][2]")).isDisplayed();
		driveR.findElement(By.xpath("//button[@class='MuiButtonBase-root'][2]")).click();
	}

	public void verifyStoreListCheckbox() throws InterruptedException {
		List<WebElement> xpathListCheckboxes = driveR.findElements(By.xpath("//*[@id='simple-menu']//li//span[2]"));
		System.out.println("Store List checkbox size : " + xpathListCheckboxes.size());
		for(WebElement storeCheckbox : xpathListCheckboxes){
			storeCheckbox.isDisplayed();
			String storecheckboxText = storeCheckbox.getText();
		}
	}

	public void selectStoreCheckbox(String storeName) throws InterruptedException {
		List<WebElement> xpathListCheckboxes = driveR.findElements(By.xpath("//*[@id='simple-menu']//li//span[2]"));
		List<String> storeCheckboxList = new ArrayList<String>();

		for(WebElement storeCheckbox : xpathListCheckboxes){
			storeCheckbox.isDisplayed();
			String storecheckboxText = storeCheckbox.getText();

			storeCheckboxList.add(storecheckboxText);

			if(storeCheckboxList.contains(storeName)){
				storeCheckbox.click();

				Actions action = new Actions(driveR);
				action.sendKeys(Keys.ESCAPE).build().perform();

				break;

			}
		}
	}

	public void selectGroupCheckbox(String groupName) throws InterruptedException {
		List<WebElement> xpathListCheckboxes = driveR.findElements(By.xpath("//*[@id='simple-menu']//li//span[2]"));
		List<String> groupCheckboxList = new ArrayList<String>();

		for(WebElement groupCheckbox : xpathListCheckboxes){
			groupCheckbox.isDisplayed();
			String groupCheckboxText = groupCheckbox.getText();

			groupCheckboxList.add(groupCheckboxText);

			if(groupCheckboxList.contains(groupName)){
				groupCheckbox.click();

				Actions action = new Actions(driveR);
				action.sendKeys(Keys.ESCAPE).build().perform();

				break;

			}
		}
	}

	public void verifyCurrentAndNextWeek() throws InterruptedException {
		List<WebElement> xpathWeekTabs = driveR.findElements(By.xpath("//span[contains(text(),'Week')]"));
		int size = xpathWeekTabs.size();

		assertEquals(size,2,"Current and Next week tabs are not displayed");

		for(WebElement xpathWeek : xpathWeekTabs){
			String name = xpathWeek.getText();
			System.out.println("Week name : " + name);
		}
	}

	public void clickOnCurrentWeekTab() throws InterruptedException {
		List<WebElement> xpathWeekTabs = driveR.findElements(By.xpath("//span[contains(text(),'Week')]"));
		String name = xpathWeekTabs.get(0).getText();
		System.out.println("Week name : " + name);

		xpathWeekTabs.get(0).click();
	}


	public void verifyDeptListForWeek() throws InterruptedException {
		Thread.sleep(3000);
		boolean sss = driveR.findElement(By.xpath("//table[@class='MuiTable-root']//tr/th/div")).isDisplayed();
		System.out.println("sss : " + sss);

		List<WebElement> xpathDeptList = driveR.findElements(By.xpath("//table[@class='MuiTable-root']//tr/th/div"));
		boolean isDeptPresent = false;
		for(WebElement xpathDept : xpathDeptList){
			xpathDept.isDisplayed();
			String deptName = xpathDept.getText();
			System.out.println("Dept name : " + deptName);
		}	
		int deptsize = xpathDeptList.size();

		if(deptsize>=1){
			isDeptPresent = true;
		}
		assertEquals(isDeptPresent, true,"Dept list not present");
	}

	public void clickOnNextWeekTab() throws InterruptedException {
		List<WebElement> xpathWeekTabs = driveR.findElements(By.xpath("//span[contains(text(),'Week')]"));
		String name = xpathWeekTabs.get(1).getText();
		System.out.println("Week name : " + name);

		xpathWeekTabs.get(1).click();
	}

	public void verifyDeptLevelSchedule() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Daily Check']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Afternoon Check']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='FM Check']")).isDisplayed();
	}

	public void verifyScheduleDateFormat() throws InterruptedException {
		driveR.findElement(By.xpath("//div/table[@class='MuiTable-root']//tr/td[1]/div[1]")).isDisplayed();
	}

	public void clickOnDept() throws InterruptedException {
		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr//td[4]/button")).isDisplayed();
		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr//td[4]/button")).click();
	}

	public void clickOnSearchDept() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='"+deptName+"']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='"+deptName+"']")).click();
	}

	public void verifyChecks() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Daily Check:']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='DD/MM/YYYY']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Afternoon Check:']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Fresh Manager Check:']")).isDisplayed();
	}

	public void clickOnSearchDeptClass() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//nav[@aria-labelledby='class-list']/div[1]//span")).isDisplayed();
		driveR.findElement(By.xpath("//nav[@aria-labelledby='class-list']/div[1]//span")).click();
	}

	public void clickOnSearchDeptSubClass() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//nav[@aria-labelledby='class-list']/div[2]//div[4]/div/span")).isDisplayed();
		driveR.findElement(By.xpath("//nav[@aria-labelledby='class-list']/div[2]//div[4]/div/span")).click();
	}


	public void clickOnClassUnderDept() throws InterruptedException {
		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr//td[4]/button")).isDisplayed();
		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr//td[4]/button")).click();

		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr[1]//td[4]/button")).isDisplayed();
		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr[1]//td[4]/button")).click();
	}

	//		
	public void getDeptName() throws InterruptedException {
		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//th")).isDisplayed();
		deptName = driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//th")).getText();

		System.out.println("Department name : " + deptName);
	}

	public void verifySearchIconDisplayed() throws InterruptedException {
		driveR.findElement(By.xpath("//span[text()='Search']")).isDisplayed();
	}

	public void clickOnSearchIcon() throws InterruptedException {
		driveR.findElement(By.xpath("//span[text()='Search']")).click();
	}

	public void verifySearchDept() throws InterruptedException {
		driveR.findElement(By.xpath("//input[@id='input-with-icon-textfield']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Schedule Summary']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Please search for a department, class, subclass of MIN to edit its check schedule']")).isDisplayed();
	}

	public void enterAndSearchDept() throws InterruptedException {
		driveR.findElement(By.xpath("//input[@id='input-with-icon-textfield']")).isDisplayed();
		driveR.findElement(By.xpath("//input[@id='input-with-icon-textfield']")).sendKeys(deptName);

		Actions builder = new Actions(driveR);        
		builder.sendKeys(Keys.ENTER).perform();
	}

	public void enterAndSearchDept(String deptName) throws InterruptedException {
		driveR.findElement(By.xpath("//input[@id='input-with-icon-textfield']")).isDisplayed();
		driveR.findElement(By.xpath("//input[@id='input-with-icon-textfield']")).sendKeys(deptName);

		Actions builder = new Actions(driveR);        
		builder.sendKeys(Keys.ENTER).perform();
	}
	
	public void verifyDeptOnSearchResult(String deptName) throws InterruptedException {

		driveR.findElement(By.xpath("//*[text()='"+deptName+"']")).isDisplayed();
	}


	public void verifyDeptOnSearchResult() throws InterruptedException {

		driveR.findElement(By.xpath("//*[text()='"+deptName+"']")).isDisplayed();
	}

	public void verifyClassOnSearchResult() throws InterruptedException {
		classDeptName = deptName + " - " + className;
		driveR.findElement(By.xpath("//*[text()='"+classDeptName+"']")).isDisplayed();
	}

	public void clickOnClassDept() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='"+classDeptName+"']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='"+classDeptName+"']")).click();
	}

	public void clickOnSubClass() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//nav[@aria-labelledby='class-list']/div[1]/div/span")).isDisplayed();
		driveR.findElement(By.xpath("//nav[@aria-labelledby='class-list']/div[1]/div/span")).click();
	}

	public void verifyBackOption() throws InterruptedException {
		driveR.findElement(By.xpath("//span[text()=' Back ' or text()='Back']")).isDisplayed();
	}


	public void clickOnBackToSearch() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()=' Back ' or text()='Back']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()=' Back ' or text()='Back']")).click();
	}

	public void verifyPageNavigatesToSearch() throws InterruptedException {
		driveR.findElement(By.xpath("//span[text()='"+deptName+"']")).isDisplayed();
		driveR.findElement(By.xpath("//span[text()='Results that match your search ']")).isDisplayed();
	}

	public void getClassNameForSelectedStore() throws InterruptedException {
		driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr[2]//th")).isDisplayed();
		className = driveR.findElement(By.xpath("//*[@class='MuiTableBody-root']//tr[2]//th")).getText();

		System.out.println("Class name : " + className);
	}

	public void enterAndSearchClassName() throws InterruptedException {
		driveR.findElement(By.xpath("//input[@id='input-with-icon-textfield']")).isDisplayed();
		driveR.findElement(By.xpath("//input[@id='input-with-icon-textfield']")).sendKeys(className);

		Actions builder = new Actions(driveR);        
		builder.sendKeys(Keys.ENTER).perform();
	}

	public void verifyExportScheduleLink() throws InterruptedException {
		driveR.findElement(By.xpath("//button/span[text()='Export Schedule']")).isDisplayed();
	}

	public void clickOnExportScheduleLink() throws InterruptedException {
		driveR.findElement(By.xpath("//button/span[text()='Export Schedule']")).click();
	}

	public void verifyExportScheduleAlert(String alertMessage) throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Export Schedule Information']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='"+alertMessage+"']")).isDisplayed();
	}

	public void verifyCancelAndExportBtn() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Cancel' or text()='CANCEL']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Export' or text()='EXPORT']")).isDisplayed();
	}

	public void clickOnExportBtn() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Export' or text()='EXPORT']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Export' or text()='EXPORT']")).click();
	}

	//		public void verifyCSVFile() throws InterruptedException {
	//			driveR.findElement(By.xpath("//span[@text='Search')]")).isDisplayed();
	//		}

	public void verifyManagerSignOffMenu() throws InterruptedException {
		driveR.findElement(By.xpath("//span[text()='Manager Sign Off']")).isDisplayed();
	}

	public void clickOnManagerSignOff() throws InterruptedException {
		driveR.findElement(By.xpath("//span[text()='Manager Sign Off']")).isDisplayed();
		driveR.findElement(By.xpath("//span[text()='Manager Sign Off']")).click();
	}

	public void verifyManagerSignOffPage() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Manager Sign Off']")).isDisplayed();
	}

	public void verifyManagerSignOffDetails() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Manager Sign Off']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Please select store or store group to continue']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Select Store']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Select Store Group']")).isDisplayed();
	}

	public void verifyDaysWithCheckboxes() throws InterruptedException {
		List<WebElement> xpathDaysCheckboxes = driveR.findElements(By.xpath("//input[@type='checkbox']"));

		int size = xpathDaysCheckboxes.size();
		assertEquals(size, 7,"Day checkboxes are not present");

	}

	public void clickOnSelectGroupDropdown() throws InterruptedException {
		driveR.findElement(By.xpath("//*[text()='Select Store Group']")).isDisplayed();
		driveR.findElement(By.xpath("//div[2]/div/div/div[2]/button[@class='MuiButtonBase-root']")).isDisplayed();
		driveR.findElement(By.xpath("//div[2]/div/div/div[2]/button[@class='MuiButtonBase-root']")).click();
	}

	public void verifyAppendAndDeleteIcon() throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//*[contains(@class,'MuiSvgIcon-colorPrimary')]")).isDisplayed();
		driveR.findElement(By.xpath("//*[contains(@class,'MuiChip-deleteIcon')]")).isDisplayed();
	}

	public void clickOnAppendIcon() throws InterruptedException {
		driveR.findElement(By.xpath("//*[contains(@class,'MuiSvgIcon-colorPrimary')]")).isDisplayed();
		driveR.findElement(By.xpath("//*[contains(@class,'MuiSvgIcon-colorPrimary')]")).click();
	}

	public void clickOnDeleteIcon() throws InterruptedException {
		Thread.sleep(2000);
		driveR.findElement(By.xpath("//*[contains(@class,'MuiChip-deleteIcon')]")).isDisplayed();
		driveR.findElement(By.xpath("//*[contains(@class,'MuiChip-deleteIcon')]")).click();
	}

	public void clickOnSignOffDays() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//*[@id='mngSoff']/div/div/div/div[2]/div/div/div/li[2]/div[2]/span/span/input")).isDisplayed();
		driveR.findElement(By.xpath("//*[@id='mngSoff']/div/div/div/div[2]/div/div/div/li[2]/div[2]/span/span/input")).click();
	}


	public void verifySelectedCheckboxes() throws InterruptedException {
		driveR.findElement(By.xpath("//svg[@class='MuiSvgIcon-root MuiChip-deleteIcon']")).isDisplayed();
		driveR.findElement(By.xpath("//svg[@class='MuiSvgIcon-root MuiChip-deleteIcon']")).click();
	}


	public void verifySaveDiscardBtn() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//*[text()='Save']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Discard']")).isDisplayed();
	}


	public void verifyCancelAndSaveBtn() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//*[text()='Save']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Cancel']")).isDisplayed();
	}

	public void clickOnDiscardBtn() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//*[text()='Discard']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Discard']")).click();
	}

	public void clickOnSaveBtn() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//*[text()='Save' or text()='SAVE']")).isDisplayed();
		driveR.findElement(By.xpath("//*[text()='Save' or text()='SAVE']")).click();
	}

	public void clickOnSaveBtnOnAlert() throws InterruptedException {
		Thread.sleep(3000);
		driveR.findElement(By.xpath("//button[contains(@class,'MuiButton-textPrimary')][2]/span[1]")).isDisplayed();
		driveR.findElement(By.xpath("//button[contains(@class,'MuiButton-textPrimary')][2]/span[1]")).click();
	}

	public void verifyAlertDisplay(String alertName) throws InterruptedException {
		Thread.sleep(2000);
		boolean alertTitle = driveR.findElement(By.xpath("//*[text()='"+alertName+"']")).isDisplayed();
		assertEquals(alertTitle,true,"Discard title is not present");
	}


	public void verifyAlertMessage(String alertMessage) throws InterruptedException {
		Thread.sleep(2000);
		boolean alertMsg = driveR.findElement(By.xpath("//*[text()='"+alertMessage+" ']")).isDisplayed();
		assertEquals(alertMsg,true,"Discard title message is not present");

	}

	public void verifyAlertMsg(String alertMessage) throws InterruptedException {
		Thread.sleep(2000);
		boolean alertMsg = driveR.findElement(By.xpath("//*[text()=' "+alertMessage+"']")).isDisplayed();
		assertEquals(alertMsg,true,"Discard title message is not present");

	}

	public void groupDayDisplayed(String name) throws InterruptedException {
		driveR.findElement(By.xpath("//h2[text()='"+name+"']")).isDisplayed();
	}

	public void verifyGroupsAreRemoved(String name) throws InterruptedException {
		try{
			driveR.findElement(By.xpath("//h2[text()='"+name+"']")).isDisplayed();
		}
		catch(Exception e){

		}
	}

	public void getAllStoreInList() throws InterruptedException {
		List<WebElement> xpathListCheckboxes = driveR.findElements(By.xpath("//*[@id='simple-menu']//li//span[2]"));
		System.out.println("Store List checkbox size : " + xpathListCheckboxes.size());
		for(WebElement storeCheckbox : xpathListCheckboxes){
			storeCheckbox.isDisplayed();
			String storecheckboxText = storeCheckbox.getText();
			storecheckboxText = storecheckboxText.split("-")[0].trim();
			
			if(!storecheckboxText.equals("All")){
			int storeId = Integer.parseInt(storecheckboxText);
			
				storeIds.add(storeId);
			}
		}
	}

	public void verifyAscendingOrder() throws InterruptedException {
		boolean isAscedingOrder = false;

		System.out.println("Store List size : " + storeIds.size());

		for(int i = 0;i<=storeIds.size()-1;i++){
			try{
			if(storeIds.get(i)< storeIds.get(i+1)){
				isAscedingOrder = true;
			}
			}
			catch(Exception e){}

			assertEquals(isAscedingOrder , true, "Store list is not in Ascending order");
		}
	}
	
	//Shrutika
	
	//Shrutika
	
		public void clickStore()
		{
			driveR.findElement(By.xpath("//span[text()='Stores']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='Stores']")).click();

		}

		public void viewStoreGrouplist() {
			clickStore();
			boolean isdispalyed = driveR.findElement(By.xpath("//span[text()='Store Groups']")).isDisplayed();
			Assert.assertEquals(true, isdispalyed);
		}
		boolean dispalyed;

		public void VerifyStorepagelistofstoregroup() {
			dispalyed = driveR.findElement(By.xpath("//*[text()='All Store Groups']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);	
			dispalyed = driveR.findElement(By.xpath("//*[text()='Edit']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);
			dispalyed = driveR.findElement(By.xpath("//*[@id='editStoreGroup']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);
			dispalyed = driveR.findElement(By.xpath("//*[text()='Delete']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);
			dispalyed = driveR.findElement(By.xpath("//*[@id='deleteStoreGroup']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);
		}

		public void ClickNewGroup() {
			clickStore();
			driveR.findElement(By.xpath("//*[text()='New group']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='New group']")).click();
			
		}

		public void CreateNewgroup() throws InterruptedException {
			driveR.findElement(By.id("storeGroupName")).isDisplayed();
			//Group Name:: Test Automation
			driveR.findElement(By.id("storeGroupName")).sendKeys("Test Automation");
			driveR.findElement(By.xpath("//button[@class='MuiButtonBase-root']")).click();  //dropdown
			//Added group 78
			driveR.findElement(By.xpath("//span[text()='78 - London2']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ESCAPE);
			driveR.findElement(By.xpath("//*[@id='submitStoreGroup']")).isDisplayed();
			driveR.findElement(By.xpath("//button[@id='submitStoreGroup']")).click();
			Thread.sleep(2000);
			dispalyed = driveR.findElement(By.xpath("//*[text()='Test Automation']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);

		}

		public void ClickEditiconOfnewStoreGroup() throws InterruptedException {
			clickStore();
			Thread.sleep(2000);
			dispalyed = driveR.findElement(By.xpath("//*[text()='Test Automation']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);
			driveR.findElement(By.xpath("//*[@id='storeGroupDetail'and text()='Test Automation']//following::td[2]//button")).click();			//Edit Button
			driveR.findElement(By.xpath("//button[@class='MuiButtonBase-root'][2]")).click();
			Thread.sleep(2000);
			//Added All groups
			driveR.findElement(By.xpath("//span[text()='All']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ESCAPE);
			driveR.findElement(By.xpath("//button[@id='submitStoreGroup']")).click();
			Thread.sleep(2000);
			dispalyed = driveR.findElement(By.xpath("//*[text()='Test Automation']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);

		}

		public void verifySuccessmessage() {
			dispalyed = driveR.findElement(By.xpath("//*[text()='Store group updated successfully...']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);

		}

		public void clickDeleticonofnewStoreGroup() throws InterruptedException {
			clickStore();
			//dispalyed = driveR.findElement(By.xpath("//*[text()='Test Automation']")).isDisplayed();
			//Assert.assertEquals(true, dispalyed);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);

			driveR.findElement(By.xpath("//button[@title='Next page']")).isDisplayed();

			driveR.findElement(By.xpath("//button[@title='Next page']")).click();
			driveR.findElement(By.xpath("//*[text()='Test Automation']")).isDisplayed();
			
			
			driveR.findElement(By.xpath("//*[@id='storeGroupDetail'and text()='Test Automation']//following::td[3]//button")).click();			//Delete Button
			Thread.sleep(2000);

			
		}


		public void verifypopupmsg(String alertMsg) throws InterruptedException {
			Thread.sleep(1000);
			boolean dispalyed1 = driveR.findElement(By.xpath("//*[text()='"+alertMsg+"']")).isDisplayed();
			Assert.assertEquals(true, dispalyed1);

		}
		
		public void deletestoregroup() {
			driveR.findElement(By.xpath("//*[text()='delete']")).click();
			dispalyed = driveR.findElement(By.xpath("//*[text()='Store group deleted successfully...']")).isDisplayed();
			Assert.assertEquals(true, dispalyed);

		}

		public void clicktogglestoregroup() {
			clickStore();
			driveR.findElement(By.xpath("//*[text()='All Store Groups']//following::input[1]")).isDisplayed();

		}

		public void enableAllStoregroup() throws InterruptedException {
			driveR.findElement(By.xpath("//*[text()='All Store Groups']//following::input[1]")).click();
			Thread.sleep(3000);
		}

		public void clickEnableNSave() throws InterruptedException {
			Thread.sleep(2000);		
			driveR.findElement(By.xpath("//span[text()='Enable']")).isDisplayed();

			driveR.findElement(By.xpath("//span[text()='Enable']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.findElement(By.xpath("//*[text()='SAVE']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='SAVE']")).click();

		}

		public void disableAllStoregroup() throws InterruptedException {
			driveR.findElement(By.xpath("//*[text()='All Store Groups']//following::input[1]")).click();
			Thread.sleep(3000);
		}

		public void clickDisableNSave() throws InterruptedException {
			Thread.sleep(2000);		
			driveR.findElement(By.xpath("//span[text()='Disable']")).isDisplayed();

			driveR.findElement(By.xpath("//span[text()='Disable']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.findElement(By.xpath("//*[text()='SAVE']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='SAVE']")).click();
		}

		public void clickStorelistTab() {
			clickStore();
			driveR.findElement(By.xpath("//span[text()='Store List']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='Store List']")).click();
		}

		public void listofStores() {
			dispalyed = driveR.findElement(By.id("storeList")).isDisplayed();
			Assert.assertEquals(true, dispalyed);
		}

		public void clickStoretoggle() throws InterruptedException {
			clickStorelistTab();
			driveR.findElement(By.xpath("//*[text()='All Stores']//following::input[1]")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='All Stores']//following::input[1]")).click();
			Thread.sleep(2000);		

		}

		public void enableStorelist() {
			driveR.findElement(By.xpath("//span[text()='Enable']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='Enable']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.findElement(By.xpath("//*[text()='SAVE']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='SAVE']")).click();
		}
		public void disableStorelist() {
			driveR.findElement(By.xpath("//span[text()='Disable']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='Disable']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.findElement(By.xpath("//*[text()='SAVE']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='SAVE']")).click();
		}

		public void clickSelectedStore(String storeID) {
			clickStorelistTab();
			driveR.findElement(By.xpath("//*[text()='"+storeID+"']//following::input[1]")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='"+storeID+"']//following::input[1]")).click();
		
		}

		public void clickExport() {
			clickStore();
			driveR.findElement(By.xpath("//span[text()='Export']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='Export']")).click();

		}

		public void clickexportlist() {
			driveR.findElement(By.xpath("//span[text()='EXPORT']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='EXPORT']")).click();		
		}

		public void clickCheckSchedules() {
			driveR.findElement(By.xpath("//span[text()='Check Schedule']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='Check Schedule']")).click();		
		}

		public void selectstoreinCheckSchedule(String storeID) throws InterruptedException{
			driveR.findElement(By.xpath("//*[text()='Select Store']//following::button[1]")).click();	//SelectStore dropdown
			driveR.findElement(By.xpath("//*[text()='"+storeID+"']//parent::li[1]")).isDisplayed();		//StoreCheckBox
			Thread.sleep(1000);
			driveR.findElement(By.xpath("//*[text()='"+storeID+"']//parent::li[1]")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ESCAPE);
			driveR.findElement(By.xpath("//span[text()='NEXT']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='NEXT']")).click();		

		}

		public void selectDepartment(String department) {
			driveR.findElement(By.xpath("//*[text()='"+department+"']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='"+department+"']//following::button[4]")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='"+department+"']//following::button[4]")).click();   		//ExpandButton

			//*[text()='001 Canned Vegetables']//following::button[4]		
		}

		public void ViewDailyAfternoonFMCheck() {
			driveR.findElement(By.xpath("//*[text()='Daily Checks' or 'Daily Check:']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='Afternoon Checks' or 'Afternoon Check:']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='FM Check' or 'Fresh Food Manager Check:']")).isDisplayed();
			
		}

		public void editDepartmentCheckDate(String department) throws InterruptedException {
			for (int i = 1; i<=3; i++) {
				driveR.findElement(By.xpath("//*[text()='" + department + "']//following::button["+i+"]")).click(); //CalenderDaliyCheck
				driveR.findElement(By.xpath("//*[text()='OK']")).isDisplayed();
				driveR.findElement(By.xpath("//*[text()='OK']")).click();
				driveR.findElement(
						By.xpath("//*[text()='" + department + "']//following::div[@id='demo-simple-select']["+i+"]"))
						.isDisplayed(); 																				//DailyDropdown
				driveR.findElement(
						By.xpath("//*[text()='" + department + "']//following::div[@id='demo-simple-select']["+i+"]"))
						.click();
				driveR.findElement(By.xpath("//li[text()='2 Days']")).isDisplayed();
				driveR.findElement(By.xpath("//li[text()='2 Days']")).click();
				driveR.switchTo().activeElement().sendKeys(Keys.ESCAPE);

			}
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);

			driveR.findElement(By.xpath("//*[text()='SAVE']")).isDisplayed();
			driveR.findElement(By.xpath("//*[text()='SAVE']")).click();
			Thread.sleep(1000);
			driveR.findElement(By.xpath("//span[text()='SAVE']")).click();


		}

		public void searchDepartment(String department) throws InterruptedException {
			driveR.findElement(By.xpath("//span[text()='Search']")).click();
			driveR.findElement(By.id("input-with-icon-textfield")).sendKeys(department);
			driveR.switchTo().activeElement().sendKeys(Keys.ENTER);
			driveR.findElement(By.xpath("//p[text()='"+department+"']")).isDisplayed();
			driveR.findElement(By.xpath("//p[text()='"+department+"']")).click();
			Thread.sleep(2000);
		}

		public void editdepartmentdatesinSearchpg() throws InterruptedException {
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.findElement(By.xpath("//button[@aria-label='change date'][1]")).isDisplayed();
			driveR.findElement(By.xpath("//button[@aria-label='change date'][1]")).click(); //calender
			driveR.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day MuiPickersDay-daySelected']//following::button[1]")).click(); //select next date
			driveR.findElement(By.xpath("//span[text()='OK']")).click();
			driveR.findElement(By.xpath("//*[text()='Daily Check:']//following::div[@id='demo-simple-select'][1]")).click();
			driveR.findElement(By.xpath("//li[text()='Daily']")).isDisplayed();
			driveR.findElement(By.xpath("//li[text()='Daily']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ESCAPE);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);		
//			driveR.findElement(By.xpath("//*[text()='Afternoon Check:']//following::div[@id='demo-simple-select'][2]")).isDisplayed();
//			driveR.findElement(By.xpath("//*[text()='Afternoon Check:']//following::div[@id='demo-simple-select'][2]")).click();
//			driveR.findElement(By.xpath("//li[text()='Daily']")).isDisplayed();
//			driveR.findElement(By.xpath("//li[text()='Daily']")).click();
//			driveR.switchTo().activeElement().sendKeys(Keys.ESCAPE);
//			driveR.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			driveR.findElement(By.xpath("//*[text()='Fresh Food Manager Check:']//following::div[@id='demo-simple-select'][3]")).click();
			driveR.findElement(By.xpath("//li[text()='7 Days']")).isDisplayed();
			driveR.findElement(By.xpath("//li[text()='7 Days']")).click();
			driveR.switchTo().activeElement().sendKeys(Keys.ESCAPE);

			driveR.findElement(By.xpath("//span[text()='SAVE']")).click();
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//span[text()='SAVE']")).click();

		
		}

		public void clickChangelog() throws InterruptedException {
			driveR.findElement(By.xpath("//span[text()='Change Log']")).isDisplayed();
			driveR.findElement(By.xpath("//span[text()='Change Log']")).click();
			Thread.sleep(1000);
		}

		public void viewLogs() {
			driveR.findElement(By.xpath("//h1[text()='Change Log']")).isDisplayed();
			driveR.findElement(By.className("MuiPaper-root MuiCard-root jss84 MuiPaper-outlined MuiPaper-rounded")).isDisplayed();
		}

		public void enterActivityNameinSearchbox(String text) throws InterruptedException {
			driveR.findElement(By.id("searchBy")).isDisplayed();
			driveR.findElement(By.id("searchBy")).click();
			driveR.findElement(By.id("searchBy")).sendKeys(text);
			driveR.switchTo().activeElement().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driveR.findElement(By.xpath("//h2[text()='"+text+"']")).isDisplayed();

		}

		public void selectdaterange() {
			driveR.findElement(By.xpath("//*[@id='searchBy']//following::button[1]")).click();
			driveR.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day MuiPickersDay-current MuiPickersDay-daySelected']//preceding::button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day']")).click();
			driveR.findElement(By.xpath("//*[@id='searchBy']//following::button[2]")).click();
			driveR.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day MuiPickersDay-current MuiPickersDay-daySelected']")).click();
		}
}

