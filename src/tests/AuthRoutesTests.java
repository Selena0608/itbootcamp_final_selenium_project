package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {


//	Test #1: Forbids visits to home url if not authenticated
//	Koraci: 
//	Ucitati /home stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 10)
	public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}

//	Test #2: Forbids visits to profile url if not authenticated
//	Koraci: 
//	Ucitati /profile stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 20)
	public void ForbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}

//	Test #3: Forbids visits to admin cities url if not authenticated
//	Koraci: 
//	Ucitati /admin/cities stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 30)
	public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}

//	Test #4: Forbids visits to admin users url if not authenticated
//	Koraci: 
//	Ucitati /admin/users stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 40)
	public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}
}
