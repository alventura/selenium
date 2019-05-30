package com.class06;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task01 {

	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://amazon.com/");
	driver.manage().window().maximize();
	
	WebElement options=driver.findElement(By.cssSelector("select#searchDropdownBox"));
	Select selection=new Select(options);
	
	List<WebElement> departments=selection.getOptions();
	System.out.println("The number of departments is "+departments.size());
	
	Iterator<WebElement> iter=departments.iterator();
	while(iter.hasNext()) {
		String department=iter.next().getText();
		if(department!="null") {
			System.out.println(department);
		}
	}
	selection.selectByVisibleText("Computers");
	Thread.sleep(3000);
	driver.close();
	}

}
