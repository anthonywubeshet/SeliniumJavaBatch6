package com.syntax.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.syntax.utils.CommonMethods;

public class AmericanAirlineCalendar extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();//https://www.aa.com/homePage.do
		//Enter from and To Airports
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("AID",Keys.TAB);
		driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("JFK",Keys.TAB);
		
		//click on the calendar and select month and year
		driver.findElement(By.id("aa-leavingOn")).click();
		
		boolean flag=false;
		
		while(!flag) {
			
			String dMonth=driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div")).getText();
			if(dMonth.equals("July 2020")) {
				List<WebElement> depCells=driver.findElements(By.xpath("//div[contains(@class,'ui-corner-left')]/following-sibling::table/tbody/tr/td"));
				for (WebElement cell : depCells) {
					String cellText=cell.getText();
					if(cellText.equals("14")) {
						cell.click();
						
						flag=true;
						break;
					}
					
				}
			}else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
			Thread.sleep(2000);
		}
		
		driver.findElement(By.xpath("//input[@id='aa-returningFrom']")).click();
		flag=false;
		while(!flag) {
			
			String rMonth=driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div")).getText();
			if(rMonth.equals("November 2020")) {
				List<WebElement> returnCells=driver.findElements(By.xpath("//div[contains(@class,'ui-corner-left')]/following-sibling::table/tbody/tr/td"));
				
				for(WebElement returnCell:returnCells) {
					
					String returnText=returnCell.getText();
					if(returnText.equals("8")) {
						returnCell.click();
						flag=true;
						break;
					}
				}
			}else{
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
			Thread.sleep(2000);
		}
		
		
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
