package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	/*@FindBy (partialLinkText = "Ressources")
	WebElement resourcesMenu;*/
	@FindBy (xpath="//button[contains(text(),'Calendrier')]")
	public
	WebElement calendrier;
	@FindBy (xpath="//a[contains(text(),'Projet')]")
	public
	WebElement projet;
	@FindBy (xpath="//button[contains(text(),'Coût')]")
	public
	WebElement cout;
	@FindBy (xpath="//a[contains(text(),'Feuille de temps')]")
	public
	WebElement feuilleDeTemps;
	@FindBy (xpath="//button[contains(text(),'Ressources')]")
	public
	WebElement ressources;
	@FindBy (xpath="//a[contains(text(),'Participants')]")
	public
	WebElement participants;

	public PageFeuilleTemps allerSurFeuilleTemps (WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(cout).build().perform();
		feuilleDeTemps.click();
		return PageFactory.initElements(driver, PageFeuilleTemps.class);
	}


}
