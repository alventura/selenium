package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class HwTask2 extends CommonMethods {
	public static void main(String[] args) {
		//access page, enter id and password to login
		setUpDriver("chrome","http://secure.smartbearsoftware.com/samples/testcomplete11/weborders/login.aspx");
		sendText1("css","input[id$='username']", "Tester");
		sendText1("css","input[id*='password']", "test");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		//click order, enter amounts
		driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();
		dropDown("css","select#ctl00_MainContent_fmwOrder_ddlProduct","ScreenSaver");//my method for dropdown
		sendText1("css","input#ctl00_MainContent_fmwOrder_txtQuantity","10");
		sendText1("xpath","//input[@name='ctl00$MainContent$fmwOrder$txtUnitPrice']","10");
		sendText1("xpath","//input[@name='ctl00$MainContent$fmwOrder$txtDiscount']","12");
		clicking("xpath","//input[@value='Calculate']");

		//enter customer information
		String costumer="Al";
		String address="123 street";
		
		sendText1("css","input#ctl00_MainContent_fmwOrder_txtName",costumer);
		sendText1("css","input#ctl00_MainContent_fmwOrder_TextBox2",address);
		sendText1("css","input#ctl00_MainContent_fmwOrder_TextBox3","VA Beach");
		sendText1("css","input#ctl00_MainContent_fmwOrder_TextBox4","Virginia");
		sendText1("css","input#ctl00_MainContent_fmwOrder_TextBox5","23456");
		clicking("css","input#ctl00_MainContent_fmwOrder_cardList_0");
		sendText1("css","input#ctl00_MainContent_fmwOrder_TextBox6","123456789000");
		sendText1("css","input#ctl00_MainContent_fmwOrder_TextBox1","12/24");
		clicking("css","a#ctl00_MainContent_fmwOrder_InsertButton");
		
		//go back and review if order is present
		clicking("xpath","//a[@href='Default.aspx']");//view orders
		
		List <WebElement> row=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for (int a=1; a<=row.size(); a++) {
			String value=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+a+"]")).getText();
			if(value.contains(costumer)) {
				System.out.println(costumer+"'s order is submitted");
				driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+a+"]/td[13]")).click();
				break;
			}
		}
		//update street name
		String newAddress="123456 new street";
		sendText1("css","input#ctl00_MainContent_fmwOrder_TextBox2", newAddress);
		clicking("css","a#ctl00_MainContent_fmwOrder_UpdateButton");
		
		//go back and see if street was  updated
		clicking("xpath","//a[@href='Default.aspx']");//view orders
		
		for (int a=1; a<=row.size(); a++) {
			String value=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+a+"]")).getText();
			if(value.contains(newAddress)) {
				String street=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr["+a+"]/td[6]")).getText();
				System.out.println("The adrees now is "+street);
				break;
			}
		}
		
	}
}
