package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void beforeSuite() throws IOException
	{
		ExtentManager.setExtent();

	}
	
	@BeforeTest(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig() throws IOException
	{
		
		prop=new Properties();
		FileInputStream	ip= new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		prop.load(ip);
	}
   
	@Parameters("browser")
	public static void launchApp(String browserName)
	{
		
		//String browserName = prop.getProperty("browser");
		
		if(browserName.contains("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.contains("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browserName.contains("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterSuite(groups= {"Smoke","Sanity","Regression"})
	public void afterSuite()
	{
		ExtentManager.endReport();
	}

}
