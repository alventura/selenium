package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Mrds;


public class RdsTesting extends Mrds {
	
	public static Properties prop;

	@BeforeClass
	public void setUp() throws InterruptedException {
		
			String filePath="src\\config\\credentials.properties";
			
			try {
				FileInputStream fis=new FileInputStream(filePath);
				prop=new Properties();
				
				prop.load(fis);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		Mrds.setUpDriver(prop.getProperty("browser"), prop.getProperty("url"));
		
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(username);
		driver.findElement(By.cssSelector("input.Textbox_LoginPassword")).sendKeys(password);
	    driver.findElement(By.cssSelector("input.button_Xlarge")).click();
	    driver.findElement(By.xpath("//nobr[contains(text(),'Signed Documents')]")).click();
	       Thread.sleep(2000);
	}

	@Test (enabled=false,priority =1)
	public static  void offerLetter() throws InterruptedException {
		 String window1 =driver.getTitle();
	      String currentPage= driver.getWindowHandle();
		
		  //  offer letter, new window
	    driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl02_StatusLink")).click();
	    Thread.sleep(2000);
	    Mrds.setWindow(driver);
	    Mrds.checkBox(driver, "EDocUserControl_chkEmployeeSign");
	    driver.findElement(By.id("ButtonSubmit")).click();
	}
	@Test(enabled=false,priority=2)
	    public void acknowledgementEmergencyVATax() throws InterruptedException {
		 String window1 =driver.getTitle();
	     String currentPage= driver.getWindowHandle();
		
	    // acknowledgement 
	    driver.switchTo().window(currentPage);
	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl04_StatusLink")).click();
	     Thread.sleep(2000);
	     Mrds.setWindow(driver);
	     Mrds.checkBox(driver, "EDocUserControl_chkEmployeeSign1");
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
	     driver.switchTo().window(currentPage);
	}
	@Test(enabled=false,priority =3)
	public void backgroundCheck() {
		 //background check .. needs more code
	     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl10_StatusLink")).click();
	     Mrds.setWindow(driver);
	     clicking("css","input#EDocUserControl_chkEmployeeSignature");
	     clicking("css","input#EDocUserControl_chkEmployeeSignature2"); 
	     clicking("css","input#EDocUserControl_chkEmployeeSignature3");
	     clicking("css","input#EDocUserControl_chkMale");
	     clicking("css","input#EDocUserControl_chkCAMNOKApplicants");
	     clicking("css","input#EDocUserControl_chkEmployeeSignature4");
		 clicking("css","input#ButtonSubmit");
	}
	@Test(enabled=false,priority=4)
	public void drugConsentW4() {
		String window1 =driver.getTitle();
	    String currentPage= driver.getWindowHandle();
		driver.switchTo().window(currentPage);
		driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl12_StatusLink")).click();
	    Mrds.setWindow(driver);
	 
		clicking("xpath","//input[@id='EDocUserControl_chkEmployeeSign']");
		clicking("xpath","//input[@id='EDocUserControl_chkEmployeeSignSpanish']");
		clicking("css","input#ButtonSubmit");
		}
		
	@Test(enabled=false,priority=5)
		public void w4() throws InterruptedException {
		 //fed w4
		String window1 =driver.getTitle();
		String currentPage= driver.getWindowHandle();
		   driver.switchTo().window(currentPage);
		     driver.findElement(By.cssSelector("a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl12_StatusLink")).click();
		     Mrds.setWindow(driver);
		     Mrds.checkBox(driver, "EDocUserControl_chkSingle");
		     Thread.sleep(4000);
		     driver.findElement(By.cssSelector("input#igtxtEDocUserControl_txtAllowances")).sendKeys(dependents);
		     Mrds.checkBox(driver, "EDocUserControl_CheckboxEmployeeSignature");
		     Thread.sleep(3000);
		     driver.findElement(By.id("ButtonSubmit")).click();
	}
	@Test(enabled=false,priority=6)
		public void I9() throws InterruptedException {
		//I9
		String window1 =driver.getTitle();
		String currentPage= driver.getWindowHandle();
	     driver.switchTo().window(currentPage);
	     clicking("css","a#ctl00_MainContent_EmployeeEDoc1_WebPanel1_GridView1_ctl15_StatusLink");
	     setWindow(driver);
	     sendText1("css","input#EDocUserControl_txtLastName",lastName);
	     sendText1("css","input#EDocUserControl_txtFirstName",name);
	     sendText1("css","input#EDocUserControl_txtMidName",middleN);
	     sendText1("css","input#EDocUserControl_txtMaidenName",otherN);
	     sendText1("css","input#EDocUserControl_txtAddress",address);
	     sendText1("css","input#EDocUserControl_txtApt",apt);
	     sendText1("css","input#EDocUserControl_txtCity",city);
	     Mrds.dropDown("css", "select#EDocUserControl_ddlState", "VA");
	     sendText1("css","input#EDocUserControl_txtZip",zip);
	     sendText1("css","input#EDocUserControl_txtBirth",bDate);
	    clicking("css","input#igtxtEDocUserControl_txtSSN");
	    Thread.sleep(2000);
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("document.getElementById('igtxtEDocUserControl_txtSSN').value='239-19-0911';");
	     //sendText1("css","input#igtxtEDocUserControl_txtSSN","123-45-6789");
	     sendText1("css","input#EDocUserControl_txtEmail",email);
	     js.executeScript("document.getElementById('igtxtEDocUserControl_txtPhoneNo').value='757 343 9422';");
	     clicking("css","input#igtxtEDocUserControl_txtPhoneNo");
	     //sendText1("css","input#igtxtEDocUserControl_txtPhoneNo",phone);
	     clicking("css","input#EDocUserControl_Immacheck1");
	     clicking("css","input#EDocUserControl_CheckboxEmployeeSignature");
	     Mrds.acceptAlert();
	     //Mrds.setWindow(driver);
	     clicking("css","input#EDocUserControl_chkIDidNotUse");
	     clicking("css","input#ButtonSubmit");
		}
		
	
	
}