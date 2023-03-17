package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utlities.WaitUtility;

public class ContactsPage
{
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactselement;
	//suppliers
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/contacts?type=supplier']")
	WebElement supplierselement;
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement supplieraddelement;

	@FindBy(xpath = "//input[@id='name']")
	WebElement nameelement;
	@FindBy(xpath = "//input[@id='supplier_business_name']")
	WebElement businessnameelement;

	@FindBy(id = "mobile")
	WebElement mobilenumbereelement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement validationforMandatoryField;
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement successmessge;
	//importcontacts
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/contacts/import']")
	WebElement importcontacts;
	@FindBy(xpath="//input[@name='contacts_csv']")
	WebElement choosefile;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitfile;
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement fileimportsuccessmessge;
	@FindBy(xpath="//input[@name='_token']")
	public WebElement hidden;

	public ContactsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public void clickOnContacts() {
	contactselement.click();

	}

	public void clickOnsuppliers() {
	supplierselement.click();
	supplieraddelement.click();

	}

	public void addSupplierWithoutFillingOneMandatoryField(String name, String businessname,String mobilenumber) {
	nameelement.sendKeys(name);
	businessnameelement.sendKeys(businessname);
	mobilenumbereelement.sendKeys(mobilenumber);
	savebutton.click();

	}
	//importcontacts
	public void clickOnImportContacts() {
	importcontacts.click();
	}
	public void importContact(String path)
	{
	choosefile.sendKeys(path);
	submitfile.click();
	}
}
