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
	
	
}//End of Class
