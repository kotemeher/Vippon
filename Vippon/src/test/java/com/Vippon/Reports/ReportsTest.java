package com.Vippon.Reports;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.FileLib;
import com.Vippon.GenericLib.WebdriverCommonLib;
import com.Vippon.Pages.LoginPage;


public class ReportsTest extends BaseTest {
	
    @Test
	public void main() throws Throwable 
	{
		BaseTest bt =new BaseTest();
		bt.openBrowser();
		
		FileLib flib= new FileLib();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		
		WebdriverCommonLib wlib= new WebdriverCommonLib();
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");

		ReportsHomePage hp= new ReportsHomePage();
		hp.Report();
	    wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), " Displaying Custom View Details");
		
        ReportsCustomViewPage cv= new ReportsCustomViewPage();
		cv.createTask();
		
        wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "ReportTitle"), "Reports");		
        ReportsCreatePage r1= new ReportsCreatePage();
		r1.selectCaseOwnerOption("Accounts");
		r1.SelectCaseOwnerOption("Contacts");
		r1.Continue();
		
		driver.close();
		
	}

}



