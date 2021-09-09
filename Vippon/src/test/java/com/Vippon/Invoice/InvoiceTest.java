package com.Vippon.Invoice;

import org.testng.annotations.Test;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.FileLib;
import com.Vippon.GenericLib.WebdriverCommonLib;
import com.Vippon.Pages.LoginPage;

public class InvoiceTest extends BaseTest {
	
       @Test
	   public  void main() throws Throwable
	   
	   {
		BaseTest bt =new BaseTest();
		bt.openBrowser();
		
		FileLib flib= new FileLib();
		WebdriverCommonLib wlib= new WebdriverCommonLib();
		
		LoginPage lp= new LoginPage();
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"), flib.readPropertyData(PROP_PATH, "passWord") );
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "homeTitle"),"Home Page");
		
		InvoiceHome hp= new InvoiceHome();
		hp.clickInvoiceTab();
		
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		InvoiceCustomViewPage cv= new InvoiceCustomViewPage();
		cv.selectCaseOption("My Invoices");
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "createInvoiceTitle"), "Create Lead Page");
	    driver.close();
	   }	

}
