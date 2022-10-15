package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

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

	@Test(priority = 20)
	public void ChecksInputTypesForCreateEditNewCity() {

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		citiesPage.waitForEditAndCreateDialog();
		Assert.assertEquals(citiesPage.getInputNewItemName().getAttribute("type"), "text",
				"ERROR: Input type should be text");

	}

	@Test(priority = 30)
	public void createNewCity() {

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemBtn().click();
		citiesPage.getInputNewItemName().sendKeys("Kragujevac");
		citiesPage.getSaveButton().click();
		wait.until(webDriver -> messagePopUpPage.successDialog().isDisplayed());
		Assert.assertTrue(messagePopUpPage.getTextFromVerifyAccount().contains("Saved successfully"),
				"Popup should be 'Saved successfully'");

	}

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
		Assert.assertEquals(messagePopUpPage.getPopUpMessage().getText(), "Popup should be 'Saved successfully'");

	}

	@Test(priority = 50)
	public void searchCity() {

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();

		citiesPage.getSearchInput().sendKeys("Kragujevac edited");
		citiesPage.waitForRowsNumberToBeVisible(1);
		Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(), citiesPage.getSearchInput().getAttribute("value"),
				"Name value should be equal to search value");

	}

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

		Assert.assertEquals(messagePopUpPage.getPopUpMessage().getText(), "Error should be 'Deleted successfully'");
	}

}
