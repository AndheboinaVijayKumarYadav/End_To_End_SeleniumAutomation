package com.vijay.testing.driver;

import com.beust.jcommander.Parameter;
import com.vijay.testing.utils.PropertiesReader;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

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
    @Parameters({"browser", "platform"})
    public static void init(String browser, String platform) throws MalformedURLException {
//        this below lines for for reading the property value from data.properties file using PropertiesReader class
//        String browser = null;
//        browser = PropertiesReader.readKey("browser").toLowerCase();

        // selenium grid config
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridUrl;

        if(driver == null){
            switch (browser.toLowerCase()){

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless");
                    capabilities.setBrowserName("edge");
                    capabilities.setCapability(EdgeOptions.CAPABILITY,edgeOptions);

//                    edgeOptions.addArguments("--start-maximized");
//                    edgeOptions.addArguments("--headless=new");
//                    edgeOptions.addArguments("--guest");
//                    driver = new EdgeDriver(edgeOptions);
//                    logger.info("Edge browser initialized.");
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    capabilities.setBrowserName("chrome");
                    capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
//                    chromeOptions.addArguments("--start-maximized");
//                    chromeOptions.addArguments("--headless=new");
//                    driver = new ChromeDriver(chromeOptions);
//                    logger.info("Chrome browser initialized.");
                    break;
                case "firefox":
                    // selenium grid
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    capabilities.setBrowserName("firefox");
                    capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,firefoxOptions);
//                   firefoxOptions.addArguments("--start-maximized");
//                   firefoxOptions.addArguments("--headless=new");
//                   driver = new FirefoxDriver(firefoxOptions);
//                   logger.info("Firefox browser initialized.");
                    break;
                default:
                    logger.error("No valid browser found! Check the properties file.");
            }

            // platform config
            if(platform.equalsIgnoreCase("mac")){
                capabilities.setPlatform(Platform.MAC);
            }
            else if(platform.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WINDOWS);
            }
            else {
                throw new IllegalArgumentException("Unsupported platform" + platform);
            }


            gridUrl = "http://192.168.1.37:4444";
            driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
            driver.manage().window().maximize();

        }

    }

    public static void down(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
