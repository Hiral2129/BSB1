package com.automation.utility;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BSB_ExtentManager {
	private static ExtentReports extent;
	public static String browsername; 
	static Map extentTestMap = new HashMap();
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/screenshots/Extent_Report_new.html", true);
            extent.addSystemInfo("Host Name", "Vipul");
            extent.addSystemInfo("Browser Name", browsername);
            extent.addSystemInfo("Prepared For:", "BSB");
            extent.addSystemInfo("Prepared By:", "Toshal Infotech");
        }
        return extent;
    }
	
	/*
	 * public static synchronized ExtentTest getTest() { return
	 * (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	 * }
	 */
}
