package automation.selenium.managers;

import org.openqa.selenium.WebDriver;

public class TestContext {

	private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
   

    public TestContext() {
    webDriverManager = new WebDriverManager();
	pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	
    }

    public PageObjectManager getPageObjectManager() {
	return pageObjectManager;
    }

}
