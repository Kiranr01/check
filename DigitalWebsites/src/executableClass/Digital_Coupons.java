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
import computedClass.Computed_Logout;
import computedClass.Computed_Shopping_List;
import computedClass.Computed_SoftLogin;

public class Digital_Coupons 
{
	WebDriver driver;
	String functionality = "Digital_Coupons";
	Browserbanner browserbanner = new Browserbanner();
	Computed_SoftLogin softlogin = new Computed_SoftLogin();
	Computed_Digital_Coupons coupons = new Computed_Digital_Coupons();
	Computed_Shopping_List shoppinglist = new Computed_Shopping_List();
	Computed_Logout logout = new Computed_Logout();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_01_Shopping_List_Add_Coupons (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality = functionality;
		String prod="";
		int count = 0;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality, TCName);
		driver = coupons.Loggedin_Coupons_Link(driver, TestDataExcel,Functionality, TCName, prod, count);
		prod   = coupons.getprod();
		count  = coupons.getcount();
		driver = shoppinglist.Coupons_ShoppingList(driver,TestDataExcel,Functionality,TCName,prod, count, "Digital_Coupon");
		driver.close();	
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_08_Shopping_List_Add_Coupons (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality = functionality;
		String prod="";
		int count = 0;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality, TCName);
		driver = coupons.Loggedin_Coupons_Link(driver,TestDataExcel, Functionality, TCName, prod, count);
		prod   = coupons.getprod();
		count  = coupons.getcount();
		driver = shoppinglist.Coupons_ShoppingList(driver,TestDataExcel,Functionality,TCName, prod, count, "Digital_Coupon");
		
		driver = logout.Logout(driver, TestDataExcel,Functionality, TCName);
	
		driver = softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality, TCName);
		driver = shoppinglist.ShoppingList_Navigation(driver, TestDataExcel,Functionality,TCName);
		driver = shoppinglist.Coupons_ShoppingList(driver, TestDataExcel,Functionality,TCName, prod, count, "Digital_Coupon");
		driver.close();	
	}
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_01_Add_Coupons_Guest_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = coupons.Loggedout_Coupons_Link(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
}
