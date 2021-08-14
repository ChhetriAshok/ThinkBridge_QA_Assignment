package com.qa.test;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.SignUp;

public class TestPage extends TestBase {

	
	@Test
	public void sign_up_Jaba_Talks() {
		
		SignUp signUp = new SignUp(driver);
		signUp.validateLanguageDropDown(textMessages.getProperty("language_dropDown_values"));
		signUp.create_Account(textMessages.getProperty("fullName"), 
				textMessages.getProperty("organizationName"), textMessages.getProperty("orgEmail"));
	}
	
}
