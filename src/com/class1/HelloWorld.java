package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HelloWorld {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		//driver.get("http://www.facebook.com");
//		driver.get("http://www.amazon.com");
//		driver.get("http://www.google.com");
//		driver.manage().window().maximize();
//		 WebElement element = driver.findElement(By.name("q"));
//		    element.sendKeys("Foxes\n"); // send also a "\n"
//		    element.submit();
		
		System.setProperty("webdriver.gecko.driver","\\Users\\alven\\Selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://www.youtube.com/");
		
	}

}
