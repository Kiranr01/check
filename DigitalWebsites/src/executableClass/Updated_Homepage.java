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
import computedClass.Computed_HomePage;
import computedClass.Computed_SoftLogin;


public class Updated_Homepage
{
	WebDriver driver = null;
	String functionality="Updated_Homepage";
	Browserbanner browserbanner=new Browserbanner();
	Computed_HomePage homepage = new Computed_HomePage();
	Computed_SoftLogin softlogin = new Computed_SoftLogin();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Home_page_for_Logged_out_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);		
		System.out.println("1");
		driver=homepage.Home_topbanner(driver,TestDataExcel, Functionality,tcname);
		System.out.println("2");
		driver=homepage.Home_logosguest(driver, TestDataExcel,Functionality,tcname);
		System.out.println("3");
		driver=homepage.Home_CouponRotator(driver, TestDataExcel,Functionality,tcname);
		driver=homepage.Home_bottomblock(driver, TestDataExcel,Functionality,tcname);
		driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_Home_page_for_Soft_Login (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		
		driver=homepage.Home_topbanner(driver, TestDataExcel,Functionality,tcname);
		driver=homepage.Home_logos(driver, TestDataExcel,Functionality,tcname);
		driver=homepage.Home_CouponRotator(driver,TestDataExcel, Functionality,tcname);
		driver=homepage.Home_bottomblock(driver,TestDataExcel, Functionality,tcname);
		driver.close();
	}
	@Test (priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_Home_page_for_Hard_Login (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality,tcname);
		driver=homepage.Home_topbanner(driver,TestDataExcel, Functionality,tcname);
		driver=homepage.Home_logos(driver, TestDataExcel,Functionality,tcname);
		driver=homepage.Home_CouponRotator(driver, TestDataExcel,Functionality,tcname);
		driver=homepage.Home_bottomblock(driver,TestDataExcel, Functionality,tcname);
		driver.close();
	}	
}
