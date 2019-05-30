package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCase2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https:/www.syntaxtechs.com");
		Thread.sleep(2000);
		driver.get("http://www.google.com");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		String title=driver.getTitle();
		
		if(title.contains("Syntax")) {
		System.out.println("Syntax is part of the URL");
		}else {
			System.out.println("incorrect title");
		}
		driver.quit();
	}

}
