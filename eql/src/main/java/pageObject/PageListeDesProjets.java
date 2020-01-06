package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageListeDesProjets {

	// Bouton "Liste des projets"
	@FindBy (xpath="//td[contains(text(),'Liste des projets')]")
	public WebElement btnListeDesProjets;
	
	// presence du code 
	@FindBy (xpath="//span[@class='z-tab-text'][contains(text(),'PRJTEST001')]") 
	public WebElement btnPresenceCode;
	
	// valeur du nom
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[1]/div[1]/span[1]")
	public WebElement valNom;
	// valeur du code
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[2]/div[1]/span[1]")
	public WebElement valCode;
	// valeur date debut
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[3]/div[1]/span[1]")
	public WebElement valDateDebut;
	// valeur echeance
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[4]/div[1]/span[1]")
	public WebElement valEcheance;
	// valeur client
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[5]/div[1]/span[1]")
	public WebElement valClient;
	// valeur budget
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[6]/div[1]/span[1]")
	public WebElement valBudget;
	// valeur heures
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[7]/div[1]/span[1]")
	public WebElement valHeures;
	// valeur etat 
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[8]/div[1]/span[1]")
	public WebElement valEtat;
	// valeur operations modifier
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']//td[1]//span[1]//table[1]//tbody[1]//tr[2]//td[2]//img[1]")
	public WebElement valOperationsModifier;
	// valeur operations supprimer
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']//td[3]//span[1]//table[1]//tbody[1]//tr[2]//td[2]//img[1]")
	public WebElement valOperationsSupprimer;
	// valeur operations modifier voir la prevision
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']//td[5]//span[1]//table[1]//tbody[1]//tr[2]//td[2]//img[1]")
	public WebElement valOperationsPrevision;
	// valeur operations modifier creer un modele
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']//td[7]//span[1]//table[1]//tbody[1]//tr[2]//td[2]//img[1]")
	public WebElement valOperationsModele;
	

}
