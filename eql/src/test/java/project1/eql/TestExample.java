package project1.eql;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObject.HomePage;
import pageObject.LoginPage;
import supportTools.EBrowser;
import supportTools.TechTools;

public class TestExample {
	
	String url = "http://localhost:8090/libreplan";
	WebDriver driver;
	/*
	@FindBy (xpath = "//div='Ressources&nbsp;'")
	WebElement resourcesMenu;
	*/
	@Before
	public void setUp() {
		driver = TechTools.chooseBrowser(EBrowser.firefox);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		
		driver.get(url);
		LoginPage logPage = PageFactory.initElements(driver, LoginPage.class);
		logPage.login("admin", "password");
		HomePage homePage = logPage.connection(driver);
		
	}

}
