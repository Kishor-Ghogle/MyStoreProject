package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AddToCartPage;
import com.pom.IndexPage;
import com.pom.OrderPage;
import com.pom.SearchResultPage;

public class OrderPageTest extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
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
	
	@Test(groups="Regression")
	public void verifyTotalPrice()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("2");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckout();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}

}
