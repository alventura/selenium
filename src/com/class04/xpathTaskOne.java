package com.class04;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

public class xpathTaskOne {
	

	
	

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			/*
			 * Open chrome browser
	Go to “https://www.facebook.com/”
	Enter valid username and valid password and click login
	User successfully logged in
			 */
			//test.rasmi@gmail.com
		       //Syntax123
			
			
			System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe" );
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.findElement(By.xpath("//input[contains(@type,'mail')]")).sendKeys("test.rasmi@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[starts-with(@data-testid,'royal_pa')]")).sendKeys("Syntax123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'account?')]")).click();
			
			////a[text()='Forgot account?']
			//a[starts-with(text(),'Forgot ')]
			
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[starts-with(@data-testid,'royal_pa')]")).sendKeys("Syntax123");
			driver.findElement(By.xpath("//input[starts-with(@value,'Log')]")).click();
			driver.close();
			
			
			

		}

}
