package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;
import utils.CommonUtils;

public class AccountsReportPage extends BasePage{
	public AccountsReportPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	@FindBy(xpath= "//div[@class='lbBody']/ul/li[2]/a")
	 public WebElement accountsLinkGreaterThan30Days;
	 @FindBy(css= "input#ext-gen20")
	 public WebElement dateFieldDropDown;
	 @FindBy(xpath= "//div[@class='x-combo-list-item'][2]")
	 public WebElement createDateOPtion;
	 @FindBy(css= "input#ext-comp-1042")
	 public WebElement fromDateField;
	 @FindBy(css= "input#ext-comp-1045")
	 public WebElement toDateField;
	 @FindBy(css= "div.x-grid3-body")
	 public WebElement ListOfAccounts;
	 
	
	 @FindBy(css= "button#ext-gen49" )
	 public WebElement saveAccountReportButton;
	 @FindBy(css= "input#saveReportDlg_reportNameField")
	 public WebElement savedReportName;
	 @FindBy(css= "input#saveReportDlg_DeveloperName")
	 public WebElement savedReportUniqueName;
	 
	 @FindBy(xpath= "//button[text()='Save and Run Report']")
	 public WebElement SaveAndRunPopupWinButton;
	 @FindBy(xpath= "//table[@id='dlgSaveReport']")
	 public WebElement saveReportPopupWinButton;
	 
	 @FindBy(css="h1.noSecondHeader.pageType")
	 public WebElement headerReportName;
	 
	
	 public void createAccountReport(WebDriver driver)
	{
		if(CommonUtils.waitForElementToBeClickable(driver,accountsLinkGreaterThan30Days )){
		accountsLinkGreaterThan30Days.click();
		 }
	}
	
	public boolean verifyDisplayofUnsavedReport(WebDriver driver)
	{
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeClickable(driver, dateFieldDropDown))
		{
			String title=driver.getTitle();
			if(title.equalsIgnoreCase("Unsaved Report ~ Salesforce - Developer Edition"))
			{
				isDisplayed=true;
				logger.info("AccountsReportpage: verifyDisplayofUnsavedReport (): verified display of unsaved report page  ");
			}
		}
		return isDisplayed;
		
	}
	public static String getDateToday()
	{
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate=sd.format(date);
		return formattedDate;
	}
	public void selectReportOptions()
	{
		dateFieldDropDown.click();
		createDateOPtion.click();
		fromDateField.sendKeys(getDateToday());
		toDateField.clear();
		toDateField.sendKeys(getDateToday());
		
	}
	public boolean verifyDisplayOfListOfAccounts(WebDriver driver)
	{
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeVisible(driver, ListOfAccounts))
			{
		isDisplayed=true;
			}
		return isDisplayed;
	}
	public void saveReport(WebDriver driver) throws InterruptedException
	{
		saveAccountReportButton.click();
		if(CommonUtils.waitForElementToBeClickable(driver, savedReportName)) {
		savedReportName.clear();	
		savedReportName.sendKeys("record3");
		logger.info("saveReport(): report name entered");
		savedReportUniqueName.clear();
		savedReportUniqueName.sendKeys("book3");
		logger.info("saveReport(): Report unique name entered");
		Thread.sleep(6000);
		if(CommonUtils.waitForElementToBeClickable(driver, SaveAndRunPopupWinButton))
		{
			saveReportPopupWinButton.click();
		logger.info("saveReport(): Save  button clicked");
		}
		}
	}
	public boolean verifyDisplayOfReportPage(WebDriver driver) throws InterruptedException
	{
		boolean isDisplayed=false;
		Thread.sleep(5000);
		
		
			if(driver.getTitle().contains("record3")) {
			isDisplayed=true;
		
		}	
		return isDisplayed;
	}
	
	
	
}
