package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerParicipant {
	// Onglet "Données personnelles
	// Bloc "Données de Base"
	//Titre "Données personnelles"
	@FindBy (xpath="//span[text()='Données personnelles']")
	public WebElement titreOngletDP;
	
	//Champ "code" 
	@FindBy (xpath="//table/tbody[2]/tr[1]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/input")
	public WebElement champCode;
	
	// Case "généré le code" coché par défault
	@FindBy (xpath="//table/tbody[2]/tr[1]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/input")
	public WebElement caseGenererCode;
	
	// Champ "Prenom"
	@FindBy (xpath="///html/body/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/div[2]/div[1]/div/fieldset[1]/div/div/div[3]/table/tbody[2]/tr[2]/td[2]/div/input")
	public WebElement champPrenom;
	
	// Champ "Nom"
	@FindBy (xpath="//table/tbody[2]/tr[4]/td[2]/div/input")
	public WebElement champNom;
	
	// Champ "ID"
	@FindBy (xpath="//table/tbody[2]/tr[5]/td[2]/div/input")
	public WebElement champID;
	
	// Liste déroulante "Type" affichant la valeur par défault "Ressource normale"
	@FindBy (xpath="//table/tbody[2]/tr[6]/td[2]/div/select")
	public WebElement listeType;
	
	// Bloc "Utilisateur lié"
	// Bouton "Non Lié" coché par défaut
	@FindBy (xpath="//span/span[1]/input")
	public WebElement btnNonLie;
	
	// Bouton "utilisateur existant"
	@FindBy (xpath="//span/span[2]/input")
	public WebElement btnUtilisateurExistant;
	
	// CheckBox "créer un nouvel utilisateur
	@FindBy (xpath="//span/span[3]/input")
	public WebElement btnNouvelUtilisateur;

	// Champ "nom d'utilisateur"
	@FindBy (xpath="//table/tbody[2]/tr[1]/td[2]/div/input")
	public WebElement champNomUtilisateur;
	
	// Champ "mot de passe"
	@FindBy (xpath="//input[@type='password']")
	public WebElement champMotPasse;
	
	//Champ confirmer "mot de passe"
	@FindBy (xpath="//fieldset[2]/div/div[2]/div[2]/div/div/div[3]/table/tbody[2]/tr[3]/td[2]/div/input")
	public WebElement champMotPasseConf;
	
	//Champ "email
	@FindBy (xpath="//fieldset[2]/div/div[2]/div[2]/div/div/div[3]/table/tbody[2]/tr[4]/td[2]/div/input")
	public WebElement champEmail;
		
	// Bouton "enregistrer"
	@FindBy (xpath= "//td[text()='Enregistrer']")
	//@FindBy (xpath="//td[contains(text(),'Enregistrer')]")
	public WebElement btnEnregistrer;
			
	// Bouton "Annuler"
	@FindBy (xpath="//td[contains(text(),'Annuler')]")
	public WebElement btnAnnuler;
			
	// Bouton "Sauver et Continuer"
	@FindBy (xpath="//td[contains(text(),'Sauver et continuer')]")
	public WebElement btnSauverContinuer;
	
	// Message Info aprés création
	@FindBy (xpath="//td[@class=message_INFO]")
	public WebElement messageInfo;

public PageParticipants enregistrerParticipant (WebDriver driver) {
	Actions a = new Actions(driver);
	a.moveToElement(btnEnregistrer).build().perform();
	btnEnregistrer.click();
	return PageFactory.initElements(driver, PageParticipants.class);
	}


}