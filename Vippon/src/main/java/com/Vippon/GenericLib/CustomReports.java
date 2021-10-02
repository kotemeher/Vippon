package com.Vippon.GenericLib;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomReports {
	@Test
	public void runReports()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Meher Chakradhar\\git\\repository\\Vippon\\Reports\\CreateLeadTest.html");
		spark.config().setReportName("Meher Report");
		spark.config().setDocumentTitle("Vippon Report");
		spark.config().setTheme(Theme.DARK);
		ExtentReports repo = new ExtentReports();
		
		repo.attachReporter(spark);
		
		ExtentTest test = repo.createTest("CreateLeadTest").assignAuthor("Meher").assignCategory("SmokeTest").assignDevice("Windows10_Chrome");
		
		test.log(Status.PASS, "Pass");
		
		repo.flush();
	}


}
