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

public class Persist_Data_During_Enrollment {
	
	WebDriver driver = null;
	String functionality = "Persist_Data_During_Enrollment";
	Browserbanner browserbanner=new Browserbanner();
	Computed_FullyEnrollment_Flow FullyEnrollment_Flow= new Computed_FullyEnrollment_Flow();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Enrollment_DataPersistency_ActiveSession (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		driver=browserbanner.BrowserBanner(driver,TestDataExcel, Functionality, BrowserType, Banner, node_ip);
		driver= FullyEnrollment_Flow.SignUpPage(driver);
		driver= FullyEnrollment_Flow.AccountLookupPage(driver, TestDataExcel,Functionality, TCName);
		driver= FullyEnrollment_Flow.Verificationpage(driver, TestDataExcel,Functionality, TCName);
		driver= FullyEnrollment_Flow.VerifyByPIIPage(driver,TestDataExcel, Functionality,TCName);
		driver= FullyEnrollment_Flow.Validate_DataPersistency_VerificationPage(driver, TestDataExcel,Functionality, TCName);
		driver= FullyEnrollment_Flow.ContactInfoPage(driver,TestDataExcel,Functionality, TCName);
		driver= FullyEnrollment_Flow.Validate_DataPersistency_ContactInfoPage(driver,TestDataExcel, Functionality, TCName);
		driver= FullyEnrollment_Flow.DataPersistency_Closebrowser(driver, TestDataExcel,Functionality, TCName,node_ip);		
	}
}
