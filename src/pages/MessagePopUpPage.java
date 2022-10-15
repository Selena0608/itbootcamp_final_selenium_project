package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
//	metodu koja ceka da pop up bude vidljiv
//	Elemente koji u sebi sadrze tekstove poruke
//	Close dugme
//	metodu koja ceka da se verify your account dijalog pojavi
//	metodu koja vraca zaglavlje iz verify your account dijaloga 
//	koji sadrzi tekst IMPORTANT: Verify your account
//	Close dugme iz verify account dijaloga
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	//Wait popup to be visible
	public void waitForPopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-snack__content')]")));
	}
	
	//Popup elements with massage
	public WebElement getPopUpMessage() {
		return (WebElement) driver.findElements(By.xpath("//div[contains(@class,'v-snack__content')]/ul/li"));
		
	}
	
	//Close btn
	public WebElement getCloseBtn() {
		return (WebElement) driver.findElements(By.xpath("//button[contains(@class,'v-btn')][4]"));
	}
	
	//Wait verify account dlg
	public void waitVerifyAccountDialog() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-dialog--active')]")));
	}
	
	//Verify your account text
	public String getTextFromVerifyAccount() {
		return driver.findElement(By.xpath("//div[contains(@class, 'dlgVerifyAccount')]")).getText();
	    }
	
	//Close dugme iz verify account dijaloga	
	public WebElement getVerifyCloseButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
		}
	
	
	public WebElement successDialog() {
        return driver.findElement(By.xpath("//div[contains(@class, 'success')]"));
    }
	
	
		
	
	
	

	
	
}
