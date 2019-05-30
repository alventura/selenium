package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String name="problem_user";
		
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys(name); 
		driver.findElement(By.xpath("//input[contains(@id,'pa')]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[starts-with(@value,'LOG')]")).click();
		driver.close();
		
		
		
	}

}
