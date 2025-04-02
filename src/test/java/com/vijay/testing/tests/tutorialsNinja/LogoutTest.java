package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.LoginPage;
import com.vijay.testing.pages.MyAccountPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends CommonToAllTest {

    @Description("TestCase 1: Verify the logout functionality")
    @Test
    public void testLogoutFunctionality(){

        String email = PropertiesReader.readKey("email");
        String password = PropertiesReader.readKey("new-password");

        LoginPage loginPage = navigateToLoginPage();
        MyAccountPage myAccountPage = loginPage.verifyLoginWithValidCredentials(email,password);
        LandingPage landingPage = myAccountPage.clickLogoutMenu();

        Assert.assertTrue(loginPage.isLoginDisplayed(),"Login option is not displayed in MyAccount section");
    }

}
