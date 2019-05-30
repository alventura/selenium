package com.class07;

import org.openqa.selenium.WebDriver;

import utils.CommonMethods;

public class Test extends CommonMethods {
	
	public static void main(String [] args) {
		
	 CommonMethods.setUpDriver("firefox", "http://www.google.com");
	 driver.close();
	 
	 
	}

}
