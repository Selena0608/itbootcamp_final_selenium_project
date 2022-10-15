package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CitiesPage;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;
import pages.SignupPage;





public class BasicTest {
	
//	Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
//		baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
//		beforeClass - gde se podesava drajver sa implicitnim cekanjem i cekanjem 
//		za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
//		aftterClass - gde se gasi stranica
//		beforeMethod - gde se pre svakog testa ucitava baseUrl stranica
//		(za vezbanje) afterMethod - gde se kreira screenshot stranice u slucaju 
//		da test ne prodje

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	protected NavPage navPage;
	protected LoginPage loginPage;
	protected SignupPage signupPage;
	protected CitiesPage citiesPage;
	protected MessagePopUpPage messagePopUpPage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		navPage = new NavPage(driver, wait);
		loginPage = new LoginPage(driver, wait);
		signupPage = new SignupPage(driver, wait);
		citiesPage = new CitiesPage(driver, wait);
		messagePopUpPage = new MessagePopUpPage(driver, wait);
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
//	@AfterMethod
//	public void afterMethod() {
		
//	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
