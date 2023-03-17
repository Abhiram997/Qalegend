package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BrandsPage {
	
	WebDriver driver;

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/brands']")
	WebElement brand;

	@FindBy(xpath = "//*[@class='content-header']//h1[text()='Brands        ']")
	public WebElement brandsTitle;

	@FindBy(xpath = "//*[@id='brands_table_filter']//label//input")
	public WebElement search;

	@FindBy(id = "name")
	public WebElement brandnameelement;

	@FindBy(id = "description")
	public WebElement description;

	@FindBy(xpath = "//*[@class='btn btn-primary' and text()='Save']")
	public WebElement save;

	@FindBy(xpath = "//*[@id='brand_add_form']/div[3]/button[2]")
	public WebElement close;

	@FindBy(xpath = "//*[@class='btn btn-block btn-primary btn-modal']")
	public WebElement add;
	@FindBy(xpath="//*[@class='toast-message']")
	public WebElement successmessage;

	@FindBy(xpath = "//*[@id='brands_table']/tbody/tr[1]/td[3]/button[2]/i")
	public WebElement delete;

	@FindBy(xpath = "//*[@id='brands_table']/tbody/tr[1]/td[3]/button[1]/i")
	public WebElement edit;
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement editsuccess;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement update;

	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger' and text()='OK']")
	public WebElement deleteOk;
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement deletesuccess;

	@FindBy(xpath = "//*[@class='swal-button swal-button--cancel' and text()='Cancel']")
	public WebElement deleteCancel;

	@FindBy(xpath = "//*[@class='dataTables_empty' and text()='No matching records found']")
	public WebElement noResult;

	public BrandsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}
	public boolean getEditMessageDisplayStatus()
	{
		return editsuccess.isDisplayed();
	}
	public void clickOnBrand()
	{
	brand.click();
	}
	public void clickOnAdd()
	{
	add.click();
	}
	public void searchBrand()
	{
	search.click();
	}

	public void addBrand(String brandname, String branddesc) {
	brandnameelement.sendKeys(brandname);
	description.sendKeys(branddesc);
	save.click();

	}
	public void editBrand(String branddescription)
	{
	edit.click();
	description.clear();
	description.sendKeys(branddescription);
	update.click();

	}
	public void deleteBrand()
	{
	delete.click();
	deleteOk.click();

	}
}
