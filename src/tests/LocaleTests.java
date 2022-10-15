package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

	@Test(priority = 20)
	public void setLocaleToES() {
		navPage.getLanguageBtn().click();
		navPage.getESLanguageButton().click();
		Assert.assertEquals(navPage.getHeader().getText().equals("Página de aterrizaje"), "Página de aterrizaje",
				"H1 element should have text: Página de aterrizaje");

	}

	@Test(priority = 30)
	public void setLocaleToEN() {
		navPage.getLanguageBtn().click();
		navPage.getENLanguageButton().click();
		Assert.assertEquals(navPage.getHeader().getText().equals("Landing"), "Página de aterrizaje",
				"H1 element should have text: Landing");
	}

	@Test(priority = 40)
	public void setLocaleToCN() {
		navPage.getLanguageBtn().click();
		navPage.getCNLanguageButton().click();
		Assert.assertEquals(navPage.getHeader().getText().equals("首页"), "Página de aterrizaje",
				"H1 element should have text: 首页");
	}

	@Test(priority = 50)
	public void setLocaleToFR() {
		navPage.getLanguageBtn().click();
		navPage.getFRLanguageButton().click();
		Assert.assertEquals(navPage.getHeader().getText().equals("Page d'atterrissage"), "Página de aterrizaje",
				"H1 element should have text: Page d'atterrissage");
	}
}
