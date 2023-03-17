package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.ContactsPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utlities.ExcelUtility;
import com.obsqura.utlities.PageUtility;

public class ContactsPageTest extends TestHelper {
	LoginPage loginpge;
	ContactsPage contactspage;
	ExcelUtility excelutility = new ExcelUtility();
	PageUtility pageutility;
	

	@Test(priority = 22, dataProvider = "SupplierDataWithoutMandatoryField")
	public void isSupplierAddedWithoutFillingOneMandatoryField(String name, String businessname, String mobilenumber) {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.userLogin("admin", "123456");
	loginpage.endTour();
	contactspage = new ContactsPage(driver);
	contactspage.clickOnContacts();
	contactspage.clickOnsuppliers();
	contactspage.addSupplierWithoutFillingOneMandatoryField(name, businessname, mobilenumber);
	if (contactspage.validationforMandatoryField.isDisplayed()) {
	Assert.assertTrue(true);
	System.out.println("Supplier cannot be added without filling mandatory field");
	} else {
	Assert.assertTrue(false);
	System.out.println("Supplier can be added without filling mandatory field");
	}
	}

	@Test(priority = 23,dataProvider = "SupplierDataWithOnlyMandatoryField")
	public void isSupplierAddedByFillingOnlyMandatoryField(String name, String businessname, String mobilenumber) {
	pageutility = new PageUtility();
	pageutility.refreshUtility(driver);
	contactspage.clickOnsuppliers();

	contactspage.addSupplierWithoutFillingOneMandatoryField(name, businessname, mobilenumber);

	if (contactspage.successmessge.isDisplayed()) {
	Assert.assertTrue(true);
	System.out.println("Supplier can be added by only filling mandatory field");
	} else {
	Assert.assertTrue(false);
	System.out.println("Supplier cannot be added by only filling mandatory field");
	}
	}

	@DataProvider(name = "SupplierDataWithoutMandatoryField")
	public Object[][] getDataFromDataprovider() {

	Object[][] data = { { "Abhiram", "ABCD", "" } };
	return data;
	}

	@DataProvider(name = "SupplierDataWithOnlyMandatoryField")
	public Object[][] getDataFromDatasprovider() {

	Object[][] data = { { "Abhiram", "ABCD", "12345678910" } };
	return data;
	}

	// importcontacts



	@Test(priority = 24, groups = {"regression" })
	public void importContacts()
	{
	contactspage.clickOnImportContacts();
	String path="C:\\Users\\ABHIRAM\\git\\Qalegend\\Qalegend\\src\\main\\resources\\ExcelFiles\\UserManagment.xlsx";
	contactspage.importContact(path);

	if (contactspage.fileimportsuccessmessge.isDisplayed()) {
	Assert.assertTrue(true);
	System.out.println("File imported successfully");
	} else {
	Assert.assertTrue(false);
	System.out.println("File not imported successfully");
	}
	}
}