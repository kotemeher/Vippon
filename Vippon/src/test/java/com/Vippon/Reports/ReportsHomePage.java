package com.Vippon.Reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class ReportsHomePage{
	@FindBy(xpath="//a[text()='Reports']") private WebElement ReportsTab;
	
	
	public ReportsHomePage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	
	}


public void Report()
{
	ReportsTab.click();
}


}
