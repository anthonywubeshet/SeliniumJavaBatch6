package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("AAA");
		
		driver.findElement(By.name("lastName")).sendKeys("WWw");
		
		driver.findElement(By.name("phone")).sendKeys("703");
		
		driver.findElement(By.id("userName")).sendKeys("ant");
		
		driver.findElement(By.name("register")).click();
		
	}

}
