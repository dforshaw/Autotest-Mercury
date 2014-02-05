package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.openqa.selenium.WebDriver;

/**
 * This is the base page object
 */

public class BasePageObject {
    protected final WebDriver driver;
    MercuryAccount mercury_account = new MercuryAccount();
    String BaseUrl = mercury_account.mercury_url;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(BaseUrl);
    }
}
