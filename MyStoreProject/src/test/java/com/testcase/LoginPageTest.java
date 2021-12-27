package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.dataprovider.DataProviders;
import com.pom.HomePage;
import com.pom.IndexPage;
import com.pom.LoginPage;

public class LoginPageTest extends BaseClass
{
	IndexPage indexPage;
	  LoginPage loginPage;
	  HomePage homePage;
	  
	  @Parameters("browser")
	  @BeforeTest(groups= {"Smoke","Sanity","Regression"})
		public void setup(String browser)
		{
		    launchApp(browser);  
		}
	  
	  @AfterTest(groups= {"Smoke","Sanity","Regression"})
	  public void tearDown()
	  {
		  driver.quit(); 
	  }
	  
	  @Test(dataProvider="credentials", dataProviderClass=DataProviders.class, groups= {"Smoke","Sanity"})
	  public void loginTest(String uname, String pswd)
	  {
		 indexPage=new IndexPage();
		 loginPage=indexPage.clickOnSignIn();
		 //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 homePage=loginPage.login(uname,pswd);
		 String actualURL=homePage.getCurrentURL();
		 String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		 Assert.assertEquals(actualURL, expectedURL);
	  }

}
