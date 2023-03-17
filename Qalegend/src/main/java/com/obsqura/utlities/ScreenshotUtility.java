package com.obsqura.utlities;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.ConstantCallSite;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.obsqura.constants.Constants;

public class ScreenshotUtility {

	TakesScreenshot takesscreenshot;

	public void takeScreenshot(WebDriver driver, String imageName) {
		try 
		{
            takesscreenshot=(TakesScreenshot) driver;
            File screenshot = takesscreenshot.getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
            String path=Constants.SCREENSHOT_FILE_PATH+imageName+"_"+timeStamp+".png";
            File destination=new File(path);
            FileHandler.copy(screenshot, destination);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
