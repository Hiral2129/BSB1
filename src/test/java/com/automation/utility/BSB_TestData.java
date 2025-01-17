package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automation.init.BSB_SeleniumInit;

public class BSB_TestData {

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static String numberofquantity(int row) {
		//System.out.println("Call Quantity.......");
		getExcelSheet(0).getRow(row).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
		return getExcelSheet(0).getRow(row).getCell(1).getStringCellValue();
	}
	
	public static String _totalqty(int row,int column) {
		//System.out.println("Call Quantity.......");
		getExcelSheet_total_Qty(0).getRow(row).getCell(column).setCellType(Cell.CELL_TYPE_STRING);
		return getExcelSheet_total_Qty(0).getRow(row).getCell(column).getStringCellValue();
	}

	public static Sheet getExcelSheet(int sheetIndex) {
		String dataFilePath = "Resources/Credential.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {
			//System.out.println("full path " + datafile.getAbsolutePath() + " con " + datafile.getCanonicalPath());
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheetIndex);
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
		}
		return firstSheet;
	}
	
	
	public static Sheet getExcelSheet_total_Qty(int sheetIndex) {
		//System.out.println("Call getExcelSheet total Qty function to read excel file");
		String dataFilePath = "Resources/Total_Qty_Calculation.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {
			//System.out.println("full path " + datafile.getAbsolutePath() + " con " + datafile.getCanonicalPath());
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheetIndex);
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
		}
		return firstSheet;
	}
	

	public static Sheet upload(int sheetIndex) {
		String dataFilePath = "Resources/firstname.txt";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {
			System.out.println("full path " + datafile.getAbsolutePath() + " con " + datafile.getCanonicalPath());
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheetIndex);
			workbook.close();
			inputStream.close();
		} catch (Exception e) {

		}
		return firstSheet;
	}

	// this function is used to change the value of the Excel sheet cell as per Test
	// Result
	public static void SheetResultcellupdate(int row_no, int cell_no, String value) {
		String dataFilePath = "Resources/[3DBroadCastSales]-Script_Result.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;
		try {
			System.out.println("full path " + datafile.getAbsolutePath() + " con " + datafile.getCanonicalPath());
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(1);
			Cell cell2Update = firstSheet.getRow(row_no).getCell(cell_no);
			cell2Update.setCellValue(value);
			inputStream.close();
			FileOutputStream output_file = new FileOutputStream(new File(fullpath));
			workbook.write(output_file);
			workbook.close();
			output_file.close();
			System.out.println("Sheet Cell Value is Updated");
		} catch (Exception e) {

		}

	}

	// this function set the all Test result to skipped before updating the Test
	// Result Sheet

	public static void SheetResultcellupdatetoskipped(int row) {

		String dataFilePath = "Resources/[3DBroadCastSales]-Script_Result.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {
			// System.out.println("full path " + datafile.getAbsolutePath() + " con " +
			// datafile.getCanonicalPath());
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(1);
			Cell cell2Update = firstSheet.getRow(row).getCell(3);
			cell2Update.setCellValue("Skipped");
			inputStream.close();
			FileOutputStream output_file = new FileOutputStream(new File(fullpath));
			workbook.write(output_file);
			workbook.close();
			output_file.close();
			System.out.println("All Sheet Cells Updated to Skipped Status");
		} catch (Exception e) {

		}

	}

//this function is calling the SheetResultcellupdatetoskipped function as per number of row
	public static void getnumberofrow() {
		String dataFilePath = "Resources/[3DBroadCastSales]-Script_Result.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;
		try {
			System.out.println("full path " + datafile.getAbsolutePath() + " con " + datafile.getCanonicalPath());
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(1);
			int noofrow = firstSheet.getLastRowNum();
			System.out.println("Number of rows :" + noofrow);
			inputStream.close();
			for (int i = 1; i < noofrow; i++) {
				SheetResultcellupdatetoskipped(i);
			}
		} catch (Exception e) {
		}

	}

	public static String getURL(int rowno,int col) {
		String testUrl;
		System.out.println("Call getURL.......");				
		//return getExcelSheet(0).getRow(rowno).getCell(1).getStringCellValue();
		getExcelSheet(0).getRow(rowno).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
		return getExcelSheet(0).getRow(rowno).getCell(col).getStringCellValue();
		
	}

	public static String getUserName() {

		return getExcelSheet(0).getRow(1).getCell(1).getStringCellValue();
	}

	public static String getPassword() {

		return getExcelSheet(0).getRow(2).getCell(1).getStringCellValue();
	}

	public static String getSenderName() {

		return getExcelSheet(0).getRow(5).getCell(1).getStringCellValue();
	}

	public static String getRandomDate() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		int fromday = cal.get(Calendar.DAY_OF_MONTH);
		int fromyear = cal.get(Calendar.YEAR);
		cal.add(Calendar.MONTH, 2);
		String day = String.valueOf(getDate(fromday));
		String month = BSB_TestData.getMonthD(cal.get(Calendar.MONTH));
		String year = String.valueOf(fromyear);
		return day + " " + month + " " + year;
	}

	public static int getDate(int fromday) {

		if (fromday < 10) {
			return 10 + (int) Math.round(Math.random() * (30 - 10));
		} else {
			return fromday;
		}
	}

	public static String getMonthD(int month) {
		switch (month) {
		case 1:
			return "Jan";

		case 2:
			return "Feb";

		case 3:
			return "Mar";

		case 4:
			return "Apr";

		case 5:
			return "May";

		case 6:
			return "Jun";

		case 7:
			return "Jul";

		case 8:
			return "Aug";

		case 9:
			return "Sep";

		case 10:
			return "Oct";

		case 11:
			return "Nov";

		case 12:
			return "Dec";

		default:
			return "Invalid month";

		}
	}

	public static String getDateConverted(String dateString) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = format1.parse(dateString);
		System.out.println(format2.format(date));
		return format2.format(date);
	}

	public static String getHeadless() {
		// TODO Auto-generated method stub
		try {
			return getExcelSheet(0).getRow(4).getCell(1).getStringCellValue();
		} catch (Exception e) {
			return "No";
		}
	}

	// Vipul
	public static String ts_firstname() {

		System.out.println("Call getURL.......");
		return getExcelSheet(1).getRow(0).getCell(1).getStringCellValue();
	}

	public static String ts_lastname() {

		System.out.println("Call getURL.......");
		return getExcelSheet(1).getRow(1).getCell(1).getStringCellValue();
	}

	public static String ts_emailaddress() {

		System.out.println("Call getURL.......");
		return getExcelSheet(1).getRow(2).getCell(1).getStringCellValue();
	}

	public static String ts_phone() {

		System.out.println("Call getURL.......");
		getExcelSheet(1).getRow(3).getCell(1).setCellType(Cell.CELL_TYPE_STRING);

		return getExcelSheet(1).getRow(3).getCell(1).getStringCellValue();
	}

	public static String ts_address() {

		System.out.println("Call getURL.......");
		return getExcelSheet(1).getRow(4).getCell(1).getStringCellValue();
	}

	public static String ts_city() {

		System.out.println("Call getURL.......");
		return getExcelSheet(1).getRow(5).getCell(1).getStringCellValue();
	}

	public static String ts_country() {

		System.out.println("Call getURL.......");
		return getExcelSheet(1).getRow(6).getCell(1).getStringCellValue();
	}

	public static String ts_state() {

		System.out.println("Call getURL.......");
		return getExcelSheet(1).getRow(7).getCell(1).getStringCellValue();
	}

	public static String ts_postalcode() {

		System.out.println("Call getURL.......");
		getExcelSheet(1).getRow(8).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
		return getExcelSheet(1).getRow(8).getCell(1).getStringCellValue();
	}

	// E-Signature

	public static String esign_username() {

		System.out.println("Call getURL.......");
		return getExcelSheet(2).getRow(0).getCell(1).getStringCellValue();
	}

	public static String esign_password() {

		System.out.println("Call getURL.......");
		return getExcelSheet(2).getRow(1).getCell(1).getStringCellValue();
	}

	/*
	 * public static String esign_firstname() {
	 * 
	 * System.out.println("Call getURL......."); return
	 * getExcelSheet(2).getRow(2).getCell(1).getStringCellValue(); }
	 * 
	 * public static String esign_lastname() {
	 * 
	 * System.out.println("Call getURL......."); return
	 * getExcelSheet(2).getRow(3).getCell(1).getStringCellValue(); }
	 * 
	 * public static String esign_emailaddress() {
	 * 
	 * System.out.println("Call getURL......."); return
	 * getExcelSheet(2).getRow(4).getCell(1).getStringCellValue(); }
	 * 
	 * public static String esign_phonenumber() {
	 * 
	 * System.out.println("Call getURL......."); return
	 * getExcelSheet(2).getRow(5).getCell(1).getStringCellValue(); }
	 */

	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
//Program name
	public static String Non_tryout_program_name(String str,int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));

		return str+"_"+builder.toString()+"_"+df.format(dateobj);
	}
	
	
	public static String TimeFormate() {
		// TODO Auto-generated method stub
		//String scheduleTime;
		/*
		 * SimpleDateFormat dateFormat1 = new SimpleDateFormat();
		 * dateFormat1.setTimeZone(TimeZone.getTimeZone("US/Eastern")); Calendar cal =
		 * Calendar.getInstance(); cal.add(Calendar.MINUTE, 3); String
		 * n=dateFormat1.format(cal.getTime()); System.out.println("Full Date  = " +n);
		 * String time=n.substring(7, n.length()); System.out.println("Time= " +time);
		 */
		String time;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat();
	    dateFormat1.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MINUTE, 3);
        String n=dateFormat1.format(cal.getTime());
        //n="03/09/20 8:30 AM";
        System.out.println("Full Date  = " +n);
        int colonindex=n.indexOf(":");
        //System.out.println(": placed= " +colonindex);
        //String tt =n.substring(colonindex, n.length());
        //System.out.println("tt= " +tt);
        String tt1 =n.substring(colonindex-2,colonindex-1);
        System.out.println("tt1= " +tt1);
        if(tt1.equals("1")) {
        	 time=n.substring(colonindex-2, n.length());
        	 System.out.println("Time with two digits in hours= " +time);
        }
        else {
        	 time=n.substring(colonindex-1, n.length());
        	 System.out.println("Time with one digit in hours= " +time);
        }
        return time;
	}	
	
// Today Date
//Test
	public static String Today_Date() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    Date dateobj = new Date();
	    //System.out.println(df.format(dateobj));
	    String month = df.format(dateobj).substring(3, 5);
	   // System.out.println(month);
	   // int monthint = Integer.valueOf(month) + 2;
	   // System.out.println(monthint);
	    String day = df.format(dateobj).substring(0, 2);
	    //System.out.println(day);
	    String year = df.format(dateobj).substring(6, 10);
	    //System.out.println(year);
	    String TodayDate = month+"/"+day+"/"+year;
	    System.out.println(TodayDate);   
		return TodayDate;
	}
	
//Future Date	
	
public static String Future_Date() {
		
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date dateobj = new Date();
   // System.out.println(df.format(dateobj));
    String month = df.format(dateobj).substring(3, 5);
    //String year = df.format(dateobj).substring(6,10);
    //System.out.println(month);
    
    int monthint = Integer.valueOf(month) + 2;
    if(monthint>12)
    	monthint = monthint-12;
    //System.out.println(monthint);
    //String day = df.format(dateobj).substring(0, 2);
    //System.out.println(day);
    String year = df.format(dateobj).substring(6, 10);
    int yearint = Integer.valueOf(year) + 1;

   //System.out.println(year);
    String FutureDate = monthint+"/"+28+"/"+yearint;
    System.out.println(FutureDate);     
	return FutureDate;
	}

public static String Future_Date_one_month() {
	
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date dateobj = new Date();
   // System.out.println(df.format(dateobj));
    String month = df.format(dateobj).substring(3, 5);
    //System.out.println(month);
    int monthint = Integer.valueOf(month) + 1;
    if(monthint>12)
    	monthint = monthint-12;
    //System.out.println(monthint);
    //String day = df.format(dateobj).substring(0, 2);
    //System.out.println(day);
    String year = df.format(dateobj).substring(6, 10);
    int yearint = Integer.valueOf(year) + 1;
   //System.out.println(year);
    String FutureDate = monthint+"/"+28+"/"+yearint;
    System.out.println(FutureDate);     
	return FutureDate;
	}

public static String Future_Date_three_month() {
	
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date dateobj = new Date();
   // System.out.println(df.format(dateobj));
    String month = df.format(dateobj).substring(3, 5);
    //System.out.println(month);
    int monthint = Integer.valueOf(month) + 3;
    if(monthint>12)
    	monthint = monthint-12;
    //System.out.println(monthint);
    //String day = df.format(dateobj).substring(0, 2);
    //System.out.println(day);
    String year = df.format(dateobj).substring(6, 10);
    int yearint = Integer.valueOf(year) + 1;
   //System.out.println(year);
    String FutureDate = monthint+"/"+28+"/"+yearint;
    System.out.println(FutureDate);     
	return FutureDate;
	}

public static String Future_Date_four_month() {
	
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date dateobj = new Date();
   // System.out.println(df.format(dateobj));
    String month = df.format(dateobj).substring(3, 5);
    //System.out.println(month);
    int monthint = Integer.valueOf(month) + 4;
    if(monthint>12)
    	monthint = monthint-12;
    //System.out.println(monthint);
    //String day = df.format(dateobj).substring(0, 2);
    //System.out.println(day);
    String year = df.format(dateobj).substring(6, 10);
    int yearint = Integer.valueOf(year) + 1;
   //System.out.println(year);
    String FutureDate = monthint+"/"+28+"/"+yearint;
    System.out.println(FutureDate);     
	return FutureDate;
	}

//Random name Alphabetic only	
	private static final String ALPHA_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String randomAlpha(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_STRING.length());
			builder.append(ALPHA_STRING.charAt(character));
		}
		return builder.toString();
	}

	private static final String NUMERIC_STRING = "01234567890123456789";

	public static String randomNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * NUMERIC_STRING.length());
			builder.append(NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	private static final String numberofdocuments = "54321";

	public static String numberofducuments() {
		int count = 1;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * numberofdocuments.length());
			builder.append(numberofdocuments.charAt(character));
		}		
		return builder.toString();
	}

}
