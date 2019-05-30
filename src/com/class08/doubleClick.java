package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class doubleClick extends CommonMethods {
public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub
	setUpDriver("chrome", "https://www.saucedemo.com");
	driver.findElement(By.cssSelector("input#user-name")).sendKeys("double");
	Actions action = new Actions(driver);
	action.doubleClick(driver.findElement(By.cssSelector("input#user-name"))).perform();
	Thread.sleep(2000);
	driver.close();

}
}
