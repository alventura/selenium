package com.class08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class classDoubleCLick extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// different examples  of drop down and select and drag
		setUpDriver("chrome", "http://uitestpractice.com/Students/Actions");
    
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.name("dblClick"))).doubleClick().build().perform();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
         alert.accept();
        
        Thread.sleep(3000);
        
        act.moveToElement(driver.findElement(By.xpath("//button[text()='Click Me !']"))).click().build().perform();
        Thread.sleep(3000);
        alert=driver.switchTo().alert();
        alert.accept();
        
        Thread.sleep(3000);
        WebElement source=driver.findElement(By.cssSelector("#draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        act.dragAndDrop(source, target).build().perform();
        Thread.sleep(3000);
        
                
        driver.close();

	}

}
