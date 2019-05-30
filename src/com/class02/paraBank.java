package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class paraBank {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		driver.findElement(By.id("customer.firstName")).sendKeys("Alv");
		driver.findElement(By.id("customer.lastName")).sendKeys("Vent");
		driver.findElement(By.id("customer.address.street")).sendKeys("412 Barb");
		driver.findElement(By.id("customer.address.city")).sendKeys("VB");
		driver.findElement(By.name("customer.address.state")).sendKeys("VA");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("23456");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("7574564564");
		driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
		driver.findElement(By.id("customer.username")).sendKeys("username");
		driver.findElement(By.id("customer.password")).sendKeys("123456789");
		driver.findElement(By.id("repeatedPassword")).sendKeys("123456789");
		driver.findElement(By.className("button")).click();
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.className("button")).click();
		}

}
