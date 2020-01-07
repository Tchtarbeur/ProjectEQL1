package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCriteres {
	
		// Colonne "Nom"
		@FindBy (xpath="//tbody[2]/tr[1]/th[1]/div")
		public WebElement titreColonne1;
		
		// Colonne "Code"
		@FindBy (xpath="//tbody[2]/tr[1]/th[2]/div")
		public WebElement titreColonne2;
		
		// Colonne "Type"
		@FindBy (xpath="//tbody[2]/tr[1]/th[3]/div")
		public WebElement titreColonne3;
		
		// Colonne "Activité"
		@FindBy (xpath="//tbody[2]/tr[1]/th[4]/div")
		public WebElement titreColonne4;
		
		// Colonne "Opération"
		@FindBy (xpath="//tbody[2]/tr[1]/th[5]/div")
		public WebElement titreColonne5;
		
		// Bouton créer
		@FindBy (xpath="//td[contains(text(), 'Créer')]")
		public WebElement btnCreer;
		
		// Bouton modifier "critère sauver et continuer"
		@FindBy (xpath="//table/tbody[2]/tr[5]/td[5]/div/table/tbody/tr/td/table/tbody/tr/td[1]/span/table/tbody/tr[2]/td[2]/img")
		public WebElement btnModifCritSM;
		
		// Ligne Modifier
		@FindBy (xpath ="//table/tbody[2]/tr[5]/td[1]/div/span")
		public WebElement critSauvModif;
		
		public PageCreerTypeCritere creerCriteres (WebDriver driver) {
			btnCreer.click();
			return PageFactory.initElements(driver, PageCreerTypeCritere.class);
		}
		
		public PageCreerTypeCritere modifierCritere (WebDriver driver) {
			btnModifCritSM.click();
			return PageFactory.initElements(driver, PageCreerTypeCritere.class);
		}
}
