package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {



	@Test(priority = 10)
	public void VisitsTheSignupPage() {

		navPage.getSignUpBtn().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "/signup should be displayed in the URL");
	}



	@Test(priority = 20)
	public void ChecksInputTypes() {

		navPage.getSignUpBtn().click();

		Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), "email", "Input type should be email");

		Assert.assertEquals(signupPage.getPasswordInput().getAttribute("password"), "password",
				"Input type should be password");

		Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("password"), "password",
				"Input type should be password");

	}



	@Test(priority = 30)
	public void DisplaysErrorsWhenUserAlreadyExists() {

		navPage.getSignUpBtn().click();

		navPage.getSignUpBtn().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "ERROR: /signup should be displayed in the URL");
		signupPage.getNameInput().sendKeys("Selena Radovanovic");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();

		messagePopUpPage.waitForPopUp();

		Assert.assertEquals(messagePopUpPage.getPopUpMessage().getText().equals("E-mail already exists"),
				"E-mail already exists", "Message should be  - E-mail already exists");

		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "/signup should be displayed in the URL");
	}


	@Test(priority = 40)
	public void signUp() throws InterruptedException {

		navPage.getSignUpBtn().click();
		signupPage.getNameInput().sendKeys("Selena Radovanovic");
		signupPage.getEmailInput().sendKeys("selena.radovanovic@itbootcamp.rs");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();

		Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().equals("IMPORTANT: Verify your account"));

		messagePopUpPage.getCloseBtn().click();
		navPage.getLogoutBtn().click();
	}

}
