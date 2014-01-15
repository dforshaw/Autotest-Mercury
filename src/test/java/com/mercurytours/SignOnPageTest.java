package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class tests the Sign On page
 */

public class SignOnPageTest {

    MercuryAccount mercury_account = new MercuryAccount();
    WebDriver driver;

    @Before
    public void setUp() {
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

        String title = driver.getTitle();
        System.out.println(title);

//        assertEquals("Welcome: Mercury Tours", driver.getTitle());
        Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
    }

    @Test
    public void FailedSignOnToMercuryTours() {
        SignOnPage signOn = new SignOnPage(driver);
        signOn.typeUsername("user");
        signOn.typePassword("password");
        signOn.submitSignOnExpectingFailure();

        String title = driver.getTitle();
        System.out.println(title);

        Assert.assertEquals("Sign-on: Mercury Tours", driver.getTitle());
    }

}
