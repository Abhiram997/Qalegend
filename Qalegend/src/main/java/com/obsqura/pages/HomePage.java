package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	
	@FindBy(xpath = "//section[contains(@class,'content-header')]/h1")
	public WebElement welcomenote;
	

 public HomePage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
  public void homePage()
  {
	 String name=welcomenote.getText();
	 System.out.println(name);
  }
 
	
public boolean isHomePageLoaded()
{
	return welcomenote.isDisplayed();
}

}

