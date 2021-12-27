package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.HomePage;
import com.pom.IndexPage;
import com.pom.LoginPage;

public class HomePageTest extends BaseClass
{
	IndexPage indexPage;
	   LoginPage loginPage;
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
		public void wishListTest()
		{
		  	indexPage=new IndexPage();
			loginPage=indexPage.clickOnSignIn();
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			boolean result=homePage.validateMyWishlist();
			Assert.assertTrue(result);
		}
		
		@Test(groups="Smoke")
		public void orderHistoryandDetailsTest()
		{
		  	indexPage=new IndexPage();
			loginPage=indexPage.clickOnSignIn();
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			boolean result=homePage.validateOrderHistory();
			Assert.assertTrue(result);
			
		}

}
