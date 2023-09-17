package testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utils.CommonUtils;

public class SFDClisteners extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	BaseTest.getTest().pass(MarkupHelper.createLabel(result.getMethod().getMethodName()+" passed",ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	WebDriver driver=BaseTest.getDriver();	
	BaseTest.getTest().fail(MarkupHelper.createLabel(result.getMethod().getMethodName()+ " Failed",ExtentColor.RED));	
	try {
		BaseTest.getTest().addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

}
