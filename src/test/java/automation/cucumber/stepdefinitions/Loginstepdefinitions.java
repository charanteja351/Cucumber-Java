package automation.cucumber.stepdefinitions;


import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import CommonUtilities.Common;
import PageObjects.CommonPage;
import PageObjects.Login;
import automation.selenium.managers.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Loginstepdefinitions {
	
	TestContext  testContext;
	Login login;
	CommonPage commonpage ;
	
	public Loginstepdefinitions(TestContext context){
		this.testContext = context;
		login = testContext.getPageObjectManager().getloginpage();
		commonpage = testContext.getPageObjectManager().getcommonpage();
		
	}

	//Login login = new Login(CommonStepdefinitions.driver);
	
	
	@Given("^I am on the Login page$")
	public void logintoapplication() throws InterruptedException
	{  
		commonpage.loginpage();
	}

	@When("^User logins to portal$")
	public void Login_to_portal(DataTable testdata) throws Exception
	{
		Map<String, String> data = testdata.asMap(String.class, String.class);
		login.enterusername(data.get("username"));
		login.enterpassword(data.get("password"));
		login.click_submit();
		
	}
	
	@Given("^I am on the application$")
	public void Appium_test() throws Exception
	{
		
		login.test_appium();
	}
	
	
	/*@When("^I Enter Username$")
	public void enterusername()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user@phptravels.com");
	}
	
	@When("^I Enter Password$")
	public void enterpassword()
	{
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demouser");
	}
	
	@When("^I click on Login$")
	public void submit()
	{
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}*/
	
	@Then("^Verify whether the User profile is Corrects$")
	public void successfulllogin() throws Exception
	{
		login.verifylogisuccessfull();
	}
	
	
	@Given("^Mobile application$")
	public void mobileapplication() throws Exception
	{
		IOSDriver<WebElement> driver;
		//Package and Activity information
		 
			//	adb shell
			//	dumpsys window windows | grep -E 'mCurrentFocus'
				
				//Chromedriver.exe location under Appium installation directory
				//C:\Users\way2automation\AppData\Local\Programs\Appium\resources\app\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win
				
				DesiredCapabilities capabilities = new DesiredCapabilities();
		 
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Charan's iPhone");
		 
				
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				
				//capabilities.setCapability("w3c", false);
				capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
				//capabilities.setCapability("chromedriverExecutable", "D:\\executables\\chromedriver77\\chromedriver.exe");
		 
		 
			
				driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				
				
				driver.get("http://google.com");
				driver.findElement(By.name("q")).sendKeys("Hello Appium !!!");
				
						
				Thread.sleep(5000);
				
				
			
		 
				driver.quit();
	}
	
	
	@Given("^Mobile application ios app$")
	public void mobileapplicationiosapp() throws Exception
	{
	    AppiumDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "iOS");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
	    
	    capabilities.setCapability("app", "io.appium.WebViewApp");
	    capabilities.setCapability("automationName", "Appium");
	    
	    capabilities.setCapability("udid","c84c5fd8fb6cd5e842473a1888c511b7cf8d9bef");
	    
	    System.out.println("test previous");
	    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	    driver.quit();
	}
	
	
	
	
	

}
