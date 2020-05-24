package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/window-popup-modal-demo.html");
		String signUpTitle=driver.getTitle();
		System.out.println("main page title is "+signUpTitle);
		String parentWindowHandled=driver.getWindowHandle();//grab the handle of parent window
		System.out.println("What is the parent window handle? "+parentWindowHandled);
		
		driver.findElement(By.linkText("Follow On Instagram")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Like us On Facebook")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Follow Instagram & Facebook")).click();
		
		Set<String> allWindowHandles=driver.getWindowHandles();//returns set of window handle of all windows
		System.out.println("What is the number of windows opened? "+allWindowHandles.size());
		
		Iterator<String> it=allWindowHandles.iterator();
		
		while(it.hasNext()) {
			String handle=it.next();//grab next window handle
			if(!handle.equals(parentWindowHandled)) {//switch to next window if not same as parent window
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				driver.close();
				Thread.sleep(1000);
			}
		}
		
		
		driver.close();
		

	}

}
