package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerTypeCritere {
	// Forumlaire de saisie
	// Titre modifier
	@FindBy (xpath = "//td[@class='z-caption-l']")
	public WebElement titreModifier;
	
	// Champ "nom"
	@FindBy (xpath = "//table/tbody[2]/tr[1]/td[2]/div/input")
	public WebElement champNom;

	// Liste déroulante "type"
	@FindBy (xpath = "//table/tbody[2]/tr[2]/td[2]/div/i/i")
	//@FindBy (xpath = "//i[@class='z-combobox-btn']")
	public WebElement btnListeType;
	
	// Liste déroulante choix "participant"
	@FindBy (xpath = "//td[contains(text(),'PARTICIPANT')]")
	public WebElement participantListe;
	
	// Liste déroulante choix "machines"
	@FindBy(xpath = "//td[contains(text(),'MACHINE')]")
	public WebElement machineListe;
	
	// CheckBox "Valeurs multiples par ressources"
	@FindBy (xpath ="//table/tbody[2]/tr[3]/td[2]/div/span/input")
	public WebElement valMultRessources;
	
	// CheckBox "Hiérarchie"
	@FindBy (xpath ="//table/tbody[2]/tr[4]/td[2]/div/span/input")
	public WebElement hierarchie;
	
	// CheckBox "Activé"
	@FindBy (xpath ="//table/tbody[2]/tr[5]/td[2]/div/span/input")
	public WebElement active;
	
	// Champ "Description"
	@FindBy (xpath ="//table/tbody[2]/tr[6]/td[2]/div/textarea")
	public WebElement champDescription;
	
	// Champ "Code"
	@FindBy (xpath ="//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")
	//@FindBy (xpath ="//table/tbody[2]/tr[7]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/input")
	public WebElement champCode;
	
	// CheckBox "Générer le code"
	@FindBy (xpath ="//table[@class='z-hbox']//table//tbody//tr//td//span[@class='z-checkbox']//input")
	public WebElement genererCode;
	
	// Champ "nouveau critère"
	@FindBy (xpath ="//table[@class='z-hbox']//table//tbody//tr//td//input[@class='z-textbox']")
	public WebElement champNouveauCrit;
	
	// Bouton "Ajouter"
	@FindBy (xpath ="//td[contains(text(),'Ajouter')]")
	public WebElement btnAjouter;
	
	// Bouton "enregistrer"
	@FindBy (xpath="//td[text()='Enregistrer']")
	public WebElement btnEnregistrer;
		
	// Bouton "Annuler"
	@FindBy (xpath="//td[text()='Annuler']")
	public WebElement btnAnnuler;
		
	// Bouton "Sauver et Continuer"
	@FindBy (xpath="//td[text()='Sauver et continuer']")
	public WebElement btnSauverContinuer;
	
	// Message test création ok aprés sauver et continuer
	@FindBy (xpath="//span[contains(text(),'Type de critère \"Test bouton [Sauver et continuer]\" enregistré')]")
	public WebElement messageCreationOK;
	
	// Message test création ok aprés sauver et continuer 2
		@FindBy (xpath="//span[contains(text(),'Type de critère \"Test bouton [Sauver et continuer] 2\" enregistré')]")
		public WebElement messageCreationOK2;
	
	// Enregistrer un nouveau type de critère
	public PageCriteres creationFin (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(btnEnregistrer).build().perform();
		btnEnregistrer.click();
		return PageFactory.initElements(driver, PageCriteres.class);
	}
	
	// Choisir entre "Participant et Machine"
	public void choixType (WebDriver driver, WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(btnListeType).build().perform();
		btnListeType.click();
		a.moveToElement(e).build().perform();
		e.click();
	}
	
	// Annuler la création d'un critère et retour sur la page critère
	public  PageCriteres annulation (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(btnAnnuler).build().perform();
		btnAnnuler.click();
		return PageFactory.initElements(driver, PageCriteres.class);
	}
}
