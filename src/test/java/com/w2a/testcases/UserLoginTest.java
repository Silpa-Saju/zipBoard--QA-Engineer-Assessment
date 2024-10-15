package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class UserLoginTest extends TestBase{
public static String testStep="";
public static String testName="";
	

	@Test(testName="ZipBoard User Login Test",dataProviderClass=TestUtil.class, dataProvider="dataProvider")
	public  void userLoginTest(String email, String pass) throws InterruptedException {
		
		try{
				testName="ZipBoard User Login Test";
			
				testStep="Enter username  ";
				logReporting(testStep);
				typeText("email_XPATH",email);
				
				
				testStep="Enter password  ";
				logReporting(testStep);
				typeText("pass_XPATH",pass);
				
				
				testStep="Click login button ";
				logReporting(testStep);
				onclick("loginButton_XPATH");
				
		//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//		Assert.assertTrue(alert.getText().contains(alertText));
		//		alert.accept();
				
				Thread.sleep(3000);
				
				testStep="Checking navigated to Home Page ";
				logReporting(testStep);
				
				if(!waitUntilElementVisible("createProjectButton_XPATH"))
				{
					testStep="Failed to navigate to Home Page ";
					logReporting(testStep);
					test.log(LogStatus.FAIL, testName, "Login Failed");
					throw new Exception("Login Failed");
				}
				testStep="Navigated to Home Page ";
				logReporting(testStep);
				test.log(LogStatus.PASS, testName, "Login Successful");
				Thread.sleep(3000);
		
			}
			catch(Exception e) {
				
			   test.log(LogStatus.FAIL, testName, "Failed due to "+e.getLocalizedMessage());
			}
			
	}
	
}
