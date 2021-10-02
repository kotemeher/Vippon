package com.Vippon.GenericLib;



import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;

public class WebdriverCommonLib extends BaseTest{

	
	public String getPageTitle()
	{
		String pageTitle = BaseTest.driver.getTitle();
		return pageTitle;
		
	}
	
	public void verify(String actual,String expected,String page)
	  {
//	  if(actual.equals(expected))
//	    {
//		System.out.println(page+" is displayed, PASS");
//	    }
//	else
//	    {
//		System.out.println(page+" is not displayed, FAIL");
//	    }
//	  }
		if(actual.equals(expected))
		{
			Assert.assertTrue(true);
			ReportListeners.test=ReportListeners.extent.createTest("verify");
			ReportListeners.test.pass(MarkupHelper.createLabel("is displayed pass", ExtentColor.BLUE));
		}
		else
		{
			Assert.assertTrue(false);
			ReportListeners.test=ReportListeners.extent.createTest("verify");
			ReportListeners.test.pass(MarkupHelper.createLabel("is not displayed pass", ExtentColor.RED));
		}
	  }
	
	public void selectOption(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void selectOption(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selectOption(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mouseHover(WebElement element)
	{
		Actions ac=new Actions(BaseTest.driver);
		ac.moveToElement(element);
	}
	
	public void rightClick(WebElement element)
	{
		Actions ac=new Actions(BaseTest.driver);
		ac.contextClick(element).perform();
	}
	
	public void dragAndDropElement(WebElement source,WebElement target )
	{
	     Actions ac=new Actions(BaseTest.driver);
	     ac.dragAndDrop(source, target).perform();
	}
	
	public void switchToFrame(int index)
	{
		
		BaseTest.driver.switchTo().frame(index);	
	}
	public void switchToFrame(String value)
	{
		
		BaseTest.driver.switchTo().frame(value);	
	}
	public void switchToFrame(WebElement element)
	{
		
		BaseTest.driver.switchTo().frame(element);	
	}
	public String getFullPageScreenshot(String screenshotName)
	{
	    TakesScreenshot ts = (TakesScreenshot)BaseTest.driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    String dest="C:\\Users\\Meher Chakradhar\\git\\repository\\Vippon\\screenshots"+screenshotName+"png";
	    File destination = new File(dest);
	    try {
	    	Files.copy(src, destination);
	    } catch (IOException e) {
	    		
	    		e.printStackTrace();
	    }
	    return dest;
	 
	}
	public void getElementPageScreenshot(WebElement element,String screenshotPath)
	{
	    
	    File src = element.getScreenshotAs(OutputType.FILE);
	    File dest = new File(screenshotPath);
	    try {
	    	Files.copy(src, dest);
	    } catch (IOException e) {
	    		
	    		e.printStackTrace();
	    }
	}
	public void WaitForPageTitle(String title)
	{
	WebDriverWait wait = new WebDriverWait(BaseTest.driver,30);
	wait.until(ExpectedConditions.titleContains(title));
	}
	public void selectoption(WebElement element, int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	public void selectoption(WebElement element, String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	public void selectoption(String text,WebElement element)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	public void getWindowHandleclick(String targetbrowsertitle, WebElement element)
	{
		String mainwindow = BaseTest.driver.getWindowHandle();
		Set<String> allwindows=BaseTest.driver.getWindowHandles();
		for(String currentwindow:allwindows)
		{
			String title = BaseTest.driver.switchTo().window(currentwindow).getTitle();
			if(title.equalsIgnoreCase(targetbrowsertitle))
			{
				element.click();
			}
			
		}
		
		BaseTest.driver.switchTo().window(mainwindow);
	}
	
	
	public void elementStatus(WebElement element, int checkType, String elementName)
	{
		switch(checkType)
		{
		case 1:
			try {
				element.isDisplayed();
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is Displayed", ExtentColor.PURPLE));
			}
			catch (Exception e) {
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is not Displayed", ExtentColor.ORANGE));
			}
			
			break;
		case 2:
			try {
				element.isEnabled();
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is Enabled", ExtentColor.PURPLE));
			}
			catch (Exception e) {
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is not Enabled", ExtentColor.ORANGE));
			}
			break;
		case 3: 
			try {
				element.isSelected();
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is Selected", ExtentColor.PURPLE));
			}
			catch (Exception e) {
				ReportListeners.test.info(MarkupHelper.createLabel(elementName+" is not Selected", ExtentColor.ORANGE));
			}
			break;
		}
	}

}

