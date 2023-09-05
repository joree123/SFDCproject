package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.LoginPage;
import testComponents.BaseTest;
import utils.FileUtilities;


public class LoginTest extends BaseTest {
	
	@Test
	public void loginTestTC01() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get("https://login.salesforce.com");
		lp.username.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		lp.password.sendKeys(FileUtilities.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		lp.loginButton.click();
		
		
	}
			
			
		
	
			
		}
		
		


