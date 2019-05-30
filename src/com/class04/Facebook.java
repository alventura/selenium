package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//input[contains(@id,'em')]")).sendKeys("alventura21@gmail.com");
		driver.findElement(By.xpath("//input[starts-with(@id,'pass')]")).sendKeys("Grid008!");
		driver.findElement(By.xpath("//input[starts-with(@type,'sub')]")).click();
		
		

	}

}
