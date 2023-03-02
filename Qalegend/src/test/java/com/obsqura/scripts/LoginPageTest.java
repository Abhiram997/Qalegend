package com.obsqura.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.utlities.ExcelUtility;

public class LoginPageTest extends TestHelper {
	LoginPage loginpge;
	ExcelUtility test;

	@Test(priority=1,enabled=true,groups= {"Smoke"})
 public void invalidUserNameLogin()
 {
		loginpge = new LoginPage(driver);
		loginpge.userLogin("admi", "123456");
		
		
		
 }

	@Test(priority=2,enabled=true,groups= {"Smoke"})
		public void validLogin() {
		    
			loginpge.userLogin("admin", "123456");
		    test = new ExcelUtility();
			test.selectExcelFile("LoginData", "ValidDataa");
			test.getCellData(0, 0);
			
			System.out.println(test.getCellData(0, 0));
			
		
	  }

}

/*
 * @Test public void invalidLogin() { LoginPage loggedin=new LoginPage(driver);
 * loggedin.userLogin("admi","1456");
 * 
 * //HomePage homePage=new HomePage(driver); //
 * Assert.assertTrue(homePage.isHomePageLoaded());
 * 
 * 
 * 
 */
