package com.vijay.testing.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class MyAccountPage extends LandingPage {
    private static final Logger logger = LogManager.getLogger(LandingPage.class);

    // page locations
    private By accoundBreadcrumb = By.xpath("//ul[@class='breadcrumb']//a[text()='Account']");
    private By logoutField = By.xpath("//aside[@id='column-right']//a[text()='Logout']");
    private By passwordField = By.xpath("//a[text()='Password']");
    private By successTextField = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private By accountMenuItem = By.xpath("//span[contains(text(),'My Account')]");
    private By loginMenuItem = By.linkText("Login");


    // page actions
    public Boolean isAccountBreadcrumbDisplayed(){
        waitForElement(accoundBreadcrumb,2);
        return isElementVisible(accoundBreadcrumb);
    }

    public Boolean isLogoutDisplayed(){
        waitForElement(logoutField,2);
        return isElementVisible(logoutField);
    }

    public PasswordPage clickOnPasswordField(){
        waitForElement(passwordField,2);
        clickElement(passwordField);

        return new PasswordPage();
    }

    public String successText(){
        waitForElement(successTextField,2);
        return find(successTextField).getText();
    }

    public void clickOnLogout(){
        clickElement(logoutField);
    }

    public LoginPage clickLoginMenu(){
        logger.info("Clicking on 'Login' menu item...");
        scrollToElement(loginMenuItem);
        clickElement(loginMenuItem);

        return new LoginPage();
    }
}
