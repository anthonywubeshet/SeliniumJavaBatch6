package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.utils.BaseClass;

public class DropDownDemo2 extends BaseClass {

	public static void main(String[] args) {
		
		setUp();
		WebElement continents=driver.findElement(By.id("continents"));
		
		Select select=new Select(continents);
		List<WebElement> options=select.getOptions();//it will return list of all options in the DD
		
		for(WebElement option:options) {
			
			String text=option.getText();
			System.out.println(text);
			
			if(text.equals("Africa")) {
				option.click();
				String ddText=option.getText();
				
				if(ddText.equals("Africe")) {
					System.out.println("Africa is selected:: "+option.isSelected());
				}else {
					System.err.println("Africa is Not selected");
				}
				
			}
			
		}
		//select.selectByVisibleText("Antarctica");//You can select by Visble Text
		boolean isMultiple=select.isMultiple();
		System.out.println("The contitnet DD is Multiple:"+isMultiple);
		
		tearDown();

	}

}
