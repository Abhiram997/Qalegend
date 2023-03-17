package com.obsqura.utlities;

 

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

	public void select_By_Index(int Index, WebElement element) {
	Select select = new Select(element);
	select.selectByIndex(Index);
	}

	public void select_By_Value(String value, WebElement element) {
	Select select = new Select(element);
	select.selectByValue(value);
	}

	public void select_By_Visibility(String visibility, WebElement element) {
	Select select = new Select(element);
	select.selectByValue(visibility);
	}

	public void doubleClick(WebElement element) {
	Actions action = new Actions(driver);
	action.doubleClick(element).build().perform();
	}

	public void scrollIntoView(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("argument[0].scrollIntoView();", element);
	js.executeScript("window.scrollBy(0,300)");
	}

	public String getText() {
	String s = driver.switchTo().alert().getText();
	return s;
	}

	public void acceptAlert() {
	driver.switchTo().alert().accept();

	}

	public void dismissAlert() {
	driver.switchTo().alert().dismiss();

	}

	public void scrollAndClick(WebElement save) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("argument[0].scrollIntoClick();");
	js.executeScript("window.scrollBy(0,200)");
	}
	public String getTextOfElement(WebElement element)
	{
	return element.getText();
	}
	public boolean is_TextAsExpected(WebElement element, String expectedtext)
	{
	String text = element.getText();
	return text.equals(expectedtext);
	}

	public void refreshUtility(WebDriver driver) {
	driver.navigate().refresh();
	}

	public void navigateBackUtility(WebDriver driver) {
	driver.navigate().back();
	}

	}
