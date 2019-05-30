package Test1;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class QAToolsTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "\\Users\\alven\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.toolsqa.com/automation-practice-form/");
        List<WebElement> list = driver.findElements(By.cssSelector("input[id^='exp-']"));
        int i=0;
        for (WebElement ele : list) {
            i++;
            if (ele.isEnabled()) {
                ele.click();
                Thread.sleep(2000);
                if(i==4) {
                    break;
                }
            }
        }
        /**
         * above is for CSS list of elements
         */
        
        List<WebElement> it = driver.findElements(By.xpath("//input[@name='exp']"));
        Iterator<WebElement> radios = it.iterator();
        while (radios.hasNext()) {
            radios.next().click();
            Thread.sleep(1000);
        }
        /**
         * above is for Xpath list of elements
         */
        driver.close();
    }
}