package com.automation.verification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automation.index.Steps;
import com.automation.indexpage.Logic;
import com.automation.init.BSB_AbstractPage;
import com.automation.init.BSB_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.BSB_Common;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;


public class Verify_New extends BSB_AbstractPage {
	int flag =0;
	public Verify_New(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void homepageverify() {
		// TODO Auto-generated method stub		
		  String urlpass = "";
		  System.out.println("Url Display on window :" +driver.getCurrentUrl()); 
		  
		  if (driver.getCurrentUrl().contains(urlpass)) {
				LogClass.VerificationPass_Extent_Report("-----> Verified BSB home page is open <-----");
				//LogClass.AssertPass_Extent_Report();
				Assert.assertTrue(true);
			} else {
				LogClass.VerificationFailed_Extent_Report("-----> Verified BSB home page is not open <-----");			
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "Open page Fail");
				Assert.assertTrue(false);
			}
		  
	}
}
