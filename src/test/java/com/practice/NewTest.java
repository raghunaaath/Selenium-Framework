package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
  @Test
  public void removeButtonValidation_1() {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://www.uitestingplayground.com/visibility");
	  driver.findElement(By.id("hideButton")).click();
	  try {
		  boolean isDisplayed = driver.findElement(By.id("removedButton")).isDisplayed(); 
		  if(isDisplayed) {
			  System.out.println("Button is still displaying");
		  }
		  
		  
	  }catch(Exception e) {
		  System.out.println("Button has been removed");
	  }
	  
	  driver.quit();
	  
	  
  }
  @Test
  public void removeButtonValidation_2() {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://www.uitestingplayground.com/visibility");
	  driver.findElement(By.id("hideButton")).click();
	  try {
		  boolean isDisplayed = driver.findElement(By.id("removedButton")).isDisplayed(); 
		  if(isDisplayed) {
			  System.out.println("Button is still displaying");
		  }
		  
		  
	  }catch(Exception e) {
		  System.out.println("Button has been removed");
	  }
	  
	  driver.quit();
	  
	  
  }
}
