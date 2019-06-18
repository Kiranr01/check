package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Writeexcel_RowName;
import computedClass.Computed_Digital_Coupons;
import computedClass.Computed_HardLogin;
import computedClass.Computed_Logout;
import computedClass.Computed_Shopping_List;
import computedClass.Computed_WeeklyAd;

public class Shopping_List 
{
	WebDriver driver;
	String functionality="Shopping_List";	
	Browserbanner browserbanner=new Browserbanner();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Computed_WeeklyAd weeklyad=new Computed_WeeklyAd();
	Computed_Digital_Coupons coupons = new Computed_Digital_Coupons();
	Computed_Shopping_List shoppinglist = new Computed_Shopping_List();
	Computed_Logout logout=new Computed_Logout();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_02_Shopping_List_Add_My_Items (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		int count=0;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver = shoppinglist.ShoppingList_Navigation(driver,TestDataExcel, Functionality, TCName);
		driver = shoppinglist.Add_Remove_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Add");
		count=shoppinglist.getcount();
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Added");		
		driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_05_Shopping_List_Filter_By (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		int count=0;
		String proddetails="";
		String prodvalu="";
		String prod="";
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		
		//weeklyad filter
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.AddProduct(driver,TestDataExcel, Functionality,TCName,proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,TestDataExcel, Functionality,TCName, proddetails, count, "Added");	
		
		//coupons filter
		driver = coupons.Loggedin_Coupons_Link(driver, TestDataExcel,Functionality,TCName, prod, count);
		prod=coupons.getprod();
		count=coupons.getcount();
		driver = shoppinglist.Coupons_ShoppingList(driver, TestDataExcel,Functionality, TCName,prod, count, "Digital_Coupon");
		
		//myitems filter
		driver = shoppinglist.Add_Remove_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Add");
		count=shoppinglist.getcount();
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Added");	
		driver = shoppinglist.Add_Remove_MyItems_ShoppingList(driver,TestDataExcel, Functionality, TCName, count, "Remove");
		count=shoppinglist.getcount();
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Removed");	
		driver.close();
	}
	
	@Test (priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_06_Shopping_List_Remove_item_MyItems (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		int count=0;
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver,TestDataExcel, Functionality, TCName);
		driver = shoppinglist.ShoppingList_Navigation(driver, TestDataExcel,Functionality,TCName);
		driver = shoppinglist.Add_Remove_MyItems_ShoppingList(driver,TestDataExcel, Functionality, TCName, count, "Add");
		count=shoppinglist.getcount();
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Added");	
		driver = shoppinglist.Add_Remove_MyItems_ShoppingList(driver,TestDataExcel, Functionality, TCName, count, "Remove");
		count=shoppinglist.getcount();
		driver=shoppinglist.Check_MyItems_ShoppingList(driver,TestDataExcel, Functionality, TCName, count, "Removed");	
		driver.close();
	}
	
	@Test (priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_09_ShoppingList_Delete_Circular_Items (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver,TestDataExcel, Functionality, TCName);
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.AddProduct(driver, TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		prodvalu=weeklyad.getprodvalu();
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,  TestDataExcel,Functionality,TCName, proddetails, count, "DeleteIcon_Removedfromshoppinglist");
		driver = logout.Logout(driver, TestDataExcel,Functionality,TCName);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver = shoppinglist.ShoppingList_Navigation(driver, TestDataExcel,Functionality, TCName);
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,  TestDataExcel,Functionality,TCName, proddetails, count, "Removed");
		
	}
	
	@Test (priority=6)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_11_Shopping_List_Edit_weekly_circular_quantity_number_Valid_Value (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.WeeklyAdPage(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.AddProduct(driver, TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		prodvalu=weeklyad.getprodvalu();
		driver=shoppinglist.Edit_ShoppingList(driver, TestDataExcel,Functionality, TCName, proddetails,"weeklyad", "editqty");
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver,  TestDataExcel,Functionality,TCName, proddetails, count, "editqty");
		driver.close();	
	}
	@Test (priority=7)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_14_EditMyItemName (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		int count=0;
		String proddetails="";
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver,TestDataExcel, Functionality, TCName);
		driver = shoppinglist.ShoppingList_Navigation(driver,TestDataExcel, Functionality,TCName);
		driver = shoppinglist.Add_Remove_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Add");
		proddetails=weeklyad.getproddetails();
		count=shoppinglist.getcount();
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Added");	
		driver = shoppinglist.Edit_ShoppingList(driver, TestDataExcel,Functionality, TCName, proddetails,"myitems", "edititem");
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "myitemname_Edited");	
		driver.close();
	}
	
	@Test (priority=8)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_16_Edit_Item_Quantity (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		int count=0;
		String proddetails="";
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver = shoppinglist.ShoppingList_Navigation(driver,TestDataExcel, Functionality,TCName);
		driver = shoppinglist.Add_Remove_MyItems_ShoppingList(driver,TestDataExcel, Functionality, TCName, count, "Add");
		proddetails=weeklyad.getproddetails();
		count=shoppinglist.getcount();
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "Added");	
		driver = shoppinglist.Edit_ShoppingList(driver,TestDataExcel, Functionality, TCName,proddetails, "myitems", "editqty");
		driver=shoppinglist.Check_MyItems_ShoppingList(driver, TestDataExcel,Functionality, TCName, count, "myitemqty_Edited");	
		driver.close();
	}
	
	@Test (priority=9)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC_21_RemoveMultipleItems_CircularItems (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		Writeexcel_RowName write = new Writeexcel_RowName();
		
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String proddetails="";
		String prodvalu="";
		int count=0;
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, TCName);
		driver=weeklyad.WeeklyAdPage(driver,TestDataExcel, Functionality, TCName);
		driver=weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		write.excelwrite(TestDataExcel,Functionality, TCName, "product1", proddetails);
		driver=weeklyad.AddProduct(driver,TestDataExcel,Functionality,TCName, proddetails, count, prodvalu,"circularpage");
		proddetails=weeklyad.getproddetails();
		count=weeklyad.getcount();
		write.excelwrite(TestDataExcel,Functionality, TCName, "product2", proddetails);
		driver = shoppinglist.WeeklyAd_Deals_ShoppingList(driver, TestDataExcel, Functionality,TCName, "2", count, "Delete_Multipleitems");	
		driver.close();
	}	
}
