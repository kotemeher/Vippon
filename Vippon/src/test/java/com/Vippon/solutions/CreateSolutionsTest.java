package com.Vippon.solutions;

import org.testng.annotations.Test;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.FileLib;
import com.Vippon.GenericLib.WebdriverCommonLib;
import com.Vippon.Pages.LoginPage;

public class CreateSolutionsTest  extends BaseTest {
	@Test
	public void main() throws Throwable {
		
		BaseTest bt = new BaseTest();
		bt.openBrowser();
		
		LoginPage lp=new LoginPage();
		FileLib flib = new FileLib();
		Thread.sleep(2000);
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"),flib.readPropertyData(PROP_PATH, "passWord"));
		
		WebdriverCommonLib wlib = new WebdriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "homeTitle"), "Home Page");
		HomePage1 hp=new HomePage1();
		hp.clickSolutionsTab();
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "customViewTitle"), "Custom View Page");
		CustomViewSolutionsPage cvs = new CustomViewSolutionsPage();
		cvs.clickNewSolutionsBtn();
		Thread.sleep(2000);
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customSolutionsTitle"), "Create Solutions Page");
		
		CreateSolutionsPage sp = new CreateSolutionsPage();	
		sp.createLeadWithMandatoryDetails1(flib.readExcelData(EXCEL_PATH,"Leads",4, 1), flib.readExcelData(EXCEL_PATH,"Leads",6, 1),flib.readExcelData(EXCEL_PATH,"Leads", 7, 1));
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "SolutionsDetails"), "Solutions Details");
		
		driver.close();
	}
	

}
