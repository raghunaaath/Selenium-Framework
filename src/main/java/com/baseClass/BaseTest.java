package com.baseClass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.factory.DriverFactory;
import com.utility.ConfigUtility;

public class BaseTest {
	
	public static WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = DriverFactory.initWebDriver(new ConfigUtility());
		
		
		
	}
}
