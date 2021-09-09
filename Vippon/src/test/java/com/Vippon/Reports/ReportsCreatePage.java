package com.Vippon.Reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.WebdriverCommonLib;

public class ReportsCreatePage{
	  @FindBy(xpath="//select[@id=\"primarymodule\"]") private WebElement primary;
	  @FindBy(xpath="//select[@id=\"Accountsrelatedmodule\"]") private WebElement Arm;
	  @FindBy(xpath="//input[@value=\"Continue\"]") private WebElement cont;
		
	  
	  
	  public ReportsCreatePage()
	  {
		  PageFactory.initElements(BaseTest.driver, this);
	  }
	  
	  
	  
	  
	  public void selectCaseOwnerOption(String text) 
		{
			WebdriverCommonLib wlib=new WebdriverCommonLib();
			wlib.selectoption(text, primary);
			
		}
		
	  public void SelectCaseOwnerOption(String text1) 
	 	{
	 		WebdriverCommonLib wlib=new WebdriverCommonLib();
	 		wlib.selectoption(text1, Arm);
	 		
	 	}
		
		public void Continue()
		{
			cont.click();
		}
		

}
