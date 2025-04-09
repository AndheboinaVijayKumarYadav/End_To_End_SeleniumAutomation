package com.vijay.testing.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

    // finding the Web element
    public WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    // finding the WebElements
    public List<WebElement> findElements(By locator){
        return getDriver().findElements(locator);
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

    // Take screenshot
    public void takeScreenshot(String screenshotName) {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // using action class to use keyboard keys
    public void keyboardActions(){

        Actions action = new Actions(getDriver());

        for(int i = 1;i<=23;i++){
            action.sendKeys(Keys.TAB).perform();
        }

        action.sendKeys("Arun").pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("Kumar").pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("vijayvj67@gmail.com").pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("123456").pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("123456").pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("123456").pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1))
                .sendKeys(Keys.ENTER).pause(Duration.ofSeconds(3)).build().perform();
    }

}
