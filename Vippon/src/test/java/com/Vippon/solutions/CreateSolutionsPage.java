package com.Vippon.solutions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vippon.GenericLib.BaseTest;

public class CreateSolutionsPage {

	@FindBy(xpath="//input[@name=\"property(Solution Title)\"]") private WebElement solutionsTitleTb;
	@FindBy(xpath="//textarea[@name=\"property(Question)\"]") private WebElement questionsTb;
	@FindBy(xpath="//textarea[@name=\"property(Answer)\"]") private WebElement answersTb;
	
	@FindBy(xpath="(//input[@value=\"Save\"])[2]") private WebElement saveBtn;
	
	public CreateSolutionsPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void createLeadWithMandatoryDetails1(String SolutionTitle, String qt, String at) 
	{
		// TODO Auto-generated method stub
        solutionsTitleTb.sendKeys(SolutionTitle);
		questionsTb.sendKeys(qt);
		answersTb.sendKeys(at);
	    saveBtn.click();	
	}
	

}
