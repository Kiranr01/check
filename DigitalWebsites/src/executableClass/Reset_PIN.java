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
import computedClass.Computed_MyAccount;
import computedClass.Computed_SoftLogin;

public class Reset_PIN {
	
	WebDriver driver;
	String functionality="Reset_PIN";
	Browserbanner browserbanner=new Browserbanner();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Computed_SoftLogin softlogin =  new Computed_SoftLogin();
	Computed_MyAccount myAcct = new Computed_MyAccount();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Reset_PIN_Account_settings_page (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
	    String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
	    String Functionality=functionality;
	    
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver=hardlogin.Account_HardLogin(driver,TestDataExcel, Functionality,tcname);
	    driver=myAcct.MyAccount_ResetPIN(driver, TestDataExcel,Functionality, tcname,"save");
	   
		driver.close();
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_Reset_PIN_Account_settings_page_cancel (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
	    String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
	    String Functionality=functionality;
	    
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver=hardlogin.Account_HardLogin(driver,TestDataExcel, Functionality,tcname);
	    driver=myAcct.MyAccount_ResetPIN(driver,TestDataExcel, Functionality, tcname,"Cancel");
		driver.close();
	}
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_Reset_PIN_Error_Message_Validation (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
	    String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
	    String Functionality=functionality;
	    
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
	    driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver=hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,tcname);
	    driver=myAcct.ResetPIN_ErrorMsgValidation(driver,TestDataExcel, Functionality, tcname);
		driver.close();
	}
}