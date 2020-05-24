package com.syntax.class07;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleWithLoop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-switch-windows-2/");
		
		String signUpTitle=driver.getTitle();
		System.out.println("main page title is "+signUpTitle);
		String parentWindowHandled=driver.getWindowHandle();//grab the handle of parent window
		System.out.println("What is the parent window handle? "+parentWindowHandled);
		
		for(int i=1; i<=3; i++) {
			driver.findElement(By.id("button1")).click();
			Thread.sleep(2000);
		}
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			System.out.println("Id of the Window::"+handle);
			driver.switchTo().window(handle);
			driver.get("https://www.google.com/");
			Thread.sleep(2000);
			driver.close();
		}
		
		
		
	}

}
