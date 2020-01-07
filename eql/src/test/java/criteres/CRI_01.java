package criteres;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageCreerTypeCritere;
import pageObject.PageCriteres;
import supportTools.EBrowser;
import supportTools.TechTools;

public class CRI_01 {

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

		//Connexion
		logPage.login("admin", "admin");
		HomePage homePage = logPage.connection(driver);
		
		// Aller sur la page critere
		PageCriteres pageCrit = homePage.allerSurPageCriteres(driver);
		
		// Vérification page critère
		// Vérification nom des colonnes
		assertEquals("Nom", pageCrit.titreColonne1.getText());
		assertEquals("Code", pageCrit.titreColonne2.getText());
		assertEquals("Type", pageCrit.titreColonne3.getText());
		assertEquals("Activé", pageCrit.titreColonne4.getText());
		assertEquals("Opérations", pageCrit.titreColonne5.getText());
		assertTrue(pageCrit.btnCreer.isDisplayed());
		
		// Aller sur la page créer un critère - remplir le champ et annuler
		PageCreerTypeCritere pageNouvCrit = pageCrit.creerCriteres(driver);
		TechTools.inputText(pageNouvCrit.champNom, "Critère - Test bouton [Annuler]");
		pageNouvCrit.choixType(driver, pageNouvCrit.participantListe);
		assertTrue(pageNouvCrit.valMultRessources.isSelected());
		assertTrue(pageNouvCrit.hierarchie.isSelected());
		assertTrue(pageNouvCrit.active.isSelected());
		TechTools.inputText(pageNouvCrit.champDescription, "Critère - Test bouton [Annuler]");
		
		// Retour sur la page 
		PageCriteres pageCrit2 = pageNouvCrit.annulation(driver);
		
		// Création d'un nouveau critère et enregistrement
		PageCreerTypeCritere pageNouvCrit2 = pageCrit2.creerCriteres(driver);
		TechTools.inputText(pageNouvCrit2.champNom, "Critère - Test bouton [Enregistrer]");
		pageNouvCrit2.choixType(driver, pageNouvCrit2.participantListe);
		assertTrue(pageNouvCrit2.valMultRessources.isSelected());
		assertTrue(pageNouvCrit2.hierarchie.isSelected());
		assertTrue(pageNouvCrit2.active.isSelected());
		TechTools.inputText(pageNouvCrit2.champDescription, "Critère - Test bouton [Enregistrer]");
		
		// Retour page critères et vérification création critère "Critère - Test bouton [Enregistrer]"
		PageCriteres pageCrit3 = pageNouvCrit2.creationFin(driver);
		Thread.sleep(2000);
		// Verification dans le tableau
		
		// Création d'un nouveau critère
		PageCreerTypeCritere pageNouvCrit3 = pageCrit3.creerCriteres(driver);
		TechTools.inputText(pageNouvCrit3.champNom, "Test bouton [Sauver et continuer]");
		pageNouvCrit3.choixType(driver, pageNouvCrit3.participantListe);
		assertTrue(pageNouvCrit3.valMultRessources.isSelected());
		assertTrue(pageNouvCrit3.hierarchie.isSelected());
		assertTrue(pageNouvCrit3.active.isSelected());
		TechTools.inputText(pageNouvCrit3.champDescription, "Critère - Test bouton [Sauver et continuer]");
		pageNouvCrit3.btnSauverContinuer.click();
		Thread.sleep(2000);
		
		assertEquals("Type de critère \"Test bouton [Sauver et continuer]\" enregistré", pageNouvCrit3.messageCreationOK.getText());
		assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer]", pageNouvCrit3.titreModifier.getText());
		PageCriteres pageCrit4 = pageNouvCrit3.annulation(driver);
		Thread.sleep(1000);
		
		// Modification critère "sauver et continuer" sans enregistrer
		PageCreerTypeCritere pageNouvCrit4 = pageCrit4.modifierCritere(driver);
		assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer]", pageNouvCrit4.titreModifier.getText());
		TechTools.inputText(pageNouvCrit4.champNom, "Critère - Test bouton [Sauver et continuer] 2");
		PageCriteres pageCrit5 = pageNouvCrit4.annulation(driver);
		Thread.sleep(1000);
		assertEquals("Test bouton [Sauver et continuer]",pageCrit5.critSauvModif.getText());
		
		// Modification critère "sauver et continuer" puis enregistrement utilisation de sauver et continuer
		PageCreerTypeCritere pageNouvCrit5 = pageCrit5.modifierCritereNom(driver);
		assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer]", pageNouvCrit5.titreModifier.getText());
		TechTools.inputText(pageNouvCrit5.champNom, "Critère - Test bouton [Sauver et continuer] 2");
		pageNouvCrit5.btnSauverContinuer.click();
		Thread.sleep(2000);
		//assertEquals("Type de critère \"Test bouton [Sauver et continuer] 2\" enregistré", pageNouvCrit5.messageCreationOK2.getText());
		//assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer] 2", pageNouvCrit5.titreModifier.getText());
		
		// Retour page "critères" et vérification avant suppression
		PageCriteres pageCrit6 = pageNouvCrit5.annulation(driver);
		assertEquals("Critère - Test bouton [Sauver et continuer] 2", pageCrit6.titreSauvModif2.getText());
		pageCrit6.btnSupprimer.click();
		Thread.sleep(2000);
		assertEquals ("Supprimer Type de critère \"Critère - Test bouton [Sauver et continuer] 2\". Êtes-vous sûr ?", pageCrit6.messageSuppression.getText());
		assertTrue(pageCrit6.btnConfirmSup.isEnabled());
		assertTrue(pageCrit6.btnAnnulerSup.isEnabled());
		PageCriteres pageCrit7 = pageCrit6.annulerSuppression(driver);
		assertEquals("Critère - Test bouton [Sauver et continuer] 2", pageCrit7.titreSauvModif2.getText());
		pageCrit7.btnSupprimer.click();
		assertEquals ("Supprimer Type de critère \"Critère - Test bouton [Sauver et continuer] 2\". Êtes-vous sûr ?", pageCrit7.messageSuppression.getText());
		assertTrue(pageCrit7.btnConfirmSup.isEnabled());
		assertTrue(pageCrit7.btnAnnulerSup.isEnabled());
		PageCriteres pageCrit8 = pageCrit7.confimSuppression(driver);
		Thread.sleep(2000);
		assertEquals("Type de critère \"Critère - Test bouton [Sauver et continuer] 2\" supprimé", pageCrit8.messageConfirmSup.getText());
		assertFalse(pageCrit8.titreSauvModif2.getText()=="Critère - Test bouton [Sauver et continuer] 2");
	}
}
