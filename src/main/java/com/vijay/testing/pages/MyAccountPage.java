package com.vijay.testing.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class MyAccountPage extends LandingPage {
    private static final Logger logger = LogManager.getLogger(MyAccountPage.class);

    // page locations
    private By accoundBreadcrumb = By.xpath("//ul[@class='breadcrumb']//a[text()='Account']");
    private By logoutField = By.xpath("//aside[@id='column-right']//a[text()='Logout']");
    private By passwordField = By.xpath("//a[text()='Password']");
    private By successTextField = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private By accountMenuItem = By.xpath("//span[contains(text(),'My Account')]");
    private By loginMenuItem = By.linkText("Login");
    private By logoutMenuItem = By.linkText("Logout");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By continueButtonAfterLogout = By.xpath("//a[text()='Continue']");
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

    public LandingPage clickLogoutMenu(){

        clickElement(accountMenuItem);
        scrollToElement(logoutField);
        clickElement(logoutField);
        waitForElement(continueButtonAfterLogout,2);
        clickElement(continueButtonAfterLogout);

        return new LandingPage();
    }
}
