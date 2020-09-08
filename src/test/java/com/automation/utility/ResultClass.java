package com.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

public class ResultClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * String filepath = funcs.getabsolutepathforfile("path.properties");
		 * 
		 * try (InputStream input = new FileInputStream(filepath)) {
		 * 
		 * Properties prop = new Properties();
		 * 
		 * // load a properties file prop.load(input);
		 * 
		 * // get the property value and print it out
		 * System.out.println(prop.getProperty("screenshotpath"));
		 * System.out.println(prop.getProperty("zipdirectorypath"));
		 * 
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); }
		 */

		/*
		 * DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); Date dateobj = new
		 * Date(); //System.out.println(df.format(dateobj)); String month =
		 * df.format(dateobj).substring(3, 5); // System.out.println(month); // int
		 * monthint = Integer.valueOf(month) + 2; // System.out.println(monthint);
		 * String day = df.format(dateobj).substring(0, 2); //System.out.println(day);
		 * String year = df.format(dateobj).substring(6, 10);
		 * //System.out.println(year); String TodayDate = month+"/"+day+"/"+year;
		 * System.out.println(TodayDate);
		 */
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat();
	    dateFormat1.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MINUTE, 3);
        String n=dateFormat1.format(cal.getTime());
        n="03/09/20 18:30 AM";
        System.out.println("Full Date  = " +n);
        int colonindex=n.indexOf(":");
        System.out.println(": placed= " +colonindex);
        String tt =n.substring(colonindex, n.length());
        System.out.println("tt= " +tt);
        String tt1 =n.substring(colonindex-2,colonindex-1);
        System.out.println("tt1= " +tt1);
        if(tt1.equals("1")) {
        	 String time=n.substring(colonindex-2, n.length());
        	 System.out.println("Time with two digits in hours= " +time);
        }
        else {
        	 String time=n.substring(colonindex-1, n.length());
        	 System.out.println("Time with one digit in hours= " +time);
        	
        }
        
        String time=n.substring(7, n.length());
        System.out.println("Time= " +time);
	}

}
