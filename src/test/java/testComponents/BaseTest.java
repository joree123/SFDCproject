package testComponents;

import java.lang.reflect.Method;
import java.time.Duration;

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
import org.testng.annotations.Parameters;

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
	
	private static ThreadLocal<WebDriver> threadLocalDriver=new ThreadLocal<>(); 
	public static Logger logger=LogManager.getLogger();
	static ExtentReports extent=new ExtentReports();
	static ExtentSparkReporter reporter;
	static ExtentTest test=null;
	static ThreadLocal<ExtentTest> threadLocaltest= new ThreadLocal<>();
	
	
	/**This method setDriver() configures the driver
	 * and cofigures the extentreport for the tests
	 */
	@Parameters({"browser","headless"})
	@BeforeTest
	public static void setDriver() {
		WebDriver driver=getBrowserType("chrome",false);
		
		logger.info("BaseTest: setDriver(): driver cofigured");
		threadLocalDriver.set(driver);
				
		logger.info("BaseTest: setDriver(): reporter assigned");
	}
	
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	
	@BeforeMethod
	public static void setupTest(Method method)
	{
		
		reporter=new ExtentSparkReporter(FileConstants.REPORT_PATH);
		extent.attachReporter(reporter);
		test =extent.createTest(method.getName());
		threadLocaltest.set(test);
		logger .info("BaseTest: setupTest() :"+method.getName()+": Test object for reporting is created");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	
	}
	
	public static ExtentTest getTest() {
		return threadLocaltest.get();
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
			logger.info("BaseTest : getBrowserType : chrome headless driver configured");
			break;
			}
			else
			{
				driver=new ChromeDriver();
				logger.info("BaseTest : getBrowserType : chrome driver configured");
				break;
			}
		case "firefox":
			driver=new FirefoxDriver();
			logger.info("BaseTest : getBrowserType : firefox driver configured");
			break;
		case "safari":
			driver=new SafariDriver();
			logger.info("BaseTest : getBrowserType : Safari driver configured");
		case "edge":
			driver=new EdgeDriver();
			logger.info("BaseTest : getBrowserType : Edge driver configured");
		default:
			driver=null;
			logger.fatal("BaseTest : getBrowserType : Incorrect browser name supplied");
			break;
				
		}
		return driver;
	}
	
	
	
	
	
	
	
	
}
