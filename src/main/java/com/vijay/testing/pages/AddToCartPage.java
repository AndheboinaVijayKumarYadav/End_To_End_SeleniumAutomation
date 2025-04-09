package com.vijay.testing.pages;

import com.vijay.testing.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddToCartPage extends CommonToAllPage {
     //page Locators
     private By iMacProductLink = By.linkText("iMac");
     private By tableHederRowsPath = By.xpath("//div[@id='content']/form/div/table/thead/tr/td");
     private By tableRowValuesPath = By.xpath("//div[@id='content']/form/div/table/tbody/tr/td");

     //page Actions
     public Boolean isIMacProductDisplayed(){
          waitForElement(iMacProductLink,1);
         return isElementVisible(iMacProductLink);
     }

     public List<WebElement> getCartTableHeaders(){

          return findElements(tableHederRowsPath);
     }
     public List<WebElement> getCartTableRows(){

          return findElements(tableRowValuesPath);
     }

}
