package com.obsqura.scripts;

import org.testng.annotations.Test;


import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utlities.ExcelUtility;

import org.testng.Assert;


public class LoginPageTest extends TestHelper
{
 

	   @Test(groups="smoke")
		public void validQaLegendLogin() {
			LoginPage loginpge = new LoginPage(driver);
			loginpge.userLogin("admin", "123456");
			ExcelUtility test = new ExcelUtility();
			test.selectExcelFile("LoginData", "ValidDataa");
			test.getCellData(0, 0);
			
			System.out.println(test.getCellData(0, 0));
			
		
	  }
}

	  
	/*  @Test
	  public void invalidLogin()
	  {
		  LoginPage loggedin=new LoginPage(driver);
			loggedin.userLogin("admi","1456");
	  
		//HomePage homePage=new HomePage(driver);
		// Assert.assertTrue(homePage.isHomePageLoaded());
	    
	  
	  
*/
	  
