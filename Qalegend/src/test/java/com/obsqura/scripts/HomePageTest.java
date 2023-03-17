package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utlities.ExcelUtility;

public class HomePageTest extends TestHelper {
	LoginPage loginpge;
	HomePage homepage = new HomePage(driver);

	

	@Test(priority = 5, groups = { "regression", "smoke" })
	public void checkHomePageLoaded() {
		loginpge = new LoginPage(driver);
		loginpge.userLogin("admin", "123456");
		loginpge.endTour();
		homepage = new HomePage(driver);
		homepage.isHomePageLoaded();

		Assert.assertTrue(homepage.isHomePageLoaded(), "Home page not loaded");
	}

	@Test(priority = 6)
	public void profileTitleTest() {
	    String expectedtitle = "Home - las";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("After hard assertion " + " Title is same");
	}

	@Test(priority = 7)
	public void welcomeNoteTest() {
		homepage = new HomePage(driver);
		boolean status = homepage.welcomenote.isDisplayed();
		if (status) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}

	}
}
