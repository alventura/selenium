package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauceDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https:/www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.className("btn_action")).click();
		driver.findElement(By.id("btn_primary btn_inventory")).click();

}
}