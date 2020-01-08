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
	public void test() throws InterruptedException {
		
		driver.get(url);
		LoginPage logPage = PageFactory.initElements(driver, LoginPage.class);
		
		// variables 
		String nom = "DU";
		String prenom = "Jean";
		String iD = "jdu";
		String password ="$jdump1";
		String email ="jdu@test.fr";
		
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
		//Vérification champs + boutons
		assertTrue(partPage.champDetailsPerso.getText().isEmpty());
		assertTrue(partPage.champFiltrePar.getText().isEmpty());
		assertTrue(partPage.btnFiltre.isEnabled());
		assertTrue(partPage.iconeLoupe.isEnabled());
		assertTrue(partPage.btnCreer.isEnabled());
		
		// Créer un participant : vérification onglet Données Personnelles + bloc utilisateur lié
		PageCreerParicipant creerPart = partPage.creerPartPage(driver);
		assertEquals("Données personnelles", creerPart.titreOngletDP.getText());
		assertTrue(creerPart.champID.getText().isEmpty());
		assertTrue(creerPart.champNom.getText().isEmpty());
		//assertTrue(creerPart.champPrenom.getText().isEmpty());
		assertTrue(creerPart.caseGenererCode.isSelected());
		assertTrue(creerPart.btnNonLie.isSelected());
		assertTrue(creerPart.btnUtilisateurExistant.isEnabled());
		assertTrue(creerPart.listeType.isEnabled());
		
		// Vérifier les boutons "enregistrer", "Sauver et continuer" et "annuler"
		assertTrue(creerPart.btnAnnuler.isEnabled());
		assertTrue(creerPart.btnEnregistrer.isEnabled());
		assertTrue(creerPart.btnSauverContinuer.isEnabled());
		
		//  Création d'un participant et enregistrement
		TechTools.inputText(creerPart.champPrenom, prenom);
		TechTools.inputText(creerPart.champNom, nom);
		TechTools.inputText(creerPart.champID, iD);
		creerPart.btnNouvelUtilisateur.click();
		Thread.sleep(2000);
		TechTools.inputText(creerPart.champNomUtilisateur, iD);
		TechTools.inputText(creerPart.champMotPasse, password);
		TechTools.inputText(creerPart.champMotPasseConf, password);
		TechTools.inputText(creerPart.champEmail, email);
		PageParticipants pagePart2 = creerPart.enregistrerParticipant(driver);
		assertEquals("Participant enregistré", pagePart2.messageCreation.getText());
		
		// Recherche utilisateur créé
		TechTools.inputText(pagePart2.champDetailsPerso, prenom);
		pagePart2.btnFiltre.click();
		assertTrue(pagePart2.rechercheResult.isDisplayed());
		pagePart2.btnPlusOption.click();
		assertTrue(pagePart2.champDebutPerAct.getText().isEmpty());
		assertTrue(pagePart2.champFinPerAct.getText().isEmpty());
		
	}

}
