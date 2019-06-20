package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.CommonMethods;

public class GoogleDemo extends CommonMethods {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		setUpDriver("chrome", "http://google.com");
		Thread.sleep(4000);
		TakesScreenshot camera=(TakesScreenshot)driver;
		File selfie=camera.getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(selfie, new File("screenshots/Google/GooglePage.png"));
			}catch(IOException e){
				System.out.println("No picture taken");
			}
		
				

	}

}
