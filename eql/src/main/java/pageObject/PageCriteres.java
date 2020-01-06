package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCriteres {
	
		// colonne "Nom"
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
		@FindBy (xpath="//td[contains(text(),'Créer']")
		public WebElement btnCreer;
		
		public PageCreerTypeCritere creerCriteres (WebDriver driver) {
			btnCreer.click();
			return PageFactory.initElements(driver, PageCreerTypeCritere.class);
		}

}
