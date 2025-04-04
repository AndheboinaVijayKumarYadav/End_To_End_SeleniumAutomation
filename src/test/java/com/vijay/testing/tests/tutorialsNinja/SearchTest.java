package com.vijay.testing.tests.tutorialsNinja;


import com.vijay.testing.base.CommonToAllTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.LandingPage;
import com.vijay.testing.pages.SearchPage;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends CommonToAllTest {

    @Description("TestCase1: Verify the Search with existing product")
    @Test
    public void testSearchWithExistingProduct(){

        String productTitle = PropertiesReader.readKey("title");
        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
        LandingPage landingPage = new LandingPage();
        SearchPage searchPage = landingPage.searching(productTitle);

        String expectedProductTitle = PropertiesReader.readKey("title");
        String actualProductTitle = searchPage.getTitleOfProduct();
        String expectedDescription = "Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo pro..";
        String actualDescription = searchPage.getDescriptionOfProduct();

        Assert.assertEquals(actualProductTitle,expectedProductTitle,"Product tile do not match");
        Assert.assertEquals(actualDescription,expectedDescription,"Product descriptions do not match");

    }

    @Description("TestCase 2: Verify the Search with non-existing product")
    @Test
    public void testSearchWithNonExistingProduct(){

        String nonExistingProductTitle = PropertiesReader.readKey("non-existing-title");
        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
        LandingPage landingPage = new LandingPage();
        SearchPage searchPage = landingPage.searching(nonExistingProductTitle);

        String expectedDescription = "There is no product that matches the search criteria.";
        String actualDescription = searchPage.getNoProductFoundMessage();

        Assert.assertEquals(actualDescription,expectedDescription,"Actual description is not matching with Expected");

    }

    @Description("TestCase 3: Verify the Search with sub-categories option ")
    @Test
    public void testSearchWithSubCategories(){

        DriverManager.getDriver().get(PropertiesReader.readKey("url"));

        LandingPage landingPage = new LandingPage();
        SearchPage searchPage = landingPage.clickOnSearchIcon();

        searchPage.enterTextInSearchCriteria("iMac");
        searchPage.selectCategoryByIndex(1);
        searchPage.clickSearchButton();

        String expectedMessage = "There is no product that matches the search criteria.";
        String actualMessage = searchPage.getNoProductFoundMessage();

        Assert.assertEquals(actualMessage,expectedMessage,"Actual description is not matching with Expected");

        searchPage.clickOnSubCategoryCheckBox();
        searchPage.clickSearchButton();

        String expectedProductTitle = PropertiesReader.readKey("title");
        String actualProductTitle = searchPage.getTitleOfProduct();
        String expectedDescription = "Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo pro..";
        String actualDescription = searchPage.getDescriptionOfProduct();

        Assert.assertEquals(actualProductTitle,expectedProductTitle,"Product tile do not match");
        Assert.assertEquals(actualDescription,expectedDescription,"Product descriptions do not match");
    }

}
