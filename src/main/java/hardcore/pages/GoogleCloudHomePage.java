package hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {
    private static final String PAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_ENQUIRY = "Google Cloud Platform Pricing Calculator";

    @FindBy(className = "devsite-searchbox")
    WebElement searchButton;

    @FindBy(name = "q")
    WebElement searchLineInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage openHomePage() {
        driver.get(PAGE_URL);
        return this;
    }

    public GoogleCloudHomePage startSearch() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public SearchResultPage inputSearchEnquiry() {
        searchLineInput.sendKeys(SEARCH_ENQUIRY + '\n');
        return new SearchResultPage(driver);
    }
}
