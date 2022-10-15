package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
//	Polje za unos imena
//	Polje za unos emaila
//	Polje za unos lozinke
//	Polje za potvrdi lozinku
//	Sign me up dugme

	private WebDriver driver;
	private WebDriverWait wait;

	public SignupPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	//Name input
	public WebElement getNameInput() {
		return (WebElement) driver.findElements(By.id("name"));
	}

	//Email input
	public WebElement getEmailInput() {
		return (WebElement) driver.findElements(By.id("email"));
	}

	//Password input
	public WebElement getPasswordInput() {
		return (WebElement) driver.findElements(By.id("password"));
	}

	//Confirm password input
	public WebElement getConfirmPasswordInput() {
		return (WebElement) driver.findElements(By.id("confirmPassword"));
	}

	// SignMeUp button
	public WebElement getSignMeUpButton() {
		return (WebElement) driver.findElements(By.xpath("//*[text()='Sign me up']"));
	}

}