package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

	public class TC1 extends CommonMethods{
		public static void main(String[] args) throws InterruptedException {
	
	
			setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
			
			sendText("css","input[id$='username']", "Tester");
			sendText("css","input[id*='password']", "test");
			driver.findElement(By.cssSelector("input[value='Login']")).click();
//GET NUMBER OF ROWS
			List <WebElement> row=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
			
			String expectedString="Susan McLaren";
			
			for (int a=1; a<=row.size(); a++) {
				
				String value=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+a+"]")).getText();
				
				if(value.contains(expectedString)) {
					driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+a+"]/td[13]")).click();
					break;
				}
				
			}
			
			sendText("css","input#ctl00_MainContent_fmwOrder_TextBox2", "new address");
			
}
}
