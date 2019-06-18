package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_Logout;
import computedClass.Computed_SoftLogin;


public class Logout 
{
	WebDriver driver = null;
	String functionality = "Logout";
	Browserbanner browserbanner=new Browserbanner();
	Computed_SoftLogin softlogin = new Computed_SoftLogin();
	Computed_Logout logout = new Computed_Logout();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Logout (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;	
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,TCName);
		driver = logout.Logout(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}
}
