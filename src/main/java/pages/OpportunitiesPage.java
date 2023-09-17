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

public class OpportunitiesPage extends BasePage
{
 public OpportunitiesPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 @FindBy(css= "a[title='Opportunities Tab']")
 public WebElement OpportunitiesLink;
 @FindBy(css= "h2.pageDescription")
 public WebElement homeText;
 @FindBy(css= "select#fcf")
 public WebElement OpportunitiesDropDown;
 @FindBy(css= "input[name='new']")
 public WebElement newButton;
 @FindBy(css= "input#opp3")
 public WebElement OpportunityName;
 @FindBy(css= "input#opp4")
 public WebElement OpportunityAccName;
 @FindBy(css= "img[title*='Account Name Lookup']")
 public WebElement accNameLookup;
 @FindBy(css= "frame[title='Search']")
 public WebElement searchFrame;
 @FindBy(css= "input[name='new']")
 public WebElement newSearchFrameButton;
 @FindBy(css= "frame[title='Results']")
 public WebElement resultsFrame;
 @FindBy(css= "td.pbButtonb input[name='save']")
 public WebElement saveResultsFrameButton;
 
 
 @FindBy(css= "input#opp9")
 public WebElement opCloseDate;
 @FindBy(css="select#opp6")
 public WebElement opSelectLeadSource;
 @FindBy(css= "input#opp10")
 public WebElement opNextStep;
 @FindBy(css= "select#opp11")
 public WebElement opSelectStage;
 @FindBy(css= "input#opp12")
 public WebElement opProbability ;
 @FindBy(css= "input#opp17")
 public WebElement opPrimaryCampaignSrc;
 
 @FindBy(css= "input[name='save']")
  public WebElement saveButton;
 @FindBy(css= "//h2[text()='Opportunity Detail']")
 public WebElement opportunityDetailText;
 @FindBy(xpath= "//a[text()='Opportunity Pipeline']")
 public WebElement opPipeLineLink;
 @FindBy(css= "h1.noSecondHeader.pageType")
 public WebElement opPipelineText;
 
 @FindBy(xpath= "//a[text()='Stuck Opportunities']")
 public WebElement opStuckLink;
 @FindBy(css= "h1.noSecondHeader.pageType")
 public WebElement stuckOpText;
 @FindBy(css= "select#quarter_q")
 public WebElement quarterlySummaryInterval;
 @FindBy(css= "select#open")
 public WebElement quarterlySummaryOpportunities;
 @FindBy(css= "h1.noSecondHeader.pageType")
 public WebElement opReportText;
 @FindBy(css= "input[value='Run Report']")
 public WebElement runReportButton;
 
 public boolean verifyDisplayOfOptyHomePage(WebDriver driver)
 {
	 boolean isDisplayed=false;
	 if(CommonUtils.waitForElementToBeVisible(driver, homeText))
	 {
		 isDisplayed=true;
	 }
	 return isDisplayed;
 }
 
 public boolean verifyOptyDropdownOptions(WebDriver driver)
 { 
	 boolean isVerified=false;
	 Select s=new Select(OpportunitiesDropDown);
	 List<WebElement> ls=s.getOptions();
	 String[] options= {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities",
			 "New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities",
			 "Won"};
	 for(int i=0;i<options.length;i++)
	 {
	 if(ls.get(i).getText().equalsIgnoreCase(options[i]))
	 {
		 isVerified=true;
	 }
	 else
	 {
		 isVerified=false;
	 }
	 
		 
	 }	 
	 return isVerified;	 	 
 }	
 public void sendAccountName(WebDriver driver)
 {
	 OpportunityAccName.sendKeys("account");
	 accNameLookup.click();
	 Set<String> s=driver.getWindowHandles();
	 Iterator<String> is=s.iterator();
	 String parentWin=is.next();
	 String childWin=is.next();
	 driver.switchTo().window(childWin);
	 CommonUtils.waitForElementToBeVisible(driver, searchFrame);
	 driver.switchTo().frame(searchFrame);
	 newSearchFrameButton.click();
	 logger.info("OpportunityPage: sendAccountName():Search button clicked");
	 driver.switchTo().defaultContent();
	 CommonUtils.waitForElementToBeVisible(driver, resultsFrame);
	 
	 driver.switchTo().frame(resultsFrame);
	 saveResultsFrameButton.click();
	 logger.info("OpportunityPage: sendAccountName():Save button clicked");
	 
	driver.switchTo().window(parentWin);
 }
 
 
 
 public void createNewOpportunity(WebDriver driver)
 {
	 OpportunityName.sendKeys("book");
	 sendAccountName(driver);
	
	 opCloseDate.sendKeys("09/09/2023");
	 opProbability.sendKeys("30");
	 Select sStage=new Select(opSelectStage);
	 sStage.selectByIndex(1);
	 Select sLead=new Select(opSelectLeadSource);
	 sLead.selectByIndex(1);
	 //opPrimaryCampaignSrc.sendKeys("fdgdg");
	 saveButton.click();
 }
 public boolean verifyDisplayOfOpportunityDetails(WebDriver driver)
 {
	 boolean isDisplayed=false;
	 if(CommonUtils.waitForElementToBeVisible(driver, opportunityDetailText))
	 {
		 isDisplayed=true;
	 }
	 
	 return isDisplayed;
 }
 
	public boolean verifyDisplayOfReportsDisplayPage(WebDriver driver)	
	{
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeVisible(driver,opPipelineText ))
		{
			isDisplayed=true;
		}
		return isDisplayed;
	}
	
	public boolean verifyDisplayOfStuckOpPage(WebDriver driver)
	{
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeVisible(driver,stuckOpText ))
		{
			isDisplayed=true;
		}
		return isDisplayed;
		
	}
	public void selectInterval(String s)
	{
		Select s1=new Select(quarterlySummaryInterval);
		s1.selectByVisibleText(s);
		
	}
	public void selectOpportunities(String s)
	{
		Select s2=new Select(quarterlySummaryOpportunities);
		s2.selectByVisibleText(s);
		runReportButton.click();
	}
	public boolean verifyDisplayOfSelectedReportPage(WebDriver driver)
	{
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeVisible(driver,opReportText ))
		{
			isDisplayed=true;
		}
		return isDisplayed;
	}
	
 }
