package com.class04;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class xpathTaskTwo {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			
			/*Open chrome browser
	Go to “http://newtours.demoaut.com/”
	Click on Register Link
	Fill out all required info
	Click Submit
			 * 
			 */
			
			System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[contains(@id,'ma')]")).sendKeys("test123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[starts-with(@name,'pass')]")).sendKeys("pass");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[starts-with(@name,'confirm')]")).sendKeys("pass");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[starts-with(@name,'reg')]")).click();
			

		}

}
