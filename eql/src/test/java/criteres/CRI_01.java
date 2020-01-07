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
/*
	@After
	public void tearDown() {
		driver.quit();
	}
	*/
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
		
		// Modification critère "sauver et continuer"
		PageCreerTypeCritere pageNouvCrit4 = pageCrit4.modifierCritere(driver);
		assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer]", pageNouvCrit4.titreModifier.getText());
		TechTools.inputText(pageNouvCrit4.champNom, "Critère - Test bouton [Sauver et continuer] 2");
		PageCriteres pageCrit5 = pageNouvCrit4.annulation(driver);
		Thread.sleep(1000);
		assertEquals("Test bouton [Sauver et continuer]",pageCrit5.critSauvModif.getText());
		
		// 
	}

}
