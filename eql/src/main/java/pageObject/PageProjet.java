package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageProjet {
		
		// Bouton "Planification de projet"
		@FindBy (xpath="//td[contains(text(),'Planification de projet')]")
		public WebElement btnPlanificationDeProjet;
		
		// Bouton "Détail du projet"
		@FindBy (xpath="//td[contains(text(),'Détail du projet')]") 
		public WebElement btnDetailDuProjet;
		
		// Bouton "Chargement des ressources"
		@FindBy (xpath="//td[contains(text(),'Chargement des ressources')]") 
		public WebElement btnChangementDesRessources;

		// Bouton "Allocation Avancée"
		@FindBy (xpath="//td[contains(text(),'Allocation avancée')]") 
		public WebElement btnAllocationAvancee;

		// Bouton "Tableau de Bord"
		@FindBy (xpath="//td[contains(text(),'Tableau de bord')]") 
		public WebElement btnTableauDeBord;
		
		// Bouton "WBS" 
		@FindBy (xpath="//span[contains(text(),'WBS (tâches)')]") 
		public WebElement btnWBS;
		
		// Bouton "Données générales" 
		@FindBy (xpath="//span[contains(text(),'Données générales')]") 
		public WebElement btnDonneesGenerales;
		
		// Bouton Coût 
		@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'Coût')]") 
		public WebElement btnCout;
		
		// Bouton Avancement 
		@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'Avancement')]") 
		public WebElement btnAvancement;
		
		// Bouton Libellés 
		@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'Libellés')]") 
		public WebElement btnLibelles;
		
		//Bouton Exigence de critère 
		@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'Exigence de critère')]") 
		public WebElement btnExigenceCritere;
		
		// Bouton Matériels 
		@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'Matériels')]") 
		public WebElement btnMateriel;
		
		// Bouton Formulaire qualité des tâches 
		@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'Formulaires qualité des tâches')]") 
		public WebElement btnFormulaireQualiteDesTaches;
		
		// Bouton Autorisation
		@FindBy (xpath=" //span[contains(text(),'Autorisation')]") 
		public WebElement btnAutorisation;
	
		// Bouton Disquette 
		@FindBy (xpath="//img[contains(@src,'/libreplan/common/img/ico_save.png')]") 
		public WebElement btnDisquette;
		
		// Bouton fleche retour 
		@FindBy (xpath="//img[contains(@src,'/libreplan/common/img/ico_back.png')]")  
		public WebElement btnFlecheRetour;
		
		// Message d'info de non enregistrement    
		@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'Les modifications non enregistrées seront perdues. Êtes-vous sûr ?')]") 
		public WebElement messageConfirmation;
		
		// Bouton OK confirmation 
		@FindBy (xpath="//td[contains(text(),'OK')]")  
		public WebElement btnOKConfirmation;
		
		// Bouton Annuler confirmation
		@FindBy (xpath="//td[contains(text(),'Annuler')]")  
		public WebElement btnAnnulerConfirmation;
		
		// Bouton "Planification des projets"
		@FindBy (xpath="//td[contains(text(),'Planification des projets')]") 
		public WebElement btnPlanificationDesProjets;
		
		//Fil d'ariane Debut
		@FindBy (xpath="//strong[contains(text(),'DEBUT')]")
		public WebElement FADebut;	
		
		//Fil d'ariane calendrier
		@FindBy (xpath="//span[contains(text(),'Calendrier')]")
		public WebElement FACalendrier;
		
		//Fil d'ariane Detail du Projet
		@FindBy (xpath="//span[contains(text(),'Détail du projet')]")
		public WebElement FADetailDuProjet;
	
		//Fil d'ariane PROJET_TEST1
		@FindBy (xpath="//table[@class='z-hbox']//table//tbody//tr//td//span[@class='z-label'][contains(text(),'PROJET_TEST1')]")
		public WebElement FAProjet_Test1;
		
		// WBS nouvelle tache
		@FindBy (xpath="//table[@class='z-hbox']//tbody//tr//td//table//tbody//tr//td//table[@class='z-hbox']//tbody//tr//td//table//tbody//tr//td//input[@class='z-textbox']")
		public WebElement NouvelleTache;
		
		//WBS heure tache
		@FindBy (xpath="//input[@class='z-intbox']")
		public WebElement HeureTache;
		
		//WBS Ajouter tache
		@FindBy (xpath="//td[text()='Ajouter']")
		public WebElement AjouterTache; 
		
		//selection Tache1_p1
		@FindBy (xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[3]/table[1]/tbody[2]/tr[2]/td[1]/div[1]")
		public WebElement SelectTache1;
		
		//selection Tache3_p1	
		@FindBy (xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[3]/table[1]/tbody[2]/tr[1]/td[1]/div[1]")
		public WebElement SelectTache3;
		
		//Fleche Montante
		@FindBy (xpath="//div[@class='z-tabbox']//td[9]//span[1]//table[1]//tbody[1]//tr[2]//td[2]//img[1]")
		public WebElement FlecheMontante;
		
		//Fleche Descendante
		@FindBy (xpath="//div[@class='z-tabbox']//td[7]//span[1]//table[1]//tbody[1]//tr[2]//td[2]//img[1]")
		public WebElement FlecheDescendante;
		
		public void clicFleche (WebDriver driver, WebElement SelectionTache, WebElement ChoixFleche) {
			Actions a = new Actions(driver);
			a.moveToElement(SelectionTache).build().perform();
			a.moveToElement(SelectionTache).click().build().perform();
			a.moveToElement(ChoixFleche).build().perform();
			ChoixFleche.click();
			}
}
