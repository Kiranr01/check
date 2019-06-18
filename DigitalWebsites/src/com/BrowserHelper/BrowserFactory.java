package com.BrowserHelper;


import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory extends EdgeOptions
{		     
	public WebDriver startbrowser(WebDriver driver,String browserName,String URL,String NodeURL) throws InterruptedException, IOException
	{
       
		if(browserName.equalsIgnoreCase("Safari"))
		{                
        	driver = new SafariDriver();
        	driver.manage().window().maximize();
        }
        else if(browserName.equalsIgnoreCase("Chrome"))
        {     
        	//System.setProperty("webdriver.chrome.driver","C:\\Users\\ragunk\\seleniumautomation\\chromedriver.exe");
        	ChromeOptions chromeoptions = new ChromeOptions(); 
        	DesiredCapabilities chromecapabilities = new DesiredCapabilities();
        	chromecapabilities.setBrowserName("chrome");
        	
        	chromeoptions.addArguments("test-type");
        	
        	chromeoptions.merge(chromecapabilities);       	
        	String remoteUrl ="http://"+NodeURL+"/wd/hub/";           
        	try
        	{
        		driver= new RemoteWebDriver(new URL(remoteUrl),chromeoptions); 
        		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        		driver.manage().window().maximize();
        		driver.get(URL);	
        	}
        	catch(Exception e)
        	{		
        		
        		System.out.println("Error in chrome browser launch in \""+remoteUrl+ "\" this node machine");
        	}
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
        	
        	/*if(Platform.equalsIgnoreCase("Windows10_Edge"))
        	{
        		String remoteUrl ="http://"+NodeURL+"/wd/hub/";  
        		try
        		{
        			EdgeOptions EdgeOption = new EdgeOptions();
        			DesiredCapabilities edgecapabilities = new DesiredCapabilities();
        			edgecapabilities.setCapability(EdgeOptions.CAPABILITY, EdgeOption);	   		
        			                         
        			driver = new RemoteWebDriver(new URL(remoteUrl), edgecapabilities); 
        			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        			driver.manage().window().maximize();
        			driver.get(URL);        	
        		}
        		catch(Exception e)
        		{
        			System.out.println("Error in edge browser launch \""+remoteUrl+ "\" this node machine");
        		}
        	}
        	else
        	{*/
        		String remoteUrl ="http://"+NodeURL+"/wd/hub/";   
        		try
        		{
        			InternetExplorerOptions ieoptions = new InternetExplorerOptions();
            		ieoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            		ieoptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            		ieoptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
            		ieoptions.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
            		ieoptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            		ieoptions.elementScrollTo(ElementScrollBehavior.TOP);
            		ieoptions.elementScrollTo(ElementScrollBehavior.BOTTOM);
            		                       
        			driver = new RemoteWebDriver(new URL(remoteUrl), ieoptions); 
        			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        			driver.manage().window().maximize();
        			driver.get(URL);
        		}
        		catch(Exception e)
        		{
        			System.out.println("Error in IE browser launch \""+remoteUrl+ "\" this node machine");
        		}
        	/*}*/
        }
		Thread.sleep(3000);     
		return driver;     
	}
}
