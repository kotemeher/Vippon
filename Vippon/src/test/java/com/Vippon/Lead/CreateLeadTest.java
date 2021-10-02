package com.Vippon.Lead;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.FileLib;
import com.Vippon.GenericLib.WebdriverCommonLib;
import com.Vippon.Pages.LoginPage;
@Listeners(com.Vippon.GenericLib.ReportListeners.class)
public class CreateLeadTest extends BaseTest{
	@Test
	public  void Lead() throws Throwable {
		
		
		
		
		LoginPage lp=new LoginPage();
		FileLib flib = new FileLib();
		Thread.sleep(2000);
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord"));
		
		WebdriverCommonLib wlib = new WebdriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "homeTitle"), "Home Page");
		
		HomePage hp = new HomePage();
//		hp.clickLeadsTab();
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "customViewTitle"),"Custom View Page");
		
		CustomViewPage cv = new CustomViewPage();
		cv.clickNewBtn();
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "createLeadTitle"), "create Lead Page");
		
		CreateLeadPage cl=new CreateLeadPage();
		cl.createLeadWithMandatoryDetails(flib.readExcelData(EXCEL_PATH,"Leads",1, 1),flib.readExcelData(EXCEL_PATH, "Leads", 2, 1));
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "leadDetailsTitle"), "Lead Details Page");
		
		
			
	}
	
}
