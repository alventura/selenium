package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Mrds;

public class practicing {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String name="Carmen";	
		String lastName="Martinez";
		String social="113118179";
		String sub=social.substring(5, 9);
		String username=name+"."+lastName;
		String password=lastName+"-"+sub;
		String address="119 Candlewood way Apt B";
		String city="Newport News,VA";
		String zip="23606";
		
		String window =driver.getTitle();
        String currentPage= driver.getWindowHandle();
        
       
		
		driver.navigate().to("http://avionte.hssstaffing.com/Avionte/Portals/Portals/Employee/RequireDocument.aspx ");
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(username);
		driver.findElement(By.cssSelector("input.Textbox_LoginPassword")).sendKeys(password);
	    driver.findElement(By.cssSelector("input.button_Xlarge")).click();
	       Thread.sleep(2000);
	    driver.findElement(By.xpath("//nobr[contains(text(),'Signed Documents')]")).click();
	       Thread.sleep(2000);
	       
	       
	       driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl09_StatusLink")).click();
		     Mrds.setWindow(driver);
//		     driver.findElement(By.cssSelector("input#igtxtEDocUserControl_txtBques1a")).sendKeys(dependents);
//		     driver.findElement(By.cssSelector("input#igtxtEDocUserControl_txtBques1c")).sendKeys(dependents);
		     Mrds.checkBox(driver, "input#EDocUserControl_CheckboxEmployeeSignature");
		     driver.findElement(By.id("ButtonSubmit")).click();
}
}