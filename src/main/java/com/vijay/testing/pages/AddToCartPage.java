package com.vijay.testing.pages;

import com.vijay.testing.base.CommonToAllPage;
import org.openqa.selenium.By;

public class AddToCartPage extends CommonToAllPage {
     //page Locators
     private By iMacProductLink = By.linkText("iMac");

     //page Actions
     public Boolean isIMacProductDisplayed(){
          waitForElement(iMacProductLink,1);
         return isElementVisible(iMacProductLink);
     }

}
