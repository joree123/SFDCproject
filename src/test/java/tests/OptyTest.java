package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.OpportunitiesPage;
import testComponents.BaseTest;

public class OptyTest extends BaseTest{
	@Test
	 public void opportunityTestTC15() throws IOException {
		 WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("OptyTest: opportunityTestTC15: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		 OpportunitiesPage op=new OpportunitiesPage(driver);
		 op.OpportunitiesLink.click();
		 Assert.assertTrue(op.verifyDisplayOfOptyHomePage(driver));
		 getTest().info("Opportunities home page is displayed");
		 logger.info("OptyTest: opportunityTestTC15: Opportunities home page is displayed");
		 Assert.assertTrue(op.verifyOptyDropdownOptions(driver));
		 getTest().info("Opportunities dropdown is checked");
		 logger.info("OptyTest: opportunityTest15:Opportunities dropdown is checked");
	
	}
	
	
	@Test
	 public void opportunityTestTC16() throws IOException {
		 WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("OptyTest: opportunityTestTC16: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		 OpportunitiesPage op=new OpportunitiesPage(driver);
		 op.OpportunitiesLink.click();
		 Assert.assertTrue(op.verifyDisplayOfOptyHomePage(driver));
		 getTest().info("Opportunities home page is displayed");
		 logger.info("OptyTest: opportunityTestTC16: Opportunities home page is displayed");
		 op.newButton.click();
		 op.createNewOpportunity(driver);
		 Assert.assertTrue(op.verifyDisplayOfOpportunityDetails(driver));
	
	
	}
	
	@Test
	 public void opportunityTestTC17() throws IOException {
		 WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("OptyTest: opportunityTestTC17: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		 OpportunitiesPage op=new OpportunitiesPage(driver);
		 op.OpportunitiesLink.click();
		 Assert.assertTrue(op.verifyDisplayOfOptyHomePage(driver));
		 getTest().info("Opportunities home page is displayed");
		 logger.info("OptyTest: opportunityTestTC17: Opportunities home page is displayed");
		 op.opPipeLineLink.click();
		 Assert.assertTrue(op.verifyDisplayOfReportsDisplayPage(driver));
		 logger.info("OptyTest: opportunityTestTC17: reports page is displayed");
		 
	
}

	@Test
	 public void opportunityTestTC18() throws IOException {
		 WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("OptyTest: opportunityTestTC18: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		 OpportunitiesPage op=new OpportunitiesPage(driver);
		 op.OpportunitiesLink.click();
		 Assert.assertTrue(op.verifyDisplayOfOptyHomePage(driver));
		 getTest().info("Opportunities home page is displayed");
		 logger.info("OptyTest: opportunityTestTC18: Opportunities home page is displayed");
		 op.opStuckLink.click();
		 Assert.assertTrue(op.verifyDisplayOfStuckOpPage(driver));
	
}
	
	@Test
	
	 public void opportunityTestTC19() throws IOException {
		 WebDriver driver=BaseTest.getDriver();
		 LoginPage lp=new LoginPage(driver);
		 lp.launchUrl(driver);
		 lp.loginToUrl(driver);
		 getTest().info("Logged in to SalesForce");
		 logger.info("OptyTest: opportunityTestTC18: Logged in to SalesForce");
		 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		 OpportunitiesPage op=new OpportunitiesPage(driver);
		 op.OpportunitiesLink.click();
		 Assert.assertTrue(op.verifyDisplayOfOptyHomePage(driver));
		 getTest().info("Opportunities home page is displayed");
		 logger.info("OptyTest: opportunityTestTC18: Opportunities home page is displayed");
		 op.selectInterval("Current FQ");
		 op.selectOpportunities("All Opportunities");
	     Assert.assertTrue(op.verifyDisplayOfSelectedReportPage(driver));
}
	

}