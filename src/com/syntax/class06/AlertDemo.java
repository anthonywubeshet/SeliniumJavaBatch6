package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.syntax.utils.BaseClass;

public class AlertDemo{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=BaseClass.setUp();//Below code is for uitestpractice.com/Students/Switchto
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		
		//handling simple alert/PopUps
		Alert simpleAlert=driver.switchTo().alert();
		Thread.sleep(1000);
		String simpleAText=simpleAlert.getText();
		System.out.println("This is simple alert text::"+simpleAText);
		Thread.sleep(1000);
		simpleAlert.accept();
		
		//Handling confirmation Alert
		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert=confirmAlert=driver.switchTo().alert();
		Thread.sleep(1000);
		String confirmAText=confirmAlert.getText();
		System.out.println("This is Confirm alert text::"+confirmAText);
		Thread.sleep(1000);
		confirmAlert.dismiss();
		
		//Handling Prompt alerts/confirmation alerts by providing some confirmation message
		driver.findElement(By.id("prompt")).click();
		Alert promptAlert=driver.switchTo().alert();
		System.out.println("This is Prompt alert text"+promptAlert.getText());
		promptAlert.sendKeys("Alex");
		promptAlert.accept();
		
		String text=driver.findElement(By.xpath("//div[@id='demo']")).getText();
		System.out.println("text added to alert box"+text);
		if(text.contains("Alex")) {
			System.out.println("Text was sucessfully added");
		}else{
			System.err.println("Text was not added");
		}
		
		BaseClass.tearDown();

	}

}
