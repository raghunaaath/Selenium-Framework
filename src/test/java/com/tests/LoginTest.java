package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseClass.BaseTest;
import com.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "loginDataProvider")
	public void LoginCheck(String userId,String password) {
		
		LoginPage loginPage = new LoginPage(driver)
				.enterUserID(userId)
				.enterPassword(password)
				.clickOnLoginButton();
		
	}
	
	@DataProvider(name="loginDataProvider")
	public Object[][] loginData(){
		return new Object [][] {
			{"ssdac","pwd"},
			{"dcgdhc","pwd"}
		};
	}

}
