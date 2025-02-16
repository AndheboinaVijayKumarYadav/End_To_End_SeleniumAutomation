package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.CreatedPage;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.RegisterPage;
import com.vijay.testing.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class RegisterTest extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(RegisterTest.class);

    @Test
    public void testRegisterAccountWithValidCredentials(){

        logger.info("Starting test: Register Account With Valid Credentials");

       DriverManager.getDriver().get(PropertiesReader.readKey("url"));
       logger.info("Navigated to URL");

       LandingPage landingPage = new LandingPage();
       landingPage.goToAccountMenu();
       RegisterPage registerPage = landingPage.clickRegisterMenu();
       logger.info("Navigated to Register Page");



       CreatedPage createdPage = registerPage.registerAccount(PropertiesReader.readKey("firstname"),
               PropertiesReader.readKey("lastname"),
               PropertiesReader.readKey("email"),
               PropertiesReader.readKey("telephone"),
               PropertiesReader.readKey("password"),
               PropertiesReader.readKey("confirm_password") );


        Assert.assertTrue(createdPage.isElementVisible(),"\n Value do not match\n");
        logger.info("Registration successful and confirmation page displayed");
    }


}
