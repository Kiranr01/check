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
import computedClass.Computed_PII_ErrorValidation;

public class PII_Validation 
{
	WebDriver driver = null;
	String functionality="PII_Validation";
	Browserbanner browserbanner=new Browserbanner();
	Computed_FullyEnrollment_Flow FullyEnrollment_Flow = new Computed_FullyEnrollment_Flow();
	Computed_PII_ErrorValidation piierror = new Computed_PII_ErrorValidation();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Select_PII_Verification_method_to_verify_customer_identity_using_Plenti_Card_number (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.VerifyByPIIPage(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC013_Verify_that_if_customer_is_already_authenticated_with_cell_number (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;	
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.VerifyByPIIPage(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}
	
	
	@Test (priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC019_Select_PII_Verification_method_to_verify_customer_identity_using_Registered_Phone_number (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.VerifyByPIIPage(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
	
	@Test (priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC010_Enter_characters_or_special_characters_in_Zip_Code_field (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver,TestDataExcel, Functionality, TCName);
		driver=piierror.Invalid_Zipcode_ErrMsg(driver,TestDataExcel, Functionality, TCName,"Invalid_Zipcode_ErrMsg");
        driver.close();
	}
	
	@Test(priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_Validate_the_error_message_if_customer_enter_invalid_Date_of_Birth_Month_in_single_digit (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB");
		driver=piierror.Invalid_Month_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Month_ErrMsg");
		driver.close();
	}
	
	@Test(priority=6)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC003_Validate_the_error_message_if_customer_enter_invalid_Date_of_Birth_Month_above_12 (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB");
		driver=piierror.Invalid_Month_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Month_ErrMsg");
		driver.close();
	}
	
	@Test(priority=7)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC005_Validate_the_error_message_if_customer_entered_invalid_date_Date_in_single_digit (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB");
		driver=piierror.Invalid_Day_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Day_ErrMsg");
		driver.close();
	}
	
	@Test(priority=8)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC006_Validate_the_error_message_if_customer_entered_invalid_date_date_above_31 (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver,TestDataExcel, Functionality, TCName);
		driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB");
		driver=piierror.Invalid_Day_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Day_ErrMsg");
		driver.close();
	}
	
	@Test(priority=9)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC007_Validate_the_error_message_if_customer_entered_invalid_year_More_than_100_years_past (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB");
		driver=piierror.Invalid_Year_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Year_ErrMsg");
		driver.close();
	}
	
	@Test(priority=9)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC008_Validate_the_error_message_if_customer_entered_invalid_year_Year_in_Future (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB");
		driver=piierror.Invalid_Year_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Year_ErrMsg");
		driver.close();
	}
	
	@Test(priority=10)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_Validate_the_error_message_if_customer_entered_date_of_birth_in_wrong_format_Date_value_in_month_field(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB");
	    driver=piierror.Invalid_Day_Year_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Day_Year_ErrMsg");
	    driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOBB");
	    driver=piierror.Invalid_Month_Day_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Month_Day_ErrMsg");
	    driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB2");
	    driver=piierror.Invalid_Month_Year_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Month_Year_ErrMsg");
	    driver=piierror.PII_Validation_EnterDOB(driver, TestDataExcel,Functionality, TCName,"DOB3");
	    driver=piierror.Invalid_Month_Day_Year_ErrMsg(driver,TestDataExcel,Functionality, TCName,"Invalid_Month_Day_Year_ErrMsg");
	    driver.close();
}
	
	@Test(priority=11)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC016_Verify_the_error_message_if_NPA_number_range_format_is_invalid(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver,TestDataExcel, Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.pii_EnterPhoneNumber(driver, TestDataExcel,Functionality, TCName,"Primary_Phone");
		driver=piierror.Invalid_PhoneNumber_ErrMsg(driver,TestDataExcel,Functionality, TCName, "Invalid_PhoneNumber_ErrMsg");
		driver=piierror.pii_EnterPhoneNumber(driver, TestDataExcel,Functionality, TCName,"Primary_Phone_invalid");
		driver=piierror.Invalid_PhoneNumber_ErrMsg(driver, TestDataExcel,Functionality, TCName,"Invalid_PhoneNumber_ErrMsg");
		driver.close();
	}
	
	@Test(priority=12)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC017_Verify_the_error_message_if_Central_Office_Code_number_range_format_is_invalid (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=FullyEnrollment_Flow.SignUpPage(driver);
		driver=FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver=FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver=piierror.pii_EnterPhoneNumber(driver, TestDataExcel,Functionality, TCName,"Primary_Phone");	
		driver=piierror.Invalid_PhoneNumber_ErrMsg(driver, TestDataExcel,Functionality, TCName,"Invalid_PhoneNumber_ErrMsg");
		driver=piierror.pii_EnterPhoneNumber(driver, TestDataExcel,Functionality, TCName,"Primary_Phone_invalid");
		driver=piierror.Invalid_PhoneNumber_ErrMsg(driver, TestDataExcel,Functionality, "Invalid_PhoneNumber_ErrMsg",TCName);
		driver.close();
	}
	
}
