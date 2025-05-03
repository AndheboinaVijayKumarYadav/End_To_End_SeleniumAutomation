package com.vijay.testing.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends LandingPage {

    // Page Locators
    private By inputEmailField = By.xpath("//input[@Id='input-email']");
    private By passwordField = By.xpath("//input[@Id='input-password']");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    private By forgotPasswordField = By.linkText("Forgotten Password");

    // Page Actions
    public void clickLoginButton(){
        clickElement(loginButton);
    }

    // method login with valid credentials and navigates to My account page
    public MyAccountPage verifyLoginWithValidCredentials(String email,String password){

        // below code will clear if input fields are not empty
        find(inputEmailField).clear();
        find(passwordField).clear();

        enterText(inputEmailField,email);
        enterText(passwordField,password);
        clickLoginButton();
        return new MyAccountPage();
    }

    // method login with invalid credentials
    public void verifyLoginWithInvalidCredentials(String email,String password){
        enterText(inputEmailField,email);
        enterText(passwordField,password);
        clickLoginButton();
        waitForElement(warningMessage,2);

    }

    public Boolean isWarningMessageDisplayed(){

        return isElementVisible(warningMessage);
    }

    public String warningText(){
        return find(warningMessage).getText();
    }

    public void verifyLoginWithInvalidCredentials4times(String email,String password){

        enterText(inputEmailField,email);
        enterText(passwordField,password);

        for (int i = 0; i < 4; i++) {
            clickLoginButton();
        }
        waitForElement(warningMessage,2);
    }

    public void clickOnForgotPassword(){
        clickElement(forgotPasswordField);
    }

}
