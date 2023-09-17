
	package pages;

	

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import constants.FileConstants;
import utils.BasePage;
import utils.CommonUtils;
import utils.FileUtilities;

/**This page contains all the required  elements and methods for login
 * page
 * @author Joree 
 */
public class LoginPage extends BasePage {

	
	 
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(id = "error")
	public WebElement errorMessage;

	@FindBy(partialLinkText = "Forgot")
	public WebElement forgotPassword;

	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	@FindBy(id = "un")
	public WebElement forgotUsername;
	
	@FindBy(css= "input#continue")
	public WebElement continueButton;
	
	@FindBy(xpath= "//div[@class='message']/ p[1]")
	public WebElement passwordResetMessage;

	@FindBy(xpath = "//a[text()='Return to Login']")
		public WebElement returnToLoginButton;
	
	@FindBy(id="phHeaderLogoImage")
	public WebElement logoImage;
  
		public void launchUrl(WebDriver driver) throws IOException
		{
			driver.get(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
			logger.info("LoginPage: launchUrl: url lauched");
		}
		public boolean selectRememberMeCheckbox() {
			logger.info("LoginPage: selectRemeberMeCheckbox():started ");
			boolean isSelected=false;
			
			if(!rememberMe.isSelected()) {
				rememberMe.click();
				isSelected=true;
				logger.info("LoginPage: selectRemeberMeCheckbox():checkbox selected");
				
			}
			logger.info("LoginPage: selectRemeberMeCheckbox():ended");
			return isSelected;
			
		}
		
		public void logoutOfSfdc(WebDriver driver)
		{
			UserMenuPage ump=new UserMenuPage(driver);
			if(ump.userMenu.isDisplayed())
			{
				ump.userMenu.click();
				if(CommonUtils.waitForElementToBeClickable(driver, ump.Logout)) {
					
				
				ump.Logout.click();
				}
				logger.info("LoginPage: logoutOfSfdc(): logout button clicked");
			}
			
		}
	
	/**This method is used to login to Login page
	 * @throws IOException 
	 */
	
		public void loginToUrl(WebDriver driver) throws IOException
		{
		driver.manage().window().maximize();
		logger.info("Loginpage: loginToUrl: driver maximized");
			if(CommonUtils.waitForElementToBeClickable(driver,username))
			{
		username.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
		password.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		logger.info	("LoginPage: loginToUrl:username and Password entered");
		loginButton.click();
		logger.info("LoginPage: loginToUrl: loginButton clicked");
			
			
			}
			
		}
		
		public boolean verifyOpeningOfSavedLoginPage(WebDriver driver)
		{
			return CommonUtils.waitForElementToBeClickable(driver, savedUsername);
		}
		
		public boolean verifyOpeningOfLoginPage(WebDriver driver)
		{
			return CommonUtils.waitForElementToBeClickable(driver, username);
		}
		
		
		
		
		public String verifyDisplayOfForgotPasswordPage(WebDriver driver)
		{
			String pageTitle=null;
			if(CommonUtils.waitForElementToBeClickable(driver,forgotUsername )) {
				pageTitle=driver.getTitle();
			}
			return pageTitle;
			
		}
 public boolean verifyDisplayOfHomePage(WebDriver driver)
 { 
	 boolean isDisplayed=false;
	 if(CommonUtils.waitForElementToBeClickable(driver, logoImage))
		{
			String pageTitle=driver.getTitle();
			if(pageTitle.equalsIgnoreCase("Home Page ~ Salesforce - Developer Edition"))
			{
			isDisplayed	=true;
			logger.info("LoginPage:VerifyDisplayOfHomePage(): Home page is displayed");
			}
			
		}
	 return isDisplayed;
 }
		
		
		}
