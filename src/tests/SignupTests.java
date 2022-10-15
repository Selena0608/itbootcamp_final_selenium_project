package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

//	Test #1: Visits the signup page
//	Koraci: 
//	Klik na sign up dugme iz navigacije
//	Verifikovati da se u url-u stranice javlja /signup ruta 

	@Test(priority = 10)
	public void VisitsTheSignupPage() {

		navPage.getSignUpBtn().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "/signup should be displayed in the URL");
	}

//	Test #2: Checks input types
//	Koraci: 
//	Klik na sign up dugme iz navigacije
//	Verifikovati da polje za unos emaila za atribut type ima vrednost email
//	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//	Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password

	@Test(priority = 20)
	public void ChecksInputTypes() {

		navPage.getSignUpBtn().click();

		Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), "email", "Input type should be email");

		Assert.assertEquals(signupPage.getPasswordInput().getAttribute("password"), "password",
				"Input type should be password");

		Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("password"), "password",
				"Input type should be password");

	}

//	Test #3: Displays errors when user already exists
//	Podaci: 
//	name: Another User
//	email: admin@admin.com
//	password: 12345
//	confirm password: 12345
//	Koraci: 
//	Klik na sign up dugme iz navigacije
//	Verifikovati da se u url-u stranice javlja /signup ruta 
//	Popuniti formu za registraciju podacima
//	Klik na sign up dugme
//	Sacekati da popu za prikaz poruke bude vidljiv
//	Verifikovati da greska sadrzi poruku E-mail already exists
//	Verifikovati da se u url-u stranice javlja /signup ruta 

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

//	Test #4: Signup
//	Podaci: 
//	name: Ime i prezime polaznika
//	email template: ime.prezime@itbootcamp.rs
//	password: 12345
//	confirm password: 12345
//	Koraci: 
//	Klik na sign up dugme iz navigacije
//	Popuniti formu podacima za registraciju
//	Klik na sign up dugme
//	Ucitati stranicu /home
//	Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
//	Kliknuti na Close dugme iz dijaloga
//	Kliknuti na logout
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
