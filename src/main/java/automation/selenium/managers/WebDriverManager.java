package automation.selenium.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {

	private WebDriver driver;
	private String driverType ="CHROME";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    String chromeDriverPath = null;
   
	    private String driverpath()
	    {
			    
	    String filepath = null; 
	    String str = System.getProperty("user.dir");    
	    filepath=str+"/src/test/resources/drivers/chromedriver";  
	    return filepath;
	    }

    public WebDriver getDriver() {
	if (driver == null)
	    driver = createDriver();
	return driver;
    }

    private WebDriver createDriver() {
	    driver = createLocalDriver();
	    return driver;
    }

    private WebDriver createLocalDriver() {
    chromeDriverPath = driverpath();
	System.setProperty(CHROME_DRIVER_PROPERTY, chromeDriverPath); 
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
    }

    public void closeDriver() {
    	driver.close();
    	driver.quit();
    }

}
