package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.CreatedPage;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.RegisterPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.vijay.testing.driver.DriverManager.getDriver;
import static com.vijay.testing.utils.GenerateEmail.generateUniqueEmail;

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

//       DriverManager.getDriver().get(PropertiesReader.readKey("url"));
//       logger.info("Navigated to URL");
//
//       LandingPage landingPage = new LandingPage();
//       landingPage.goToAccountMenu();
//       RegisterPage registerPage = landingPage.clickRegisterMenu();
        logger.info("Navigating to Register Page");
        RegisterPage registerPage = navigateToRegisterPage();
       logger.info("Navigated to Register Page");


       // email should be unique so created below string and passed as parameter
       String email = generateUniqueEmail();

       CreatedPage createdPage = registerPage.registerAccount(PropertiesReader.readKey("firstname"),
               PropertiesReader.readKey("lastname"),
               email,
               PropertiesReader.readKey("telephone"),
               PropertiesReader.readKey("password"),
               PropertiesReader.readKey("confirm_password") );


        Assert.assertTrue(createdPage.isElementVisible(),"\n Value do not match\n");
        logger.info("Registration successful and confirmation page displayed");

    }

    @Description("Test Case 2: Verification of fill form without mandatory properties")
    @Test(dataProvider = "formCombinations")
    public void testFormFillingInvalidCombinations(String firstName, String lastName, String email, String phone, String password, String[] expectedErrors){
        logger.info("Starting test: Register Account With InValid Credentials");

//        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
//        logger.info("Navigated to URL");
//
//        LandingPage landingPage = new LandingPage();
//        landingPage.goToAccountMenu();
//        RegisterPage registerPage = landingPage.clickRegisterMenu();

        RegisterPage registerPage = navigateToRegisterPage();
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

    @Description("Test Case 3: Check Registration Behavior for Mismatched Password Fields")
    @Test
    public void testRegistrationWithMismatchedPasswordFields(){

        logger.info("Starting test: Register Account With Mismatched Password Fields");

//        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
//        logger.info("Navigated to URL");
//
//        LandingPage landingPage = new LandingPage();
//        landingPage.goToAccountMenu();
//        RegisterPage registerPage = landingPage.clickRegisterMenu();
        RegisterPage registerPage = navigateToRegisterPage();
        logger.info("Navigated to Register Page");


        // email should be unique so created below string and passed as parameter
        String email = generateUniqueEmail();

        CreatedPage createdPage = registerPage.registerAccount(PropertiesReader.readKey("firstname"),
                PropertiesReader.readKey("lastname"),
                email,
                PropertiesReader.readKey("telephone"),
                PropertiesReader.readKey("passwordForMismatch"),
                PropertiesReader.readKey("confirm_passwordMismatch") );


        String expectedText = "Password confirmation does not match password!";
        String actualText = registerPage.passwordErrorText();
        logger.info("Registration Not successful");

    }

    @Description("Test Case 4: Validate Warning message for Duplicate Account Registraction")
    @Test
    public void testDuplicateAccountRegistration(){

        RegisterPage registerPage = navigateToRegisterPage();
        registerPage.fillForm("vijay","ajay","Vijayadav1245656@gmail.com","123456","123456","123456");
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();

        String expectedText = "Warning: E-Mail Address is already registered!";
        String actualText = registerPage.warningFieldText();

        Assert.assertEquals(actualText,expectedText,"Value do not match");

    }

    @Description("Test Case 5: Validate Warning message popup for Invalid email input")
    @Test
    public void testInvalidEmailInput(){

        RegisterPage registerPage = navigateToRegisterPage();
        registerPage.fillForm("vijay","ajay","Vijayadav1245656","123456","123456","123456");
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();

        registerPage.takeScreenshot("emailActualScreenshot");
    }

    @Description("Test Case 6: Verify Registering account with Keyboard keys")
    @Test
    public void testRegisteringWithKeyboardKeys(){

        RegisterPage registerPage = navigateToRegisterPage();
        registerPage.keyboardActions();


//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        Assert.assertTrue(registerPage.isElementVisible(By.xpath("//div[@id='content']/h1")));

    }

    @Description("Test Case 7: Verify that Placeholders Field Text in Register Page")
    @Test
    public void testVerifyPlaceHoldersText(){
        RegisterPage registerPage = navigateToRegisterPage();

        String expectedFirstNamePlaceHolderText ="First Name";
        Assert.assertEquals(getDriver().findElement(By.id("input-firstname")).getAttribute("placeholder"),expectedFirstNamePlaceHolderText);


    }

    @Description("Test Case 8: Verify Mandatory Symbol and Color")
    @Test
    public void verifyMandatorySymbolAndColor(){
        RegisterPage registerPage = navigateToRegisterPage();

        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        //        System.out.println(fnContent);
        String expectedContent = "\"* \"";
        String expectedColor = "rgb(255, 0, 0)";

        WebElement firstNameLabel = getDriver().findElement(By.cssSelector("label[for='input-firstname']"));
        String fnContent = (String) js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')",firstNameLabel);
        String fnColor = (String) js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')",firstNameLabel);

        Assert.assertEquals(fnContent,expectedContent,"Expected label content is not matched with Actual one");
        Assert.assertEquals(fnColor,expectedColor,"Expected color is not matched with Actual one");
    }



}
