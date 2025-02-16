package com.vijay.testing.base;

import com.vijay.testing.driver.DriverManager;
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
}
