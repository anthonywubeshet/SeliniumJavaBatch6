package com.syntax.class08;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.utils.BaseClass;

public class WaitDemo extends BaseClass {

	public static void main(String[] args) {
	
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebElement link=driver.findElement(By.linkText("Dynamic Controls"));
		link.click();
		driver.findElement(By.cssSelector("div#checkbox")).click();
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement goneText=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
		String text=goneText.getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		WebElement itsBack=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
		
		System.out.println(itsBack.getText());
		
		driver.close();
	}

}
