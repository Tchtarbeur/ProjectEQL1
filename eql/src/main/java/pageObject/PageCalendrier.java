package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCalendrier {
	// En-tête colonne 1  "Nom"
	@FindBy (xpath="//div[contains(text(),'Nom')]")
	public WebElement titreColonne1;
	
	// En-tête colonne 2  "Hérité de la date"
	@FindBy (xpath="//div[contains(text(),'Hérité de la date')]")
	public WebElement titreColonne2;
	
	// En-tête colonne 3  "Héritages à jour"
	@FindBy (xpath="//div[contains(text(),'Héritages à jour')]")
	public WebElement titreColonne3;
	
	// En-tête colonne 4  "Opérations"
	@FindBy (xpath="//div[contains(text(),'Opérations')]")
	public WebElement titreColonne4;
	
	// Boutton "Créer"
	@FindBy (xpath="//td[contains(text(),'Créer')]")
	public WebElement boutonCreer;
	
	//Titre de la page
	@FindBy (xpath="//div[@class='z-window-embedded-header']")
	public WebElement titrePage;
	
	//Bouton arborescence de la 1ère ligne
	@FindBy (xpath="//span[contains(@class,'z-dottree-ico')]")
	public WebElement boutonArborescence;
	
	//Ligne Dérivé dans le tableau
	@FindBy (xpath="//tr[2][@class='z-treerow']")
	public WebElement ligneDerive;
	
	//Bouton Créer une copie de la 1ère ligne
	@FindBy (xpath="//tr[1]//span[@title='Créer une copie']")
	public WebElement creerCopie;
	
	//Message info
	@FindBy (xpath="//div[@class='message_INFO']")
	public WebElement mInfo;
	
	//2ème calendrier créé
	@FindBy (xpath="//tr[3]//span[2]")
	public WebElement cal2;
	
	// Accés page "Creer Calendrier"
		public PageCreerCalendrier allerSurPageCreerCal (WebDriver driver) {
			Actions a = new Actions(driver);
			boutonCreer.click();
			return PageFactory.initElements(driver, PageCreerCalendrier.class);
		}
		
	// Accés page "Creer Dérive"
		public PageCreerDerive allerSurPageCreerDerive (WebDriver driver, WebElement e) {
			Actions a = new Actions(driver);
			e.click();
			return PageFactory.initElements(driver, PageCreerDerive.class);
		}
		
	//Accès page "Creer Calendrier" avoir avoir cliquer sur "Creer une copie"
		public PageCreerCalendrier creerCopie (WebDriver driver) {
			creerCopie.click();
			return PageFactory.initElements(driver, PageCreerCalendrier.class);
		}
}

