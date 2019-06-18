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

public class Login_Or_Signup_Global_Nav {
	
	WebDriver driver = null;
	String functionality="Login_Or_Signup_Global_Nav";
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Browserbanner browserbanner=new Browserbanner();
	
	@Test(priority=1) 
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_LogInSign_FullyEnrolled_Linked_to_SEG_rewards (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality, tcname);
		driver.close();
		
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_LogInSign_FullyEnrolled_NOT_Linked_to_SEG_rewards (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.HardLogin_FullyEnrolledUser(driver,TestDataExcel, Functionality, tcname);
		driver.close();
		
	}
		
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_LogInSign_Pre_Enrolled_User (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String tcname = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.HardLogin_PreEnrolledUser(driver, TestDataExcel,Functionality, tcname);
		driver.close();		
	}
}
