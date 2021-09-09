package com.Vippon.Potentials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class CustomPotentialPage {

	
@FindBy(xpath = "//input[@value=\"New Potential\"]") private WebElement newPotentialBtn;
	
	public CustomPotentialPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void clickNewPotentialBtn() {
		// TODO Auto-generated method stub
		newPotentialBtn.click();
	}
	

}
