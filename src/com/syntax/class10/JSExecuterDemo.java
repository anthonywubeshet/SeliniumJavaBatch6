package com.syntax.class10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class JSExecuterDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		setUp();
		
		driver.findElement(By.name("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		WebElement pass=driver.findElement(By.id("txtPassword"));
		WebElement loginBtn=driver.findElement(By.className("button"));
		pass.sendKeys(ConfigsReader.getProperty("password"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//change the background color of an element.
		js.executeScript("arguments[0].style.backgroundColor='red'",pass );
		
		//click on login btn using js
		js.executeScript("arguments[0].click()", loginBtn);
		
		js.executeScript("window.scrollBy(0,250)");
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-250)");
		
		Thread.sleep(5000);
		
		tearDown();

	}

}
