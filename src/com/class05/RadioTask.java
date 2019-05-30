package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioTask {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		List<WebElement> box=driver.findElements(By.xpath("//input[@name='exp']"));
		 String Sel = "Selenium Webdriver";
	        for (WebElement check : box) {
	            Thread.sleep(300);
	            String a = check.getAttribute("value");
	            if (check.isEnabled()) {
	                if (!Sel.equals(a)) {
	                    check.click();
	                    check.click();
	                } else {
	                    check.click();
	                }
	            }

	        }
	}

}
