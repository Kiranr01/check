package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_Digital_Coupons;
import computedClass.Computed_MyRewards;
import computedClass.Computed_Personalisedoffers;
import computedClass.Computed_SoftLogin;
import computedClass.Computed_Static_Info_bar;
import computedClass.Computed_WeeklyAd;

public class SoftLogin 
{
	WebDriver driver;
	String functionality="SoftLogin";
	
	Browserbanner browserbanner = new Browserbanner();
	Computed_SoftLogin softlogin = new Computed_SoftLogin();
	Computed_Digital_Coupons coupons = new Computed_Digital_Coupons();	
	Computed_Personalisedoffers deals = new Computed_Personalisedoffers();
	Computed_WeeklyAd weeklyad = new Computed_WeeklyAd();
	Computed_Static_Info_bar staticinfobar = new Computed_Static_Info_bar();
	Computed_MyRewards rewards = new Computed_MyRewards();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_SoftLogin_Phone_And_Zip_login (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String prod="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality,TCName);
		driver = coupons.Loggedin_Coupons_Homepage(driver, TestDataExcel,Functionality,TCName, prod, count);
		driver = deals.Loggedin_Personalisedoffers(driver, TestDataExcel,Functionality,TCName);
		driver = weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver = weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, prod, count, prodvalu,"circularpage");
		driver = staticinfobar.LoginStaticinfobar_Rewards(driver, TestDataExcel,Functionality,TCName);
		driver = staticinfobar.LoginStaticinfobar_MyAccount(driver, TestDataExcel,Functionality, TCName,"Softlogin"); 
		driver.close();
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_SoftLogin_unable_to_view_account (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality,tcname);
		driver=staticinfobar.LoginStaticinfobar_MyAccount(driver,TestDataExcel, Functionality,tcname, "Softlogin");
		driver.close();
	}
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_SoftLogin_loggedout_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;	
		
		String prod="";
		String prodvalu="";
		int count=0;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=coupons.Loggedout_Coupons_Homepage(driver,TestDataExcel, Functionality,TCName);
		driver=deals.Loggedout_Personalisedoffers(driver, TestDataExcel,Functionality,TCName);
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver = weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, prod, count, prodvalu,"circularpage");
		driver=rewards.loggedout_Myreward(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
}
