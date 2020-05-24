package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;

public class DeltaCalendarDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		//click on depart/to calendar
		driver.findElement(By.xpath("//span[@class='calenderDepartSpan']")).click();
		
		String dMonth=driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		
		while(!dMonth.equals("August")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(2000);
			dMonth=driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		}
		
		//loop through td and grab the text
		List<WebElement> fromCells=driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td"));
		for(WebElement fromCell:fromCells) {
			String fromText=fromCell.getText();
			if(fromText.equals("15")) {
				fromCell.click();
				break;
			}
		}
		
		//grab the text of return month and check if it equals to October
		String returnMoth=driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();
		
		while(!returnMoth.equals("October")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(2000);
			returnMoth=driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();
		}
		
		List<WebElement> returnCells=driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
		
		for(WebElement returnCell:returnCells) {
			String returnText=returnCell.getText();
			if (returnText.equals("9")) {
				returnCell.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[@value='done']")).click();
		Thread.sleep(5000);
		tearDown();
		

	}

}
