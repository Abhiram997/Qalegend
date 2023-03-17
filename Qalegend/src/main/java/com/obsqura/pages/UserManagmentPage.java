package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utlities.GenericUtility;
import com.obsqura.utlities.WaitUtility;

public class UserManagmentPage {

	WebDriver driver;
	WaitUtility waitutility;
	GenericUtility genericutility;

	@FindBy(xpath = "//span[text()='User Management']")
	WebElement usermanagment;

	// Users

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']")
	WebElement users;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement useraddbutton;
	@FindBy(id = "surname")
	WebElement prefixelement;
	@FindBy(id = "first_name")
	WebElement firstnameelement;
	@FindBy(id = "last_name")
	WebElement lastnameelement;
	@FindBy(id = "email")
	WebElement emailelement;
    @FindBy(id = "select2-role-container")
	WebElement clickrole;
	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
	WebElement roleelement;
	@FindBy(id = "username")
	WebElement usernameelement;
	@FindBy(id = "password")
	WebElement passwordelement;
	@FindBy(id = "confirm_password")
	WebElement confirmpasswordelement;
	@FindBy(id = "cmmsn_percent")
	WebElement salescommissionpercentageelement;
	@FindBy(xpath = "//div[@class='icheckbox_square-blue']//ins[@class='iCheck-helper']")
	WebElement allowselectcontactelement;
	@FindBy(xpath="//ul[@class='select2-selection__rendered']")
	WebElement selectcontactsclickelement;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement selectcontactselement;
	@FindBy(id = "submit_user_button")
	WebElement saveelement;
	@FindBy(xpath = "//*[@class='toast-message']")
	public WebElement successmessage;
	@FindBy(xpath = "//input[@type='search']")
	public WebElement usersearch;
	@FindBy(xpath ="//span//i[@class='fa fa-list']")
	WebElement actionelement;
	@FindBy(xpath="//a[text()=' Export to CSV']")
	WebElement exporttocsv;
	@FindBy(xpath = "//*[@id=\"users_table\"]/tbody/tr/td[5]/a[2]")
	public WebElement viewuser;
	@FindBy(xpath = "//*[@id=\"users_table\"]/tbody/tr/td[5]/button")
	public WebElement deleteuser;
	@FindBy(xpath = "//*[@class=\"swal-button swal-button--confirm swal-button--danger\"]")
	public WebElement okbutton_del;
	@FindBy(xpath = "//*[@class='toast-message']")
	public WebElement delmsg;
	@FindBy(id = "confirm_password-error")
	public WebElement passerror;
	@FindBy(id = "password-error")
	public WebElement invalidpass;
	@FindBy(id = "email-error")
	public WebElement invalidemail;

	

	// Roles

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/roles']")
	WebElement roleselement;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/roles/create']")
	WebElement addrolesbuttonelement;
	@FindBy(id = "name")
	WebElement rolenameelement;

	// SalesCommissionAgents

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/sales-commission-agents']")
	WebElement salescommissionagentsbutton;
	@FindBy(xpath = "//button[@data-href='https://qalegend.com/billing/public/sales-commission-agents/create']")
	WebElement salescommissionagentsaddbutton;

	public UserManagmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnUserManagmentPage() {
		usermanagment.click();

	}

	// User
	public void clickOnUser() {
		users.click();
		

	}

	public void clickOnAdd() {
		useraddbutton.click();
	}

	public void selectRole(String role) {
		clickrole.click();
		roleelement.sendKeys(role + Keys.ENTER);
		// driver.findElement(By.xpath("//li[text()='tailor']")).click();
	}
	public void allowselectContact()
	{
		allowselectcontactelement.click();
	}
	public void selectContactsElement(String selectcontacts)
	{
		selectcontactsclickelement.click();
		selectcontactselement.sendKeys(selectcontacts+Keys.ENTER);
	}
	public void userSearch()
	{
		usersearch.click();
	
	}
	public void clickOnActionAndExportToCsv()
	{
		actionelement.click();
		exporttocsv.click();
	}
	public void viewUserClick()
	{
		viewuser.click();
	}
	public void deleteUserClick()
	{
		deleteuser.click();
		okbutton_del.click();
		
	}

	

	public void createUser(String prefix, String firstName, String lastName, String email, String userName,
			String password, String confirmPassword, String salesCommissionPercentag, String role,String selectcontacts) 
	{
		waitutility=new WaitUtility(driver);
		
		prefixelement.sendKeys(prefix);
		firstnameelement.sendKeys(firstName);
		lastnameelement.sendKeys(lastName);
		emailelement.sendKeys(email);
		selectRole(role);
		usernameelement.sendKeys(userName);
		passwordelement.sendKeys(password);
		confirmpasswordelement.sendKeys(confirmPassword);
		salescommissionpercentageelement.sendKeys(salesCommissionPercentag);
		selectContactsElement(selectcontacts);
		saveelement.click();

	}

	public String getUserCreationMessage() {
		return successmessage.getAttribute("data-msg");

	}
	public boolean isAlertMessageDisplayed(String expectedMessage)
	{
		genericutility=new GenericUtility();
		return genericutility.is_TextAsExpected(successmessage,expectedMessage);
	}

	// Role

	public void clickOnRole() {
		roleselement.click();

	}

	public void clickOnRolesAddButton() {
		addrolesbuttonelement.click();

	}

}
