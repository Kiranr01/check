package executableClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import computedClass.Computed_Digital_Coupons;
import computedClass.Computed_HardLogin;
import computedClass.Computed_MyAccount;
import computedClass.Computed_Personalisedoffers;
import computedClass.Computed_SoftLogin;
import computedClass.Computed_Static_Info_bar;
import computedClass.Computed_WeeklyAd;

public class HardLogin_Loggedin_Account 
{
	WebDriver driver;
	String functionality="HardLogin_Loggedin_Account";
	Browserbanner browserbanner=new Browserbanner();
	Computed_HardLogin hardlogin = new Computed_HardLogin();
	Computed_Digital_Coupons dc=new Computed_Digital_Coupons();	
	Computed_Personalisedoffers po=new Computed_Personalisedoffers();
	Computed_WeeklyAd wa=new Computed_WeeklyAd();
	Computed_Static_Info_bar sib = new Computed_Static_Info_bar();
	Computed_SoftLogin softlogin =  new Computed_SoftLogin();
    Computed_MyAccount myAcct = new Computed_MyAccount();
    
	@Test (priority=1)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC001_HardLogin_Access_features (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;	
		String prod="";
		String prodvalu="";
		int count=0;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality,TCName);
		driver=dc.Loggedin_Coupons_Homepage(driver,TestDataExcel, Functionality,TCName, prod, count);
		driver=po.Loggedin_Personalisedoffers(driver, TestDataExcel,Functionality,TCName);
		driver=wa.WeeklyAdPage(driver,TestDataExcel, Functionality, TCName);
		driver=wa.AddProduct(driver,TestDataExcel,Functionality,TCName, prod, count, prodvalu, "circularpage");
		driver=sib.LoginStaticinfobar_Rewards(driver,TestDataExcel, Functionality,TCName);
		driver=sib.LoginStaticinfobar_MyAccount(driver,TestDataExcel, Functionality, TCName,"HardLogin"); 
		driver.close();
	}
	
	@Test(priority=2)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
    public void TC002_HardLogin_Edit_PII_and_save (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException

    {
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;	
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
        driver=softlogin.SoftLogin_SaveCoupon(driver,TestDataExcel, Functionality,TCName);
        driver=hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,TCName);    
        driver=myAcct.Loggedin_MyAccountpage(driver,TestDataExcel, Functionality, TCName,"Save");
        driver.close();
    }
	
	@Test(priority=3)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC004_HardLogin_stateExpiry (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;	
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		driver=hardlogin.Global_HardLogin(driver, TestDataExcel,Functionality,TCName);
	    driver=hardlogin.HardLogin_CheckExpiration(driver,TestDataExcel, Functionality, TCName);
		driver.close();
	}
	
	@Test(priority=4)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void  TC006_HardLogin_CCC_number_and_Forgot_password_link(String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
		System.out.println("sdhg");
		driver=hardlogin.Validate_HardLogin_Modal_Links(driver, TestDataExcel,Functionality,TCName);
		driver.close();
	}
	
	@Test(priority=5)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
	public void TC012_Validate_HardLoginModal (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
	{
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
	    driver=hardlogin.HardLogin_ErrorValidation(driver, TestDataExcel,Functionality, TCName);
		driver.close();
	}
	
	
	@Test(priority=6)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
    public void TC008_SMS_preferences_for_opt_in_and_opt_out_NOT_enrolled_for_marketing_SMS (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException

    {
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
        driver=softlogin.SoftLogin_Rewards(driver, TestDataExcel,Functionality,TCName);
        driver=hardlogin.Account_HardLogin(driver, TestDataExcel,Functionality,TCName);    
        driver=myAcct.MarketingSMS_NotEnrolled(driver,TestDataExcel, Functionality, TCName);
        driver.close();
    }
	
	@Test(priority=7)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
    public void TC011_SMS_preferences_for_opt_in_and_opt_out_user_previously_opted_in_for_SMS_SEG_fully_enrolled (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
    {
		//For getting current method name and passing as tcname
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
        driver=softlogin.SoftLogin_Rewards(driver,TestDataExcel, Functionality,TCName);
        driver=hardlogin.Account_HardLogin(driver,TestDataExcel, Functionality,TCName);    
        driver=myAcct.MarketingSMS_AlreadyEnrolled(driver,TestDataExcel, Functionality, TCName);
        driver.close();
    }
	
	@Test(priority=8)
	@Parameters({"BrowserType","Banner","node_ip","TestDataExcel"})
    public void TC003_HardLogin_First_time_login_No_recaptcha (String BrowserType,String Banner,String node_ip,String TestDataExcel) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, AWTException
    {
		String TCName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String Functionality=functionality;
		
		driver = browserbanner.BrowserBanner(driver,TestDataExcel, Functionality,BrowserType,Banner,node_ip);
        driver=hardlogin.HardLoginFirstym_norecaptcha(driver, TestDataExcel,Functionality, TCName);
        driver.close();
    }
}
