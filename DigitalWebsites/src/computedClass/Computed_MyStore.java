package computedClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import Utility.Data;
import Utility.Readexcel_RowName;
import generatedClass.POM_Generated_Homepage;
import generatedClass.POM_Generated_StaticInfoBar;
import generatedClass.POM_Generated_StoreLocatorPage;
import generatedClass.POM_Generated_WeeklyAdPage;

public class Computed_MyStore 
{
	Data obj=new Data();
	public WebDriver SetStore(WebDriver driver,String TestDataExcel, String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_StaticInfoBar staticInfoBar = new POM_Generated_StaticInfoBar(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		
		String Global="Global";
		WebElement logo =null;
		
	    new Readexcel_RowName().excelRead(TestDataExcel,Global,Functionality);
	    
	    if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Winndixie_logo;
		}
		if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Bilo_logo;
		}
		if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Harveys_logo;
		}
		
		
		try
		{	
			System.out.println("setstore");
			obj.waitForElementClickable(driver, logo);
			logo.click();
			obj.waitForElementClickable(driver, staticInfoBar.click_Static_info_My_Account_Link);
			obj.waitForElement(driver, staticInfoBar.click_Static_info_WeeklyAds_Text);
			try
			{
				if(staticInfoBar.isDisplayed_click_Static_info_MyStore_Link())
				{	
					
					if(staticInfoBar.isDisplayed_click_Static_info_MyStore_Address_Text())
					{	
						Reporter.log("Mystore address text is displaying");
					}
					else
					{
						obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName, "err_mystoreadd");
						Assert.fail("Mystore address text is not displaying");
					}
					obj.waitForElementClickable(driver, staticInfoBar.click_Static_info_MyStore_Change_Link);
					staticInfoBar.click_click_Static_info_MyStore_Change_Link();
				}
				else
				{
					System.out.println("my store link not displayed");
				}
				
			}
			catch(Exception e)
			{
				try
				{
					if(staticInfoBar.isDisplayed_click_Static_info_Set_Store_Link())
					{	
						obj.waitForElement(driver, staticInfoBar.click_Static_info_Set_Store_Text);
						if(staticInfoBar.isDisplayed_click_Static_info_Set_Store_Text())
						{	
							Reporter.log("Please Set store text is displaying");
						}
						else
						{
							obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName, "err_nomsg");
							Assert.fail("Please set the store text is not displaying");
						}
						obj.waitForElementClickable(driver, staticInfoBar.click_Static_info_Set_Store_Link);
						staticInfoBar.click_click_Static_info_Set_Store_Link();
					}
					else
					{
						System.out.println("set store link not displayed");
					}
				}
				catch(Exception ee)
				{
					if(staticInfoBar.isDisplayed_click_Static_info_MyStore_Nearest_store_link())
					{	
						staticInfoBar.click_click_Static_info_MyStore_Nearest_store_link();
					}
					else
					{
						System.out.println("nearest store link not displayed");	
					}
				}
			}
		}
		catch (Exception e1)
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName, "err_nolinks");
			driver.close();
			Assert.fail("Store links are not displayed");
		}	
		System.out.println("setstore done");
		return driver;
	}
	
	public WebDriver StoreLocatorValidation(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException
	{
		POM_Generated_StoreLocatorPage storelocatorpage = new POM_Generated_StoreLocatorPage(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		//Data obj=new Data();
		try
		{	
			obj.waitForElementClickable(driver, homepage.click_Global_StoreLocator_Button);
			homepage.click_click_Global_StoreLocator_Button();
			obj.scrollingToElementofAPage(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.waitForElement(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			
			if( storelocatorpage.isDisplayed_txt_Enter_Zip_Or_City_Field())
			{
				Reporter.log("Textbox is displayed");	
			}
			else
			{
				 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_notext");     
				Assert.fail("Textbox is not displayed");
			}
				
			if(storelocatorpage.isDisplayed_click_Search_Button())
			{
				Reporter.log("Search button is present");
				
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nosearch");
				Assert.fail("Search button is not present");
			}
		}
		catch(NoSuchElementException e)
		{
			 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nav");
			Assert.fail("Error in navigation to store locator page");
		}
		return driver;
		
	}
	public WebDriver StoreLocator_Zipcode(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException
	{
		POM_Generated_StoreLocatorPage storelocatorpage = new POM_Generated_StoreLocatorPage(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		POM_Generated_WeeklyAdPage weeklyadpage = new POM_Generated_WeeklyAdPage(driver);
		List<WebElement> Weeklyad=null;
		String value="";
		String zip="";
		WebElement logo = null;
		
		new Readexcel_RowName().excelRead(TestDataExcel,"Global",Functionality);
	    if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	value="winndixie";
	    	logo=homepage.click_Winndixie_logo;
	    	 		
	    }
	    else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	value="bi-lo";
	    	logo=homepage.click_Bilo_logo;
	    }
	    else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	value="harveyssupermarkets";
	    	logo=homepage.click_Harveys_logo;
	    }
	    String Weeklyadpopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/weeklyad/";
		
		
		if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    {
			new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	zip=Readexcel_RowName.getValue("WD_ZIP"); 		
	    }
	    else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	zip=Readexcel_RowName.getValue("BL_ZIP");
	    	
	    }
	    else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	zip=Readexcel_RowName.getValue("HY_ZIP");	
	    } 
		
		try
		{	
			obj.waitForElementClickable(driver, logo);
	    	logo.click();
	    	obj.PageNavigation(driver, Weeklyadpopup);
			obj.waitForElementClickable(driver, homepage.click_Global_StoreLocator_Button);
			homepage.click_click_Global_StoreLocator_Button();
			obj.scrollingToElementofAPage(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.waitForElement(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.waitForElementClickable(driver, storelocatorpage.click_Storelocation_Button);
			storelocatorpage.click_click_Storelocation_Button();
				
			storelocatorpage.click_txt_Enter_Zip_Or_City_Field();
			storelocatorpage.type_txt_Enter_Zip_Or_City_Field(zip);
			storelocatorpage.click_click_Search_Button();
			try
			{
				obj.waitForElementClickable(driver, storelocatorpage.click_Weekly_Ad_Link_Webelement);
				Weeklyad = storelocatorpage.click_Weekly_Ad_Link_List;
				
				obj.movetoElementofAPage_Click(driver,Weeklyad.get(0));
				
				Thread.sleep(2000);
				if(weeklyadpage.isDisplayed_txt_Your_WeeklyAd_Text())
				{
					obj.movetoElementofAPage_Click(driver, weeklyadpage.click_View_weeklyAd_Link);	
					Thread.sleep(3000);
				}
	    		else
	    		{
	    			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_WeeklyAdTextError");
	    			driver.close();
	    			Assert.fail("Error in Your WeeklyAd text");
	    		}
			}
			catch(Exception e)
			{
				try
				{
					if(storelocatorpage.isDisplayed_txt_Invalid_store_text())
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"invalid_zip");
						driver.close();
						Assert.fail("Invalid zipcode");
						storelocatorpage.click_click_Home_Button();	
					}
					else if( storelocatorpage.isDisplayed_txt_Invalid_zipcode_txt())
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
						driver.close();
						Assert.fail("No stores found for the given zip code");
						storelocatorpage.click_click_Home_Button();
					}
					else
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
						driver.close();
						Assert.fail("error in locating stores or adding stores");
					}
				}
				catch(Exception ee)
				{
					obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
					driver.close();
					Assert.fail("error in locating stores or adding stores");
				}
			}
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostores");
			Assert.fail("error in locating stores");
		}
		
		return driver;
		
	}
	
	public WebDriver StoreLocator_CityState(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException
	{
		POM_Generated_StoreLocatorPage storelocatorpage = new POM_Generated_StoreLocatorPage(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		POM_Generated_WeeklyAdPage weeklyadpage = new POM_Generated_WeeklyAdPage(driver);
		List<WebElement> Weeklyad=null;
		//Data obj=new Data();
		String value="";
		String city="";
		WebElement logo = null;
		new Readexcel_RowName().excelRead(TestDataExcel,"Global",Functionality);
	    if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	value="winndixie";
	    	logo=homepage.click_Winndixie_logo;
	    	 		
	    }
	    else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	value="bi-lo";
	    	logo=homepage.click_Bilo_logo;
	    }
	    else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	value="harveyssupermarkets";
	    	logo=homepage.click_Harveys_logo;
	    }
	    String Weeklyadpopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/weeklyad/";
		
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
			obj.waitForElementClickable(driver, logo);
	    	logo.click();
	    	obj.PageNavigation(driver, Weeklyadpopup);
			obj.waitForElementClickable(driver, homepage.click_Global_StoreLocator_Button);
			homepage.click_click_Global_StoreLocator_Button();
			obj.scrollingToElementofAPage(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.waitForElementClickable(driver, storelocatorpage.click_Storelocation_Button);
			storelocatorpage.click_click_Storelocation_Button();
			storelocatorpage.click_txt_Enter_Zip_Or_City_Field();
			storelocatorpage.type_txt_Enter_Zip_Or_City_Field(city);
			storelocatorpage.click_click_Search_Button();
			try
			{
				obj.waitForElementClickable(driver, storelocatorpage.click_Weekly_Ad_Link_Webelement);
				Weeklyad = storelocatorpage.click_Weekly_Ad_Link_List;
				
				Weeklyad.get(0).click();			
				if(weeklyadpage.isDisplayed_txt_Your_WeeklyAd_Text())
				{
					obj.movetoElementofAPage_Click(driver, weeklyadpage.click_View_weeklyAd_Link);	
				}
	    		else
	    		{
	    			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_WeeklyAdTextError");
	    			driver.close();
	    			Assert.fail("Error in Your WeeklyAd text");
	    		}
					
			}
			catch(Exception e)
			{
				if(storelocatorpage.isDisplayed_txt_Invalid_store_text())
				{
					 obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"invalid_city");
					driver.close();
					Assert.fail("Invalid City");
					storelocatorpage.click_click_Home_Button();	
				}
				else if( storelocatorpage.isDisplayed_txt_Invalid_zipcode_txt())
				{
					 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
						driver.close();
						Assert.fail("No stores found for entered city ");
						storelocatorpage.click_click_Home_Button();
				}
			}

		}
		catch(Exception e)
		{
			 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
			Assert.fail("error in locating stores");
		}
		
		return driver;
		
	}
	
	public WebDriver SetStore_ChangeLocation(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_StoreLocatorPage storelocatorpage = new POM_Generated_StoreLocatorPage(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
	
		List<WebElement> makemystore=null;
		List<WebElement> viewdetails=null;
		
		try
		{
			obj.waitForElementClickable(driver, homepage.click_Global_StoreLocator_Button);
			homepage.click_click_Global_StoreLocator_Button();
			
			obj.scrollingToElementofAPage(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			obj.waitForElement(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
			new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
			if(Readexcel_RowName.getValue("Change_Zipcode")!=null)
			{
				storelocatorpage.click_click_Storelocation_Button();
				obj.waitForElementClickable(driver, storelocatorpage.click_Storelocation_Button);
				obj.scrollingToElementofAPage(driver, storelocatorpage.ddl_Radius_Dropdown);
				String rad=storelocatorpage.getValue_ddl_Radius_Dropdown();
				if(!rad.equals("10 miles"))
				{
					 obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_defrad");
					driver.close();
					Assert.fail("Default radius is not 10");
				}
				storelocatorpage.type_txt_Enter_Zip_Or_City_Field(Readexcel_RowName.getValue("Change_Zipcode"));
				storelocatorpage.click_click_Search_Button();
				obj.waitForElementClickable(driver, storelocatorpage.click_Storelocation_Button);
				obj.movetoElementofAPage(driver, storelocatorpage.click_Make_My_store_Button_Webelement);
				try 
				{
					makemystore =storelocatorpage.click_Make_My_store_Button_List;
					makemystore.get(0).click();
					obj.waitForElementClickable(driver, storelocatorpage.click_Storelocation_Button);
					obj.movetoElementofAPage(driver, storelocatorpage.click_View_Store_Details_Button_Webelement);
					viewdetails=storelocatorpage.click_View_Store_Details_Button_List;
					viewdetails.get(0).click();
					obj.waitForElementClickable(driver, storelocatorpage.click_Home_Button);
					String sdetails=storelocatorpage.getText_txt_StreetAddr_Text();
					storelocatorpage.click_click_Home_Button();
					obj.waitForElement(driver, storelocatorpage.txt_StreetAddr_Text);
					String addr=storelocatorpage.getText_txt_StreetAddr_Text();
					if(!sdetails.equals(addr))
					{
						 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_add");
						driver.close();
						Assert.fail("Store address not changed");
					}
				}
				catch(NoSuchElementException e) 
				{
					try
					{
						if(	storelocatorpage.isDisplayed_click_Invalid_Store_Error_Text())
						{
							obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
							driver.close();
							Assert.fail("No stores found");
							storelocatorpage.click_click_Home_Button();
						}
						else	
						{
							obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
							driver.close();
							Assert.fail("No stores found error message is not displaying");
							storelocatorpage.click_click_Home_Button();
						}
					}
					catch (NoSuchElementException e1)
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
						driver.close();
						Assert.fail("No stores found error message is not displaying");
						storelocatorpage.click_click_Home_Button();
					}
				}		
			}
			else
			{
				storelocatorpage.click_click_Home_Button();
			}
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_store");
			driver.close();
			Assert.fail("Error in my store page");
		}
		
		
		return driver;
	}
	public WebDriver SetStore_InvalidZip(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException
	{
		POM_Generated_StoreLocatorPage storelocatorpage = new POM_Generated_StoreLocatorPage(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		String invalid_zip="";
	//	WebElement logo = null;
		//Data obj=new Data();
		
		new Readexcel_RowName().excelRead(TestDataExcel,"Global",Functionality);
    	
    	
    	if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    {
    		new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
    		invalid_zip=Readexcel_RowName.getValue("WD_INVALID_ZIP");
	    	System.out.println(invalid_zip);
	    	 		
	    }
	    else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	invalid_zip=Readexcel_RowName.getValue("BL_INVALID_ZIP");
	    	
	    }
	    else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    {
	    	new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
	    	invalid_zip=Readexcel_RowName.getValue("HV_INVALID_ZIP");
	    	
	    } 

		obj.waitForElementClickable(driver, homepage.click_Global_StoreLocator_Button);
		homepage.click_click_Global_StoreLocator_Button();
		obj.scrollingToElementofAPage(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
		obj.waitForElement(driver, storelocatorpage.txt_Enter_Zip_Or_City_Field);
		try
		{
			String Error_Msg;
			
			new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Invalid_Zip_error_msg");
			Error_Msg= Readexcel_RowName.getValue("Error_Message");

			obj.waitForElementClickable(driver, storelocatorpage.click_Storelocation_Button);
			storelocatorpage.click_click_Storelocation_Button();
			storelocatorpage.click_txt_Enter_Zip_Or_City_Field();
			storelocatorpage.type_txt_Enter_Zip_Or_City_Field(invalid_zip);
			storelocatorpage.click_click_Search_Button();
			if(storelocatorpage.isDisplayed_txt_Invalid_zipcode_txt())
			{
				if(Error_Msg.equals(storelocatorpage.getText_txt_Invalid_zipcode_txt()))
				{
					Reporter.log("Error message is displayed:" +storelocatorpage.getText_txt_Invalid_zipcode_txt());
				}
				else
				{
					obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_invaliderr");
					Assert.fail("Displayed error message is not as expected:" +storelocatorpage.getText_txt_Invalid_zipcode_txt());
				}
				}
			else
			{
				 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
				Assert.fail("Error message is not displayed");
			}
				
		}
		catch(Exception e)
		{
			 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nostore");
			Assert.fail("Error in store locating page");
		}
		
		return driver;
	
	}
				
}
