package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.walmart.com");
		driver.findElements(By.tagName("a"));
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		int count=0;
		for(WebElement link: links) {
			String linkText=link.getText();
			if(!linkText.isEmpty()) {
				System.out.println(linkText);
				count++;
			}	
		}
			System.out.println("The total of links with texts are "+count);
			driver.close();
			
	}

}
