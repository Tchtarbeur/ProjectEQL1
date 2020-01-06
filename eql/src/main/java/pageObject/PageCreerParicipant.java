package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreerParicipant {
	// Onglet "Données personnelles
	// Bloc "Données de Base"
	//Champ "code" 
	@FindBy (xpath="")
	public WebElement champCode;
	// Case "généré le code" coché par défault
	@FindBy (xpath="")
	public WebElement caseGenererCode;
	
	// Champ "Prenom"
	@FindBy (xpath="")
	public WebElement champPrenom;
	
	// Champ "Nom"
	@FindBy (xpath="")
	public WebElement champNom;
	
	// Champ "ID"
	@FindBy (xpath="")
	public WebElement champID;
	
	// Liste déroulante "Type" affichant la valeur par défault "Ressource normale"
	@FindBy (xpath="")
	public WebElement listeType;
	
	// Bloc "Utilisateur lié"
	// Bouton "Non Lié" coché par défaut
	@FindBy (xpath="")
	public WebElement btnNonLie;
	
	// Bouton "utilisateur existant"
	@FindBy (xpath="")
	public WebElement btnUtilisateurExistant;
	
	// Champ "nom d'utilisateur"
	@FindBy (xpath="")
	public WebElement champNomUtilisateur;
	
	// Champ "mot de passe"
	@FindBy (xpath="")
	public WebElement champMotPasse;
	
	// Bouton "enregistrer"
	@FindBy (xpath="//td[contains(text(),'Enregistrer')]")
	public WebElement btnEnregistrer;
			
	// Bouton "Annuler"
	@FindBy (xpath="//td[contains(text(),'Annuler')]")
	public WebElement btnAnnuler;
			
	// Bouton "Sauver et Continuer"
	@FindBy (xpath="//td[contains(text(),'Sauver et continuer')]")
	public WebElement btnSauverContinuer;
}
