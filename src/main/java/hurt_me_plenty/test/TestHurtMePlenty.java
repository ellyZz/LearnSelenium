package hurt_me_plenty.test;


import hurt_me_plenty.pages.CalculatorPage;
import hurt_me_plenty.pages.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class TestHurtMePlenty {
    private WebDriver driver;
    private CalculatorPage calculatorPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability("applicationCacheEnabled", false);
    }

    @Test
    public void checkCorrectFieldsFilling() {
        calculatorPage = new GoogleCloudHomePage(driver).openHomePage()
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(calculatorPage.getValueOfVMMachine().contains("regular"), "value of VM is incorrectly set");
        softAssert.assertTrue(calculatorPage.getValueInstanceType().contains("n1-standard-8"),
                "value of instance type is incorrectly set");
        softAssert.assertTrue(calculatorPage.getValueRegion().contains("Frankfurt"),
                "value of region is incorrectly set");
        assertTrue(calculatorPage.getValueLocalSSD().contains("2x375"),
                "value of local SSD is incorrectly set");
        softAssert.assertTrue(calculatorPage.getCommitmentTerm().contains("1 Year"),
                "value of commitment term is incorrectly set");
        softAssert.assertTrue(calculatorPage.getCost().contains("1,082.77"),
                "cost from estimate is calculate incorrectly");
        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
