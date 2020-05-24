package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;

public class Task extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp();//https://www.aa.com/homePage.do
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		String fMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		
		while(!fMonth.equals("June")) {
			driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
			fMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}
		
		List<WebElement> fromCells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for(WebElement fromCell:fromCells) {
			String fromText=fromCell.getText();
			if(fromText.equals("14")) {
				fromCell.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();
		String rMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();
		
		while(!rMonth.equals("November")) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
			rMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();
			}
		
		List<WebElement> returnCells=driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td"));
		for(WebElement returnCell:returnCells) {
			String returnText=returnCell.getText();
			if(returnText.equals("8")) {
				returnCell.click();
				break;
			}
		}
		
		

	}

}
