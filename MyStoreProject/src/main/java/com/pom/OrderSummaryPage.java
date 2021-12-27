package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class OrderSummaryPage extends BaseClass
{
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	  WebElement confirmOrderBtn;
	  
	  public OrderSummaryPage()
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public OrderConfirmationPage clickOnConfirmOrderBtn()
	  {
		  confirmOrderBtn.click();
		  return new OrderConfirmationPage();
	  }
	  
	  

}
