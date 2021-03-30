package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By pasteField = By.id("postform-text");
    private By pasteExpirationPushing = By.id("select2-postform-expiration-container");
    private By pasteExpirationSelection = By.xpath("//li[text()='10 Minutes']");
    private By pasteNameFieldPushing = By.id("postform-name");
    private By newPasteButton = By.xpath("//button[@class='btn -big']");
    private By successNote = By.xpath("//div[contains(@class, 'notice -success -post-view')]");

    public void openPage() {
        driver.get("https://pastebin.com");
    }

    public void writeTextInToNewPasteField(String textForNewPaste) {
        driver.findElement(pasteField).sendKeys(textForNewPaste);
    }

    public void selectPasteExpiration() {
        driver.findElement(pasteExpirationPushing).click();
        driver.findElement(pasteExpirationSelection).click();
    }

    public void writeTextInToPasteNameField(String textForPasteName) {
        driver.findElement(pasteNameFieldPushing).sendKeys(textForPasteName);
    }

    public void pressCreateNewPasteButton() {
        driver.findElement(newPasteButton).click();
    }

    public String searchSuccessNote() {
        return driver.findElement(successNote).getText();
    }
}

