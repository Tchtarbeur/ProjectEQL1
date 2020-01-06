package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerFeuilleTemps {

	//Nom de la page
	@FindBy (xpath="//div[2]/div[2]//div[@class='z-window-embedded-header']")
	public
	WebElement titre;
	
	//Nom bloc "Données Générales"
	@FindBy (xpath="//tr[1]/td[1]/fieldset/legend/span")
	public
	WebElement blocDonnéesGénérales;
	
	//Champ Code du bloc Données Générales
	@FindBy (xpath="//td[1]/input")
	public
	WebElement blocDonnéesGénéralesChampCode;
	
	//Case du champ Code du bloc Données Générales
	@FindBy (xpath="//td[3]//input")
	public
	WebElement blocDonnéesGénéralesCase;
	
	//Nom de la case du champ Code
	@FindBy (xpath="//label")
	public
	WebElement blocDonnéesGénéralesGenererLeCode;
	
	//Nom du bloc "Champs Rubriques"
	@FindBy (xpath="//tr[3]/td[1]/fieldset/legend/span")
	public
	WebElement blocChampsRubriques;
	
	//Nom du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]/td[1]/fieldset/legend/span")
	public
	WebElement blocLignesDeFeuillesDeTemps;
	
	//Boutton "Ajouter une ligne"
	@FindBy (xpath="//tr[7]//td[@class='z-button-cm']")
	public
	WebElement boutonAjouterUneLigne;
	
	//Nom de la colonne 1 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[1]/div/div/parent::div")
	public
	WebElement titreColonne1;
	
	//Nom de la colonne 2 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[2]/div/div/parent::div")
	public
	WebElement titreColonne2;
	
	//Nom de la colonne 3 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[3]/div/div/parent::div")
	public
	WebElement titreColonne3;
	
	//Nom de la colonne 4 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[4]/div/div/parent::div")
	public
	WebElement titreColonne4;
	
	//Nom de la colonne 5 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[5]/div/div/parent::div")
	public
	WebElement titreColonne5;
	
	//Nom de la colonne 6 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[6]/div/div/parent::div")
	public
	WebElement titreColonne6;
	
	//Nom de la colonne 7 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[7]/div/div/parent::div")
	public
	WebElement titreColonne7;
	
	//Nom de la colonne 8 du bloc "Lignes de feuilles de temps"
	@FindBy (xpath="//tr[7]//th[8]/div/div/parent::div")
	public
	WebElement titreColonne8;
	
	//Boutton "Enregistrer"
	@FindBy (xpath="//td[contains(text(),'Enregistrer')]")
	public
	WebElement btEnregistrer;
	
	//Boutton "Sauver et continuer"
	@FindBy (xpath="//td[contains(text(),'Sauver ')]")
	public
	WebElement btSauverEtContinuer;
	
	//Boutton "Sauvegarder & Nouvelle feuille de temps"
	@FindBy (xpath="//td[contains(text(),'Sauvegarder')]")
	public
	WebElement btSauvegarder ;
	
	//Boutton "Annuler"
	@FindBy (xpath="//td[contains(text(),'Annuler')]")
	public
	WebElement btAnnuler;
	
	//Champ date pour ajouter une ligne
	@FindBy (xpath="//tr[7]//input[@class='z-datebox-inp']")
	public
	WebElement champDate;
	
	//Liste déroulante ressources pour ajouter une ligne
	@FindBy (xpath="//tr[7]//input[@class='z-combobox-inp']")
	public
	WebElement listeDeroulanteRessources;
	
	//boutton pour ouvrir liste des ressources disponible
	@FindBy (xpath="//tr[7]//i[@class='z-combobox-btn']")
	public
	WebElement choixRessource;
	
	//1ère ressources de la liste
	@FindBy (xpath="/html[1]/body[1]/div[3]//tr[1]/td[2]")
	public
	WebElement choix1Ressource;
	
	//champ tache pour ajouter une ligne
	@FindBy (xpath="//tr[7]//input[@class='z-bandbox-inp']")
	public
	WebElement champTache;
	
	//boutton pour ouvrir liste des projets
	@FindBy (xpath="//tr[7]//i[@class='z-bandbox-btn']")
	public
	WebElement boutonRechercheTache;
	
	//1er projet de la liste
	@FindBy (xpath="/html[1]/body[1]/div[3]//tr[1]//tr[1]//tr[1]/td[1]/div[1]")
	public
	WebElement choix1Tache;
	
	//champ heure pour ajouter une ligne
	@FindBy (xpath="//tr[7]//input[@class='z-textbox']")
	public
	WebElement champHeure;
	
	//liste déroulante "type heures" pour ajouter une ligne
	@FindBy (xpath="//tr[7]//select")
	public
	WebElement listeDeroulanteTypeHeures;
	
	//Valeur "default" pour types heures
	@FindBy (xpath="//tr[7]//select//option[contains(text(),'Default')]")
	public
	WebElement choixTypeHeuresDefault;
	
	//case réalisé pour ajouter une ligne
	@FindBy (xpath="//tr[7]//input[@type='checkbox']")
	public
	WebElement caseRealise;
	
	//champ code pour ajouter une ligne
	@FindBy (xpath="//tr[7]//input[contains(@class,'z-textbox-disd')]")
	public
	WebElement champCode;
	
	//boutton supprimer pour ajouter une ligne
	@FindBy (xpath="//tr[7]//span[@class='icono z-button']")
	public
	WebElement boutonSupprimer;
	
	public PageFeuilleTemps enregistrerNouvelleFeuilleTemps (WebDriver driver) {
		btEnregistrer.click();
		return PageFactory.initElements(driver, PageFeuilleTemps.class);
	}
}
