package com.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class AddToCartPage extends BaseClass
{
	@FindBy(id="quantity_wanted")
	  WebElement quantity;
	  
	  @FindBy(name="group_1")
	  WebElement size;
	  
	  @FindBy(xpath="//span[text()='Add to cart']")
	  WebElement addToCartBtn;
	  
	  @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	  WebElement addToCartMessage;
	  
	  @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	  WebElement proceedToCheckoutBtn;
	  
	  public AddToCartPage()
		{
			PageFactory.initElements(driver,this);
		}
	  
	  public void enterQuantity(String qant)
	  {
		  quantity.clear();
		  quantity.sendKeys(qant);
	  }
	  
	  public void selectSize(String size1)
	  {
		  Select sel=new Select(size);
		  sel.selectByValue(size1);
	  }
	  
	  public void clickOnAddToCart()
	  {
		  
		  addToCartBtn.click();
	  }
	  
	  public boolean validateAddToCart() 
	  {
		  WebDriverWait wb=new WebDriverWait(driver,30);
		  wb.until(ExpectedConditions.visibilityOf(addToCartMessage));
		  return addToCartMessage.isDisplayed();
	  }
	 
	  public OrderPage clickOnCheckout()
	  {
		  WebDriverWait wb=new WebDriverWait(driver,30);
		  wb.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
		  JavascriptExecutor js= (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();",proceedToCheckoutBtn);
		  return new OrderPage();
	  }

}
