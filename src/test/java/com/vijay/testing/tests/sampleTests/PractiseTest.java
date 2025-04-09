package com.vijay.testing.tests.sampleTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class PractiseTest {
    WebDriver driver;
    String url ="https://tutorialsninja.com/demo";

    @Test
    public void test(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }
}
