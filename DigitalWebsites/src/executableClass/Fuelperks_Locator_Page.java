package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import computedClass.Computed_FuelPerk;

public class Fuelperks_Locator_Page 
{
	WebDriver driver;
	String functionality="Fuelperks_Locator_Page";
	Browserbanner browserbanner=new Browserbanner();
	Computed_FuelPerk fuelperk=new Computed_FuelPerk();
	
	@Test(priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_Fuelperks_locator_Search_with_ZIP(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;	
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=fuelperk.FuelPerk_Zipcode(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC002_Fuelperks_locator_Search_with_city_and_state(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();	
		String Functionality = functionality;	
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver = fuelperk.FuelPerk_CityState(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
}
