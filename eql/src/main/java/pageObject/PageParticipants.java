package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageParticipants {
	// colonne "Surnom"
	@FindBy (xpath="//tbody[2]/tr[1]/th[1]/div")
	public WebElement titreColonne1;
	
	// Colonne "Prénom"
	@FindBy (xpath="//tbody[2]/tr[1]/th[2]/div")
	public WebElement titreColonne2;
	
	// Colonne "ID"
	@FindBy (xpath="//tbody[2]/tr[1]/th[3]/div")
	public WebElement titreColonne3;
	
	// Colonne "Code"
	@FindBy (xpath="//tbody[2]/tr[1]/th[4]/div")
	public WebElement titreColonne4;
	
	// Colonne "En File"
	@FindBy (xpath="//tbody[2]/tr[1]/th[5]/div")
	public WebElement titreColonne5;
	
	// Colonne "Opération"
	@FindBy (xpath="//tbody[2]/tr[1]/th[6]/div")
	public WebElement titreColonne6;
	
	// Champ de recherche "filtré par"
	@FindBy (xpath="//table/tbody/tr/td/table/tbody/tr/td[3]/span/i/input")
	public WebElement champFiltrePar;
	
	// Icone "loupe"
	@FindBy (xpath="//table/tbody/tr/td/table/tbody/tr/td[3]/span/i/i")
	public WebElement iconeLoupe;
	
	// Champ "Détails personnels"
	@FindBy (xpath="//table/tbody/tr/td/table/tbody/tr/td[7]/input")
	public WebElement champDetailsPerso;
	
	// Bouton bleu plus d'options
	@FindBy (xpath="//td[text()='Plus d'options']")
	public WebElement btnPlusOption;
	
	// Bouton vert "filtre"
	@FindBy (xpath="//td[text()='Filtre']")
	public WebElement btnFiltre;
	
	// Bouton créer un participant
	@FindBy (xpath = "//td[contains(text(), 'Créer')]")
	public WebElement btnCreer;
	
	// Message participant créé
	@FindBy (xpath= "//span[contains(text(), 'Participant enregistré']")
	public WebElement messageCreation;
	
	// Resultat recherche
	@FindBy (xpath= "//span[text()='Jean']")
	public WebElement rechercheResult;
	
	// Champ "période active de :"
	@FindBy (xpath="//")
	public WebElement champDebutPerAct;
	
	// Champ "fin période active"
	@FindBy (xpath="")
	public WebElement champFinPerAct;
	
	
	public PageCreerParicipant creerPartPage (WebDriver driver) {
		btnCreer.click();
		return PageFactory.initElements(driver, PageCreerParicipant.class);
	}
}
