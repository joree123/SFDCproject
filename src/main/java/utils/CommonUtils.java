package utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import constants.WaitConstants;



public class CommonUtils {
	
	public static boolean waitForElement(WebDriver driver,WebElement element)
	{
		boolean isElementVisible=false;
		WebDriverWait wait=new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT);
		try {
			
		wait.until(ExpectedConditions.elementToBeClickable(element));
		isElementVisible=true;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isElementVisible;
	}
	
	public static boolean waitForElementToDisappear(WebDriver driver,WebElement element)
	{
		boolean elementDisappeared=false;
		WebDriverWait wait=new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			elementDisappeared=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return elementDisappeared;
	}
	
	public static String createDateAndTimeStamp()
	{
	String sdate=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	return sdate;
	}
	
	public static void moveMouseToElement(WebDriver driver,WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();
		
	}
	
	public static String getScreenshot(WebDriver driver) throws IOException
	{
		String filePath=FileConstants.SCREENSHOT_PATH;
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		File dest=new File(filePath);
		FileUtils.copyFile(src,dest);
		return filePath;
	}
	
	
	
}
