package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UserManagmentPage;
import com.obsqura.utlities.ExcelUtility;
import com.obsqura.utlities.GenericUtility;
import com.obsqura.utlities.PageUtility;
import com.obsqura.utlities.WaitUtility;

public class UserManagmentPageTest extends TestHelper {
	LoginPage loginpge;
	UserManagmentPage usermanagmentpage;
	ExcelUtility excelutility = new ExcelUtility();
	WaitUtility wait;
	PageUtility pageutility;
	
	
	

	@Test(priority = 8)
	public void invalidUserEmail() {
		loginpge= new LoginPage(driver);
		loginpge.userLogin("admin", "123456");
		loginpge.endTour();
		
		usermanagmentpage= new UserManagmentPage(driver);
		usermanagmentpage.clickOnUserManagmentPage();
		usermanagmentpage.clickOnUser();
		usermanagmentpage.clickOnAdd();
		
		excelutility.selectExcelFile("UserManagment", "userData");
		String role = "Engineer";
		String prefix = excelutility.getCellData(0, 0);
		String firstName = excelutility.getCellData(0, 1);
		String lastName = excelutility.getCellData(0, 2);
		String email = excelutility.getCellData(0, 3);
		email = email + GenericUtility.getRandomNumber();
		String userName = excelutility.getCellData(0, 4);
		userName = userName + GenericUtility.getRandomNumber();
		String password = excelutility.getCellData(0, 5);
		String confirmPassword = excelutility.getCellData(0, 6);
		String salesCommissionPercentag = excelutility.getCellData(0, 7);
		usermanagmentpage.allowselectContact();
		String selectcontacts = "Abhi";
		usermanagmentpage.createUser(prefix, firstName, lastName, email, userName, password, confirmPassword,
				salesCommissionPercentag, role, selectcontacts);

	if (usermanagmentpage.invalidemail.isDisplayed()) {
		Assert.assertTrue(true);
		System.out.println("Password error message displayed");

	} else {
		Assert.assertTrue(false, "Error message Not displayed");
	}

	}
	@Test(priority = 9)
	public void invalidpassword_user() {
		pageutility = new PageUtility();
		pageutility.refreshUtility(driver);
		usermanagmentpage = new UserManagmentPage(driver);
	
		excelutility.selectExcelFile("UserManagmetInvalidConfirmPassword", "invalidData1");
		String role = "Engineer";
		String prefix = excelutility.getCellData(0, 0);
		String firstName = excelutility.getCellData(0, 1);
		String lastName = excelutility.getCellData(0, 2);
		String email = excelutility.getCellData(0, 3);
		email = email + GenericUtility.getRandomNumber() + "@yahoo.com";
		String userName = excelutility.getCellData(0, 4);
		userName = userName + GenericUtility.getRandomNumber();
		String password = excelutility.getCellData(0, 5);
		String confirmPassword = excelutility.getCellData(0, 6);
		String salesCommissionPercentag = excelutility.getCellData(0, 7);
		usermanagmentpage.allowselectContact();
		String selectcontacts = "Abhi";
		usermanagmentpage.createUser(prefix, firstName, lastName, email, userName, password, confirmPassword,
				salesCommissionPercentag, role, selectcontacts);
		if (usermanagmentpage.invalidpass.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Password error message displayed");

		} else {
			Assert.assertTrue(false, "Error message Not displayed");
		}
	}

	
	@Test(priority = 10)
	public void invalidConfirmpassword_user() {
		pageutility = new PageUtility();
		pageutility.refreshUtility(driver);
		usermanagmentpage = new UserManagmentPage(driver);
		excelutility.selectExcelFile("UserManagmetInvalidConfirmPassword", "invalidPass");
		String role = "Engineer";
		String prefix = excelutility.getCellData(0, 0);
		String firstName = excelutility.getCellData(0, 1);
		String lastName = excelutility.getCellData(0, 2);
		String email = excelutility.getCellData(0, 3);
		email = email + GenericUtility.getRandomNumber() + "@yahoo.com";
		String userName = excelutility.getCellData(0, 4);
		userName = userName + GenericUtility.getRandomNumber();
		String password = excelutility.getCellData(0, 5);
		String confirmPassword = excelutility.getCellData(0, 6);
		String salesCommissionPercentag = excelutility.getCellData(0, 7);
		usermanagmentpage.allowselectContact();
		String selectcontacts = "Abhi";
		usermanagmentpage.createUser(prefix, firstName, lastName, email, userName, password, confirmPassword,
				salesCommissionPercentag, role, selectcontacts);
		if (usermanagmentpage.passerror.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Password error message displayed");

		} else {
			Assert.assertTrue(false, "Error message Not displayed");
		}
	}

	@Test(priority = 11)
	public void addNewUserInUserManagment() {
		pageutility = new PageUtility();
		pageutility.refreshUtility(driver);
		usermanagmentpage = new UserManagmentPage(driver);
		excelutility.selectExcelFile("UserManagment", "userData");
		String role = "Engineer";
		String prefix = excelutility.getCellData(0, 0);
		String firstName = excelutility.getCellData(0, 1);
		String lastName = excelutility.getCellData(0, 2);
		String email = excelutility.getCellData(0, 3);
		email = email + GenericUtility.getRandomNumber() + "@yahoo.com";
		String userName = excelutility.getCellData(0, 4);
		userName = userName + GenericUtility.getRandomNumber();
		String password = excelutility.getCellData(0, 5);
		String confirmPassword = excelutility.getCellData(0, 6);
		String salesCommissionPercentag = excelutility.getCellData(0, 7);
		usermanagmentpage.allowselectContact();
		String selectcontacts = "Abhi";
		usermanagmentpage.createUser(prefix, firstName, lastName, email, userName, password, confirmPassword,
				salesCommissionPercentag, role, selectcontacts);
		if (usermanagmentpage.successmessage.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Message displayed");

		} else {
			Assert.assertTrue(false, "Message Not displayed");
		}

	}

	//
	@Test(priority = 12)
	public void searchByUsernameAndExportDataToCsv() {
		pageutility = new PageUtility();
		pageutility.refreshUtility(driver);
		usermanagmentpage.userSearch();
		usermanagmentpage.usersearch.sendKeys("pooja");
		usermanagmentpage.clickOnActionAndExportToCsv();

	}

	@Test(priority = 13)
	public void user_viewuser() {

		pageutility = new PageUtility();
		pageutility.refreshUtility(driver);
		
		usermanagmentpage.userSearch();
		usermanagmentpage.usersearch.sendKeys("Pooja");
		usermanagmentpage.viewUserClick();
		String actualtitle = driver.getTitle();
		String expectedtitle = "View User - las";
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Title matches");
	}

	@Test(priority = 14)
	public void user_deleteuser() {
		
		pageutility.navigateBackUtility(driver);
		pageutility.refreshUtility(driver);
		usermanagmentpage.userSearch();
		usermanagmentpage.usersearch.sendKeys("AbhiKrishna");
		usermanagmentpage.deleteUserClick();
		if (usermanagmentpage.delmsg.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Deleted successfully,message displayed");

		} else {
			Assert.assertTrue(false, "not displayed");
		}
	}
}
