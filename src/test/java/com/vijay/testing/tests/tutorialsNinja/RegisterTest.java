package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.CreatedPage;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.RegisterPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegisterTest extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(RegisterTest.class);

    @DataProvider(name = "formCombinations")
    public Object[][] getFromCombinations(){
        return new Object[][]{
                {"", "", "", "", "", new String[]{"First Name must be between 1 and 32 characters!", "Last Name must be between 1 and 32 characters!", "E-Mail Address does not appear to be valid!", "Telephone must be between 3 and 32 characters!", "Password must be between 4 and 20 characters!"}},
                {"John", "", "", "", "", new String[]{"Last Name must be between 1 and 32 characters!", "E-Mail Address does not appear to be valid!", "Telephone must be between 3 and 32 characters!", "Password must be between 4 and 20 characters!"}},
                {"John", "Doe", "", "", "", new String[]{"E-Mail Address does not appear to be valid!", "Telephone must be between 3 and 32 characters!", "Password must be between 4 and 20 characters!"}},
                {"John", "Doe", "john.doe@gmail.com", "", "", new String[]{"Telephone must be between 3 and 32 characters!", "Password must be between 4 and 20 characters!"}},
                {"John", "Doe", "john.doe@gmail.com", "1234567890", "", new String[]{"Password must be between 4 and 20 characters!"}},
                {"John", "Doe", "john.doe@gmail.com", "1234567890", "Password123", new String[]{}},  // No errors expected
        };

    }


    @Description("Test Case 1: Verification of registering the account with valid details")
    @Test
    public void testRegisterAccountWithValidCredentials(){

        logger.info("Starting test: Register Account With Valid Credentials");

       DriverManager.getDriver().get(PropertiesReader.readKey("url"));
       logger.info("Navigated to URL");

       LandingPage landingPage = new LandingPage();
       landingPage.goToAccountMenu();
       RegisterPage registerPage = landingPage.clickRegisterMenu();
       logger.info("Navigated to Register Page");


       // email should be unique so created below string and passed as parameter
       String email = "vijay" + System.currentTimeMillis() + "@gmail.com";

       CreatedPage createdPage = registerPage.registerAccount(PropertiesReader.readKey("firstname"),
               PropertiesReader.readKey("lastname"),
               email,
               PropertiesReader.readKey("telephone"),
               PropertiesReader.readKey("password"),
               PropertiesReader.readKey("confirm_password") );


        Assert.assertTrue(createdPage.isElementVisible(),"\n Value do not match\n");
        logger.info("Registration successful and confirmation page displayed");

    }

    @Description("Test Case 2: Verification of fill form with invalid combinations")
    @Test(dataProvider = "formCombinations")
    public void testFormFillingInvalidCombinations(String firstName, String lastName, String email, String phone, String password, String[] expectedErrors){
        logger.info("Starting test: Register Account With InValid Credentials");

        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
        logger.info("Navigated to URL");

        LandingPage landingPage = new LandingPage();
        landingPage.goToAccountMenu();
        RegisterPage registerPage = landingPage.clickRegisterMenu();
        logger.info("Navigated to Register Page");

        registerPage.clickOnContinue();

        // SoftAssert to capture all errors
        SoftAssert softAssert = new SoftAssert();

        // Verify each expected error
        for (String expectedError : expectedErrors) {
            boolean errorFound = registerPage.getAllErrorMessages().contains(expectedError);
            softAssert.assertTrue(errorFound, "Expected error not found: " + expectedError);
        }


        // Assert all
        softAssert.assertAll();



    }



}
