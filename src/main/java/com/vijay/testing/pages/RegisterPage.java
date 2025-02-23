package com.vijay.testing.pages;

import com.vijay.testing.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.vijay.testing.driver.DriverManager.driver;

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



    //Page Actions
    // below method returns the CreatedPage all the form details given are valid ones
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

    // general method for filling form details
    public void fillForm(String firstName,String lastName,String email,String telephone,String password, String confirmPassword){

        enterText(inputFirstNameField, firstName);
        enterText(inputLastNameField, lastName);
        enterText(inputEmailField, email);
        enterText(inputTelephoneField, telephone);
        enterText(inputPasswordField, password);
        enterText(inputConfirmPasswordField, confirmPassword);
    }

    // collecting all errormessages
    public List<String> getAllErrorMessages(){
        List<WebElement> errorElements = driver.findElements(By.cssSelector(".text-danger"));
        return errorElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickOnContinue(){
        clickElement(continueButton);
    }


}
