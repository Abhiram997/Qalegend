package com.obsqura.utlities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class GenericUtility {
	
	public static String getRandomNumber()
	{
		Random random= new Random();
		int number=random.nextInt(1000);
		return String.valueOf(number);
	}

	public static String getTimeStamp()
	{
		 String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		 return timeStamp;
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
}
	
