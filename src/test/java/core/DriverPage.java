package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverPage {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}