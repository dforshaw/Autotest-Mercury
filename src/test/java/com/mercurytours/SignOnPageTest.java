package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class tests the Sign On page
 */

public class SignOnPageTest {

    MercuryAccount mercury_account;
    WebDriver driver;

    @Before
    public void setUp() {
        mercury_account = new MercuryAccount();
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void SignOnToMercuryTours() {
        SignOnPage signOn = new SignOnPage(driver);
        signOn.SignOnAs(mercury_account.userName, mercury_account.password);
     }

}
