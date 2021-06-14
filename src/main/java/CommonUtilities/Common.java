package CommonUtilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class Common {
	
	public static WebDriver driver;
	
	public static void movetoanelement(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static void selectbytext(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public static String getcurrentdatetime()
	{
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();
		String datetime = dt.format(now).toString();
		return datetime;
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{


                TakesScreenshot scrShot =((TakesScreenshot)webdriver);

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

                File DestFile=new File(fileWithPath);
                
                FileUtils.copyFile(SrcFile, DestFile);

    }

	

}
