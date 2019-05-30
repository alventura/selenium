package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssTask {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.cssSelector("a[href*='mercuryregister.php']")).click();////[a[text()
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Alvaro");
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Ventura");
		driver.findElement(By.cssSelector("input[name*='em']")).sendKeys("email@email.com");
		
//		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
//		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("bob");
//		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("tom");
//		driver.findElement(By.cssSelector("input#email")).sendKeys("test");
//		driver.findElement(By.cssSelector("input[name^='pass']")).sendKeys("123");
//		driver.findElement(By.cssSelector("input[name$='Password']")).sendKeys("123");
//		driver.findElement(By.cssSelector("input[name='register']")).click();

		

	}

}
