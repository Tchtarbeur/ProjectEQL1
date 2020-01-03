package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	/*@FindBy (partialLinkText = "Ressources")
	WebElement resourcesMenu;*/
	@FindBy (xpath="//button[contains(text(),'Calendrier')]")
	WebElement calendrier;
	@FindBy (xpath="//a[contains(text(),'Projet')]")
	WebElement projet;
	
	public PageProjet allerSurProjet (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(calendrier).build().perform();
		a.moveToElement(projet).build().perform();
		projet.click();
		return PageFactory.initElements(driver, PageProjet.class);
	}
	

}
