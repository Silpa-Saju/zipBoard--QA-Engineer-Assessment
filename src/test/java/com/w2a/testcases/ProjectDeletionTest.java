package com.w2a.testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class ProjectDeletionTest extends TestBase{

	
	public static String testStep="";
	public static String testName="";

		
		@Test(testName="ZipBoard Project Deletion Test",dataProviderClass=TestUtil.class, dataProvider="dataProvider")
		public void projectDeletionTest(String projectId) throws InterruptedException {
			
				try {
					testName="ZipBoard Project Deletion Test";
					
					waitUntilElementVisible("projectHomePage_XPATH");
					testStep="Click on Project Navigation bar ";
					logReporting(testStep);
					onclick("projectHomePage_XPATH");
					
					
					testStep="Waiting for project page to load ";
					logReporting(testStep);
					
					waitUntilElementVisible("projectListTableViewButton_XPATH");
					if(!isElementPresent("projectListTableViewButton_XPATH"))
					{
						testStep="Project table listing navigation bar is not displayed yet";
						logReporting(testStep);
						test.log(LogStatus.FAIL, testName, "Can't view project lists");
						throw new Error(""+testStep);
					}
					testStep="Click on nav-bar to display the view of projects";
					logReporting(testStep);
					onclick("projectListTableViewButton_XPATH");
					
					testStep="Enter Project Id in search bar";
					logReporting(testStep);
					typeText("projectIdSearchInHomePage_XPATH",projectId);
					
					if(!isElementPresent("projectIdDisplayedInTableSearch_XPATH",projectId))
					{
						testStep="Specified Project Id is not displayed in Table";
						logReporting(testStep);
						test.log(LogStatus.FAIL, testName, "Can't view Specified project");
						throw new Error(""+testStep);
					}
					
					testStep="Specified Project Id is  displayed in Table";
					logReporting(testStep);
					
					testStep="Click on Project delete button ";
					logReporting(testStep);
					onclick("deleteButtonForProjectIDInTableSearch_XPATH");
					
					waitUntilElementVisible("deleteConfirmationButtonForProjectID_XPATH");
					testStep="Click Project delete button ";
					logReporting(testStep);
					onclick("deleteConfirmationButtonForProjectID_XPATH");
					
					
					
					testStep="Checking project is deleted from table ";
					logReporting(testStep);
					waitUntilElementVisible("projectIdSearchInHomePage_XPATH");
					
					
					testStep="Enter Project Id in search bar";
					logReporting(testStep);
					typeText("projectIdSearchInHomePage_XPATH",projectId);
					Thread.sleep(1500);

					
					if(isElementPresent("projectIdDisplayedInTableSearch_XPATH",projectId))
					{
						testStep="Specified Project Id didn't got deleted from Table";
						logReporting(testStep);
						test.log(LogStatus.FAIL, testName, "Project deletion failed");
						throw new Error(""+testStep);
					}
					
					testStep="Successfully deleted the project with id"+projectId;
					logReporting(testStep);	
					test.log(LogStatus.PASS, testName);
					Thread.sleep(3000);

			}
			catch(Exception e) {
				
			   test.log(LogStatus.FAIL, testName, "Failed due to "+e.getLocalizedMessage());
			}
			
			Thread.sleep(3000);
		

		

		}


		
	
	
	
	
	
	
}
