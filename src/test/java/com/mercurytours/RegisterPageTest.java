package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class tests the Sign On page
 */

public class RegisterPageTest {

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
    public void LoadRegistrationPage() {
        RegisterPage registration = new RegisterPage(driver);

        String pageTitle = driver.getTitle();
        assertThat(pageTitle, is("Register: Mercury Tours"));
    }

    @Test
    public void EnterRegistrationInfo() {
        RegisterPage registration = new RegisterPage(driver);

        registration.typeContactInformation("Joe", "Smith", "510-555-1212", "joe.smith@yahoo.com");

    }
}
