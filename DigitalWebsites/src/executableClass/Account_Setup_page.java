package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_ContactInfo_ErrorValidation ;

public class Account_Setup_page 
{
	WebDriver driver = null;
	String functionality = "Account_Setup_page";
	Browserbanner browserbanner = new Browserbanner();
	Computed_ContactInfo_ErrorValidation contactinfo = new Computed_ContactInfo_ErrorValidation ();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC005_Error_message_validation_FirstName(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as TCName
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = contactinfo.Contactinfo_nav(driver,TestDataExcel, Functionality,TCName);
		driver = contactinfo.Invalid_Or_Empty_FirstName_ErrMsg(driver,TestDataExcel, Functionality,TCName,"Invalid_Or_Empty_FirstName_ErrMsg");
		driver = contactinfo.Invalid_Or_Empty_LastName_ErrMsg(driver,TestDataExcel,Functionality,TCName, "Invalid_Or_Empty_LastName_ErrMsg");
		driver = contactinfo.Empty_DOB_ErrMsg(driver,TestDataExcel,Functionality,TCName,"Empty_DOB_ErrMsg");
		driver = contactinfo.Empty_PhoneNumber_ErrMsg(driver,TestDataExcel,Functionality,TCName,"Empty_PhoneNumber_ErrMsg");
		driver = contactinfo.Empty_Address_ErrMsg(driver,TestDataExcel,Functionality,TCName, "Empty_Address_ErrMsg");
		driver = contactinfo.Empty_City_ErrMsg(driver,TestDataExcel,Functionality,TCName,"Empty_City_ErrMsg");
		driver = contactinfo.Empty_State_ErrMsg(driver,TestDataExcel,Functionality,TCName,"Empty_State_ErrMsg");
		driver = contactinfo.Empty_Zipcode_ErrMsg(driver,TestDataExcel,Functionality,TCName, "Empty_Zipcode_ErrMsg");
	    driver.close();
	}
	
	@Test (priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_Error_message_validation_Salutation (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = contactinfo.Contactinfo_nav(driver,TestDataExcel, Functionality,TCName);
		driver = contactinfo.ContactInfoPage_Nosalutation(driver,TestDataExcel, Functionality,TCName,"Error_landline_primaryphone");
		driver.close();
		
	}
	@Test (priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC023_ErrorMessage_validation_cellphone_and_Landline (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = contactinfo.Contactinfo_nav(driver,TestDataExcel, Functionality,TCName);
		driver = contactinfo.Empty_Offers_selection(driver,TestDataExcel, Functionality,TCName,"Empty_Offers_selection");
		driver.close();
	}

	@Test (priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC010_Error_message_validation_character_and_special_characters_in_Phone_Number (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver, TestDataExcel,Functionality,BrowserType,Banner,node_ip);
		driver = contactinfo.Contactinfo_nav(driver,TestDataExcel, Functionality,TCName);
		driver = contactinfo.ContactInfoPage_phone(driver,TestDataExcel,Functionality,TCName);
		driver.close();
	
	}

	@Test (priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC019_error_message_Invalid_NPA_number_range_format(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = contactinfo.Contactinfo_nav(driver,TestDataExcel, Functionality,TCName);
		driver = contactinfo.validate_phoneNumber_InvalidNPACodeNumber(driver,TestDataExcel,Functionality,TCName, "Invalid_PhoneNumber_ErrMsg");
		driver.close();
	
	}
	@Test (priority=6)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC020_error_message_Invalid_Central_Office_Code_number_range_format(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = contactinfo.Contactinfo_nav(driver,TestDataExcel, Functionality,TCName);
		driver = contactinfo.validate_phoneNumber_InvalidCentralOfficeCodeNumber(driver,TestDataExcel,Functionality,TCName, "Invalid_PhoneNumber_ErrMsg");
		driver.close();
	}
}
