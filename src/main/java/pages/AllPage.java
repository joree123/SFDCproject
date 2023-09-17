package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;

public class AllPage {
	public AllPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(css= "li#AllTab_Tab a")
public WebElement allTab;

@FindBy(css= "input.btnImportant")
public WebElement customizeMyTabLink;
@FindBy(css= "select#duel_select_0")
public WebElement selectAvailableTabs;
@FindBy(css= "select#duel_select_1")
public WebElement selectSelectedTabs;
@FindBy(css= "a#duel_select_0_left")
public WebElement removeTabButton;
@FindBy(css= "input[title='Save']")
public WebElement saveTabButton;

@FindBy(css= "ul#tabBar li")
public List<WebElement> tabsInTabBar;

@FindBy(css= "select#p1")
public WebElement viewTabsDropDown;

public boolean verifyDisplayOfAllTabsPage(WebDriver driver)
{
	boolean isDisplayed=false;
	String title=driver.getTitle();
	if(title.equalsIgnoreCase("All Tabs ~ Salesforce - Developer Edition"))
	{
		isDisplayed=true;
	}
	return isDisplayed;
}
public boolean verifyDisplayOfCustomizeMyTabPage(WebDriver driver)
{
	boolean isDisplayed=false;
	String title=driver.getTitle();
	if(title.equalsIgnoreCase("Customize My Tabs ~ Salesforce - Developer Edition"))
	{
		isDisplayed=true;
	}
	return isDisplayed;
	
}
public String selectAnyTabFromSelectedTabs()
{
	Select s1=new Select(selectSelectedTabs);
	s1.selectByIndex(3);
	String selectedTab=s1.getFirstSelectedOption().getText();
	return selectedTab;
}
public boolean verifyDisplayOfSelectedTabInAvailableTabs(WebDriver driver,String sTab) 
{
	boolean isDisplayed=false;
	
	if(CommonUtils.waitForElementToBeVisible(driver, selectAvailableTabs)) {
	Select s2=new Select(selectAvailableTabs);
	List<WebElement> ls=s2.getOptions();
	for(WebElement e:ls)
	{
		if(e.getText().equals(sTab)) {
			isDisplayed=true;
			break;
		}
	}
	}
	return isDisplayed;
}
public boolean verifyRemovedTabNotDisplayedInTabBar(WebDriver driver,String sTab)
{
	boolean isNotDisplayed=true;
	for(WebElement e:tabsInTabBar)
	{
		if(e.getText().equals(sTab)) {
			isNotDisplayed=false;
			break;
		}
		
	}
	return isNotDisplayed;
}

}



