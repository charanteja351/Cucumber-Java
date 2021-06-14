package automation.selenium.managers;

import org.openqa.selenium.WebDriver;

import PageObjects.CommonPage;
import PageObjects.Login;
import PageObjects.MyAccount;

public class PageObjectManager {
	private WebDriver driver;
    private Login login;
    private CommonPage commonpage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

    public Login getloginpage() {
		return (login == null) ? login = new Login(driver) : login;
	}
    
    public CommonPage getcommonpage() {
		return (commonpage == null) ? commonpage = new CommonPage(driver) : commonpage;
	}
	
}

