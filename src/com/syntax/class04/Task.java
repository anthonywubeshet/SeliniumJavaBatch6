package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) {
		/*1.open chrome browser
		 * 2.go to amazon
		 * 3.get all links
		 * get number of links that has text 
		 * print only links that has text
		 * 
		 * 
		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		int count=0;
		
		for (WebElement link : allLinks) {
			String text=link.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
