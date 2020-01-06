package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import supportTools.TechTools;

public class PageCreerCalendrier {
	// Onglet "Données de calendrier"
	@FindBy (xpath="//span[contains(text(),'Données de calendrier')]")
	public WebElement onglet;
	
	// Champ "Nom"
	@FindBy (xpath="//table[1]/tbody[2]/tr[1]/td[2]/div[1]/input[1]")
	public WebElement champNom;
	
	//Case "Générer le code"
	@FindBy (xpath="//table[1]/tbody[1]/tr[1]/td[3]/span[1]/input[1]")
	public WebElement caseCode;
	
	// Boutton "Enregistrer"
	@FindBy (xpath="//td[@class='z-button-cm'][contains(text(),'Enregistrer')]")
	public WebElement boutonEnregistrer;
	
	// Boutton "Enregistrer et continuer"
	@FindBy (xpath="//td[contains(text(),'Enregistrer et continuer')]")
	public WebElement boutonEnregistrerEtContinuer;

	// Boutton "Annuler"
	@FindBy (xpath="//td[@class='z-button-cm'][contains(text(),'Annuler')]")
	public WebElement boutonAnnuler;
	
	//Remplir le champ "Nom"
	public void saisirNom (String nom) {
		TechTools.inputText(champNom, nom);
	}

	// Accés page "Calendrier"
	public PageCalendrier retourSurPageCal (WebDriver driver) {
		Actions a = new Actions(driver);
		boutonEnregistrer.click();
		return PageFactory.initElements(driver, PageCalendrier.class);
	}
	
}
