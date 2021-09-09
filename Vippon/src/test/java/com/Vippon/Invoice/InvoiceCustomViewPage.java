package com.Vippon.Invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.WebdriverCommonLib;

public class InvoiceCustomViewPage {

	
	@FindBy(xpath="//select[@name='cvid']")private WebElement drop;
	
	public InvoiceCustomViewPage ()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	public void selectCaseOption(String text) 
	{
		WebdriverCommonLib wlib=new WebdriverCommonLib();
		wlib.selectoption(text, drop);
		
	}


}
