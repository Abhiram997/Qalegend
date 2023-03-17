package com.obsqura.scripts;

import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.obsqura.constants.Constants;
import com.obsqura.utlities.ScreenshotUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestHelper {
	static WebDriver driver;
	Properties prop;
	FileInputStream ip;
	ScreenshotUtility screenshot=new ScreenshotUtility();
	

	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	public TestHelper()
	{
		prop=new Properties();
		try
		{
			ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@BeforeTest(enabled = true, alwaysRun = true)
	public void launchBrowser()

	{
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		System.out.println("Execution started");
		initialize(browser,url);
		
	}
	@Parameters("browser")
	@BeforeMethod(enabled = false)
	public void launchCrossBrowserSession(String browser)
	{
		String url=prop.getProperty("url");
		initialize(browser,url);
		
	}
	
	@AfterMethod
	public void terminateInstance(ITestResult itestresult)
	{
		if(itestresult.getStatus()==TestResult.FAILURE)
		{
			
			screenshot.takeScreenshot(driver, itestresult.getName());
		}
	}
	
	
	
	

	
	@BeforeTest(enabled = false)
	public void openBrowser(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://qalegend.com/billing/public/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		}
		if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("https://qalegend.com/billing/public/login");
			driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}

	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}

}
