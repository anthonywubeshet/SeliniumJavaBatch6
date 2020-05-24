package com.syntax.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class DropDownDemo3 extends BaseClass {

	public static void main(String[] args) {
		
		setUp();
		WebElement continents=driver.findElement(By.id("continents"));
		
		Select select=new Select(continents);
		
		select.selectByValue("AUS");
		
		List<WebElement> optionsList=select.getOptions();
		Iterator <WebElement> it=optionsList.iterator();
		
		while(it.hasNext()) {
			String text=it.next().getText();
			System.out.println(text);
		}
	}

}
