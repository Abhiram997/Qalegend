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
	WaitUtility waitutility;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactselement;
	//suppliers
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/contacts?type=supplier']")
	WebElement supplierselement;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement supplieraddelement;
	@FindBy(xpath="//select[@id='contact_type']")
	WebElement contacttypeelement;
	@FindBy(xpath="//input[@id='name']")
	WebElement nameelement;
	@FindBy(xpath="//input[@id='supplier_business_name']")
	WebElement businessnameelement;
	@FindBy(xpath="//input[@id='contact_id']")
	WebElement contactidelement;
	@FindBy(xpath="//input[@id='tax_number']")
	WebElement taxnumberelement;
	@FindBy(xpath="//input[@id='opening_balance']")
	WebElement openingbalanceelement;
	@FindBy(xpath="//input[@id='pay_term_number']")
	WebElement paytermnumberelement;
	@FindBy(xpath="//select[@class='form-control width-60 pull-left']")
	WebElement paytermselectelement;
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement customergroupelement;
	@FindBy(xpath="//input[@id='credit_limit']")
	WebElement creditlimitelement;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailelement;
	@FindBy(xpath="//input[@id='mobile']")
	WebElement mobileelement;
	@FindBy(xpath="//input[@id='alternate_number']")
	WebElement alternatenumberelement;
	@FindBy(xpath="//input[@id='landline']")
	WebElement landlinenumberelement;
	@FindBy(xpath="//input[@id='city']")
	WebElement cityelement;
	@FindBy(xpath="//input[@id='state']")
	WebElement stateelement;
	@FindBy(xpath="//input[@id='country']")
	WebElement countryelement;
	@FindBy(xpath="//input[@id='landmark']")
	WebElement landmarkelement;
	@FindBy(xpath="//input[@id='custom_field1']")
	WebElement customfield1element;
	@FindBy(xpath="//input[@id='custom_field2']")
	WebElement customfield2element;
	@FindBy(xpath="//input[@id='custom_field3']")
	WebElement customfield3element;
	@FindBy(xpath="//input[@id='custom_field4']")
	WebElement customfield4element;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveelement;
	

	public ContactsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 public void clickContactsPage() 
	 {
		 contactselement.click();
	 }
	//suppliers
		public void clickOnsuppliers() {
			supplierselement.click();

		}

		public void clickOnAdd() {
			supplieraddelement.click();
		}
		 
		public void selectContactType()
		{
			//contacttypeelement.click();
			Select s=new Select(contacttypeelement);
			s.selectByValue("both");
		}
		public void selectPayterm()
		{
			//paytermselectelement.click();
			Select s=new Select(paytermselectelement);
			s.selectByValue("months");
		}
		public void selectCustomerGroup()
		{
			//customergroupelement.click();
			Select s=new Select(customergroupelement);
			s.selectByVisibleText("GOLD");
		}

		
		public void createContact(String name,String businessname,String contactid,String taxnumber,String openingbalance,String payterm,String creditlimit,String email,String mobile,String alternatecontactnumber,String landline,String city,String state,String country,String landmark,String customfield1,String customfield2,String customfield3,String customfield4) 

		{
			waitutility=new WaitUtility(driver);
			nameelement.sendKeys(name);
			businessnameelement.sendKeys(businessname);
			contactidelement.sendKeys(contactid);
			taxnumberelement.sendKeys(taxnumber);
			openingbalanceelement.sendKeys(openingbalance);
			paytermnumberelement.sendKeys(payterm);
			creditlimitelement.sendKeys(creditlimit);
			emailelement.sendKeys(email);
			mobileelement.sendKeys(mobile);
			alternatenumberelement.sendKeys(alternatecontactnumber);
			landlinenumberelement.sendKeys(landline);
			cityelement.sendKeys(city);
			stateelement.sendKeys(state);
			countryelement.sendKeys(country);
			landmarkelement.sendKeys(landmark);
			customfield1element.sendKeys(customfield1);
			customfield2element.sendKeys(customfield2);
			customfield3element.sendKeys(customfield3);
			customfield4element.sendKeys(customfield4);
			saveelement.click();
			
			
			
			
			
		}
	
	
	
	
	
	
}



