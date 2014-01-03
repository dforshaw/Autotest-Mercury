package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class tests the Sign On page
 */

public class SignOnPageTest {

    MercuryAccount mercury_account = new MercuryAccount();

    @Test
    public void SignOnToMercuryTours() {
        WebDriver driver = new FirefoxDriver();
        SignOnPage signOn = new SignOnPage(driver);

//        driver.get(mercury_account.mercury_url +"/mercurysignon.php");
        signOn.SignOnAs(mercury_account.userName, mercury_account.password);
        driver.quit();
    }
}
