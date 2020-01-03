package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import supportTools.TechTools;

public class LoginPage {
	@FindBy (xpath = "//input[@name='j_username']")
	WebElement nameField;
	
	@FindBy (xpath ="//input[@name='j_password']")
	WebElement passwordField;
	
	@FindBy (xpath ="//input[@id='button']")
	WebElement connectBtn;
	
	public void login (String user, String password) {
		TechTools.inputText(nameField, user);
		TechTools.inputText(passwordField, password);
	}
	
	public HomePage connection (WebDriver driver) {
		connectBtn.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
}
