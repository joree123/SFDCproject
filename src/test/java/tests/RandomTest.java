package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AllPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserMenuPage;
import testComponents.BaseTest;

public class RandomTest extends BaseTest {

	@Test
	public void randomTestTC33() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("OptyTest: opportunityTestTC18: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		HomePage hp=new HomePage(driver);
		hp.HomeTab.click();
		Assert.assertTrue(hp.verifyDisplayOfHomePage(driver));
		Assert.assertTrue(hp.verifyDisplayOfFirstAndLastNameLink(driver));
		hp.firstAndLastNameLink.click();
		Assert.assertTrue(hp.verifyDisplayOfMyProfilePage(driver));
		
	}
	
	@Test
	public void randomTestTC34() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("OptyTest: opportunityTestTC18: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		HomePage hp=new HomePage(driver);
		hp.HomeTab.click();
		Assert.assertTrue(hp.verifyDisplayOfHomePage(driver));
		Assert.assertTrue(hp.verifyDisplayOfFirstAndLastNameLink(driver));
		hp.firstAndLastNameLink.click();
		Assert.assertTrue(hp.verifyDisplayOfMyProfilePage(driver));
		UserMenuPage ump=new UserMenuPage(driver);
		ump.selectEditContactButton();
		Assert.assertTrue(ump.isDisplayedEditProfilePopUp(driver));
		Assert.assertTrue(ump.verifyProfilePageLastNameChanged(driver, "Banerjee"));
		Assert.assertTrue(hp.verifyLastNameChangedOnUserMenu(driver,"Banerjee"));
		
		
	}
	
	@Test
	public void randomTestTC35() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("RandomTest: randomTestTC35: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		 AllPage ap=new AllPage(driver);
		 ap.allTab.click();
		 Assert.assertTrue(ap.verifyDisplayOfAllTabsPage(driver));
		 logger.info("RandomTest: randomTestTC35: All tabs page displayed");
		 ap.customizeMyTabLink.click();
		 Assert.assertTrue(ap.verifyDisplayOfCustomizeMyTabPage(driver));
		 logger.info("RandomTest: randomTestTC35: Customize my tab page displayed");
		 String tabName=ap.selectAnyTabFromSelectedTabs();
		 ap.removeTabButton.click();
		 logger.info("RandomTest: randomTestTC35: remove button clicked");
		 Assert.assertTrue(ap.verifyDisplayOfSelectedTabInAvailableTabs(driver,tabName));
		 logger.info("RandomTest: randomTestTC35: selected tab is displayed in available tabs");
		 ap.saveTabButton.click();
		 Assert.assertTrue(ap.verifyDisplayOfAllTabsPage(driver));
		 logger.info("RandomTest: randomTestTC35: All tabs page displayed");
		 Assert.assertTrue(ap.verifyRemovedTabNotDisplayedInTabBar(driver,tabName));
		 logger.info("RandomTest: randomTestTC35: selected tabis not displayed in tab bar");
		 
}
}	
