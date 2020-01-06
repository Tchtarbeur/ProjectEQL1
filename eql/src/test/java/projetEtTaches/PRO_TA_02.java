package projetEtTaches;

import static org.junit.Assert.assertEquals;

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
import supportTools.EBrowser;
import supportTools.TechTools;

public class PRO_TA_02 {
	String url = "http://localhost:8090/libreplan";
	WebDriver driver;
	String fildariane = "DEBUT Calendrier Détail du projet PROJET_TEST1";
	String nomnouvelletache1 = "Tache1-P1";
	String heurenouvelletache1 = "5";
	String nomnouvelletache2 = "Tache2-P1";
	String heurenouvelletache2 = "10";
	String nomnouvelletache3 = "Tache3-P1";
	String heurenouvelletache3 = "20";
	String nomnouvelletache4 = "Tache4-P1";
	String heurenouvelletache4 = "8";
	String espace = " ";
	String T1Code = "T1"; 
	String T2Code = "T2";
	String T3Code = "T3";
	String T4Code = "T4";
	String T1date = "05/02/2020";
	String T2date = "08/02/2020";
	String T3date = "03/03/2020";
	String T4date = "05/03/2020";
	
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
	
	//aller sur la page Liste des projets
	PageListeDesProjets pageListeDesProjets = PageFactory.initElements(driver, PageListeDesProjets.class);
	pageListeDesProjets.btnListeDesProjets.click();
	
	//aller sur le projet PROJET_TEST1
	pageListeDesProjets.valNom.click();
	
	//vérification du Fil d'ariane
	PageProjet pageProjets = PageFactory.initElements(driver, PageProjet.class);
	assertEquals(fildariane , pageProjets.FADebut.getText()+ " " +pageProjets.FACalendrier.getText()+ " " + pageProjets.FADetailDuProjet.getText() + " " + pageProjets.FAProjet_Test1.getText());
	
	// creation d'une nouvelle tache
	TechTools.inputText(pageProjets.NouvelleTache, nomnouvelletache1);
	TechTools.inputText(pageProjets.HeureTache, heurenouvelletache1);
	pageProjets.AjouterTache.click();
	// Creation des 3 autres taches
	TechTools.inputText(pageProjets.HeureTache, heurenouvelletache2);
	TechTools.inputText(pageProjets.NouvelleTache, nomnouvelletache2);
	pageProjets.AjouterTache.click();
	TechTools.inputText(pageProjets.HeureTache, heurenouvelletache3);
	TechTools.inputText(pageProjets.NouvelleTache, nomnouvelletache3);
	pageProjets.AjouterTache.click();
	TechTools.inputText(pageProjets.HeureTache, heurenouvelletache4);
	TechTools.inputText(pageProjets.NouvelleTache, nomnouvelletache4);
	pageProjets.AjouterTache.click();
	
	//Modification ordre de la tache 1
	pageProjets.clicFleche(driver, pageProjets.SelectTache1, pageProjets.FlecheDescendante);
	//Modification ordre de la tache 3
	//pageProjets.clicFleche(driver, pageProjets.SelectTache3, pageProjets.FlecheMontante);
	}
}
