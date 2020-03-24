package com.automation.indexpage;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.init.BSB_AbstractPage;
import com.automation.init.BSB_SeleniumInit;
import com.automation.utility.BSB_TestData;
//import com.automation.utility.Common;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
import com.sun.corba.se.spi.orbutil.fsm.Action;

import com.automation.verification.Verify;
import com.automation.verification.Verify_New;

public class Logic_New extends BSB_AbstractPage {
	String testUrl;
	public Logic_New(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
/*
	public static Verify CalcuQuote_Valid_Credentials() {
		// TODO Auto-generated method stub
		
		LogClass.logExtent("==> Enter Username ");
		funcs.senddata(driver, calcuquote_password, BSB_SeleniumInit.password);

		LogClass.logExtent("==> Enter Password ");
		funcs.clickon_element(driver, calcuquote_login_btn);
		
		return new Verify(driver);
	}
*/
	public Verify_New tshq_staging() {
		// TODO Auto-generated method stub
		testUrl = BSB_TestData.getURL(1,3);		
		driver.get("http://stagingtshq.bsbtest.com/default.aspx?portalid="+testUrl);		
		funcs.waitforseconds(5);
		LogClass.logExtent("Step 1 : "+driver.getCurrentUrl());
		return new Verify_New(driver);
	}
	
	public Verify_New sports_staging() {
		// TODO Auto-generated method stub
		testUrl = BSB_TestData.getURL(2,3);		
		driver.get("https://stagingsports.bsbtest.com/Default.aspx?portalid="+testUrl);		
		funcs.waitforseconds(5);
		LogClass.logExtent("Step 1 : "+driver.getCurrentUrl());
		return new Verify_New(driver);
	}

	public Verify_New ayso_staging() {
		// TODO Auto-generated method stub
		testUrl = BSB_TestData.getURL(3,3);
		driver.get("https://stagingayso.bsbtest.com/Default.aspx?portalid="+testUrl);
		funcs.waitforseconds(5);
		LogClass.logExtent("Step 1 : "+driver.getCurrentUrl());
		return new Verify_New(driver);
	}	
	
	@FindBy(xpath="//a[@id='dnn_dnnLOGIN_cmdLogin']")private static WebElement home_login;
	@FindBy(xpath="//input[contains(@id,'UserNameTextBox')]")private static WebElement username;
	@FindBy(xpath="//input[contains(@id,'Password')]")private static WebElement password;
	@FindBy(xpath="//a[contains(@id,'SingInButton')]")private static WebElement login;
	
	public Verify_New login_as_admin() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, home_login);
		funcs.waitforseconds(4);
		LogClass.logExtent("==> Click on home Login Button to process login");
		funcs.senddata(driver, username, "bsbadmin"+testUrl);
		LogClass.logExtent("==> Enter User Name");
		funcs.senddata(driver, password, "St4ckSp0rts@");
		funcs.clickon_element(driver, login);
		LogClass.logExtent("==> Click on login button ");
		funcs.waitforseconds(5);
		return new Verify_New(driver);
	}	
	
	public Verify_New login_as_host() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, home_login);
		funcs.waitforseconds(4);
		LogClass.logExtent("==> Click on home Login Button to process login");
		funcs.senddata(driver, username, "athost");
		LogClass.logExtent("==> Enter User Name");
		funcs.senddata(driver, password, "ITW3546ctyz10@");
		funcs.clickon_element(driver, login);
		LogClass.logExtent("==> Click on login button ");
		funcs.waitforseconds(5);
		return new Verify_New(driver);
	}	
}
