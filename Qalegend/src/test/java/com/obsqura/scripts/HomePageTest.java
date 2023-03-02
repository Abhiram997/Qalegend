package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utlities.ExcelUtility;

public class HomePageTest extends TestHelper {
/*	@Test
	public void homePageQalegend() {
		
		
		
		ExcelUtility test = new ExcelUtility();
		test.setExcelFile("LoginData", "ValidDataa");
		test.getCellData(0, 0);
		System.out.println(test.getCellData(0, 0));
		HomePage home = new HomePage(driver);
		home.homePage();
	}*/
	
	@Test(groups={"regression","smoke"})
	public void checkHomePageLoaded()
	{
		LoginPage loginpge = new LoginPage(driver);
		loginpge.userLogin("admin", "123456");
		HomePage homepage=new HomePage(driver);
		homepage.isHomePageLoaded();
		
		Assert.assertTrue(homepage.isHomePageLoaded(), "Home page not loaded");
	}
}
