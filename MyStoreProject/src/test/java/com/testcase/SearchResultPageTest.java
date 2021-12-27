package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.HomePage;
import com.pom.IndexPage;
import com.pom.SearchResultPage;

public class SearchResultPageTest extends BaseClass
{

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
	    launchApp(browser);  
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(groups="Smoke")
	public void productAvailabilityTest()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		
	}

}
