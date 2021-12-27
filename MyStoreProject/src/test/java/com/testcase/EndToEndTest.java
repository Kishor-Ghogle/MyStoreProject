package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AddToCartPage;
import com.pom.AddressPage;
import com.pom.IndexPage;
import com.pom.LoginPage;
import com.pom.OrderConfirmationPage;
import com.pom.OrderPage;
import com.pom.OrderSummaryPage;
import com.pom.PaymentPage;
import com.pom.SearchResultPage;
import com.pom.ShippingPage;

public class EndToEndTest extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
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
	public void endToEndTest()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("2");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckout();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickOnCheckoutBtn();
		shippingPage.clickOnTerms();
		paymentPage=shippingPage.clickOnProceddToCheckout();
		orderSummaryPage=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummaryPage.clickOnConfirmOrderBtn();
		String actualMsg=orderConfirmationPage.validateConfirmMsg();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

}
