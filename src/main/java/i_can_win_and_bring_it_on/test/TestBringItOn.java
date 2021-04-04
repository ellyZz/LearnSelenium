package i_can_win_and_bring_it_on.test;

import i_can_win_and_bring_it_on.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestBringItOn {
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void checkPageTitleAndPasteNameMath() {
        MainPage mainPage = new MainPage(driver);
        String textForPasteField = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String textForPasteName = "how to gain dominance among developers";
        mainPage.writeTextInToNewPasteField(textForPasteField);
        mainPage.selectSyntaxHighlighting("Bash");
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField(textForPasteName);
        mainPage.pressCreateNewPasteButton();
        mainPage.checkPasteNameMath(textForPasteName);
    }

    @Test
    public void checkSyntaxHighlightedForBash() {
        MainPage mainPage = new MainPage(driver);
        String textForPasteField = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String textForPasteName = "how to gain dominance among developers";
        String textForSyntaxHighlighting = "Bash";

        mainPage.writeTextInToNewPasteField(textForPasteField);
        mainPage.selectSyntaxHighlighting(textForSyntaxHighlighting);
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField(textForPasteName);
        mainPage.pressCreateNewPasteButton();
        mainPage.checkTextOnSyntaxButton(textForSyntaxHighlighting);
    }

    @Test
    public void checkRavPasteDataTextMatchNewPasteText() {
        MainPage mainPage = new MainPage(driver);
        String textForPasteField = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String textForPasteName = "how to gain dominance among developers";
        String textForSyntaxHighlighting = "Bash";

        mainPage.writeTextInToNewPasteField(textForPasteField);
        mainPage.selectSyntaxHighlighting(textForSyntaxHighlighting);
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField(textForPasteName);
        mainPage.pressCreateNewPasteButton();
        mainPage.checkTextInRawPasteDataField(textForPasteField);
    }
}