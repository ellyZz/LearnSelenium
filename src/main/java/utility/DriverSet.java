package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSet {
    private static WebDriver driver;
    private DriverSet(){
    }
    public static WebDriver getDriver(){
        if(driver==null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
