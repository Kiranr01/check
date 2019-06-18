package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_MyRewards;


public class Loggedout_Rewards_Page 

{
	WebDriver driver = null;
	String functionality="Loggedout_Rewards_Page";
	Browserbanner browserbanner=new Browserbanner();
	Computed_MyRewards loggedout = new Computed_MyRewards();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Rewards_Page_for_Logged_Out_users (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);	
		driver=loggedout.loggedout_Myreward(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
}

