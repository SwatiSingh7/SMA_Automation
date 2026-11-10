package com.morrisons.sma.page_objects.mobile.old;

import com.morrisons.sma.page_objects.mobile.CountsPO;
import org.openqa.selenium.*;
import io.appium.java_client.android.AndroidDriver;

import com.morrisons.common.action.Hook;

import com.morrisons.common.utility.ApplicationConfig;
import com.morrisons.common.utility.ConfigLoader;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPagePO {
private static AndroidDriver driveR;
public static String sUser;
	private static ApplicationConfig applicationConfig = new ConfigLoader().getConfig();
	String env = applicationConfig.getWebElementEnviroment().getEnv();
	static String env1 = applicationConfig.getWebElementEnviroment().getEnv();

	String collegueUsername = applicationConfig.getUserCredentials().getCollegueUsername();
	String colleguePassword = applicationConfig.getUserCredentials().getColleguePassword();
	String managerUsername = applicationConfig.getUserCredentials().getManagerUsername();
	String managerPassword = applicationConfig.getUserCredentials().getManagerPassword();
	String twilightManagerUsername = applicationConfig.getUserCredentials().getTwilightManagerUsername();
	String twilightManagerPassword = applicationConfig.getUserCredentials().getTwilightManagerPassword();


	public LoginPagePO() {
		this.driveR = (AndroidDriver) Hook.getDriver();
	}

	public void enterCollegueCredentials() throws Throwable {
		sUser = "Collegue User";
		int retryExp = 0 ,retryExp1 = 0, retryExp2 = 0;
		boolean boolSts = true;
		LoginClg: while(boolSts == true) {
			try {
				Thread.sleep(5000);
				driveR.findElement(By.xpath("//android.widget.Button[@text = 'Sign in with Google']")).click();
				Thread.sleep(5000);
			} catch (StaleElementReferenceException se) {
				if (retryExp1 < 3) {
					driveR.close();
					Thread.sleep(3000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					retryExp1++;
					System.out.println(se + " " + retryExp1);
					Thread.sleep(5000);
					continue LoginClg;
				} else {
					Assert.fail(se.getMessage());
					boolSts = false;
					break LoginClg;
				}
			} catch (NoSuchElementException nw) {
				if (retryExp2 < 2) {
					retryExp2++;
					System.out.println(nw + " " + retryExp1);
					try {
						if (driveR.findElement(By.xpath("//android.widget.Button[@text = 'CLOSE']")).isDisplayed()) {
							driveR.findElement(By.xpath("//android.widget.Button[@text = 'CLOSE']")).click();
						}
					} catch (Exception ff) {

					}
					Thread.sleep(7000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					System.out.println(nw + " " + retryExp2);
					continue LoginClg;
//					enterCollegueCredentials();
				} else {
					Assert.fail(nw.getMessage());
					boolSts = false;
					break LoginClg;
				}
			} catch (WebDriverException ww) {
				if (retryExp1 < 2) {
					retryExp1++;
					try {
						driveR.quit();
					}
					catch(Exception de){

					}
					System.out.println(" de " + ww + "retryExp1 " + retryExp1);
					Thread.sleep(10000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					System.out.println(ww + " " + retryExp1);
					continue LoginClg;
//					enterCollegueCredentials();
				} else {
					try{
						WebElement oELe = driveR.findElement(By.xpath("//android.widget.Button[@text = 'Sign in with Google']"));
						Actions act = new Actions(driveR);
						act.moveToElement(oELe).click().build().perform();
					}
					catch(Exception e) {
						Assert.fail(ww.getMessage());
						boolSts = false;
						break LoginClg;
					}
				}
			} catch (Exception ww) {
				if (retryExp1 < 2) {
					CountsPO oc = new CountsPO();
					Thread.sleep(7000);
					retryExp1++;
					System.out.println(ww + " " + retryExp1);
//					enterCollegueCredentials();
					continue LoginClg;
				} else {
					Assert.fail(ww.getMessage());
					boolSts = false;
					break LoginClg;
				}
			}
			boolean bSignIn = true;
//			SignIn:
//			while(bSignIn == true){
			Thread.sleep(3000);
			String xpathUserName = "//android.widget.EditText[@index='0']";
//		String xpathUserName7 = "//android.widget.Button[@resource-id='" + env + ":id/username']";
			String xpathPwd = "//android.widget.EditText[@resource-id='password']";

//		driveR.findElement(By.xpath(xpathUserName)).clear();
			try {
				driveR.findElement(By.xpath(xpathUserName)).sendKeys(collegueUsername);
//		driveR.findElement(By.xpath(xpathUserName)).click();
				Thread.sleep(1000);
				driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
				Thread.sleep(3000);
				driveR.findElement(By.xpath(xpathPwd)).clear();
				driveR.findElement(By.xpath(xpathPwd)).sendKeys(colleguePassword);
				Thread.sleep(2000);
				driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
			} catch (NoSuchSessionException ne) {
				if (retryExp2 < 2) {
					retryExp2++;
					System.out.println("retryExp1 " + retryExp2);
					Thread.sleep(3000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					System.out.println(ne + " " + retryExp2);
					continue LoginClg;
//					enterCollegueCredentials();
				} else {
					Assert.fail(ne.getMessage());
					boolSts = false;
					break LoginClg;
				}
			} catch (NoSuchElementException nw) {
				if (retryExp2 < 2) {
					retryExp2++;
					try {
						if (driveR.findElement(By.xpath("//android.widget.Button[@text = 'CLOSE']")).isDisplayed()) {
							driveR.findElement(By.xpath("//android.widget.Button[@text = 'CLOSE']")).click();
						}
						if(driveR.findElement(By.xpath("//android.widget.FrameLayout")).isEnabled()){
							driveR.findElement(By.xpath("//android.widget.FrameLayout/android.widget.Button[@text = 'Wait']")).click();
						}
					} catch (Exception et) {

					}
					Thread.sleep(7000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					System.out.println(nw + " " + retryExp2);
					continue LoginClg;
//					enterCollegueCredentials();
				} else {
					Assert.fail(nw.getMessage());
					boolSts = false;
					break LoginClg;
				}
			} catch (WebDriverException ww) {
				if (retryExp1 < 2) {
					retryExp1++;
					try {
						driveR.quit();
					}
					catch(Exception de){

					}
					Thread.sleep(7000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					System.out.println(ww + " " + retryExp1);
//					enterCollegueCredentials();
					continue LoginClg;
				} else {
					Assert.fail(ww.getMessage());
					boolSts = false;
					break LoginClg;
				}
			} catch (Exception we) {
				driveR.findElement(By.xpath(xpathUserName)).sendKeys(collegueUsername);
//		driveR.findElement(By.xpath(xpathUserName)).click();
				driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
				Thread.sleep(3000);
				driveR.findElement(By.xpath(xpathPwd)).clear();
				driveR.findElement(By.xpath(xpathPwd)).sendKeys(colleguePassword);
				Thread.sleep(2000);
				driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
			}
			boolSts = false;
			break LoginClg;
		}
}
	
	public void enterManagerCredentials() throws Throwable {
		sUser = "Manager User";
		int retryExp = 0 ,retryExp1 = 0, retryExp2 = 0;
		boolean boolSts = true;
		LoginMgr: while(boolSts == true) {
			try {
				Thread.sleep(5000);
				driveR.findElement(By.xpath("//android.widget.Button[@text = 'Sign in with Google']")).click();
				Thread.sleep(5000);
			} catch (StaleElementReferenceException se) {
				if (retryExp1 < 3) {
					driveR.close();
					Thread.sleep(3000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					retryExp1++;
					System.out.println(se + " " + retryExp1);
					Thread.sleep(5000);
					continue LoginMgr;
//					enterManagerCredentials();
				} else {
					Assert.fail(se.getMessage());
					boolSts = false;
					break LoginMgr;
				}
			} catch (NoSuchElementException nw) {
				if (retryExp2 < 2) {
					retryExp2++;
					try {
						if (driveR.findElement(By.xpath("//android.view.View[@text = 'Couldn’t sign you in']")).isDisplayed()) {
							driveR.findElement(By.xpath("//android.widget.Button[@text = 'CLOSE']")).click();
						}
					} catch (Exception et) {

					}
					Thread.sleep(3000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					System.out.println(nw + " " + retryExp2);
//					enterManagerCredentials();
					continue LoginMgr;
				}
				else {
					Assert.assertThrows((Assert.ThrowingRunnable) nw);
					boolSts = false;
					break LoginMgr;
				}
			} catch (WebDriverException ww) {
				if (retryExp1 < 2) {
					retryExp1++;
					try {
						driveR.quit();
					}
					catch(Exception de){

					}
					Thread.sleep(10000);
					Hook hh = new Hook();
					hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					System.out.println(ww + " " + retryExp1);
//					enterManagerCredentials();
					continue LoginMgr;
				}
				else {
					Assert.fail(ww.getMessage());
					boolSts = false;
					break LoginMgr;
				}
			} catch (Exception ww) {
				if (retryExp1 < 3) {
					CountsPO oc = new CountsPO();
					Thread.sleep(7000);
					retryExp1++;
					System.out.println(ww + " " + retryExp1);
//					enterManagerCredentials();
					continue LoginMgr;
				}
				else {
					Assert.fail(ww.getMessage());
					boolSts = false;
					break LoginMgr;
				}
			}
			boolean bSignIn = true;
//			SignIn:
//			while(bSignIn == true) {
				Thread.sleep(3000);
				String xpathUserName = "//android.widget.EditText[@index='0']";
//		String xpathUserName7 = "//android.widget.Button[@resource-id='" + env + ":id/username']";
				String xpathPwd = "//android.widget.EditText[@resource-id='password']";

//		driveR.findElement(By.xpath(xpathUserName)).clear();
				try {
					driveR.findElement(By.xpath(xpathUserName)).sendKeys(managerUsername);
					Thread.sleep(1000);
//		driveR.findElement(By.xpath(xpathUserName)).click();
					driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
					Thread.sleep(3000);
					driveR.findElement(By.xpath(xpathPwd)).clear();
					driveR.findElement(By.xpath(xpathPwd)).sendKeys(managerPassword);
					Thread.sleep(2000);
					driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
				} catch (NoSuchSessionException ne) {
					if (retryExp2 < 2) {
						retryExp2++;
						System.out.println("retryExp2 " + retryExp2 + "Exception " + ne);
						Thread.sleep(7000);
						Hook hh = new Hook();
						hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
					continue LoginMgr;
//						enterManagerCredentials();
					} else {
						Assert.fail(ne.getMessage());
						boolSts = false;
						break LoginMgr;
					}
				} catch (NoSuchElementException nw) {
					if (retryExp2 < 2) {
						retryExp2++;
						try {
							if (driveR.findElement(By.xpath("//android.view.View[@text = 'Couldn’t sign you in']")).isDisplayed()) {
								driveR.findElement(By.xpath("//android.widget.Button[@text = 'CLOSE']")).click();
							}
						} catch (Exception et) {

						}
						Thread.sleep(3000);
						Hook hh = new Hook();
						hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
						System.out.println("retryExp2 " + retryExp2 + "Exception " + nw);
						continue LoginMgr;
//						enterManagerCredentials();
					} else {
						Assert.fail(nw.getMessage());
						boolSts = false;
						break LoginMgr;
					}
				} catch (WebDriverException ww) {
					if (retryExp1 < 2) {
						retryExp1++;
						try {
							driveR.quit();
						}
						catch(Exception de){

						}
						Thread.sleep(10000);
						Hook hh = new Hook();
						hh.smaBefore();
					LoginPagePO oo = new LoginPagePO();
						System.out.println("retryExp1 " + retryExp1 + "Exception " + ww);
						continue LoginMgr;
//						enterManagerCredentials();
					} else {
						Assert.fail(ww.getMessage());
						boolSts = false;
						break LoginMgr;
					}
				} catch (Exception we) {
					driveR.findElement(By.xpath(xpathUserName)).sendKeys(managerUsername);
//		driveR.findElement(By.xpath(xpathUserName)).click();
					driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
					Thread.sleep(3000);
					driveR.findElement(By.xpath(xpathPwd)).clear();
					driveR.findElement(By.xpath(xpathPwd)).sendKeys(managerPassword);
					Thread.sleep(2000);
					driveR.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
				}
//		String xpathUserName = "//android.widget.EditText[@resource-id='" + env + ":id/username']";
//		String xpathPwd = "//android.widget.EditText[@resource-id='" + env + ":id/password']";
//		System.out.println("managerUsername--------------------------"+managerUsername);
//
//		driveR.findElement(By.xpath(xpathUserName)).clear();
//
//		driveR.findElement(By.xpath(xpathUserName)).sendKeys(managerUsername);
//
//		driveR.findElement(By.xpath(xpathPwd)).clear();
//		driveR.findElement(By.xpath(xpathPwd)).sendKeys(managerPassword);
			boolSts = false;
			break LoginMgr;

		}
	}

	public void clickOnLogin() throws Throwable {
		String sToken = null;
		int iLogin = 0,iLogin1 = 0, iCount = 0, sGVerfCnt = 0;
		boolean bSts = false,sGVerfSts = true;
		Thread.sleep(5000);
		aa:
		while(sGVerfSts == true) {
			try {
				String xpathbarcodeicon = "//android.widget.Button[@resource-id='totpNext']";
				WebDriverWait w = new WebDriverWait(driveR, 10);
				w.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(xpathbarcodeicon)));
				bSts = true;
				sGVerfSts = false;
			} catch (Exception TotpExp) {
				if (sGVerfCnt < 2) {
					sGVerfCnt++;
					continue aa;
				}
				else{
					break aa;
				}
			}
		}
		bb:
		while(bSts == true) {
			try {
				if (sUser.equalsIgnoreCase("Manager User")) {
					sToken = returnTokenKeyManager();
				} else if (sUser.equalsIgnoreCase("Collegue User")) {
					sToken = returnTokenKeyCollegue();
				}
				driveR.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys(sToken);
				Thread.sleep(2000);
				System.out.println("We are at clicking upper next btn");
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id='totpNext']")).click();
				Thread.sleep(5000);
				try {
					System.out.println("We are at inner next btn");
				iCount = driveR.findElements(By.xpath("//android.widget.Button[@resource-id='totpNext']")).size();
				System.out.println("2-Step verf Next btn cnt " + iCount);
					if (iCount > 0) {
						midbb:
						while (iLogin < 3) {
							System.out.println("iLogin " + iLogin + " run status " + bSts);
							iLogin++;
//						driveR.navigate().refresh();
							continue bb;
						}
					} else {
						bSts = false;
						break bb;
					}
				}
				catch(NoSuchElementException oe){
					System.out.println("We intered into inner try");
					bSts = false;
					break bb;
				}
				catch(Exception u){
					System.out.println("We intered into inner try");
				}
//			driveR.findElement(By.xpath("//android.widget.Button[@resource-id='confirm_yes']")).click();
			}
			catch(NoSuchElementException ne){
				System.out.println(ne + " " + iLogin1);
				iCount = driveR.findElements(By.xpath("//android.widget.Button[@resource-id='totpNext']")).size();
				System.out.println("bSts " + bSts);
				System.out.println("2-Step verf Next btn cnt under exception " + iCount);
				if (iCount > 0 && iLogin>0) {
					while (iLogin1 < 3) {
						iLogin1++;
						continue bb;
					}
				}
				else{
					try {
						iCount = driveR.findElements(By.xpath("//android.widget.Button[@text = 'CLOSE']")).size();
						if (iCount > 0) {
							break bb;
						}
					}
					catch(Exception closeBtnexp){

					}
					while (iLogin1 < 3) {
						if (sUser.equalsIgnoreCase("Manager User")) {
							enterManagerCredentials();
						}
						else if (sUser.equalsIgnoreCase("Collegue User")) {
							enterCollegueCredentials();
						}
						iLogin1++;
						continue bb;
					}
					}
			}
			catch (Exception e) {
				System.out.println(e + " " + iLogin);
				iCount = driveR.findElements(By.xpath("//android.widget.Button[@resource-id='totpNext']")).size();
				System.out.println("2-Step verf Next btn cnt under exception " + iCount);
				System.out.println("bSts " + bSts);
				if (iCount > 0 && iLogin>0) {
					while (iLogin1 < 3) {
						iLogin1++;
						continue bb;
					}
				}
				else {
					try {
						iCount = driveR.findElements(By.xpath("//android.widget.Button[@text = 'CLOSE']")).size();
						if (iCount > 0) {
							break bb;
						}
					}
					catch(Exception closeBtnexp){

					}
					while (iLogin1 < 3) {
						if (sUser.equalsIgnoreCase("Manager User")) {
							enterManagerCredentials();
						} else if (sUser.equalsIgnoreCase("Collegue User")) {
							enterCollegueCredentials();
						}
						iLogin1++;
						continue bb;
					}
				}
			}
			bSts = false;
			break bb;
		}
		try {
			Thread.sleep(2000);
			if (driveR.findElements(By.xpath("//android.widget.Button[@text = 'CLOSE']")).size() > 0) {
				driveR.findElement(By.xpath("//android.widget.Button[@text = 'CLOSE']")).click();
				Thread.sleep(3000);
				driveR.findElement(By.xpath("//android.widget.Button[@text = 'Sign in with Google']")).click();
				Thread.sleep(2000);
				System.out.println("Total login btn ");
				driveR.findElement(By.xpath("//android.widget.Button[@resource-id = 'choose-account-0']")).click();
				Thread.sleep(3000);
			}
		}
		catch(NoSuchElementException clExp){
			System.out.println("Total login btn ");
			driveR.findElement(By.xpath("//android.widget.Button[@resource-id = 'choose-account-0']")).click();;
			Thread.sleep(3000);
		}
		catch(Exception rr){

		}
		sUser = "";
		iLogin = 0;
	}

	String returnTokenKeyCollegue(){
		String collegueUserKey = applicationConfig.getUserKeys().getcollegueUserKey();
		Totp totp = new Totp(collegueUserKey);
		String twoFactorCode = totp.now();
		return twoFactorCode;
	}

	public String returnTokenKeyManager(){
		String managerUserKey = applicationConfig.getUserKeys().getmanagerUserKey();
		Totp totp = new Totp(managerUserKey);
		String twoFactorCode = totp.now();
		return twoFactorCode;
	}
	
	public void enterTwilightManagerCredentials() throws Throwable {


		String xpathUserName = "//android.widget.EditText[@resource-id='" + env + ":id/username']";
		String xpathPwd = "//android.widget.EditText[@resource-id='" + env + ":id/password']";

		driveR.findElement(By.xpath(xpathUserName)).clear();

		driveR.findElement(By.xpath(xpathUserName)).sendKeys(twilightManagerUsername);

		driveR.findElement(By.xpath(xpathPwd)).clear();
		driveR.findElement(By.xpath(xpathPwd)).sendKeys(twilightManagerPassword);

	}

}
