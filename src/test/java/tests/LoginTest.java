package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.LoginPage;
import testComponents.BaseTest;
import testComponents.SFDClisteners;
import utils.CommonUtils;
import utils.FileUtilities;

@Listeners( SFDClisteners.class)
public class LoginTest extends BaseTest {
	
	
	
	@Test
	
	public void loginTestTC01() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		logger.info("LoginTest:TC01: launched client URL");
		lp.username.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		getTest().info("username entered");
		logger.info("LoginTest:TC01: user name entered");
		
		getTest().info("password not entered");
		logger.info("LoginTest:TC01: password not entered");
		
		lp.loginButton.click();
		getTest().info("clicked login button");
		logger.info("LoginTest:TC01: login button clicked");
		if(CommonUtils.waitForElementToBeClickable(driver,lp.errorMessage))
		{
			Assert.assertEquals(lp.errorMessage, "Please enter your password.");
			getTest().info("error message checked");
			logger.info("LoginTest:TC01: error message checked");
			
		}
		else {
			getTest().info("error message did not appear");
			logger.warn("LoginTest:TC01:error message did not appear ");
		}
	}
			
	@Test
	public void loginTestTC02() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		lp.loginToUrl(driver);
		if(CommonUtils.waitForElementToBeClickable(driver, lp.logoImage))
		{
			String pageTitle=driver.getTitle();
			Assert.assertEquals(pageTitle,"Home Page ~ Salesforce - Developer Edition");
			getTest().info("home page displayed");
			logger.info("LoginTest:TC01: home page displayed");
		}
			}
		
	@Test
	public void LoginTestTC03() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		logger.info("LoginTest:TC03: launched client URL");
		lp.username.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		getTest().info("username entered");
		logger.info("LoginTest:TC03: user name entered");
		lp.password.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		getTest().info("password  entered");
		logger.info("LoginTest:TC03: password entered");
		Assert.assertTrue(lp.selectRememberMeCheckbox());
		
		getTest().info("selected rememberMe checkbox");
		lp.loginButton.click();
		Assert.assertTrue(lp.verifyDisplayOfHomePage(driver));
		getTest().info("home page displayed");
		logger.info("LoginTest:TC03: home page displayed");
		lp.logoutOfSfdc(driver);
		getTest().info("logged out of SFDC");
		Assert.assertTrue(lp.verifyOpeningOfSavedLoginPage(driver));
		getTest().info("login page displayed");
		Assert.assertEquals(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"), lp.savedUsername.getText());
		getTest().info("username displayed in username field");
		logger.info("LoginTest:TC03:username displayed in username field");	
	
	}
	
@Test
	public void LoginTestTC04A() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.launchUrl(driver);
		logger.info("LoginTest:TC04A: launched client URL");
		Assert.assertTrue(lp.verifyOpeningOfLoginPage(driver));
		lp.forgotPassword.click();
		logger.info("LoginTest:TC04A: forgot password link is clicked");
		getTest().info("forgot password link is clicked");
		Assert.assertEquals(lp.verifyDisplayOfForgotPasswordPage(driver), "Forgot Your Password | Salesforce");
		lp.forgotUsername.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		logger.info("LoginTest:TC04A: usernamefield entered in forgot password page");
		getTest().info("usernamefield entered in forgot password page");
		lp.continueButton.click();
		Assert.assertTrue(lp.passwordResetMessage.isDisplayed());
	}

@Test
public void LoginTestTC04b() throws IOException
{
	WebDriver driver=BaseTest.getDriver();
	LoginPage lp=new LoginPage(driver);
	lp.launchUrl(driver);
	logger.info("LoginTest:TC04A: launched client URL");
	lp.username.sendKeys("asd123");
	lp.password.sendKeys("23dd");
	logger.info("LoginTest:TC04b: wrong username and password entered");
	getTest().info("wrong username and password entered");
	lp.loginButton.click();
	Assert.assertTrue(lp.errorMessage.isDisplayed());
	logger.info("LoginTest:TC04b:error message displayed ");
	getTest().info("error message displayed");
}



	}
		
		
	
			
		

	
		


