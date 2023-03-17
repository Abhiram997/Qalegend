package com.obsqura.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.utlities.ExcelUtility;
import com.obsqura.utlities.PageUtility;
import com.obsqura.utlities.WaitUtility;

public class LoginPageTest extends TestHelper {
	LoginPage loginpage;
	ExcelUtility test;
	WaitUtility wait;
	PageUtility pageutility;

	@Test(priority = 1, enabled = true, groups = { "Smoke" })
	public void invalidUsernameLogin() {

	loginpage = new LoginPage(driver);

	loginpage.userLogin("admins", "123456");
	String actualmessage = loginpage.invalidCredentialMessage.getText();
	String expectedmessage = "These credentials do not match our records.";
	Assert.assertEquals(actualmessage, expectedmessage);

	}

	@Test(priority = 2, enabled = true, groups = { "Smoke" })
	public void invalidPasswordLogin() {

	pageutility = new PageUtility();
	pageutility.refreshUtility(driver);
	loginpage.userLogin("admin", "123456789");
	String actualmessage = loginpage.invalidCredentialMessage.getText();
	String expectedmessage = "These credentials do not match our records.";
	Assert.assertEquals(actualmessage, expectedmessage);

	}

	@Test(priority = 3, enabled = true, groups = { "Smoke" })
	public void invalidUsernamePasswordLogin() {

	pageutility = new PageUtility();
	pageutility.refreshUtility(driver);
	loginpage.userLogin("admins", "123456789");
	String actualmessage = loginpage.invalidCredentialMessage.getText();
	String expectedmessage = "These credentials do not match our records.";
	Assert.assertEquals(actualmessage, expectedmessage);

	}

	@Test(priority = 4, enabled = true, groups = { "Smoke" })

	public void validLogin() {

	pageutility = new PageUtility();
	pageutility.refreshUtility(driver);

	loginpage.userLogin("admin", "123456");
	loginpage.endTour();

	}
	@Test(priority = 25, enabled = true, groups = { "Smoke" })

	public void checkSignOut() {


	loginpage.signOut();
	String actual=driver.getTitle();
	String expected="Login - Demo POS";
	Assert.assertEquals(actual, expected);
	System.out.println("Logout successfull");




	}
}

