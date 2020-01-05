package projetEtTaches;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import pageObject.SurFenetreNewProjet;
import supportTools.EBrowser;
import supportTools.TechTools;

public class TestCinqUn {

	String url = "http://localhost:8090/libreplan";
	WebDriver driver;
	String nom = "";
	String modele = "";
	String code = "";
	String echeance = "";
	String client = "";
	String calendrier = "Default";

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
		
													//******************* Pas de test 1 *******************//
		driver.get(url);
		LoginPage logPage = PageFactory.initElements(driver, LoginPage.class);
		logPage.login("admin", "admin");
		HomePage homePage = logPage.connection(driver);
		
													//******************* Pas de test 2 *******************//
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
		String typecalendrier = SurFenetreProjet1.calendrierBox.getAttribute("value");			// recupère la value de l'attribute 
		assertEquals("la case calendrier est par default",  calendrier, typecalendrier); 
		
													//******************* Pas de test 3 *******************//
		nom = "PROJET_TEST1";
		TechTools.inputText(SurFenetreProjet1.nomTextBox, nom);
		
		SurFenetreProjet1.croixChecked.click();
		code = "PRJTEST001";
		TechTools.inputText(SurFenetreProjet1.codeTextBox, code);
		
		SimpleDateFormat formatDate2= new SimpleDateFormat("d MMM yyyy"); 					// format de la date "03 Janv. 2020"
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 5); 													//rajouter 5j
		String datePlusCinq = formatDate2.format(c.getTime());
		TechTools.inputText(SurFenetreProjet1.dateDebut, datePlusCinq);							
		
		SimpleDateFormat formatDate3= new SimpleDateFormat("d MMM yyyy"); 					// format de la date "03 Janv. 2020"
		c.add(Calendar.DAY_OF_MONTH, 15);  													//rajouter 15j
		String datePlusQuize = formatDate3.format(c.getTime());
		TechTools.inputText(SurFenetreProjet1.dateEcheance, datePlusQuize);
		
		SurFenetreProjet1.btnValider.click();
		
													//******************* Pas de test 4 *******************//
		assertEquals("nom incorrect", "", SurFenetreProjet1.nomTextBox.getText());
	}
	
//	Planification de projet
//	Détail du projet
//	Chargement des ressources
//	Allocation avancée
//	Tableau de bord

}