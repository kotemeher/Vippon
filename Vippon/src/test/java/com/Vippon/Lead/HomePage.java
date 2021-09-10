package com.Vippon.Lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Leads']") private WebElement leadsTab;
	
	public HomePage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	
	}
	
	public void clickLeadsTab() {
		
		leadsTab.click();
	}
	

}
