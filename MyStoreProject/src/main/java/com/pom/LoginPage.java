package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass
{
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id="SubmitCreate")
	WebElement createNewAccount;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
    public HomePage login(String uname, String pswd)
    {
    	//userName.clear();
    	userName.sendKeys(uname);
    	//password.clear();
    	password.sendKeys(pswd);
    	signInBtn.click();
    	return new HomePage();
    }
    
    public AddressPage login1(String uname, String pswd)
    {
    	userName.clear();
    	userName.sendKeys(uname);
    	password.clear();
    	password.sendKeys(pswd);
    	signInBtn.click();
    	return new AddressPage();
    }
    
    public AccountCreationPage createNewAccount(String newEmail)
    {
    	emailForNewAccount.clear();
    	emailForNewAccount.sendKeys(newEmail);
    	createNewAccount.click();
    	return new AccountCreationPage();
    }

}
