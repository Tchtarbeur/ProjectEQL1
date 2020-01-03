package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreerFeuilleTemps {

	@FindBy (xpath="//div[2]/div[2]//div[@class='z-window-embedded-header']")
	public
	WebElement titre;
	@FindBy (xpath="//tr[1]/td[1]/fieldset/legend/span")
	public
	WebElement blocDonnéesGénérales;
	@FindBy (xpath="//td[1]/input")
	public
	WebElement blocDonnéesGénéralesChampCode;
	@FindBy (xpath="//td[3]//input")
	public
	WebElement blocDonnéesGénéralesCase;
	@FindBy (xpath="//label")
	public
	WebElement blocDonnéesGénéralesGenererLeCode;
	@FindBy (xpath="//tr[3]/td[1]/fieldset/legend/span")
	public
	WebElement blocChampsRubriques;
	@FindBy (xpath="//tr[7]/td[1]/fieldset/legend/span")
	public
	WebElement blocLignesDeFeuillesDeTemps;
	@FindBy (xpath="//tr[7]//td[@class='z-button-cm']")
	public
	WebElement bouttonAjouterUneLigne;
	@FindBy (xpath="//tr[7]//th[1]/div/div/parent::div")
	public
	WebElement titreColonne1;
	@FindBy (xpath="//tr[7]//th[2]/div/div/parent::div")
	public
	WebElement titreColonne2;
	@FindBy (xpath="//tr[7]//th[3]/div/div/parent::div")
	public
	WebElement titreColonne3;
	@FindBy (xpath="//tr[7]//th[4]/div/div/parent::div")
	public
	WebElement titreColonne4;
	@FindBy (xpath="//tr[7]//th[5]/div/div/parent::div")
	public
	WebElement titreColonne5;
	@FindBy (xpath="//tr[7]//th[6]/div/div/parent::div")
	public
	WebElement titreColonne6;
	@FindBy (xpath="//tr[7]//th[7]/div/div/parent::div")
	public
	WebElement titreColonne7;
	@FindBy (xpath="//tr[7]//th[8]/div/div/parent::div")
	public
	WebElement titreColonne8;
	@FindBy (xpath="//td[contains(text(),'Enregistrer')]")
	public
	WebElement btEnregistrer;
	@FindBy (xpath="//td[contains(text(),'Sauver ')]")
	public
	WebElement btSauverEtContinuer;
	@FindBy (xpath="//td[contains(text(),'Sauvegarder')]")
	public
	WebElement btSauvegarder ;
	@FindBy (xpath="//td[contains(text(),'Annuler')]")
	public
	WebElement btAnnuler;

}
