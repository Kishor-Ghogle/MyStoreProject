package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class OrderConfirmationPage extends BaseClass
{
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	  WebElement confirmMsg;
	  
	  public OrderConfirmationPage()
	  {
		 PageFactory.initElements(driver, this); 
	  }
	  
	  public String validateConfirmMsg()
	  {
		  String confirmMsg1=confirmMsg.getText();
		  return confirmMsg1;
	  }

}
