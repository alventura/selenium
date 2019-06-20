package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.Mrds;



public class rds extends Mrds{
	public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		String name="Tanisha";	
		String lastName="Lyerly";
		String social="082861741";
		String sub=social.substring(5, 9);
		String username=name+"."+lastName+"_"+sub;
		String password=lastName+"-"+sub;
		String address="25 Christine Ct";
		String city="Williamsburg,VA";
		String zip="23188";
		String dependents="5";
		String status="single";
		
		String window =driver.getTitle();
        String currentPage= driver.getWindowHandle();
        
		
		driver.navigate().to("http://avionte.hssstaffing.com/Avionte/Portals/Portals/Employee/RequireDocument.aspx ");
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(username);
		driver.findElement(By.cssSelector("input.Textbox_LoginPassword")).sendKeys(password);
	    driver.findElement(By.cssSelector("input.button_Xlarge")).click();
	       Thread.sleep(2000);
	    driver.findElement(By.xpath("//nobr[contains(text(),'Signed Documents')]")).click();
	       Thread.sleep(2000);
	   //  offer letter, new window
	    driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl02_StatusLink")).click();
	    Thread.sleep(2000);
	    Mrds.setWindow(driver);
	    Mrds.checkBox(driver, "EDocUserControl_chkEmployeeSign");
	    driver.findElement(By.id("ButtonSubmit")).click();
	   // acknowledgement 
	    driver.switchTo().window(currentPage);
	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl04_StatusLink")).click();
	     Thread.sleep(2000);
	     Mrds.setWindow(driver);
	     Mrds.checkBox(driver, "EDocUserControl_chkEmployeeSign1");
	     Mrds.checkBox(driver, "EDocUserControl_chkEmployeeSign2");
	     Mrds.checkBox(driver, "EDocUserControl_chkAcceptedSignature");
	     Mrds.checkBox(driver, "EDocUserControl_chkEmployeeSign"); 
	     driver.findElement(By.id("ButtonSubmit")).click();
	     Thread.sleep(2000);
	     //emergency contact
	     driver.switchTo().window(currentPage);
	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl08_StatusLink")).click();
	     Mrds.setWindow(driver);//switch window
	     Mrds.checkBox(driver, "EDocUserControl_rdbtnNewHire");
	     Mrds.checkBox(driver, "EDocUserControl_RadioButton2");//choose not to furnish
	     Mrds.checkBox(driver, "EDocUserControl_CheckboxEmployeeSignature");
	     driver.findElement(By.id("ButtonSubmit")).click();
	     Thread.sleep(3000);

	     //VA tax
	     driver.switchTo().window(currentPage);
	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl09_StatusLink")).click();
	     Mrds.setWindow(driver);
	     driver.findElement(By.cssSelector("input#igtxtEDocUserControl_txtBques1a")).sendKeys(dependents);
	     driver.findElement(By.cssSelector("input#igtxtEDocUserControl_txtBques1c")).sendKeys(dependents);
	     Mrds.checkBox(driver, "EDocUserControl_CheckboxEmployeeSignature");
	     driver.findElement(By.id("ButtonSubmit")).click();
	     
//	     background check .. needs more code
	   //  driver.switchTo().window(currentPage);
	  //   driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl10_StatusLink")).click();
	    // Mrds.setWindow(driver);
	    
	     // drug consent, needs more code
//	     driver.switchTo().window(currentPage);
//	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl11_StatusLink")).click();
//	     Mrds.setWindow(driver);
//	     driver.findElement(By.id("ButtonSubmit")).click();
	     
	     //fed w4
	     driver.switchTo().window(currentPage);
	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl12_StatusLink")).click();
	     Mrds.setWindow(driver);
	     Mrds.checkBox(driver, "EDocUserControl_chkSingle");
	     Thread.sleep(4000);
	     driver.findElement(By.cssSelector("input#igtxtEDocUserControl_txtAllowances")).sendKeys(dependents);
	     Mrds.checkBox(driver, "EDocUserControl_CheckboxEmployeeSignature");
	     Thread.sleep(3000);
	     driver.findElement(By.id("ButtonSubmit")).click();
	     //i9
	    // driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl15_StatusLink")).click();    
	     
	     //uniform policy English
	     driver.switchTo().window(currentPage);
	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl18_StatusLink")).click();
	     Mrds.setWindow(driver);
	     Mrds.checkBox(driver, "EDocUserControl_chkEmployeeSignature");
	     driver.findElement(By.id("ButtonSubmit")).click();
	     
	     //work opportunity
	    driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl20_StatusLink")).click();
	    clicking("css","a#EDocUserControl_HypWOTC");
	     
	    
	
	}
}
