package com.baseClass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.factory.DriverFactory;
import com.utility.ConfigUtility;

public class BaseTest {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = DriverFactory.initWebDriver(new ConfigUtility())
				.maximizeWindow()
				.openURL(new ConfigUtility().getPropertyValueOf("APPLICATION_URL"))
				.resolve();	
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
