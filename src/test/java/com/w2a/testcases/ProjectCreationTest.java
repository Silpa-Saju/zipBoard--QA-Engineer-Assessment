package com.w2a.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class ProjectCreationTest extends TestBase{
	
	
public static String testStep="";
public static String testName="";

	
	@Test(testName="ZipBoard Project Creation Test",dataProviderClass=TestUtil.class, dataProvider="dataProvider")
	public void projectCreationTest(String projectId, String projectTitle, String projectDescription) throws InterruptedException {
		
			try {
				testName="ZipBoard Project Creation Test";
				
				waitUntilElementVisible("createProjectButton_XPATH");
				testStep="Click create Project button ";
				logReporting(testStep);
				onclick("createProjectButton_XPATH");
				
				
				testStep="Checking pop-up appeared  ";
				logReporting(testStep);
				
				waitUntilElementVisible("newProjectpopup_XPATH");
				if(!isElementPresent("newProjectpopup_XPATH"))
				{
					testStep="Popup didn't appear ";
					logReporting(testStep);
					test.log(LogStatus.FAIL, testName, "Can't Enter new project details");
					throw new Error(""+testStep);
				}
				testStep="Pop-up appeared to enter details of new Project";
				logReporting(testStep);
				
				testStep="Enter new Project Id";
				logReporting(testStep);
				typeText("projectIdTextbox_XPATH",projectId);
				
				testStep="Enter new Project Title";
				logReporting(testStep);
				typeText("projectTitleTextbox_XPATH",projectTitle);
				
				testStep="Enter new Project Description";
				logReporting(testStep);
				typeText("projectTitleTextbox_XPATH",projectDescription);
				
				testStep="Click Project save button ";
				logReporting(testStep);
				onclick("projectSaveButton_XPATH");
				
				testStep="Check project is created ";
				logReporting(testStep);
				if(isElementPresent("projectCreationFailedMessage_XPATH")) {
					throw new Exception("Project creation Failed due to incomplete data.");
				}
				if(!waitUntilElementVisible("projectTaskListButton_XPATH"))
				{
					throw new Exception("Project creation Failed");
				}
				testStep="New Project is created successfully";
				logReporting(testStep);	
				test.log(LogStatus.PASS, testName);
				Thread.sleep(5000);

		}
		catch(Exception e) {
			
		   test.log(LogStatus.FAIL, testName, "Failed due to "+e.getLocalizedMessage());
		}
		
		Thread.sleep(3000);
	

	

	}
}
