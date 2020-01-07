package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		
		// Ligne titre final critere "sauver et modifier"
		@FindBy (xpath ="//table/tbody[2]/tr[3]/td[1]/div/span")
		public WebElement titreSauvModif2;
		
		// Icone "suppression"
		@FindBy (xpath = "//table/tbody[2]/tr[3]/td[5]/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/table/tbody/tr[2]/td[2]/img")
		public WebElement btnSupprimer;
		
		// Message suppression
		@FindBy (xpath = "/html/body/div[3]/div[3]/div/div/div/table[1]/tbody/tr/td/table/tbody/tr/td[3]/div/span")
		public WebElement messageSuppression;
		//"/html/body/div[3]/div[3]/div/div/div/table[1]/tbody/tr/td/table/tbody/tr/td[3]/div/span"
		
		// Bouton confirmation suppression "OK"
		@FindBy (xpath = "//td[contains(text(),'OK')]")
		public WebElement btnConfirmSup;
		
		// Bouton "annuler" suppression
		@FindBy (xpath = "//table[2]/tbody/tr/td/table/tbody/tr/td[3]/span/table/tbody/tr[2]/td[2]")
		public WebElement btnAnnulerSup;
		
		// Message confirmation suppression
		@FindBy (xpath = "//table/tbody/tr/td/table/tbody/tr/td/div/span")
		public WebElement messageConfirmSup;
		//html/body/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td/div/span
		
		public PageCreerTypeCritere creerCriteres (WebDriver driver) {
			btnCreer.click();
			return PageFactory.initElements(driver, PageCreerTypeCritere.class);
		}
		
		public PageCreerTypeCritere modifierCritere (WebDriver driver) {
			btnModifCritSM.click();
			return PageFactory.initElements(driver, PageCreerTypeCritere.class);
		}
		
		public PageCreerTypeCritere modifierCritereNom (WebDriver driver) {
			critSauvModif.click();
			return PageFactory.initElements(driver, PageCreerTypeCritere.class);
		}
		// Annuler suppression critères
		public PageCriteres annulerSuppression (WebDriver driver) {
			Actions a = new Actions(driver);
			a.moveToElement(btnAnnulerSup).build().perform();
			btnAnnulerSup.click();
			return PageFactory.initElements(driver, PageCriteres.class);
		}
		
		// Confirmer suppression critères
		public PageCriteres confimSuppression (WebDriver driver) {
			Actions a = new Actions(driver);
			a.moveToElement(btnConfirmSup).build().perform();
			btnConfirmSup.click();
			return PageFactory.initElements(driver, PageCriteres.class);
		}
}
