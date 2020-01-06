package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import supportTools.TechTools;

public class PageCreerDerive {
	// Champ "Nom1"
	@FindBy (xpath="//td[@class='z-row-inner']/child::div[@class='z-row-cnt z-overflow-hidden']/child::input[@class='z-textbox']")
	public WebElement champNom;
	
	// Message d'erreur "le champ ne peux pas être vide"
	@FindBy (xpath="//div[@class='z-errbox-right z-errbox-close']")
	public WebElement erreur;
	
	// Champ "Type"
	@FindBy (xpath="//tr[@valign='top']/child::td[@style='height:100%']/child::span[@class='z-label']")
	public WebElement champType;

	// Bouton "Enregistrer"
	@FindBy (xpath="//td[@class='z-button-cm'][contains(text(),'Enregistrer')]")
	public WebElement boutonEnregistrer;

	// Boutton "Enregistrer et continuer"
	@FindBy (xpath="//td[contains(text(),'Enregistrer et continuer')]")
	public WebElement boutonEnregistrerEtContinuer;

	// Boutton "Annuler"
	@FindBy (xpath="//td[@class='z-button-cm'][contains(text(),'Annuler')]")
	public WebElement boutonAnnuler;
	
	//Case "Générer le code"
	@FindBy (xpath="//label[contains(text(),'Générer le code')]/preceding-sibling::input[@type='checkbox']")
	public WebElement caseCode;
	
	//Message d'erreur "Calendrier - Test 1 existe déjà"
	@FindBy (xpath="//div[@class='message_WARNING']/child::span[@class='z-label']")
	public WebElement messageErreur;
	
	//Message de validation "Calendrier de base "Calendrier - Test Calendrier Dérivé" enregistré"
	@FindBy (xpath="//div[@class='message_INFO']/child::span[@class='z-label']")
	public WebElement messageValidation;
	
	
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
	
	//Cliquer sur "Enregistrer et continuer"
	public void enregistrerEtContinuer () {
		boutonEnregistrerEtContinuer.click();
	}
	
	//Cliquer sur fermer le message d'erreur
	public void fermerMessageErreur (WebDriver driver) {
		Actions b = new Actions(driver);
		b.moveToElement(erreur).build().perform();
		erreur.click();
	}
	
}
