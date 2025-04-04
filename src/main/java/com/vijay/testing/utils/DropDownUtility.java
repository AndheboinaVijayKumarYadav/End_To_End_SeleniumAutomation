package com.vijay.testing.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {

    public static void selectOptionByIndex(WebElement element, int indexNumber) {
            Select select = new Select(element);
            select.selectByIndex(indexNumber);
    }
}
