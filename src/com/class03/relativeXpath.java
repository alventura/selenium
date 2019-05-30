package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class relativeXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();

		driver.get("https://www.saucedemo.com" );
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("problem_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@class='btn_action']")).click();
		
	}

}
