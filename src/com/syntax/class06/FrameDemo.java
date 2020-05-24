package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.BaseClass;

public class FrameDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();//uitestpractice
		String text=driver.findElement(By.xpath("//h3[text()='click on the below link: ']")).getText();
		System.out.println(text);
		
		/*
		 * we can switch to a frame using three different methods 
		 * 1.By  index
		 * 2.By NameOrId
		 * 3.By WebElement
		 */
		
		//by index
		driver.switchTo().frame(0);
		WebElement name=driver.findElement(By.id("name"));
		name.sendKeys("Vital");
		driver.switchTo().defaultContent();//switch back to main window
		Thread.sleep(2000);
		
		//by name or id
		driver.switchTo().frame("iframe_a");//switch method is used to switch to a frame
		name.clear();
		name.sendKeys("Sermed");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		//by webelement
		WebElement firstFrame=driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
		driver.switchTo().frame(firstFrame);
		name.clear();
		name.sendKeys("Asel");
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(3000);
		tearDown();

	}

}
