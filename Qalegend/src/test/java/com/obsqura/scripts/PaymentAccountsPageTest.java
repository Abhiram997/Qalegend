package com.obsqura.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.PaymentAccountsPage;
import com.obsqura.utlities.ExcelUtility;

public class PaymentAccountsPageTest extends TestHelper{
	LoginPage loginpage;
	 PaymentAccountsPage paymentaccountspage;
	 ExcelUtility excelutility = new ExcelUtility();
	 
	 
	 @Test(priority=16, groups = {"regression" })
	 public void verifyTitle() {

	 loginpage = new LoginPage(driver);
	 loginpage.userLogin("admin", "123456");
	 loginpage.endTour();
	 paymentaccountspage = new PaymentAccountsPage(driver);
	 paymentaccountspage.clickOnPaymentAccounts();
	 paymentaccountspage.clickOnListAccounts();
	 String actualTitle=driver.getTitle();
	 String expectedTitle="Payment Accounts - las";
	 Assert.assertEquals(actualTitle, expectedTitle);
	 System.out.println("Title matches");

	 }


	 @Test(priority=17)
	 public void verifyNewAccountCreation() {

	 excelutility.selectExcelFile("PaymentAccount", "listAccounts");
	 paymentaccountspage.clickOnListAccounts();
	 paymentaccountspage.clickOnAdd();
	 String name = excelutility.getCellData(0, 0);
	 String accountnumber = excelutility.getCellData(0, 1);
	 String openingbalance = excelutility.getCellData(0, 2);
	 String note = excelutility.getCellData(0, 3);
	 paymentaccountspage.paymentAccountsAdd(name, accountnumber, openingbalance, note);
	 String expectedAlertMessage = "Account created successfully";
	 Assert.assertEquals(paymentaccountspage.getAccountCreationMessage(), expectedAlertMessage);

	 }
}
