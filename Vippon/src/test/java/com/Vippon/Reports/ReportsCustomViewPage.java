package com.Vippon.Reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class ReportsCustomViewPage {
	@FindBy(xpath="//input[@value=\"Create New Report\"]") private WebElement CreateNew;
	
	public ReportsCustomViewPage  ()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}

	public void createTask() 
		{
			
		CreateNew.click();
		     	
		}

}
