package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class Task extends CommonMethods{

	public static void main(String[] args) {
		setUpDriver("chrome", "https://www.toolsqa.com");
		WebElement hover = driver.findElement(By.xpath("//span[text()='Tutorial']"));
		Actions action= new Actions(driver);
		action.moveToElement(hover).click().perform();

	}

}
