package com.vijay.testing.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.vijay.testing.base.CommonToAllPage;
import org.openqa.selenium.By;


public class LandingPage extends CommonToAllPage {

    private static final Logger logger = LogManager.getLogger(LandingPage.class);

    // Page Locators
    private By accountMenuItem = By.xpath("//span[contains(text(),'My Account')]");
    private By registerMenuItem = By.linkText("Register");
    private By loginMenuItem = By.linkText("Login");
    private By searchInputField = By.xpath("//input[@class='form-control input-lg']");
    private By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

    // Page Actions
    public void goToAccountMenu(){
        scrollToElement(accountMenuItem);
        clickElement(accountMenuItem);
    }

    public RegisterPage clickRegisterMenu(){
        logger.info("Clicking on 'Register' menu item...");
        scrollToElement(registerMenuItem);
        clickElement(registerMenuItem);

        return new RegisterPage();
    }

    public LoginPage clickLoginMenu(){
        logger.info("Clicking on 'Login' menu item...");
        scrollToElement(loginMenuItem);
        clickElement(loginMenuItem);

        return new LoginPage();
    }

    public Boolean isLoginDisplayed(){
        goToAccountMenu();
        waitForElement(loginMenuItem,2);
        return find(loginMenuItem).isDisplayed();
    }

    public SearchPage searching(String title){
        enterText(searchInputField,title);
        clickElement(searchButton);

        return new SearchPage();
    }
}
