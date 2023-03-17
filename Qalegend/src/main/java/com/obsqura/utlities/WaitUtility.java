package com.obsqura.utlities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtility
{
  WebDriver driver;
  
  public  WaitUtility(WebDriver driver)
  {
	  this.driver=driver;
  }
  public void waitForVisibility(String xpath)
  {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	  
  }
  public void waitForVisibility(WebElement element)
  {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOf(element));
	  
  }
	/////////////////////////// Implicit wait///////////////////////////////
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/////////////////////// Explicit wait for element to be
	/////////////////////// visible///////////////////////
	public void waitForElementTobeVisible(WebDriver driver, WebElement element, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/////////////////// Explicit wait for element 
	public void fluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(5000))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.visibilityOf(element));

	}
	/////////////////// clickable///////////////////////////
	public void waitForElemntTobeClickable(WebDriver driver, WebElement element, long i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	///////////////////// Wait//////////////////////
	public void waitS(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	////////////////////////////// Fluent Wait//////////////////////////////////
	public void fluentWait(WebDriver driver, WebElement element, String attribute, String attributeValue) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(4000))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.attributeToBe(element, attribute, attributeValue));
	}

	
}

  

