package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class taskRightClick extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setUpDriver("chrome","https://www.saucedemo.com" );
		WebElement rightC=driver.findElement(By.id("password"));
		Actions action = new Actions(driver);
		action.contextClick(rightC).perform();
		Thread.sleep(2000);
		driver.close();
		
		
		
		
	}

}
