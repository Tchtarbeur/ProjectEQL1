package pageObject;

import java.text.ParseException;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFeuilleTemps {

	//Nom de la page
	@FindBy (xpath="//div[@class=\"z-window-embedded-header\"]")
	public
	WebElement titre;

	//nom colonne 1
	@FindBy (xpath="//tbody[2]/tr[1]/th[1]/div")
	public
	WebElement titreColonne1;

	//nom colonne 2
	@FindBy (xpath="//tbody[2]/tr[1]/th[2]/div")
	public
	WebElement titreColonne2;

	//nom colonne 3
	@FindBy (xpath="//tbody[2]/tr[1]/th[3]/div")
	public
	WebElement titreColonne3;

	//nom colonne 4
	@FindBy (xpath="//tbody[2]/tr[1]/th[4]/div")
	public
	WebElement titreColonne4;

	//nom colonne 5
	@FindBy (xpath="//tbody[2]/tr[1]/th[5]/div")
	public
	WebElement titreColonne5;

	//nom colonne 6
	@FindBy (xpath="//tbody[2]/tr[1]/th[6]/div")
	public
	WebElement titreColonne6;

	//liste déroulante pour filtrer par modèle
	@FindBy (xpath="//select")
	public
	WebElement filtreModele;

	//choix "Montrer tout" de la liste déroulante pour filtrer par modèle
	@FindBy (xpath="//select/option[1]")
	public
	WebElement choixMontrerToutFiltreModele;

	//champ calendrier pour filtrer avec une date de début
	@FindBy (xpath="//td[9]/i/input[@class='z-datebox-inp']")
	public
	WebElement champCalendrierDe;

	//champ calendrier pour filtrer avec une date de fin
	@FindBy (xpath="//td[13]/i/input[@class='z-datebox-inp']")
	public
	WebElement champCalendrierA;

	//boutton "Filtre" pour appliquer les filtres choisis
	@FindBy (xpath="//td[@class='z-button-cm' and contains(., 'Filtre')]")
	public
	WebElement boutonFiltre;

	//Liste déroulantes pour choisir un canevas
	@FindBy (xpath="//td[3]/select")
	public
	WebElement ldChoisirCanevas;

	//Options "Default" de la liste déroulantes pour choisir un canevas
	@FindBy (xpath="//td[3]/select/option[1]")
	public
	WebElement choixDefaultldChoisircanevas;

	//Boutton pour créer une nouvelle feuille de temps
	@FindBy (xpath="//td[@class='z-button-cm' and contains(., 'Nouvelle feuille de temps')]")
	public
	WebElement boutonNouvelleFeuilleDeTemps;

	//Message d'information
	@FindBy (xpath="//div[@class='message_INFO']/span")
	public
	WebElement messageInfo;

	//1ère date de début du tableau
	@FindBy (xpath="//div[3]/table[1]/tbody[2]/tr[1]//span[1]")
	public
	WebElement dateDebut1;

	//1ère date de fin du tableau
	@FindBy (xpath="//div[3]/table[1]/tbody[2]/tr[1]/td[2]//span[1]")
	public
	WebElement dateFin;

	//1er travail total du tableau
	@FindBy (xpath="//div[3]/table[1]/tbody[2]/tr[1]/td[4]//span[1]")
	public
	WebElement travailTotal;

	//1er modèle du tableau
	@FindBy (xpath="//div[3]/table[1]/tbody[2]/tr[1]/td[3]//span[1]")
	public
	WebElement modele;


	public PageCreerFeuilleTemps creerFeuilleTemps(WebDriver driver) {
		boutonNouvelleFeuilleDeTemps.click();
		return PageFactory.initElements(driver, PageCreerFeuilleTemps.class);

	}

	//Méthode pour avoir un xpath avec une variable
	public WebElement xpathFTVariable(WebDriver driver, String codeNouvelleFT) {
		WebElement dernierFTCreee = driver.findElement(By.xpath("//span[contains(text(),'"+codeNouvelleFT+"')]"));
		return dernierFTCreee;
	}

	public void dateDebutDecroissante (WebDriver driver) throws ParseException {
		for (int i=2; i<5; i++) {
			//transformer en Date 1er WebElement
			String s1 = dateDebut1.getText();
			SimpleDateFormat sdf1 = new SimpleDateFormat("d MMM yyyy");
			Date d1 = sdf1.parse(s1);
			//transformer en Date 2ème WebElement avec xpath variable
			WebElement dateDebut2 = driver.findElement(By.xpath("//div[3]/table[1]/tbody[2]/tr["+i+"]//span[1]"));
			String s2 = dateDebut2.getText();
			SimpleDateFormat sdf2 = new SimpleDateFormat("d MMM yyyy");
			Date d2 = sdf2.parse(s2);
			//Comparer les 2 dates
			assertTrue (d1.after(d2));
			//modifier 1ère date
			dateDebut1= dateDebut2;
		}
	}

	public void dateFinCroissante (WebDriver driver) throws ParseException {
		for (int i=2; i<5; i++) {
			WebElement dateFin1= dateFin;
			//transformer en Date 1er WebElement
			String s1 = dateFin1.getText();
			SimpleDateFormat sdf1 = new SimpleDateFormat("d MMM yyyy");
			Date d1 = sdf1.parse(s1);
			//transformer en Date 2ème WebElement avec xpath variable
			WebElement dateFin2 = driver.findElement(By.xpath("//div[3]/table[1]/tbody[2]/tr["+i+"]/td[2]//span[1]"));
			String s2 = dateFin2.getText();
			SimpleDateFormat sdf2 = new SimpleDateFormat("d MMM yyyy");
			Date d2 = sdf2.parse(s2);
			//Comparer les 2 dates
			assertTrue (d1.before(d2));
			//modifier 1ère date
			dateFin1= dateFin2;
		}

	}

	public void dateFinDecroissante (WebDriver driver) throws ParseException {
		for (int i=2; i<5; i++) {
			WebElement dateFin1= dateFin;
			//transformer en Date 1er WebElement
			String s1 = dateFin1.getText();
			SimpleDateFormat sdf1 = new SimpleDateFormat("d MMM yyyy");
			Date d1 = sdf1.parse(s1);
			//transformer en Date 2ème WebElement avec xpath variable
			WebElement dateFin2 = driver.findElement(By.xpath("//div[3]/table[1]/tbody[2]/tr["+i+"]//span[1]"));
			String s2 = dateFin2.getText();
			SimpleDateFormat sdf2 = new SimpleDateFormat("d MMM yyyy");
			Date d2 = sdf2.parse(s2);
			//Comparer les 2 dates
			assertTrue (d1.after(d2));
			//modifier 1ère date
			dateFin1= dateFin2;
		}
		

	}

	public void travailTotalCroissant (WebDriver driver) {
		for (int i=2; i<5; i++) {
			WebElement travailTotal1 = travailTotal;
			//transformer en int 1er WebElement
			String s1 = travailTotal1.getText();
			int int1 = Integer.parseInt(s1);	
			//transformer en int 2ème WebElement avec xpath variable
			WebElement travailTotal2 = driver.findElement(By.xpath("//div[3]/table[1]/tbody[2]/tr["+i+"]/td[4]//span[1]"));
			String s2 = travailTotal2.getText();
			int int2 = Integer.parseInt(s2);
			//Comparer les 2 int
			assertTrue (int1<int2);
			//modifier 1ère int
			travailTotal1= travailTotal2;
		}

	}

	public void travailTotalDecroissant (WebDriver driver) {
		for (int i=2; i<5; i++) {
			WebElement travailTotal1 = travailTotal;
			//transformer en int 1er WebElement
			String s1 = travailTotal1.getText();
			int int1 = Integer.parseInt(s1);	
			//transformer en int 2ème WebElement avec xpath variable
			WebElement travailTotal2 = driver.findElement(By.xpath("//div[3]/table[1]/tbody[2]/tr["+i+"]/td[4]//span[1]"));
			String s2 = travailTotal2.getText();
			int int2 = Integer.parseInt(s2);
			//Comparer les 2 int
			assertTrue (int1>int2);
			//modifier 1ère int
			travailTotal1= travailTotal2;
		}

	}

	public void modeleOrdreAplha (WebDriver driver) {
		for (int i=2; i<5; i++) {
			WebElement modele1 = modele;
			boolean result= false;
			String s1 = modele1.getText();
			char lettre1=s1.charAt(0);

			WebElement modele2 = driver.findElement(By.xpath("//div[3]/table[1]/tbody[2]/tr["+i+"]/td[3]//span[1]"));
			String s2 = modele2.getText();
			char lettre2= s2.charAt(0);

			int a = Character.compare(lettre1, lettre2);
			if (a<=0) {
				 result = true;
			}
			else {
				 result = false;
			}
			assertTrue (result);
			modele1 = modele2;
		}
	}
	
	public void modeleOrdreAplhaInverse (WebDriver driver) {
		for (int i=2; i<5; i++) {
			WebElement modele1 = modele;
			boolean result= false;
			String s1 = modele1.getText();
			char lettre1=s1.charAt(0);

			WebElement modele2 = driver.findElement(By.xpath("//div[3]/table[1]/tbody[2]/tr["+i+"]/td[3]//span[1]"));
			String s2 = modele2.getText();
			char lettre2= s2.charAt(0);

			int a = Character.compare(lettre1, lettre2);
			if (a>=0) {
				 result = true;
			}
			else {
				 result = false;
			}
			assertTrue (result);
			modele1 = modele2;
		}
	}

}

