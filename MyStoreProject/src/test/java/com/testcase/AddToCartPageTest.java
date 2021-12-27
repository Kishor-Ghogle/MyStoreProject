package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AddToCartPage;
import com.pom.IndexPage;
import com.pom.SearchResultPage;

public class AddToCartPageTest extends BaseClass 
{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
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
	
	@Test(groups={"Regression","Sanity"})
	public void AddToCartTest()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("3");
		addToCartPage.selectSize("2");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
	}

}
