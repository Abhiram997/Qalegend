package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentAccountsPage
{
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Payment Accounts']")
	WebElement paymentaccountelement;
	
	//List Accounts
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/account/account']")
	WebElement listaccountselement;
	@FindBy(xpath = "//button[@data-href='https://qalegend.com/billing/public/account/account/create']")
	WebElement listaddbutton;
	@FindBy(id = "name")
	WebElement nameelement;
	@FindBy(id = "account_number")
	WebElement accountnumberelement;
	@FindBy(id = "opening_balance")
	WebElement openingbalanceelement;
	@FindBy(id = "note")
	WebElement noteelement;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveelement;
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement successmessage;

	
	 public PaymentAccountsPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void clickOnPaymentAccounts()
	 {
		 paymentaccountelement.click();
		
		 
	 }
	 //List Account
	 
	 public void clickOnListAccounts()
	 {
		 listaccountselement.click();
		
	 }
	 public void clickOnListAdd()
	 {
		 listaddbutton.click();
	 }
	
	public void paymentAccountsAdd(String name,String accountnumber,String openingbalance ,String note )
	{
		nameelement.sendKeys(name);
		accountnumberelement.sendKeys(accountnumber);
		openingbalanceelement.sendKeys(openingbalance);
		noteelement.sendKeys(note);
		saveelement.click();
		
		
		
	}
	public String getAccountCreationMessage()
	 {
		 return successmessage.getText();
		 
	 }

}
