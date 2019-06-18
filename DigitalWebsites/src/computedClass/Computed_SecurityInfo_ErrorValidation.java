package computedClass;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import Utility.Data;
import Utility.Readexcel_RowName;
import generatedClass.POM_Generated_AccountSecurityPage;

public class Computed_SecurityInfo_ErrorValidation 
{
	Data obj=new Data();
	public WebDriver ResetPassword_ErrorMsgValidation(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws IOException, InterruptedException, AWTException 
	{
		POM_Generated_AccountSecurityPage acctSecurity= new POM_Generated_AccountSecurityPage(driver);
		
		 try
		    {
			    new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
				String Pwd_Lessthan8Digits=Readexcel_RowName.getValue("Pwd_Lessthan8Digits");
				String Pwd_Greaterthan16Digits=Readexcel_RowName.getValue("Pwd_Greaterthan16Digits");
				String Pwd_NoCaps=Readexcel_RowName.getValue("Pwd_NoCaps");
				String Pwd_NoNumber=Readexcel_RowName.getValue("Pwd_NoNumber");
				String Pwd_NoLower=Readexcel_RowName.getValue("Pwd_NoLower");
				String Password = Readexcel_RowName.getValue("Password");
				String Confirm_Password = Readexcel_RowName.getValue("Confirm_Password");
				String Error_Msg;
			
	    // Not Matching Passwords error validation
				acctSecurity.type_txt_Set_Password1_Field(Password);
				acctSecurity.type_txt_Set_Password2_Field(Confirm_Password);
				acctSecurity.click_txt_Set_Password1_Field();
				new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_NotMatching_Passwords");
				Error_Msg= Readexcel_RowName.getValue("Error_Message");
				if(acctSecurity.isDisplayed_txt_Error_NotSamePwds_Msg())
				    {
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_NotSamePwds_Msg()))
				     {
				     Reporter.log("Error message is displayed when Passwords are not matching : "+acctSecurity.getText_txt_Error_NotSamePwds_Msg());
					 }
				     else
				     {
				     obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"wrngerr_msg");
				     Assert.fail("Displayed Error Message is not the expected : "+acctSecurity.getText_txt_Error_NotSamePwds_Msg()); 
				     }    
				    }
					else
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is not displayed when Passwords are not matching :"+acctSecurity.getText_txt_Error_NotSamePwds_Msg());
					}	
		      	
	   // Password is less than 8 digit
				acctSecurity.type_txt_Set_Password2_Field(" ");
				acctSecurity.type_txt_Set_Password1_Field(Pwd_Lessthan8Digits);
				acctSecurity.click_txt_Set_Password2_Field();
				new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_Password_Requirement");
				Error_Msg= Readexcel_RowName.getValue("Error_Message");
				if(acctSecurity.isDisplayed_txt_Error_SetPassword_Info_Msg())
				    {
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_SetPassword_Info_Msg()))
				     {
				     Reporter.log("Error message is displayed when Password is less than 8 digits : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					 }
				     else
				     {
				     obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_wrngmsg");
				     Assert.fail("Displayed Error Message is not the expected : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg()); 
				     }    
				    }
					else
					{
						obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is not displayed when Password is less than 8 digits :"+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					}	
		      	
		 // Password is greater than 16 digits
				acctSecurity.type_txt_Set_Password1_Field(Pwd_Greaterthan16Digits);
				acctSecurity.click_txt_Set_Password2_Field();
				if(acctSecurity.isDisplayed_txt_Error_SetPassword_Info_Msg())
				    {
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_SetPassword_Info_Msg()))
				     {
				     Reporter.log("Error message is displayed when Password is more than 16 digits : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					 }
				     else
				     {
				     obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_wrngmsg");
				     Assert.fail("Displayed Error Message is not the expected : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg()); 
				     }    
				    }
					else
					{
						obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is not displayed when Password is more than 16 digits :"+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					}	
		      	
	    // Password does not have capital letter
				acctSecurity.type_txt_Set_Password1_Field(Pwd_NoCaps);
				acctSecurity.click_txt_Set_Password2_Field();
				if(acctSecurity.isDisplayed_txt_Error_SetPassword_Info_Msg())
				    {
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_SetPassword_Info_Msg()))
				     {
				     Reporter.log("Error message is displayed when Password does not have any capital letter : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					 }
				     else
				     {
				    	 obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_wrngmsg");
				     Assert.fail("Displayed Error Message is not the expected : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg()); 
				     }    
				    }
					else
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is not displayed when Password doesnt have any capital letter :"+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					}	
		     
	  // Password does not have number
				acctSecurity.type_txt_Set_Password1_Field(Pwd_NoNumber);
				acctSecurity.click_txt_Set_Password2_Field();
				if(acctSecurity.isDisplayed_txt_Error_SetPassword_Info_Msg())
				    {
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_SetPassword_Info_Msg()))
				     {
				     Reporter.log("Error message is displayed when Password does not have any number : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					 }
				     else
				     {
				    	 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_wrngmsg");
				     Assert.fail("Displayed Error Message is not the expected : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg()); 
				     }    
				    }
					else
					{
						obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is not displayed when Password doesnt have any number :"+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					}	
		        // Password does not have lower letter
				acctSecurity.type_txt_Set_Password1_Field(Pwd_NoLower);
				acctSecurity.click_txt_Set_Password2_Field();
				if(acctSecurity.isDisplayed_txt_Error_SetPassword_Info_Msg())
				    {
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_SetPassword_Info_Msg()))
				     {
				     Reporter.log("Error message is displayed when Password does not have any lower letter : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					 }
				     else
				     {
				     obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_wrngmsg");
				     Assert.fail("Displayed Error Message is not the expected : "+acctSecurity.getText_txt_Error_SetPassword_Info_Msg()); 
				     }    
				    }
					else
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is not displayed when Password doesnt have any lower letter :"+acctSecurity.getText_txt_Error_SetPassword_Info_Msg());
					}	
	      }
					 catch(Exception e)
					    {
						    obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_resetpwd");
					    	
					    	Assert.fail("Error in Reset Password ");
					    }
						return driver;
	}
	public WebDriver ResetPIN_ErrorMsgValidation(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws IOException, InterruptedException, AWTException 
	{
		POM_Generated_AccountSecurityPage acctSecurity= new POM_Generated_AccountSecurityPage(driver);
		
		/* try
		    {*/
			    new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
				String PIN_Repeat=Readexcel_RowName.getValue("PIN_Repeat");
				String PIN_Phone=Readexcel_RowName.getValue("PIN_Phone");
				String PIN_EasilyGuessable=Readexcel_RowName.getValue("PIN_EasilyGuessable");
				String PIN_House=Readexcel_RowName.getValue("PIN_House");
				String valid_pin=Readexcel_RowName.getValue("Pin");
				String Confirm_Pin = Readexcel_RowName.getValue("Confirm_Pin");

				String Error_Msg;
				String PIN_CRC = Readexcel_RowName.getValue("PIN_CRC");
			
		 
	    // Not Matching PINs error validation
				obj.waitForElement(driver, acctSecurity.txt_Email_Address_Field);
				//First attempt
				acctSecurity.type_txt_Set_Pin1_Field(valid_pin);
				acctSecurity.type_txt_Set_Pin2_Field(Confirm_Pin);
				acctSecurity.click_txt_Set_Pin1_Field();
				new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_ConfirmPIN_NotMachingPIN_Msg");
				Error_Msg= Readexcel_RowName.getValue("Error_Message");
				if(acctSecurity.isDisplayed_txt_Error_NotSamePINs_Msg())
				    {
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_NotSamePINs_Msg()))
				     {
				     Reporter.log("Error message is displayed when PINs are not matching : "+acctSecurity.getText_txt_Error_NotSamePINs_Msg());
					 }
				     else
				     {
				     obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_wrngmsg");
				     Assert.fail("Displayed Error Message is not the expected : "+acctSecurity.getText_txt_Error_NotSamePINs_Msg()); 
				     }
				     }
					else
					{
						obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is not displayed when PINs are not matching :"+acctSecurity.getText_txt_Error_NotSamePINs_Msg());
					}	
				driver.navigate().refresh();
		//Repeating Digit PIN error validation
				
				acctSecurity.type_txt_Set_Pin2_Field("");
				acctSecurity.type_txt_Set_Pin1_Field(PIN_Repeat);
				acctSecurity.click_txt_Set_Pin2_Field();
				new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_Pin_Error_RepeatingNumbers_Msg");
				Error_Msg= Readexcel_RowName.getValue("Error_Message");
				if(acctSecurity.isDisplayed_txt_Error_SetPIN_Info_Msg())
				    {
					System.out.println(Error_Msg);
					System.out.println(acctSecurity.getText_txt_Error_SetPIN_Info_Msg());
				     if(Error_Msg.equals(acctSecurity.getText_txt_Error_SetPIN_Info_Msg()))
				     {
				     Reporter.log("Error message is displayed when repeated digits PIN is entered : "+acctSecurity.getText_txt_Error_SetPIN_Info_Msg());
				    /* Actions builder = new Actions(driver);
				     builder.moveToElement(myaccountpage.click_Info_Icon).perform();*/
				     /* if(acctSecurity.click_Info_Icon.isDisplayed())
				      	{
				    	 System.out.println("Pop up");
				    	 Reporter.log("PIN requirement pop up is opened when error message is displayed :"+acctSecurity.getText_click_Info_Icon());
				      	}
				    */ /* else
				      	{
				    	 Assert.fail("PIN requirement pop up is NOT opened when error message is displayed");
				        }*/
					  }
				     else
				     {
				    	 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
				     Assert.fail("Error message is NOT displayed when repeated digits PIN is entered : "+acctSecurity.getText_txt_Error_SetPIN_Info_Msg()); 
				     }
				     }
				else
					{
					    obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
						Assert.fail("Error message is NOT displayed when repeated digits PIN is entered :"+acctSecurity.getText_txt_Error_SetPIN_Info_Msg());
					}	
				driver.navigate().refresh();
		//Easily guessable PIN error validation
				
					acctSecurity.type_txt_Set_Pin1_Field(PIN_EasilyGuessable);
					acctSecurity.click_txt_Set_Pin2_Field();
					new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_Pin_Error_RepeatingNumbers_Msg");
					Error_Msg= Readexcel_RowName.getValue("Error_Message");
					if(acctSecurity.isDisplayed_txt_Error_SetPIN_Info_Msg())
					    {
						
					    if(Error_Msg.trim().equals(acctSecurity.getText_txt_Error_SetPIN_Info_Msg().trim()))
					     Reporter.log(" Error message displayed is same as Error message expected if PIN is easily guessable : "+acctSecurity.getText_txt_Error_SetPIN_Info_Msg());
					     else
					     {
					     obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
					     Assert.fail("Error message displayed is NOT same as Error message expected if PIN is easily guessable : "+acctSecurity.getText_txt_PIN_Requirement_Popup()); 
					     }
					     } 
					else
						{
						    obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
							Assert.fail("Error message is NOT displayed when easily guessable digits PIN is entered :"+acctSecurity.getText_txt_PIN_Requirement_Popup());
						}	
					driver.navigate().refresh();
					
		//House Number PIN Error Validation
					System.out.println(PIN_House);
						acctSecurity.type_txt_Set_Pin1_Field(PIN_House);
						acctSecurity.click_txt_Set_Pin2_Field();
						new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_Pin_Error_RepeatingNumbers_Msg");
						Error_Msg= Readexcel_RowName.getValue("Error_Message");
						if(acctSecurity.isDisplayed_txt_Error_ConfirmPIN_Info_Msg())
						    {
							System.out.println(Error_Msg);
							String errorInScreen=acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg().trim();
							System.out.println(errorInScreen);
							
							if(Error_Msg.trim().equals(errorInScreen))
							{
							     Reporter.log(" Error message displayed is same as Error message expected if PIN is house number: "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
							}
							     else
							  {
								 obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
							     Assert.fail("Error message displayed is NOT same as Error message expected if PIN is house number: "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg()); 
						    }
						    }
						     else
						     {
						     obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
						     Assert.fail("Error message is NOT displayed when house number is entered as PIN number : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg()); 
						     }
						driver.navigate().refresh();
		//CRC Number PIN Error Validation
						  System.out.println(PIN_CRC);
							acctSecurity.type_txt_Set_Pin1_Field(PIN_CRC);
							acctSecurity.click_txt_Set_Pin2_Field();
							new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_Pin_Error_RepeatingNumbers_Msg");
							Error_Msg= Readexcel_RowName.getValue("Error_Message");
							if(acctSecurity.isDisplayed_txt_Error_ConfirmPIN_Info_Msg())
						    {
							System.out.println(Error_Msg);
							String errorInScreen=acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg().trim();
							System.out.println(errorInScreen);
							
							if(Error_Msg.trim().equals(errorInScreen))
							{
							     Reporter.log(" Error message displayed is same as Error message expected if PIN is CRC id : "+acctSecurity.getText_txt_Error_SetPIN_Info_Msg());
							}
							     else
							     {
							     Assert.fail("Error message displayed is NOT same as Error message expected if PIN is CRC id : "+acctSecurity.getText_txt_PIN_Requirement_Popup()); 
						    }
						    }
							else
								{
									Assert.fail("Error message is NOT displayed when CRC number is entered as PIN number :"+acctSecurity.getText_txt_PIN_Requirement_Popup());
								}	
							driver.navigate().refresh();
			//Phone Number PIN Error Validation
							acctSecurity.type_txt_Set_Pin1_Field(PIN_Phone);
							acctSecurity.click_txt_Set_Pin2_Field();
								new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_Pin_Error_RepeatingNumbers_Msg");
								Error_Msg= Readexcel_RowName.getValue("Error_Message");
								if(acctSecurity.isDisplayed_txt_Error_ConfirmPIN_Info_Msg())
							    {
								if(Error_Msg.trim().equals(acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg().trim()))
								{
								     Reporter.log(" Error message displayed is same as Error message expected if PIN is last 4 digits of phone number : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
								}
								    else
								    {
				    
										obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
								    Assert.fail("Error message displayed is NOT same as Error message expected if PIN is last 4 digits of phone number: "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg()); 
							    }
							    }
								else
									{
									obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
									Assert.fail("Error message is NOT displayed when Phone number is entered as PIN number :"+acctSecurity.getText_txt_PIN_Requirement_Popup());
									}	
		//Entering Wrong PIN for 3 times
								driver.navigate().refresh();
								acctSecurity.type_txt_Set_Pin1_Field(PIN_Repeat);
							    acctSecurity.type_txt_Set_Pin2_Field(PIN_Repeat);
								    acctSecurity.click_txt_Set_Pin1_Field();
								 
									if(acctSecurity.isDisplayed_txt_Error_ConfirmPIN_Info_Msg())
									{
	
										 Reporter.log(" Appropriate Error message is displayed when invalid PIN is given for first time : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
									}
									else
									{
										obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nomsg");
										Assert.fail("Appropriate Error message is NOT displayed when invalid PIN is given for first time : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
									}
									acctSecurity.type_txt_Set_Pin1_Field(PIN_Repeat);
								    acctSecurity.type_txt_Set_Pin2_Field(PIN_Repeat);
									    acctSecurity.click_txt_Set_Pin1_Field();
								    if(acctSecurity.isDisplayed_txt_Error_ConfirmPIN_Info_Msg())
								    {
										 Reporter.log(" Appropriate Error message is displayed when invalid PIN is given for Second time : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
								    }
									else
									{
										obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
										Assert.fail("Appropriate Error message is NOT displayed when invalid PIN is given for second time : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
								    }
								    acctSecurity.type_txt_Set_Pin1_Field(PIN_Repeat);
								    acctSecurity.type_txt_Set_Pin2_Field(PIN_Repeat);
									    acctSecurity.click_txt_Set_Pin1_Field();
									    
									    if(acctSecurity.isDisplayed_txt_Error_ConfirmPIN_Info_Msg())
									    {
											 Reporter.log(" Appropriate Error message is displayed when invalid PIN is given for third time : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
									    }
										else
										{
											obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
											Assert.fail("Appropriate Error message is NOT displayed when invalid PIN is given for third time : "+acctSecurity.getText_txt_Error_ConfirmPIN_Info_Msg());
									    }
									    
									    acctSecurity.type_txt_Set_Pin1_Field(PIN_Repeat);
									    acctSecurity.type_txt_Set_Pin2_Field(PIN_Repeat);
										    acctSecurity.click_txt_Set_Pin1_Field();
								    
									new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_PIN_Error_After3 attempts_Msg");
									Error_Msg= Readexcel_RowName.getValue("Error_Message");
									
									if(acctSecurity.isDisplayed_txt_Error_InvalidPins_3Times_Msg())
									    {
										String errorInScreen=acctSecurity.getText_txt_Error_InvalidPins_3Times_Msg().replace("[", "");
										errorInScreen=errorInScreen.replace("]", "");
										errorInScreen=errorInScreen.replace("-", "");
										
										Error_Msg=Error_Msg.replace("[", "");
										Error_Msg=Error_Msg.replace("]", "");
										Error_Msg=Error_Msg.replace("-", "");
										
										System.out.println(errorInScreen);
										System.out.println(Error_Msg);
									     if(Error_Msg.trim().equals(errorInScreen.trim()))
									     {
									     Reporter.log("Appropriate Error message is displayed when invalid PIN is given for third time : "+acctSecurity.getText_txt_Error_InvalidPins_3Times_Msg());
									     }
									     else
									     {
									    	 obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
									    	 Assert.fail("Appropriate Error message is NOT displayed when invalid PIN is given for third time : "+acctSecurity.getText_txt_Error_InvalidPins_3Times_Msg());
									 
									     }
	}
									  /*  }
									    
		  catch(Exception e)
		    {
		    	obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_nopin");
		    	System.out.println(e);
		    	Assert.fail("PIN section is not displayed ");
		    }*/
			return driver;
	}
	
	public WebDriver PIN_Field_Validation(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws IOException, InterruptedException, AWTException 
	{
		POM_Generated_AccountSecurityPage acctSecurity= new POM_Generated_AccountSecurityPage(driver);
		Actions action = new Actions(driver);
		 try
		    {
			    new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
				String PIN_Character=Readexcel_RowName.getValue("Pin");
				String Confirm_Pin =Readexcel_RowName.getValue("Confirm_Pin");
				acctSecurity.type_txt_Set_Pin1_Field(PIN_Character);
			    acctSecurity.click_txt_Set_Pin2_Field();
			    if(acctSecurity.getText_txt_Set_Pin1_Field().equals(""))
			    {
			    	System.out.println("special");
			    	Reporter.log("PIN Field accepts character or special character");
			    }
			    else
			    {
			    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_pinfield");
			    	Assert.fail("PIN Field does not accept character or special character");
			    }
			    //PIN HELP TEXT
			    if(acctSecurity.isDisplayed_click_Info_Icon_SetPIN())
			    {
			    	Reporter.log("Info icon is displayed in Set PIN Field");
			    	action.moveToElement(acctSecurity.click_Info_Icon_SetPIN).build().perform();
			    	action.moveToElement(acctSecurity.click_Info_Icon_SetPIN).moveToElement(acctSecurity.txt_PIN_Requirement_Popup1).click().build().perform();
			        String ax=acctSecurity.getText_txt_PIN_Requirement_Popup1();
			        System.out.println(ax);
			        if(ax.contains("Must not be four repeating digits"))
			        {
			        	Reporter.log("PIN help text is displayed while mouse oing on Info icon");
			        }
			        else
			        {
			        	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nopintext");
			        	Assert.fail("PIN help text is NOT  displayed while mouse oing on Info icon");
			        }
			        //EYE ICON
			        acctSecurity.type_txt_Set_Pin1_Field(Confirm_Pin);
				    acctSecurity.click_txt_Set_Pin2_Field();
				    String Type= acctSecurity.txt_Set_Pin1_Field.getAttribute("type");
				    if(Type.equals("password"))
				    {
				    	Reporter.log("PIN is displayed in encrypted form");
				    }
				    else
				    {
				    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nopin");
				    	Assert.fail("PIN is not displayed in encrypted form");
				    }
				    acctSecurity.click_click_Eye_Icon_SetPIN();
				    String Type1= acctSecurity.txt_Set_Pin1_Field.getAttribute("type");
				    if(Type1.equals("text"))
				    {
				    	Reporter.log("User is able to see the numbers after clicking Eye icon");
				    }
				    else
				    {
				    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_numnotdisplayed");
				    	Assert.fail("User is NOT able to see the numbers after clicking Eye icon");
				    }
				    
				    
				    
			    }
		    }
			    catch(Exception e)
			    {
			    	obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nopin");
			    	System.out.println(e);
			    	Assert.fail("PIN section is not displayed ");
			    }
			return driver;
	}
	public WebDriver Invalid_Domain_ErrorValidation(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String TestDataColumn) throws IOException, InterruptedException, AWTException 
	{
		POM_Generated_AccountSecurityPage acctSecurity= new POM_Generated_AccountSecurityPage(driver);
		//Data obj=new Data();
		 try
		    {
			 new Readexcel_RowName().excelRead(TestDataExcel,Functionality,TCName);
			 String Invalid_Domain=Readexcel_RowName.getValue(TestDataColumn);
			
			 new Readexcel_RowName().excelRead("ErrorMessageSheet",Functionality,"Error_Invalid_Domain_Email");
			 String Error_Msg= Readexcel_RowName.getValue("Error_Message");
			 acctSecurity.type_txt_Email_Address_Field(Invalid_Domain);
			 acctSecurity.click_txt_Email_Address_Field();
			 acctSecurity.click_txt_Set_Password1_Field();
			 if(acctSecurity.isDisplayed_txt_Error_InvalidEmail())
               {
            	   Reporter.log("Error message is displayed when user enteres invalid domain:"+Invalid_Domain);
            	   if(acctSecurity.getText_txt_Error_InvalidEmail().equals(Error_Msg))
            	   	{
	                  Reporter.log("Appropriate Error message is displayed as:"+acctSecurity.getText_txt_Error_InvalidEmail());      
                    }
            	   else
            	   {
            		   obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_wrongmsg");
            		   Assert.fail("Appropriate Error message is NOT displayed as:"+acctSecurity.getText_txt_Error_InvalidEmail());
            	   }   
               }
               else
               {
            	   obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"err_nomsg");
            	   Assert.fail("Error message is NOT displayed when user enteres invalid domain");
               }
			 }
		    
		    catch(Exception e)
		    {
		    	obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"err_accsec");
		    	System.out.println(e);
		    	Assert.fail("Error in Account Security page ");
		    }
		return driver;
	}
	
	public WebDriver PasswordSetScreen(WebDriver driver,String TestDataExcel,String Functionality,String TCName) throws FileNotFoundException, IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException 
	{
		POM_Generated_AccountSecurityPage accsecpage = new POM_Generated_AccountSecurityPage(driver);
		
		Data obj=new Data();
		
		try
		{
			if(accsecpage.isEnabled_txt_Email_Address_Field())
			{
			 String email=accsecpage.getValue_txt_Email_Address_Field();	
			 if (email!=null)	
			 {
				Reporter.log("Email address is pre-populated for fully enrolled user");
			 }
			 else
			 {
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"empty_email");
				Assert.fail("Email address is not pre-populated for Fully enrolled user");
			 }
		
		    }
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"nonedit_email");
				Assert.fail("Email address field is not editable for Fully enrolled user");
			}
			if(accsecpage.isDisplayed_click_Email_Address_Message_Verify())
			{
				Reporter.log("Email address message is displayed in the security info screen");
			}
			
			
		}
		catch(NoSuchElementException e)
		{
			obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"email_error");
			Assert.fail("Issue with Email address field in Security info page");
		}
		try
		{
			if(accsecpage.isDisplayed_txt_Set_Password1_Field())
			{
				Reporter.log("Set Password field is displayed in Password set screen in the Security info page");
			}
			else
			{
				obj.Ashot_Screenshot(driver, TestDataExcel,Functionality, TCName,"setpwd_error");
				Assert.fail("Set password field is not displayed");
			}
			if(accsecpage.isDisplayed_txt_Set_Password2_Field())
			{
				Reporter.log("Confirm Password field is displayed in Password set screen in the Security info page");
			}
		}
		
		catch(NoSuchElementException e)
		{
			obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"pwd_error");
			Assert.fail("Issue with password fields in password set screen");
		}
		
		try
		{
			if(accsecpage.isDisplayed_txt_Set_Pin1_Field())
			{
				obj.Ashot_Screenshot(driver,TestDataExcel, Functionality, TCName,"pin_error");
				Assert.fail("Pin field is displayed in Password set screen");
			}
		}
		catch(NoSuchElementException e)
		{
			Reporter.log("Pin fields are not displayed in Password set screen");
		}
		
		return driver;
	}

}
	
