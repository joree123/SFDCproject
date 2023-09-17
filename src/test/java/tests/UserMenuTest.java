package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.LoginPage;
import pages.MySettingsPage;
import pages.UserMenuPage;
import testComponents.BaseTest;
import testComponents.SFDClisteners;
import utils.CommonUtils;

@Listeners (SFDClisteners.class)
public class UserMenuTest extends BaseTest {
	

	@Test ()
	public void userMenuDropDown_TC06(Method name) throws IOException  {
		
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		lp.loginToUrl(driver);
		UserMenuPage ump=new UserMenuPage(driver);
		ump.clickUserMenuButton(driver);
		getTest().info("UserMenu button is clicked");
		Assert.assertTrue(ump.verifyUserMenuItems());
		getTest().info("usermenu is verified");
		Assert.assertTrue(ump.selectMyProfileOption());
		getTest().info("My profile option is selected");
		Assert.assertTrue(ump.verifyProfilePageDisplayed());
		getTest().info("Profile page uploaded");
		ump.selectEditContactButton();
		Assert.assertTrue(ump.isDisplayedEditProfilePopUp(driver));
		getTest().info("EditContactPopUp is displayed");
		Assert.assertTrue(ump.verifyProfilePageLastNameChanged(driver, "Banerjee"));
		getTest().info(" Verified Last name changed");
		Assert.assertTrue(ump.verifyCreatePost(driver,"My bad"));
		getTest().info(" verified create post");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.LOGIN_TESTDATA_FILE_PATH));
		getTest().info(" Verified file upload");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PROFILE_PHOTO_FILE_PATH));
		getTest().info(" Verified photo upload");
		
		
		
	}
	
	@Test(enabled=true)
	public void userMenuTestTC07() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		lp.loginToUrl(driver);
		UserMenuPage ump=new UserMenuPage(driver);
		ump.clickUserMenuButton(driver);
		getTest().info("UserMenu button is clicked");
		logger.info("userMenu button clicked");
		MySettingsPage msp=new MySettingsPage(driver);
		msp.selectMySettingsOption(driver);
		getTest().info("My settings option is selected");
		logger.info("My settings option is selected");
		Assert.assertTrue(msp.verifyDisplayOfMySettingsPage(driver));
		getTest().info("My settings page is displayed");
		logger.info("My settings page is displayed");
		
		Assert.assertTrue(msp.verifyDownloadOfLoginHistory(driver));
		getTest().info("Login history is downloaded");
		logger.info("Login history is downloaded");
		msp.displayAndLayout.click();
		msp.customizeTab.click();
		logger.info("Customize tab clicked");
		Assert.assertTrue(msp.verifyDisplayAndLayoutLink(driver));
		getTest().info("Display and Layout link is verified");
		logger.info("Display and Layout link is verified");
		
		/*Assert.assertTrue(msp.verifyEmailLink(driver));
		getTest().info("Email link is verified");
		logger.info("Email link is verified");
		Assert.assertTrue(msp.verifyCalenderRemindersLink(driver));
		getTest().info("CalenderReminders link is verified");
		logger.info("CalenderReminders link is verified");
		*/
	}
	
	
	@Test(enabled=true)
	public void UserMenuTestTC08() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		lp.loginToUrl(driver);
		UserMenuPage ump=new UserMenuPage(driver);
		ump.clickUserMenuButton(driver);
		getTest().info("UserMenu button is clicked");
		Assert.assertTrue(ump.verifyUserMenuItems());
		getTest().info("usermenu is verified");
		ump.openDeveloperConsole();
		getTest().info("Developer console is Opened");
		Assert.assertTrue(ump.verifyDeveloperConsoleWindow(driver));
		getTest().info("Developer console popup window is verified");
		ump.closeWindow(driver);
		getTest().info("Developer console window is closed");
	}

	@Test(enabled=true)
	public void UsermenuTestTC09() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		lp.loginToUrl(driver);
		UserMenuPage ump=new UserMenuPage(driver);
		
		ump.clickUserMenuButton(driver);
		getTest().info("UserMenu button is clicked");
		ump.clickLogoutButton(driver);
		getTest().info("Logout button is clicked");
		Assert.assertTrue(ump.verifyDisplayOfLoginPage(driver));
		getTest().info("Login page is displayed");
	}
	
	
	
}

