package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AddressPage extends BaseClass 
{
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	  WebElement proceedToCheckoutBtn;
	  
	  public AddressPage()
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public ShippingPage  clickOnCheckoutBtn()
	  {
		  proceedToCheckoutBtn.click();
		  return new ShippingPage();
	  }

}
