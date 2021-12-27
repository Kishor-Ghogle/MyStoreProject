package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.AccountCreationPage;
import com.pom.HomePage;
import com.pom.IndexPage;
import com.pom.LoginPage;

public class AccountCreationTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	 
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
	
	@Test(groups="Sanity")
	public void createAccountPageTest()
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount("kis2@abc.com");
		boolean result=accountCreationPage.validateAccountCreatepage();
		Assert.assertTrue(result);	
	}

}
