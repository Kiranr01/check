package executableClass;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_DB;
import computedClass.Computed_EnrollmentVerify;
import computedClass.Computed_FullyEnrollment_Flow;
public class Fully_Enrolled_Customers_Flow 
{
	WebDriver driver = null;
	String functionality = "Fully_Enrolled_Customers_Flow";
	Browserbanner browserbanner=new Browserbanner();
	Computed_FullyEnrollment_Flow FullyEnrollment_Flow= new Computed_FullyEnrollment_Flow();
	Computed_EnrollmentVerify Enrollmentverify = new Computed_EnrollmentVerify();
	Computed_DB  db = new Computed_DB(); 
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_EnrollNewProgram_Phonenumber_VerifybyPII (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver= FullyEnrollment_Flow.SignUpPage(driver);
		driver= FullyEnrollment_Flow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver= FullyEnrollment_Flow.VerifyByPIIPage(driver,TestDataExcel, Functionality,TCName);
		driver=FullyEnrollment_Flow.ContactInfoPage(driver,TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.AccountSecurityPage(driver,TestDataExcel,Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
	
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC006_EnrollinNewProgram_old_SEG_CRC_number_VerifybyPII (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;	
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver= FullyEnrollment_Flow.SignUpPage(driver);
		driver= FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver= FullyEnrollment_Flow.VerifyByPIIPage(driver, TestDataExcel,Functionality,TCName);
		driver=FullyEnrollment_Flow.ContactInfoPage(driver,TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.AccountSecurityPage(driver,TestDataExcel,Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
	}
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC009_EnrollinNewProgram_PlentiCardNumber_VerifybyPII (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver= FullyEnrollment_Flow.SignUpPage(driver);
		driver= FullyEnrollment_Flow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver,TestDataExcel, Functionality, TCName);
		driver= FullyEnrollment_Flow.VerifyByPIIPage(driver,TestDataExcel, Functionality,TCName);
		driver=FullyEnrollment_Flow.ContactInfoPage(driver,TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.AccountSecurityPage(driver,TestDataExcel,Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
	}
	
	@Test(priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC012_EnrollinNewProgram_G_AND_G_cardNumber_VerifybyPII (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;	
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver= FullyEnrollment_Flow.SignUpPage(driver);
		
		driver= FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver= FullyEnrollment_Flow.VerifyByPIIPage(driver, TestDataExcel,Functionality,TCName);
		driver=FullyEnrollment_Flow.ContactInfoPage(driver,TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.AccountSecurityPage(driver,TestDataExcel,Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
	}
}
