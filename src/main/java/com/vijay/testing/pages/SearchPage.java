package com.vijay.testing.pages;

import com.vijay.testing.base.CommonToAllPage;
import com.vijay.testing.utils.DropDownUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends CommonToAllPage {

    // page locators
    private By titleOfProduct = By.xpath("//div[@class='caption']/h4");
    private By descriptionOfProduct = By.xpath("//div[@class='caption']/p");
    private By noProductTextElement = By.xpath("//p[text()='There is no product that matches the search criteria.']");
    private By searchCriteriaField = By.id("input-search");
    private By searchButton = By.id("button-search");
    private By categoryDropDown = By.name("category_id");
    private By subCategoryCheckbox = By.name("sub_category");
    private By addToCartButton = By.xpath("//button[normalize-space()='Add to Cart']");
    private By successMessageAfterAddToCart = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    // page actions
    public String getTitleOfProduct(){
        return find(titleOfProduct).getText();
    }

    public String getDescriptionOfProduct(){
        return find(descriptionOfProduct).getText();
    }

    public String getNoProductFoundMessage(){
        return find(noProductTextElement).getText();
    }

    public void enterTextInSearchCriteria(String text){
        enterText(searchCriteriaField,text);
    }

    public void clickSearchButton(){
        clickElement(searchButton);
    }

    public void selectCategoryByIndex(int index){
        WebElement element = find(categoryDropDown);
        DropDownUtility.selectOptionByIndex(element,index);
    }

    public void clickOnSubCategoryCheckBox(){
        clickElement(subCategoryCheckbox);
    }

    // returning other pages
    public String clickOnAddToCart(){
        scrollToElement(addToCartButton);
        clickElement(addToCartButton);
        return find(successMessageAfterAddToCart).getText();
    }
}
