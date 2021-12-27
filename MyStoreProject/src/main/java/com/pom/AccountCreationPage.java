package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AccountCreationPage extends BaseClass
{
	@FindBy(xpath="//h1[text()='Create an account']")
	  WebElement formTitle;
	  
	  public AccountCreationPage()
		{
			PageFactory.initElements(driver,this);
			
		}
	  public boolean validateAccountCreatepage()
	  {
		  return formTitle.isDisplayed();
	  }
	
}
