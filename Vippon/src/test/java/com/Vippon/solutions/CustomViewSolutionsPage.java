package com.Vippon.solutions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class CustomViewSolutionsPage {
@FindBy(xpath = "//input[@value=\"New Solution\"]") private WebElement newSolutionsBtn;
	
	public CustomViewSolutionsPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickNewSolutionsBtn() {
		// TODO Auto-generated method stub
		newSolutionsBtn.click();
	}

}
