package com.syntax.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.CommonMethods;

public class FacebookSignUp extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		sendText(firstName, "Anthony");
		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		sendText(lastName, "Smith");
		WebElement email=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		sendText(email, "anthony@hotmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		sendText(password, "Password");
		List<WebElement> faceBookRadio=driver.findElements(By.xpath("//input[@type='radio']"));
		clickRadioOrCheckbox(faceBookRadio, "2");
		
		WebElement monthDD=driver.findElement(By.id("month"));
		Select obj=new Select(monthDD);
		obj.selectByVisibleText("Jun");
		
		WebElement dayDD=driver.findElement(By.id("day"));
		selectDDValue(dayDD, 6);
		
		WebElement yearDD=driver.findElement(By.id("year"));
		selectDDValue(yearDD, "1990");
		
		Thread.sleep(3000);
		tearDown();
		

	}

}
