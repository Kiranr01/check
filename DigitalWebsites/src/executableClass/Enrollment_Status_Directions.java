package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_FullyEnrollment_Flow;
import computedClass.Computed_PreEnrollment_Flow;

public class Enrollment_Status_Directions {
	
	WebDriver driver;
	String functionality = "Enrollment_Status_Directions";
	Computed_FullyEnrollment_Flow fullyenrolled = new Computed_FullyEnrollment_Flow();
	Computed_PreEnrollment_Flow preenrolled = new Computed_PreEnrollment_Flow();
	Browserbanner browserbanner =new Browserbanner();
	
	@Test(priority=1) 
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_check_navigation_for_Fullyenrolled_User (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = fullyenrolled.SignUpPage(driver);
		driver = fullyenrolled.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver.close();	
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_check_navigation_for_PreEnrolled_User (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = preenrolled.SignUpPage(driver, TestDataExcel,Functionality, TCName);
		driver = preenrolled.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver.close();
		
	}	
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_check_navigation_for_Fully_Enrolled_but_not_linked (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = fullyenrolled.SignUpPage(driver);
		driver = fullyenrolled.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}	
}
