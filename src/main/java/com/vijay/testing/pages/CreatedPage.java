package com.vijay.testing.pages;


import com.vijay.testing.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CreatedPage extends LandingPage {

    private By h1 = By.xpath("//h1[contains(text(),'Created')]");

    public boolean isElementVisible() {
        try {
            return DriverManager.getDriver().findElement(h1).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;  // Element is not present, return false instead of failing
        }

    }
}
