package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");//making connection to driver
		WebDriver driver= new ChromeDriver();// open chrome browser by calling constructor
		
		driver.get("https://www.google.com");
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		System.out.println(driver.getTitle());
		//Thread.sleep(2000);
		
		//driver.close();

	}

}
