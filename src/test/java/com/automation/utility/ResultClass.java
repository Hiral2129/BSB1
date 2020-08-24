package com.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResultClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filepath = funcs.getabsolutepathforfile("path.properties");
		
		try (InputStream input = new FileInputStream(filepath)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("screenshotpath"));
            System.out.println(prop.getProperty("zipdirectorypath"));
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }

	}

}
