package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class Dropdown extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
        CommonMethods.setUpDriver("chrome", "https://www.facebook.com/");
        driver.findElement(By.name("firstname")).sendKeys("Lucy");
        Thread.sleep(1000);
        driver.findElement(By.id("u_0_e")).sendKeys("Cirus");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_email__")).sendKeys("lycysyntax@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Syntax@123");
        Thread.sleep(1000);
        WebElement month = driver.findElement(By.cssSelector("select#month"));
        Select obj=new Select(month);
        obj.selectByVisibleText("Feb");
        Thread.sleep(1000);
        WebElement days= driver.findElement(By.cssSelector("select#day"));
        Select obj2=new Select(days);
        obj2.selectByVisibleText("15");
        Thread.sleep(1000);
        WebElement year=driver.findElement(By.cssSelector("select#year"));
        Select obj3=new Select(year);
        obj3.selectByIndex(20);
        Thread.sleep(1000);
         driver.findElement(By.xpath("//input[@name='sex']")).click();
         Thread.sleep(1000);
         driver.close();
        

    }

}
	
