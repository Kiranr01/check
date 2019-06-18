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
import computedClass.Computed_Shopping_List;
import computedClass.Computed_WeeklyAd;

public class Weekly_Ad 
{
	WebDriver driver;
	String functionality="Weekly_Ad";	
	Browserbanner browserbanner=new Browserbanner();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Computed_WeeklyAd weeklyad=new Computed_WeeklyAd();
	Computed_Shopping_List shoppinglist = new Computed_Shopping_List();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC01_Add_items_to_list_ADD_TO_LIST_button_item_added (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver,TestDataExcel, Functionality, TCName);
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,TestDataExcel,Functionality,TCName, proddetails, count, "Added");	
		driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC03_Add_items_to_list_VIEW_DETAILS_button_add_item_again (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		prodvalu=weeklyad.getprodvalu();
		driver = weeklyad.AddAgain(driver,TestDataExcel,Functionality,TCName,prodvalu);	
		//driver.close();
	}
	
	@Test (priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC01_Remove_items_from_the_list_Weekly_Circular (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver = weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver = weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		driver = weeklyad.Removeproduct(driver,TestDataExcel,Functionality,TCName, prodvalu, count,"circularpage");
		proddetails = weeklyad.getproddetails();
		count = weeklyad.getcount();
		prodvalu = weeklyad.getprodvalu();
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,TestDataExcel, Functionality,TCName, proddetails, count, "Removed");
		driver.close();
	}
	
	@Test (priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC02_Remove_items_from_the_list_View_Details_screen (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"overlay");
		driver=weeklyad.Removeproduct(driver,TestDataExcel,Functionality,TCName, prodvalu, count,"overlay");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		prodvalu=weeklyad.getprodvalu();
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,TestDataExcel,Functionality,TCName, proddetails, count, "Removed");
		//driver.close();
	}
	
	@Test (priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC03_Remove_items_from_the_list_My_Shopping_List (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver,TestDataExcel, Functionality, TCName);
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		prodvalu=weeklyad.getprodvalu();
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,TestDataExcel,Functionality,TCName, proddetails, count, "DeleteIcon_Removedfromshoppinglist");
		driver = weeklyad.RemoveAgain(driver,TestDataExcel,Functionality,TCName, prodvalu);
		driver=weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		prodvalu=weeklyad.getprodvalu();
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,TestDataExcel, Functionality,TCName, proddetails, count, "DeleteAllButton_Removedfromshoppinglist");
		driver = weeklyad.RemoveAgain(driver,TestDataExcel,Functionality,TCName, prodvalu);
		driver.close();
	}
}
