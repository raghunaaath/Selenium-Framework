package com.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BasePage;
import com.baseClass.BaseTest;
import com.utility.DriverUtility;
import com.widgets.Button;

import dev.failsafe.internal.util.Assert;

public class LoginPage extends BasePage{
	
	Button loginButton;

	@FindBy(name="UserName")
	private WebElement userIDInput;

	@FindBy(name="Password")
	private WebElement passwordInput;

	@FindBy(id="login")
	private WebElement LoginButton;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		loginButton = new Button(driver,LoginButton);
	}

	public LoginPage enterUserID(String userName) {
		userIDInput.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		passwordInput.sendKeys(password);
		return this;
	}
	
	public LoginPage clickOnLoginButton() {
		loginButton.click();
		return this;
	}


}
