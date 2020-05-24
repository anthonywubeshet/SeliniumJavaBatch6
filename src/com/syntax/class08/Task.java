package com.syntax.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Task {

	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/table-search-filter-demo.html");
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		
		System.out.println(rows.size());
		System.out.println(cols.size());
		
		for(WebElement col:cols) {
			String colText=col.getText();
			System.out.println(colText);
		}
		
		for(WebElement row:rows) {
			String rowText=row.getText();
			System.out.println(rowText);
		}


	}

}
