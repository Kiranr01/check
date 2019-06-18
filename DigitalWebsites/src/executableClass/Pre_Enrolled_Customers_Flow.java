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
import computedClass.Computed_PreEnrollment_Flow;

public class Pre_Enrolled_Customers_Flow 
{
	WebDriver driver = null;
	String functionality = "Pre_Enrolled_Customers_Flow";
	Browserbanner browserbanner=new Browserbanner();
	Computed_PreEnrollment_Flow preenrollmentflow= new Computed_PreEnrollment_Flow();
	Computed_EnrollmentVerify Enrollmentverify= new Computed_EnrollmentVerify();
	Computed_DB db = new Computed_DB();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_EnrollNewProgram_Phonenumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.AccountSecurityPage(driver,TestDataExcel, Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_EnrollinNewProgram_old_SEG_CRC_number (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.AccountSecurityPage(driver,TestDataExcel, Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
		
	}
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_EnrollinNewProgram_PlentiCardNumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountSecurityPage(driver, TestDataExcel,Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
		
	}
	
	@Test(priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_EnrollinNewProgram_G_AND_G_card_number (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountSecurityPage(driver, TestDataExcel,Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
		
	}
	
	@Test(priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC005_EnrollinNewProgram_SignUp_As_A_New_Member (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.AccountSecurityPage(driver, TestDataExcel,Functionality, TCName);
		driver=Enrollmentverify.Enrollverify(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		db.DB_CheckEnrolledDetails(TestDataExcel,Functionality, TCName);
	}
}
