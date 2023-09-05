package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import constants.FileConstants;
import utils.BasePage;
import utils.CommonUtils;
import utils.FileUtilities;

/**
 * This page contains all the required page object elements and methods of
 * usermenu page
 * 
 * @author Joree
 * @version v1.0
 */
public class UserMenuPage extends BasePage {

	public UserMenuPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userNavButton")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement MyProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement MySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement DevelopersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement Logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement Userprofilepagenamedisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(css= "iframe.cke_wysiwyg_frame.cke_reset")
	public WebElement postIFrame;
	
	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;



	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditemtextadditional']")
	public WebElement enteredPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;
	
	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;
	
	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	private boolean profilePageLastNameChanged;

	/**
	 * This function can be called to select option from user menu options
	 * 
	 * @param driver  Webdriver instance has to be passed
	 * @param sOption Option value eg: "My Profile"
	 * @return {boolean} true if given option is selected else false
	 */
	
	public boolean selectUserMenuOption(WebDriver driver,String sOption) {
	boolean isOptionSelected=false;
	if(userMenu.isDisplayed())
		{
			userMenu.click();
		}
		WebElement menuItem=driver.findElement(By.xpath("//a[text()='"+sOption+"']"));
		if(menuItem.isDisplayed())
		{
			menuItem.click();
			isOptionSelected=true;
		}
		return isOptionSelected;
	}
	
	
	public boolean verifyUserMenuItems(WebDriver driver) throws IOException
	{ 
		boolean verifyItems=false;
		logger.info("UserMenupage:verifyUsermenuitems(): verifying user menu items started");
		String[] expectedUserMenuOptions=(FileUtilities.readPropertiesFile
				(FileConstants.USER_MENU_TESTDATA_FILE_PATH,"usermenu.items")).split(",");
		for(int i=0;i<expectedUserMenuOptions.length;i++)
		{
			String actualOption=userMenuOptions.get(i).getText();
			if(actualOption.equals(expectedUserMenuOptions[i])) {
				verifyItems=true;
			}
			else {
				verifyItems=false;
				logger.warn("UserMenupage:verifyUsermenuitems(): Menu Items failed to match the list of usermenu");
				break;
			}
		}
			return verifyItems;
		
	}

	public boolean selectMyProfileOption(WebDriver driver) {
		boolean selectMyProfile=false;
		if(MyProfile.isDisplayed()) {
			MyProfile.click();
			logger.info("UserMenuPage:selectmyProfileOption():My profile option is selected");
			selectMyProfile=true;
		}
		return selectMyProfile;
	}
	
	public boolean verifyProfilePageDisplayed(WebDriver driver) {
		boolean isDisplayed=false;
		if(profilePage.isDisplayed())
		{
			isDisplayed=true;
			logger.info("UserMenuPage:verifyProfilePageDisplayed():Profile page is displayed" );
		}
		return isDisplayed;
	}
		
	public void selectEditContactButton(WebDriver driver) {
		
		if(editContactButton.isEnabled())
		{
			editContactButton.click();
		}
		}
	   
	public boolean isDisplayedEditProfilePopUp(WebDriver driver) {
		boolean isDisplayed=false;
		CommonUtils.waitForElement(driver,iframeAboutTab );
		if(iframeAboutTab.isDisplayed()) {
			driver.switchTo().frame(iframeAboutTab);
			if(Abouttab.isDisplayed() && contactTab.isDisplayed())
			{
				isDisplayed=true;
				logger.info("UserMenuPage: isDisplayedEditProfilePopup():"
						+ "Edit profile window with About and Contact tab is displayed ");
			}
		}
			return isDisplayed;
		
	}
	
	 public boolean verifyProfilePageLastNameChanged(WebDriver driver,String sLastName) {
		 boolean isVerified=false;
		 if(Abouttab.isDisplayed()) {
		logger.info("UserMenuPage:verifyProfilePageLastNamechanged():About tab is clicked")	;	 
		 Abouttab.click();
		 Abouttablastname.clear();
		 Abouttablastname.sendKeys(sLastName);
		 logger.info("UserMenuPage:verifyProfilePageLastNamechanged():changed last name entered");
		 saveAllButton.click();
		 
		 }
		 driver.switchTo().defaultContent();
		 if(Userprofilepagenamedisplay.isDisplayed())
		 {
			 if(Userprofilepagenamedisplay.getText().contains(sLastName)) {
				 isVerified=true;
				 logger.info("UserMenuPage:verifyProfilePageLastNamechanged():last name changed");
			 }
		 }
		 return isVerified;
	 }
	public boolean verifyCreatePost(WebDriver driver,String sMessage)
	{
	boolean isPostCreated=false;	
	
	if(postLink.isDisplayed())
	{
		postLink.click();
		driver.switchTo().frame(postIFrame);
		postTextArea.sendKeys(sMessage);
		driver.switchTo().defaultContent();
		shareButton.click();
		CommonUtils.waitForElementToDisappear(driver, shareButton);

		isPostCreated=true;		
		
		
	}
	return isPostCreated;
	}
public boolean verifyFileUpload( WebDriver driver,String sFilepath) {
	boolean isUploaded=false;
	if(filelink.isDisplayed()) {
		filelink.click();
		if(CommonUtils.waitForElement(driver, Uploadfile)) {
		Uploadfile.click();
		}
		if(CommonUtils.waitForElement(driver, Fileopen)) {
			
		Fileopen.sendKeys(sFilepath);
		shareButton.click();
		}
	}
		if(CommonUtils.waitForElementToDisappear(driver,cancelUpload ))
		{
			if(verifyFilePostElement.isDisplayed())
			{
				isUploaded=true;
			}
		}
		return isUploaded;
	
}

public void clickOnUpdatePhotoButton(WebDriver driver) {
	
	CommonUtils.moveMouseToElement(driver,moderatorButton );
	if(updateButton.isDisplayed()) {
		updateButton.click();
	}
}
	
public boolean verifyPhotoUpload(WebDriver driver,String sImageFilePath) {
	boolean isPhotoUploaded=false;
	clickOnUpdatePhotoButton(driver);
	if(photoUploadIframe.isDisplayed()) {
		driver.switchTo().frame(photoUploadIframe);
		if(CommonUtils.waitForElement(driver, uploadphoto))
		{
			uploadphoto.sendKeys(sImageFilePath);
			photoSaveButton.click();
		}
			
	}
	
	if((CommonUtils.waitForElementToDisappear(driver, spinnerIcon)) 
			&& (CommonUtils.waitForElement(driver, photoSaveButton2)))
			{
		photoSaveButton2.click();
			}
	driver.switchTo().parentFrame();
	isPhotoUploaded=true;
	return isPhotoUploaded;
}
	
}










