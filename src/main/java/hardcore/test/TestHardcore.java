package hardcore.test;


import hardcore.pages.EmailGeneratorPage;
import hardcore.pages.CalculatorPage;
import hardcore.pages.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestHardcore {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability("applicationCacheEnabled", false);
    }

    @Test(priority = 1)
    public void checkMail() {
        EmailGeneratorPage pageForGenerateEmail = new EmailGeneratorPage(driver);
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        CalculatorPage calculatorPage = googleCloudHomePage.openHomePage()
                .startSearch()
                .inputSearchEnquiry()
                .pickRightResult()
                .switchToComputerEngine()
                .setNumberOfInstances()
                .setOperatingSystem()
                .setMachineClass()
                .setMachineSeries()
                .setMachineType()
                .switchOnAddGpu()
                .setNumberOfGpu()
                .setGPUType()
                .setLocalSSD()
                .setDatacenterLocation()
                .setCommitedUsage()
                .clickAddToEstimate();
        String costEstimate = calculatorPage.getCost();
        calculatorPage.switchToEmailPage();
        new EmailGeneratorPage(driver).copyEmail().switchToCalculator();
        calculatorPage.clickEmailEstimate().inputEmail().sendEmail().switchToEmailPage();
        new EmailGeneratorPage(driver).openMail();
        Assert.assertTrue(costEstimate.contains(pageForGenerateEmail.getCostFromEmail()));

    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
