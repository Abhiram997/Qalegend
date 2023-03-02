package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockAdjustmentPage
{
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Stock Adjustment']")
	WebElement stocladjustmentelement;
	
	//Add Stock
	@FindBy(xpath ="//a[@href='https://qalegend.com/billing/public/stock-adjustments/create']")
	WebElement addstockadjustmentelement;
	
	@FindBy(xpath = "//input[@id='transaction_date']")
	WebElement dateelement;
	@FindBy(xpath = "//input[@id='transaction_date']")
	WebElement monthtextelement;
	
	public StockAdjustmentPage(WebDriver driver)  
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnStockAdjustment()
	{
		stocladjustmentelement.click();
	}
	
	public void clickOnAddStockAdjustment()
	{
		addstockadjustmentelement.click();
	}

}
