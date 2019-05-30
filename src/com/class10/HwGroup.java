package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class HwGroup extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setUpDriver("chrome", "http://uitestpractice.com/");
		
		driver.findElement(By.xpath("//a[starts-with(@href,'/Students/F')] ")).click();
		
		sendText1("css","input#firstname","Al");
		sendText1("css","input#lastname","Ventura");
		checkBox(driver,driver.findElement(By.xpath("//html/body/div[2]/div[1]/div/form/div[3]/label[2]/input")));
		checkBox(driver,driver.findElement(By.xpath("//html/body/div[2]/div[1]/div/form/div[4]/label[3]/input")));
		
		WebElement contries = driver.findElement(By.cssSelector("select#sel1"));
		Select select = new Select(contries);
		select.selectByVisibleText("Algeria");
		
		//selecting calendar
		
	    driver.findElement(By.cssSelector("input#datepicker")).click();
				        
	    WebElement month = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
	    Select selectMonth = new Select(month);
	    selectMonth.selectByVisibleText("May");
				        
	    WebElement year = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
	    Select selectYear = new Select (year);
	    selectYear.selectByVisibleText("1970");
				        
				        
//      List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/thead/tr/td"));
//      List<WebElement> cols = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr"));
				        
	   //To select calendar day
	    String expectedValue = "25";
				        
	    List <WebElement> days =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	    for (WebElement day: days) {
	    String dayText=day.getText();
		if (dayText.equals(expectedValue)) {
		day.click();
				                
		sendText("css","input#phonenumber","5555555");
		driver.findElement(By.cssSelector("input#username")).sendKeys("JavaJets");
		driver.findElement(By.cssSelector("input#email")).sendKeys("javajets@4lyf3.com");
		driver.findElement(By.cssSelector("textarea#comment")).sendKeys("WE ARE THE JAVA-JETS");
		driver.findElement(By.cssSelector("input#pwd")).sendKeys("password");
		Thread.sleep(5000); //after submitting, the page goes back to being blank
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[12]/div/button")).click();	                
				                
		
	}

}
	
}
}