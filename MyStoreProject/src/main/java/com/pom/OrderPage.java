package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class OrderPage extends BaseClass
{
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
    
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckout;
	
	public OrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice()
	{
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice()
	{
		String totalPrice1=totalPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice=Double.parseDouble(total);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut()
	{
		proceedToCheckout.click();
		return new LoginPage();
	}
	

}