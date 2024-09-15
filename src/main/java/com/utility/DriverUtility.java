package com.utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;

public class DriverUtility{
	
	WebDriver driver;
	
	public DriverUtility(String browserType,boolean isHeadless) {
		
	//	this.driver = DriverFactory.initWebDriver(browserType, isHeadless);
	
	}
	
	public DriverUtility() {
		
	}
	
	public WebDriver getWebDriver() {
		return this.driver;
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void refreshWindow() {
		driver.navigate().refresh();
	}
	
	public void moveForward() {
		driver.navigate().forward();
	}
	
	public void moveBackWard() {
		driver.navigate().back();
	}
	
	public String switchToTab(String tabName) {
		
		String currentWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String windowHandle : windowHandles) {
			
			driver.switchTo().window(windowHandle);
			
			if(driver.getTitle().equals(tabName)) {
				break;
			}
		}
		
		return currentWindow;
		
	}
	
	public void openURL(String URL) {
		driver.get(URL);
	}
	
	public void closeBrowser() {
		DriverFactory.quitDriver();
	}

}
