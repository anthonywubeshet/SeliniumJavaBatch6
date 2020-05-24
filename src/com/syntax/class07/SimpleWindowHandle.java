package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleWindowHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.com%2F&hl=en&dsh=S-620231072%3A1589331523610987&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		String signUpTitle=driver.getTitle();
		System.out.println("main page title is "+signUpTitle);
		
		driver.findElement(By.linkText("Help")).click();
		
		/*
		 * how to get window handle?
		 * in selenium we have two methods to get the hand of window
		 * getWindowHandle();
		 * getWindowHandles();
		 */
		
		Set<String> allWindowHandles=driver.getWindowHandles();//returns set of string IDs of all windows currently opened by the current instance
		
		System.out.println("Number of windows open are:: "+allWindowHandles.size());//get size of set
		
		Iterator<String> it=allWindowHandles.iterator();
		
		String mainWindowHandle=it.next();//return id of the main window
		System.out.println("Id of Main window:: "+mainWindowHandle );
		
		String childWindowHandle=it.next();//returns id of child window
		System.out.println("Id of Child window:: "+childWindowHandle );
		
		driver.switchTo().window(childWindowHandle);
		
		String childWindowTitle=driver.getTitle();
		
		System.out.println("Child Page Title is:: "+childWindowTitle);
		driver.close();//will close window where the focus of the driver is

	}

}
