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
import computedClass.Computed_MyRewards;
import computedClass.Computed_SoftLogin;
import computedClass.Computed_Static_Info_bar;

public class LoggedIn_for_Rewards_Section 
{
	WebDriver driver = null;
	String functionality="LoggedIn_for_Rewards_Section";
	Computed_MyRewards loggedin = new Computed_MyRewards();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Browserbanner browserbanner=new Browserbanner();
	Computed_SoftLogin softlogin = new Computed_SoftLogin();
	Computed_Static_Info_bar staticinfobar= new Computed_Static_Info_bar();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Rewards_section_for_Hard_Logged_In_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
	
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver,TestDataExcel, Functionality,TCName);
		driver=loggedin.Loggedin_Myrewardpage(driver,TestDataExcel, Functionality, TCName);
		
		driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_Rewards_section_for_Soft_Logged_In_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;

		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality,TCName);
		
		driver=loggedin.Loggedin_Myrewardpage(driver, TestDataExcel,Functionality,TCName);
		
		driver.close();
	 }
	
	@Test (priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003__Validate_Edit_Account_Details_for_Hard_Logged_In_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality,TCName);
		driver=loggedin.Loggedin_Myrewardpage_editacc(driver, TestDataExcel,Functionality,TCName,"hardlogin");
		driver.close();
	}
	
	@Test (priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004__Validate_Edit_Account_Details_for_Soft_Logged_In_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality,TCName);
		driver=loggedin.Loggedin_Myrewardpage_editacc(driver, TestDataExcel,Functionality,TCName,"softlogin");
		driver.close();
	}
	
	@Test (priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC005_Validate_the_functionality_of_Useful_Links_section_for_Hard_Login_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	 {
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality,TCName);
		driver=loggedin.Loggedin_Myrewardpage_usefulinks(driver,TestDataExcel, Functionality,TCName);
		driver.close();
	 }
	
	@Test (priority=6)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC006_Validate_the_functionality_of_Useful_Links_section_for_Soft_Login_user (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality,TCName);
		driver=loggedin.Loggedin_Myrewardpage_usefulinks(driver, TestDataExcel,Functionality,TCName);
		driver.close();
	}
	@Test (priority=7)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC007_Verify_the_Recent_Transactions_page_HardLogin (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
	
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality,TCName);
		driver=staticinfobar.LoginStaticinfobar_Rewards(driver, TestDataExcel,Functionality, TCName);
		driver=loggedin.Myreward_RecentTransactions(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
	
	@Test (priority=8)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC008_Verify_the_Recent_Transactions_page_SoftLogin (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality,TCName);
		driver=loggedin.Myreward_RecentTransactions(driver,TestDataExcel,Functionality, TCName);
		driver.close();
	}
}
