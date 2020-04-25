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

public class Logic extends BSB_AbstractPage {
	String testUrl;
	String testUrlportalno;
	public Logic(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*
	 * ===============
	 * Login functions
	 * ===============
	 */
	public Verify geturlforcore() {
		// TODO Auto-generated method stub
		testUrl = BSB_TestData.getURL(1,1);	
		driver.get(testUrl);		
		funcs.waitforseconds(2);
		LogClass.logExtent("Step 1 : "+driver.getCurrentUrl());
		return new Verify(driver);
	}
		
	@FindBy(xpath="//div[@class='skLogin']//a[contains(text(),'L')]")private static WebElement home_login;
	@FindBy(xpath="//input[contains(@id,'UserNameTextBox')]")private static WebElement username;
	@FindBy(xpath="//input[contains(@id,'Password')]")private static WebElement password;
	@FindBy(xpath="//a[contains(@id,'SingInButton')]")private static WebElement login;
	
	public Verify login_as_admin() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, home_login);
		funcs.waitforseconds(4);
		LogClass.logExtent("==> Click on home Login Button to process login");
		funcs.senddata(driver, username, BSB_TestData.getURL(2, 1));
		LogClass.logExtent("==> Enter User Name");
		funcs.waitforseconds(1);
		funcs.senddata(driver, password, BSB_TestData.getURL(3, 1));
		LogClass.logExtent("==> Enter Password");
		funcs.clickon_element(driver, login);
		LogClass.logExtent("==> Click on login button ");
		funcs.waitforseconds(5);
		return new Verify(driver);
	}	
	
	public Verify login_as_host() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, home_login);
		funcs.waitforseconds(4);
		LogClass.logExtent("==> Click on home Login Button to process login");
		funcs.senddata(driver, username, BSB_TestData.getURL(2,5));
		LogClass.logExtent("==> Enter User Name");
		funcs.senddata(driver, password, BSB_TestData.getURL(3,5));
		LogClass.logExtent("==> Enter Password");
		funcs.clickon_element(driver, login);
		LogClass.logExtent("==> Click on login button ");
		funcs.waitforseconds(5);
		return new Verify(driver);
	}	
	
	public Verify production() {
		// TODO Auto-generated method stub
		testUrl = BSB_TestData.getURL(6,1);	
		
		driver.get(testUrl);		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, home_login);
		funcs.waitforseconds(4);
		LogClass.logExtent("==> Click on home Login Button to process login");
		//funcs.senddata(driver, username, "Harshid_host");
		funcs.senddata(driver, username, BSB_TestData.getURL(7,1));
		LogClass.logExtent("==> Enter User Name");
		funcs.waitforseconds(1);
		LogClass.logExtent("==> Enter Password");
		funcs.senddata(driver, password, BSB_TestData.getURL(8,1));
		funcs.clickon_element(driver, login);
			
		return new Verify(driver);
	}  
	
	/*
	 * =================
	 * Program functions
	 * =================
	 */
	@FindBy(xpath="//span[text()='+']")private static WebElement new_program_plus;
	public Verify click_new_program_plus_sign() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, new_program_plus);
		LogClass.logExtent("==> Click on New Program Plus Icon ");
		return new Verify(driver);
	}	
	
	@FindBy(xpath="//a[text()='Create a Non-Tryout/Rec Program']")private static WebElement create_non_tryout_rec_pro;
	public Verify click_Create_Non_Tryout_Rec_Program() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, create_non_tryout_rec_pro);
		LogClass.logExtent("==> Click on Create a Non-Tryout/Rec Program");
		return new Verify(driver);
	}	
	
	@FindBy(xpath="//a[text()='Create a Tryout/Competitive Program']")private static WebElement create_tryout_Competitive_pro;
	public Verify click_Create_Tryout_Competitive_Program() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, create_tryout_Competitive_pro);
		LogClass.logExtent("==> Click on Create a Tryout/Competitive Program");
		return new Verify(driver);
	}	
	
	@FindBy(xpath="//input[contains(@id,'txtProgramName')]")private static WebElement program_name;
	public Verify enter_program_name() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.senddata(driver, program_name, BSB_TestData.Non_tryout_program_name(4));
		LogClass.logExtent("==> Enter Program Name");
		return new Verify(driver);
	}	
	
	//@FindBy(xpath="//select[contains(@id,'ActivityType')]")private static WebElement select_activity_type;
	
	@FindBy(xpath="//span[text()='--Select--']")private static WebElement click_select_activity_type;
	public Verify select_activity_type(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> Activity Type dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> Activity Type Selected");
		return new Verify(driver);
	}	
	
	public Verify select_national_affilation(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> National Affiliation dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> National Affiliation Selected");
		return new Verify(driver);
	}	
	
	public Verify select_state_affilation(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> State Affiliation dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> State Affiliation Selected");
		return new Verify(driver);
	}	
	
	public Verify select_Organization(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> Organization dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> Organization Selected");
		return new Verify(driver);
	}
	
	public Verify select_club(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> Clubs dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> Clubs Selected");
		return new Verify(driver);
	}
	
	public Verify select_Season(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(6);
		//WebElement season = driver.findElement(By.xpath("//span[text()='--Select--']"));
		//season.click();
		click_select_activity_type.click();
		funcs.jsClick(driver, click_select_activity_type);
		LogClass.logExtent("==> Season dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> Season Selected");
		return new Verify(driver);
	}
	
	public Verify select_play_Level(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> Play Level dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> Play Level Selected");
		return new Verify(driver);
	} 
	public Verify select_Region(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> Region dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> Region Selected");
		return new Verify(driver);
	}  
	public Verify select_League(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(2);
		click_select_activity_type.click();
		LogClass.logExtent("==> League dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> League Selected");
		return new Verify(driver);
	}  
	
	public Verify select_Association(String activitytype) {
		// TODO Auto-generated method stub
		//funcs.clickon_element(driver, click_select_activity_type)
		funcs.waitforseconds(6);
		click_select_activity_type.click();
		funcs.jsClick(driver, click_select_activity_type);
		LogClass.logExtent("==> Association dropdown list open");
		WebElement ele = driver.findElement(By.xpath("//li[text()='"+activitytype+"']"));
		ele.click();
		LogClass.logExtent("==> Association Selected");
		return new Verify(driver);
	}
	

}//End of Class
