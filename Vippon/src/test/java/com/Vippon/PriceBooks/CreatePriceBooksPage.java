package com.Vippon.PriceBooks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class CreatePriceBooksPage {
@FindBy(xpath="//input[@name=\"property(Price Book Name)\"]") private WebElement priceBooksTb;
	
	@FindBy(xpath="//textarea[@name=\"property(Description)\"]") private WebElement descriptionTb;
	
	
	
	
	@FindBy(xpath="(//input[@value=\"Save\"])[2]") private WebElement saveBtn;
	
	public CreatePriceBooksPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void createLeadWithMandatoryDetails2(String SolutionTitle,String qt)
	{
		priceBooksTb.sendKeys(SolutionTitle);
		descriptionTb.clear();
		
		descriptionTb.sendKeys(qt);
		
		
		saveBtn.click();
		
	}
	


}
