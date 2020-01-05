package gestionDesRessources;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageMachines;
import supportTools.EBrowser;
import supportTools.TechTools;

public class GRF_02 {

	String url = "http://localhost:8090/libreplan";
	WebDriver driver;


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

		//Connexion
		logPage.login("admin", "admin");
		HomePage homePage = logPage.connection(driver);
		
		// Aller sur la page "machines"
		PageMachines pageMachine = homePage.allerSurPageMachines(driver);
		
		// Vérification des éléments
		

	}

}
