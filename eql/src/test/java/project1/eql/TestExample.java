package project1.eql;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import supportTools.EBrowser;
import supportTools.TechTools;

public class TestExample {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = TechTools.chooseBrowser(EBrowser.firefox);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		
	}

}
