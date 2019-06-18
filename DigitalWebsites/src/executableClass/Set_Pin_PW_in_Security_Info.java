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
import computedClass.Computed_SecurityInfo_ErrorValidation;

public class Set_Pin_PW_in_Security_Info {
	
	WebDriver driver = null;
	String functionality="Set_Pin_PW_in_Security_Info";
	Browserbanner browserbanner=new Browserbanner();
	Computed_FullyEnrollment_Flow fullyenrollmentflow = new Computed_FullyEnrollment_Flow();
	Computed_PreEnrollment_Flow preenrollmentflow= new Computed_PreEnrollment_Flow();
	Computed_SecurityInfo_ErrorValidation SecurityInfo= new Computed_SecurityInfo_ErrorValidation();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_FullyEnrolled_NavigateTo_PasswordSetScreen_WithCardNumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
		String Functionality=functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=fullyenrollmentflow.SignUpPage(driver);
		driver=fullyenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=fullyenrollmentflow.Verificationpage(driver,TestDataExcel, Functionality, TCName);
		driver=fullyenrollmentflow.VerifyByPIIPage(driver,TestDataExcel, Functionality, TCName);
		driver=fullyenrollmentflow.ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver=SecurityInfo.PasswordSetScreen(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_FullyEnrolled_NoPinNoPassword_WithCardNumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=fullyenrollmentflow.SignUpPage(driver);
		driver=fullyenrollmentflow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.VerifyByPIIPage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.AccountSecurityPage(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
	
	@Test (priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC011_FullyEnrolled_NavigateTo_PasswordSetScreen_WithPhoneNumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=fullyenrollmentflow.SignUpPage(driver);
		driver=fullyenrollmentflow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.VerifyByPIIPage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver=SecurityInfo.PasswordSetScreen(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}
	
	@Test(priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC013_PreEnrolled_NoPinNoPassword_WithCardNumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver = preenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver = preenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver = preenrollmentflow.AccountSecurityPage(driver,TestDataExcel, Functionality, TCName);
		driver.close();
		
	}
	
	@Test(priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC014_PreEnrolled_NoPinNoPassword_WithPhoneNumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver = preenrollmentflow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver = preenrollmentflow.ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver = preenrollmentflow.AccountSecurityPage(driver, TestDataExcel,Functionality, TCName);
		driver.close();
		
	}
	
	@Test(priority=6)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC015_FullyEnrolled_Check_T_And_C (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=fullyenrollmentflow.SignUpPage(driver);
		driver=fullyenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=fullyenrollmentflow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.VerifyByPIIPage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver=fullyenrollmentflow.AccountSecurityPage(driver, TestDataExcel,Functionality, TCName);
		driver.close();		
	}
	
	@Test(priority=7)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC016_PreEnrolled_Check_T_And_C (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver = preenrollmentflow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver = preenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver = preenrollmentflow.AccountSecurityPage(driver,TestDataExcel, Functionality, TCName);
		driver.close();
		
	}
	
	@Test(priority=8)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC006_FullyEnrolledUser_PasswordSetScreen_ErrorMessageValidation (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver=SecurityInfo.ResetPassword_ErrorMsgValidation(driver, TestDataExcel,Functionality, TCName);	
		driver.close();	
	}
	
	@Test(priority=9)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC008_FullyEnrolledUser_PinSetScreen_ErrorMessageValidation (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
	//For getting current method name and passing as TCName
			String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
			String Functionality=functionality;
			
			driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
			driver= fullyenrollmentflow.SignUpPage(driver);
			driver= fullyenrollmentflow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
			driver=fullyenrollmentflow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
			driver= fullyenrollmentflow.VerifyByPIIPage(driver, TestDataExcel,Functionality,TCName);
			driver=fullyenrollmentflow.ContactInfoPage(driver,TestDataExcel,Functionality, TCName);
			driver= SecurityInfo.ResetPIN_ErrorMsgValidation(driver,TestDataExcel, Functionality, TCName);
			driver.close();
	}
	
	@Test(priority=10)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC007_Validate_ErrorMessage_If_Character_As_A_PINnumber (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver=SecurityInfo.PIN_Field_Validation(driver, TestDataExcel,Functionality, TCName);
		
	}
	
	@Test(priority=11)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC013_Validate_the_blocked_list_of_email_domains_should_not_be_allowed (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
				
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=preenrollmentflow.SignUpPage(driver,TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=preenrollmentflow.ContactInfoPage(driver, TestDataExcel,Functionality, TCName);
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver,TestDataExcel, Functionality, TCName,"Invalid_Domain1");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain2");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain3");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain4");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain5");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain6");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain7");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain8");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain9");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain10");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain11");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain12");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain13");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain14");
		driver=SecurityInfo.Invalid_Domain_ErrorValidation(driver, TestDataExcel,Functionality, TCName,"Invalid_Domain15");
	}	
}