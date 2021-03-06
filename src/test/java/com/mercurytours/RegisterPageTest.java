package com.mercurytours;

import com.mercurytours.domain.MercuryAccount;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class tests the Registration page
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

    @Test
    public void VerifyLayoutOfRegistrationPage() {
        RegisterPage registration = new RegisterPage(driver);

        WebElement firstName = driver.findElement(registration.userFirstNameLocator);
        System.out.println(firstName.getSize());
        System.out.println(firstName.getTagName());
        System.out.println(firstName.getLocation());
        System.out.println(firstName.isDisplayed());
    }
}
