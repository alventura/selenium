package tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.MethodsReuse;

public class Task1 extends MethodsReuse {
	
	public static void main(String[] args) {
		MethodsReuse.browserSetUp("chrome", "https://the-internet.herokuapp.com/tables");
		
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		String expected="Bach";
		String name;
		for (int a=1; a<=list.size(); a++) {
		
			 name=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+a+"]")).getText();
			
			if(name.contentEquals(expected)) {
				driver.findElement(By.xpath("table[@id='table1']/tbody/tr["+a+"]/td/a[@href='#edit']")).click();
				//driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td/a[1]")).click();
				break;
				
			}
			
		}
}
}