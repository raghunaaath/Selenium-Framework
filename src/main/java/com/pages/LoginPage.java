package com.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtility;

import dev.failsafe.internal.util.Assert;

public class LoginPage {

	private DriverUtility driverUtility;
	private WebDriver driver;

	@FindBy(id="username")
	private WebElement userIDInput;

	@FindBy(id="password")
	private WebElement passwordInput;

	@FindBy(id="log-in")
	private WebElement LoginButton;
	
	@FindBy(xpath="//h6[@id='time']")
	private WebElement headerText;

	public LoginPage() {

		System.out.println("Login Page Constructor");
		this.driverUtility = new DriverUtility("chrome",true);
		this.driver = driverUtility.getWebDriver();
		if(this.driver==null) {
			System.out.println("Driver is null");
		}
		PageFactory.initElements(this.driver, this);

	}

	public LoginPage login(String userName,String password) {

		userIDInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		LoginButton.click();
		
		String header = headerText.getText();
		
		assertEquals(header, "Your nearest branch closes in: 30m 5s");
		
		return this;
	}


}
