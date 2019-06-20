package utils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Mrds {
	public static WebDriver driver;
	
	public static String name="Denese";	
	public static String lastName="Downer";
	public static String middleN="n/a";
	public static String otherN="n/a";
	public static String social="699099456";
	
	public static String sub=social.substring(5, 9);
	public static String username=name+"."+lastName+"_"+sub;
	public static String password=lastName+"-"+sub;
	public static String address="410 West 26th Street";
	public static String apt="n/a";
	public static String city="Norfolk";
	public static String zip="23517";
	public static String bDate="01/26/1980";
	public static String dependents="4";
	public static String phone="7573439422";
	public static String email="n/a";
	
	String status="single";
	
	
	
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
	  
	  public static String acceptAlert() {
	    	try {
	    		   Alert alert=driver.switchTo().alert();
	    			alert.accept();
	    	}catch(NoAlertPresentException e){
	    		System.out.println("Alert not present");
	    		return null;
	    	}
			return null;
	   }
	  
	    //my method for Dropdown
	    public static void dropDown(String pathOrCss, String location, String text) {
			
			if (pathOrCss.equalsIgnoreCase("css")) {
		       WebElement element=driver.findElement(By.cssSelector(location));
		        
		        Select select = new Select(element);
		        List<WebElement> options = select.getOptions();
		        for (WebElement option : options) {
		            String optionText = option.getText();
		            if (optionText.equals(text)) {
		                select.selectByVisibleText(text);
		                break;
		            }
		      }
		        }else if(pathOrCss.equalsIgnoreCase("xpath")) {
		    		WebElement element=driver.findElement(By.xpath(location));
		    		Select select = new Select(element);
			        List<WebElement> options = select.getOptions();
			        for (WebElement option : options) {
			            String optionText = option.getText();
			            if (optionText.equals(text)) {
			                select.selectByVisibleText(text);
			                break; 
			            }else {
			            	System.out.println("OH NO! Something went wrong");   
			            	}
			        }
			     }else {
		    		System.out.println("OH NO! Something went wrong");
		    	}
	    }

	    public static void sendText1(String locator, String element, String value) {
	    	if (locator.equalsIgnoreCase("css")) {
	    		
	    	driver.findElement(By.cssSelector(element)).clear();
	        driver.findElement(By.cssSelector(element)).sendKeys(value);
	    	}
	    	else if(locator.equalsIgnoreCase("xpath")) {
	    		 driver.findElement(By.xpath(element)).clear();
	    		 driver.findElement(By.xpath(element)).sendKeys(value);
	    	}else {
	    		System.out.println("OH NO! Something went wrong");
	    	}
	    }
}
