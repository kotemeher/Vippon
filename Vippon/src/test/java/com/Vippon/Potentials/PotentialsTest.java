package com.Vippon.Potentials;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vippon.GenericLib.BaseTest;
import com.Vippon.GenericLib.FileLib;
import com.Vippon.GenericLib.WebdriverCommonLib;
import com.Vippon.Pages.LoginPage;

@Listeners(com.Vippon.GenericLib.ReportListeners.class)
public class PotentialsTest extends BaseTest{
	@Test
public  void main() throws Throwable {
		
		
		
		LoginPage lp=new LoginPage();
		FileLib flib = new FileLib();
		Thread.sleep(2000);
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"),flib.readPropertyData(PROP_PATH, "passWord"));
		

		WebdriverCommonLib wlib = new WebdriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "homeTitle"), "Home Page");
		 PotentialsHome hp = new PotentialsHome();
		hp.clickPotentialsTab();
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "customViewTitle"), "Custom View Page");
		CustomPotentialPage cvs = new CustomPotentialPage();
		cvs.clickNewPotentialBtn();
		Thread.sleep(2000);
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customPotentialTitle"), "Create Potential Page");
		
		CreatePotentialPage sp = new CreatePotentialPage();	
		sp.createLeadWithMandatoryDetails2(flib.readExcelData(EXCEL_PATH,"Leads",14, 1));
		sp.selectCaseOwnerOption("Qualification");
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "PotentialDetails"), "potential Details");
		
		
		
}

}
