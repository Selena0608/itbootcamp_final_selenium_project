package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
//	Test #1: Visits the admin cities page and list cities
//	Podaci: 
//	admin email: admin@admin.com
//	admin password: 12345
//	Koraci: 
//	Klik na sign up dugme iz navigacije
//	Prijaviti se na sistem admin kredencijalima
//	Klik na admin dugme iz navigacije
//	Klik na Cities dugme iz padajuceg Admin menija
//	Verifikovati da se u url-u stranice javlja /admin/cities ruta 

	@Test(priority = 10)
	public void VisitsTheAdminCitiesPageAndListCities() {

		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginBtn().click();

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
				"ERROR: /admin/cities should be displayed in the URL");
	}

//	Test #2: Checks input types for create/edit new city
//	Koraci: 
//	Klik na admin dugme iz navigacije
//	Klik na Cities dugme iz padajuceg Admin menija
//	Kliknuti na New Item dugme
//	Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//	Verifikovati da polje za unos grada za atribut type ima tekst text

	@Test(priority = 20)
	public void ChecksInputTypesForCreateEditNewCity() {

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		citiesPage.waitForEditAndCreateDialog();
		Assert.assertEquals(citiesPage.getInputNewItemName().getAttribute("type"), "text",
				"ERROR: Input type should be text");

	}

//	Test #3: Create new city
//	Podaci: 
//	city: [Ime i prezime polaznika]’s city
//	Koraci: 
//	Klik na admin dugme iz navigacije
//	Klik na Cities dugme iz padajuceg Admin menija
//	Kliknuti na New Item dugme
//	Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//	Uneti ime grada u polje
//	Kliknuti na Save dugme
//	Sacekati da popu za prikaz poruke bude vidljiv   OVO DOVRSI
//	Verifikovati da poruka sadrzi tekst Saved successfully
	@Test(priority = 30)
	public void createNewCity() {

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		citiesPage.getInputNewItemName().sendKeys("Kragujevac");
		citiesPage.getSaveButton().click();
		wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
		Assert.assertTrue(messagePopUpPage.getTextFromVerifyAccount(), "Popup should be 'Saved successfully'");

	}

//	Test #4: Edit city
//	Podaci: 
//	old city name: [Ime i prezime polaznika]’s city
//	new city name: [Ime i prezime polaznika]’s city Edited
//	Koraci: 
//	Klik na admin dugme iz navigacije
//	Klik na Cities dugme iz padajuceg Admin menija
//	U polje za pretragu uneti staro ime grada
//	Sacekati da broj redova u tabeli bude 1
//	Kliknuti na dugme Edit iz prvog reda
//	Uneti novo ime za grad
//	Kliknuti na dugme Save
//	Sacekati da popu za prikaz poruke bude vidljiv  DOVRSI
//	Verifikovati da poruka sadrzi tekst Saved successfully
	@Test(priority = 40)
	public void EditCity() {

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();

		citiesPage.getSearchInput().sendKeys("Kragujevac");
		citiesPage.getRowEditButton(0).click();
		citiesPage.waitForRowsNumberToBeVisible(1);
		citiesPage.getRowEditButton(1).click();
		citiesPage.getInputNewItemName().clear();
		citiesPage.getInputNewItemName().sendKeys("Kragujevac edited");
		citiesPage.getSaveButton().click();
		wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
		Assert.assertTrue(messagePopUpPage.getTextFromUserError(), "Popup should be 'Saved successfully'");

	}

//	Test #5: Search city
//	Podaci: 
//	city name: [Ime i prezime polaznika]’s city Edited
//	Koraci: 
//	Klik na admin dugme iz navigacije
//	Klik na Cities dugme iz padajuceg Admin menija
//	U polje za pretragu uneti staro ime grada
//	Sacekati da broj redova u tabeli bude 1
//	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
	@Test(priority = 50)
	public void searchCity() {

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();

		citiesPage.getSearchInput().sendKeys("Kragujevac edited");
		citiesPage.waitForRowsNumberToBeVisible(1);
		Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), citiesPage.getSearchInput().getAttribute("value"),
				"Name value should be equal to search value");
		wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
		Assert.assertTrue(messagePopUpPage.getTextFromUserError(), "Popup should be 'Saved successfully'");

	}

//	Test #6: Delete city
//	Podaci: 
//	city name: [Ime i prezime polaznika]’s city Edited
//	Koraci: 
//	Klik na admin dugme iz navigacije
//	Klik na Cities dugme iz padajuceg Admin menija
//	U polje za pretragu uneti staro ime grada
//	Sacekati da broj redova u tabeli bude 1
//	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//	Kliknuti na dugme Delete iz prvog reda
//	Sacekati da se dijalog za brisanje pojavi
//	Kliknuti na dugme Delete iz dijaloga
//	Sacekati da popu za prikaz poruke bude vidljiv
//	Verifikovati da poruka sadrzi tekst Deleted successfully
	@Test(priority = 60)
	public void deleteCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Kragujevac edited");
		citiesPage.waitForRowsNumberToBeVisible(1);
		Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), citiesPage.getSearchInput().getAttribute("value"),
				"Name value should be equal to search value");
		citiesPage.getRowDeleteButton(1).click();
		citiesPage.waitForDeleteDialog();
		citiesPage.getDeleteButton().click();
		wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());

		Assert.assertTrue(messagePopUpPage.getTextFromUserError().contains("Deleted successfully"),
				"Error should be 'Deleted successfully'");
	}

}
