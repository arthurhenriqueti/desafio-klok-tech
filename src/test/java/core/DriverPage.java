package core;

import org.openqa.selenium.WebDriver;

public class DriverPage {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "D:\\dev\\DesafioKlokTech\\src\\driver\\geckodriver.exe");
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
