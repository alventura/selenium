package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02 {

		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			
			driver.navigate().to("http://newtours.demoaut.com/");
			driver.findElement(By.linkText("REGISTER")).click();
			driver.findElement(By.name("firstName")).sendKeys("Alvaro");
			driver.findElement(By.name("lastName")).sendKeys("Ventura");
			driver.findElement(By.name("phone")).sendKeys("77755555");
			driver.findElement(By.id("userName")).sendKeys("Aventura89");
			driver.findElement(By.name("address1")).sendKeys("123 address");
			driver.findElement(By.name("city")).sendKeys("Virginia Beach");
			driver.findElement(By.name("state")).sendKeys("VA");
			driver.findElement(By.name("postalCode")).sendKeys("23455");
			driver.findElement(By.id("email")).sendKeys("alventura21@gmail.com");
			driver.findElement(By.name("password")).sendKeys("grid");
			driver.findElement(By.name("confirmPassword")).sendKeys("grid");
			driver.findElement(By.name("register")).click();
			driver.quit();
		}
}
