package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurFenetreNewProjet {
	@FindBy (xpath ="//img[contains(@src,'/libreplan/common/img/ico_add.png')]") 
	public WebElement buttonNewProject;
	
	@FindBy (xpath ="//table[1]/tbody[2]/tr[1]/td[2]/div[1]/input[1]")   
	public WebElement nomTextBox;
//
	@FindBy (xpath ="//table[1]/tbody[2]/tr[2]/td[2]/div[1]/span[1]/i[1]/input[1]")   
	public WebElement modeleBandBox;
	
	@FindBy (xpath ="//table[1]/tbody[2]/tr[3]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/input[1]")
	public WebElement croixChecked;

	@FindBy (xpath ="//table[1]/tbody[2]/tr[3]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]") 
	public WebElement codeTextBox;
	
	@FindBy (xpath ="//html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[2]/tr[4]/td[2]/div[1]/i[1]/input[1]") 
	public WebElement dateDebut;
	
	@FindBy (xpath ="//table[1]/tbody[2]/tr[5]/td[2]/div[1]/i[1]/input[1]")
	public WebElement dateEcheance;
	
	@FindBy (xpath ="//table[1]/tbody[2]/tr[6]/td[2]/div[1]/span[1]/i[1]/input[1]")
	public WebElement nomClient;
	
	@FindBy (xpath ="//html[1]/body[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[2]/tr[7]/td[2]/div[1]/i[1]/input[1]")  
	public WebElement calendrierBox;
	
	@FindBy (xpath =" //td[contains(text(),'Accepter')]")  
	public WebElement btnValider;
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> a deplacer dans HomePage<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 	@FindBy (xpath="//td[contains(text(),'Planification de projet')]")
	WebElement boutonPlanificationDeProjet;
	@FindBy (xpath="//td[contains(text(),'Détail du projet')]") 
	WebElement boutonDetailDuProjet;
	@FindBy (xpath="//td[contains(text(),'Chargement des ressources')]") 
	WebElement boutonChangementDesRessources;
	@FindBy (xpath="//td[contains(text(),'Allocation avancée')]") 
	WebElement boutonAllocationAvancee;
	@FindBy (xpath="//td[contains(text(),'Tableau de bord')]") 
	WebElement boutonTableauDeBord;
	 */
	
	public HomePage clickNewProject(WebDriver driver) {
		buttonNewProject.click();
		  return PageFactory.initElements(driver, HomePage.class);
	}
}
