package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishlists;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateMyWishlist()
	{
		return myWishlists.isDisplayed();
	}
	
	public boolean validateOrderHistory()
	{
		return orderHistory.isDisplayed();
	}
	
	public String getCurrentURL()
	{
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}

}
