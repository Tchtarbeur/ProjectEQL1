package relevesDesHeuresDeTravail;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageCreerFeuilleTemps;
import pageObject.PageFeuilleTemps;
import supportTools.EBrowser;
import supportTools.TechTools;

public class RHT_01 {
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

		//Vérification homePage
		assertTrue(homePage.calendrier.isDisplayed());

		//Aller sur page Liste des feuilles de temps
		homePage.allerSurFeuilleTemps(driver);
		PageFeuilleTemps pageFeuilleTemps = PageFactory.initElements(driver, PageFeuilleTemps.class);

		//Vérification page Liste des feuilles de temps
		//Vérifier titre
		assertEquals("Liste des feuilles de temps", pageFeuilleTemps.titre.getText());

		//Vérifier nom colonne
		assertEquals("Date de début", pageFeuilleTemps.titreColonne1.getText());
		assertEquals("Date de fin",  pageFeuilleTemps.titreColonne2.getText());
		assertEquals("Modèle",  pageFeuilleTemps.titreColonne3.getText());
		assertEquals("Travail total",  pageFeuilleTemps.titreColonne4.getText());
		assertEquals("Code",  pageFeuilleTemps.titreColonne5.getText());
		assertEquals("Actions",  pageFeuilleTemps.titreColonne6.getText());

		//Vérifier filtre modèle
		assertTrue(pageFeuilleTemps.filtreModele.isEnabled());
		assertTrue(pageFeuilleTemps.choixMontrerToutFiltreModele.isSelected());

		//Vérifier filtre calendrier
		assertTrue(pageFeuilleTemps.champCalendrierDe.isEnabled());
		assertTrue(pageFeuilleTemps.champCalendrierA.isEnabled());

		//Vérifier boutton filtre
		assertTrue(pageFeuilleTemps.bouttonFiltre.isEnabled());

		//Vérifier liste déroulante Choisir un Canevas
		assertTrue (pageFeuilleTemps.ldChoisirCanevas.isEnabled());
		assertTrue (pageFeuilleTemps.choixDefaultldChoisircanevas.isSelected());

		//Vérifier boutton Nouvelle feuille de temps
		assertTrue (pageFeuilleTemps.bouttonNouvelleFeuilleDeTemps.isEnabled());

		//Clique sur Nouvelle feuille de temps
		pageFeuilleTemps.creerFeuilleTemps(driver);
		PageCreerFeuilleTemps pageCFT = PageFactory.initElements(driver, PageCreerFeuilleTemps.class);

		//Vérifier titre
		assertEquals("Créer la feuille de temps", pageCFT.titre.getText());

		//Vérifier bloc données générales
		assertEquals("Données générales", pageCFT.blocDonnéesGénérales.getText());
		assertFalse(pageCFT.blocDonnéesGénéralesChampCode.isEnabled());
		assertTrue(pageCFT.blocDonnéesGénéralesCase.isSelected());
		assertEquals("Générer le code", pageCFT.blocDonnéesGénéralesGenererLeCode.getText());

		//Vérifier bloc Champs Rubriques
		assertEquals("Champs Rubriques", pageCFT.blocChampsRubriques.getText());

		//Vérifier bloc Lignes de feuilles de temps
		assertEquals("Lignes de feuille de temps", pageCFT.blocLignesDeFeuillesDeTemps.getText());
		assertTrue (pageCFT.bouttonAjouterUneLigne.isEnabled());
		assertEquals ("Date", pageCFT.titreColonne1.getText());
		assertEquals ("Ressource", pageCFT.titreColonne2.getText());
		assertEquals ("Tâche", pageCFT.titreColonne3.getText());
		assertEquals ("Heures", pageCFT.titreColonne4.getText());
		assertEquals ("Type d'heures", pageCFT.titreColonne5.getText());
		assertEquals ("Réalisé", pageCFT.titreColonne6.getText());
		assertEquals ("Code", pageCFT.titreColonne7.getText());
		assertEquals ("Op.", pageCFT.titreColonne8.getText());

		//Vérifier bouton
		assertTrue (pageCFT.btEnregistrer.isEnabled());
		assertTrue (pageCFT.btSauverEtContinuer.isEnabled());
		assertTrue (pageCFT.btSauvegarder.isEnabled());
		assertTrue (pageCFT.btAnnuler.isEnabled());

		//Clique boutton Ajouter une ligne
		pageCFT.bouttonAjouterUneLigne.click();


	}
}
