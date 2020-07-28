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
	
	//@FindBy(xpath="//a[@id='dnn_dnnLOGIN_cmdLogin']")private static WebElement home_login;
	//@FindBy(xpath="//a[contains(@class='login-link')]")private static List<WebElement> home_login;
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

	@FindBy(xpath="//div[contains(@class,'tshq-activity')]//ul//li[1]")private static WebElement select_activity_type;
	public Verify_New selct_Activity_type() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, select_activity_type);
		select_activity_type.click();
		LogClass.logExtent("==> Select Activity Type ");
		return new Verify_New(driver);
	}	
	
	@FindBy(xpath="//span[text()=' Save & Continue ']")private static WebElement saveandcontinue;
	public Verify_New click_save_and_continue_btn() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, saveandcontinue);
		LogClass.logExtent("==> Clicked Save and Continue button ");
		return new Verify_New(driver);
	}

	@FindBy(xpath="//input[@placeholder='Program Name']")private static WebElement program_name;
	public Verify_New enter_program_name(String name) {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.senddata(driver, program_name, BSB_TestData.Non_tryout_program_name(name,3));
		LogClass.logExtent("==> Enter Program Name");
		return new Verify_New(driver);
	}
	
	@FindBy(xpath="//span[text()='National Affiliation']")private static WebElement click_national_affilation_menu;
	public Verify_New select_national_affilation(String activitytype) {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		//funcs.clickon_element(driver, click_national_affilation_menu);
		click_national_affilation_menu.click();
		LogClass.logExtent("==> National Affiliation dropdown list open");
		funcs.waitforseconds(2);
		System.out.println("Activity Type :"+activitytype);
		//WebElement ele = driver.findElement(By.xpath("//span[text()='"+activitytype+"']"));
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+ activitytype +"')]"));
		//funcs.clickon_element(driver, ele);
		ele.click();
		LogClass.logExtent("==> National Affiliation Selected");
		return new Verify_New(driver);
	}
	
}//End of Class
