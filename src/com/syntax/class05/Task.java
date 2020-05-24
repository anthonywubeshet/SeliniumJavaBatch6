package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class Task extends BaseClass {

	public static void main(String[] args) {
		/*
		 * open chrome browser
		 * go to facebook
		 * verify: month dd has 12 options
		 * day dd has 31 day options 
		 * year dd has 115 year options
		 *  Select your data of birth 
		 *  quit browser 
		 */
		
		setUp();
		WebElement monthDD=driver.findElement(By.name("birthday_month"));
		Select select= new Select(monthDD);
		
		List<WebElement> list=select.getOptions();
		System.out.println(list.size());
		
		WebElement dayDD=driver.findElement(By.name("birthday_day"));
		Select select1= new Select(dayDD);
		List<WebElement> list1=select1.getOptions();
		System.out.println(list1.size());
		
		WebElement yearDD=driver.findElement(By.name("birthday_year"));
		Select select2= new Select(yearDD);
		List<WebElement> list2=select2.getOptions();
		System.out.println(list2.size());
		
		select.selectByVisibleText("Oct");
		select1.selectByVisibleText("6");
		select2.selectByVisibleText("1995");

		
	}

}
