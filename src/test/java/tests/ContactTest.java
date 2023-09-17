package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.LoginPage;
import pages.ViewPage;
import testComponents.BaseTest;

public class ContactTest extends BaseTest {

@Test
public void contactTestTC25() throws IOException
{
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC25: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact Page displayed");
	 logger.info("AccountTest: ContactTestTC25: contact page displayed");
	 
	 cp.clickNewContactButton();
	 Assert.assertTrue(cp.verifyDisplayOfNewContactPage(driver));
	 cp.enterLastName();
	 cp.enterAccountName(driver);
	 cp.clickSaveButton();
	 Assert.assertTrue(cp.verifyCreatingNewContact(driver));
	 getTest().info("New contact is created");
	 logger.info("AccountTest: ContactTestTC25: new contact is created");
	 
}
@Test	
public void contactTestTC29() throws IOException
{
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC25: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact Page displayed");
	 logger.info("AccountTest: ContactTestTC29: contact page displayed");
	 String contactName=cp.clickOnAContactName(driver);
	 getTest().info("Clicked on a contact name");
	 logger.info("AccountTest: ContactTestTC29: clicked on a contact name");
	 Assert.assertTrue(cp.verifyContactInfoOfContactName(driver,contactName));
	 getTest().info("Contact info verified");
	 logger.info("AccountTest: ContactTestTC29: contact info verified");


}

@Test
public void contactTestTC26() throws IOException {
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC25: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact Page displayed");
	 logger.info("AccountTest: ContactTestTC29: contact page displayed");
	/* cp.clickOnCreateNewView();
	 Assert.assertTrue(cp.verifyDisplayOfNewViewPage(driver));
	cp.enterNewViewName();
	cp.enterUniqueViewName();
	cp.saveView();
	Assert.assertTrue(cp.verifyDisplayOfNewViewName(driver));*/
	 ViewPage vp=new ViewPage(driver);
	 vp.createNewView(driver);
	 Assert.assertTrue(vp.verifyDisplayOfNewView(driver));
	 
			
}

@Test
public void contactTestTC27() throws IOException {
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC27: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact home Page displayed");
	 logger.info("AccountTest: ContactTestTC27: contact home page displayed");
	 cp.selectRecentlyCreatedfromDropdown();
	 Assert.assertTrue(cp.verifyDisplayOfRecentlyCreatedContact(driver));
	

}

@Test
public void contactTestTC28() throws IOException {
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC28: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact home Page displayed");
	 logger.info("AccountTest: ContactTestTC27: contact home page displayed");
	 cp.selectMyContacts();
	 getTest().info("selected my contacts");
	 logger.info("AccountTest: ContactTestTC28: my contacts selected ");
	 Assert.assertTrue(cp.verifyDisplayOfMyContactsView(driver));

}
@Test
public void contactTestTC30() throws IOException {
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC30: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact home Page displayed");
	 logger.info("AccountTest: ContactTestTC30: contact home page displayed");
	 ViewPage vp=new ViewPage(driver);
	 vp.createNewViewLink.click();
	 Assert.assertTrue(vp.checkErrorMessageforViewname(driver));
	 getTest().info("Checked error message for view name");
	 logger.info("AccountTest: ContactTestTC30: Checked error message for view name");
	 
	 

}
@Test
public void contactTestTC31() throws IOException {
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC31: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact home Page displayed");
	 logger.info("AccountTest: ContactTestTC31: contact home page displayed");
	 ViewPage vp=new ViewPage(driver);
	 vp.createNewViewLink.click();
	 vp.checkCancelViewButton(driver);
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 
	 
}

@Test
public void contactTestTC32() throws IOException {
	WebDriver driver=BaseTest.getDriver();
	 LoginPage lp=new LoginPage(driver);
	 lp.launchUrl(driver);
	 lp.loginToUrl(driver);
	 getTest().info("Logged in to SalesForce");
	 logger.info("AccountTest: ContactTestTC31: Logged in to SalesForce");
	 Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickContactTab();
	 Assert.assertTrue(cp.verifyDisplayOfContactsHomePage(driver));
	 getTest().info("Contact home Page displayed");
	 logger.info("AccountTest: ContactTestTC31: contact home page displayed");
	 
	 cp.createNewContact(driver);
	 Assert.assertTrue(cp.verifyDisplayOfNewContactPage(driver));
}
}