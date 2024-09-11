package com.baseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public DriverUtility driverUtility;
	public WebDriver driver;
	
	
	public Base() {
		
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		System.out.println("Printing SetUp");
		driverUtility = new DriverUtility("Chrome",false);
		driverUtility.maximizeWindow();
		driverUtility.openURL("https://demo.applitools.com/index.html");
		driver = driverUtility.getWebDriver();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		System.out.println("Printing tearDown");
		this.driverUtility.closeBrowser();
		
	}

}
