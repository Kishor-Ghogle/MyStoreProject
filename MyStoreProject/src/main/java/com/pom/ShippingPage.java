package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ShippingPage extends BaseClass 
{
	@FindBy(id="cgv")
	  WebElement terms;
	  
	  @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	  WebElement proceedToCheckoutBtn;
	  
	  public ShippingPage()
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public void clickOnTerms()
	  {
		  terms.click();
	  }
	  
	  public PaymentPage clickOnProceddToCheckout()
	  {
		  proceedToCheckoutBtn.click();
		  return new PaymentPage();
	  }

}
