package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_HardLogin;
import computedClass.Computed_MyStore;
import computedClass.Computed_WeeklyAd;

public class Store_Locator
{
	WebDriver driver;
	String functionality="Store_Locator";
	Browserbanner browserbanner=new Browserbanner();
	Computed_HardLogin hardlogin =new Computed_HardLogin();
	Computed_WeeklyAd weeklyad= new Computed_WeeklyAd();
	Computed_MyStore mystore= new Computed_MyStore();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_01_Store_Locator_Page(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=mystore.StoreLocatorValidation(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC02_Store_Locator_Zipcode(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		String prod="";
		String prodvalu="";
		int count=0;
	
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=mystore.StoreLocator_Zipcode(driver,TestDataExcel, Functionality, TCName);
		driver = weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, prod, count, prodvalu,"circularpage");
		prod=weeklyad.getprodvalu();
		count=weeklyad.getcount();
		prodvalu=weeklyad.getprodvalu();
		driver.close();
	}
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_04_Store_Locator_City_And_State(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		String prod="";
		String prodvalu="";
		int count=0;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=mystore.StoreLocator_CityState(driver, TestDataExcel,Functionality, TCName);
		driver = weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, prod, count, prodvalu,"circularpage");
		prod=weeklyad.getprodvalu();
		count=weeklyad.getcount();
		prodvalu=weeklyad.getprodvalu();
		driver.close();
	}
	@Test(priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_03_Store_Locator_ChangeLocation(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver= hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver=mystore.SetStore_ChangeLocation(driver, TestDataExcel,Functionality, TCName);	
		driver.close();
	}
	
	@Test(priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_08_Store_Locator_Page_logged_in(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{	
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver= hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver=mystore.SetStore(driver, TestDataExcel,Functionality, TCName);
		driver=mystore.StoreLocatorValidation(driver, TestDataExcel,Functionality, TCName);	
		driver.close();
	}
	
	@Test(priority=6)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_06_Search__invalid_Zip_code_More_than_5_digits(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver= mystore.SetStore_InvalidZip(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}	
}
