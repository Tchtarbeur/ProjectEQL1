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
}

