package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.syntax.utils.BaseClass;

public class SyntaxPracticeSiteFrameDemo {

	public static void main(String[] args) {
		
		WebDriver driver=BaseClass.setUp();
		
		driver.switchTo().frame("FrameOne");
		boolean logIsDis=driver.findElement(By.id("hide")).isDisplayed();
		System.out.println("logo inside frameone"+logIsDis);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("FrameTwo");
		boolean enrollBtnIsEnabled=driver.findElement(By.className("enroll-btn")).isEnabled();
		System.out.println("Enrol button inside frametwo "+enrollBtnIsEnabled);
		
		BaseClass.tearDown();
		
		
		
		
	}
	
	

}
