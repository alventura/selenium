package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class Task extends CommonMethods{
public static void main(String[] args) {
	setUpDriver("chrome","https://the-internet.herokuapp.com/");
	
	driver.findElement(By.linkText("Dynamic Loading")).click();
	driver.findElement(By.partialLinkText("Example 1")).click();
	
	driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
	WebDriverWait wait=new  WebDriverWait(driver,30);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Hello Wold!']")));
	
  boolean isDisplayed=driver.findElement(By.cssSelector("div#finish")).isDisplayed();
  if(isDisplayed) {
	  System.out.println("Text is present");
        
    }else {
        System.out.println("text is not present");
    }
	
	
}
}
