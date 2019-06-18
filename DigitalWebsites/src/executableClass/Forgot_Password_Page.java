package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_Forgot_Password;

public class Forgot_Password_Page {
	
	WebDriver driver;
	String functionality="Forgot_Password_Page";
	Browserbanner browserbanner=new Browserbanner();
	Computed_Forgot_Password forgotpassword= new Computed_Forgot_Password();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void  TC001_ForgotPassword(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;	
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=forgotpassword.Validate_ForgotPassword(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void  TC003_ForgotPassword_Invalid_email(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=forgotpassword.ValidateErrorMsg_Invalid_Email(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
}
