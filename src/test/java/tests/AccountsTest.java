package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.AccountsReportPage;
import pages.LoginPage;
import pages.UserMenuPage;
import pages.ViewPage;
import testComponents.BaseTest;

public class AccountsTest extends BaseTest{
 @Test
 public void accountTestTC10() throws IOException {
	 WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: AccountTestTC10: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 
	 
	 AccountsPage ap=new AccountsPage(driver);	 
	 ap.clickAccountsLink();
	 Assert.assertTrue(ap.verifyDisplayOfAccountsPage(driver));
	 getTest().info("Verified display of Accounts Page");
	 logger.info("AccountTest: AccountTestTC10:Verified display of Account page ");
	 ap.createNewButton.click();
	 ap.createNewAccount();
	 getTest().info("new account is created");
	 logger.info("AccountTest: AccountTestTC10():new account is created ");
	 Assert.assertTrue(ap.verifyDisplayOfNewAccountPage(driver));
	 getTest().info("verify display of new account page");
	 logger.info("AccountTest: AccountTestTC10:Verified display of new account page ");
 }
 @Test
 public void accountTestTC11() throws IOException {
	 WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: AccountTestTC11: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	
	 AccountsPage ap=new AccountsPage(driver);	 
	 ap.clickAccountsLink();
	
	 Assert.assertTrue(ap.verifyDisplayOfAccountsPage(driver));
	 getTest().info("Verified display of Accounts Page");
	 logger.info("AccountTest: AccountTestTC11:Verified display of Account page ");
	 ViewPage vp=new ViewPage(driver);
	 
	 vp.createNewView(driver);
	 getTest().info("new view created");
	 logger.info("AccountTest: AccountTestTC11():new view created ");
	 Assert.assertTrue(vp.verifyDisplayOfNewView(driver));
	 getTest().info("new view displayed");
	 logger.info("AccountTest: AccountTestTC11():new view displayed ");
	 
 }
 
 @Test
 public void accountTestTC13() throws IOException {
	 WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: AccountTestTC11: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	
	 AccountsPage ap=new AccountsPage(driver);	 
	 ap.clickAccountsLink();
	
	 Assert.assertTrue(ap.verifyDisplayOfAccountsPage(driver));
	 //check whether more than 1 accounts to merge
	 getTest().info("Verified display of Accounts Page");
	 logger.info("AccountTest: AccountTestTC11:Verified display of Account page ");
	 ap.mergeAccountsLink.click();
	 ap.selectAccountsToMerge(driver);
	 ap.mergeAccounts(driver);
	 Assert.assertTrue(ap.verifyDisplayOfNewMegedAccounts(driver));
 }
 
 @Test
 public void accountTestTC14() throws IOException, InterruptedException {
	 WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: AccountTestTC14: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	
	 AccountsPage ap=new AccountsPage(driver);	 
	 ap.clickAccountsLink();
	
	 Assert.assertTrue(ap.verifyDisplayOfAccountsPage(driver));
	 
	 getTest().info("Verified display of Accounts Page");
	 logger.info("AccountTest: AccountTestTC14:Verified display of Account page ");
	 AccountsReportPage arp=new AccountsReportPage(driver);
	 arp.createAccountReport(driver);
	 getTest().info("Account report created");
	 logger.info("AccountTest: AccountTestTC14:Account report created");
	 Assert.assertTrue(arp.verifyDisplayofUnsavedReport(driver));
	 arp.selectReportOptions();
	 getTest().info("selected report option");
	 logger.info("AccountTest: AccountTestTC14:   selected report option ");
	 Assert.assertTrue(arp.verifyDisplayOfListOfAccounts(driver));
	 arp.saveReport(driver);
	 getTest().info("Report saved");
	 logger.info("AccountTest: AccountTestTC11: Report saved");
	 Assert.assertTrue(arp.verifyDisplayOfReportPage(driver));
	 getTest().info("Verified display of Report Page");
	 logger.info("AccountTest: AccountTestTC11:Verified display of Report page ");
 }
 
}

