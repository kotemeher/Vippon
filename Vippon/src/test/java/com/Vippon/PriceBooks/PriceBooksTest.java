package com.Vippon.PriceBooks;

import org.testng.annotations.Test;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.FileLib;
import com.Vippon.GenericLib.WebdriverCommonLib;
import com.Vippon.Pages.LoginPage;


public class PriceBooksTest extends BaseTest{
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
		PriceBooksHomePage hp=new PriceBooksHomePage();
		hp.clickPriceBooksTab();
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "customViewTitle"), "Custom View Page");
		CustomViewPricePage  cvs = new CustomViewPricePage();
		cvs.clickNewPriceBookBtn();
		Thread.sleep(2000);
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "custompricebookTitle"), "Create Price BOOK Page");
		
		CreatePriceBooksPage sp = new CreatePriceBooksPage();	
		sp.createLeadWithMandatoryDetails2(flib.readExcelData(EXCEL_PATH,"Leads",11, 1), flib.readExcelData(EXCEL_PATH,"Leads",12, 1));
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "PriceBookDetails"), "price book Details");
		
        driver.close();
}
}