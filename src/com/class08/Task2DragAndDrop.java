package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class Task2DragAndDrop extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setUpDriver("chrome", "http://demo.guru99.com/test/drag_drop.html");
		//WebElement frame = driver.findElement(By.cssSelector("i"));
		WebElement drag= driver.findElement(By.id("credit2"));
		WebElement drop= driver.findElement(By.id("placeholder"));
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		Thread.sleep(3000);
		
		
	}

}
