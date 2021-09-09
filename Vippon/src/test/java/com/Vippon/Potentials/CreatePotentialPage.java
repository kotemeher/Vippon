package com.Vippon.Potentials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.WebdriverCommonLib;

public class CreatePotentialPage {

@FindBy(xpath="//input[@name='property(Potential Name)']") private WebElement potentialNameTb;
	
	@FindBy(xpath="//img[@src='/crm/images/Accounts_small.gif']") private WebElement accountNameTb;
	@FindBy(xpath="//a[text()='QSpiders Bull Temple']") private WebElement accountNameTb1;
	
	@FindBy(xpath="//img[@src='/crm/images/cal.gif']") private WebElement closingDtImg;
	@FindBy(xpath="//a[@class='calCurrDay'and text()='9']") private WebElement calDay;
	
	@FindBy(xpath="//select[@name='property(Stage)']") private WebElement stageBtn;
	
	
	@FindBy(xpath="(//input[@value=\"Save\"])[2]") private WebElement saveBtn;
	
	public CreatePotentialPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void createLeadWithMandatoryDetails2(String pn)
	{
		potentialNameTb.sendKeys(pn);
		accountNameTb.click();
		WebdriverCommonLib wlib=new WebdriverCommonLib();
		wlib.getWindowHandleclick("Zoho CRM - Account Name Lookup", accountNameTb1);
	
		closingDtImg.click();
		wlib.getWindowHandleclick("Closing Date", calDay);
		
		
		
		
	}	
	public void selectCaseOwnerOption(String text) 
	{
		WebdriverCommonLib wlib=new WebdriverCommonLib();
		wlib.selectoption(text, stageBtn);
		saveBtn.click();
	}
	

}
