package com.vijay.testing.pages;

import com.vijay.testing.base.CommonToAllPage;
import com.vijay.testing.model.CartRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

     // getAllCartRows return all the cartRow values
     public List<CartRow> getAllCartRows() {
          List<WebElement> rows = findElements(By.xpath("//div[@id='content']/form/div/table/tbody/tr"));
          List<CartRow> cartRows = new ArrayList<>();

          for (WebElement row : rows) {
               String imageSrc = row.findElement(By.xpath(".//td[1]//img")).getAttribute("src");
               String productName = row.findElement(By.xpath(".//td[2]/a")).getText();
               String model = row.findElement(By.xpath(".//td[3]")).getText();
               String quantity = row.findElement(By.xpath(".//td[4]//input")).getAttribute("value");
               String unitPrice = row.findElement(By.xpath(".//td[5]")).getText();
               String total = row.findElement(By.xpath(".//td[6]")).getText();

               cartRows.add(new CartRow(imageSrc, productName, model, quantity, unitPrice, total));
          }

          return cartRows;
     }


}
