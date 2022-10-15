package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
//	dugme New Item
//	input za pretragu
//	metodu koja ceka da se dijalog za editovanje i kreiranje pojavi
//	metodu koja ceka da se dijalog za brisanje pojavi
//	save dugme iz dijalog za editovanje i kreiranje
//	delete dugme iz dijaloga za brisanje
//	metodu koja ceka da se u tabeli pojavi odredjeni broj redova. 
//	Metoda kao parametar prima broj redova. Ako se metoda pozove sa 
//	parametrom 5, to znaci da metoda ceka da se u tabeli pojavi 5 redova.
//	metodu koja vraca celiju iz odredjenog reda. Metoda kao parametre prima 
//	red i kolonu a vraca td iz tabele. Npr: ukoliko se metoda pozove row=2, 
//	cell=3 tada metoda vraca trecu celiju iz 2 reda.
//	metodu koja vraca edit dugme trazenog reda. Metoda kao parametar prima 
//	red a vraca dugme. Npr ako se metoda pozove row=3, metoda vraca edit dugme 
//	iz treceg reda tabele
//	metodu koja vraca delete dugme trazenog reda. Metoda kao parametar prima 
//	red a vraca dugme. Npr ako se metoda pozove row=3, metoda vraca delete 
//	dugme iz treceg reda tabele

	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	//New Item Button
	public WebElement getNewItemBtn() {
		return (WebElement) driver.findElements(By.className("btnNewItem"));
	}
	
	//Input City Name Dlg
	public WebElement getInputNewItemName() {
		return (WebElement) driver.findElements(By.id("name"));
	}

	//Search Input
	public WebElement getSearchInput() {
		return (WebElement) driver.findElements(By.id("search"));
	}

	//Method wait dialog for create and edit
	public void waitForEditAndCreateDialog() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'dlgNewEditItem')]")));

	}

	//Method wait dialog for delete
	public void waitForDeleteDialog() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-dialog')]\")[7]")));
	}
	
	
	//Save button from dialog edit and create	
	public WebElement getSaveButton() {
		return (WebElement) driver.findElements(By.xpath("//button[contains(@class,'btnSave')]"));
	}
	
	//Delete button from delete dialog
	public WebElement getDeleteButton() {
		return (WebElement) driver.findElements(By.xpath("//*[text()=' Delete ']"));
	}

	//	metodu koja ceka da se u tabeli pojavi odredjeni broj redova.
	public void waitForRowsNumberToBeVisible(int rowNum) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rowNum));
	}

	 public WebElement getTableCell(int row, int cell) {
	        return driver.findElement(By.xpath("//table//tr" + "[" + row + "]" + "/td" + "[" + cell + "]"));
	    }

	public WebElement getRowEditButton(int row) {
        return driver.findElement(By.xpath("//table//tr" + "[" + row + "]" + "//button[1]"));
    }

    public WebElement getRowDeleteButton(int row) {
        return driver.findElement(By.xpath("//table//tr" + "[" + row + "]" + "//button[2]"));
    }
	
}
