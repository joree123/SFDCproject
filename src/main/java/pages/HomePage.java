package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class HomePage {
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath= "//a[text()='Home']")
	public WebElement HomeTab;
	@FindBy(xpath= "//h1[@class='currentStatusUserName']/a")
	public WebElement firstAndLastNameLink;
	
	@FindBy(css= "span.pageDescription a")
	public WebElement currentDateLink;
	
	@FindBy(css= "h1.pageType")
	public WebElement calenderText;
	
	@FindBy(css= "div[id='p:f:j_id25:j_id61:28:j_id64'] a")
	public WebElement eightPMLink;
	
	@FindBy(css="h2.pageDescription")
	public WebElement calenderNewEventText;
	@FindBy(css= "a[title='Combo (New Window)']")
	public WebElement subjectComboIcon;
	@FindBy(css= "li.listItem4 a")
	public WebElement otherComboBoxLink;
	@FindBy(css= "input#evt5")
	public WebElement subjectInputBox;
	@FindBy(css= "input#EndDateTime")
	public WebElement endInputDateField;
	@FindBy(css= "input#EndDateTime_time")
	public WebElement endInputTimeField;
	@FindBy(id ="simpleTimePicker")
	public WebElement endTimeDropDown;
	@FindBy(css= "div#simpleTimePicker div")
	public List<WebElement> endTimeOptions;
	
	@FindBy(css= "input[title='Save']")
	public WebElement saveButton;
	@FindBy(linkText="Other")
	public WebElement otherLink;
	
	@FindBy(xpath= "//td[text()='Subject']/following-sibling::td")
	public WebElement subjectDisplayWindow;
	@FindBy(xpath= "//td[text()='Start']/following-sibling::td")
	public WebElement startTimeDisplay;
	@FindBy(xpath= "//td[text()='End']/following-sibling::td")
	public WebElement endTimeDisplay;
	
	@FindBy(id= "IsRecurrence")
	public WebElement recurrenceCheckBox;
	
	@FindBy(xpath= "//label[text()='Frequency']")
	public WebElement frequencyText;
	@FindBy(xpath= "//label[text()='Recurrence Start']")
	public WebElement recurrenceStartText;
	@FindBy(xpath= "//label[text()='Recurrence End']")
	public WebElement recurrenceEndText;
	
	@FindBy(id= "rectypeftw")
	public WebElement weeklyRadioButton;
	@FindBy(id= "wi")
	public WebElement recursEveryTextBox;
	
	@FindBy(css= "div#w div:nth-child(2) label")
	public List<WebElement> daysOfTheWeek;
	@FindBy(css= "div#w div:nth-child(2) input")
	public List<WebElement> daysOfTheWeekCheckboxes;
	@FindBy(css = "div[id='p:f:j_id25:j_id61:32:j_id64'] a")
	WebElement fourPMLink;
	
	
	public boolean verifyDisplayOfHomePage(WebDriver driver)
	{
		boolean isDisplayed=false;
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Salesforce - Developer Edition"))
				{
			isDisplayed=true;
				}
		return isDisplayed;
	}
	
	public boolean verifyDisplayOfFirstAndLastNameLink(WebDriver driver)
	{
		boolean isDisplayed=false;
		if(firstAndLastNameLink.isDisplayed())
		{
			isDisplayed=true;
		}
		
		return isDisplayed;
	}
	public boolean verifyDisplayOfMyProfilePage(WebDriver driver)
	{
		boolean isDisplayed=false;
		String title=driver.getTitle();
		UserMenuPage ump=new UserMenuPage(driver);
		ump.userMenu.click();
		ump.MyProfile.click();
		String title1=driver.getTitle();
		if(title.equals(title1))
		{
			isDisplayed=true;
		}
		return isDisplayed;
	}
	
	public boolean verifyLastNameChangedOnUserMenu(WebDriver driver,String sname)
	{
		boolean isVerified=false;
		UserMenuPage ump=new UserMenuPage(driver);
		if(ump.userMenu.getText().contains(sname))
				{
			isVerified=true;
				}
		return isVerified;
	}
	
	public boolean verifyDisplayOfCurrentDate(WebDriver driver)
	{
		boolean isDisplayed=false;
		String actualDate=currentDateLink.getText();
		Date date=new Date();
		SimpleDateFormat sd= new SimpleDateFormat("EEEE MMMM d, YYYY");
		String expectedDate=sd.format(date);
		if(actualDate.equals(expectedDate))
		{
			isDisplayed=true;
			
		}
		return isDisplayed;
	}
	
	public boolean verifyDisplayOfCalenderPage(WebDriver driver)
	{
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeVisible(driver, calenderText))
		{
			isDisplayed=true;
		}
		return isDisplayed;
	}
	
	
		
	public boolean verifyDisplayOfCalenderNewEvent(WebDriver driver)
	    {
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeVisible(driver, calenderNewEventText))
		{
			isDisplayed=true;
		}
		return isDisplayed;
		
	}
	
	public boolean verifyDisplayOfComboBoxPopup(WebDriver driver)
	{
		boolean isVerified=false;
		Set<String> set=driver.getWindowHandles();
		Iterator<String> is=set.iterator();
		String parentWindow=is.next();
		String childWindow=is.next();
		driver.switchTo().window(childWindow);
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("ComboBox"))
		{
			isVerified=true;
		}
		return isVerified;
	}
	public void selectOthersFromComboBox()
	{
		otherComboBoxLink.click();
	}
	 
	public boolean verifyClosingOfComboBox(WebDriver driver)
	{
		boolean isVerified=false;
		String currentPageTitle=driver.getTitle();
		if(currentPageTitle.equalsIgnoreCase("Calendar: New Event ~ Salesforce - Developer Edition"))
		{
			isVerified=true;
		}
		return isVerified;
	}
	
	public boolean verifyDisplayofEndTimeDropDown(WebDriver driver)
	{
		boolean  isDisplayed=false;
		if(endTimeDropDown.isDisplayed())
		{
			isDisplayed=true;
		}
		return isDisplayed;
	}
	
	public void enterTimeToEndTimeField(String s)
	{
		for(WebElement e:endTimeOptions)
		{
			if(e.getText().equals(s))
			{
				e.click();
			}
		
	}
	
	}
	
	
	public boolean verifyDisplayOfOthersInTimeSlot(WebDriver driver, String startTime, String endTime)
	{
		// TODO Auto-generated method stub
boolean isVerified=false;
		
		otherLink.click();
		String sTime=startTimeDisplay.getText();
		String eTime=endTimeDisplay.getText();
		if(CommonUtils.waitForElementToBeVisible(driver, startTimeDisplay)) {
				
		if((sTime.contains(startTime)) && (eTime.contains(endTime)))
		{
			isVerified=true;
		}
		}
		return isVerified;
		
	}

	public boolean verifyDisplayOfRecurrenceItems(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean isDisplayed=false;
			if(recurrenceCheckBox.isSelected())
				{
				if((recurrenceStartText.isDisplayed())&& (frequencyText.isDisplayed())&& (recurrenceEndText.isDisplayed()))
				{
					isDisplayed=true;
				}
				}
			return isDisplayed;
				
			}

	

	public boolean verifyDisplayOfSelectedWeeklyButton(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean isDisplayed=false;
		if(CommonUtils.waitForElementToBeClickable(driver, recursEveryTextBox))
		{
			if(weeklyRadioButton.isSelected())
			{
				isDisplayed=true;
			}
		}
		return isDisplayed;
		
	}

	public boolean verifyDisplayOfRecursEverySection(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean isVerified=false;
		if(recursEveryTextBox.getAttribute("value").equalsIgnoreCase("1")) {
			isVerified=true;
		}
		return isVerified;
	}

	public boolean verifyDisplayOfCurrentDay(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean isVerified=false;
		for(int i=0;i<daysOfTheWeek.size();i++)
		{
			if(daysOfTheWeekCheckboxes.get(i).isSelected())
			{
				String day=daysOfTheWeek.get(i).getText();
				SimpleDateFormat sd=new SimpleDateFormat("EEEE");
				String today=sd.format(new Date());
				if(day.equals(today))
				{
					isVerified=true;
				}
			}
		}
		
		return isVerified;
	}

	public void enterEndDate() throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-dd");
		String fDate=sd.format(new Date());
			
		LocalDate ld=LocalDate.parse(fDate);
		LocalDate ld1=ld.plusWeeks(2);
		Date eDate = Date.from(ld1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat sd1=new SimpleDateFormat("M/d/YYYY");
		String endDate=sd1.format(eDate);
		endInputDateField.clear();
		endInputDateField.sendKeys(endDate);
		
	}

	public boolean verifyDisplayOfMonthViewPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}
				

	
}