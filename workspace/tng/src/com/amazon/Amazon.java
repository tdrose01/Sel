package com.amazon;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon {

	private FirefoxDriver driver;

	@Before
	public void setupSelenium() {
		driver = new FirefoxDriver();
	}

	@After
	public void closeSelenium() {
		driver.close();
		driver.quit();
	}

	@Test public void
	search_amazon() {
		// Open the amazon home page
		driver.get("http://www.amazon.com/");
		

		// Enter a search term
/*		WebElement keywordsField = driver.findElement(By.name("field-keywords")); 
		keywordsField.sendKeys("iain banks");

		// Click go
		WebElement goButton = driver.findElement(By.id("nav-search-in")); 
		goButton.click();
		// Confirm top result
*/		
		WebElement topResultTitle = driver.findElement(By.xpath("//*[@id='nav-your-account']/span[2]"));
		topResultTitle.click();
		
		//driver.findElement(By.id("result_10"));
		/*WebElement topResultTitle = driver.findElement(By.link("result_10"));*/
			
		
		//assert.assertThat(topResultTitle, "Am", "Amazon");
		// Expection handling in Java
		//assert.
		
	}
}



