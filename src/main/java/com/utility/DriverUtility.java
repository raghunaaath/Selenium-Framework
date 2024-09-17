package com.utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;

public class DriverUtility{
	
	WebDriver driver;
	
	public DriverUtility() {
		driver = DriverFactory.getWebDriver();
	}
	
	
	public WebDriver resolve() {
		return driver;
	}
	
	public DriverUtility maximizeWindow() {
		driver.manage().window().maximize();
		return this;
	}
	
	public DriverUtility refreshWindow() {
		driver.navigate().refresh();
		return this;
	}
	
	public DriverUtility moveForward() {
		driver.navigate().forward();
		return this;
	}
	
	public DriverUtility moveBackWard() {
		driver.navigate().back();
		return this;
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
	
	public DriverUtility openURL(String URL) {
		driver.get(URL);
		return this;
	}
	
	public DriverUtility closeBrowser() {
		DriverFactory.quitDriver();
		return this;
	}

}
