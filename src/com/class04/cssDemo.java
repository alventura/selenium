package com.class04;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class cssDemo {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			
			System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input.btn_action")).click();
			
//			driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
//			driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("bob");
//			driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("tom");
//			driver.findElement(By.cssSelector("input#email")).sendKeys("test");
//			driver.findElement(By.cssSelector("input[name^='pass']")).sendKeys("123");
//			driver.findElement(By.cssSelector("input[name$='Password']")).sendKeys("123");
//			driver.findElement(By.cssSelector("input[name='register']")).click();

			

		

	}
}
