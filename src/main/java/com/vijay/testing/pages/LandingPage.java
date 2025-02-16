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

}
