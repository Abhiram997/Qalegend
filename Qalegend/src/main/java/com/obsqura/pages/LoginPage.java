package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
	WebDriver driver;
	  @FindBy(xpath="//input[@id='username']")
	  WebElement username;
	  @FindBy(xpath="//input[@id='password']")
	  WebElement password;
	  @FindBy(xpath="//button[@type='submit' and @class='btn btn-primary']")
	  WebElement loginbutton;
	  @FindBy(xpath="//*[contains(text(),'Welcome vishwanadhan,')]")
	    WebElement actualTitle;
	  @FindBy(xpath = "//input[@name='remember']")
	  WebElement rememberme;
	  @FindBy(xpath="//button[@data-role='end']")
	  WebElement endtour;


		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this); //use current class driver
		}

		public void userLogin(String username1, String password1)		{
			
			username.sendKeys(username1);
			password.sendKeys(password1);
			rememberme.click();
			loginbutton.click();
			endtour.click();
			
		
			
		
		}
		public String getTitleMsg() {
			String titMsg = actualTitle.getText();
			System.out.println(titMsg);
			return titMsg;
		}


		
}

