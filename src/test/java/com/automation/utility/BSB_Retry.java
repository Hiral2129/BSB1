package com.automation.utility;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.automation.utility.BSB_ExtentManager;
import com.automation.init.BSB_SeleniumInit;
 

public class BSB_Retry implements IRetryAnalyzer {
	 private int count = 0;
	    private static int maxTry = -1; //Run the failed test 2 times
	 
	    @Override
	    public boolean retry(ITestResult iTestResult) {
	        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
	            if (count <= maxTry) {                            //Check if maxtry count is reached                
	                System.out.println("Retrying " + iTestResult.getName() + " again and the count is " + (count+1));	  
	                count++;      //Increase the maxTry count by 1
	                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
	                extendReportsFailOperations(iTestResult);    //ExtentReports fail operations
	                return true;                                 //Tells TestNG to re-run the test
	            }
	        } else {
	            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
	        }
	        return false;
	    }
	 
	    public void extendReportsFailOperations (ITestResult iTestResult) {
	        Object testClass = iTestResult.getInstance();
	        WebDriver webDriver = ((BSB_SeleniumInit) testClass).getDriver();
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
	       // BSB_ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed"BSB_ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	    }

}
