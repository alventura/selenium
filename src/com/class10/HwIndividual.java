package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class HwIndividual extends CommonMethods {
public static void main(String[] args) {
	setUpDriver("chrome","https://www.jqueryui.com/");
	clicking("xpath","//a[@href='https://jqueryui.com/datepicker/']");
	
	WebElement element =driver.findElement(By.cssSelector("iframe.demo-frame"));
	driver.switchTo().frame(element);
	clicking("xpath","//input[@id='datepicker']");
	
	String expected="August 2019";
	
	//clicking("xpath","//a[@data-handler='next']");
	String monthText=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText();
	String  expectedDay = "10";
	
	clicking("xpath","//a[@data-handler='next']");
	clicking("xpath","//a[@data-handler='next']");
	clicking("xpath","//a[@data-handler='next']");
	 List<WebElement> table = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	 for (WebElement day : table) {
    	 String dayText = day.getText();
    	
	if(dayText.equals(expectedDay)) {
	               day.click();
	               break;
	        }else { 
	        System.out.println("not the day");
	        }

		}
}
}
