package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.pages.*;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    // here we can add parallel = true in parameter list to run parallel
    @DataProvider(name="invalidLoginCredentials")
    public Object[][] getLoginCredentials(){

        return new Object[][] {
                {"",""},
                {"@gmail.com","12345"},
                {"","12345"}
        };
    }



    @Description("TestCase 1: Verify login with Valid Credentials")
    @Test
    public void testVerifyLoginWithValidCredentials(){

        String email = PropertiesReader.readKey("email");
        String password = PropertiesReader.readKey("password");

        Assert.assertNotNull(email, "Email property is null");
        Assert.assertNotNull(password,"Password is null");

        LoginPage loginPage = navigateToLoginPage();
        MyAccountPage myAccountPage = loginPage.verifyLoginWithValidCredentials(email,password);

        Assert.assertTrue(myAccountPage.isAccountBreadcrumbDisplayed(), "Account Breadcrumb is not displayed after login");
        Assert.assertTrue(myAccountPage.isLogoutDisplayed(), "Logout option is not displayed after login ");

    }

    @Description("TestCase 2: Verify login with Invalid Credentials")
    @Test(dataProvider = "invalidLoginCredentials")
    public void testInvalidLoginCredentials(String email,String password){

        logger.info("Starting Test: login with invalid credentials");

        LoginPage loginPage = navigateToLoginPage();
        loginPage.verifyLoginWithInvalidCredentials(email,password);

        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),"Warning message is not displayed");

        String expectedText = "Warning: No match for E-Mail Address and/or Password.";
        String actualText = loginPage.warningText();

        Assert.assertEquals(actualText,expectedText,"Actual warning message is not matched with expected warning message");



    }

//    @Description("TestCase 3: Verify login with Invalid Credentials for more than 4 time")
//    @Test
//    public void testVerifyLoginWithValidEmailInvalidPasswordMoreThan4Times(){
//
//        logger.info("Starting Test: login with invalid credentials for more than 4 times");
//
//        String email ="Vijayadav12456567687@gmail.com";
//        String password ="";
//
//        LoginPage loginPage = navigateToLoginPage();
//        loginPage.verifyLoginWithInvalidCredentials4times(email,password);
//
//        String expectedWarningMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
//        String actualWarningMessage = loginPage.warningText();
//
//        Assert.assertEquals(actualWarningMessage,expectedWarningMessage,"Actual is not matching with expected");
//
//    }

//    @Description("TestCase 4: Verify login after changing the password")
//    @Test
//    public void testVerifyLoginAfterPasswordChange(){
//
//        logger.info("Started TestCase 4: Verify login after changing the password");
//
//        logger.info("Navigate to login page");
//        LoginPage loginPage = navigateToLoginPage();
//
//        String email = PropertiesReader.readKey("email");
//        String oldPassword = PropertiesReader.readKey("password");
//        String newPassword = PropertiesReader.readKey("new-password");
//
//        MyAccountPage myAccountPage = loginPage.verifyLoginWithValidCredentials(email,oldPassword);
//        logger.info("logged in with valid credentials");
//
//        PasswordPage passwordPage = myAccountPage.clickOnPasswordField();
//        myAccountPage = passwordPage.changePassword(newPassword);
//        String actualSuccessText = myAccountPage.successText();
//        String expectedSuccessText = "Success: Your password has been successfully updated.";
//
//        Assert.assertEquals(actualSuccessText,expectedSuccessText,"Actual success text not matching with expected");
//
//        logger.info("Password successfully updated");
//        myAccountPage.clickOnLogout();
//
//
//        logger.info("logging with old password");
//        loginPage = myAccountPage.clickLoginMenu();
//        loginPage.verifyLoginWithInvalidCredentials(email,oldPassword);
//        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),"Warning message when old password entered is not displayed");
//
//        myAccountPage = loginPage.verifyLoginWithValidCredentials(email, newPassword);
//
//        Assert.assertTrue(myAccountPage.isAccountBreadcrumbDisplayed(), "Account Breadcrumb is not displayed after login");
//        Assert.assertTrue(myAccountPage.isLogoutDisplayed(), "Logout option is not displayed after login ");
//    }

}
