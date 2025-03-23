package com.vijay.testing.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends LandingPage {

    // Page Locators
    private By inputEmailField = By.xpath("//input[@Id='input-email']");
    private By passwordField = By.xpath("//input[@Id='input-password']");
    private By loginButton = By.xpath("//input[@type='submit']");

    // Page Actions
    public MyAccountPage verifyLoginWithValidCredentials(String email,String password){

        enterText(inputEmailField,email);
        enterText(passwordField,password);
        clickLoginButton();
        return new MyAccountPage();
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }



}
