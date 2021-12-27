package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PaymentPage extends BaseClass
{
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	  WebElement bankWireMethod;
	  
	  @FindBy(xpath="//a[conatins(text(),'Pay by check')]")
	  WebElement payByCheckMethod;
	  
	  public PaymentPage()
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public OrderSummaryPage clickOnPaymentMethod()
	  {
		  bankWireMethod.click();
		  return new OrderSummaryPage();
	  }

}
