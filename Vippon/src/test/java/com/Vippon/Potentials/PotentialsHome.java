package com.Vippon.Potentials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class PotentialsHome {
	
@FindBy(xpath="//a[text()='Potentials']") private WebElement PotentialTab;
	
	public PotentialsHome()
	{
		PageFactory.initElements(BaseTest.driver, this);
	
	}
	
	public void clickPotentialsTab()
	{
		// TODO Auto-generated method stub
		PotentialTab.click();
	}
	

}
