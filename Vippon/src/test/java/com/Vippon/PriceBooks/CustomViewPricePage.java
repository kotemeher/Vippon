package com.Vippon.PriceBooks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class CustomViewPricePage  {
@FindBy(xpath = "//input[@value=\"New Price Book\"]") private WebElement newPriceBooksBtn;
	
	public CustomViewPricePage ()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickNewPriceBookBtn() {
		// TODO Auto-generated method stub
		newPriceBooksBtn.click();
	}
	


}