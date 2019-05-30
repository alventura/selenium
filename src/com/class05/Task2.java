package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.findElements(By.tagName("a"));
		
		List<WebElement> listLinks=driver.findElements(By.tagName("a"));
		
		int number=0;
		for(WebElement link: listLinks) {
			String text=link.getText();
			if(!text.isEmpty()) {
				number++;
			}
		}
		System.out.println(number);
		int count=0;
		
		Iterator <WebElement> iter=listLinks.iterator();
		while(iter.hasNext()) {
			String links=iter.next().getText();
			if(!links.isEmpty()) {
				System.out.println(links);
				count++;
			}
		}
			System.out.println(count);
		driver.close();
	}

}
