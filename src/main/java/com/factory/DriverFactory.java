package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.utility.ConfigUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Class Demonstrates how to setup WebDriver for the framework. 
 * Developed By : Raghunath Majhi
 * Date : 8th Sept 2024
 * 
 */
public class DriverFactory {


	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initWebDriver(ConfigUtility configUtility) {
		
		String browserType = configUtility.getPropertyValueOf("BROWSER_TYPE");
		boolean isHeadless = Boolean.parseBoolean(configUtility.getPropertyValueOf("RUN_HEADLESS"));

		if(driver.get()==null) {

			switch(browserType.toUpperCase()) {
			case "CHROME":
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				setHeadLessOptions(chromeOptions, isHeadless);
				driver.set(new ChromeDriver(chromeOptions));
				break;
			case "EDGE":
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeOptions = new EdgeOptions();
				setHeadLessOptions(edgeOptions, isHeadless);
				driver.set(new EdgeDriver(edgeOptions));	
				break;
			case "FIREFOX":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				setHeadLessOptions(firefoxOptions, isHeadless);
				driver.set(new FirefoxDriver(firefoxOptions));
				break;
			default:
				throw new IllegalArgumentException("Unsupported Browser "+browserType);
			}

		}


		return driver.get();
	}

	public static WebDriver getWebDriver() {
		
		if(driver.get()==null) {
			throw new IllegalStateException("WebDriver not Initialized Yet.");
		}
		return driver.get();
	}

	public static void quitDriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
		}

	}

	private static void setHeadLessOptions(Object options,boolean isHeadless) {
		if(isHeadless) {
			if(options instanceof ChromeOptions) {
				((ChromeOptions)options).addArguments("--headless"); 	
			}else if (options instanceof FirefoxOptions) {
				((FirefoxOptions)options).addArguments("--headless");
			}else if(options instanceof EdgeOptions) {
				((EdgeOptions)options).addArguments("--headless");
			}
		}
	}



}
