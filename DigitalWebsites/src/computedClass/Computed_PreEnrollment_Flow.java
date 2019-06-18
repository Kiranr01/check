package computedClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import Utility.Data;
import Utility.Readexcel_RowName;
import Utility.Writeexcel_RowName;
import generatedClass.POM_Generated_AccountLookupPage;
import generatedClass.POM_Generated_AccountSecurityPage;
import generatedClass.POM_Generated_CongratulationsPage;
import generatedClass.POM_Generated_ContactInfoPage;
import generatedClass.POM_Generated_Homepage;
import generatedClass.POM_Generated_One_Quick_Thing_Popup;

public class Computed_PreEnrollment_Flow 
{
	Data obj=new Data();
	//Signup page
	public WebDriver SignUpPage(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException 
	{
		POM_Generated_Homepage homepage = new POM_Generated_Homepage(driver);
		
		try
		{
			obj.waitForElement(driver, homepage.click_Login_Or_Signup_Button);
			homepage.click_click_Login_Or_Signup_Button();
			obj.waitForElement(driver, homepage.click_Register_Button);
			homepage.click_click_Register_Button();			
		}
		catch(Exception e)
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"error_signup");
			driver.close();
			Assert.fail("Error in Signup page");
		}
		return driver;
	}
	
	//Accountlookup page for pre enrolled and net new user
	public WebDriver AccountLookupPage(WebDriver driver, String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException 
	{
		POM_Generated_AccountLookupPage accountlookuppage = new POM_Generated_AccountLookupPage(driver);
		POM_Generated_ContactInfoPage contactinfopage = new POM_Generated_ContactInfoPage(driver);
		POM_Generated_One_Quick_Thing_Popup onequickthing = new POM_Generated_One_Quick_Thing_Popup(driver);
		//Data obj=new Data();
		
		new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
		try
		{		
			obj.waitForElement(driver, accountlookuppage.txt_Card_Number_Field);
			if(Readexcel_RowName.getValue("Card_Type(Card/Phone/CRC)").equalsIgnoreCase("Card")||Readexcel_RowName.getValue("Card_Type(Card/Phone/CRC)").equalsIgnoreCase("CRC"))
			{
				accountlookuppage.type_txt_Card_Number_Field(Readexcel_RowName.getValue("Phone/Card_Number"));
				obj.scrollingToElementofAPage(driver, accountlookuppage.click_Get_Started_With_SEG_Button);
				accountlookuppage.click_click_Get_Started_With_SEG_Button();
			}
			else if(Readexcel_RowName.getValue("Card_Type(Card/Phone/CRC)").equalsIgnoreCase("Phone"))
			{
				accountlookuppage.type_txt_Phone_Number_Field(Readexcel_RowName.getValue("Phone/Card_Number"));
				obj.scrollingToElementofAPage(driver, accountlookuppage.click_Get_Started_With_SEG_Button);
				accountlookuppage.click_click_Get_Started_With_SEG_Button();
			}
			else if(Readexcel_RowName.getValue("Card_Type(Card/Phone/CRC)").equalsIgnoreCase("NewMember"))
			{	
				//obj.scrollingToElementofAPage(driver, accountlookuppage.click_Signup_As_New_Member_Button);
				accountlookuppage.click_click_Signup_As_New_Member_Button();
			}
			try
			{
				obj.waitForElement(driver, onequickthing.click_Ok_I_Will_Do_This_Now_Button);
				onequickthing.click_click_Ok_I_Will_Do_This_Now_Button();
			}
			catch(Exception e1)
			{
				
			}
			obj.waitForElement(driver, contactinfopage.txt_HeaderName_Text)	;
			
			Reporter.log("Account lookup page completed successfully");
		}	
		catch (Exception e) 
		{
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"invalid_card");
			Assert.fail("Invalid Card number or Error in Account lookup page");
        }
		return driver;
	}
	
	//Contact info page
	public WebDriver ContactInfoPage(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException 
	{	
		POM_Generated_ContactInfoPage contactinfopage = new POM_Generated_ContactInfoPage(driver);
		POM_Generated_AccountSecurityPage accountsecuritypage = new POM_Generated_AccountSecurityPage(driver);
		//Data obj=new Data();
		Writeexcel_RowName write = new Writeexcel_RowName();
		new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
		try
		{
			if(!contactinfopage.getText_txt_HeaderName_Text().equals("Hello"))
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"invalid_contactinfo");
				driver.close();
				Assert.fail("Contact info header is displaying wrongly");
			}
			if (contactinfopage.getValue_ddl_Salutation_Field().equals("--"))
			{
				contactinfopage.select_ddl_Salutation_Field(Readexcel_RowName.getValue("Salutation"));
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_ysal");
				driver.close();
				Assert.fail("Salutation is pre populating");
			}
			if (contactinfopage.getValue_txt_Fname_Field().equals(""))
			{
				contactinfopage.type_txt_Fname_Field(Readexcel_RowName.getValue("FirstName"));
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_yfname");
				driver.close();
				Assert.fail("FirstName is pre populating");
			}
			if (contactinfopage.getValue_txt_Address_Field().equals(""))
			{
				contactinfopage.type_txt_Address_Field(Readexcel_RowName.getValue("Address1"));
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_yadd");
				driver.close();
				Assert.fail("Address is pre populating");
			}
			if (contactinfopage.getValue_txt_Lname_Field().equals(""))
			{
				contactinfopage.type_txt_Lname_Field(Readexcel_RowName.getValue("LastName"));
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_ylname");
				driver.close();
				Assert.fail("LastName is pre populating");
			}	
			if (Readexcel_RowName.getValue("Address2")!=null)
			{
				if (contactinfopage.getValue_txt_Additional_Address_Field().equals(""))
				{
					contactinfopage.type_txt_Additional_Address_Field(Readexcel_RowName.getValue("Address2"));
				}
				else
				{
					obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_yaddr");
					driver.close();
					Assert.fail("Additional Address is pre populating");
				}
			
			}
			else
			{
				if (!contactinfopage.getValue_txt_Additional_Address_Field().equals(""))
				{
					obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_addaddr");
					driver.close();
					Assert.fail("Additional Address is pre populating");
				}
			}
			obj.scrollingToElementofAPage(driver, contactinfopage.txt_Month_Field);
			if (contactinfopage.getValue_txt_Month_Field().equals(""))
			{
				contactinfopage.type_txt_Month_Field(Readexcel_RowName.getValue("Month"));
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_ymnth");
				driver.close();
				Assert.fail("Month is pre populating");
			}	
			if (contactinfopage.getValue_txt_Date_Field().equals(""))
			{
				contactinfopage.type_txt_Date_Field(Readexcel_RowName.getValue("Date"));
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_ydat");
				driver.close();
				Assert.fail("Date is pre populating");
			}
		
			if (contactinfopage.getValue_txt_Year_Field().equals(""))
			{
				contactinfopage.type_txt_Year_Field(Readexcel_RowName.getValue("Year"));
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_yyr");
				driver.close();
				Assert.fail("Year is pre populating");
			}	
			obj.scrollingToElementofAPage(driver, contactinfopage.txt_City_Field);
			if (contactinfopage.getValue_txt_City_Field().equals(""))
			{
				contactinfopage.type_txt_City_Field(Readexcel_RowName.getValue("City").trim());
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_ycity");
				driver.close();
				Assert.fail("City is pre populating");
			}
			obj.scrollingToElementofAPage(driver, contactinfopage.ddl_State_Field);
			
			
			if (contactinfopage.getValue_ddl_State_Field().equals("Select"))
			{
				contactinfopage.select_ddl_State_Field(Readexcel_RowName.getValue("State").trim());
				Thread.sleep(500);
				String statecode= contactinfopage.getValue_ddl_State_Field();
				
				write.excelwrite(TestDataExcel,Functionality, TCName, "State_Code", statecode);
				
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_ystate");
				driver.close();
				Assert.fail("State is pre populating");
			}
		
			obj.scrollingToElementofAPage(driver, contactinfopage.txt_Primary_Phone_Number_Field);
			if (contactinfopage.getValue_txt_Primary_Phone_Number_Field().equals(""))
			{
				contactinfopage.type_txt_Primary_Phone_Number_Field(Readexcel_RowName.getValue("Primary_Phone"));
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_ph");
				driver.close();
				Assert.fail("Primary_Phone_Number is pre populating");
			}
			obj.scrollingToElementofAPage(driver, contactinfopage.txt_Zipcode_Field);
			if (contactinfopage.getValue_txt_Zipcode_Field().equals(""))
			{
				contactinfopage.type_txt_Zipcode_Field(Readexcel_RowName.getValue("Zip"));
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_yzip");
				driver.close();
				Assert.fail("ZipCode is pre populating");
			}
			
			if(!(contactinfopage.isSelected_click_TextMeOffers_Yes_Button() || contactinfopage.isSelected_click_TextMeOffers_No_Button()))
			{
				if(Readexcel_RowName.getValue("Text_Me_Offers(Y/N)").equalsIgnoreCase("Y"))
				{
					contactinfopage.click_click_TextMeOffers_Yes_Button();
				}
				else
				{
					contactinfopage.click_click_TextMeOffers_No_Button();
				}
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_ytxt");
				driver.close();
				Assert.fail("Text_Me_Offers radio button is already selected");
			}
				
			contactinfopage.click_click_Submit_Form_Button();;			
			obj.waitForElement(driver, accountsecuritypage.txt_Email_Address_Field);
			
			Reporter.log("Contact info page completed successfully");
		}
		catch (Exception e) 
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_contactinfo");
		//	driver.close();
			System.out.println(e);
			Assert.fail("Error in Contactinfo page");
			
    	}
		return driver;
	}
	
	//Account Info page
	public WebDriver AccountSecurityPage(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException 
	{
		POM_Generated_AccountSecurityPage accountsecuritypage = new  POM_Generated_AccountSecurityPage(driver);
		POM_Generated_CongratulationsPage congratulationspage = new POM_Generated_CongratulationsPage(driver);
		//Data obj=new Data();
		
		
		new Readexcel_RowName().excelRead(TestDataExcel,Functionality , TCName);
		try
		{
			if (accountsecuritypage.getValue_txt_Email_Address_Field().equals(""))
			{
				accountsecuritypage.type_txt_Email_Address_Field(Readexcel_RowName.getValue("EmailAddress"));
			}
			else
			{
				accountsecuritypage.type_txt_Email_Address_Field(Readexcel_RowName.getValue("EmailAddress"));
			}
		
			if (accountsecuritypage.getValue_txt_Set_Password1_Field().equals(""))
			{
				accountsecuritypage.type_txt_Set_Password1_Field(Readexcel_RowName.getValue("Password"));
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_ypwd");
				driver.close();
				Assert.fail("Password is pre populating");
			}				
			if (accountsecuritypage.getValue_txt_Set_Password2_Field().equals(""))
			{
				accountsecuritypage.type_txt_Set_Password2_Field(Readexcel_RowName.getValue("Confirm_Password"));	
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_confpwd");
				driver.close();
				Assert.fail("Confirm Password is pre populating");
			}	 	

			if (accountsecuritypage.getValue_txt_Set_Pin1_Field().equals(""))
			{
				accountsecuritypage.type_txt_Set_Pin1_Field(Readexcel_RowName.getValue("Pin"));
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_pin");
				driver.close();
				Assert.fail("Pin is pre populating");
			} 					
			if (accountsecuritypage.getValue_txt_Set_Pin2_Field().equals(""))
			{
				accountsecuritypage.type_txt_Set_Pin2_Field(Readexcel_RowName.getValue("Confirm_Pin"));
			}
			else
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_confpin");
						
				driver.close();
				Assert.fail("Confirm Pin is pre populating");
			}
			
			
			obj.scrollingToElementofAPage(driver, accountsecuritypage.click_Terms_And_Condition_Checkbox);
			accountsecuritypage.click_click_Terms_And_Condition_Checkbox();
			
			obj.scrollingToElementofAPage(driver, accountsecuritypage.txt_NeverMissADeal_Yes_Button);
			String cpn=Readexcel_RowName.getValue("Save_With_Digital_Coupons(Y/N)");
			if(cpn.equalsIgnoreCase("Y"))
			{
				accountsecuritypage.click_txt_NeverMissADeal_Yes_Button();
			}
			else if(cpn.equalsIgnoreCase("N"))
			{
				accountsecuritypage.click_txt_NeverMissADeal_No_Button();
			}
			obj.scrollingToElementofAPage(driver, accountsecuritypage.click_Security_Next_Button);
			obj.waitForElement(driver, accountsecuritypage.click_Security_Next_Button);	
			accountsecuritypage.click_click_Security_Next_Button();
			
			Reporter.log("Account info page completed successfully");
			
			obj.waitForElement(driver, congratulationspage.txt_ThankYou_Message_Text);
			
			
			if(congratulationspage.isDisplayed_txt_ThankYou_Message_Text())
			{
				Reporter.log("Congratulations Message is displayed correctly");
			}	
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
				driver.close();
				Assert.fail("Congratulations Message not displayed");
				
			}
		}
		catch (Exception e) 
		{	
			//driver.close();
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_acc");
			System.out.println(e);
			Assert.fail("Error in Accountinfo page");
			
		}
		return driver;
	}
}