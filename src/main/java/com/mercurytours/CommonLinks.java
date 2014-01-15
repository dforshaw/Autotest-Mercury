package com.mercurytours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

// In Progress: goal is to create a page object for sidebar and navigation links
public class CommonLinks extends Page {

    String underConsTitle = "Under Construction: Mercury Tours";

    public CommonLinks(WebDriver driver) {
        super(driver);
//        driver.get(BaseUrl);

        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;

// extract the link texts of each link element
        for (WebElement e : linkElements) {

            linkTexts[i] = e.getText();
            i++;
        }
    }
}
