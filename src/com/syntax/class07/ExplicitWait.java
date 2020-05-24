package com.syntax.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://166.62.36.207/syntaxpractice/dynamic-elements-loading.html");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.id("startButton")).click();
		
		//boolean ele=driver.findElement(By.xpath("//p[contains(text(),'First Name :')]")).isDisplayed();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Welcome Syntax Technologies')]")));
		
		String text=driver.findElement(By.xpath("//h4[contains(text(),'Welcome Syntax Technologies')]")).getText();
		
		System.out.println(text);
		
		driver.quit();

	}

}
