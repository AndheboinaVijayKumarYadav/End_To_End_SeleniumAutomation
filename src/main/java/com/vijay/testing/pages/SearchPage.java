package com.vijay.testing.pages;

import com.vijay.testing.base.CommonToAllPage;
import org.openqa.selenium.By;

public class SearchPage extends CommonToAllPage {

    // page locators
    private By titleOfProduct = By.xpath("//div[@class='caption']/h4");
    private By descriptionOfProduct = By.xpath("//div[@class='caption']/p");


    // page actions
    public String getTitleOfProduct(){
        return find(titleOfProduct).getText();
    }

    public String getDescriptionOfProduct(){
        return find(descriptionOfProduct).getText();
    }

}
