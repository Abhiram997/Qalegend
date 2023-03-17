package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
WebDriver driver;
/////////////////////////////// add
/////////////////////////////// products/////////////////////////////////////

@FindBy(xpath = "//*[contains(@id,'tour_step5_menu')]")
public WebElement product;
@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[2]/a")
public WebElement addproduct;
@FindBy(xpath = "//*[@id=\"name\"]")
public WebElement proname;
@FindBy(id="select2-unit_id-container")
public WebElement clickunit;
@FindBy(xpath = "//input[@class='select2-search__field']")
public WebElement unitelement;

@FindBy(xpath = "//*[@id=\"unit_id\"]/option[3]")
public WebElement option;
@FindBy(xpath = "//*[@id=\"product_add_form\"]/div[1]/div/div/div[5]/div/span/span[1]")
public WebElement category;
@FindBy(id = "select2-barcode_type-container")
WebElement clickbarcode;
@FindBy(xpath="//input[@class='select2-search__field']")
WebElement barcodeelement;

@FindBy(xpath = "//*[@id=\"category_id\"]/option[3]")
public WebElement option1;
@FindBy(xpath = "//*[@id=\"alert_quantity\"]")
public WebElement alertqty;
@FindBy(xpath = "//*[@id=\"single_dpp\"]")
public WebElement exctax;
@FindBy(xpath = "//*[@id=\"product_add_form\"]/div[4]/div/div/div/button[4]")
public WebElement sbutton;

@FindBy(xpath = "//*[@id=\"upload_image\"]")
public WebElement pro_image;
@FindBy(id = "single_dpp")
public WebElement exctaxelement;
@FindBy(id="single_dpp_inc_tax")
public WebElement inctaxelement;
@FindBy(xpath = "//*[@id=\"toast-container\"]/div")
public WebElement pro_save_msg;

public ProductPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this); //use current class driver
}
public void selectUnit(String unit) {
	clickunit.click();
	unitelement.sendKeys(unit + Keys.ENTER);

}
public void selectBarCode(String barcode) {
	clickbarcode.click();
	barcodeelement.sendKeys(barcode + Keys.ENTER);

}

public void addProduct(String productname, String unit, String barcode, String alertquantity, String exctax, String inctax) {
	proname.sendKeys(productname);
	selectUnit(unit);
	selectBarCode(barcode);
	exctaxelement.sendKeys(exctax);
	inctaxelement.sendKeys(inctax);
	alertqty.sendKeys(alertquantity);
	sbutton.click();

}



public void clickOnProduct()
{
	product.click();
}
public void clickOnAddProduct()
{
	addproduct.click();
}

}
