package com.Vippon.solutions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class HomePage1 {

	@FindBy(xpath="//a[text()='Solutions']") private WebElement solutionsTab;
	
	public HomePage1()
	{
		PageFactory.initElements(BaseTest.driver, this);
	
	}
	public void clickSolutionsTab()
	{
		solutionsTab.click();
	}
	

}
