package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.syntax.utils.BaseClass;

public class FrameRecap {

	public static void main(String[] args) {
		

		WebDriver driver=BaseClass.setUp();
		
		boolean isHomeDis=driver.findElement(By.xpath("//a[@href='./index.html']")).isDisplayed();
		System.out.println("is home link displayed? "+isHomeDis);
		
		driver.switchTo().frame("FrameOne");
		
		String welcomeMesge=driver.findElement(By.xpath("//h3[text()='Welcome to Selenium Easy ']")).getText();
		System.out.println(welcomeMesge);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("FrameTwo");
		
		boolean buttonEnabled=driver.findElement(By.xpath("//a[@class='enroll-btn']")).isEnabled();
		
		System.out.println("Is enroll btn enabled? "+buttonEnabled);
	}

}
