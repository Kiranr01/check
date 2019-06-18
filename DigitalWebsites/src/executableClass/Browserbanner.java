package executableClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BrowserHelper.BrowserFactory;

import Utility.Data;
import Utility.Readexcel_RowName;
import generatedClass.POM_Generated_Homepage;


public class Browserbanner 
{
	Data obj=new Data();
	
	public WebDriver BrowserBanner(WebDriver driver,String TestDataExcel, String Functionality,String BrowserType,String Banner, String node_ip) throws InterruptedException, IOException 
	{	
		BrowserFactory browserFactory = new BrowserFactory();
		
		new Readexcel_RowName().excelRead("HubSheet", "BannerURL", Banner);	
		String url= Readexcel_RowName.getValue("URL");
		
		driver = browserFactory.startbrowser(driver, BrowserType, url,node_ip);
		
		driver = Clearcookie(driver, TestDataExcel, Functionality,Banner);
		
		return driver ;
	}
	
	public WebDriver Clearcookie(WebDriver driver, String TestDataExcel,String Functionality,String Banner) throws InterruptedException, IOException 
	{
		
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		
		WebElement logo = null;
		
		
	
		if(Banner.equalsIgnoreCase("Winndixie"))
		{
			logo=homepage.click_Winndixie_logo;
		}
		else if(Banner.equalsIgnoreCase("Bilo"))
		{
			logo = homepage.click_Bilo_logo;
		}
		else if(Banner.equalsIgnoreCase("Harveys"))
		{	
			logo = homepage.click_Harveys_logo;
		}
			
		try
		{									  			   			
			obj.waitForElementClickable(driver, homepage.click_Close_cookies_Button);
			obj.movetoElementofAPage_Click(driver, homepage.click_Close_cookies_Button);
			
			Thread.sleep(1000);
			
		}
		catch(Exception e)
		{
			
		}	
		obj.waitForElementClickable(driver, logo);
		logo.click();
		System.out.println("clicked");
		return driver ;
	}
}

