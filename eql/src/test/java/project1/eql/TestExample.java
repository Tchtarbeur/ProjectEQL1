package project1.eql;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObject.HomePage;
import pageObject.LoginPage;
import supportTools.EBrowser;
import supportTools.TechTools;

public class TestExample {
	
	String url = "http://localhost:8090/libreplan";
	WebDriver driver;
	
	@FindBy (xpath = "//input[@name='j_username']")
	WebElement nameField;
	
	@FindBy (xpath ="//input[@name='j_password']")
	WebElement passwordField;
	
	@FindBy (xpath ="//input[@id='button']")
	WebElement connectBtn;
	
	// Menu "Ressources"
	@FindBy (xpath="//button[contains(text(),'Ressources')]")
	WebElement ressources;
	
	// Sous-Menu "Participants
	@FindBy (xpath="//a[contains(text(),'Participants')]")
	WebElement participants;
	
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
		
		// Connexion
		TechTools.inputText(nameField, "admin");
		TechTools.inputText(passwordField, "admin");
		
		// Aller sur la page participants
		// c'est là que ça plante quand on utilise les page ça passe mais 
		// là les actions en les enchainant ne passe pas impossible d'aller cliquer sur le menu ressources
		// on a essayé plusieurs techniques différentes mais sans succés
		
		Actions a = new Actions(driver);
		a.moveToElement(ressources).build().perform();
		participants.click();
		
	}

}
