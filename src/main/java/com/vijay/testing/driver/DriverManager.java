package com.vijay.testing.driver;

import com.vijay.testing.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * DriverManager class manages WebDriver instance lifecycle.
 *
 * <p><b>Purpose of Logger:</b></p>
 * - Helps track browser initialization and closure.
 * - Useful for debugging issues in browser setup.
 * - Maintains logs for troubleshooting and monitoring test execution.
 *
 * <p>Logging is essential for debugging and tracking automation test runs.</p>
 */

public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }




    // initialing the browser as per the browser mentioned in the data.properties file
    public static void init(){
        String browser = null;
        browser = PropertiesReader.readKey("browser").toLowerCase();

        if(driver == null){
            switch (browser){

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    logger.info("Edge browser initialized.");
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--headless=new");
                    driver = new ChromeDriver(chromeOptions);
                    logger.info("Chrome browser initialized.");
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--headless=new");
                    driver = new FirefoxDriver(firefoxOptions);
                    logger.info("Firefox browser initialized.");
                    break;
                default:
                    logger.error("No valid browser found! Check the properties file.");
            }

        }

    }

    public static void down(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
