package com.obsqura.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.BrandsPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ProductPage;
import com.obsqura.utlities.ExcelUtility;
import com.obsqura.utlities.PageUtility;
import com.obsqura.utlities.WaitUtility;

public class BrandTestCases extends TestHelper {
	 LoginPage loginpage;
	 ProductPage productpage;
	 BrandsPage brandspage;
	 PageUtility pageutility;

	 @Test(priority = 18, groups = {"regression" })
	 public void brandPageTitleMatch() {
	 loginpage = new LoginPage(driver);
	 loginpage.userLogin("admin", "123456");
	 loginpage.endTour();
	 productpage = new ProductPage(driver);
	 productpage.clickOnProduct();
	 brandspage = new BrandsPage(driver);
	 brandspage.clickOnBrand();
	 String actualTitle=driver.getTitle();
	 String expectedTitle="Brands - las";

	 Assert.assertEquals(actualTitle, expectedTitle);
	 System.out.println("Title of page is as expected");
	 }

	 @Test(priority = 19, dataProvider = "BrandData")
	 public void AddBrand(String brandname, String branddesc) {

	 brandspage.clickOnAdd();
	 brandspage.addBrand(brandname, branddesc);


	 if (brandspage.successmessage.isDisplayed()) {
	 Assert.assertTrue(true);
	 } else {
	 Assert.assertTrue(false);
	 }

	 }

	 @Test(priority = 20, groups = {"regression" })
	 public void EditBrand()  {
	 pageutility = new PageUtility();
	 pageutility.refreshUtility(driver);
	 brandspage.searchBrand();
	 brandspage.search.sendKeys("Nike");
	 String branddescription="ABC";
	 brandspage.editBrand(branddescription);
	 
	boolean status=brandspage.getEditMessageDisplayStatus();
	Assert.assertTrue(status,"Edit message not fount");

	 }

	 @Test(priority = 21, groups = {"regression" })
	 public void DeleteBrand()  {

	 brandspage.deleteBrand();
	 if (brandspage.deletesuccess.isDisplayed()) {
	 Assert.assertTrue(true);
	 } else {
	 Assert.assertTrue(false);
	 }

	 }



	 @DataProvider(name = "BrandData")
	 public Object[][] getDataFromDataprovider() {

	 Object[][] data = { { "Nike", "123" } };
	 return data;
	 }
}

