package com.automation.index;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.utility.BSB_TestData;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.automation.init.BSB_SeleniumInit;

import com.automation.indexpage.Logic;


public class Steps_New extends BSB_SeleniumInit {

	
	public static int step, numberOfFailure = 1;
	SoftAssert softassertion = new SoftAssert();// For the soft Assertion
	public static com.aventstack.extentreports.ExtentTest logger;// for the log in extent report
	public static ExtentTest test_package;// for the log in extent report
	public static ExtentTest extent_report_log;// for the log in extent report
	// soft assertion
	SoftAssert softAssertion = new SoftAssert();

	
	public static void getTest(ExtentTest test) {
		// TODO Auto-generated method stub
		// test_package = test;
		extent_report_log = test;
		System.out.println("GetTest Method called");
	}

//Login Module Test Cases , dependsOnMethods = { "Signin_TestCase_02" }
	@Test(priority = 0, enabled = true)
	public void Signin_TestCase_01() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to login with valid credentials";
		LogClass.logExtent(report_msg);
		//report_msg ="Step " + (step++) + ":Open : Below URL";
		//LogClass.logExtent(report_msg);
		
		veri_new = logic_new.tshq_staging();
		veri_new.homepageverify();
		veri_new = logic_new.login_as_admin();
		
		veri_new = logic_new.sports_staging();
		veri_new.homepageverify();
		veri_new = logic_new.login_as_admin();
		
		//veri_new = logic_new.ayso_staging();
		//veri_new.homepageverify();
		//veri_new = logic_new.login_as_admin();
		
		veri_new = logic_new.tshq_staging();
		veri_new.homepageverify();
		veri = logic.login_as_host();
		
		veri_new = logic_new.sports_staging();
		veri_new.homepageverify();
		veri = logic.login_as_host();
		
		//veri_new = logic_new.loginstaging_ayso();
		//veri_new.homepageverify();
		//veri_new = logic_new.login_as_host();
		
	}// End of Signin_TestCase_01.

	
}// End of Class