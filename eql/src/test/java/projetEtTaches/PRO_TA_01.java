package projetEtTaches;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageListeDesProjets;
import pageObject.PageProjet;
import pageObject.SurFenetreNewProjet;
import supportTools.EBrowser;
import supportTools.TechTools;

public class PRO_TA_01 {

	String url = "http://localhost:8090/libreplan";
	WebDriver driver;
	String nom = "";
	String modele = "";
	String code = "";
	String echeance = "";
	String client = "";
	String calendrier = "Default";
	String BudgetTotal = "0 €";
	String Heures = "0";
	String Etat = "PRE-VENTES";

	@Before
	public void setUp() {
		driver = TechTools.chooseBrowser(EBrowser.firefox);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		//driver.quit();
	}

	@Test
	public void test() {
		
		//connexion 
		driver.get(url);
		LoginPage logPage = PageFactory.initElements(driver, LoginPage.class);
		logPage.login("admin", "admin");
		HomePage homePage = logPage.connection(driver);
		
		//Acces au formulaire et verification des elements
		SurFenetreNewProjet SurFenetreProjet1 = PageFactory.initElements(driver, SurFenetreNewProjet.class);
		SurFenetreProjet1.buttonNewProject.click();		
		
		assertEquals("la case nom est vide",  nom, SurFenetreProjet1.nomTextBox.getText());  
		assertEquals("la case modele est vide",modele, SurFenetreProjet1.modeleBandBox.getText()); 
			
		SimpleDateFormat formatDate= new SimpleDateFormat("d MMM yyyy"); 					// format de la date "03 Janv. 2020"
		Date date = new Date(System.currentTimeMillis());									// demande la date du jour
		String strDate = formatDate.format(date);  											// passe la date en String 
		String dateValue = SurFenetreProjet1.dateDebut.getAttribute("value");				// recupère la value de l'attribute 
		assertEquals(strDate , dateValue);													// vérif la date du jour avec la date ecrite sur le site
			
		assertEquals("la case echeance est vide", echeance , SurFenetreProjet1.dateEcheance.getText());
		// recupère la value de l'attribute
		String typecalendrier = SurFenetreProjet1.calendrierBox.getAttribute("value");		 
		assertEquals("la case calendrier est par default",  calendrier, typecalendrier); 
		
		//creation d'un projet en renseignant les champs	
		nom = "PROJET_TEST1";
		TechTools.inputText(SurFenetreProjet1.nomTextBox, nom);
		
		SurFenetreProjet1.croixChecked.click();
		code = "PRJTEST001";
		TechTools.inputText(SurFenetreProjet1.codeTextBox, code);
		
		// format de la date "03 Janv. 2020"
		SimpleDateFormat formatDate2= new SimpleDateFormat("d MMM yyyy"); 	
		Calendar c = Calendar.getInstance();
		//rajouter 5j
		c.add(Calendar.DAY_OF_MONTH, 5); 									
		String datePlusCinq = formatDate2.format(c.getTime());
		TechTools.inputText(SurFenetreProjet1.dateDebut, datePlusCinq);							
		
		SimpleDateFormat formatDate3= new SimpleDateFormat("d MMM yyyy"); 					
		c.add(Calendar.DAY_OF_MONTH, 15);  													
		String datePlusQuize = formatDate3.format(c.getTime());
		TechTools.inputText(SurFenetreProjet1.dateEcheance, datePlusQuize);
		
		SurFenetreProjet1.btnValider.click();
		
		//aller sur la pageProjet
		PageProjet pageProjet = PageFactory.initElements(driver, PageProjet.class);
		
		// verif la presence des boutons du menu vertical
		assertTrue(pageProjet.btnPlanificationDeProjet.isEnabled());
		assertTrue(pageProjet.btnDetailDuProjet.isEnabled());
		assertTrue(pageProjet.btnChangementDesRessources.isEnabled());
		assertTrue(pageProjet.btnAllocationAvancee.isEnabled());
		assertTrue(pageProjet.btnTableauDeBord.isEnabled());
		
		// verif la presence des boutons du menu horizontal 
		assertTrue(pageProjet.btnWBS.isEnabled());
		assertTrue(pageProjet.btnDonneesGenerales.isEnabled());
		assertTrue(pageProjet.btnCout.isEnabled());
		assertTrue(pageProjet.btnAvancement.isEnabled());
		assertTrue(pageProjet.btnLibelles.isEnabled());
		assertTrue(pageProjet.btnExigenceCritere.isEnabled());	
		assertTrue(pageProjet.btnMateriel.isEnabled());	
		assertTrue(pageProjet.btnFormulaireQualiteDesTaches.isEnabled());	
		assertTrue(pageProjet.btnAutorisation.isEnabled());	
		
		// verification de la presence des boutons Disquette et Fleche de retour
		assertTrue(pageProjet.btnDisquette.isEnabled());
		assertTrue(pageProjet.btnFlecheRetour.isEnabled());
		
		// cliquer sur le bouton fleche retour pour annuler l'edition 
		pageProjet.btnFlecheRetour.click();
		
		// verification de la presence des bourons OK et Annuler + du message d'information
		assertTrue(pageProjet.btnOKConfirmation.isEnabled());
		assertTrue(pageProjet.btnAnnulerConfirmation.isEnabled());
		
		// cliquer sur le bouton OK ==> clique sur Planification 
		pageProjet.btnOKConfirmation.click();
		pageProjet.btnPlanificationDesProjets.click();
		
		// absence de menu horizontal 
		try {assertFalse(pageProjet.btnWBS.isDisplayed()); }
		//Exception : pour dire qu'il faut attendre cette erreur pour que le test soit vrai
		catch (Exception exception) {  } 			
		
		//cliquer sur le sous-menu projet du menu calendrier
		homePage.allerSurPageProjet(driver);
		
		// verification de la présence du Projet dans la Liste des projets
		PageListeDesProjets pageListeDesProjets = PageFactory.initElements(driver, PageListeDesProjets.class);
		assertTrue(pageListeDesProjets.btnListeDesProjets.isDisplayed());
	
		// vérification des champs du projet
		assertEquals(pageListeDesProjets.valNom.getText(),nom);	
		assertEquals(pageListeDesProjets.valCode.getText() , code);	
		assertEquals(pageListeDesProjets.valDateDebut.getText(), datePlusCinq);
		assertEquals(pageListeDesProjets.valEcheance.getText() , datePlusQuize);
		assertEquals(pageListeDesProjets.valClient.getText() , client);
		assertEquals(pageListeDesProjets.valBudget.getText(), BudgetTotal);
		assertEquals(pageListeDesProjets.valHeures.getText() , Heures);
		assertEquals(pageListeDesProjets.valEtat.getText() , Etat);
		assertTrue(pageListeDesProjets.valOperationsModifier.isEnabled());
		assertTrue(pageListeDesProjets.valOperationsSupprimer.isEnabled());
		assertTrue(pageListeDesProjets.valOperationsPrevision.isEnabled());
		assertTrue(pageListeDesProjets.valOperationsModele.isEnabled());

	}
	

}