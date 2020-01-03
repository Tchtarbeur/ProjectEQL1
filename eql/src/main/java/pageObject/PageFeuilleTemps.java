package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFeuilleTemps {
	
	@FindBy (xpath="//div[@class=\"z-window-embedded-header\"]")
	public
	WebElement titre;
	@FindBy (xpath="//tbody[2]/tr[1]/th[1]/div")
	public
	WebElement titreColonne1;
	@FindBy (xpath="//tbody[2]/tr[1]/th[2]/div")
	public
	WebElement titreColonne2;
	@FindBy (xpath="//tbody[2]/tr[1]/th[3]/div")
	public
	WebElement titreColonne3;
	@FindBy (xpath="//tbody[2]/tr[1]/th[4]/div")
	public
	WebElement titreColonne4;
	@FindBy (xpath="//tbody[2]/tr[1]/th[5]/div")
	public
	WebElement titreColonne5;
	@FindBy (xpath="//tbody[2]/tr[1]/th[6]/div")
	public
	WebElement titreColonne6;
	@FindBy (xpath="//select")
	public
	WebElement filtreModele;
	@FindBy (xpath="//select/option[1]")
	public
	WebElement choixMontrerToutFiltreModele;
	@FindBy (xpath="//td[9]/i/input[@class='z-datebox-inp']")
	public
	WebElement champCalendrierDe;
	@FindBy (xpath="//td[13]/i/input[@class='z-datebox-inp']")
	public
	WebElement champCalendrierA;
	@FindBy (xpath="//td[@class='z-button-cm' and contains(., 'Filtre')]")
	public
	WebElement bouttonFiltre;
	@FindBy (xpath="//td[3]/select")
	public
	WebElement ldChoisirCanevas;
	@FindBy (xpath="//td[3]/select/option[1]")
	public
	WebElement choixDefaultldChoisircanevas;
	@FindBy (xpath="//td[@class='z-button-cm' and contains(., 'Nouvelle feuille de temps')]")
	public
	WebElement bouttonNouvelleFeuilleDeTemps;
	
	public PageCreerFeuilleTemps creerFeuilleTemps(WebDriver driver) {
		bouttonNouvelleFeuilleDeTemps.click();
		return PageFactory.initElements(driver, PageCreerFeuilleTemps.class);
		
	}

}
