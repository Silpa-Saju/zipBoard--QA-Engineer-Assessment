package com.w2a.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumHelper {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static Properties logprops = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//excel//testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports report = ExtentManager.getInstance();
    public static ExtentTest test;
    
    
    
	public boolean isElementPresent(By by) {
		
		try{
			findWebElement(by);
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
		
	}
	
	
	public boolean isElementPresent(String locator) {
			
			try{
				if(!findWebElement(locator).isDisplayed()) {
					return false;
				}
				return true;
			}
			catch(NoSuchElementException e) {
				test.log(LogStatus.FAIL, " Failed due to :  "+e.getLocalizedMessage());
				return false;
			}
			
		}
	
	
	public boolean isElementPresent(String locator, String value) {
		
		String xpath = String.format(OR.getProperty(locator),value);
		return isElementPresent(xpath);
		
		
	}

	
	public void onclick(String locator) {
		try {
			findWebElement(locator).click();
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed due to "+e.getLocalizedMessage());
		}
	}
	
	
	public void onclick(String locator, String value) {
		String xpath = String.format(OR.getProperty(locator),value);
		onclick(xpath);
	}

	public void typeText(String locator, String text) {
		try {
			findWebElement(locator).clear();
			Thread.sleep(1000);
			findWebElement(locator).sendKeys(text);
		} catch (InterruptedException e) {
			test.log(LogStatus.FAIL, "Failed due to "+e.getLocalizedMessage());
		}
	}
	
	public static void verifyEquals(String actual , String expected) throws IOException {
		
		try {
				Assert.assertEquals(actual, expected);
				test.log(LogStatus.PASS, "");
			
		}catch(Throwable  t) {
			
			TestUtil.captureScreenshot();
//			ReportNG
			Reporter.log("<br>"+"Failure Reason : "+t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+"></a>");
//			Extent Reports
			test.log(LogStatus.FAIL,"Execution failed with exception : "+t.getMessage());
			test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenShotName));	
			
		}
		
	}
	
	
	public boolean waitUntilElementVisible(String locator) {
		try {
			  if(wait.until(ExpectedConditions.visibilityOf(findWebElement(locator))) == null) {
				  test.log(LogStatus.FAIL, "Element can't be located within specified period of time");
				  return false;

			  } 
			  return true;

		}catch(Exception e) {
			  test.log(LogStatus.FAIL, "Failed due to "+e.getLocalizedMessage());
			return false;
		}
		
	}
	
	
	public static WebElement elementLocator;
	
	
	public  WebElement findWebElement(By by) {
		
			try{
				elementLocator = driver.findElement(by);
			    return elementLocator;
			}catch(Exception e) {
				test.log(LogStatus.FAIL, " Failed due to "+e.getLocalizedMessage());
				return null;
			}
			
	}
	
	
	public  WebElement findWebElement(String locator, String value) {
		String xpath = String.format(OR.getProperty(locator),value);
		return findWebElement(xpath);
	}

	public  WebElement findWebElement(String locator) {
		
		try{
			if(locator.endsWith("_CSS")) {
				elementLocator = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			}
			else if(locator.endsWith("_XPATH")) {
				elementLocator = driver.findElement(By.xpath(OR.getProperty(locator)));
			}
			else if(locator.endsWith("_ID")) {
				elementLocator =  driver.findElement(By.id(OR.getProperty(locator)));
			}
			return elementLocator;
		
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " Failed due to "+e.getLocalizedMessage());
			return null;
		}
	}
	
	
	public void selectByText(String locator, String value) {
		
		try
		{
			elementLocator = findWebElement(locator);
			Select select = new Select(elementLocator);
			select.selectByVisibleText(value);
		
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " Failed due to "+e.getLocalizedMessage());
		}
	}
	
	
	public void selectByValue(String locator, String value) {
		
		try{
			elementLocator = findWebElement(locator);
		
			Select select = new Select(elementLocator);
			
			select.selectByValue(value);
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " Failed due to "+e.getLocalizedMessage());
		}
	}
	
	public void selectByIndex(String locator, int value) {
		
		try{
			elementLocator = findWebElement(locator);
			Select select = new Select(elementLocator);	
			select.selectByIndex(value);
	     }
		 catch(Exception e) {
				test.log(LogStatus.FAIL, " Failed due to "+e.getLocalizedMessage());
			}
	}
	
	
	public  static void  logReporting(String testStep)
	{
		log.debug(testStep);
		Reporter.log(testStep);
		test.log(LogStatus.INFO,testStep);
	}
	
	









}
