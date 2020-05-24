package com.syntax.class10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class ScreenShotDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		setUp();
		
		driver.findElement(By.name("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.className("button")).click();
		
		Thread.sleep(2000);
		//create an object of TakeScreenshot interface and cast the Webdriver with it.
		TakesScreenshot ts=(TakesScreenshot)driver;
		//Use getScreenshotAs() method to take the screenshot(int the constructor pass Type.File
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		
		//Copy the file from source to a another destination
		FileUtils.copyFile(sourceFile, new File("screenshots/HRMS/dashboard.png"));
		
		tearDown();

	}

}
