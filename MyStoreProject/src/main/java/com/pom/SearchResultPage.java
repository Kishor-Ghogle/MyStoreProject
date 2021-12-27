package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchResultPage extends BaseClass
{
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver,this);
	}
    
	public boolean isProductAvailable()
	{
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct()
	{
		productResult.click();
		return new AddToCartPage();
	}

}
