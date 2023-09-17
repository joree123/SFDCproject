package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.BasePage;
import utils.CommonUtils;

public class ContactsPage extends BasePage{
public ContactsPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(css= "a[title='Contacts Tab']")
public WebElement contactsTab;

@FindBy(css= "h1.pageType")
public WebElement contactText;

@FindBy(css= "input[name='new']")
public WebElement newButton;

@FindBy(css= "h2.pageDescription")
public WebElement newContactText;

@FindBy(css= "input[id='name_lastcon2']")
public WebElement lastNameInput;

@FindBy(css= "input#con4")
public WebElement accountNameInput;

@FindBy(css= "a#con4_lkwgt")
public WebElement lookUpButton;



@FindBy (css= "td.pbButton input[name='save']")
public WebElement saveButtonInLookUp;

@FindBy(css= "input[title='Save']")
public WebElement saveContactsButton;
//@FindBy(css="td#topButtonRow input[name='save_new']")
//public WebElement saveAndNewButton;
@FindBy(xpath= "//tr[contains(@class,'dataRow')]/th/a")
public List<WebElement>  displayOfContactNames;

@FindBy(css= "td.pbTitle h3")
public WebElement RecentContactsText;

@FindBy(css= "h2.topName")
public WebElement displayOfContactName;

@FindBy(css= "select#hotlist_mode")
public WebElement selectRecentlyCreated;

@FindBy(css= "select#fcf")
public WebElement selectContacts;
@FindBy(css= "input[value*='Go!']")
public WebElement goButton;



@FindBy(css= "th.dataCell  ")
public WebElement contactUnderName;

@FindBy(css= "input[value='Save & New']")
public WebElement saveAndNewButton;

public void clickContactTab()
{
	contactsTab.click();
	
}
public boolean verifyDisplayOfContactsHomePage(WebDriver driver)
{
	boolean isDisplayed=false;
	if(CommonUtils.waitForElementToBeVisible(driver, contactText))
	{
		isDisplayed=true;
	}
	return isDisplayed;
}

public void clickNewContactButton()
{
	newButton.click();
}

public boolean verifyDisplayOfNewContactPage(WebDriver driver)
{
	boolean isDisplayed=false;
	if(CommonUtils.waitForElementToBeVisible(driver, newContactText)) {
		isDisplayed=true;
	}
	return isDisplayed;
}
public void enterLastName() {
	lastNameInput.sendKeys("Devan");
}
public void enterAccountName(WebDriver driver)
{
	accountNameInput.sendKeys("primary");
	lookUpButton.click();
	logger.info("ContactPage:enterAccountName():lookupButton clicked");
	Set<String> s=driver.getWindowHandles();
	Iterator<String> is=s.iterator();
	String parentWindow=is.next();
	String childWindow=is.next();
	driver.switchTo().window(childWindow);
	logger.info("ContactPage:enterAccountName():switched to new window");
	if(CommonUtils.waitForElementToBeClickable(driver, newButton)) {
	newButton.click();
	logger.info("ContactPage:enterAccountName():newButton clicked");
	if(CommonUtils.waitForElementToBeClickable(driver, saveButtonInLookUp))
	{saveButtonInLookUp.click();
	logger.info("ContactPage:enterAccountName():savelookupButton clicked");
	
	
	}
	}
	driver.switchTo().window(parentWindow);
}
public void clickSaveButton()
{
	saveContactsButton.click();
	logger.info("ContactPage:clickSaveButton():save contacts Button clicked");
}

public boolean verifyCreatingNewContact(WebDriver driver)
{
	boolean isDisplayed=false;
	CommonUtils.waitForElementToBeClickable(driver, displayOfContactName); 
		if(driver.getTitle().contains("Devan"))
		{
			isDisplayed=true;
		}
		
	
	return isDisplayed;
}
public void selectRecentlyCreatedfromDropdown()
{
	Select s1=new Select(selectRecentlyCreated);
	s1.selectByVisibleText("Recently Created");
	
	
}
public boolean verifyDisplayOfRecentlyCreatedContact(WebDriver driver)
{
	boolean isDisplayed=false;
	if(CommonUtils.waitForElementToBeVisible(driver, RecentContactsText))
	{
		if(RecentContactsText.getText().equalsIgnoreCase("Recent Contacts"))
		{
			isDisplayed=true;
		}
		return isDisplayed;
	}
	
	
	return isDisplayed;
}
public String clickOnAContactName(WebDriver driver)
{
	CommonUtils.waitForElementToBeVisible(driver, RecentContactsText);
	String contact=displayOfContactNames.get(0).getText();
	displayOfContactNames.get(0).click();
	
	return contact;
	
}
public boolean verifyContactInfoOfContactName(WebDriver driver,String contact) {
	boolean isVerified=false;
	CommonUtils.waitForElementToBeVisible(driver, displayOfContactName);
	if(displayOfContactName.getText().equalsIgnoreCase(contact))
	{
		isVerified=true;
	}
	
	return isVerified;
}
 public void selectMyContacts()
 {
	 Select s2=new Select(selectContacts);
	 s2.selectByVisibleText("My Contacts");
	 
	 goButton.click();
 }
public boolean verifyDisplayOfMyContactsView(WebDriver driver)
{
	boolean isDisplayed=false;
	//CommonUtils.waitForElementToBeClickable(driver, newContactButton);
	
		if(driver.getTitle().equalsIgnoreCase("Contacts ~ Salesforce - Developer Edition"))
		{
			isDisplayed=true;
		}
	
	return isDisplayed;
}
public void createNewContact(WebDriver driver)
{
	newButton.click();
	verifyDisplayOfNewContactPage(driver);
	enterLastName();
	enterAccountName(driver);
	saveAndNewButton.click();
	
	
}

}