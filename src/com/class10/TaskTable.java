package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class TaskTable extends CommonMethods{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setUpDriver("chrome","https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Sortable Data Tables")).click();
        List<WebElement>col=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        int sizeC=col.size();
        System.out.println(sizeC);
        List<WebElement>row=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        int sizeR=row.size();
        System.out.println(sizeR);
        
        if(sizeC==6&&sizeR==4) {
            for(WebElement run:col) {
                System.out.println(run.getText());
            }
            for(WebElement run:row) {
                System.out.println(run.getText());
            }
            
        }
        driver.close();
    }
		
	

}
