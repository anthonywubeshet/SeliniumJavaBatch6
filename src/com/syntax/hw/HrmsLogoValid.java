package com.syntax.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;

public class HrmsLogoValid extends CommonMethods {

	public static void main(String[] args) {
		
		setUp();
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		
		System.out.println(logo.isDisplayed());
		
		tearDown();
	}

}
