package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.IndexPage;

public class IndexPageTest extends BaseClass 
{
	IndexPage indexPage;	
	
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
	  public void verifyLogo()
	  {
		indexPage=new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	  }
	  
	  @Test(groups="Smoke")
	  public void verifyTitle()
	  {
		  String actTitle=indexPage.getmyStoreTitle();
		  Assert.assertEquals(actTitle,"My Store");
	  }

}
