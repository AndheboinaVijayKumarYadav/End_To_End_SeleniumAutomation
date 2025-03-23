package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.LoginPage;
import com.vijay.testing.pages.MyAccountPage;
import com.vijay.testing.pages.RegisterPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonToAllTest {



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


}
