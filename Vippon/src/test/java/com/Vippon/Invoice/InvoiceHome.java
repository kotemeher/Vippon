package com.Vippon.Invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class InvoiceHome {

	
	
@FindBy(xpath="//a[text()='Invoices']") private WebElement InvoicesTab;
@FindBy(xpath="//img[@id=\"scrollright\"]") private WebElement ctl;
	
	public InvoiceHome()
	{
		PageFactory.initElements(BaseTest.driver, this);
	
	}
	public void clickInvoiceTab()
	{
		
			for(int i=1;i<=75;i++)
			{
				ctl.click();
			}
		
			InvoicesTab.click();
	}
	

}
