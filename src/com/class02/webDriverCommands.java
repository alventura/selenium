package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriverCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		driver.get("https://google.com");
//		System.out.println(driver.getTitle());//to validate the webpage is correct
//		String title=driver.getTitle();
//		if(title.equalsIgnoreCase("google")) {
//			System.out.println("this is the right title");
//		}
//		else {
//			System.out.println("sorry this is not the right title");
//		}
		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Facebook - Log In or Sign Up")) {
			System.out.println("This is the right title");
		}else {
			System.out.println("Not the right title");
		}
	}

}
