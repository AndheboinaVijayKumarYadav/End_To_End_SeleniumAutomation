package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.AddToCartPage;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.SearchPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(AddToCartTest.class);

     @Description("TestCase 1: Add Existing Product to Cart")
     @Test
     public void testAddExistingProductToCart() {
         logger.info("Starting the Add to Cart TestCase1");
         String productTitle = PropertiesReader.readKey("title");
         DriverManager.getDriver().get(PropertiesReader.readKey("url"));
         LandingPage landingPage = new LandingPage();
         SearchPage searchPage = landingPage.searching(productTitle);
         logger.info("Navigated to Search page ");
         String expectedSuccessMessage = searchPage.clickOnAddToCart();
         logger.info("Item added to cart");

         Assert.assertTrue(expectedSuccessMessage.contains("Success"),"Add to Cart Success message not displayed");
         logger.info("Success message verified");

         AddToCartPage addToCartPage = searchPage.clickOnShoppingCartLink();
         logger.info("Navigated to Add to cart page");
         Assert.assertTrue(addToCartPage.isIMacProductDisplayed(),"iMac product is not displayed");
         logger.info("iMac product is displayed");
     }

}
