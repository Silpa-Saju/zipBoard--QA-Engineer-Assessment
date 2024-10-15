package com.w2a.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extend;
	public static ExtentReports getInstance() {
		if(extend==null) {
			extend = new ExtentReports(System.getProperty("user.dir")+"//target//surefire-reports//html//extent.html",true,DisplayOrder.OLDEST_FIRST);
			extend.loadConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extentconfig//ReportsConfig.xml"));
		
		
		}
		return extend;
		

	}

}
