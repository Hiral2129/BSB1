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
	 * ===============
	 * Login functions
	 * ===============
	 */
	
	public Verify_New geturlfornew() {
		// TODO Auto-generated method stub
		testUrl = BSB_TestData.getURL(1,3);	
		driver.get(testUrl);		
		funcs.waitforseconds(2);
		LogClass.logExtent("Step 1 : "+driver.getCurrentUrl());
		return new Verify_New(driver);
	}
	
	
	@FindBy(xpath="//div[@class='skLogin']//a[contains(text(),'L')]")private static WebElement home_login;
	@FindBy(xpath="//input[contains(@id,'UserNameTextBox')]")private static WebElement username;
	@FindBy(xpath="//input[contains(@id,'Password')]")private static WebElement password;
	@FindBy(xpath="//a[contains(@id,'SingInButton')]")private static WebElement login;
	
	public Verify_New login_as_admin() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, home_login);
		funcs.waitforseconds(4);
		LogClass.logExtent("==> Click on home Login Button to process login");
		funcs.senddata(driver, username, BSB_TestData.getURL(2, 3));
		LogClass.logExtent("==> Enter User Name");
		funcs.waitforseconds(1);
		LogClass.logExtent("==> Enter Password");
		funcs.senddata(driver, password, BSB_TestData.getURL(3, 3));
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
		funcs.senddata(driver, username, BSB_TestData.getURL(2,5));
		LogClass.logExtent("==> Enter User Name");
		funcs.senddata(driver, password, BSB_TestData.getURL(3,5));
		funcs.clickon_element(driver, login);
		LogClass.logExtent("==> Click on login button ");
		funcs.waitforseconds(5);
		return new Verify_New(driver);
	}	
	
	@FindBy(xpath="//span[text()=' Add Program ']")private static WebElement new_program_plus;
	public Verify_New click_new_program_plus_sign() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, new_program_plus);
		LogClass.logExtent("==> Click on New Program Plus Icon ");
		return new Verify_New(driver);
	}	
	
	@FindBy(xpath="//span[text()=' Select ']")private static WebElement select_nt_program;
	
	public Verify_New select_non_tryout_program() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, select_nt_program);
		LogClass.logExtent("==> Select Non-Tryout/Recreational or Camp ");
		return new Verify_New(driver);
	}	
	
}//End of Class
