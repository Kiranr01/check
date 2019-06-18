package computedClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import Utility.Data;
import Utility.Readexcel_RowName;
import generatedClass.POM_Generated_ContactInfoPage;
import generatedClass.POM_Generated_HardLoginPage;
import generatedClass.POM_Generated_Homepage;
import generatedClass.POM_Generated_LoggedIn_RewardsPage;
import generatedClass.POM_Generated_StaticInfoBar;

public class Computed_Static_Info_bar 
{	
	public WebDriver LoginStaticinfobar_WeeklyAd(WebDriver driver,String TestDataExcel,String Functionality, String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_StaticInfoBar staticinfobar = new POM_Generated_StaticInfoBar(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		
		Data obj=new Data();
		String Global="Global";
		String value="";
		WebElement logo=null;
		new Readexcel_RowName().excelRead(TestDataExcel,Global,Functionality);
		
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
		String weeklyadpopup="https://pdnAccess:greasemonkey@"+value+".pdn.retaileriq.com/weeklyad/";
	   
		try
		{
			obj.waitForElementClickable(driver, logo);
			
			obj.movetoElementofAPage_Click(driver, logo);
		
			obj.PageNavigation(driver, weeklyadpopup);
	
			obj.waitForElementClickable(driver, logo);
		
			obj.movetoElementofAPage_Click(driver, logo);
	
			obj.waitForElementClickable(driver,staticinfobar.click_Static_info_WeeklyAds_link);
			
			if(staticinfobar.isDisplayed_click_Static_info_WeeklyAds_link())
			{
				obj.waitForElement(driver,staticinfobar.click_Static_info_WeeklyAds_Text);
				
				if(staticinfobar.isDisplayed_click_Static_info_WeeklyAds_Text())
				{  			
					staticinfobar.click_click_Static_info_WeeklyAds_link();					
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_WeeklyAdTxtnotdisplayed"); 
					driver.close();
					Assert.fail("Weekly ad text is not displaying");
				}
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_WeeklyAdLinknotdisplayed"); 
				driver.close();
				Assert.fail("Weekly ad link is not displaying");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_WeeklyAdLinknotdisplayed"); 
			driver.close();
			Assert.fail("Error in weekly ad link");
		}
		return driver;
	}	
	
	public WebDriver LoginStaticinfobar_Rewards(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_StaticInfoBar staticinfobar = new POM_Generated_StaticInfoBar(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		POM_Generated_LoggedIn_RewardsPage loginrewardspage = new POM_Generated_LoggedIn_RewardsPage(driver);
		
		Data obj=new Data();
		String Global="Global";
	
	    
		String pts="";
		WebElement logo=null;
		String[] pointsplit;
		
		new Readexcel_RowName().excelRead(TestDataExcel,Global,Functionality);
		
		if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Winndixie_logo;
		}
		else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Bilo_logo;
		}
		else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Harveys_logo;
		}
	 
		try 
		{
			obj.waitForElementClickable(driver, logo);
			logo.click();
			obj.waitForElement(driver, staticinfobar.click_Static_info_My_Rewards_Text);
			obj.waitForElementClickable(driver, staticinfobar.click_Static_info_My_Rewards_Link);
			if(staticinfobar.isDisplayed_click_Static_info_My_Rewards_Link())
			{
				obj.waitForElement(driver, staticinfobar.click_Static_info_My_Rewards_Text);
				if(staticinfobar.isDisplayed_click_Static_info_My_Rewards_Text())
				{
					Thread.sleep(1500);
					pts=staticinfobar.getText_click_Static_info_My_Rewards_Text();		
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"errRewtxtNotDisp"); 
					driver.close();
					Assert.fail("My Rewards text is not displaying");
				}
				staticinfobar.click_click_Static_info_My_Rewards_Link();
				obj.waitForElement(driver, loginrewardspage.txt_Points_Text);
				System.out.println(pts);
				pointsplit = pts.split(" ");
				String Rewardpoints1=pointsplit[0];
				int av=pointsplit.length;
				System.out.println(Rewardpoints1);
				System.out.println(av);
				String verifypts=loginrewardspage.getText_txt_Points_Text();
				String[] pointsplit2 = verifypts.split(" ");
				if(Rewardpoints1.equals(pointsplit2[0]))
				{
					  Reporter.log("Reward points are equal :"+pointsplit[0]);
				}
				else
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_RewDiffPTS"); 
					driver.close();
					Assert.fail("Different points"+pointsplit2[0]+"instead of "+pointsplit[0]);
				}
				//logo.click();			
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_RewardLinknotdisplayed"); 
				driver.close();
				Assert.fail("My Rewards link is not displaying");
			}	
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_WeeklyAd not displayed"); 
			driver.close();
			Assert.fail("Error in rewards link");
		}
	return driver;
	}
	
	
	public WebDriver LoginStaticinfobar_MyAccount(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String MyAccfunc) throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
		POM_Generated_StaticInfoBar staticinfobar= new POM_Generated_StaticInfoBar(driver);
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		POM_Generated_ContactInfoPage contactinfopage = new POM_Generated_ContactInfoPage(driver);
		POM_Generated_HardLoginPage hardloginpage = new POM_Generated_HardLoginPage(driver);
		Data obj=new Data();
		String Global="Global";
		
	    
		WebElement logo=null;
		
		new Readexcel_RowName().excelRead(TestDataExcel,Global,Functionality);
		
		if(Readexcel_RowName.getValue("Winndixie(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Winndixie_logo;
		}
		else if(Readexcel_RowName.getValue("Bilo(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Bilo_logo;
		}
		else if(Readexcel_RowName.getValue("Harveys(Y/N)").equalsIgnoreCase("Y"))
		{
			logo=homepage.click_Harveys_logo;
		}
		try
		{
			obj.waitForElement(driver, logo);
			logo.click();
			obj.waitForElement(driver, staticinfobar.click_Static_info_My_Account_Link);
			if(staticinfobar.isDisplayed_click_Static_info_My_Account_Link())
			{
				if(!staticinfobar.isDisplayed_click_Static_info_My_Account_Text())
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_MyAccTxtNotDisp"); 
					driver.close();
					Assert.fail("My Account text is not displaying");
				}
				staticinfobar.click_click_Static_info_My_Account_Link();
				if(MyAccfunc.equalsIgnoreCase("SoftLogin"))
				{
					obj.waitForElement(driver, hardloginpage.click_Popup_Close_Button);
				
					if(hardloginpage.isDisplayed_click_Popup_Close_Button())
					{
						hardloginpage.click_click_Popup_Close_Button();
						Reporter.log("Hard login window is displayed by clicking on My Account");
					}
					else
					{
						obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_HardLoginPopupNotdisp"); 
						driver.close();
						Assert.fail("Hard Login popup is not displaying");
					}
				}
				else if(MyAccfunc.equalsIgnoreCase("HardLogin"))
				{
					obj.waitForElement(driver, contactinfopage.txt_Fname_Field);
					if(contactinfopage.isDisplayed_txt_Fname_Field())
					{					
						Reporter.log("My Account page is displayed for hardlogin user by clicking on My Account static info bar");
					}
					else
					{
						obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_MyAccPageNotdisplayed"); 
						driver.close();
						Assert.fail("My Account page is displayed for hardlogin user by clicking on My Account static info bar");
					}
				}
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_MyAccLinknotdisplayed"); 
				driver.close();
				Assert.fail("My Account link is not displaying");
			}	
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_MyAccLinknotdisplayed"); 
			driver.close();
			Assert.fail("Error in MyAccount link");
		}		
		return driver;
	}
}
