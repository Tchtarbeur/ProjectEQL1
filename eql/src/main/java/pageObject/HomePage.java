package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Menu "Calendrier"
	@FindBy (xpath="//button[contains(text(),'Calendrier')]")
	public WebElement calendrier;
	
	// Sous-menu "Projet"
	@FindBy (xpath="//a[contains(text(),'Projet')]")
	public WebElement projet;
	
	// Menu "Coût"
	@FindBy (xpath="//button[contains(text(),'Coût')]")
	public WebElement cout;
	// Sous-Menu "Feuille de temps"
	@FindBy (xpath="//a[contains(text(),'Feuille de temps')]")
	public WebElement feuilleDeTemps;
	
	// Menu "Ressources"
	@FindBy (xpath="//button[contains(text(),'Ressources')]")
	public WebElement ressources;
	// Sous-Menu "Participants
	@FindBy (xpath="//a[contains(text(),'Participants')]")
	public WebElement participants;
	// Sous-Menu "Machines"
	@FindBy (xpath="//a[contains(text(),'Machines')]")
	public WebElement machines;
	// Sous-Menu "Critères"
	@FindBy (xpath="//a[contains(text(),'Critères')]")
	public WebElement criteres;
	//Sous-menu "Calendriers"
	@FindBy (xpath="//a[contains(text(),'Calendriers')]")
	public WebElement calendriers;
	//href="/libreplan/calendars/calendars.zul"
	
	// Bouton "Planification de projet"
	@FindBy (xpath="//td[contains(text(),'Planification de projet')]")
	public WebElement boutonPlanificationDeProjet;
	
	// Bouton "Détail du projet"
	@FindBy (xpath="//td[contains(text(),'Détail du projet')]") 
	public WebElement boutonDetailDuProjet;
	
	// Bouton "Chargement des ressources"
	@FindBy (xpath="//td[contains(text(),'Chargement des ressources')]") 
	public WebElement boutonChangementDesRessources;

	// Bouton "Allocation Avancée"
	@FindBy (xpath="//td[contains(text(),'Allocation avancée')]") 
	public WebElement boutonAllocationAvancee;

	// Bouton "Tableau de Bord"
	@FindBy (xpath="//td[contains(text(),'Tableau de bord')]") 
	public WebElement boutonTableauDeBord;

	// Accés page "Feuille de temps"
	public PageFeuilleTemps allerSurFeuilleTemps (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(cout).build().perform();
		feuilleDeTemps.click();
		return PageFactory.initElements(driver, PageFeuilleTemps.class);
	}
	
	// Accés page "Participants"
	public PageParticipants allerSurPageParticipant (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(ressources).build().perform();
		participants.click();
		return PageFactory.initElements(driver, PageParticipants.class);
	}
	
	// Accés page "Machines"
	public PageMachines allerSurPageMachines (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(ressources).build().perform();
		machines.click();
		return PageFactory.initElements(driver, PageMachines.class);
	}
	
	// Accés page "Critère"
	public PageCriteres allerSurPageCriteres (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(ressources).build().perform();
		criteres.click();
		return PageFactory.initElements(driver, PageCriteres.class);
	}
	
	// Accés page "Calendrier"
		public PageCalendrier allerSurPageCal (WebDriver driver) {
			Actions a = new Actions(driver);
			a.moveToElement(ressources).build().perform();
			calendriers.click();
			return PageFactory.initElements(driver, PageCalendrier.class);
		}
		// Accés page "Projet"
		public PageProjet allerSurPageProjet (WebDriver driver) {
			Actions a = new Actions(driver);
			a.moveToElement(calendrier).build().perform();
			projet.click();
			return PageFactory.initElements(driver, PageProjet.class);
		}
}
