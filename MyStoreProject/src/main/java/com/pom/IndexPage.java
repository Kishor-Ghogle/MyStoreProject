package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class IndexPage extends BaseClass
{
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//*[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//*[@id='search_query_top']")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public IndexPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage clickOnSignIn()
	{
		signInBtn.click();
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return myStoreLogo.isDisplayed();
	}
	
	public String getmyStoreTitle()
	{
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}
    
	public SearchResultPage searchProduct(String productname)
	{
		searchProductBox.clear();
		searchProductBox.sendKeys(productname);
		searchButton.click();
		return new SearchResultPage();
	}

}
