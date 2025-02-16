package com.vijay.testing.pages;

import com.vijay.testing.base.CommonToAllPage;
import org.openqa.selenium.By;

public class RegisterPage extends LandingPage {

    // page locators
    private By inputFirstNameField = By.id("input-firstname");
    private By inputLastNameField = By.id("input-lastname");
    private By inputEmailField = By.id("input-email");
    private By inputTelephoneField = By.id("input-telephone");
    private By inputPasswordField = By.id("input-password");
    private By inputConfirmPasswordField = By.id("input-confirm");
    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");


    public CreatedPage registerAccount(String firstName,String lastName,String email,String telephone,String password,String confirmPassword){
        enterText(inputFirstNameField, firstName);
        enterText(inputLastNameField, lastName);
        enterText(inputEmailField, email);
        enterText(inputTelephoneField, telephone);
        enterText(inputPasswordField, password);
        enterText(inputConfirmPasswordField, confirmPassword);

        // click on agree
        scrollToElement(agreeCheckbox);
        clickElement(agreeCheckbox);

        // click on continue button
        clickElement(continueButton);

        return new CreatedPage();
    }




}
