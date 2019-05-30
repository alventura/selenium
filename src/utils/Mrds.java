package utils;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mrds {
	public static WebDriver driver;
	public static void setUpDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			// For mac
			System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	public static void setWindow(WebDriver driver) {
	Set<String> allWindows = driver.getWindowHandles();
    Iterator<String> it = allWindows.iterator();
   String parent=it.next();
   String child= it.next();
    driver.switchTo().window(child);
    child=driver.getTitle();
    String childId= driver.getWindowHandle();
    System.out.println("window "+child+" "+" ID: "+childId);
    
    driver.switchTo().window(childId);
    String newW=driver.getWindowHandle();

	}
	
	public static void checkBox(WebDriver driver, String Id) {
		WebElement chckbox= driver.findElement(By.id(Id));
//	    Actions action = new Actions(driver);
//	    action.moveToElement(chckbox).click().build().perform();
	    System.out.println(chckbox.isDisplayed());// true
		System.out.println(chckbox.isEnabled());// true
		System.out.println(chckbox.isSelected());// false
		chckbox.click();
		System.out.println(chckbox.isSelected());
	   
	}
	  public static void clicking(String cssOrXpath,String location) {
	    	if(cssOrXpath.equalsIgnoreCase("css")) {
	    	WebElement element=driver.findElement(By.cssSelector(location));
	    	element.click();
	    }else if(cssOrXpath.equalsIgnoreCase("xpath")) {
	    	WebElement element=driver.findElement(By.xpath(location));
	    	element.click();
	    }
	    }
}
