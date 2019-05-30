package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tours {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("http://newtours.demoaut.com");
		driver.findElement(By.xpath("//input[contains(@type,'t')]")).sendKeys("Alventura89");
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("grid");
		driver.findElement(By.xpath("//input[starts-with(@src,'/')]")).click();
		

	}

}
