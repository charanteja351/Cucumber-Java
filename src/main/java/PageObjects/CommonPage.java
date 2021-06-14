package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	
    static WebDriver driver;

    String filepath = null;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	
	public CommonPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}
	
	
	public void loginpage() throws InterruptedException
	{
	  	
		   // driver.manage().window().maximize();
			driver.navigate().to("https://www.phptravels.net/");
			Thread.sleep(5000);
	    	driver.findElement(By.xpath("//div[contains(@class,'dropdown-login')]//a[@id='dropdownCurrency']")).click();
	    	driver.findElement(By.xpath("//a[text()='Login']")).click();

	}

}
