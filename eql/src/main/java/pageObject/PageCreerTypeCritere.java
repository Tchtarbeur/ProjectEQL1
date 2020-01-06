package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerTypeCritere {
	// Forumlaire de saisie
	// Champ "nom"
	@FindBy (xpath = "")
	public WebElement champNom;
	
	// Liste déroulante "type"
	@FindBy (xpath = "")
	public WebElement listeType;
	
	// CheckBox "Valeurs multiples par ressources"
	@FindBy (xpath ="")
	public WebElement valMultRessources;
	
	// CheckBox "Hiérarchie"
	@FindBy (xpath ="")
	public WebElement hierarchie;
	
	// CheckBox "Activé"
	@FindBy (xpath ="")
	public WebElement active;
	
	// Champ "Description"
	@FindBy (xpath ="")
	public WebElement champDescription;
	
	// CheckBox "Générer le code"
	@FindBy (xpath ="")
	public WebElement genererCode;
	
	// Champ "nouveau critère"
	@FindBy (xpath ="")
	public WebElement champNouveauCrit;
	
	// Bouton "Ajouter"
	@FindBy (xpath ="")
	public WebElement btnAjouter;
	
	// Bouton "enregistrer"
	@FindBy (xpath="//td[contains(text(),'Enregistrer')]")
	public WebElement btnEnregistrer;
		
	// Bouton "Annuler"
	@FindBy (xpath="//td[contains(text(),'Annuler')]")
	public WebElement btnAnnuler;
		
	// Bouton "Sauver et Continuer"
	@FindBy (xpath="//td[contains(text(),'Sauver et continuer')]")
	public WebElement btnSauverContinuer;
	
	public PageCriteres creationFin (WebDriver driver) {
		btnEnregistrer.click();
		return PageFactory.initElements(driver, PageCriteres.class);
	}
}
