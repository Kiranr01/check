package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_HomePage;

public class Global_Nav_Update
{
	WebDriver driver = null;
	String functionality="Global_Nav_Update";
	Browserbanner browserbanner=new Browserbanner();
	Computed_HomePage homepage = new Computed_HomePage();
	
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Rewards_link_in_Global_nav (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;	
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		
		driver=homepage.Globalnavupdate(driver, TestDataExcel,Functionality,TCName);
	    driver.close();
	}
}
