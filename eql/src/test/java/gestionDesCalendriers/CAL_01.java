package gestionDesCalendriers;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageCalendrier;
import pageObject.PageCreerCalendrier;
import pageObject.PageCreerDerive;
import pageObject.PageCriteres;
import supportTools.EBrowser;
import supportTools.TechTools;

public class CAL_01 {
	
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
	
	//@After
	//public void tearDown() {
		//driver.quit();
	//}

	@Test
	public void test() {
		//Connexion sur l'application libreplan avec le login et le mot de passe admin
		driver.get(url);
		LoginPage logPage = PageFactory.initElements(driver, LoginPage.class);
		logPage.login("admin", "admin");
		HomePage homePage = logPage.connection(driver);
		
		//Vérification de la présence de l'onglet Calendrier
		assertTrue("L'onglet Calendrier n'est pas présent sur la page d'accueil",homePage.calendrier.isDisplayed());
		
		// Aller sur la page Calendrier
		PageCalendrier pageCal = homePage.allerSurPageCal(driver);
		
		//Vérification des titres des colonnes
		assertTrue("L'en-tête de la première colonne n'est pas correct",pageCal.titreColonne1.isDisplayed());
		assertTrue("L'en-tête de la deuxième colonne n'est pas correct",pageCal.titreColonne2.isDisplayed());
		assertTrue("L'en-tête de la troisième colonne n'est pas correct",pageCal.titreColonne3.isDisplayed());
		assertTrue("L'en-tête de la quatrième colonne n'est pas correct",pageCal.titreColonne4.isDisplayed());
		
		//Vérification de la présence du bouton créer
		assertTrue("Le boutton Créer n'est pas présent sur la page Calendriers",pageCal.boutonCreer.isEnabled());
		
		//Aller sur la page Créer Calendrier en cliquant sur le boutton "Créer"
		PageCreerCalendrier pageCreerCal = pageCal.allerSurPageCreerCal(driver);
		
		//Vérifier le titre de l'onglet "Données de calendrier"
		assertTrue("Le nom de l'onglet n'est pas correct",pageCreerCal.onglet.isDisplayed());
		
		//Vérifier les présences des boutons [Enregistrer], [Enregistrer et continuer] et [Annuler]
		assertTrue("Le boutton Enregistrer n'est pas présent sur la page Créer Calendriers",pageCreerCal.boutonEnregistrer.isEnabled());
		assertTrue("Le boutton Enregistrer et continuer n'est pas présent sur la page Créer Calendriers",pageCreerCal.boutonEnregistrerEtContinuer.isEnabled());
		assertTrue("Le boutton Annuler n'est pas présent sur la page Créer Calendriers",pageCreerCal.boutonAnnuler.isEnabled());
		
		//Remplir le champ "Nom"
		pageCreerCal.saisirNom("Calendrier - Test 1");
		
		//Vérifier que la case "Générer le code" est cochée
		assertTrue("La case [Générer le code] n'est pas cochée",pageCreerCal.caseCode.isSelected());
		
		//Enregistrer
		pageCreerCal.retourSurPageCal(driver);
		
		//Vérifier que le calendrier "Calendrier - Test 1" a bien été créé
		assertEquals("Le Calendrier n'a pas été créé","Calendrier de base \"Calendrier - Test 1\" enregistré", driver.findElement(By.xpath("//span[contains(text(),'Calendrier - Test 1')]")).getText());
		
		WebElement derive = driver.findElement(By.xpath("//span[contains(text(),'Calendrier - Test 1')]/following::span[@title='Créer une dérive']"));
				
		//Aller sur la page Créer une dérive
		PageCreerDerive pageCreerDerive = pageCal.allerSurPageCreerDerive(driver,derive);
		
		//Vérifier que le champ "Nom" est vide
		assertTrue("Le champ Nom n'est pas vide",pageCreerDerive.champNom.getText().isEmpty());
		
		//Vérifier que le champ "Type" est "Dérivé du calendrier calendrier 1"
		assertEquals("Le champ type n'est pas \"Dérivé du calendrier Calendrier - Test 1\"","Dérivé du calendrier Calendrier - Test 1",pageCreerDerive.champType.getText());
		
		//Remplir le champ "Nom" avec "Calendrier - Test 1"
		pageCreerDerive.saisirNom("Calendrier - Test 1");
		
		//Vérifier que la case "générer code" est cochée
		assertTrue("La case [Générer le code] n'est pas cochée",pageCreerDerive.caseCode.isSelected());
		
		//Cliquer sur "Enregistrer et continuer"
		pageCreerDerive.enregistrerEtContinuer();
		
		//Vérification de l'affichage du message d'erreur "Calendrier - Test 1 existe déjà"
		assertEquals("Le message d'erreur n'apparraît pas","Calendrier - Test 1 existe déjà",pageCreerDerive.messageErreur.getText());

		//Remplir le champ "Nom" avec " Calendrier - Test Calendrier Dérivé"
		pageCreerDerive.saisirNom(" Calendrier - Test Calendrier Dérivé");
		
		//Fermer le message d'erreur
		pageCreerDerive.fermerMessageErreur(driver);
		
		//Remplir le champ "Nom" avec " Calendrier - Test Calendrier Dérivé"
		pageCreerDerive.saisirNom(" Calendrier - Test Calendrier Dérivé");
		
		//Cliquer sur "Enregistrer et continuer"
		//pageCreerDerive.enregistrerEtContinuer();
		
		//Vérification de l'affichage du message de validation "Calendrier de base "Calendrier - Test Calendrier Dérivé" enregistré"
		//assertEquals("Le message de validation n'apparraît pas","Calendrier - Test Calendrier Dérivé",pageCreerDerive.messageValidation.getText());
	}

}