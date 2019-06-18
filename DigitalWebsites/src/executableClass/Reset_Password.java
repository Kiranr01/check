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
import computedClass.Computed_Logout;
import computedClass.Computed_MyAccount;
import computedClass.Computed_SoftLogin;

public class Reset_Password {
	
	WebDriver driver;
	String functionality="Reset_Password";
	Browserbanner browserbanner=new Browserbanner();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Computed_SoftLogin softlogin =  new Computed_SoftLogin();
	Computed_MyAccount myAcct = new Computed_MyAccount();
	Computed_Logout logout = new Computed_Logout();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Reset_Password_Account_settings_page (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
	    String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
	    String Functionality=functionality;
	    
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver=hardlogin.Account_HardLogin(driver,TestDataExcel, Functionality,tcname);
	    driver=myAcct.MyAccount_ResetPassword(driver,TestDataExcel, Functionality, tcname,"save");
	    driver=logout.Logout(driver, TestDataExcel,Functionality, tcname);
	    driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
	    //Hard Login with new password
	    driver=hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,tcname);
	    driver=myAcct.MyAccount_ResetPassword_ToOldPassword(driver,TestDataExcel, Functionality, tcname,"save");
		driver.close();
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC005_Validate_the_functionality_of_Cancel_button_in_Reset_Password_section (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
	    String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
	    String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver=hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,tcname);
	    driver=myAcct.MyAccount_ResetPassword(driver, TestDataExcel,Functionality, tcname,"Cancel");
		driver.close();
	}
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_Reset_Password_Error_Message_Validation (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
	    String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
	    String Functionality=functionality;
	    
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver=hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,tcname);
	    driver=myAcct.ResetPassword_ErrorMsgValidation(driver,TestDataExcel, Functionality, tcname);
		driver.close();
	}
	
	@Test(priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_Validate_the_functionality_of_EYE_icon_in_password_section (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
	    String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
	    String Functionality=functionality;
	    
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,tcname);
		driver=hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,tcname);
	    driver=myAcct.Validate_EYEIcon_PAssword(driver,TestDataExcel,Functionality,tcname);	
	}
}
