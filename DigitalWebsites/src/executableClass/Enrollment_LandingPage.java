package executableClass;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import computedClass.Computed_Register;


public class Enrollment_LandingPage {
		
		WebDriver driver;
		String functionality = "Enrollment_LandingPage";
		Browserbanner browserbanner = new Browserbanner();
		Computed_Register register = new Computed_Register();
		
		@Test (priority=1)
		@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
		public void TC001_Enrollment_landing_page(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
		{	
			String Functionality=functionality;
			String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();		
			driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
			driver = register.Enrollment_Landing_Page(driver, TestDataExcel,Functionality,TCName);
			driver.close();
		}
}
