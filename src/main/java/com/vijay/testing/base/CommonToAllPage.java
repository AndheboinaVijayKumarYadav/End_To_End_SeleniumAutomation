package com.vijay.testing.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.vijay.testing.driver.DriverManager.getDriver;

public class CommonToAllPage {

    // Constructor
    public CommonToAllPage(){
        // If you want to call something before every Page Object Class call, Put your Code here
        // Open File, Open Data Base Connection You can write code here
    }


    // clicking the element through By location
    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    // Method overloading
    // clicking the element through WebElement
    public void clickElement(WebElement element){
        element.click();
    }


    public void enterText(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    // Enter text using WebElement
    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Get text using By locator
    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    // Get text using WebElement
    public String getText(WebElement element) {
        return element.getText();
    }

    // Wait for element to be visible using By locator
    public WebElement waitForElement(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Wait for element to be clickable using By locator
    public WebElement waitForElementToBeClickable(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // Check if element is visible using By locator
    public boolean isElementVisible(By by) {
        return getDriver().findElement(by).isDisplayed();
    }

    // Check if element is visible using WebElement
    public boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    // Scroll to element using By locator
    public void scrollToElement(By by) {
        WebElement element = getDriver().findElement(by);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll to element using WebElement
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    // Take screenshot
//    public void takeScreenshot(String screenshotName) {
//        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(srcFile, new File("screenshots/" + screenshotName + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
