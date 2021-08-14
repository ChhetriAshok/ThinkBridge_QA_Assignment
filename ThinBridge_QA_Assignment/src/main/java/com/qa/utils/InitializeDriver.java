package com.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitializeDriver {

	private WebDriver driver;
	
	public WebDriver InitializeWebDriver(String browser) {
		try {
			
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			default:
				Assert.fail("Browser not perfectly configured or invaild browser passed");
				
			}
			driver.manage().window().maximize();
		}catch(Exception e) {
			new Throwable("Error in Driver Initilization");
		}
		return driver;
	}
	
}
