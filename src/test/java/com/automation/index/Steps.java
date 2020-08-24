package com.automation.index;
import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.init.BSB_SeleniumInit;
import com.automation.utility.BSB_TestData;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.ExtentTest;
import com.sun.corba.se.spi.orbutil.fsm.Action;


public class Steps extends BSB_SeleniumInit {

	
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
// ===> Program Creation Mudule Test Cases
//Login Module Test Cases , dependsOnMethods = { "Signin_TestCase_02" }
	@Test(priority = 0, enabled = true, groups ="program")
	public void Program_TestCase_01() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to create the NGB program[Soccer | US Youth Soccer]";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore();
		veri.homepageverify();
		veri = logic.login_as_admin();
		veri = logic.click_new_program_plus_sign();
		veri = logic.click_Create_Non_Tryout_Rec_Program();
		veri = logic.enter_program_name("NT_USYS");
		veri = logic.select_activity_type("Soccer");
		veri = logic.select_national_affilation("US Youth Soccer");
		veri = logic.select_state_affilation("Blue Sombrero Integration"); 
		veri = logic.select_Organization("BSB United");
		veri = logic.select_club("BSB UTD - 01");
		veri = logic.select_Season("Spring 2020");
		veri = logic.select_play_Level("Recreational");
	}// End of Program_TestCase_01.
	
	@Test(priority = 0, enabled = true, groups ="program")
	public void Program_TestCase_02() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to create the NGB program[Football | Pop worner]";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore();
		veri.homepageverify();
		veri = logic.login_as_admin();
		veri = logic.click_new_program_plus_sign();
		veri = logic.click_Create_Non_Tryout_Rec_Program();
		veri = logic.enter_program_name("NT_FBallPoppWorner");
		veri = logic.select_activity_type("Football");
		veri = logic.select_national_affilation("Pop Warner");
		veri = logic.select_Region("Sports Connect Demo Region");
		veri = logic.select_League("Sports Connect Demo League");
		veri = logic.select_Season("2020 Spring/Year Round");
	}// End of Program_TestCase_02.
	
	@Test(priority = 0, enabled = true, groups ="program")
	public void Program_TestCase_03() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to create the NGB program[Baseball | PONY Baseball]";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore();
		veri.homepageverify();
		veri = logic.login_as_admin();
		veri = logic.click_new_program_plus_sign();
		veri = logic.click_Create_Non_Tryout_Rec_Program();
		veri = logic.enter_program_name("NT_BBALLPONY");
		veri = logic.select_activity_type("Baseball");
		veri = logic.select_national_affilation("PONY Baseball");
		veri = logic.select_Association("National City Pony");
	}// End of Program_TestCase_03.

	@Test(priority = 0, enabled = true, groups ="program")
	public void Program_TestCase_04() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to create program[Baseball | Little League]";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore();
		veri.homepageverify();
		veri = logic.login_as_admin();
		veri = logic.click_new_program_plus_sign();
		veri = logic.click_Create_Non_Tryout_Rec_Program();
		veri = logic.enter_program_name("NT_BBallLL");
		veri = logic.select_activity_type("Baseball");
		veri = logic.select_national_affilation("Little League Baseball");
	}// End of Program_TestCase_04.
	
	@Test(priority = 0, enabled = true, groups ="program")
	public void Program_TestCase_05() {
		step = 1;
		String report_msg;// String for the log in the Report
		report_msg = "To verify that user is able to create Tryout Program";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore();
		veri.homepageverify();
		veri = logic.login_as_admin();
		veri = logic.click_new_program_plus_sign();
		veri = logic.click_Create_Tryout_Competitive_Program();
		veri = logic.enter_program_name("TRYOUT");
		veri = logic.select_activity_type("Baseball");
		veri = logic.select_national_affilation("American Legion Baseball");
	}// End of Program_TestCase_05.
	
	@Test(priority = 0, enabled = true, groups ="program")
	public void Program_TestCase_06() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to create Non Tryout Program";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore();
		veri.homepageverify();
		veri = logic.login_as_admin();
		veri = logic.click_new_program_plus_sign();
		veri = logic.click_Create_Non_Tryout_Rec_Program();
		veri = logic.enter_program_name("NT");
		veri = logic.select_activity_type("Baseball");
		veri = logic.select_national_affilation("American Legion Baseball");
		veri = logic.click_next_btn_Program_creation();
		veri = logic.click_add_new_question_btn_Program_creation();
		veri = logic.Add_question_for_Program_creation();
		veri = logic.click_next_btn_Program_creation();
		veri = logic.Add_Special_Discount_or_Fee();
		veri = logic.click_next_btn_Program_creation();
		veri = logic.add_Team_Staff();
		veri = logic.click_next_btn_Program_creation();
		veri = logic.click_next_btn_Program_creation();
		veri = logic.add_Division_Details();
		funcs.waitforseconds(5);
	}// End of Program_TestCase_06.
	
	@Test(priority = 0, enabled = true, groups ="portal")
	public void Portal_Creation_TestCase_01() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to create as maany Portals on Any Server";
		LogClass.logExtent(report_msg);
		veri = logic.production();
		
		List<WebElement> sclogo = driver.findElements(By.xpath("//img[@alt='Sports Connect']"));
		sclogo.get(1).click();
		System.out.println("==> Click on Sports Connect logo");
		
		String min = BSB_TestData.getURL(9,1);
		String max = BSB_TestData.getURL(10,1);
		
		System.out.println("==> Range from "+min+" to "+max);
		
		funcs.waitforseconds(6);
		List<WebElement> clickonhost = driver.findElements(By.xpath("//span[text()='Host']"));
		funcs.clickon_element(driver, clickonhost.get(1));
		System.out.println("==> Click on Host");
		
		for(int i=Integer.valueOf(min);i<=Integer.valueOf(max);i++)
		{
		
		funcs.waitforseconds(6);
		WebElement clickonhost_1 = driver.findElement(By.xpath("//span[text()='Host']"));
		funcs.clickon_element(driver, clickonhost_1);
		System.out.println("==> Click on Host");
		
		funcs.waitforseconds(5);
		WebElement site_mmt = driver.findElement(By.xpath("//span[text()='Host']//..//li//a[text()='Site Management']"));
		funcs.clickon_element(driver, site_mmt);
		System.out.println("==> Click on Site Management");
		
		funcs.waitforseconds(7);
		WebElement add_new_site = driver.findElement(By.xpath("//a[text()='Add New Site']"));
		funcs.clickon_element(driver, add_new_site);
		System.out.println("==> Click on Add New Site");
		
		funcs.waitforseconds(7);
		WebElement click_on_child = driver.findElement(By.xpath("//label[text()='Child']//..//input[2]"));
		funcs.clickon_element(driver, click_on_child);
		System.out.println("==> Select the Child");	
		
		funcs.waitforseconds(7);
		WebElement enter_site_alias = driver.findElement(By.xpath("//input[contains(@id,'Signup_txtPortalAlias')]"));
		String getsitealiaslink = enter_site_alias.getAttribute("value");
		System.out.println("Site Alias :"+getsitealiaslink);
		funcs.senddata(driver, enter_site_alias, getsitealiaslink+BSB_TestData.getURL(11,1)+i);
		System.out.println("==> Enter Port site alias :"+"Demo"+i);
		
		WebElement enter_title = driver.findElement(By.xpath("//input[contains(@id,'Signup_txtPortalName')]"));
		funcs.senddata(driver, enter_title, BSB_TestData.getURL(12,1)+i);
		System.out.println("==> Entere Title Name :"+"Demo"+i);
		
		funcs.waitforseconds(5);
		WebElement click_on_tem = driver.findElement(By.xpath("//input[contains(@id,'Signup_cboTemplate_Input')]"));
		funcs.jsClick(driver, click_on_tem);
		click_on_tem.click();
		System.out.println("==> Click to select the Template");
		
		funcs.waitforseconds(5);
		WebElement select_tem = driver.findElement(By.xpath("//li[text()='BSB-ClubHomeProfessional']"));
		funcs.jsClick(driver, select_tem );
		System.out.println("==> Select the Template :"+select_tem.getText());
		
		funcs.waitforseconds(8);
		WebElement click_on_create_site = driver.findElement(By.xpath("//a[@title='Create Site']"));
		//funcs.clickon_element(driver, click_on_create_site);
		//click_on_create_site.click();
		funcs.jsClick(driver, click_on_create_site);
		System.out.println("==> Click on Create Site");
		
		System.out.println("==> Waiting for 100 seconds");
		
		funcs.waitforseconds(5);
		LogClass.makeScreenshot_without_fail(driver, "Demo"+i);
		
		funcs.waitforseconds(110);
		driver.navigate().refresh();
		
		funcs.waitforseconds(2);
		
		}//End of for loop	
		
	}// End of Portal_Creation_TestCase_01.
	
	
	@Test(priority = 0, enabled = true, groups ="deleteprogram")
	public void Delete_Program_TestCase_01() {
		step = 1;
		String report_msg;// String for the log in the Report		
		report_msg = "To verify that user is able to create Non Tryout Program";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore();
		veri.homepageverify();
		veri = logic.login_as_admin();
		veri = logic.click_archive_program_button_new_Logic();
		funcs.waitforseconds(5);
	}// Delete_Program_TestCase_01.
	
	@Test(priority = 0, enabled = true, groups ="Bulkmail")
	public void Bulkmail_TestCase_01() throws AWTException {
		step = 1;
		String report_msg;// String for the log in the Report	
		for(int i=4;i<=4;i=i+2) {	
		report_msg = "To verify that user is able to do the bulkmail";
		LogClass.logExtent(report_msg);
		veri = logic.geturlforcore_Bulkmail(i+14,1);
		veri.homepageverify();
		veri = logic.login_as_admin_bulkmail(i+15);
		veri = logic.bulkmail();
		funcs.waitforseconds(5);
		veri = logic.schedulemail();
		funcs.waitforseconds(5);
		}
	}// Bulkmail_TestCase_01.
	
	
}// End of Class
