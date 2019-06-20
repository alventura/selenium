package com.practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Magento extends CommonMethods{

	   @BeforeMethod(alwaysRun =true, groups ="Regression")
	    public void setUP() {
	        setUpDriver("firefox", "http://live.guru99.com/index.php/");
	        
	        boolean logo=driver.findElement(By.xpath("//a[@class='logo']/img[1]")).isDisplayed();
	        Assert.assertTrue(logo);
	    }
	   
	   @Test
	   public void getTitle() {
		   String title=driver.getTitle();
		  System.out.println(title);
	   }
	   
	   
	
}
