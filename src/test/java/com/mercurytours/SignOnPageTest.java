package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

        String pageTitle = driver.getTitle();

        assertThat(pageTitle, is("Welcome: Mercury Tours"));
    }

    @Test
    public void FailedSignOnToMercuryTours() {
        SignOnPage signOn = new SignOnPage(driver);
        signOn.typeUsername("user");
        signOn.typePassword("password");
        signOn.submitSignOnExpectingFailure();

        String pageTitle = driver.getTitle();

        assertEquals(pageTitle, "Sign-on: Mercury Tours");
        assertThat(pageTitle, is(not("Welcome: Mercury Tours")));
    }

}
