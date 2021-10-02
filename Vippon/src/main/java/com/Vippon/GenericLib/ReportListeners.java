package com.Vippon.GenericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportListeners implements ITestListener {
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.INFO, result.getName()+" Method Started");
	}

	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.pass(MarkupHelper.createLabel(" case has PASSED", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.fail(MarkupHelper.createLabel(" case has FAILED because of following reasons: ", ExtentColor.RED));
		test.fail(result.getThrowable());
		WebdriverCommonLib wlib = new WebdriverCommonLib();
		test.addScreenCaptureFromPath(wlib.getFullPageScreenshot(result.getName()));
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.skip(MarkupHelper.createLabel(" case has SKIPPED because of following reasons: ", ExtentColor.PINK));
		test.skip(result.getThrowable());
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Meher Chakradhar\\git\\repository\\Vippon\\Reports\\CreateLeadTest.html");
		//Customizing report view
		spark.config().setDocumentTitle("Vippon Reports");
		spark.config().setReportName("Extent Reports 5");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		//setting system info
		extent.setSystemInfo("Author", "Meher");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("TestRunner Name", context.getName());
		
	}

	public void onFinish(ITestContext context) {
		//Writing all logs into report
		extent.flush();
	}

}



