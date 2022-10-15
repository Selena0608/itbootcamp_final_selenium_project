package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheLoginPage() throws InterruptedException {
		navPage.getLanguageBtn().click();
		navPage.getENLanguageButton().click();
		navPage.getLoginBtn().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "/login should be displayed in the URL");
	}

	@Test(priority = 20)
	public void checksInputTypes() throws InterruptedException {

		navPage.getLoginBtn().click();

		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email", "Input type should be email");

		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
				"Input type should be password");
	}

	@Test(priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {

		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUp();

		Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().equals("User does not exists"),
				"Message should be User does not exists");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "/login should be displayed in the URL");

	}

	@Test(priority = 40)
	public void displaysErrorsWhenPasswordIsWrong() {

		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUp();

		Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().equals("Wrong password"),
				"Message should be Wrong password");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "/login should be displayed in the URL");

	}

	@Test(priority = 50)
	public void login() {

		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUp();

		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "/login should be displayed in the URL");

	}

	@Test(priority = 60)
	public void logout() {

		Assert.assertTrue(navPage.getLogoutBtn().isDisplayed(), "Logout button should be displayed");
		navPage.getLogoutBtn().click();

	}

}
