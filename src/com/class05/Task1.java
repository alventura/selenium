package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {

		//done by the teacher
		
		String userName="standard_user";
		String password="secret_sauce";
		
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.saucedemo.com/");
		//login to the application
		driver.findElement(By.xpath("//input[starts-with(@id,'user-name')]")).sendKeys(userName);
		driver.findElement(By.xpath("//input[starts-with(@id,'password')]")).sendKeys(password);
		driver.findElement(By.xpath("//input[starts-with(@value,'LOGI')]")).click();
		//logo verification
		boolean logo=driver.findElement(By.cssSelector("div.peek")).isDisplayed();
		
		if (logo) {
			System.out.println("Robot logo is displayed");
		}else {
			System.out.println("Robot logo is NOT displayed");
		}
		//verify product text
		WebElement product=driver.findElement(By.cssSelector("div.product_label"));
		boolean displayP=product.isDisplayed();
		String productText=product.getText();
		
		String expectedText="Products";
		
		if (displayP && productText.equals(expectedText)) {
			System.out.println("Element is displayed and texts is "+productText);
		}else {
			System.out.println("Element is NOT displayed OR textis NOT="+productText);
		}
		
	

	}

}
