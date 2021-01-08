package com.automation.indexpage;

import java.awt.AWTException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.ss.formula.functions.Today;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.HomeBaseWarning;

import com.automation.init.BSB_AbstractPage;
import com.automation.init.BSB_SeleniumInit;
import com.automation.utility.BSB_TestData;
//import com.automation.utility.Common;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
//import com.sun.corba.se.spi.orbutil.fsm.Action;

import com.automation.verification.Verify;
import com.aventstack.extentreports.model.Log;

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
	
	public Verify geturlforcore_Bulkmail(int row,int col) {
		// TODO Auto-generated method stub
		testUrl = BSB_TestData.getURL(row,col);	
		System.out.println("URL : "+testUrl);
		driver.get(testUrl);		
		funcs.waitforseconds(1);
		LogClass.logExtent("Step 1 : "+driver.getCurrentUrl());
		return new Verify(driver);
	}
		
	@FindBy(xpath="//a[@id='dnn_dnnLOGIN_cmdLogin'or @id='dnn_dnnLOGINLL_cmdLogin']")private static WebElement home_login;  //production Servers
	//@FindBy(xpath="//a[@id='dnn_dnnLOGIN_cmdLogin']")private static WebElement home_login;  //production Servers
	//@FindBy(xpath="//a[contains(@class='login-link')]")private static List<WebElement> home_login;
	//@FindBy(xpath="//div[contains(@class,'skLogin')]//a[contains(text(),'L')]")private static WebElement home_login;
	//@FindBy(xpath="//a[@id='dnn_dnnLOGINLL_cmdLogin']")private static WebElement home_login;   // Clubs portal 15
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
	
	public Verify login_as_admin_bulkmail(int row) {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver, home_login);
		funcs.waitforseconds(4);
		LogClass.logExtent("==> Click on home Login Button to process login");
		funcs.senddata(driver, username, BSB_TestData.getURL(row, 1));
		LogClass.logExtent("==> Enter User Name");
		funcs.waitforseconds(1);
		funcs.senddata(driver, password, BSB_TestData.getURL(24, 1));
		LogClass.logExtent("==> Enter Password");
		funcs.clickon_element(driver, login);
		LogClass.logExtent("==> Click on login button ");
		funcs.waitforseconds(1);
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
	
	@FindBy(xpath="//a[text()='Create a Team Coach Registration Program']")private static WebElement create_Teamcoach_Pro;
	public Verify click_Creat_TeamCoach_Registration_Program() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, create_Teamcoach_Pro);
		LogClass.logExtent("==> Click on Create a Team Coach Registration Program");
		return new Verify(driver);
	}
	
	@FindBy(xpath="//input[contains(@id,'txtProgramName')]")private static WebElement program_name;
	public Verify enter_program_name(String name) {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.senddata(driver, program_name, BSB_TestData.Non_tryout_program_name(name,3));
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
		funcs.waitforseconds(8);
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
	
	@FindBy(xpath="//span[text()='Next']")private static WebElement next_btn;
	public Verify click_next_btn_Program_creation() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, next_btn);
		LogClass.logExtent("==> Click on Next Button Program Creation");
		return new Verify(driver);
	}
	
	@FindBy(xpath="//span[text()='Skip']")private static WebElement skip_btn;
	public Verify click_skip_btn_Program_creation() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, skip_btn);
		LogClass.logExtent("==> Click on skip Button Program Creation");
		return new Verify(driver);
	}
	
	@FindBy(xpath = "//iframe[contains(@id,'txtTryoutFeeConfirmationEmail_miniRichEditor_contentIframe')]")private static WebElement Enter_Text1;
	@FindBy(xpath = "//iframe[contains(@id,'txtPlayerAcceptanceEmail_miniRichEditor_contentIframe')]") private static WebElement Enter_Text2;
	@FindBy(xpath = "//iframe[contains(@id,'txtPlayerRejectedEmail_miniRichEditor_contentIframe')]") private static WebElement Enter_Text3;
	@FindBy(xpath = "//iframe[contains(@id,'txtConfirmationEmail_miniRichEditor_contentIframe')]") private static WebElement Enter_Text4;
	@FindBy(xpath = "//iframe[contains(@id,'txtPlayerAcceptanceContract_miniRichEditor_contentIframe')]") private static WebElement Enter_Text5;
	@FindBy(xpath = "//body")private static List<WebElement> Enter_Text;
	@FindBy(xpath="//span[text()='Next']")private static WebElement next_btn1;
	public Verify step5_Program_creation() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		driver.switchTo().frame(Enter_Text1);
		//System.out.println("Enter text:" +Enter_Text);
		//System.out.println("Enter text1:" +Enter_Text1.size());
		//funcs.clickon_element(driver, Enter_Text1.get(1));
		funcs.waitforseconds(2);
		funcs.senddata(driver, Enter_Text.get(0), "Tryout Registration Confirmation Email");
		LogClass.logExtent("==> Tryout Registration Confirmation Email");
		driver.switchTo().defaultContent();
		
		funcs.waitforseconds(5);
		driver.switchTo().frame(Enter_Text2);
		funcs.waitforseconds(2);
		funcs.senddata(driver, Enter_Text.get(0), "Participant Made the Team Email");
		LogClass.logExtent("==> Participant Made the Team Email");
		driver.switchTo().defaultContent();
		
		funcs.waitforseconds(3);
		driver.switchTo().frame(Enter_Text3);
		funcs.senddata(driver, Enter_Text.get(0), "Participant Did Not Make the Team Email");
		LogClass.logExtent("==> Participant Did Not Make the Team Email");
		driver.switchTo().defaultContent();
		
		funcs.waitforseconds(3);
		driver.switchTo().frame(Enter_Text4);
		funcs.senddata(driver, Enter_Text.get(0), "Division Registration Confirmation Email");
		LogClass.logExtent("==> Division Registration Confirmation Email");
		driver.switchTo().defaultContent();
		
		funcs.waitforseconds(3);
		driver.switchTo().frame(Enter_Text5);
		funcs.senddata(driver, Enter_Text.get(0), "Club Policies Contract");
		LogClass.logExtent("==> Club Policies Contract");
		driver.switchTo().defaultContent();
		
	funcs.waitforseconds(3);
		funcs.clickon_element(driver, next_btn1);
		LogClass.logExtent("==> Click on Next Button Program Creation");
		return new Verify(driver);
	}	
	
	@FindBy(xpath="//span[text()='Add New Question']")private static WebElement add_new_question_btn;
	public Verify click_add_new_question_btn_Program_creation() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, add_new_question_btn);
		LogClass.logExtent("==> Click on Add New Question Button Program Creation");
		return new Verify(driver);
	}	

	@FindBy(xpath="//span[text()='Add']")private static List<WebElement> add_btn;
	@FindBy(xpath="//input[@class='BSBInput full-width']")private static List<WebElement> Text_or_Multi_line_text;
	@FindBy(xpath="//span[text()='Save Changes']")private static List<WebElement> save_change_btn;
	@FindBy(xpath="//span[text()='Add New']")private static List<WebElement> add_new_btn;
	@FindBy(xpath="//a[text()='Select All']")private static WebElement select_all;
	@FindBy(xpath="//label[contains(text(),'Waiver Text')]//..//textarea")private static WebElement textarea;
	@FindBy(xpath="//span[text()='Choose...']//..//div//b")private static WebElement select_questions_from_list;
	@FindBy(xpath="//li[text()='Years of Experience?']")private static WebElement exp_ques;
	
	public Verify Add_question_for_Program_creation() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, select_questions_from_list);
		select_questions_from_list.click();
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, exp_ques);
		exp_ques.click();
		funcs.waitforseconds(1);
		LogClass.logExtent("==> Select the question from the Drop Down list ");
		funcs.clickon_element(driver, add_btn.get(0));
		
		funcs.waitforseconds(1);
		click_add_new_question_btn_Program_creation();
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, add_btn.get(1));
		LogClass.logExtent("==> Click on Add Button ");
		funcs.senddata(driver, Text_or_Multi_line_text.get(0), "Text or Multi-line text");
		funcs.waitforseconds(3);
		LogClass.logExtent("==> Added Text or Multi-line text Question ");
		save_change_btn.get(0).click();
		LogClass.logExtent("==> Click on Save Change Button to save question");
		
		funcs.waitforseconds(1);
		click_add_new_question_btn_Program_creation();
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, add_btn.get(2));
		LogClass.logExtent("==> Click on Add Button ");
		funcs.senddata(driver, Text_or_Multi_line_text.get(12), "Drop-down List");
		funcs.senddata(driver, Text_or_Multi_line_text.get(13), "Drop-down List1");
		LogClass.logExtent("==> Added Drop-down List Question ");
		save_change_btn.get(3).click();
		LogClass.logExtent("==> Click on Save Change Button to save question");
		
		funcs.waitforseconds(1);
		click_add_new_question_btn_Program_creation();
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, add_btn.get(3));
		LogClass.logExtent("==> Click on Add Button ");
		funcs.senddata(driver, Text_or_Multi_line_text.get(4), "Check Box");
		funcs.senddata(driver, Text_or_Multi_line_text.get(5), "Check Box1");
		LogClass.logExtent("==> Added Check Box Question ");
		save_change_btn.get(1).click();
		LogClass.logExtent("==> Click on Save Change Button to save question");
		
		funcs.waitforseconds(1);
		click_add_new_question_btn_Program_creation();
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, add_btn.get(4));
		LogClass.logExtent("==> Click on Add Button ");
		funcs.senddata(driver, Text_or_Multi_line_text.get(8), "Radio Button");
		funcs.senddata(driver, Text_or_Multi_line_text.get(9), "Radio Button1");
		LogClass.logExtent("==> Added Radio Button Question ");
		save_change_btn.get(2).click();
		LogClass.logExtent("==> Click on Save Change Button to save question");
		
		funcs.waitforseconds(1);
		click_add_new_question_btn_Program_creation();
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, add_btn.get(5));
		LogClass.logExtent("==> Click on Add Button ");
		funcs.senddata(driver, Text_or_Multi_line_text.get(25), "Uniform Selection");
		funcs.senddata(driver, Text_or_Multi_line_text.get(26), "M");
		LogClass.logExtent("==> Added Uniform Selection Question ");
		save_change_btn.get(6).click();
		LogClass.logExtent("==> Click on Save Change Button to save question");
		
		funcs.waitforseconds(1);
		click_add_new_question_btn_Program_creation();
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, add_btn.get(7));
		LogClass.logExtent("==> Click on Add Button ");
		funcs.senddata(driver, Text_or_Multi_line_text.get(38), "Player File/Document Upload");
		select_all.click();
		funcs.waitforseconds(1);
		LogClass.logExtent("==> Added Player File/Document Upload Question ");
		save_change_btn.get(13).click();
		LogClass.logExtent("==> Click on Save Change Button to save question");
		
		funcs.waitforseconds(1);
		click_add_new_question_btn_Program_creation();
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, add_btn.get(8));
		LogClass.logExtent("==> Click on Add Button ");
		funcs.senddata(driver, Text_or_Multi_line_text.get(24), "Waiver");
		textarea.sendKeys("Waiver");
		LogClass.logExtent("==> Added Waiver Question ");
		save_change_btn.get(7).click();
		LogClass.logExtent("==> Click on Save Change Button to save question");
		
		return new Verify(driver);
	}

	
	@FindBy(xpath="//span[text()='Save Settings']")private static WebElement save_setting;
	public Verify click_on_save_setting() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, save_setting);
		LogClass.logExtent("==> Click on Save Setting Button");
		return new Verify(driver);
	}	
	
	@FindBy(xpath="//input[@class='BSBInput full-width priceInput']")private static List<WebElement> feesanddiscount;
	@FindBy(xpath="//input[@class=\"BSBInput full-width priceInput\"]//..//input")private static List<WebElement> feesanddiscount1;
	public Verify Add_Special_Discount_or_Fee() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		feesanddiscount.get(0).sendKeys("10");
		feesanddiscount.get(1).sendKeys("15");
		feesanddiscount.get(2).sendKeys("20");
		feesanddiscount.get(3).sendKeys("25");
		
		feesanddiscount1.get(6).sendKeys("6");
		feesanddiscount1.get(7).sendKeys("11");
		feesanddiscount1.get(8).sendKeys("16");
		feesanddiscount1.get(9).sendKeys("9");
		
		click_on_save_setting();
		
		LogClass.logExtent("==> Fees and Discount Added ");
		
		return new Verify(driver);
	}	
	
	public Verify Add_Special_Discount_or_Fee_TeamCoach() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		
		feesanddiscount.get(0).sendKeys("10");
		feesanddiscount.get(1).sendKeys("15");
		feesanddiscount.get(2).sendKeys("20");
		//feesanddiscount.get(3).sendKeys("25");
		
		//feesanddiscount1.get(5).sendKeys("6");
		feesanddiscount1.get(6).sendKeys("11");
		feesanddiscount1.get(7).sendKeys("16");
		feesanddiscount1.get(8).sendKeys("9");
		feesanddiscount1.get(9).sendKeys("9");
		
		click_on_save_setting();
		
		LogClass.logExtent("==> Fees and Discount Added ");
		
		return new Verify(driver);
	}	
	
	@FindBy(xpath="//span[text()='Add Team Staff']")private static WebElement add_custom_team_staff;
	@FindBy(xpath="//input[contains(@name,'txtVolunteerRole')]")private static WebElement custom_team_staff_role_name;
	public Verify add_Custom_Team_Staff() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		funcs.senddata(driver, custom_team_staff_role_name, "VP"+BSB_TestData.randomAlpha(3));
		funcs.clickon_element(driver, add_custom_team_staff);
		return new Verify(driver);
	}

	@FindBy(xpath="//span[text()='No']")private static List<WebElement> select_team_staff_roles;
	public Verify add_Team_Staff() {
		// TODO Auto-generated method stub
		add_Custom_Team_Staff();
		funcs.waitforseconds(8);
		select_team_staff_roles.get(1).click();
		select_team_staff_roles.get(2).click();
		click_on_save_setting();
		LogClass.logExtent("==> Added Team Staff Standard and Custom Positions ");
		return new Verify(driver);
	}

	@FindBy(xpath="//input[contains(@data-bind,': DivisionName')]")private static WebElement division_name;
	@FindBy(xpath="//input[contains(@data-bind,'value: OpenRegistration')]")private static List<WebElement> registration_start_dateandtime;
	@FindBy(xpath="//input[contains(@data-bind,'value: CloseRegistration')]")private static List<WebElement> registration_close_dateandtime;
	@FindBy(xpath="//input[contains(@data-bind,'value: StartDate')]")private static WebElement season_start_date;
	@FindBy(xpath="//input[contains(@data-bind,'value: EndDate')]")private static WebElement season_end_date;
	@FindBy(xpath="//input[contains(@data-bind,'value: MinAge')]")private static WebElement minage;
	@FindBy(xpath="//input[contains(@data-bind,'value: MaxAge')]")private static WebElement maxage;
	@FindBy(xpath="//input[@class='BSBInput full-width priceInput']")private static WebElement division_price;
	@FindBy(xpath="//span[text()='Select']//..//div//b")private static WebElement click_select_gender;
	@FindBy(xpath="//li[text()='Coed']")private static WebElement select_coed;
	@FindBy(xpath="//span[text()='Save']")private static WebElement save_btn_div;
	@FindBy(xpath="//span[text()='Advanced']")private static WebElement advanced_btn;
	@FindBy(xpath="//input[contains(@id,'MaxPlayersTextBox')]")private static WebElement maxplayers;
	@FindBy(xpath="//a[text()='Fees & Discounts']")private static WebElement feesanddiscount_advanced_setting;
	@FindBy(xpath="//span[text()='No']")private static WebElement deposit_only_yes;
	@FindBy(xpath="//input[contains(@id,'txtDepositAmt')]")private static WebElement deposit_amount;
	@FindBy(xpath="//input[contains(@id,'EarlyBirdDeadlineDate')]")private static WebElement earlybird_discount_date;
	@FindBy(xpath="//input[contains(@id,'EarlyBirdDeadlineTime')]")private static WebElement earlybird_discount_time;
	@FindBy(xpath="//input[contains(@id,'txtEarlyBirdDiscount')]")private static WebElement early_bird_discount_amount;
	@FindBy(xpath="//input[contains(@id,'LateFeeDeadlineDate')]")private static WebElement late_fee_start_date;
	@FindBy(xpath="//input[contains(@id,'LateFeeDeadlineTime')]")private static WebElement late_fee_start_time;
	@FindBy(xpath="//input[contains(@id,'LateFeeAmt')]")private static WebElement late_fee_amount;
	@FindBy(xpath="//span[text()='Create New Payment Plan']")private static WebElement Create_New_Payment_Plan_btn;
	@FindBy(xpath="//input[contains(@data-bind,'PlanName')]")private static WebElement plan_name;
	@FindBy(xpath="//span[text()='Add New']")private static WebElement add_new_btn_payment_installment;
	@FindBy(xpath="//input[@name='Amount']")private static List<WebElement> installment_amount;
	@FindBy(xpath="//input[contains(@class,'installment-DueInDate')]")private static List<WebElement> installment_date;
	@FindBy(xpath="//span[text()='Finish']")private static WebElement finish_btn;
	@FindBy(xpath="//textarea")private static WebElement plan_description;
	public Verify add_Division_Details() {
		// TODO Auto-generated method stub
		
		funcs.waitforseconds(1);
		funcs.senddata(driver, division_name, "Div A with Plan");
		LogClass.logExtent("==> Entered Division Name ");
		funcs.senddata(driver, registration_start_dateandtime.get(0), BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Registration Start Date");
		funcs.senddata(driver, registration_start_dateandtime.get(1), "12:00 AM");
		LogClass.logExtent("==> Entered Registration Start Time");
		
		funcs.senddata(driver, registration_close_dateandtime.get(0), BSB_TestData.Future_Date());
		LogClass.logExtent("==> Entered Registration End Date");
		funcs.senddata(driver, registration_close_dateandtime.get(1), "12:00 AM");
		LogClass.logExtent("==> Entered Registration End Time");
		
		funcs.senddata(driver, season_start_date,BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Season Start Date");
		funcs.senddata(driver, season_end_date,BSB_TestData.Future_Date());
		LogClass.logExtent("==> Entered Season End Date");
		
		funcs.senddata(driver, minage, "01/01/2020");
		LogClass.logExtent("==> Entered Minage Date");
		funcs.senddata(driver, maxage,"01/01/2000");
		LogClass.logExtent("==> Entered Maxage Date");
		
		funcs.senddata(driver, division_price, "100");
		LogClass.logExtent("==> Entered Division Price");
		
		funcs.clickon_element(driver, click_select_gender);
		funcs.waitforseconds(1);
		click_select_gender.click();
		funcs.clickon_element(driver, select_coed);
		LogClass.logExtent("==> Selected the Gender");
		funcs.waitforseconds(1);
		select_coed.click();
		funcs.clickon_element_wid(driver, save_btn_div);
		
		funcs.clickon_element(driver, advanced_btn);
		LogClass.logExtent("==> Click on Advanced Button");
		funcs.waitforseconds(1);
		funcs.senddata(driver, maxplayers, "1");
		LogClass.logExtent("==> Entered Max players number");
		
		click_on_save_setting();
		
		funcs.waitforseconds(5);
		deposit_only_yes.click();
		LogClass.logExtent("==> Click on Deposit Only Yes");
		funcs.waitforseconds(3);
		
		funcs.senddata(driver, deposit_amount, "25");
		LogClass.logExtent("==> Entered Deposit Amount");
		
		funcs.senddata(driver, earlybird_discount_date, BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Early Bird Discount Date");
		
		funcs.senddata(driver,earlybird_discount_time, "12:00 PM");
		LogClass.logExtent("==> Entered Early Bird Discount Time");
		
		funcs.senddata(driver, early_bird_discount_amount, "10");
		LogClass.logExtent("==> Entered Early Bird Discount Amount");
		
		funcs.senddata(driver, late_fee_start_date, BSB_TestData.Future_Date_one_month());
		LogClass.logExtent("==> Entered Late Fee Start Date");
		
		funcs.senddata(driver, late_fee_start_time, "12:00 PM");
		LogClass.logExtent("==> Entered Late Fee Start Time");
		
		funcs.senddata(driver, late_fee_amount, "35");
		LogClass.logExtent("==> Entered Late Fee Amount");
		
		
		click_on_save_setting();
		LogClass.logExtent("==> Saved the Division Setting");
		
		funcs.waitforseconds(5);
		deposit_only_yes.click();
		LogClass.logExtent("==> Enable Wait List Yes");
		
		click_on_save_setting();
		LogClass.logExtent("==> Saved the Division Setting");
		
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, Create_New_Payment_Plan_btn);
		LogClass.logExtent("==> Clicked on Create New Payment Plan Button");
		
		funcs.senddata(driver, plan_name, "Easy Pay");
		LogClass.logExtent("==> Entered Payment Plan Name");
		
		for(int i=0; i<=2;i++) {
		funcs.clickon_element(driver, add_new_btn_payment_installment);
		LogClass.logExtent("==> Clicked on Add New button for the payment installment");
		funcs.waitforseconds(1);}
		
		for(WebElement ele:installment_amount) {
			funcs.senddata(driver, ele, "20");
		}
		LogClass.logExtent("==> Entered Installment Amount");
		
		funcs.senddata(driver,installment_date.get(0),BSB_TestData.Today_Date());
		funcs.senddata(driver,installment_date.get(1),BSB_TestData.Future_Date_one_month());
		funcs.senddata(driver,installment_date.get(2),BSB_TestData.Future_Date());
		funcs.senddata(driver,installment_date.get(3),BSB_TestData.Future_Date_three_month());
		funcs.senddata(driver,installment_date.get(4),BSB_TestData.Future_Date_four_month());
		
		LogClass.logExtent("==> Entered Installment Dates");
		
		funcs.senddata(driver, plan_description, "This is plan Description for the payment plan");
		LogClass.logExtent("Entered Plan Description for the Payment Plan");
		funcs.waitforseconds(1);
		
		funcs.clickon_element(driver, save_btn_div);
		LogClass.logExtent("==> Clicked on Save button");
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, finish_btn);
		LogClass.logExtent("==> Clicked on Finish button");
		
		funcs.waitforseconds(7);
		funcs.clickon_element(driver, finish_btn);
		LogClass.logExtent("==> Clicked on Finish button");
		
		return new Verify(driver);
	}

	
	@FindBy(xpath="//input[contains(@id,'txtDepositAmt')]")private static WebElement deposit_amount1;
	@FindBy(xpath = "//input[contains(@id,'txtTryoutFeeAmt')]") private static WebElement tryoutFee_amount;
	
	public Verify add_Division_Details_Tryout() {
		// TODO Auto-generated method stub
		
		funcs.waitforseconds(1);
		funcs.senddata(driver, division_name, "Div A with Plan");
		LogClass.logExtent("==> Entered Division Name ");
		funcs.senddata(driver, registration_start_dateandtime.get(0), BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Registration Start Date");
		funcs.senddata(driver, registration_start_dateandtime.get(1), "12:00 AM");
		LogClass.logExtent("==> Entered Registration Start Time");
		
		funcs.senddata(driver, registration_close_dateandtime.get(0), BSB_TestData.Future_Date());
		LogClass.logExtent("==> Entered Registration End Date");
		funcs.senddata(driver, registration_close_dateandtime.get(1), "12:00 AM");
		LogClass.logExtent("==> Entered Registration End Time");
		
		funcs.senddata(driver, season_start_date,BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Season Start Date");
		funcs.senddata(driver, season_end_date,BSB_TestData.Future_Date());
		LogClass.logExtent("==> Entered Season End Date");
		
		funcs.senddata(driver, minage, "01/01/2020");
		LogClass.logExtent("==> Entered Minage Date");
		funcs.senddata(driver, maxage,"01/01/2000");
		LogClass.logExtent("==> Entered Maxage Date");
		
		funcs.senddata(driver, division_price, "100");
		LogClass.logExtent("==> Entered Division Price");
		
		funcs.clickon_element(driver, click_select_gender);
		funcs.waitforseconds(1);
		click_select_gender.click();
		funcs.clickon_element(driver, select_coed);
		LogClass.logExtent("==> Selected the Gender");
		funcs.waitforseconds(1);
		select_coed.click();
		funcs.clickon_element_wid(driver, save_btn_div);
		
		funcs.clickon_element(driver, advanced_btn);
		LogClass.logExtent("==> Click on Advanced Button");
		funcs.waitforseconds(1);
		funcs.senddata(driver, maxplayers, "1");
		LogClass.logExtent("==> Entered Max players number");
		
		click_on_save_setting();
		
		funcs.waitforseconds(5);
		
		deposit_only_yes.click();
		LogClass.logExtent("==> Click on Deposit Only Yes");
		funcs.waitforseconds(5);
		
		funcs.senddata(driver, deposit_amount1, "25");
		LogClass.logExtent("==> Entered Deposit Amount");

		funcs.senddata(driver, tryoutFee_amount, "25");
		LogClass.logExtent("==> Entered Deposit Amount");
		
		funcs.senddata(driver, earlybird_discount_date, BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Early Bird Discount Date");
		
		funcs.senddata(driver,earlybird_discount_time, "12:00 PM");
		LogClass.logExtent("==> Entered Early Bird Discount Time");
		
		funcs.senddata(driver, early_bird_discount_amount, "10");
		LogClass.logExtent("==> Entered Early Bird Discount Amount");
		
		funcs.senddata(driver, late_fee_start_date, BSB_TestData.Future_Date_one_month());
		LogClass.logExtent("==> Entered Late Fee Start Date");
		
		funcs.senddata(driver, late_fee_start_time, "12:00 PM");
		LogClass.logExtent("==> Entered Late Fee Start Time");
		
		funcs.senddata(driver, late_fee_amount, "35");
		LogClass.logExtent("==> Entered Late Fee Amount");
		
		funcs.waitforseconds(5);
		click_on_save_setting();
		LogClass.logExtent("==> Saved the Division Setting");
		
		
		//click_on_save_setting();
		//LogClass.logExtent("==> Saved the Division Setting");
		
		funcs.waitforseconds(5);
		//funcs.waitforseconds(1);
		funcs.clickon_element(driver, Create_New_Payment_Plan_btn);
		LogClass.logExtent("==> Clicked on Create New Payment Plan Button");
		
		funcs.senddata(driver, plan_name, "Easy Pay");
		LogClass.logExtent("==> Entered Payment Plan Name");
		
		for(int i=0; i<=2;i++) {
		funcs.clickon_element(driver, add_new_btn_payment_installment);
		LogClass.logExtent("==> Clicked on Add New button for the payment installment");
		funcs.waitforseconds(1);}
		
		for(WebElement ele:installment_amount) {
			funcs.senddata(driver, ele, "20");
		}
		LogClass.logExtent("==> Entered Installment Amount");
		
		funcs.senddata(driver,installment_date.get(0),BSB_TestData.Today_Date());
		funcs.senddata(driver,installment_date.get(1),BSB_TestData.Future_Date_one_month());
		funcs.senddata(driver,installment_date.get(2),BSB_TestData.Future_Date());
		funcs.senddata(driver,installment_date.get(3),BSB_TestData.Future_Date_three_month());
		funcs.senddata(driver,installment_date.get(4),BSB_TestData.Future_Date_four_month());
		
		LogClass.logExtent("==> Entered Installment Dates");
		
		funcs.senddata(driver, plan_description, "This is plan Description for the payment plan");
		LogClass.logExtent("Entered Plan Description for the Payment Plan");
		funcs.waitforseconds(1);
		
		funcs.clickon_element(driver, save_btn_div);
		LogClass.logExtent("==> Clicked on Save button");
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, finish_btn);
		LogClass.logExtent("==> Clicked on Finish button");
		
		funcs.waitforseconds(7);
		funcs.clickon_element(driver, finish_btn);
		LogClass.logExtent("==> Clicked on Finish button");
		
		return new Verify(driver);
	}
	
	
	   public Verify add_Division_Details_TeamCoach() {
		// TODO Auto-generated method stub
		
		funcs.waitforseconds(1);
		funcs.senddata(driver, division_name, "Div A with Plan");
		LogClass.logExtent("==> Entered Division Name ");
		funcs.senddata(driver, registration_start_dateandtime.get(0), BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Registration Start Date");
		funcs.senddata(driver, registration_start_dateandtime.get(1), "12:00 AM");
		LogClass.logExtent("==> Entered Registration Start Time");
		
		funcs.senddata(driver, registration_close_dateandtime.get(0), BSB_TestData.Future_Date());
		LogClass.logExtent("==> Entered Registration End Date");
		funcs.senddata(driver, registration_close_dateandtime.get(1), "12:00 AM");
		LogClass.logExtent("==> Entered Registration End Time");
		
		funcs.senddata(driver, season_start_date,BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Season Start Date");
		funcs.senddata(driver, season_end_date,BSB_TestData.Future_Date());
		LogClass.logExtent("==> Entered Season End Date");
		
		funcs.senddata(driver, minage, "01/01/2020");
		LogClass.logExtent("==> Entered Minage Date");
		funcs.senddata(driver, maxage,"01/01/2000");
		LogClass.logExtent("==> Entered Maxage Date");
		
		funcs.senddata(driver, division_price, "100");
		LogClass.logExtent("==> Entered Division Price");
		
		funcs.clickon_element(driver, click_select_gender);
		funcs.waitforseconds(1);
		click_select_gender.click();
		funcs.clickon_element(driver, select_coed);
		LogClass.logExtent("==> Selected the Gender");
		funcs.waitforseconds(1);
		select_coed.click();
		funcs.clickon_element_wid(driver, save_btn_div);
		
		funcs.clickon_element(driver, advanced_btn);
		LogClass.logExtent("==> Click on Advanced Button");
		funcs.waitforseconds(1);
		//funcs.senddata(driver, maxplayers, "1");
		//LogClass.logExtent("==> Entered Max players number");
		
		click_on_save_setting();
		
		funcs.waitforseconds(8);
		deposit_only_yes.click();
		LogClass.logExtent("==> Click on Deposit Only Yes");
		funcs.waitforseconds(5);
		
		funcs.senddata(driver, deposit_amount, "25");
		LogClass.logExtent("==> Entered Deposit Amount");
	
		funcs.senddata(driver, earlybird_discount_date, BSB_TestData.Today_Date());
		LogClass.logExtent("==> Entered Early Bird Discount Date");
		
		funcs.senddata(driver,earlybird_discount_time, "12:00 PM");
		LogClass.logExtent("==> Entered Early Bird Discount Time");
		
		funcs.senddata(driver, early_bird_discount_amount, "10");
		LogClass.logExtent("==> Entered Early Bird Discount Amount");
		
		funcs.senddata(driver, late_fee_start_date, BSB_TestData.Future_Date_one_month());
		LogClass.logExtent("==> Entered Late Fee Start Date");
		
		funcs.senddata(driver, late_fee_start_time, "12:00 PM");
		LogClass.logExtent("==> Entered Late Fee Start Time");
		
		funcs.senddata(driver, late_fee_amount, "35");
		LogClass.logExtent("==> Entered Late Fee Amount");
		
		funcs.waitforseconds(5);
		click_on_save_setting();
		LogClass.logExtent("==> Saved the Division Setting");
		
		
		//click_on_save_setting();
		//LogClass.logExtent("==> Saved the Division Setting");
		
		funcs.waitforseconds(5);
		//funcs.waitforseconds(1);
		funcs.clickon_element(driver, Create_New_Payment_Plan_btn);
		LogClass.logExtent("==> Clicked on Create New Payment Plan Button");
		
		funcs.senddata(driver, plan_name, "Easy Pay");
		LogClass.logExtent("==> Entered Payment Plan Name");
		
		for(int i=0; i<=2;i++) {
		funcs.clickon_element(driver, add_new_btn_payment_installment);
		LogClass.logExtent("==> Clicked on Add New button for the payment installment");
		funcs.waitforseconds(1);}
		
		for(WebElement ele:installment_amount) {
			funcs.senddata(driver, ele, "20");
		}
		LogClass.logExtent("==> Entered Installment Amount");
		
		funcs.senddata(driver,installment_date.get(0),BSB_TestData.Today_Date());
		funcs.senddata(driver,installment_date.get(1),BSB_TestData.Future_Date_one_month());
		funcs.senddata(driver,installment_date.get(2),BSB_TestData.Future_Date());
		funcs.senddata(driver,installment_date.get(3),BSB_TestData.Future_Date_three_month());
		funcs.senddata(driver,installment_date.get(4),BSB_TestData.Future_Date_four_month());
		
		LogClass.logExtent("==> Entered Installment Dates");
		
		funcs.senddata(driver, plan_description, "This is plan Description for the payment plan");
		LogClass.logExtent("Entered Plan Description for the Payment Plan");
		funcs.waitforseconds(1);
		
		funcs.clickon_element(driver, save_btn_div);
		LogClass.logExtent("==> Clicked on Save button");
	
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, finish_btn);
		LogClass.logExtent("==> Clicked on Finish button");
		
		return new Verify(driver);
	}
	
	@FindBy(xpath="//span[text()='Copy']")private static WebElement copy_btn;
	@FindBy(xpath="//input[@name='ko_unique_3']")private static WebElement per_player_toggle;
	public Verify copy_Division_Details_TeamCoach() {
		// TODO Auto-generated method stub
		
				funcs.waitforseconds(1);
				funcs.clickon_element(driver, copy_btn);
				LogClass.logExtent("==> Clicked on Copy button");
				
				funcs.waitforseconds(3);
				funcs.clickon_element(driver, per_player_toggle);
				LogClass.logExtent("==> Clicked on per_player_Toggle");
				
				funcs.clickon_element(driver, save_btn_div);
				LogClass.logExtent("==> Clicked on Save button");
				
				funcs.waitforseconds(5);
				funcs.clickon_element(driver, finish_btn);
				LogClass.logExtent("==> Clicked on Finish button");
				return new Verify(driver);
	}
	
	
	@FindBy(xpath="//i[@class='icn icn-tournament-archive']")private static List<WebElement> archive_button;
	public Verify click_archive_program_button_new_Logic() {
		// TODO Auto-generated method stub
		int count = 0;
		LogClass.logExtent("==> Total Programs in this Portal : "+archive_button.size());
		for(int i=0;i<=archive_button.size()-25;i++) {
			//funcs.waitforseconds(5);
			WebElement ele = driver.findElement(By.xpath("//i[@class='icn icn-tournament-archive']"));
			funcs.clickon_element(driver,ele);
			LogClass.logExtent("==> Clicked on Archive Program Button");
			funcs.waitforseconds(6);
			count++;
			LogClass.logExtent("==> "+count+" Program Archived");
		}
		return new Verify(driver);
	}

	@FindBy(xpath = "//a[text()='Email']")private static List<WebElement> email_Menu;
	@FindBy(xpath = "//a[text()='Bulk Email']")private static WebElement Bulkmail;
	@FindBy(xpath = "//a[contains(@id,'AddLinkButton')]")private static List<WebElement> Select_Program;
	@FindBy(xpath = "//div[@class='row']//textarea[contains(@class,'form-control')]") private static WebElement additinal_EmailID;
	@FindBy(xpath = "//input[contains(@size,'40')]")private static WebElement Subject;
	@FindBy(xpath = "//div[@class='RadAjaxPanel']//a[text()='Select a Template']")private static WebElement Template;
	@FindBy(xpath = "//tbody//div[@class='RadAjaxPanel']//a[text()='Edit']")private static List<WebElement> Edit_Template;
	@FindBy(xpath = "//div[@class='newFileUpload']//a[@id='attachFileLink']")private static WebElement Attachment;
	@FindBy(xpath = "//div[@class='pull-right']//a[span[@class='icn icn-tournament-true']]")private static WebElement SendEmail;
	public Verify bulkmail() throws AWTException {
		// TODO Auto-generated method stub
		funcs.waitforseconds(4);
		System.out.println("Bulk_mail fuctioncall");
		funcs.mousehover_on_element(driver, email_Menu.get(0));
		LogClass.logExtent("==> Mouse hover on menu");
		funcs.waitforseconds(4);
		funcs.clickon_element(driver, Bulkmail);
		LogClass.logExtent("==> Click on Bulkmail");
		funcs.waitforseconds(8);
		funcs.clickon_element(driver, Select_Program.get(0));
		LogClass.logExtent("==> Select program");
		funcs.waitforseconds(13);
		funcs.senddata(driver, additinal_EmailID, "itw.hiralm@gmail.com;vipulmailinator@mailinator.com;ti.harshidd@gmail.com;\n" + 
				"itw.minalp@gmail.com;\n" + 
				"itw.rudrim@gmail.com;\n" + 
				"itw.hiralm@gmail.com;\n" + 
				"itw.krishnapatel@gmail.com;\n" + 
				"mrudul@idea2working.com;\n" + 
				"Itw.durvab@gmail.com;\n" + 
				"Itw.vipulp@gmail.com");
		LogClass.logExtent("==> Enter Email ID for Additional Recipients");
		funcs.waitforseconds(5);
		
		String subjectportal = testUrl.substring(8, 13);
		funcs.senddata(driver, Subject, subjectportal +" Test Bulkmail " + BSB_TestData.Today_Date());
		LogClass.logExtent("==> Enter Subject name");
		
		funcs.senddata(driver, reply_to, "vipul@mailinator.com");
		LogClass.logExtent("==> Enter Reply To Email address");
		
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, Template);
		LogClass.logExtent("==> Click on template");
		funcs.waitforseconds(11);
		funcs.clickon_element(driver, Edit_Template.get(0));
		LogClass.logExtent("==> Click on Edit_button");
		funcs.waitforseconds(12);
		Actions ac = new Actions(driver);
		ac.moveToElement(Attachment).build().perform();
		funcs.waitforseconds(3);
		String path ="Resources/Images/Bulkmail_AattachmentFile.jpg";
		path = funcs.getabsolutepathforfile(path);
		System.out.println("path= " +path);
		Attachment.click();
	    LogClass.logExtent("==> Click on Attachment");
        funcs.waitforseconds(5);
        funcs.uploadthefile_robot_class(path);            
		funcs.waitforseconds(11);
		funcs.clickon_element(driver, SendEmail);
	    LogClass.logExtent("==> Click on SendEmail");
		funcs.waitforseconds(10);  
		return new Verify(driver);
	}

	//Schedule_ mail
	
		@FindBy(xpath = "//a[text()='Email']")private static List<WebElement> email_Menu1;
		@FindBy(xpath = "//a[text()='Email Statistics']")private static WebElement EmailStatistics;
		@FindBy(xpath = "//a[text()='Resend']")private static WebElement Resend;
		@FindBy(xpath = "//input[contains(@size,'40')]")private static WebElement ScheduleSubject;
		@FindBy(xpath="//input[contains(@id,'BulkEmail_txtReplyTo')]")private static WebElement reply_to;
		@FindBy(xpath = "//a[@class='bsb-btn btn-default btn-tournament btn-tournament-orange h-s-r-margin sendEmail']")private static WebElement Schedule_Email;
		@FindBy(xpath = "//div[span[@class='form-control-feedback']]")private static WebElement Date;
		@FindBy(xpath = "//input[@id='scheduleTime']")private static WebElement EnterTime;
		@FindBy(xpath = "//a[@class='bsb-btn btn-transparent btn-tournament btn-tournament-orange btn-blue h-s-l-margin']")private static WebElement Save_Button;
		public Verify schedulemail() {
			// TODO Auto-generated method stub
			//driver.navigate().refresh();
			//funcs.waitforseconds(3);
			Actions action = new Actions(driver);
			System.out.println("Bulk_mail fuctioncall");
			funcs.waitforseconds(3);
			funcs.mousehover_on_element(driver, email_Menu1.get(0));
			LogClass.logExtent("==> Mouse hover on menu");
			funcs.waitforseconds(4);
			funcs.clickon_element(driver, EmailStatistics);
			LogClass.logExtent("==> Click on Email Statistics");
			funcs.waitforseconds(3);
			driver.navigate().refresh();	
			funcs.waitforseconds(5);
			funcs.clickon_element(driver, Resend);
			LogClass.logExtent("==> Click on Resend");
			funcs.waitforseconds(10);
			Subject.clear();
			//funcs.waitforseconds(3);
			String subjectportal = testUrl.substring(8, 13);
			funcs.senddata(driver, ScheduleSubject, subjectportal +" Test_Schedulemail "+BSB_TestData.Today_Date());
			LogClass.logExtent("==> Enter Subject name");
			
			funcs.senddata(driver, reply_to, "vipul@mailinator.com");
			LogClass.logExtent("==> Enter Reply To Email address");
			
			funcs.waitforseconds(3);
			funcs.clickon_element(driver, Schedule_Email);
			LogClass.logExtent("==> Click on Schedule_email");
			funcs.waitforseconds(10);
			
			Date.click();
			funcs.waitforseconds(5);
			action.sendKeys(Keys.ENTER).build().perform();
			funcs.waitforseconds(2);
			LogClass.logExtent("==> Click on Date");
			
			String time=BSB_TestData.TimeFormate();
			funcs.senddata(driver, EnterTime, time);
			LogClass.logExtent("==> EnterTime");
			funcs.waitforseconds(2);
			
			Save_Button.click();
			LogClass.logExtent("==> Click on save button");
			funcs.waitforseconds(3);
			return new Verify(driver);
		}

	
	
}//End of Class
