package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtilities;

public class AccountsPage {
 public AccountsPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 @FindBy(css= "li#Account_Tab a")
 public WebElement accountsLink;
 
 @FindBy(id ="createNewButton")
 public WebElement createNewButton;
 @FindBy(css ="a.accountMru.menuButtonMenuLink")
 public WebElement newAccountOption ;
 
 @FindBy(css= "h2.pageDescription")
 public WebElement newAccountText;
 
 @FindBy(css= "input[class='btn'][title='New']")
 public WebElement createNewAccountButton;
 
 @FindBy(css= "input#acc2")
 public WebElement accountNameInputBox;
 
 @FindBy(css= "select[id='acc6']")
 public WebElement selectAccountType;
 
 @FindBy(css= "select[id='00NHu00000PEMti']")
 public WebElement selectCustomerPriority;
 
 @FindBy(css= "#topButtonRow input[name='save']")
 public WebElement saveAccountButon;
 @FindBy(css="h2.topName")
 public WebElement newAccountOwnerName;
 
 @FindBy(xpath= "//a[text()='Merge Accounts']")
 public WebElement mergeAccountsLink;
 @FindBy(css= "input#srch" )
 public WebElement findAccountInputBox;
 @FindBy(css= "input[value='Find Accounts']")
 public WebElement findAccountsButton;
 @FindBy(css= "table.list")
 public WebElement foundAccounts;
 @FindBy(css= "table.list tr[class*='dataRow']")
 public List<WebElement> foundAccountsList;
 @FindBy(css= "table.list input")
 public List<WebElement> selectAccountMergeButtons;
 @FindBy(xpath= "//div[@class='pbTopButtons']/input[@name='goNext']")
 public WebElement nextButton;
 @FindBy(xpath= "//div[@class='pbTopButtons']//input[@title='Merge']")
 public WebElement mergeAccountsButton;
 @FindBy(css= "tr.dataRow.even.first th a")
 public WebElement mergedAccountName;
 
 
 
 public void clickAccountsLink() {
	 if(accountsLink.isDisplayed()) {
	 accountsLink.click();
 }
	 
 }
 
 public boolean verifyDisplayOfAccountsPage(WebDriver driver)
 {
	 boolean isDisplayed=false;
	 String actualTitle=driver.getTitle();
	 
	 if(actualTitle.equalsIgnoreCase("Accounts: Home ~ Salesforce - Developer Edition"))
	 {
		 isDisplayed=true;
	 }
	 return isDisplayed;
 }
 
 public void createNewAccount() throws IOException
 {
	 newAccountOption.click();
	 if(newAccountText.isDisplayed())
	 {
		 accountNameInputBox.sendKeys(FileUtilities.readPropertiesFile(FileConstants.USER_TESTDATA_FILE_PATH3, "accountOwnerName1"));
		 Select s1=new Select(selectAccountType);
		 s1.selectByVisibleText("Technology Partner");
		 Select s2=new Select(selectCustomerPriority);
		 s2.selectByVisibleText("High");
		 saveAccountButon.click();
	 }
	 
 }
 public boolean verifyDisplayOfNewAccountPage(WebDriver driver) throws IOException
 {
	boolean isDisplayed=false;
	if(CommonUtils.waitForElementToBeClickable(driver, newAccountOwnerName))
	{
		String expectedName=FileUtilities.readPropertiesFile(FileConstants.USER_TESTDATA_FILE_PATH3, "accountOwnerName1");
	if(newAccountOwnerName.getText().equals(expectedName))
	{
		isDisplayed=true;
	}
	
	}
	return isDisplayed;
	
 }
 public void selectAccountsToMerge(WebDriver driver)
 {
	if(CommonUtils.waitForElementToBeClickable(driver, findAccountInputBox))
	{
		findAccountInputBox.sendKeys("suprit");
		findAccountsButton.click();
		if(CommonUtils.waitForElementToBeClickable(driver,foundAccounts)) {
			if(foundAccountsList.size()>1)
			{
				for(int i=0;i<3;i++) {
					if(!selectAccountMergeButtons.get(i).isSelected())	
					{
				selectAccountMergeButtons.get(i).click();
					}
				}
				nextButton.click();
				
			}
		}
	}
 }
 public void mergeAccounts(WebDriver driver) {
	 if(CommonUtils.waitForElementToBeClickable(driver, mergeAccountsButton)) {
		 mergeAccountsButton.click();
		 driver.switchTo().alert().accept();
	 }
 }
 public boolean verifyDisplayOfNewMegedAccounts(WebDriver driver)
 {
	 boolean isDisplayed=false;
	 if(CommonUtils.waitForElementToBeClickable(driver, mergedAccountName))
	 {
		 isDisplayed=true;
	 }
	return isDisplayed; 
 }
 
}