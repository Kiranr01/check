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
import generatedClass.POM_Generated_DigitalCouponsPage;
import generatedClass.POM_Generated_HardLoginPage;
import generatedClass.POM_Generated_Homepage;
import generatedClass.POM_Generated_ShoppingListPage;


public class Computed_Digital_Coupons 
{
	private String prod;
	private int count;
	Data obj=new Data();
	
	public WebDriver Loggedout_Coupons_Link(WebDriver driver, String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_Homepage homepage=new POM_Generated_Homepage(driver);
		POM_Generated_DigitalCouponsPage couponspage= new POM_Generated_DigitalCouponsPage(driver);
		POM_Generated_HardLoginPage hardloginpage = new POM_Generated_HardLoginPage(driver);		
		WebElement logo = null;		
		boolean aa=true; 	
		String value="";
		
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
    	String couponspopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/coupons/";
	    
		
		try
		{
			
	        obj.waitForElementClickable(driver, logo);
			logo.click();
			obj.PageNavigation(driver, couponspopup);
			obj.waitForElementClickable(driver, logo);
			logo.click();
			obj.waitForElementClickable(driver, homepage.click_Savings_link_Hover);	
			
			homepage.click_click_Savings_link_Hover();
			obj.waitForElementClickable(driver, homepage.click_Savings_Coupon_Button);
			homepage.click_click_Savings_Coupon_Button();
			
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			couponspage.click_click_Digital_Coupon_page_Link();
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			Thread.sleep(1000);
		
			List<WebElement> buttons= couponspage.click_Digital_Coupon_Add_Button;
			int sizee=buttons.size();
			for(int n=1;n<sizee;n++)
			{
				if(aa==true)
				{
					if(buttons.get(n).isDisplayed())
					{	
						obj.scrollingToElementofAPage(driver, buttons.get(n));
						buttons.get(n).click();	
						aa=false;		
					}
				}	
			}
			try
			{
			obj.movetoElementofAPage(driver, homepage.click_HardLogin_button);
			obj.waitForElementClickable(driver, homepage.click_HardLogin_button);
			homepage.click_click_HardLogin_button();
			obj.waitForElementClickable(driver, hardloginpage.click_Popup_Close_Button);
			hardloginpage.click_click_Popup_Close_Button();	
			}
			catch(Exception el)
			{
				obj.waitForElementClickable(driver, hardloginpage.click_Popup_Close_Button);
				hardloginpage.click_click_Popup_Close_Button();	
			}
		}
		catch(Exception e)
		{
			
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName, "LogoutCoupPage_Link");
			driver.close();
			Assert.fail("Error in Digital coupons page");			
		}	
		return driver;				
	}
	
	public WebDriver Loggedout_Coupons_Homepage(WebDriver driver,String TestDataExcel, String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_Homepage homepage=new POM_Generated_Homepage(driver);
		POM_Generated_DigitalCouponsPage couponspage= new POM_Generated_DigitalCouponsPage(driver);
		POM_Generated_HardLoginPage hardloginpage = new POM_Generated_HardLoginPage(driver);
		WebElement logo = null;		
		boolean aa=true; 	
		String value="";
		
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
    	String couponspopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/coupons/";
	   
		
		try
		{
			
			obj.waitForElementClickable(driver, logo);
			logo.click();
			obj.PageNavigation(driver, couponspopup);
			obj.waitForElementClickable(driver, logo);
			logo.click();
			homepage.click_click_Digitial_Coupons_Logo();
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			couponspage.click_click_Digital_Coupon_page_Link();
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			Thread.sleep(1000);
			List<WebElement> buttons= couponspage.click_Digital_Coupon_Add_Button;
			int sizee=buttons.size();
			for(int n=1;n<sizee;n++)
			{
				if(aa==true)
				{
                    obj.waitForElementClickable(driver,buttons.get(n));
					obj.movetoElementofAPage(driver, buttons.get(n));
					if(buttons.get(n).isDisplayed())
					{	
						obj.movetoElementofAPage(driver, buttons.get(n));
						buttons.get(n).click();	
						aa=false;		
					}
				}	
			}
			
			Thread.sleep(2000);
			obj.movetoElementofAPage_Click(driver, homepage.click_HardLogin_button);
			obj.waitForElementClickable(driver, hardloginpage.click_Popup_Close_Button);
			hardloginpage.click_click_Popup_Close_Button();	
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName, "LogoutCoupHomePage");
			driver.close();	
			System.out.println(e);
			Assert.fail("Error in Digital coupons page");
			
		}	
		return driver;	
			
	}
	
	public WebDriver Loggedin_Coupons_Link(WebDriver driver, String TestDataExcel,String Functionality,String TCName,String prod,int count) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_Homepage homepage=new POM_Generated_Homepage(driver);
		POM_Generated_DigitalCouponsPage couponspage= new POM_Generated_DigitalCouponsPage(driver);
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		String cont = null;
		WebElement logo = null;		
		boolean aa=true; 	
		String value="";
	
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
    	String couponspopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/coupons/";
	    
		try
		{
			//To handle window pop up Authentication				
			
			Thread.sleep(2000);
			obj.movetoElementofAPage_Click(driver, logo);
			obj.PageNavigation(driver, couponspopup);
			obj.waitForElementClickable(driver, logo);
			obj.movetoElementofAPage_Click(driver, logo);
			obj.waitForElementClickable(driver, homepage.click_Savings_link_Hover);		
			
			homepage.click_click_Savings_link_Hover();
			obj.waitForElementClickable(driver, homepage.click_Savings_Coupon_Button);
			homepage.click_click_Savings_Coupon_Button();
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			couponspage.click_click_Digital_Coupon_page_Link();
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			List<WebElement> buttons= couponspage.click_Digital_Coupon_Add_Button;
			List<WebElement> prodsummary=couponspage.txt_Digital_Coupon_Prod_summary_Text;
			List<WebElement> proddesc=couponspage.txt_Digital_Coupon_Prod_Desc_Text;
			int sizee=buttons.size();
				
			for(int n=1;n<sizee;n++)
			{
				if(aa==true)
				{
					if(buttons.get(n).isDisplayed())
					{		
						cont=shoppinglistpage.getText_txt_List_Count_Text();
						count = Integer.parseInt(cont);						
						prod=prodsummary.get(n).getText()+" "+proddesc.get(n).getText();
						buttons.get(n).click();						
						try
						{
							if(couponspage.isDisplayed_click_Digital_Coupon_Paypal_Popup_Close_Button())
							{
								couponspage.click_click_Digital_Coupon_Paypal_Popup_Close_Button();
							}
							else
							{
								this.prod=prod;
								count=count+1;
								System.out.println("count--"+count);
								this.count=count;
								aa=false;
							}
						}
						catch(NoSuchElementException e1)
						{
							this.prod=prod;
							count=count+1;
							System.out.println("count--"+count);
							this.count=count;
							aa=false;
						}
					}
				}
			}
			
			Thread.sleep(1000);
			//obj.waitForElement(driver, couponspage.click_Digital_Coupon_Activated_Coupon_Icon);
			
			if(couponspage.isEnabled_click_Digital_Coupon_Activated_Coupon_Icon())
			{
				Reporter.log("Coupons added and changed to tick mark");
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName, "TickMarkNotCngd");
				Assert.fail("Coupons added and not changed to tick mark");
			}

			obj.waitForElement(driver, shoppinglistpage.txt_List_Count_Text);
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName, "LoginCoupLink_Page");
			System.out.println(e);
			//driver.close();
			Assert.fail("Error in Digital coupons page");
			
		}	
		return driver;			
	}
	
	public WebDriver Loggedin_Coupons_Homepage(WebDriver driver,String TestDataExcel, String Functionality,String TCName,String prod,int count) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_Homepage homepage=new POM_Generated_Homepage(driver);
		POM_Generated_DigitalCouponsPage couponspage= new POM_Generated_DigitalCouponsPage(driver);
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		String cont = null;
		WebElement logo = null;		
		boolean aa=true; 	
		String value="";
	    
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
    	String couponspopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/coupons/";
	   
		
		try
		{
			//To handle window pop up Authentication				
			
			obj.waitForElementClickable(driver, logo);	
			logo.click();
			obj.PageNavigation(driver, couponspopup);
			obj.waitForElementClickable(driver, logo);			
			logo.click();		
			Thread.sleep(2000);
			obj.movetoElementofAPage_Click(driver, homepage.click_Digitial_Coupons_Logo);
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			couponspage.click_click_Digital_Coupon_page_Link();
			obj.waitForElementClickable(driver, couponspage.click_Digital_Coupon_page_Link);
			Thread.sleep(1000);
		
			List<WebElement> buttons= couponspage.click_Digital_Coupon_Add_Button;
			List<WebElement> prodsummary=couponspage.txt_Digital_Coupon_Prod_summary_Text;
			List<WebElement> proddesc=couponspage.txt_Digital_Coupon_Prod_Desc_Text;
			int sizee=buttons.size();
				
			for(int n=1;n<sizee;n++)
			{
				if(aa==true)
				{
					if(buttons.get(n).isDisplayed())
					{	
		  					
						cont=shoppinglistpage.getText_txt_List_Count_Text();
						count = Integer.parseInt(cont);					
						prod=prodsummary.get(n).getText()+" "+proddesc.get(n).getText();					
						obj.scrollingToElementofAPage(driver, buttons.get(n));
						buttons.get(n).click();
						try
						{
							if(couponspage.isDisplayed_click_Digital_Coupon_Paypal_Popup_Close_Button())
							{
								couponspage.click_click_Digital_Coupon_Paypal_Popup_Close_Button();
							}
							else
							{
								this.prod=prod;
								count=count+1;
								this.count=count;
								aa=false;
							}
						}
						catch(NoSuchElementException e1)
						{
							aa=false;
						}
		  			}
		  		}
		  	}
			Thread.sleep(1000);
			//obj.waitForElement(driver, couponspage.click_Digital_Coupon_Activated_Coupon_Icon);
			
			if(couponspage.isEnabled_click_Digital_Coupon_Activated_Coupon_Icon())
			{
				Reporter.log("Coupons added and changed to tick mark");
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName, "TickMarkNotCngd");
				Assert.fail("Coupons added and not changed to tick mark");
			}

			obj.waitForElement(driver, shoppinglistpage.txt_List_Count_Text);
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName, "LoginCoupHomePage");
			//driver.close();
			System.out.println(e);
			Assert.fail("Error in Digital coupons page");
			
		}	
		return driver;	
			
	}
	public int getcount() 
	{
		return count;
	}
	public String getprod() 
	{	
		return prod;
	}
}
