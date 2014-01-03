package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class tests the Sign On page
 */

public class SignOnPageTest {

    private MercuryAccount mercury_account = new MercuryAccount();
    private WebDriver driver = new FirefoxDriver();

    @Test
    public void SignOnToMercuryTours() {

        SignOnPage signOn = new SignOnPage(driver);

        signOn.SignOnAs(mercury_account.userName, mercury_account.password);
        driver.quit();
    }

}
