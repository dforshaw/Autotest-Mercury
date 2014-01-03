package com.mercurytours.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class FieldChecks {

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;  // Success!
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }
}
