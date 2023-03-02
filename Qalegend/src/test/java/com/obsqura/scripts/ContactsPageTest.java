package com.obsqura.scripts;

import org.testng.annotations.Test;

import com.obsqura.pages.ContactsPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utlities.ExcelUtility;

public class ContactsPageTest extends TestHelper {
	LoginPage loginpge;
	ContactsPage contactspage;
	ExcelUtility excelutility = new ExcelUtility();

	@Test
	public void verifyNewSupplierCreation() {
		loginpge = new LoginPage(driver);
		loginpge.userLogin("admin", "123456");
		contactspage = new ContactsPage(driver);
		excelutility.selectExcelFile("ContactsSuppliers", "Contactdata");
		contactspage.clickContactsPage();
		contactspage.clickOnsuppliers();
		contactspage.clickOnAdd();
		contactspage.selectContactType();
		String name = excelutility.getCellData(0, 0);
		String businessname =excelutility.getCellData(0, 1);
		String contactid =excelutility.getCellData(0, 2);
		String taxnumber =excelutility.getCellData(0, 3);
		String openingbalance =excelutility.getCellData(0, 4);
		String payterm =excelutility.getCellData(0, 5);
		contactspage.selectPayterm();
		contactspage.selectCustomerGroup();
	    String creditlimit =excelutility.getCellData(0, 6);
		String email =excelutility.getCellData(0, 7);
		String mobile =excelutility.getCellData(0, 8);
		String alternatecontactnumber =excelutility.getCellData(0, 9);
		String landline =excelutility.getCellData(0, 10);
		String city =excelutility.getCellData(0, 11);
		String state =excelutility.getCellData(0, 12);
		String country =excelutility.getCellData(0, 13);
		String landmark =excelutility.getCellData(0, 14);
		String customfield1 =excelutility.getCellData(0, 15);
		String customfield2 =excelutility.getCellData(0, 16);
		String customfield3 =excelutility.getCellData(0, 17);
		String customfield4 =excelutility.getCellData(0, 18);
		contactspage.createContact(name, businessname, contactid, taxnumber, openingbalance, payterm, creditlimit, email, mobile, alternatecontactnumber, landline, city, state, country, landmark, customfield1, customfield2, customfield3, customfield4);
				
		
	}
}
