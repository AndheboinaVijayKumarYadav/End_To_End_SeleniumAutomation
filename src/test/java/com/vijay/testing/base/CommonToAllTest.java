package com.vijay.testing.base;

import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.LoginPage;
import com.vijay.testing.pages.RegisterPage;
import com.vijay.testing.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(CommonToAllTest.class);

    @BeforeMethod
    public void setUp() {
        try {
            logger.info("Initializing WebDriver...");
            DriverManager.init();
            logger.info("WebDriver initialized successfully.");
        } catch (Exception e) {
            logger.error("Error initializing WebDriver: " + e.getMessage(), e);
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            logger.info("Closing WebDriver...");
            DriverManager.down();
            logger.info("WebDriver closed successfully.");
        } catch (Exception e) {
            logger.error("Error closing WebDriver: " + e.getMessage(), e);
        }
    }

    protected RegisterPage navigateToRegisterPage() {
        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
        LandingPage landingPage = new LandingPage();
        landingPage.goToAccountMenu();
        return landingPage.clickRegisterMenu();
    }

    protected RegisterPage navigateToRegisterPageLocalHosted(){
        DriverManager.getDriver().get(PropertiesReader.readKey("url_localhost"));
        LandingPage landingPage = new LandingPage();
        landingPage.goToAccountMenu();
        return landingPage.clickRegisterMenu();
    }

    protected LoginPage navigateToLoginPage(){
        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
        LandingPage landingPage = new LandingPage();
        landingPage.goToAccountMenu();
        return landingPage.clickLoginMenu();
    }
}
