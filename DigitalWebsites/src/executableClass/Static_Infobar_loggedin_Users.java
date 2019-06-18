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
import computedClass.Computed_SoftLogin;
import computedClass.Computed_Static_Info_bar;

public class Static_Infobar_loggedin_Users 
{
	WebDriver driver;
	String functionality="Static_Infobar_loggedin_Users";
	Browserbanner browserbanner=new Browserbanner();
	Computed_MyStore mystore = new Computed_MyStore();
	Computed_Static_Info_bar staticinfobar = new Computed_Static_Info_bar();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Computed_SoftLogin softlogin = new Computed_SoftLogin();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Staticbar_links_Hardlogin (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality,tcname);
		driver = mystore.SetStore(driver, TestDataExcel,Functionality, tcname);
		driver = staticinfobar.LoginStaticinfobar_WeeklyAd(driver,TestDataExcel, Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_Rewards(driver, TestDataExcel,Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_MyAccount(driver, TestDataExcel,Functionality, tcname,"Hardlogin");
		driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_Staticbar_Hardlogin_links_navigation_Homepage (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = hardlogin.Global_HardLogin(driver,TestDataExcel, Functionality,tcname);
		driver = mystore.SetStore(driver,TestDataExcel, Functionality, tcname);
		driver = staticinfobar.LoginStaticinfobar_WeeklyAd(driver,TestDataExcel, Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_Rewards(driver, TestDataExcel,Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_MyAccount(driver, TestDataExcel,Functionality,tcname, "Hardlogin");
		driver.close();
	}
	
	@Test (priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_Staticbar_Hard_login_links_navigation_Account_setting_page (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality, tcname);
		driver = hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,tcname );
		driver = mystore.SetStore(driver, TestDataExcel,Functionality, tcname);
		driver = staticinfobar.LoginStaticinfobar_WeeklyAd(driver, TestDataExcel,Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_Rewards(driver, TestDataExcel,Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_MyAccount(driver, TestDataExcel,Functionality,tcname, "Hardlogin");
		driver.close();
	}
	
	@Test (priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_Staticbar_links_Softlogin (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality, tcname);
		driver = mystore.SetStore(driver, TestDataExcel,Functionality, tcname);
		driver = staticinfobar.LoginStaticinfobar_WeeklyAd(driver,TestDataExcel, Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_MyAccount(driver,TestDataExcel, Functionality,tcname, "Softlogin");
		driver.close();
	}
	
	@Test (priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC005_Staticbar_Softlogin_links_navigation_Homepage (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality, tcname);	
		driver = mystore.SetStore(driver, TestDataExcel,functionality, tcname);
		driver = staticinfobar.LoginStaticinfobar_WeeklyAd(driver, TestDataExcel,Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_Rewards(driver, TestDataExcel,Functionality,tcname);
		driver = staticinfobar.LoginStaticinfobar_MyAccount(driver,TestDataExcel, Functionality,tcname, "Softlogin");
		driver.close();
	}
}
