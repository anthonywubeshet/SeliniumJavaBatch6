package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class SimpleCalendarDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		//http://166.62.36.207/humanresources/symfony/web/index.php/dashboard
		setUp();
		
		//login to HRMS application
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.id("btnLogin")).click();
		
		//navigate to leave list 
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();
		
		//click on the calendar 
		driver.findElement(By.id("calFromDate")).click();
		
		WebElement mDD=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		selectDDValue(mDD, "Apr");
		
		WebElement yDD=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		selectDDValue(yDD, "2021");
		
		//select day from the calendar
		List<WebElement> fromDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
		
		for(WebElement fromDay:fromDate) {
			if(fromDay.getText().equals("15")) {
				fromDay.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		tearDown();

	}

}
