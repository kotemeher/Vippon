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

import com.google.common.io.Files;

public class WebdriverCommonLib extends BaseTest{

	
	public String getPageTitle()
	{
		String pageTitle = BaseTest.driver.getTitle();
		return pageTitle;
		
	}
	
	public void verify(String actual,String expected,String page)
	  {
	  if(actual.equals(expected))
	    {
		System.out.println(page+" is displayed, PASS");
	    }
	else
	    {
		System.out.println(page+" is not displayed, FAIL");
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
	public void getElementPageScreenshot(String screenshotPath)
	{
	    TakesScreenshot ts = (TakesScreenshot)BaseTest.driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File(screenshotPath);
	    try {
	    	Files.copy(src, dest);
	    } catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    }
	 
	}
	public void getFullPageScreenshot(WebElement element,String screenshotPath)
	{
	    
	    File src = element.getScreenshotAs(OutputType.FILE);
	    File dest = new File(screenshotPath);
	    try {
	    	Files.copy(src, dest);
	    } catch (IOException e) {
	    		// TODO Auto-generated catch block
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
}

