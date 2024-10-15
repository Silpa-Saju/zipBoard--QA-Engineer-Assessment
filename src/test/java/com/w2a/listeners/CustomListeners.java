package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult arg0) {
		
		test = report.startTest(arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg1) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			
				TestUtil.captureScreenshot();
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		test.log(LogStatus.PASS,arg1.getName()+"PASS");
		test.log(LogStatus.PASS,test.addScreenCapture(TestUtil.screenShotName));
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+"></a>");
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult arg2) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			
				TestUtil.captureScreenshot();
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL,arg2.getName().toUpperCase()+"Failed with exception : "+arg2.getThrowable());
		test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenShotName));

		
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+"></a>");
		report.endTest(test);
		report.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
