package i_can_win_and_bring_it_on.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class MainPage {

    @FindBy(id = "postform-text")
    private WebElement pasteField;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxField;

    @FindBy(className = "select2-search__field")
    private WebElement syntaxPushing;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationPushing;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationSelection;

    @FindBy(id = "postform-name")
    private WebElement pasteNameFieldPushing;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement newPasteButton;

    @FindBy(xpath = "//div[@class='info-top']/child::h1")
    private WebElement textFromNameMath;

    @FindBy(xpath = "//div[@class='left']/child::a")
    private WebElement textFromSyntaxButton;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement textFromDataField;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void writeTextInToNewPasteField(String textForNewPaste) {
        pasteField.sendKeys(textForNewPaste);
    }

    public void selectSyntaxHighlighting(String syntax) {
        syntaxField.click();
        syntaxPushing.sendKeys(syntax);
        syntaxPushing.sendKeys(Keys.ENTER);
    }

    public void selectPasteExpiration() {
        pasteExpirationPushing.click();
        pasteExpirationSelection.click();
    }

    public void writeTextInToPasteNameField(String textForPasteName) {
        pasteNameFieldPushing.sendKeys(textForPasteName);
    }

    public void pressCreateNewPasteButton() {
        newPasteButton.click();
    }

    public void checkPasteNameMath(String textForPasteName) {
        String isExist = textFromNameMath.getText();
        assertEquals(isExist, textForPasteName);
    }

    public void checkTextOnSyntaxButton(String syntax) {
        String isExist = textFromSyntaxButton.getText();
        assertEquals(isExist, syntax);
    }

    public void checkTextInRawPasteDataField(String textInPasteData) {
        String isExist = textFromDataField.getText();
        assertEquals(isExist, textInPasteData);
    }
}