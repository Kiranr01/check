package computedClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.Reporter;

import Utility.Data;
import Utility.Readexcel_RowName;
import generatedClass.POM_Generated_Homepage;
import generatedClass.POM_Generated_ShoppingListPage;
import generatedClass.POM_Generated_WeeklyAdPage;

public class Computed_WeeklyAd 
{
	private String proddetails;
	private String prodvalu;
	private int count;
	String value="";
	Data obj=new Data();

	public WebDriver WeeklyAdPage(WebDriver driver,String TestDataExcel, String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		POM_Generated_WeeklyAdPage weeklyadpage = new POM_Generated_WeeklyAdPage(driver);
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		
		String url="";
		
		WebElement logo = null;
	    try
    	{
	    	new Readexcel_RowName().excelRead(TestDataExcel,"Global",Functionality);
	    	if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    	{  		
	    		value="winndixie";
	    		url="https://winndixie.pdn.retaileriq.com/weeklyad/storelocator/";
	    		logo= homepage.click_Winndixie_logo;
	    	}
	    	else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    	{
	    		
	    		value="bi-lo";
	    		url="https://bi-lo.pdn.retaileriq.com/weeklyad/storelocator/";
	    		logo = homepage.click_Bilo_logo;
	    	}
	    	else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    	{
	    		
	    		value="harveyssupermarkets";
	    		url="https://harveyssupermarkets.pdn.retaileriq.com/weeklyad/storelocator/";	
	    		logo = homepage.click_Harveys_logo;
	    	}
	    	String Weeklyadpopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/weeklyad/";	
	    	obj.waitForElementClickable(driver, logo);
	    	logo.click();
	    	obj.PageNavigation(driver, Weeklyadpopup);
	    	obj.waitForElementClickable(driver, logo);
	    	logo.click();
    		obj.waitForElementClickable(driver, homepage.click_Savings_link_Hover);
    		homepage.click_click_Savings_link_Hover();		
    		obj.movetoElementofAPage_Click(driver, homepage.click_Savings_WeeklyAd_Button);
    		obj.waitForElement(driver, shoppinglistpage.txt_List_Count_Text);
    		if(driver.getCurrentUrl().equalsIgnoreCase(url))
    		{
    			new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
    			String Store_Zip = Readexcel_RowName.getValue("Store_Zip");
    			//obj.waitForElement(driver, weeklyadpage.txt_Select_Store_Field);
    			Thread.sleep(2000);
    			if(weeklyadpage.isDisplayed_click_Locate_A_store_Near_You_Button())
    			{
    				Reporter.log("Locate a store near you button is displayed");
    			}
    			else
    			{
    				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_StoreNear");
    				Assert.fail("Locate a store near you button is not displayed");
    			}
    			if(weeklyadpage.isDisplayed_txt_Please_Select_A_Store_Text())
    			{
    				Reporter.log("Please select a store near to view weekly ads text is displayed");
    			}
    			else
    			{
    				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_store");
    				Assert.fail("Please select a store near to view weekly ads text is not displayed");
    			}	
    			weeklyadpage.type_txt_Select_Store_Field(Store_Zip);
    			weeklyadpage.click_click_Store_Search_Button();
    			Thread.sleep(2000);
    			weeklyadpage.click_click_Store_View_weeklyAds_Button();
    			Thread.sleep(2000);
    			
    		}	
    		Thread.sleep(2000);
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
    		
    		obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_WeeklyAd Page");
    		//driver.close();
    		System.out.println(e);
    		Assert.fail("Error in Weekly Ad page");
		}		    
	    return driver; 
	}
	
	
	public WebDriver AddProduct(WebDriver driver,String TestDataExcel,String Functionality,String TCName, String proddetails,int count,String prodvalu,String addpage) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_WeeklyAdPage weeklyadpage = new POM_Generated_WeeklyAdPage(driver);
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		Data obj=new Data();
		String description="";
		List<WebElement> products=null;	
		try
		{
			obj.waitForElement(driver, weeklyadpage.click_Product_Webelement_Text);		
			products=  weeklyadpage.click_Product_List_Text;
			int totprdcnt=products.size();
			
			String cont=shoppinglistpage.getText_txt_List_Count_Text();
			count=Integer.parseInt(cont);
			
			outerloop:
			for (int l=0;l<totprdcnt;l++)
			{			
				try
				{	
					
					obj.movetoElementofAPage(driver, products.get(l));
					Thread.sleep(1000);
					boolean b=weeklyadpage.isDisplayed_click_Product_AddToList_Button();
					if(b==true)
					{	
						proddetails=products.get(l).getText().replace(".", "");
						proddetails=proddetails.replace("/", "");
						proddetails=proddetails.replace(" - opens dialog", "");	
						Thread.sleep(1000);
						if(addpage.equalsIgnoreCase("circularpage"))
						{
							weeklyadpage.click_click_Product_AddToList_Button();
							
							obj.waitForElement(driver, weeklyadpage.click_Product_RemoveFromList_Button);
							
							weeklyadpage.click_click_Product_view_Deals_Button();
							
							
						}
						else if(addpage.equalsIgnoreCase("overlay"))
						{
							
							weeklyadpage.click_click_Product_view_Deals_Button();
							obj.waitForElement(driver, weeklyadpage.click_Product_Overlay_Close_Button);	
							
							weeklyadpage.click_click_Product_AddToList_Overlay_Button();
							
						}
						obj.waitForElement(driver, weeklyadpage.click_Product_RemoveFromList_Overlay_Button);		
						
						try
						{
							description=weeklyadpage.getText_txt_Product_Description_Text();
							description=description.replace(".", "");
							description=description.replace("/", "");	
						}
						catch(Exception e)
						{
							description="";
						}
						
						prodvalu=weeklyadpage.click_Product_RemoveFromList_Overlay_Button.getAttribute("productkey");
						
						weeklyadpage.click_click_Product_Overlay_Close_Button();
						Thread.sleep(1000);
						String color = products.get(l).getCssValue("border-color");
						String hex = Color.fromString(color).asHex();
						if(hex.equalsIgnoreCase("#ff0000"))
						{
							Reporter.log("Added products are highlighted in Red color");
						}
						else
						{
							obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_notred");
							Assert.fail("Added products are not highlighted in Red color");
						}
						count=count+1;
						Reporter.log("Product added from overlay page");
						this.count=count;
						this.proddetails=proddetails+" "+description;
						this.prodvalu=prodvalu;
						break outerloop;
					}	
				}
				catch(NoSuchElementException e)
				{
						
				}
			}	
		}		
		catch(Exception e)
		{	
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_WeeklyAdCircular");
			System.out.println(e);
			//driver.close();
			Assert.fail("Error in weekly ad circular page");
		}	
		return driver;
	}
	
	public WebDriver AddAgain(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String prodvalu) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_WeeklyAdPage weeklyadpage = new POM_Generated_WeeklyAdPage(driver);
		
		Data obj=new Data();
			
		try
		{
			obj.waitForElement(driver, weeklyadpage.click_Product_Webelement_Text);		
			
		
			WebElement wel=driver.findElement(By.xpath("//product[@key='"+prodvalu+"']"));
			
			Actions action1=new Actions(driver); 
			action1.moveToElement(wel).build().perform();
			Thread.sleep(1000);
			try
			{
				if(weeklyadpage.isDisplayed_click_Product_view_Deals_Button())
				{
					//driver.close();	
					Reporter.log("View Deals Button is displayed");	
					weeklyadpage.click_click_Product_view_Deals_Button();
					try
					{
						obj.waitForElement(driver, weeklyadpage.click_Product_Overlay_Close_Button);
						if(weeklyadpage.isDisplayed_click_Product_RemoveFromList_Overlay_Button())
						{
							
							Reporter.log("Items added once cannot add the same item again in overlay as expected");
						}
						
						weeklyadpage.click_click_Product_Overlay_Close_Button();
					}
					catch(Exception e2)
					{
						obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_SoftLoginFailed");
						weeklyadpage.click_click_Product_Overlay_Close_Button();
						Assert.fail("Items added is still displaying as Add to list instead Remove from list in overlay");
					}
				}
				else
				{
					obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_SoftLoginFailed");
					weeklyadpage.click_click_Product_Overlay_Close_Button();
					Assert.fail("View Deals Button is displayed");	
					
				}	
				action1.moveToElement(wel).build().perform();
				Thread.sleep(1000);
				if(weeklyadpage.isDisplayed_click_Product_RemoveFromList_Button())
				{		
					Reporter.log("Items added once cannot add the same item again as expected");	
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_SoftLoginFailed");
					Assert.fail("Items added is still displaying as Add to list instead Remove from list");				
				}
			}
			catch(NoSuchElementException e1)
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_SoftLoginFailed");
				Assert.fail("Items added is still displaying as Add to list instead Remove from list");	
			}
		}
		
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_Add Product again");
			System.out.println(e);
			//driver.close();
			Assert.fail("Un Expected Error in Add again product");
		}
		return driver;
	}
			
			
	public WebDriver Removeproduct(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String proddetails,int count,String removepage) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_WeeklyAdPage weeklyadpage = new POM_Generated_WeeklyAdPage(driver);
		POM_Generated_ShoppingListPage shoppinglist = new POM_Generated_ShoppingListPage(driver);
		Data obj=new Data();
		String description="";
		List<WebElement> products=null;
		try
		{
			obj.waitForElement(driver,weeklyadpage.click_Product_Webelement_Text);
			products= weeklyadpage.click_Product_List_Text;
			int totprdcnt=products.size();
			String cont=shoppinglist.getText_txt_List_Count_Text();
			count=Integer.parseInt(cont);
			
			outerloop:
			for (int l=0;l<totprdcnt;l++)
			{
				Actions action1=new Actions(driver); 
				action1.moveToElement(products.get(l)).build().perform();
				
				Thread.sleep(1000);
				try
				{
					
					boolean b=weeklyadpage.isDisplayed_click_Product_RemoveFromList_Button();
					
					if(b==true)
					{
						proddetails=products.get(l).getText().replace(".", "");
						proddetails=proddetails.replace("/", "");
						proddetails=proddetails.replace(" - opens dialog", "");
						
						Thread.sleep(1000);
						String color = products.get(l).getCssValue("border-color");
						String hex = Color.fromString(color).asHex();
						if(hex.equalsIgnoreCase("#ff0000"))
						{
							Reporter.log("Added products are highlighted in Red color");
						}
						else
						{
							obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_productcolorerr");
							Assert.fail("Added products are not highlighted in Red color");
						}
					
						if(removepage.equalsIgnoreCase("circularpage"))
						{
							weeklyadpage.click_click_Product_RemoveFromList_Button();
							obj.waitForElement(driver, weeklyadpage.click_Product_AddToList_Button);
							weeklyadpage.click_click_Product_view_Deals_Button();
							obj.waitForElement(driver, weeklyadpage.click_Product_Overlay_Close_Button);
							
						}
						else if(removepage.equalsIgnoreCase("overlay"))
						{
							
							weeklyadpage.click_click_Product_view_Deals_Button();
							obj.waitForElement(driver, weeklyadpage.click_Product_Overlay_Close_Button);
							weeklyadpage.click_click_Product_RemoveFromList_Overlay_Button();
							
						}
						obj.waitForElement(driver, weeklyadpage.click_Product_AddToList_Overlay_Button);
						try
						{
							description=weeklyadpage.getText_txt_Product_Description_Text();
							description=description.replace(".", "");
							description=description.replace("/", "");
						}
	    				catch(Exception e)
	    				{
	    					description="";
	    				}
					
						weeklyadpage.click_click_Product_Overlay_Close_Button();
						count=count-1;
						this.count=count;
						this.proddetails=proddetails+" "+description;
						break outerloop;
					}
				}
				catch(NoSuchElementException e)
				{
					
				}
			}
		}
		catch(Exception e)
	    {
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_WeeklyAd page");
			System.out.println(e);
			//driver.close();
			Assert.fail("Error in Weekly Ad page or remove from list");
	    }		
		return driver;		
	}
	
	public WebDriver RemoveAgain(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String prodvalu) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_WeeklyAdPage weeklyadpage = new POM_Generated_WeeklyAdPage(driver);
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		Data obj=new Data();
			
		try
		{
			Thread.sleep(1000);
			obj.waitForElement(driver, weeklyadpage.click_Product_Webelement_Text);		
			
			String cont=shoppinglistpage.getText_txt_List_Count_Text();
			count=Integer.parseInt(cont);
			WebElement wel=driver.findElement(By.xpath("//product[@key='"+prodvalu+"']"));
			System.out.println(wel);
			obj.movetoElementofAPage(driver, wel);
			Thread.sleep(2000);
			try
			{
				
				if(weeklyadpage.isDisplayed_click_Product_view_Deals_Button())
				{
					Reporter.log("View Deals Button is displayed");	
					weeklyadpage.click_click_Product_view_Deals_Button();
					try
					{
						obj.waitForElement(driver, weeklyadpage.click_Product_Overlay_Close_Button);
						if(weeklyadpage.isDisplayed_click_Product_AddToList_Overlay_Button())
						{
							Reporter.log("Items removed once cannot remove the same item again in overlay as expected");
						}
						weeklyadpage.click_click_Product_Overlay_Close_Button();
					}
					catch(Exception e2)
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_SoftLoginFailed");
						Assert.fail("Items Removed is still displaying as Remove from list instead Add to list in overlay");
					}
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_SoftLoginFailed");
					Assert.fail("View Deals Button is not displayed");		
					
				}	
				obj.movetoElementofAPage(driver, wel);
				Thread.sleep(1000);
				if(weeklyadpage.isDisplayed_click_Product_AddToList_Button())
				{		
					Reporter.log("Items Removed once cannot remove the same item again as expected");	
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_SoftLoginFailed");
					Assert.fail("Items Removed is still displaying as Remove from list instead Add to list");					
				}
			}
			catch(NoSuchElementException e1)
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_SoftLoginFailed");
				Assert.fail("Items Removed is still displaying as Remove from list instead Add to list");	
			}
		}
		
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_SoftLoginFailed");
			driver.close();
			Assert.fail("Un Expected Error in Remove again product");
		}
		return driver;
	}
	
	public String getproddetails() 
	{
		return proddetails;
	}
	public int getcount() 
	{
		return count;
	}
	
	public String getprodvalu() 
	{
		return prodvalu;
	}

}
