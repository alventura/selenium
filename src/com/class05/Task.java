package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) {
		
		String userName="standards_user";
		String password="secret_sauce";
		
		System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().fullscreen();
		driver.findElement(By.cssSelector("input#user-name")).sendKeys(userName);
		driver.findElement(By.xpath("//input[contains(@type,'p')]")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
			//to verify that the image of the robot displays
		boolean box=driver.findElement(By.cssSelector("div.peek")).isDisplayed();
		if(box) {
			System.out.println("Robot displays");
		}else {
			System.out.println("Robot does not display");
		}
			//to verify if a text displays
		boolean text= driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed();
		if(text) {
			System.out.println("The text 'Products' is displayed");
		}else {
			System.out.println("The text is not found/displayed");
		}
		
		/*
		 * is the text changes it is better to use the name of the class
		 * WebElement product=driver.findElement(By.cssSelector("div.product_label"));
		 * boolean displayP=product.isDisplayed();
		 * 
		 */
		
		
		
	}
}
