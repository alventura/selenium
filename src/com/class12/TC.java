package com.class12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utils.CommonMethods;

public class TC {
	Properties prop;
	@Test
	public void readFile() {
		String file="src\\config\\credentials.properties";
		
		try {
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
	
	CommonMethods.setUpDriver(prop.getProperty("browser"), prop.getProperty("url"));
	CommonMethods.sendText1("css", "input#txtUsername", prop.getProperty("userID"));
	CommonMethods.sendText1("css", "input#txtPassword", prop.getProperty("password"));
	CommonMethods.clicking("css", "input#btnLogin");
}

}
