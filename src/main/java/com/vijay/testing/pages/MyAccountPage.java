package com.vijay.testing.pages;


import org.openqa.selenium.By;

public class MyAccountPage extends LandingPage {

    // page locations
    private By accoundBreadcrumb = By.xpath("//ul[@class='breadcrumb']//a[text()='Account']");
    private By logoutField = By.xpath("//aside[@id='column-right']//a[text()='Logout']");

    // page actions
    public Boolean isAccountBreadcrumbDisplayed(){
        waitForElement(accoundBreadcrumb,2);
        return isElementVisible(accoundBreadcrumb);
    }

    public Boolean isLogoutDisplayed(){
        return isElementVisible(logoutField);
    }
}
