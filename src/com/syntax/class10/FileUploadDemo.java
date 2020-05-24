package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class FileUploadDemo {

	public static void main(String[] args) {
		//String filePath="C:\\Users\\antho\\Pictures\\Camera Roll";
		String url="https://the-internet.herokuapp.com/";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		//click on File Upload link
		driver.findElement(By.linkText("File Upload")).click();
		
		//click on choose File
		//driver.findElement(By.id("file-upload")).click();
		//We simply use sendkeys() method to upload the file
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\antho\\Pictures\\Camera Roll");
		driver.findElement(By.id("file-submit")).click();
		
		driver.quit();
	}

}
