package gestionDesRessources;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageCreerParicipant;
import pageObject.PageParticipants;
import supportTools.EBrowser;
import supportTools.TechTools;

public class GRF_01 {
	
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
		
		// Aller sur la page participant
		PageParticipants partPage = homePage.allerSurPageParticipant(driver);
		
		// Verifier les éléments de la page gestion des participants
		// Vérification des titres des colonnes du tableau
		assertEquals("Surnom", partPage.titreColonne1.getText());
		assertEquals("Prénom", partPage.titreColonne2.getText());
		assertEquals("ID", partPage.titreColonne3.getText());
		assertEquals("Code", partPage.titreColonne4.getText());
		assertEquals("En file", partPage.titreColonne5.getText());
		assertEquals("Opérations", partPage.titreColonne6.getText());
		
		// Créer un participant
		PageCreerParicipant creerPart = partPage.creerPartPage(driver);
		
		// Vérification de l'onglet "Données Personnelles"
		// Vérifier Bloc "Données de Base"
		//creerPart.champPrenom.getSize();
		
		// Vérifier Bloc "Utilisateur lié"
		
		
		// Vérifier les boutons "enregistrer", "Sauver et continuer" et "annuler"
		assertTrue(creerPart.btnAnnuler.isEnabled());
		assertTrue(creerPart.btnEnregistrer.isEnabled());
		assertTrue(creerPart.btnSauverContinuer.isEnabled());
		
		//  Création d'un participant et enregistrement
		
	}

}
