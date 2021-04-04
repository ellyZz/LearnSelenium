package i_can_win_and_bring_it_on.test;

import i_can_win_and_bring_it_on.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestICanWin {
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
    public void createNewPaste() {
        MainPage mainPage = new MainPage(driver);
        mainPage.writeTextInToNewPasteField("Hello world");
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField("Name");
        mainPage.pressCreateNewPasteButton();

    }
}
