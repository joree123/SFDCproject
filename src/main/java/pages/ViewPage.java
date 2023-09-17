package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import utils.BasePage;
import utils.CommonUtils;
import utils.FileUtilities;

public class ViewPage extends BasePage{
	public ViewPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
 @FindBy(xpath= "//a[text()='Create New View']")
 public WebElement createNewViewLink;
	
 @FindBy(css= "input#fname")
 public WebElement viewNameInput;	
 
 @FindBy(css= "input#devname")
 public WebElement uniqueViewNameInput;

 @FindBy(xpath= "//div[@class='pbHeader']// input[1]")
 public WebElement saveViewButton;
 
 @FindBy(css= "select.title")
 public WebElement showNewViewInList;
 
 @FindBy(css= "select#fcf")
 public WebElement accountViewList;
 
 @FindBy(xpath= "//a[text()='Edit']")
 public WebElement editViewLink;
 
 @FindBy(css= "input#fname")
 public WebElement changeViewName;
 
 @FindBy(css= "select#fcol1")
 public WebElement selectFilter;
 @FindBy(css= "select#fop1")
 public WebElement selectOperator;
 @FindBy(css= "input#fval1" )
 public WebElement selectValue;
 @FindBy(xpath= "//div[@class='pbHeader']// input[1]")
 public WebElement saveChangedViewButton; 
 
 @FindBy(css= "div.errorMsg strong")
 public WebElement errorMessage;
 
 
@FindBy(xpath= "//input[@value='Cancel']")
 public WebElement cancelViewButton;
 
 public void createNewView(WebDriver driver) throws IOException
 {
	 if(CommonUtils.waitForElementToBeClickable(driver, createNewViewLink)) {
	 createNewViewLink.click();
	 if(CommonUtils.waitForElementToBeClickable(driver, viewNameInput)) {
  String viewName=FileUtilities.readPropertiesFile(FileConstants.USER_TESTDATA_FILE_PATH3, "viewName1");
  String viewUniqueName=FileUtilities.readPropertiesFile(FileConstants.USER_TESTDATA_FILE_PATH3, "viewUniqueName1");	
  viewNameInput.sendKeys(viewName);
  //change existing unique view name in file
  uniqueViewNameInput.sendKeys(viewUniqueName);
  saveViewButton.click();
	 }
	 }
 }
 
 public boolean verifyDisplayOfNewView(WebDriver driver) throws IOException
 {
	 boolean isDisplayed=false;
	if(CommonUtils.waitForElementToBeClickable(driver, showNewViewInList))
	{
	Select s=new Select(showNewViewInList);
	List<WebElement> options=s.getOptions();
	logger.info("got all view options");
	System.out.println(options);
	String viewName=FileUtilities.readPropertiesFile(FileConstants.USER_TESTDATA_FILE_PATH3, "viewName1");
	for(int i=0;i<options.size();i++)
	{
		if(options.get(i).getText().equalsIgnoreCase(viewName))
	{
			isDisplayed=true;	
			break;
	}
	}	
	}
	return isDisplayed;
 }
 

 
 public boolean checkErrorMessageforViewname(WebDriver driver)
 {
 boolean isChecked=false;
	 if(CommonUtils.waitForElementToBeClickable(driver, uniqueViewNameInput))
	 {
		 uniqueViewNameInput.sendKeys("EFGH");
		 saveViewButton.click();
		 CommonUtils.waitForElementToBeVisible(driver, errorMessage);
			
		 if(errorMessage.getText().contains("Error")) 
		 {
			 isChecked=true;
		 }
		 
		 
	 }
	 
	return isChecked; 
	 
 }
 public void checkCancelViewButton(WebDriver driver)
 {
	 if(CommonUtils.waitForElementToBeClickable(driver, viewNameInput))
	 {
		 viewNameInput.sendKeys("ASDF");
		 uniqueViewNameInput.sendKeys("EFGH");
		 cancelViewButton.click();
	 } 
 }
   
}