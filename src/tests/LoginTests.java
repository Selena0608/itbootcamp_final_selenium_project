package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

//	Test #1: Visits the login page
//	Koraci: 
//	Postaviti EN jezik stranice
//	Klik na login dugme iz navigacije
//	Verifikovati da se u url-u stranice javlja ruta /login

	@Test(priority = 10)
	public void visitsTheLoginPage() throws InterruptedException {
		navPage.getLanguageBtn().click();
		navPage.getENLanguageButton().click();
		navPage.getLoginBtn().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
				"/login should be displayed in the URL");
	}

//	Checks input types
//	Klik na login dugme iz navigacije
//	Verifikovati da polje za unos emaila za atribut type ima vrednost email
//	Verifikovati da polje za unos lozinke za atribut type ima vrednost password

	@Test(priority = 20)
	public void checksInputTypes() throws InterruptedException {

		navPage.getLoginBtn().click();

		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), 
				"email",
				"Input type should be email");

		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), 
				"password",
				"Input type should be password");
	}

//	Podaci: 
//		email: non-existing-user@gmal.com
//		password: password123
//	Koraci: 
//		Klik na login dugme iz navigacije
//		Popuniti login formu podacima za logovanje
//		Klik na login dugme
//		Sacekati da popu za prikaz greske bude vidljiv
//		Verifikovati da greska sadrzi poruku User does not exists
//		Verifikovati da se u url-u stranice javlja /login ruta 

	@Test(priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {

		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUp();

		Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().equals("User does not exists"),
				"Message should be User does not exists");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
				"/login should be displayed in the URL");

	}

//	 Displays errors when password is wrong
//	 Podaci: 
//	 email: admin@admin.com
//	 password: password123
//	 Koraci: 
//	 Klik na login dugme iz navigacije
//	 Popuniti login formu podacima za logovanje
//	 Klik na login dugme
//	 Sacekati da popu za prikaz poruke bude vidljiv
//	 Verifikovati da greska sadrzi poruku Wrong password
//	 Verifikovati da se u url-u stranice javlja /login ruta 

	@Test(priority = 40)
	public void displaysErrorsWhenPasswordIsWrong() {

		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUp();

		Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().equals("Wrong password"),
				"Message should be Wrong password");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), 
				"/login should be displayed in the URL");

	}

//	Test #5: Login
//	Podaci: 
//	email: admin@admin.com
//	password: 12345
//	Koraci: 
//	Klik na login dugme iz navigacije
//	Popuniti login formu podacima za logovanje
//	Verifikovati da se u url-u stranice javlja /home ruta 

	@Test(priority = 50)
	public void login() {

		navPage.getLoginBtn().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginBtn().click();

		messagePopUpPage.waitForPopUp();

		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), 
				"/login should be displayed in the URL");

	}

//	Test #6: Logout
//	Koraci: 
//	Verifikovati da je dugme logout vidljivo na stranici
//	Kliknuti na logout dugme

	@Test(priority = 60)
	public void logout() {

		Assert.assertTrue(navPage.getLogoutBtn().isDisplayed(), 
				"Logout button should be displayed");
		navPage.getLogoutBtn().click();

	}

}
