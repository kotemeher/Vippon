package com.Vippon.PriceBooks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class PriceBooksHomePage {
	
@FindBy(xpath="//a[text()='Price Books']") private WebElement PriceBooksTab;
@FindBy(xpath="//img[@id=\"scrollright\"]") private WebElement ctl;
	
	public PriceBooksHomePage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	
	}
	
	public void clickPriceBooksTab() {
		// TODO Auto-generated method stub
		for(int i=1;i<=30;i++)
		{
			ctl.click();
		}
	
	PriceBooksTab.click();
	}
}