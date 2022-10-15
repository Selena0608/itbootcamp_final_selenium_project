package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
//	Home link
//	About link
//	My profile link
//	Admin dugme
//	Cities link iz padajuceg Admin menija
//	Users link iz padajuceg Admin menija
//	Sign up dugme
//	Login dugme
//	Logout dugme
//	Dugme za izbor jezika
//	EN dugme iz padajuceg menija za izbor jezika
//	ES dugme iz padajuceg menija za izbor jezika
//	FR dugme iz padajuceg menija za izbor jezika
//	CN dugme iz padajuceg menija za izbor jezika

	private WebDriver driver;
	private WebDriverWait wait;

	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// Home link
	public WebElement getHomeLink() {
		return (WebElement) driver.findElements(By.className("btnHome"));
	}

	// About link
	public WebElement getAboutLink() {
		return (WebElement) driver.findElements(By.className("btnAbout"));
	}

	// Profile link
	public WebElement getMyProfileLink() {
		return driver.findElement(By.className("btnProfile"));
	}

	// Admin button
	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}

	// Cities link
	public WebElement getCitiesLink() {
		return driver.findElement(By.className("btnAdminCities"));
	}

	// Users link
	public WebElement getUsersLink() {
		return driver.findElement(By.className("btnAdminUsers"));
	}

	// Signup btn
	public WebElement getSignUpBtn() {
		return driver.findElement(By.xpath("//a[@href='/signup']"));
	}

	// Login btn
	public WebElement getLoginBtn() {
		return (WebElement) driver.findElements(By.xpath("//div[contains(@class,'v-toolbar__items')]/a[3]"));
	}

	// Logout button
	public WebElement getLogoutBtn() {
		return (WebElement) driver.findElements(By.xpath("//button[contains(@class,'btnLogout')]"));
	}

	// Btn for language
	public WebElement getLanguageBtn() {
		return (WebElement) driver.findElements(By.className("btnLocaleActivation"));

	}

	// EN btn
	public WebElement getENLanguageButton() {
		return driver.findElement(By.className("btnEN"));
	}

	// ES btn
	public WebElement getESLanguageButton() {
		return driver.findElement(By.className("btnES"));
	}

	// FR btn
	public WebElement getFRLanguageButton() {
		return driver.findElement(By.className("btnFR"));
	}

	// CN btn
	public WebElement getCNLanguageButton() {
		return driver.findElement(By.className("btnCN"));
	}

	// Header
	public WebElement getHeader() {
		return driver.findElement(By.tagName("h1"));
	}

}
