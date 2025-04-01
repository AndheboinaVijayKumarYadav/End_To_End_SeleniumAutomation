package com.vijay.testing.pages;

import org.openqa.selenium.By;

public class PasswordPage extends LandingPage{

    // page locators
    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By continueButton = By.xpath("//input[@value='Continue']");

    // page actions
    public MyAccountPage changePassword(String newPassword){

        enterText(passwordField,newPassword);
        enterText(confirmPasswordField,newPassword);
        clickOnContinue();

        return new MyAccountPage();
    }

    public void clickOnContinue(){
        clickElement(continueButton);
    }

}
