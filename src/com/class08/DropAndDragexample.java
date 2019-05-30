package com.class08;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class DropAndDragexample extends CommonMethods{
    public static void main(String[] args) throws InterruptedException {
        
        setUpDriver("chrome", "http://uitestpractice.com/Students/Index");    
        
        driver.findElement(By.xpath("//a[text()='Actions']")).click();
        Thread.sleep(2000);
         //click on Click ME! and handle alert
        driver.findElement(By.xpath("//button[text()='Click Me !']")).click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        
        //double click on Double Click Me! and handle alert
        Actions action=new Actions(driver);
        WebElement doubleCl=driver.findElement(By.xpath("//button[text()='Double Click Me !']"));
        Thread.sleep(2000);
        action.doubleClick(doubleCl).perform();
        alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        
        //drag and drop
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        action.dragAndDrop(drag, drop).perform();
        Thread.sleep(2000);
        
//        Click and hold on 1,2,3,4 boxes
        WebElement one=driver.findElement(By.xpath("//li[text()='1']"));
        WebElement two=driver.findElement(By.xpath("//li[text()='2']"));
        WebElement three=driver.findElement(By.xpath("//li[text()='3']"));
        WebElement four=driver.findElement(By.xpath("//li[text()='4']"));
        
        action.clickAndHold(one).clickAndHold(two).clickAndHold(three).clickAndHold(four).release().build().perform();
    //    action.clickAndHold(one).moveToElement(four).release().build().perform();
        Thread.sleep(2000);
        
        //click and hold on boxes 12-9
        WebElement twelve=driver.findElement(By.xpath("//li[text()='12']"));
        WebElement eleven=driver.findElement(By.xpath("//li[text()='11']"));
        WebElement ten=driver.findElement(By.xpath("//li[text()='10']"));
        WebElement nine=driver.findElement(By.xpath("//li[text()='9']"));
        action.clickAndHold(twelve).moveToElement(eleven).clickAndHold(ten).moveToElement(nine).release().build().perform();
        Thread.sleep(2000);
        
        //click and hold on boxes 3,7,11
        WebElement seven=driver.findElement(By.xpath("//li[text()='7']"));
    //    action.clickAndHold(three).moveToElement(eleven).release().build().perform();
        action.moveToElement(three).clickAndHold().moveToElement(seven).clickAndHold().moveToElement(eleven).clickAndHold().release().build().perform();
        Thread.sleep(2000);
        
        //click on box 1 move to box 12
        action.clickAndHold(one).moveToElement(twelve).release().build().perform();
        Thread.sleep(2000);
        
        //click to Switch to, pass text in iframe
        driver.findElement(By.xpath("//a[text()='Switch to']")).click();
        Thread.sleep(2000);
        driver.switchTo().frame("iframe_a");
        driver.findElement(By.cssSelector("input#name")).sendKeys("milena");
        Thread.sleep(2000);
        
        driver.switchTo().defaultContent();
        
        //click on Select
        driver.findElement(By.xpath("//a[text()='Select']")).click();
        Thread.sleep(2000);
        //Multiple Drop Down
        WebElement countries=driver.findElement(By.id("countriesMultiple"));
        Select select=new Select(countries);
        List<WebElement> country=select.getOptions();
        System.out.println("Total number of options available in Multiple DD: "+country.size());
        
        select.selectByVisibleText("United states of America");
        select.selectByValue("china");
        Thread.sleep(2000);
        
        if (select.isMultiple()) {
            select.deselectByVisibleText("China");
            Thread.sleep(2000);
        }
        
        Thread.sleep(3000);
        driver.quit();
    }    
}

