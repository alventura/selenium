package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		// Go to “https://www.toolsqa.com/automation-practice-form/”
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		// Fill out:// First Name // Last Name
		driver.findElement(By.cssSelector("input[name^=first]")).sendKeys("Al");
		driver.findElement(By.cssSelector("input[name^=last]")).sendKeys("Ven");
		// Check that sex radio buttons are enabled and select “Male”
		List<WebElement> list;
		list=driver.findElements(By.name("sex"));
		String expected="Male";
		for(WebElement gender:list) {
		if(gender.isEnabled()) {
			String male=gender.getAttribute("value");
			    if(male.equals(expected)) {
				   gender.click();
			    }
		 }
		}
		// Check all Years of Experience radio buttons are clickable
		list=driver.findElements(By.name("exp"));
		Iterator<WebElement> it=list.iterator();
		while(it.hasNext()) {
			WebElement year=it.next();
			 if(year.isEnabled()) {
				 year.click();
				 Thread.sleep(500);
			}
			
		}
		// Date
		driver.findElement(By.cssSelector("#datepicker")).sendKeys("14/05/2019");
		Thread.sleep(500);
        //Select both checkboxes for profession
		list=driver.findElements(By.name("profession"));
		for(WebElement profession:list) {
			if(profession.isEnabled()) {
			profession.click();
			}
		}
//		Check all Automation Tools checkboxes are clickable and keep “Selenium WebDriver” option as selected
		list=driver.findElements(By.xpath("//input[@name='tool']"));
		
		for(WebElement tool:list) {
			String automationTools=tool.getAttribute("value");
			if(tool.isEnabled()) {
				System.out.println(automationTools+" is clickable");
				}
			if(automationTools.equals("Selenium Webdriver")) {
				System.out.println(automationTools);
				tool.click();
				
				Thread.sleep(500);
			}
			
		}
//		Quit browser
		Thread.sleep(3000);
		driver.quit();
	}

}
