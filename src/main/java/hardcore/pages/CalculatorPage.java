package hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CalculatorPage extends AbstractPage {
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input_65")
    WebElement numberOfInstancesInput;

    @FindBy(id = "select_value_label_58")
    WebElement operatingSystemDropDownList;

    @FindBy(xpath = "//md-option[@value='free']/div[@class='md-text']")
    WebElement valueOfOperatingSystemButton;

    @FindBy(id = "select_82")
    WebElement machineClassDropDownList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='Regular']")
    WebElement valueMachineClassButton;

    @FindBy(id = "select_value_label_62")
    WebElement machineTypeDropDownList;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    WebElement valueOfMachineTypeButton;

    @FindBy(id = "select_value_label_61")
    WebElement machineSeriesDropDownList;

    @FindBy(xpath = "//md-option[@value='n1']")
    WebElement valueOfMachineSeriesButton;

    @FindBy(xpath = "//md-input-container//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGpuCheckBox;

    @FindBy(id = "select_value_label_397")
    WebElement numberOfGpuDropDownList;

    @FindBy(id = "select_option_404")
    WebElement valueOfNumberOfGpuButton;

    @FindBy(id = "select_value_label_398")
    WebElement gpuTypeDropDownList;

    @FindBy(id = "select_option_411")
    WebElement valueOfGPUTypeButton;

    @FindBy(id = "select_value_label_359")
    WebElement localSsdDropDownList;

    @FindBy(xpath = "//md-option[@id='select_option_386']")
    WebElement valueOfLocalSsdButton;

    @FindBy(id = "select_value_label_63")
    WebElement datacenterLocationDropDownList;

    @FindBy(xpath = "//md-option[@id='select_option_207']")
    WebElement valueOfDatacenterLocationButton;

    @FindBy(id = "select_value_label_64")
    WebElement commitedUsageDropDownList;

    @FindBy(id = "select_option_99")
    WebElement valueOfCommitedUsageButton;

    @FindBy(xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")
    WebElement addToEstimateButton;

    @FindBy(xpath = "(//button[@id='email_quote'])")
    WebElement emailButton;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    WebElement costFromEstimate;

    @FindBy(id = "input_482")
    WebElement emailInput;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    WebElement sendEmailButton;

    private static final By VALUE_OF_VM_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'regular')]");
    private static final By VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Instance type:')]");
    private static final By VALUE_OF_REGION_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Region:')]");
    private static final By VALUE_OF_LOCAL_SSD_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Total available')]");
    private static final By VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Commitment')]");
    private static final By COST_FROM_ESTIMATE = By.xpath("//h2[@class='md-title']/b[@class='ng-binding']");
    private static final By FRAME = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private static final By COMPUTER_ENGINE_BUTTON = By.xpath("//md-tab-item/*[@title='Compute Engine']");

    public CalculatorPage switchToComputerEngine() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(FRAME));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(COMPUTER_ENGINE_BUTTON));
        driver.findElement(COMPUTER_ENGINE_BUTTON).click();
        return this;
    }

    public CalculatorPage setNumberOfInstances() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(COMPUTER_ENGINE_BUTTON));
        numberOfInstancesInput.sendKeys("4");
        return this;
    }

    public CalculatorPage setOperatingSystem() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(operatingSystemDropDownList));
        executor.executeScript("arguments[0].click()", operatingSystemDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfOperatingSystemButton));
        executor.executeScript("arguments[0].click()", valueOfOperatingSystemButton);
        return this;
    }

    public CalculatorPage setMachineClass() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(machineClassDropDownList));
        executor.executeScript("arguments[0].click()", machineClassDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueMachineClassButton));
        executor.executeScript("arguments[0].click()", valueMachineClassButton);
        return this;
    }

    public CalculatorPage setMachineSeries() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(machineSeriesDropDownList));
        executor.executeScript("arguments[0].click()", machineSeriesDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfMachineSeriesButton));
        executor.executeScript("arguments[0].click()", valueOfMachineSeriesButton);
        return this;
    }

    public CalculatorPage setMachineType() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(machineTypeDropDownList));
        executor.executeScript("arguments[0].click()", machineTypeDropDownList);
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(valueOfMachineTypeButton));
        executor.executeScript("arguments[0].click()", valueOfMachineTypeButton);
        return this;
    }

    public CalculatorPage switchOnAddGpu() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addGpuCheckBox));
        executor.executeScript("arguments[0].click()", addGpuCheckBox);
        return this;
    }

    public CalculatorPage setNumberOfGpu() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(numberOfGpuDropDownList));
        executor.executeScript("arguments[0].click()", numberOfGpuDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfNumberOfGpuButton));
        executor.executeScript("arguments[0].click()", valueOfNumberOfGpuButton);
        return this;
    }

    public CalculatorPage setGPUType() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(gpuTypeDropDownList));
        executor.executeScript("arguments[0].click()", gpuTypeDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfGPUTypeButton));
        executor.executeScript("arguments[0].click()", valueOfGPUTypeButton);
        return this;
    }

    public CalculatorPage setLocalSSD() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(localSsdDropDownList));
        executor.executeScript("arguments[0].click()", localSsdDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfLocalSsdButton));
        executor.executeScript("arguments[0].click()", valueOfLocalSsdButton);
        return this;
    }

    public CalculatorPage setDatacenterLocation() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(datacenterLocationDropDownList));
        executor.executeScript("arguments[0].click()", datacenterLocationDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfDatacenterLocationButton));
        executor.executeScript("arguments[0].click()", valueOfDatacenterLocationButton);
        return this;
    }

    public CalculatorPage setCommitedUsage() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(commitedUsageDropDownList));
        executor.executeScript("arguments[0].click()", commitedUsageDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfDatacenterLocationButton));
        executor.executeScript("arguments[0].click()", valueOfCommitedUsageButton);
        return this;
    }

    public CalculatorPage clickAddToEstimate() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        addToEstimateButton.click();
        return this;
    }

    public void switchToEmailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(" https://10minutemail.com");
    }

    public CalculatorPage clickEmailEstimate() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(emailButton));
        executor.executeScript("arguments[0].click()", emailButton);
        return this;
    }

    public CalculatorPage inputEmail() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required ng-valid-email']")));
        emailInput.sendKeys(Keys.LEFT_CONTROL, "v");
        return this;
    }

    public CalculatorPage sendEmail() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Send Email']")));
        executor.executeScript("arguments[0].click()", sendEmailButton);
        return this;
    }

    public String getCost() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//h2[@class='md-title']/b[@class='ng-binding']")));
        return costFromEstimate.getText();
    }

}
