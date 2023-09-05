
	package pages;

	

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//a[text()='Return to Login']")
		public WebElement returnToLoginButton;
  
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
	
	/**This method is used to login to Login page
	 * @throws IOException 
	 */
	
		public void loginToUrl(WebDriver driver) throws IOException
		{
		driver.manage().window().maximize();
		logger.info("Loginpage: loginToUrl: driver maximized");
			if(CommonUtils.waitForElement(driver,username))
			{
		username.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
		password.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		logger.info	("LoginPage: loginToUrl:username and Password entered");
		loginButton.click();
		logger.info("LoginPage: loginToUrl: loginButton clicked");
			
			
			}
			
		}
		
		}
