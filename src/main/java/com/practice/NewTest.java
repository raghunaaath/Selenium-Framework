package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

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
  
  @Test
  public void TestWaitingPeriod_1() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://play1.automationcamp.ir/expected_conditions.html");
	  
	  driver.findElement(By.id("alert_trigger")).click();
	  WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	  
	  alert.accept();
	  
	  String message = driver.findElement(By.id("alert_handled_badge")).getText();
	  Assert.assertEquals(message,"Alert handled");
	  
  }
  
  @Test
  public void TestWaitingPeriod_2() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://play1.automationcamp.ir/expected_conditions.html");
	  
	  String[] inputs = {"OK","Cancel"};
	  
	  for(int i=0;i<inputs.length;i++) {
		  
		  driver.findElement(By.id("prompt_trigger")).click();
		  WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		  
		  String promptMessage = alert.getText();
		  //Assert.assertEquals("promptMessage", null)
		  System.out.println(promptMessage);
		  if(inputs[i].equalsIgnoreCase("OK")) {
			  alert.accept();
			  String sucessMessage = driver.findElement(By.id("confirm_ok_badge")).getText();
			  Assert.assertEquals("OK",sucessMessage);
		  }else if(inputs[i].equalsIgnoreCase("Cancel")) {
			  alert.dismiss();
			  String sucessMessage = driver.findElement(By.id("confirm_cancelled_badge")).getText();
			  Assert.assertEquals("Cancelled",sucessMessage);
			 
		  }  
	  }

  }
  
  @Test
  public void TestWaitingPeriod_3() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://play1.automationcamp.ir/expected_conditions.html");
	  
	  try {
		  driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		  System.out.println("Button Exists");
		  
	  }catch(Exception e) {
		  System.out.println("Button does not exist");
		  driver.findElement(By.xpath("//button[text()='Trigger']")).click();
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='visibility_target']"))));
		  element.click();
	  }
	  
	  driver.quit();

  }
  
  @Test
  public void TestIframe_1() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://play1.automationcamp.ir/frames.html");
	  
	  driver.switchTo().frame("frame1");
	 // driver.switchTo().frame("frame2");
	  driver.switchTo().frame("frame3");
	  driver.switchTo().frame("frame4");
	  driver.findElement(By.id("click_me_4")).click();
	  
	 
	  driver.quit();

  }
  
  @Test
  public void MultiWindow_1() {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://play1.automationcamp.ir/multi_window.html");
	  
	 driver.findElement(By.id("window1")).click();
	 String currentWindowHandle = driver.getWindowHandle();
	 
	 Set<String> tabs = driver.getWindowHandles();
	 for(String tabName : tabs) {
		 if(tabName.contains("Frame2")) {
			 driver.switchTo().window(tabName);
			 driver.findElement(By.id("click_me_2")).click();
			 driver.switchTo().window(currentWindowHandle);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 break;
		}
	 }
	 
	  driver.quit();

  }

@Test
public void ScrollToView_1() {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://www.uitestingplayground.com/overlapped");
	  driver.findElement(By.id("id")).sendKeys("UserName");
	  WebElement element = driver.findElement(By.id("name"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",element);
	 try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 element.sendKeys("Raghu");
	
	  driver.quit();

  }
@Test
public void amazonAddToCart_1() throws InterruptedException {
	   
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.get("https://amazon.in");
	  
	  WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
	  Select select = new Select(dropDown);
	  
	  select.selectByVisibleText("Electronics");
	  
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smartphone");
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  Thread.sleep(2000);
	  
	 
	  
	  WebElement slider = driver.findElement(By.xpath("(//input[@type='range'])[2]"));
	  
	  
	  
	  WebElement minSlider = driver.findElement(By.id("p_36/range-slider_slider-item_lower-bound-slider"));
	  WebElement maxSlider = driver.findElement(By.id("p_36/range-slider_slider-item_upper-bound-slider"));
	  
	  int currentValueMin = Integer.parseInt(minSlider.getAttribute("value"));
	  int currentValueMax = Integer.parseInt(maxSlider.getAttribute("value"));
	  System.out.println("Current Value Min "+currentValueMin);
	  System.out.println("Current Value Max "+currentValueMax);
	  
	  Thread.sleep(15000);
	  Actions action = new Actions(driver);
	  action.dragAndDropBy(minSlider, 50, 0).perform();
	  action.dragAndDropBy(maxSlider, -50, 0).perform();
	  
	  currentValueMin = Integer.parseInt(minSlider.getAttribute("value"));
	  currentValueMax = Integer.parseInt(maxSlider.getAttribute("value"));
	  System.out.println("Current Value Min "+currentValueMin);
	  System.out.println("Current Value Max "+currentValueMax);
	  /*int max = Integer.parseInt(slider.getAttribute("max"));
	  int min = Integer.parseInt(slider.getAttribute("min"));
	  int sliderWidth = slider.getSize().width;
	  
	  int targetPrice = -100;
	  int xOffSet = (int)((targetPrice-currentValue)*	(sliderWidth/(max-min)));
	  
	  System.out.println(xOffSet);
	  
	  Actions action = new Actions(driver);
	  Thread.sleep(10000);
	  action.dragAndDropBy(slider, xOffSet, 0).perform();
	  */
	  Thread.sleep(30000);
	  
	  
	  driver.quit();

  }

  @Test
  public void fileUploadTest_1() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("http://www.uitestingplayground.com/upload");	
	  
	  System.out.println("Break Point 1");
	  
	  WebElement iFrame = driver.findElement(By.tagName("iframe"));
	  
	  System.out.println("Break Point 2");
	  driver.switchTo().frame(iFrame);
	  System.out.println("Break Point 3");
	  WebElement browseButton = driver.findElement(By.tagName("input"));
	  
	  System.out.println("Break Point 4");
	  
	 // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  //wait.until(ExpectedConditions.visibilityOf(browseButton));
	  
	  browseButton.sendKeys("C:\\Users\\raghu\\Desktop\\excel java.txt");
	  
	  System.out.println(driver.findElement(By.xpath("//div[@class='success-file']//p")).getText());
	 
	  
	  driver.quit();
  }
  
  @Test
  public void fileUploadTest_2() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/upload");
	  
	  driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\raghu\\Desktop\\excel java.txt");
	  
	  Thread.sleep(20000);
	  
	  driver.quit();
	  
  }
  
  @Test
  public void fileUploadTest_3() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("http://www.uitestingplayground.com/upload");	
	    
	  WebElement iFrame = driver.findElement(By.tagName("iframe"));
	  
	  driver.switchTo().frame(iFrame);
	  
	  
	 
	  WebElement browseButton = driver.findElement(By.tagName("input"));
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].removeAttribute('hidden')",browseButton);
	  
	  browseButton.click();
	  
	  
	  
	 // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  //wait.until(ExpectedConditions.visibilityOf(browseButton));
	  
	  //browseButton.sendKeys("C:\\Users\\raghu\\Desktop\\excel java.txt");
	  
	//  System.out.println(driver.findElement(By.xpath("//div[@class='success-file']//p")).getText());
	 
	  
	  driver.quit();
  }
  
  @Test
  public void enable_disable_element_test_1() {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/dynamic_controls");
	  
	  WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	  WebElement removeButton = driver.findElement(By.xpath("//button[normalize-space()='Remove']"));
	  
	  checkBox.click();
	  
	  removeButton.click();
	  
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  boolean isCheckBoxinVisible = wait.until(ExpectedConditions.invisibilityOf(checkBox));
	  
	  Assert.assertEquals(isCheckBoxinVisible,true);
	  
	  WebElement addButton = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
	  addButton.click();
	  
	  //checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	  WebElement newCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
	  newCheckBox.click();
	  
  }
  @Test
  public void infiniteScroll_1() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/infinite_scroll");
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  
	  long oldHeight = (long)js.executeScript("return document.body.scrollHeight");
	  
	  while(true) {
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  Thread.sleep(8000);
		  long newHeight = (long)js.executeScript("return document.body.scrollHeight");
		  
		  if(newHeight == oldHeight ) {
			  break;
		  }else {
			  oldHeight = newHeight;
		  }
	  }
	  
	  
	  
  }
  
  @Test
  public void geoLocationTest_1() {
	  
	  Map<String,Object> prefs = new HashMap<String,Object>();
	  Map<String,Object> contentSettings = new HashMap<String,Object>();
	  
	  contentSettings.put("geolocation",1);
	  prefs.put("profile.default_content_setting_values", contentSettings);
	  
	  WebDriverManager.chromedriver().setup();
	  
	  ChromeOptions options = new ChromeOptions();
	  options.setExperimentalOption("prefs", prefs);
	  WebDriver driver = new ChromeDriver(options);
	  
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/geolocation");
	  
	  driver.findElement(By.xpath("//button[normalize-space()='Where am I?']")).click();	  
	  
	  
  }

}
