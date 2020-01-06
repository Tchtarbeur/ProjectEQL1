package relevesDesHeuresDeTravail;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void test() throws ParseException, InterruptedException {

		driver.get(url);
		LoginPage logPage = PageFactory.initElements(driver, LoginPage.class);

		//Connexion
		logPage.login("admin", "admin");
		HomePage homePage = logPage.connection(driver);

		//Vérification homePage
		assertTrue(homePage.calendrier.isDisplayed());

							//Pas De Test 2
		//Aller sur page Liste des feuilles de temps
		PageFeuilleTemps pageFeuilleTemps = homePage.allerSurFeuilleTemps(driver);

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
		assertTrue(pageFeuilleTemps.boutonFiltre.isEnabled());

		//Vérifier liste déroulante Choisir un Canevas
		assertTrue (pageFeuilleTemps.ldChoisirCanevas.isEnabled());
		assertTrue (pageFeuilleTemps.choixDefaultldChoisircanevas.isSelected());

		//Vérifier boutton Nouvelle feuille de temps
		assertTrue (pageFeuilleTemps.boutonNouvelleFeuilleDeTemps.isEnabled());

							//Pas De Test 3
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
		
		//Récupération du code pour la suite du test
		String codeNouvelleFT = pageCFT.blocDonnéesGénéralesChampCode.getAttribute("value");
		
		//Vérifier bloc Champs Rubriques
		assertEquals("Champs Rubriques", pageCFT.blocChampsRubriques.getText());

		//Vérifier bloc Lignes de feuilles de temps
		assertEquals("Lignes de feuille de temps", pageCFT.blocLignesDeFeuillesDeTemps.getText());
		assertTrue (pageCFT.boutonAjouterUneLigne.isEnabled());
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

								//Pas De Test 4
		//Clique boutton Ajouter une ligne
		pageCFT.boutonAjouterUneLigne.click();

		//Vérification date
		SimpleDateFormat formatDate= new SimpleDateFormat("d MMM yyyy");
		Date date = new Date(System.currentTimeMillis());
		String strDate = formatDate.format(date);
		String dateValue = pageCFT.champDate.getAttribute("value");
		assertEquals(strDate , dateValue);
		
		//Vérification menu déroulant avec aucune valeur par défaut
		assertTrue(pageCFT.listeDeroulanteRessources.isDisplayed());
		String valeurAutocomplete = pageCFT.listeDeroulanteRessources.getAttribute("autocomplete");
		assertEquals ("off",valeurAutocomplete);
		
		//Vérification tache
		assertTrue (pageCFT.champTache.isEnabled());
		assertTrue (pageCFT.boutonRechercheTache.isEnabled());
		
		//Vérification heure
		assertTrue (pageCFT.champHeure.isEnabled());
		String valeurValue = pageCFT.champHeure.getAttribute("value");
		assertEquals ("0", valeurValue);
		
		//Vérification types d'heures
		assertTrue (pageCFT.listeDeroulanteTypeHeures.isEnabled());
		assertTrue (pageCFT.choixTypeHeuresDefault.isSelected());
		
		//Vérification Réalisé
		assertFalse (pageCFT.caseRealise.isSelected());
		
		//Vérification code
		assertFalse (pageCFT.champCode.isEnabled());
		String valeurValueCode = pageCFT.champCode.getAttribute("value");
		assertEquals ("", valeurValueCode);
		
		//Vérification Op
		assertTrue (pageCFT.boutonSupprimer.isEnabled());
		String valeurTitle = pageCFT.boutonSupprimer.getAttribute("title");
		assertEquals ("Supprimer", valeurTitle);
		
							//Pas De Test 5
		//Date
		SimpleDateFormat formatDate2= new SimpleDateFormat("d MMM yyyy"); 					
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 3); 													
		String datePlusCinq = formatDate2.format(c.getTime());
		TechTools.inputText(pageCFT.champDate, datePlusCinq);
		
		//Ressource
		pageCFT.choixRessource.click();
		pageCFT.choix1Ressource.click();
		
		//Tache
		pageCFT.boutonRechercheTache.click();
		pageCFT.choix1Tache.click();
		
		//Heure
		TechTools.inputText(pageCFT.champHeure, "8");
		
		//Réalisé
		pageCFT.caseRealise.click();
		
		//Enregistrer
		PageFeuilleTemps pageFT = pageCFT.enregistrerNouvelleFeuilleTemps(driver);
		
		//Vérificaton retour sur la page "Liste des feuilles de temps"
		assertEquals("Liste des feuilles de temps", pageFT.titre.getText());
		
		//Vérification message "Feuille de temps sauvegardée"
		assertEquals("Feuille de temps sauvegardée", pageFT.messageInfo.getText());
		
		//Vérification Feuille de temps créée visible dans le tableau
		WebElement dernierFTCreee = pageFT.xpathFTVariable(driver, codeNouvelleFT);
		assertTrue(dernierFTCreee.isDisplayed());
		
						//Pas de test 6
		pageFT.dateDebutDecroissante(driver);
		
						//Pas de test 7
		pageFT.titreColonne2.click();
		pageFT.dateFinCroissante(driver);
		
						//Pas de test 8
		pageFT.titreColonne2.click();
		pageFT.dateFinDecroissante(driver);
		
						//Pas de test 9
		pageFT.titreColonne4.click();
		pageFT.travailTotalCroissant(driver);
		
						//Pas de test 10
		pageFT.titreColonne4.click();
		pageFT.travailTotalDecroissant(driver);
		
						//Pas de test 11
		pageFT.titreColonne3.click();
		pageFT.modeleOrdreAplha(driver);
		
		
						//Pas de test 12
		pageFT.titreColonne3.click();
		pageFT.modeleOrdreAplhaInverse(driver);
	}
}
