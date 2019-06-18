package computedClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import Utility.Data;
import Utility.Readexcel_RowName;
import generatedClass.POM_Generated_Homepage;
import generatedClass.POM_Generated_ShoppingListPage;

public class Computed_Shopping_List 
{
	Data obj=new Data();
	List<WebElement> totalprod= null;
    List<WebElement> prodsummary=null;
    List<WebElement> proddesc= null;
    List<WebElement> price=null;
    List<WebElement> Delete=null;
    List<WebElement> checkbox=null;
    List<WebElement> qty=null;
    private String proddetails;
	private int count;
    public WebDriver ShoppingList_Navigation(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
    	POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);		
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		
		String value="";
		WebElement logo = null;
	    try
    	{
	    	new Readexcel_RowName().excelRead(TestDataExcel,"Global",Functionality);
	    	if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
	    	{  			
	    		value="winndixie";		
	    		logo= homepage.click_Winndixie_logo;
	    	}
	    	else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
	    	{
	    		
	    		value="bi-lo";	    		
	    		logo = homepage.click_Bilo_logo;
	    	}
	    	else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
	    	{	
	    		value="harveyssupermarkets";	    		
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
    		homepage.click_click_Savings_WeeklyAd_Button();	
    		obj.waitForElement(driver, shoppinglistpage.txt_List_Count_Text);
    	}
	    catch(Exception e)
	    {
	    	obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_shoplist");
	    	Assert.fail("Error in shopping list navigation");
	    }
		return driver;
	  }
    public WebDriver ShoppingList_CheckCount(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String checkvalue) throws FileNotFoundException, IOException, InterruptedException, AWTException 
   	{		
   		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);

   	    try
       	{
       		obj.waitForElementClickable(driver, shoppinglistpage.txt_List_Count_Text);
       		String valu=shoppinglistpage.getText_txt_List_Count_Text();
       		if(valu.equalsIgnoreCase(checkvalue))
       		{
       			Reporter.log("Products count updated in shopping list after updation");
       		}
       		else
       		{
       			Assert.fail("Products count are not updated in shopping list after updation");
       		}
       		
       	}
   	    catch(Exception e)
   	    {
   	    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"shoplist_NoCountUpdat");
   	    	Assert.fail("Error in shopping list count");
   	    }
   		return driver;
   	  }
    
	public WebDriver WeeklyAd_Deals_ShoppingList(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String proddetails,int count,String actionverify) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		//Data obj=new Data();
		Robot rb = new Robot();
	    try
	    { 	   
		    obj.waitForElementClickable(driver, shoppinglistpage.txt_List_Count_Text);
			String sc=shoppinglistpage.getText_txt_List_Count_Text();
			int scl=Integer.parseInt(sc);
			if(!actionverify.equalsIgnoreCase("")||count!=0)
			{
				if(scl!=count)
				{
					obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_count");
					driver.close();
					Assert.fail("count not updated");
				}
			}
			obj.waitForElementClickable(driver, shoppinglistpage.click_List_icon_Button);
			shoppinglistpage.click_click_List_icon_Button();
	        obj.waitForElementClickable(driver,shoppinglistpage.click_Close_Button);
	        
	        boolean prodchk=true;
	        rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			obj.scrollingToTop(driver);
	        
			if(!shoppinglistpage.isSelected_click_Weekly_Ad_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Weekly_Ad_Filter_Checkbox();
				obj.waitForElementselected(driver, shoppinglistpage.click_Weekly_Ad_Filter_Checkbox);
			}
			if(shoppinglistpage.isSelected_click_Coupons_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Coupons_Filter_Checkbox();
	        }
			if(shoppinglistpage.isSelected_click_MyItem_Filter_Checkbox())
			{
				shoppinglistpage.click_click_MyItem_Filter_Checkbox();
	        }
			Thread.sleep(2000);
			totalprod= shoppinglistpage.txt_Total_Products_Text;
			
			try
			{
				if(shoppinglistpage.isDisplayed_click_Print_List_Button())
				{
					Reporter.log("Print list button is displayed in shopping list page");
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel,Functionality, TCName,"err_noprint");
					Assert.fail("Print list button is not displayed in shopping list page");
				}
				if(shoppinglistpage.isDisplayed_click_Email_List_Button())
				{
					Reporter.log("Email list button is displayed in shopping list page");
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_noemail");
					Assert.fail("Email list button is not displayed in shopping list page");
				}
			}
			catch(Exception e)
			{
				 obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_emailorprint");
				Assert.fail("Error in Email list  or print list button in shopping list page");
			}
			obj.movetoElementofAPage(driver, shoppinglistpage.click_Weekly_Ad_Filter_Checkbox);
			if(totalprod.size()!=0)
			{
				prodsummary=shoppinglistpage.txt_Product_Summary_Text;
				price= shoppinglistpage.txt_Product_Price_Text;
				Delete=shoppinglistpage.click_Weekly_Ad_Items_Delete_Icon;
				qty = shoppinglistpage.txt_Quantity_CheckBox;
				checkbox=shoppinglistpage.click_Select_Items_CheckBox;
			}
			else
			{
				prodchk=false;
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_total");
				Assert.fail("Error in total products");
			}
	        
			String editqty="";
			String firstqty="";
	        int size=totalprod.size();
			String item="";
			String summary="";
		    String desc="";
		    String pric="";
		    String product1="";
		    String product2="";
		    int itemnumber=0;
		    boolean chk=false;
		    boolean finished = false;
		    new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
			
			if(actionverify.equalsIgnoreCase("editqty"))
			{	
				editqty=Readexcel_RowName.getValue("Edit_QTY");
				
			}
			else if(actionverify.equalsIgnoreCase("Delete_Multipleitems"))
			{
				product1=Readexcel_RowName.getValue("product1");
				product2=Readexcel_RowName.getValue("product2");
			}
		    if(prodchk==true) 
		    {
		    System.out.println("Size "+size);	
		    	outerloop:		    		
		    	for(int k=0;k<size;k++)
		    	{		
		    		for(int j=0;j<size && finished==false;j++)
		    		{    	
		    			item= totalprod.get(k).getText();
		    			if(item.isEmpty())
		    			{
		    				rb.keyPress(KeyEvent.VK_DOWN);
		    				rb.keyRelease(KeyEvent.VK_DOWN);
				    	}
		    			else
		    			{   			
		    				summary= prodsummary.get(k).getText();
		    				summary = summary.replace(".","");		    			
		    				summary = summary.replace("/", "");
		    				firstqty = qty.get(k).getText();
		    				
		    				try
		    				{
		    					proddesc= shoppinglistpage.txt_Product_Description_Text;
		    					desc=proddesc.get(k).getText();
		    					desc = desc.replace(".", "");
		    					desc = desc.replace("/", "");
		    				}
		    				catch(Exception e)
		    				{
		    					desc="";
		    				}
		    				proddetails =  proddetails.replace(".", "");
		    				proddetails = proddetails.replace("/", "");		
		    				pric=price.get(k).getText();
				    		pric = pric.replace(".", "");
				    		pric = pric.replace("/", "");
				    		
				    		if(actionverify.equalsIgnoreCase("Added"))
				    		{
				    		
				    			if(proddetails.equalsIgnoreCase(summary+" "+pric+" "+desc))
				    			{
				    				if(firstqty.equalsIgnoreCase("1"))
									{
				    					chk=true;
				    					finished=true;
				    					break outerloop;
									}
				    				else
				    				{
				    					obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_defqty");
				    					Assert.fail("Default quantity 1 is not displaying for Products added in shoppinglist");
				    				}
				    			}
				    		}
				    		else if(actionverify.equalsIgnoreCase("Removed"))
				    		{			    						
				    			if(proddetails.equalsIgnoreCase(summary+" "+pric+" "+desc))
				    			{
				    				chk=true;
				    				finished=true;
				    				break outerloop;
				    			}
				    		}
				    		else if(actionverify.equalsIgnoreCase("DeleteIcon_Removedfromshoppinglist"))
				    		{
				    			System.out.println(proddetails);
				    			System.out.println(summary+" "+pric+" "+desc);
					    		System.out.println(firstqty);
				    			if(proddetails.equalsIgnoreCase(summary+" "+pric+" "+desc))
				    			{
				    				chk=true;
				    				finished=true;
				    				this.proddetails=proddetails;
				    				Delete.get(k).click();
				    				Thread.sleep(3000);
				    				break outerloop;		
				    			}
				    				
				    		}
				    		else if(actionverify.equalsIgnoreCase("DeleteAllButton_Removedfromshoppinglist"))
				    		{
				    					
				    			if(proddetails.equalsIgnoreCase(summary+" "+pric+" "+desc))
				    			{
				    				
				    				chk=true;
				    				finished=true;
				    				this.proddetails=proddetails;
				    				checkbox.get(k).click();
				    				obj.movetoElementofAPage(driver, shoppinglistpage.click_Remove_All_Checked_Items_Button);
				    				Thread.sleep(1000);
				    				shoppinglistpage.click_click_Remove_All_Checked_Items_Button();
				    				Thread.sleep(3000);
				    				break outerloop;		    						
				    			}
				    				
				    		}
				    		else if(actionverify.equalsIgnoreCase("Delete_Multipleitems"))
				    		{		
				    			
				    			if(product1.equalsIgnoreCase(summary+" "+pric+" "+desc))
				    			{
				    				
				    				checkbox.get(k).click();
				    				
				    				itemnumber+=1;
				    				finished=true;	
				    				Thread.sleep(500);
				    			}
				    			else if(product2.equalsIgnoreCase(summary+" "+pric+" "+desc))
				    			{
				    				
				    				checkbox.get(k).click();		
				    				
				    				itemnumber+=1;		
				    				finished=true;	
				    				Thread.sleep(500);
				    			}
				    			int val=Integer.parseInt(proddetails);
				    			if(itemnumber==val)
				    			{
				    				
				    				chk=true;	
				    			/*	boolean asd=false;
				    				while(asd==true)
				    				{
				    					try
				    					{
				    						Thread.sleep(1000);
				    						if(shoppinglistpage.isDisplayed_click_Remove_All_Checked_Items_Button())
				    						{
				    							shoppinglistpage.click_click_Remove_All_Checked_Items_Button();
				    							asd=true;
				    						}
				    						else
				    						{
				    							rb.keyPress(KeyEvent.VK_DOWN);
							    				rb.keyRelease(KeyEvent.VK_DOWN);
				    						}
				    					}
				    					catch(Exception e)
				    					{
				    						rb.keyPress(KeyEvent.VK_DOWN);
						    				rb.keyRelease(KeyEvent.VK_DOWN);
				    					}
				    					
				    				}*/
				    				obj.movetoElementofAPage_Click(driver, shoppinglistpage.click_Remove_All_Checked_Items_Button);

				    				Thread.sleep(3000);
				    				break outerloop;
				    			}
				    		}
				    		else if(actionverify.equalsIgnoreCase("editqty"))
							{
								if(proddetails.equalsIgnoreCase(summary+" "+pric+" "+desc))
								{	
									if(editqty.equalsIgnoreCase(qty.get(k).getText()))
									{
										finished=true;
										chk=true;
										Thread.sleep(3000);
										break outerloop;
									}
									else
									{
										obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_qty");
										Assert.fail("Quantity not changed");
									}
								}
							}
				    		else if(actionverify.equalsIgnoreCase(""))
				    		{
				    			
				    		}
				    		else
				    		{
				    			 obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_chkActnVerParameter");
				    			Assert.fail("Check action verify parameter from shopping list");
				    		}
		    			}
		    			
		    		}
		    		finished=false;
				}
		  	}
		    if(actionverify.equalsIgnoreCase("Added"))
		    {
		    	if(chk==false)
		    	{
		    		//driver.close();
		    		obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nopdt");
		    		Assert.fail("Products are not displaying in shoppinglist when items added from circular page");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Products added in shopping list when items added from circular page");
		    	}
		    }
		    else if(actionverify.equalsIgnoreCase("Removed"))
		    {
		    	if(chk==true)
		    	{
		    		obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_pdtremov");
		    		driver.close();
		    		Assert.fail("Products are displaying in shoppinglist when items removed from circular page");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Products removed in shopping list when items removed from circular page");
		    	}
		    }
		    else if(actionverify.equalsIgnoreCase("DeleteIcon_Removedfromshoppinglist")||actionverify.equalsIgnoreCase("DeleteAllButton_Removedfromshoppinglist"))
		    {
		    	if(chk==false)
		    	{
		    		obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_delpdt");
		    		//driver.close();
		    		Assert.fail("Products are not removed from shoppinglist by clicking delete icon");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Products removed from shopping list");
		    	}
		    }
		    
		    else if(actionverify.equalsIgnoreCase("Delete_Multipleitems"))
		    {
		    	if(chk==false)
		    	{
		    		obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_mutliplepdtnotremoved");
		    		driver.close();
		    		Assert.fail("Multiple Products are not removed from shoppinglist by selecting and clicking delete all items button");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Multiple Products are not removed from shoppinglist by selecting and clicking delete all items button");
		    	}
		    }
		    else if(actionverify.equalsIgnoreCase(""))
		    {
		    	Reporter.log("verified shopping list only as expected");
		    }
		    else if(actionverify.equalsIgnoreCase("editqty"))
		    {
		    	if(chk==false)
		    	{
		    		obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_qtynotupdated");
		    		//driver.close();
		    		Assert.fail("Edited Quantity is not updated in shopping list");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Edited Quantity is updated in shopping list");
		    	}
		    }
		    else
    		{
		    	obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_chkActnVerParameter");
    			Assert.fail("Check action verify parameter from shopping list");
    		}
		    obj.waitForElementClickable(driver, shoppinglistpage.click_Close_Button);
		   shoppinglistpage.click_click_Close_Button();
		    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_Noshoplist");
	    //	driver.close();
		Assert.fail("Error in shopping list or shopping list not opened");    	
	    }	
	    return driver;  	  
	}
	
	public WebDriver Coupons_ShoppingList(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String prod,int count,String pageverify) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		//Data obj=new Data();
		Robot rb = new Robot(); 
	    try
	    { 
		    
		    obj.waitForElement(driver, shoppinglistpage.txt_List_Count_Text);
			String sc=shoppinglistpage.getText_txt_List_Count_Text();
			int scl=Integer.parseInt(sc);
			
			if(scl!=count)
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_count");
				driver.close();
				
				Assert.fail("count not updated");
			}
			obj.waitForElementClickable(driver, shoppinglistpage.click_List_icon_Button);
			shoppinglistpage.click_click_List_icon_Button();
	        obj.waitForElementClickable(driver,shoppinglistpage.click_Close_Button);
	        
	        boolean prodchk=true;
	        rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			obj.scrollingToTop(driver);
	        
	       
			if(shoppinglistpage.isSelected_click_Weekly_Ad_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Weekly_Ad_Filter_Checkbox();
			}
			if(!shoppinglistpage.isSelected_click_Coupons_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Coupons_Filter_Checkbox();
				obj.waitForElementselected(driver, shoppinglistpage.click_Coupons_Filter_Checkbox);
			}
			if(shoppinglistpage.isSelected_click_MyItem_Filter_Checkbox())
			{
				shoppinglistpage.click_click_MyItem_Filter_Checkbox();
			}
	        	
			totalprod= shoppinglistpage.txt_Total_Products_Text;
			if(totalprod.size()!=0)
			{
				prodsummary=shoppinglistpage.txt_Product_Summary_Text;
				proddesc= shoppinglistpage.txt_Product_Description_Text;
			}
			else
			{
	        		prodchk=false;
			}
			int size=totalprod.size();
			String item="";
			String summary="";
			String desc="";
			
			boolean chk=false;
			boolean finished = false;
			if(prodchk==true) 
			{
				outerloop:
				for(int k=0;k<size;k++)
				{		
					for(int j=0;j<size && finished==false;j++)
					{    	
						item= totalprod.get(k).getText();
						if(item.isEmpty())
						{
							rb.keyPress(KeyEvent.VK_DOWN);
							rb.keyRelease(KeyEvent.VK_DOWN);
					   	}
						else
						{   			
							summary= prodsummary.get(k).getText();
							summary = summary.replace(".","");		    			
							summary = summary.replace("/", "");
							desc=proddesc.get(k).getText();
							desc = desc.replace(".", "");
							desc = desc.replace("/", "");
							prod =  prod.replace(".", "");
							prod = prod.replace("/", "");
							if(pageverify.equalsIgnoreCase("Save_Coupon"))
							{
								if(prod.equalsIgnoreCase("Save coupon- "+summary+" "+desc))
								{
									Reporter.log("Save Coupons displayed in shopping list");
									chk=true;
									finished=true;
									break outerloop;
								}
							} 
							else if(pageverify.equalsIgnoreCase("Digital_Coupon"))
							{
								
								if(prod.equalsIgnoreCase(summary+" "+desc))
								{
									Reporter.log("Digital Coupons displayed in shopping list");
									chk=true;
									finished=true;
									break outerloop;
								}
							}
			    		}
			    		
					}
			  	}
			   
				if(chk==false)
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_coupons");
					driver.close();
					Assert.fail("Coupons are not added in shoppinglist");
			    		
				}
			}
			obj.waitForElementClickable(driver, shoppinglistpage.click_Close_Button);
			shoppinglistpage.click_click_Close_Button();	  
	    }
	    catch(Exception e)
	    {
	    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_shoplist");
	    	driver.close();
	    	Assert.fail("Error in shopping list");
	    	obj.waitForElement(driver, shoppinglistpage.click_Close_Button);
	    	shoppinglistpage.click_click_Close_Button();
	    }
	    return driver;
	}
	
	
	public WebDriver Add_Remove_MyItems_ShoppingList(WebDriver driver,String TestDataExcel,String Functionality,String TCName, int count,String action) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		//Data obj=new Data();
		Robot rb = new Robot();
		String prodname="";
	    try
	    { 	   
	    	
		    obj.waitForElementClickable(driver, shoppinglistpage.txt_List_Count_Text);
			String sc=shoppinglistpage.getText_txt_List_Count_Text();
			count=Integer.parseInt(sc);
			
			obj.waitForElementClickable(driver, shoppinglistpage.click_List_icon_Button);
			shoppinglistpage.click_click_List_icon_Button();
	        obj.waitForElementClickable(driver,shoppinglistpage.click_Close_Button);
	        
	        rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			obj.scrollingToTop(driver);
	        
			if(shoppinglistpage.isSelected_click_Weekly_Ad_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Weekly_Ad_Filter_Checkbox();
				obj.waitForElementselected(driver, shoppinglistpage.click_Weekly_Ad_Filter_Checkbox);
			}
			if(shoppinglistpage.isSelected_click_Coupons_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Coupons_Filter_Checkbox();
	        }
			if(!shoppinglistpage.isSelected_click_MyItem_Filter_Checkbox())
			{
				shoppinglistpage.click_click_MyItem_Filter_Checkbox();
				obj.waitForElementselected(driver, shoppinglistpage.click_MyItem_Filter_Checkbox);
	        }
			Thread.sleep(2000);		
			try 
			{
				obj.movetoElementofAPage(driver, shoppinglistpage.click_Remove_All_Checked_Items_Button);
				if(!shoppinglistpage.isEnabled_click_Remove_All_Checked_Items_Button())
				{
					Reporter.log("Remove all checked items button is disabled pre selection");
				}
				else
				{
					//Assert.fail("Remove all checked items button is enabled pre selection");
				}
			}
			catch(Exception e)
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_remove");
				Assert.fail("Error in Remove all checked items button");
			}
			
			try
			{
				if(shoppinglistpage.isDisplayed_click_Print_List_Button())
				{
					Reporter.log("Print list button is displayed in shopping list page");
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_noprint");
					Assert.fail("Print list button is not displayed in shopping list page");
				}
				if(shoppinglistpage.isDisplayed_click_Email_List_Button())
				{
					Reporter.log("Email list button is displayed in shopping list page");
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_noemail");
					Assert.fail("Email list button is not displayed in shopping list page");
				}
			}
			catch(Exception e)
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_emailorprint");
				Assert.fail("Error in Email list or print list button in shopping list page");
			}
			
			obj.movetoElementofAPage(driver, shoppinglistpage.click_Weekly_Ad_Filter_Checkbox);
			
			obj.waitForElement(driver, shoppinglistpage.txt_ADD_An_Item_Text_Field);
			new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
			prodname=Readexcel_RowName.getValue("Add_An_Item");
			if(action.equalsIgnoreCase("Add"))
			{				
				
				shoppinglistpage.type_txt_ADD_An_Item_Text_Field(prodname);
				shoppinglistpage.click_click_ADD_An_Item_Icon();
				Thread.sleep(1000);
				Reporter.log("Clicked add an item button in shopping list");
				this.count=count+1;
			}
			else if(action.equalsIgnoreCase("Remove"))
			{
				boolean prodchk=true;
				String item="";
				totalprod= shoppinglistpage.txt_MyItem_Product_Name;
				Delete=shoppinglistpage.click_MyItem_Delete_Icon;
				if(totalprod.size()==0)
				{
					prodchk=false;
				}
				int size=totalprod.size();	
				
				boolean finished = false;
				if(prodchk==true) 
				{
					outerloop:
					for(int k=0;k<size;k++)
					{		
						for(int j=0;j<size && finished==false;j++)
						{    	
							item= totalprod.get(k).getText();
							System.out.println("item"+item);
							if(item.isEmpty())
							{
								rb.keyPress(KeyEvent.VK_DOWN);
								rb.keyRelease(KeyEvent.VK_DOWN);
						   	}
							else if(prodname.equalsIgnoreCase(item))
							{	
				    				finished=true;
				    				Delete.get(k).click();
				    				Thread.sleep(3000);
				    				this.count=count-1;
				    				Reporter.log("Clicked delete icon in shopping list for myitems");
				    				break outerloop;		    						
				    		}				    		
						}
				  	}
				}   
				
			}
			obj.waitForElementClickable(driver, shoppinglistpage.click_Close_Button);
			shoppinglistpage.click_click_Close_Button();	  
	    }
	    catch(Exception e)
	    {
	    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_shoplist");
	    	//driver.close();
	    	System.out.println(e);
	    	Assert.fail("Error in shopping list");
	    	
	    }
	
	    return driver;  	  
	}
	
	
	public WebDriver Check_MyItems_ShoppingList(WebDriver driver,String TestDataExcel,String Functionality,String TCName,int count,String actionverify) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		//Data obj=new Data();
		Robot rb = new Robot();
		String prodname="";
		String editname="";
		String editqty="";
	    try
	    { 	   
		    obj.waitForElementClickable(driver, shoppinglistpage.txt_List_Count_Text);
			String sc=shoppinglistpage.getText_txt_List_Count_Text();
			int scl=Integer.parseInt(sc);
			
			if(scl!=count)
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_count");
				driver.close();
				Assert.fail("count not updated");
			}
			
			obj.waitForElementClickable(driver, shoppinglistpage.click_List_icon_Button);
			shoppinglistpage.click_click_List_icon_Button();
	        obj.waitForElementClickable(driver,shoppinglistpage.click_Close_Button);
	        
	        boolean prodchk=true;
	        boolean chk=false;
	        rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			obj.scrollingToTop(driver);
	        
			if(shoppinglistpage.isSelected_click_Weekly_Ad_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Weekly_Ad_Filter_Checkbox();
				
			}
			if(shoppinglistpage.isSelected_click_Coupons_Filter_Checkbox())
			{
				shoppinglistpage.click_click_Coupons_Filter_Checkbox();
	        }
			if(!shoppinglistpage.isSelected_click_MyItem_Filter_Checkbox())
			{
				shoppinglistpage.click_click_MyItem_Filter_Checkbox();
				obj.waitForElementselected(driver, shoppinglistpage.click_MyItem_Filter_Checkbox);
	        }
			String item="";
			totalprod= shoppinglistpage.txt_MyItem_Product_Name;
			checkbox=shoppinglistpage.txt_Quantity_CheckBox;
			if(totalprod.size()==0)
			{
				prodchk=false;
			}
			int size=totalprod.size();	
			new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
			prodname=Readexcel_RowName.getValue("Add_An_Item");
			if(actionverify.equalsIgnoreCase("myitemname_Edited")||actionverify.equalsIgnoreCase("myitemqty_Edited"))
			{
				editname=Readexcel_RowName.getValue("Edit_Item_Name");
				editqty=Readexcel_RowName.getValue("Edit_QTY");
				
			}
			
			boolean finished = false;
			if(prodchk==true) 
			{
				outerloop:
				for(int k=0;k<size;k++)
				{		
					for(int j=0;j<size && finished==false;j++)
					{    	
						item= totalprod.get(k).getText();
						if(item.isEmpty())
						{
							rb.keyPress(KeyEvent.VK_DOWN);
							rb.keyRelease(KeyEvent.VK_DOWN);
					   	}
						else
						{
							if(actionverify.equalsIgnoreCase("Added"))
							{
								if(prodname.equalsIgnoreCase(item))
								{	
									finished=true;
									chk=true;
									Thread.sleep(3000);
								
									break outerloop;		
								}
							}
							else if(actionverify.equalsIgnoreCase("Removed"))
							{
								if(prodname.equalsIgnoreCase(item))
								{	
									finished=true;
									chk=true;
									Thread.sleep(3000);
								
									break outerloop;		
								}
							}
							
							else if(actionverify.equalsIgnoreCase("myitemname_Edited"))
							{
							
								if(editname.equalsIgnoreCase(item))
								{	
									finished=true;
									chk=true;
									Thread.sleep(3000);								
									break outerloop;
									
								}
							}
							else if(actionverify.equalsIgnoreCase("myitemqty_Edited"))
							{
								if(prodname.equalsIgnoreCase(item)||editname.equalsIgnoreCase(item))
								{	
									if(editqty.equalsIgnoreCase(checkbox.get(k).getText()))
									{
										Reporter.log("Quantity for my items has been updated after editing");
										finished=true;
										chk=true;
										Thread.sleep(3000);							
										break outerloop;
									}
									else
									{
										obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_qtynotupdated");
										Assert.fail("Quantity not changed");
									}
								}
							}
							
						}
					}
			  	}
			}   
			if(actionverify.equalsIgnoreCase("Added"))
		    {
		    	if(chk==false)
		    	{
		    		obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_pdtnotadded");
		    		//driver.close();
		    		Assert.fail("Products are not displaying in shoppinglist when items added from myitems");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Products added in shopping list when items added from myitems");
		    	}
		    }
			else if(actionverify.equalsIgnoreCase("myitemname_Edited"))
		    {
		    	if(chk==false)
		    	{
		    		//driver.close();
		    		obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_pdtnotadded");
		    		Assert.fail("Products are not displaying in shoppinglist when items Edited from myitems");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Products Edited in shopping list when items added from myitems");
		    	}
		    }
		    else if(actionverify.equalsIgnoreCase("Removed"))
		    {
		    	if(chk==true)
		    	{
		    		obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_pdt");
		    		driver.close();
		    		Assert.fail("Products are displaying in shoppinglist when items removed from myitems");
		    		
		    	}
		    	else
		    	{
		    		Reporter.log("Products removed in shopping list when items removed from myitems");
		    	}
		    }
			obj.waitForElementClickable(driver, shoppinglistpage.click_Close_Button);
			shoppinglistpage.click_click_Close_Button();
		}
	    catch(Exception e)
	    {
	    	//driver.close();
	    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_myitems");
	    	System.out.println(e);
	    	Assert.fail("Error in myitems shopping list");
	    	
	    }
	
	    return driver;  	  
	}

	
	public WebDriver Edit_ShoppingList(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String proddetails,String filter, String Editaction) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_ShoppingListPage shoppinglistpage = new POM_Generated_ShoppingListPage(driver);
		
		//Data obj=new Data();
		Robot rb = new Robot();
		String prodname="";
		String editname="";
		String editqty="";
	
	    try
	    { 	   
		    obj.waitForElement(driver, shoppinglistpage.txt_List_Count_Text);
			
			obj.waitForElementClickable(driver, shoppinglistpage.click_List_icon_Button);
			shoppinglistpage.click_click_List_icon_Button();
	        obj.waitForElementClickable(driver,shoppinglistpage.click_Close_Button);      
	        boolean prodchk=true;      
	        rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			
			obj.scrollingToTop(driver);
	        if (filter.equalsIgnoreCase("Weeklyad"))
	        {
	        	if(!shoppinglistpage.isSelected_click_Weekly_Ad_Filter_Checkbox())
	        	{
	        		shoppinglistpage.click_click_Weekly_Ad_Filter_Checkbox();
	        		obj.waitForElementselected(driver, shoppinglistpage.click_Weekly_Ad_Filter_Checkbox);
				
	        	}
	        	if(shoppinglistpage.isSelected_click_Coupons_Filter_Checkbox())
				{
					shoppinglistpage.click_click_Coupons_Filter_Checkbox();
		        }
				if(shoppinglistpage.isSelected_click_MyItem_Filter_Checkbox())
				{
					shoppinglistpage.click_click_MyItem_Filter_Checkbox();					
		        }
				
				Thread.sleep(2000);
				totalprod= shoppinglistpage.txt_Total_Products_Text;
				if(totalprod.size()!=0)
				{
					
					prodsummary=shoppinglistpage.txt_Product_Summary_Text;
					price= shoppinglistpage.txt_Product_Price_Text;
					Delete=shoppinglistpage.click_Weekly_Ad_Items_Delete_Icon;
					
					qty = shoppinglistpage.txt_Quantity_CheckBox;
					
					checkbox=shoppinglistpage.click_Select_Items_CheckBox;			
				}
				else
				{
					prodchk=false;
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_total");
					Assert.fail("Error in total products");
				}
				
		        int size=totalprod.size();
		       
		        new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
				editqty=Readexcel_RowName.getValue("Edit_QTY");
			
				String item="";
				String summary="";
			    String desc="";
			    String pric="";
			    boolean finished = false;
			    
			    if(prodchk==true) 
			    {
			    	outerloop:
			    	for(int k=0;k<size;k++)
			    	{		
			    		for(int j=0;j<size && finished==false;j++)
			    		{    	
			    			item= totalprod.get(k).getText();
			    			if(item.isEmpty())
			    			{
			    				rb.keyPress(KeyEvent.VK_DOWN);
			    				rb.keyRelease(KeyEvent.VK_DOWN);
					    	}
			    			else
			    			{   			
			    				summary= prodsummary.get(k).getText();
			    				summary = summary.replace(".","");		    			
			    				summary = summary.replace("/", "");
			    				try
			    				{
			    					proddesc= shoppinglistpage.txt_Product_Description_Text;
			    					desc=proddesc.get(k).getText();
			    					desc = desc.replace(".", "");
			    					desc = desc.replace("/", "");
			    				}
			    				catch(Exception e)
			    				{
			    					desc="";
			    				}
			    				proddetails =  proddetails.replace(".", "");
			    				proddetails = proddetails.replace("/", "");		
			    				pric=price.get(k).getText();
					    		pric = pric.replace(".", "");
					    		pric = pric.replace("/", "");
					    				
					    		if(proddetails.equalsIgnoreCase(summary+" "+pric+" "+desc))
					    		{
					    			
					    			if(Editaction.equalsIgnoreCase("editqty"))
									{
										qty.get(k).sendKeys(Keys.ENTER+""+Keys.CONTROL + "a"+Keys.DELETE);
										driver.findElement(By.xpath("//input[@class='form-control item-quantity']")).sendKeys(editqty);
										Thread.sleep(1000); 	
					    				finished=true;
					    				break outerloop;
					    			}
					    			
					    		}
			    			}
			    		}
			    	}
			    }
	        }
	       
	        else if(filter.equalsIgnoreCase("myitems"))
	        {
	        	if(shoppinglistpage.isSelected_click_Weekly_Ad_Filter_Checkbox())
	        	{
	        		shoppinglistpage.click_click_Weekly_Ad_Filter_Checkbox();				
	        	}
	        	if(shoppinglistpage.isSelected_click_Coupons_Filter_Checkbox())
				{
					shoppinglistpage.click_click_Coupons_Filter_Checkbox();
					
		        }
				if(!shoppinglistpage.isSelected_click_MyItem_Filter_Checkbox())
				{
					shoppinglistpage.click_click_MyItem_Filter_Checkbox();
					obj.waitForElementselected(driver, shoppinglistpage.click_MyItem_Filter_Checkbox);
		        }
	        
				 boolean finished = false;
			        String item="";
					totalprod= shoppinglistpage.txt_MyItem_Product_Name;
					qty=shoppinglistpage.txt_Quantity_CheckBox;
					if(totalprod.size()==0)
					{
						prodchk=false;
					}
					int size=totalprod.size();
					new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
					prodname=Readexcel_RowName.getValue("Add_An_Item");
					editname=Readexcel_RowName.getValue("Edit_Item_Name");
					editqty=Readexcel_RowName.getValue("Edit_QTY");
					
					if(prodchk==true) 
					{
						outerloop:
						for(int k=0;k<size;k++)
						{		
							for(int j=0;j<size && finished==false;j++)
							{    	
								item= totalprod.get(k).getText();
								if(item.isEmpty())
								{
									rb.keyPress(KeyEvent.VK_DOWN);
									rb.keyRelease(KeyEvent.VK_DOWN);
							   	}
								else
								{
									if(prodname.equalsIgnoreCase(item)||editname.equalsIgnoreCase(item))
									{	
										finished=true;
										
										Thread.sleep(3000);
										if(Editaction.equalsIgnoreCase("edititem"))
										{
											
											totalprod.get(k).sendKeys(Keys.ENTER+""+Keys.CONTROL + "a"+Keys.DELETE);
											driver.findElement(By.xpath("//input[@class='form-control item-name']")).sendKeys(editname);
											Thread.sleep(1000);
											 
										}
										else if(Editaction.equalsIgnoreCase("editqty"))
										{
											
											qty.get(k).sendKeys(Keys.ENTER+""+Keys.CONTROL + "a"+Keys.DELETE);
											driver.findElement(By.xpath("//input[@class='form-control item-quantity']")).sendKeys(editqty);
											Thread.sleep(1000); 
											
										}
										break outerloop;		
									}		
								}
							}
					  	}
					}   
	        }
			shoppinglistpage.click_click_Close_Button();
		}
	    catch(Exception e)
	    {
	    	//driver.close();
	    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_shoplist");
	    	System.out.println(e);
	    	Assert.fail("Error in shopping list");
	    	
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
}
