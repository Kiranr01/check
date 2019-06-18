package computedClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Utility.Data;
import Utility.Readexcel_RowName;
import generatedClass.POM_Generated_Homepage;
import generatedClass.POM_Generated_StoreLocatorPage;

public class Computed_FuelPerk 
{
	public WebDriver FuelPerk_Zipcode(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_StoreLocatorPage storelocatorpage = new POM_Generated_StoreLocatorPage(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		Data obj=new Data();
		String zip="";
		//String value="";
		
		new Readexcel_RowName().excelRead(TestDataExcel,"Global",Functionality);
	    if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    {
	    //	value="winndixie";
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	zip=Readexcel_RowName.getValue("WD_ZIP");
	    	
	    	 		
	    }
	    else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    {
	    //	value="bi-lo";
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	zip=Readexcel_RowName.getValue("BL_ZIP");
	    }
	    else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	//value="harveyssupermarkets";
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	zip=Readexcel_RowName.getValue("HY_ZIP");
	    }
	    
		try
		{
			obj.waitForElementClickable(driver, homepage.click_Global_StoreLocator_Button);
			homepage.click_click_Global_StoreLocator_Button();
			obj.waitForElementClickable(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.movetoElementofAPage(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.waitForElementClickable(driver, storelocatorpage.click_Fuellocation_Button);
			storelocatorpage.click_click_Fuellocation_Button();
			obj.waitForElementClickable(driver, storelocatorpage.ddl_Radius_Dropdown);
			obj.movetoElementofAPage(driver, storelocatorpage.ddl_Radius_Dropdown);
			String rad=storelocatorpage.getValue_ddl_Radius_Dropdown();
			if(!rad.equals("10"))
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"defrad_err");
				driver.close();
				Assert.fail("Default radius is not 10");
			}
			obj.waitForElementClickable(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			storelocatorpage.click_txt_Enter_Zip_Or_City_Field();
			storelocatorpage.type_txt_Enter_Zip_Or_City_Field(zip);
			storelocatorpage.click_click_Search_Button();
			Thread.sleep(2000);
			obj.waitForElementClickable(driver, storelocatorpage.click_Fuel_Station_Webelement);
	
			List<WebElement> fs= storelocatorpage.click_Fuel_Station_List;
			int cnt = fs.size();
			
			if(cnt>=1)
			{
				Reporter.log("No. of fuel stations displayed is: "+cnt);
			}
			else
			{
				Assert.fail("NO stores found is displayed");
			}
		}
		catch(Exception e)
		{
			if(storelocatorpage.isDisplayed_txt_Invalid_store_text())
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"invalid_zip");
				driver.close();
				Assert.fail("Invalid zip code");
				storelocatorpage.click_click_Home_Button();	
			}
			else if( storelocatorpage.isDisplayed_txt_Invalid_zipcode_txt())
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"no_store");
				driver.close();
				Assert.fail("No stores found for the given zip code");
				storelocatorpage.click_click_Home_Button();
			}
		}
		return driver;
	}
	public WebDriver FuelPerk_CityState(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_StoreLocatorPage storelocatorpage = new POM_Generated_StoreLocatorPage(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		Data obj=new Data();
		String city="";
		//String value="";
		
		new Readexcel_RowName().excelRead(TestDataExcel,"Global",Functionality);
	    if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	city=Readexcel_RowName.getValue("WD_CITY");
	    	 		
	    }
	    else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	city=Readexcel_RowName.getValue("BL_CITY");
	    	
	    }
	    else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	city=Readexcel_RowName.getValue("HY_CITY");
	    	
	    } 
		try
		{
			obj.waitForElementClickable(driver, homepage.click_Global_StoreLocator_Button);
			homepage.click_click_Global_StoreLocator_Button();
			obj.waitForElementClickable(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.movetoElementofAPage(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.waitForElementClickable(driver, storelocatorpage.click_Fuellocation_Button);
			storelocatorpage.click_click_Fuellocation_Button();
			obj.waitForElementClickable(driver, storelocatorpage.ddl_Radius_Dropdown);
			obj.movetoElementofAPage(driver, storelocatorpage.ddl_Radius_Dropdown);
			String rad=storelocatorpage.getValue_ddl_Radius_Dropdown();
			if(!rad.equals("10"))
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"def_rad");
				driver.close();
				Assert.fail("Default radius is not 10");
			}
				
			obj.waitForElementClickable(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			storelocatorpage.click_txt_Enter_Zip_Or_City_Field();
			storelocatorpage.type_txt_Enter_Zip_Or_City_Field(city);
			storelocatorpage.click_click_Search_Button();
			Thread.sleep(2000);
			obj.waitForElementClickable(driver, storelocatorpage.click_Fuel_Station_Webelement);
	
			List<WebElement> fs= storelocatorpage.click_Fuel_Station_List;
			int cnt = fs.size();
			
			if(cnt>=1)
			{
				Reporter.log("No. of fuel stations displayed is: "+cnt);
			}
			else
			{
				Assert.fail("NO stores found is displayed");
			}
		
		}
		catch(Exception e)
		{
			if(storelocatorpage.isDisplayed_txt_Invalid_store_text())
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"invalid_city");
				driver.close();
				Assert.fail("Invalid city");
				storelocatorpage.click_click_Home_Button();	
			}
			else if( storelocatorpage.isDisplayed_txt_Invalid_zipcode_txt())
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"no_stores");
				driver.close();
				Assert.fail("No stores found for the given city");
				storelocatorpage.click_click_Home_Button();
			}
		}
		return driver;
	}
}	
		
		
		

