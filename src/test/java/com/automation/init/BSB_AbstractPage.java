package com.automation.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;


public abstract class BSB_AbstractPage extends BSB_SeleniumInit {

	public int DRIVER_WAIT = 15;

	/**
	 * Initialize UserAbstractPage.
	 * 
	 * @param Driver
	 *            .
	 */
	
	public BSB_AbstractPage(WebDriver driver) {
		this.driver = driver;
		
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		
		PageFactory.initElements(finder, this);
		//System.out.println("======Abstract Page======");
	}
}
