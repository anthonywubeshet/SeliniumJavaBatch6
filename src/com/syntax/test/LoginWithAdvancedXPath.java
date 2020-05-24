package com.syntax.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginWithAdvancedXPath extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		//identify username based on the parent
		WebElement username=driver.findElement(By.xpath("//div[@id='divUsername']/input"));
		sendText(username, ConfigsReader.getProperty("username"));
		
		//identify password based on the following sibling
		WebElement password=driver.findElement(By.xpath("//span[text()='Password']/preceding-sibling::input"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		//identify login based on parents sibling
		//WebElement loginBtn=driver.findElement(By.xpath("//div[@id='divLoginHelpLink']/following-sibling::div/input"));
		//loginBtn.click();
		
		//identify login btn based on grandparent //form[@id='frmLogin']/div[5]/input
		WebElement loginBtn=driver.findElement(By.xpath("//form[@id='frmLogin']/div[5]/input"));
		loginBtn.click();
		
		Thread.sleep(5000);
		tearDown();
	}

}
