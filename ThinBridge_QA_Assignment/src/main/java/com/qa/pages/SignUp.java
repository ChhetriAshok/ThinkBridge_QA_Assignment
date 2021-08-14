package com.qa.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUp {
	
	private WebDriver driver;
	
	public SignUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//div[@id='language']")
	WebElement drpLanguage;
	
	@FindBy(xpath = "//div[@id='language']//a/div")
	List<WebElement> stcTxtLanguageDropDownValues;
	
	//sign-up
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement txtName;
	
	@FindBy(xpath = "//input[@id='orgName']")
	WebElement txtOrganizationName;
	
	@FindBy(xpath = "//input[@id='singUpEmail']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//label[@class='ui-checkbox']/span")
	WebElement chkAgreeTermsCondition;
	
	@FindBy(xpath = "//button[text()='Get Started']")
	WebElement btnGetStarted;
	
	@FindBy(xpath = "//span[normalize-space(text())='A welcome email has been sent. Please check your email.']")
	WebElement stcTxtSignUpConfirmationMsg;
	
	public void validateLanguageDropDown(String language) {
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
			}
		drpLanguage.click();
		List<String> drpDownValues_language = stcTxtLanguageDropDownValues.stream().map(i->i.getText().trim())
					.collect(Collectors.toList());
		String []lang = language.split(",");
		for(int i=0;i<lang.length;i++) {
			Assert.assertEquals(lang[i], drpDownValues_language.get(i));
		}
		new Actions(driver).moveToElement(stcTxtLanguageDropDownValues.get(0)).click().build().perform();
	}
	
	public void create_Account(String fullName, String organizationName, String email) {
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
			}
		txtName.sendKeys(fullName);
		txtOrganizationName.sendKeys(organizationName);
		txtEmail.sendKeys(email);
		new Actions(driver).moveToElement(chkAgreeTermsCondition).click(chkAgreeTermsCondition).build().perform();
		btnGetStarted.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(stcTxtSignUpConfirmationMsg));
		Assert.assertEquals(stcTxtSignUpConfirmationMsg.getText().trim(),
				"A welcome email has been sent. Please check your email.");
	}
	
	
	

}
