package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {



	
	@Test(priority = 10)
	public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}


	@Test(priority = 20)
	public void ForbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}


	
	@Test(priority = 30)
	public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}


	
	@Test(priority = 40)
	public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		Assert.assertEquals(driver.getCurrentUrl().contains("/login"), "login", "URL should contain '/login'");
	}
}
