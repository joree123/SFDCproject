package pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import utils.BasePage;
import utils.CommonUtils;
import utils.FileUtilities;

public class MySettingsPage extends BasePage{
 
	public MySettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	}
	@FindBy(xpath="//a[@class='setupSection']/span[2]")
	public WebElement mySettingsText;
	
	@FindBy(css= "#PersonalInfo a.header.setupFolder")
	public WebElement personalButton;
	
	@FindBy(css= "a[id=LoginHistory_font]")
	public WebElement loginHistoryButton;
	
	@FindBy(xpath= "//h3[text()='Login History']")
	public WebElement loginHistoryText;
	
	@FindBy(css= "div.pShowMore a")
	public WebElement downloadLoginHistory;
	
	
	@FindBy(css= "#DisplayAndLayout a.header.setupFolder")
	public WebElement displayAndLayout;
	
	
	@FindBy(css= "a[id=CustomizeTabs_font]")
	public WebElement customizeTab;
	@FindBy(css= "select#p4")
	public WebElement customAppDropdown;
		
	@FindBy(css="select#duel_select_0" )
	public WebElement availableTabs;
	
	@FindBy(id="duel_select_1" )
	public WebElement selectedTabs;
	
	@FindBy(css="input.btn.primary" )
		public WebElement addButton;
	
	@FindBy(css="a#duel_select_0_left")
	public WebElement removeButton;
	
	@FindBy(css="input[name='save']")
	public WebElement saveButton;
	
	@FindBy(css="[id='EmailSetup'] a[class='header setupFolder']" )
	public WebElement emailLink;
	
	@FindBy(css="a[id='EmailSettings_font']" )
	public WebElement myEmailSettings;
	
	@FindBy(css= "input[id='sender_name']")
	public WebElement setEmailName;
	
	@FindBy(css= "input[id='sender_email']" )
	public WebElement setEmailAddress;
		
	@FindBy(css= "input#auto_bcc1" )
	public WebElement bccRadioButton;
	
	@FindBy(css= "input.btn.primary" )
	public WebElement saveEmailButton;
	
	@FindBy(css= "h1.noSecondHeader.pageType")
	public WebElement myEmailSettingsText;
	
	@FindBy(css="div.messageText" )
	public WebElement changeSettingMessage;
	
	@FindBy(css= "[id='CalendarAndReminders'] a.header.setupFolder" )
	public WebElement calendersAndReminders;
	
	@FindBy(css= "a[id='Reminders_font']" )
	public WebElement activityRemindersLink;
	
	@FindBy(xpath="//div[@id='summary0']//div[@class='subject']")
	public WebElement sampleEventText;
	@FindBy(id= "testbtn" )
	public WebElement testReminderButton;
	
	public void selectMySettingsOption(WebDriver driver) {
		UserMenuPage ump=new UserMenuPage(driver);
		if(ump.MySettings.isDisplayed()) {
			
		ump.MySettings.click();
		}
		
	}
	
	public boolean verifyDisplayOfMySettingsPage(WebDriver driver) {
	boolean isDisplayed=false;
	
		if(mySettingsText.isDisplayed()) {
		if(mySettingsText.getText().equalsIgnoreCase("My Settings")) {
			isDisplayed=true;
		}
	}
		return isDisplayed;
		
	}
	public boolean verifyDisplayOfLoginHistory(WebDriver driver) {
		boolean isDisplayed=false;
		personalButton.click();
		if(loginHistoryButton.isDisplayed())
		{
			loginHistoryButton.click();
			if(loginHistoryText.getText().equalsIgnoreCase("Login History")) {
				isDisplayed=true;
			}
		}
		return isDisplayed;
	}
	
	 public boolean isFileDownloaded(String downloadPath) {
		 boolean isDownloaded=false;
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().contains(".csv")) {
		          // File has been found, it can now be deleted:
		          
		          isDownloaded=true;
		          dirContents[i].deleteOnExit();
		          break;
		      }
		          }
		  return isDownloaded;
		      
		  }
	
	
	public boolean verifyDownloadOfLoginHistory(WebDriver driver) {
		boolean isDownloaded=false;
		if(verifyDisplayOfLoginHistory(driver)) {
			downloadLoginHistory.click();
			//check the download
					
			isDownloaded=isFileDownloaded("C:\\Users\\ashvi\\OneDrive\\Documents\\Downloads");
		}
		return isDownloaded;
		
	}
	public void selectSalesForceChatter(WebDriver driver)
	{
		if(CommonUtils.waitForElementToBeClickable(driver,customAppDropdown)) {			
			
			Select s=new Select(customAppDropdown);
			s.selectByVisibleText("Salesforce Chatter");
	}
	}
	/**This method is used to check display and layout link.
	 * While selecting available tabs we have to check the site otherwise test will fail.
	 * cannot repeat the test with same tab
	 * @param driver
	 * @return boolean
	 * @throws InterruptedException 
	 */
	public boolean verifyDisplayAndLayoutLink(WebDriver driver) {
		boolean isDisplayed=false;
		selectSalesForceChatter(driver);

		logger.info("MySettingsPage: verifyDisplayAndLayoutLink:SalesforceChatter is selected");
		
		if(CommonUtils.waitForElementToBeClickable(driver,availableTabs))
		{
		Select s1=new Select(availableTabs);
		s1.selectByVisibleText("Reports");
		addButton.click();
		logger.info("MySettingsPage: verifyDisplayAndLayoutLink:add button clicked");
		
		if(CommonUtils.waitForElementToBeClickable(driver,selectedTabs))
		{
			logger.info("MySettingsPage: selected tabs found");
		Select s2=new Select(selectedTabs);
		List<WebElement> ls=s2.getOptions();
		for(WebElement e:ls)
		{
		if(e.getText().contains("Reports"))
		{
			isDisplayed=true;
			
			removeButton.click();
			saveButton.click();
			break;
		}	
		}
		}
		}
		return isDisplayed;
	}
	
	public boolean verifyEmailLink(WebDriver driver) throws IOException {
		boolean isVerified=false;
		emailLink.click();
		myEmailSettings.click();
		setEmailName.sendKeys(FileUtilities.readPropertiesFile(FileConstants.USER_TESTDATA_FILE_PATH3, "name"));
		setEmailAddress.sendKeys(FileUtilities.readPropertiesFile(FileConstants.USER_TESTDATA_FILE_PATH3, "email"));
		bccRadioButton.click();
		saveEmailButton.click();
		while(CommonUtils.waitForElementToBeClickable(driver, myEmailSettingsText))
		{
			isVerified=true;
		}
		return isVerified;
	}
	
	public boolean verifyCalenderRemindersLink(WebDriver driver) {
		boolean isVerified=false;
		calendersAndReminders.click();
		activityRemindersLink.click();
		if(testReminderButton.isDisplayed()) {
			testReminderButton.click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> is=windows.iterator();
		String parentWindow=is.next();
		String childWindow=is.next();
		driver.switchTo().window(childWindow);
		if(sampleEventText.getText().contains("Sample Event")) {
			isVerified=true;
		}
		}
		return isVerified;
		
	}
	
}