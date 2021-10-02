package com.Vippon.Lead;

import org.testng.annotations.Test;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.FileLib;
import com.Vippon.GenericLib.WebdriverCommonLib;
import com.Vippon.Pages.LoginPage;

public class DeleteLeadsTest extends BaseTest{
	@Test
	public void deleteLeads() throws Throwable
	{
	    FileLib flib=new FileLib();
	    LoginPage lp=new LoginPage();
	    lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord"));
	    WebdriverCommonLib wlib= new WebdriverCommonLib();
	    HomePage hp=new HomePage();
//	    wlib.elementStatus(hp.clickLeadsTab(), 1, "Leads Button");
	    hp.clickLeadsTab();
	    CustomViewPage cv=new CustomViewPage();
	    wlib.elementStatus(null, 0, CHROME_KEY);
	}

}
