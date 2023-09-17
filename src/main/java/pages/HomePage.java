package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(css= "div[id='p:f:j_id25:j_id61:28:j_id64'] a")
	public WebElement eightPMLink;
	
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
	@FindBy(css="div.hourPicker")
	public WebElement endTimeDropDown;
	@FindBy(css= "input[title='Save']")
	public WebElement saveButton;
	@FindBy(xpath= "//td[text()='Subject']/following-sibling::td")
	public WebElement subjectDisplayWindow;
	@FindBy(xpath= "//td[text()='Start']/following-sibling::td")
	public WebElement startTimeDisplayWindow;
	@FindBy(xpath= "//td[text()='End']/following-sibling::td")
	public WebElement endTimeDisplayWindow;
	
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
}