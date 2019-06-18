package Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class Data 
{
	/*public static WebDriver driver;
	WebElement webElement = null;
	WebDriverWait webDriverWait;
	String Pass_screenShot=".\\ScreenShot_Pass\\";
	String Fail_screenShot=".\\ScreenShot_Failed\\";	*/
	
	//Get row num
	public int rownum(String ExcelName,String SheetName) throws IOException
	{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+ExcelName+".xlsx");
		@SuppressWarnings("resource")
		Workbook wb = new XSSFWorkbook(fs);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		return lastRow;
	}

	//Screen Shots 
	public void Screenshot(WebDriver driver,String name,String Path) throws IOException
	{
		File scrfile=(File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(Path+name+".jpeg"));
	}
	
	//Ashot
	public  WebDriver Ashot_Screenshot(WebDriver driver,String TestDataExcel,String Functionality,String TCName,String screenshotName) throws IOException
	{
		
		String FolderPath = System.getProperty("user.dir")+"\\Screenshots\\"+TestDataExcel+"\\"+Functionality+"\\"+TCName;
		String FilePath = System.getProperty("user.dir")+"\\Screenshots\\"+TestDataExcel+"\\"+Functionality+"\\"+TCName+"\\"+screenshotName+".png";
		Path Path = null;	
		try 
		{
			Path = Paths.get(FolderPath);
			if(Files.notExists(Path))
			{
				 Files.createDirectories(Path);
			}
			File file = new File(FilePath);
		    try 
		    {
		    	if (!file.exists()) 
		    	{
		    		file.createNewFile();
		        } 
		    	else 
		    	{
		    		file.delete();		               
		    		file.createNewFile();    
		    	}
		    } 
		    catch (IOException e) 
		    {
		    	e.printStackTrace();
		    }
		} 
		catch (Exception e) 
		{
		    System.err.println("Cannot create Screenshot directories - " + e);
		}
			
		Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
		
		// To save the screenshot in desired location
		ImageIO.write(screenshot.getImage(), "PNG",new File(FilePath));
		
		return driver;
	}
	
	//waitForElementClickable
	public WebDriver waitForElementClickable(WebDriver driver,WebElement item)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(item));
		return driver;
	}
	
	//wait for element	
	public WebDriver waitForElement(WebDriver driver,WebElement item)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(item));
		return driver;
	}
	
	@SuppressWarnings("unchecked")
	public List<WebDriver> waitForElements(WebDriver driver, List<WebElement> elements) 
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		return (List<WebDriver>) driver;	
	}
	
	public WebDriver waitForElementselected(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeSelected(element));
		return driver;
	}
	
	//scrollingToElementofAPage
	public WebDriver scrollingToElementofAPage(WebDriver driver,WebElement item) 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", item);
		return driver;
	}
	
	//JSClick
	public WebDriver JSClick(WebDriver driver,WebElement item) 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
		return driver;
	}
	
	public WebDriver scrollingToTop(WebDriver driver) 
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,0)");
		return driver;
	}
	
	public WebDriver PageNavigation(WebDriver driver,String url) 
	{
		driver.navigate().to(url);
		return driver;
	}
	
	//move to element
	public WebDriver movetoElementofAPage(WebDriver driver,WebElement item) 
	{
		Actions actions = new Actions(driver);

		actions.moveToElement(item).build().perform();
		return driver;
	}
	
	//move to element and click
	public WebDriver movetoElementofAPage_Click(WebDriver driver,WebElement item) 
	{
		Actions actions = new Actions(driver);

		actions.moveToElement(item).click().build().perform();
		return driver;
	}
	public WebDriver movetoElement_JS(WebDriver driver,WebElement item) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", (item));
		return driver;
	}
	//WindowPopup
	/*public String popuppath()
	{
		String popup="O:\\QA and Testing Department\\Roadrunner\\Digital Websites\\Selenium_Grid\\Windowpopup.exe";
		return popup;	
	}*/
}
