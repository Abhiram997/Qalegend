package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
	WebDriver driver;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//span[@class='help-block']")
	public WebElement invalidCredentialMessage;
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary']")
	WebElement loginbutton;
	@FindBy(xpath = "//section[contains(@class,'content-header')]/h1")
	WebElement welcomenote;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement rememberme;
	@FindBy(xpath = "//*[contains(text(),'Welcome vishwanadhan,')]")
	WebElement actualTitle;
	@FindBy(xpath = "//span[text()='vishwanadhan Aanadh']")
	WebElement profile;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/logout']")
	WebElement signout;

	@FindBy(xpath = "//button[@data-role='end']")
	WebElement endtour;

	public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public void userLogin(String usname, String pswd) {

	username.sendKeys(usname);
	password.sendKeys(pswd);
	rememberme.click();
	loginbutton.click();

	}

	public String getTitleMsg() {
	endtour.click();
	String titMsg = actualTitle.getText();
	System.out.println(titMsg);
	return titMsg;
	}

	public void endTour() {
	endtour.click();
	}

	public void signOut() {
	profile.click();
	signout.click();

	}

}