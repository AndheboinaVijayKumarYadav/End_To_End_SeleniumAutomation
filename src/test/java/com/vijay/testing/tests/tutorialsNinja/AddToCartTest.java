package com.vijay.testing.tests.tutorialsNinja;

import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.model.CartRow;
import com.vijay.testing.pages.AddToCartPage;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.SearchPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;



public class AddToCartTest extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(AddToCartTest.class);

     @Description("TestCase 1: Add Existing Product to Cart and verifying the product details")
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

         // here we are storing the table header web elements
         List<WebElement> tableHeaders = addToCartPage.getCartTableHeaders();
         List<String> actualHeaders = new ArrayList<>();

         // here we are adding the text in each header to list of strings
         for(int i = 0; i < tableHeaders.size(); i++) {
             actualHeaders.add(tableHeaders.get(i).getText());

         }

         List<String> expectedHeaders = Arrays.asList("Image", "Product Name", "Model","Quantity","Unit Price","Total");

         assertThat(actualHeaders).isNotNull().isNotEmpty().hasSize(6);
         assertThat(actualHeaders).isEqualTo(expectedHeaders);


         // here we are storing the table row values
         CartRow firstRow = addToCartPage.getAllCartRows().get(0);

         // assertions to check the row values
         assertThat(firstRow.getImageSrc()).isNotEmpty().isEqualTo(PropertiesReader.readKey("iMacSrc"));
         assertThat(firstRow.getProductName()).isNotEmpty().isEqualTo(PropertiesReader.readKey("iMacTitle"));
         assertThat(firstRow.getModel()).isNotEmpty().isEqualTo(PropertiesReader.readKey("iMacProductModel"));
         assertThat(firstRow.getQuantity()).isNotEmpty().isEqualTo(PropertiesReader.readKey("iMacQuantity"));
         assertThat(firstRow.getUnitPrice()).isNotEmpty().isEqualTo(PropertiesReader.readKey("iMacUnitPrice"));
         assertThat(firstRow.getTotal()).isNotEmpty().isEqualTo(PropertiesReader.readKey("iMacTotalPrice"));



     }

}
