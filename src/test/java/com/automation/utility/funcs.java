package com.automation.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.glass.ui.Clipboard;


import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.datatransfer.DataFlavor;

//This class have the Ready to Use functions which will give you highly re-usability of Code.

public class funcs {
	
	// All function for the Wait for the Elements with Different Wait Condition
	public static void waitforelementvisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitforelementclickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
		jsClick(driver, element);
	}

	public static void waitforelementclickable_withjsclick1(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
		jsClick_with_highlight(driver, element);
	}
	public static void waitforseconds(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {

		}
	}

	//mouse hover on the element
	public static void mousehover_on_element(WebDriver driver, WebElement element) {
		waitforelementvisible(driver, element);
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	

	//Perform Mouse Hover using javasript executer
	public static void mouseHoverUsingJS(WebDriver driver, WebElement ele) {
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript, ele);
	}

	//Clicks on visible or not visible element.
	public static void jsClick(WebDriver driver, WebElement element) {
		highlightElement(driver, element); //Remove the comment if you want to highlight the element.
		System.out.println("============Apply NOw:::::::::Test::::::"+element.getText());
		((JavascriptExecutor) driver).executeScript(
				"return arguments[0].click();", element);
		// this.waitForAjax("0");
	}
	
	
	public static void jsClick_with_highlight(WebDriver driver, WebElement element) {
		//highlightElement(driver, element); //Remove the comment if you want to highlight the element.
		System.out.println("============Apply NOw:::::::::Test::::::"+element.getText());
		((JavascriptExecutor) driver).executeScript(
				"return arguments[0].click();", element);
		// this.waitForAjax("0");
	}
	//Highlight the element and click on same
	public static void clickOn(WebDriver driver, WebElement element) {
		highlightElement(driver, element);
		waitforelementclickable(driver, element);
		element.click();
		FluentwaitForElementClickable(driver, element);// For Firefox
	}
	public static void FluentwaitForElementClickable(WebDriver driver, WebElement element) {
		
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).pollingEvery(4, TimeUnit.SECONDS)
		.withTimeout(30,TimeUnit.SECONDS)		
		.ignoring(ElementNotInteractableException.class);		
}
	//Highlight Element
	public static void highlightElement(WebDriver driver, WebElement element) {
		// draw a border around the found element
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid yellow'", element);
		waitforseconds(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '0px'", element);
	}
	
	
	// Function to Enter Data in the TextFields
	public static void senddata(WebDriver driver, WebElement element, String data) {
		waitforelementvisible(driver, element);
		//element.click();
		funcs.waitforseconds(1);
		element.clear();
		element.sendKeys(data);
	}
	
	//Function to Click on the Button/Menu/or any clickable Element 
	
	public static void clickon_element(WebDriver driver,WebElement element) {
		waitforelementclickable(driver, element);
		//element.click();
	} 
	
	public static void clickon_element_wid(WebDriver driver,WebElement element) {
		waitforelementclickable_withjsclick1(driver, element);
		//element.click();
	} 
	
	
	public static void doubleclick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	//get the attributes value's value	
	public static String getattributes_value(WebElement element) {
		return element.getAttribute("value");
	}

	// upload the file
	public static void uploadthefile(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		File file = new File(value);
		String absolutePath = file.getAbsolutePath();
		element.sendKeys(absolutePath);
	}
	
	// upload the file
		public static String getabsolutepathforfile(String value) {
			File file = new File(value);
			String absolutePath = file.getAbsolutePath();
			return absolutePath;
		}
	
	// upload the file using robot class
		public static void uploadthefile_robot_class(String value) throws AWTException {
			 // Specify the file location with extension
			 StringSelection sel = new StringSelection(value);
			 
			   // Copy to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
			 System.out.println("selection" +sel);
			 
			 // Create object of Robot class
			 Robot robot = new Robot();
			 waitforseconds(2);
			 
			  // Press CTRL+V
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 
			// Release CTRL+V
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_V);
			 waitforseconds(2);
			        
			 // Press Enter 
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
		}	
		
	//Scroll Horizontal by pixels
	
	public static void scrollBy_vertical(WebDriver driver,int y) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0," + y + ")", "");
		waitforseconds(3);
	}
	
	//Scroll vertical by pixels
		public static void scrollBy_horizontal(WebDriver driver,int y) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(" + y + ",0)", "");
			waitforseconds(3);
		}

	// Select data from dropwon or combobox by Value.
	public static void selectFromCombo(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	// Select data form dropdown or combobox by visible element
	public static void selectFromComboByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	// Select data form dropdown or combobox by Index
	public static void selectFromComboByIndex(WebElement element, int value) {
		Select select = new Select(element);
		select.selectByIndex(value);
		
	}
		
	// Select data form dropdown or combobox by visible element
		public static void selectFromComboByVisibleText_multi(WebDriver driver,WebElement element, String[] value) {
		Actions act = new Actions(driver);
		Select select = new Select(element);
		act.keyDown(Keys.CONTROL).build().perform();
		for (int i = 0; i<value.length; i++) {
			select.selectByVisibleText(value[i]);
			waitforseconds(4);
		}
		act.keyUp(Keys.CONTROL).build().perform();

		}
	
	
	// Function Write data into Text File
	/*
	 * Write data into the AccountInfo text file Start String fileName =
	 * "lib/AccountInfo.txt"; String[] data = { firstname, lastname, emailaddress };
	 * ReadyToUse_Functions.writedataintofile(fileName, data);
	 */
	public static void writedataintoTextFile(String filename, String[] data) {
		// TODO Auto-generated method stub
		// The name of the file to open.
		String fileName = filename;
		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// Note that write() does not automatically
			// append a newline character.
			for (int i = 0; i < data.length; i++) {
				bufferedWriter.write(data[i]);
				bufferedWriter.newLine();
			}
			// bufferedWriter.write("");
			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	// Function Read data from the Text File
	// You can call the ReadTextFile method using below steps
	/*
	 * String fileName = "lib/LoginDetails.txt"; ArrayList<String> data; data =
	 * ReadyToUse_Functions.ReadTextFile(fileName, 2);
	 */
	public static ArrayList<String> ReadTextFile(String filename, int nooflines) {
		String fileName = filename;
		// This will reference one line at a time
		String line = null;
		ArrayList<String> data = new ArrayList<String>();
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			for (int i = 1; i <= nooflines; i++) {
				if ((line = bufferedReader.readLine()) != null)
					data.add(line);
			}
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return data;
	}
	
	//Function to zip the Single File
	//see the steps to call the function
	/*System.out.println("Calling ZipFile for the Extent Report.........");
	//for the Extent Report Zip 
	String dataFilePath = "test-output/screenshots/Extent_Report_new.html";
	File datafile = new File(dataFilePath);
	String INPUT_FILE = datafile.getAbsolutePath();
	String dataFilePath1 = "test-output/screenshots/Extent_Report_new.zip";
	File datafile1 = new File(dataFilePath1);
	String OUTPUT_FILE = datafile1.getAbsolutePath();
    ReadyToUse_Functions.zipFile(new File(INPUT_FILE), OUTPUT_FILE); //This function Zip the single file
    //End for the Extent Report Zip use 
*/	
	public static void zipFile(File inputFile, String zipFilePath) {
        try {
 
            // Wrap a FileOutputStream around a ZipOutputStream
            // to store the zip stream to a file. Note that this is
            // not absolutely necessary
            FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
 
            // a ZipEntry represents a file entry in the zip archive
            // We name the ZipEntry after the original file's name
            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);
 
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            byte[] buf = new byte[1024];
            int bytesRead;
 
            // Read the input file by chucks of 1024 bytes
            // and write the read bytes to the zip stream
            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }
 
            // close ZipEntry to store the stream to the file
            zipOutputStream.closeEntry();
 
            zipOutputStream.close();
            fileOutputStream.close();
 
            System.out.println("Regular file :" + inputFile.getCanonicalPath()+" is zipped to archive :"+zipFilePath);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
// Zip single file function End
	
	
// Function to Zip the Directory/Folder
//Check the Common Class for this method
	
	// Function to use opne url in the new tab window
	public static void switchToNewtabWithUrl(WebDriver driver, String URL, int tab) {
		waitforseconds(5);
		System.out.println("===========" + System.getProperty("os.name"));
		((JavascriptExecutor) driver).executeScript("window.open();");
		//waitforseconds(2); //commented
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
		//waitforseconds(2);//commented
		driver.get(URL);
		waitforseconds(5);
	}
	
	public static void switchToNewtabWithUrl_ctrl_v(WebDriver driver, String URL, int tab) {
		waitforseconds(5);
		System.out.println("===========" + System.getProperty("os.name"));
		((JavascriptExecutor) driver).executeScript("window.open();");
		waitforseconds(2);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
		waitforseconds(2);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL+"v");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ENTER);
		//driver.get(URL);
		waitforseconds(5);
	}
	
	public static void switchTowindow(WebDriver driver, int tab) {
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
		
		driver.navigate().refresh();		
		waitforseconds(5);
	}
	
	//code to copy clipboard text to variable
	public static String getSysClipboardText() {
        String ret = "";
        java.awt.datatransfer.Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipTf = sysClip.getContents(null);
        if (clipTf != null) {
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    ret = (String) clipTf
                            .getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
	
	/*
	 public static String getClipboardContents() {
	        String result = "";
	        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        // odd: the Object param of getContents is not currently used
	        Transferable contents = clipboard.getContents(null);
	        boolean hasTransferableText = (contents != null)
	                && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
	        if (hasTransferableText) {
	            try {
	                result = (String) contents
	                        .getTransferData(DataFlavor.stringFlavor);
	            } catch (UnsupportedFlavorException | IOException ex) {
	                System.out.println(ex);
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }
	*/
	
	 public static String getstringfromclipboard() throws UnsupportedFlavorException, IOException {
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
			java.awt.datatransfer.Clipboard clipboard = toolkit.getSystemClipboard();
			String result = (String) clipboard.getData(DataFlavor.stringFlavor);
			System.out.println("String from Clipboard:" + result);
			return result;
	 }
	 	 
}//End of Ready To Use class
