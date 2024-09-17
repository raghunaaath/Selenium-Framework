package com.widgets;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
	
	private WebDriver driver;
	private WebElement buttonElement;
	
	public Button(WebDriver driver,WebElement buttonLocator) {
		this.driver = driver;
		this.buttonElement = buttonLocator;	
	}
	
	public void waitForButtonToBeClickable() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
	}
	
	public void click() {
		waitForButtonToBeClickable();
		buttonElement.click();
	}

}
