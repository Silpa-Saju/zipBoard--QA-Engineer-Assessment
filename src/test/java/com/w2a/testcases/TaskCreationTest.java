package com.w2a.testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class TaskCreationTest extends TestBase{

	
	public static String testStep="";
	public static String testName="";

		
		@Test(testName="ZipBoard Task Creation Test",dataProviderClass=TestUtil.class, dataProvider="dataProvider")
		public void taskCreationTest(String taskTitle, String taskDescription, String taskStatus, String taskType, String taskPriority) throws InterruptedException {
			
				try {
					testName="ZipBoard Task Creation Test";
					
					Thread.sleep(1000);
					waitUntilElementVisible("projectTaskListButton_XPATH");
					testStep="Click on Task nav-bar button ";
					logReporting(testStep);
					onclick("projectTaskListButton_XPATH");
					
					testStep="Click on add Task button ";
					logReporting(testStep);
					onclick("addTaskButton_XPATH");
					
					
					testStep="Checking pop-up appeared  ";
					logReporting(testStep);
					
					waitUntilElementVisible("addTaskTitleTextBox_XPATH");
					if(!isElementPresent("addTaskTitleTextBox_XPATH"))
					{
						testStep="Popup didn't appear ";
						logReporting(testStep);
						test.log(LogStatus.FAIL, testName, "Can't Enter new task details");
						throw new Error(""+testStep);
					}
					testStep="Pop-up appeared to enter details of new task";
					logReporting(testStep);
					
					testStep="Enter new Task Title";
					logReporting(testStep);
					typeText("addTaskTitleTextBox_XPATH",taskTitle);
					
					testStep="Click on add Title button ";
					logReporting(testStep);
					onclick("addTaskTitleButton_XPATH");
					
					testStep="Enter new Task Description";
					logReporting(testStep);
					typeText("addTaskDescription_XPATH",taskDescription);
					
//					if(waitUntilElementVisible("saveTaskDescription_XPATH"))
//					{
//						testStep="Click on save Task Description button ";
//						logReporting(testStep);
//						onclick("saveTaskDescription_XPATH");
//					}
					
					
					testStep="Click on Task Status drop down button ";
					logReporting(testStep);
					onclick("taskStatusButton_XPATH");
					
					
					testStep="Select Task Status ";
					logReporting(testStep);
					onclick("taskStatusSelection_XPATH",taskStatus);
					
					
					
					
					testStep="Click on Task Type drop down button ";
					logReporting(testStep);
					onclick("taskTypeButton_XPATH");
					
					
					testStep="Select Task Type ";
					logReporting(testStep);
					onclick("taskTypeSelection_XPATH",taskType);
					
					testStep="Click on Task Priority drop down button ";
					logReporting(testStep);
					onclick("taskPriorityButton_XPATH");
					
					
					testStep="Select Task Priority ";
					logReporting(testStep);
					onclick("taskPriorityelection_XPATH",taskPriority);
					
					testStep="Click on Task Close button ";
					logReporting(testStep);
					onclick("taskcloseButton_XPATH");
				
					
					testStep="Check task is created ";
					logReporting(testStep);
//					if(!isElementPresent("taskListTableViewButton_XPATH")) {
//						throw new Exception("Task creation Failed due to incomplete data.");
//					}
					if(!waitUntilElementVisible("taskListTableViewButton_XPATH"))
					{
						throw new Exception("Task creation Failed");
					}
					testStep="New Task is created successfully";
					logReporting(testStep);	
					test.log(LogStatus.PASS, testName);
					Thread.sleep(3000);

			}
			catch(Exception e) {
				
			   test.log(LogStatus.FAIL, testName, "Failed due to "+e.getLocalizedMessage());
			}
		}
	
		
		

//		@Test(testName="ZipBoard Task Search Test",dataProviderClass=TestUtil.class, dataProvider="dataProvider",priority=2)
//		public void projectSearchTest(String taskTitle, String taskDescription, String taskStatus, String taskType, String taskPriority) throws InterruptedException {
//			
//			try {
//				testName="ZipBoard Task Search Test";
//				
//				testStep="Click on Task Tabe nav-bar ";
//				logReporting(testStep);
//				onclick("taskListTableViewButton_XPATH");
//				
//				testStep="Click on Task search-bar ";
//				logReporting(testStep);
//				typeText("projectTitleTextbox_XPATH",taskTitle);
//		
//			}
//			catch(Exception e) {
//				
//				   test.log(LogStatus.FAIL, testName, "Failed due to "+e.getLocalizedMessage());
//				}
//				
//				Thread.sleep(3000);
//	}
	
	
	
	
	
	
}
