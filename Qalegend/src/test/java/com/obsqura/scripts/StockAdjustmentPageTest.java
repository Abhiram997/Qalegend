package com.obsqura.scripts;

import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.StockAdjustmentPage;

public class StockAdjustmentPageTest extends TestHelper{
	
	LoginPage loginpage;
	StockAdjustmentPage stockadjustmentpage;

  @Test
  public void verifyAddStockAdujustment() {
	  loginpage = new LoginPage(driver);
	  stockadjustmentpage = new StockAdjustmentPage(driver);
	  
	  loginpage.userLogin("admin", "123456");
	  stockadjustmentpage.clickOnStockAdjustment();
	  stockadjustmentpage.clickOnAddStockAdjustment();

  }
}
