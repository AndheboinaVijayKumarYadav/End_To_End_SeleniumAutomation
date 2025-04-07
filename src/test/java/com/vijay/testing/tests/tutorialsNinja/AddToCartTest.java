package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.SearchPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AddToCartTest extends CommonToAllTest {

     @Description("TestCase 1: Add Existing Product to Cart")
     @Test
     public void verifyAddToCart() throws InterruptedException {

         String productTitle = PropertiesReader.readKey("title");
         DriverManager.getDriver().get(PropertiesReader.readKey("url"));
         LandingPage landingPage = new LandingPage();
         SearchPage searchPage = landingPage.searching(productTitle);

         String expectedSuccessMessage = searchPage.clickOnAddToCart();
         System.out.println(expectedSuccessMessage);



     }

}
