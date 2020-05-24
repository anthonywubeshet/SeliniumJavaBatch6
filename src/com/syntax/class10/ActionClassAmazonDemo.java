package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.syntax.utils.CommonMethods;

public class ActionClassAmazonDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp();
		
		WebElement account=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		
		Actions action=new Actions(driver);
		//hover the mouse over Menu
		action.moveToElement(account).perform();
		WebElement element=driver.findElement(By.xpath("//div[@id='nav-flyout-ya-newCust']"));
		
		if(element.getText().contains("Start")) {
			System.out.println("Menu displayed");
		}else {
			System.out.println("Menu Not displayed");
		}
		//how to rightclick on a element
		action.contextClick(element).perform();
		
		WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		//how to double click on a element.
		action.moveToElement(searchBox).click().sendKeys("Movies").doubleClick().perform();
		//action.moveToElement(searchBox).click().keyUp(Keys.SHIFT).sendKeys("movies").perform();
		Thread.sleep(5000);
		tearDown();

	}

}
