package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ProductPage;
import com.obsqura.utlities.ExcelUtility;
import com.obsqura.utlities.PageUtility;
import com.obsqura.utlities.WaitUtility;

public class ProductPageTest extends TestHelper {
	LoginPage loginpage;
	ProductPage productpage;
	ExcelUtility excelutility = new ExcelUtility();
	WaitUtility wait;
	PageUtility pageutility;

	@Test(priority=15)
	  public void addproduct()  {
		loginpage = new LoginPage(driver);
		loginpage.userLogin("admin", "123456");
		loginpage.endTour();
	    productpage = new ProductPage(driver);
		excelutility.selectExcelFile("Product", "addProduct");
		productpage.clickOnProduct();
		productpage.clickOnAddProduct();
		String productname = excelutility.getCellData(0, 0);
		String unit = excelutility.getCellData(0, 1);
		String barcode = excelutility.getCellData(0, 2);
		String alertquantity = excelutility.getCellData(0, 3);
		String exctax = excelutility.getCellData(0, 4);
		String inctax = excelutility.getCellData(0, 5);
		productpage.addProduct(productname, unit, barcode, alertquantity,exctax, inctax);
		if (productpage.pro_save_msg.isDisplayed()) {
			Assert.assertTrue(true, "Save message Displayed");
		} else {
			Assert.assertTrue(false, "Save message not displayed");
		}

		
		
		}

	
}