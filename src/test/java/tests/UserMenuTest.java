package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.LoginPage;
import pages.UserMenuPage;
import testComponents.BaseTest;
import testComponents.SFDClisteners;
import utils.CommonUtils;

@Listeners (SFDClisteners.class)
public class UserMenuTest extends BaseTest {
	
	

	@Test ()
	public void userMenuDropDown_TC06() throws IOException, InterruptedException {
		
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		lp.loginToUrl(driver);
		UserMenuPage ump=new UserMenuPage(driver);
		CommonUtils.waitForElement(driver, ump.userMenu);
		if(ump.userMenu.isDisplayed()) {
			ump.userMenu.click();
		}
		Assert.assertTrue(ump.verifyUserMenuItems(driver));
		BaseTest.test.info("usermenu is verified");
		Assert.assertTrue(ump.selectMyProfileOption(driver));
		BaseTest.test.info("My profile option is selected");
		Assert.assertTrue(ump.verifyProfilePageDisplayed(driver));
		BaseTest.test.info("Profile page uploaded");
		ump.selectEditContactButton(driver);
		Assert.assertTrue(ump.isDisplayedEditProfilePopUp(driver));
		BaseTest.test.info("EditContactPopUp is displayed");
		Assert.assertTrue(ump.verifyProfilePageLastNameChanged(driver, "Ghosh"));
		BaseTest.test.info(" Verified Last name changed");
		Assert.assertTrue(ump.verifyCreatePost(driver,"My bad"));
		BaseTest.test.info(" verified create post");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.LOGIN_TESTDATA_FILE_PATH));
		BaseTest.test.info(" Verified file upload");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PROFILE_PHOTO_FILE_PATH));
		BaseTest.test.info(" Verified photo upload");
		
		
		
	}

}
