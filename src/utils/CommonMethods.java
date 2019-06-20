package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	public static WebDriver driver;
	public static Select name;

	public static void setUpDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			// For mac
			System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}

    public static void selectValueFromDD(WebElement element, String text) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals(text)) {
                select.selectByVisibleText(text);
                break;
            }else {
                System.out.println("Option with text �+text+� is not available");
            }
        }
    }

    public static void selectValueFromDD(WebElement element, int index) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        if (options.size() > index) {
            select.selectByIndex(index);
        }else {
            System.out.println("Invalid index has been passed");
        }
    }
    
    
    public static void checkBox(WebDriver driver, WebElement webElement) {
		WebElement chckbox= webElement;
	   // chckbox.isDisplayed();// true
		//chckbox.isEnabled();// true
		//chckbox.isSelected();// false
		chckbox.click();
		//chckbox.isSelected();
    
    }
    
    public static void sendText(String locator, String element, String value) {
    	if (locator.equalsIgnoreCase("css")) {
        driver.findElement(By.cssSelector(element)).sendKeys(value);
    	}
    	else if(locator.equalsIgnoreCase("xpath")) {
    		 driver.findElement(By.xpath(element)).sendKeys(value);
    	}else {
    		System.out.println("OH NO! Something went wrong");
    	}
    }
    public static void selectByValue(WebElement element,String value) {
        name=new Select(element);
       List<WebElement> list=name.getOptions();
       for(WebElement ele:list) {
           System.out.println(ele.getText());
           if(value.equals(ele.getAttribute("value"))) {
                name.selectByValue(value);
           }
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

    //my method to click
    public static void clicking(String cssOrXpath,String location) {
    	if(cssOrXpath.equalsIgnoreCase("css")) {
    	WebElement element=driver.findElement(By.cssSelector(location));
    	element.click();
    }else if(cssOrXpath.equalsIgnoreCase("xpath")) {
    	WebElement element=driver.findElement(By.xpath(location));
    	element.click();
    }
    }
    
    /**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, int time
	 */
	public static void waitForElementBeVisible(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementBeVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementBeClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementBeClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

    public static String getAlertText() {
    	try {
    	Alert alert= driver.switchTo().alert();
    	return alert.getText();
    	}catch(NoAlertPresentException e){
    		System.out.println("Alert not present");
    		return null;
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
    
    public static void takeScreenshot(String folderName, String fileName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
        File scr=ts.getScreenshotAs(OutputType.FILE);
        
        try {
			FileUtils.copyFile(scr, new File("screenshots/"+folderName+"/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screesnhot");
		}
	}
    
    public void scrollDown(int pixels) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,"+pixels+")");
    }
    public void scrollUp(int pixels) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,-"+pixels+")");
    }
    public void jsClick(WebElement element) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();",element);
    }
}