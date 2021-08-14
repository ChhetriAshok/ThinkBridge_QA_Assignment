package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.qa.utils.InitializeDriver;
import com.qa.utils.TestDataUtils;


public class TestBase {
	
	protected WebDriver driver;
	protected TestDataUtils textMessages;
	
	@BeforeSuite
	public void setupBase() {
		driver = new InitializeDriver().InitializeWebDriver("chrome");
		textMessages = new TestDataUtils("textValidations");
		driver.get(textMessages.getProperty("url"));
		
	}
	
}
