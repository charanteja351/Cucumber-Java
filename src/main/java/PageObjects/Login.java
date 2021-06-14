package PageObjects;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import CommonUtilities.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement username_input;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password_input;
	
	@FindBy(xpath="//button[text()='Login']")
	public WebElement login_btn;
	

	public void enterusername(String username)
	{
		username_input.sendKeys(username);
	}
	
	public void enterpassword(String password)
	{
		password_input.sendKeys(password);
	}
	
	public void click_submit() throws Exception
	{
		login_btn.click();
		Common.takeSnapShot(driver, "/Users/kadavakollucharanteja/Downloads/Cucumber/Screenshots/logins_SS.jpg");
	}
	
	public void verifylogisuccessfull() throws Exception
	{
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//div[@class='row align-items-center']//h3"));
		String Profilename = element.getText();
		System.out.println(Profilename);
		boolean status = Profilename.contains("Demo User");
		Assert.assertEquals(status,true);
		String str = System.getProperty("user.dir");    
	    String screenshotpath=str+"/Screenshots/SS_"+Common.getcurrentdatetime()+".jpg";
		Common.takeSnapShot(driver, screenshotpath);
		driver.close();
	}
	
	public void test_appium() throws MalformedURLException, InterruptedException
	{
		// Android
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		//dc.setCapability("udid", "");  // get it from command prompt after connecting device
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9.0");   // Android version number of your phone
		dc.setCapability("appPackage", "in.amazon.mShop.android.shopping");  // install apk info app in your mobile and you can the info of application
		dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity"); // you can find under activity
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		WebDriver appiumdriver = new AndroidDriver(url,dc);
		Thread.sleep(5000);
 	    appiumdriver.findElement(By.id("in.amazon.mShop.android.shopping:id/new_user")).click();
		Thread.sleep(10000);
		appiumdriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.EditText")).sendKeys("TestTraining");
		

	}
	

}
