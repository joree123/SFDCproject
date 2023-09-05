package testComponents;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

public class BaseTest {
	
	
	
//	Requirements
//	Cross browser support
//	Parallel support -
//	Proper reporting - Accurate Assertion, Screenshots
//	Support of Logs in the framework
	
	public static ThreadLocal<WebDriver> threadLocalDriver=new ThreadLocal<>(); 
	public static Logger logger=LogManager.getLogger();
	public static ExtentReports extent=new ExtentReports();
	static ExtentSparkReporter reporter;
	public static ExtentTest test;
	
	
	/**This method setDriver() configures the driver
	 * and cofigures the extentreport for the tests
	 */
	@BeforeTest
	public static void setDriver() {
		WebDriver driver=getBrowserType("chrome",false);
		logger.info("BaseTest: setDriver(): driver cofigured");
		threadLocalDriver.set(driver);
		reporter=new ExtentSparkReporter(FileConstants.REPORT_PATH);
		extent.attachReporter(reporter);
		logger.info("BaseTest: setDriver(): reporter assigned");
	}
	
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	@BeforeMethod
	public static void setupTest(Method method)
	{
		test =extent.createTest(method.getName());
		logger .info("BaseTest: setupTest() :"+method.getName()+": Test object for reporting is created");
	}
	@AfterMethod
	public static void tearDown(Method method)
	{
		logger.info("BaseTset:tearDown():"+method.getName()+" tear down called");
	}
	@AfterTest
	public static void removeDriver() {
		extent.flush();
		getDriver().close();
		logger.info("BaseTest: removedriver: removed driver");
		threadLocalDriver.remove();
	}
	
	/**this method is the first method to be executed to get the browser driver
	 * inside setDriver() method
	 * @param browser type 
	 * @return WebDriver for the browser
	 */
	public static WebDriver getBrowserType(String browser,boolean headless)
	{
		WebDriver driver;
		browser.toLowerCase();
		switch(browser) {
		case "chrome":
			if(headless== true) {
			ChromeOptions co =new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
			break;
			}
			else
			{
				driver=new ChromeDriver();
				break;
			}
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "safari":
			driver=new SafariDriver();
		case "edge":
			driver=new EdgeDriver();
		default:
			driver=null;
			break;
				
		}
		return driver;
	}
	
	
	
	
	
	
	
	
}
